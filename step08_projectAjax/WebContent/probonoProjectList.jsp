<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<% String url = application.getContextPath() + "/"; %>
<table border="1">
	<tr>
		<th>프로젝트 id</th><th>프로젝트명</th><th>재능기부자 id</th>
		<th>재능 수혜자  id</th><th>재능기부 내용</th>
	</tr>
	<c:forEach items="${requestScope.probonoProjectAll}" var="dataAll"> 
 		<tr>
 			<td>${dataAll.probonoProjectId}</td>
 			<td>${dataAll.probonoProjectName}</td>
 			<td><a href='<%=url%>probono?command=activist&activistId=${dataAll.activistId}'>${dataAll.activistId}</a></td>
 			<td><a href='${pageContext.request.contextPath}/probono?command=recipient&recipientId=${dataAll.receiveId}'>${dataAll.receiveId}</a></td>
 			<%-- http://ip:port/project명/probono?c~~ 상동 --%>
 			
 			
 			<td>${dataAll.projectContent}</td>
 		</tr>
 	</c:forEach> 
</table>

<br><br><br>
<font color="blue">재능 기부자 id 및 재능 수혜자 id를 클릭하면 상세 정보 확인이 가능합니다</font>

</center>
</body>
</html>