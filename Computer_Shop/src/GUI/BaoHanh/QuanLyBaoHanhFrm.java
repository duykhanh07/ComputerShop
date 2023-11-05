package GUI.BaoHanh;

import javax.swing.JPanel;
import java.awt.Color;
import MyDesign.MyTabPane.MyTabbedPaneCustom;
import MyDesign.MyTable.CustomTableCellRenderer;
import MyDesign.MyTable.CustomTableHeaderUI;
import MyDesign.MyComponents.MyTextfield;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JComboBox;
import MyDesign.MyComponents.MyButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JLabel;
import java.awt.Font;
import MyDesign.Calendar.MyDateChooser;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class QuanLyBaoHanhFrm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Create the panel.
	 */
	public QuanLyBaoHanhFrm() {
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
		
		JPanel phieuBaoHanhPanel = new JPanel();
		phieuBaoHanhPanel.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("Phiếu bảo hành", null, phieuBaoHanhPanel, null);
		
		MyTextfield timKiemDonNhapTxt = new MyTextfield();
		timKiemDonNhapTxt.setPreferredSize(new Dimension(180, 35));
		timKiemDonNhapTxt.setColumns(10);
		timKiemDonNhapTxt.setBorder(new EmptyBorder(0, 0, 0, 0));
		timKiemDonNhapTxt.setBackground(new Color(77, 77, 77));
		
		JComboBox timKiemTypeCmbx = new JComboBox();
		timKiemTypeCmbx.setForeground(Color.CYAN);
		timKiemTypeCmbx.setBackground(new Color(102, 102, 102));
		
		MyButton timKiemBtn = new MyButton();
		timKiemBtn.setText("Lọc");
		timKiemBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel auto_increase_spaceLbl = new JLabel("");
		
		JLabel lblNewLabel = new JLabel("Sắp xếp :");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox sortCmbx = new JComboBox();
		sortCmbx.setForeground(Color.CYAN);
		sortCmbx.setBackground(new Color(102, 102, 102));
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(new Color(51,51,51));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		table = new JTable();
		table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		table.getTableHeader().setUI(new CustomTableHeaderUI());
		table.getTableHeader().setFont(new Font("Tahoma",Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"m\u00E3 phi\u1EBFu", "ng\u00E0y nh\u1EADn", "ng\u00E0y tr\u1EA3", "m\u00E3 nh\u00E2n vi\u00EAn"
			}
		));
		scrollPane.setViewportView(table);
		
		MyButton timKiemBtn_1 = new MyButton();
		timKiemBtn_1.setText("Hoàn thành");
		timKiemBtn_1.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JPanel HangSXPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) HangSXPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		HangSXPanel.setToolTipText("các hãng laptop");
		HangSXPanel.setForeground(Color.CYAN);
		HangSXPanel.setBackground(new Color(77, 77, 77));
		
		JCheckBox chckbxHonThnh = new JCheckBox("Đã hoàn thành");
		chckbxHonThnh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxHonThnh.setForeground(Color.CYAN);
		chckbxHonThnh.setBackground(new Color(77, 77, 77));
		HangSXPanel.add(chckbxHonThnh);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("chưa hoàn thành");
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxNewCheckBox_1.setForeground(Color.CYAN);
		chckbxNewCheckBox_1.setBackground(new Color(77, 77, 77));
		HangSXPanel.add(chckbxNewCheckBox_1);
		
		MyButton timKiemBtn_1_1 = new MyButton();
		timKiemBtn_1_1.setText("in");
		timKiemBtn_1_1.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel auto_increase_spaceLbl_2 = new JLabel("");
		GroupLayout gl_phieuBaoHanhPanel = new GroupLayout(phieuBaoHanhPanel);
		gl_phieuBaoHanhPanel.setHorizontalGroup(
			gl_phieuBaoHanhPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_phieuBaoHanhPanel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_phieuBaoHanhPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_phieuBaoHanhPanel.createSequentialGroup()
							.addComponent(timKiemDonNhapTxt, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(timKiemTypeCmbx, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(timKiemBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(50)
							.addComponent(auto_increase_spaceLbl, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(sortCmbx, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_phieuBaoHanhPanel.createSequentialGroup()
							.addComponent(lblT, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(fromDateChooser, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lbln, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(toDateChooser, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(auto_increase_spaceLbl_2, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
							.addGap(21)
							.addComponent(HangSXPanel, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
						.addGroup(gl_phieuBaoHanhPanel.createSequentialGroup()
							.addComponent(timKiemBtn_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(timKiemBtn_1_1, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
					.addGap(9))
		);
		gl_phieuBaoHanhPanel.setVerticalGroup(
			gl_phieuBaoHanhPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_phieuBaoHanhPanel.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_phieuBaoHanhPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_phieuBaoHanhPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(timKiemDonNhapTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_phieuBaoHanhPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(timKiemTypeCmbx, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addComponent(timKiemBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_phieuBaoHanhPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(auto_increase_spaceLbl, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_phieuBaoHanhPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_phieuBaoHanhPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(sortCmbx, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addGroup(gl_phieuBaoHanhPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblT, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(fromDateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbln, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(toDateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(auto_increase_spaceLbl_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_phieuBaoHanhPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(HangSXPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
					.addGap(11)
					.addGroup(gl_phieuBaoHanhPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(timKiemBtn_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(timKiemBtn_1_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(14))
		);
		phieuBaoHanhPanel.setLayout(gl_phieuBaoHanhPanel);
		
		JPanel LapPhieuBaoHanhPanel = new JPanel();
		LapPhieuBaoHanhPanel.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("Lập phiếu", null, LapPhieuBaoHanhPanel, null);
		
		MyTextfield timKiemDonNhapTxt_1 = new MyTextfield();
		timKiemDonNhapTxt_1.setPreferredSize(new Dimension(180, 35));
		timKiemDonNhapTxt_1.setColumns(10);
		timKiemDonNhapTxt_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		timKiemDonNhapTxt_1.setBackground(new Color(77, 77, 77));
		
		JComboBox timKiemTypeCmbx_1 = new JComboBox();
		timKiemTypeCmbx_1.setForeground(Color.CYAN);
		timKiemTypeCmbx_1.setBackground(new Color(102, 102, 102));
		
		MyButton timkiemBtn = new MyButton();
		timkiemBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		timkiemBtn.setText("Lọc");
		timkiemBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JComboBox sortCmbx_1 = new JComboBox();
		sortCmbx_1.setForeground(Color.CYAN);
		sortCmbx_1.setBackground(new Color(102, 102, 102));
		
		JLabel lblNewLabel_1 = new JLabel("Sắp xếp :");
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.getViewport().setBackground(new Color(51,51,51));
		
		table_1 = new JTable();
		table_1.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		table_1.getTableHeader().setUI(new CustomTableHeaderUI());
		table_1.getTableHeader().setFont(new Font("Tahoma",Font.PLAIN,15));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"m\u00E3 h\u00F3a \u0111\u01A1n", "m\u00E3 s\u1EA3n ph\u1EA9m", "H\u1EA1n b\u1EA3o h\u00E0nh"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_2.getViewport().setBackground(new Color(51,51,51));
		
		table_2 = new JTable();
		table_2.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		table_2.getTableHeader().setUI(new CustomTableHeaderUI());
		table_2.getTableHeader().setFont(new Font("Tahoma",Font.PLAIN, 15));
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"m\u00E3 h\u00F3a \u0111\u01A1n", "m\u00E3 s\u1EA3n ph\u1EA9m", "l\u1ED7i", "h\u01B0\u1EDBng gi\u1EA3i quy\u1EBFt"
			}
		));
		scrollPane_2.setViewportView(table_2);
		
		MyButton themCTHDBtn = new MyButton();
		themCTHDBtn.setText("Thêm");
		themCTHDBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton xoaCTHDBtn = new MyButton();
		xoaCTHDBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		xoaCTHDBtn.setText("Xóa");
		xoaCTHDBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton themPhieuBaoHanhBtn = new MyButton();
		themPhieuBaoHanhBtn.setText("thêm phiếu");
		themPhieuBaoHanhBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyTextfield timKiemDonNhapTxt_1_1 = new MyTextfield();
		timKiemDonNhapTxt_1_1.setPreferredSize(new Dimension(180, 35));
		timKiemDonNhapTxt_1_1.setColumns(10);
		timKiemDonNhapTxt_1_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		timKiemDonNhapTxt_1_1.setBackground(new Color(77, 77, 77));
		
		JLabel lblNewLabel_1_1 = new JLabel("Lỗi :");
		lblNewLabel_1_1.setForeground(Color.CYAN);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Hướng giải quyết :");
		lblNewLabel_1_1_1.setForeground(Color.CYAN);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield timKiemDonNhapTxt_1_1_1 = new MyTextfield();
		timKiemDonNhapTxt_1_1_1.setPreferredSize(new Dimension(180, 35));
		timKiemDonNhapTxt_1_1_1.setColumns(10);
		timKiemDonNhapTxt_1_1_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		timKiemDonNhapTxt_1_1_1.setBackground(new Color(77, 77, 77));
		
		JLabel auto_increase_spaceLbl_1 = new JLabel("");
		
		MyButton mbtnLmMi = new MyButton();
		mbtnLmMi.setText("làm mới");
		mbtnLmMi.setIcon(new ImageIcon(QuanLyBaoHanhFrm.class.getResource("/assets/reset.png")));
		mbtnLmMi.setHorizontalTextPosition(SwingConstants.LEADING);
		GroupLayout gl_LapPhieuBaoHanhPanel = new GroupLayout(LapPhieuBaoHanhPanel);
		gl_LapPhieuBaoHanhPanel.setHorizontalGroup(
			gl_LapPhieuBaoHanhPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LapPhieuBaoHanhPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(timKiemDonNhapTxt_1, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(timKiemTypeCmbx_1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(timkiemBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(mbtnLmMi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(auto_increase_spaceLbl_1, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(sortCmbx_1, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addGap(9))
				.addGroup(gl_LapPhieuBaoHanhPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
					.addGap(9))
				.addGroup(gl_LapPhieuBaoHanhPanel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_LapPhieuBaoHanhPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_LapPhieuBaoHanhPanel.createSequentialGroup()
							.addGap(40)
							.addComponent(timKiemDonNhapTxt_1_1, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(timKiemDonNhapTxt_1_1_1, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(themCTHDBtn, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(xoaCTHDBtn, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_LapPhieuBaoHanhPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
					.addGap(9))
				.addGroup(gl_LapPhieuBaoHanhPanel.createSequentialGroup()
					.addGap(671)
					.addComponent(themPhieuBaoHanhBtn, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
		);
		gl_LapPhieuBaoHanhPanel.setVerticalGroup(
			gl_LapPhieuBaoHanhPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LapPhieuBaoHanhPanel.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_LapPhieuBaoHanhPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_LapPhieuBaoHanhPanel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(auto_increase_spaceLbl_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(timKiemDonNhapTxt_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(timKiemTypeCmbx_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addComponent(timkiemBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
							.addComponent(sortCmbx_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addComponent(mbtnLmMi, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
					.addGap(10)
					.addGroup(gl_LapPhieuBaoHanhPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_LapPhieuBaoHanhPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(timKiemDonNhapTxt_1_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_LapPhieuBaoHanhPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(timKiemDonNhapTxt_1_1_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_LapPhieuBaoHanhPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(themCTHDBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_LapPhieuBaoHanhPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(xoaCTHDBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addGap(7)
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(themPhieuBaoHanhBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(4))
		);
		LapPhieuBaoHanhPanel.setLayout(gl_LapPhieuBaoHanhPanel);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
					.addGap(23))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
					.addGap(22))
		);
		setLayout(groupLayout);

	}
}
