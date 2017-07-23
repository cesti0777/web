package coin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import coin.model.dto.BtcDTO;
import coin.model.util.DBUtil;

public class BtcDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();

	// 비트코인 데이터 삽입
	public static boolean addBtc(BtcDTO btc) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("addBtc"));
			pstmt.setString(1, btc.getDay());
			pstmt.setDouble(2, btc.getLast_price());
			pstmt.setDouble(3, btc.getVolume());
			pstmt.setInt(4, btc.getEid());

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
			
		} finally {
			DBUtil.close(con, pstmt);
		}
		
		return false;
	}

	// 날짜로 해당 비트코인의 모든 정보 반환
	public static BtcDTO getBtc(String date) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BtcDTO btc = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getBtc"));
			pstmt.setString(1, date);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				btc = new BtcDTO(rset.getString(1), rset.getDouble(2), rset.getDouble(3), rset.getInt(4));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return btc;
	}

	// 모든 비트코인 검색해서 반환
	public static ArrayList<BtcDTO> getAllBtc() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BtcDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getAllBtc"));
			rset = pstmt.executeQuery();

			list = new ArrayList<BtcDTO>();
			while (rset.next()) {
				list.add(new BtcDTO(rset.getString(1), rset.getDouble(2), rset.getDouble(3), rset.getInt(4)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
