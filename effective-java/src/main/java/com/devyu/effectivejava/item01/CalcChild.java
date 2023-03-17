package com.devyu.effectivejava.item01;

public class CalcChild extends Calc {

    private static final CalcChild c = new CalcChild();

    private CalcChild() {

    }

    public static CalcChild getInstance() {
        return c;
    }

}
