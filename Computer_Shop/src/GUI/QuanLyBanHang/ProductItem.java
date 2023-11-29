package GUI.QuanLyBanHang;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import GUI.LoginForm;

import javax.swing.JTextArea;
import MyDesign.MyComponents.MyButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ProductItem extends JPanel {

	//Edit
	private static long serialVersionUID = 1L;
	public static JLabel imageLbl ;
	public static JTextArea tenLaptopLbl;
	public static JLabel lblNewLabel;
	public static MyButton timKiemBtn_1;
	public String tensp;
	public String masp;
	public double gia;
	public Object DTO_SanPham;
	public String image;

	/**
	 * Create the panel.
	 */
	
	
	public ProductItem() {
		setBorder(new LineBorder(new Color(0, 255, 255), 1, true));
		setBackground(new Color(102, 102, 102));
			setSize(237,207);
			
			//Edit: hình
			imageLbl = new JLabel();
			imageLbl.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			imageLbl.setHorizontalAlignment(SwingConstants.CENTER);
			imageLbl.setForeground(new Color(0, 255, 255));
			
			//Edit: tên sp
			tenLaptopLbl = new JTextArea();
			tenLaptopLbl.setBorder(null);
			tenLaptopLbl.setEditable(false);
			tenLaptopLbl.setLineWrap(true);
			tenLaptopLbl.setText(tensp);
			tenLaptopLbl.setForeground(new Color(0, 255, 255));
			tenLaptopLbl.setBackground(new Color(102, 102, 102));
			
			timKiemBtn_1 = new MyButton();
			timKiemBtn_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
	                   BUS.QuanLyBanHang.AddToCartBUS.SetUpAddToCart();

				}
			});
			timKiemBtn_1.setIcon(new ImageIcon(ProductItem.class.getResource("/assets/cart.png")));
			timKiemBtn_1.setHorizontalTextPosition(SwingConstants.LEADING);
			
			//Edit: giá
			lblNewLabel = new JLabel();
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setForeground(new Color(255, 255, 102));
			GroupLayout groupLayout = new GroupLayout(this);
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(23)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(timKiemBtn_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(tenLaptopLbl, Alignment.LEADING)
								.addComponent(imageLbl, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)))
						.addContainerGap())
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(10)
						.addComponent(imageLbl, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addGap(2)
						.addComponent(tenLaptopLbl, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addGap(1)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(timKiemBtn_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGap(11))
			);
			setLayout(groupLayout);
	}


	 public void setTenSanPham(String tensp) {
	        this.tensp = tensp;
	        // Assuming tenSanPhamLbl is a label within each ProductItem instance
	        // Update this part according to your actual class structure
	        tenLaptopLbl.setText(tensp);
	    }

	    public void setTenGia(double gia) {
	        this.gia = gia;
	        // Assuming giaLbl is a label within each ProductItem instance
	        // Update this part according to your actual class structure
	        DecimalFormat decimalFormat = new DecimalFormat("#");
	        lblNewLabel.setText(decimalFormat.format(gia));
	    }
	    
	    public void setAnh(String image) {
	        this.image = image;

	        // Attempt to load the image using the resource path
	        URL imageUrl = ProductItem.class.getResource(image);

	        if (imageUrl != null) {
	            // Image found, create ImageIcon and set it to the imageLbl
	            ImageIcon icon = new ImageIcon(imageUrl);
	            Image img = icon.getImage();

	            // Set the desired width and height for displaying
	            int width = 187;
	            int height = 130;

	            // Calculate the scale factor to maintain the aspect ratio
	            double scaleFactor = Math.min(1.0 * width / img.getWidth(null), 1.0 * height / img.getHeight(null));

	            // Scale the image with Image.SCALE_SMOOTH
	            Image scaledImage = img.getScaledInstance((int) (img.getWidth(null) * scaleFactor), (int) (img.getHeight(null) * scaleFactor), Image.SCALE_SMOOTH);

	            // Create a new ImageIcon with the scaled image and set it to the imageLbl
	            icon = new ImageIcon(scaledImage);
	            imageLbl.setIcon(icon);
	        } else {
	            // Image not found, handle the error (e.g., print a message)
	            System.err.println("Image not found: " + image);
	        }
	    }
	    public void setMaSanPham(String masp)
	    {
	    	this.masp = masp;
	    }
	    
	    public String getMaSanPham() {
	        return masp;
	    }
	
	    public String getTenSanPham() {
	        return tensp;
	    }

	    public double getTenGia() {
	        return gia;
	    }
	    
	    public String getTenAnh() {
	        return image;
	    }



	    //Set up Add to cart
	    /*
	    public void setTenSanPham1(String tensp) {
	        this.tensp = tensp;
	        // Assuming tenSanPhamLbl is a label within each ProductItem instance
	        // Update this part according to your actual class structure
	        tenLaptopLbl.setText(tensp);
	    }

	    public void setTenGia1(double gia) {
	        this.gia = gia;
	        // Assuming giaLbl is a label within each ProductItem instance
	        // Update this part according to your actual class structure
	        GUI.QuanLyBanHang.AddToCart.setTenGia1.setText(String.valueOf(gia));
	    }
	    
	    public void setAnh1(String image) {
	        this.image = image;

	        // Attempt to load the image using the resource path
	        URL imageUrl = ProductItem.class.getResource(image);

	        if (imageUrl != null) {
	            // Image found, create ImageIcon and set it to the imageLbl
	            ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imageUrl));
	            imageLbl1.setIcon(icon);
	        } else {
	            // Image not found, handle the error (e.g., print a message)
	            System.err.println("Image not found: " + image);
	        }
	    }
*/

	  
	    	
	    

}
