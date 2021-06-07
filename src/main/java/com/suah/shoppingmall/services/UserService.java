package com.suah.shoppingmall.services;

import com.suah.shoppingmall.dtos.UserDto;
import com.suah.shoppingmall.interfaces.LoginResult;
import com.suah.shoppingmall.mappers.IUserMapper;
import com.suah.shoppingmall.vos.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final IUserMapper userMapper;

    @Autowired
    public UserService(IUserMapper userMapper) {
        this.userMapper = userMapper;
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
    }

    public static boolean checkEmail(String email) { return email.matches(Regex.EMAIL); }

    public static boolean checkName(String name) { return name.matches(Regex.NAME); }

    public static boolean checkContactFirst(String contactFirst) { return contactFirst.matches(Regex.CONTACT_FIRST); }

    public static boolean checkContactSecond(String contactSecond) { return contactSecond.matches(Regex.CONTACT_SECOND); }

    public static boolean checkContactThird(String contactThird) { return contactThird.matches(Regex.CONTACT_THIRD); }

    public static boolean checkAddressPost(String addressPost) { return addressPost.matches(Regex.ADDRESS_POST); }

    public static boolean checkAddressPrimary(String addressPrimary) { return addressPrimary.matches(Regex.ADDRESS_PRIMARY); }

    public static boolean checkAddressSecondary(String addressSecondary) { return addressSecondary.matches(Regex.ADDRESS_SECONDARY); }

    public static boolean checkPassword(String password) { return password.matches(Regex.PASSWORD); }



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


}
