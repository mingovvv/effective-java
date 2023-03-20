package com.devyu.effectivejava.item45;

import java.util.HashMap;
import java.util.stream.IntStream;

public class Main {

    /**
     * item 45 : 스트림은 주의해서 사용하라
     */
    public static void main(String[] args) {

        /**
         * 람다가 등장하면서 상위 클래스의 기본 메서드를 재정의해 원하는 동작을 구현하는 '템플릿 메서드 패턴'의 사용은 줄어듦
         * java.util.function 패키지에 다양한 용도의 표준 함수형 인터페이스가 있음
         */

//        HashMap<String, String> map = new HashMap<>();
////        map.put("key", "value");
//        map.compute("key", (s, s2) -> {
//            System.out.println(s);
//            System.out.println(s2);
//            return s + s2;
//        });
//        System.out.println(map);
    }
}
