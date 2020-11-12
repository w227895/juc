package com.kebo.bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: kb
 * @create: 2020-11-11 20:45
 **/
public class Test {
    public static void main(String[] args) throws InterruptedException {
       /* test1();
        test2();*/
       // test3();
        test4();
    }

    //抛出异常
    public static void test1() {
        ArrayBlockingQueue blockQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockQueue.add("a"));
        System.out.println(blockQueue.add("b"));
        System.out.println(blockQueue.add("c"));
        //Exception in thread "main" java.lang.IllegalStateException: Queue full
        //System.out.println(blockQueue.add("d"));
        System.out.println(blockQueue.element());
        System.out.println(blockQueue.remove());
        System.out.println(blockQueue.remove());
        System.out.println(blockQueue.remove());
        // java.util.NoSuchElementException抛出异常
        // System.out.println(blockQueue.remove());
    }

    //不抛出异常，有返回值
    public static void test2() {
        ArrayBlockingQueue blockQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockQueue.offer("a"));
        System.out.println(blockQueue.offer("b"));
        System.out.println(blockQueue.offer("c"));
        System.out.println(blockQueue.peek());
        //不抛出异常！，返回null
        //System.out.println(blockQueue.offer("d"));
        System.out.println(blockQueue.poll());
        System.out.println(blockQueue.poll());
        System.out.println(blockQueue.poll());
        // 不抛出异常！，返回false
        System.out.println(blockQueue.poll());
    }

    //等待阻塞，一直阻塞
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue blockQueue = new ArrayBlockingQueue<>(3);
        blockQueue.put("a");
        blockQueue.put("b");
        blockQueue.put("c");
        //一直阻塞
        //blockQueue.put("d");

        System.out.println(blockQueue.take());
        System.out.println(blockQueue.take());
        System.out.println(blockQueue.take());
        //  //一直阻塞
        System.out.println(blockQueue.take());
    }


    //等待阻塞，超时等待
    public static void test4() throws InterruptedException {
        ArrayBlockingQueue blockQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockQueue.offer("a"));
        System.out.println(blockQueue.offer("b"));
        System.out.println(blockQueue.offer("c"));
        System.out.println(blockQueue.peek());
        //不抛出异常！，阻塞两秒后退出
        System.out.println(blockQueue.offer("d"));
        System.out.println(blockQueue.poll());
        System.out.println(blockQueue.poll());
        System.out.println(blockQueue.poll());
        System.out.println(blockQueue.poll(2, TimeUnit.SECONDS));
        // 不抛出异常！，返回false
    }
}

