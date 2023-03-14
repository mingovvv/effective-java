package com.devyu.effectivejava.no17;

public class Main {

    public static void main(String[] args) {

        /**
         * instance 변경 가능성을 최소화하기
         * -> instance 내부의 값을 수정할 수 없는 '불변'클래스
         *   - 객체의 상태를 변경하는 메서드를 제공하지 않는다
         *   - 클래스를 확장할 수 없도록 한다
         *   - 모든 필드를 'final'로 선언하기
         *   - 모든 필드를 'private'로 선언하기
         */

        /**
         *  함수형 프로그래밍
         *    - 피연산자에 함수를 적용해 결과를 반환
         *    - 피연산자는 변경 없음
         *
         *   절차적 프로그래밍
         *     - 메서드에서 피연산자인 자신을 수정해 자신의 상태가 변함
         */

        Calc calcA = new Calc(1, 2);
        Calc calcB = new Calc(99, 198);

        Calc calcC = calcA.plus(calcB);

        // Calc(paramA=100, paramB=200)
        System.out.println(calcC);

        // 정적 팩터리를 사용 :: 메모리 사용량과 GC 비용 줄임
        Calc calcD = Calc.ZERO.plus(calcC);
        // Calc(paramA=100, paramB=200)
        System.out.println(calcD);

    }

}