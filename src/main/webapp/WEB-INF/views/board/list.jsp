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
        <h1>글 목록</h1>
        <section>
            <table>
                <caption></caption>
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
                    <tr>
                        <td>1</td>
                        <td>주문/입금 안내</td>
                        <td>관리자</td>
                        <td>2021-08-21</td>
                        <td>2101</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>반품/환불 안내</td>
                        <td>관리자</td>
                        <td>2021-08-21</td>
                        <td>1223</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>추석 연휴 배송 지연 안내</td>
                        <td>관리자</td>
                        <td>2021-08-25</td>
                        <td>4442</td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td>카카오톡 실시간 알람 톡 OPEN</td>
                        <td>관리자</td>
                        <td>2021-09-01</td>
                        <td>13231</td>
                    </tr>
                    <tr>
                        <td>5</td>
                        <td>멤버쉽 혜택 안내</td>
                        <td>관리자</td>
                        <td>2021-09-02</td>
                        <td>331</td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="5">
                            <form action="" method="get">
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
                    <tr>

                    </tr>
                </tfoot>
            </table>
        </section>
    </div>
</main>
<%@ include file="/WEB-INF/parts/footer.jsp" %>
</body>
</html>