package com.swpu.AB;

public class WaitNotifyInterrupt {
    static final Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            try {
                System.out.println("---begin---");
                synchronized (obj) {
                    obj.wait();
                }
                System.out.println("----end----");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();

        Thread.sleep(1000);

        System.out.println("---begin interrupt threadA---");

        threadA.interrupt();

        System.out.println("---end interrupt threadA---");
    }
}
