package com.yahoo.jmh.jmhtest;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.CompilerControl;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.TearDown;

public abstract class BaseTest {
    protected Wrapper wrapper;
    protected String bar = "foo";
    protected String[] foo = {bar};

    protected String equalsLhs1 = "ThisIsAStringI'mComparing";
    protected String equalsRhs1 = "ThisIsAStringI'mComparing";
    protected String notEqualsLhs1 = "SomethingElseLongAlmostDifferent";
    protected String notEqualsRhs1 = "SomethingElseLongToCompare";


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
    public boolean testParamStringsEq() {
        return wrapper.paramStrings(equalsLhs1, equalsRhs1);
    }

    @Benchmark
    @CompilerControl(CompilerControl.Mode.EXCLUDE)
    public boolean testParamStringsNe() {
        return wrapper.paramStrings(notEqualsLhs1, notEqualsRhs1);
    }


    @Benchmark
    @CompilerControl(CompilerControl.Mode.EXCLUDE)
    public boolean testParamStringsUnicodeEq() {
        return wrapper.paramStringsUnicode(equalsLhs1, equalsRhs1);
    }

    @Benchmark
    @CompilerControl(CompilerControl.Mode.EXCLUDE)
    public boolean testParamStringsUnicodeNe() {
        return wrapper.paramStringsUnicode(notEqualsLhs1, notEqualsRhs1);
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

    @Benchmark
    @CompilerControl(CompilerControl.Mode.EXCLUDE)
    public boolean testEquals1() {
        return wrapper.strEquals(equalsLhs1, equalsRhs1);
    }

    @Benchmark
    @CompilerControl(CompilerControl.Mode.EXCLUDE)
    public boolean testEquals2() {
        return wrapper.strEquals(notEqualsLhs1, notEqualsRhs1);
    }


}
