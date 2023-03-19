package com.devyu.effectivejava.item42;

public class Test {

    void testLambda() {

        int i = 0;
        Runnable r = () -> {
            // 지역변수 재선언 불가능
            // int i = 1;
            System.out.println("testLambda() 'this' : " + this);
        };

        r.run();

    }

    void testAnonymous() {

        int i = 0;
        Runnable r = new Runnable() {
            @Override
            public void run() {
                // 지역변수 재선언 가능
                int i = 0;
                System.out.println("testAnonymous() 'this' : " + this);
            }
        };

        r.run();
    }

    void test() {
        System.out.println("'this' : " + this);
    }

}
