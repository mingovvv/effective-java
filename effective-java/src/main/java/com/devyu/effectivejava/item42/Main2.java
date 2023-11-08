package com.devyu.effectivejava.item42;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.DoubleBinaryOperator;

/**
 * [7장] - 람다와 스트림
 * [아이템 42] - 익명 클래스보다는 람다를 사용하라
 *
 * [요약] - 익명 클래스는 함수형 인터페이스가 아닌 타입의 인스턴스를 만들 때만 사용하고 다른 경우에는 람다식을 사용해보자!
 */
public class Main2 {

    public static void main(String[] args) {

        List<String> words = new ArrayList<>(List.of("a", "bb", "ccc"));

        /**
         * [익명클래스]를 사용한 문자열 길이순 정렬
         *  - 코드가 너무 길기 때문에 자바는 함수형 프로그래밍에 적합하지 않았다.
         */
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        /**
         * [람다식]
         *  - Java 8에 들어서서 추상 메서드 하나만 가지고 있는 인터페이스는 특별한 의미를 인정 받아 함수형 `인터페이스`라 불려진다.
         *  - `함수형 인터페이스`의 인스턴스들은 람다식을 통해 간결하게 표현할 수 있다.
         *  - 반환 타입과 매개변수 타입이 생략된 것을 볼 수 있다. -> 컴파일러가 문맥을 보고 타입을 추론하는 것이다. 컴파일러가 타입을 추론하지 못하는 경우는 개발자가 직접 명시해주어야 한다.
         *  - `타입을 명시해야 코드가 더 명확할 때만 제외하고는 람다의 모든 매개변수 타입은 생략하자`
         *  - 제네릭과 연관지어 생각해볼 수 도 있다.
         *      - 제네릭 타입을 사용할 때 로 타입(raw type)을 사용하지 말아야 하는 이유는 컴파일러가 타입을 추론하지 못한다는 것 때문이다.
         *      - 컴파일러가 타입 추론을 못하면 람다식에서도 타입 추론이 어려워 진다. 개발자가 일일이 타입을 명시해야만 한다.
         *      - List words2 = List.of("a", "bb", "ccc"); // raw type
         *        Collections.sort(words2, (String o1, String o2) -> Integer.compare(o1.length(), o2.length())); // 타입 명시
         */
        Collections.sort(words, (String o1, String o2) -> Integer.compare(o1.length(), o2.length()));

        /**
         * [메서드 래퍼런스]
         *
         */
        Collections.sort(words, Comparator.comparingInt(String::length));

        /**
         * [default method]
         */
        words.sort(Comparator.comparingInt(String::length));

        System.out.println(Operation2.PLUS.simbol);
        System.out.println(Operation2.PLUS.apply(1, 10));

        /**
         * 그럼에도 익명클래스를 사용해야만 할 때는???
         *
         *  - 람다는 메서드나 클래스와 달리 이름도 없고 문서화도 못한다.
         *  - 코드 자체로 동작이 명확히 설명되지 않거나 줄 수가 많아지면 람다를 지양해야 한다.
         *  - 오히려 람다가 떡칠해두면 가독성이 떨어지므로 리팩토링이 필요하다.
         *  - 추상 클래스의 인스턴스르 ㄹ만들 때 람다를 쓸 수 없으니 익명 클래스를 써야한다.
         */

        /**
         *  - 람다는 자신을 참조할 수 없다. 자신으 참조하려면 익명 클래스를 써야한다.
         *      - 람다의 this는 바깥 인스턴스를 가리킨다.
         *      - 익명 클래스의 this는 익명 클래스의 인스턴스 자신을 가리킨다.
         */
        new OuterClass().print();

    }

    static class OuterClass {
        // com.devyu.effectivejava.item42.Main2$OuterClass$1@31cefde0
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(this);
            }
        };

        // com.devyu.effectivejava.item42.Main2$OuterClass@439f5b3d
        Runnable r2 = () -> System.out.println(this);

        public void print() {
            r1.run();
            r2.run();
        }
    }

    /**
     * 람다를 사용하면 열거 타입에 인스턴스 필드를 두고 접근할 수 있는 로직을 쉽게 구현할 수 있다.
     * 단순히, 각 열거 타입 상수의 동작을 람다로 구현해 생성자에 넘기고 생성자는 이 람다를 인스턴스 필드에 저장해둔다.
     *
     * 아래 코드는 열거 타입의 동작을 표현하는 람다를 DoubleBinaryOperator 인터페이스 변수에 할당한다.
     * 해당 인터페이스는 함수형 인터페이스로 Double 타입 인수 2개를 받아 Double 타입을 반환하는 인터페이스다.
     */
    enum Operation2 {
        PLUS("+", (x, y) -> x + y),
        MINUS("-", (x, y) -> x - y),
        TIMES("*", (x, y) -> x * y),
        DIVIDE("/", (x, y) -> x / y);

        final String simbol;
        final DoubleBinaryOperator operator; // 람다를 인스턴스 필드에 저장함

        @Override
        public String toString() {
            return this.simbol;
        }

        Operation2(String simbol, DoubleBinaryOperator operator) {
            this.simbol = simbol;
            this.operator = operator;
        }

        public double apply(double x, double y) {
            return operator.applyAsDouble(x, y);
        }
    }

    enum Operation {
        PLUS("+") {
            public double apply(double x, double y) {
                return x + y;
            }
        },
        MINUS("-") {
            public double apply(double x, double y) {
                return x - y;
            }
        },
        TIMES("*") {
            public double apply(double x, double y) {
                return x * y;
            }
        },
        DIVIDE("/") {
            public double apply(double x, double y) {
                return x / y;
            }
        };

        final String simbol;

        @Override
        public String toString() {
            return this.simbol;
        }

        Operation(String simbol) {
            this.simbol = simbol;
        }

        // 추상메서드 선언
        protected abstract double apply(double x, double y);

    }

}
