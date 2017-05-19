package com.payneteasy.merchantproxy.util;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class CacheUtil {

  private static final Cache<String, String> ACCESS_TOKEN_CACHE = CacheBuilder.newBuilder().expireAfterWrite(30, TimeUnit.MINUTES).build();

  private CacheUtil() {
  }

  public static void putAccessTokenSerialNumber(final String accessToken, final String serialNumber) {
    ACCESS_TOKEN_CACHE.put(accessToken, serialNumber);
  }

  public static String getAccessTokenSerialNumber(final String accessToken) {
    return ACCESS_TOKEN_CACHE.getIfPresent(accessToken);
  }
}
