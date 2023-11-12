package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


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
		String sql = "SELECT * FROM sanpham WHERE tinhtrang=1";
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
}
