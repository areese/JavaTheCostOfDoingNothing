The Cost of Doing Nothing
================

*   [Background](#Background)
*   [Running](#Running)
    *   [Running JavaTest](#JavaTest)
    *   [Running JNITest](#JNITest)
    *   [Running on OS-X](#osx)
    *   [Running on Linux](#linux)
*   [Charts](#Charts)
*   [Credits](#Credits)

<h2 id="Background">Background</h2>

This code is to resurrect a presentation done by Dean Yu (@dty) & Josh Blatt (@jtblatt) at JavaOne 2008.
(Complete track here: http://download.oracle.com/javaone/javaone2008-ee.zip.  Actual pdf here: TS6391.pdf)

The title was something similiar to the cost of doing nothing, and reflected how much does 
it cost to make a single JNI call.

With JMH we can do far better micro-benchmarking, so I've resurrected this.

<h2 id="Running">Running</h2>
First build the code: 

```
mvn clean verify
```

Then decide which test to run, and set your java.library.path appriately.


<h3 id="JavaTest">JavaTest</h3>

```
java -jar target/JavaTheCostOfDoingNothing-1.0-SNAPSHOT.jar com.yahoo.jmh.jmhtest.JavaTest 
```

<h3 id="JNITest">JNITest</h3>

```
java -Djava.library.path=target/native/x86_64-darwin-clang/ -jar target/JavaTheCostOfDoingNothing-1.0-SNAPSHOT.jar com.yahoo.jmh.jmhtest.JNITest 
```

<h3 id="osx">osx</h3>

```
java.library.path=target/native/x86_64-darwin-clang/
```

<h3 id="linux">linux</h3>

```
java.library.path=target/native/x86_64-linux-gcc/
```

<h2 id="Charts">Charts</h2>
Data is in javatest.txt and jnitest.txt
hardware config is in DATA.md
Copied into google docs, and then created charts as pdfs.
These replicate the orginal charts in slide 13 and 14, but using the data from this code as output from jmh.
(Sadly I can't find the original code that was used for these slides despite digging).

<h2 id="TheCost">The Cost</h2>

| Benchmark                           | Score       | Error ± |           |           | avg       | avg ns/op   |
|-------------------------------------|-------------|---------|-----------|-----------|-----------|-------------|
| JNITest.testEquals1                 | 1748.002    | 4.084   | 1743.918  | 1752.086  | 1748.002  | 572.0817253 |
| JNITest.testEquals2                 | 1589.69     | 3.514   | 1586.176  | 1593.204  | 1589.69   | 629.0534633 |
| JNITest.testParam2StringsNoScoping  | 8759.817    | 252.259 | 8507.558  | 9012.076  | 8759.817  | 114.1576359 |
| JNITest.testParamStringsEq          | 1810.502    | 13.743  | 1796.759  | 1824.245  | 1810.502  | 552.3329994 |
| JNITest.testParamStringsNe          | 1635.348    | 5.647   | 1629.701  | 1640.995  | 1635.348  | 611.490643  |
| JNITest.testParamStringsUnicodeEq   | 2523.425    | 12.172  | 2511.253  | 2535.597  | 2523.425  | 396.2867928 |
| JNITest.testParamStringsUnicodeNe   | 2434.21     | 9.913   | 2424.297  | 2444.123  | 2434.21   | 410.8108996 |
| JavaTest.testParam2StringsNoScoping | 10238.344   | 62.841  | 10175.503 | 10301.185 | 10238.344 | 97.6720454  |


| Portion                            | ns/op       | % Time Taken |
|------------------------------------|-------------|--------------|
| Java 2 strings                     | 97.6720454  |              |
| JNI 2 strings                      | 114.1576359 |              |
| Jni 2 equal Strings unicode        | 396.2867928 |              |
| Jni 2 equal Strings UTF8           | 552.3329994 |              |
|                                    |             |              |
| Java function overhead             | 97.6720454  | 17.68%       |
| JNI function overhead              | 16.48559054 | 2.98%        |
| JNI Get Strings overhead (unicode) | 282.1291568 | 51.08%       |
| JNI UTF8 Decoding overhead         | 156.0462066 | 28.25%       |
| Total Time taken                   | 552.3329994 |              |


<h2 id="Credits">Credits</h2>
Josh Blatt (@jtblatt) and Dean Yu (@dty) originally presented this at JavaOne 2008 as part of the Java Platform Team @ Yahoo!
Thanks to Sumit Shah (@bigloser) for digging up the original presentation, as he was also a member of the team at that time.
Nelson Maltez (@nelson-maltez) put together the basic parts of the code which I then refined with him.
Markdown tables were generated by copying from Google Sheets into http://www.tablesgenerator.com/markdown_tables
