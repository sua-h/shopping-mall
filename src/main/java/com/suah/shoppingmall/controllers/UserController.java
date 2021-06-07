package com.suah.shoppingmall.controllers;

import com.suah.shoppingmall.dtos.UserDto;
import com.suah.shoppingmall.interfaces.LoginResult;
import com.suah.shoppingmall.services.UserService;
import com.suah.shoppingmall.vos.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/user/")
@SessionAttributes(UserDto.MODEL_NAME)
public class UserController extends StandardController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String loginGet(
            @ModelAttribute(UserDto.MODEL_NAME) UserDto user) {
        if (user != null) {
            return "redirect:/";
        }
        return "user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public String loginPost(
            @ModelAttribute(UserDto.MODEL_NAME) UserDto user, Model model, LoginVo loginVo) {
        if (user != null) {
            return "redirect:/";
        }

        this.userService.login(loginVo);
        if (loginVo.getResult() == LoginResult.SUCCESS) {
            model.addAttribute(UserDto.MODEL_NAME, loginVo.getUser());
            return "redirect:/";
        } else {
            model.addAttribute("vo", loginVo);
            return "user/login";
        }
    }
}
