package com.swpu.thread;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("我是一个子线程");
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        //thread.start();
    }
}
