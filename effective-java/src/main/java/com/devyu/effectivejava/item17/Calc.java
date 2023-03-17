package com.devyu.effectivejava.item17;

import lombok.ToString;

// 'final' class 선언
@ToString
public final class Calc {

    public static final Calc ZERO = new Calc(0, 0);

    private final int paramA;
    private final int paramB;

    public Calc(int paramA, int paramB) {
        this.paramA = paramA;
        this.paramB = paramB;
    }

    public int getParamA() {
        return paramA;
    }

    public int getParamB() {
        return paramB;
    }

    // 인스턴스는 자신의 필드를 수정하지 않고 새로운 인스턴스에 결과를 만들어서 반환
    public Calc plus(Calc calc) {
        return new Calc(this.paramA + calc.paramA, this.paramB + calc.paramB);
    }

    // 인스턴스는 자신의 필드를 수정하지 않고 새로운 인스턴스에 결과를 만들어서 반환
    public Calc minus(Calc calc) {
        return new Calc(this.paramA - calc.paramA, this.paramB - calc.paramB);
    }

}
