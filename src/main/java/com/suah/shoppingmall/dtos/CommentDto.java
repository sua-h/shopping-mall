package com.suah.shoppingmall.dtos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommentDto {
    private static class Format {
        public static final String TIMESTAMP = "yyyy-MM-dd HH:mm";
    }

    private final int index;
    private final int articleIndex;
    private final String userEmail;
    private final Date timestamp;
    private final String content;
    private final String formattedTimestamp;

    public CommentDto(int index, int articleIndex, String userEmail, Date timestamp, String content) {
        this.index = index;
        this.articleIndex = articleIndex;
        this.userEmail = userEmail;
        this.timestamp = timestamp;
        this.content = content;
        this.formattedTimestamp = new SimpleDateFormat(Format.TIMESTAMP).format(timestamp);
    }

    public int getIndex() {
        return this.index;
    }

    public int getArticleIndex() {
        return this.articleIndex;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public String getContent() {
        return this.content;
    }

    public String getFormattedTimestamp() {
        return this.formattedTimestamp;
    }
}
