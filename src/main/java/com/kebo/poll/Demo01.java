package com.kebo.poll;

import java.util.concurrent.*;

/**
 * @description:
 * @author: kb
 * @create: 2020-11-11 21:21
 **/
//new ThreadPoolExecutor.CallerRunsPolicy()队列满了，会抛异常
    // new ThreadPoolExecutor.AbortPolicy()队列满了，哪来的谁执行，一般是main线程
    //new ThreadPoolExecutor.DiscardPolicy()队列满了，丢掉任务，不会抛异常
    //new ThreadPoolExecutor.DiscardOldestPolicy()//队列满了，尝试和最早的竞争，也不会抛出异常
public class Demo01 {
    public static void main(String[] args) {
        ExecutorService executorService = new
                ThreadPoolExecutor(2, 5, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
        try {
            for (int i = 0; i < 9; i++) {
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

        //线程池用完，程序结束，关闭线程池
    }
}

