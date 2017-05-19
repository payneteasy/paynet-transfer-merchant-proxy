package com.payneteasy.merchantproxy.dao;

import com.payneteasy.merchantproxy.model.TransferData;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;
import org.springframework.stereotype.Service;

@Service
public class TransferDataDaoImpl implements TransferDataDao {

  private final Logger logger = LoggerFactory.getLogger(TransferDataDaoImpl.class);

  private final SimpleJdbcInsertOperations jdbcInsert;
  private final NamedParameterJdbcTemplate jdbcTemplate;

  @Autowired
  public TransferDataDaoImpl(final DataSource dataSource) {
    final JdbcTemplate template = new JdbcTemplate(dataSource);
    this.jdbcTemplate = new NamedParameterJdbcTemplate(template);
    this.jdbcInsert = new SimpleJdbcInsert(template)
        .withTableName("TRANSFERDATA")
        .usingColumns("INVOICE_ID", "INITIATE_DATE", "CHECK_DATE", "INITIATE_TRANSFER_REQUEST", "INITIATE_TRANSFER_RESPONSE",
            "CHECK_TRANSFER_REQUEST", "CHECK_TRANSFER_RESPONSE", "IS_INITIATE_ERROR", "IS_CHECK_ERROR")
        .usingGeneratedKeyColumns("ID");
  }

  @Override
  public long create(final TransferData transferData) {
    final Map<String, Object> params = new HashMap<>();
    params.put("INVOICE_ID", transferData.getInvoiceId());
    params.put("INITIATE_DATE", transferData.getInitiateDate() == null ? null : new Timestamp(transferData.getInitiateDate().getTime()));
    params.put("CHECK_DATE", transferData.getCheckDate() == null ? null : new Timestamp(transferData.getCheckDate().getTime()));
    params.put("INITIATE_TRANSFER_REQUEST", transferData.getInitiateTransferRequest());
    params.put("INITIATE_TRANSFER_RESPONSE", transferData.getInitiateTransferResponse());
    params.put("CHECK_TRANSFER_REQUEST", transferData.getCheckTransferRequest());
    params.put("CHECK_TRANSFER_RESPONSE", transferData.getCheckTransferResponse());
    params.put("IS_INITIATE_ERROR", transferData.isInitiateError());
    params.put("IS_CHECK_ERROR", transferData.isCheckError());

    final long id = jdbcInsert.executeAndReturnKey(params).longValue();

    transferData.setId(id);

    return id;
  }

  @Override
  public void setInitiateTransferResponse(final long id, final String initiateTransferResponse, final boolean isError) {
    final Map<String, Object> params = new HashMap<>();
    params.put("id", id);
    params.put("response", initiateTransferResponse);
    params.put("isError", isError);

    jdbcTemplate.update("UPDATE TRANSFERDATA SET INITIATE_TRANSFER_RESPONSE = :response, IS_INITIATE_ERROR = :isError WHERE ID = :id",
        params);
  }

  @Override
  public void setCheckTransferRequest(final long id, final String checkTransferRequest, final Date date) {
    final Map<String, Object> params = new HashMap<>();
    params.put("id", id);
    params.put("request", checkTransferRequest);
    params.put("checkDate", new Timestamp(date.getTime()));

    jdbcTemplate.update("UPDATE TRANSFERDATA SET CHECK_TRANSFER_REQUEST = :request, CHECK_DATE = :checkDate WHERE ID = :id",
        params);
  }

  @Override
  public void setCheckTransferResponse(final long id, final String checkTransferResponse, final boolean isError) {
    final Map<String, Object> params = new HashMap<>();
    params.put("id", id);
    params.put("response", checkTransferResponse);
    params.put("isError", isError);

    jdbcTemplate.update("UPDATE TRANSFERDATA SET CHECK_TRANSFER_RESPONSE = :response, IS_CHECK_ERROR = :isError WHERE ID = :id",
        params);
  }

  @Override
  public TransferData findById(final long id) {
    try {
      return jdbcTemplate.queryForObject(TransferData.QUERY + " WHERE ID = :id",
          Collections.singletonMap("id", id),
          TransferData.getRowMapper());
    } catch (final EmptyResultDataAccessException e) {
      logger.error("No TransferData found for id={}", id, e);
    }
    return null;
  }

  @Override
  public TransferData findByInvoiceId(final String invoiceId) {
    try {
      return jdbcTemplate.queryForObject(TransferData.QUERY + " WHERE INVOICE_ID = :invoiceId",
          Collections.singletonMap("invoiceId", invoiceId),
          TransferData.getRowMapper());
    } catch (final EmptyResultDataAccessException e) {
      logger.error("No TransferData found for invoiceId='{}'", invoiceId, e);
    }
    return null;
  }
}
