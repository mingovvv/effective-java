package com.devyu.effectivejava.item02;

public class Store {

    private String enterpriseCode;
    private String corporationCode;
    private String storeCode;

    // ===== ===== ===== ===== =====
    // 생성자 패턴
    // ===== ===== ===== ===== =====

    // 매개변수가 없는 construct
    public Store() {
    }

    // 하나의 매개변수만 가지고 있는 constructor
    public Store(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    // 두개의 매개변수만 가지고 있는 constructor
    public Store(String enterpriseCode, String corporationCode) {
        this.enterpriseCode = enterpriseCode;
        this.corporationCode = corporationCode;
    }

    // 모든 매개변수를 가지고 있는 constructor
    public Store(String enterpriseCode, String corporationCode, String storeCode) {
        this.enterpriseCode = enterpriseCode;
        this.corporationCode = corporationCode;
        this.storeCode = storeCode;
    }

    // ===== ===== ===== ===== =====
    // 자바빈즈 패턴
    // ===== ===== ===== ===== =====

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    public String getCorporationCode() {
        return corporationCode;
    }

    public void setCorporationCode(String corporationCode) {
        this.corporationCode = corporationCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    // ===== ===== ===== ===== =====
    // 빌더 패턴
    // ===== ===== ===== ===== =====
    public static class Builder {

        private String enterpriseCode;
        private String corporationCode;
        private String storeCode;

        public Builder() {
        }

        public Builder enterpriseCode(String enterpriseCode) {
            return this;
        }

        public Builder corporationCode(String corporationCode) {
            return this;
        }

        public Builder storeCode(String storeCode) {
            return this;
        }

        public Store build() {
            return new Store(this);
        }

    }

    // 생성자를 private으로 선언
    private Store(Builder builder) {
        enterpriseCode = builder.enterpriseCode;
        corporationCode = builder.corporationCode;
        storeCode = builder.storeCode;
    }

}
