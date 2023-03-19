package com.devyu.effectivejava.item42;

import java.util.*;

public class Main {

    /**
     * item 42 :익명 클래스보다는 람다를 사용하라
     */
    public static void main(String[] args) {

        /**
         * add(), sort() 사용 시, UnsupportedOperationException 발생
         * List.of() 메서드는 ImmutableCollections 불변 클래스를 인스턴스화 하기때문에 변경을 할 수 없음
         */
        List<String> list1 = List.of("a", "f", "z", "b");

        /**
         * add() 사용 시, UnsupportedOperationException 발생
         * Arrays.asList() 메서드는 Arrays 클래스 내부클래스인 ArrayList를 통해 인스턴스화 되는데
         * 부모 역할인 추상클래스 AbstractList의 add()를 override하지 않았기에 부모인 AbstractList의 add() 메서드를 가져다 쓰게 됨
         */
        List<String> list2 = Arrays.asList("a", "f", "z", "b");


        List<String> list3 = new ArrayList<>();
        list3.add("a");
        list3.add("f");
        list3.add("z");
        list3.add("b");


        /**
         * 익명클래스
         *   - 코드가 길어져 함수형 프로그래밍에 적합하지 않음
         */
        Collections.sort(list3, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        /**
         * 람다표현식
         *   - 자바8에서 등장한 문법
         *   - 단 한개의 추상메서드를 가진 메서드를 함수형 인터페이스라하며 람다식을 사용해 인스턴스화 할 수 있음
         *   - 매개변수 타입, 반환 타입은 컴파일러가 추론함
         */
        Collections.sort(list3, (o1, o2) -> o1.compareTo(o2));

        /**
         * 메서드 래퍼런스
         */
        Collections.sort(list3, String::compareTo);

        /**
         * List 인터페이스에 추가된 sort메서드 사용
         *   - 자바8
         */
        list3.sort(String::compareTo);

        /**
         * 익명클래스와 람다표현식의 차이점
         *   1. this의 target
         *     - 람다는 자신을 참조할 수 없기 때문에 람다의 this는 바깥 인스턴스를 의미한다.
         *     - 익명클래스는 자신의 인스턴스를 가리킨다.
         *   2. 지역변수의 재선언 가능
         *     - 람다에서는 불가능하며 익명클래스의 경우 가능하다.
         */
        Test t = new Test();
        t.testAnonymous();
        t.testLambda();
        t.test();

    }

}
