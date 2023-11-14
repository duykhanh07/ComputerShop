package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;

public class ThongKeDoanhThuDAO {
	
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
	
	public static String[] layCacNam() {
		String[] nam = {"---------"};
		try {
			Connection conn = getConnection();
			Statement sta = conn.createStatement();
			String query = "SELECT distinct DATE_FORMAT(ngaylaphd, '%Y') as nam FROM hoadon\r\n"
					+ "ORDER BY DATE_FORMAT(ngaylaphd, '%Y')";
			ResultSet rss = sta.executeQuery(query);
			while(rss.next()) {
				nam = Arrays.copyOf(nam, nam.length+1);
				nam[nam.length-1] = rss.getString("nam");
			}
			conn.close();
			return nam;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public static String[] layCacQuy(String nam) {
		String[] quy = {"---------"};
		try {
			Connection conn = getConnection();
			Statement sta = conn.createStatement();
			String query = "SELECT distinct QUARTER(ngaylaphd) as quy \r\n"
					+ "FROM hoadon\r\n"
					+ "WHERE DATE_FORMAT(ngaylaphd, '%Y') = '"+nam+"'\r\n"
					+ "ORDER BY QUARTER(ngaylaphd)";
			ResultSet rss = sta.executeQuery(query);
			while(rss.next()) {
				quy = Arrays.copyOf(quy, quy.length+1);
				quy[quy.length-1] = rss.getString("quy");
			}
			conn.close();
			return quy;
		} catch (Exception e) {	}
		return null;
	}
	
	public static String[] layCacThang(String nam) {
		String[] thang = {"---------"};
		try {
			Connection conn = getConnection();
			Statement sta = conn.createStatement();
			String query = "SELECT distinct DATE_FORMAT(ngaylaphd, '%m') AS thang\r\n"
					+ "FROM hoadon\r\n"
					+ "WHERE DATE_FORMAT(ngaylaphd,'%Y') = '"+nam+"'";
			ResultSet rss = sta.executeQuery(query);
			while(rss.next()) {
				thang = Arrays.copyOf(thang, thang.length+1);
				thang[thang.length-1] = rss.getString("thang");
			}
			conn.close();
			return thang;
		} catch (Exception e) {	}
		return null;
	}
	public static ResultSet layDoanhThuTheoCacNam(){
		try {
			Connection conn = getConnection();
			Statement sta = conn.createStatement();
			String query = "SELECT DATE_FORMAT(ngaylaphd, \"%Y\")AS nam, SUM(tongtien) AS doanhthu\r\n"
					+ "FROM hoadon\r\n"
					+ "WHERE trangthai = 'đã thanh toán'\r\n"
					+ "GROUP BY DATE_FORMAT(ngaylaphd, \"%Y\")";
			return sta.executeQuery(query);
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public static ResultSet layDoanhThuTheoNam(String nam, int opt) {
		try {
			Connection conn = getConnection();
			Statement sta = conn.createStatement();
			String query;
			if(opt == 1) {
				query = "SELECT Quarter(ngaylaphd) AS quy, SUM(tongtien) AS doanhthu\r\n"
						+ "FROM hoadon\r\n"
						+ "WHERE DATE_FORMAT(ngaylaphd,'%Y') = '"+nam+"' \r\n"
						+ "GROUP BY Quarter(ngaylaphd)";
			}else{
				query = "SELECT DATE_FORMAT(ngaylaphd,'%m') AS thang, SUM(tongtien) AS doanhthu\r\n"
						+ "FROM hoadon\r\n"
						+ "WHERE DATE_FORMAT(ngaylaphd,'%Y') = '"+nam+"' \r\n"
						+ "GROUP BY DATE_FORMAT(ngaylaphd,'%m')";
			}	
			return sta.executeQuery(query);
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public static ResultSet layDoanhThuTheoQuy(String nam, String quy) {
		try {
			Connection conn = getConnection();
			Statement sta = conn.createStatement();
			String query = "SELECT DATE_FORMAT(ngaylaphd,'%m') AS thang, SUM(tongtien) AS doanhthu\r\n"
					+ "FROM hoadon\r\n"
					+ "WHERE DATE_FORMAT(ngaylaphd,'%Y') = '"+nam+"' \r\n and quarter(ngaylaphd) ="+quy+"\r\n"
					+ "GROUP BY DATE_FORMAT(ngaylaphd,'%m')";
			return sta.executeQuery(query);
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public static ResultSet layDoanhThuTheoThang(String nam, String thang) {
		try {
			Connection conn = getConnection();
			Statement sta = conn.createStatement();
			String query = "SELECT DAY(ngaylaphd) as ngay, SUM(tongtien) AS doanhthu\r\n"
					+ "FROM hoadon\r\n"
					+ "WHERE DATE_FORMAT(ngaylaphd,'%Y') = '"+nam+"' AND DATE_FORMAT(ngaylaphd,'%m')= '"+thang+"'\r\n"
					+ "GROUP BY DAY(ngaylaphd)";
			return sta.executeQuery(query);
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
