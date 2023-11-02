package com.devyu.effectivejava.item30;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * [5장] - 제네릭
 * [아이템 30] - 이왕이면 제네릭 메서드로 만들라
 *
 * [요약] -
 */
public class Main {

    public static void main(String[] args) {

        /**
         * 제네릭을 사용하지 않은 메서드
         */
        int result = 0;
        Set set = union1(Set.of(1, 2, 3), Set.of("다", "라"));
//        for (Object o : set) {
//
//            int setNum = (int) o; // ClassCastException 발생
//            result += setNum;
//        }
//        System.out.println(result);

        /**
         * 제네릭을 사용한 않은 메서드
         */
//        Set<String> mixed = union2(Set.of(1, 2, 3), Set.of("다", "라")); // 컴파일 에러...!
//        System.out.println(mixed);

    }

    /**
     * 메서드 선언부의 입력 2개, 반환 1개의 원소타입 매개변수로 명시하고 메서드 안에서드 타입 매개변수만 사용하게 수정
     */
    public static <E> Set<E> union2(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    /**
     * 제네릭을 사용하지 않은 메서드
     *  - 컴파일 시, 경고 발생
     *  - 타입 안정성 보장 X
     *  - Set 객체는 컴파일 시, '타입 소거' 발생하여 타입을 동적으로 체크할 수 없음. 어떤 값이나 들어갈 수 있음.
     */
    public static Set union1(Set s1, Set s2) {
        Set result = new HashSet(s1); // [unchecked 경고가 발생...! 런타임 시, 문제가 발생할 수도 있다.] -> 타입 안정성을 보장하라.
        result.addAll(s2);
        return result;
    }

}
