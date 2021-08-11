package com.suah.shoppingmall.vos;

import com.suah.shoppingmall.enums.user.ForgotPasswordResult;
import com.suah.shoppingmall.utils.CryptoUtil;

import javax.servlet.http.HttpServletRequest;

public class ForgotPasswordContinueVo {
    private final String key;
    private final String hashedUa;
    private final String hashedIp;
    private final String hashedPassword;

    private ForgotPasswordResult result;

    public ForgotPasswordContinueVo(String key, HttpServletRequest request, String password) {
        this.key = key;
        this.hashedUa = CryptoUtil.Sha512.hash(request.getHeader("User-Agent"), null);
        this.hashedIp = CryptoUtil.Sha512.hash(request.getRemoteAddr(), null);
        this.hashedPassword = CryptoUtil.Sha512.hash(password, null);
    }

    public String getKey() {
        return this.key;
    }

    public String getHashedUa() {
        return this.hashedUa;
    }

    public String getHashedIp() {
        return this.hashedIp;
    }

    public String getHashedPassword() {
        return this.hashedPassword;
    }

    public ForgotPasswordResult getResult() {
        return this.result;
    }

    public void setResult(ForgotPasswordResult result) {
        this.result = result;
    }
}
