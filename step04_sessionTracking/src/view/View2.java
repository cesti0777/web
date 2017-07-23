package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class View2 extends HttpServlet {
	//client ½Ã½ºÅÛÀ¸·Î ºÎÅÍ Cookie Á¤º¸¸¦ È¹µæ - ÇØ´ç domain °Í¸¸ È¹µæÇÔ
	//ÄíÅ° È¹µæ -> º°ÄªÀ¸·Î °ªÀ» È¹µæ
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("View2 service()");
		
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		
		Cookie[] all = request.getCookies();
		for(int i = 0; i< all.length ; i++){
			if(all[i].getName().equals("id")){
				out.println("id = " + all[i].getValue());
			}else if(all[i].getName().equals("pw")){
				out.println("<br>pw = " + all[i].getValue());
			}
			
			//ÄíÅ°Á¤º¸ »èÁ¦
			all[i].setMaxAge(0); 
			response.addCookie(all[i]);
		}
	}
}
