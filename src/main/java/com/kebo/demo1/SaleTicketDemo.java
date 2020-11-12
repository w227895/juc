package com.kebo.demo1;

/**
 * @description:
 * @author: kb
 * @create: 2020-11-09 22:07
 **/
public class SaleTicketDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        //lambda表达式(参数)->{代码}
        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "C").start();

    }
}

class Ticket {
    private  int number = 50;

    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出了" + (number--) + "票，剩余：" + number);
        }
    }
}

