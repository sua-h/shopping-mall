<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!doctype html>
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
    <link rel="stylesheet" href="/statics/resources/stylesheets/board/write.css">
    <script src="https://cdn.ckeditor.com/ckeditor5/29.2.0/classic/ckeditor.js"></script>
    <title>글 쓰기</title>
</head>
<body class="write">
<%@ include file="/WEB-INF/parts/header.jsp" %>
<main>
    <div class="wrap">
        <h1>${vo.board.id}</h1>
        <section class="write">
            <form method="post">
                <table>
                    <caption>글쓰기</caption>
                    <tbody>
                        <tr>
                            <th>TITLE</th>
                            <td>
                                <label>
                                    <span hidden>제목</span>
                                    <input autofocus name="title" type="text" maxlength="100" placeholder="제목">
                                </label>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <label>
                    <span hidden>내용</span>
                    <textarea id="editor" name="content" maxlength="10000" placeholder="내용"></textarea>
                </label>
                <div class="button">
                    <div class="left-button">
                        <a href="#" class="object-button prop-light" onclick="window.history.back();">CANCEL</a>
                    </div>
                    <div class="stretch"></div>
                    <div class="right-button">
                        <input class="object-button prop-light" type="reset" value="RESET">
                        <input class="object-button prop-light" type="submit" value="WRITE">
                    </div>
                </div>
            </form>
        </section>
    </div>
</main>
<%@ include file="/WEB-INF/parts/footer.jsp" %>
<script src="/statics/resources/scripts/board/ckeditor.js"></script>
</body>
</html>