package com.devyu.effectivejava.item29;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * [5장] - 제네릭
 * [아이템 29] - 이왕이면 제네릭 타입으로 만들라
 *
 * [요약] - 클라이언트에서 직접 형 변환을 해야하는 타입보다 제네릭 타입이 더 안전하고 쓰기 편하다. 기존 코드도 제네릭 타입으로 변경하면 클라이언트 코드에 영향이 없이도 새로운 사용자는 타입 안정성을 더 지킬 수 있다.
 */
public class Main {

    public static void main(String[] args) {

        /**
         * Object 배열로 작성하였기에 꺼내올 때 형변환이 필요하다.
         * > 런타임 오류가 발생할 수 있음.
         */
        Stack1 stack1 = new Stack1();
        stack1.push(1);
        stack1.push(2);
//        stack1.push("가"); // 컴파일 에러 발생안함... 런타임 에러 발생...ㅜ
        int pop1 = (int) stack1.pop();
        int pop2 = (int) stack1.pop();

        /**
         * 배열을 사용하는 코드를 제네릭으로 만들어보자
         */
        Stack2<String> stack2 = new Stack2<>();
        stack2.push("가");
//        stack2.push(1); // 컴파일 에러 발생...!

    }

    /**
     * 제네릭을 클래스로 작성한 Stack
     */
    static class Stack2<E> {
//        private E[] elements;
        private Object[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;

//        @SuppressWarnings("unchecked")
        public Stack2() {
//            elements = new E[DEFAULT_INITIAL_CAPACITY]; // 제네릭 E는 실체화가 불가능하니 배열로 만들 수 없다.

            /**
             * 방법1. 제네릭 배열 생성을 금지하는 제약을 우회하기
             * > Object 배열을 생성한 다음 제네릭 배열로 형 변환
             * > 컴파일러 경고 !!! -> 런타임 시, 에러가 발생할 수고 있음. 타입 안정성이 떨어짐.
             * >
             * > 가독성이 좋다.
             */
//            elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];

            /**
             * 방법2. elements 필드의 타입을 E[] -> Object[]로 바꾸기
             * > Object 배열을 생성한 다음 제네릭 배열로 형 변환
             * > 컴파일러 경고 !!! -> 런타임 시, 에러가 발생할 수고 있음. 타입 안정성이 떨어짐.
             */
            elements = new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(E e) {
            ensureCapacity();
            elements[size++] = e;
        }

        @SuppressWarnings("Unchecked")
        public E pop() {
            if (size == 0) throw new EmptyStackException();

            /**
             * 방법2를 사용하면 (E)로 형변환을 하고 경고가 뜬다.
             * E는 실체화 불가 타입이므로 컴파일러는 런타임에 이뤄지는 형변환이 안전한지 증명할 방법이 없다.
             */
            E result = (E) elements[--size];
            elements[size] = null;
            return result;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private void ensureCapacity() {
            if (elements.length == size) {
                elements = Arrays.copyOf(elements, 2 * size + 1);
            }
        }

    }

    /**
     * Object 배열로 작성한 Stack
     */
    static class Stack1 {
        private Object[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;

        public Stack1() {
            elements = new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(Object e) {
            ensureCapacity();
            elements[size++] = e;
        }

        public Object pop() {
            if (size == 0) throw new EmptyStackException();

            Object result = elements[--size];
            elements[size] = null;
            return result;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private void ensureCapacity() {
            if (elements.length == size) {
                elements = Arrays.copyOf(elements, 2 * size + 1);
            }
        }

    }

}
