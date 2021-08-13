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
    <link rel="stylesheet" href="/statics/resources/stylesheets/user/user-success.css">
    <title>비밀번호 찾기</title>
</head>
<body class="success">
<%@ include file="/WEB-INF/parts/header.jsp" %>
<main>
    <div class="wrap">
        <h1>비밀번호 찾기 완료</h1>
        <section>
            <p>비밀번호 재설정 링크가 포함된 이메일을 전송하였습니다.<br>
                링크를 이용해 비밀번호를 재설정해주세요.<br>
                <span class="sub-text">이메일 수신까지는 시간이 소요될 수 있습니다.</span>
            </p>
            <div class="button">
                <a class="object-button prop-dark" href="/user/login">로그인</a>
                <a class="object-button prop-light" href="/">메인 페이지</a>
            </div>
        </section>
    </div>
</main>
<%@ include file="/WEB-INF/parts/footer.jsp" %>
</body>
</html>