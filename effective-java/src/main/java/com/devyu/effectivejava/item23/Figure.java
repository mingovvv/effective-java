package com.devyu.effectivejava.item23;

public class Figure {

    enum Shape {
        RECTANGLE, CIRCLE;
    }

    private Shape shape;

    // RECTANGLE 용 필드
    private int length;
    private int width;

    // CIRCLE 용 필드
    private int radius;

    // RECTANGLE 용 생성자
    public Figure(int length, int width) {
        this.length = length;
        this.width = width;
    }

    // CIRCLE 용 생성자
    public Figure(int radius) {
        this.radius = radius;
    }

}
