package com.devyu.effectivejava.item38;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * [6장] - 열거 타입과 애너테이션
 * [아이템 38] - 확장할 수 있는 열거 타입이 필요하면 인터페이스를 사용하라
 *
 * [요약] - 열거 타입끼리는 상속이 불가능하니 확장하고자 하면 인터페이스를 설계한 뒤 해당 인터페이스를 구현하는 열거 타입을 만들도록 하자
 */
public class Main {

    public static void main(String[] args) {

        /**
         * 열거 타입 자체는 확장할 수 없지만 인터페이스와 인터페이스를 구현하는 열거 타입을 통해 같은 효과를 낼 수 있다.
         * 클라이언트 코드에서는 해당 인터페이스를 구현한 특정 열거 타입을 만들어 사용할 수 있다.
         */

        /**
         * class 리터럴 : 한정적 타입 토큰
         * <T extends Enum<T> & Operation> : 입력 매개변수로 넘어오는 클래스가 열거 타입인 동시에 Operation 하위 타입이여야 한다는 제약
         * 열거 타입이여야 상수 원소를 순회할 수 있고 Opertion이여야 연산을 수행할 수 있음
         *
         * -> 컴파일 타임에 타입 안정성을 보장하고, 런타임에 발생할 수 있는 잠재적인 ClassCastException을 방지할 수 있음
         *
         */
        test(ExtendedOperation.class, 10, 20);


        /**
         * 한정적 와일드 카드 타입을 사용한 방법
         */
        test(Arrays.asList(ExtendedOperation.values()), 10, 20);



    }

    private static <T extends Enum<T> & Operation> void test(Class<T> opEnumType, double x, double y) {
        for (Operation op : opEnumType.getEnumConstants()) {
            System.out.println(op.apply(x, y));
        }
    }

    private static void test(Collection<? extends Operation> opList, double x, double y) {
        for (Operation op : opList) {
            System.out.println(op.apply(x, y));
        }
    }


    interface Operation {
        double apply(double x, double y);
    }

    enum ExtendedOperation implements Operation {

        EXP("^") {
            @Override
            public double apply(double x, double y) {
                return Math.pow(x, y);
            }
        },
        REMINDER("%") {
            @Override
            public double apply(double x, double y) {
                return x % y;
            }
        };

        private final String symbol;

        ExtendedOperation(String symbol) {
            this.symbol = symbol;
        }

    }

//    public interface Operation {
//        double apply(double x, double y);
//    }
//
//    public class ExtendedOperation {
//        public static final Operation EXP = new Operation() {
//            @Override
//            public double apply(double x, double y) {
//                return Math.pow(x, y);
//            }
//        };
//
//        public static final Operation REMINDER = new Operation() {
//            @Override
//            public double apply(double x, double y) {
//                return x % y;
//            }
//        };
//
//        // equals(), hashCode() 재정의 필수 -> 객체 동등성을 객체 동일성으로
//    }
    enum BasicOperation implements Operation {

        PLUS("+") {
            @Override
            public double apply(double x, double y) {
                return x + y;
            }
        },

        MINUS("-") {
            @Override
            public double apply(double x, double y) {
                return x - y;
            }
        };

        private final String symbol;

        BasicOperation(String symbol) {
            this.symbol = symbol;
        }

    }


}
