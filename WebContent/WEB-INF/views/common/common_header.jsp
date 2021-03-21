<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <section class="section_header">
        <ul>
            <li class="logo">co-doing</li>
            <li class="cate"><a href="post_list.do">글 관리</a></li>
            <li class="cate"><a href="user_list.do">회원 관리</a></li>
            <li class="cate"><a href="">통계 관리</a></li>
        </ul>
        <ul>
            <li class="cate"><a href="pass_chk_frm.do">설정</a></li>
    		<c:if test="${ empty sessionScope.id }">
				<li class="cate"><a href="index.do">로그인</a></li>
			</c:if>
			<c:if test="${ not empty sessionScope.id }">
				<li class="cate"><a href="logout.do">로그아웃</a></li>
			</c:if>
        </ul>
    </section>