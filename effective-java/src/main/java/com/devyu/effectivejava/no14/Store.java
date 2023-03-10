package com.devyu.effectivejava.no14;

import lombok.Builder;
import lombok.ToString;

@ToString
public class Store implements Comparable<Store> {

    private String enterpriseCode;
    private String corporationCode;
    private String storeCode;

    @Builder
    public Store(String enterpriseCode, String corporationCode, String storeCode) {
        this.enterpriseCode = enterpriseCode;
        this.corporationCode = corporationCode;
        this.storeCode = storeCode;
    }

    @Override
    public int compareTo(Store o) {
        return 0;
    }

//    @Override
//    public int compareTo(Store o) {
//
//        this.corporationCode
//
//        return ;
//    }
}
