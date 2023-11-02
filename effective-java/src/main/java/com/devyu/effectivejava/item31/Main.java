package com.devyu.effectivejava.item31;

import java.util.*;

/**
 * [5장] - 제네릭
 * [아이템 31] - 한정적 와일드카드를 사용해 API 유연성을 높이라
 *
 * [요약] - 유연성을 극대화하려면 원소의 생산사자 소비자용 입력 매개변수에 와일드 카드 타입을 사용하라. PECS(producer-extends, consumer-super)
 */
public class Main {

    public static void main(String[] args) {

        Stack<Number> numberStack = new Stack<>();
        Iterable<Integer> numbers = List.of(1, 2, 3, 4, 5);

        /**
         * Number와 Integer는 부모-자식 타입이지만, 제네릭 타입은 `불공변` 이므로
         * Stack<Number>를 매개변수로 받는 pushAll() 메서드의 인자로 Iterable<Integer>를 넘길 수 없다.
         *
         */
//        numberStack.pushAll(numbers); // 컴파일 에러...!!

        /**
         * 한정적 와일드카드 사용
         *  - 특별한 매개변수화 타입
         *  - <? extends E>
         *  - pushAll()의 입력 매개변수 타입은 "E의 Iterable이 아니라 E의 하위 타입의 Iterable 이어야 한다라는 것"
         */
        numberStack.pushAll2(numbers);

        /**
         * Ojbect와 Number은 부모-자식 타입이지만, 제네릭 타입은 `불공변` 이므로
         * Stack<Number>를 매개변수로 받는 pushAll() 메서드의 인자로 List<Object>를 넘길 수 없다.
         *
         */
        Stack<Number> numberStack2 = new Stack<>();
        List<Object> objs = List.of(5, 6, 7, 8, 9);
//        numberStack2.popAll(objs); // 컴파일 에러...!!

        /**
         * 한정적 와일드카드 사용
         *  - 특별한 매개변수화 타입
         *  - <? super E>
         *  - popAll()의 입력 매개변수 타입은 "E의 Iterable이 아니라 E의 상위 타입의 Iterable 이어야 한다라는 것"
         */
        numberStack2.popAll2(objs);

    }

    static class Stack<E> {
        private E[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;

        @SuppressWarnings("unchecked")
        public Stack() {

            elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(E e) {
            ensureCapacity();
            elements[size++] = e;
        }

        @SuppressWarnings("Unchecked")
        public E pop() {
            if (size == 0) throw new EmptyStackException();

            E result = elements[--size];
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

        public void pushAll(Iterable<E> source) {
            for (E e : source) {
                push(e);
            }
        }

        /**
         * 한정적 와일드카드를 통해 개선한 pushAll() 메서드
         */
        public void pushAll2(Iterable<? extends E> source) {
            for (E e : source) {
                push(e);
            }
        }

        public void popAll(Collection<E> dst) {
            while (!isEmpty()) {
                dst.add(pop());
            }
        }

        /**
         * 한정적 와일드카드를 통해 개선한 popAll() 메서드
         */
        public void popAll2(Collection<? super E> dst) {
            while (!isEmpty()) {
                dst.add(pop());
            }
        }

        public <T> void printFirst1(List<T> list) {
            if (!list.isEmpty()) {
                T item = list.get(0);
                System.out.println(item);
            }
        }

        public void printFirst2(List<?> list) {
            if (!list.isEmpty()) {
                Object o = list.get(0);
                System.out.println(o);
            }
        }

    }

}
