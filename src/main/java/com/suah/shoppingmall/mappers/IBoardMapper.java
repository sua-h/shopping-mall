package com.suah.shoppingmall.mappers;

import com.suah.shoppingmall.dtos.ArticleDto;
import com.suah.shoppingmall.dtos.BoardDto;
import com.suah.shoppingmall.dtos.CommentDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface IBoardMapper {
    ArrayList<BoardDto> selectBoards();

    BoardDto selectBoard(
            @Param("id") String id);

    BoardDto selectBoardByArticle(
            @Param("aid") int articleId);

    void insertArticle(
            @Param("bid") String bid,
            @Param("userEmail") String userEmail,
            @Param("title") String title,
            @Param("content") String content);

    ArrayList<ArticleDto> selectArticles(
            @Param("bid") String bid,
            @Param("limit") int limit,
            @Param("offset") int offset);

    int selectArticleCount(
            @Param("bid") String bid);

    ArticleDto selectArticle(
            @Param("aid") int articleId);

    void insertComment(
            @Param("aid") int articleId,
            @Param("userEmail") String userEmail,
            @Param("content") String content);

    ArrayList<CommentDto> selectComments(
            @Param("aid") int articleId);

    CommentDto selectComment(
            @Param("cid") int commentId);

    void updateArticleViewed(
            @Param("aid") int articleId);
}
