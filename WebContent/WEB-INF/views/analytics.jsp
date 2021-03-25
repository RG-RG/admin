<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자_유저 관리화면</title>
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin_stat.css">
</head>
<body>
    <!-- 헤더 -->
        <c:import url="../common/common_header.jsp" />
    <!-- 헤더 end -->


    <!-- 메인화면 -->
    <section class="section_main">
        <!-- h1 메인 타이틀, h2 소제목 -->
        <h1>통계 관리</h1>

        <h2>가입자 수 추이</h2>
        <!-- 표는 자리만 일단 만들어놓고.. 좀 더 봐야 할듯ㅠㅠ -->
        <div class="graph_section"></div>
        
        <h2>전체 방문자 수 추이</h2>
        <div class="graph_section"></div>

        <h2>인기글(상위 5개)</h2>
        <ul class="stat_table">
            <!-- 표의 분류 -->
            <li class="table_title">
                <span>No.</span>
                <span>제목</span>
                <span>작성자</span>
                <span>조회수</span>
                <span>좋아요</span>
            </li>
            <!-- 데이터 넣을 때엔 여기서부터 li하나씩 foreach 하면 돼용 -->
            <c:forEach items="${ like_list }" var="post" varStatus="status">
            <li>
                <span>${ status.count }</span>
                <span>${ like_list.post_title }</span>
                <span>${ like_list.id }</span>
                <span>${ like_list.view_cnt }</span>
                <span>${ like_list.like_cnt }</span>
            </li>
			</c:forEach>
        </ul>
    </section>
    
</body>
</html>