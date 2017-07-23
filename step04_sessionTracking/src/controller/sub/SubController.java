package controller.sub;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SubController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SubController service()");
		
		//이미 생성된 세션객체 받아서 이름 저장
		//이미 존재하는 해당 client만의 세션 객체 반환
		HttpSession session = request.getSession();
		System.out.println(session.getId());
		session.setAttribute("id", "master");
		
		//jsp로 화면 이동
		//jsp에서도 getAttribute로 데이터 활용 가능
		//http://ip:port/project/nameSave
			//http://ip:port/project/finalView.jsp
		response.sendRedirect("finalView.jsp");
		
		
	}

}
