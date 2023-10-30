package com.devyu.effectivejava.item26;

import java.util.*;

/**
 * 제네릭 타입
 *   - 제네릭 클래스
 *   - 제네릭 인터페이스
 */
public class Main {

    static public class Stamp {}

    static public class Coin {}

    public static void main(String[] args) {

        /**
         * 로 타입
         */
        Collection stamp = new ArrayList();
        stamp.add(new Stamp()); // 단순 경고, 컴파일 됨
        stamp.add(new Coin()); // 단순 경고, 컴파일 됨

        /**
         * 제네릭
         */
        Collection<Stamp> stamps = new ArrayList<>();
        stamps.add(new Stamp());
//        stamps.add(new Coin()); // 컴파일 에러 !!!

        /**
         * rawTypeMethod() : 로 타입을 매개변수로 가지는 메서드
         *  -> 컴파일 에러가 발생하지 않지만 타입 안정성을 잃는다
         *
         *  listObjTypeMethod() : List<Object>를 매개변수로 가지는 메서드
         *  -> 컴파일 에러가 발생하여 타입 안정성을 가짐
         *  -> List<String>은 List<Object>을 하위 타입이 아님!!!
         */
        ArrayList<String> strList = new ArrayList<>();
        rawTypeMethod(strList);
//        listObjTypeMethod(strList); // 컴파일 에러 !!!

        /**
         * 로 타입 매개변수로 작성된 메서드는 안정성이 떨어진다.
         * 컴파일은 성공했지만 런타임 시 캐스팅 에러가 발생할 수 있다.
         */
        ArrayList<String> str = new ArrayList<>();
        add(str, 15);
//        String s = str.get(0); // 런타임 에러 ㅠㅠ

        /**
         *
         */
        List<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        integers.add(1);

        // 메서드 매개변수로 `List<Object>` 사용
//        wildcard1(strings, integers); // List<String> 은 List<Object> 의 하위 타입이 아니기에 컴파일 에러 !!!

        // 메서드 매개변수로 'List' 사용
//        wildcard2(strings, integers); // 동작은 하지만 타입 안정성 없음 !!!
//        String s1 = strings.get(0); // 런타임 에러 ㅠㅠ

        // 메서드 매개변수로 '비한정적 와일드카드 타입' 사용
        wildcard3(strings, integers); // 컴파일 에러 !!!

        // 비한정적 와일드 카드 타입은 불변식을 훼손하지 않도록 설계되어 null 이외에 어떤것도 추가될 수 없다
        // 메서드 매개변수로 사용되거나 참조되어야만 한다.
        List raw = new ArrayList<>();
        raw.add(1);
        raw.add("가나다");
        List<?> wild = new ArrayList<>();
//        wild.add(1); // 컴파일 에러
//        wild.add("가나다"); // 컴파일 에러

    }

    public static void wildcard3(List<?> list1, List<?> list2) {
        list1.forEach(s -> {
            boolean contains = list2.contains(s);
        });
    }

    public static void wildcard2(List list1, List list2) {
        list1.addAll(list2);
    }

    public static void wildcard1(List<Object> list1, List<Object> list2) {
        list1.addAll(list2);
    }

    public static void add(List list, Object o) {
        list.add(o);
    }

    // 매개변수로 로 타입을 넘기는 메서드
    public static void rawTypeMethod(List list) {
        System.out.println(list.size());
    }

    // 매개변수로 List<Object> 타입을 넘기는 메서드
    public static void listObjTypeMethod(List<Object> list) {
        System.out.println(list.size());
    }

}
