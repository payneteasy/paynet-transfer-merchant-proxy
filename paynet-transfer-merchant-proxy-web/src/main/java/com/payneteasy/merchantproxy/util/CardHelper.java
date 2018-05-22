package com.payneteasy.merchantproxy.util;

public class CardHelper {

    public static String createClientCardReferenceId(final Long serverCardId){
        return String.valueOf(new StringBuilder(String.valueOf(serverCardId)).reverse().toString().hashCode());
    }
}
