package com.swpu.test;

import org.junit.Test;

/**
 * @author: Lemon-Fruit
 * @date: 2021-06-15 17:56
 */
public class ConcurrencyTest {
    private static final long count = 10000L;

    @Test
    public void CTest() throws InterruptedException {
        concurrency();
        serial();
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        //lambda 重写runnable接口
        Thread thread = new Thread(() -> {
            int a = 0;
            for (long i = 0; i < count; ++i) {
                a += 5;
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; ++i) {
            --b;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("concurrency :" + time + "ms,b=" + b);
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; ++i) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; ++i) {
            --b;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("Serial :" + time + "ms,b=" + b + ",a=" + a);
    }
}