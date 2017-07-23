<%@ page language="java" 
				  contentType="text/html; charset=EUC-KR"
    			  pageEncoding="EUC-KR"%>
   <!-- jsp 파일임을 암시, 응답 포멧 지정, import문장 선언구 -->
    
   <%--
   1. jsp만의 주석 : client 브라우저로 전송 안 함. 보안을 고려한 주석에 권장
   2. 1line tag : page 지시자
   --%>			  
    			  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>jsp1Scripting.jsp</title>
</head>
<body>
	jsp Scripting tag jsp 학습 <br>
	1. 5가지<br>
	2. 종류 <br>
		1. 맴버변수 / 맴버 메소드 구현 가능한 tag<br>
		2. import/응답 모펫 지정 tag<br>
		3. 순수 자바 코드 개발 가능한 tag<br>
		4. 브라우저에 출력 전담 tag<br>
		5. jsp만의 주석<br>
		
		<hr><br>
		<%! 
			// 멤버 변수와 메소드 구현 tag
			String msg = "나 맴버";
			String getMsg(){
				return msg;
			}
		%>
		
		<%
			//client별 1:1 실행되는 멤버 변수, 메소드 구현 tag, 순수자바코드 개발 가능
			//*** jsp 장점 : 내장 객체가 이미 존재
			out.println(getMsg());
		%>
		
		<br>
		<%-- 출력 전담 tag --%>
		<%=msg%>
		
		
		
		
		
</body>
</html>