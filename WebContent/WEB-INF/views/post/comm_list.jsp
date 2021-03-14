<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript">
$(function(){
	
});//ready

function removeComm(comm_num){
	//location.href="post_detail.do?post_num="+post_num;
}//viewDetail
</script>
	<div id="container">
		<h1>댓글</h1>
		<div id="containerContent">
			<table id="commTable" class="table user_table" style="border: 1px solid #333">
			  <thead>
			    <tr style="background-color: #e8e8e8; font-weight: 600">
			      <th scope="col" id="commNumTh">댓글 번호</th>
			      <th scope="col" id="idTh">아이디</th>
			      <th scope="col" id="commContentTh">내용</th>
			      <th scope="col" id="dateTh">작성일</th>
			      <th scope="col" id="commManageTh">댓글 관리</th>
			    </tr>
			  </thead>			
			  <tbody>
			    <c:forEach var="cl" items="${ comment_list }">
				    <tr>
				      <td>${ cl.comm_num }</td>
				      <td>${ cl.id }</td>
					  <td>${ cl.comm_content }</td>
				      <td>
				      	<fmt:parseDate var="originalDate" value="${ cl.input_date }" pattern="yyyy-MM-dd HH:mm:ss.SSS"/>
				      	<fmt:formatDate var="date" value="${ originalDate }" pattern="yyyy-MM-dd"/>
				      	${ date }
				      </td>
				      <td>
				      	<c:if test="${ cl.delete_flag eq 'F' }">
				      		<button type="button" class="btn btn-dark" id="commDelBtn" onclick="removeComm('${ cl.comm_num }');">삭제</button>
				      	</c:if>
				      	<c:if test="${ cl.delete_flag eq 'T' }">
				      		삭제된 댓글입니다.
				      	</c:if>
					  </td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		</div>
	</div>
