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
		
		//�̹� ������ ���ǰ�ü �޾Ƽ� �̸� ����
		//�̹� �����ϴ� �ش� client���� ���� ��ü ��ȯ
		HttpSession session = request.getSession();
		System.out.println(session.getId());
		session.setAttribute("id", "master");
		
		//jsp�� ȭ�� �̵�
		//jsp������ getAttribute�� ������ Ȱ�� ����
		//http://ip:port/project/nameSave
			//http://ip:port/project/finalView.jsp
		response.sendRedirect("finalView.jsp");
		
		
	}

}