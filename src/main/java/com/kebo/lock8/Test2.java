package com.kebo.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: kb
 * @create: 2020-11-10 19:09
 **/
public class Test2 {
    public static void main(String[] args) {
        Phone2 phone = new Phone2();
        Phone2 phone2 = new Phone2();
        new Thread(() -> {
            phone.sendSms();
        }, "A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            phone2.call();
        }, "B").start();
    }
}

class Phone2 {
    public synchronized void sendSms() {
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

    public void hello() {
        System.out.println("hello");
    }
}

