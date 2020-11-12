package com.kebo.function;

import java.util.function.Supplier;

/**
 * @description:
 * @author: kb
 * @create: 2020-11-12 19:24
 **/
public class Demo04 {
    public static void main(String[] args) {
        Supplier<String> supplier=()->{return "hello";};
        System.out.println(supplier.get());
    }
}

