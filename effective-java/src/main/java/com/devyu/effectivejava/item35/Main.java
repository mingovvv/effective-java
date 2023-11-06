package com.devyu.effectivejava.item35;

/**
 * [6장] - 열거 타입과 애너테이션
 * [아이템 35] - ordinal 메서드 대신 인스턴스 필드를 사용하라
 *
 * [요약] - 열거 타입에서 ordinal 쓰지마라
 */
public class Main {

    public static void main(String[] args) {
        /**
         * [X]
         * 열거 타입은 하나의 정수 값에 대응되며 상수 값이 몇 번째 위치인지 반환하는 ordinal 메서드를 제공한다.
         *  - 열거 타입 상수 값의 순서가 바뀌면 ordinal 메서드 값도 함께 바뀌어 클라이언트 코드에서 에러가 발생할 수 있음
         */
        System.out.println(Fruit.MELON.ordinal());

        /**
         * [O]
         * 열거 타입 상수에 연결된 값은 ordinal 메서드로 얻지 말고 인스턴스 필드에 저장해야 한다.
         */
        System.out.println(Fruit2.MELON.seq);

    }

    enum Fruit2 {
        APPLE(1), BANANA(2), ORANGE(3), MELON(4);

        private final int seq;

        Fruit2(int seq) {
            this.seq = seq;
        }

    }

    enum Fruit {
        APPLE, BANANA, ORANGE, MELON
    }

}
