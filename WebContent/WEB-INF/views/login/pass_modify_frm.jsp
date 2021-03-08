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
	alert("로그인 후 이용해 주세요.");
	location.href="index.do";
}//end if

if(${ not empty check_fail}){
	alert("현재 비밀번호를 확인해주세요.");
	location.href="pass_chk_frm.do";
}//end if

</script>
<style type="text/css">
#container{ min-height: 600px; display: flex; flex-direction: column; justify-content: center;}
.logo-div {text-align: center; padding: 50px;}

.frm_div {display: flex; justify-content: center;}
.pass-modify-frm { width: 25%;}

.text-div{margin-bottom: 1rem; display: flex; justify-content:space-between;}
.text-label{padding-top:10px;}
.text-box{padding: 0px; display: flex; justify-content: flex-end; width: 75%}

#modifyBtn {background-color: #0F4C81; border: 1px solid #17462B; color:#fff}
</style>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

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
function try_modify(){
	//id 유효성검사
	if($("#new_pass").val().trim().length == 0) {
		alert("새 비밀번호를 입력해주세요.");
		$("#new_pass").focus();
		return;
	}
	//pass 유효성 검사
	if($("#new_pass_chk").val().trim().length == 0) {
		alert("새 비밀번호를 한번 더 입력해주세요.");
		$("#new_pass_chk").focus();
		return;
	}
	
	if($("#new_pass").val()!=$("#new_pass_chk").val()){
		alert("입력하신 비밀번호가 다릅니다. 다시 입력해주세요.");
		return;
	}
	
	$("#passModifyFrm").submit();
}//try_login

</script>
</head>
<body>
<div id="container">
	<div class="logo-div">
		<!-- <img src="common/images/logo_green.png"/> -->
	</div>
	<div class="frm_div">
		<form id="passModifyFrm" action="modify_pass.do" method="post" class="pass-modify-frm">
			<div class="text-div">
				<label class="text-label">새 비밀번호</label>
			    <div class="text-box">
					<input type="password" name="pass" id="new_pass" class="form-control"/>
			    </div>
			</div>
			<div class="text-div">
				<label class="text-label">새 비밀번호 확인</label>
			    <div class="text-box">
					<input type="password" name="pass_chk" id="new_pass_chk" class="form-control" onkeyup="enterkey()"/>
			    </div>
			</div>
			<div>
				<input type="button" value="변경" id="modifyBtn" class="form-control" onclick="try_modify()"/>
			</div>
		</form>
	</div>
</div>
</body>
</html>