package com.swpu.AB;

public class Resource {
    //资源
    private static final Object resourceA = new Object();
    private static final Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {
        //线程A
        Thread threadA = new Thread(() -> {
            try {
                //获取resourceA共享资源的监视器锁
                synchronized (resourceA) {
                    System.out.println("threadA get resourceA lock");
                    synchronized (resourceB) {
                        System.out.println("threadA get resourceB lock");
                        //线程A阻塞,并释放获取的resourceA的锁
                        System.out.println("threadA release resourceA lock");
                        resourceA.wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //线程B
        Thread threadB = new Thread(() -> {
            try {
                Thread.sleep(1000);
                synchronized (resourceA) {
                    System.out.println("threadB get resourceA lock");

                    System.out.println("threadB try get resourceB lock ...");
                    synchronized (resourceB) {
                        System.out.println("threadB get resourceB lock");
                        //线程B阻塞,并释放获取的resourceA的锁
                        System.out.println("threadB release resourceA lock");
                        resourceA.wait();
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println("main over");
    }
}
