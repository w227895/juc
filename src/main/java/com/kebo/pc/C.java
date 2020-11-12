package com.kebo.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: kb
 * @create: 2020-11-10 18:57
 **/
public class C {
    public static void main(String[] args) {
        Data3 data3 = new Data3();
        new Thread(() -> {
            for (int i = 0; i <10 ; i++) {
                data3.printA();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i <10 ; i++) {
                data3.printB();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i <10 ; i++) {
                data3.printC();
            }
        }, "C").start();
    }
}

class Data3 {
    private int number = 1;
    private Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();

    public void printA() {
        lock.lock();
        try {
            while (number != 1) {
                conditionA.await();
            }
            System.out.println(Thread.currentThread().getName() + "AAA");
            number = 2;
            conditionB.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            while (number != 2) {
                conditionB.await();
            }
            System.out.println(Thread.currentThread().getName() + "BBB");
            number = 3;
            conditionC.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            while (number != 3) {
                conditionC.await();
            }
            System.out.println(Thread.currentThread().getName() + "CCC");
            number = 1;
            conditionA.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

