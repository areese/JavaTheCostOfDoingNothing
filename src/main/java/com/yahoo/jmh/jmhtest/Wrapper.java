// Copyright 2016 Yahoo Inc.
// Licensed under the terms of the New-BSD license. Please see LICENSE file in the project root for terms.

package com.yahoo.jmh.jmhtest;

public interface Wrapper {

    boolean paramNone();

    /**
     * Pass a string as a parameter and do not decode it
     * @param param
     * @return
     */
    boolean paramString(String param);

    /**
     * Pass an array string as a parameter and do not decode them or touch the array
     * @param param
     * @return
     */
    boolean paramArray(String[] param);

    /**
     * Pass 2 strings as a parameters and do not decode them 
     * @param param
     * @return
     */
    boolean paramStrings(String lhs, String rhs);


    /**
     * Pass 2 strings as a parameters and decode them into unicode 
     * @param param
     * @return
     */
    boolean paramStringsUnicode(String lhs, String rhs);

    /**
     * Pass 2 strings as a parameters and decode them into UTF-8 
     * @param param
     * @return
     */
    boolean paramStringsUTF8(String lhs, String rhs);


    /**
     * Pass a strings a parameter and decode it into UTF-8 
     * @param param
     * @return
     */
    boolean paramStringUTF8(String lhs);

    /**
     * Pass a strings a parameter and decode it into Unicode 
     * @param param
     * @return
     */
    boolean paramStringUnicode(String lhs);

    /**
     * Return a static string encoded from UTF8
     * @return
     */
    String paramNoneReturnStringUTF8();

    boolean strEquals(String lhs, String rhs);

    boolean param2StringsNoScoping(String equalsLhs1, String equalsRhs1);

}
