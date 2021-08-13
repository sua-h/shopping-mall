<%@ page import="com.suah.shoppingmall.services.UserService" %>
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
    <link rel="stylesheet" href="/statics/resources/stylesheets/user/user-forgot.css">
    <script src="/statics/resources/scripts/class.ajax.js"></script>
    <script src="/statics/resources/scripts/user/forgot-password.js"></script>
    <title>비밀번호 재설정</title>
</head>
<body class="user-forgot">
<%@ include file="/WEB-INF/parts/header.jsp" %>
<main>
    <div class="wrap">
        <h1>RESET PASSWORD</h1>
        <section class="reset-password">
            <form id="resetPasswordForm" method="post">
                <table>
                    <caption>비밀번호 재설정</caption>
                    <tbody>
                    <tr>
                        <th>새 비밀번호</th>
                        <td>
                            <label>
                                <span hidden>새 비밀번호</span>
                                <input autofocus class="object-text" type="password" name="password" maxlength="100" placeholder="새 비밀번호" data-regex="<%=UserService.Regex.NAME%>">
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <th>새 비밀번호 확인</th>
                        <td>
                            <label>
                                <span hidden>비밀번호 확인</span>
                                <input class="object-text" type="password" name="passwordCheck" maxlength="100" placeholder="새 비밀번호 확인">
                            </label>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div>
                    <input class="object-button prop-dark" type="submit" name="submit" value="확인">
                    <a href="/user/login" class="object-button prop-light" target="_self">돌아가기</a>
                </div>
            </form>
        </section>
    </div>
</main>
<%@ include file="/WEB-INF/parts/footer.jsp" %>
<script>
</script>
</body>
</html>