학습내용

1. jsp 기본 tag
	1-1. scripting tag
		: <%시작...%>
	- <%@ page import="" contentType="" %>
	
	1-2. jsp action tag
		<jsp:tag명>
	- page forward
		<jsp:forward page="이동 page"/>
			<jsp:param name="별칭" value="값"/>
		</jsp:forward>

2. EL tag
	- ${}
	- 자바 데이터 출력
	- tag 내부에서 연산식 가능, 
	- null인 경우 client에게 blank로 view
	- 쿠키코드 간결하게 지원
	- JSTL tag의 기능이 잘 활용될 수 있도록 지원
	
	- 문법
		${requestScope.별칭}
		${sessionScope.별칭}
		${applicationScope.별칭}
		
		${param.웹쿼리스트링별칭}
		${cookie.별칭.value}
		
3. JSTL tag 학습
	1. 개발 세팅 필수 단계
		- 외부 library 개발 환경으로 download
		- db driver와 같은 셋팅 전처리 필수
		- web server의 web application의 library 절대 경로
			WEB-INF/lib/*.jar	
			
	2. jsp 파일별 반드시 jstl사용하겠다는 선언 필수
	
4. client만의 고유 데이터 저장 기법
	1. forward 방식시 사용되는 객체
		- HttpServletRequest
		- jsp의 내장객체(request)
	2. page이동 방식과 무관하게 사용하는 객체
		- HttpSession : jsp의 내장 객체(session)
		- Cookie	

5. 서버가 서비스를 하기위한 초기화 작업
	1. 완벽한 web application을 서버에 배치
	2. 서버를 시작한다
		* 서버 관점에서 바라보기
			1. 서버 자체의 설정 정보 확인(ip/port...)
			2. 서비스 하고자하는 app~ 들의 설정 파일들 검증 및 초기화
				- web.xml
			3. web app~ 서비스 시작
			4. web app~(web project) 만의 ServletContext라는 객체 생성
				- 모든 user(servlet과 jsp)가 조건없이 데이터를
				   공유(setAtrribute())하고 공유 받을수 있는(getAttribyte()) 유일한 객체
				- 개발자가 생성 권한 없음, web server(container)가 직접 생성
			* 참고 : 
				ServletContext도 내장 객체
				jsp는 application 변수명으로 사용함
				
	3. 서비스를 한다	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	