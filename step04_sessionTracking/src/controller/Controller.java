/*
 * service() ���� ����
 * - �α���/ȸ������ ���δ� ���� ����
 * 		: �������� �߻��ϴ� �پ��� ����� ���� ó��
 * 
 * 1�ܰ� : � ��û���� ����
 * 		����� ��1 : �α��� ��û
 * 		����� ��2 : ȸ��ʰ��� ��û
 * 2�ܰ� : ��û ������ ���� ����
 * 3�ܰ� : ����� ����� ���� view����
 *		�α��� �� ���
 *			����� ��1 : ��ȿ
 *			����� ��2 : ��ȿ
 *		ȸ�������� ���
 *			����� ��1 : ��ȿ
 *			����� ��2 : ��ȿ
 *				- ��� : id �ߺ�
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
	//get/post ��� ��δ� ó��
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Controller service()");
		
		String command = request.getParameter("command");
		
		if(command != null){
			if(command.equals("login")){
				//DAO�� �Ϲ� �޼ҵ� ȣ������� ���� �Ϸ� ����
				if(true){
					/*
					 * page�̵� ��İ� �����ϰ� �ش� client���� �������� ���� ���� ���
					 * 		- ���� �޸� Ȱ��
					 * 		- ����
					 * 			���� ���� -> ���� ������ ����
					 * 		- ���� ��� 
					 * 			������ ���� new ���� �Ұ�
					 * 			��? ���� ������ app~�� ���� �� �� �ְ� �����ϴ� container�� ���
					 * 			container���� ��û�ؼ� �޾Ƽ� ����ϴ� ����
					 */
					HttpSession session = request.getSession();//���� ����
					System.out.println("������ ������ id�� : "+session.getId());
					session.setAttribute("name", "���");
					
					response.sendRedirect("nameSave");
				}else{
					request.setAttribute("errorMsg", "�α��� ����");
					request.getRequestDispatcher("fail").forward(request, response);
				}
			}else if(command.equals("insert")){
				//DAO�� insert ���� ȣ���̶� ����
				if(true){
					//id/pw���� ��Ű�� ������ client �ý��ۿ� ���� �����ϱ�
					
					//��Ű ����
					Cookie c1 = new Cookie("id", request.getParameter("id"));
					Cookie c2 = new Cookie("pw", request.getParameter("pw"));
					
					//��Ű ���� �ð�
					c1.setMaxAge(60*60*24*365);
					c1.setMaxAge(60*60*24*365);
					
					//client �ý��ۿ� ���� ����
					response.addCookie(c1);
					response.addCookie(c2);
					
					
					response.sendRedirect("cookieView.jsp");
				}else{
					request.setAttribute("errorMsg", "���� ����");
					request.getRequestDispatcher("fail").forward(request, response);
				}
			}else{
				//���� ������ ���� ��û�� �ƴ� ��� ���
			}
		}else{
			response.sendRedirect("login.html");
		}
			
	}

}
