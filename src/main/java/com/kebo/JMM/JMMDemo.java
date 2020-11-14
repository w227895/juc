package com.kebo.JMM;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: kb
 * @create: 2020-11-14 10:34
 **/
public class JMMDemo {
    //不加volatile程序会死循环
    private static volatile int num = 0;
    //这个程序会一直运行，因为num的值在不同线程内是不一样的
    public static void main(String[] args) {
        new Thread(
                () -> {
                    while (num == 0) {
                    }
                }
        ).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num = 1;
        System.out.println(num);
    }
}

