package com.payneteasy.merchantproxy.controller;

import com.payneteasy.merchantproxy.config.MockAppConfig;
import com.payneteasy.merchantproxy.config.WebConfig;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, MockAppConfig.class})
@WebAppConfiguration
public class BaseControllerTest {

  @Resource
  protected WebApplicationContext webApplicationContext;

  protected MockMvc mockMvc;

  @Before
  public void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void test() {
    // Prevent no tests error
  }

}
