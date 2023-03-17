package com.devyu.effectivejava.item03;

/**
 * getInstance() 메서드를 통한 싱글턴 인스턴스 접근
 */
public class Singleton2 {

    // private 필드
    private static final Singleton2 INSTANCE = new Singleton2();

    // private 생성자를 사용하여 '싱글턴' 임을 보장
    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return INSTANCE;
    }

}
