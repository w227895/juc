package com.kebo.rw;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description:
 * @author: kb
 * @create: 2020-11-11 20:01
 **/
//读-读：可以共存
    //读-写：不能共存
    //写-写：不能共存
    //独占锁就是写锁（一次只能被一个线程占有)
    //共享锁就是读锁（多个线程可以同时占有）
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache2 myCache = new MyCache2();
        for (int i = 0; i < 6; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.put(temp + "", temp);
            }).start();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 6; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.get(temp + "");
            }).start();
        }
    }
}

class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();

    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + "写入一个" + key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "写入OK");

    }

    public void get(String key) {
        System.out.println(Thread.currentThread().getName() + "读取一个" + key);
        map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取OK");
    }
}

class MyCache2 {
    private volatile Map<String, Object> map = new HashMap<>();
    //读写锁，更加细粒度的控制
    private ReadWriteLock lock = new ReentrantReadWriteLock();


    //写入的时候，只希望同时有一个线程写
    public void put(String key, Object value) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "写入一个" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void get(String key) {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "读取一个" + key);
            map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }
}

