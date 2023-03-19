package com.devyu.effectivejava.item28;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /**
         * 공변(covaiant)
         *   - 함께 변하는 성질
         *   - sub가 super의 하위 타입이라면 배열 sub[]는 배열 super[]의 하위타입
         *   - 배열
         * 불공변(invariant)
         *   - type1과 type2가 있을 때, List<type1>은 List<type2>의 하위 타입도 아니고 상위 타입도 아니다
         *   - 리스트
         */

        Object[] objectArray = new Long[1];
        // runtime 시, java.lang.ArrayStoreException 발생
        objectArray[0] = "안녕하세요";

        // compile 자체가 되지 않음
//        List<Object> objectList = new ArrayList<Long>();
//        objectList.add("안녕하세요");



    }

}
