package com.suah.shoppingmall.vos;

import com.suah.shoppingmall.enums.user.RegisterResult;
import com.suah.shoppingmall.utils.CryptoUtil;

public class RegisterVo {
    private final String email;
    private final String password;
    private final String name;
    private final String contactFirst;
    private final String contactSecond;
    private final String contactThird;
    private final String addressPost;
    private final String addressPrimary;
    private final String addressSecondary;
    private final String hashedPassword;

    private RegisterResult result;

    public RegisterVo(String email, String password, String name, String contactFirst, String contactSecond, String contactThird, String addressPost, String addressPrimary, String addressSecondary) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.contactFirst = contactFirst;
        this.contactSecond = contactSecond;
        this.contactThird = contactThird;
        this.addressPost = addressPost;
        this.addressPrimary = addressPrimary;
        this.addressSecondary = addressSecondary;
        this.hashedPassword = CryptoUtil.Sha512.hash(password, null);
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
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

    public String getAddressPost() {
        return this.addressPost;
    }

    public String getAddressPrimary() {
        return this.addressPrimary;
    }

    public String getAddressSecondary() {
        return this.addressSecondary;
    }

    public String getHashedPassword() {
        return this.hashedPassword;
    }

    public RegisterResult getResult() {
        return this.result;
    }

    public void setResult(RegisterResult result) {
        this.result = result;
    }
}
