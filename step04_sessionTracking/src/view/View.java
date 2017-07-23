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
	 * ��� ���� servlet ���� �ܰ�
	 * 1�ܰ� : ���� ���� ����
	 * 2�ܰ� : ��� ��ü ����
	 * 3�ܰ� : ���� ��ü ȹ��
	 * 4�ܰ� : ���� ��ü�� ���� �����͵� ��ȯ �� ���
	 * 5�ܰ� : ���� ���� ���鿡�� ���̻� ������ �ʴ� ������ ��ȿȭ
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("View service()");
		
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		out.println(session.getAttribute("id") + "<br>");
		out.println(session.getAttribute("name"));
		
		//�α׾ƿ� Ŭ���� ȣ��Ǵ� �޼ҵ�
		session.invalidate();
		session = null;
	}

}
