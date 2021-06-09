package com.suah.shoppingmall.mappers;

import com.suah.shoppingmall.dtos.UserDto;
import com.suah.shoppingmall.vos.LoginVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IUserMapper {
    void updateAutoSignKeyExtended(
            @Param("key") String key,
            @Param("days") int days);

    void updateAutoSignKeyExpired(
            @Param("key") String key);

    UserDto selectUser(LoginVo loginVo);

    UserDto selectUserFromCookie(
            @Param("key") String key);

    void insertAutoSignKey(
            @Param("email") String email,
            @Param("key") String key,
            @Param("days") int days);
}
