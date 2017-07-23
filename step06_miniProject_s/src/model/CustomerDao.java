package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import util.Util;

public class CustomerDao {
	static Properties sql = Util.getProperties();

	public static void insert(CustomerVo cvo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = Util.getDataSource().getConnection();
			pstmt = con.prepareStatement(sql.getProperty("insert"));
			pstmt.setString(1, cvo.getId());
			pstmt.setString(2, cvo.getPassword());
			pstmt.setString(3, cvo.getName());
			pstmt.setString(4, cvo.getEmail());
			pstmt.executeUpdate();
		} finally { //catch 문장은 익셉션 던졌기 때문에 빼도됨
						//그래도 try finally 문은 필요.  자원반환 코드는 100% 실행되도록 해야함.
			Util.close(con, pstmt);
		}
	}

	/**
	 * 특정 고객을 Database customr table에서 삭제한다.<br>
	 * 호출 하는 곳으로 부터 삭제할 게시물의 id (PK)를 받아 Database에서 삭제한다..
	 * 
	 * Query : delete
	 * 
	 * 1. Connection 생성 2. PreparedStatement 생성 3. 쿼리 전송 4. close()
	 * 
	 * @param id
	 * @throws SQLException
	 */
	public static void delete(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = Util.getDataSource().getConnection();
			pstmt = con.prepareStatement(sql.getProperty("delete"));
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}finally {
			Util.close(con, pstmt);
		}
	}

	/**
	 * 특정 고객의 password와 email 정보를 Database customr table에서 갱신한다.<br>
	 * 
	 * Query : update
	 * 
	 * 1. Connection 생성 2. PreparedStatement 생성 3. 쿼리 전송 4. close()
	 * 
	 * @param id
	 * @throws SQLException
	 */
	public static void update(CustomerVo cvo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = Util.getDataSource().getConnection();

			pstmt = con.prepareStatement(sql.getProperty("update"));
			pstmt.setString(1, cvo.getPassword());
			pstmt.setString(2, cvo.getEmail());
			pstmt.setString(3, cvo.getId());

			pstmt.executeQuery();

		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			Util.close(con, pstmt);
		}
	}

	/**
	 * 모든 고객의 정보를 Database customr table에서 검색한다.<br>
	 * 
	 * Query : select
	 * 
	 * 1. Connection 생성 2. PreparedStatement 생성 3. 쿼리 전송 4. close()
	 * 
	 * @param id
	 * @throws SQLException
	 */
	public static ArrayList getCustomers() throws SQLException {
		System.out.println("CustomerDao getCustomers()");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList allList = new ArrayList();
		try {
			System.out.println("0");
			System.out.println(Util.getDataSource());
			conn = Util.getDataSource().getConnection();
			System.out.println("1");
			System.out.println(sql);
			System.out.println("------");
			System.out.println(sql.getProperty("getCustomers"));
			pstmt = conn.prepareStatement(sql.getProperty("getCustomers"));
			System.out.println("2");
			rset = pstmt.executeQuery();
			while (rset.next()) {
				allList.add(new CustomerVo(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			Util.close(conn, pstmt, rset);
		}
		return allList;
	}
}