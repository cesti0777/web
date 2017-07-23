1. Java Script[JS]
2. js가 적용 가능한 파일
	1. html에 개발(*.html or *.htm)
	2. jsp(asp, php) 내에서 개발(*.jsp)
	3. java script로만 갭라 가능(*.js)
	
3. 필요성
	1. 브라우저에 동적인 화면(사용자의 욕구 충족) 구성 요소
	2. 동적인 화면 구성
	
4. 문법
	1. 불명확
	2. 함수 개발 문법 조차도 여러개로 가능
	3. 이러한 다양한 경우의 수로 좋은 기능이 구현된 함수의 집합체인 library들 파생
		- jQuery가 대표적
		- 용어 : 함수들의 library toolkit
	4. 참고
		- 사내 솔루션 회사들도 jQuery library + HTML5 + CSS3 조합된
		
5. 학습내용
	1. js의 변수 선언 및 호출 문법
	2. js 함수 호출 및 구현 문법
		2-1. js 자체 API 함수 호출
		2-2. 브라우저 자체 지원 함수 호출
		2-3. 사용자 정의 함수 개발 및 호출
	3. 데이터 포멧 및 처리
		1. CSV - 단순 데이터 표현에 적합
				  - , 데이터 구분
				  - 단점 : 데이터 구조화가 약해
		2. xml - tag와 value값 구성
				  - value값은 tag명과 tag의 계층 구조
				  - xml의 데이터 처리는 performance가 저하
		3. JSON - Java Script Object Notation
					- key와 value 구조로 관리되는 데이터 구조
					- 서버 입장 : json구조는 단순 문자열
					- client 부라우저 입장
						: json구조의 단순 문자열 반드시 js 객체로 변환 필수
						: key로 value 활용
							(핵심 : 단순 문자열을 JSON 객체로 변환하는 함수)
					
6. 필수 암기 사항
	1. 변수 선언 문법
		1. 전역(멤버)
			1. <script> tag 내부에 선언되는 변수들
			2. 사용자 정의 함수 내부에 var가 없이 변수명으로만 선언된 변수들
			
		2. 로컬
			1. 사용자 정의 함수 내부에 var로 선언된 변수들
	
	2. 함수 구현 문법
		1. function 함수명([..]){}
		2. 호출 문법
			- 호출시 구현된 parameter와 100% 일치하지 않아도 호출가능
			- 구현되어 있다 하더라도 미호출시 실행 불가 			
			
			
			
			