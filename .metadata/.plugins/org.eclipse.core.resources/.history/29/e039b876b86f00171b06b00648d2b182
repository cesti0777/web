1. web
	1. servlet & jsp
		- 서버 데이터 처리가 가능
		- http 기반의 브라우저 요청 및 응답 처리 가능
		- http : 단순 UI 화면
			- 자바 객체가 보유한 데이터값 화면 출력 불가
	2. java script
		- jQuery
		- 다양하면서 복잡
	3. Ajax 비동기 학습
	4. html/css
		- http://www.w3schools.com

2. git
	- 형상관리 tool
	
3. DB Modeling

----------------------------------------

1. Main 접속 : html
2. Login 시도  - id.pw 입력, 전송 : html
3. 서버는 id/pw 받음(로그인 요청) : Servlet
4. id/pw로 DB 검샘 - select : 일반(DAO)
5. 

----------------------------------------

1. http 프로토콜 통신 필수 장비
	- web server 
		- 늘 실시간 실행중
	- 브라우저

2. 서버 관점 
	- client 요청 직접적으로 수락 할 수 있는 언어
		1. htmp
		2. servlet
		3. jsp
			- web server들은 첫 요청 처리시 servlet으로 자동 변환
			- jsp는 servlet
		
		*** 일반 순수 자바 직접 요청 및 응답 처리 불가
			자바 기반의 웹처리 기술인 servlet 이용 통신

3. 용어
	1. web server 
		= server 
		= [web] application server[WAS] 
		= [web] container 
		= servlet engine

--------------------------------------------
1. 용어
	1. web server 
		= server 
		= [web] application server[WAS] 
		= [web] container 
		= servlet engine
		
	2. server : service를 하는 주체
	   client : service를 받는 주체
	   
	3. web query string
		- client가 서버에 전송하는 데이터 구조
			key1=value&key2=value2..
		
2. web 통신 규약
	1. http 프로토콜
	2. w3c에서 관리하는 스펙
	
3. servlet & jsp 기반의 개발 스펙
	1. http 프로토콜 기반
	2. 개발의 장점
		- http 프로토콜 고려 및 처리 로직은 이미 HttpServlet 제공
		- 상속 받아 개인 처리 로직에만 집중해서 개발
		- 개발이 쉽다
4. 필요 장비
	1. web server (tomcat...)
		* 서비스 로직 구현된 web application
	2. 브라우저

5. 실행을 위한 (서비스) 필수 조건
	- 서버는 24시간 365일 늘 실행중이어야 함
	
6. url 
	- http://ip:port/prohect명/경로../파일명
	1. servlet
		- 확장자 절대 적용 불가
		- http://ip:port/prohect명/경로../파일명
	2. html/jsp
		- 확장자 필수
		- http://ip:port/prohect명/경로../파일명.html
	
7. API 학습
	1. 스펙 제시 : (구)sun 
	2. doGet() 개발 : 실제 로직 개발은 서비스 구현하는 개발자
	3. doGet() 호출 : 웹서버, 
					호출 시점은 client가 url로 해당 servlet 요청시
					web container(url)가 요청 감지 후 메소드 호출
	*** sun/개발자/web server의 벤더사들 스펙 일치
	
8. http 통신 방법
	1. http://w3.org
	2. 요청 방식
		1. get방식
			- 요청시 client가 입력하는 데이터 url에 오픈되는 구조
			- 즐겨찾기용 요청 처리 방식
		2. post방식
			- 요청시 client가 입력하는 데이터 url에 오픈되지 않는 은닉 구조로 요청
			- 보안을 고려, 전송하는 데이터 양이 많을 경우 권장

9. servlet 필수 설정 정보
	* 주의사항 : 이클립스는 servlet 생성시 자동 ㅓㄹ정 정보 생성
			    간혹 설정 정보가 생성이 안 될 경우 발생
			    해결책 : 개발자가 직접 xml문서 편집
	1. web.xml
	2. q보안을 고려한 url값 수정
	  <servlet>
	    <servlet-name>HelloServlet</servlet-name>
	    <servlet-class>실제구현한 서블릿 클래스명</servlet-class>
	  </servlet>
	  
	  <servlet-mapping>
	    <servlet-name>url과 실제 서블릿 매핑하는 별칭</servlet-name>
	    <url-pattern>/클라이언트가 요청하는 url</url-pattern>
	  </servlet-mapping>
	  
10. 주요 API
	HttpServlet
		- http 프로토콜 기반의 로직 지원하는 유용한 클래스
		- 상속받는 경우 http servlet
		
	HttpServletRequest
		- http프로토콜 기반의 client의 요청 정보 보유
		- 접속한 client 만의 ip/브라우저 정보/client의 데이터 값
		- getParameter/setAttribute/getAttribute/setCharacterEncoding
	
	HttpServletResponse
		- 접속한 client에게만 응답해주는 객체
		- setContentType
		- getWriter
		- sendRedirect
	
	RequestDispacher
		- servlet간의 화면이동
		- forward

11. A라는 Servlet(인증 처리)
	A Servlet객체 : request 객체 : response객체수 : client수
	= 1 : 100 : 100 : 100
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	