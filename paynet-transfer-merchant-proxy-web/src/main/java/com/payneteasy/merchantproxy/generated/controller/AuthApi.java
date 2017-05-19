package com.payneteasy.merchantproxy.generated.controller;

import com.payneteasy.merchantproxy.generated.model.AccessTokenResponse;
import com.payneteasy.merchantproxy.generated.model.ErrorResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "auth", description = "the auth API")
public interface AuthApi {

    @ApiOperation(value = "Generate access token for transfer operation", notes = "", response = AccessTokenResponse.class, tags={  })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Randomly generated access token", response = AccessTokenResponse.class),
        @ApiResponse(code = 500, message = "Server error", response = ErrorResponse.class) })

    @RequestMapping(value = "/auth/request-access-token",
        produces = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<Object> authRequestAccessTokenGet();

}
