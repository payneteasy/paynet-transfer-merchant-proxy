package com.payneteasy.merchantproxy;

import java.io.File;
import java.net.MalformedURLException;

import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

public class StartApp {

  public static void main(final String... args) throws ServletException, LifecycleException, MalformedURLException {
    final String webappDirLocation = "paynet-transfer-merchant-proxy-web/target/libs/";
    final Tomcat tomcat = new Tomcat();
    tomcat.setBaseDir("target");

    final StandardContext ctx = (StandardContext) tomcat.addWebapp("", new File(webappDirLocation).getAbsolutePath());
    ctx.setUseHttpOnly(true);
    System.out.println("Configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());

    // Declare an alternative location for your "WEB-INF/classes" dir
    // Servlet 3.0 annotation will work
    final File additionWebInfClasses = new File("paynet-transfer-merchant-proxy-web/target/classes");
    final WebResourceRoot resources = new StandardRoot(ctx);
    resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));
    ctx.setResources(resources);

    tomcat.start();
    tomcat.getServer().await();
  }
}
