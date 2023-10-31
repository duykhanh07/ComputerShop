package GUI.QuanLyKho;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.border.LineBorder;
import javax.swing.ScrollPaneConstants;

public class QuanLyKhoFrm extends JPanel {

	private static final long serialVersionUID = 1L;
	private MyTextfield timKiemDonNhapTxt;
	private MyButton timKiemBtn;
	private MyDateChooser fromDateChooser;
	private JScrollPane scrollPane;
	private JTable donNhapTable;
	private JTable tonKhoTable;

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
		timKiemBtn.setBounds(new Rectangle(0, 0, 44, 35));
		
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
		themDonNhapBtn.setBounds(new Rectangle(0, 0, 44, 35));
		
		MyButton inBtn = new MyButton();
		inBtn.setText("In");
		inBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		inBtn.setBounds(new Rectangle(0, 0, 44, 35));
		
		MyButton chiTietBtn = new MyButton();
		chiTietBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChiTietDonNhap().setVisible(true);
			}
		});
		chiTietBtn.setText("Chi tiết");
		chiTietBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		chiTietBtn.setBounds(new Rectangle(0, 0, 44, 35));
		
		JLabel auto_increase_spaceLbl_2 = new JLabel("");
		
		MyButton importBtn = new MyButton();
		importBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		importBtn.setText("Nhập Excel");
		importBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		importBtn.setBounds(new Rectangle(0, 0, 44, 35));
		GroupLayout gl_donNhapPanel = new GroupLayout(donNhapPanel);
		gl_donNhapPanel.setHorizontalGroup(
			gl_donNhapPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_donNhapPanel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_donNhapPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_donNhapPanel.createSequentialGroup()
							.addGroup(gl_donNhapPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_donNhapPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(timKiemDonNhapTxt, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(timKiemTypeCmbx, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_donNhapPanel.createSequentialGroup()
									.addComponent(lblT, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(fromDateChooser, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_donNhapPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_donNhapPanel.createSequentialGroup()
									.addGap(2)
									.addComponent(timKiemBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(auto_increase_spaceLbl, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(sortCmbx, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
									.addGap(40))
								.addGroup(gl_donNhapPanel.createSequentialGroup()
									.addComponent(lbln, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(toDateChooser, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))
						.addGroup(gl_donNhapPanel.createSequentialGroup()
							.addGroup(gl_donNhapPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_donNhapPanel.createSequentialGroup()
									.addComponent(auto_increase_spaceLbl_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(themDonNhapBtn, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(inBtn, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(chiTietBtn, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addGap(159)
									.addComponent(auto_increase_spaceLbl_2, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
									.addGap(113)
									.addComponent(importBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE))
							.addGap(40))))
		);
		gl_donNhapPanel.setVerticalGroup(
			gl_donNhapPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_donNhapPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_donNhapPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(sortCmbx, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_donNhapPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(timKiemDonNhapTxt, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addComponent(timKiemTypeCmbx, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addComponent(timKiemBtn, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
						.addComponent(auto_increase_spaceLbl, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_donNhapPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(toDateChooser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblT, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
						.addComponent(lbln, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
						.addComponent(fromDateChooser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_donNhapPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(auto_increase_spaceLbl_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(inBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(importBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(chiTietBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_donNhapPanel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(auto_increase_spaceLbl_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(themDonNhapBtn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
					.addGap(17))
		);
		
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
		donNhapPanel.setLayout(gl_donNhapPanel);
		
		JTableHeader tableHeader = donNhapTable.getTableHeader();
		tableHeader.setUI(new CustomTableHeaderUI());
		tableHeader.setFont(new Font("Tahoma", Font.PLAIN, 18));

		
		JPanel tonKhoPanel = new JPanel();
		tonKhoPanel.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("Tồn kho", null, tonKhoPanel, null);
		
		JComboBox timKiemTypeCmbx_1 = new JComboBox();
		timKiemTypeCmbx_1.setBackground(new Color(102, 102, 102));
		timKiemTypeCmbx_1.setForeground(new Color(0, 255, 255));
		
		MyTextfield timKiemTonKhoBtn = new MyTextfield();
		timKiemTonKhoBtn.setPreferredSize(new Dimension(180, 35));
		timKiemTonKhoBtn.setColumns(10);
		timKiemTonKhoBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		timKiemTonKhoBtn.setBackground(new Color(77, 77, 77));
		
		MyButton timKiemBtn_1 = new MyButton();
		timKiemBtn_1.setText("Lọc");
		timKiemBtn_1.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel lblNewLabel_1 = new JLabel("Sắp xếp :");
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox sortCmbx_1 = new JComboBox();
		sortCmbx_1.setBackground(new Color(102, 102, 102));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBorder(new LineBorder(new Color(130, 135, 144)));
		scrollPane_1.getViewport().setBackground(new Color(51,51,51));
		
		JLabel auto_increase_spaceLbl_3 = new JLabel("");
		
		tonKhoTable = new JTable();
		tonKhoTable.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		tonKhoTable.getTableHeader().setUI(new CustomTableHeaderUI());
		tonKhoTable.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
		tonKhoTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"m\u00E3 s\u1EA3n ph\u1EA9m", "t\u00EAn s\u1EA3n ph\u1EA9m", "s\u1ED1 l\u01B0\u1EE3ng"
			}
		));
		scrollPane_1.setViewportView(tonKhoTable);
		GroupLayout gl_tonKhoPanel = new GroupLayout(tonKhoPanel);
		gl_tonKhoPanel.setHorizontalGroup(
			gl_tonKhoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tonKhoPanel.createSequentialGroup()
					.addGap(22)
					.addComponent(timKiemTonKhoBtn, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(timKiemTypeCmbx_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(timKiemBtn_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(auto_increase_spaceLbl_3, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(sortCmbx_1, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addGap(38))
				.addGroup(gl_tonKhoPanel.createSequentialGroup()
					.addGap(21)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
					.addGap(38))
		);
		gl_tonKhoPanel.setVerticalGroup(
			gl_tonKhoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tonKhoPanel.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_tonKhoPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tonKhoPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(timKiemTonKhoBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_tonKhoPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(timKiemTypeCmbx_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addComponent(timKiemBtn_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(auto_increase_spaceLbl_3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_tonKhoPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_tonKhoPanel.createSequentialGroup()
							.addGap(6)
							.addComponent(sortCmbx_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addGap(8)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
					.addGap(27))
		);
		tonKhoPanel.setLayout(gl_tonKhoPanel);
		setLayout(groupLayout);
		
		initComponents();
	}
	public void initComponents() {
		setMinimumSize(new Dimension(880, 595));
		setSize(880,595);
	}
}
