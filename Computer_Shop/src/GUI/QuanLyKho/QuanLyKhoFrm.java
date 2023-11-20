package GUI.QuanLyKho;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import MyDesign.Calendar.MyDateChooser;
import MyDesign.MyComponents.MyButton;
import MyDesign.MyComponents.MyTextfield;
import MyDesign.MyTabPane.MyTabbedPaneCustom;
import MyDesign.MyTable.CustomTableCellRenderer;
import MyDesign.MyTable.CustomTableHeaderUI;

import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import BUS.NhaCungCapBUS;
import BUS.QuanLyTonKhoBUS;
import DTO.DTO_NhaCungCap;

import javax.swing.border.LineBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.*;
import java.awt.print.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class QuanLyKhoFrm extends JPanel {

	private static final long serialVersionUID = 1L;
	private MyTextfield timKiemDonNhapTxt;
	private MyButton timKiemBtn;
	private MyDateChooser fromDateChooser;
	private JScrollPane scrollPane;
	private JTable donNhapTable;
	private JTable tonKhoTable;
	private JTable table;

	private QuanLyTonKhoBUS qltk_bus = new QuanLyTonKhoBUS();
	/**
	 * Create the panel.
	 */
	
	public QuanLyKhoFrm() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		setBackground(new Color(77, 77, 77));
		
		MyTabbedPaneCustom tabbedPane = new MyTabbedPaneCustom();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
					.addGap(22))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
					.addGap(22))
		);
		
		JPanel donNhapPanel = new JPanel();
		donNhapPanel.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("Đơn nhập", null, donNhapPanel, null);
		
		timKiemDonNhapTxt = new MyTextfield();
		timKiemDonNhapTxt.setBackground(new Color(77, 77, 77));
		timKiemDonNhapTxt.setBorder(new EmptyBorder(0, 0, 0, 0));
		timKiemDonNhapTxt.setPreferredSize(new Dimension(180, 35));
		timKiemDonNhapTxt.setColumns(10);
		
		JComboBox timKiemTypeCmbx = new JComboBox();
		timKiemTypeCmbx.setForeground(new Color(0, 255, 255));
		timKiemTypeCmbx.setBackground(new Color(102, 102, 102));
		
		timKiemBtn = new MyButton();
		timKiemBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		timKiemBtn.setText("Lọc");
		timKiemBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JComboBox sortCmbx = new JComboBox();
		sortCmbx.setBackground(new Color(102, 102, 102));
		sortCmbx.setForeground(new Color(0, 255, 255));
		
		JLabel lblNewLabel = new JLabel("Sắp xếp :");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel auto_increase_spaceLbl = new JLabel("");
		
		JLabel lblT = new JLabel("Từ :");
		lblT.setForeground(Color.CYAN);
		lblT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lbln = new JLabel("Đến :");
		lbln.setForeground(Color.CYAN);
		lbln.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		fromDateChooser = new MyDateChooser();
		fromDateChooser.setBackground(new Color(102, 102, 102));
		
		MyDateChooser toDateChooser = new MyDateChooser();
		toDateChooser.setBackground(new Color(102, 102, 102));
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getViewport().setBackground(new Color(51,51,51));
		
		JLabel auto_increase_spaceLbl_1 = new JLabel("");
		
		MyButton themDonNhapBtn = new MyButton();
		themDonNhapBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ThemDonNhapFrm().setVisible(true);
			}
		});
		themDonNhapBtn.setText("Thêm");
		themDonNhapBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton inBtn = new MyButton();
		inBtn.setText("In");
		inBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton chiTietBtn = new MyButton();
		chiTietBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChiTietDonNhap().setVisible(true);
			}
		});
		chiTietBtn.setText("Chi tiết");
		chiTietBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel auto_increase_spaceLbl_2 = new JLabel("");
		
		MyButton importBtn = new MyButton();
		importBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		importBtn.setText("Nhập Excel");
		importBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		donNhapTable = new JTable();
		donNhapTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"DN001", "NV00001", "NCC002", "15000000", "15/6/2023 16:31:32"},
			},
			new String[] {
				"m\u00E3 \u0111\u01A1n nh\u1EADp", "m\u00E3 nh\u00E2n vi\u00EAn", "m\u00E3 nh\u00E0 cung c\u1EA5p", "t\u1ED5ng ti\u1EC1n", "ng\u00E0y nh\u1EADp"
			}
		));
		donNhapTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		donNhapTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		donNhapTable.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		
		scrollPane.setViewportView(donNhapTable);
		
		MyButton mbtnLmMi = new MyButton();
		mbtnLmMi.setIcon(new ImageIcon(QuanLyKhoFrm.class.getResource("/assets/reset.png")));
		mbtnLmMi.setText("làm mới");
		mbtnLmMi.setHorizontalTextPosition(SwingConstants.LEADING);
		GroupLayout gl_donNhapPanel = new GroupLayout(donNhapPanel);
		gl_donNhapPanel.setHorizontalGroup(
			gl_donNhapPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_donNhapPanel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_donNhapPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_donNhapPanel.createSequentialGroup()
							.addComponent(timKiemDonNhapTxt, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(timKiemTypeCmbx, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(timKiemBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(auto_increase_spaceLbl, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(sortCmbx, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_donNhapPanel.createSequentialGroup()
							.addComponent(lblT, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(fromDateChooser, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lbln, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(toDateChooser, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 269, Short.MAX_VALUE)
							.addComponent(mbtnLmMi, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
						.addGroup(gl_donNhapPanel.createSequentialGroup()
							.addComponent(auto_increase_spaceLbl_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(themDonNhapBtn, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(inBtn, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(chiTietBtn, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(159)
							.addComponent(auto_increase_spaceLbl_2, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
							.addGap(113)
							.addComponent(importBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(40))
		);
		gl_donNhapPanel.setVerticalGroup(
			gl_donNhapPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_donNhapPanel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_donNhapPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(timKiemDonNhapTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_donNhapPanel.createSequentialGroup()
							.addGap(4)
							.addComponent(timKiemTypeCmbx, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_donNhapPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(timKiemBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addComponent(auto_increase_spaceLbl, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(sortCmbx, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_donNhapPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblT, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(fromDateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbln, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(toDateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(mbtnLmMi, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
					.addGap(11)
					.addGroup(gl_donNhapPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_donNhapPanel.createSequentialGroup()
							.addGap(7)
							.addComponent(auto_increase_spaceLbl_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_donNhapPanel.createSequentialGroup()
							.addGap(7)
							.addComponent(themDonNhapBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_donNhapPanel.createSequentialGroup()
							.addGap(7)
							.addComponent(inBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_donNhapPanel.createSequentialGroup()
							.addGap(7)
							.addComponent(chiTietBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(auto_increase_spaceLbl_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_donNhapPanel.createSequentialGroup()
							.addGap(7)
							.addComponent(importBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(17))
		);
		donNhapPanel.setLayout(gl_donNhapPanel);
		
		JTableHeader tableHeader = donNhapTable.getTableHeader();
		tableHeader.setUI(new CustomTableHeaderUI());
		tableHeader.setFont(new Font("Tahoma", Font.PLAIN, 15));

		
		JPanel tonKhoPanel = new JPanel();
		tonKhoPanel.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("Tồn kho", null, tonKhoPanel, null);
		
		// TODO : LẤY DANH SÁCH TỒN KHO
//		SELECT DSNHAP.masp,sp.tensp, DSNHAP.nhap - DSDOANHSO.doanhso AS soluongton
//		FROM
//		sanpham AS sp
//		JOIN
//		(SELECT ctdn.masp, SUM(ctdn.solg) AS nhap
//		FROM ctdn
//		GROUP BY ctdn.masp) AS DSNHAP
//		ON DSNHAP.masp = sp.masp
//		JOIN
//		(SELECT cthd.masp, SUM(cthd.solg) AS doanhso
//		FROM cthd
//		GROUP BY cthd.masp) AS DSDOANHSO
//		ON DSNHAP.masp = DSDOANHSO.masp
//		GROUP BY DSNHAP. masp
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBorder(new LineBorder(new Color(130, 135, 144)));
		scrollPane_1.getViewport().setBackground(new Color(51,51,51));
		
		JLabel auto_increase_spaceLbl_3 = new JLabel("");
		
		tonKhoTable = new JTable();
		tonKhoTable.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		tonKhoTable.getTableHeader().setUI(new CustomTableHeaderUI());
		tonKhoTable.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		tonKhoTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"m\u00E3 s\u1EA3n ph\u1EA9m", "t\u00EAn s\u1EA3n ph\u1EA9m", "s\u1ED1 l\u01B0\u1EE3ng"
			}
		));
		scrollPane_1.setViewportView(tonKhoTable);
		
		MyTextfield timKiemTonKhoTxt = new MyTextfield();
		timKiemTonKhoTxt.setPreferredSize(new Dimension(180, 35));
		timKiemTonKhoTxt.setColumns(10);
		timKiemTonKhoTxt.setBorder(new EmptyBorder(0, 10, 0, 0));
		timKiemTonKhoTxt.setBackground(new Color(77, 77, 77));
		
		JComboBox timKiemTypeCmbx_1 = new JComboBox();
		timKiemTypeCmbx_1.setModel(new DefaultComboBoxModel(new String[] {"----------", "theo mã sản phẩm", "theo tên sản phẩm"}));
		timKiemTypeCmbx_1.setForeground(Color.CYAN);
		timKiemTypeCmbx_1.setBackground(new Color(102, 102, 102));
		
		MyButton timKiemBtn_1 = new MyButton();
		timKiemBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiemTonKho(timKiemTonKhoTxt.getText().toLowerCase(), timKiemTypeCmbx_1.getSelectedIndex());
			}
		});
		
		timKiemTonKhoTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					timKiemTonKho(timKiemTonKhoTxt.getText().toLowerCase(), timKiemTypeCmbx_1.getSelectedIndex());
				}
			}
		});
		timKiemBtn_1.setText("Lọc");
		timKiemBtn_1.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel lblNewLabel_1 = new JLabel("Sắp xếp :");
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox sortCmbx_1 = new JComboBox();
		sortCmbx_1.setModel(new DefaultComboBoxModel(new String[] {"----------", "tên sản phẩm(A->Z)", "tên sản phẩm(Z->A)", "số lượng (thấp -> cao)", "số lượng (cao -> thấp)"}));
		sortCmbx_1.setForeground(Color.CYAN);
		sortCmbx_1.setBackground(new Color(102, 102, 102));
		
		MyButton mbtnLmMi_1 = new MyButton();
		mbtnLmMi_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qltk_bus = new QuanLyTonKhoBUS();
				loadTonKho();
			}
		});
		mbtnLmMi_1.setIcon(new ImageIcon(QuanLyKhoFrm.class.getResource("/assets/reset.png")));
		mbtnLmMi_1.setText("làm mới");
		mbtnLmMi_1.setHorizontalTextPosition(SwingConstants.LEADING);
		GroupLayout gl_tonKhoPanel = new GroupLayout(tonKhoPanel);
		gl_tonKhoPanel.setHorizontalGroup(
			gl_tonKhoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tonKhoPanel.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_tonKhoPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tonKhoPanel.createSequentialGroup()
							.addComponent(timKiemTonKhoTxt, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(timKiemTypeCmbx_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(timKiemBtn_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(mbtnLmMi_1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(auto_increase_spaceLbl_3, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
							.addGap(28)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(sortCmbx_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE))
					.addGap(38))
		);
		gl_tonKhoPanel.setVerticalGroup(
			gl_tonKhoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tonKhoPanel.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_tonKhoPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(timKiemTonKhoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_tonKhoPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(timKiemTypeCmbx_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(sortCmbx_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(auto_increase_spaceLbl_3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_tonKhoPanel.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_tonKhoPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(mbtnLmMi_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(timKiemBtn_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))))
					.addGap(12)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
					.addGap(27))
		);
		tonKhoPanel.setLayout(gl_tonKhoPanel);
		
		JPanel donNhapPanel_1 = new JPanel();
		donNhapPanel_1.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("Nhà cung cấp", null, donNhapPanel_1, null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.getViewport().setBackground(new Color(51,51,51));
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		MyTextfield timKiemDonNhapTxt_1 = new MyTextfield();
		timKiemDonNhapTxt_1.setPreferredSize(new Dimension(180, 35));
		timKiemDonNhapTxt_1.setColumns(10);
		timKiemDonNhapTxt_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		timKiemDonNhapTxt_1.setBackground(new Color(77, 77, 77));
		
		JComboBox timKiemTypeCmbx_2 = new JComboBox();
		timKiemTypeCmbx_2.setModel(new DefaultComboBoxModel(new String[] {"----------", "theo mã nhà cung cấp", "theo tên nhà cung cấp", "theo số điện thoại", "theo địa chỉ"}));
		timKiemTypeCmbx_2.setForeground(Color.CYAN);
		timKiemTypeCmbx_2.setBackground(new Color(102, 102, 102));
		
		MyButton timKiemBtn_2 = new MyButton();
		timKiemBtn_2.setText("Lọc");
		timKiemBtn_2.setHorizontalTextPosition(SwingConstants.LEADING);
		//Xử lý sự kiện nhấn vào nút lọc form nhà cung cấp
		timKiemBtn_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				timKiemNhaCungCap(timKiemDonNhapTxt_1.getText().toLowerCase(), timKiemTypeCmbx_2.getSelectedIndex());
			}
		});
		
		
		JLabel auto_increase_spaceLbl_4 = new JLabel("");
		
		JLabel lblNewLabel_2 = new JLabel("Sắp xếp :");
		lblNewLabel_2.setForeground(Color.CYAN);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox sortCmbx_2 = new JComboBox();
		sortCmbx_2.setModel(new DefaultComboBoxModel(new String[] {"----------", "tên nhà cung cấp(A->Z)", "địa chỉ (A->Z)"}));
		sortCmbx_2.setForeground(Color.CYAN);
		sortCmbx_2.setBackground(new Color(102, 102, 102));
		
		//Xử lý sự kiện hiển thị danh sách nhà cung cấp theo kiểu sắp xếp đã chọn
		sortCmbx_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				sapXepNhaCungCap(sortCmbx_2.getSelectedIndex());
			}
		});
		
		JLabel auto_increase_spaceLbl_1_1 = new JLabel("");
		
		MyButton themDonNhapBtn_1 = new MyButton();
		themDonNhapBtn_1.setText("Thêm");
		themDonNhapBtn_1.setHorizontalTextPosition(SwingConstants.LEADING);
		//Hiển thị form thêm nhà cung cấp
		themDonNhapBtn_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new ThemNhaCungCap().setVisible(true);
			}
		});
		
		MyButton inBtn_1 = new MyButton();
		//In thông tin trên JTable
		inBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				MessageFormat header = new MessageFormat("Nhà Cung Cấp");
				MessageFormat footer = new MessageFormat("Page{0, number, integer}");	
				try {
					table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		inBtn_1.setText("In");
		inBtn_1.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel auto_increase_spaceLbl_2_1 = new JLabel("");
		
		MyButton importBtn_1 = new MyButton();
		importBtn_1.setText("Nhập Excel");
		importBtn_1.setHorizontalTextPosition(SwingConstants.LEADING);
		//Nhập dữ liệu vào từ Excel
		importBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				//ArrayList lưu trữ các phần tử lấy từ Excel
				ArrayList <DTO_NhaCungCap> arr_temp = new ArrayList<DTO_NhaCungCap>();
				
				//Arraylist chứa mã nhà cung cấp có trong Database
				ArrayList <String> ds_mancc = nhacungcapbus.get_mancc();
				
				//Khởi tạo các instance để đọc dữ liệu từ file Excel
				File excelFile;
				Workbook wb;
				Sheet sheet;
				Row row;
				Cell cell;
				
				//Khởi tạo instance xác định file Excel đầu vào
				FileInputStream fis = null;
				
				//Khởi tạo instance cho phép chọn file
				JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\USER\\Desktop");
				excelFileChooser.setDialogTitle("Chọn File Excel");
				int excelChooser = excelFileChooser.showOpenDialog(null);
				
				if(excelChooser == JFileChooser.APPROVE_OPTION)
				{
					try {
						excelFile = excelFileChooser.getSelectedFile();
						fis = new FileInputStream(excelFile);
						wb = WorkbookFactory.create(fis);
						sheet = wb.getSheet("Sheet1");
						
						for(int i = 1; i <= sheet.getLastRowNum(); i++)
						{
							row = sheet.getRow(i);
							cell = row.getCell(0);
							String mancc = cell.getStringCellValue();
							cell = row.getCell(1);
							String tenncc = cell.getStringCellValue();
							cell = row.getCell(2);
							String sdt = cell.getStringCellValue();
							cell = row.getCell(3);
							String diachi = cell.getStringCellValue();
							
							if(ds_mancc.contains(mancc))
							{
								JOptionPane.showMessageDialog(null, "Nhập file Excel không thành công!!! Mã nhà cung cấp " + mancc + " ở dòng " + (i+1) + " đã tồn tại!!!");
								return;
							}
							else
								arr_temp.add(new DTO_NhaCungCap(mancc, tenncc, sdt, diachi));
						}
						
						for(DTO_NhaCungCap x: arr_temp)
							nhacungcapbus.insert_NhaCungCap(x);
						
						//Update dữ liệu từ Database cho biến arr_ncc sau khi nhập thêm nhà cung cấp
						arr_ncc = nhacungcapbus.get_AllNhaCungCap();
						loadNhaCungCap();
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				;
			}
		});
		
		MyButton mbtnLmMi_2 = new MyButton();
		mbtnLmMi_2.setIcon(new ImageIcon(QuanLyKhoFrm.class.getResource("/assets/reset.png")));
		mbtnLmMi_2.setText("làm mới");
		mbtnLmMi_2.setHorizontalTextPosition(SwingConstants.LEADING);
		
		//Làm mới form nhà cung cấp
		mbtnLmMi_2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				timKiemDonNhapTxt_1.setText("");
				timKiemTypeCmbx_2.setSelectedIndex(0);
				sortCmbx_2.setSelectedIndex(0);
			}
		});
		
		GroupLayout gl_donNhapPanel_1 = new GroupLayout(donNhapPanel_1);
		gl_donNhapPanel_1.setHorizontalGroup(
			gl_donNhapPanel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_donNhapPanel_1.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_donNhapPanel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
						.addGroup(gl_donNhapPanel_1.createSequentialGroup()
							.addComponent(timKiemDonNhapTxt_1, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(timKiemTypeCmbx_2, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(timKiemBtn_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(mbtnLmMi_2, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(auto_increase_spaceLbl_4, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(sortCmbx_2, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_donNhapPanel_1.createSequentialGroup()
							.addComponent(auto_increase_spaceLbl_1_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(themDonNhapBtn_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(inBtn_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(269)
							.addComponent(auto_increase_spaceLbl_2_1, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
							.addGap(113)
							.addComponent(importBtn_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(40))
		);
		gl_donNhapPanel_1.setVerticalGroup(
			gl_donNhapPanel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_donNhapPanel_1.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_donNhapPanel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(timKiemDonNhapTxt_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_donNhapPanel_1.createSequentialGroup()
							.addGap(4)
							.addComponent(timKiemTypeCmbx_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(sortCmbx_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(auto_increase_spaceLbl_4, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_donNhapPanel_1.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_donNhapPanel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(mbtnLmMi_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(timKiemBtn_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
					.addGap(11)
					.addGroup(gl_donNhapPanel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_donNhapPanel_1.createSequentialGroup()
							.addGap(7)
							.addComponent(auto_increase_spaceLbl_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_donNhapPanel_1.createSequentialGroup()
							.addGap(7)
							.addComponent(themDonNhapBtn_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_donNhapPanel_1.createSequentialGroup()
							.addGap(7)
							.addComponent(inBtn_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(auto_increase_spaceLbl_2_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_donNhapPanel_1.createSequentialGroup()
							.addGap(7)
							.addComponent(importBtn_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(17))
		);
		
		table = new JTable();
		table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		table.getTableHeader().setUI(new CustomTableHeaderUI());
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"m\u00E3 nh\u00E0 cung c\u1EA5p", "t\u00EAn nh\u00E0 cung c\u1EA5p", "s\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0111\u1ECBa ch\u1EC9"
			}
		));
		scrollPane_2.setViewportView(table);
		donNhapPanel_1.setLayout(gl_donNhapPanel_1);
		setLayout(groupLayout);
		
		//Hiển thị danh sách nhà cung cấp
		loadNhaCungCap();
		
		//Hiển thị danh sách tồn kho
		initComponents();
		loadTonKho();
		
		sortCmbx_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sapXepTonKho(sortCmbx_1.getSelectedIndex());
			}
		});
	}
	public void initComponents() {
		setMinimumSize(new Dimension(880, 595));
		setSize(880,595);
	}
	public void loadTonKho() {
		DefaultTableModel model = (DefaultTableModel)tonKhoTable.getModel();
		model.setRowCount(0);
		for(int i =0; i< qltk_bus.ds_hienThi.size(); i++) {
			model.addRow(new Object[] {qltk_bus.ds_hienThi.get(i).getMasp(), qltk_bus.ds_hienThi.get(i).getTensp(), qltk_bus.ds_hienThi.get(i).getSoluongton()});
		}
	}
	public void sapXepTonKho(int selectedIndex) {
		qltk_bus.sapXepTonKho(selectedIndex);
		loadTonKho();
	}
	public void timKiemTonKho(String timkiemStr, int selectedIndex) {
		if(timkiemStr.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Bạn phải điền thông tin muốn tìm");
		}else {
			qltk_bus.timKiemTonKho(timkiemStr, selectedIndex);
			loadTonKho();
		}
	}
	
	//Khởi tạo instance NhaCungCapBUS để thực thi phương thức
	NhaCungCapBUS nhacungcapbus = new NhaCungCapBUS();
	//Biến lưu trữ dữ liệu hiện tại trên bảng danh sách nhà cung cấp
	ArrayList <DTO_NhaCungCap> arr_ncc = nhacungcapbus.get_AllNhaCungCap();
	
	
	//Form nhà cung cấp
	//Hiển thị danh sách nhà cung cấp
	public void loadNhaCungCap()
	{
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for(DTO_NhaCungCap x: arr_ncc)
		{
			model.addRow(new Object[] {x.getMancc(), x.getTenncc(), x.getSdt(), x.getDiachi()});
		}
	}
	
	//Tìm kiếm nhà cung cấp
	public void timKiemNhaCungCap(String timKiemStr, int selectedIndex)
	{
		if(timKiemStr.equalsIgnoreCase(""))
			JOptionPane.showMessageDialog(null, "Bạn phải điền thông tin muốn tìm");
		else
		{
			arr_ncc = nhacungcapbus.timKiemNhaCungCap(timKiemStr, selectedIndex);
		}
		loadNhaCungCap();
	}
	
	//Sắp xếp danh sách nhà cung cấp
	public void sapXepNhaCungCap(int selectedIndex)
	{		
		switch (selectedIndex)
		{
		case 1:
			Collections.sort(arr_ncc, (o1, o2) -> o1.getTenncc().compareToIgnoreCase(o2.getTenncc()));
			loadNhaCungCap();
			break;
		case 2:
			Collections.sort(arr_ncc, (o1, o2) -> o1.getDiachi().compareToIgnoreCase(o2.getDiachi()));
			loadNhaCungCap();
			break;
		default:
			arr_ncc = nhacungcapbus.get_AllNhaCungCap();
			loadNhaCungCap();
		}
	}
}
