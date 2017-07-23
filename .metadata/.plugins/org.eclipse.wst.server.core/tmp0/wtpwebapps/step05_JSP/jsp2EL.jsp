<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>jsp2EL.jsp</title>
</head>
<body>
	EL tag 학습<br>
	1. 주 목적 : view는 view 답게 개발 권장<br>
	2. 형식 : tag 위주의 파일<br>
	
	<br><hr><br>

	1. 단순 연산 및 비교 연산자
	<table border="1">
		<tr>
			<td>2+3</td>
			<td>${2+3}</td>
		</tr>
		<tr>
			<td>a == a</td>
			<td>${'a' == 'a'}</td>
		</tr>
		<tr>
			<td>3 != 3</td>
			<td>${3 != 3}</td>
		</tr>
	</table>
	
	<br><hr><br>

	2. 자바의 데이터를 EL로 출력해보기 
	혹여 데이터 미 존재시 브라우저엔 blank가 출력<br>
	<%
		/*
		- 데이터 유지 방식
			1. forward 방식 사용 사유
				- request에 데이터 저장 및 활용
			2. session 사용 사유
				- page이동 방식과 무관하게 데이터를 유지(상태유지)
			*1과 2는 client별 개별
			
			3. 모든 user가 공유하는 자원은 ServletContext라는 객체안 application활용
		
		- jsp는 내장 객체 존재(필수로 암기)
			1. request
			2. session
			3. application
				- 데이터 저장 메소드 : setAttrinbute(Object key, Object value)
				- 데이터 반환 메소드 : Object getAttrinbute(Object key)
				- 데이터 삭제 메소드 : removeAttribyte(Object key)
		*/
		
		request.setAttribute("reqData",	 "data1");
		session.setAttribute("sessData", "data2");
		application.setAttribute("applData", "data3");
		
		
	%>
		<%= request.getAttribute("reqData") %><br>
		<% out.println(request.getAttribute("reqData")); %><br>
		${requestScope.reqData}<br>
		${reqData}<br>
		-${reqDatafffff}-<br>

</body>
</html>