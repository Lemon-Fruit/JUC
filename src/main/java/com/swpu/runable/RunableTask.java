package com.swpu.runable;

public class RunableTask implements Runnable {
    @Override
    public void run() {
        System.out.println("我是一个子线程");
    }

    public static void main(String[] args) {
        RunableTask task = new RunableTask();
         new Thread(task).start();
         new Thread(task).start();

    }
}
