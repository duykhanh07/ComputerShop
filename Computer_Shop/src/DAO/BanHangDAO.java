package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import DTO.DTO_CTHoaDon;
import DTO.DTO_HoaDon;
import DTO.DTO_KhachHang;
import DTO.DTO_SanPham;

public class BanHangDAO {
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
	// lấy danh sách sản phẩm
	public ArrayList<DTO_SanPham> layCacSanPham(){
		ArrayList<DTO_SanPham> ds_sp = new ArrayList<DTO_SanPham>();
		try {
			Connection con = getConnection();
			Statement sta = con.createStatement();
			String query = "Select * from SanPham";
			ResultSet rss = sta.executeQuery(query);
			while(rss.next()) {
				String masp = rss.getString("masp");
				String tensp = rss.getString("tensp");
				String image = rss.getString("image");
				String cpu = rss.getString("cpu");
				String ram = rss.getString("ram");
				String rom = rss.getString("rom");
				String card = rss.getString("card");
				String manhinh = rss.getString("manhinh");
				String pin = rss.getString("pin");
				String hang = rss.getString("hang");
				int gia = rss.getInt("gia");
				int tinhtrang = rss.getInt("tinhtrang");	
				
				DTO_SanPham sanpham = new DTO_SanPham(masp, tensp, image, cpu, ram, rom, card,
						manhinh, pin, hang, gia, tinhtrang);
				ds_sp.add(sanpham);	
			}
			con.close();
			return ds_sp;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	// lấy số lượng tồn
	public HashMap<String, Integer> layTonKho(){
		HashMap<String, Integer> ds_ton = new HashMap<String,Integer>();
		try {
			Connection c = getConnection();
			String sql = "select distinct sp.masp,coalesce(dsn.soluong - dsx.soluong, 0) as tonkho\r\n"
					+ "from\r\n"
					+ "( select masp, sum(solg) as soluong\r\n"
					+ "from ctdn\r\n"
					+ "group by masp) as dsn\r\n"
					+ "join\r\n"
					+ "( select masp, sum(solg) as soluong\r\n"
					+ "from cthd\r\n"
					+ "group by masp) as dsx\r\n"
					+ "on dsn.masp = dsx.masp\r\n"
					+ "right join Sanpham as sp on sp.masp = dsx.masp";
			Statement st = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				ds_ton.put(rs.getString("masp"), rs.getInt("tonkho"));
			}
			
			c.close();
			return ds_ton;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<DTO_KhachHang> layKhachHang(){
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
	public int congDiemTichLuy(String makh, int diem) {
		try {
			Connection conn = getConnection();
			String query = "Update KHACHHANG"
					+ " set "
					+ " diem = ?"
					+ " where makh = ?";
			PreparedStatement pre_sta = conn.prepareStatement(query);
			pre_sta.setInt(1, diem);
			pre_sta.setString(2, makh);
			int kq = pre_sta.executeUpdate();
			conn.close();
			return kq;
		}catch (Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	public int themKhachHang(DTO_KhachHang kh) {
		try {
			Connection conn = getConnection();
			String query = "insert into KHACHHANG values(?,?,?,?)";
			PreparedStatement pre_sta = conn.prepareStatement(query);
			pre_sta.setString(1, kh.getMakh());
			pre_sta.setString(2, kh.getTenkh());
			pre_sta.setString(3, kh.getSdt());
			pre_sta.setInt(4, 0);
			int kq = pre_sta.executeUpdate();
			conn.close();
			return kq;
		}catch (Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	public int taoSTT_HoaDon() {
		int stt = 1;
		try {
			Connection conn = getConnection();
			Statement sta = conn.createStatement();
			String query = "SELECT COUNT(hoadon.mahd) AS stt\r\n"
					+ "FROM hoadon";
			ResultSet rss = sta.executeQuery(query);
			while(rss.next()) {
				stt += rss.getInt("stt");
			}
			conn.close();
			return stt; 
		} catch (SQLException e) {
			System.out.println(e);
		}	
		return -1;
	}
	public void themHoaDon(String mahd, String makh, String manv,String diaChi, Long tongtien, String trangThai) {
		try {
			Connection conn = getConnection();
			String query = "insert into HOADON values(?,?,?,?,?,?,?)";
			PreparedStatement pre_sta = conn.prepareStatement(query);
			pre_sta.setString(1, mahd);
			pre_sta.setString(2, makh);
			pre_sta.setString(3, manv);
			pre_sta.setDate(4, new Date(System.currentTimeMillis()));
			pre_sta.setString(5, diaChi);
			pre_sta.setLong(6, tongtien);
			pre_sta.setString(7, trangThai);
			pre_sta.executeUpdate();
			conn.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public void themCtHoaDon(String mahd, String masp,int dongia, int soluong) {
		try {
			Connection conn = getConnection();
			String query = "insert into cthd values(?,?,?,?)";
			PreparedStatement pre_sta = conn.prepareStatement(query);
			pre_sta.setString(1, masp);
			pre_sta.setString(2, mahd);
			pre_sta.setInt(3, dongia);
			pre_sta.setInt(4, soluong);
			pre_sta.executeUpdate();
			conn.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public DTO_HoaDon layHoaDon(String mahd) {
		try {
			DTO_HoaDon hd = null;
			Connection conn = getConnection();
			Statement sta = conn.createStatement();
			String query = "SELECT * from HoaDon where mahd ='"+mahd+"'";
			ResultSet rss = sta.executeQuery(query);
			while(rss.next()) {
				int trangthai = 0;
				hd = new DTO_HoaDon(mahd, rss.getString("makh"), rss.getString("manv"), rss.getDate("ngaylaphd"), rss.getString("diachigiao"), rss.getDouble("tongtien"),rss.getString("trangthai"));
				break;
			}
			conn.close();
			return hd; 
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	
	public ResultSet layChiTiet1HoaDon(String mahd){
		try {
			Connection conn = getConnection();
			Statement sta = conn.createStatement();
			String query = "SELECT cth.*, sp.tensp from cthd as cth join sanpham as sp on cth.masp = sp.masp where cth.mahd ='"+mahd+"'";
			ResultSet rss = sta.executeQuery(query);
			return rss;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
}
