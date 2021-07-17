<%@ page import="com.suah.shoppingmall.services.UserService" %>
<%@ page import="com.suah.shoppingmall.enums.user.LoginResult" %>
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
    <link rel="stylesheet" href="/statics/resources/stylesheets/user/login.css">
    <script src="/statics/resources/scripts/user/login.js"></script>
    <title>로그인</title>
</head>
<body class="user-login">
<%@ include file="/WEB-INF/parts/header.jsp" %>
<main>
    <div class="wrap">
        <h1>LOGIN</h1>
        <section class="login">
            <form id="login-form" method="post">
                <div>
                    <div class="email">
                        <label>
                            <span hidden>Email</span>
                            <input class="object-text" autofocus type="email" name="email" placeholder="EMAIL" maxlength="50" value="${vo.email}" data-regex="<%=UserService.Regex.EMAIL%>">
                        </label>
                    </div>
                    <div class="password">
                        <label>
                            <span hidden>Password</span>
                            <input class="object-text" type="password" name="password" placeholder="PASSWORD" maxlength="100" data-regex="<%=UserService.Regex.PASSWORD%>">
                        </label>
                    </div>
                    <div class="submit">
                        <input class="object-button prop-dark" type="submit" value="LOGIN">
                    </div>
                </div>
                <label class="object-check">
                    <input type="checkbox" name="autoSign">
<%--                    <input type="hidden" value="false" name="autoSign">--%>
                    <span>자동 로그인</span>
                </label>
            </form>
            <div>
                <a class="object-button prop-light" href="/user/register">JOIN</a>
                <a class="object-button prop-light" href="/user/forgot">FORGOT EMAIL</a>
                <a class="object-button prop-light" href="/user/recover">FORGOT PASSWORD</a>
            </div>
        </section>
    </div>
</main>
<%@ include file="/WEB-INF/parts/footer.jsp" %>
<script>
    ${vo.result == LoginResult.FAILURE? "alert('이메일 혹은 비밀번호가 올바르지 않습니다.');" : ""}
    ${vo.result == LoginResult.UNAVAILABLE? "alert('해당 계정은 현재 이용하실 수 없습니다.');" : ""}
</script>
</body>
</html>