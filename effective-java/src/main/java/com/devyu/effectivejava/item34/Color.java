package com.devyu.effectivejava.item34;

import java.util.HashMap;
import java.util.Map;

public enum Color {
    RED, GREEN, BLUE;

    private static final Map<String, Color> colorMap = new HashMap<>();

    /**
     * 코드에서 Color 열거 타입의 생성자는 colorMap에 자신의 인스턴스를 추가하려고 시도.
     * 그러나 이는 컴파일 오류를 발생시키며, 이는 열거 타입의 생성자가 실행되는 시점에 colorMap이 아직 초기화되지 않았기 때문
     *
     * 따라서 열거 타입의 생성자에서는 자신의 인스턴스를 맵에 추가하거나,
     * 같은 열거 타입의 다른 상수에 접근하는 것이 허용되지 않고 이는 컴파일 오류를 발생시키며, 이러한 제약이 없다면 런타임에 NullPointerException이 발생할 수 있음
     */
    Color() {
        // It is illegal to access static member 'colorMap' from enum constructor or instance initializer
//        colorMap.put(this.name(), this); // 컴파일 오류 발생
    }

    public static Color fromString(String color) {
        return colorMap.get(color);
    }
}

//public class Color {
//    public static final Color RED = new Color();
//    public static final Color GREEN = new Color();
//    public static final Color BLUE = new Color();
//
//    private Color() {
//        // private 생성자를 통해 외부에서 인스턴스 생성을 막습니다.
//    }
//}