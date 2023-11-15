package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import DTO.DTO_SanPham;

public class SanPhamDAO {
	
	public Connection conn = null;
	
	public static SanPhamDAO getInstance() { 
		return new SanPhamDAO();
	}
	
	public Connection Connect_mySQL() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cuahangmaytinh", "root", "123456");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	public static void closeConnection(Connection c) {
		try {
		if (c!=null) 
			c.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<DTO_SanPham> selectAll() {
		ArrayList<DTO_SanPham> listSanPham = new ArrayList<DTO_SanPham>();
		
		Connection c = Connect_mySQL();
		String sql = "SELECT * FROM sanpham";
		try {
				Statement st = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = st.executeQuery(sql);
				
				while(rs.next()) {
					String masp = rs.getString("masp");
					String tensp = rs.getString("tensp");
					String image = rs.getString("image");
					String cpu = rs.getString("cpu");
					String ram = rs.getString("ram");
					String rom = rs.getString("rom");
					String card = rs.getString("card");
					String manhinh = rs.getString("manhinh");
					String pin = rs.getString("pin");
					String hang = rs.getString("hang");
					int gia = rs.getInt("gia");
					int tinhtrang = rs.getInt("tinhtrang");	
					
					DTO_SanPham sanpham = new DTO_SanPham(masp, tensp, image, cpu, ram, rom, card,
							manhinh, pin, hang, gia, tinhtrang);
					listSanPham.add(sanpham);
				}
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection(c);
		return listSanPham;
		
			
	}
	public ArrayList<String> getAllBrands() {
		ArrayList<String> listBrand = new ArrayList<String>();
		
		try {
			Connection c = Connect_mySQL();
			String sql = "SELECT distinct hang from sanpham";
			Statement st = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				listBrand.add(rs.getString("hang"));
			}
			
			closeConnection(c);
			return listBrand;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public HashMap<String, Integer> layTonKho(){
		HashMap<String, Integer> ds_ton = new HashMap<String,Integer>();
		try {
			Connection c = Connect_mySQL();
			String sql = "select sp.masp,(dsn.soluong - dsx.soluong) as tonkho\r\n"
					+ "from\r\n"
					+ "( select masp, sum(solg) as soluong\r\n"
					+ "from ctdn\r\n"
					+ "group by masp) as dsn\r\n"
					+ "join\r\n"
					+ "( select masp, sum(solg) as soluong\r\n"
					+ "from cthd\r\n"
					+ "group by masp) as dsx\r\n"
					+ "on dsn.masp = dsx.masp\r\n"
					+ "join Sanpham as sp on sp.masp = dsx.masp";
			Statement st = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				ds_ton.put(rs.getString("masp"), rs.getInt("tonkho"));
			}
			
			closeConnection(c);
			return ds_ton;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
