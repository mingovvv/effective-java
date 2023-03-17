package com.devyu.effectivejava.item18;

import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSet<E> extends HashSet<E> {

    // 추가된 원소의 수
    private int addCount = 0;

    public InstrumentedHashSet() {
    }

    @Override
    public boolean add(E e) {
        // issue point!!!
        addCount++;
        return super.add(e);
    }

    /**
     * HashSet의 addAll() 메서드가 내부적으로 HashSet의 add() 메서드를 호출하기 때문에
     * add() 메서드를 재정의함에 따라 addCount++ 가 동작하게 됨
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

}
