package com.yahoo.monkey;

import sun.misc.Unsafe;

import static com.yahoo.wildwest.MUnsafe.*;
import com.yahoo.wildwest.MUnsafe;

// http://www.docjar.com/docs/api/sun/misc/Unsafe.html#getInt

@SuppressWarnings("restriction")
public class TestUnsafe {
    public static void main(String[] args) {

        char[] from = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '\u20AC', '\uD852', '\uDF62'};

        Unsafe unsafe = MUnsafe.getUnsafe();

        // System.err.println(new String(from));
        // //
        // for (int i = 0; i < from.length; i++) {
        // char c = unsafe.getChar(from, MUnsafe.charArrayOffset(i));
        // System.err.println(Integer.toHexString(c) + " " + c);
        // }
        // for (int i = 0; i < from.length; i++) {
        // char c = unsafe.getChar(from, MUnsafe.charArrayOffset(i));
        // System.err.println(Integer.toHexString(c));
        // }


        long memorySize = MUnsafe.charArraySize(from);
        long newMemory = unsafe.allocateMemory(512 + memorySize);

        // System.err.println(from.length + " chars, length " + memorySize + " At " + newMemory);

        char[] to = new char[256];

        long fromAddress = MUnsafe.toAddress(from);

        // unsafe.copyMemory(fromAddress + MUnsafe.charArrayBaseOffset, newMemory, memorySize);
        // unsafe.copyMemory(from, MUnsafe.charArrayBaseOffset, null, newMemory, memorySize);
        // unsafe.copyMemory(from, MUnsafe.charArrayBaseOffset, to, MUnsafe.charArrayBaseOffset, memorySize);

        // System.err.println("copied " + to.length);
        // System.err.println(new String(to));
        System.err.println("efg");
        System.out.println("====\n");

        for (int i = 0; i < memorySize + 512; i += 8) {
            // char c = unsafe.getChar(newMemory, MUnsafe.charArrayBaseOffset + i * MUnsafe.charArrayIndexScale);
            // char c2 = unsafe.getChar(to, MUnsafe.charArrayBaseOffset + (i * MUnsafe.charArrayIndexScale));
            // byte c = unsafe.getByte(newMemory, (long) i);
            long l = unsafe.getLong(newMemory, MUnsafe.normalize(i));
            // System.out.println("c1 : " + Integer.toHexString((byte) c) + " " + c);
            System.out.println("c1 : " + Long.toHexString(l) + " " + l);
            // System.out.println("c2 : " + Integer.toHexString((byte) c2) + " " + c2);
            // System.err.println(c);
            // System.out.print(c);
        }
        System.err.println("done");

        unsafe.freeMemory(newMemory);
    }


}
