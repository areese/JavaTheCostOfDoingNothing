// Copyright 2016 Yahoo Inc.
// Licensed under the terms of the New-BSD license. Please see LICENSE file in the project root for terms.

package com.yahoo.jmh.jmhtest;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import com.yahoo.jmh.jmhtest.jni.JNIWrapper;
import com.yahoo.jmh.jmhtest.jni.JniLibraryLoader;

@State(Scope.Benchmark)
public class JNITest extends BaseTest {
    public JNITest() {
        super(JNIWrapper.getInstance());
    }

    @Override
    @Setup
    public void setup() {
        JniLibraryLoader.load();
    }
}
