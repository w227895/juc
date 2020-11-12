package com.kebo.function;

import java.util.function.Predicate;

/**
 * @description:
 * @author: kb
 * @create: 2020-11-12 19:14
 **/
//断定型接口：有一个输入参数，返回值只能是布尔型
public class Demo02 {
    public static void main(String[] args) {
        Predicate<String> predicate=(String str)->{return false;};
        System.out.println(predicate.test("hello"));
    }
}

