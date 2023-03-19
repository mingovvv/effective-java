package com.devyu.effectivejava.item26;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /**
         * 제네릭 타입
         *   - 제네릭 클래스
         *   - 제네릭 인터페이스
         */

        // 로(raw) 타입으로 선언
        List list = new ArrayList();
        list.add(1);
        list.add("일");

        System.out.println(list.get(0));
        System.out.println(list.get(1));


        List<String> strList = new ArrayList<>();
        List<Object> objList = new ArrayList<>();

        // OK
        method1(strList);
        // OK
        method1(objList);

        // error
        // 제네릭의 하위 타입 규칙
        //     - List<String>는 로(raw)타입인 List의 하위 타입
        //     - List<Object>는 하위 타입이 아님
//        method2(strList);
        // OK
        method2(objList);

        // OK
        method3(strList);
        // OK
        method3(objList);

        // OK
        method4(strList);
        // OK
        method4(objList);

    }

    public static void method1(List list) {
        System.out.println(list.size());
    }

    public static void method2(List<Object> list) {
        System.out.println(list.size());
    }

    // 비한정 와일드카드
    public static void method3(List<?> list) {
        System.out.println(list.size());
    }

    // 제네릭
    public static <T> void method4(List<T> list) {
        System.out.println(list.size());
    }

}
