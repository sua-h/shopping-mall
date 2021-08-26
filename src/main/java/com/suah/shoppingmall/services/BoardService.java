package com.suah.shoppingmall.services;

import com.suah.shoppingmall.mappers.IBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
