package com.kebo.lock8;

/**
 * @description:
 * @author: kb
 * @create: 2020-11-10 19:09
 **/
public class Test1 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            try {
                phone.sendSms();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            try {
                phone.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "").start();
    }
}

class Phone {
    public synchronized void sendSms() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendSms");
    }

    public synchronized void call() {
        System.out.println("call");
    }
}

