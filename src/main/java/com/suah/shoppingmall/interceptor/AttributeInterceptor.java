package com.suah.shoppingmall.interceptor;

import com.suah.shoppingmall.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component  // 목적 없는 객체
public class AttributeInterceptor implements HandlerInterceptor {
    private final BoardService boardService;

    @Autowired
    public AttributeInterceptor(BoardService boardService) {
        this.boardService = boardService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("boards", this.boardService.getBoards());
        return true;
    }
}
