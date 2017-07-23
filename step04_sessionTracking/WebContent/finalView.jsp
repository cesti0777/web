<%@ page contentType="text/html; charset=euc-kr" 
				  pageEncoding="euc-kr" %>
				  
<%System.out.println("finalView.jsp"); %>				  

${id}<br>
${sessionScope.id}<br>
${name}<br>
${sessionScope.name}<br>


<%
	session.invalidate();
	session = null;
%>		
		
