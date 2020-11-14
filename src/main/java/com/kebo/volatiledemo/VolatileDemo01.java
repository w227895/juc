package com.kebo.volatiledemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: kb
 * @create: 2020-11-14 10:45
 **/
public class VolatileDemo01 {
    //volatile不保证原子性，所以num结果肯定不是20000
    //private volatile static int num = 0;
    private volatile static AtomicInteger num = new AtomicInteger();

    public static void add() {
        //num++;
        num.getAndIncrement();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + num);

    }
}

