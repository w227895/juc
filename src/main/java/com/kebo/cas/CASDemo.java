package com.kebo.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: kb
 * @create: 2020-11-14 14:49
 **/
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(200);
        // 如果我们期望的值达到了，那么久更行，否则不更新
        atomicInteger.compareAndSet(200, 2021);
        System.out.println(atomicInteger.get());
    }
}

