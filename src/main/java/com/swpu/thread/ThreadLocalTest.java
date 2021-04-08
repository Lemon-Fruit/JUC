package com.swpu.thread;

public class ThreadLocalTest {

    static void print(String str) {
        //打印当前线程本地内存中localVariable的值
        System.out.println(str + ":" + localVariable.get());
        //清除当前线程本地内存中的localVariable的值
        //localVariable.remove();
    }

    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    public static void main(String[] args) {

        Thread threadOne = new Thread(() -> {
            localVariable.set("threadOne local variable");

            print("threadOne");

            System.out.println("threadOne remove after:" + localVariable.get());
        });

        Thread threadTwo = new Thread(() -> {
            localVariable.set("threadTwo local variable");

            print("threadTwo");
            System.out.println("threadTwo remove after:" + localVariable.get());
        });
        threadOne.start();
        threadTwo.start();
    }
}
