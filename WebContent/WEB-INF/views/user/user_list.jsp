<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자화면 - 회원관리</title>
<script type="text/javascript">
/* if(${ empty sessionScope.id }){
	alert("로그인 후 이용해 주세요");
	location.href="index.do";
}//end if */

</script>

<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/admin_user_manage.css">

</head>
<body>
    <!-- 헤더 -->
    <section class="section_header">
        <ul>
            <li class="logo">GLOG</li>
            <li class="cate">글 관리</li>
            <li class="cate">회원 관리</li>
            <li class="cate">통계 관리</li>
        </ul>
        <ul>
            <li class="cate">설정</li>
            <li class="cate">로그인</li>
        </ul>
    </section>

    <!-- 메인화면 -->
    <section class="section_main">
        <!-- 타이틀 -->
        <h1>회원 관리</h1>

        <ul class="user_table">
            <li class="table_title">
                <span>No.</span>
                <span>아이디</span>
                <span>이메일</span>
                <span>소셜 타입</span>
            </li>
            <c:forEach items="${ user_list }" var="user" varStatus="status">
   	            <li>
	                <span>${ status.count }</span>
	                <span>${ user.id }</span>
	                <span>${ user.auth_email }</span>
	                <span>${ user.platform }</span>
            	</li>
            </c:forEach>
            
        </ul>
    </section>
</body>
</html>