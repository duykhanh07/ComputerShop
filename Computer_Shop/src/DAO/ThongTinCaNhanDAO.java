package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ThongTinCaNhanDAO {
	
	public Connection Connect_mySQL() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlycuahang", "root", "");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int ExecuteUpdate(String query) {
		try {
			Connection conn = Connect_mySQL();
			Statement sta = conn.createStatement();
			int kq = sta.executeUpdate(query);
			conn.close();
			return kq;
		}catch (SQLException e) {
			System.out.println(e);
			return -1;
		}
	}
	
	public ResultSet ExecuteQuery(String query) {
		try {
		Connection conn = Connect_mySQL();
		Statement sta = conn.createStatement();
		ResultSet rss = sta.executeQuery(query);
		return rss;
		}catch (Exception e) {
			System.out.println(query);
			System.out.println(e);
		}
		return null;
	}
}
