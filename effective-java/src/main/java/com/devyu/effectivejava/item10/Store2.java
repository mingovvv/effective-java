package com.devyu.effectivejava.item10;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Store2 {

    private String enterpriseCode;
    private String corporationCode;
    private String storeCode;

    @Builder
    public Store2(String enterpriseCode, String corporationCode, String storeCode) {
        this.enterpriseCode = enterpriseCode;
        this.corporationCode = corporationCode;
        this.storeCode = storeCode;
    }

}
