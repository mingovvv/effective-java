package com.devyu.effectivejava.item20;

public class Main {

    public static void main(String[] args) {

        /**
         * Java가 제공하는 다중 구현 메커니즘
         *   - Interface
         *       - 자바8 이후로 default method를 제공하여 인터페이스도 인스턴스 메서드를 구현할 수 있음
         *   - Abstract class
         *       - 추상 클래스를 구현하면 반드시 추상 클래스의 하위 클래스가 됨
         *       - 자바는 단일 상속만 지원하니, 새로운 타입을 정의하는데 제약이 있음
         */

        // 기존 클래스 위에 새로운 추상 클래스를 끼워넣기는 어려움

        A a = new A();
        a.speak();
        a.run();

//        B b = new B() {
//            @Override
//            public String speak() {
//                return null;
//            }
//
//            @Override
//            public String speak2() {
//                return null;
//            }
//
//        };

        B b = a;


    }

}
