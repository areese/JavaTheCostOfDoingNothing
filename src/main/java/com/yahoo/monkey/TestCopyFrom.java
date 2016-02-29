package com.yahoo.monkey;

import java.util.Arrays;

import sun.misc.Unsafe;
import sun.misc.VM;

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

    private static long index(long address, int i) {
        return address + ((long) i << 0);
    }

    private static long allocate(long cap) {
        boolean pa = VM.isDirectMemoryPageAligned();
        int ps = MUnsafe.unsafe.pageSize();
        long size = Math.max(1L, (long) cap + (pa ? ps : 0));
        long base = MUnsafe.unsafe.allocateMemory(size);
        MUnsafe.unsafe.setMemory(base, size, (byte) 0);

        long address = 0;
        if (pa && (base % ps != 0)) {
            // Round up to page boundary
            address = base + ps - (base & (ps - 1));
        } else {
            address = base;
        }

        return address;
    }

    private static void testCopyFromByteArray() {
        Unsafe unsafe = MUnsafe.getUnsafe();
        long byteArrayBaseOffset = unsafe.arrayBaseOffset(byte[].class);
        long byteArrayIndexScale = unsafe.arrayIndexScale(byte[].class);


        long size = 16;
        long totalSize = size + 32;
        long destAddress = allocate(totalSize);

        byte[] from = new byte[(int) totalSize];
        Arrays.fill(from, (byte) 0xDA);
        Arrays.fill(from, (int) byteArrayBaseOffset, (int) totalSize, (byte) 0xBB);

        System.out.println(arrayHexString(from));

        System.err.println("BEFORE COPY");


        long fromOffset = unsafe.arrayBaseOffset(byte[].class);
        unsafe.copyMemory(from, fromOffset, null, index(destAddress, 0), totalSize);
        // unsafe.copyMemory(MUnsafe.toAddress(from), destAddress, size);


        System.err.println("AFTER COPY");

        // for (int i = 0; i < size / 4; i += 4) {
        // byte b = unsafe.getByte(address + i);
        // System.out.print(Integer.toHexString(b));
        // }
        // System.out.println("");



        JNIWrapper.dumpBytesFromAddress(destAddress, 0, 16);
        JNIWrapper.dumpBytesFromAddress(destAddress, byteArrayBaseOffset, totalSize);
        System.err.println(byteArrayBaseOffset);
    }

    private static String arrayHexString(byte[] from) {
        StringBuilder sb = new StringBuilder();
        for (byte b : from) {
            sb.append(Integer.toHexString(Byte.toUnsignedInt(b)));
        }

        return sb.toString();
    }

    private static void testReadingAndWritingNative() {
        // we need an unsafe.

        Unsafe unsafe = MUnsafe.getUnsafe();
        long size = 1024;
        long address = unsafe.allocateMemory(size);

        JNIWrapper.fillBytesInFromNative(address, 16);

        JNIWrapper.dumpBytesFromAddress(address, 0, 16);
        JNIWrapper.dumpBytesFromAddress(address, 16, size);

        System.out.println("");
        System.out.println("========================================================================");

        JNIWrapper.dumpBytesFromAddress(address, 0, size);

        unsafe.freeMemory(address);

    }
}
