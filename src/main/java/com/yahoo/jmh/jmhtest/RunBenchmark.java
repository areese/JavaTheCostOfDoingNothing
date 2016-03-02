// Copyright 2016 Yahoo Inc.
// Licensed under the terms of the New-BSD license. Please see LICENSE file in the project root for terms.
package com.yahoo.jmh.jmhtest;

import java.io.IOException;

import org.openjdk.jmh.runner.RunnerException;

public class RunBenchmark {

    public static void main(String... args) throws RunnerException, IOException {
        org.openjdk.jmh.Main.main(args);
    }
}
