package com.devyu.effectivejava.no1;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Calc {

    public Calc() {
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static Calc getInstance() {
        return CalcChild.getInstance();
    }

}
