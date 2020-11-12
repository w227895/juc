package com.kebo.function;


import java.util.function.Function;

/**
 * @description:
 * @author: kb
 * @create: 2020-11-12 19:08
 **/
//Function 函数式接口，有一个输入参数，有一个输出
    //只要是函数型接口，可以用lambda
public class Demo01 {
    public static void main(String[] args) {
        /*Function<String,String> function = new Function<String, String>() {
            @Override
            public String apply(String o) {
                return o;
            }
        };*/
        Function<String,String> function=(str)->{return str;};
        System.out.println(function.apply("123"));
    }
}

