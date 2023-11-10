package com.devyu.effectivejava.item43;

import java.util.HashMap;

/**
 * [7장] - 람다와 스트림
 * [아이템 43] - 람다보다는 메서드 참조를 사용하라
 *
 * [요약] - 메서드 참조는 람다의 간단명료한 대안이 될 수 있으니 메서드 참조 쪽이 짧고 명확하다면 메서드 참조를 사용하고 그렇지 않다면 람다를 쓰자!
 */
public class Main {

    public static void main(String[] args) {

        HashMap<String, Integer> m = new HashMap<>();
        m.put("사과", 1000);

        // 람다표현식
        m.merge("사과", 2000, (s, s2) -> s + s2);

        // 메서드 래퍼런스
        m.merge("사과", 2000, Integer::sum);

        /**
         * 메서드 래퍼런스 유형
         *   1. 정적 메서드 참조
         *     - ex ) Integer::parseInt         str -> Integer.parseInt(str);
         *
         *   2. 한정적(bound) 인스턴스 메서드 참조
         *     - 함수 객체가 받는 인수와 참조되는 메서드가 받는 인수가 똑같음
         *     - ex ) Instant.now()::isAfter    Instant then = Instant.now(); t-> then.isAfter();
         *
         *   3. 비한정적(unbound) 인스턴스 메서드 참조
         *     - ex ) String::toLowerCase       str -> str.toLowerCase();
         *
         *   4. 클래스 생성자 메서드 참조
         *     - ex ) HashMap<K,V>::new         () -> new HashMap<K,V>();
         *
         *   5. 배열 생성자 메서드 참조
         *     - ex ) int[]::new                len -> new int[len]
         *
         */



    }

}
