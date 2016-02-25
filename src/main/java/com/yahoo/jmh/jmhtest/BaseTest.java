package com.yahoo.jmh.jmhtest;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.CompilerControl;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.TearDown;

import com.yahoo.jmh.jmhtest.java.JavaWrapper;

public abstract class BaseTest {
    protected Wrapper wrapper;
    protected String bar = "foo";
    protected String[] foo = {bar};

    public BaseTest(Wrapper instance) {
        wrapper = instance;
    }

    @Setup
    public void setup() {}

    @TearDown
    public void tearDown() {}


    @Benchmark
    @CompilerControl(CompilerControl.Mode.EXCLUDE)
    public boolean testParamNone() {
        return wrapper.paramNone();
    }

    @Benchmark
    @CompilerControl(CompilerControl.Mode.EXCLUDE)
    public boolean testParamString() {
        return wrapper.paramString(bar);
    }

    @Benchmark
    @CompilerControl(CompilerControl.Mode.EXCLUDE)
    public boolean testParamArray() {
        return wrapper.paramArray(foo);
    }

    @Benchmark
    @CompilerControl(CompilerControl.Mode.EXCLUDE)
    public String testParamNoneReturnString() {
        return wrapper.paramNoneReturnString();
    }

}
