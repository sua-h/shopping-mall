package com.suah.shoppingmall.interceptor;

import com.suah.shoppingmall.dtos.UserDto;
import com.suah.shoppingmall.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class AutoSignInterceptor implements HandlerInterceptor {
    private final UserService userService;

    @Autowired
    public AutoSignInterceptor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object userObj = session.getAttribute(UserDto.MODEL_NAME);
        UserDto user = userObj instanceof UserDto ? (UserDto) userObj : null;
        if (user == null && request.getCookies() != null) {
            Cookie autoSignKeyCookie = null;
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("ask")) {
                    autoSignKeyCookie = cookie;
                    break;
                }
            }
            if (autoSignKeyCookie != null) {
                user = this.userService.login(autoSignKeyCookie);
                if (user != null) {
                    session.setAttribute(UserDto.MODEL_NAME, user);

                    this.userService.extendAutoSignKey(autoSignKeyCookie);
                    autoSignKeyCookie.setMaxAge(60 * 60 * 24 * UserService.Config.AUTO_SIGN_VALID_DAYS);
                    autoSignKeyCookie.setPath("/");
                    response.addCookie(autoSignKeyCookie);
                    if (request.getRequestURI().equals("/user/login") ||
                            request.getRequestURI().equals("/user/register")) {
                        response.sendRedirect("/");
                        return false;
                    }
                }
            }
        }
//        if (userObj instanceof UserDto) {
//            System.out.println("로그인 인식");
//        } else {
//            System.out.println("로그인 인식 불가");
//        }
        return true;
    }
}
