package com.devyu.effectivejava.item45;

import java.util.*;

/**
 * [7장] - 람다와 스트림
 * [아이템 45] - 스트림은 주의해서 사용하라
 *
 * [요약] - 스트림과 기본 반복 방식 중 가독성을 고려하여 선택하라.
 */
public class Main2 {

    public static void main(String[] args) {

        /**
         * 스트림 API
         *  - Java8 추가
         *  - 다량의 데이터 처리 작업을 지원(순차적/병렬적)
         *  - 스트림은 데이터 원소의 유한, 무한 시퀀스
         *  - 스트림 파이프라인은 원소들로 수행하는 연산 단계를 표현
         *    - 중단 연산 + 중단 연산 + ... + 종단 연산
         *    - 중단 연산은 한 스트림을 다른 스트림으로 변환함
         *  - 스트림은 지연 평가(Lazy evaluation) - 스트림의 평가는 종단 연산이 호출될 때 수행됨을 의미한다. 즉, Lazy Loading
         *  - Fluent API - 메서드 체이닝을 지원
         *    - 파이프 라인은 순차적으로 실행됨
         */

        List<String> lists = List.of("가나다", "나가다", "다가나");
        HashMap<String, Set<String>> groups = new HashMap<>();

        for (String word : lists) {
            /**
             * computeIfAbsent
             *  - 1. map안에 key가 있는지 찾는다.
             *  - 2-1. key가 존재하다면, key에 매핑된 value를 반환한다.
             *  - 2-2. key가 존재하지 않는다면, 파라미터로 전달된 람다 함수 객체를 실행하고 해당 value를 반환한다.
             */
            groups.computeIfAbsent(alphabetize(word), s -> new TreeSet<>()).add(word);
        }

        // {가나다=[가나다, 나가다, 다가나]}
        System.out.println(groups);


    }

    private static String alphabetize(String word) {
        char[] array = word.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }


}
