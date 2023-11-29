package BUS.QuanLyBanHang;

import javax.swing.*;

import GUI.QuanLyBanHang.AddToCart;
import GUI.QuanLyBanHang.CartItem;
import GUI.QuanLyBanHang.ProductItem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ProductItemBUS {
    public static ProductItem[] productItems;
	private static Container productItemPanel = new Container();
	
	
    public ProductItemBUS(Container productItemPanel) {
        ProductItemBUS.productItemPanel = productItemPanel;
    }


    public static int showRows() {
        int rowCount = 0;

        String sql = "SELECT COUNT(*) AS row_count FROM sanpham";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlycuahang", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            // Lấy số hàng và xuất ra màn hình
            if (resultSet.next()) {
                rowCount = resultSet.getInt("row_count");
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }
    
    public void setTenSanPham(String tensp) {
        ProductItem productItem = new ProductItem();
        productItem.setTenSanPham(tensp);
        // Call the method to set the text for the giaLbl label if needed
        // productItem.setGia(gia);
        productItemPanel.add(productItem);
    }
    
    public void setTenGia(double gia) {
        ProductItem productItem = new ProductItem();
        productItem.setTenGia(gia);
        // Call the method to set the text for the giaLbl label if needed
        // productItem.setGia(gia);
        productItemPanel.add(productItem);
    }
    
    public void setAnh(String image) {
    	 SwingUtilities.invokeLater(() -> {
             ProductItem productItem = new ProductItem();
             productItem.setAnh(image);
             productItemPanel.add(productItem);
         });
    	/*
        ProductItem productItem = new ProductItem();
        productItem.setAnh(image);
        // Call the method to set the text for the giaLbl label if needed
        // productItem.setGia(gia);
        productItemPanel.add(productItem);
        */
    }
    
//Set UP mã sp, mã nhân viên
    public void SetUPSanPhamNhanVien()
    {
    	
    	 String sql = "SELECT masp,image, tensp, gia FROM sanpham";

         // Kết nối đến cơ sở dữ liệu
         try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlycuahang", "root", "");
              // Assuming the cartItemPanel is needed for initialization
              PreparedStatement statement = connection.prepareStatement(sql)) {

             // Thực hiện truy vấn SELECT
             ResultSet resultSet = statement.executeQuery();

             // Lưu dữ liệu vào ArrayList<ProductItem>
             while (resultSet.next()) {
             	String image = resultSet.getString("image");
             	image = changeFileExtension(image, "jpg"); //đuôi jpg
                 String tensp = resultSet.getString("tensp");
                 double gia = resultSet.getDouble("gia");

               
             }

             // Đóng các tài nguyên
             resultSet.close();
             statement.close();
             connection.close();

         } catch (SQLException e) {
             e.printStackTrace();
         }
    }
    
   
    //Đổi đuôi jpg
    public static String changeFileExtension(String originalPath, String newExtension) {
        int lastDotIndex = originalPath.lastIndexOf('.');
        if (lastDotIndex == -1) {
            // No dot found in the original path
            return originalPath;
        }

        String pathWithoutExtension = originalPath.substring(0, lastDotIndex);
        return pathWithoutExtension + "." + newExtension;
    }
    
    public static ArrayList<ProductItem> getProductItems() {
        ArrayList<ProductItem> productItems = new ArrayList<>();
        String masp="";
        
        // Thông tin kết nối cơ sở dữ liệu

        // Câu truy vấn SQL để lấy dữ liệu từ bảng sanpham
        String sql = "SELECT masp, image, tensp, gia FROM sanpham";

        // Kết nối đến cơ sở dữ liệu
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlycuahang", "root", "");
             // Assuming the cartItemPanel is needed for initialization
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Thực hiện truy vấn SELECT
            ResultSet resultSet = statement.executeQuery();

            // Lưu dữ liệu vào ArrayList<ProductItem>
            while (resultSet.next()) {
            	masp = resultSet.getString("masp");
            	String image = resultSet.getString("image");
            	image = changeFileExtension(image, "jpg"); //đuôi jpg
                String tensp = resultSet.getString("tensp");
                double gia = resultSet.getDouble("gia");

                // Tạo mới ProductItem và gán dữ liệu
                ProductItem pi = new ProductItem();
                 pi.setAnh(image);
                 pi.setTenSanPham(tensp);
                 pi.setTenGia(gia);
                 pi.setMaSanPham(masp);
              
                // Thêm ProductItem vào ArrayList
                productItems.add(pi);
            }

            // Đóng các tài nguyên
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productItems;
    }
    
	//Filter by JCheckBox
	
	public static boolean meetsCondition(boolean condition, String Item, String Phanloai) {
        return condition && (Item.toLowerCase()).contains(Phanloai.toLowerCase());
    }
	
	public static void filterAndDisplayItems(boolean condition, String txt) {
	    GUI.QuanLyBanHang.QuanLyBanHangFrm.ProductItemPanel.removeAll();

	    ArrayList<ProductItem> productItems = ProductItemBUS.getProductItems();

	    int itemsPerRow = 4;
	    GUI.QuanLyBanHang.QuanLyBanHangFrm.ProductItemPanel.setLayout(new GridLayout(0, itemsPerRow + 1, 0, 0));

        // Get the list of ProductItem objects from the database

        for (int i = 0; i < productItems.size(); i++) {
            ProductItem pi = productItems.get(i);
    	        // Check the condition for filtering
    	        if (meetsCondition(condition, pi.getTenSanPham(), txt)) {
    	            // Create a new JPanel for each ProductItem and add it to the ProductItemPanel
    	            GUI.QuanLyBanHang.QuanLyBanHangFrm.ProductItemPanel.add(pi);

    	           if ((i + 1) % itemsPerRow == 0) {
            	 GUI.QuanLyBanHang.QuanLyBanHangFrm.ProductItemPanel.add(new JPanel());
            }  
    	        }
    	    } 
        
	   
	    // Revalidate and repaint the panels
	    revalidateProductItemPanel() ;
	}
	/*
	public static void demo1() {
        int itemsPerRow = 4;
		ProductItemPanel.setLayout(new GridLayout(0, itemsPerRow + 1, 0, 0));

        // Get the list of ProductItem objects from the database
        ArrayList<ProductItem> productItems = ProductItemBUS.getProductItems();

        for (int i = 0; i < productItems.size(); i++) {
            ProductItem pi = productItems.get(i);
            ProductItemPanel.add(pi);

            if ((i + 1) % itemsPerRow == 0) {
                ProductItemPanel.add(new JPanel());
            }
        }
        */
	/*
	public static void filterAndDisplayItems(boolean condition, String txt) {
	    GUI.QuanLyBanHang.QuanLyBanHangFrm.ProductItemPanel.removeAll();

	    ArrayList<ProductItem> productItems = ProductItemBUS.getProductItems();

	    int itemsPerRow = 4;

	    // Set the layout for ProductItemPanel and cartItemPanel
	    GUI.QuanLyBanHang.QuanLyBanHangFrm.ProductItemPanel.setLayout(new GridLayout(0, itemsPerRow, 5, 5));

	    int itemCount = 0; // Số lượng ProductItem đã thêm vào layout

	    for (int i = 0; i < productItems.size(); i++) {
	        ProductItem pi = productItems.get(i);

	        // Check the condition for filtering
	        if (meetsCondition(condition, pi.getTenSanPham(), txt)) {
	            // Create a new JPanel for each ProductItem and add it to the ProductItemPanel
	            JPanel itemPanel = createItemPanel(pi);
	            GUI.QuanLyBanHang.QuanLyBanHangFrm.ProductItemPanel.add(itemPanel);

	            itemCount++; // Tăng số lượng ProductItem đã thêm vào layout
	        }
	    }

	    // Add empty panels to fill the remaining spaces in the last row
	    int emptySpaces = itemsPerRow - (itemCount % itemsPerRow);
	    for (int i = 0; i < emptySpaces; i++) {
	        GUI.QuanLyBanHang.QuanLyBanHangFrm.ProductItemPanel.add(createEmptyPanel());
	    }

	    // Revalidate and repaint the panels
	    revalidateProductItemPanel() ;
	}
	

	// Helper method to create a JPanel for each ProductItem
	private static JPanel createItemPanel(ProductItem pi) {
	    JPanel itemPanel = new JPanel();
	    itemPanel.setLayout(new BorderLayout());
	    itemPanel.add(pi, BorderLayout.CENTER);
	    return itemPanel;
	}

	// Helper method to create an empty JPanel
	private static JPanel createEmptyPanel() {
	    JPanel emptyPanel = new JPanel();
	    return emptyPanel;
	}

	*/
	
	
	// Helper method to revalidate and repaint panels
	private static void revalidateProductItemPanel() {
	    GUI.QuanLyBanHang.QuanLyBanHangFrm.ProductItemPanel.revalidate();
	    GUI.QuanLyBanHang.QuanLyBanHangFrm.ProductItemPanel.repaint();
	   
	}

	
    public static void clearProductItemPanel() {
    	GUI.QuanLyBanHang.QuanLyBanHangFrm.ProductItemPanel.removeAll();

    	clearFields();

        GUI.QuanLyBanHang.QuanLyBanHangFrm.demo1(); // Call the demo method again to display all items

        revalidateProductItemPanel();
    }
    

    public static void clearFields() {
        // Iterate through the components of your JFrame
    	GUI.QuanLyBanHang.QuanLyBanHangFrm.GroupModel.clearSelection();
    	GUI.QuanLyBanHang.QuanLyBanHangFrm.timKiemTonKhoTxt.setText("");
    	/*
    	if (GUI.QuanLyBanHang.QuanLyBanHangFrm.sortCmbx_1.getSelectedItem() != null)
    	{
    		GUI.QuanLyBanHang.QuanLyBanHangFrm.sortCmbx_1.setEnabled(false);
        // Khôi phục trạng thái ban đầu sau một khoảng thời gian
    	Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Khôi phục trạng thái ban đầu của JComboBox
            	GUI.QuanLyBanHang.QuanLyBanHangFrm.sortCmbx_1.setEnabled(true);
            }

        });
        timer.setRepeats(false); // Chỉ chạy một lần
        timer.start();
        timer.setRepeats(false); // Chỉ chạy một lần
        timer.start();
    	}
    	*/
    
     }
    
    
    
    
    //Sorting
    //Decreasing
    public static void mergeSort1(ArrayList<ProductItem> arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort1(arr, left, mid);
            mergeSort1(arr, mid + 1, right);

            merge1(arr, left, mid, right);
        }
    }

    public static void merge1(ArrayList<ProductItem> arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        ArrayList<ProductItem> leftArray = new ArrayList<>(arr.subList(left, mid + 1));
        ArrayList<ProductItem> rightArray = new ArrayList<>(arr.subList(mid + 1, right + 1));

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray.get(i).getTenGia() <= rightArray.get(j).getTenGia()) {
                arr.set(k++, leftArray.get(i++));
            } else {
                arr.set(k++, rightArray.get(j++));
            }
        }

        while (i < n1) {
            arr.set(k++, leftArray.get(i++));
        }

        while (j < n2) {
            arr.set(k++, rightArray.get(j++));
        }
    }

  //Increasing
    public static void mergeSort2(ArrayList<ProductItem> arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort2(arr, left, mid);
            mergeSort2(arr, mid + 1, right);

            merge2(arr, left, mid, right);
        }
    }

    public static void merge2(ArrayList<ProductItem> arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        ArrayList<ProductItem> leftArray = new ArrayList<>(arr.subList(left, mid + 1));
        ArrayList<ProductItem> rightArray = new ArrayList<>(arr.subList(mid + 1, right + 1));

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray.get(i).getTenGia() >= rightArray.get(j).getTenGia()) {
                arr.set(k++, leftArray.get(i++));
            } else {
                arr.set(k++, rightArray.get(j++));
            }
        }

        while (i < n1) {
            arr.set(k++, leftArray.get(i++));
        }

        while (j < n2) {
            arr.set(k++, rightArray.get(j++));
        }
    }

   public static void SortingPrice (int a)
   {
	    GUI.QuanLyBanHang.QuanLyBanHangFrm.ProductItemPanel.removeAll();
	   ArrayList<ProductItem> productItems = ProductItemBUS.getProductItems();

       if (a==0)
       {
    	   mergeSort1(productItems, 0, productItems.size() - 1);
       }
       else
       {
    	   mergeSort2(productItems, 0, productItems.size() - 1);
       }
       

	    int itemsPerRow = 4;
	    GUI.QuanLyBanHang.QuanLyBanHangFrm.ProductItemPanel.setLayout(new GridLayout(0, itemsPerRow + 1, 0, 0));

       // Get the list of ProductItem objects from the database

       for (int i = 0; i < productItems.size(); i++) {
           ProductItem pi = productItems.get(i);
   	        // Check the condition for filtering
   	            // Create a new JPanel for each ProductItem and add it to the ProductItemPanel
   	            GUI.QuanLyBanHang.QuanLyBanHangFrm.ProductItemPanel.add(pi);

   	           if ((i + 1) % itemsPerRow == 0) {
           	 GUI.QuanLyBanHang.QuanLyBanHangFrm.ProductItemPanel.add(new JPanel());
            
   	        }
   	    } 
   
    // Revalidate and repaint the panels
	    revalidateProductItemPanel() ;   
   }
    
	
}
