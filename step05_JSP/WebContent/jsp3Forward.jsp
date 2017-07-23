<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	System.out.println("jsp3Forward.jsp");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>jsp3Forward.jsp</title>
</head>
<body>
	데이터 입력(web query string조합)해서 
	jsp4Forward.jsp 로 포워딩해 보기<br>

	<%-- jsp tag로 forward 방식으로 화면 이동 
	http://ip:port/project명/view/jsp4Forward.jsp?msg=master
	--%>
	<jsp:forward page="./view/jsp4Forward.jsp">
		<jsp:param value="master" name="msg"/>
	</jsp:forward>	
</body>
</html>