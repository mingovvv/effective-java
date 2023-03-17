package com.devyu.effectivejava.item10;

public class Main {

    public static void main(String[] args) {

        /**
         * equals 메서드는 아래의 경우 재정의하지 않는다
         *   - 각 인스턴스는 본질적으로 고유함을 보장함
         *   - 인스턴스의 동치성을 검사할 일이 없음
         */

        Store a = Store.builder()
                .enterpriseCode("mp_super")
                .corporationCode("1001")
                .storeCode("111")
                .build();

        Store b = Store.builder()
                .enterpriseCode("mp_super")
                .corporationCode("1001")
                .storeCode("111")
                .build();

        // false - Store 객체의 equals 메서드는 재정의되지 않음
        System.out.println(a.equals(b));

        /**
         * 객체 식별성이 아니라 논리적 동치성을 확인해야 할 때, equals 메서드를 재정의
         * (두 객체의 '값'을 비교하교자 할 때)
         */

        Store2 a2 = Store2.builder()
                .enterpriseCode("mp_super")
                .corporationCode("1001")
                .storeCode("111")
                .build();

        Store2 b2 = Store2.builder()
                .enterpriseCode("mp_super")
                .corporationCode("1001")
                .storeCode("111")
                .build();

        // true - Store 객체의 equals 메서드는 재정의됨
        System.out.println(a2.equals(b2));

    }

}
