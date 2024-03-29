package com.suah.shoppingmall.services;

import com.suah.shoppingmall.dtos.ArticleDto;
import com.suah.shoppingmall.dtos.BoardDto;
import com.suah.shoppingmall.dtos.UserDto;
import com.suah.shoppingmall.enums.board.ListResult;
import com.suah.shoppingmall.enums.board.ReadResult;
import com.suah.shoppingmall.enums.board.WriteResult;
import com.suah.shoppingmall.mappers.IBoardMapper;
import com.suah.shoppingmall.vos.board.CommentVo;
import com.suah.shoppingmall.vos.board.ListVo;
import com.suah.shoppingmall.vos.board.ReadVo;
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

    public BoardDto getBoard(int aid) { return this.boardMapper.selectBoardByArticle(aid); }

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
                writeVo.getTitle(),
                writeVo.getContent());
        writeVo.setResult(WriteResult.OKAY);
    }

    public void read(ReadVo readVo) {
        BoardDto board = this.getBoard(readVo.getArticleId());
        if (board == null) {
            readVo.setResult(ReadResult.NO_SUCH_ARTICLES);
            return;
        }

        if (!BoardService.isAllowedToRead(readVo.getUser(), board)) {
            readVo.setResult(ReadResult.NOT_AUTHORIZED);
            return;
        }

        this.boardMapper.updateArticleViewed(readVo.getArticleId());
        ArticleDto article = this.boardMapper.selectArticle(readVo.getArticleId());
        // TODO : article - comment set
        article.setComments(this.boardMapper.selectComments(readVo.getArticleId()));
        readVo.setArticle(article);
        readVo.setBoard(board);
        readVo.setResult(ReadResult.OKAY);
    }

    public void writeComment(CommentVo commentVo) {
        BoardDto board = this.getBoard(commentVo.getArticleId());

        System.out.println(commentVo.getContent());

        if (board == null || BoardService.isAllowedToComment(commentVo.getUser(), board)) {
            return;
        }

        this.boardMapper.insertComment(
                commentVo.getArticleId(),
                commentVo.getUser().getEmail(),
                commentVo.getContent());
    }


}
