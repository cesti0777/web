package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Util {
	static Properties sql = new Properties();
	private static DataSource source = null;
	
	/* jdbc/myoracle 이라는 리소스 설정 이름으로
	 * 연관 객체를 반환해서
	 * 해당 객체로부터 승인하에 Connection 객체 제공받고 사용하고 반환(재사용) */
	static {
		try {
			Context ctx = new InitialContext();
			source = (DataSource) ctx.lookup("java:comp/env/jdbc/myoracle");
			System.out.println(source);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			sql.load(new FileReader("D:/0.swStudy/4.web/step06_miniProject_s/sql.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Properties getProperties(){
		return sql;
	}
	
	public static DataSource getDataSource() throws SQLException{ 
		return source;
	}
	
	public static void close(Connection con, Statement stmt, ResultSet rset){ 
		try { 
			if(rset != null){
				rset.close();
				rset = null; 
			}
			if(stmt != null){
				stmt.close();
				stmt = null; 
			} 
			if(con != null){
				con.close();
				con = null; 
			} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection con, Statement stmt){ // 퍼포먼스 고려해서 dml용 따로 만듬.
		try { 
			if(stmt != null){
				stmt.close();
				stmt = null; 
			} 
			if(con != null){
				con.close();
				con = null; 
			} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

