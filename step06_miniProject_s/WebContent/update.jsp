<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="model.*" %>

<html>
<head>
<title>���� ���� ����</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
</head>
<body>
<%
   CustomerVo cvo = (CustomerVo)session.getAttribute("cvo");
%>
<br>
<center>
<h3>���� ���� �����ϱ�</h3>
<br>

<form action="CustomerServlet" method="post">
	  <!-- update Form  -->	
	  <table border="1" cellspacing="1" width="60%">
		  <tr>
			<td width=30%>����� ���̵�</td>
			<td width=70%>	
				${sessionScope.cvo.id}			
			</td>
		  </tr>
		  <tr>
			<td width="30%">�̸�</td>
			<td width="70%">	
				${sessionScope.cvo.name}	
			</td>
		  </tr>
		  <tr>
			<td width="30%">��й�ȣ ����</td>
			<td width="70%">
				<input type="password" name="password" value="${sessionScope.cvo.password}">
			</td>
		  </tr>			  
		
		  <tr>
		
			<td width="30%">�̸��� �ּ�</td>
			<td width="70%">
				<input type="text" name="email" value="${sessionScope.cvo.email}">
			</td>		  
		  <tr>				  
	</table>  
	<p/>

	<%-- hidden tag�ϼ� �ϼ���
			 value������ �����ؾ� �ϴ� ����? 
	--%>
	<input type="hidden" value="update"  name="command">
	<input type="hidden" value="${sessionScope.cvo.id}"  name="id">
	<input type="hidden" value="${sessionScope.cvo.name}"  name="name">

	<input type="submit" value="����" > &nbsp;
	<input type="reset" value="���">&nbsp;
	<input type="submit" value="��κ���" name="allList">
</form>

</body>
</html>
