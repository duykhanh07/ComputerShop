package GUI;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GUI.QuanLyKho.QuanLyKhoFrm;
import MyDesign.MyComponents.MyButton;
import MyDesign.MyComponents.MyButton2;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

public class MainForm extends JFrame {

	private JPanel contentPane;
	
	private ArrayList<MyButton2> ds_menu = new ArrayList<MyButton2>(); // TODO : DANH SÁCH MENU
	private String manv, tennv, chucvu;
	private JPanel menuPanel;

	private JSplitPane splitPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm(new String[]{"","","thủ kho"});
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
		setMinimumSize(new Dimension(1280, 760));
		initComponents();
	}
	
	public MainForm(String[] data) {
		this.manv = data[0];
		this.tennv = data[1];
		this.chucvu = data[2];
		
		initComponents();
	}
	// TODO : KHỞI TẠO COMPONENTS
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280,720);
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
		
		JLabel menuLabel = new JLabel("MAIN MENU");
		menuLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		menuLabel.setForeground(new Color(0, 204, 204));
		menuLabel.setBackground(new Color(255, 255, 102));
		menuLabel.setOpaque(true);
		menuLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel bottomRect = new JLabel("hide");
		bottomRect.setForeground(new Color(255, 255, 102));
		bottomRect.setBackground(new Color(255, 255, 102));
		bottomRect.setOpaque(true);
		bottomRect.setBounds(new Rectangle(0, 0, 0, 20));
		
		JLabel auto_agile = new JLabel("");
		GroupLayout gl_menuPanel = new GroupLayout(menuPanel);
		gl_menuPanel.setHorizontalGroup(
			gl_menuPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuPanel.createSequentialGroup()
					.addGroup(gl_menuPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(auto_agile, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(bottomRect, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(menuLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_menuPanel.setVerticalGroup(
			gl_menuPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuPanel.createSequentialGroup()
					.addComponent(menuLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(596)
					.addComponent(auto_agile, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bottomRect))
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
		int y_position = 34;
		if(chucVu.equalsIgnoreCase("thu ngân") || chucVu.equals("bán hàng")) {
			MyButton2 button = new MyButton2("BÁN HÀNG");
			button.addActionListener(new ActionListener() {	@Override public void actionPerformed(ActionEvent e) {
				changeButtonColor(button);
			}});
			button.setBounds(0, y_position, 174, 32);
			menuPanel.add(button);
			ds_menu.add(button);
			
			y_position += 32;
			
			MyButton2 button_1 = new MyButton2("QUẢN LÝ KHÁCH HÀNG");
			button_1.addActionListener(new ActionListener() {	@Override public void actionPerformed(ActionEvent e) {
				changeButtonColor(button_1);
			}});
			button_1.setBounds(0, y_position, 174, 32);
			menuPanel.add(button_1);
			ds_menu.add(button_1);
			
		}else if(chucVu.equalsIgnoreCase("thủ kho")) {
			MyButton2 button = new MyButton2("QUẢN LÝ KHO");
			button.addActionListener(new ActionListener() {	@Override public void actionPerformed(ActionEvent e) {
				changeButtonColor(button);
			}});
			button.setBounds(0, y_position, 174, 32);
			menuPanel.add(button);
			ds_menu.add(button);
			
		}else if(chucVu.equalsIgnoreCase("kỹ thuật")) {
			MyButton2 button = new MyButton2("BẢO HÀNH");
			button.addActionListener(new ActionListener() {	@Override public void actionPerformed(ActionEvent e) {
				changeButtonColor(button);
			}});
			button.setBounds(0, y_position, 174, 32);
			menuPanel.add(button);
			ds_menu.add(button);
			
		}else if(chucVu.equalsIgnoreCase("quản lý")) {
			MyButton2 button = new MyButton2("QUẢN LÝ SẢN PHẨM");
			button.addActionListener(new ActionListener() {	@Override public void actionPerformed(ActionEvent e) {
				changeButtonColor(button);
			}});
			button.setBounds(0, y_position, 174, 32);
			menuPanel.add(button);
			ds_menu.add(button);
			
			y_position += 32;
			
			MyButton2 button_1 = new MyButton2("QUẢN LÝ KHÁCH HÀNG");
			button_1.addActionListener(new ActionListener() {	@Override public void actionPerformed(ActionEvent e) {
				changeButtonColor(button_1);
			}});
			button_1.setBounds(0, y_position, 174, 32);
			menuPanel.add(button_1);
			ds_menu.add(button_1);
			
			y_position += 32;
			
			MyButton2 button_2 = new MyButton2("THỐNG KÊ");
			button_2.addActionListener(new ActionListener() {	@Override public void actionPerformed(ActionEvent e) {
				changeButtonColor(button_2);
			}});
			button_2.setBounds(0, y_position, 174, 32);
			menuPanel.add(button_2);
			ds_menu.add(button_2);
		}else {
			MyButton2 button = new MyButton2("QUẢN LÝ TÀI KHOẢN");
			button.addActionListener(new ActionListener() {	@Override public void actionPerformed(ActionEvent e) {
				changeButtonColor(button);
			}});
			button.setBounds(0, y_position, 174, 32);
			menuPanel.add(button);
			ds_menu.add(button);
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
				
			}else if(ds_menu.get(i).getText().equalsIgnoreCase("QUẢN LÝ KHO")){
				ds_menu.get(i).addActionListener(new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						splitPane.setRightComponent(new QuanLyKhoFrm());
						splitPane.setDividerLocation(175);
					}
				});
			}else if(ds_menu.get(i).getText().equalsIgnoreCase("QUẢN LÝ KHÁCH HÀNG")){
				
			}else if(ds_menu.get(i).getText().equalsIgnoreCase("QUẢN LÝ SẢN PHẨM")) {
				
			}else if(ds_menu.get(i).getText().equalsIgnoreCase("THỐNG KÊ")) {
				
			}else if(ds_menu.get(i).getText().equalsIgnoreCase("QUẢN LÝ TÀI KHOẢN")) {
				
			}else if(ds_menu.get(i).getText().equalsIgnoreCase("BẢO")) {
				
			}
			
		}
	}

	
	public void initContent(JPanel content) {
		
	}
	
}
