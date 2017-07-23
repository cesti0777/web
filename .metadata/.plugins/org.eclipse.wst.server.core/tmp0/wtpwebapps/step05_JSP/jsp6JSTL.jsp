<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.domain.Person"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	jstl 반복 tag로 자바 데이터 출력<br>
	<%
		Person p1 = new Person("masert", "111");
		Person p2 = new Person("tester", "111");
		String s1 = "문자열1";
		String s2 = "문자열2";
		
		ArrayList list1 = new ArrayList();
		HashMap map1 = new HashMap();
	%>
	1. ArrayList에 데이터 저장해서 EL로 출력<br>
		1-1. EL tag로 변수명 호출시 getXxx() 자동 호출, 따라서 getXxx()는 필요<br>
	<%
		list1.add(s1);//0번째 저장
		list1.add(s2);
		list1.add(p1);//2번째 저장
		list1.add(p2);
		session.setAttribute("list", list1);
	%>
	${sessionScope.list[0]}-${sessionScope.list[2].id}-
	
	<br><hr><br>
	
	2. HashMap에 데이터 자장해서 EL로 출력<br>
		2-1. key로 데이터 관리하는 구조<br>
	<%
		map1.put("k1", p1);
		map1.put("k2", p2);
		map1.put("k3", s1);
		map1.put("k4", s2);
		
		request.setAttribute("map", map1);
	%>
	${requestScope.map["k1"].id}-${requestScope.map["k2"].id}-${requestScope.map["k2"].pw}-${requestScope.map["k3"]}-<br>
	${requestScope.map.k1.id}-${requestScope.map.k2.id}-${requestScope.map.k2.pw}-${requestScope.map.k3}-
	
	<br><hr><br>
	
	3. session에 단순 Person객체 저장해서 각 멤버값 출력<br>
	<%
		session.setAttribute("p", p1);
	%>
	${sessionScope.p.id}-${sessionScope.p.pw}
	
	<br><hr><br>
	
	4. forEach를 활용한 데이터값 출력<br>
	<%
		ArrayList list2 = new ArrayList();
		list2.add("a");
		list2.add("aw");
		list2.add("aqw");
		list2.add("aqqfq");
		list2.add("eea");
		list2.add("wga");
		list2.add("eeha");
		//모든 user가 공유하는 ServletContext
		application.setAttribute("allData", list2);
	%>
	<c:forEach items="${applicationScope.allData }" var="data">
		${data}-
	</c:forEach>	
	
	<br><hr><br>
	<%
		ArrayList list3 = new ArrayList();
		list3.add(new Person("s1", "111"));
		list3.add(new Person("s2", "222"));
		list3.add(new Person("s3", "333"));
		//모든 user가 공유하는 ServletContext
		application.setAttribute("allData3", list3);
	%>
	<c:forEach items="${applicationScope.allData3 }" var="data">
		${data.id}/${data.pw}<br>
	</c:forEach>	
	
	
</body>
</html>