package com.payneteasy.merchantproxy.generated.controller;

import com.payneteasy.merchantproxy.generated.model.CheckTransferRequest;
import com.payneteasy.merchantproxy.generated.model.CheckTransferResponse;
import com.payneteasy.merchantproxy.generated.model.ErrorResponse;
import com.payneteasy.merchantproxy.generated.model.InitiateTransferRequest;
import com.payneteasy.merchantproxy.generated.model.InitiateTransferResponse;
import com.payneteasy.merchantproxy.generated.model.RatesRequest;
import com.payneteasy.merchantproxy.generated.model.RatesResponse;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "transfer", description = "the transfer API")
public interface TransferApi {

    @ApiOperation(value = "Get transfer rates and limits configuration", notes = "", response = RatesResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Rates and limits data", response = RatesResponse.class),
        @ApiResponse(code = 500, message = "Server error", response = ErrorResponse.class) })
    
    @RequestMapping(value = "/transfer/get-rate",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Object> transferGetRatePost(@ApiParam(value = "Session info" ,required=true )  @Valid @RequestBody RatesRequest sessionData);


    @ApiOperation(value = "Initiate transfer request", notes = "", response = InitiateTransferResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Enpoint config, rates, session tokens to perform transfer request", response = InitiateTransferResponse.class),
        @ApiResponse(code = 400, message = "Request data is invalid", response = ErrorResponse.class),
        @ApiResponse(code = 500, message = "Server error", response = ErrorResponse.class) })
    
    @RequestMapping(value = "/transfer/initiate-transfer",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Object> transferInitiateTransferPost(@ApiParam(value = "Device info, location data, session info, amount" ,required=true )  @Valid @RequestBody InitiateTransferRequest initiateTransferData);


    @ApiOperation(value = "Check transfer response", notes = "", response = CheckTransferResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Check signature to verify and other transaction data", response = CheckTransferResponse.class),
        @ApiResponse(code = 400, message = "Request data is invalid", response = ErrorResponse.class),
        @ApiResponse(code = 500, message = "Server error", response = ErrorResponse.class) })
    
    @RequestMapping(value = "/transfer/{invoiceId}/check",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Object> transferInvoiceIdCheckPost(@ApiParam(value = "Previously generated transfer transaction identifier",required=true ) @PathVariable("invoiceId") String invoiceId,@ApiParam(value = "Transaction data to check" ,required=true )  @Valid @RequestBody CheckTransferRequest checkRequestData);

}
