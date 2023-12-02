package GUI.QuanLyBanHang;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import BUS.QuanLyBanHang.BanHangInterface;
import BUS.QuanLyBanHang.QuanLyBanHangBUS;
import DTO.DTO_SanPham;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import MyDesign.MyComponents.MyButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import MyDesign.MyComponents.MyTextfield;
import java.awt.Dimension;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class AddToCart extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel imageLbl;
	private JLabel thanhTienLbl;
	private JTextArea tenLaptopLbl;
	DecimalFormat df = new DecimalFormat("#,###");
	
	//Edit
	private static JButton xoaBtn;
	private static JButton congBtn;
	private static JButton truBtn;
	private static MyTextfield quantityTxt;
	
	private JPanel contentPane;
	
	private DTO_SanPham sp;
	private BanHangInterface banHangInterface;

	public AddToCart(DTO_SanPham sp,BanHangInterface banHangInterface) {
		this.sp = sp;
		this.banHangInterface = banHangInterface;
		
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
		setResizable(false);
		setMinimumSize(new Dimension(239, 462));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		
		imageLbl = new JLabel("hình ảnh");
		imageLbl.setBounds(29, 6, 165, 112);
		imageLbl.setHorizontalAlignment(SwingConstants.CENTER);
		imageLbl.setForeground(Color.CYAN);
		imageLbl.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
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
				inputNum(7);
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
				inputNum(8);
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
				inputNum(9);
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
				inputNum(4);
			}
		});
		
		MyButton btn5 = new MyButton();
		btn5.setColor(new Color(51, 51, 51));
		btn5.setColorOver(new Color(77, 77, 77));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputNum(5);
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
				inputNum(6);
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
				inputNum(0);
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
				inputNum(2);
			}
		});
		
		MyButton btn3 = new MyButton();
		btn3.setColor(new Color(51, 51, 51));
		btn3.setColorOver(new Color(77, 77, 77));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn3.setBackground(new Color(51, 51, 51));
		btn3.setText("3");
		btn3.setHorizontalTextPosition(SwingConstants.LEADING);
		panel.add(btn3);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputNum(3);
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
				backSpace();
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
				inputNum(0);
			}
		});
		
		MyButton xacNhanBtn = new MyButton();
		xacNhanBtn.setText("OK");
		xacNhanBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		panel.add(xacNhanBtn);
		xacNhanBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themVaoGioHang();
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
				increase();
			}
		});
		
		
		truBtn = new MyButton();
		truBtn.setIcon(new ImageIcon(AddToCart.class.getResource("/assets/remove.png")));
		truBtn.setBounds(144, 202, 66, 30);
		truBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
		truBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		//Edit
		truBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				decrease();
			}
		});
		
		//Edit tên laptop
		tenLaptopLbl = new JTextArea();
		tenLaptopLbl.setLineWrap(true);
		tenLaptopLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tenLaptopLbl.setText("Laptop 5");
		tenLaptopLbl.setBounds(0, 120, 223, 41);
		tenLaptopLbl.setBorder(null);
		tenLaptopLbl.setForeground(Color.CYAN);
		tenLaptopLbl.setEditable(false);
		tenLaptopLbl.setBackground(new Color(102, 102, 102));

		//Edit tổng tiền
		thanhTienLbl = new JLabel();
		thanhTienLbl.setBounds(10, 172, 200, 28);
		thanhTienLbl.setHorizontalAlignment(SwingConstants.CENTER);
		thanhTienLbl.setForeground(new Color(255, 255, 102));
		thanhTienLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		quantityTxt = new MyTextfield();
		quantityTxt.setHorizontalAlignment(SwingConstants.CENTER);
		quantityTxt.setText("1");
		quantityTxt.setBounds(76, 202, 68, 30);
		quantityTxt.setAlignmentY(0.0f);
		quantityTxt.setAlignmentX(0.0f);
		
		//Edit
		quantityTxt.setEditable(false);
		
		quantityTxt.setPreferredSize(new Dimension(180, 35));
		quantityTxt.setColumns(10);
		quantityTxt.setBorder(new EmptyBorder(0, 0, 0, 0));
		quantityTxt.setBackground(new Color(77, 77, 77));
		contentPane.setLayout(null);
		contentPane.add(imageLbl);
		contentPane.add(thanhTienLbl);
		contentPane.add(congBtn);
		contentPane.add(quantityTxt);
		contentPane.add(truBtn);
		contentPane.add(congBtn);
		contentPane.add(panel);
		contentPane.add(tenLaptopLbl);
		hienThi();
	}
	public void hienThi() {
		this.imageLbl.setIcon(new ImageIcon(new ImageIcon(ProductItem.class.getResource(this.sp.getImage())).getImage().getScaledInstance(187, 112, Image.SCALE_SMOOTH)));
		tenLaptopLbl.setText(this.sp.getTensp());
		quantityTxt.setText("1");
		thanhTienLbl.setText(df.format(this.sp.getGia())+"đ");
	}
	public void inputNum(int num) {
		quantityTxt.setText(quantityTxt.getText() + num);
		tinhThanhTien();
	}
	public void backSpace() {
		if(quantityTxt.getText().length()>0)
			quantityTxt.setText(quantityTxt.getText().substring(0, quantityTxt.getText().length()-1));
		if(!quantityTxt.getText().equalsIgnoreCase("")) {
			tinhThanhTien();
		}
	}
	public void increase() {
		quantityTxt.setText((Integer.parseInt(quantityTxt.getText())+1)+"");
		tinhThanhTien();
	}
	public void decrease() {
		if(Integer.parseInt(quantityTxt.getText())>1) {
			quantityTxt.setText((Integer.parseInt(quantityTxt.getText())-1)+"");
			tinhThanhTien();
		}
	}
	public void tinhThanhTien() {
		int thanhTien = Integer.parseInt(quantityTxt.getText()) * sp.getGia();
		thanhTienLbl.setText(df.format(thanhTien)+"đ");
	}
	public void themVaoGioHang() {
		int soluong;
		try {
			soluong = Integer.parseInt(quantityTxt.getText());
		} catch (Exception e) {
			soluong = 1;
			quantityTxt.setText("1");
		}
		
		int xacNhan = JOptionPane.showConfirmDialog(null, "Thêm vào giỏ hàng");
		if(xacNhan == 0) {
			banHangInterface.capNhatGioHang(sp, soluong);
			dispose();
		}
	}
}
