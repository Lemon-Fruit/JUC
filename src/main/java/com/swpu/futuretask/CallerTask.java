package com.swpu.futuretask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 有返回结果
 */
public class CallerTask implements Callable<String> {
    @Override
    public String call() {
        return "hello";
    }

    public static void main(String[] args) {
        //创建异步任务
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        //启动线程
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
