<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자_유저 관리화면</title>
    <link rel="icon" href="./images/icon/favicon.ico" />
	<link rel="shortcut icon" href="favicon.ico" />
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <!-- Google CDN -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
   	<!-- Chart.js -->
	<script	src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"></script>
	
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin_stat.css">
    <link rel="stylesheet" href="css/admin_common_header.css">
    
    <script>
    $(function(){
    	console.log("페이지 로드 됨")
     	queryReports("31daysAgo", "today", "entrances", "date", "방문자 수") 
    })
    function queryReports(startDate, endDate, expression, name, label) {
    	
    	var key = new Array();
    	var value = new Array();
    	
    	var param = {
    			startDate : startDate,
    			endDate : endDate,
    			metrics : expression,
    			dimensions : name
    		}
    	$.ajax({
    		method:'GET',
    		dataType:'json',
    		url:"analytics_admin.do",
    		contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
    		data:param,
    		async:false,
    		success:function(result){
    			console.log(result.reports[0].data.rows)
    			result = result.reports[0].data.rows;
    			for(var i=0; i<result.length; i++){
    		    	key[i]=result[i].dimensions[0];
    		    	value[i]=result[i].metrics[0].values[0];
    		    	console.log(key[i], value[i])
    			}
    			 
    		},
    		error:function(error){
    			
    		}
    	})
    	console.log(key, value, label)
    	if(label === "방문자 수") {
        	drawChart(key,value,label); 		
    	} else {
    		postViewTable(key, value);
    	}
    }

    function drawChart(key, value, label_name){
    	
    	for(var i=0; i<key.length; i++){
    		var year=key[i].substring(0,4);
    		var month=key[i].substring(4,6);
    		var date=key[i].substring(6,8);
    		
    		key[i]=month+'-'+date;
    	}
    	
    	 /*차트*/
    	 var ctx = document.getElementById('siteUse').getContext('2d');
    	 var myChart = new Chart(ctx, {
    	     type: 'line',
    	     data: {
    	         labels: key,
    	         datasets: [{
    	        	 label : label_name,
    	             data: value,
    	             backgroundColor: [
    	                 'rgba(255, 255, 255, 0)'
    	             ],
    	             borderColor: [
    	                 'rgba(244, 121, 42, 1)'
    	             ],
    	             borderWidth: 1,
    	             lineTension: 0
    	         }]
    	     },
    	     options: {
    	         scales: {
    	             yAxes: [{
    	                 ticks: {
    	                     beginAtZero: true
    	                 },
    	             }]
    	         }
    	     }
    	 });

    	
    }
    </script>
</head>
<body>
    <!-- 헤더 -->
        <c:import url="../common/common_header.jsp" />
    <!-- 헤더 end -->


    <!-- 메인화면 -->
    <section class="section_main">
        <!-- h1 메인 타이틀, h2 소제목 -->
        <h1>통계 관리</h1>
        
        <h2>전체 방문자 수 추이</h2>
        	<canvas id="siteUse"></canvas>

        <h2>인기글(상위 5개)</h2>
        <ul class="stat_table">
            <!-- 표의 분류 -->
            <li class="table_title">
                <span>No.</span>
                <span>제목</span>
                <span>작성자</span>
                <span>좋아요</span>
            </li>
            <!-- 데이터 넣을 때엔 여기서부터 li하나씩 foreach 하면 돼용 -->
            <c:forEach items="${ like_list }" var="post" varStatus="status">
            <li>
                <span>${ status.count }</span>
                <span>${ post.post_title }</span>
                <span>${ post.id }</span>
                <span>${ post.cnt }</span>
            </li>
			</c:forEach>
        </ul>
    </section>
    
</body>
</html>