package com.yahoo.monkey;

import java.util.Arrays;

import sun.misc.Unsafe;

import com.yahoo.jmh.jmhtest.jni.JNIWrapper;
import com.yahoo.wildwest.MUnsafe;

@SuppressWarnings("restriction")
public class TestCopyFrom {

    /**
     * JDK uses inotify and reads from a byte array. Let's try that.
     */
    public static void main(String[] args) {
        // testReadingAndWritingNative();
        testCopyFromByteArray();
    }

    private static void testCopyFromByteArray() {
        Unsafe unsafe = MUnsafe.getUnsafe();
        long size = 1024;
        long address = unsafe.allocateMemory(size);

        byte[] from = new byte[(int) size];
        Arrays.fill(from, (byte) 0xDA);

        unsafe.copyMemory(from, 0, null, address, size);

//        for (int i = 0; i < size / 4; i += 4) {
//            byte b = unsafe.getByte(address + i);
//            System.out.print(Integer.toHexString(b));
//        }
//        System.out.println("");



        JNIWrapper.dumpBytesFromAddress(address, 32);
        long byteArrayBaseOffset = unsafe.arrayBaseOffset(byte[].class);
        long byteArrayIndexScale = unsafe.arrayIndexScale(byte[].class);

        System.err.println(byteArrayBaseOffset);
    }

    private static void testReadingAndWritingNative() {
        // we need an unsafe.

        Unsafe unsafe = MUnsafe.getUnsafe();
        long size = 1024;
        long address = unsafe.allocateMemory(size);

        JNIWrapper.fillBytesInFromNative(address, size);

        for (int i = 0; i < size / 4; i += 4) {
            long l = unsafe.getLong(address + i);
            System.out.print(Long.toHexString(l));
        }
        System.out.println("");

        JNIWrapper.dumpBytesFromAddress(address, size);

        unsafe.freeMemory(address);

    }
}
