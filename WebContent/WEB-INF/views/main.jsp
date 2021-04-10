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
	if(${ not empty sessionScope.id }){
		location.href="post_list.do";
	}//end if
	
	if(${ not empty login_fail}){
		alert("아이디나 비밀번호를 확인해주세요.");
	}//end if
	
	if(${ not empty modify_fail}){
		alert("요청 처리 중 문제가 발생하였습니다. 다시 시도해 주세요.");
	}//end if
	
	if(${ not empty modify_success}){
		alert("비밀번호 변경을 완료했습니다. 로그인 후 이용해 주세요.");
	}//end if
</script>


<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/admin_login.css">

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
function try_login(){
	//id 유효성검사
	if($("#admin_id").val().trim().length == 0) {
		alert("아이디를 입력해주세요.");
		$("#admin_id").focus();
		return;
	}
	//pass 유효성 검사
	if($("#admin_pass").val().trim().length == 0) {
		alert("비밀번호를 입력해주세요.");
		$("#admin_pass").focus();
		return;
	}
	
	$("#loginFrm").submit();
}//try_login

</script>
</head>
<body>
<div id="container">

	<div class="logo-div">
		<img src="images/codoing1.png"/>
	</div>
	
	<div class="frm_div">
		<form id="loginFrm" action="login.do" method="post" class="login-frm">
			<div class="text-div">
				<label class="text-label">아이디</label>
			    <div class="text-box">
					<input type="text" name="id" id="admin_id" class="form-control"/>
			    </div>
			</div>
			<div class="text-div">
				<label class="text-label">비밀번호</label>
			    <div class="text-box">
					<input type="password" name="pass" id="admin_pass" class="form-control" onkeyup="enterkey()"/>
			    </div>
			</div>
			<div>
				<input type="button" value="LOGIN" id="loginBtn" class="form-control" onclick="try_login()"/>
			</div>
		</form>
	</div>
</div>
</body>
</html>