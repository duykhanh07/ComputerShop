package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import DTO.DTO_DonNhap;

public class DAO_QuanLyDonNhap {
	
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
	
	public static ArrayList<DTO_DonNhap> selectAllDonNhap() {
		openData();
		ArrayList<DTO_DonNhap> listDonNhap = new ArrayList<DTO_DonNhap>();
		openData();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String sql = "select * from donnhap";
			ResultSet rs  = stmt.executeQuery(sql);
			while(rs.next()) {		
				String maDonNhap = rs.getString("madn");
				String maNhanVien = rs.getString("manv");
				String maNhaCungCap = rs.getString("mancc");
				Double tongTien = rs.getDouble("tongtien");
				Date ngayNhap = rs.getDate("ngaynhap");
				
				DTO_DonNhap donNhap = new DTO_DonNhap(maDonNhap, maNhanVien, maNhaCungCap, tongTien, ngayNhap);
				listDonNhap.add(donNhap);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listDonNhap;
	}
	
	public static ArrayList<DTO_DonNhap> selectDonNhap_MaDN(String madn) {
		openData();
		ArrayList<DTO_DonNhap> listDonNhap_Ma = new ArrayList<DTO_DonNhap>();
		openData();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String sql = "select * from donnhap where madn LIKE '%"+madn+"%'";
			ResultSet rs  = stmt.executeQuery(sql);
			while(rs.next()) {		
				String maDonNhap = rs.getString("madn");
				String maNhanVien = rs.getString("manv");
				String maNhaCungCap = rs.getString("mancc");
				Double tongTien = rs.getDouble("tongtien");
				Date ngayNhap = rs.getDate("ngaynhap");
				
				DTO_DonNhap donNhap = new DTO_DonNhap(maDonNhap, maNhanVien, maNhaCungCap, tongTien, ngayNhap);
				listDonNhap_Ma.add(donNhap);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listDonNhap_Ma;
	}
	
	public static ArrayList<DTO_DonNhap> selectDonNhap_MaNV(String manv) {
		openData();
		ArrayList<DTO_DonNhap> listDonNhap_Ma = new ArrayList<DTO_DonNhap>();
		openData();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String sql = "select * from donnhap where manv LIKE '%"+manv+"%'";
			ResultSet rs  = stmt.executeQuery(sql);
			while(rs.next()) {		
				String maDonNhap = rs.getString("madn");
				String maNhanVien = rs.getString("manv");
				String maNhaCungCap = rs.getString("mancc");
				Double tongTien = rs.getDouble("tongtien");
				Date ngayNhap = rs.getDate("ngaynhap");
				
				DTO_DonNhap donNhap = new DTO_DonNhap(maDonNhap, maNhanVien, maNhaCungCap, tongTien, ngayNhap);
				listDonNhap_Ma.add(donNhap);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listDonNhap_Ma;
	}
	
	public static ArrayList<DTO_DonNhap> selectDonNhap_MaNCC(String mancc) {
		openData();
		ArrayList<DTO_DonNhap> listDonNhap_Ma = new ArrayList<DTO_DonNhap>();
		openData();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String sql = "select * from donnhap where mancc LIKE '%"+mancc+"%'";
			ResultSet rs  = stmt.executeQuery(sql);
			while(rs.next()) {		
				String maDonNhap = rs.getString("madn");
				String maNhanVien = rs.getString("manv");
				String maNhaCungCap = rs.getString("mancc");
				Double tongTien = rs.getDouble("tongtien");
				Date ngayNhap = rs.getDate("ngaynhap");
				
				DTO_DonNhap donNhap = new DTO_DonNhap(maDonNhap, maNhanVien, maNhaCungCap, tongTien, ngayNhap);
				listDonNhap_Ma.add(donNhap);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listDonNhap_Ma;
	}
	
	public static ArrayList<DTO_DonNhap> selectDonNhap_Ngay(String ngayBatDau, String ngayKetThuc) {
		openData();
		ArrayList<DTO_DonNhap> listDonNhap_Ngay = new ArrayList<DTO_DonNhap>();
		openData();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String sql = "select * from donnhap where ngaynhap >= '"+ngayBatDau+"' AND ngaynhap <= '"+ngayKetThuc+"'";
			ResultSet rs  = stmt.executeQuery(sql);
			while(rs.next()) {		
				String maDonNhap = rs.getString("madn");
				String maNhanVien = rs.getString("manv");
				String maNhaCungCap = rs.getString("mancc");
				Double tongTien = rs.getDouble("tongtien");
				Date ngayNhap = rs.getDate("ngaynhap");
				
				DTO_DonNhap donNhap = new DTO_DonNhap(maDonNhap, maNhanVien, maNhaCungCap, tongTien, ngayNhap);
				listDonNhap_Ngay.add(donNhap);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listDonNhap_Ngay;
	}

}
