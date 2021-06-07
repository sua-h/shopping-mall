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
    private final int level;

    public UserDto(int index, String email, String password, String name, String contactFirst, String contactSecond, String contactThird, String addressPost, String addressPrimary, String addressSecondary, int level) {
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
}
