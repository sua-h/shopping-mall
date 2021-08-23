package com.suah.shoppingmall.vos;

import com.suah.shoppingmall.enums.user.ForgotPasswordContinueResult;
import com.suah.shoppingmall.interfaces.IResult;
import com.suah.shoppingmall.utils.CryptoUtil;

import javax.servlet.http.HttpServletRequest;

public class ForgotPasswordContinueVo implements IResult<ForgotPasswordContinueResult> {
    private final String key;
    private final String hashedUa;
    private final String hashedIp;
    private final String hashedPassword;

    private ForgotPasswordContinueResult result;

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

    @Override
    public ForgotPasswordContinueResult getResult() {
        return this.result;
    }

    @Override
    public String getResultName() {
        return this.result.name();
    }

    @Override
    public void setResult(ForgotPasswordContinueResult result) {
        this.result = result;
    }
}
