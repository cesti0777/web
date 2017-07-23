/* CREATE TABLE activist (
       activist_id          VARCHAR2(20)  PRIMARY KEY,
       name                 VARCHAR2(20) NULL,
       password             VARCHAR2(20) NULL,
       major                VARCHAR2(50) NULL
);  */
package probono.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import probono.model.dto.ActivistDTO;
import probono.model.util.DBUtil;

public class ActivistDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();

	// 삽입
	public static boolean addActivist(ActivistDTO activist) throws SQLException {
		//채우기
	}

	// 수정
	// 기부자 id로 주요 기부 내용 수정하기
	public static boolean updateActivist(String activistId, String major) throws SQLException {
		//채우기
	}

	// ??? 삭제
	// sql - delete from activist where activist_id=?
	public static boolean deleteActivist(String activistId) throws SQLException {
		//채우기
	}

	// id로 해당 기부자의 모든 정보 반환
	public static ActivistDTO getActivist(String activistId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ActivistDTO activist = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from activist where activist_id=?");
			pstmt.setString(1, activistId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				activist = new ActivistDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return activist;
	}

	// ???모든 기부자 검색해서 반환
	// sql - select * from activist
	public static ArrayList<ActivistDTO> getAllActivists() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ActivistDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from activist");
			rset = pstmt.executeQuery();

			list = new ArrayList<ActivistDTO>();
			while (rset.next()) {
				list.add(new ActivistDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
