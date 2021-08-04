package com.suah.shoppingmall.controllers;

import com.suah.shoppingmall.dtos.UserDto;
import com.suah.shoppingmall.enums.user.LoginResult;
import com.suah.shoppingmall.enums.user.ModifyResult;
import com.suah.shoppingmall.enums.user.RegisterResult;
import com.suah.shoppingmall.services.UserService;
import com.suah.shoppingmall.vos.LoginVo;
import com.suah.shoppingmall.vos.ModifyVo;
import com.suah.shoppingmall.vos.RegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            @ModelAttribute(UserDto.MODEL_NAME) UserDto user,
            HttpServletResponse response,
            Model model,
            LoginVo loginVo) {
        if (user != null) {
            return "redirect:/";
        }

        this.userService.login(loginVo);
        if (loginVo.getResult() == LoginResult.SUCCESS) {
            if (loginVo.isAutoSign()) {
                this.userService.putAutoSignKey(loginVo.getUser());

                Cookie cookie = new Cookie("ask", loginVo.getUser().getAutoSignKey());
                cookie.setMaxAge(60 * 60 * 24 * UserService.Config.AUTO_SIGN_VALID_DAYS);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
            model.addAttribute(UserDto.MODEL_NAME, loginVo.getUser());
            return "redirect:/";
        } else {
            model.addAttribute("vo", loginVo);
            return "user/login";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String logoutGet(
            @ModelAttribute(UserDto.MODEL_NAME) UserDto user,
            SessionStatus sessionStatus,
            HttpServletResponse response,
            HttpServletRequest request) {
        if (user != null) {
            Cookie autoSignKeyCookie = null;
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("ask")) {
                    autoSignKeyCookie = cookie;
                    break;
                }
            }
            if (autoSignKeyCookie != null) {
                this.userService.expireAutoSignKey(autoSignKeyCookie);
                autoSignKeyCookie.setMaxAge(0);
                autoSignKeyCookie.setPath("/");
                response.addCookie(autoSignKeyCookie);
            }
        }
        sessionStatus.setComplete();
        return "redirect:/";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String registerGet(
            @ModelAttribute(UserDto.MODEL_NAME) UserDto user,
            Model model) {
        if (user != null) {
            return "redirect:/";
        }
        return "user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public String registerPost(
            @ModelAttribute(UserDto.MODEL_NAME) UserDto user,
            Model model,
            RegisterVo registerVo) {
        if (user != null) {
            return "redirect:/";
        }

        this.userService.register(registerVo);
        if (registerVo.getResult() == RegisterResult.SUCCESS) {
            return "user/register.success";
        } else {
            model.addAttribute("vo", registerVo);
            return "user/register";
        }
    }

    @RequestMapping(value = "/register.success", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String registerSuccess() {
        return "user/register.success";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String modifyGet(
            @ModelAttribute(UserDto.MODEL_NAME) UserDto user,
            Model model) {
        if (user == null) {
            return "redirect:/";
        }
        return "user/modify";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public String modifyPost(
            @ModelAttribute(UserDto.MODEL_NAME) UserDto user,
            SessionStatus sessionStatus,
            Model model,
            ModifyVo modifyVo) {
        if (user == null) {
            return "redirect:/";
        }
        modifyVo.setUser(user);
        this.userService.modify(modifyVo);
        if (modifyVo.getResult() == ModifyResult.SUCCESS) {
            sessionStatus.setComplete();
        }
        model.addAttribute("vo", modifyVo);
        return "user/modify";
    }

    @RequestMapping(value = "/forgot-email", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String forgotEmailGet(
            @ModelAttribute(UserDto.MODEL_NAME) UserDto user) {
        if (user != null) {
            return "redirect:/";
        }
        return "user/forgot-email";
    }

    @RequestMapping(value = "/forgot-email", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public String forgotEmailPost(
            @ModelAttribute(UserDto.MODEL_NAME) UserDto user) {
        if (user != null) {
            return "redirect:/";
        }
        return "user/forgot-email";
    }

    @RequestMapping(value = "/forgot-password", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String forgotPasswordGet(
            @ModelAttribute(UserDto.MODEL_NAME) UserDto user) {
        if (user != null) {
            return "redirect:/";
        }
        return "user/forgot-password";
    }

    @RequestMapping(value = "/forgot-password", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public String forgotPasswordPost(
            @ModelAttribute(UserDto.MODEL_NAME) UserDto user) {
        if (user != null) {
            return "redirect:/";
        }
        return "user/forgot-password";
    }




}
