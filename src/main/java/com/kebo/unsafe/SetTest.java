package com.kebo.unsafe;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @description:
 * @author: kb
 * @create: 2020-11-10 20:19
 **/
//1.Collections.synchronizedSet
//2.CopyOnWriteArraySet
public class SetTest {
    public static void main(String[] args) {
        //Set<String> list = Collections.synchronizedSet(new HashSet<>());
        Set<String> list = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);
            }, String.valueOf(i)).start();

        }
    }
}

