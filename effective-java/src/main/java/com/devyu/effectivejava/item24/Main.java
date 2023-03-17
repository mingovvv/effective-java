package com.devyu.effectivejava.item24;

public class Main {

    public static void main(String[] args) {

        /**
         * nested class
         *   - 중첩 클래스
         *   - 다른 클래스 안에 정의된 클래스
         *   - 중첩 클래스는 자신을 감싼 바깥 클래스에서만 쓰여야 하며, 그 외 사용된다면
         *   탑 레벨 클래스로 빼내어 사용해야 함
         *   - 종류
         *      1. 정적 멤버 클래스
         *      2. 비정적 멤버 클래스 = 내부 클래스(inner class)
         *      3. 익명 클래스 = 내부 클래스(inner class)
         *      4. 지역 클래스 = 내부 클래스(inner class)
         */

        Calc calc = new Calc();
        String plus = Calc.Operation.PLUS;
//        A.AA aa = new A.AA();
    }

}
