package com.swpu.CAS;

import sun.misc.Unsafe;

/*
运行结果：
Exception in thread "main" java.lang.ExceptionInInitializerError
Caused by: java.lang.SecurityException: Unsafe
	at jdk.unsupported/sun.misc.Unsafe.getUnsafe(Unsafe.java:97)
	at com.swpu.CAS.TestUnSafe.<clinit>(TestUnSafe.java:6)
 */
public class TestUnSafe {
    /*
        getUnsafe源码：
        if (!VM.isSystemDomainLoader(caller.getClassLoader()))
                throw new SecurityException("Unsafe");
            return theUnsafe;
        由于TestUnSafe.class是由AppClassLoader加载的，而非Bootstrap加载器，所以抛出异常
        可深入：双亲委派机制
     */
    static final Unsafe unsafe = Unsafe.getUnsafe();

    static long stateOffset;

    private final long state = 0;

    static {
        try {
            stateOffset = unsafe.objectFieldOffset(TestUnSafe.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestUnSafe test = new TestUnSafe();

        Boolean success = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(success);
    }
}
