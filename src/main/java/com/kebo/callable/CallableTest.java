package com.kebo.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @author: kb
 * @create: 2020-11-10 21:28
 **/
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        FutureTask futureTask = new FutureTask(myThread);
        new Thread(futureTask).start();
        new Thread(futureTask).start();
        Object o = futureTask.get();
        System.out.println(o);
    }
}

class MyThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("call()");
        return "123";
    }
}
