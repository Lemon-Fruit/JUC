package com.swpu.interrupted;

public class interrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(() -> {
            for (; ; ) {
            }
        });

        threadOne.start();

        //设置中断标志
        threadOne.interrupt();

        //获取中断标志
        System.out.println("isInterrupted:" + threadOne.isInterrupted());

        //获取中断标志，如果为true 重置标志
        System.out.println("isInterrupted:" + Thread.interrupted());
        /*
        threadOne.interrupted()等价于Thread.interrupted()
        interrupted()为static方法
         */

        //获取中断标志，如果为true 重置标志
        System.out.println("isInterrupted:" + Thread.interrupted());

        //获取中断标志
        System.out.println("isInterrupted:" + threadOne.isInterrupted());

        threadOne.join();

        System.out.println("main thread is over");
    }
    /*
    result:
    isInterrupted:true
    isInterrupted:false
    isInterrupted:false
    isInterrupted:true
     */
}
