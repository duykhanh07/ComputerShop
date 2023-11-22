package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.DTO_CTPhieuBaoHanh;
import DTO.DTO_PhieuBaoHanh;

public class DAO_PhieuBaoHanh {
	public static Connection getConnection() {
        Connection conn;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlycuahang", "root", "");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	public static List<Object[]> layDanhSachPhieuBaoHanh(){
		List<Object[]> danhSachPhieuBaoHanh = new ArrayList<>();
		try (Connection conn = DAO_PhieuBaoHanh.getConnection();
				PreparedStatement ps = conn.prepareStatement(
						"SELECT * FROM baohanh")){
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Object[] row = new Object[4];
				row[0] = rs.getString("mapbh");
				row[1] = rs.getDate("ngaynhan");
				row[2] = rs.getDate("ngaytra");
				row[3] = rs.getString("manv");
				
				danhSachPhieuBaoHanh.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return danhSachPhieuBaoHanh;
	}
	
	public static List<Object[]> layDanhSachPhieuBaoHanhTheoNgay(Date tuNgay, Date denNgay) {
        List<Object[]> danhSachPhieuBaoHanh = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT * FROM baohanh WHERE ngaynhan >= ? AND ngaytra <= ?")) {

            ps.setDate(1, new java.sql.Date(tuNgay.getTime()));
            ps.setDate(2, new java.sql.Date(denNgay.getTime()));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] row = new Object[4];
                row[0] = rs.getString("mapbh");
                row[1] = rs.getDate("ngaynhan"); // ngày nhận
                row[2] = rs.getDate("ngaytra"); // ngày trả
                row[3] = rs.getString("manv");

                danhSachPhieuBaoHanh.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachPhieuBaoHanh;
    }
	

}
