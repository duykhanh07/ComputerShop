package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class LoginDAO {
	
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
	
	public static String[] Login(String username, String password) {
		openData();
		String[] data = {null,null,null};
		openData();
		try {
			Statement sta = conn.createStatement();
			String query = "SELECT * \r\n"
					+ "FROM nhanvien AS nv JOIN taikhoan AS tk ON nv.manv = tk.manv\r\n"
					+ "WHERE username='"+username+"' AND password ='"+password+"' AND tinhtrang=1";			
			ResultSet rs  = sta.executeQuery(query);
			while(rs.next()) {		
				data[0] = rs.getString("manv");
				data[1] = rs.getString("tennv");
				data[2] = rs.getString("chucvu");	
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
	}
	
	
	public static void main(String[] args) {
		LoginDAO.Login("admin", "888888888");
	}
}
