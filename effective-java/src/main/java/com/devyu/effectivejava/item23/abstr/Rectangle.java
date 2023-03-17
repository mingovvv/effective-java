package com.devyu.effectivejava.item23.abstr;

public class Rectangle extends Figure {

    double length;
    double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }

}
