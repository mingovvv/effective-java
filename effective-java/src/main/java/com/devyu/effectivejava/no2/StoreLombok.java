package com.devyu.effectivejava.no2;

public class StoreLombok {

    private String enterpriseCode;
    private String corporationCode;
    private String storeCode;

    public StoreLombok(String enterpriseCode, String corporationCode, String storeCode) {
        this.enterpriseCode = enterpriseCode;
        this.corporationCode = corporationCode;
        this.storeCode = storeCode;
    }

    public static Store2Builder builder() {
        return new Store2Builder();
    }

    public static class Store2Builder {

        private String enterpriseCode;
        private String corporationCode;
        private String storeCode;

        public Store2Builder() {
        }


        public Store2Builder enterpriseCode(String enterpriseCode) {
            this.enterpriseCode = enterpriseCode;
            return this;
        }

        public Store2Builder corporationCode(String corporationCode) {
            this.corporationCode = corporationCode;
            return this;
        }

        public Store2Builder storeCode(String storeCode) {
            this.storeCode = storeCode;
            return this;
        }

        public StoreLombok build() {
            return new StoreLombok(this.enterpriseCode, this.corporationCode, this.storeCode);
        }

    }

}
