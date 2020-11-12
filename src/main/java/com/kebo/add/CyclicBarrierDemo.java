package com.kebo.add;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @description:
 * @author: kb
 * @create: 2020-11-11 19:43
 **/
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤神龙成功");
        });
        for (int i = 1; i <= 7; i++) {
            //Lambda不能操作i
            final int temp = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "收集龙珠" + temp);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}

