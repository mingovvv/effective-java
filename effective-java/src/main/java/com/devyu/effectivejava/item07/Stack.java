package com.devyu.effectivejava.item07;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 4;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    /**
     * GC는 객체 참조 하나를 살려두면 그 객체뿐 아니라 그 객체가 참조하는
     * 모든 객체를 회수해 가지 못한다.
     */
    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        // 다 쓴 참조 해제
        elements[size] = null;
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }


}
