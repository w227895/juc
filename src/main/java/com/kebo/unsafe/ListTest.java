package com.kebo.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @description:
 * @author: kb
 * @create: 2020-11-10 19:59
 **/

//并发修改异常java.util.ConcurrentModificationException
//1.使用vector
//2.使用Collections.synchronizedList
//3.使用copyOnWriteArrayList
public class ListTest {
    public static void main(String[] args) {
        //List<String> list =Collections.synchronizedList(new ArrayList<>());
        //List<String> list =new Vector<>();
        //copyonwrite写入时复制，  cow计算机程序涉及领域的一种优化策略
        //多个线程调用的时候，list,读取的时候固定，写入（覆盖）
        //在写入的时候避免覆盖，造成数据问题
        //CopyOnWriteArrayList比Vector 厉害在哪里 Vector使用sychorized关键字是重型锁，CopyOnWriteArrayList使用的是lock，是轻型锁
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);
            }, String.valueOf(i)).start();

        }
    }
}

