package com.devyu.effectivejava.no2;

public class Main {

    public static void main(String[] args) {

        /*
         * [생성자 패턴]
         * '점층적 생성자 패턴' 도 쓸 수는 있지만,
         * 매개변수 개수가 많아지면 관리하기 힘듦
         */
        Store store1 = new Store("A", "1001", "111");
        Store store2 = new Store("A", "1001");
        Store store3 = new Store("A");

        /*
         * [자바빈즈 패턴]
         * 객체 하나를 조립하려면 메서드를 여러개 호출해야 함
         *   - 객체의 일관성(consistency)가 무너진 상태
         *   - setter 메소드를 열어두면 객체가 어디서 일관성이 무너졌는지 여러명이서 코드를 관리하는 경우 추적하기 쉽지 않음
         */
        Store store4 = new Store();
        store4.setEnterpriseCode("A");
        store4.setCorporationCode("1001");
        store4.setStoreCode("11");

        /*
         * [빌더 패턴]
         * build()로 생성된 클래스는 불변이며, 메서드 체이닝을 지원함
         *
         */

        // effective java 방식
        Store store5 = new Store.Builder()
                .enterpriseCode("A")
                .corporationCode("1001")
                .storeCode("11")
                .build();

        // lombok 방식
        StoreLombok store6 = StoreLombok.builder()
                .enterpriseCode("A")
                .corporationCode("1001")
                .storeCode("11")
                .build();

    }

}