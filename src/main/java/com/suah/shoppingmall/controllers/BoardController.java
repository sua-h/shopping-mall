package com.suah.shoppingmall.controllers;

import com.suah.shoppingmall.dtos.UserDto;
import com.suah.shoppingmall.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/board/")
@SessionAttributes(UserDto.MODEL_NAME)
public class BoardController extends StandardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping(value = {"/list/{bid}", "/list/{bid}/{page}"}, method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String listGet() {

    }
}
