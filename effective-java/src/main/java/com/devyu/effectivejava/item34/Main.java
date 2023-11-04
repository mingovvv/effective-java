package com.devyu.effectivejava.item34;

/**
 * [6장] - 열거 타입과 애너테이션
 * [아이템 34] - int 상수 대신 열거 타입을 사용하라
 *
 * [요약] -
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(Apple.ONE.hashCode());
        System.out.println(Apple.TWO.hashCode());
        System.out.println(Apple.THREE.hashCode());

        oldObject oldObject = new oldObject();
        System.out.println(oldObject.hashCode());
        System.out.println(oldObject.hashCode());
        System.out.println(oldObject.hashCode());

        TT.PLUS.apply();
    }

    public static void test(Apple apple) {
        // Apple 열거타입 :: 컴파일타임 타입 안정성 제공
        // apple은 null, ONE, TWO, THREE 네 가지 값 중 하나임이 확실
        // 다른 타입의 값을 넘기려 하면 컴파일 오류 발생..!

    }

}

class oldObject {
    /**
     * 열거 타입을 지원하기 전
     *   - 타입 안전을 보장할 방법이 없음
     *   - 컴파일러가 에러를 발견할 수 없음
     *   - 접두어(APPLE_, BANANA_를 사용하여 이름 충돌을 방지)
     */
    public static final int APPLE_ONE = 1;
    public static final int APPLE_TWO = 2;
    public static final int APPLE_THREE = 3;

    public static final int BANANA_ONE = 1;
    public static final int BANANA_TWO = 2;
    public static final int BANANA_THREE = 3;



}

/**
 * 열거 타입
 *   - 상수 하나당 자신의 인스턴스를 하나씩 만들어 public static final 필드로 공개
 *   - 열거 타입 선언으로 만들어진 인스턴스들은 딱 하나씩만 존재함
 *   - 컴파일타임 타입 안정성 제공
 */
enum Apple {
    ONE, TWO, THREE;
}

enum Banana {
    ONE, TWO, THREE
}

enum TT {
    PLUS("+") {
        @Override
        public int apply() {
            return 0;
        }
    };

    private String simbol;

    TT(String simbol) {
        this.simbol = simbol;
    }
    public abstract int apply();
}