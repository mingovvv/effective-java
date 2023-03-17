package com.devyu.effectivejava.item03;

public class Main {

    public static void main(String[] args) {

        Singleton1 instance1_1 = Singleton1.INSTANCE;
        Singleton1 instance1_2 = Singleton1.INSTANCE;

        // true
        System.out.println(instance1_1 == instance1_2);

        Singleton2 instance2_1 = Singleton2.getInstance();
        Singleton2 instance2_2 = Singleton2.getInstance();

        // true
        System.out.println(instance2_1 == instance2_2);

        Singleton3 instance3_1 = Singleton3.INSTANCE;
        Singleton3 instance3_2 = Singleton3.INSTANCE;

        // true
        System.out.println(instance3_1 == instance3_2);

    }

}
