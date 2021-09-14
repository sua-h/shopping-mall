package com.suah.shoppingmall.dtos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ArticleDto {
    private static class Format {
        public static final String TIMESTAMP = "yyyy-MM-dd HH:mm";
    }

    private final int index;
    private final String boardId;
    private final String userEmail;
    private final String userName;
    private final String title;
    private final String content;
    private final Date timestamp;
    private final int view;
    private final String formattedTimestamp;

    private BoardDto board;
    private ArrayList<CommentDto> comments;

    public ArticleDto(int index, String boardId, String userEmail, String userName, String title, String content, Date timestamp, int view) {
        this.index = index;
        this.boardId = boardId;
        this.userEmail = userEmail;
        this.userName = userName;
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
        this.view = view;
        this.formattedTimestamp = new SimpleDateFormat(Format.TIMESTAMP).format(timestamp);
    }

    public int getIndex() {
        return this.index;
    }

    public String getBoardId() {
        return this.boardId;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public int getView() {
        return this.view;
    }

    public String getFormattedTimestamp() {
        return this.formattedTimestamp;
    }

    public BoardDto getBoard() {
        return this.board;
    }

    public void setBoard(BoardDto board) {
        this.board = board;
    }

    public ArrayList<CommentDto> getComments() {
        return this.comments;
    }

    public void setComments(ArrayList<CommentDto> comments) {
        this.comments = comments;
    }
}
