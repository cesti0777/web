package coin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coin.model.CoinService;
import coin.model.MemberService;
import coin.model.dto.BtcDTO;
import coin.model.dto.DashDTO;
import coin.model.dto.EtcDTO;
import coin.model.dto.EthDTO;
import coin.model.dto.LtcDTO;
import coin.model.dto.MemberDTO;
import coin.model.dto.WalletCoinDTO;
import coin.model.dto.XrpDTO;

public class CoinFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String command = request.getParameter("command");
		try{
			if(command != null){
				if(command.equals("memberInsert")){//ȸ������
					memberInsert(request, response);
				}else if(command.equals("login")){//�α���
					memberLogin(request, response);
				}else if(request.getSession().getAttribute("name") != null){//�α��� ���¿����� ����
					if(command.equals("btc")){//�̵��
						response.sendRedirect("btc.jsp");
					}else if(command.equals("eth")){//�̵��
						response.sendRedirect("eth.jsp");
					}else if(command.equals("ltc")){//�̵��
						response.sendRedirect("ltc.jsp");
					}else if(command.equals("etc")){//�̵��
						response.sendRedirect("etc.jsp");
					}else if(command.equals("xrp")){//�̵��
						response.sendRedirect("xrp.jsp");
					}else if(command.equals("dash")){//�̵��
						response.sendRedirect("dash.jsp");
					}else if(command.equals("logout")){//�α׾ƿ�
						memberLogout(request, response);
					}else if(command.equals("wallet")){//������
						response.sendRedirect("wallet.jsp");
					}else if(command.equals("coinInfo")){//��������
						coinInfo(request, response);
					}else if(command.equals("coinInfoUpdate")){//������
						coinInfoUpdate(request, response);
					}else if(command.equals("coinAmount")){//������
						coinAmount(request, response);
					}
				}else if(command.equals("btcAll")){// ��� ��Ʈ���� ���� �˻�
					btcAll(request, response);
				}else if(command.equals("getbtc")){// ��¥�� ��Ʈ���� �˻�
					getbtc(request, response);
				}else if(command.equals("btcInsert")){// ��Ʈ���� �߰� ���
					btcInsert(request, response);   
				}else if(command.equals("ethInsert")){	// ��Ʈ���� �߰� ���
					ethInsert(request, response);   
				}else if(command.equals("ltcInsert")){	// ��Ʈ���� �߰� ���
					ltcInsert(request, response);   
				}else if(command.equals("etcInsert")){	// ��Ʈ���� �߰� ���
					etcInsert(request, response);   
				}else if(command.equals("xrpInsert")){	// ��Ʈ���� �߰� ���
					xrpInsert(request, response);   
				}else if(command.equals("dashInsert")){	// ��Ʈ���� �߰� ���
					dashInsert(request, response);   
				}
				else{
					request.setAttribute("errorMsg", "�α��� �� �̿����ּ���");
					request.getRequestDispatcher("showError.jsp").forward(request, response);
				}
			}else{
				response.sendRedirect("index.jsp");
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}

	//���� ���� ��ȸ �޼ҵ�
	protected void coinInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String coinName = request.getParameter("coinName");
		try{
			HttpSession session = request.getSession();
			WalletCoinDTO coinInfo = MemberService.getCoinInfo((String)session.getAttribute("id"), coinName);
			if(coinInfo == null){
				String coinInfoJson = "{\"name\":\""+"empty"
                +"\",\"amount\":\""+"0"
                +"\",\"price\":\""+"0"
                +"\"}";
				  response.getWriter().print(coinInfoJson);
			}else{
				  String coinInfoJson = "{\"name\":\""+coinInfo.getCoinName()
                  +"\",\"amount\":\""+coinInfo.getAmount()
                  +"\",\"price\":\""+coinInfo.getPrice()
                  +"\"}";
				  response.getWriter().print(coinInfoJson);
				
			}
		}catch(Exception s){
			s.printStackTrace();
			request.setAttribute("errorMsg", s.getMessage());
		}
	}
	
	//���� ���� ��ȸ �޼ҵ�
		protected void coinAmount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try{
				HttpSession session = request.getSession();
				ArrayList<Integer> allCoinInfo =  MemberService.getAllCoinInfo((String)session.getAttribute("id"));
			    String coinAmountJson = "{"
			                    +"\"amountAll\":\""+allCoinInfo.get(0)
			                    +"\",\"amountBTC\":\""+allCoinInfo.get(1)
			                    +"\",\"amountETH\":\""+allCoinInfo.get(2)
			                    +"\",\"amountDASH\":\""+allCoinInfo.get(3)
			                    +"\",\"amountLTC\":\""+allCoinInfo.get(4)
			                    +"\",\"amountETC\":\""+allCoinInfo.get(5)
			                    +"\",\"amountXRP\":\""+allCoinInfo.get(6)
			                    +"\"}";
			    response.getWriter().print(coinAmountJson);
			}catch(Exception s){
				s.printStackTrace();
				request.setAttribute("errorMsg", s.getMessage());
			}
		}
	
	//������ ���� 
	public void coinInfoUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			HttpSession session = request.getSession();
			String cname = request.getParameter("cname");
			String updateType = request.getParameter("updateType");
			int updateAmount = Integer.parseInt(request.getParameter("updateAmount"));
			int updatePrice = Integer.parseInt(request.getParameter("updatePrice"));
			MemberService.updateCoin((String)session.getAttribute("id"), cname, updateType, updateAmount, updatePrice);
			url = "wallet.jsp?command=wallet";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	

	//ȸ�� ���� �޼ҵ�
	protected void memberInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		String name = request.getParameter("name");
		System.out.println(name);
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		MemberDTO member = new MemberDTO(id, name, pw, email);
		try{
			boolean result = MemberService.addMember(member);
			if(result){
				request.setAttribute("member", member);
				request.setAttribute("successMsg", "���� �Ϸ�");
				url = "loginResult.jsp";
			}else{
				request.setAttribute("errorMsg", "�ٽ� �õ��ϼ���");
			}
		}catch(Exception s){
			s.printStackTrace();
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	//�α��� �޼ҵ�
	protected void memberLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		try{
			MemberDTO member = MemberService.getMember(id);
			if(member.getPw().equals(pw)){
				HttpSession session = request.getSession();//���� ����
				session.setAttribute("member", member);
				session.setAttribute("name", member.getName());
				session.setAttribute("id", member.getId());
				request.setAttribute("successMsg", "�α��� ����");
				url = "index.jsp";
			}else{
				request.setAttribute("errorMsg", "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			}
		}catch(Exception s){
			s.printStackTrace();
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	protected void memberLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try{
			request.getSession(true).invalidate();
			request.setAttribute("successMsg", "�α׾ƿ� ����");
			url = "index.jsp";
		}catch(Exception s){
			s.printStackTrace();
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	// ��� ��Ʈ���� �˻�
	public void btcAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("btcAll", CoinService.getAllBtc());
			url = "coinList.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// ��¥�� ���� ��Ʈ���� �˻�
	public void getbtc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("btc", CoinService.getBtc(request.getParameter("btcDay")));
			url = "btcDetail.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
		
	// ��Ʈ���� ������ ����
	protected void btcInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		String date = null;
		double price, volume;
		int eid;
		boolean result = false;
		String[] data = request.getParameter("btcData").split(",");

		try {
			for (int i = 0; i < data.length; i++) {
				date = data[i].split("/")[0];
				price = Double.parseDouble(data[i].split("/")[1]);
				volume = Double.parseDouble(data[i].split("/")[2]);
				eid = Integer.parseInt(data[i].split("/")[3]);
				BtcDTO btc = new BtcDTO(date, price, volume, eid);
				result = CoinService.addBtc(btc);
			}
			if (result) {
				request.setAttribute("errorMsg", "���� �Ϸ�");
				url = "showError.jsp";
			} else {
				request.setAttribute("errorMsg", "�ٽ� �õ��ϼ���.");
			}
		} catch (Exception s) {
			s.printStackTrace();
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	// �̴����� ������ ����
	protected void ethInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		String date = null;
		double price, volume;
		int eid;
		boolean result = false;
		String[] data = request.getParameter("ethData").split(",");

		try {
			for (int i = 0; i < data.length; i++) {
				date = data[i].split("/")[0];
				price = Double.parseDouble(data[i].split("/")[1]);
				volume = Double.parseDouble(data[i].split("/")[2]);
				eid = Integer.parseInt(data[i].split("/")[3]);
				EthDTO eth = new EthDTO(date, price, volume, eid);
				result = CoinService.addEth(eth);
			}
			if (result) {
				request.setAttribute("errorMsg", "���� �Ϸ�");
				url = "showError.jsp";
			} else {
				request.setAttribute("errorMsg", "�ٽ� �õ��ϼ���.");
			}
		} catch (Exception s) {
			s.printStackTrace();
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	// ����Ʈ���� ������ ����
	protected void ltcInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "showError.jsp";
			String date = null;
			double price, volume;
			int eid;
			boolean result = false;
			String[] data = request.getParameter("ltcData").split(",");

			try {
				for (int i = 0; i < data.length; i++) {
					date = data[i].split("/")[0];
					price = Double.parseDouble(data[i].split("/")[1]);
					volume = Double.parseDouble(data[i].split("/")[2]);
					eid = Integer.parseInt(data[i].split("/")[3]);
					LtcDTO ltc = new LtcDTO(date, price, volume, eid);
					result = CoinService.addLtc(ltc);
				}
				if (result) {
					request.setAttribute("errorMsg", "���� �Ϸ�");
					url = "showError.jsp";
				} else {
					request.setAttribute("errorMsg", "�ٽ� �õ��ϼ���.");
				}
			} catch (Exception s) {
				s.printStackTrace();
				request.setAttribute("errorMsg", s.getMessage());
			}
			request.getRequestDispatcher(url).forward(request, response);
		}
	// �̴�����Ŭ���� ������ ����
	protected void etcInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		String date = null;
		double price, volume;
		int eid;
		boolean result = false;
		String[] data = request.getParameter("etcData").split(",");

		try {
			for (int i = 0; i < data.length; i++) {
				date = data[i].split("/")[0];
				price = Double.parseDouble(data[i].split("/")[1]);
				volume = Double.parseDouble(data[i].split("/")[2]);
				eid = Integer.parseInt(data[i].split("/")[3]);
				EtcDTO etc = new EtcDTO(date, price, volume, eid);
				result = CoinService.addEtc(etc);
			}
			if (result) {
				request.setAttribute("errorMsg", "���� �Ϸ�");
				url = "showError.jsp";
			} else {
				request.setAttribute("errorMsg", "�ٽ� �õ��ϼ���.");
			}
		} catch (Exception s) {
			s.printStackTrace();
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	// ���� ������ ����
	protected void xrpInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		String date = null;
		double price, volume;
		int eid;
		boolean result = false;
		String[] data = request.getParameter("xrpData").split(",");

		try {
			for (int i = 0; i < data.length; i++) {
				date = data[i].split("/")[0];
				price = Double.parseDouble(data[i].split("/")[1]);
				volume = Double.parseDouble(data[i].split("/")[2]);
				eid = Integer.parseInt(data[i].split("/")[3]);
				XrpDTO xrp = new XrpDTO(date, price, volume, eid);
				result = CoinService.addXrp(xrp);
			}
			if (result) {
				request.setAttribute("errorMsg", "���� �Ϸ�");
				url = "showError.jsp";
			} else {
				request.setAttribute("errorMsg", "�ٽ� �õ��ϼ���.");
			}
		} catch (Exception s) {
			s.printStackTrace();
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
		
		// �뽬 ������ ����
	protected void dashInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		String date = null;
		double price, volume;
		int eid;
		boolean result = false;
		String[] data = request.getParameter("dashData").split(",");

		try {
			for (int i = 0; i < data.length; i++) {
				date = data[i].split("/")[0];
				price = Double.parseDouble(data[i].split("/")[1]);
				volume = Double.parseDouble(data[i].split("/")[2]);
				eid = Integer.parseInt(data[i].split("/")[3]);
				DashDTO xrp = new DashDTO(date, price, volume, eid);
				result = CoinService.addDash(xrp);
			}
			if (result) {
				request.setAttribute("errorMsg", "���� �Ϸ�");
				url = "showError.jsp";
			} else {
				request.setAttribute("errorMsg", "�ٽ� �õ��ϼ���.");
			}
		} catch (Exception s) {
			s.printStackTrace();
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
