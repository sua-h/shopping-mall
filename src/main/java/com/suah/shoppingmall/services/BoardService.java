package com.suah.shoppingmall.services;

import com.suah.shoppingmall.dtos.ArticleDto;
import com.suah.shoppingmall.dtos.BoardDto;
import com.suah.shoppingmall.dtos.UserDto;
import com.suah.shoppingmall.enums.board.ListResult;
import com.suah.shoppingmall.enums.board.WriteResult;
import com.suah.shoppingmall.mappers.IBoardMapper;
import com.suah.shoppingmall.vos.board.ListVo;
import com.suah.shoppingmall.vos.board.WriteVo;
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

    public void getArticles(ListVo listVo) {
        if (listVo.getBoard() == null) {
            listVo.setResult(ListResult.NO_SUCH_BOARD);
            return;
        }

        if (!BoardService.isAllowedToList(listVo.getUser(), listVo.getBoard())) {
            listVo.setResult(ListResult.NOT_AUTHORIZED);

            return;
        }

        int articleCount = this.boardMapper.selectArticleCount(listVo.getBoardId());
        int maxPage = articleCount / Config.ARTICLES_PER_PAGE + (articleCount % Config.ARTICLES_PER_PAGE == 0 ? 0 : 1);
        int leftPage = Math.max(1, listVo.getPage() - Config.PAGE_RANGE);
        int rightPage = Math.min(maxPage, listVo.getPage() + Config.PAGE_RANGE);

        listVo.setArticleCount(articleCount);
        listVo.setMaxPage(maxPage);
        listVo.setLeftPage(leftPage);
        listVo.setRightPage(rightPage);

        ArrayList<ArticleDto> articles = this.boardMapper.selectArticles(
                listVo.getBoardId(),
                Config.ARTICLES_PER_PAGE,
                Config.ARTICLES_PER_PAGE * (listVo.getPage() - 1));

        // TODO : article에 comment

        listVo.setArticles(articles);
        listVo.setResult(ListResult.OKAY);
    }

    public void writeArticle(WriteVo writeVo) {
        if (writeVo.getBoard() == null) {
            writeVo.setResult(WriteResult.NO_SUCH_BOARD);
            return;
        }

        if (!BoardService.isAllowedToWrite(writeVo.getUser(), writeVo.getBoard())) {
            writeVo.setResult(WriteResult.NOT_AUTHORIZED);
            return;
        }

        this.boardMapper.insertArticle(
                writeVo.getBoard().getId(),
                writeVo.getUser().getEmail(),
                writeVo.getUser().getName(),
                writeVo.getTitle(),
                writeVo.getContent());
        writeVo.setResult(WriteResult.OKAY);
    }


}
