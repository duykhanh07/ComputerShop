package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class DAO_TaiKhoan {
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
	
	public static String[] selectTaikhoanNV() {
		openData();
		String[] data = {null,null,null};
		openData();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String sql = "select * from taikhoan";
			ResultSet rs  = stmt.executeQuery(sql);
			while(rs.next()) {		
				data[0] = rs.getString("matk");
				data[1] = rs.getString("manv");
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
