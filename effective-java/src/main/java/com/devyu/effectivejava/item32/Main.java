package com.devyu.effectivejava.item32;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * [5장] - 제네릭
 * [아이템 32] - 제네릭과 가변인수를 함께 쓸 때는 신중하라
 *
 * [요약] -
 */
public class Main {

    public static void main(String[] args) {

        /**
         * 가변인수
         *  - 가변인수(varargs)는 메서드에 넘기는 인수의 개수를 클라이언트 코드에서 조절 가능
         *  - 가변인수 메서드를 호출하면 가변인수를 담기 위한 배열이 자동으로 생성됨
          */

        dangerous(List.of("가"), List.of("나"));
//
//        String[] strings = pickTwo("mingo", "devyu", "puregyu");
    }

    /**
     * 가변인수 메서드
     *  - 가변인수 메서드를 호출하면 가변인수를 담기 위한 배열이 자동으로 생성됨
     *  - 실체화 불가 타입인 제네릭으로 가변인수 매개변수 선언을 하면 컴파일러 경고가 발생
     *  - 가변인수 메서드를 호출할 때 가변인수 매개변수가 실체화 불가 타입으로 추론되면, 그 호출에 대해서도 경고를 발생
     *  - 매개변수 타입의 변수가 다른 객체를 참조하면 힙 오염이 발생함
     */
//    @SafeVarargs
    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = List.of(42);
        List<String>[] stringLists1 = stringLists;
        Object[] objects = stringLists;
        objects[0] = intList; // 힙 오염 발생 - 매개변수 타입 stringLists가 다른 객체를 참조한 것. 컴파일러가 자동 생성한 형변환이 실패할 수 있음
        String s = stringLists[0].get(0);// ClassCastException
    }

    /**
     * 제네릭 매개변수 배열의 참조를 외부로 노출한다.
     *  -> safety 하지 않음
     */
    static <T> T[] toArray(T... args) {
        return args;
    }

    static <T> T[] pickTwo(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0:
                return toArray(a, b);
            case 1:
                return toArray(a, c);
            case 2:
                return toArray(b, c);
        }
        throw new AssertionError();
    }


}
