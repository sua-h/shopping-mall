<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!doctype html>
<html lang="en">
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
    <title>글 쓰기</title>
</head>
<%@ include file="/WEB-INF/parts/header.jsp" %>
<body>
    <div class="wrap">
        <h1>write</h1>
        <section class="write">
            <form method="post">
                <label>
                    <span hidden>제목</span>
                    <input autofocus name="title" type="text" maxlength="100" placeholder="제목">
                </label>
                <label>
                    <span hidden>내용</span>
                    <textarea name="content" maxlength="10000" placeholder="내용"></textarea>
                </label>
                <input type="reset" value="되돌리기">
                <input type="submit" value="글 작성">
            </form>
            <a href="#" onclick="window.history.back();">취소</a>
        </section>
    </div>
<%@ include file="/WEB-INF/parts/footer.jsp" %>
</body>
</html>