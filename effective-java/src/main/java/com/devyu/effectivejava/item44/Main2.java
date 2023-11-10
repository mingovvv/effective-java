package com.devyu.effectivejava.item44;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main2 {

    public static void main(String[] args) {

        ListFilter<String> stringFilter = (inputList, condition) -> {
            ArrayList<String> result = new ArrayList<>();
            for (String s : inputList) {
                if (condition.test(s)) {
                    result.add(s);
                }
            }
            return result;
        };

        List<String> words = List.of("apple", "banana", "orange", "grape", "melon");

        // 길이가 6 이상인 단어들을 필터링하는 람다 표현식
        Predicate<String> lengthCondition = word -> word.length() >= 6;

        List<String> filtered = stringFilter.filter(words, lengthCondition);

        System.out.println(filtered);


    }

    interface ListFilter<T> {
        List<T> filter(List<T> inputList, Predicate<T> condition);
    }

}
