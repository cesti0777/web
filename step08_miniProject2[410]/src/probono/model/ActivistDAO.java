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

	// ����
	public static boolean addActivist(ActivistDTO activist) throws SQLException {
		//ä���
	}

	// ����
	// ����� id�� �ֿ� ��� ���� �����ϱ�
	public static boolean updateActivist(String activistId, String major) throws SQLException {
		//ä���
	}

	// ??? ����
	// sql - delete from activist where activist_id=?
	public static boolean deleteActivist(String activistId) throws SQLException {
		//ä���
	}

	// id�� �ش� ������� ��� ���� ��ȯ
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

	// ???��� ����� �˻��ؼ� ��ȯ
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
