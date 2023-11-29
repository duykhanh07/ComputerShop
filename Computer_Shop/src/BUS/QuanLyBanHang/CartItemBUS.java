package BUS.QuanLyBanHang;

import java.awt.GridLayout;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import GUI.QuanLyBanHang.CartItem;
import GUI.QuanLyBanHang.ProductItem;


public class CartItemBUS {
	public static String masp;

	public static String tensp;
	public static double dongia;
	public static int soluong;
	public static double thanhtien;
	
	public static double totalSum;
	public static String makh;
	
	public static ArrayList<Cart> cart = new ArrayList<>();
	public static String getMa()
	{	    ArrayList<ProductItem> productItems = ProductItemBUS.getProductItems();

	    for (int i = 0; i < productItems.size(); i++) {
	        ProductItem pi = productItems.get(i);
	        if (pi.getTenSanPham().toLowerCase().contains(GUI.QuanLyBanHang.AddToCart.tenLaptopLbl.getText().toLowerCase())) {
	            masp = pi.getMaSanPham();
	            break; // Thoát khỏi vòng lặp khi tìm thấy mã sản phẩm
	        }
	    }
		return masp;
	}
	
	public static void cartTable()
	{
	masp = getMa();
	tensp = GUI.QuanLyBanHang.AddToCart.tenLaptopLbl.getText();
  	dongia =Double.parseDouble(GUI.QuanLyBanHang.AddToCart.tongTienPanel.getText());
  	soluong = Integer.parseInt(GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.getText());
     Cart ct = new Cart(BUS.QuanLyBanHang.CartItemBUS.masp,tensp,dongia,soluong);
     BUS.QuanLyBanHang.CartItemBUS.cart.add(ct);
	}
	 
	
	public static double TongCong()
	{
		totalSum = 0;
		for (Cart ct: cart)
		{
			double a = ct.getThanhtien();
			totalSum+=a;
		}
		return totalSum;
		
	}
	/*
	public static ArrayList<CartItem> cartItems = new ArrayList<>();

	public static ArrayList<CartItem> getCartItems() {

	    ArrayList<ProductItem> productItems = ProductItemBUS.getProductItems();

	    String masp = "";
	    boolean found = false;

	    for (int i = 0; i < productItems.size(); i++) {
	        ProductItem pi = productItems.get(i);
	        if (pi.getTenSanPham().toLowerCase().contains(GUI.QuanLyBanHang.AddToCart.tenLaptopLbl.getText().toLowerCase())) {
	            masp = pi.getMaSanPham();
	            break; // Thoát khỏi vòng lặp khi tìm thấy mã sản phẩm
	        }
	    }
	    if (cartItems != null && BUS.QuanLyBanHang.AddToCartBUS.submit) {
	        for (int i = 0; i < cartItems.size(); i++) {
	            CartItem gh = cartItems.get(i);

	            if (GUI.QuanLyBanHang.AddToCart.tenLaptopLbl.getText().toLowerCase().equalsIgnoreCase(gh.tenLaptopLbl.getText().toLowerCase())) {
	                found = true;
	                int SL = Integer.parseInt(GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.getText());
	                int SLcart = Integer.parseInt(gh.soLuongLbl.getText());
	                gh.soLuongLbl.setText(String.valueOf(SL + SLcart));

	                // Cập nhật giá tiền
	                int donGia = Integer.parseInt(GUI.QuanLyBanHang.AddToCart.tongTienPanel.getText());
	                gh.GiaTienlbl.setText(String.valueOf(donGia * Integer.parseInt(gh.soLuongLbl.getText())));

	                break; // Thoát khỏi vòng lặp khi tìm thấy sản phẩm trong giỏ hàng
	            }
	        }
	    }

	    if (!found && BUS.QuanLyBanHang.AddToCartBUS.submit) {
	        CartItem gh = new CartItem();
	        gh.maSanPhamLbl.setText(masp);
	        gh.tenLaptopLbl.setText(GUI.QuanLyBanHang.AddToCart.tenLaptopLbl.getText());
	        gh.donGiaLbl.setText(GUI.QuanLyBanHang.AddToCart.tongTienPanel.getText());
	        gh.soLuongLbl.setText(GUI.QuanLyBanHang.AddToCart.timKiemDonHangTxt.getText());

	        gh.GiaTienlbl.setText(String.valueOf(Integer.parseInt(gh.donGiaLbl.getText()) * Integer.parseInt(gh.soLuongLbl.getText())));

	        cartItems.add(gh);
	    }

	    return cartItems;
	}

	public static void setCartItems(ArrayList<CartItem> newCartItems) {
	    cartItems = newCartItems;
	}
	
	
	//Nút tăng số lượng
	
	public static void SetUpButtonIncrease1()
	{
		try {
			String a = GUI.QuanLyBanHang.CartItem.soLuongLbl.getText(); 
			int SL= Integer.parseInt(a);
			SL = SL+1;
			GUI.QuanLyBanHang.CartItem.soLuongLbl.setText(Integer.toString(SL));
			
			if (SL<=10)
			{
				double b = Double.parseDouble(GUI.QuanLyBanHang.CartItem.donGiaLbl.getText()); 
				double k = 0;
				k = SL * b;
				DecimalFormat decimalFormat = new DecimalFormat("#");
				GUI.QuanLyBanHang.CartItem.GiaTienlbl.setText(decimalFormat.format(k));
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Để tránh tình trạng đầu cơ trục lợi ảnh hưởng tới thị trường. \n Vui lòng đặt tối đa 10 sản phầm.");
				GUI.QuanLyBanHang.CartItem.soLuongLbl.setText("1");
				GUI.QuanLyBanHang.CartItem.GiaTienlbl.setText(GUI.QuanLyBanHang.CartItem.donGiaLbl.getText()); 
			}
			
			}
		catch (Exception E){
			JOptionPane.showMessageDialog(null, "Unacceptable value");
			}
			
	}
	*/
	//Nút giảm số lượng
	public static void SetUpButtonDecrease1()
	{
		try {
			String a = GUI.QuanLyBanHang.CartItem.soLuongLbl.getText(); 
					 int SL= Integer.parseInt(a);
					 if(SL > 1)
					 {
						 SL = SL-1;	
				GUI.QuanLyBanHang.CartItem.soLuongLbl.setText(Integer.toString(SL));
					 }
					 else
					 {
						JOptionPane.showMessageDialog(null, "Số lượng hàng không được nhỏ hơn 1");
					 }
			double b = Double.parseDouble(GUI.QuanLyBanHang.CartItem.donGiaLbl.getText()); 
			double k = 0;
			k = SL * b;
			DecimalFormat decimalFormat = new DecimalFormat("#");
			GUI.QuanLyBanHang.CartItem.GiaTienlbl.setText(decimalFormat.format(k));				}
				catch (Exception E){
					JOptionPane.showMessageDialog(null, "Unacceptable value");
				}		
	}
	//Xử lý sdt
	
	public static boolean isValid(String phoneNumber) {
        try {
            String cleanedPhoneNumber = cleanPhoneNumber(phoneNumber);

            // Check if the cleaned phone number has at most 11 digits and contains only numbers
            return cleanedPhoneNumber.length() <= 11 && cleanedPhoneNumber.matches("\\d+");
        } catch (InputMismatchException e) {
    
            return false;
        }
    }

    private static String cleanPhoneNumber(String phoneNumber) {
        // Remove spaces and dashes from the phone number
        return phoneNumber.replaceAll("\\s|-", "");
    }
	
	
	public static void ShowNameCustomerByPhone() {
	    String sdt1 = GUI.QuanLyBanHang.QuanLyBanHangFrm.soDienThoaiKHTxt.getText();
	    String tenkh = "";

	    if (!isValid(sdt1)) 
	    {
            JOptionPane.showMessageDialog(null, "Lỗi: Số điện thoại không hợp lệ. \n Vui lòng chỉ nhập không lớn hơn 11 số.");

	    }
	    else
	    {
	        String sqlQuery1 = "SELECT makh,tenkh FROM khachhang WHERE sdt LIKE ?";

	        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlycuahang", "root", "");
	             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery1)) {

	            preparedStatement.setString(1, "%"+sdt1+"%"); // Fix the parameter index here
	            ResultSet resultSet = preparedStatement.executeQuery();

	            // Retrieving data from the database
	            while (resultSet.next()) {
	                makh = resultSet.getString("makh");
	                tenkh = resultSet.getString("tenkh");
	              
	            }
	            resultSet.close();
	            preparedStatement.close();
	            connection.close();
	            
	            while(true)
	            {
	            	if (tenkh == "") {
	                // Display a dialog indicating failure
	                JOptionPane.showMessageDialog(null, "Không tìm thấy tên khách hàng!");
	              
	                // Clear the text field
	                GUI.QuanLyBanHang.QuanLyBanHangFrm.teniKhachHangTxt.setText("");       
	                break;
	            } else {
	                // Set the result in the text field
	                GUI.QuanLyBanHang.QuanLyBanHangFrm.teniKhachHangTxt.setText(tenkh);
	                break;
	            }
	            }
	            

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	}
	
	


	//Submit to cart item
/*
	public static void executeOK() {
	  //  GUI.QuanLyBanHang.QuanLyBanHangFrm.cartItemPanel.removeAll(); // Xóa dữ liệu cũ
	   ArrayList<CartItem> cartItems = CartItemBUS.getCartItems();

	    totalSum = 0;

	    for (int i = 0; i < cartItems.size(); i++) {
	        CartItem gh = cartItems.get(i);
	        GUI.QuanLyBanHang.QuanLyBanHangFrm.cartItemPanel.setLayout(new GridLayout(0, 1, 0, 0));
	        GUI.QuanLyBanHang.QuanLyBanHangFrm.cartItemPanel.add(gh);
	        
	        // Tính tổng giá tiền
	        double dg = Double.parseDouble(gh.GiaTienlbl.getText()); 
	        totalSum += dg;
	    }
	    revalidateCartItemPanel();
	    
	}

	
	
	public static void removeCartItem() {
		//GUI.QuanLyBanHang.QuanLyBanHangFrm.cartItemPanel.removeAll(); // Xóa dữ liệu cũ
	    ArrayList<CartItem> cartItems = CartItemBUS.getCartItems();
        String targetProductCode = GUI.QuanLyBanHang.QuanLyBanHangFrm.MaSP.getText().trim();

       
        for (int i = 0 ; i<cartItems.size();i++) {
            
            if (CartItem.maSanPhamLbl.getText().equalsIgnoreCase(targetProductCode)) {
            	if (cartItems.size() == 1) {
            		cartItems.clear();
            	    GUI.QuanLyBanHang.QuanLyBanHangFrm.cartItemPanel.removeAll();

            	}
            	else
            	{
            	    GUI.QuanLyBanHang.QuanLyBanHangFrm.cartItemPanel.remove(cartItems.get(i));
            		cartItems.remove(i);

            	}
          
            }
        }
	    
	    
	    BUS.QuanLyBanHang.CartItemBUS.executeOK();

	    revalidateCartItemPanel();
	}
*/
	/*
	public static void ShowNameCustomerByPhone(JComboBox<String> comboBox) {
        String sdt1 = GUI.QuanLyBanHang.QuanLyBanHangFrm.soDienThoaiKHTxt.getText();
        String tenkh = "";

        if (isValid(sdt1)) {
            String sqlQuery1 = "SELECT tenkh FROM khachhang WHERE sdt LIKE ?";

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlycuahang", "root", "");
                 PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery1)) {

                preparedStatement.setString(1, "%" + sdt1 + "%"); // Fix the parameter index here
                ResultSet resultSet = preparedStatement.executeQuery();

                // Retrieving data from the database
                while (resultSet.next()) {
                    tenkh = resultSet.getString("tenkh");
                    comboBox.addItem(tenkh);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Disconnect from the database
                try {
					DAO_Connection.disconnect();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
    }
    */
	public static void revalidateCartItemPanel() {
	    GUI.QuanLyBanHang.QuanLyBanHangFrm.cartItemPanel.revalidate();
	    GUI.QuanLyBanHang.QuanLyBanHangFrm.cartItemPanel.repaint();
	   
	}

	public static void checkCart() {
		
	}
	/*
    public static void clearCartItemPanel() {
    	GUI.QuanLyBanHang.QuanLyBanHangFrm.cartItemPanel.removeAll();

    	//clearFields();

        BUS.QuanLyBanHang.CartItemBUS.executeOK(); // Call the demo method again to display all items

        revalidateCartItemPanel();
    }
	 
	*/
}
