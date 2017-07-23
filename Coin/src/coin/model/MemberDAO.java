//create sequence member_seq_wid;
//CREATE TABLE member (
//       mid          			VARCHAR2(30)  PRIMARY KEY,
//       mname               	VARCHAR2(30) NOT NULL,
//       pw         				VARCHAR2(30) NOT NULL,
//       email                	VARCHAR2(50) NOT NULL,
//       wid						NUMBER(5) NOT NULL
//);
package coin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import coin.model.dto.MemberDTO;
import coin.model.dto.WalletCoinDTO;
import coin.model.util.DBUtil;

public class MemberDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();

	public static boolean addMember(MemberDTO member) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("addMember"));
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPw());
			pstmt.setString(4, member.getEmail());
			int result = pstmt.executeUpdate();
			pstmt = con.prepareStatement(sql.getString("addWallet1"));
			pstmt.setString(1, member.getId());
			pstmt.executeUpdate();
			pstmt = con.prepareStatement(sql.getString("addWallet2"));
			pstmt.setString(1, member.getId());
			pstmt.executeUpdate();
			pstmt = con.prepareStatement(sql.getString("addWallet3"));
			pstmt.setString(1, member.getId());
			pstmt.executeUpdate();
			pstmt = con.prepareStatement(sql.getString("addWallet4"));
			pstmt.setString(1, member.getId());
			pstmt.executeUpdate();
			pstmt = con.prepareStatement(sql.getString("addWallet5"));
			pstmt.setString(1, member.getId());
			pstmt.executeUpdate();
			pstmt = con.prepareStatement(sql.getString("addWallet6"));
			pstmt.setString(1, member.getId());
			pstmt.executeUpdate();
			
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 수정
	// 기부자 id로 주요 기부 내용 수정하기
	public static boolean updateMember(String memberId, String major) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("update member set major=? where member_id=?");
			pstmt.setString(1, major);
			pstmt.setString(2, memberId);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}


	// id로 해당 기부자의 모든 정보 반환
	public static MemberDTO getMember(String memberId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberDTO member = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getMember"));
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				member = new MemberDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return member;
	}

	// 모든 코인 정보 조회
	public static ArrayList<WalletCoinDTO> getWalletCoin(String memberId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<WalletCoinDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getWalletCoin"));
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			list = new ArrayList<WalletCoinDTO>();
			while (rset.next()) {
				list.add(new WalletCoinDTO(rset.getString(2), rset.getInt(3), rset.getInt(4)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	// 지갑 차트 데이터 조회
	public static ArrayList<Integer> getAllWalletData(String memberId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Integer> allWalletData = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getAllWalletAmount"));
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			allWalletData = new ArrayList<Integer>();
			rset.next();
			allWalletData.add(rset.getInt(1));
			pstmt = con.prepareStatement(sql.getString("getEachWalletAmount"));
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				allWalletData.add(rset.getInt(1));
			}
			
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return allWalletData;
	}
	
	// 코인 정보 수정
	public static boolean updateCoin(String memberId, String cName , int amount, int price) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("updateCoin"));
			pstmt.setInt(1, amount);
			pstmt.setInt(2, price);
			pstmt.setString(3, cName);
			pstmt.setString(4, memberId);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
}
