<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <div class="container">
        <div class="logo-container">
            <a class="logo" href="/" target="_self">
                <img src="/statics/resources/images/logo.png" alt="logo">
            </a>
        </div>
        <div class="menu-container">
            <div class="stretch"></div>
            <ul class="menu-list">
                <li class="main-menu"><a href="/about">about us</a></li>
                <li class="main-menu"><a href="/category">shop</a>
                    <ul class="sub-list">
                        <li class="sub-menu"><a href="/category/best">best</a></li>
                        <li class="sub-menu"><a href="/category/shoulder">shoulder</a></li>
                        <li class="sub-menu"><a href="/category/tote">tote</a></li>
                        <li class="sub-menu"><a href="/category/messenger">messenger</a></li>
                        <li class="sub-menu"><a href="/category/etc">etc</a></li>
                    </ul>
                </li>
                <li class="main-menu"><a href="/lookbook">lookbook</a></li>
                <li class="main-menu"><a href="#">community</a>
                    <ul class="sub-list">
                        <c:forEach var="board" items="${boards}">
                            <li class="sub-menu"><a href="/board/list/${board.id}" target="_self">${board.name}</a></li>
                        </c:forEach>
                    </ul>
                </li>
            </ul>
            <ul class="user-menu-list">
                <c:if test="${user == null}">
                    <li class="main-menu"><a href="/user/login">login/join</a></li>
                </c:if>
                <c:if test="${user != null}">
                    <li class="main-menu"><a href="/user/mypage">account</a>
                        <ul class="sub-list">
                            <li class="sub-menu"><a href="/user/mypage">mypage</a></li>
                            <li class="sub-menu"><a href="/user/order">order</a></li>
                            <li class="sub-menu"><a href="/user/modify">modify</a></li>
                            <li class="sub-menu"><a href="/user/logout">logout</a></li>
                        </ul>
                    </li>
                </c:if>
                <li><a href="/cart">cart</a></li>
            </ul>
        </div>
    </div>

<%--    <div>--%>
<%--        <c:if test="${user == null}">--%>
<%--            <span><b><a href="/user/login">로그인</a></b>해주세요.</span>--%>
<%--        </c:if>--%>
<%--        <c:if test="${user != null}">--%>
<%--            <span><b>${user.nickname}</b>님 환영합니다.</span>--%>
<%--            <span><a href="/user/modify">정보수정</a></span>--%>
<%--            <span><a href="/user/logout">로그아웃</a></span>--%>
<%--        </c:if>--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        <ul>--%>
<%--            <c:forEach var="board" items="${boards}">--%>
<%--                <li>--%>
<%--                    <a href="/board/list/${board.id}" target="_self">${board.name}</a>--%>
<%--                </li>--%>
<%--            </c:forEach>--%>
<%--        </ul>--%>
<%--    </div>--%>
</header>