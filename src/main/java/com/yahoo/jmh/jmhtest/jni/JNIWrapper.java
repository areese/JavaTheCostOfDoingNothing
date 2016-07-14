// Copyright 2016 Yahoo Inc.
// Licensed under the terms of the New-BSD license. Please see LICENSE file in the project root for terms.

package com.yahoo.jmh.jmhtest.jni;

import com.yahoo.jmh.jmhtest.Wrapper;

public class JNIWrapper implements Wrapper {

    private boolean returnValue = true;

    static {
        JniLibraryLoader.load();
    }

    private static final JNIWrapper INSTANCE = new JNIWrapper();

    public static final JNIWrapper getInstance() {
        return INSTANCE;
    }

    static final native void nativeParamNone();

    static final native void nativeParamString(String param);

    static final native void nativeParamStrings(String lhs, String rhs);

    static final native void nativeParamStringsUnicode(String lhs, String rhs);

    static final native void nativeParamArray(String[] param);

    static final native String nativeParamNoneReturnStringUTF8();

    static final native boolean nativeEquals(String lhs, String rhs);

    static final native void nativeParam2StringsNoScoping(String lhs, String rhs);

    static final native void nativeParamStringsUTF8(String lhs, String rhs);
    static final native void nativeParamStringUTF8(String lhs);
    static final native void nativeParamStringUnicode(String lhs);

    /**
     * 
     * Write 0xDA to an address from sun.misc.unsafe.
     * 
     * @param address allocated by Unsafe.allocate memory
     * @param size size in bytes to write to.
     */
    public static final native void fillBytesInFromNative(long address, long size);

    /**
     * 
     * Write 0xDA to an address from sun.misc.unsafe.
     * 
     * @param address allocated by Unsafe.allocate memory
     * @param size size in bytes to write to.
     */
    public static final native void dumpBytesFromAddress(long address, long start, long size);


    @Override
    public final boolean paramNone() {
        nativeParamNone();
        return returnValue;
    }

    @Override
    public final boolean paramString(String param) {
        nativeParamString(param);
        return returnValue;
    }

    @Override
    public final boolean paramStrings(String lhs, String rhs) {
        nativeParamStrings(lhs, rhs);
        return returnValue;
    }

    @Override
    public boolean paramStringsUnicode(String lhs, String rhs) {
        nativeParamStringsUnicode(lhs, rhs);
        return returnValue;
    }

    @Override
    public final boolean paramArray(String[] param) {
        nativeParamArray(param);
        return returnValue;
    }

    @Override
    public final String paramNoneReturnStringUTF8() {
        return nativeParamNoneReturnStringUTF8();
    }

    @Override
    public boolean strEquals(String lhs, String rhs) {
        return nativeEquals(lhs, rhs);
    }

    @Override
    public boolean param2StringsNoScoping(String lhs, String rhs) {
        nativeParam2StringsNoScoping(lhs, rhs);
        return returnValue;
    }

    @Override
    public boolean paramStringsUTF8(String lhs, String rhs) {
        nativeParamStringsUTF8(lhs, rhs);
        return returnValue;
    }

    @Override
    public boolean paramStringUTF8(String lhs) {
        nativeParamStringUTF8(lhs);
        return returnValue;
    }

    @Override
    public boolean paramStringUnicode(String lhs) {
        nativeParamStringUnicode(lhs);
        return returnValue;
    }

}
