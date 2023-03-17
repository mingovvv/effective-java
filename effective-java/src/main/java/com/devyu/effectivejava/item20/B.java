package com.devyu.effectivejava.item20;

public interface B {

    String speak();
    String speak2();

    default String run() {
        return "ㅌㅌ";
    }

}
