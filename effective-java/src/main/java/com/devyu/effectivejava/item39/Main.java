package com.devyu.effectivejava.item39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * [6장] - 열거 타입과 애너테이션
 * [아이템 39] - 명명 패턴보다 애너테이션을 사용하라
 *
 * [요약] - 명명 패턴은 개발자의 실수가 발생할 수 있으니 애너테이션을 사용해서 명시적으로 개발해라
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> testClass = Class.forName("com.devyu.effectivejava.item39.Main$Sample");
        Method[] methods = testClass.getDeclaredMethods();

        int tests = 0;
        int passed = 0;

        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException e) {
                    System.out.println(e + " : 실패");
                } catch (Exception e) {
                    System.out.println(e + " : 실패");
                }
            }
        }
        System.out.printf("성공 : %d, 실패 : %d", passed, tests - passed);

    }

    static class Sample2 {

        @ExceptionTest(ArithmeticException.class)
        public static void m1() {}

        @ExceptionTest(ArithmeticException.class)
        public static void m2() {}

        @ExceptionTest(ArithmeticException.class)
        public static void m3() {}

    }

    static class Sample {

        @Test
        public static void m1() {}


        public static void m2() {}

        @Test
        public static void m3() {
            throw new RuntimeException("error");
        }

        public static void m4() {}

        @Test
        public void m5() {}

        public static void m6() {}

        @Test
        public static void m7() {
            throw new RuntimeException("error");
        }

        public static void m8() {}

    }

}
