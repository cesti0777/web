package coin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import coin.model.dto.DashDTO;
import coin.model.util.DBUtil;

public class DashDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();

	// 데이터 삽입
	public static boolean addDash(DashDTO dash) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("addDash"));
			pstmt.setString(1, dash.getDay());
			pstmt.setDouble(2, dash.getLast_price());
			pstmt.setDouble(3, dash.getVolume());
			pstmt.setInt(4, dash.getEid());

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
			
		} finally {
			DBUtil.close(con, pstmt);
		}
		
		return false;
	}

	// 날짜로 해당 코인의 모든 정보 반환
	public static DashDTO getDash(String date) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		DashDTO dash = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getDash"));
			pstmt.setString(1, date);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				dash = new DashDTO(rset.getString(1), rset.getDouble(2), rset.getDouble(3), rset.getInt(4));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return dash;
	}

	// 모든 코인 검색해서 반환
	public static ArrayList<DashDTO> getAllDash() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DashDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getAllDash"));
			rset = pstmt.executeQuery();

			list = new ArrayList<DashDTO>();
			while (rset.next()) {
				list.add(new DashDTO(rset.getString(1), rset.getDouble(2), rset.getDouble(3), rset.getInt(4)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
