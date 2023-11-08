package com.devyu.effectivejava.item40;

import java.util.HashSet;

/**
 * [6장] - 열거 타입과 애너테이션
 * [아이템 40] - @Override 애너테이션을 일관되게 사용하라
 *
 * [요약] - 상위 추상 클래스나 상위 인터페이스의 메서드를 재정의한다면 습관적으로 @Override 애너테이션을 달아주자
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        HashSet<Bigram> s = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                s.add(new Bigram(ch, ch));
            }
        }

        /**
         * Overriding을 실수해서 발생한 에러
         */
        System.out.println(s.size()); // 26이 아니라 260이 출력된다...!

    }

    static class Bigram {

        private final char first;
        private final char second;

        public Bigram(char first, char second) {
            this.first = first;
            this.second = second;
        }

        /**
         * overriding이 아닌 overloading을 해버림 -> 새롭게 정의한 다중 정의
         *  - Object객체의 equals()는 입력 매개변수로 Object를 가진다.
         */
//        @Override // Method does not override method from its superclass
        public boolean equals(Bigram bigram) {
            return bigram.first == this.first && bigram.second == this.second;
        }

        /**
         * overriding
         */
//        @Override
//        public boolean equals(Object obj) { }
    }

}
