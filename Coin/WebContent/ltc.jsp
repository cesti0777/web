<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="sessionCheck.jsp" flush="false" />
<!DOCTYPE HTML>
<html>
<head>
<title>coINsight - 라이트코인</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="assets/css/main.css" />
<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
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

		<!-- Main -->
		<div id="main" class="alt">

			<!-- One -->
			<section id="one">
				<div class="inner">
					<header class="major">
						<h1><img src="images/ltc_logo.png" width="70" height="70"> LTC _ 라이트코인</h1>
					</header>
					<span class="image main">
						<p id="areaText"></p> <script>
							$.ajax({
								url : "graph/all_graph.jsp",
								data : {msg : "'./file/LTC_price.csv'"},
								  cache: false
								})
								  .done(function( html ) {
									$("#areaText").append("<h3 style='text-align:center'> [ 시세 정보 (단위 : KRW) ]</h3>");
									$("#areaText").append( html );
								    $("#clickButton2").css("display","none");
								  });
						</script>
					</span>
				</div>
			</section>
			<ul class="actions"
				style="width: 100px; margin: 20px auto; margin-bottom: 100px;">
				<li style="width: 100px;">
					<button id="clickButton" onclick="openVolume()">거래량보기</button>
					<button id="clickButton2" onclick="openVolume()">시세보기</button>
				</li>
			</ul>
		</div>
		<script>
			count = 1;
			function openVolume() {
			
			if (count == 1) {
					$.ajax({
						url : "graph/all_graph.jsp",
						data : {msg : "'./file/LTC_volume.csv'"},
						cache : false
					}).done(function(html) {
						$("#areaText").html("<h3 style='text-align:center'> [ 거래량 정보 (단위 : KRW) ]</h3>");
						$("#areaText").append(html);
						$("#clickButton2").css("display","block");
						$("#clickButton").css("display","none");
					});
					count = 0;
				} else {
					$.ajax({
						url : "graph/all_graph.jsp",
						data : {msg : "'./file/LTC_price.csv'"},
						cache : false
					}).done(function(html) {
						$("#areaText").html("<h3 style='text-align:center'> [ 시세 정보 (단위 : KRW) ]</h3>");
						$("#areaText").append(html);
						$("#clickButton").css("display","block");
						$("#clickButton2").css("display","none");
					});
					count = 1;
				}
			}
		</script>

		<!-- Footer -->
		<footer id="footer">
			<div class="inner"
				style="padding: 10px !important; text-align: center; width: 60%;">
				<ul class="copyright">
					<li>ⓒ 2017. kData Bitcoin Viewer Team all rights reserved.</li>
				</ul>
			</div>
		</footer>

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