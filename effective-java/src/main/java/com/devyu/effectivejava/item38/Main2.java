package com.devyu.effectivejava.item38;

import java.util.List;

public class Main2 {

    public static void main(String[] args) {

        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        List<Double> doubles = List.of(1.1, 2.2, 3.3);

        test(integers);
        test(doubles);

        test2(integers);
        test2(doubles);
    }

    private static <T extends Number> void test(List<T> list) {
        list.forEach(System.out::println);
    }

    private static void test2(List<? extends Number> list) {
        list.forEach(System.out::println);
    }



}

