package com.w.callum.pdf_service_data.util;

import java.io.*;

public class ImageHashing {
    public long ConvertByteArrToNumberFNV1A(byte[] bytes) {
        long fnvOffsetBasis = -3750763034362895579L;
        long fnvPrime = 1099511628211L;

        long hash = fnvOffsetBasis;
        for(byte a : bytes){
            hash = hash ^ Byte.toUnsignedLong(a);
            hash = hash * fnvPrime;
        }

        return hash;
    }

    public long Hash64shift(long key) {
        key = (key) + (key << 21);
        key = key ^ (key >>> 24);
        key = (key + (key << 3)) + (key << 8); // key * 265
        key = key ^ (key >>> 14);
        key = (key + (key << 2)) + (key << 4); // key * 21
        key = key ^ (key >>> 28);
        key = key + (key << 31);
        return key;
    }

    // ConvertHashToString uses base62 to compress and convert the uint64 number into a more human-readable form.
    public String ConvertHashToString(long input) {
        StringBuilder s = new StringBuilder();
        String charSet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        for (long i = input; Long.compareUnsigned(i, 0) > 0; i = Long.divideUnsigned(i, 62L)) {
            int remainer = Math.toIntExact(Long.remainderUnsigned(i, 62L));
            String c = String.valueOf(charSet.charAt(remainer));
            s.insert(0, c);
        }

        return s.toString();
    }
}