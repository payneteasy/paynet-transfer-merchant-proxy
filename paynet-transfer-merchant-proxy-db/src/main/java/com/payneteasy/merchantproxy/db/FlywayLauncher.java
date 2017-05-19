package com.payneteasy.merchantproxy.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

import org.flywaydb.core.Flyway;

public class FlywayLauncher {
  private final Properties properties;

  public static void main(final String... args) throws IOException {
    if (System.getProperty("flyway.configFile") == null) {
      System.err.println("Incorrect usage. Please, specify -Dflyway.configFile parameter");
      System.exit(1);
    }

    final Properties properties = new Properties();
    try (InputStream in = new FileInputStream(System.getProperty("flyway.configFile"))) {
      properties.load(in);
    }
    new FlywayLauncher(properties).run((args.length > 0) ? args[0] : null);
  }

  private FlywayLauncher(final Properties properties) {
    this.properties = properties;
  }

  private void run(final String command) {
    final String urlProp = properties.getProperty("flyway.url");
    final String userProp = properties.getProperty("flyway.user");
    final String passwordProp = properties.getProperty("flyway.password");

    final Flyway flyway = new Flyway();
    flyway.setDataSource(urlProp, userProp, passwordProp);
    if (Objects.equals("clean", command)) {
      flyway.clean();
    } else if (Objects.equals("repair", command)) {
      flyway.repair();
    } else {
      flyway.migrate();
    }
  }
}
