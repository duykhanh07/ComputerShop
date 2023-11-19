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
import DTO.DTO_DonNhap;

public class DAO_ThemDonNhap {
	
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
	
	public static ArrayList<String> selectTenSanPham(String masp) {
		openData();
		ArrayList<String> tenSanPham = new ArrayList<String>();
		openData();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String sql = "select tensp from sanpham where masp='"+masp+"'";
			ResultSet rs  = stmt.executeQuery(sql);
			while(rs.next()) {		
				String TenSanPham = rs.getString("tensp");
				tenSanPham.add(TenSanPham);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tenSanPham;
	}
	//Truy xuất mã sản phẩm
	public static ArrayList<String> selectMaSanPham() {
		openData();
		ArrayList<String> listMaSanPham = new ArrayList<String>();
		openData();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String sql = "select masp from sanpham";
			ResultSet rs  = stmt.executeQuery(sql);
			while(rs.next()) {		
				String maSanPham = rs.getString("masp");
				listMaSanPham.add(maSanPham);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listMaSanPham;
	}
	
	//Truy xuất mã nhà cung cấp
	public static ArrayList<String> selectMaNhaCungCap() {
		openData();
		ArrayList<String> listMaNhaCungCap = new ArrayList<String>();
		openData();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String sql = "select mancc from nhacungcap";
			ResultSet rs  = stmt.executeQuery(sql);
			while(rs.next()) {		
				String maNhaCungCap = rs.getString("mancc");
				listMaNhaCungCap.add(maNhaCungCap);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listMaNhaCungCap;
	}
	
	//Thêm đơn nhập hàng 
	public int insertDonNhap(DTO_DonNhap donNhap) {
		openData();
		int ketqua = 0;
		openData();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String sql = "INSERT INTO donnhap(madn,manv,mancc,tongtien,ngaynhap)"
			+"VALUES('"+donNhap.getMadn()+"','"+donNhap.getManv()+"','"+donNhap.getMancc()+"','"+donNhap.getTongtien()+"','"+donNhap.getNgaynhap()+"')";
			ketqua = stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketqua;
	}
	//Thêm chi tiết đơn nhập
	public int insertChiTietDonNhap(DTO_CTDonNhap chiTietDonNhap) {
		openData();
		int ketqua = 0;
		openData();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String sql = "INSERT INTO ctdn(masp,madn,dongia,solg)"
			+"VALUES('"+chiTietDonNhap.getMasp()+"','"+chiTietDonNhap.getMadn()+"','"+chiTietDonNhap.getDongia()+"','"+chiTietDonNhap.getSolg()+"')";
			ketqua = stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketqua;
	}
}
