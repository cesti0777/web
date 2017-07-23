package guestbook.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.model.GuestBookBean;
import guestbook.model.GuestBookDAO;

 
 public class GuestBookServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post방식으로 전송되는 한글 데이터에 대한 인코딩 설정
		//get방식으로 전송되는 한글 데이터는 서버별 설정 파일에 추가 설정
		//server.xml 문서에 63line에 URIEncoding="euc-kr" 추가
		request.setCharacterEncoding("euc-kr");
		
		
		//모든 요청을 하나의 servlet이 받음 : command pattern & controller 		
		String command=request.getParameter("command");
		
		//guestbook.do 로만 요청시 모두 보기 할수 있겠금 처리한 로직
		if(command == null){
			command = "list";
		}
		if(command.equals("list")){
			list(request, response);
		}else if(command.equals("write")){
			write(request, response);
		}else if(command.equals("read")){
			read(request, response);
		}else if(command.equals("updateForm")){
			updateForm(request, response);
		}else if(command.equals("update")){
			update(request, response);
		}else if(command.equals("delete")){
			delete(request, response);
		}
	}
	private void delete(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		String strNum=request.getParameter("num");
		String password = request.getParameter("password");
		
		if(strNum == null || strNum.trim().length() == 0 ||
			password == null || password.trim().length() == 0){
			response.sendRedirect("guestbook.do");
			return;				
		}
		boolean result = false;
		try {
			result = GuestBookDAO.deleteContent(Integer.parseInt(strNum),password);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "해당 게시글 삭제 실패했습니다. 재 시도 하셔요");
		}
		if(result){
			response.sendRedirect("guestbook.do");			
			return;
		}else{
			request.setAttribute("error", "삭제하려는 게시글이 존재하지 않습니다");
		}
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
	/* 정상실행 후 모든 방명록 보기
	 * 		- 별도의 데이터를 추가 저장할 필요없이 guestbook.do url로 요청 
	 * 비정상 실행 예외 error.jsp로 상황메세지 전송해서 실행	 */
	private void update(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		String strNum = request.getParameter("num");
		String title=request.getParameter("title");
		String author=request.getParameter("author");				
		String email=request.getParameter("email");				
		String content=request.getParameter("content");
		String password=request.getParameter("password");
		if(strNum == null || strNum.trim().length() == 0 ||
			title == null || title.trim().length() == 0 ||
			author == null || author.trim().length() == 0 ||
			email == null || email.trim().length() == 0 ||
			content == null || content.trim().length() == 0 ||
			password == null || password.trim().length() == 0 ){
				response.sendRedirect("guestbook.do");
				return;
		}
		boolean result = false;
		try {
			result = GuestBookDAO.updateContent(new GuestBookBean(Integer.parseInt(strNum),title,author,email,content,password));
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "게시글 수정 실패");
		}
		if(result){
			response.sendRedirect("guestbook.do");
			return;
		}
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}

	private void updateForm(HttpServletRequest request, HttpServletResponse response) 
	throws IOException, ServletException{
		String strNum=request.getParameter("num");
		if(strNum == null || strNum.trim().length() == 0){
			response.sendRedirect("guestbook.do");
			return;				
		}
		String url = "error.jsp";
		GuestBookBean gContent = null;
		try {
			gContent = GuestBookDAO.getContent(Integer.parseInt(strNum), false);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "수정하고자 하는 게시글 검색 실패했습니다");
		}
		if(gContent == null){
			request.setAttribute("error", "수정하고자 하는 게시글이 존재하지 않습니다");
		}else{
			request.setAttribute("resultContent", gContent);
			url = "update.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	private void read(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String strNum=request.getParameter("num");
		if(strNum==null || strNum.length() == 0){
			response.sendRedirect("guestbook.do");
			return;
		}
		String url = "error.jsp";
		GuestBookBean gContent = null;
		try {
			gContent = GuestBookDAO.getContent(Integer.parseInt(strNum), true);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "게시글 읽기 실패");
		}
		if(gContent == null){
			request.setAttribute("error", "해당 게시글이 존재하지 않습니다");
		}else{
			request.setAttribute("resultContent", gContent);
			url = "/read.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	//방명록 작성 : db에 저장
	private void write(HttpServletRequest request, HttpServletResponse response) 
				throws IOException, ServletException{
		String title=request.getParameter("title");
		String author=request.getParameter("author");				
		String email=request.getParameter("email");				
		String content=request.getParameter("content");				
		String password=request.getParameter("password");
		
		//데이터값 입력 유무만 유효성 검증
		if(title == null || title.trim().length() == 0 ||
		author == null || author.trim().length() == 0 ||
		email == null || email.trim().length() == 0 ||
		content == null || content.trim().length() == 0 ||
		password == null || password.trim().length() == 0 ){
			response.sendRedirect("write.html");
			return;//write() 메소드 종료
		}
		boolean result = false;
		try {
			result = GuestBookDAO.writeContent(new GuestBookBean(title,author,email,content,password));
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "게시글 저장 시도 실패 재 시도 하세요");
		}
		if(result){
			//db에 정상 저장후 guestbook.do로 url 요청 : get방식으로 리다이렉트
			//guestbook.do : web.xml 
			response.sendRedirect("guestbook.do"); 
		}else{
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	/* 정상? 비정상? 관련된 고려사항을 반영
	 * 비정상 실행일 경우 error.jsp로 이동 추가
	 * error.jsp에 EL tag로 상황 메세지 출력
	 */
	private void list(HttpServletRequest request, HttpServletResponse response) 
							throws ServletException, IOException {
		String url = "error.jsp";
		try {
			request.setAttribute("list", GuestBookDAO.getAllContents());
			url = "list.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "모두 보기 실패 재 실행 해 주세요");
		}	
		request.getRequestDispatcher(url).forward(request, response);
	}
}
 
 
 
 
 
 
 
 
 
 