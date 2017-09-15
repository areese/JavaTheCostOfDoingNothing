#!/bin/bash
V=$$

java -jar target/JavaTheCostOfDoingNothing-1.0-SNAPSHOT.jar  com.yahoo.jmh.jmhtest.JavaTest -bm avgt -tu ns 2>&1 | tee java.results.$V
java -Djava.library.path=target/native/x86_64-linux-gcc/ -jar target/JavaTheCostOfDoingNothing-1.0-SNAPSHOT.jar  com.yahoo.jmh.jmhtest.JNITest -tu ns -bm avgt 2>&1 | tee jni.results.$V
