package com.suah.shoppingmall.services;

import com.suah.shoppingmall.dtos.UserDto;
import com.suah.shoppingmall.enums.user.LoginResult;
import com.suah.shoppingmall.enums.user.RegisterResult;
import com.suah.shoppingmall.mappers.IUserMapper;
import com.suah.shoppingmall.utils.CryptoUtil;
import com.suah.shoppingmall.vos.LoginVo;
import com.suah.shoppingmall.vos.RegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserService {
    private final IUserMapper userMapper;

    @Autowired
    public UserService(IUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public static class Config {
        public static final int AUTO_SIGN_KEY_HASH_COUNT = 10;
        public static final int AUTO_SIGN_VALID_DAYS = 7;
    }


    public static class Regex {
        public static final String EMAIL = "^(?=.{8,50}$)([0-9a-z]([_]?[0-9a-z])*?)@([0-9a-z][0-9a-z\\-]*[0-9a-z]\\.)?([0-9a-z][0-9a-z\\-]*[0-9a-z])\\.([a-z]{2,15})(\\.[a-z]{2})?$";
        public static final String NAME = "^([가-힣]{1,10})$";
        public static final String CONTACT_FIRST = "^(010|070)$";
        public static final String CONTACT_SECOND = "^([0-9]{4})$";
        public static final String CONTACT_THIRD = "^([0-9]{4})$";
        public static final String ADDRESS_POST = "^([0-9]{5})$";
        public static final String ADDRESS_PRIMARY = "^([0-9a-zA-Z가-힣\\- ]{10,100})$";
        public static final String ADDRESS_SECONDARY = "^([0-9a-zA-Z가-힣\\- ]{0,100})$";
        public static final String PASSWORD = "^([0-9a-zA-Z`~!@#$%^&*()\\-_=+\\[{\\]}\\\\|;:',<.>/?]{8,50})$";

        public static final String AUTO_SIGN_KEY = "^([0-9a-z]{128})$";

        public static final String AUTH_CODE_KEY = "^([0-9a-z]{128})$";
        public static final String AUTH_CODE = "^([0-9]{6})$";

        // TODO 생년월일 추가정보 정규화 + users DATABASE 생년월일 추가해서 수정 (NOT NULL 필요X)
        public static final String BIRTH_YEAR = "";
        public static final String BIRTH_MONTH = "";
        public static final String BIRTH_DATE = "";
    }

    public static boolean checkEmail(String email) {
        return email.matches(Regex.EMAIL);
    }

    public static boolean checkName(String name) {
        return name.matches(Regex.NAME);
    }

    public static boolean checkContactFirst(String contactFirst) {
        return contactFirst.matches(Regex.CONTACT_FIRST);
    }

    public static boolean checkContactSecond(String contactSecond) {
        return contactSecond.matches(Regex.CONTACT_SECOND);
    }

    public static boolean checkContactThird(String contactThird) {
        return contactThird.matches(Regex.CONTACT_THIRD);
    }

    public static boolean checkAddressPost(String addressPost) {
        return addressPost.matches(Regex.ADDRESS_POST);
    }

    public static boolean checkAddressPrimary(String addressPrimary) {
        return addressPrimary.matches(Regex.ADDRESS_PRIMARY);
    }

    public static boolean checkAddressSecondary(String addressSecondary) {
        return addressSecondary.matches(Regex.ADDRESS_SECONDARY);
    }

    public static boolean checkPassword(String password) {
        return password.matches(Regex.PASSWORD);
    }

    public void extendAutoSignKey(Cookie autoSignKeyCookie) {
        if (!autoSignKeyCookie.getValue().matches(Regex.AUTO_SIGN_KEY)) {
            return;
        }
        this.userMapper.updateAutoSignKeyExtended(autoSignKeyCookie.getValue(), Config.AUTO_SIGN_VALID_DAYS);
    }

    public void expireAutoSignKey(Cookie autoSignKeyCookie) {
        if (!autoSignKeyCookie.getValue().matches(Regex.AUTO_SIGN_KEY)) {
            return;
        }
        this.userMapper.updateAutoSignKeyExpired(autoSignKeyCookie.getValue());
    }


    public void login(LoginVo loginVo) {
        if (!UserService.checkEmail(loginVo.getEmail())) {
            loginVo.setResult(LoginResult.FAILURE);
            return;
        }

        UserDto user = this.userMapper.selectUser(loginVo);

        if (user == null) {
            loginVo.setResult(LoginResult.FAILURE);
            return;
        }

        if (user.getLevel() == 10) {
            loginVo.setResult(LoginResult.UNAVAILABLE);
        }

        loginVo.setResult(LoginResult.SUCCESS);
        loginVo.setUser(user);
    }

    public UserDto login(Cookie autoSignKeyCookie) {
        if (!autoSignKeyCookie.getValue().matches(Regex.AUTO_SIGN_KEY)) {
            return null;
        }

        UserDto user = this.userMapper.selectUserFromCookie(autoSignKeyCookie.getValue());

        if (user == null || user.getLevel() == 10) {
            return null;
        }
        return user;
    }

    public void putAutoSignKey(UserDto user) {
        String key = String.format("%s%s%s%f",
                user.getEmail(),
                user.getPassword(),
                new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()),
                Math.random());
        for (int i = 0; i < Config.AUTO_SIGN_KEY_HASH_COUNT; i++) {
            key = CryptoUtil.Sha512.hash(key, null);
        }
        this.userMapper.insertAutoSignKey(user.getEmail(), key, Config.AUTO_SIGN_VALID_DAYS);
        user.setAutoSignKey(key);
    }

    public void register(RegisterVo registerVo) {
        if (!UserService.checkEmail(registerVo.getEmail()) ||
                !UserService.checkName(registerVo.getName()) ||
                !UserService.checkContactFirst(registerVo.getContactFirst()) ||
                !UserService.checkContactSecond(registerVo.getContactSecond()) ||
                !UserService.checkContactThird(registerVo.getContactThird()) ||
                !UserService.checkAddressPost(registerVo.getAddressPost()) ||
                !UserService.checkAddressPrimary(registerVo.getAddressPrimary()) ||
                !UserService.checkAddressSecondary(registerVo.getAddressSecondary())) {
            registerVo.setResult(RegisterResult.FAILURE);
            return;
        }

        if (this.userMapper.selectEmailCount(registerVo.getEmail()) > 0) {
            registerVo.setResult(RegisterResult.DUPLICATE_EMAIL);
            return;
        }

        if (this.userMapper.selectContactCount(registerVo.getContactFirst(),
                registerVo.getContactSecond(),
                registerVo.getContactThird()) > 0) {
            registerVo.setResult(RegisterResult.DUPLICATE_CONTACT);
            return;
        }

        this.userMapper.insertUser(registerVo);
        registerVo.setResult(RegisterResult.SUCCESS);
    }

    public int getEmailCount(String email) {
        return this.userMapper.selectEmailCount(email);
    }

}
