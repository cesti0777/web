package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Calculate doGet()");
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Calculate doPost()");
		process(request, response);
	}

	protected void process(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		String c = request.getParameter("c");
		
		int intA = Integer.parseInt(a);
		int intB = Integer.parseInt(b);
		int intC = Integer.parseInt(c);
		
		if(intA + intB == intC){
			request.setAttribute("result", intA+"+"+intB+"="+intC);
			RequestDispatcher rd = request.getRequestDispatcher("succ");
			rd.forward(request, response);			
		}else{
			response.sendRedirect("fail");
		}
	}
}
