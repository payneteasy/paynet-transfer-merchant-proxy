package com.payneteasy.merchantproxy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.payneteasy.merchantproxy.dao.TransferDataDao;
import com.payneteasy.merchantproxy.generated.model.ErrorResponse;
import com.payneteasy.merchantproxy.generated.model.ErrorResponseError;
import com.payneteasy.merchantproxy.util.StrUtil;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorHandler {

  private final Logger logger = LoggerFactory.getLogger(GlobalErrorHandler.class);

  private final TransferDataDao transferDataDao;

  @Autowired
  public GlobalErrorHandler(final TransferDataDao transferDataDao) {
    this.transferDataDao = transferDataDao;
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse processValidationErrors(final MethodArgumentNotValidException e) {
    final String methodName = e.getParameter().getMethod().getName();
    final BindingResult bindingResult = e.getBindingResult();
    final String uuid = UUID.randomUUID().toString();
    final ErrorResponseError error = new ErrorResponseError()
        .code(uuid)
        .message(bindingResult.getFieldErrors().toString())
        .cause(ErrorResponseError.CauseEnum.INVALID_REQUEST);

    logger.warn("Parameters validation failed for method '{}',\nerror: code={},\nmessage='{}'", methodName, error.getCode(), error.getMessage());

    return new ErrorResponse().error(error);
  }

  @ExceptionHandler(ApplicationException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorResponse processExceptions(final ApplicationException e) {
    final String uuid = UUID.randomUUID().toString();
    final ErrorResponseError error = new ErrorResponseError()
        .code(uuid)
        .message(e.getCause().getMessage())
        .cause(ErrorResponseError.CauseEnum.SERVER_FAILED);

    logger.error("Error code={},\nmessage='{}'", error.getCode(), error.getMessage());
    logger.error("Exception:", e.getCause());

    final ErrorResponse errorResponse = new ErrorResponse().error(error);

    if (e.getId() != null) {
      switch (e.getRequestType()) {
        case TRANSFER_INITIATE:
          try {
            transferDataDao.setInitiateTransferResponse(e.getId(), StrUtil.OBJECT_MAPPER.writeValueAsString(errorResponse), true);
          } catch (final JsonProcessingException e1) {
            logger.error("Cannot serialize JSON: {}", errorResponse, e1);
          }
          break;
        case TRANSFER_CHECK:
          try {
            transferDataDao.setCheckTransferResponse(e.getId(), StrUtil.OBJECT_MAPPER.writeValueAsString(errorResponse), true);
          } catch (final JsonProcessingException e1) {
            logger.error("Cannot serialize JSON: {}", errorResponse, e1);
          }
          break;
      }
    }

    return errorResponse;
  }
}
