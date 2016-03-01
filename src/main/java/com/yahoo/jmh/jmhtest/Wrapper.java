// Copyright 2016 Yahoo Inc.
// Licensed under the terms of the New-BSD license. Please see LICENSE file in the project root for terms.

package com.yahoo.jmh.jmhtest;

public interface Wrapper {

    boolean paramNone();

    boolean paramString(String param);

    boolean paramStrings(String lhs, String rhs);

    boolean paramStringsUnicode(String lhs, String rhs);

    boolean paramArray(String[] param);

    String paramNoneReturnString();

    boolean strEquals(String lhs, String rhs);

    boolean param2StringsNoScoping(String equalsLhs1, String equalsRhs1);

}
