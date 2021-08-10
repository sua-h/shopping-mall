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
    <link rel="stylesheet" href="/statics/resources/stylesheets/user/forgot-password.css">
    <script src="/statics/resources/scripts/class.ajax.js"></script>
    <script src="/statics/resources/scripts/user/forgot-password.js"></script>
    <title>비밀번호 찾기</title>
</head>
<body class="user-forgot-password">
<%@ include file="/WEB-INF/parts/header.jsp" %>
<main>
    <div class="wrap">
        <h1>FORGOT PASSWORD</h1>
        <section class="forgot-password">
            <form id="forgotPasswordForm">
                <table>
                    <caption>비밀번호 찾기</caption>
                    <tbody>
                    <tr>
                        <th>이름</th>
                        <td>
                            <label>
                                <span hidden>이름</span>
                                <input class="object-text" type="text" name="name" maxlength="10" value="" data-regex="<%=UserService.Regex.NAME%>">
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <th>이메일</th>
                        <td>
                            <label>
                                <span hidden>이메일</span>
                                <input class="object-text" type="text" name="email" maxlength="50" value="" data-regex="<%=UserService.Regex.EMAIL%>">
                                <span class="notice" rel="">회원정보가 일치하면 해당 메일로 비밀번호 재설정 링크를 보내드립니다.</span>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <th>휴대전화</th>
                        <td>
                            <label>
                                <span hidden>휴대전화</span>
                                <select class="num-box" name="contactFirst">
                                    <option value="010" ${vo.contactFirst.equals("010") ? "selected" : ""}>010</option>
                                    <option value="011" ${vo.contactFirst.equals("011") ? "selected" : ""}>011</option>
                                    <option value="016" ${vo.contactFirst.equals("016") ? "selected" : ""}>016</option>
                                    <option value="017" ${vo.contactFirst.equals("017") ? "selected" : ""}>017</option>
                                    <option value="018" ${vo.contactFirst.equals("018") ? "selected" : ""}>018</option>
                                    <option value="019" ${vo.contactFirst.equals("019") ? "selected" : ""}>019</option>
                                </select>
                                <span>-</span>
                            </label>
                            <label>
                                <span hidden>휴대전화(중간)</span>
                                <input class="object-text num-box" type="number" name="contactSecond" maxlength="4" value="" data-regex="<%=UserService.Regex.CONTACT_SECOND%>">
                                <span>-</span>
                            </label>
                            <label>
                                <span hidden>휴대전화(끝)</span>
                                <input class="object-text num-box" type="number" name="contactThird" maxlength="4" value="" data-regex="<%=UserService.Regex.CONTACT_THIRD%>">
                            </label>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div>
                    <input class="object-button prop-dark" type="submit" name="submit" value="비밀번호 찾기">
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