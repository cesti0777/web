<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��� Activist list ȭ��</title>
</head>
<body>
<br><br><br>
<center>
<h3>��� ����� list</h3>
<hr><p>

<table border="1">
	<thead>
		<tr>
			<th>����� id</th><th>����� �̸�</th><th>�ֿ� �о�</th>
		</tr>
	</thead>
	
	<%--???
	 	��� ����� ���� ���� : ����� id�� Ŭ���ϸ� "��� �����"�� ���� ������ ����Ǿ�� �� --%>
	<c:forEach> 
 		<tr>
 			<td><a href='<%=url%>probono?command=????'>${dataAll.id}</a></td>
 			<td>${dataAll.name}</td>
 			<td>${dataAll.major}</td>
 		</tr>
 	</c:forEach> 
</table>

<br><br><br>
<font color="blue">��� ����� id�� Ŭ���ϸ� �� ���� Ȯ���� �����մϴ�</font>

</center>
</body>
</html>