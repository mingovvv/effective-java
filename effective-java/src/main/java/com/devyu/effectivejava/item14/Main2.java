package com.devyu.effectivejava.item14;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main2 {

    public static void main(String[] args) {

        // 그냥 끄적끄적임..
        String text = "BHDSGA";

        // ===== ===== ===== ===== =====
        char[] chars = text.toCharArray();
        Arrays.sort(chars);
        String t1 = String.valueOf(chars);
        // ABDGHS
        System.out.println(t1);

        // ===== ===== ===== ===== =====
        String t2 = text.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        // ABDGHS
        System.out.println(t2);

        // ===== ===== ===== ===== =====
        String t3 = Arrays.stream(text.split(""))
                .sorted()
                .collect(Collectors.joining());
        // ABDGHS
        System.out.println(t3);

    }

}
