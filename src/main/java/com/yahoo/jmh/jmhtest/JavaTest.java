// Copyright 2016 Yahoo Inc.
// Licensed under the terms of the New-BSD license. Please see LICENSE file in the project root for terms.

package com.yahoo.jmh.jmhtest;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import com.yahoo.jmh.jmhtest.java.JavaWrapper;

@State(Scope.Benchmark)
public class JavaTest extends BaseTest {

    public JavaTest() {
        super(JavaWrapper.getInstance());
    }
}
