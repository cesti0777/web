[1] 실습 목적
	1. Servlet API를 활용한 Web Program 개발하기
	 
		
[2] 실습  
	1. 기존 JDBC 프로젝트 소스 확장하기
	
	2. 추가 구현 로직
		2-1. Connection Pool 구조로 변환하기
			- context.xml 파일 제공되었음 
		
		2-2. 미리 제공된 로직[실행 가능]
		  - 진행중인 재능 기부 프로젝트 모든 정보 검색하기
				
		2-3. 구현해야 하는 로직
			2-3-1. 재능 기부자 모두 검색하기
			2-3-2. 재능 기부자 정보 수정하기
			2-3-3. 재능 기부자 탈퇴하기
			
		2-4. 차후에 혼자 해 보기
			수혜자 CRUD			
		
	3. blank source
		3-1. ProbonoFrontController.java
			3-1-1. activistAll() : 모든 재능 기부자 검색하기
			3-1-2. activistUpdate() : 재능 기부자 정보 수정하기
			3-1-3. activistDelete() : 재능 기부자 탈퇴하기
		
		3-2. activistList.jsp		
			3-2-1. 모든 재능 기부자 보기 완성하기
			
		3-3. probonoProjectList.jsp
			3-3-1. 모든 재능 기부 프로젝트 보기  완성하기
			
		3-4. activistDetail.jsp
			3-4-1. EL tag로 출력로직 완성하기	
			
----- 신 문제 제출자 : 임수현, 정희민
//JDBC복습	
1. sql 문장들 properties로 분할하여 정리하기.
//자바 복습
2. ActivistDAO 완성하기
	2-1 : addActivist 완성하기
	2-2 : updateActivist 완성하기
	2-3 : deleteActivist 완성하기
//웹 실습
3. ProbonoFrontController 완성하기
	3-1 : activistInsert() 완성하기
	3-2 : activistUpdate() 완성하기
	3-3 : activistDelete() 완성하기
	
	3-4. activistList.jsp		
		3-4-1. 모든 재능 기부자 보기 완성하기
			
	3-5. probonoProjectList.jsp
		3-5-1. 모든 재능 기부 프로젝트 보기  완성하기
			
	3-6. activistDetail.jsp
		3-6-1. EL tag로 출력로직 완성하기	