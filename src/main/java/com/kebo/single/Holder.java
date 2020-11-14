package com.kebo.single;

/**
 * @description:
 * @author: kb
 * @create: 2020-11-14 14:33
 **/
public class Holder {
    private Holder() {

    }

    public static class InnerClass {
        private static final Holder holder = new Holder();
    }
}

