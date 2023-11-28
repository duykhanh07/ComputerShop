package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import DTO.DTO_CTDonNhap;
import DTO.DTO_DonNhap;

public class DAO_ChiTietDonNhap {
	
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
	
	public static ArrayList<DTO_CTDonNhap> selectChiTietDonNhap(String madn) {
		openData();
		ArrayList<DTO_CTDonNhap> listChiTietDonNhap = new ArrayList<DTO_CTDonNhap>();
		openData();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String sql = "SELECT ct.masp, sp.tensp, ct.dongia, ct.solg, ct.dongia*ct.solg as thanhtien\r\n"
					+"FROM donnhap as dn \r\n"
					+"JOIN ctdn as ct ON dn.madn=ct.madn \r\n"
					+"JOIN sanpham as sp ON ct.masp=sp.masp \r\n"
					+"WHERE dn.madn = '"+madn+"'";
			ResultSet rs  = stmt.executeQuery(sql);
			while(rs.next()) {		
				String maSanPham = rs.getString("masp");
				String tenSanPham = rs.getString("tensp");
				Double donGia = rs.getDouble("dongia");
				int solg = rs.getInt("solg");
				Double thanhTien = rs.getDouble("thanhtien");
				
				DTO_CTDonNhap ctdn = new DTO_CTDonNhap(null,maSanPham, tenSanPham, donGia, solg, thanhTien);
				listChiTietDonNhap.add(ctdn);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listChiTietDonNhap;
	}
}
