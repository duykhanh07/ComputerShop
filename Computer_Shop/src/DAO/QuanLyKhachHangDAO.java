package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JOptionPane;

import DTO.DTO_KhachHang;

public class QuanLyKhachHangDAO {
	
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
	
	public static ArrayList<DTO_KhachHang> layKhachHang(){
		ArrayList<DTO_KhachHang> ds_KhachHang = new ArrayList<DTO_KhachHang>();
		try {
			Connection conn = getConnection();
			Statement sta = conn.createStatement();
			String query = "Select * from KHACHHANG";
			ResultSet rss = sta.executeQuery(query);
			while(rss.next()) {
				DTO_KhachHang khachHang = new DTO_KhachHang(rss.getString("makh"), rss.getString("tenkh"), rss.getString("sdt"), rss.getInt("diem"));
				ds_KhachHang.add(khachHang);
			}
			conn.close();
			return ds_KhachHang;
		} catch (SQLException e) {
			System.out.println(e);
		}	
		return null;
	}
	public static HashMap<String,Date> layLanCuoiMuaHang(){
		HashMap<String, Date> ds_lanCuoiMua = new HashMap<String, Date>();
		try {
			Connection conn = getConnection();
			Statement sta = conn.createStatement();
			String query = "Select kh.makh, MAX(hd.ngaylaphd) AS lancuoi "
					+ "from KHACHHANG as kh join HOADON as hd on kh.makh = hd.makh"
					+ " GROUP BY kh.makh";
			ResultSet rss = sta.executeQuery(query);
			while(rss.next()) {
				java.sql.Timestamp ts = rss.getTimestamp("lancuoi");
				java.sql.Date lancuoi = new java.sql.Date(ts.getTime());
				ds_lanCuoiMua.put(rss.getString("makh"), lancuoi);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return ds_lanCuoiMua;
	}
	
	public static int capNhatKhachHang(DTO_KhachHang khachHang) {
		try {
			Connection conn = getConnection();
			Statement sta = conn.createStatement();
			String query = "Update KhachHang "
					+ "set "
					+ "tenkh = '"+ khachHang.getTenkh()+"',"
					+ "sdt= '"+khachHang.getSdt()+"' "
					+ "where makh = '"+ khachHang.getMakh()+"'";
			int kq = sta.executeUpdate(query);
			return kq;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
