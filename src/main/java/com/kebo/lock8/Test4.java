package com.kebo.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: kb
 * @create: 2020-11-10 19:09
 **/
public class Test4 {
    public static void main(String[] args) {
        Phone4 phone1 = new Phone4();
        //Phone3 phone2 = new Phone3();
        new Thread(() -> {
            phone1.sendSms();
        }, "A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            phone1.call();
        }, "B").start();
    }
}

class Phone4 {
    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendSms");
    }

    public synchronized void call() {
        System.out.println("call");
    }

}

