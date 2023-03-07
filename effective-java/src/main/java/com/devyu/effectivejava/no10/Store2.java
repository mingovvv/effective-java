package com.devyu.effectivejava.no10;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Store2 {

    private String enpterpriseCode;
    private String corporationCode;
    private String storeCode;

    @Builder
    public Store2(String enpterpriseCode, String corporationCode, String storeCode) {
        this.enpterpriseCode = enpterpriseCode;
        this.corporationCode = corporationCode;
        this.storeCode = storeCode;
    }

}
