package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class View extends HttpServlet {
	/*
	 * 출력 전담 servlet 개발 단계
	 * 1단계 : 응답 포멧 지정
	 * 2단계 : 출력 객체 생성
	 * 3단계 : 세션 객체 획득
	 * 4단계 : 세션 객체로 부터 데이터들 반환 및 출력
	 * 5단계 : 서버 관리 측면에서 더이상 사용되지 않는 세션은 무효화
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("View service()");
		
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		out.println(session.getAttribute("id") + "<br>");
		out.println(session.getAttribute("name"));
		
		//로그아웃 클릭시 호출되는 메소드
		session.invalidate();
		session = null;
	}

}
