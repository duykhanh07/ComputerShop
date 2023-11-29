package BUS.QuanLyBanHang;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import BUS.HoaDonBUS;
import DAO.ChiTietHoaDonDAO;
import DAO.DAO_ChiTietDonNhap;
import DTO.DTO_HoaDon;
import GUI.QuanLyBanHang.AddToCart;
import GUI.QuanLyBanHang.CartItem;
import GUI.QuanLyBanHang.ProductItem;

public class AddToCartBUS {
	
	//Nút backspace
	
	//Nếu nút AddCart true toàn bộ thì lấy giá trị qua đây
		public static boolean submit;
	
	public static void SetUpButtonBackspace()
	{
		String currentText = GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.getText();
			  if (currentText.length() > 0) {
			 // Xóa ký tự cuối cùng
				  GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.setText(currentText.substring(0, currentText.length() - 1));
			        }		
	}
	
	//Nút tăng số lượng (phần Bán hàng)
	public static void SetUpButtonIncrease()
	{
		try {
			String a = GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.getText(); 
			int SL= Integer.parseInt(a);
			SL = SL+1;
			GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.setText(Integer.toString(SL));
			}
		catch (Exception E){
			JOptionPane.showMessageDialog(null, "Unacceptable value");
			}
			
	}
	
	//Nút giảm số lượng
	public static void SetUpButtonDecrease()
	{
		try {
		String a = GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.getText(); 
					 int SL= Integer.parseInt(a);
					 if(SL > 1)
					 {
						 SL = SL-1;	
		GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.setText(Integer.toString(SL));
					 }
					 else
					 {
						JOptionPane.showMessageDialog(null, "Số lượng hàng không được nhỏ hơn 1");
					 }
				}
				catch (Exception E){
					JOptionPane.showMessageDialog(null, "Unacceptable value");
				}		
	}
	
	//Nút 0
	public static void Number0()
	{
			String a = GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.getText(); 
			String SL = "0";	
			GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.setText(a+SL);		
	}

	//Nút 1
		public static void Number1()
		{
				String a = GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.getText(); 
				String SL = "1";	
				GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.setText(a+SL);		
		}
		
		//Nút 2
		public static void Number2()
		{
				String a = GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.getText(); 
				String SL = "2";	
				GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.setText(a+SL);		
		}
		
		//Nút 3
		public static void Number3()
		{
				String a = GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.getText(); 
				String SL = "3";	
				GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.setText(a+SL);		
		}
		
		//Nút 4
		public static void Number4()
		{
				String a = GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.getText(); 
				String SL = "4";	
				GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.setText(a+SL);		
		}
		
		//Nút 5
		public static void Number5()
		{
				String a = GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.getText(); 
				String SL = "5";	
				GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.setText(a+SL);		
		}
		
		//Nút 6
		public static void Number6()
		{
				String a = GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.getText(); 
				String SL = "6";	
				GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.setText(a+SL);		
		}
		
		//Nút 7
		public static void Number7()
		{
				String a = GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.getText(); 
				String SL = "7";	
				GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.setText(a+SL);		
		}
		
		//Nút 8
		public static void Number8()
		{
				String a = GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.getText(); 
				String SL = "8";	
				GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.setText(a+SL);		
		}
		
		//Nút 9
		public static void Number9()
		{
				String a = GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.getText(); 
				String SL = "9";	
				GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.setText(a+SL);		
		}
	
	//Nút thêm vào giỏ hàng
		public static void AddToCartButton() {
		    int b = 0;
		    boolean validInput = false;
		    boolean exitLoop = false;

		    while (!validInput && !exitLoop) {
		        try {
		            String a = GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.getText();

		            // Kiểm tra nếu chuỗi rỗng
		            if (!a.isEmpty()) {
		                b = Integer.parseInt(a);

		                if (b > 0) {
		                    if (b <= 10) {
		                    	//Kiểm tra tồn kho
		                    	int soLuongTrongKho = DAO_ChiTietDonNhap.Kho(CartItemBUS.getMa());
		                    	int soLuongTrongHoaDon = ChiTietHoaDonDAO.KhoHD(CartItemBUS.getMa());

		                    	if (b <= (soLuongTrongKho - soLuongTrongHoaDon)) {
		                    	    submit = true;
		                    	    validInput = true;
		                    	    BUS.QuanLyBanHang.CartItemBUS.cartTable();
		                    	    JOptionPane.showMessageDialog(null, "Thêm vào giỏ hàng thành công");
		                    	} else {
		                    	    JOptionPane.showMessageDialog(null, "Hàng loại này chỉ còn trong kho là: " +
		                    	            String.valueOf(soLuongTrongKho - soLuongTrongHoaDon));
		                    	    GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.setText("1");
		                    	    exitLoop = true;
		                    	}
		                        
		                    } else {
		                        JOptionPane.showMessageDialog(null, "Để tránh tình trạng đầu cơ trục lợi ảnh hưởng tới thị trường. \n Vui lòng đặt tối đa 10 sản phẩm.");
		                        GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.setText("1");
		                        exitLoop = true;
		                    }
		                } else {
		                    JOptionPane.showMessageDialog(null, "Lỗi: Bạn cần nhập vào số nguyên dương");
		                    GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.setText("1");
		                    exitLoop = true;
		                }
		            } else {
		                JOptionPane.showMessageDialog(null, "Lỗi: Bạn cần nhập vào số nguyên dương");
		                GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.setText("1");
		                exitLoop = true;
		            }
		        } catch (NumberFormatException e) {
		            JOptionPane.showMessageDialog(null, "Lỗi: Bạn cần nhập vào số nguyên dương");
		            GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.setText("1");
		            exitLoop = true;
		        }
		    }
		}

		//SetUp GUI data AddToCart
	public static void SetUpAddToCart() {
	    ArrayList<ProductItem> productItems = ProductItemBUS.getProductItems();

            for (int i = 0 ; i < productItems.size() ; i++) {
            	ProductItem pi = productItems.get(i);
            	if (pi.getTenSanPham().toLowerCase().contains(GUI.QuanLyBanHang.QuanLyBanHangFrm.timKiemTonKhoTxt.getText().toLowerCase()))
            	{
            		String image = pi.getTenAnh();
            	image = ProductItemBUS.changeFileExtension(image, "jpg"); //đuôi jpg
                String tensp1 = pi.getTenSanPham();
                double gia = pi.getTenGia();

                // Tạo mới AddToCart và gán dữ liệu
                AddToCart gh = new AddToCart();
                 gh.setAnh1(image);
                 gh.setTenSanPham1(tensp1);
                 gh.setTenGia1(gia*Double.parseDouble(GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.getText()));
                 gh.setVisible(true);
                 
               
            	}
             
            }
	}
	

}




