package com.payneteasy.merchantproxy.util;

import java.util.Collection;

public class CollectionUtils {
    public static boolean isEmpty(Collection collection){
        return collection == null || collection.isEmpty();
    }
}