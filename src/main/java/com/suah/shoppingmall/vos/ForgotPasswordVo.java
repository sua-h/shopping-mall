package com.suah.shoppingmall.vos;

import com.suah.shoppingmall.dtos.UserDto;
import com.suah.shoppingmall.enums.user.ForgotPasswordResult;
import com.suah.shoppingmall.interfaces.IResult;
import com.suah.shoppingmall.utils.CryptoUtil;

import javax.servlet.http.HttpServletRequest;

public class ForgotPasswordVo implements IResult<ForgotPasswordResult> {
    private final String name;
    private final String email;
    private final String contactFirst;
    private final String contactSecond;
    private final String contactThird;
    private final String hashedUa;
    private final String hashedIp;

    private ForgotPasswordResult result;

    public ForgotPasswordVo(String name, String email, String contactFirst, String contactSecond, String contactThird, HttpServletRequest request) {
        this.name = name;
        this.email = email;
        this.contactFirst = contactFirst;
        this.contactSecond = contactSecond;
        this.contactThird = contactThird;
        this.hashedUa = CryptoUtil.Sha512.hash(request.getHeader("User-Agent"), null);
        this.hashedIp = CryptoUtil.Sha512.hash(request.getRemoteAddr(), null);
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

    public String getHashedUa() {
        return this.hashedUa;
    }

    public String getHashedIp() {
        return this.hashedIp;
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
