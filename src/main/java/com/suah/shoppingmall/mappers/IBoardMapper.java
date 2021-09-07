package com.suah.shoppingmall.mappers;

import com.suah.shoppingmall.dtos.ArticleDto;
import com.suah.shoppingmall.dtos.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface IBoardMapper {
    ArrayList<BoardDto> selectBoards();

    BoardDto selectBoard(
            @Param("id") String id);

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
}
