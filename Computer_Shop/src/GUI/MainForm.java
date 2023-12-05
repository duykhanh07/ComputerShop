package GUI;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.log.Slf4JLogger;

import GUI.BaoHanh.QuanLyBaoHanhFrm;
import GUI.QuanLyBanHang.QuanLyBanHangFrm;
import GUI.QuanLyKhachHang.QuanLyKhachHangFrm;
import GUI.QuanLyKho.QuanLyKhoFrm;
import GUI.QuanLySanPham.QuanLySanPhamFrm;
import GUI.QuanLyTaiKhoan.QuanLyTaiKhoanFrm;
import GUI.ThongKe.ThongKeDoanhSo;
import GUI.ThongKe.ThongKeDoanhThu;
import MyDesign.MyComponents.MyButton;
import MyDesign.MyComponents.MyButton2;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class MainForm extends JFrame {

	private JPanel contentPane;
	
	private ArrayList<MyButton2> ds_menu = new ArrayList<MyButton2>(); // TODO : DANH SÁCH MENU
	private String manv, tennv, chucvu;
	private JPanel menuPanel;

	private JSplitPane splitPane;

	private int y_position;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm(new String[]{"","","tester"});
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
	public MainForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainForm.class.getResource("/assets/Laptop_Login.png")));
		initComponents();
	}
	
	public MainForm(String[] data) {
		this.manv = data[0];
		this.tennv = data[1];
		this.chucvu = data[2];
		
		initComponents();
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainForm.class.getResource("/assets/Laptop_Login.png")));
		splitPane.setRightComponent(new Welcome(manv, tennv, chucvu));
	}
	// TODO : KHỞI TẠO COMPONENTS
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280,720);
		setMinimumSize(new Dimension(1280, 760));
		setLocationRelativeTo(null);
		setTitle(chucvu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		splitPane = new JSplitPane();
		splitPane.setForeground(new Color(0, 0, 0));
		splitPane.setBackground(new Color(0, 0, 0));
		splitPane.setEnabled(false);
		splitPane.setDividerSize(1);
		splitPane.setDividerLocation(175);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 1264, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
		);
		
		menuPanel = new JPanel();
		menuPanel.setMinimumSize(new Dimension(175, 10));
		menuPanel.setPreferredSize(new Dimension(175, 720));
		menuPanel.setMaximumSize(new Dimension(175, 32767));
		menuPanel.setBackground(new Color(51, 51, 51));
		splitPane.setLeftComponent(menuPanel);
		
		JLabel menuLabel = new JLabel("LAPTOP SHOP");
		menuLabel.setIcon(new ImageIcon(new ImageIcon(MainForm.class.getResource("/assets/Laptop_Login.png")).getImage().getScaledInstance(32, 24, Image.SCALE_SMOOTH)));
		menuLabel.setFont(new Font("Bangers", Font.PLAIN, 20));
		menuLabel.setForeground(new Color(0, 204, 204));
		menuLabel.setBackground(new Color(255, 255, 102));
		menuLabel.setOpaque(true);
		menuLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel bottomRect = new JLabel("hide");
		bottomRect.setAlignmentY(0.0f);
		bottomRect.setForeground(new Color(255, 255, 102));
		bottomRect.setBackground(new Color(255, 255, 102));
		bottomRect.setOpaque(true);
		bottomRect.setBounds(new Rectangle(0, 0, 0, 20));
		
		JLabel auto_agile = new JLabel("");
		
		JButton btnNewButton = new JButton("Đăng xuất");
		btnNewButton.setIcon(new ImageIcon(MainForm.class.getResource("/assets/logout.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					UIManager.setLookAndFeel(getClass().getName());
				} catch (Exception e2) {}
				new LoginForm().setVisible(true);
			}
		});
		btnNewButton.setAlignmentY(0.0f);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(new Color(0, 255, 255));
		btnNewButton.setBackground(new Color(77, 77, 77));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_menuPanel = new GroupLayout(menuPanel);
		gl_menuPanel.setHorizontalGroup(
			gl_menuPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_menuPanel.createSequentialGroup()
					.addGroup(gl_menuPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(bottomRect, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
						.addGroup(gl_menuPanel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(menuLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
							.addComponent(auto_agile, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_menuPanel.setVerticalGroup(
			gl_menuPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuPanel.createSequentialGroup()
					.addComponent(menuLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(538)
					.addComponent(auto_agile, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
					.addGap(35)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(bottomRect, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
		);
		menuPanel.setLayout(gl_menuPanel);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(new Color(77, 77, 77));
		splitPane.setRightComponent(contentPanel);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 880, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 669, Short.MAX_VALUE)
		);
		contentPanel.setLayout(gl_contentPanel);
		contentPane.setLayout(gl_contentPane);
		initButton(this.chucvu);
	}

	// TODO : TẠO MENU ITEM CHO MENU
	public void initButton(String chucVu) {
		y_position = 34;
		ArrayList<String>btnString;
		if(chucVu.equalsIgnoreCase("thu ngân") || chucVu.equals("bán hàng")) {
			btnString = new ArrayList<String>(Arrays.asList("BÁN HÀNG","QUẢN LÝ KHÁCH HÀNG","THÔNG TIN CÁ NHÂN"));		
		}else if(chucVu.equalsIgnoreCase("thủ kho")) {
			btnString = new ArrayList<String>(Arrays.asList("QUẢN LÝ KHO","THÔNG TIN CÁ NHÂN"));	
		}else if(chucVu.equalsIgnoreCase("kỹ thuật")) {
			btnString = new ArrayList<String>(Arrays.asList("BẢO HÀNH","THÔNG TIN CÁ NHÂN"));
		}else if(chucVu.equalsIgnoreCase("quản lý")) {
			btnString = new ArrayList<String>(Arrays.asList("QUẢN LÝ SẢN PHẨM", "QUẢN LÝ KHÁCH HÀNG", "THỐNG KÊ DOANH THU", "THỐNG KÊ DOANH SỐ","THÔNG TIN CÁ NHÂN"));
		}else if(chucVu.equalsIgnoreCase("admin")) {
			btnString = new ArrayList<String>(Arrays.asList("QUẢN LÝ TÀI KHOẢN","THÔNG TIN CÁ NHÂN"));
		}else {
			btnString = new ArrayList<String>(Arrays.asList("BÁN HÀNG","QUẢN LÝ KHÁCH HÀNG","QUẢN LÝ KHO","BẢO HÀNH","QUẢN LÝ SẢN PHẨM", "QUẢN LÝ KHÁCH HÀNG", 
					"THỐNG KÊ DOANH THU", "THỐNG KÊ DOANH SỐ","QUẢN LÝ TÀI KHOẢN","THÔNG TIN CÁ NHÂN"));
		}
		for(int i =0; i<btnString.size(); i++) {
			MyButton2 button = new MyButton2(btnString.get(i));
			button.addActionListener(new ActionListener() {	@Override public void actionPerformed(ActionEvent e) {
				changeButtonColor(button);
			}});
			button.setBounds(0, y_position, 174, 40);
			menuPanel.add(button);
			ds_menu.add(button);
			
			y_position += 40;
		}
		bindingButtonFeature();
		
	}
	
	public void changeButtonColor(MyButton2 btn) {
		for(int i = 0; i< ds_menu.size();i++) {
			if(btn.equals(ds_menu.get(i))) {
				ds_menu.get(i).setSelected(true);
			}else {
				ds_menu.get(i).setSelected(false);
			}
		}
		
	}
	
	public void bindingButtonFeature() {
		for(int i = 0; i<ds_menu.size(); i++) {
			
			if(ds_menu.get(i).getText().equalsIgnoreCase("BÁN HÀNG")) {
				ds_menu.get(i).addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						if(!getTitle().equalsIgnoreCase(chucvu + " - Quản lý bán hàng")) {
							setTitle(chucvu+" - Quản lý bán hàng");
							splitPane.setRightComponent(new QuanLyBanHangFrm(manv));
							splitPane.setDividerLocation(175);
						}
					}
				});
			}else if(ds_menu.get(i).getText().equalsIgnoreCase("QUẢN LÝ KHO")){
				ds_menu.get(i).addActionListener(new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(!getTitle().equalsIgnoreCase(chucvu + " - Quản lý kho hàng")) {
							setTitle(chucvu+" - Quản lý kho hàng");
							splitPane.setRightComponent(new QuanLyKhoFrm(manv));
							splitPane.setDividerLocation(175);
						}
					}
				});
			}else if(ds_menu.get(i).getText().equalsIgnoreCase("QUẢN LÝ KHÁCH HÀNG")){
				ds_menu.get(i).addActionListener(new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(!getTitle().equalsIgnoreCase(chucvu + " - Quản lý khách hàng")) {
							setTitle(chucvu+" - Quản lý khách hàng");
							splitPane.setRightComponent(new QuanLyKhachHangFrm());
							splitPane.setDividerLocation(175);
						}
					}
				});
			}else if(ds_menu.get(i).getText().equalsIgnoreCase("QUẢN LÝ SẢN PHẨM")) {
				ds_menu.get(i).addActionListener(new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(!getTitle().equalsIgnoreCase(chucvu + " - Quản lý danh mục sản phẩm")) {
							setTitle(chucvu+" - Quản lý danh mục sản phẩm");
							splitPane.setRightComponent(new QuanLySanPhamFrm());
							splitPane.setDividerLocation(175);
						}
					}
				});
			}else if(ds_menu.get(i).getText().equalsIgnoreCase("QUẢN LÝ TÀI KHOẢN")) {
				ds_menu.get(i).addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(!getTitle().equalsIgnoreCase(chucvu + " - Quản lý tài khoản nhân viên")) {
							setTitle(chucvu+" - Quản lý tài khoản nhân viên");
							splitPane.setRightComponent(new QuanLyTaiKhoanFrm());
							splitPane.setDividerLocation(175);
						}	
					}
				});						
			}else if(ds_menu.get(i).getText().equalsIgnoreCase("BẢO HÀNH")) {
				ds_menu.get(i).addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(!getTitle().equalsIgnoreCase(chucvu + " - Quản lý bảo hành")) {
							setTitle(chucvu + " - Quản lý bảo hành");
							splitPane.setRightComponent(new QuanLyBaoHanhFrm(manv));
							splitPane.setDividerLocation(175);
						}
					}
				});
			}else if(ds_menu.get(i).getText().equalsIgnoreCase("THÔNG TIN CÁ NHÂN")) {
				ds_menu.get(i).addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(!getTitle().equalsIgnoreCase(chucvu + " - Thông tin cá nhân")) {
							setTitle(chucvu + " - Thông tin cá nhân");
							splitPane.setRightComponent(new Information(manv));
							splitPane.setDividerLocation(175);
						}
					}
				});
			}else if(ds_menu.get(i).getText().equalsIgnoreCase("THỐNG KÊ DOANH THU")) {
				ds_menu.get(i).addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(!getTitle().equalsIgnoreCase(chucvu + " - Thống kê doanh thu")) {
							setTitle(chucvu + " - Thống kê doanh thu");
							splitPane.setRightComponent(new ThongKeDoanhThu());
							splitPane.setDividerLocation(175);
						}
					}
				});
			}else if(ds_menu.get(i).getText().equalsIgnoreCase("THỐNG KÊ DOANH SỐ")) {
				ds_menu.get(i).addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(!getTitle().equalsIgnoreCase(chucvu + " - Thống kê doanh số")) {
							setTitle(chucvu + " - Thống kê doanh số");
							splitPane.setRightComponent(new ThongKeDoanhSo());
							splitPane.setDividerLocation(175);
						}
					}
				});
			}
		}
	}
}
