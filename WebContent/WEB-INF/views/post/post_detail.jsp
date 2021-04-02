<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Co-doing</title>
<script type="text/javascript">
if(${ empty sessionScope.id }){
	alert("로그인 후 이용해 주세요");
	location.href="index.do";
}//end if

</script>
<style type="text/css">
#container{ width: 70rem; margin: 0 auto; margin-top: 10rem; min-height: 180rem }
#containerTitle{ display: inline; margin-right: 1rem }
#moveBtn, #postDelBtn { font-size: 1.5rem !important; margin-left: 1rem; margin-bottom: 1.5rem }
.nameTd{ width: 15rem; border: 1px solid #bbb; background-color: #f5f5f5 !important; font-weight: bold; vertical-align: middle; }
.valueTd{ width: 55rem; text-align: left; border: 1px solid #bbb; padding-left: 2.5rem !important; padding-right: 2.5rem !important }
#postContent{ resize: none; background-color: #FFFFFF; width: 100%; vertical-align: middle; height: 30rem; border: 0 }
#commTable{ border: 1px solid #bbb }
#nameTr{ background-color: #e8e8e8; font-weight: 600 }
#commNumTh{ width: 8rem }
#idTh{ width: 10rem }
#commContentTh{ width: 22rem }
#dateTh{ width: 10rem }
#commManageTh{ width: 15rem }
#commDelBtn{ font-size: 1.2rem !important }
#pagination{ margin-top: 5rem }
.page-link{ cursor: pointer; }
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link rel="icon" href="./images/icon/favicon.ico" />
<link rel="shortcut icon" href="favicon.ico" />
<link rel="stylesheet" href="./css/reset.css">
<link rel="stylesheet" href="./css/admin_user_manage.css">
<link rel="stylesheet" href="./css/admin_pagination.css">
<link rel="stylesheet" href="./css/admin_common_header.css">

<script type="text/javascript">
$(function(){
	
});//ready

function removePost(){
	if (confirm("글을 삭제하시겠습니까?")){
		$("#removePostFrm").submit();
	}//end if
}//removePost

function viewPost(id, post_num){
	location.href="/"+id+"/blog/post.do?post="+post_num;
}//viewDetail

</script>
</head>
<body>
<div id="wrap">
	<c:import url="../common/common_header.jsp"/>
	
	<section class="section_main">
	<div id="container">
		<h1 id="containerTitle">글 상세보기</h1>
		<button type="button" class="btn btn-dark" id="moveBtn" onclick="viewPost('${ post_detail.id }', '${ post_detail.post_num }');">글 보러가기</button>
		<button type="button" class="btn btn-dark" id="postDelBtn" onclick="removePost();">글 삭제하기</button>
		<form id="removePostFrm" action="remove_post.do" method="POST">
			<input type="hidden" name="post_page" value="${ param.post_page }"/>
			<input type="hidden" name="post_num" value="${ post_detail.post_num }"/>
		</form>
		<div id="containerContent">
			<table class="table user_table">
			  <tbody>
			    <tr>
			      <td class="nameTd">글 번호</td>
			      <td class="valueTd">${ post_detail.post_num }</td>
			    </tr>
			    <tr>
			      <td class="nameTd">아이디</td>
			      <td class="valueTd">${ post_detail.id }</td>
			    </tr>
			    <tr>
			      <td class="nameTd">제목</td>
				  <td class="valueTd">${ post_detail.post_title }</td>
			    </tr>
			    <tr>
			      <td class="nameTd">작성일</td>
			      <td class="valueTd">
			      	<fmt:parseDate var="originalDate" value="${ post_detail.input_date }" pattern="yyyy-MM-dd HH:mm:ss.SSS"/>
			      	<fmt:formatDate var="date" value="${ originalDate }" pattern="yyyy-MM-dd"/>
			      	${ date }
			      </td>
			    </tr>
			    <tr>
			      <td class="nameTd">내용</td>
			      <td class="valueTd"><textarea id="postContent" readonly="readonly" disabled="disabled">${ post_detail.post_content }</textarea></td>
			    </tr>
			  </tbody>
			</table>
			<c:import url="/comment_list.do"/>
		</div>
	</div>
	</section>
	
</div>
</body>
</html>