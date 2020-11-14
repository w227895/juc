package com.kebo.single;

/**
 * @description:
 * @author: kb
 * @create: 2020-11-14 14:27
 **/
public class LazyHungry {
    private LazyHungry() {

    }

    private volatile static LazyHungry lazyHungry;

    public static LazyHungry getInstance() {
        if (lazyHungry == null) {
            synchronized (LazyHungry.class) {
                if (lazyHungry == null) {
                    return new LazyHungry();
                }
            }
        }
        return lazyHungry;
    }
}

