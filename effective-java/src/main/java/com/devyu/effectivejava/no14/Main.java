package com.devyu.effectivejava.no14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        /**
         * Comparable 인터페이스의 유일한 메서드 'compareTo'
         *   - 동치성 비교 + 순서 비교
         *   - 제네릭
         *   - 알파벳, 숫자, 연대 같이 순서가 명확한 값 클래스를 작성한다면 Comparable 인터페이스를 구현할 것
         */

        /**
         *
         */

        String c = "c";
        String b = "b";
        String a = "a";


        String[] alphabet = {c, b, a};

        // [c, b, a]
        System.out.println(Arrays.toString(alphabet));

        // 정렬 - String 객체 내부적으로 Comparable 인터페이스를 구현
        Arrays.sort(alphabet);

        // [a, b, c]
        System.out.println(Arrays.toString(alphabet));
        // 역순
        // [c, b, a]
        // Arrays.sort(alphabet, Comparator.reverseOrder());

        /**
         * 'Comparator' 객체 사용하여 비교
         *   - class를 직접 수정할 수 없는 경우 사용
         *   - class에 정렬순서가 정의되어 있을 때, 다른 정렬기준으로 정렬 조건을 오버라이딩
         *
         */

        Store2 storeC = Store2.builder().enterpriseCode("c").build();
        Store2 storeB = Store2.builder().enterpriseCode("b").build();
        Store2 storeA = Store2.builder().enterpriseCode("a").build();
        List<Store2> storeList = new ArrayList<>(List.of(storeC, storeB, storeA));
        // [Store2(enterpriseCode=c, corporationCode=null, storeCode=null), Store2(enterpriseCode=b, corporationCode=null, storeCode=null), Store2(enterpriseCode=a, corporationCode=null, storeCode=null)]
        System.out.println(storeList);

//        Comparator<Store2> comp = new Comparator<>() {
//            @Override
//            public int compare(Store2 o1, Store2 o2) {
//                return o1.getEnterpriseCode().compareTo(o2.getEnterpriseCode());
//            }
//        };

//        Comparator<Store2> comp = (o1, o2) -> o1.getEnterpriseCode().compareTo(o2.getEnterpriseCode());

        Comparator<Store2> comp = Comparator.comparing(Store2::getEnterpriseCode);
        storeList.sort(comp);
        // [Store2(enterpriseCode=a, corporationCode=null, storeCode=null), Store2(enterpriseCode=b, corporationCode=null, storeCode=null), Store2(enterpriseCode=c, corporationCode=null, storeCode=null)]
        System.out.println(storeList);

        List<Store2> aa = storeList.stream()
                // 오름차순
                .sorted(Comparator.comparing(Store2::getEnterpriseCode))
                // 내림차순
//                .sorted(Comparator.comparing(Store2::getEnterpriseCode).reversed())
                // 오름차순
//                .sorted((o1, o2) -> o1.getEnterpriseCode().compareTo(o2.getEnterpriseCode()))
                // 내림차순
//                .sorted((o1, o2) -> (o1.getEnterpriseCode().compareTo(o2.getEnterpriseCode())) * -1)
                .collect(Collectors.toList());
        System.out.println(aa);

    }

}
