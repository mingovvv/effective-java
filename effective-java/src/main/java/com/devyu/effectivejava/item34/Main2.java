package com.devyu.effectivejava.item34;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * [6장] - 열거 타입과 애너테이션
 * [아이템 34] - int 상수 대신 열거 타입을 사용하라
 *
 * [요약] -
 */
public class Main2 {

    public static void main(String[] args) {

        /**
         * [정수 열거 타입]은 깨지기 쉽다..!
         *  - 평범한 상수를 나열한 것 뿐
         *  - 컴파일 시, 값이 클라이언트 코드에 새겨질 뿐
         *  - 상수의 값이 바뀌면 클라이언트 코드도 다시 컴파일 해야함(실행은 되지만 엉뚱한 결과가 나올 수 있음)
         */

        // APPLE와 ORANGE 타입에 따른 안전성을 보장하지 않음
        System.out.println(Old.ORANGE_BLOOD == Old.APPLE_GRANNY_SMITH);

        /**
         * [열거 타입] 등장
         *  - 클래스
         *  - 상수 하나당 자신의 인스턴스를 하나씩 만들어 public static fianl 필드로 공개 함
         *  - 열거 타입은 밖에서 접근할 수 있는 생성자를 제공하지 않으므로 final -> 클라이언트 코드에서 직접 생성 또는 확장 불가 -> 싱글톤
         *  - 컴파일 시점의 타입 안정성을 제공
         *  - 열거 타입은 각각의 namespace가 존재하여 같은 이름의 상수도 공존이 가능
         *  - 열거 타입에 새로운 상수를 추가하거나 순서를 바꿔도 다시 컴파일하지 않아도 됨. 공개되는 것이 오직 필드명 뿐이라 정수 열거 패턴과 달리 상수 값이 클라이언트 코드로 컴파일되어 각인되지 않음
         *
         */
//        System.out.println(ORANGE.BLOOD != Apple.GRANNY_SMITH); // 컴파일 에러...! 다른 열거 타입끼리 == 연산자 비교를 할 수 없음



    }

    /**
     * [상수마다 동작이 달라져야 하는 열거 타입]
     * step 2. 열거 타입에 추상 메서드를 선언하고 각 상수별 클래스 몸체를 재정의하는 방법 - 상수별 메서드 구현
     *
     *  - 새로운 상수가 추가되어도 apply를 적용해야한다는 것을 개발자로 하여금 인식시킴 -> apply 재정의 안하면 컴파일 에러가 발생
     *  - 상수별 메서드 구현을 상수별 데이터와 결합할 수 도 있다. (+)
     *  -
     */
    enum Operation2 {
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

        Operation2(String simbol) {
            this.simbol = simbol;
        }

        // 추상메서드 선언
        protected abstract double apply(double x, double y);

        private static final Map<String, Operation2> stringToEnum = Stream.of(values()).collect(Collectors.toMap(s -> s.name(), e -> e));

        public static Optional<Operation2> fromString(String symbol) {
            return Optional.ofNullable(stringToEnum.get(symbol));
        }
    }


    /**
     * [상수마다 동작이 달라져야 하는 열거 타입]
     * step 1. 동작 메서드 구현
     *
     * - 동작은 하지만 좋은 설계는 아님
     * - throw new는 실제로 도달할 일이 없지만 기술적으로 가능한 것이기 때문
     * - 깨지기 쉬운 코드임 -> 새로운 상수를 추가하면 해당 case도 추가해야 함 / case에 넣는 것을 까먹으면 컴파일은 되지만...? apply() 사용 시 에러 발생
     */
    enum Operation {
        PLUS, MINUS, TIMES, DIVIDE;

        public double apply(double x, double y) {
            switch (this) {
                case PLUS -> {
                    return x + y;
                }
                case MINUS -> {
                    return x - y;
                }
                case TIMES -> {
                    return x * y;
                }
                case DIVIDE -> {
                    return x / y;
                }
            }
            throw new AssertionError("unknown error : " + this);
        }
    }

    /**
     * [필드와 메서드를 갖는 열거 타입]
     *  - 열거 타입에 필드와 메서드를 추가하여 확장함
     *  - 불변의 데이터이므로 모든 필드는 final
     *  - 유연한 확장성을 가지고 있어서 지구(EARTH)를 추가하는 것은 한줄이면 됨
     *  - 열거 타입은 정의된 상수를 배열에 담아 제공하는 value() 메서드를 제공함
     *  - 열거 타입에서 상수를 하나 제거해도 직접 지워진 상수를 사용하지 않는 클라이언트 코드에서는 아무런 문제가 없다.
     *  - 직접 사용한 클라이언트 코드는 컴파일 에러를 발생시켜 개발자가 확인하기 용이하다.
     */
    enum Planet {
        MERCURY(3.302E+23, 2.439E6),
        VENUS(4.869E+24, 6.052E6);

        final double mass;
        final double radius;
        final double surfaceGravity;

        static final double G = 6.67300E-11;

        Planet(double mass, double radius) {
            this.mass = mass;
            this.radius = radius;
            this.surfaceGravity = G * mass / (radius * radius);
        }

        public double getMass() {
            return mass;
        }

        public double getRadius() {
            return radius;
        }

        public double getSurfaceGravity() {
            return surfaceGravity;
        }

        public double surfaceWeight(double mass) {
            return mass * surfaceGravity; // F = ma
        }
    }

    enum Orange { NAVEL, TEMPLE, BLOOD }
    enum Apple { FUJI, PIPPIN, GRANNY_SMITH }

    /**
     * [정수 열거 패턴]
     *  - 타입 안전을 보장할 방법이 없다.
     */
    static class Old {

        /**
         * 사과 상수
         *  - 자바는 namespace를 지원하지 않기 때문에 접두어(APPLE_)를 통해 이름 충돌을 방지한다.
         */
        public static final int APPLE_FUJI = 0;
        public static final int APPLE_PIPPIN = 1;
        public static final int APPLE_GRANNY_SMITH = 2;

        /**
         * 오렌지 상수
         * - 자바는 namespace를 지원하지 않기 때문에 접두어(ORANGE_)를 통해 이름 충돌을 방지한다.
         */
        public static final int ORANGE_NAVEL = 0;
        public static final int ORANGE_TEMPLE = 1;
        public static final int ORANGE_BLOOD = 2;

    }

}
