<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
if(${ empty sessionScope.id }){
	alert("로그인 후 이용해 주세요");
	location.href="index.do";
}//end if

</script>
<style type="text/css">
#wrap{ width: 900px; height: 940px; margin: 0px auto; }
#header{ width: 900px; height: 220px; }
#container{ width:900px; height: 600px; position: relative;}
#footer{ width:900px; height: 120px; position: relative;}
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

<script type="text/javascript">

$(function() {
	$("#passChkBtn").click(function() {
		$("#passChkFrm").submit();
	});
});

/* function passChk(){
	$("#passChkFrm").submit();
} */

</script>
</head>
<body>
<div id="wrap">
	<div id="header">
	</div>
	<div id="container">
	글관리<br/>
	<a href="logout.do">로그아웃</a><br/>
	<form id="passChkFrm" action="pass_chk_frm.do" method="post">
		<input type="button" value="비밀번호 변경" id="passChkBtn" />
	</form>
	</div>
	<div id="footer">
	</div>
</div>
</body>
</html>