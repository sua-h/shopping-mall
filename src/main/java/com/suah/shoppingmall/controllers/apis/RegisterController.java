package com.suah.shoppingmall.controllers.apis;

import com.suah.shoppingmall.services.UserService;
import com.suah.shoppingmall.vos.apis.user.CountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/apis/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
public class RegisterController {
    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/count")
    public String countPost(CountVo countVo) {
        if ("e".equals(countVo.getField())) {
            return String.format("{\"count\":%d}", this.userService.getEmailCount(countVo.getValue()));
        } else {
            return "{}";
        }
    }
}
