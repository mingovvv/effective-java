package com.devyu.effectivejava.no3;

/**
 * public 필드를 통한 싱글턴 인스턴스 접근
 */
public class Singleton1 {

    // public 필드
    public static final Singleton1 INSTANCE = new Singleton1();

    // private 생성자를 사용하여 '싱글턴' 임을 보장
    private Singleton1() {
    }

}
