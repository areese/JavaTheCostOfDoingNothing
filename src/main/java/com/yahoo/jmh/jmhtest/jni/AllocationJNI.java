package com.yahoo.jmh.jmhtest.jni;

public class AllocationJNI {

    static {
        JniLibraryLoader.load();
    }

    public static final native long allocate(int size);

    public static final native void release(long address);

    public static final native int doSomething(long destAddress, int size);

}
