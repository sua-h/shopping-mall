package com.suah.shoppingmall.vos.user;

import com.suah.shoppingmall.enums.user.ForgotPasswordResult;
import com.suah.shoppingmall.interfaces.IResult;

public class ForgotPasswordVo implements IResult<ForgotPasswordResult> {
    private final String name;
    private final String email;
    private final String contactFirst;
    private final String contactSecond;
    private final String contactThird;

    private ForgotPasswordResult result;

    public ForgotPasswordVo(String name, String email, String contactFirst, String contactSecond, String contactThird) {
        this.name = name;
        this.email = email;
        this.contactFirst = contactFirst;
        this.contactSecond = contactSecond;
        this.contactThird = contactThird;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
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

    @Override
    public ForgotPasswordResult getResult() {
        return this.result;
    }

    @Override
    public String getResultName() {
        return this.result.name();
    }

    @Override
    public void setResult(ForgotPasswordResult result) {
        this.result = result;
    }
}
