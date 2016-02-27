package com.yahoo.monkey;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

// http://www.docjar.com/docs/api/sun/misc/Unsafe.html#getInt

@SuppressWarnings("restriction")
public class TestUnsafe {
    public static void main(String[] args) {

        char[] from = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '\u20AC', '\uD852', '\uDF62'};

        Unsafe unsafe = MUnsafe.getUnsafe();

        System.err.println(new String(from));
        //
        for (int i = 0; i < from.length; i++) {
            char c = unsafe.getChar(from, MUnsafe.charArrayOffset(i));
            System.err.println(Integer.toHexString(c) + " " + c);
        }
        // for (int i = 0; i < from.length; i++) {
        // char c = unsafe.getChar(from, MUnsafe.charArrayOffset(i));
        // System.err.println(Integer.toHexString(c));
        // }


        long memorySize = MUnsafe.charArraySize(from);
        long newMemory = unsafe.allocateMemory(memorySize);

        System.err.println(from.length + " chars, length " + memorySize + " At " + newMemory);

        char[] to = new char[256];

        unsafe.copyMemory(from, MUnsafe.charArrayBaseOffset, null, newMemory, memorySize);
        unsafe.copyMemory(from, MUnsafe.charArrayBaseOffset, to, MUnsafe.charArrayBaseOffset, memorySize);

        System.err.println("copied " + to.length);
        System.err.println(new String(to));
        System.err.println("efg");

        for (int i = 0; i < memorySize; i++) {
            // char c = unsafe.getChar(newMemory, i * MUnsafe.charArrayIndexScale);
            int c = unsafe.getByte(newMemory, (long) i);
            System.err.println(Integer.toHexString((byte) c) + " " + c);
            // System.err.println(c);
        }
        System.err.println("done");

        unsafe.freeMemory(newMemory);
    }

    static class MUnsafe {
        static final Unsafe unsafe;
        public static final long charArrayBaseOffset;
        public static final long charArrayIndexScale;

        static {
            try {
                Field f = Unsafe.class.getDeclaredField("theUnsafe");
                f.setAccessible(true);
                unsafe = (Unsafe) f.get(null);
                charArrayBaseOffset = unsafe.arrayBaseOffset(char[].class);
                charArrayIndexScale = unsafe.arrayIndexScale(char[].class);
            } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        public static Unsafe getUnsafe() {
            return unsafe;
        }

        public static long charArrayOffset(int index) {
            return calculateOffset(index, charArrayBaseOffset, charArrayIndexScale);
        }

        public static long charArraySize(char[] from) {
            return from.length * charArrayIndexScale;
        }

        /**
         * The object referred to by o is an array, and the offset is an integer of the form B+N*S, where N is a valid
         * index into the array, and B and S are the values obtained by #arrayBaseOffset and #arrayIndexScale
         * (respectively) from the array's class. The value referred to is the Nth element of the array.
         **/
        public static long calculateOffset(int index, long base, long scale) {
            return (base + (index * scale));
        }

        static long toAddress(Object obj) {
            Object[] array = new Object[] {obj};
            long baseOffset = getUnsafe().arrayBaseOffset(Object[].class);
            return normalize(getUnsafe().getInt(array, baseOffset));
        }

        static Object fromAddress(long address) {
            Object[] array = new Object[] {null};
            long baseOffset = getUnsafe().arrayBaseOffset(Object[].class);
            getUnsafe().putLong(array, baseOffset, address);
            return array[0];
        }

        private static long normalize(int value) {
            if (value >= 0)
                return value;
            return (~0L >>> 32) & value;
        }


    }
}
