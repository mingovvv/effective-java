package com.devyu.effectivejava.no6;

import java.util.regex.Pattern;

public class Util {

    // '불변'의 Pattern 인스턴스를 생성해서 재활용 함
    private static final Pattern numberPattern = Pattern.compile("(^[0-9]*$)");

    private Util() {

    }

    // String.matches 메서드는 해당 메서드가 호출될 때마다 내부적으로
    // 'Pattern' instance가 생성되어 GC의 대상이 됨
    public static boolean isNumCheck1(String s) {
        return s.matches("(^[0-9]*$)");
    }

    // 불변의 Pattern 객체 instance를 맴버변수에 캐싱해두고 해당 instance를 재활용 함
    public static boolean isNumCheck2(String s) {
        return numberPattern.matcher(s).matches();
    }

}
