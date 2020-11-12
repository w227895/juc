package com.kebo.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: kb
 * @create: 2020-11-12 19:31
 **/
public class Test {
    public static void main(String[] args) {
        User u1 = new User(1, "name1", 2);
        User u2 = new User(10, "name2", 23);
        User u3 = new User(13, "name3", 24);
        User u4 = new User(14, "name14", 25);
        List<User> users = Arrays.asList(u1, u2, u3, u4);
        users.stream().filter(u -> {
            return u.getId() % 2 == 0;
        }).filter(u -> {
            return u.getAge() > 0;
        }).map(u -> {
            return u.getName().toUpperCase();
        }).sorted((uu1, uu2) -> {
            return uu2.compareTo(uu2);
        }).limit(1).
                forEach(System.out::println);

    }
}

