package com.suah.shoppingmall.vos;

import com.suah.shoppingmall.dtos.UserDto;
import com.suah.shoppingmall.enums.user.ForgotEmailResult;

public class ForgotEmailVo {
    private final String name;
    private final String contactFirst;
    private final String contactSecond;
    private final String contactThird;

    private ForgotEmailResult result;
    private UserDto user;

    public ForgotEmailVo(String name, String contactFirst, String contactSecond, String contactThird) {
        this.name = name;
        this.contactFirst = contactFirst;
        this.contactSecond = contactSecond;
        this.contactThird = contactThird;
    }

    public String getName() {
        return this.name;
    }

    public String getContactFirst() {
        return this.contactFirst;
    }

    public String getContactSecond() {
        return this.contactSecond;
    }

    public String getContactThird() {
        return this.contactThird;
    }

    public ForgotEmailResult getResult() {
        return this.result;
    }

    public void setResult(ForgotEmailResult result) {
        this.result = result;
    }

    public UserDto getUser() {
        return this.user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
