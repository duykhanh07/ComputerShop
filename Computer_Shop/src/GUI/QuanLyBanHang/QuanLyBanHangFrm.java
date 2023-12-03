package GUI.QuanLyBanHang;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import MyDesign.MyTabPane.MyTabbedPaneCustom;
import MyDesign.MyTable.CustomTableCellRenderer;
import MyDesign.MyTable.CustomTableHeaderUI;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import MyDesign.MyComponents.MyTextfield;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JComboBox;
import MyDesign.MyComponents.MyButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.ScrollPaneConstants;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Flow;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import MyDesign.Calendar.MyDateChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import BUS.HoaDonBUS;
import BUS.QuanLyBanHang.BanHangInterface;
import BUS.QuanLyBanHang.QuanLyBanHangBUS;
import DTO.DTO_HoaDon;
import DTO.DTO_SanPham;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;



public class QuanLyBanHangFrm extends JPanel {

	//Edit
	private static final long serialVersionUID = 1L;
	public static JComboBox sortCmbx_1;
	public static JCheckBox giaoHangChck;
	//public static JComboBox<String> teniKhachHangTxt;
	public static MyTextfield soDienThoaiKHTxt;
	public static MyTextfield tenKhachHangTxt;
	public static MyTextfield timKiemSanPhamTxt;
	public static MyTextfield diaChiTxt;
	private JTable table;
	public static JPanel cartItemPanel;
	public static JPanel ProductItemPanel;
	public static JLabel lblTngCng;
	public static MyTextfield timKiemDonHangTxt ;
	private static DefaultTableModel model;
	HoaDonBUS hoadonbus = new HoaDonBUS();
    
	private ArrayList<JCheckBox> ds_HangBtn;
	private QuanLyBanHangBUS qlbh_bus;
	private JPanel HangSXPanel;
	private MyButton mbtnLmMi;
	private JScrollPane scrollPane_1;
	
	//CART
	private AddToCart cuaSoGioHang;
	public String manv;
	private BanHangInterface banHangInter;
	
	public QuanLyBanHangFrm(String manv) {
		
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		setBackground(new Color(102, 102, 102));
		
		this.manv = manv;
		ds_HangBtn = new ArrayList<JCheckBox>();
		qlbh_bus = new QuanLyBanHangBUS();
		banHangInter = new BanHangInterface() {			
			@Override
			public void moCuaSoGioHang(DTO_SanPham sp) {
				if(cuaSoGioHang != null) {
					cuaSoGioHang.dispose();
				}
				cuaSoGioHang = new AddToCart(sp, banHangInter);
				cuaSoGioHang.setVisible(true);
			}
			
			@Override
			public void capNhatGioHang(DTO_SanPham sp, int soluong) {
				int kq_them = qlbh_bus.capNhatGioHang(sp, soluong);	
				if(kq_them<0) {
					JOptionPane.showMessageDialog(null, "Cập nhật giỏ hàng thất bại, quá số lượng");
				}
				hienThiGioHang();
			}

			@Override
			public void boKhoiGioHang(String masp) {
				qlbh_bus.boKhoiGioHang(masp);
				hienThiGioHang();
			}

			@Override
			public void themGioHang(DTO_SanPham sp, int soluong) {
				int kq_them = qlbh_bus.themVaoGioHang(sp, soluong);
				if(kq_them<0) {
					JOptionPane.showMessageDialog(null, "Thêm vào giỏ hàng thất bại, quá số lượng");
				}else {
					JOptionPane.showMessageDialog(null, "Thêm vào giỏ hàng thành công");
				}
				hienThiGioHang();
			}
		};
		
		
		MyTabbedPaneCustom tabbedPane = new MyTabbedPaneCustom();
		
		JPanel banHangPanel = new JPanel();
		banHangPanel.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("bán hàng", null, banHangPanel, null);
		
		//Edit
		timKiemSanPhamTxt = new MyTextfield();
		timKiemSanPhamTxt.setPreferredSize(new Dimension(180, 35));
		timKiemSanPhamTxt.setColumns(10);
		timKiemSanPhamTxt.setBorder(new EmptyBorder(0, 0, 0, 0));
		timKiemSanPhamTxt.setBackground(new Color(77, 77, 77));
		timKiemSanPhamTxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                   timKiemSanPham();
                }
            }
        });
		
		JLabel lblNewLabel_1 = new JLabel("Sắp xếp :");
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		//Edit sorting
		 String[] sortOptions = { "Giá tăng dần", "Giá giảm dần"};
        JComboBox sortCmbx_1 = new JComboBox(sortOptions);
        sortCmbx_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(sortCmbx_1.getSelectedIndex() > -1)
        			sapXepTheoGia(sortCmbx_1.getSelectedIndex());
        	}
        });
        sortCmbx_1.setForeground(Color.CYAN);
        sortCmbx_1.setBackground(new Color(102, 102, 102));
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBorder(new LineBorder(new Color(130, 135, 144)));
		scrollPane_1.getVerticalScrollBar().setUnitIncrement(100);
		
		HangSXPanel = new JPanel();
		FlowLayout fl_HangSXPanel = (FlowLayout) HangSXPanel.getLayout();
		fl_HangSXPanel.setAlignment(FlowLayout.LEFT);
		HangSXPanel.setToolTipText("các hãng laptop");
		HangSXPanel.setForeground(Color.CYAN);
		HangSXPanel.setBackground(new Color(77, 77, 77));
		
		//Edit
		mbtnLmMi = new MyButton();
		mbtnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		mbtnLmMi.setIcon(new ImageIcon(QuanLyBanHangFrm.class.getResource("/assets/reset.png")));
		mbtnLmMi.setText("làm mới");
		mbtnLmMi.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton timKiemBtn_1 = new MyButton();
		timKiemBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiemSanPham();
			}
		});
		timKiemBtn_1.setText("Lọc");
		timKiemBtn_1.setHorizontalTextPosition(SwingConstants.LEADING);
		
		GroupLayout gl_banHangPanel = new GroupLayout(banHangPanel);
		gl_banHangPanel.setHorizontalGroup(
			gl_banHangPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_banHangPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_banHangPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)
						.addGroup(gl_banHangPanel.createSequentialGroup()
							.addComponent(timKiemSanPhamTxt, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(timKiemBtn_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 297, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(sortCmbx_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_banHangPanel.createSequentialGroup()
							.addComponent(HangSXPanel, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(mbtnLmMi, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
					.addGap(22))
		);
		gl_banHangPanel.setVerticalGroup(
			gl_banHangPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_banHangPanel.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_banHangPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_banHangPanel.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_banHangPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(sortCmbx_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_banHangPanel.createSequentialGroup()
							.addGap(13)
							.addGroup(gl_banHangPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(timKiemBtn_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(timKiemSanPhamTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_banHangPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(mbtnLmMi, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(HangSXPanel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
					.addGap(13))
		);
		
		ProductItemPanel = new JPanel();
		ProductItemPanel.setBackground(new Color(51, 51, 51));
		scrollPane_1.setViewportView(ProductItemPanel);
		banHangPanel.setLayout(gl_banHangPanel);
		
		
		/*
		teniKhachHangTxt = new JComboBox<>();
		teniKhachHangTxt.setBackground(new Color(77, 77, 77));
		teniKhachHangTxt.setBorder(null);
		teniKhachHangTxt.setVisible(true);

		teniKhachHangTxt.addItemListener(new ItemListener() {
		    public void itemStateChanged(ItemEvent e) {
		        System.out.println("ItemStateChanged event triggered!");
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		            CartItemBUS.ShowNameCustomerByPhone(teniKhachHangTxt);
		        }
		    }
		});
		*/
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 851, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
					.addGap(21))
		);
		
		JPanel cartPanel = new JPanel();
		cartPanel.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("Giỏ hàng", null, cartPanel, null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.getViewport().setBackground(new Color(51,51,51));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		
		MyButton xacNhanHoaDonBtn = new MyButton();
		xacNhanHoaDonBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taoHoaDon();
			}
		});
		xacNhanHoaDonBtn.setText("Xác nhận");
		xacNhanHoaDonBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		

		JLabel maNhanVienThuNganLbl = new JLabel("mã nhân viên : "+this.manv);
		maNhanVienThuNganLbl.setForeground(Color.CYAN);
		maNhanVienThuNganLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		//Edit tồng cộng label
		
		lblTngCng = new JLabel();
		lblTngCng.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTngCng.setForeground(Color.CYAN);
		lblTngCng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		JLabel lblTnKhchHng = new JLabel("số điện thoại : ");
		lblTnKhchHng.setForeground(Color.CYAN);
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		//Edit
		soDienThoaiKHTxt = new MyTextfield();
		soDienThoaiKHTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
					timKiemKhachHang();
			}
		});
		soDienThoaiKHTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!soDienThoaiKHTxt.getText().equals(""))	
					timKiemKhachHang();
			}
		});
		soDienThoaiKHTxt.setBackground(new Color(77, 77, 77));
		soDienThoaiKHTxt.setColumns(10);
		soDienThoaiKHTxt.setBorder(null);
		
		
		JLabel lblSinThoi = new JLabel("tên khách hàng :");
		lblSinThoi.setForeground(Color.CYAN);
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		//Edit
		tenKhachHangTxt = new MyTextfield();
		tenKhachHangTxt.setText("");
		tenKhachHangTxt.setBackground(new Color(77, 77, 77));
		tenKhachHangTxt.setBorder(null);
		tenKhachHangTxt.setVisible(true);
		tenKhachHangTxt.setEditable(false);
				
				giaoHangChck = new JCheckBox("giao hàng tại nhà");
				giaoHangChck.setForeground(Color.CYAN);
				giaoHangChck.setFont(new Font("Tahoma", Font.PLAIN, 15));
				giaoHangChck.setBorder(new EmptyBorder(0, 0, 0, 0));
				giaoHangChck.setBackground(new Color(102, 102, 102));
				
				diaChiTxt = new MyTextfield();
				diaChiTxt.setText("");
				diaChiTxt.setEditable(false);
				diaChiTxt.setBackground(new Color(77, 77, 77));
				diaChiTxt.setColumns(10);
				diaChiTxt.setBorder(null);
				
				JLabel autoIncreaseSpaceLbl = new JLabel("");
				
				cartItemPanel = new JPanel();
				cartItemPanel.setBackground(new Color(51, 51, 51));
				scrollPane.setViewportView(cartItemPanel);
				cartItemPanel.setLayout(new GridLayout(0, 1, 0, 0));
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(255, 255, 102));
				
				JLabel lblNewLabel_2 = new JLabel(".No");
				lblNewLabel_2.setForeground(new Color(0, 205, 205));
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
				
				JLabel lblNewLabel_2_1 = new JLabel("Tên sản phẩm");
				lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_2_1.setForeground(new Color(0, 205, 205));
				lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				
				JLabel lblNewLabel_2_1_1 = new JLabel("đơn giá");
				lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_2_1_1.setForeground(new Color(0, 205, 205));
				lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				
				JLabel lblNewLabel_2_1_1_1 = new JLabel("số lượng");
				lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_2_1_1_1.setForeground(new Color(0, 205, 205));
				lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				
				JLabel lblNewLabel_2_1_1_2 = new JLabel("thành tiền");
				lblNewLabel_2_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_2_1_1_2.setForeground(new Color(0, 205, 205));
				lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
						
						JLabel lblNewLabel_3 = new JLabel("");
						GroupLayout gl_cartPanel = new GroupLayout(cartPanel);
						gl_cartPanel.setHorizontalGroup(
							gl_cartPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_cartPanel.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_cartPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_cartPanel.createParallelGroup(Alignment.LEADING, false)
											.addGroup(gl_cartPanel.createSequentialGroup()
												.addGap(122)
												.addComponent(soDienThoaiKHTxt, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
											.addComponent(lblTnKhchHng, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
											.addComponent(maNhanVienThuNganLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(Alignment.TRAILING, gl_cartPanel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblTngCng, GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
											.addGap(10)
											.addComponent(xacNhanHoaDonBtn, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.TRAILING, gl_cartPanel.createSequentialGroup()
											.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
											.addGap(5)
											.addComponent(tenKhachHangTxt, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
											.addGap(37)
											.addComponent(giaoHangChck, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(diaChiTxt, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabel_3, 0, 0, Short.MAX_VALUE))
										.addComponent(panel, 0, 0, Short.MAX_VALUE)
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE))
									.addContainerGap())
						);
						gl_cartPanel.setVerticalGroup(
							gl_cartPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_cartPanel.createSequentialGroup()
									.addGap(15)
									.addComponent(maNhanVienThuNganLbl)
									.addGap(5)
									.addGroup(gl_cartPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(soDienThoaiKHTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_cartPanel.createSequentialGroup()
											.addGap(6)
											.addComponent(lblTnKhchHng)))
									.addGap(13)
									.addGroup(gl_cartPanel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblSinThoi)
										.addGroup(gl_cartPanel.createSequentialGroup()
											.addGap(2)
											.addGroup(gl_cartPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_cartPanel.createParallelGroup(Alignment.BASELINE)
													.addComponent(giaoHangChck, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
													.addComponent(diaChiTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
												.addComponent(tenKhachHangTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
									.addGap(31)
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
									.addGap(17)
									.addGroup(gl_cartPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(xacNhanHoaDonBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTngCng, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
									.addGap(12))
						);
						
						JLabel lblNewLabel_4 = new JLabel("");
						GroupLayout gl_panel = new GroupLayout(panel);
						gl_panel.setHorizontalGroup(
							gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_2_1, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
									.addGap(6)
									.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(lblNewLabel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_2_1_1_2, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
						);
						gl_panel.setVerticalGroup(
							gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblNewLabel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2_1_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2_1_1_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2_1_1_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
									.addContainerGap(2, Short.MAX_VALUE))
						);
						panel.setLayout(gl_panel);
						cartPanel.setLayout(gl_cartPanel);
						
						giaoHangChck.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								if(giaoHangChck.isSelected()) {
									diaChiTxt.setEditable(true);
									diaChiTxt.setBackground(new Color(77,77,77));
								}else {
									diaChiTxt.setText("");
									diaChiTxt.setEditable(false);
									diaChiTxt.setBackground(new Color(100,100,100));
								}
							}
						});
		
		JPanel donHangPanel = new JPanel();
		donHangPanel.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("Đơn hàng - Hóa đơn", null, donHangPanel, null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.getViewport().setBackground(new Color(51,51,51));
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		table = new JTable();
		table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		table.getTableHeader().setUI(new CustomTableHeaderUI());
		table.getTableHeader().setFont(new Font("Tahoma",Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"m\u00E3 h\u00F3a \u0111\u01A1n", "m\u00E3 kh\u00E1ch h\u00E0ng", "m\u00E3 nh\u00E2n vi\u00EAn", "ng\u00E0y l\u1EADp", "d\u1ECBa ch\u1EC9 giao h\u00E0ng", "t\u1ED5ng ti\u1EC1n", "tr\u1EA1ng th\u00E1i"
			}
		));
		scrollPane_2.setViewportView(table);
		
		timKiemDonHangTxt = new MyTextfield();
		timKiemDonHangTxt.setPreferredSize(new Dimension(180, 35));
		timKiemDonHangTxt.setColumns(10);
		timKiemDonHangTxt.setBorder(new EmptyBorder(0, 0, 0, 0));
		timKiemDonHangTxt.setBackground(new Color(77, 77, 77));
		
		JComboBox timKiemTypeCmbx = new JComboBox();
		timKiemTypeCmbx.setModel(new DefaultComboBoxModel(new String[] {"theo mã hóa đơn", "theo mã khách hàng", "theo mã nhân viên", "theo địa chỉ giao hàng", "theo trạng thái"}));
		timKiemTypeCmbx.setForeground(Color.CYAN);
		timKiemTypeCmbx.setBackground(new Color(102, 102, 102));
		
		MyButton timKiemBtn = new MyButton();
		
		timKiemBtn.setText("Lọc");
		timKiemBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel auto_increase_spaceLbl = new JLabel("");
		auto_increase_spaceLbl.setBackground(new Color(102, 102, 102));
		
		JLabel lblNewLabel = new JLabel("Sắp xếp :");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox sortCmbx = new JComboBox();
		sortCmbx.setModel(new DefaultComboBoxModel(new String[] {"----------", "ngày lập hóa đơn tăng dần", "ngày lập hóa đơn giảm dần", "tổng tiền tăng dần", "tổng tiền giảm dần"}));
		sortCmbx.setForeground(Color.CYAN);
		sortCmbx.setBackground(new Color(102, 102, 102));
		sortCmbx.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				sapXepHoaDon(sortCmbx.getSelectedIndex());
			}
		});
		
		JLabel lblT = new JLabel("Từ :");
		lblT.setForeground(Color.CYAN);
		lblT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyDateChooser fromDateChooser = new MyDateChooser();
		fromDateChooser.setBackground(new Color(102, 102, 102));
		
		JLabel lbln = new JLabel("Đến :");
		lbln.setForeground(Color.CYAN);
		lbln.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyDateChooser toDateChooser = new MyDateChooser();
		toDateChooser.setBackground(new Color(102, 102, 102));
		timKiemBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				timKiemHoaDon(timKiemDonHangTxt.getText().toLowerCase(), timKiemTypeCmbx.getSelectedIndex(), fromDateChooser.getDate(), toDateChooser.getDate());
			}
		});
		
		MyButton InHoaDonBtn = new MyButton();
		InHoaDonBtn.setText("in hóa đơn");
		InHoaDonBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		InHoaDonBtn.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
					if(table.getSelectedRow() > 0) {
						 String mahd = table.getValueAt(table.getSelectedRow(), 0).toString();
						 qlbh_bus.inHoaDon(mahd);
					}
			}
		});
		
		
		// Nút này để cập nhật trạng thái, ví dụ từ : đang giao hàng -> đã thanh toán
		MyButton InHoaDonBtn_1 = new MyButton();
		InHoaDonBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() > 0) {
					updateTrangThaiHoaDon(table.getSelectedRow());
				}
			}
		});
		
		InHoaDonBtn_1.setToolTipText("cập nhật trạng thái hóa đơn");
		InHoaDonBtn_1.setText("cập nhật");
		InHoaDonBtn_1.setHorizontalTextPosition(SwingConstants.LEADING);
		GroupLayout gl_donHangPanel = new GroupLayout(donHangPanel);
		gl_donHangPanel.setHorizontalGroup(
			gl_donHangPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_donHangPanel.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_donHangPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_donHangPanel.createSequentialGroup()
							.addComponent(timKiemDonHangTxt, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(timKiemTypeCmbx, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(timKiemBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(auto_increase_spaceLbl, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
							.addGap(26)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(sortCmbx, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_donHangPanel.createSequentialGroup()
							.addComponent(lblT, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(fromDateChooser, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(lbln, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(toDateChooser, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
						.addGroup(gl_donHangPanel.createSequentialGroup()
							.addComponent(InHoaDonBtn, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(InHoaDonBtn_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))
					.addGap(38))
		);
		gl_donHangPanel.setVerticalGroup(
			gl_donHangPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_donHangPanel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_donHangPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(timKiemDonHangTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_donHangPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(timKiemTypeCmbx, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_donHangPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(timKiemBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addComponent(auto_increase_spaceLbl, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(sortCmbx, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(gl_donHangPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_donHangPanel.createSequentialGroup()
							.addGap(2)
							.addComponent(lblT, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_donHangPanel.createSequentialGroup()
							.addGap(2)
							.addComponent(fromDateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_donHangPanel.createSequentialGroup()
							.addGap(2)
							.addComponent(lbln, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(toDateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
					.addGap(11)
					.addGroup(gl_donHangPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(InHoaDonBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(InHoaDonBtn_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(21))
		);
		donHangPanel.setLayout(gl_donHangPanel);
		setLayout(groupLayout);
//		demo1(); 
//		demo2();
		hienThiSanPham();
		hienThiHangSanPham();
		loadHoaDon();
	}
	// Method to update the table with new data
    
	//DEMON
	public static void demo1() {
		ProductItemPanel.setLayout(new GridLayout(0, 4, 0, 0));
        for (int i = 0; i < 10; i++) {
//            ProductItem pi = new ProductItem();
//            ProductItemPanel.add(pi);
        }
	}
	
	public void demo2() {
        for (int i = 0; i < 10; i++) {
//           CartItem cartItem = new CartItem(qlbh_bus.ds_hienThi.get(i),1, banHangInter);
//           cartItemPanel.add(cartItem);
        }
	}
	
	ArrayList <DTO_HoaDon> arr_hoadon = hoadonbus.get_AllHoaDon();
	public void loadHoaDon()
	{
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		//Định dạng hiển thị ngày
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY      HH:mm:ss");
		
		//Định dạng hiển thị tiền tệ
		String patternTongTien = "###,###";
		DecimalFormat formatTongTien = new DecimalFormat(patternTongTien);
		
		for(DTO_HoaDon x: arr_hoadon)
		{
			String ngaylaphoadon = sdf.format(x.getNgaylaphd());
			String tongtien = formatTongTien.format(x.getTongtien());
			model.addRow(new Object [] {x.getMahd(), x.getMakh(), x.getManv(), ngaylaphoadon, x.getDiachigiao(), tongtien, x.getTrangthai()});
		}
	}
	
	//Tìm kiếm hóa đơn
	public void timKiemHoaDon(String timKiemStr, int selectedIndex, Date fromDate, Date toDate)
	{
		if(timKiemStr.equalsIgnoreCase(""))
			JOptionPane.showMessageDialog(null, "Bạn phải điền thông tin muốn tìm");
		else
		{
			arr_hoadon = hoadonbus.timKiemHoaDon(timKiemStr, selectedIndex, fromDate, toDate);
		}
		loadHoaDon();
	}
	
	//Sắp xếp danh sách hóa đơn
	public void sapXepHoaDon(int selectedIndex)
	{
		switch (selectedIndex)
		{
		case 1:
			Collections.sort(arr_hoadon, Comparator.comparing(DTO_HoaDon -> DTO_HoaDon.getNgaylaphd()));
			loadHoaDon();
			break;
		case 2:
			Collections.sort(arr_hoadon, Comparator.comparing(DTO_HoaDon -> ((DTO.DTO_HoaDon) DTO_HoaDon).getNgaylaphd()).reversed());
			loadHoaDon();
			break;
		case 3:
			Collections.sort(arr_hoadon, Comparator.comparingDouble(DTO_HoaDon -> DTO_HoaDon.getTongtien()));
			loadHoaDon();
			break;
		case 4:
			Collections.sort(arr_hoadon, Comparator.comparingDouble((DTO_HoaDon -> ((DTO.DTO_HoaDon) DTO_HoaDon).getTongtien())).reversed());
			loadHoaDon();
			break;
		default:
			arr_hoadon = hoadonbus.get_AllHoaDon();
			loadHoaDon();
		}
	}
	
	//Cập nhật trạng thái hóa đơn
	public void updateTrangThaiHoaDon(int selectedRow)
	{
		if(arr_hoadon.get(selectedRow).getTrangthai().equalsIgnoreCase("đã thanh toán"))
		{
			JOptionPane.showMessageDialog(null, "Hóa đơn này đã thanh toán");
			return;
		}
		
		arr_hoadon.get(selectedRow).setTrangthai("đã thanh toán");
		int check = -1;
		check = hoadonbus.update_TrangThaiHoaDon(arr_hoadon.get(selectedRow));
		if(check != -1)
			JOptionPane.showMessageDialog(null, "Cập nhật trạng thái hóa đơn thành công!!!");
		else
			JOptionPane.showMessageDialog(null, "Lỗi!!! Cập nhật trạng thái hóa đơn không thành công!!!");
		loadHoaDon();
	}
	public void hienThiSanPham() {
		ProductItemPanel.removeAll();
		ProductItemPanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		for (int i = 0; i < qlbh_bus.ds_hienThi.size(); i++) {
			ProductItem productItem = new ProductItem(qlbh_bus.ds_hienThi.get(i), banHangInter);
			ProductItemPanel.add(productItem);
		}
		int count = qlbh_bus.ds_hienThi.size();
		while(count<12) {
			ProductItem productItem = new ProductItem();
			ProductItemPanel.add(productItem);
			count++;
		}
		ProductItemPanel.revalidate();
		ProductItemPanel.repaint();
		
	}
	
	public void hienThiHangSanPham() {
		HangSXPanel.removeAll();
		for(int i = 0; i<qlbh_bus.ds_hang.size(); i++) {
			JCheckBox checkbox = new JCheckBox(qlbh_bus.ds_hang.get(i));
			checkbox.setForeground(Color.CYAN);
			checkbox.setBackground(new Color(77, 77, 77));
			checkbox.setSelected(true);
			HangSXPanel.add(checkbox);
			ds_HangBtn.add(checkbox);
			checkbox.addChangeListener(new ChangeListener() {			
				@Override
				public void stateChanged(ChangeEvent e) {
					filterByBrand();
				}
			});
		}
	}
	
	public void filterByBrand() {
		ArrayList <String> hang = new ArrayList<String>();
		for(int i = 0; i<ds_HangBtn.size(); i++) {
			if(ds_HangBtn.get(i).isSelected()) {
				hang.add(ds_HangBtn.get(i).getText());
			}	
		}
		qlbh_bus.filterByBrand(hang, timKiemSanPhamTxt.getText());
		hienThiSanPham();
	}
	
	public void timKiemSanPham() {
		String timKiemStr = timKiemSanPhamTxt.getText();
		qlbh_bus.timKiem(timKiemStr);
		hienThiSanPham();
		HangSXPanel.revalidate();
		HangSXPanel.repaint();
		hienThiHangSanPham();
	}
	
	public void sapXepTheoGia(int type) {
		qlbh_bus.sapXepTheoGia(type);
		hienThiSanPham();
	}
	
	public void hienThiGioHang() {
		cartItemPanel.removeAll();
		for(int i = 0; i<qlbh_bus.gioHang_sanpham.size(); i++) {
			CartItem cartItem = new CartItem(qlbh_bus.gioHang_sanpham.get(i), qlbh_bus.gioHang_soluong.get(i), banHangInter);
			cartItemPanel.add(cartItem);
		}
		
		if(qlbh_bus.gioHang_sanpham.size()*40 < scrollPane_1.getHeight()) {
			int count = qlbh_bus.gioHang_sanpham.size();
			while(count * 40 < scrollPane_1.getHeight()) {
				CartItem cartItem = new CartItem();
				cartItemPanel.add(cartItem);
				count++;
			}
		}
		cartItemPanel.revalidate();
		cartItemPanel.repaint();
		
		hienTongTien();
	}
	public void hienTongTien() {
		DecimalFormat df = new DecimalFormat("#,###");
		long tongTien = qlbh_bus.tinhTongTien();
		lblTngCng.setText("Tổng tiền : " +df.format(tongTien)+"đ");
	}
	
	public void timKiemKhachHang() {
		String sdt = soDienThoaiKHTxt.getText();
		if(sdt.matches("^0\\d{9}$")) {
			String ten_kh_timKiem = qlbh_bus.timKiemKhachHang(sdt);
			if(!ten_kh_timKiem.equalsIgnoreCase("")) {
				tenKhachHangTxt.setText(ten_kh_timKiem);
				tenKhachHangTxt.setEditable(false);
			}else {
				if(!tenKhachHangTxt.isEditable()) {
					tenKhachHangTxt.setEditable(true);
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại hợp lệ");
		}
	}
	
	public boolean kiemTraTenKhachHang() {
		String tenkh = tenKhachHangTxt.getText();
		for(int i = 0; i<10; i++) {
			if(tenkh.contains(""+i)){
				return false;
			}
		}
		return true;
	}
	public void taoHoaDon() {
		
		//manv = this.manv
		
		String diaChiGiao=null;
		String sdtKh= null;
		String tenKh=null;
		int xacNhan = JOptionPane.showConfirmDialog(null, "Tạo hóa đơn");
		if(xacNhan == 0 && kiemTraHopLeHoaDon()) {
			if(tenKhachHangTxt.isEditable()) {
				sdtKh = soDienThoaiKHTxt.getText();
				tenKh = tenKhachHangTxt.getText();			
			}else {
				
			}
			if(diaChiTxt.getText().length() > 0) {
				diaChiGiao = diaChiTxt.getText();
			}
			if(tenKh != null)
				qlbh_bus.taoHoaDon(manv, tenKh, sdtKh, diaChiGiao);
			else
				qlbh_bus.taoHoaDon(manv, diaChiGiao);
		}
	}
	private boolean kiemTraHopLeHoaDon() {
		if(!kiemTraTenKhachHang()) {
			JOptionPane.showMessageDialog(null, "Tên khách hàng không được chứa kí tự là số");
			tenKhachHangTxt.requestFocus();
			return false;
		}
		
		// kiểm tra địa chỉ nếu có
		if(diaChiTxt.getText().equalsIgnoreCase("") && diaChiTxt.isEditable()) {
			diaChiTxt.requestFocus();
			return false;
		}
		
		return true;
	}
	private void refresh() {
		this.qlbh_bus = new QuanLyBanHangBUS();
		hienThiSanPham();
		hienThiHangSanPham();
		hienThiGioHang();
		hienTongTien();
	}
}
