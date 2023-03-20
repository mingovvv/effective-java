package com.devyu.effectivejava.item46;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

    /**
     * item 46 : 스트림에서는 부작용 없는 함수를 사용하라
     */
    public static void main(String[] args) {

        List<String> list = List.of("a", "b", "c", "d", "e", "a");

        Map<String, List<String>> collect = list.stream().collect(Collectors.groupingBy(s -> s));
//        System.out.println(collect);

        Map<String, Long> collect1 = list.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
//        System.out.println(collect1);

        String string = list.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        System.out.println(string);


    }

}
