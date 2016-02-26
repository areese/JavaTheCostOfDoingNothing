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
	mvn clean verify

Then decide which test to run, and set your java.library.path appriately.


<h3 id="JavaTest">JavaTest</h3>
	java -jar target/JavaTheCostOfDoingNothing-1.0-SNAPSHOT.jar com.yahoo.jmh.jmhtest.JavaTest 

<h3 id="JNITest">JNITest</h3>
	java -Djava.library.path=target/native/x86_64-darwin-clang/ -jar target/JavaTheCostOfDoingNothing-1.0-SNAPSHOT.jar com.yahoo.jmh.jmhtest.JNITest 

<h3 id="osx">osx</h3>
	java.library.path=target/native/x86_64-darwin-clang/

<h3 id="linux">linux</h3>
	java.library.path=target/native/x86_64-linux-gcc/

<h2 id="Charts">Charts</h2>
Data is in javatest.txt and jnitest.txt
hardware config is in DATA.md
Copied into google docs, and then created charts as pdfs.
These replicate the orginal charts in slide 13 and 14, but using the data from this code as output from jmh.
(Sadly I can't find the original code that was used for these slides despite digging).

<h2 id="Credits">Credits</h2>
Josh Blatt (@jtblatt) and Dean Yu (@dty) originally presented this at JavaOne 2008 as part of the Java Platform Team @ Yahoo!
Thanks to Sumit Shah (@bigloser) for digging up the original presentation, as he was also a member of the team at that time.
Nelson Maltez (@nelson-maltez) put together the basic parts of the code which I then refined with him.