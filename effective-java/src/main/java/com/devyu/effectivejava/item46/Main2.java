package com.devyu.effectivejava.item46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * [7장] - 람다와 스트림
 * [아이템 46] - 스트림에서는 부작용 없는 함수를 사용하라
 *
 * [요약] - 스트림을 사용할 때는 이전 단계의 결과를 받아 처리하는 순수함수를 사용해보도록
 */
public class Main2 {

    public static void main(String[] args) throws FileNotFoundException {

        /**
         * 스트림의 패러다임
         *   - 스트림은 '함수형 프로그래밍'에 기초한 패러다임
         *   - 계산을 일련의 변환(transformation)으로 재구성
         *   - 스트림의 변환 단계는 이전 단계의 결과를 받아 처리하는 순수함수 이여야 한다. -> 이 말은 즉슨, 다른 가변 상태를 참조하지 않고 함수 스스로도 다른 상태로 변경되지 아니하며 오직 '입력 값' 만이 결과에 영향을 주는 함수를 의미 하는 것
         *   - 순수함수는 side effect가 없음
         */

        /**
         * 스트림의 패러다임을 이해하지 못한 코드
         *   - 스트림 코드를 가장한 반복적 코드
         *   - 이 코드의 모든 작업은 종단 연산인 forEach() 메서드에서 일어나는데, 이 때 외부 상태('freq')를 수정하는 람다를 실행하면서 스트림 패더라임을 깨트려 버림.
         */
        HashMap<String, Long> freq = new HashMap<>();
        try (Stream<String> words = new Scanner(new File("")).tokens()) {
            words.forEach(word -> {
                freq.merge(word.toLowerCase(), 1L, Long::sum);
            });
        }

        /**
         * 스트림의 패러다임을 이해한 코드로 변경
         *   - 스트림 API를 제대로 활용한 코드
         *   - forEach() 종단 연산은 스트림API 중에 가장 '덜' 스트림 답다. -> 계산 결과를 보고하는 경우에만 사용하고 실제 연산이 들어가는 계산 로직에는 사용하지 말자.
         *   -
         */
        Map<String, Long> freq2;
        try (Stream<String> words = new Scanner(new File("")).tokens()) {
            freq2 = words
                    .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
        }


    }

}
