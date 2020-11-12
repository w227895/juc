package com.kebo.bq;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: kb
 * @create: 2020-11-11 21:06
 **/
//同步队列和其他的BlockingQueue不一样，SynchronousQueue不存储元素，put了一个元素，
// 必须从里面先take取出来，否则不能在put进去值！
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> synchronousQueue = new SynchronousQueue();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "put 1");
            try {
                synchronousQueue.put("1");
                System.out.println(Thread.currentThread().getName() + "put 2");
                synchronousQueue.put("2");
                System.out.println(Thread.currentThread().getName() + "put 3");
                synchronousQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + synchronousQueue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + synchronousQueue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + synchronousQueue.take());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}

