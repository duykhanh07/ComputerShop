package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import DTO.DTO_NhanVien;
import DTO.DTO_TaiKhoan;

public class DAO_TaiKhoan {
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
	
	
	public static ArrayList<DTO_TaiKhoan> selectAllTaiKhoan() {
		ArrayList<DTO_TaiKhoan> ds_taikhoan = new ArrayList<DTO_TaiKhoan>();
		openData();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String sql = "select * from taikhoan where taikhoan.MANV not like 'AD%'";
			ResultSet rs  = stmt.executeQuery(sql);
			while (rs.next()) {
				DTO_TaiKhoan taikhoan = new DTO_TaiKhoan(rs.getString("matk"), rs.getString("manv"),
						rs.getString("username"), rs.getString("password"), rs.getInt("tinhtrang"));
				ds_taikhoan.add(taikhoan);
			}
			conn.close();
			return ds_taikhoan;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static int themTK(DTO_TaiKhoan tk) {
		openData();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String sql = "insert into TaiKhoan Values " + tk.insertString();
			int ketqua = stmt.executeUpdate(sql);
			conn.close();
			return ketqua;
		} catch (Exception e) {
			System.out.println(e);
			
		}
		return 0;
	}

	public static int suaTK(DTO_TaiKhoan tk) {
		openData();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String sql = String.format("Update TaiKhoan set manv =N'%s', username=N'%s', password=N'%s', tinhtrang='%d' where matk = '%s' ", tk.getManv(), tk.getUsername(),tk.getPassword(), tk.getTinhtrang(), tk.getMatk());
			int ketqua = stmt.executeUpdate(sql);
			conn.close();
			return ketqua;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	public static String[] layMaNhanVienKoTK() {
		String[] ds_ma = {};
		
		try {
			openData();
			Statement stmt = conn.createStatement();
			String sql = "Select distinct nv.manv from NhanVien as nv left join TaiKhoan as tk on nv.manv = tk.manv where tk.matk is null";
			ResultSet rss = stmt.executeQuery(sql);
			
			while(rss.next()) {
				String manv = rss.getString("manv");
				ds_ma = Arrays.copyOf(ds_ma, ds_ma.length + 1);
				ds_ma[ds_ma.length - 1] = manv;
			}
			return ds_ma;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
