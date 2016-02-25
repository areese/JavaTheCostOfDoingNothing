#

This code is to resurrect a presentation done by Dean Yu & Josh Blatt at JavaOne 2008.
(http://download.oracle.com/javaone/javaone2008-ee.zip,  TS6391.pdf)

The title was something similiar to the cost of doing nothing, and reflected how much does 
it cost to make a single JNI call.

With JMH we can do far better micro-benchmarking, so I've resurrected this.

To execute the code:

java -Djava.library.path=target/native/x86_64-darwin-clang/ -jar target/jmhtest-1.0-SNAPSHOT.jar com.yahoo.jmh.jmhtest.JavaTest 

java -Djava.library.path=target/native/x86_64-darwin-clang/ -jar target/jmhtest-1.0-SNAPSHOT.jar com.yahoo.jmh.jmhtest.JNITest 


Notice the library dir is:
target/native/x86_64-{darwin,linux}-{clang,gcc}

depending on build OS.