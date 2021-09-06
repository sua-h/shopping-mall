package com.suah.shoppingmall.controllers;

import com.suah.shoppingmall.dtos.BoardDto;
import com.suah.shoppingmall.dtos.UserDto;
import com.suah.shoppingmall.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping(value = "/write/{bid}", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String writeGet(
            HttpServletResponse response,
            Model model,
            @PathVariable("bid") String boardId,
            @ModelAttribute(UserDto.MODEL_NAME) UserDto user) {
        BoardDto board = this.boardService.getBoard(boardId);
        if (board == null || !BoardService.isAllowedToWrite(user, board)) {
            System.out.println("접근 불가");
            response.setStatus(404);
            return null;
        }
        return "board/write";
    }

    @RequestMapping(value = "/write", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public String writePost() {
        return "board/write";
    }
}
