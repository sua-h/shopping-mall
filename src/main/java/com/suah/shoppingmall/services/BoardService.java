package com.suah.shoppingmall.services;

import com.suah.shoppingmall.dtos.BoardDto;
import com.suah.shoppingmall.dtos.UserDto;
import com.suah.shoppingmall.mappers.IBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BoardService {
    private final IBoardMapper boardMapper;

    @Autowired
    public BoardService(IBoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public static class Config {
        public static final int ARTICLES_PER_PAGE = 10;
        public static final int PAGE_RANGE = 5;
    }

    public static boolean isAllowedToComment(UserDto user, BoardDto board) {
        return (user == null ? 10 : user.getLevel()) <= board.getLevelComment();
    }

    public static boolean isAllowedToList(UserDto user, BoardDto board) {
        return (user == null ? 10 : user.getLevel()) <= board.getLevelList();
    }

    public static boolean isAllowedToRead(UserDto user, BoardDto board) {
        return (user == null ? 10 : user.getLevel()) <= board.getLevelRead();
    }

    public static boolean isAllowedToWrite(UserDto user, BoardDto board) {
        return (user == null ? 10 : user.getLevel()) <= board.getLevelWrite();
    }


    public ArrayList<BoardDto> getBoards() {
        return this.boardMapper.selectBoards();
    }

    public BoardDto getBoard(String bid) {
        return this.boardMapper.selectBoard(bid);
    }


}
