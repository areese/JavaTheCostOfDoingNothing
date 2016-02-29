package com.yahoo.wildwest;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

@SuppressWarnings("restriction")
public class MUnsafe {
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
     * The object referred to by o is an array, and the offset is an integer of the form B+N*S, where N is a valid index
     * into the array, and B and S are the values obtained by #arrayBaseOffset and #arrayIndexScale (respectively) from
     * the array's class. The value referred to is the Nth element of the array.
     **/
    public static long calculateOffset(int index, long base, long scale) {
        return (base + (index * scale));
    }

    public static long toAddress(Object obj) {
        Object[] array = new Object[] {obj};
        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        return normalize(unsafe.getInt(array, baseOffset));
    }

    public static Object fromAddress(long address) {
        Object[] array = new Object[] {null};
        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        unsafe.putLong(array, baseOffset, address);
        return array[0];
    }

    public static long normalize(int value) {
        if (value >= 0)
            return value;
        return (~0L >>> 32) & value;
    }


}
