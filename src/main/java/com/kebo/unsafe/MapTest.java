package com.kebo.unsafe;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @description:
 * @author: kb
 * @create: 2020-11-10 21:15
 **/
public class MapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0, 5));
                System.out.println(map);
            }, String.valueOf(i)).start();

        }
    }
}

