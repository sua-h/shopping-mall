<%@ page import="com.suah.shoppingmall.services.UserService" %>
<%@ page import="com.suah.shoppingmall.enums.user.RegisterResult" %>
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
    <link rel="stylesheet" href="/statics/resources/stylesheets/user/register.css">
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="/statics/resources/scripts/class.ajax.js"></script>
    <script src="/statics/resources/scripts/user/register.js"></script>
    <title>회원가입</title>
</head>
<body class="user-register">
<%@ include file="/WEB-INF/parts/header.jsp" %>
<main>
    <div id="postal-layer"></div>
    <div class="wrap">
        <h1>JOIN</h1>
        <section class="register">
            <form id="register-form" method="post">
                <table>
                    <caption>기본 정보</caption>
                    <tbody>
                        <tr>
                            <th>이름<span> *</span></th>
                            <td>
                                <label>
                                    <span hidden>이름</span>
                                    <input class="object-text" autofocus type="text" name="name" maxlength="10" value="${vo.name}" data-regex="<%=UserService.Regex.NAME%>">
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <th>이메일<span> *</span></th>
                            <td>
                                <label>
                                    <span hidden>이메일</span>
                                    <input class="object-text" type="email" name="email" maxlength="50" value="${vo.email}" data-regex="<%=UserService.Regex.EMAIL%>">
                                    <span class="warning" rel="email-warning">해당 이메일은 이미 사용 중입니다.</span>
                                </label>
                            </td>
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
<%--                                <label>--%>
<%--                                    <input class="object-check" type="radio" name="isSolarCalendar" value="true" checked="checked">--%>
<%--                                    <span>양력</span>--%>
<%--                                    <input class="object-check" type="radio" name="isSolarCalendar" value="false">--%>
<%--                                    <span>음력</span>--%>
<%--                                </label>--%>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <table>
                    <caption>이용약관</caption>
                    <tbody>
                        <tr>
                            <td>
                                <label class="object-check">
                                    <input name="disc-agree-all" type="checkbox">
                                    <span>이용약관 및 개인정보수집 및 이용, 쇼핑정보 수신(선택)에 모두 동의합니다.</span>
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <td class="disc">
                                <label>
                                    <span><strong>[필수] 이용 약관</strong></span>
                                    <textarea class="object-text" readonly>본 사이트는 포트폴리오 용도의 사이트입니다.</textarea>
                                </label>
                                <label class="object-check">
                                    <input name="disc-agree-a" type="checkbox">
                                    <span>이용 약관에 동의합니다.</span>
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <td class="disc">
                                <label>
                                    <span><strong>[필수] 개인정보 수집 및 이용 동의</strong></span>
                                    <textarea class="object-text" readonly>개인정보 수집 및 이용 동의</textarea>
                                </label>
                                <label class="object-check">
                                    <input name="disc-agree-b" type="checkbox">
                                    <span>개인정보 수집 및 이용에 동의합니다.</span>
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <td class="disc">
                                <label>
                                    <span><strong>[선택] 쇼핑정보 수신 동의</strong></span>
                                    <textarea class="object-text" readonly>쇼핑정보 수신 동의</textarea>
                                </label>
                                <label class="object-check">
                                    <input name="disc-agree-c" type="checkbox">
                                    <span>쇼핑정보 수신에 동의합니다.</span>
                                </label>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <div>
                    <input class="object-button prop-dark" type="submit" value="회원가입">
                    <a class="object-button prop-light" href="/user/login" target="_self">돌아가기</a>
                </div>
            </form>
        </section>
    </div>
</main>
<%@ include file="/WEB-INF/parts/footer.jsp" %>
<script>
    ${vo.result == RegisterResult.DUPLICATE_EMAIL ? "alert('입력하신 이메일은 이미 사용 중입니다.');" : ""}
    ${vo.result == RegisterResult.DUPLICATE_CONTACT ? "alert('입력하신 연락처는 이미 사용 중입니다.');" : ""}
    ${vo.result == RegisterResult.FAILURE ? "alert('회원가입에 실패하였습니다. 다시 시도해주세요.');" : ""}
</script>
</body>
</html>