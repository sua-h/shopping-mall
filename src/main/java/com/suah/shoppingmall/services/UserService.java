package com.suah.shoppingmall.services;

import com.suah.shoppingmall.dtos.UserDto;
import com.suah.shoppingmall.enums.user.*;
import com.suah.shoppingmall.mappers.IUserMapper;
import com.suah.shoppingmall.utils.CryptoUtil;
import com.suah.shoppingmall.vos.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserService {
    private final IUserMapper userMapper;
    private final JavaMailSender mailSender;

    @Autowired
    public UserService(IUserMapper userMapper, JavaMailSender mailSender) {
        this.userMapper = userMapper;
        this.mailSender = mailSender;
    }

    public static class Config {
        public static final int AUTO_SIGN_KEY_HASH_COUNT = 10;
        public static final int AUTO_SIGN_VALID_DAYS = 7;
    }


    public static class Regex {
        public static final String EMAIL = "^(?=.{8,50}$)([0-9a-z]([_]?[0-9a-z])*?)@([0-9a-z][0-9a-z\\-]*[0-9a-z]\\.)?([0-9a-z][0-9a-z\\-]*[0-9a-z])\\.([a-z]{2,15})(\\.[a-z]{2})?$";
        public static final String NAME = "^([가-힣]{1,10})$";
        public static final String CONTACT_FIRST = "^(010|011|016|017|018|019)$";
        public static final String CONTACT_SECOND = "^([0-9]{4})$";
        public static final String CONTACT_THIRD = "^([0-9]{4})$";
        public static final String ADDRESS_POST = "^([0-9]{5})$";
        public static final String ADDRESS_PRIMARY = "^([0-9a-zA-Z가-힣\\- ]{10,100})$";
        public static final String ADDRESS_SECONDARY = "^([0-9a-zA-Z가-힣\\- ]{0,100})$";
        public static final String PASSWORD = "^([0-9a-zA-Z`~!@#$%^&*()\\-_=+\\[{\\]}\\\\|;:',<.>/?]{8,50})$";

        public static final String AUTO_SIGN_KEY = "^([0-9a-z]{128})$";

        public static final String AUTH_CODE_KEY = "^([0-9a-z]{128})$";
        public static final String AUTH_CODE = "^([0-9]{6})$";

        public static final String BIRTH_YEAR = "^(?:[0-9]{4}|)$";
        public static final String BIRTH_MONTH = "^(?:(0[1-9]|1[0-2])|)$";
        public static final String BIRTH_DATE = "^(?:(0[1-9]|[1-2][0-9]|3[0-1])|)$";
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

    public static boolean checkBirthYear(String birthYear) {
        return birthYear.matches(Regex.BIRTH_YEAR);
    }

    public static boolean checkBirthMonth(String birthMonth) {
        return birthMonth.matches(Regex.BIRTH_MONTH);
    }

    public static boolean checkBirthDate(String birthDate) {
        return birthDate.matches(Regex.BIRTH_DATE);
    }

    public static boolean checkPassword(String password) {
        return password.matches(Regex.PASSWORD);
    }

    public static String getTempPassword(int size) {
        char[] charSet = new char[]{
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                '~', '!', '@', '#', '$', '%', '^', '&', '*'
        };

        StringBuffer stringBuffer = new StringBuffer();
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.setSeed(new Date().getTime());

        int idx = 0;
        int len = charSet.length;
        for (int i = 0; i < size; i++) {
            idx = secureRandom.nextInt(len);
            stringBuffer.append(charSet[idx]);
        }

        return stringBuffer.toString();
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
                !UserService.checkAddressSecondary(registerVo.getAddressSecondary()) ||
                !UserService.checkBirthYear(registerVo.getBirthYear()) ||
                !UserService.checkBirthMonth(registerVo.getBirthMonth()) ||
                !UserService.checkBirthDate(registerVo.getBirthDate())) {
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

    public void modify(ModifyVo modifyVo) {
        if (!UserService.checkPassword(modifyVo.getPassword()) ||
                !UserService.checkPassword(modifyVo.getPasswordNew()) ||
                !UserService.checkContactFirst(modifyVo.getContactFirst()) ||
                !UserService.checkContactSecond(modifyVo.getContactSecond()) ||
                !UserService.checkContactThird(modifyVo.getContactThird()) ||
                !UserService.checkAddressPost(modifyVo.getAddressPost()) ||
                !UserService.checkAddressPrimary(modifyVo.getAddressPrimary()) ||
                !UserService.checkAddressSecondary(modifyVo.getAddressSecondary()) ||
                !UserService.checkBirthYear(modifyVo.getBirthYear()) ||
                !UserService.checkBirthMonth(modifyVo.getBirthMonth()) ||
                !UserService.checkBirthDate(modifyVo.getBirthDate())) {
            modifyVo.setResult(ModifyResult.FAILURE);
            return;
        }

        if (!modifyVo.getUser().getPassword().equals(modifyVo.getHashedPassword())) {
            modifyVo.setResult(ModifyResult.INVALID_PASSWORD);
            return;
        }

        if ((!modifyVo.getUser().getContactFirst().equals(modifyVo.getContactFirst()) &&
                !modifyVo.getUser().getContactSecond().equals(modifyVo.getContactSecond()) &&
                !modifyVo.getUser().getContactThird().equals(modifyVo.getContactThird())) &&
                this.userMapper.selectContactCount(
                        modifyVo.getContactFirst(),
                        modifyVo.getContactSecond(),
                        modifyVo.getContactThird()) > 0) {
            modifyVo.setResult(ModifyResult.DUPLICATE_CONTACT);
            return;
        }

        this.userMapper.updateUser(modifyVo);
        modifyVo.setResult(ModifyResult.SUCCESS);
    }

    public void findEmail(ForgotEmailVo forgotEmailVo) {
        if (!UserService.checkName(forgotEmailVo.getName()) ||
                !UserService.checkContactFirst(forgotEmailVo.getContactFirst()) ||
                !UserService.checkContactSecond(forgotEmailVo.getContactSecond()) ||
                !UserService.checkContactThird(forgotEmailVo.getContactThird())) {
            forgotEmailVo.setResult(ForgotEmailResult.FAILURE);
            return;
        }

        UserDto user = this.userMapper.selectEmail(forgotEmailVo);

        if (user == null) {
            forgotEmailVo.setResult(ForgotEmailResult.FAILURE);
            return;
        }

        forgotEmailVo.setResult(ForgotEmailResult.SUCCESS);
        forgotEmailVo.setUser(user);
    }

    public void findPassword(ForgotPasswordVo forgotPasswordVo) throws MessagingException {
        if (!UserService.checkName(forgotPasswordVo.getName()) ||
                !UserService.checkEmail(forgotPasswordVo.getEmail()) ||
                !UserService.checkContactFirst(forgotPasswordVo.getContactFirst()) ||
                !UserService.checkContactSecond(forgotPasswordVo.getContactSecond()) ||
                !UserService.checkContactThird(forgotPasswordVo.getContactThird())) {
            forgotPasswordVo.setResult(ForgotPasswordResult.FAILURE);
            return;
        }

        UserDto user = this.userMapper.selectPassword(forgotPasswordVo);

        if (user == null) {
            forgotPasswordVo.setResult(ForgotPasswordResult.FAILURE);
            return;
        }


        int size = (int) ((Math.random() * (16 - 10)) + 10);

        final String tempPassword = getTempPassword(size);
        System.out.println(tempPassword);

        String hashedTempPassword = CryptoUtil.Sha512.hash(tempPassword, null);

        MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
        mimeMessageHelper.setTo(user.getEmail());
        mimeMessageHelper.setSubject(String.format("%s%s%s", "[suavité] ", user.getName(), "님의 임시 비밀번호입니다."));
        mimeMessageHelper.setText(String.format("%s<br>%s<br>%s%s%s<br>%s",
                "<h1>[suavite]  임시 비밀번호 안내</h1>",
                "<p>회원님의 비밀번호 재설정 요청이 있어 임시 비밀번호를 보내드립니다. 로그인 시 아래 임시 비밀번호를 이용해주시고, 비밀번호 변경을 권장드립니다.</p>",
                "<h3>", tempPassword, "</h3>",
                "<p>비밀번호를 요청한 적 없는 경우 해당 메일을 폐기하시거나 고객센터로 문의 바랍니다.</p>"), true);

        mimeMessageHelper.setFrom("admin@suavite.com");
        this.mailSender.send(mimeMessage);

        forgotPasswordVo.setResult(ForgotPasswordResult.SUCCESS);
        this.userMapper.updatePassword(hashedTempPassword, user.getEmail());
    }


}
