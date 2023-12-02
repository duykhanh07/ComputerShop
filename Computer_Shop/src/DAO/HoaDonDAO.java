package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.DTO_HoaDon;
import DTO.DTO_NhaCungCap;

public class HoaDonDAO extends DAO_Connection {

	public HoaDonDAO() {
		conn = Connect_mySQL();
	}

	// Lấy tất cả hóa đơn có trong database
	public ArrayList<DTO_HoaDon> get_AllHoaDon() {
		String sql = "select * from hoadon";
		ArrayList<DTO_HoaDon> arr = new ArrayList<DTO_HoaDon>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				DTO_HoaDon hoadon = new DTO_HoaDon(rs.getString("mahd"), rs.getString("makh"),
						rs.getString("manv"), new Date((rs.getTimestamp("ngaylaphd").getTime())), rs.getString("diachigiao"), Double.parseDouble(rs.getString("tongtien")), rs.getString("trangthai"));
				arr.add(hoadon);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	//Cập nhật trạng thái hóa đơn trong Database
	public int update_TrangThaiHoaDon(DTO_HoaDon hoadon)
	{
		String sql = "update hoadon set trangthai = ? where mahd = '" + hoadon.getMahd() + "'";
		int rs = -1;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, hoadon.getTrangthai());
			rs = stmt.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
}