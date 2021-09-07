package com.suah.shoppingmall.controllers;

import com.suah.shoppingmall.dtos.BoardDto;
import com.suah.shoppingmall.dtos.UserDto;
import com.suah.shoppingmall.enums.board.WriteResult;
import com.suah.shoppingmall.services.BoardService;
import com.suah.shoppingmall.vos.board.ListVo;
import com.suah.shoppingmall.vos.board.WriteVo;
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

    @RequestMapping(value = {"/list/{bid}", "/list/{bid}/{page}"}, method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String listGet(
            Model model,
            @PathVariable("bid") String boardId,
            @PathVariable("page") Optional<Integer> optionalPage,
            @ModelAttribute(UserDto.MODEL_NAME) UserDto user) {
        // /board/list/notice    : page = 1
        // /board/list/notice/5  : page = 5
        int page = optionalPage.orElse(1);
        ListVo listVo = new ListVo(boardId, page);
        listVo.setUser(user);
        listVo.setBoard(this.boardService.getBoard(boardId));
        this.boardService.getArticles(listVo);
        model.addAttribute("vo", listVo);
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

    @RequestMapping(value = "/write/{bid}", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public String writePost(
            HttpServletResponse response,
            Model model,
            WriteVo writeVo,
            @PathVariable("bid") String boardId,
            @ModelAttribute(UserDto.MODEL_NAME) UserDto user) {
        writeVo.setBoard(this.boardService.getBoard(boardId));
        writeVo.setUser(user);
        this.boardService.writeArticle(writeVo);
        model.addAttribute("vo", writeVo);
        if (writeVo.getResult() == WriteResult.OKAY) {
            return "redirect:/board/list" + boardId;
        } else {
            return "board/write";
        }
    }
}
