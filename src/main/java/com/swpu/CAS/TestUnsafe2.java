package com.swpu.CAS;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/*
使用强大的反射
 */
public class TestUnsafe2 {
    static Unsafe unsafe;

    static long stateOffset;

    private final long state = 0;

    static {
        try {
            //使用反射获取Unsafe的成员变量theUnsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");

            //设置为可存取
            field.setAccessible(true);

            //获取变量的值
            unsafe = (Unsafe) field.get(null);

            //获取state在TestUnsafe中的便宜量
            stateOffset = unsafe.objectFieldOffset(TestUnSafe.class.getDeclaredField("state"));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        TestUnsafe2 test2 = new TestUnsafe2();
        Boolean success = unsafe.compareAndSwapInt(test2, stateOffset, 0, 1);
        System.out.println(success);
    }
}