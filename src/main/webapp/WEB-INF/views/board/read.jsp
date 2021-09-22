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
    <title>글 목록</title>
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
                    <tr>
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
                        <td colspan="5">${vo.article.content}</td>
                    </tr>
                    <tr class="button">
                        <td>
                            <a class="object-button prop-light" href="/board/list/${vo.board.id}">LIST</a>
                        </td>
                        <td colspan="3"></td>
                        <td>
                            <a class="object-button prop-light" href="/board/edit/${vo.article.index}" target="_self">EDIT</a>
                            <a class="object-button prop-light" href="/board/delete/${vo.article.index}" target="_self">DELETE</a>
                        </td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr class="comment-read head">
                        <td colspan="5">이재현<span>2021-01-01 11:11</span></td>
                    </tr>
                    <tr class="comment-read cont">
                        <td colspan="5">COMMENT CONTENT</td>
                    </tr>
                    <tr class="comment-write">
                        <th>comment</th>
                        <td colspan="5">
                            <form method="post">
                                <label>
                                    <span hidden>댓글</span>
                                    <input class="object-text" name="content" type="text" maxlength="100" placeholder="댓글">
                                </label>
                                <input class="object-button prop-light" type="submit" value="WRITE">
                            </form>
                        </td>
                    </tr>
                </tfoot>
            </table>
        </section>
    </div>
</main>
<%@ include file="/WEB-INF/parts/footer.jsp" %>
</body>
</html>