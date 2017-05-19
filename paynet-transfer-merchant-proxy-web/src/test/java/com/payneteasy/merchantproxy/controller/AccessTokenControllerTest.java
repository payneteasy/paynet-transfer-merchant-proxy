package com.payneteasy.merchantproxy.controller;

import java.util.regex.Pattern;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AccessTokenControllerTest extends BaseControllerTest {

  private static final Pattern TOKEN_PATTERN = Pattern.compile("^[0-9A-Za-z^$]{64}$");

  @Test
  public void testGetAccessToken() throws Exception {
    mockMvc.perform(get("/auth/request-access-token"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.session").isMap())
        .andExpect(jsonPath("$.session.accessToken").isString())
        .andExpect(jsonPath("$.session.accessToken").value(ACCESS_TOKEN_MATCHER))
    ;
  }

  private static final Matcher<String> ACCESS_TOKEN_MATCHER = new BaseMatcher<String>() {

    @Override
    public boolean matches(final Object item) {
      return item instanceof CharSequence && TOKEN_PATTERN.matcher((CharSequence) item).matches();
    }

    @Override
    public void describeTo(final Description description) {
      description.appendText(" ^[0-9A-Za-z^$]{64}$ pattern character sequence ");
    }
  };
}
