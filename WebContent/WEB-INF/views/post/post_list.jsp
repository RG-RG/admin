<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 - 글 관리</title>
<script type="text/javascript">
if(${ empty sessionScope.id }){
	alert("로그인 후 이용해 주세요");
	location.href="index.do";
}//end if

</script>
<style type="text/css">
tr:nth-child(even) { background-color: #f5f5f5 }
tr:hover{ background-color: #ffdbd0 }
table { table-layout: fixed; word-break:break-all }
#container{ width: 80rem; margin: 0 auto }
#postNumTh{ width: 10rem }
#idTh{ width: 12rem }
#dateTh{ width: 13rem }
#postTitleTh{ width: 30rem }
#postManageTh{ width: 15rem }
.btn-dark{ font-size: 1.2rem !important }
#pagination{ margin-top: 5rem }
.page-link{ cursor: pointer; }
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/admin_user_manage.css">
<link rel="stylesheet" href="css/admin_pagination.css">

<script type="text/javascript">
$(function(){
	
});//ready

function viewDetail(post_page, post_num){
	if (post_page == ''){
		post_page = 1;
	}//end if
	location.href="post_detail.do?post_page="+post_page+"&post_num="+post_num;
}//viewDetail

function movePage(post_page){
	location.href = "post_list.do?post_page="+post_page;
}//movePage

</script>
</head>
<body>
<div id="wrap">
	<c:import url="../common/common_header.jsp"/>
	
	<section class="section_main">
	<div id="container">
		<h1>글 관리</h1>
		<div id="containerContent">
			<table class="table table-hover user_table">
			  <thead>
			    <tr style="background-color: #e8e8e8; font-weight: 600">
			      <th scope="col" id="postNumTh">글 번호</th>
			      <th scope="col" id="idTh">아이디</th>
			      <th scope="col" id="postTitleTh">제목</th>
			      <th scope="col" id="dateTh">작성일</th>
			      <th scope="col" id="postManageTh">글 관리</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:if test="${ post_list ne null }">
			    <c:forEach var="pl" items="${ post_list }">
				    <tr>
				      <td>${ pl.post_num }</td>
				      <td>${ pl.id }</td>
					  <c:set var="post_title" value="${ pl.post_title }" />
					  <td>${ fn:substring(post_title, 0, 20) }</td>
				      <td>
				      	<fmt:parseDate var="originalDate" value="${ pl.input_date }" pattern="yyyy-MM-dd HH:mm:ss.SSS"/>
				      	<fmt:formatDate var="date" value="${ originalDate }" pattern="yyyy-MM-dd"/>
				      	${ date }
				      </td>
				      <td>
				      	<c:if test="${ pl.delete_flag eq 'F' }">
				      		<button type="button" class="btn btn-dark" onclick="viewDetail('${ param.post_page }','${ pl.post_num }');">상세보기</button>
				      	</c:if>
				      	<c:if test="${ pl.delete_flag eq 'T' }">
				      		삭제된 글입니다.
				      	</c:if>
					  </td>
				    </tr>
			    </c:forEach>
			  </c:if>
			  </tbody>
			  <c:if test="${ post_list eq '[]' }">
			  	<tbody>
				  	<tr><td colspan="5">작성된 글이 없습니다.</td></tr>
			  	</tbody>
			  </c:if>
			</table>
			<c:if test="${ post_list ne '[]' }">
			<div id="pagination">
				<c:out value="${ pagination }" escapeXml="false"/>
			</div>
			</c:if>
		</div>
	</div>
	</section>
	
</div>
</body>
</html>