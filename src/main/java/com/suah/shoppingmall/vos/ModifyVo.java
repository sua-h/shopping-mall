package com.suah.shoppingmall.vos;

import com.suah.shoppingmall.dtos.UserDto;
import com.suah.shoppingmall.enums.user.ModifyResult;
import com.suah.shoppingmall.interfaces.IResult;
import com.suah.shoppingmall.utils.CryptoUtil;

public class ModifyVo implements IResult<ModifyResult> {
    private final String password;
    private final String passwordNew;
    private final String contactFirst;
    private final String contactSecond;
    private final String contactThird;
    private final String addressPost;
    private final String addressPrimary;
    private final String addressSecondary;
    private final String birthYear;
    private final String birthMonth;
    private final String birthDate;
    private final String hashedPassword;
    private final String hashedPasswordNew;

    private UserDto user;
    private ModifyResult result;

    public ModifyVo(String password, String passwordNew, String contactFirst, String contactSecond, String contactThird, String addressPost, String addressPrimary, String addressSecondary, String birthYear, String birthMonth, String birthDate) {
        this.password = password;
        this.passwordNew = passwordNew.equals("") ? password : passwordNew;
        this.contactFirst = contactFirst;
        this.contactSecond = contactSecond;
        this.contactThird = contactThird;
        this.addressPost = addressPost;
        this.addressPrimary = addressPrimary;
        this.addressSecondary = addressSecondary;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDate = birthDate;
        this.hashedPassword = CryptoUtil.Sha512.hash(this.password, null);
        this.hashedPasswordNew = CryptoUtil.Sha512.hash(this.passwordNew, null);
    }

    public String getPassword() {
        return this.password;
    }

    public String getPasswordNew() {
        return this.passwordNew;
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

    public String getBirthYear() {
        return this.birthYear;
    }

    public String getBirthMonth() {
        return this.birthMonth;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public String getHashedPassword() {
        return this.hashedPassword;
    }

    public String getHashedPasswordNew() {
        return this.hashedPasswordNew;
    }

    public UserDto getUser() {
        return this.user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    @Override
    public ModifyResult getResult() {
        return this.result;
    }

    @Override
    public String getResultName() {
        return this.result == null ? null : this.result.name();
    }

    @Override
    public void setResult(ModifyResult result) {
        this.result = result;
    }
}
