<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript">
$(function(){
	
});//ready

function getParameterByName(name) { //url parameter 가져오는 정규식
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
            results = regex.exec(location.search);
    return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}//getParameterByName

function removeComm(comm_num){
	if (confirm("댓글을 삭제하시겠습니까?")){
		$.ajax({
			url : "remove_comment.do",
			type : "POST",
			data : "comm_num="+comm_num,
			dataType : "JSON",
			error : function(xhr){
				alert("error : " + xhr.status+" / "+xhr.statusText);
			},
			success : function(json){
				if (json.delete_flag){
					$("#commContent"+comm_num).html("");
					$("#deleteFlag"+comm_num).html("삭제된 댓글입니다.");
				}//end if
			}//success
		});//ajax
	}//end if
}//removeComm

function movePage(page){
	var post_num = getParameterByName('post_num');
	$.ajax({
		url : "move_comment_list.do?post_num="+post_num,
		type : "GET",
		data : "page="+page,
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		dataType : "JSON",
		error : function(xhr){
			alert("error : " + xhr.status+" / "+xhr.statusText);
		},
		success : function(json){
			var output = '';
			output += '<table id="commTable" class="table user_table">';
			output += '<thead><tr id="nameTr">';
			output += '<th scope="col" id="commNumTh">댓글 번호</th>';
			output += '<th scope="col" id="idTh">아이디</th>';
			output += '<th scope="col" id="commContentTh">내용</th>';
			output += '<th scope="col" id="dateTh">작성일</th>';
			output += '<th scope="col" id="commManageTh">댓글 관리</th>';
			output += '</tr></thead>';
			output += '<tbody>';
			$.each(json.comment_list, function(idx, list){
				output += '<tr><td>' + list.comm_num + '</td>';
				output += '<td>' + list.id + '</td>';
				
				if (list.comm_content == null){
					output += '<td id="commContent">&nbsp;</td>';
				} else {
					output += '<td id="commContent">' + list.comm_content + '</td>';
				}//end else
				output += '<td>';

				var year = list.input_date.substr(0,4);
				var month = list.input_date.substr(5,2);
				var day = list.input_date.substr(8,2);
				output += year + '-' + month + '-' + day;
				
				output += '</td>';
				output += '<td>';
				if (list.delete_flag == "F"){
				output += '<button type="button" class="btn btn-dark" id="commDelBtn" onclick="removeComm(\'' + list.comm_num + '\');">삭제</button>';
				} else {
				output += '삭제된 댓글입니다.';
				}//end else
				output += '</td>';
				output += '</tr>';
			});//each
			output += '</tbody></table>';
			
			$("#commentContent").html(output);
			$("#pagination").html(json.pagination);
		}//success
	});//ajax
}//movePage

</script>
	<div id="commentContainer">
		<h1>댓글</h1>
		<div id="commentContent">
			<table id="commTable" class="table user_table">
			  <thead>
			    <tr id="nameTr">
			      <th scope="col" id="commNumTh">댓글 번호</th>
			      <th scope="col" id="idTh">아이디</th>
			      <th scope="col" id="commContentTh">내용</th>
			      <th scope="col" id="dateTh">작성일</th>
			      <th scope="col" id="commManageTh">댓글 관리</th>
			    </tr>
			  </thead>			
			  <tbody>
			  	<c:if test="${ comment_list ne null }">
			    <c:forEach var="cl" items="${ comment_list }">
				    <tr>
				      <td>${ cl.comm_num }</td>
				      <td>${ cl.id }</td>
					  <td id="commContent${ cl.comm_num }">${ cl.comm_content }</td>
				      <td>
				      	<fmt:parseDate var="originalDate" value="${ cl.input_date }" pattern="yyyy-MM-dd HH:mm:ss.SSS"/>
				      	<fmt:formatDate var="date" value="${ originalDate }" pattern="yyyy-MM-dd"/>
				      	${ date }
				      </td>
				      <td id="deleteFlag${ cl.comm_num }">
				      	<c:if test="${ cl.delete_flag eq 'F' }">
				      		<button type="button" class="btn btn-dark" id="commDelBtn" onclick="removeComm('${ cl.comm_num }');">삭제</button>
				      	</c:if>
				      	<c:if test="${ cl.delete_flag eq 'T' }">
				      		삭제된 댓글입니다.
				      	</c:if>
					  </td>
				    </tr>
			    </c:forEach>
			  	</c:if>
			  	<c:if test="${ comment_list eq '[]' }">
			  		<tr><td colspan="5">작성된 댓글이 없습니다.</td></tr>
			  	</c:if>
			  </tbody>
			</table>
		</div>
		<c:if test="${ comment_list ne '[]' }">
		<div id="pagination">
			<c:out value="${ pagination }" escapeXml="false"/>
		</div>
		</c:if>
	</div>
