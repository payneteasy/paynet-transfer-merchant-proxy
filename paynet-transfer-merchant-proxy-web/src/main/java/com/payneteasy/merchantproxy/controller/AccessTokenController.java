package com.payneteasy.merchantproxy.controller;

import com.payneteasy.merchantproxy.generated.controller.AuthApi;
import com.payneteasy.merchantproxy.generated.model.AccessTokenResponse;
import com.payneteasy.merchantproxy.generated.model.AccessTokenResponseSession;
import com.payneteasy.merchantproxy.util.StrUtil;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
public class AccessTokenController implements AuthApi {

  public static final int ACCESS_TOKEN_LENGTH = 64;

  @Override
  public ResponseEntity<Object> authRequestAccessTokenGet() {
    final String token = StrUtil.generateRandomString(ACCESS_TOKEN_LENGTH);
    final AccessTokenResponseSession session = new AccessTokenResponseSession().accessToken(token);
    final AccessTokenResponse response = new AccessTokenResponse().session(session);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
