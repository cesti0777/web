package coin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import coin.model.dto.EthDTO;
import coin.model.util.DBUtil;

public class EthDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();

	// 데이터 삽입
	public static boolean addEth(EthDTO eth) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("addEth"));
			pstmt.setString(1, eth.getDay());
			pstmt.setDouble(2, eth.getLast_price());
			pstmt.setDouble(3, eth.getVolume());
			pstmt.setInt(4, eth.getEid());

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
	public static EthDTO getEth(String date) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		EthDTO eth = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getEth"));
			pstmt.setString(1, date);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				eth = new EthDTO(rset.getString(1), rset.getDouble(2), rset.getDouble(3), rset.getInt(4));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return eth;
	}

	// 모든 코인 검색해서 반환
	public static ArrayList<EthDTO> getAllEth() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<EthDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getAllEth"));
			rset = pstmt.executeQuery();

			list = new ArrayList<EthDTO>();
			while (rset.next()) {
				list.add(new EthDTO(rset.getString(1), rset.getDouble(2), rset.getDouble(3), rset.getInt(4)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
