package com.devyu.effectivejava.no18;

import com.devyu.effectivejava.no18.composition.InstrumentedSet;

import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /**
         * [상속]
         *   - 메서드 호출과 달리 상속은 캡슐화를 깨트린다
         *   - 상위 class의 변경에 하위 class가 영향을 받을 수 있음
         *   - 'is-a' 관계일 때만 사용하기
         */

        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(List.of("가", "나", "다"));

        // '3'이 아닌 '6'이 출력
        // :: 상위 class인 HashSet이 addCount() 메서드가 add() 메서드를 self-use 하기때문
        System.out.println(s.getAddCount());

        /**
         * [composition::컴포지션]
         *   - 기존 클래스를 상속하는 대신, 새로운 래퍼 클래스를 만들고
         *   포워딩 class에서 private 필드로 래퍼 클래스의 인스턴스를 참조하게 하는 방법!!
         *   - 앞 단에 포워딩 역할만 하는 전달클래스가 든든하게 캡슐화를 유지시켜주네~
         *   - 부모클래스의 내부 구현방식(ex. self-use)에서 벗어나며, 심지어 부모클래스에
         *   새로운 내부 구현방식이 추가되더라도 전혀 영향을 받지 않음
         */
        HashSet<String> param = new HashSet<>();
        InstrumentedSet<String> s2 = new InstrumentedSet<>(param);
        s2.addAll(List.of("가", "나", "다", "라"));
        System.out.println(s2.getAddCount());

    }

}
