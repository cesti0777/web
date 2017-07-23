<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%String url = application.getContextPath() + "/";%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
	<head>
		<title>coINsight - LoginResult</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<style type="text/css">
			form .field.half {
					width: 100% !important;
					float: none;
					padding: 0;
				}
			#contact > .inner > :nth-child(2n - 1) {
				width:55% !important;
				margin: 0 auto;
				padding-right:0px !important;
				border-right:0px !important;
			}
		</style>
	</head>
	<body>

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
		<header id="header">
         <a href="index.jsp" class="logo"><img src="images/coinsight.png"
            style="width: 260px; height: 60px;"></a>
         <nav>
            <c:if test="${empty sessionScope.member}">
               <p>
                  <a href="join.jsp">JOIN</a>
               </p>
               <p>
                  <a href="login.jsp">LOGIN</a>
               </p>
            </c:if>
            <c:if test="${not empty sessionScope.member}">
               <p>${sessionScope.member.id}(${sessionScope.member.name})</p>
               <p>
                  <a href="coin?command=logout">logout</a>
               </p>
            </c:if>
            <a href="#menu">Menu</a>
         </nav>
      </header>


      <!-- Menu -->
      <nav id="menu">
         <ul class="links">
            <li><a href="index.jsp">Home</a></li>
            <li><a href="coin?command=wallet">Wallet</a></li>
            <li><a href="index.jsp#hidden">Real Time Chart</a></li>
            <li><a href="index.jsp#one">Coin Graph</a></li>
         </ul>
         <ul class="actions vertical">
            <c:if test="${empty sessionScope.member}">
            	<li><a href="login.jsp" class="button special fit">Log In</a></li>		
			</c:if>
			<c:if test="${not empty sessionScope.member}">
				<li><a href="coin?command=logout" class="button special fit">Log Out</a></li>	
			</c:if>
         </ul>
      </nav>

				<!-- Contact -->
		<section id="contact">
			<div class="inner">
				<center>
				<img src="images/success.png" style="width:250px; height:250px; margin-bottom:50px;">
					<h2>coINsight의 회원이 되신 것을 환영합니다.</h2>
					<br> <a class="button special default" href="<%=url%>login.jsp">로그인 화면으로 이동하기</a>
					<br><br>
				</center>
			</div>
		</section>

		<!-- Footer -->
					<footer id="footer">
						<div class="inner" style="padding:10px !important; text-align:center; width:60%;">
							<ul class="copyright" >
								<li>ⓒ 2017. kData Bitcoin Viewer Team all rights reserved.</li>
							</ul>
						</div>
						

			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>

	</body>
</html>