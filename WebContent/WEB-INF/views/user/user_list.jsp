<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Co-doing 관리자</title>

<link rel="icon" href="./images/icon/favicon.ico" />
<link rel="shortcut icon" href="favicon.ico" />

<script type="text/javascript">
	 if(${ empty sessionScope.id }){
		alert("로그인 후 이용해 주세요");
		location.href="index.do";
	}//end if

	//pagination
	function movePage(page) {
		location.href="user_list.do?param_page="+page;
	}

</script>

<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/admin_user_manage.css">
<link rel="stylesheet" href="css/admin_common_header.css">
<link rel="stylesheet" href="css/admin_pagination.css">

</head>
<body>
    <!-- 헤더 -->
	<c:import url="../common/common_header.jsp" />

    <!-- 메인화면 -->
    <section class="section_main">
        <!-- 타이틀 -->
        <h1>회원 관리</h1>

        <ul class="user_table">
            <li class="table_title">
                <span>회원 번호</span>
                <span>아이디</span>
                <span>이메일</span>
                <span>소셜 타입</span>
            </li>
            <c:forEach items="${ user_list }" var="user" varStatus="status">
   	            <li>
	                <span>${ status.count }</span>
	                <span>${ user.id }</span>
	                <span>${ user.auth_email }</span>
	                <c:if test="${ user.platform eq null }">
	                	<span>탈퇴 회원</span>
	                </c:if>
	                <c:if test="${ user.platform ne null }">
	                	<span>${ user.platform }</span>
	                </c:if>
	                
            	</li>
            </c:forEach>
        </ul>
        
		<c:out value="${ pagination_view }" escapeXml="false"/>
    </section>
</body>
</html>