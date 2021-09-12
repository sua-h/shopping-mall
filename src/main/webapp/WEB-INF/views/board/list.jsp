<%@ page import="com.suah.shoppingmall.enums.board.ListResult" %>
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
    <link rel="stylesheet" href="/statics/resources/stylesheets/board/list.css">
    <title>글 목록</title>
</head>
<body class="list">
<%@ include file="/WEB-INF/parts/header.jsp" %>
<main>
    <div class="wrap">
        <h1>${vo.result == ListResult.NO_SUCH_BOARD ? "존재하지 않는 게시판" : vo.board.name}</h1>
        <section>
            <table>
                <caption>게시판 목록</caption>
                <thead>
                    <tr>
                        <th>NO</th>
                        <th>TITLE</th>
                        <th>WRITER</th>
                        <th>DATE</th>
                        <th>VIEW</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${vo.result == ListResult.NO_SUCH_BOARD}">
                        <tr>
                            <td colspan="5">존재하지 않는 게시판입니다.</td>
                        </tr>
                    </c:if>

                    <c:if test="${vo.result == ListResult.NOT_AUTHORIZED}">
                        <tr>
                            <td colspan="5">게시판을 확인할 권한이 없습니다.</td>
                        </tr>
                    </c:if>

                    <c:if test="${vo.result == ListResult.OKAY}">
                        <c:if test="${vo.articles.size() == 0}">
                            <tr>
                                <td colspan="5">작성된 게시글이 없습니다.</td>
                            </tr>
                        </c:if>
                        <c:forEach var="article" items="${vo.articles}">
                            <tr>
                                <td>${article.index}</td>
                                <td>
                                    <a href="/board/read/${article.index}?is=0&p=${vo.page}">${article.title}</a>
                                    <a>[${article.comments.size()}]</a>
                                </td>
                                <td>${article.user.name}</td>
                                <td>${article.timestamp}</td>
                                <td>${article.view}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </tbody>
                <tfoot>
                    <tr>
                        <td class="button"><a class="object-button prop-light" href="/board/write/{bid}">WRITE</a></td>
                    </tr>
                    <tr>
                        <td class="page-num" colspan="5">
                            <c:if test="${vo.page > 1}">
                                <span>
                                    <a href="/board/list/${vo.board.id}/1" target="_self"><<</a>
                                </span>
                            </c:if>
                            <c:forEach var="i" begin="${vo.leftPage}" end="${vo.rightPage}" step="1">
                                <c:if test="${i == vo.page}">
                                    <span>
                                        <a>${i}</a>
                                    </span>
                                </c:if>
                                <c:if test="${i != vo.page}">
                                    <span>
                                        <a href="/board/list/${vo.board.id}/${i}" target="_self">${i}</a>
                                    </span>
                                </c:if>
                            </c:forEach>
                            <c:if test="${vo.page < vo.maxPage}">
                                <span>
                                    <a href="/board/list/${vo.board.id}}/${vo.maxPage}" target="_self">>></a>
                                </span>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5">
                            <form action="/board/search/${vo.boardId}" method="get">
                                <label>
                                    <span hidden>기준</span>
                                    <select name="criteria">
                                        <option selected value="title">제목</option>
                                        <option value="content">제목 + 내용</option>
                                        <option value="writer">작성자</option>
                                    </select>
                                </label>
                                <label>
                                    <span hidden>키워드</span>
                                    <input maxlength="10" name="keyword" placeholder="검색어">
                                </label>
                                <input class="object-button prop-dark" type="submit" value="검색">
                            </form>
                        </td>
                    </tr>
                </tfoot>
            </table>
        </section>
    </div>
</main>
<%@ include file="/WEB-INF/parts/footer.jsp" %>
</body>
</html>