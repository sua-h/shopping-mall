package com.suah.shoppingmall.vos.apis.user;

public class CountVo {
    private final String field;
    private final String value;

    public CountVo(String field, String value) {
        this.field = field;
        this.value = value;
    }

    public String getField() {
        return this.field;
    }

    public String getValue() {
        return this.value;
    }
}
