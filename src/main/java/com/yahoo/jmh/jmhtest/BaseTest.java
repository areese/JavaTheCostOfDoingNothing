// Copyright 2016 Yahoo Inc.
// Licensed under the terms of the New-BSD license. Please see LICENSE file in the project root for terms.
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
  public void setup() {
  }

  @TearDown
  public void tearDown() {
  }


  @Benchmark
  @CompilerControl(CompilerControl.Mode.EXCLUDE)
  public boolean paramNone() {
    return wrapper.paramNone();
  }

  @Benchmark
  @CompilerControl(CompilerControl.Mode.EXCLUDE)
  public boolean paramString() {
    return wrapper.paramString(bar);
  }

  @Benchmark
  @CompilerControl(CompilerControl.Mode.EXCLUDE)
  public boolean paramStringUTF8() {
    return wrapper.paramStringUTF8(bar);
  }

  @Benchmark
  @CompilerControl(CompilerControl.Mode.EXCLUDE)
  public boolean paramStringUnicode() {
    return wrapper.paramStringUnicode(bar);
  }

  @Benchmark
  @CompilerControl(CompilerControl.Mode.EXCLUDE)
  public boolean testParam2StringsNoScoping() {
    return wrapper.param2StringsNoScoping(equalsLhs1, equalsRhs1);
  }

  @Benchmark
  @CompilerControl(CompilerControl.Mode.EXCLUDE)
  public boolean testParamStringsEq() {
    return wrapper.strEquals(equalsLhs1, equalsRhs1);
  }

//  @Benchmark
//  @CompilerControl(CompilerControl.Mode.EXCLUDE)
//  public boolean testParamStringsNe() {
//    return wrapper.strNotEquals(notEqualsLhs1, notEqualsRhs1);
//  }
//

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
  public String paramNoneReturnStringUTF8() {
    return wrapper.paramNoneReturnStringUTF8();
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
