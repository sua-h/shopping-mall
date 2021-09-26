<%@ page import="com.suah.shoppingmall.enums.board.ListResult" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
    <link rel="stylesheet" href="/statics/resources/stylesheets/common.css">
    <link rel="stylesheet" href="/statics/resources/stylesheets/board/read.css">
    <title>글 읽기</title>
</head>
<body class="list">
<%@ include file="/WEB-INF/parts/header.jsp" %>
<main>
    <div class="wrap">
        <h1>${vo.board.id}</h1>
        <section>
            <table>
                <thead>
                    <tr>
                        <th>TITLE</th>
                        <td colspan="5">${vo.article.title}</td>
                    </tr>
                    <tr class="read-header">
                        <th>WRITER</th>
                        <td>${vo.article.userName}</td>
                        <th>DATE</th>
                        <td>${vo.article.formattedTimestamp}</td>
                        <th>VIEW</th>
                        <td>${vo.article.view}</td>
                    </tr>
                </thead>
                <tbody>
                    <tr class="content">
                        <td colspan="6">${vo.article.content}</td>
                    </tr>
                </tbody>
            </table>
            <div class="read-footer">
                <div class="button">
                    <div class="left-button">
                        <a class="object-button prop-light" href="/board/list/${vo.board.id}">LIST</a>
                    </div>
                    <div class="stretch"></div>
                    <div class="right-button">
                        <a class="object-button prop-light" href="/board/edit/${vo.article.index}" target="_self">EDIT</a>
                        <a class="object-button prop-light" href="/board/delete/${vo.article.index}" target="_self">DELETE</a>
                    </div>
                </div>
                <div class="comment-read">
                    <div class="read-head">
                        <strong>홍은비</strong>
                        <span>2021-01-01 11:11</span>
                    </div>
                    <div class="read-cont">
                        <span>COMMENT CONTENT</span>
                    </div>
                </div>
                <div class="comment-write">
                    <div class="write-head">
                        <strong>write a comment</strong>
                    </div>
                    <div class="write-cont">
                        <form method="post">
                                <label>
                                    <span hidden>댓글</span>
                                    <input class="object-text" name="content" type="text" maxlength="100" placeholder="댓글">
                                </label>
                                <input class="object-button prop-light" type="submit" value="WRITE">
                        </form>
                    </div>
                </div>

            </div>
        </section>
    </div>
</main>
<%@ include file="/WEB-INF/parts/footer.jsp" %>
</body>
</html>