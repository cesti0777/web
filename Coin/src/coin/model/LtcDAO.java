package coin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import coin.model.dto.LtcDTO;
import coin.model.util.DBUtil;

public class LtcDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();

	// 데이터 삽입
	public static boolean addLtc(LtcDTO ltc) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("addLtc"));
			pstmt.setString(1, ltc.getDay());
			pstmt.setDouble(2, ltc.getLast_price());
			pstmt.setDouble(3, ltc.getVolume());
			pstmt.setInt(4, ltc.getEid());

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
	public static LtcDTO getLtc(String date) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		LtcDTO ltc = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getLtc"));
			pstmt.setString(1, date);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				ltc = new LtcDTO(rset.getString(1), rset.getDouble(2), rset.getDouble(3), rset.getInt(4));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return ltc;
	}

	// 모든 코인 검색해서 반환
	public static ArrayList<LtcDTO> getAllLtc() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<LtcDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getAllLtc"));
			rset = pstmt.executeQuery();

			list = new ArrayList<LtcDTO>();
			while (rset.next()) {
				list.add(new LtcDTO(rset.getString(1), rset.getDouble(2), rset.getDouble(3), rset.getInt(4)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
