package com.devyu.effectivejava.item11;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        /**
         * Object 명세서
         *
         *   - equals 비교에 사용되는 정보가 변경되지 않았다면
         *   애플리케이션이 실행되는 동안 그 객체의 hashCode 메서드는 일관성을 지님
         *
         *   - equals 가 두 객체를 같다고 판단했다면, 두 객체의 hashCode는
         *   같은 값을 반환해야함
         *
         *   - equals 가 두 객체를 다르다고 판단했더라고, 두 객체의 hashCode는
         *   서로 다른 값을 반환할 필요는 없다. 하지만 해시테이블의 성능을 위해서
         *   다른 값을 반환해야함
         *
         */
        Store s = Store.builder().build();

        // 동일한 hashCode
        System.out.println(s.hashCode());
        System.out.println(s.hashCode());
        System.out.println(s.hashCode());
        System.out.println(s.hashCode());
        System.out.println(s.hashCode());

        // ===== ===== ===== ===== =====

        Store a1 = Store.builder()
                .enterpriseCode("mp_super")
                .corporationCode("1001")
                .storeCode("111")
                .build();

        Store b1 = Store.builder()
                .enterpriseCode("mp_super")
                .corporationCode("1001")
                .storeCode("111")
                .build();

        // => [equals 재정의 X]
        // 'a1' 와 'b1' instance는 물리적으로 다르나 논리적으로 같은 instance
        // 두 instance는 각기 다른 hashCode를 지님
        System.out.println(a1.hashCode());
        System.out.println(b1.hashCode());

        // => [equals 재정의 X]
        // 논리적으로 동치인 2개의 instance를 각각 'put()' 과 'get()' 메서드를 사용했을때,
        // 'hashCode'를 재정의하지 않았기 때문에 논리적으로 동치인 2개의 instance는 서로 다른 'hashCode'를 지님
        // 그 결과로 'get()' 메서드는 다른 hash bucket에 가서 객체를 찾다가 찾지 못하고 null 반환
        HashMap<Store, String> test1 = new HashMap<>();
        test1.put(Store.builder().enterpriseCode("test1").build(), "테스트");
        // 결과 : null
        System.out.println(test1.get(Store.builder().enterpriseCode("test1").build()));

        // ===== ===== ===== ===== =====

        Store2 a2 = Store2.builder()
                .enterpriseCode("mp_super")
                .corporationCode("1001")
                .storeCode("111")
                .build();

        Store2 b2 = Store2.builder()
                .enterpriseCode("mp_super")
                .corporationCode("1001")
                .storeCode("111")
                .build();

        // 'a2' 와 'b2' instance는 물리적으로 다르나 논리적으로 같은 instance
        // => [equals 재정의 O / hashCode 재정의 O]
        // 두 instance는 동일한 hashCode를 지님
        System.out.println(a2.hashCode());
        System.out.println(b2.hashCode());

        // => [equals / hashCode 재정의 O]
        // 논리적으로 동치인 2개의 instance를 각각 'put()' 과 'get()' 메서드를 사용했을때,
        // 'hashCode'를 재정의 하였기 때문에 논리적으로 동치인 2개의 instance는 서로 같은 'hashCode'를 지님
        // 그 결과로 'get()' 메서드는 같은 hash bucket에 가서 객체를 찾아내고 '테스트' String 을 반환
        HashMap<Store2, String> test2 = new HashMap<>();
        test2.put(Store2.builder().enterpriseCode("test1").build(), "테스트");
        // 결과 : 테스트
        System.out.println(test2.get(Store2.builder().enterpriseCode("test1").build()));

    }

}
