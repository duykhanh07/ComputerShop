package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import DTO.DTO_NhanVien;

public class DAO_NhanVien {
private static Connection conn = null;
	
	public static void openData() {
		try {
			DriverManager.registerDriver(new SQLServerDriver());
			String uri = "jdbc:mySQL://localhost:3306/quanlycuahang";
			String user = "root";
			String password = "";
			
			conn = DriverManager.getConnection(uri, user, password);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static String[] selectAllNhanVien() {
		openData();
		String[] data = {null,null,null};
		openData();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String sql = "select * from nhanvien";
			ResultSet rs  = stmt.executeQuery(sql);
			while(rs.next()) {		
				data[0] = rs.getString("manv");
				data[1] = rs.getString("tennv");
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
