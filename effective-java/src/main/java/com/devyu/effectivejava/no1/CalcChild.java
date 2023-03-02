package com.devyu.effectivejava.no1;

public class CalcChild extends Calc {

    private static final CalcChild c = new CalcChild();

    private CalcChild() {

    }

    public static CalcChild getInstance() {
        return c;
    }

}
