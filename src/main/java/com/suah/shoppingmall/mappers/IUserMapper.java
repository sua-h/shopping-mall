package com.suah.shoppingmall.mappers;

import com.suah.shoppingmall.dtos.UserDto;
import com.suah.shoppingmall.vos.LoginVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserMapper {
    UserDto selectUser(LoginVo loginVo);
}
