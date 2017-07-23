<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="sessionCheck.jsp" flush="false" />
<html>
<head>
<title>coINsight - 지갑관리</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="assets/css/main.css" />
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
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
<script type="text/javascript">

	var btc_c, eth_c, dash_c, ltc_c, etc_c, xrp_c, btc_c1, eth_c1, dash_c1, ltc_c1, etc_c1, xrp_c1;
	var pbtc_c, peth_c, pdash_c, pltc_c, petc_c, pxrp_c, obj, tempval;
	var amount, price, avgPrice, currentPrice_b, currentPrice_p, subPrice_b, subPrice_p;
	var btc_data;
	var eth_data;
	var dash_data;
	var ltc_data;
	var etc_data;
	var xrp_data;
	var currency;
	
	window.onload = function() {
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
			}
		});
	}

	$.ajax({
		url : "coin",
		data : {
			command : "coinAmount",
		},
		method : "post",
		dataType : "html",
		success : function(responseData) {
			var data = JSON.parse(responseData);
			btc_data = data.amountBTC * 1;
			eth_data = data.amountETH * 1;
			dash_data = data.amountDASH * 1;
			ltc_data = data.amountLTC * 1;
			etc_data = data.amountETC * 1;
			xrp_data = data.amountXRP * 1;
		}
	});

	function number_format(num) {
		return String(num).replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
	}

	function coinInfo(c) {
		$.ajax({
			url : "coin",
			data : {
				command : "coinInfo",
				coinName : c
			},
			method : "post",
			dataType : "html",
			success : function(responseData) {
				var data = JSON.parse(responseData);
				amount = data.amount * 1;
				price = data.price * 1;
				avgPrice = (data.price / data.amount) * 1;

				$("#amount").val(number_format(amount));
				$("#price").val(number_format(price));
				if (c == 'BTC') {
					currentPrice_b = btc_c * amount * 1;
					currentPrice_p = pbtc_c * amount * 1;
					subPrice_b = currentPrice_b - price;
					subPrice_p = currentPrice_p - price;
				} else if (c == 'ETH') {
					currentPrice_b = eth_c * amount * 1;
					currentPrice_p = peth_c * amount * 1;
					subPrice_b = currentPrice_b - price;
					subPrice_p = currentPrice_p - price;
				} else if (c == 'DASH') {
					currentPrice_b = dash_c * amount * 1;
					currentPrice_p = pdash_c * amount * 1;
					subPrice_b = currentPrice_b - price;
					subPrice_p = currentPrice_p - price;
				} else if (c == 'LTC') {
					currentPrice_b = ltc_c * amount * 1;
					currentPrice_p = pltc_c * amount * 1;
					subPrice_b = currentPrice_b - price;
					subPrice_p = currentPrice_p - price;
				} else if (c == 'ETC') {
					currentPrice_b = etc_c * amount * 1;
					currentPrice_p = petc_c * amount * 1;
					subPrice_b = currentPrice_b - price;
					subPrice_p = currentPrice_p - price;
				} else if (c == 'XRP') {
					currentPrice_b = xrp_c * amount * 1;
					currentPrice_p = pxrp_c * amount * 1;
					subPrice_b = currentPrice_b - price;
					subPrice_p = currentPrice_p - price;
				}
				if (amount == 0) {
					$("#avgPrice").val("보유한 코인이 없습니다.");
				} else if (avgPrice == 'Infinity') {
					$("#avgPrice").val("보유한 코인이 없습니다.");
				} else {
					$("#avgPrice").val(number_format(avgPrice));
				}
				if (currentPrice_b.toFixed(2) == 'NaN') {
					$("#currentPrice_b").val("서버 통신 오류입니다. 코인을 다시 선택해주세요.");
				} else {
					$("#currentPrice_b").val(
							number_format(currentPrice_b));
					$("#subPrice_b").val(
							number_format(subPrice_b));
				}
				if (currentPrice_p.toFixed(2) == 'NaN') {
					$("#currentPrice_p").val("서버에서 데이터를 받아오지 못했습니다.");
				} else {
					$("#currentPrice_p").val(
							number_format(currentPrice_p));
					$("#subPrice_p").val(
							number_format(subPrice_p));
				}
				if (amount == 0) {
					$("#currentPrice_b").val("보유한 코인이 없습니다.");
					$("#currentPrice_p").val("보유한 코인이 없습니다.");
					$("#subPrice_b").val(0);
					$("#subPrice_p").val(0);
				}
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
				if (obj.message == null) {
					btc_c = obj.data.BTC.closing_price * 1;
					eth_c = obj.data.ETH.closing_price * 1;
					dash_c = obj.data.DASH.closing_price * 1;
					ltc_c = obj.data.LTC.closing_price * 1;
					etc_c = obj.data.ETC.closing_price * 1;
					xrp_c = obj.data.XRP.closing_price * 1;

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
				pbtc_c = parseInt(obj.USDT_BTC.last * currency);
				peth_c = parseInt(obj.USDT_ETH.last * currency);
				pdash_c = parseInt(obj.USDT_DASH.last * currency);
				pltc_c = parseInt(obj.USDT_LTC.last * currency);
				petc_c = parseInt(obj.USDT_ETC.last * currency);
				pxrp_c = parseInt(obj.USDT_XRP.last * currency);
				BTC_per = (obj.USDT_BTC.percentChange * 100).toFixed(2);
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
			<div>
				<section>
					<script src="scripts/jquery-3.1.1.js"></script>
						<script src="scripts/jquery.validate.min.js"></script>
						<script src="http://ajax.microsoft.com/ajax/jquery.validate/1.11.1/additional-methods.js"></script>
					<script type="text/javascript">
						  $(document).ready(function(){
					      jQuery.validator.addMethod('cnameSelectCheck', function (value) {
					             return (value != 'empty');
					      }, "<i class='fa fa-warning' style='font-size:24px; color:yellow;'></i> 코인 종류를 선택하세요.");
					      jQuery.validator.addMethod(
					            'amountCheck', 
					            function (value) {
					              console.log($("#updateType").val());
					              console.log(value);
					              console.log(amount);
					              if($("#updateType").val()=='sell'){
					                 return (value*1 <= amount*1);
					              }else{
					                 return true;
					              }
					            }, 
					           "<i class='fa fa-warning' style='font-size:24px; color:yellow;'></i> 코인이 부족합니다."
					     );
					      
					     $("#walletForm").validate({ 
					         rules:{
					            cname:{cnameSelectCheck:true},
					            updateAmount:{required:true, digits:true, amountCheck:true},
					            updatePrice:{required:true, digits:true}
					         },
					         messages:{ 
					            updateAmount:{
					                 required:"<i class='fa fa-warning' style='font-size:24px; color:yellow;'></i> 수량을 입력하세요.", 
					                 digits:"<i class='fa fa-warning' style='font-size:24px; color:yellow;'></i> 올바른 숫자를 입력하세요."
					             },
					             updatePrice:{
					                 required:"<i class='fa fa-warning' style='font-size:24px; color:yellow;'></i> 금액을 입력하세요.",
					                 digits:"<i class='fa fa-warning' style='font-size:24px; color:yellow;'></i> 올바른 숫자를 입력하세요."
					             }
					         }
					     });
					  });   
					</script>
					<form id="walletForm" name="walletForm" method="post" action="coin">
						<div id="part1"
							style="width: 40%; float: left; margin-left: 80px;">
							<h2
								style="text-align: center; border-bottom: 2px solid; border-bottom-color: white; margin-bottom: 50px; margin-top: 0px !important;">지&nbsp;&nbsp;&nbsp;갑&nbsp;&nbsp;&nbsp;관&nbsp;&nbsp;&nbsp;리</h2>
							<div class="field half">
								<label for="cname">코인 종류</label> <select name="cname" id="cname"
									onChange="coinInfo(this.value)">
									<option value="empty" style="color: navy !important;">코인
										종류를 선택하세요</option>
									<option value="BTC" style="color: navy !important;">비트코인</option>
									<option value="ETH" style="color: navy !important;">이더리움</option>
									<option value="DASH" style="color: navy !important;">대쉬코인</option>
									<option value="LTC" style="color: navy !important;">라이트코인</option>
									<option value="ETC" style="color: navy !important;">이더리움
										클래식</option>
									<option value="XRP" style="color: navy !important;">리플</option>
								</select>
							</div>
							<div class="field half">
								<label for="id">수량</label> <input type="text" name="amount"
									id="amount" readonly />
							</div>
							<div class="field half">
								<label for="pw">총 구매 금액</label> <input type="text" name="price"
									id="price" readonly />
							</div>
							<div class="field half">
								<label for="pw">평균 코인 구매 단가[총구매금액/코인개수]</label> 
								<input type="text" name="avgPrice" id="avgPrice" readonly />
							</div>
							<div class="field half">
								<div style="float: left; width:45%;">
									<label for="pw" >현재 평가 금액[BITHUMB]</label> 
									<input type="text" name="currentPrice_b" id="currentPrice_b" readonly />
								</div>
								<div style="float: left; width:45%; margin-left: 50px">
									<label for="pw" >판매 차액</label> 
									<input type="text" name="subPrice_b" id="subPrice_b" readonly /><br>
								</div>
							</div>
							<div class="field half">
								<div style="float: left; width:45%;">
									<label for="pw" >현재 평가 금액[POLONIEX]</label> 
									<input type="text" name="currentPrice_p" id="currentPrice_p" readonly />
								</div>
								<div style="float: left; width:45%; margin-left: 50px">
									<label for="pw" >판매 차액</label> 
									<input type="text" name="subPrice_p" id="subPrice_p" readonly /><br>
								</div>
							</div>
						</div>
						<div id="part2"
							style="width: 40%; float: right; margin-right: 80px; margin-top:50px;">
							<div id="areaText"
								style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto">
								<script>
                        Highcharts.chart('areaText', {
                            chart: {
                                plotBorderWidth: null,
                                plotShadow: false,
                                backgroundColor: {
                                    linearGradient: { x1: 0, y1: 0, x2: 1, y2: 1 },
                                    stops: [
                                       [0, '#242943'],
                                       [1, '#242943']
                                    ]
                                 },
                                 style: {
                                    fontFamily: '\'Unica One\', sans-serif'
                                 },
                                 plotBorderColor: '#606063',
                                 type: 'pie'
                            },
                            title: {
                                text: '코인 종류 별 보유 비율(%)',
                                style: {
                                   color: '#FFFFFF',
                                    fontSize: '25px',
                                }
                            },
                            tooltip: {
                                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                            },
                            plotOptions: {
                                pie: {
                                    allowPointSelect: true,
                                    cursor: 'pointer',
                                    dataLabels: {
                                        enabled: true,
                                        format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                                        style: {
                                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'white'
                                        }
                                    }
                                }
                            },
                            series: [{
                                colorByPoint: true,
                                data: [{
                                    name: '비트코인(BTC)',
                                    y: btc_data,
                                    sliced: true,
                                    selected: true
                                }, {
                                    name: '이더리움(ETH)',
                                    y: eth_data
                                }, {
                                    name: '대쉬코인(DASH)',
                                    y: dash_data
                                }, {
                                    name: '라이트코인(LTC)',
                                    y: ltc_data
                                }, {
                                    name: '이더리움클래식(ETC)',
                                    y: etc_data
                                }, {
                                    name: '리플(XRP)',
                                    y: xrp_data
                                }]
                            }]
                        });
                     </script>
							</div>
							<h2
                        style="text-align: center; border-bottom: 2px solid; border-bottom-color: white; margin-bottom: 60px; margin-top: 50px !important;">
                        지&nbsp;갑&nbsp;정&nbsp;보&nbsp;수&nbsp;정</h2>
                     <div class="field half">
                        <div style="width: 24%; float: left; margin-right: 21px;">
                           <label for="cname">분류</label> <select name="updateType"
                              id="updateType">
                              <option value="buy" style="color: navy !important;">구입</option>
                              <option value="sell" style="color: navy !important;">판매</option>
                           </select>
                        </div>
                        <div style="width: 35%; float: left; margin: 0 auto;">
                           <label for="pw">수량</label> <input type="text"
                              name="updateAmount" id="updateAmount" />
                        </div>
                        <div style="width: 35%; float: right;">
                           <label for="pw">금액</label> <input type="text"
                              name="updatePrice" id="updatePrice" />
                        </div>
                     </div>

							<br> <br> <br> <br> <br> <input
								type="hidden" name="command" value="coinInfoUpdate" />

							<ul class="actions"
								style="margin: 0 auto !important; width: 58%;">
								<li><input type="submit" value="지갑에 등록" class="special" /></li>
								<li><input type="reset" value="다시 작성" /></li>
							</ul>
						</div>
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