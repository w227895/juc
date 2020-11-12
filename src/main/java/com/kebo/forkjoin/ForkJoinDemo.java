package com.kebo.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @description:
 * @author: kb
 * @create: 2020-11-12 19:50
 **/
//如何使用forkjoin
//1.forkjoinPool通过它执行
//2.计算任务通过forkjoinPool.excute(ForkJoinTask task)
//3.计算类要继承ForkJoinTask
public class ForkJoinDemo extends RecursiveTask<Long> {
    private Long start;
    private Long end;
    private Long temp = 1000000000L;

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start < temp) {
            Long sum = 0L;
            for (Long i = start; i < end; i++) {
                sum = sum + i;
            }
            System.out.println(sum);
            return sum;
        } else {
            long middle = (start + end) / 2;
            ForkJoinDemo forkJoinDemo1 = new ForkJoinDemo(start, middle);
            forkJoinDemo1.fork();
            ForkJoinDemo forkJoinDemo2 = new ForkJoinDemo(middle + 1, end);
            forkJoinDemo2.fork();
            return forkJoinDemo1.join() + forkJoinDemo2.join();
        }
    }

    public static void main(String[] args) {
       ForkJoinDemo forkJoinDemo=new ForkJoinDemo(0L,10000_0000L);
       forkJoinDemo.compute();
    }
}

