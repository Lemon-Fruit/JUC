package com.swpu.thread;

public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable {

        @Override
        public void run() {
            try {
                SleepUtils.second(10);
            } finally {
                //main 线程执行完毕，jvm中没有Daemon线程，虚拟机退出，DaemonRunner立即终止
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}
