package com.devyu.effectivejava.item27;

import java.util.HashSet;
import java.util.Set;

/**
 * [5장] - 제네릭
 * [아이템 27] - 비검사 경고를 제거하라
 *
 * [요약] - 비검사 경고를 숨기지 않고 그대로 두면 진짜 문제를 알리는 새로운 경고가 나와도 알아차리기 어려우므로 꼭 제거해주자
 */
public class Main {

    public static void main(String[] args) {
        /**
         * [input]
         * javac effective-java/src/main/java/com/devyu/effectivejava/item27/Main.java -Xlint:unchecked -encoding UTF-8
         *
         * [output]
         * effective-java\src\main\java\com\devyu\effectivejava\item27\Main.java:15: warning: [unchecked] unchecked conversion
         *         Set<Lark> exaltation = new HashSet();
         *                                ^
         *   required: Set<Lark>
         *   found:    HashSet
         * 1 warning
         */
        Set<Lark> exaltation1 = new HashSet();

        /**
         * <> 다이아몬드 연산자
         *
         * 다이아몬드 연산자를 통한 타입 매개변수 추론
         */
        Set<Lark> exaltation2 = new HashSet<>();

        /**
         * @SuppressWarnings("unchecked")
         *
         * 경고를 제거할 수 없지만 타입 안전하다고 확신하는 경우에 사용하는 애노테이션
         */
        @SuppressWarnings("unchecked")
        Set<Lark> exaltation3 = new HashSet();

    }

    static class Lark { }

}
