<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>coINsight - 회원가입</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="assets/css/main.css" />
<style type="text/css">
form .field.half {
	width: 100% !important;
	float: none;
	padding: 0;
}

#contact>.inner>:nth-child(2n - 1) {
	width: 55% !important;
	margin: 0 auto;
	padding-right: 0px !important;
	border-right: 0px !important;
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
					<li><a href="coin?command=logout" class="button special fit">Log
							Out</a></li>
				</c:if>
			</ul>
		</nav>

		<!-- Contact -->
		<section id="contact">
			<div class="inner">
				<section>
					<script src="scripts/jquery-3.1.1.js"></script>
					<script src="scripts/jquery.validate.min.js"></script>
					<script
						src="http://ajax.microsoft.com/ajax/jquery.validate/1.11.1/additional-methods.js"></script>
					<script>
                        $(document).ready(function(){
                            $('#joinForm').validate({
                                onfocusout: false,
                                rules: {
                                   id:{required:true, rangelength:[5,10]},
                                   pw:{required:true, rangelength:[5,15]},
                                    name: {required: true, rangelength:[1,15]}, 
                                    email: { required: true, email: true}
                                }, messages: {
                                   id:{
                                       required:"<i class='fa fa-warning' style='font-size:24px; color:yellow;'></i> ID를 입력하세요", // 이와 같이 규칙이름과 메시지를 작성
                                       rangelength:"<i class='fa fa-warning' style='font-size:24px; color:yellow;'></i> 5글자 이상, 10글자 이하여야 합니다"
                                   },
                                   pw:{
                                       required:"<i class='fa fa-warning' style='font-size:24px; color:yellow;'></i> 패스워드를 입력하세요",
                                       rangelength:"<i class='fa fa-warning' style='font-size:24px; color:yellow;'></i> 5글자 이상, 15글자 이하여야 합니다"
                                   }, 
                                   name: {
                                        required: "<i class='fa fa-warning' style='font-size:24px; color:yellow;'></i> 이름을 입력하세요",
                                    }, 
                                    email: {
                                        required: "<i class='fa fa-warning' style='font-size:24px; color:yellow;'></i> 이메일을 입력하세요",
                                        email: "<i class='fa fa-warning' style='font-size:24px; color:yellow;'></i> 올바른 이메일 주소가 아닙니다"
                                    }
                                }
                            });
                        });
                        </script>
					<form id="joinForm" name="joinForm" method="post" action="coin">
						<h2
							style="text-align: center; border-bottom: 2px solid; border-bottom-color: white; margin-bottom: 80px; margin-top: 0px !important;">회&nbsp;&nbsp;&nbsp;원&nbsp;&nbsp;&nbsp;가&nbsp;&nbsp;&nbsp;입</h2>
						<div class="field half">
							<label for="name">이름</label> <input type="text" name="name"
								id="name" />
						</div>
						<div class="field half">
							<label for="id">아이디</label> <input type="text" name="id" id="id" />
						</div>
						<div class="field half">
							<label for="pw">비밀번호</label> <input type="password" name="pw"
								id="pw" />
						</div>
						<div class="field half">
							<label for="email">이메일</label> <input type="text" name="email"
								id="email" />
						</div>
						<!-- <div class="field">
                              <label for="message">Message</label>
                              <textarea name="message" id="message" rows="6"></textarea>
                           </div> -->
						<br> <input type="hidden" name="command" value="memberInsert" />

						<ul class="actions" style="margin: 0 auto !important; width: 44%;">
							<li><input type="submit" value="가입 신청" class="special" /></li>
							<li><input type="reset" value="다시 작성" /></li>
						</ul>
					</form>
				</section>
			</div>
		</section>

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
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="assets/js/main.js"></script>

</body>
</html>