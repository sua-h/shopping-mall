package com.suah.shoppingmall.vos.board;

import com.suah.shoppingmall.dtos.ArticleDto;
import com.suah.shoppingmall.dtos.BoardDto;
import com.suah.shoppingmall.dtos.UserDto;
import com.suah.shoppingmall.enums.board.ListResult;
import com.suah.shoppingmall.interfaces.IResult;

import java.util.ArrayList;

public class ListVo implements IResult<ListResult> {
    private final String boardId;
    private final int page;

    private UserDto user;
    private BoardDto board;
    private ArrayList<ArticleDto> articles;
    private ListResult result;

    private int leftPage;
    private int rightPage;
    private int maxPage;

    public ListVo(String boardId, int page) {
        this.boardId = boardId;
        this.page = page;
    }

    public String getBoardId() {
        return this.boardId;
    }

    public int getPage() {
        return this.page;
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

    public ArrayList<ArticleDto> getArticles() {
        return this.articles;
    }

    public void setArticles(ArrayList<ArticleDto> articles) {
        this.articles = articles;
    }

    @Override
    public ListResult getResult() {
        return this.result;
    }

    @Override
    public String getResultName() {
        return this.result.name();
    }

    @Override
    public void setResult(ListResult result) {
        this.result = result;
    }

    public int getLeftPage() {
        return this.leftPage;
    }

    public void setLeftPage(int leftPage) {
        this.leftPage = leftPage;
    }

    public int getRightPage() {
        return this.rightPage;
    }

    public void setRightPage(int rightPage) {
        this.rightPage = rightPage;
    }

    public int getMaxPage() {
        return this.maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }
}
