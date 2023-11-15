package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import DTO.DTO_NhanVien;

public class DAO_NhanVien {
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

	public static ArrayList<DTO_NhanVien> selectAllNhanVien() {
		ArrayList<DTO_NhanVien> ds_nhanvien = new ArrayList<DTO_NhanVien>();
		openData();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String sql = "select * from nhanvien";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				DTO_NhanVien nhanvien = new DTO_NhanVien(rs.getString("manv"), rs.getString("tennv"),
						rs.getString("sdt"), rs.getString("email"), rs.getString("diachi"), rs.getString("chucvu"));
			}
			conn.close();
			return ds_nhanvien;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static int themNV(DTO_NhanVien nv) {
		openData();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String sql = "insert into Nhanvien Values" + nv.insertString();
			int ketqua = stmt.executeUpdate(sql);
			conn.close();
			return ketqua;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	public static int suaNV(String manv, String tennv) {
		openData();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String sql = "update Nhanvien set tennv= '"+ tennv +"' where manv = '"+manv+"'";
			int ketqua = stmt.executeUpdate(sql);
			conn.close();
			return ketqua;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
}
