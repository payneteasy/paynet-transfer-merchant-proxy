package com.payneteasy.merchantproxy.config;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScan({"com.payneteasy.merchantproxy.service", "com.payneteasy.merchantproxy.dao"})
@PropertySource("classpath:application.properties")
public class AppConfig {

  @Value("${db.url}")
  private String dbUrl;

  @Value("${db.user}")
  private String dbUser;

  @Value("${db.password}")
  private String dbPassword;


  @Bean
  public DataSource dataSource() {
    final JdbcDataSource dataSource = new JdbcDataSource();
    dataSource.setUrl(dbUrl);
    dataSource.setUser(dbUser);
    dataSource.setPassword(dbPassword);
    return dataSource;
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    return new DataSourceTransactionManager(dataSource());
  }

}
