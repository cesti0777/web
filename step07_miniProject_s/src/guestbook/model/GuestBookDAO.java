package guestbook.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import util.DBUtil;

public class GuestBookDAO {
	// 모든 DAO에서 공통적으로 사용하는 공유 자원 보유 객체
	// web bproject 에서 properties파일의 정보를 뷰아하게 되는 객체는 ResourceBundle 사용
	// main 메소드 기반의 standalone app~에서 java.util.Properties 객체 사용 했었음.
	static ResourceBundle sql = DBUtil.getResourceBundle();
	// 게시물 등록
	//end user가 insert시도
	/*발생 가능한 경우의 수
	 * 1. 정상 insert
	 * 2. 서버(WAS) 문제 발생이 비정상 실행
	 * 3. DB 서버 문제 "	
	 * 4. 고유한 ID 중복 : 예외 발생 */
	public static boolean writeContent(GuestBookBean vo) throws SQLException{
		System.out.println(sql.getString("writeContent"));
		Connection con = null;	
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			con = DBUtil.getConnection();
			//INSERT INTO gbook VALUES(seq_gbook.nextval,?,?,?,?,?,sysdate,0)
			pstmt = con.prepareStatement(sql.getString("writeContent")); // getProperty에서 바뀜.

	        pstmt.setString(1,vo.getTitle());
	        pstmt.setString(2,vo.getAuthor());
	        pstmt.setString(3, vo.getEmail());
	        pstmt.setString(4, vo.getContent());
	        pstmt.setString(5, vo.getPassword());
	        
			int count = pstmt.executeUpdate();			
			if(count != 0){
				result = true;
			}
		}finally{
			DBUtil.close(pstmt, con);
		}
		return result;		
	}
	
	// 게시물 조회 - boolean flag 값 = read인 경우 true, update인 경우  false
	public static GuestBookBean getContent(int  num, boolean flag) throws SQLException{		
		Connection con = null;	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		GuestBookBean vo  = null;

		try {
			con = DBUtil.getConnection();
			if(flag){
				pstmt = con.prepareStatement(sql.getString("getContentUpdate"));
				pstmt.setInt(1, num);
				int count = pstmt.executeUpdate();
				if(count == 0){
					return vo;
				}
			}
			pstmt = con.prepareStatement(sql.getString("getContentSelect"));
			pstmt.setInt(1, num);	
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				vo = new GuestBookBean(num,rset.getString(1),
						rset.getString(2),rset.getString(3),rset.getString(4).replaceAll("</n>","<br>"),
						rset.getString(5),rset.getString(6),rset.getInt(7));
			}
		}finally{
			DBUtil.close(pstmt, con);
		}
		return vo;
	}
	
	//게시물 삭제
	public  static boolean deleteContent(int num, String password) throws SQLException{
		Connection con = null;	
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("deleteContent"));

			pstmt.setInt(1,num);
	        pstmt.setString(2,password);

			int count = pstmt.executeUpdate();
			
			if(count != 0){
				result = true;
			}
		}finally{
			DBUtil.close(pstmt, con);
		}
		return result;
	}
	
	// 게시물 수정
	public  static boolean updateContent(GuestBookBean vo) throws SQLException{
		Connection con = null;	
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			con = DBUtil.getConnection();
		
			pstmt = con.prepareStatement(sql.getString("updateContent"));
			pstmt.setString(1,vo.getTitle());
		    pstmt.setString(2,vo.getAuthor());
		    pstmt.setString(3, vo.getEmail());
		    pstmt.setString(4, vo.getContent());
		    pstmt.setInt(5, vo.getNum());
		    pstmt.setString(6, vo.getPassword());

			int count = pstmt.executeUpdate();
			
			if(count != 0){
				result = true;
			}
		}finally{
			DBUtil.close(pstmt, con);
		}
		return result;
	}
	
	// 모든 게시물 조회
	public  static ArrayList<GuestBookBean> getAllContents() throws SQLException{
		Connection con = null;	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<GuestBookBean> alist = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getAllContents"));
			rset = pstmt.executeQuery();
			alist = new ArrayList<GuestBookBean>();
			while(rset.next()){
				alist.add(new GuestBookBean(rset.getInt(1),rset.getString(2),
						rset.getString(3),rset.getString(4),rset.getString(5)
		 				,rset.getString(6),rset.getString(7),rset.getInt(8)));
			}
		}finally{
			DBUtil.close(rset, pstmt, con);
		}
		return alist;
	}
}
