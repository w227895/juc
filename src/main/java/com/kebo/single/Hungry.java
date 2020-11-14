package com.kebo.single;

/**
 * @description:
 * @author: kb
 * @create: 2020-11-14 14:26
 **/
public class Hungry {
    private final static Hungry hungry = new Hungry();

    private Hungry() {
    }

    public Hungry getHungry() {
        return hungry;
    }
}

