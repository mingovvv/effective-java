package com.devyu.effectivejava.item10;

import lombok.Builder;

public class Store {

    private String enterpriseCode;
    private String corporationCode;
    private String storeCode;

    @Builder
    public Store(String enterpriseCode, String corporationCode, String storeCode) {
        this.enterpriseCode = enterpriseCode;
        this.corporationCode = corporationCode;
        this.storeCode = storeCode;
    }

}
