package com.suah.shoppingmall.dtos;

public class UserDto {
    public static final String MODEL_NAME = "user";

    private final int index;
    private final String email;
    private final String password;
    private final String name;
    private final String contactFirst;
    private final String contactSecond;
    private final String contactThird;
    private final String addressPost;
    private final String addressPrimary;
    private final String addressSecondary;
    private final String birthYear;
    private final String birthMonth;
    private final String birthDate;
    private final int level;

    private String autoSignKey;

    public UserDto(int index, String email, String password, String name, String contactFirst, String contactSecond, String contactThird, String addressPost, String addressPrimary, String addressSecondary, int level, String birthYear, String birthMonth, String birthDate) {
        this.index = index;
        this.email = email;
        this.password = password;
        this.name = name;
        this.contactFirst = contactFirst;
        this.contactSecond = contactSecond;
        this.contactThird = contactThird;
        this.addressPost = addressPost;
        this.addressPrimary = addressPrimary;
        this.addressSecondary = addressSecondary;
        this.level = level;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDate = birthDate;
    }

    public int getIndex() {
        return this.index;
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

    public int getLevel() {
        return this.level;
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

    public String getAutoSignKey() {
        return this.autoSignKey;
    }

    public void setAutoSignKey(String autoSignKey) {
        this.autoSignKey = autoSignKey;
    }
}
