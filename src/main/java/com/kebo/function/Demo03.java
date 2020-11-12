package com.kebo.function;

import java.util.function.Consumer;

/**
 * @description:
 * @author: kb
 * @create: 2020-11-12 19:20
 **/
//consumer消费型接口：只有输入，没有返回值
public class Demo03 {
    public static void main(String[] args) {
        /*Consumer<String> consumer=new Consumer<String>() {
            @Override
            public void accept(String o) {
                System.out.println(o);
            }
        };*/
        Consumer<String> consumer=(String o)->{System.out.println(o);};
        consumer.accept("helo");
    }
}

