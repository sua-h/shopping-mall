package com.suah.shoppingmall.controllers;

import com.suah.shoppingmall.dtos.UserDto;
import com.suah.shoppingmall.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/board/")
@SessionAttributes(UserDto.MODEL_NAME)
public class BoardController extends StandardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping(value = "/list"/*{"/list/{bid}", "/list/{bid}/{page}"}*/, method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String listGet(
            Model model,
//            @PathVariable("bid") String boardId,
//            @PathVariable("page") Optional<Integer> optionalPage,
            @ModelAttribute(UserDto.MODEL_NAME) UserDto user) {

        return "board/list";
    }
}
