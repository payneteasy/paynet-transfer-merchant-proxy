package com.payneteasy.merchantproxy.config;

import com.payneteasy.merchantproxy.dao.TransferDataDao;
import com.payneteasy.merchantproxy.service.TransactionService;

import org.easymock.EasyMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class MockAppConfig {

  @Bean
  public TransactionService transactionService() {
    return EasyMock.createStrictMock(TransactionService.class);
  }

  @Bean
  public TransferDataDao transferDataDao() {
    return EasyMock.createStrictMock(TransferDataDao.class);
  }
}
