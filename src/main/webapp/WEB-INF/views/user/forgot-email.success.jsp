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
    <link rel="stylesheet" href="/statics/resources/stylesheets/user/forgot-email.success.css">
    <title>회원가입 성공</title>
</head>
<body class="forgot-email-success">
<%@ include file="/WEB-INF/parts/header.jsp" %>
<main>
    <div class="wrap">
        <h1>이메일 찾기 완료</h1>
        <section>
            <p>이메일 찾기가 완료 되었습니다.<br>다음 정보로 가입된 아이디가 있습니다.</p>
            <div>
                <dl>
                    <dt>이름</dt>
                    <dd>김김김<!--${vo.name}--></dd>
                </dl>
                <dl>
                    <dt>휴대전화</dt>
                    <dd>010-0000-0000</dd>
                </dl>
                <dl>
                    <dt>이메일</dt>
                    <dd>adbd@naver.com</dd>
                </dl>
            </div>
            <p><span>김김김</span>님 즐거운 쇼핑 되세요!</p>
            <div>
                <a class="object-button prop-dark" href="/user/login">로그인</a>
                <a class="object-button prop-light" href="/">메인 페이지</a>
            </div>
        </section>
    </div>
</main>
<%@ include file="/WEB-INF/parts/footer.jsp" %>
</body>
</html>