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
	location.href="post_list.do";
}//end if

</script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/pass_chk_form.css">
<link rel="stylesheet" href="css/admin_common_header.css">

<!-- Google CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script type="text/javascript">


$(function() {
});

function enterkey() { 
	if (window.event.keyCode == 13) { 
		try_login();
	} 
}//enterkey


//로그인 시도
function try_check(){

	//pass 유효성 검사
	if($("#cur_pass").val().trim().length == 0) {
		alert("현재 비밀번호를 입력해주세요.");
		$("#cur_pass").focus();
		return;
	}//end if
	
	$("#passChkFrm").submit();
}//try_login

</script>
</head>
<body>
<c:if test="${ not empty login_fail }">
</c:if>
<div id="container">
	<c:import url="../common/common_header.jsp"/>

	<div class="logo-div">
		<img src="images/codoing1.png"/>
	</div>
	<div class="frm_div">
		<form id="passChkFrm" action="pass_chk.do" method="post" class="check-frm">
			<input type="hidden" id="hid"/>
			<div class="text-div">
				<label class="text-label">현재 비밀번호 확인</label><br/>
			    <div class="text-box">
					<input type="password" name="pass" id="cur_pass" class="form-control" onkeyup="enterkey()"/>
			    </div>
			</div>
			<div>
				<input type="button" value="확인" id="checkBtn" class="form-control" onclick="try_check()"/>
			</div>
		</form>
	</div>
</div>
</body>
</html>