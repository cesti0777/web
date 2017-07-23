/*
 * service() 구현 로직
 * - 로그인/회원가입 무두다 정상 실행
 * 		: 실행결과가 발생하는 다양한 경우의 수도 처리
 * 
 * 1단계 : 어떤 요청인지 구분
 * 		경우의 수1 : 로그인 요청
 * 		경우의 수2 : 회우너가입 요청
 * 2단계 : 요청 로직별 개별 실행
 * 3단계 : 응답된 결과에 따른 view지정
 *		로그인 인 경우
 *			경우의 수1 : 유효
 *			경우의 수2 : 무효
 *		회원가입의 경우
 *			경우의 수1 : 유효
 *			경우의 수2 : 무효
 *				- 사례 : id 중복
 */


package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Controller extends HttpServlet {
	//get/post 방식 모두다 처리
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Controller service()");
		
		String command = request.getParameter("command");
		
		if(command != null){
			if(command.equals("login")){
				//DAO의 일반 메소드 호출등으로 검증 완료 가정
				if(true){
					/*
					 * page이동 방식과 무관하게 해당 client만의 지속적인 상태 유지 기술
					 * 		- 서버 메모리 활용
					 * 		- 세션
					 * 			세션 생성 -> 세션 데이터 저장
					 * 		- 개발 기술 
					 * 			세션은 절대 new 생성 불가
					 * 			왜? 세션 관리는 app~을 서비스 할 수 있게 관리하는 container가 담당
					 * 			container에게 요청해서 받아서 사용하는 구조
					 */
					HttpSession session = request.getSession();//세션 생성
					System.out.println("세션의 고유한 id값 : "+session.getId());
					session.setAttribute("name", "장원");
					
					response.sendRedirect("nameSave");
				}else{
					request.setAttribute("errorMsg", "로그인 실패");
					request.getRequestDispatcher("fail").forward(request, response);
				}
			}else if(command.equals("insert")){
				//DAO의 insert 로직 호출이라 가정
				if(true){
					//id/pw값을 쿠키로 생성후 client 시스템에 몰래 저장하기
					
					//쿠키 생성
					Cookie c1 = new Cookie("id", request.getParameter("id"));
					Cookie c2 = new Cookie("pw", request.getParameter("pw"));
					
					//쿠키 잔존 시간
					c1.setMaxAge(60*60*24*365);
					c1.setMaxAge(60*60*24*365);
					
					//client 시스템에 전송 저장
					response.addCookie(c1);
					response.addCookie(c2);
					
					
					response.sendRedirect("cookieView.jsp");
				}else{
					request.setAttribute("errorMsg", "가입 실패");
					request.getRequestDispatcher("fail").forward(request, response);
				}
			}else{
				//값은 있으나 실전 요청이 아닌 경우 고려
			}
		}else{
			response.sendRedirect("login.html");
		}
			
	}

}
