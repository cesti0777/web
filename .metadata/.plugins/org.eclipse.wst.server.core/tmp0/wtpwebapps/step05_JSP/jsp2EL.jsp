<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>jsp2EL.jsp</title>
</head>
<body>
	EL tag �н�<br>
	1. �� ���� : view�� view ��� ���� ����<br>
	2. ���� : tag ������ ����<br>
	
	<br><hr><br>

	1. �ܼ� ���� �� �� ������
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

	2. �ڹ��� �����͸� EL�� ����غ��� 
	Ȥ�� ������ �� ����� �������� blank�� ���<br>
	<%
		/*
		- ������ ���� ���
			1. forward ��� ��� ����
				- request�� ������ ���� �� Ȱ��
			2. session ��� ����
				- page�̵� ��İ� �����ϰ� �����͸� ����(��������)
			*1�� 2�� client�� ����
			
			3. ��� user�� �����ϴ� �ڿ��� ServletContext��� ��ü�� applicationȰ��
		
		- jsp�� ���� ��ü ����(�ʼ��� �ϱ�)
			1. request
			2. session
			3. application
				- ������ ���� �޼ҵ� : setAttrinbute(Object key, Object value)
				- ������ ��ȯ �޼ҵ� : Object getAttrinbute(Object key)
				- ������ ���� �޼ҵ� : removeAttribyte(Object key)
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