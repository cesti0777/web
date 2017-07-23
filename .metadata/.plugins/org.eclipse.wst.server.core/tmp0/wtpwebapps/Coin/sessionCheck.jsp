<%@ page language="java" contentType="text/html; charset=EUC-KR" 
    pageEncoding="EUC-KR"%> 
<%
String log_check = (String)session.getAttribute("id"); 
boolean login = log_check == null ? false : true; 
if (!login) {
%>
<jsp:forward page="login.jsp" /> 
<%
}
%> 
