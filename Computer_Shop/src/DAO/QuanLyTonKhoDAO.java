package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QuanLyTonKhoDAO {
		
	public static Connection getConnection() {
		Connection conn;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlycuahang", "root", "");
			return conn;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	public static ArrayList[] getTonKho(){
		ArrayList<String> ds_masp = new ArrayList<String>();
		ArrayList<String> ds_tensp = new ArrayList<String>();
		ArrayList<Integer> ds_soluong = new ArrayList<Integer>();
		try {
			Connection conn = getConnection();
			Statement sta = conn.createStatement();
			String query = "SELECT DSNHAP.masp,sp.tensp, DSNHAP.nhap - DSDOANHSO.doanhso AS soluongton\r\n"
					+ "FROM\r\n"
					+ "sanpham AS sp\r\n"
					+ "JOIN\r\n"
					+ "(SELECT ctdn.masp, SUM(ctdn.solg) AS nhap\r\n"
					+ "FROM ctdn\r\n"
					+ "GROUP BY ctdn.masp) AS DSNHAP\r\n"
					+ "ON DSNHAP.masp = sp.masp\r\n"
					+ "JOIN\r\n"
					+ "(SELECT cthd.masp, SUM(cthd.solg) AS doanhso\r\n"
					+ "FROM cthd\r\n"
					+ "GROUP BY cthd.masp) AS DSDOANHSO\r\n"
					+ "ON DSNHAP.masp = DSDOANHSO.masp\r\n"
					+ "GROUP BY DSNHAP. masp";
			ResultSet rss = sta.executeQuery(query);
			while(rss.next()) {
				ds_masp.add(rss.getString("masp"));
				ds_tensp.add(rss.getString("tensp"));
				ds_soluong.add(rss.getInt("soluongton"));
			}
			ArrayList[] ds_tonkho = {ds_masp, ds_tensp, ds_soluong};
			return ds_tonkho;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
}
