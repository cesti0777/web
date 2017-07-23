<%@ page language="java" contentType="text/html; charset=euc-kr"
   pageEncoding="euc-kr"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>coINsight</title>
<meta charset="euc-kr" />
<meta name="viewport"
   content="width=device-width, initial-scale=1, user-scalable=no" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="assets/css/main.css" />
<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
<link href="https://cdn.rawgit.com/YJSoft/Webfonts/0.1/BM_HANNA.css"  rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- <link href="https://cdn.rawgit.com/singihae/Webfonts/master/style.css" rel="stylesheet" type="text/css" />
<script>
@import url('https://cdn.rawgit.com/singihae/Webfonts/master/style.css');
</script> -->
</head>
<style type="text/css">
/*  * {font-family:'BM HANNA','배달의민족 한나 ' !important, sans-serif; }  */
table { font-family:'BM HANNA'; }
.table-wrapper { font-family:'BM HANNA'; }
th {text-align:center;}
tr:nth-child(even){background-color: rgba(183, 191, 233, 0.34);}
</style>
<body>

   <!-- Wrapper -->
   <div id="wrapper">
      <!-- 실시간 코인 값 받아오는 로직 -->
      <!-- <div id="BTC"></div> -->
      <script type="text/javascript">
               var btc_c,eth_c,dash_c,ltc_c,etc_c,xrp_c,btc_c1,eth_c1,dash_c1,ltc_c1,etc_c1,xrp_c1;
               var pbtc_c,peth_c,pdash_c,pltc_c,petc_c,pxrp_c,obj,tempval;
            
               function number_format(num){
            		return String(num).replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
            	}
               
              var currency;
            	 window.onload = function(){
            		getCurrencyData();
            	}
             function getCurrencyData() {
                   $.ajax({
                   url : "http://api.fixer.io/latest?base=USD",
                   dataType : "html",
                   method : "GET",
                   success : function(result) {
                      result = result.replace(/(\s*)/g, "");         
                      obj = eval("(" + result + ")");
                      currency = obj.rates.KRW;
                      $("#krw").text(currency);
                      $("#krw2").text(currency);
                   }
               });
             }
            		   
               function myFun() {
               $.ajax({
               url : "bithumbUrl.jsp",
               dataType : "html",
               method : "GET",
               success : function(result) {
                  result = result.replace(/(\s*)/g, "");         
                  obj = eval("(" + result + ")");
                  if (obj.message == null){
                  btc_c = obj.data.BTC.closing_price;   
                  eth_c = obj.data.ETH.closing_price;
                  dash_c = obj.data.DASH.closing_price;
                  ltc_c = obj.data.LTC.closing_price;
                  etc_c = obj.data.ETC.closing_price;
                  xrp_c = obj.data.XRP.closing_price;
                  BTC_bper = ((btc_c-obj.data.BTC.opening_price)/btc_c*100).toFixed(2);
                  if(BTC_bper > 0)
                	 $("#BTC").html(number_format(btc_c) +"<div style='float:right; color:#9beb97;'>(" + BTC_bper + "%" + ")</div>");
                  else 
                	 $("#BTC").html(number_format(btc_c) +"<div style='float:right; color:red;'>(" + BTC_bper + "%" + ")</div>");
                  ETH_bper = ((eth_c-obj.data.ETH.opening_price)/eth_c*100).toFixed(2);
                  if(ETH_bper > 0)
                 	 $("#ETH").html(number_format(eth_c) +"<div style='float:right; color:#9beb97;'>(" + ETH_bper + "%" + ")</div>");
                  else
                	 $("#ETH").html(number_format(eth_c) +"<div style='float:right; color:red;'>(" + ETH_bper + "%" + ")</div>");
                  DASH_bper = ((dash_c-obj.data.DASH.opening_price)/dash_c*100).toFixed(2);
                  if(DASH_bper > 0)
                	  $("#DASH").html(number_format(dash_c) +"<div style='float:right; color:#9beb97;'>(" + DASH_bper + "%" + ")</div>");
                  else
                 	 $("#DASH").html(number_format(dash_c) +"<div style='float:right; color:red;'>(" + DASH_bper + "%" + ")</div>");
                  LTC_bper = ((ltc_c-obj.data.LTC.opening_price)/ltc_c*100).toFixed(2);
                  if(LTC_bper > 0)
                	  $("#LTC").html(number_format(ltc_c) +"<div style='float:right; color:#9beb97;'>(" + LTC_bper + "%" + ")</div>");
                  else
                 	 $("#LTC").html(number_format(ltc_c) +"<div style='float:right; color:red;'>(" + LTC_bper + "%" + ")</div>");
                  ETC_bper = ((etc_c-obj.data.ETC.opening_price)/etc_c*100).toFixed(2);
                  if(ETC_bper > 0)
                	  $("#ETC").html(number_format(etc_c) +"<div style='float:right; color:#9beb97;'>(" + ETC_bper + "%" + ")</div>");
                  else
                 	 $("#ETC").html(number_format(etc_c) +"<div style='float:right; color:red;'>(" + ETC_bper + "%" + ")</div>");
                  XRP_bper = ((xrp_c-obj.data.XRP.opening_price)/xrp_c*100).toFixed(2);
                  if(XRP_bper > 0)
                	  $("#XRP").html(number_format(xrp_c) +"<div style='float:right; color:#9beb97;'>(" + XRP_bper + "%" + ")</div>");
                  else
                 	 $("#XRP").html(number_format(xrp_c) +"<div style='float:right; color:red;'>(" + XRP_bper + "%" + ")</div>");
                 
                  }
               }
            });
         }
            //폴로닉스 api 받아오는 함수
            function myFun2() {
               $.ajax({
                  url : "poloniexUrl.jsp",
                  dataType : "html",
                  method : "GET",
                  success : function(result2) {
                     result2 = result2.replace(/(\s*)/g, "");               
                     obj = eval("(" + result2 + ")");
                     pbtc_c = parseInt(obj.USDT_BTC.last*currency);
                     peth_c = parseInt(obj.USDT_ETH.last*currency);
                     pdash_c = parseInt(obj.USDT_DASH.last*currency);
                     pltc_c = parseInt(obj.USDT_LTC.last*currency);
                     petc_c = parseInt(obj.USDT_ETC.last*currency);
                     pxrp_c = parseInt(obj.USDT_XRP.last*currency);
                     BTC_per = (obj.USDT_BTC.percentChange*100).toFixed(2);
                     if(BTC_per > 0)
                    	 $("#PBTC").html(number_format(pbtc_c) +"<div style='float:right; color:#9beb97;'>(" + BTC_per + "%" + ")</div>");
                     else 
                    	 $("#PBTC").html(number_format(pbtc_c) +"<div style='float:right; color:red;'>(" + BTC_per + "%" + ")</div>");
                     ETH_per = (obj.USDT_ETH.percentChange*100).toFixed(2);
                     if(ETH_per > 0)
                    	 $("#PETH").html(number_format(peth_c)+"<div style='float:right; color:#9beb97;'>(" + ETH_per + "%" + ")</div>");
                     else
                    	 $("#PETH").html(number_format(peth_c)+"<div style='float:right; color:red;'>(" + ETH_per + "%" + ")</div>");
                     DASH_per = (obj.USDT_DASH.percentChange*100).toFixed(2);
                     if(DASH_per > 0)
                    	 $("#PDASH").html(number_format(pdash_c)+"<div style='float:right; color:#9beb97;'>(" + DASH_per + "%" + ")</div>");
                     else
                    	 $("#PDASH").html(number_format(pdash_c)+"<div style='float:right; color:red;'>(" + DASH_per + "%" + ")</div>");
                     LTC_per = (obj.USDT_LTC.percentChange*100).toFixed(2);
                     if(LTC_per > 0)
                    	 $("#PLTC").html(number_format(pltc_c)+"<div style='float:right; color:#9beb97;'>(" + LTC_per + "%" + ")</div>");
                     else
                    	 $("#PLTC").html(number_format(pltc_c)+"<div style='float:right; color:red;'>(" + LTC_per + "%" + ")</div>");
                     ETC_per = (obj.USDT_ETC.percentChange*100).toFixed(2);
                     if(ETC_per > 0)
                    	 $("#PETC").html(number_format(petc_c)+"<div style='float:right; color:#9beb97;'>(" + ETC_per + "%" + ")</div>");
                     else
                    	 $("#PETC").html(number_format(petc_c)+"<div style='float:right; color:red;'>(" + ETC_per + "%" + ")</div>");
                     XRP_per = (obj.USDT_XRP.percentChange*100).toFixed(2);
                     if(XRP_per > 0)
                    	 $("#PXRP").html(number_format(pxrp_c)+"<div style='float:right; color:#9beb97;'>(" + XRP_per + "%" + ")</div>");
                     else
                    	 $("#PXRP").html(number_format(pxrp_c)+"<div style='float:right; color:red;'>(" + XRP_per + "%" + ")</div>");
                     if(btc_c != null && pbtc_c != null){
	                     if(btc_c>pbtc_c){
	                     tempval = (btc_c - pbtc_c)/btc_c*100;
	                     $("#BTC_p").html(tempval.toFixed(2) + "%"+ "    (<img src='images/logo_bithumb.png' width='80' height='28' style='padding-top:5px;'> <i class='fa fa-arrow-up' style='font-size:26px; color:#9beb97;'></i>)");   
	                     }
	                     else{
	                     tempval = (pbtc_c-btc_c)/btc_c*100;
	                     $("#BTC_p").html(tempval.toFixed(2) + "%"+ "   (<img src='images/poloniex.png' width='80' height='19' style='padding-top:5px;'>  <i class='fa fa-arrow-up' style='font-size:26px; color:#9beb97;'></i>)");
	                     }
                     }
                     if(eth_c != null && peth_c != null){
	                     if(eth_c>peth_c){
	                     tempval = (eth_c - peth_c)/eth_c*100;
	                     $("#ETH_p").html(tempval.toFixed(2) + "%"+ "    (<img src='images/logo_bithumb.png' width='80' height='28' style='padding-top:5px;'> <i class='fa fa-arrow-up' style='font-size:26px; color:#9beb97;'></i>)");   
	                     }
	                     else{
	                     tempval = (peth_c-eth_c)/eth_c*100;
	                     $("#ETH_p").html(tempval.toFixed(2) + "%"+ "   (<img src='images/poloniex.png' width='80' height='19' style='padding-top:5px;'> <i class='fa fa-arrow-up' style='font-size:26px; color:#9beb97;'></i>)");
	                     }
                     }
                     if(dash_c != null && pdash_c != null){
	                     if(dash_c>pdash_c){
	                     tempval = (dash_c - pdash_c)/dash_c*100;
	                     $("#DASH_p").html(tempval.toFixed(2) + "%"+ "    (<img src='images/logo_bithumb.png' width='80' height='28' style='padding-top:5px;'> <i class='fa fa-arrow-up' style='font-size:26px; color:#9beb97;'></i>)");   
	                     }
	                     else{
	                     tempval = (pdash_c-dash_c)/dash_c*100;
	                     $("#DASH_p").html(tempval.toFixed(2) + "%"+ "   (<img src='images/poloniex.png' width='80' height='19' style='padding-top:5px;'> <i class='fa fa-arrow-up' style='font-size:26px; color:#9beb97;'></i>)");
	                     }
                     }
                     if(ltc_c != null && pltc_c != null){
	                     if(ltc_c>pltc_c){
	                     tempval = (ltc_c - pltc_c)/ltc_c*100;
	                     $("#LTC_p").html(tempval.toFixed(2) + "%"+ "    (<img src='images/logo_bithumb.png' width='80' height='28' style='padding-top:5px;'> <i class='fa fa-arrow-up' style='font-size:26px; color:#9beb97;'></i>)");   
	                     }
	                     else{
	                     tempval = (pltc_c-ltc_c)/ltc_c*100;
	                     $("#LTC_p").html(tempval.toFixed(2) + "%"+ "   (<img src='images/poloniex.png' width='80' height='19' style='padding-top:5px;'> <i class='fa fa-arrow-up' style='font-size:26px; color:#9beb97;'></i>)");
	                     }
                     }
                     if(etc_c != null && petc_c != null){
	                     if(etc_c>petc_c){
	                   	 tempval = (etc_c - petc_c)/etc_c*100;
	                     $("#ETC_p").html(tempval.toFixed(2) + "%"+ "    (<img src='images/logo_bithumb.png' width='80' height='28' style='padding-top:5px;'> <i class='fa fa-arrow-up' style='font-size:26px; color:#9beb97;'></i>)");   
	                     }
	                     else{
	                     tempval = (petc_c-etc_c)/etc_c*100;
	                     $("#ETC_p").html(tempval.toFixed(2) + "%"+ "   (<img src='images/poloniex.png' width='80' height='19' style='padding-top:5px;'> <i class='fa fa-arrow-up' style='font-size:26px; color:#9beb97;'></i>)");
	                     }
                     }
                     if(xrp_c != null && pxrp_c != null){
	                     if(xrp_c>pxrp_c){
	                     tempval = (xrp_c - pxrp_c)/xrp_c*100;
	                     $("#XRP_p").html(tempval.toFixed(2) + "%"+ "    (<img src='images/logo_bithumb.png' width='80' height='28' style='padding-top:5px;'> <i class='fa fa-arrow-up' style='font-size:26px; color:#9beb97;'></i>)");   
	                     }
	                     else{
	                     tempval = (pxrp_c-xrp_c)/xrp_c*100;
	                     $("#XRP_p").html(tempval.toFixed(2) + "%"+ "   (<img src='images/poloniex.png' width='80' height='19' style='padding-top:5px;'> <i class='fa fa-arrow-up' style='font-size:26px; color:#9beb97;'></i>)");
	                     } 
                     }
                  }
               });
            }
            function myFunction2() {
               myVar = setInterval(myFun2, 1000);
               
            }
            function myFunction() {
            myVar = setInterval(myFun, 1000);
         }
            myFunction();
            myFunction2();
      </script>
      <!-- ---------------------------------- -->
      <!-- Header -->
      <header id="header" class="alt">
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

      <!-- Banner -->
      <section id="banner" class="major" style="height: 700px;">
         <div class="inner">
            <header class="major">
               <h1>
                  <!--   안녕하세요, <strong>coINsight</strong>입니다. -->
                  <img src="images/anigif.gif">
               </h1>
            </header>
            <div class="content">
               <p>
                  coINsight란 coin(코인) + sight(시야)를 통해 파생된 단어로서, <br> 더불어 co(함께)
                  + insight(통찰력) 이라는 뜻을 가지고 있습니다.<br> coINsight는 가상화폐의 다양한 종류
                  별, 그리고 거래소 별 시세 비교를 한 눈에 쉽게 그래프 차트로 제공합니다.<br> 또한 사용자가 구매한
                  가상화폐의 현재 시세와 비교하여 수익률을 계산하는 기능을 추가로 제공합니다.<br> coINsight와 함께
                  가상화폐 거래에서 더욱 뛰어난 통찰력으로 높은 수익 창출을 경험해보세요. <br>
               </p>

               <ul class="actions">
                  <li><a href="#hihi" class="button next scrolly">시작하기</a></li>
               </ul>
            </div>
         </div>
      </section>
	 <div id="hidden" style="height:50px;"></div>
      <div id="hihi" style="height: 600px">
         <!-- Table -->

         <div style="width: 10%; margin: 0 auto;">
            <!-- <button
               style="width: 100%; height: 50px; background-color: white; color: navy;">
               <i class="fa fa-refresh" style="font-size: 24px"></i> 새로고침
            </button> -->
         </div>

         <div class="table-wrapper"
            style="width: 35%; float: left; margin-left: 40px;">
            <a href="https://www.bithumb.com/" class="logo"><img
               src="images/logo_bithumb.png" width="240" height="66" /></a> <br>
            <br>
            <table class="alt">
               <thead>
                  <tr>
                     <th>Coin</th>
                     <th>Price(원화: KRW) <div style="float:right;">24시간 변동률</div></th>
                  </tr>
               </thead>
               <tbody>
                  <tr>
                     <td style="text-align:left;">비트코인(BTC)</td>
                     <td><div id="BTC"><i class="fa fa-spinner fa-spin" style="font-size:24px"></i></div></td>
                  </tr>
                  <tr>
                     <td style="text-align:left;">이더리움(ETH)</td>
                     <td><div id="ETH"><i class="fa fa-spinner fa-spin" style="font-size:24px"></i></div></td>
                  </tr>
                  <tr>
                     <td style="text-align:left;">대쉬 코인(DASH)</td>
                     <td><div id="DASH"><i class="fa fa-spinner fa-spin" style="font-size:24px"></i></div></td>
                  </tr>
                  <tr>
                     <td style="text-align:left;">라이트 코인(LTC)</td>
                     <td><div id="LTC"><i class="fa fa-spinner fa-spin" style="font-size:24px"></i></div></td>
                  </tr>
                  <tr>
                     <td style="text-align:left;">이더리움 클래식(ETC)</td>
                     <td><div id="ETC"><i class="fa fa-spinner fa-spin" style="font-size:24px"></i></div></td>
                  </tr>
                  <tr>
                     <td style="text-align:left;">리플(XRP)</td>
                     <td><div id="XRP"><i class="fa fa-spinner fa-spin" style="font-size:24px"></i></div></td>
                  </tr>
               </tbody>
            </table>
         </div>

         <div class="table-wrapper"   style="width: 20%; float: left; margin:0 35px;">
            <h4 style="margin-bottom:37px; text-align:center; color:#959ab3;"> [ 오늘의 환율 ] <br>
            							1KRW/USD : <span id="krw"></span> </h4>
            <table class="alt">
               <thead>
                  <th style="text-align:center;"><strong>국내외 시세차이(%)</strong></th>
               </thead>
               <tbody style="text-align:center;">
                  <tr> 
                     <td><div id="BTC_p" style="text-align:center; height:30px;"><i class="fa fa-spinner fa-spin" style="font-size:24px"></i></div></td>
                  </tr>
                  <tr>
                     <td><div id="ETH_p" style="text-align:center; height:30px;"><i class="fa fa-spinner fa-spin" style="font-size:24px"></i></div></td>
                  </tr>
                  <tr>
                     <td><div id="DASH_p" style="text-align:center; height:30px;"><i class="fa fa-spinner fa-spin" style="font-size:24px"></i></div></td>
                  </tr>
                  <tr>
                     <td><div id="LTC_p" style="text-align:center; height:30px;"><i class="fa fa-spinner fa-spin" style="font-size:24px"></i></div></td>
                  </tr>
                  <tr>
                     <td><div id="ETC_p" style="text-align:center; height:30px;"><i class="fa fa-spinner fa-spin" style="font-size:24px"></i></div></td>
                  </tr>
                  <tr>
                     <td><div id="XRP_p" style="text-align:center; height:30px;"><i class="fa fa-spinner fa-spin" style="font-size:24px"></i></div></td>
                  </tr>
               </tbody>
               <!-- <tfoot>
                  <tr>
                     <td colspan="2"></td>
                     <td>100.00</td>
                  </tr>
               </tfoot> -->
            </table>
         </div>


         <div class="table-wrapper"
            style="width: 35%; float: right; margin-right: 40px;">
            <a href="https://poloniex.com/" class="logo"><img
               src="images/poloniex.png" width="250" height="40"
               style="margin-top: 24px;" /></a>  <br> <br>
            <table class="alt">
               <thead>
                  <tr>
                     <th>Coin</th>
                     <th>Price(원화: KRW) <div style="float:right;">24시간 변동률</div></th>
                  </tr>
               </thead>
               <tbody>
                  <tr>
                     <td style="text-align:left;">비트코인(BTC)</td>
                     <td><div id="PBTC"><i class="fa fa-spinner fa-spin" style="font-size:24px"></i></div></td>
                  </tr>
                  <tr>
                     <td style="text-align:left;">이더리움(ETH)</td>
                     <td><div id="PETH"><i class="fa fa-spinner fa-spin" style="font-size:24px"></i></div></td>
                  </tr>
                  <tr>
                     <td style="text-align:left;">대쉬 코인(DASH)</td>
                     <td><div id="PDASH"><i class="fa fa-spinner fa-spin" style="font-size:24px"></i></div></td>
                  </tr>
                  <tr>
                     <td style="text-align:left;">라이트 코인(LTC)</td>
                     <td><div id="PLTC"><i class="fa fa-spinner fa-spin" style="font-size:24px"></i></div></td>
                  </tr>
                  <tr>
                     <td style="text-align:left;">이더리움 클래식(ETC)</td>
                     <td><div id="PETC"><i class="fa fa-spinner fa-spin" style="font-size:24px"></i></div></td>
                  </tr>
                  <tr>
                     <td style="text-align:left;">리플(XRP)</td>
                     <td><div id="PXRP"><i class="fa fa-spinner fa-spin" style="font-size:24px"></i></div></td>
                  </tr>
               </tbody>
            </table>
         </div>
      </div>


      <div style="width: 16%; margin: 0 auto; margin-bottom: 20px;">
         <a href="#one" class="button next scrolly">코인 별 상세보기</a>
      </div>

      <!-- Main -->
      <div id="main">
         <!-- One -->
         <section id="one" class="tiles">
            <article>
               <span class="image"> <!-- <img src="images/pic01.jpg" alt="" /> -->
                  <img src="images/eth.png" />
               </span>
               <header class="major">
                  <h3>
                     <a href="coin?command=eth" class="link">ETH</a>
                  </h3>
                  <p>이더리움</p>
               </header>
            </article>
            <article>
               <span class="image"> <!-- <img src="images/pic02.jpg" alt="" /> -->
                  <img src="images/btc.png" />
               </span>
               <header class="major">
                  <h3>
                     <a href="coin?command=btc" class="link">BTC</a>
                  </h3>
                  <p>비트코인</p>
               </header>
            </article>
            <article>
               <span class="image"> <!-- <img src="images/pic03.jpg" alt="" /> -->
                  <img src="images/dash.png" width="100" />
               </span>
               <header class="major">
                  <h3>
                     <a href="coin?command=dash" class="link">DASH</a>
                  </h3>
                  <p>대쉬코인</p>
               </header>
            </article>
            <article>
               <span class="image"> <!-- <img src="images/pic04.jpg" alt="" /> -->
                  <img src="images/ltc.png" />
               </span>
               <header class="major">
                  <h3>
                     <a href="coin?command=ltc" class="link">LTC</a>
                  </h3>
                  <p>라이트코인</p>
               </header>
            </article>
            <article>
               <span class="image"> <!-- <img src="images/pic05.jpg" alt="" /> -->
                  <img src="images/etc.png" />
               </span>
               <header class="major">
                  <h3>
                     <a href="coin?command=etc" class="link">ETC</a>
                  </h3>
                  <p>이더리움 클래식</p>
               </header>
            </article>
            <article>
               <span class="image"> <!-- <img src="images/pic06.jpg" alt="" /> -->
                  <img src="images/xrp.png" />
               </span>
               <header class="major">
                  <h3>
                     <a href="coin?command=xrp" class="link">XRP</a>
                  </h3>
                  <p>리플</p>
               </header>
            </article>
         </section>

      </div>


      <!-- Footer -->
      <footer id="footer">
         <div class="inner"
            style="padding: 10px !important; text-align: center; width: 60%;">
            <br>
            <ul class="copyright">
               <li>ⓒ 2017. kData coInsight Team all rights reserved.</li>
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