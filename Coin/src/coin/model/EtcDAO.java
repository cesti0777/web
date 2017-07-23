package coin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import coin.model.dto.EtcDTO;
import coin.model.util.DBUtil;

public class EtcDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();

	// ������ ����
	public static boolean addEtc(EtcDTO etc) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("addEtc"));
			pstmt.setString(1, etc.getDay());
			pstmt.setDouble(2, etc.getLast_price());
			pstmt.setDouble(3, etc.getVolume());
			pstmt.setInt(4, etc.getEid());

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
			
		} finally {
			DBUtil.close(con, pstmt);
		}
		
		return false;
	}

	// ��¥�� �ش� ������ ��� ���� ��ȯ
	public static EtcDTO getEtc(String date) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		EtcDTO etc = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getEtc"));
			pstmt.setString(1, date);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				etc = new EtcDTO(rset.getString(1), rset.getDouble(2), rset.getDouble(3), rset.getInt(4));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return etc;
	}

	// ��� ���� �˻��ؼ� ��ȯ
	public static ArrayList<EtcDTO> getAllEtc() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<EtcDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getAllEtc"));
			rset = pstmt.executeQuery();

			list = new ArrayList<EtcDTO>();
			while (rset.next()) {
				list.add(new EtcDTO(rset.getString(1), rset.getDouble(2), rset.getDouble(3), rset.getInt(4)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
