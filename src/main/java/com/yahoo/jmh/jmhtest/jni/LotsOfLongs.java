// Copyright 2016 Yahoo Inc.
// Licensed under the terms of the New-BSD license. Please see LICENSE file in the project root for terms.

package com.yahoo.jmh.jmhtest.jni;


public class LotsOfLongs {

  private boolean returnValue = true;

  static {
    JniLibraryLoader.load();
  }

  public static final native void testLongArray(long[] longArray);

  public static final native void testLongParams(long inetAddress, long inetAddressLen, long ra, long raLen, long rp,
                                                 long rpLen, long rs, long rsLen);


}
