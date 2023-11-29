package GUI.QuanLyBanHang;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import MyDesign.MyTabPane.MyTabbedPaneCustom;
import MyDesign.MyTable.CustomTableCellRenderer;
import MyDesign.MyTable.CustomTableHeaderUI;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import MyDesign.MyComponents.MyTextfield;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JComboBox;
import MyDesign.MyComponents.MyButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import MyDesign.Calendar.MyDateChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import BUS.HoaDonBUS;
import DTO.DTO_HoaDon;
import javax.swing.table.TableColumnModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import javax.swing.ImageIcon;

public class QuanLyBanHangFrm extends JPanel {

	private static final long serialVersionUID = 1L;
	private MyTextfield diaChiTxt;
	private JTable table;
	private JPanel cartItemPanel;
	private JPanel ProductItemPanel;

	/**
	 * Create the panel.
	 */
	public QuanLyBanHangFrm() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		setBackground(new Color(102, 102, 102));
		
		MyTabbedPaneCustom tabbedPane = new MyTabbedPaneCustom();
		
		JPanel banHangPanel = new JPanel();
		banHangPanel.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("bán hàng", null, banHangPanel, null);
		
		MyTextfield timKiemTonKhoTxt = new MyTextfield();
		timKiemTonKhoTxt.setPreferredSize(new Dimension(180, 35));
		timKiemTonKhoTxt.setColumns(10);
		timKiemTonKhoTxt.setBorder(new EmptyBorder(0, 0, 0, 0));
		timKiemTonKhoTxt.setBackground(new Color(77, 77, 77));
		
		JComboBox timKiemTypeCmbx_1 = new JComboBox();
		timKiemTypeCmbx_1.setForeground(Color.CYAN);
		timKiemTypeCmbx_1.setBackground(new Color(102, 102, 102));
		
		MyButton timKiemBtn_1 = new MyButton();
		timKiemBtn_1.setText("Lọc");
		timKiemBtn_1.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel auto_increase_spaceLbl_3 = new JLabel("");
		
		JLabel lblNewLabel_1 = new JLabel("Sắp xếp :");
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox sortCmbx_1 = new JComboBox();
		sortCmbx_1.setForeground(Color.CYAN);
		sortCmbx_1.setBackground(new Color(102, 102, 102));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBorder(new LineBorder(new Color(130, 135, 144)));
		scrollPane_1.getVerticalScrollBar().setUnitIncrement(100);
		
		JPanel HangSXPanel = new JPanel();
		FlowLayout fl_HangSXPanel = (FlowLayout) HangSXPanel.getLayout();
		fl_HangSXPanel.setAlignment(FlowLayout.LEFT);
		HangSXPanel.setToolTipText("các hãng laptop");
		HangSXPanel.setForeground(Color.CYAN);
		HangSXPanel.setBackground(new Color(77, 77, 77));
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("ACER");
		chckbxNewCheckBox.setForeground(Color.CYAN);
		chckbxNewCheckBox.setBackground(new Color(77, 77, 77));
		HangSXPanel.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("ASUS");
		chckbxNewCheckBox_1.setForeground(Color.CYAN);
		chckbxNewCheckBox_1.setBackground(new Color(77, 77, 77));
		HangSXPanel.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("HP");
		chckbxNewCheckBox_1_1.setForeground(Color.CYAN);
		chckbxNewCheckBox_1_1.setBackground(new Color(77, 77, 77));
		HangSXPanel.add(chckbxNewCheckBox_1_1);
		
		JCheckBox chckbxNewCheckBox_1_2 = new JCheckBox("Intel");
		chckbxNewCheckBox_1_2.setForeground(Color.CYAN);
		chckbxNewCheckBox_1_2.setBackground(new Color(77, 77, 77));
		HangSXPanel.add(chckbxNewCheckBox_1_2);
		
		JCheckBox chckbxNewCheckBox_1_3 = new JCheckBox("Lenovo");
		chckbxNewCheckBox_1_3.setForeground(Color.CYAN);
		chckbxNewCheckBox_1_3.setBackground(new Color(77, 77, 77));
		HangSXPanel.add(chckbxNewCheckBox_1_3);
		
		MyButton mbtnLmMi = new MyButton();
		mbtnLmMi.setIcon(new ImageIcon(QuanLyBanHangFrm.class.getResource("/assets/reset.png")));
		mbtnLmMi.setText("làm mới");
		mbtnLmMi.setHorizontalTextPosition(SwingConstants.LEADING);
		GroupLayout gl_banHangPanel = new GroupLayout(banHangPanel);
		gl_banHangPanel.setHorizontalGroup(
			gl_banHangPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_banHangPanel.createSequentialGroup()
					.addGroup(gl_banHangPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_banHangPanel.createSequentialGroup()
							.addGap(10)
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE))
						.addGroup(gl_banHangPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(timKiemTonKhoTxt, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(timKiemTypeCmbx_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(timKiemBtn_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(auto_increase_spaceLbl_3, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(sortCmbx_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_banHangPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(HangSXPanel, GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(mbtnLmMi, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
					.addGap(22))
		);
		gl_banHangPanel.setVerticalGroup(
			gl_banHangPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_banHangPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_banHangPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_banHangPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(timKiemTonKhoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_banHangPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(timKiemTypeCmbx_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addComponent(timKiemBtn_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_banHangPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(auto_increase_spaceLbl_3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_banHangPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_banHangPanel.createSequentialGroup()
							.addGap(6)
							.addComponent(sortCmbx_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_banHangPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(mbtnLmMi, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(HangSXPanel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
					.addGap(13))
		);
		
		ProductItemPanel = new JPanel();
		ProductItemPanel.setBackground(new Color(51, 51, 51));
		scrollPane_1.setViewportView(ProductItemPanel);
		banHangPanel.setLayout(gl_banHangPanel);
		
		JPanel cartPanel = new JPanel();
		cartPanel.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("Giỏ hàng", null, cartPanel, null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(new Color(51,51,51));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		
		MyButton xacNhanHoaDonBtn = new MyButton();
		xacNhanHoaDonBtn.setText("Xác nhận");
		xacNhanHoaDonBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel maNhanVienThuNganLbl = new JLabel("mã nhân viên : <<mavn>>");
		maNhanVienThuNganLbl.setForeground(Color.CYAN);
		maNhanVienThuNganLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblTngCng = new JLabel("tổng cộng :....................");
		lblTngCng.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTngCng.setForeground(Color.CYAN);
		lblTngCng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblTnKhchHng = new JLabel("số điện thoại : ");
		lblTnKhchHng.setForeground(Color.CYAN);
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield soDienThoaiKHTxt = new MyTextfield();
		soDienThoaiKHTxt.setBackground(new Color(77, 77, 77));
		soDienThoaiKHTxt.setColumns(10);
		soDienThoaiKHTxt.setBorder(null);
		
		JLabel lblSinThoi = new JLabel("tên khách hàng :");
		lblSinThoi.setForeground(Color.CYAN);
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield teniKhachHangTxt = new MyTextfield();
		teniKhachHangTxt.setBackground(new Color(77, 77, 77));
		teniKhachHangTxt.setColumns(10);
		teniKhachHangTxt.setBorder(null);
		
		JCheckBox giaoHangChck = new JCheckBox("giao hàng tại nhà");
		giaoHangChck.setForeground(Color.CYAN);
		giaoHangChck.setFont(new Font("Tahoma", Font.PLAIN, 15));
		giaoHangChck.setBorder(new EmptyBorder(0, 0, 0, 0));
		giaoHangChck.setBackground(new Color(102, 102, 102));
		
		diaChiTxt = new MyTextfield();
		diaChiTxt.setEditable(false);
		diaChiTxt.setBackground(new Color(77, 77, 77));
		diaChiTxt.setColumns(10);
		diaChiTxt.setBorder(null);
		
		JLabel autoIncreaseSpaceLbl = new JLabel("");
		
		JLabel autoIncreaseSpaceLbl_1 = new JLabel("");
		
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
		GroupLayout gl_cartPanel = new GroupLayout(cartPanel);
		gl_cartPanel.setHorizontalGroup(
			gl_cartPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_cartPanel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_cartPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 811, Short.MAX_VALUE)
						.addGroup(gl_cartPanel.createSequentialGroup()
							.addComponent(maNhanVienThuNganLbl, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(autoIncreaseSpaceLbl_1, GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
						.addGroup(gl_cartPanel.createSequentialGroup()
							.addGroup(gl_cartPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnKhchHng, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_cartPanel.createSequentialGroup()
									.addGap(122)
									.addComponent(soDienThoaiKHTxt, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)))
							.addGap(10)
							.addComponent(autoIncreaseSpaceLbl, GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE))
						.addGroup(gl_cartPanel.createSequentialGroup()
							.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(teniKhachHangTxt, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
							.addGap(71)
							.addComponent(giaoHangChck, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(diaChiTxt, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
						.addGroup(gl_cartPanel.createSequentialGroup()
							.addComponent(lblTngCng, GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
							.addGap(11)
							.addComponent(xacNhanHoaDonBtn, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
					.addGap(22))
		);
		gl_cartPanel.setVerticalGroup(
			gl_cartPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cartPanel.createSequentialGroup()
					.addGap(3)
					.addGroup(gl_cartPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cartPanel.createSequentialGroup()
							.addGap(12)
							.addComponent(maNhanVienThuNganLbl))
						.addComponent(autoIncreaseSpaceLbl_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_cartPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cartPanel.createSequentialGroup()
							.addGap(6)
							.addComponent(lblTnKhchHng))
						.addComponent(soDienThoaiKHTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_cartPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(autoIncreaseSpaceLbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(3)
					.addGroup(gl_cartPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cartPanel.createSequentialGroup()
							.addGap(7)
							.addComponent(lblSinThoi))
						.addComponent(teniKhachHangTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_cartPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(giaoHangChck, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_cartPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(diaChiTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(35)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
					.addGap(13)
					.addGroup(gl_cartPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cartPanel.createSequentialGroup()
							.addGap(4)
							.addComponent(lblTngCng, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(xacNhanHoaDonBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(12))
		);
		
		JLabel lblNewLabel_2_1_1_2_1 = new JLabel("");
		lblNewLabel_2_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_2_1.setForeground(new Color(0, 205, 205));
		lblNewLabel_2_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
							.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 132, Short.MAX_VALUE)))
					.addComponent(lblNewLabel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(0, 0, Short.MAX_VALUE)
					.addComponent(lblNewLabel_2_1_1_2, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2_1_1_2_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(71))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel_2_1_1_2_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2_1_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2_1_1_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2_1_1_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		cartPanel.setLayout(gl_cartPanel);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
					.addGap(21))
		);
		
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
				"m\u00E3 h\u00F3a \u0111\u01A1n", "m\u00E3 kh\u00E1ch h\u00E0ng", "m\u00E3 nh\u00E2n vi\u00EAn", "ng\u00E0y l\u1EADp", "địa chỉ giao hàng", "t\u1ED5ng ti\u1EC1n", "tr\u1EA1ng th\u00E1i"
			}
		));
		scrollPane_2.setViewportView(table);
		
		//Hiển thị danh sách hóa đơn
		loadHoaDon();
	
		MyTextfield timKiemDonHangTxt = new MyTextfield();
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
		//Xử lý sự kiện khi chọn JComboBox
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
//		fromDateChooser.addMouseListener(new MouseAdapter() {
//			public void mouseEntered(MouseEvent e) {
//                JOptionPane.showMessageDialog(null, "hi");
//                System.out.println("hi");
//            }
//		});
		
		JLabel lbln = new JLabel("Đến :");
		lbln.setForeground(Color.CYAN);
		lbln.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyDateChooser toDateChooser = new MyDateChooser();
		toDateChooser.setBackground(new Color(102, 102, 102));
		
		//Xử lý sự kiện nhấn vào nút "lọc" form hóa đơn
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
		//Xử lý sự kiện khi nhấn vào nút "In"
		InHoaDonBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				MessageFormat header = new MessageFormat("Hóa đơn bán hàng");
				MessageFormat footer = new MessageFormat("Page{0, number, integer}");	
				try {
					table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
			
		// Nút này để cập nhật trạng thái, ví dụ từ : đang giao hàng -> đã thanh toán
		MyButton InHoaDonBtn_1 = new MyButton();
		InHoaDonBtn_1.setToolTipText("cập nhật trạng thái hóa đơn");
		InHoaDonBtn_1.setText("cập nhật");
		//Xử lý khi nhấn vào nút "cập nhật" để cập nhật trạng thái hóa đơn
		InHoaDonBtn_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				updateTrangThaiHoaDon(table.getSelectedRow());
			}
		});
		
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
		
		giaoHangChck.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(giaoHangChck.isSelected()) {
					diaChiTxt.setEditable(true);
					diaChiTxt.setBackground(new Color(77,77,77));
				}else {
					diaChiTxt.setEditable(false);
					diaChiTxt.setBackground(new Color(100,100,100));
				}
			}
		});
		demo();
	}
	public void demo() {
		ProductItemPanel.setLayout(new GridLayout(3,4,0,0));
		cartItemPanel.setLayout(new GridLayout(0,1,0,0));
		for(int i = 0; i< 10; i++) {
			ProductItem pi = new ProductItem();
			ProductItemPanel.add(pi);
			cartItemPanel.add(new CartItem());
		}
	}
	//Tạo instance của HoaDonBUS để thực thi các phương thức
	HoaDonBUS hoadonbus = new HoaDonBUS();
	
	//Tạo ArrayList lưu trữ danh sách hóa đơn lấy từ Database
	ArrayList <DTO_HoaDon> arr_hoadon = hoadonbus.get_AllHoaDon();
	
	//Hiển thị danh sách hóa đơn
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
	// Method to update the table with new data
    
}
