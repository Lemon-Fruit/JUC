package com.swpu.interrupted;

public class interruptedFlag {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(() -> {

            // 开始：Thread.currentThread().interrupted() 为false
            // interrupt 打断后 interrupted 复位 变为true break;
            while (!Thread.interrupted()) {

            }
            System.out.println("threadOne isInterrupted:" + Thread.currentThread().isInterrupted());
        });

        threadOne.start();

        //打断
        threadOne.interrupt();

        threadOne.join();

        System.out.println("main thread is over");
    }
}
