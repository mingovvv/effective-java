package com.devyu.effectivejava.no10;

import lombok.Builder;

public class Store {

    private String enpterpriseCode;
    private String corporationCode;
    private String storeCode;

    @Builder
    public Store(String enpterpriseCode, String corporationCode, String storeCode) {
        this.enpterpriseCode = enpterpriseCode;
        this.corporationCode = corporationCode;
        this.storeCode = storeCode;
    }

}
