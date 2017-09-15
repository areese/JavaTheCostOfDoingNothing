// Copyright 2016 Yahoo Inc.
// Licensed under the terms of the New-BSD license. Please see LICENSE file in the project root for terms.

package com.yahoo.jmh.jmhtest.java;

import java.nio.charset.StandardCharsets;

import com.yahoo.jmh.jmhtest.Wrapper;


public class JavaWrapper implements Wrapper {

    private static final JavaWrapper INSTANCE = new JavaWrapper();

    private boolean returnValue = true;
    private String returnString = "foo";
    private byte[] UTF8_STRING = returnString.getBytes(StandardCharsets.UTF_8);

    public static final JavaWrapper getInstance() {
        return INSTANCE;
    }

    @Override
    public final boolean paramNone() {
        return returnValue;
    }

    @Override
    public final boolean paramString(String param) {
        return returnValue;
    }

    @Override
    public final boolean paramStrings(String lhs, String rhs) {
        return returnValue;
    }

    @Override
    public final boolean paramArray(String[] param) {
        return returnValue;
    }

    @Override
    public final String paramNoneReturnStringUTF8() {
        // FIX me this should do encoding
        return new String(UTF8_STRING, StandardCharsets.UTF_8);
    }

    @Override
    public boolean strEquals(String lhs, String rhs) {
        return lhs.equals(rhs);
    }

    @Override
    public boolean paramStringsUnicode(String lhs, String rhs) {
        // we want to look exactly like the jni would look when it gets unicode for 2 strings and compares lengths.
        // http://hg.openjdk.java.net/jdk8u/jdk8u-dev/hotspot/file/92693f9dd704/src/share/vm/classfile/javaClasses.cpp#l321
        // that's what I think the jni ends up calling underneath
        char[] left;
        {
            final int len = lhs.length();
            left = new char[len];
            for (int i = 0; i < len; i++) {
                left[i] = lhs.charAt(i);
            }
        }

        char[] right;
        {
            final int len = rhs.length();
            right = new char[len];
            for (int i = 0; i < len; i++) {
                right[i] = rhs.charAt(i);
            }
        }

        return left.length > 0 && right.length > 0;
    }

    @Override
    public boolean param2StringsNoScoping(String lhs, String rhs) {
        return returnValue;
    }

    @Override
    public boolean paramStringsUTF8(String lhs, String rhs) {
        return lhs.getBytes(StandardCharsets.UTF_8).length > 0 && rhs.getBytes(StandardCharsets.UTF_8).length > 0;
    }

    @Override
    public boolean paramStringUTF8(String lhs) {
        // decode the string to be UTF-8
        return lhs.getBytes(StandardCharsets.UTF_8).length > 0;
    }

    @Override
    public boolean paramStringUnicode(String lhs) {
        return lhs.getBytes(StandardCharsets.UTF_16).length > 0;
    }

}
