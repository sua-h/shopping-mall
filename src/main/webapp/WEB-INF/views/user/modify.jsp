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
    <link rel="stylesheet" href="/statics/resources/stylesheets/user/modify.css">
    <title>회원정보 수정</title>
</head>
<body class="user-modify">
<%@ include file="/WEB-INF/parts/header.jsp" %>
<main>
    <div class="wrap">
        <h1>MODIFY</h1>
        <section class="modify">
            <form id="modify-form" method="post">
                <table>
                    <caption>회원정보 수정</caption>
                    <tbody>
                        <tr>
                            <th>이름<span> *</span></th>
                            <td>${vo.name}</td>
                        </tr>
                        <tr>
                            <th>이메일<span> *</span></th>
                            <td>${vo.email}</td>
                        </tr>
                        <tr>
                            <th>비밀번호<span> *</span></th>
                            <td>
                                <label>
                                    <span hidden>비밀번호</span>
                                    <input class="object-text" type="password" name="password" maxlength="100" data-regex="<%=UserService.Regex.PASSWORD%>">
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <th>비밀번호 재확인<span> *</span></th>
                            <td>
                                <label>
                                    <span hidden>비밀번호 재확인</span>
                                    <input class="object-text" type="password" name="passwordCheck" maxlength="100">
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <th>휴대전화<span> *</span></th>
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
                                    <input class="object-text num-box" type="number" name="contactSecond" maxlength="4" value="${vo.contactSecond}" data-regex="<%=UserService.Regex.CONTACT_SECOND%>">
                                    <span>-</span>
                                </label>
                                <label>
                                    <span hidden>휴대전화(끝)</span>
                                    <input class="object-text num-box" type="number" name="contactThird" maxlength="4" value="${vo.contactThird}" data-regex="<%=UserService.Regex.CONTACT_THIRD%>">
                                </label>
                            </td>
                        </tr>
                        <tr class="addr">
                            <th>주소<span> *</span></th>
                            <td>
                                <label>
                                    <span hidden>우편번호</span>
                                    <input readonly class="object-text" type="number" name="addressPost" maxlength="5" value="${vo.addressPost}">
                                    <input class="object-button prop-dark" type="button" name="addressPostFindButton" value="우편번호"><br>
                                </label>
                                <label>
                                    <span hidden>기본주소</span>
                                    <input readonly class="object-text" type="text" name="addressPrimary" maxlength="100" value="${vo.addressPrimary}"><br>
                                </label>
                                <label>
                                    <span hidden>상세주소</span>
                                    <input class="object-text" type="text" name="addressSecondary" maxlength="100"  placeholder="상세주소" value="${vo.addressSecondary}" data-regex="<%=UserService.Regex.ADDRESS_SECONDARY%>">
                                </label>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <table class="add">
                    <caption>추가 정보</caption>
                    <tbody>
                    <tr>
                        <th>생년월일</th>
                        <td>
                            <label>
                                <span hidden>생년</span>
                                <input class="object-text add-year" type="number" name="birthYear" maxlength="4" placeholder="yyyy" value="${vo.birthYear}" data-regex="<%=UserService.Regex.BIRTH_YEAR%>">
                                <span class="add-text">년</span>
                            </label>
                            <label>
                                <span hidden>월</span>
                                <input class="object-text add" type="number" name="birthMonth" maxlength="2" placeholder="mm" value="${vo.birthMonth}" data-regex="<%=UserService.Regex.BIRTH_MONTH%>">
                                <span class="add-text">월</span>
                            </label>
                            <label>
                                <span hidden>일</span>
                                <input class="object-text add" type="number" name="birthDate" maxlength="2" placeholder="dd" value="${vo.birthDate}" data-regex="<%=UserService.Regex.BIRTH_DATE%>">
                                <span class="add-text">일</span>
                            </label>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div>
                    <input class="object-button prop-dark" type="submit" value="회원가입">
                    <a class="object-button prop-light" href="/user/mypage" target="_self">취소</a>
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