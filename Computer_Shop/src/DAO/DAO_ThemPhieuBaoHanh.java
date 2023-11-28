package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import DTO.DTO_CTDonNhap;
import DTO.DTO_CTHoaDon;
import DTO.DTO_CTPhieuBaoHanh;
import DTO.DTO_PhieuBaoHanh;

public class DAO_ThemPhieuBaoHanh {
	
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
	
	public static ArrayList<DTO_PhieuBaoHanh> selectAllBaoHanh() {
		openData();
		ArrayList<DTO_PhieuBaoHanh> listPhieuBaoHanh = new ArrayList<DTO_PhieuBaoHanh>();
		openData();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String sql = "SELECT * FROM baohanh";
			ResultSet rs  = stmt.executeQuery(sql);
			while(rs.next()) {		
				String maHoaDon = rs.getString("mapbh");
				Date ngayNhan = rs.getDate("ngaynhan");
				Date ngayTra = rs.getDate("ngaytra");
				String maNhanVien = rs.getString("manv");
				
				DTO_PhieuBaoHanh chitiet = new DTO_PhieuBaoHanh(maHoaDon, ngayNhan, ngayTra, maNhanVien);
				listPhieuBaoHanh.add(chitiet);	
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPhieuBaoHanh;
		
	}
	//Lấy hóa đơn cần bảo hành
	public static ArrayList<DTO_CTHoaDon> selectHoaDonCanBHAll() {
		openData();
		ArrayList<DTO_CTHoaDon> listChiTietHoaDon = new ArrayList<DTO_CTHoaDon>();
		openData();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String sql = "SELECT hd.mahd, sp.masp, DATE_ADD(hd.ngaylaphd,INTERVAL 1 YEAR) as hanbh\r\n"
					+ "FROM sanpham AS sp JOIN cthd ON sp.masp = cthd.masp\r\n"
					+ "JOIN hoadon AS hd ON cthd.mahd = hd.mahd";
			ResultSet rs  = stmt.executeQuery(sql);
			while(rs.next()) {		
				String maHoaDon = rs.getString("mahd");
				String maSanPham = rs.getString("masp");
				Date ngayHetHan = rs.getDate("hanbh");
				
				DTO_CTHoaDon chitiet = new DTO_CTHoaDon(maHoaDon, maSanPham, ngayHetHan);
				listChiTietHoaDon.add(chitiet);	
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listChiTietHoaDon;
	}
	
	public static ArrayList<DTO_CTHoaDon> selectCTHD_MaHD(String mahd) {
		openData();
		ArrayList<DTO_CTHoaDon> listChiTietHoaDon = new ArrayList<DTO_CTHoaDon>();
		openData();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String sql = "SELECT hd.mahd, sp.masp, DATE_ADD(hd.ngaylaphd,INTERVAL 1 YEAR) as hanbh\r\n"
					+ "FROM sanpham AS sp JOIN cthd ON sp.masp = cthd.masp\r\n"
					+ "JOIN hoadon AS hd ON cthd.mahd = hd.mahd\r\n"
					+ "WHERE hd.mahd LIKE '%"+mahd+"%'";
			ResultSet rs  = stmt.executeQuery(sql);
			while(rs.next()) {		
				String maHoaDon = rs.getString("mahd");
				String maSanPham = rs.getString("masp");
				Date ngayHetHan = rs.getDate("hanbh");
				
				DTO_CTHoaDon chitiet = new DTO_CTHoaDon(maHoaDon, maSanPham, ngayHetHan);
				listChiTietHoaDon.add(chitiet);	
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listChiTietHoaDon;
	}
	
	public static ArrayList<DTO_CTHoaDon> selectCTHD_MaSP(String masp) {
		openData();
		ArrayList<DTO_CTHoaDon> listChiTietHoaDon = new ArrayList<DTO_CTHoaDon>();
		openData();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String sql = "SELECT hd.mahd, sp.masp, DATE_ADD(hd.ngaylaphd,INTERVAL 1 YEAR) as hanbh\r\n"
					+ "FROM sanpham AS sp JOIN cthd ON sp.masp = cthd.masp\r\n"
					+ "JOIN hoadon AS hd ON cthd.mahd = hd.mahd\r\n"
					+ "WHERE sp.masp LIKE '%"+masp+"%'";
			ResultSet rs  = stmt.executeQuery(sql);
			while(rs.next()) {		
				String maHoaDon = rs.getString("mahd");
				String maSanPham = rs.getString("masp");
				Date ngayHetHan = rs.getDate("hanbh");
				
				DTO_CTHoaDon chitiet = new DTO_CTHoaDon(maHoaDon, maSanPham, ngayHetHan);
				listChiTietHoaDon.add(chitiet);	
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listChiTietHoaDon;
	}
	
	public int insertChiTietBaoHanh(DTO_CTPhieuBaoHanh chiTietBaoHanh) {
		openData();
		int ketqua = 0;
		openData();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String sql = "INSERT INTO ctbh(mapbh,masp,mahd,loi,giaiquyet)"
			+"VALUES('"+chiTietBaoHanh.getMapbh()+"','"+chiTietBaoHanh.getMasp()+"','"+chiTietBaoHanh.getMahd()+"','"+chiTietBaoHanh.getLoi()+"','"+chiTietBaoHanh.getGiaiquyet()+"')";
			ketqua = stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketqua;
	}
	public int insertBaoHanh(DTO_PhieuBaoHanh phieuBaoHanh) {
		openData();
		int ketqua = 0;
		openData();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String sql = "INSERT INTO baohanh(mapbh,ngaynhan,ngaytra,manv)"
			+"VALUES('"+phieuBaoHanh.getMapbh()+"','"+phieuBaoHanh.getNgaynhan()+"','"+phieuBaoHanh.getNgaytra()+"','"+phieuBaoHanh.getManv()+"')";
			ketqua = stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketqua;
	}
	
}
