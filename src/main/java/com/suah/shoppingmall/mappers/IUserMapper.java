package com.suah.shoppingmall.mappers;

import com.suah.shoppingmall.dtos.UserDto;
import com.suah.shoppingmall.vos.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IUserMapper {
    void updateAutoSignKeyExtended(
            @Param("key") String key,
            @Param("days") int days);

    void updateAutoSignKeyExpired(
            @Param("key") String key);

    int selectEmailCount(
            @Param("email") String email);

    int selectContactCount(
            @Param("contactFirst") String contactFirst,
            @Param("contactSecond") String contactSecond,
            @Param("contactThird") String contactThird);

    void insertUser(RegisterVo registerVo);

    UserDto selectUser(LoginVo loginVo);

    UserDto selectUserFromCookie(
            @Param("key") String key);

    void insertAutoSignKey(
            @Param("email") String email,
            @Param("key") String key,
            @Param("days") int days);

    void updateUser(ModifyVo modifyVo);

    UserDto selectEmail(ForgotEmailVo forgotEmailVo);

    UserDto selectPassword(ForgotPasswordVo forgotPasswordVo);

    void insertReset(
            @Param("userIndex") int userIndex,
            @Param("bindingUa") String bindingUa,
            @Param("bindingIp") String bindingIp,
            @Param("key") String key);

    int selectResetUserIndex(
            @Param("bindingUa") String bindingUa,
            @Param("bindingIp") String bindingIp,
            @Param("key") String key);

    void updateResetExpire(
            @Param("bindingUa") String bindingUa,
            @Param("bindingIp") String bindingIp,
            @Param("key") String key);

    void updatePassword(
            @Param("userIndex") int userIndex,
            @Param("password") String password);
}
