package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itextpdf.text.pdf.PdfPTable;

public class DAO_PrintHoaDon {
	public static PdfPTable table;
    public static String mahd;
    public static String masp;
    public static String tensp;
    public static String dongia;
    public static String soluong;
    public static double thanhtien;

    public static String manv;
    public static String tenkh;
    public static String diachi;
    public static String date;
    public static double tongcong;
	
	public void GetData(String mahd)
	{
		
		String sql = "SELECT * FROM hoadon JOIN cthd ON hoadon.mahd = cthd.mahd JOIN sanpham ON cthd.masp = sanpham.masp"
	            + " WHERE hoadon.mahd = '" + mahd + "'";
	
    // Kết nối đến cơ sở dữ liệu
    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlycuahang", "root", "");
         // Assuming the cartItemPanel is needed for initialization
         PreparedStatement statement = connection.prepareStatement(sql)) {

        // Thực hiện truy vấn SELECT
        ResultSet resultSet = statement.executeQuery();

        // Lưu dữ liệu vào ArrayList<ProductItem>
        while (resultSet.next()) {
        	// mahd;
        	 masp = resultSet.getString("masp");
        	 tensp = resultSet.getString("tensp");
        	 dongia = resultSet.getString("dongia");
        	 soluong = resultSet.getString("solg");
        	 thanhtien = resultSet.getDouble("thanhtien");

        	 manv = resultSet.getString("manv");
        	 tenkh = resultSet.getString("tenkh");
        	 diachi = resultSet.getString("diachi");
        	 date = resultSet.getString("date");
        	 tongcong = resultSet.getDouble("tongcong");
        	    
        	
          
        }

        // Đóng các tài nguyên
        resultSet.close();
        statement.close();
        connection.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
