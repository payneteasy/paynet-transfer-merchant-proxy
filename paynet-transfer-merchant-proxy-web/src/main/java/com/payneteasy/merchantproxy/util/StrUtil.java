package com.payneteasy.merchantproxy.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.BaseEncoding;

import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class StrUtil {

  public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

  public static final String EMPTY = "";

  public static boolean isBlank(String text){
    return text == null || text.isEmpty();
  }

  // Alphanumeric characters (62) + 2 special characters (for 64 total length to optimize random number generator)
  private static final char[] CHAR_ARRAY
      = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ^$".toCharArray();

  public static String generateRandomString(final int length) {
    final Random generator = ThreadLocalRandom.current();

    final StringBuilder res = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      res.append(CHAR_ARRAY[generator.nextInt(CHAR_ARRAY.length)]);
    }

    return res.toString();
  }

  public static String calcShaHash(final byte[] data, final CharSequence key) throws GeneralSecurityException {
    final String hmacSHA1 = "HmacSHA1";
    final byte[] keyBytes = BaseEncoding.base16().decode(key);
    final Key signingKey = new SecretKeySpec(keyBytes, hmacSHA1);
    final Mac mac = Mac.getInstance(hmacSHA1);
    mac.init(signingKey);
    final byte[] rawHmac = mac.doFinal(data);
    return BaseEncoding.base16().encode(rawHmac);
  }
}
