// Copyright 2016 Yahoo Inc.
// Licensed under the terms of the New-BSD license. Please see LICENSE file in the project root for terms.

package com.yahoo.jmh.jmhtest;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.CompilerControl;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import com.yahoo.jmh.jmhtest.jni.JniLibraryLoader;
import com.yahoo.jmh.jmhtest.jni.LotsOfLongs;

@State(Scope.Benchmark)
public class TestLotsOfLongs {

    private int returnValue = 792;
    long inetAddress = 20;
    long inetAddressLen = 30;
    long ra = 40;
    long raLen = 50;
    long rp = 60;
    long rpLen = 70;
    long rs = 80;
    long rsLen = 90;

    private long[] values = new long[] { //
                    inetAddress, inetAddressLen, //
                                    ra, raLen, //
                                    rp, rpLen, //
                                    rs, rsLen //

                    };

    public TestLotsOfLongs() {}

    @Setup
    public void setup() {
        JniLibraryLoader.load();
    }

    @Benchmark
    @CompilerControl(CompilerControl.Mode.EXCLUDE)
    public int testLongArrays() {
        LotsOfLongs.testLongArray(values);
        return returnValue;
    }

    @Benchmark
    @CompilerControl(CompilerControl.Mode.EXCLUDE)
    public int testLongs() {
        // LotsOfLongs.testLongParams(inetAddress, inetAddressLen, ra, raLen, rp, rpLen, rs, rsLen);
        LotsOfLongs.testLongParams(values[0], values[1], values[2], values[3], values[4], values[5], values[6],
                        values[7]);
        return returnValue;
    }

}
