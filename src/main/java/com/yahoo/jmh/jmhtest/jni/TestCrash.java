package com.yahoo.jmh.jmhtest.jni;

public class TestCrash {
  public static void main(String[] args) {
    JNIWrapper.nativeParamStringUnicode("bar");
  }
}
