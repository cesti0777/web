package coin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import coin.model.dto.XrpDTO;
import coin.model.util.DBUtil;

public class XrpDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();

	// 데이터 삽입
	public static boolean addXrp(XrpDTO xrp) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("addXrp"));
			pstmt.setString(1, xrp.getDay());
			pstmt.setDouble(2, xrp.getLast_price());
			pstmt.setDouble(3, xrp.getVolume());
			pstmt.setInt(4, xrp.getEid());

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
	public static XrpDTO getXrp(String date) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		XrpDTO xrp = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getXrp"));
			pstmt.setString(1, date);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				xrp = new XrpDTO(rset.getString(1), rset.getDouble(2), rset.getDouble(3), rset.getInt(4));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return xrp;
	}

	// 모든 코인 검색해서 반환
	public static ArrayList<XrpDTO> getAllXrp() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<XrpDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getAllXrp"));
			rset = pstmt.executeQuery();

			list = new ArrayList<XrpDTO>();
			while (rset.next()) {
				list.add(new XrpDTO(rset.getString(1), rset.getDouble(2), rset.getDouble(3), rset.getInt(4)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
