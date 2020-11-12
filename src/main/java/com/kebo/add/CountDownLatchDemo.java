package com.kebo.add;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: kb
 * @create: 2020-11-11 19:31
 **/
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {

            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "Go out");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("Close Door");
//原理：countDownLatch.countDown数量减1
        //countDownLatch.await()等待计数器归零后，然后再向下执行，否则不执行
        //适用于关门操作，比如说养鸡场把所有的鸡放出来，然后在把笼子关掉
    }
}

