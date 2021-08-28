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
    <link rel="stylesheet" href="/statics/resources/stylesheets/common.css">
    <link rel="stylesheet" href="/statics/resources/stylesheets/user/list.css">
    <title>글 목록</title>
</head>
<body class="">
<%@ include file="/WEB-INF/parts/header.jsp" %>
<main>
    <div class="wrap">
        <h1>글 목록</h1>
        <section>
            <table>
                <caption></caption>
                <thead>
                    <tr>
                        <th>NO</th>
                        <th>TITLE</th>
                        <th>DATE</th>
                        <th>WRITER</th>
                        <th>VIEW</th>
                    </tr>
                </thead>
                <tbody>
                    <tr></tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="5">
                            <form action="" method="get">
                                <label>
                                    <span hidden>기준</span>
                                    <select name="">
                                        <option selected value="title">제목</option>
                                        <option value="content">제목 + 내용</option>
                                        <option value="writer">작성자</option>
                                    </select>
                                </label>
                                <label>
                                    <span hidden>키워드</span>
                                    <input maxlength="10" name="keyword" placeholder="검색어">
                                </label>
                                <input type="submit" value="검색">
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