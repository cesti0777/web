<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>W3.CSS</title>
<!-- <meta name="viewport" content="width=device-width, initial-scale=1">
 -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<style type="text/css">
.footer {
	position: relative;
	text-align: center;
	width: 100%;
	height: 50px;
	bottom: 0;
	left: 0;
	line-height: 50px;
}
</style>

</head>
<body>


<div class="w3-container w3-red" style="height: 10%">
	<%-- 
		모든 web page에서 공통적으로 사용되는 메뉴가 있을 경우 해당 메뉴 로직들로만 구성된 jsp
		header.jsp로 분리해서 개발
		필요한 위치(jsp에 한해서)에는 포함이 가능
			- <jsp:include page = "포함하고자 하는 jsp">
			- 실시간 header.jsp를 수정할 경우 서버 재 실행하지 않고도 실시간 수정 내용이 client에게 서비스 가능
			- <%@ include file="포함시킬 html or jsp" %>
				- 최초 jsp를 요청할 경우 servlet으로 변환시에만 적용하는 tag			
	 --%>
  <jsp:include page="header.jsp"/>
</div>


<div class="w3-container" style="height: 80%">
  home화면입니다.<br><br><Br><br><br><Br>
 
</div>



<div  class="footer w3-container w3-red " style="height: 10%;">
	<%@ include file="footer.html" %>
</div>



</body>
</html>

