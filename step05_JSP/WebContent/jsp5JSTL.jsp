<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%-- �ܺ� library ��� ���� --%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	JSTL tag�н�<br>
	1. ���� tag<br>
		1-1. if tag<br>
		1-2. when choose~<br>
	2. �ݺ� tag : forEach<br>
	
	<br><hr><br>
	
	1. if ���� tag<br>
	<c:if test="${'a' == 'a'}">
		'a' == 'a' �� ��� <br>
	</c:if>
	
	<c:if test="${'a' == 'b'}">
		'a' == 'b' �� ��� <br>
	</c:if>	
	
	<%//jstl ���� tag �н��� ���� test ������ ���� - servlet ���� ����� ���°� ����
		request.setAttribute("d1", "����");
		session.setAttribute("d1", "�ٶ���");
	%>
	
	2. �ڹ� �����͸� jstl tag�� ���� üũ<br>
	<c:if test="${requestScope.d1 == '����' }">
		requestScope.d1 == '����'<br>
	</c:if>
	
	3. �������� �ִ� �����Ͱ� ��?<br>
		3-1. <%= request.getParameter("name") %><br>
		3-2. ${requestScope.name }<br>
		
		3-3. ������ ���� ���� Ȯ��<br>
	<c:if test="${requestScope.message == null }">
		������ ���� ���� Ȯ���ؼ� �����Ͱ� ����(null or blank)���� ���<br>
	</c:if>
	
		3-4. ������ ���� ���� Ȯ�� : empty ������ Ȱ��(data�� ������ true)<br>
	<c:if test="${empty requestScope.message}">
		������ ���� ���� Ȯ���ؼ� �����Ͱ� ����(null or blank)���� ���<br>
	</c:if>
	
		3-5. ������ ���� ���� Ȯ�� : not empty ������ Ȱ��(data�� ������ true)<br>
	<c:if test="${not empty requestScope.d1}">
		������ ���� ���� Ȯ���ؼ� �����Ͱ� ���� ���� ���<br>
	</c:if>
	
	<br><hr><br>
	
	4. when���� tag
	<c:choose>
		<c:when test="${1==1 }">
			1==1<br>
		</c:when>
		<c:when test="${2 == 2}">
		 	2 == 2<br>
		</c:when>
		<c:otherwise>
			��� ������ ������ ������<br>
		</c:otherwise>
	</c:choose>
	
	<br><hr><br>
	
	5. jstl �ݺ� : forEach(��� �� ���� ����)<br>
		5-1. �ܼ� 1~5���� �ݺ�<br>
	<c:forEach begin="1" end="5" step="1" var="data">
		${data}-			
	</c:forEach>
	
	
</body>
</html>