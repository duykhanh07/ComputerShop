package BUS.QuanLyBanHang;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import DAO.LoginDAO;
import GUI.QuanLyBanHang.CartItem;

public class ThanhToan {
	public static void XacNhan() {
	    //có sửa pubic MYTextField của LoginForm
	   
	        String ma = TaoMaHD();
	        addHD(ma);

	        // String mahd, String masp, Double dongia, int solg
	        for (int i = 0; i < BUS.QuanLyBanHang.CartItemBUS.cart.size(); i++) {
	            Cart ct = BUS.QuanLyBanHang.CartItemBUS.cart.get(i);
	            addCTHD(ct.masp, ma, ct.dongia, ct.soluong);
	        }
	    
	}


    private static String generateNextString(String currentValue) {
        // Sử dụng regex để tìm phần số trong chuỗi
        Pattern pattern = Pattern.compile("(\\d+)$");
        Matcher matcher = pattern.matcher(currentValue);

        // Nếu tìm thấy số cuối cùng trong chuỗi
        if (matcher.find()) {
            String numberPart = matcher.group(); // Lấy số từ chuỗi
            int currentNumber = Integer.parseInt(numberPart);

            // Tăng giá trị số lên 1
            int nextNumber = currentNumber + 1;

            // Tạo chuỗi mới bằng cách thay thế số mới vào chuỗi cũ
            String nextValue = currentValue.replaceAll(numberPart, String.format("%04d", nextNumber));

            return nextValue;
        } else {
            // Trường hợp không tìm thấy số cuối cùng, có thể xử lý tùy theo yêu cầu
            return currentValue; // hoặc có thể trả về null hoặc chuỗi mặc định khác
        }
    }
    
    //Tạo mã hóa đơn
    public static String TaoMaHD ()
    {
    	String mahd = "";
    	String sqlQuery1 = "SELECT mahd FROM hoadon " +
    	                   "ORDER BY mahd DESC " +
    	                   "LIMIT 1";

    	try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlycuahang", "root", "");
    	     Statement statement = connection.createStatement()) {

    	    ResultSet resultSet = statement.executeQuery(sqlQuery1);

    	    // Retrieving data from the database
    	    while (resultSet.next()) {
    	        mahd = resultSet.getString("mahd");
    	    }

    	    resultSet.close();
    	    statement.close();
    	    connection.close();
    	} catch (SQLException e) {
    	    e.printStackTrace();
    	}

        
        
    	 // Giả sử bạn có một giá trị từ cột cơ sở dữ liệu
        String currentValueFromDatabase = mahd;

        // Gọi hàm để tạo chuỗi mới
        String nextValue = generateNextString(currentValueFromDatabase);

		return nextValue;
    }
    
    public static String GetMaNhanVien(String username)
    {
    	String manv = "";	
    	String sqlQuery1 = "SELECT manv FROM taikhoan WHERE username LIKE ?";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlycuahang", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery1)) {

            preparedStatement.setString(1, ""+username+""); // Fix the parameter index here
            ResultSet resultSet = preparedStatement.executeQuery();

            // Retrieving data from the database
            while (resultSet.next()) {
                manv = resultSet.getString("manv");
              
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manv;
    	
    }
    
    //Ngap lap HD
    public static String Datetime () {
        // Lấy ngày giờ hiện tại
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Định dạng ngày giờ theo mẫu mong muốn
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        // In ngày giờ hiện tại
        return formattedDateTime;
    }
    
   public static void addHD(String ma)
   {
	   String mahd = ma;
	   String manv = GUI.MainForm.manv;
	   String makh = BUS.QuanLyBanHang.CartItemBUS.makh;
	   String ngaylaphd = Datetime();
	   String diachigiao = GUI.QuanLyBanHang.QuanLyBanHangFrm.diaChiTxt.getText();
       double tongtien = CartItemBUS.TongCong();
       String trangthai ="";

       if (GUI.QuanLyBanHang.QuanLyBanHangFrm.giaoHangChck.isSelected())
       {
    	   trangthai = "chưa giao hàng";
       }
       else
       {
    	   GUI.QuanLyBanHang.QuanLyBanHangFrm.diaChiTxt.setText("");
    	   diachigiao = "";
    	   trangthai = "đã thanh toán";
       }
       
       if (!GUI.QuanLyBanHang.QuanLyBanHangFrm.giaoHangChck.isSelected())
       {
       	diachigiao = "Mua tại cửa hàng";
       	GUI.QuanLyBanHang.QuanLyBanHangFrm.diaChiTxt.setText("");
       }
       else
       {
          diachigiao = GUI.QuanLyBanHang.QuanLyBanHangFrm.diaChiTxt.getText();
       }
       
       // Câu truy vấn SQL chèn dữ liệu
       String sqlInsert = "INSERT INTO hoadon (mahd, manv, makh, ngaylaphd, diachigiao, tongtien, trangthai)"
       		+ " VALUES (?, ?, ?, ?, ?, ?, ? )";


       try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlycuahang", "root", "");
               PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert)) {

           // Thiết lập giá trị cho các tham số trong câu truy vấn
    	   preparedStatement.setString(1, mahd);
    	   preparedStatement.setString(2, manv);
    	   preparedStatement.setString(3, makh);
    	   preparedStatement.setString(4, ngaylaphd);
    	   preparedStatement.setString(5, diachigiao);
    	   preparedStatement.setDouble(6, tongtien);
    	   preparedStatement.setString(7, trangthai);

           // Thực hiện câu truy vấn chèn
           int affectedRows = preparedStatement.executeUpdate();

           if (affectedRows > 0) {
               JOptionPane.showMessageDialog(null, "Xác nhận đã ghi hóa đơn.");
           } else {
               JOptionPane.showMessageDialog(null, "Ghi hóa đơn thất bại!");
           }

       } catch (SQLException e) {
           e.printStackTrace();
       }
   
   }

   
   public static void addCTHD(String masp, String ma, Double dongia, int solg)
   {
	   String mahd = ma;
	   
       // Câu truy vấn SQL chèn dữ liệu
	   String sqlInsert = "INSERT INTO cthd (masp, mahd, dongia, solg) "
	   		+ "VALUES (?, ?, ?, ?)";


       try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlycuahang", "root", "");
               PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert)) {

           // Thiết lập giá trị cho các tham số trong câu truy vấn
           preparedStatement.setString(1, masp);
           preparedStatement.setString(2, mahd);
           preparedStatement.setDouble(3, dongia);
           preparedStatement.setInt(4, solg);



           // Thực hiện câu truy vấn chèn
           int affectedRows = preparedStatement.executeUpdate();

           if (affectedRows > 0) {
               JOptionPane.showMessageDialog(null, "Xác nhận đã ghi chi tiết hóa đơn.");
           } else {
               JOptionPane.showMessageDialog(null, "Ghi chi tiết hóa đơn thất bại!");
           }

       } catch (SQLException e) {
           e.printStackTrace();
       }
   
   }
   
   public static boolean checkCartItem() {
	    if (GUI.QuanLyBanHang.QuanLyBanHangFrm.teniKhachHangTxt.getText().equals("")) {
	        JOptionPane.showMessageDialog(null, "Không được để trống họ tên!");
	        return false;
	    }

	    if (BUS.QuanLyBanHang.CartItemBUS.cart.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Giỏ hàng trống!");
	        return false;
	    }

	    if (GUI.QuanLyBanHang.QuanLyBanHangFrm.giaoHangChck.isSelected() && GUI.QuanLyBanHang.QuanLyBanHangFrm.diaChiTxt.getText().equals("")) {
	        JOptionPane.showMessageDialog(null, "Nếu giao hàng tận nhà. \n Đề nghị nhập địa chỉ!");
	        return false;
	    }

	    return true;
	}

}
