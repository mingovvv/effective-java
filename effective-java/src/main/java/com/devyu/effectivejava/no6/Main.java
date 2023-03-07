package com.devyu.effectivejava.no6;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main {

    public static void main(String[] args) {

        System.out.println(Util.isNumCheck1("1"));
        System.out.println(Util.isNumCheck2("1"));

        long s1 = System.currentTimeMillis();
        Long sum1 = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum1 += i;
        }
        long e1 = System.currentTimeMillis();
        System.out.println("결과 : " + sum1 + ", 수행시간 : " + (e1 - s1) + "ms");
        // 결과 : 2305843005992468481, 수행시간 : 9527ms
        // 불필요한 Long type boxing으로 수행시간이 길어지며 쓸데없는 instance가 많이 생성됨
        // 의도치 않음 Auto Boxing을 주의해야 함

        long s2 = System.currentTimeMillis();
        long sum2 = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum2 += i;
        }
        long e2 = System.currentTimeMillis();
        System.out.println("결과 : " + sum1 + ", 수행시간 : " + (e2 - s2) + "ms");
        // 결과 : 2305843005992468481, 수행시간 : 607ms


    }

}
