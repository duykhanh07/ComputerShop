package GUI.QuanLyBanHang;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import BUS.QuanLyBanHang.AddToCartBUS;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import MyDesign.MyComponents.MyButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import MyDesign.MyComponents.MyTextfield;
import java.awt.Dimension;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class AddToCart extends JFrame {

	private static final long serialVersionUID = 1L;

	public static JLabel imageLbl1 ;
	public static JLabel tongTienPanel;
	public static JTextArea tenLaptopLbl;
	
	//Edit
	public static JButton xoaBtn;
	public static JButton congBtn;
	public static JButton truBtn;
	public static MyTextfield timKiemDonHangTxt;
	private JPanel contentPane;

	public String tensp;

	public double gia;

	public String image;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddToCart frame = new AddToCart();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	/**
	 * Create the frame.
	 */
	public AddToCart() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddToCart.class.getResource("/assets/Laptop_Login.png")));
		setTitle("Add to Cart");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(239, 462);
		setMinimumSize(new Dimension(239, 462));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		
		imageLbl1 = new JLabel();
		imageLbl1.setBounds(29, 6, 165, 112);
		imageLbl1.setHorizontalAlignment(SwingConstants.CENTER);
		imageLbl1.setForeground(Color.CYAN);
		imageLbl1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 232, 200, 175);
		panel.setBackground(new Color(77, 77, 77));
		panel.setLayout(new GridLayout(4, 3, 0, 0));
		
		MyButton btn7 = new MyButton();
		btn7.setColorOver(new Color(77, 77, 77));
		btn7.setColor(new Color(51, 51, 51));
		btn7.setBackground(new Color(51, 51, 51));
		btn7.setText("7");
		btn7.setHorizontalTextPosition(SwingConstants.LEADING);
		panel.add(btn7);
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCartBUS.Number7();
			}
		});
		
		MyButton btn8 = new MyButton();
		btn8.setColor(new Color(51, 51, 51));
		btn8.setColorOver(new Color(77, 77, 77));
		btn8.setBackground(new Color(51, 51, 51));
		btn8.setText("8");
		btn8.setHorizontalTextPosition(SwingConstants.LEADING);
		panel.add(btn8);
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCartBUS.Number8();
			}
		});
		
		MyButton btn9 = new MyButton();
		btn9.setColor(new Color(51, 51, 51));
		btn9.setColorOver(new Color(77, 77, 77));
		btn9.setBackground(new Color(51, 51, 51));
		btn9.setText("9");
		btn9.setHorizontalTextPosition(SwingConstants.LEADING);
		panel.add(btn9);
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCartBUS.Number9();
			}
		});
		
		MyButton btn4 = new MyButton();
		btn4.setColor(new Color(51, 51, 51));
		btn4.setColorOver(new Color(77, 77, 77));
		btn4.setBackground(new Color(51, 51, 51));
		btn4.setText("4");
		btn4.setHorizontalTextPosition(SwingConstants.LEADING);
		panel.add(btn4);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCartBUS.Number4();
			}
		});
		
		MyButton btn5 = new MyButton();
		btn5.setColor(new Color(51, 51, 51));
		btn5.setColorOver(new Color(77, 77, 77));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCartBUS.Number5();
			}
		});
		btn5.setBackground(new Color(51, 51, 51));
		btn5.setText("5");
		btn5.setHorizontalTextPosition(SwingConstants.LEADING);
		panel.add(btn5);
		
		MyButton btn6 = new MyButton();
		btn6.setColor(new Color(51, 51, 51));
		btn6.setColorOver(new Color(77, 77, 77));
		btn6.setBackground(new Color(51, 51, 51));
		btn6.setText("6");
		btn6.setHorizontalTextPosition(SwingConstants.LEADING);
		panel.add(btn6);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCartBUS.Number6();
			}
		});
		
		MyButton btn1 = new MyButton();
		btn1.setColor(new Color(51, 51, 51));
		btn1.setColorOver(new Color(77, 77, 77));
		btn1.setBackground(new Color(51, 51, 51));
		btn1.setText("1");
		btn1.setHorizontalTextPosition(SwingConstants.LEADING);
		panel.add(btn1);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCartBUS.Number1();
			}
		});
		
		MyButton btn2 = new MyButton();
		btn2.setColor(new Color(51, 51, 51));
		btn2.setColorOver(new Color(77, 77, 77));
		btn2.setBackground(new Color(51, 51, 51));
		btn2.setText("2");
		btn2.setHorizontalTextPosition(SwingConstants.LEADING);
		panel.add(btn2);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCartBUS.Number2();
			}
		});
		
		MyButton btn3 = new MyButton();
		btn3.setColor(new Color(51, 51, 51));
		btn3.setColorOver(new Color(77, 77, 77));
		btn3.setBackground(new Color(51, 51, 51));
		btn3.setText("3");
		btn3.setHorizontalTextPosition(SwingConstants.LEADING);
		panel.add(btn3);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCartBUS.Number3();
			}
		});
		
		MyButton xoaBtn = new MyButton();
		xoaBtn.setIcon(new ImageIcon(AddToCart.class.getResource("/assets/backspace.png")));
		xoaBtn.setColorOver(new Color(255, 100, 100));
		xoaBtn.setColor(new Color(255, 128, 128));
		xoaBtn.setForeground(new Color(0, 0, 0));
		xoaBtn.setBackground(new Color(255, 128, 128));
		xoaBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		panel.add(xoaBtn);
		xoaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCartBUS.SetUpButtonBackspace();
			}
		});
		
		
		MyButton btn0 = new MyButton();
		btn0.setColor(new Color(51, 51, 51));
		btn0.setColorOver(new Color(77, 77, 77));
		btn0.setBackground(new Color(51, 51, 51));
		btn0.setText("0");
		btn0.setHorizontalTextPosition(SwingConstants.LEADING);
		panel.add(btn0);
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCartBUS.Number0();
			}
		});
		
		MyButton xacNhanBtn = new MyButton();
		xacNhanBtn.setText("OK");
		xacNhanBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		panel.add(xacNhanBtn);
		xacNhanBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCartBUS.AddToCartButton();
				QuanLyBanHangFrm.updateTable();
				//BUS.QuanLyBanHang.CartItemBUS.executeOK();
			}
		});
		
        
		congBtn = new MyButton();
		congBtn.setIcon(new ImageIcon(AddToCart.class.getResource("/assets/add.png")));
		congBtn.setBounds(10, 202, 66, 30);
		congBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
		congBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		//Edit
		congBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCartBUS.SetUpButtonIncrease();
			}
		});
		
		
		truBtn = new MyButton();
		truBtn.setIcon(new ImageIcon(AddToCart.class.getResource("/assets/remove.png")));
		truBtn.setBounds(144, 202, 66, 30);
		truBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
		truBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		
		//Edit
		truBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToCartBUS.SetUpButtonDecrease();
			}
		});
		
		//Edit tên laptop
		tenLaptopLbl = new JTextArea();
		tenLaptopLbl.setBounds(0, 120, 223, 41);
		tenLaptopLbl.setBorder(null);
		tenLaptopLbl.setLineWrap(true);
		tenLaptopLbl.setForeground(Color.CYAN);
		tenLaptopLbl.setEditable(false);
		tenLaptopLbl.setBackground(new Color(102, 102, 102));
		
		//Edit tổng tiền
		tongTienPanel = new JLabel();
		tongTienPanel.setBounds(10, 172, 200, 28);
		tongTienPanel.setHorizontalAlignment(SwingConstants.CENTER);
		tongTienPanel.setForeground(new Color(255, 255, 102));
		tongTienPanel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		timKiemDonHangTxt = new MyTextfield();
		timKiemDonHangTxt.setHorizontalAlignment(SwingConstants.CENTER);
		timKiemDonHangTxt.setText("1");
		timKiemDonHangTxt.setBounds(76, 202, 68, 30);
		timKiemDonHangTxt.setAlignmentY(0.0f);
		timKiemDonHangTxt.setAlignmentX(0.0f);
		
		//Edit
		timKiemDonHangTxt.setEditable(true);
		
		timKiemDonHangTxt.setPreferredSize(new Dimension(180, 35));
		timKiemDonHangTxt.setColumns(10);
		timKiemDonHangTxt.setBorder(new EmptyBorder(0, 0, 0, 0));
		timKiemDonHangTxt.setBackground(new Color(77, 77, 77));
		contentPane.setLayout(null);
		contentPane.add(imageLbl1);
		contentPane.add(tongTienPanel);
		contentPane.add(congBtn);
		contentPane.add(timKiemDonHangTxt);
		contentPane.add(truBtn);
		contentPane.add(panel);
		contentPane.add(tenLaptopLbl);
	
	}
	
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
	        DecimalFormat decimalFormat = new DecimalFormat("#");
	        tongTienPanel.setText(decimalFormat.format(gia));
	    }
	    
	    public void setAnh1(String image) {
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
	            imageLbl1.setIcon(icon);
	        } else {
	            // Image not found, handle the error (e.g., print a message)
	            System.err.println("Image not found: " + image);
	        }
	    }

	
	    public String getTenSanPham1() {
	        return tensp;
	    }

	    public double getTenGia1() {
	        return gia;
	    }
	    
	    

}
