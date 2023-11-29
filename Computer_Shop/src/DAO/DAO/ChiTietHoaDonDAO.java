package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import DTO.DTO_CTHoaDon;
import DTO.DTO_HoaDon;

public class ChiTietHoaDonDAO extends DAO_Connection{

private static Connection connn;
public static int SLhd;

	public ChiTietHoaDonDAO() {
		conn = Connect_mySQL();
	}

	// Lấy tất cả chi tiết hóa đơn có trong database
	public ResultSet get_AllChiTietHoaDon(String mahd) {
		String sql = "select cthd.*,sp.tensp from cthd join sanpham as sp on sp.masp = cthd.masp where mahd = '"+mahd+"'";
		ArrayList<DTO_CTHoaDon> arr = new ArrayList<DTO_CTHoaDon>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void openData() {
		try {
			DriverManager.registerDriver(new SQLServerDriver());
			String uri = "jdbc:mySQL://localhost:3306/quanlycuahang";
			String user = "root";
			String password = "";
			
			connn = DriverManager.getConnection(uri, user, password);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static int KhoHD(String masp) {
	    openData();
	    SLhd = 0;

	    try {
	        Statement stmt = (Statement) connn.createStatement();
	        String sql = "SELECT solg FROM cthd WHERE masp = '" + masp + "'";
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        while (rs.next()) {
	            int solg = rs.getInt("solg");
	            SLhd += solg;
	        }
	        
	        connn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return SLhd;
	}

}
