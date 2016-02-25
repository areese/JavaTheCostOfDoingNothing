// Copyright 2016 Yahoo Inc.
// Licensed under the terms of the New-BSD license. Please see LICENSE file in the project root for terms.

package com.yahoo.jmh.jmhtest.java;

import com.yahoo.jmh.jmhtest.Wrapper;


public class JavaWrapper implements Wrapper {

    private static final JavaWrapper INSTANCE = new JavaWrapper();

    private boolean returnValue = true;
    private String returnString = "foo";

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
    public final String paramNoneReturnString() {
        return returnString;
    }

    @Override
    public boolean strEquals(String lhs, String rhs) {
        return lhs.equals(rhs);
    }

}
