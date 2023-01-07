package com.suah.shoppingmall.vos.board;

import com.suah.shoppingmall.dtos.ArticleDto;
import com.suah.shoppingmall.dtos.BoardDto;
import com.suah.shoppingmall.dtos.UserDto;
import com.suah.shoppingmall.enums.board.ReadResult;
import com.suah.shoppingmall.interfaces.IResult;

public class ReadVo implements IResult<ReadResult> {
    private final int articleId;

    private UserDto user;
    private BoardDto board;
    private ArticleDto article;
    private ReadResult result;

    public ReadVo(int articleId) {
        this.articleId = articleId;
    }

    public int getArticleId() {
        return this.articleId;
    }

    public UserDto getUser() {
        return this.user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public BoardDto getBoard() {
        return this.board;
    }

    public void setBoard(BoardDto board) {
        this.board = board;
    }

    public ArticleDto getArticle() {
        return this.article;
    }

    public void setArticle(ArticleDto article) {
        this.article = article;
    }

    @Override
    public ReadResult getResult() {
        return this.result;
    }

    @Override
    public String getResultName() {
        return this.result.name();
    }

    @Override
    public void setResult(ReadResult result) {
        this.result = result;
    }
}
