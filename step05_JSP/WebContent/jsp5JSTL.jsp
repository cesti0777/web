<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%-- 외부 library 사용 선언 --%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	JSTL tag학습<br>
	1. 조건 tag<br>
		1-1. if tag<br>
		1-2. when choose~<br>
	2. 반복 tag : forEach<br>
	
	<br><hr><br>
	
	1. if 조건 tag<br>
	<c:if test="${'a' == 'a'}">
		'a' == 'a' 의 결과 <br>
	</c:if>
	
	<c:if test="${'a' == 'b'}">
		'a' == 'b' 의 결과 <br>
	</c:if>	
	
	<%//jstl 조건 tag 학습을 위한 test 데이터 구성 - servlet 에서 저장된 상태가 가정
		request.setAttribute("d1", "경진");
		session.setAttribute("d1", "다람귄");
	%>
	
	2. 자바 데이터를 jstl tag로 조건 체크<br>
	<c:if test="${requestScope.d1 == '경진' }">
		requestScope.d1 == '경진'<br>
	</c:if>
	
	3. 없을수도 있는 데이터값 비교?<br>
		3-1. <%= request.getParameter("name") %><br>
		3-2. ${requestScope.name }<br>
		
		3-3. 데이터 존재 유무 확인<br>
	<c:if test="${requestScope.message == null }">
		데이터 존재 유무 확인해서 데이터가 없을(null or blank)때만 출력<br>
	</c:if>
	
		3-4. 데이터 존재 유무 확인 : empty 연산자 활용(data가 없으면 true)<br>
	<c:if test="${empty requestScope.message}">
		데이터 존재 유무 확인해서 데이터가 없을(null or blank)때만 출력<br>
	</c:if>
	
		3-5. 데이터 존재 유무 확인 : not empty 연산자 활용(data가 있으면 true)<br>
	<c:if test="${not empty requestScope.d1}">
		데이터 존재 유무 확인해서 데이터가 있을 때만 출력<br>
	</c:if>
	
	<br><hr><br>
	
	4. when조건 tag
	<c:choose>
		<c:when test="${1==1 }">
			1==1<br>
		</c:when>
		<c:when test="${2 == 2}">
		 	2 == 2<br>
		</c:when>
		<c:otherwise>
			모든 조건이 연관성 없을때<br>
		</c:otherwise>
	</c:choose>
	
	<br><hr><br>
	
	5. jstl 반복 : forEach(사용 빈도 무지 높음)<br>
		5-1. 단순 1~5까지 반복<br>
	<c:forEach begin="1" end="5" step="1" var="data">
		${data}-			
	</c:forEach>
	
	
</body>
</html>