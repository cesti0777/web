<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<style type="text/css">
 .footer {
  	position: fixed;
      text-align: center;
      background: #2E303D;

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
  <jsp:include page="header.jsp"/>
</div>


<div class="w3-container" style="height: 80%">
  service1 page입니다
</div>



<div  class="footer w3-container w3-red " style="height: 10%;">
	<%@ include file="footer.html" %>
</div>



</body>
</html>

