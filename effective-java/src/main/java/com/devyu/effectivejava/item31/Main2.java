package com.devyu.effectivejava.item31;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2 {

    static class Animal {}
    static class Bird extends Animal {}
    static class Chicken extends Bird {}

    static class MingoList<T> {
        public List<T> originList = new ArrayList<>();

        /**
         * 메서드 타입 파라미터로 전달받은 리스트안으로 데이터를 주입한다.
         *
         * List<? extends T> : 인자로 전달받을 수 있는 타입은 T 또는 T 상위클래스
         *  -> T 또는 T 상위 클래스만이 T로 선언된 originList의 데이터를 수용할 수 있으므로
         */
        public void popAll(List<? super T> list) {
            originList.forEach(l -> {
                list.add(l);
            });
        }

        /**
         * 메서드 타입 파라미터로 전달받은 리스트를 순회하며 저장한다.
         *
         * List<? extends T> : 인자로 전달받을 수 있는 타입은 T 또는 T 하위 클래스
         *   -> T 또는 T 하위 클래스만이 T로 선언된 originList에 추가 될 수 있으므로
         */
        public void pushAll(List<? extends T> list) {
            list.forEach(l -> {
                originList.add(l);
            });
        }

    }

    public static void main(String[] args) {
        // 정수형
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        // 실수형
        List<Double> doubles = List.of(2.0, 4.2, 4.9);

        // 숫자형 선언
        MingoList<Number> numbers = new MingoList<>();

        numbers.pushAll(integers);
        System.out.println(numbers.originList);

        numbers.pushAll(doubles);
        System.out.println(numbers.originList);

        List<Number> integerList2 = List.of();
        numbers.popAll(integerList2);


    }



}
