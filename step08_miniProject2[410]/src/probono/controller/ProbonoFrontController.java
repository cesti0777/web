package probono.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import probono.exception.MessageException;
import probono.model.ProbonoService;
import probono.model.dto.ActivistDTO;
public class ProbonoFrontController extends HttpServlet {
    public ProbonoFrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String command = request.getParameter("command");
		try{
			if(command.equals("probonoProjectAll")){//��� probono project ���� �˻�
				probonoProjectAll(request, response);
			}else if(command.equals("activistAll")){//��� ��� ����� �˻�
				activistAll(request, response);
			}else if(command.equals("activist")){//Ư�� ��� ����� ���� �˻�
				activist(request, response);
			}else if(command.equals("activistInsert")){//��� ����� �߰� ���
				activistInsert(request, response);
			}else if(command.equals("activistUpdateReq")){//��� ����� ���� ������û
				activistUpdateReq(request, response);
			}else if(command.equals("activistUpdate")){//��� ����� ���� ����
				activistUpdate(request, response);
			}else if(command.equals("activistDelete")){//��� ����� Ż��[����]
				activistDelete(request, response);
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}
	

	//��� ProbonoProject �˻� �޼ҵ�
	public void probonoProjectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("probonoProjectAll", ProbonoService.getAllProbonoProjects());
			url = "probonoProjectList.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	//???
	//��� ��� ����� �˻� - �˻��� ������ ��� ȭ��[activistList.jsp]
	public void activistAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("activistAll", ProbonoService.getAllActivists());
			url = "activistList.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	//��� ����� �˻� 
	public void activist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("activist", ProbonoService.getActivist(request.getParameter("activistId")));
			url = "activistDetail.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	

	//��� ����� ���� �޼ҵ�
	protected void activistInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	//��� ����� ���� �䱸
	public void activistUpdateReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("activist", ProbonoService.getActivist(request.getParameter("activistId")));
			url = "activistUpdate.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	//???
	//��� ����� ���� - ������ Ȯ�� jsp[activistDetail.jsp]
	public void activistUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	//???
	//��� ����� ����
	public void activistDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
