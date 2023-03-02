package com.devyu.effectivejava.no1;

import org.apache.commons.lang3.StringUtils;

public class Main {
    public static void main(String[] args) {

         /*
         * [스태틱 팩터리 메서드 장점]
         * 1. 메서드 이름을 가질 수 있음
         * 2. 호출될 때마다 인스턴스를 새로 생성하지 않아도 됨
         *   - 인스턴스 통제(싱글턴, 인스턴스 불가, 동치인 인스턴스 보장 등등 활용성이 많음)
         * 3. 반환 타입의 하위 타입 객체를 반환할 수 있음
         * 4. 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있음
         * 5. 스태틱 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 됨
         */

        /*
         * [스태틱 팩터리 메서드 단점]
         *
         * 1. 상속을 하려면 public이나 protected 생성자가 필요하니 스태틱 팩터리 메서드만
         * 제공하면 하위 클래스를 만들 수 없음
         * 2. 스태틱 팩터리 메서드는 개발자가 찾기 어려움
         *   - 메서드명을 널리 알려면 컨벤션을 바탕으로 짓는 것이 좋음
         *     - from : 매개변수 하나
         *     - of : 매개변수 여러개
         *     - valueOf : from, of의 자세한 버전
         *     - instance / getInstance : 인스턴스를 반환
         *     - create / newInstance : 매번 새로운 인스턴스를 생성해서 반환
         */

        var value = Calc.add(1, 2);
        System.out.println(value);

    }
}
