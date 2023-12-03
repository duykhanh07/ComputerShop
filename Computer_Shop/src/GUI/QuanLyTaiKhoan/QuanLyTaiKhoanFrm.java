package GUI.QuanLyTaiKhoan;

import javax.swing.JPanel;
import MyDesign.MyTabPane.MyTabbedPaneCustom;
import MyDesign.MyTable.CustomTableCellRenderer;
import MyDesign.MyTable.CustomTableHeaderUI;

import java.awt.Color;
import MyDesign.MyComponents.MyTextfield;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JComboBox;
import MyDesign.MyComponents.MyButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.NhanVienBUS;
import BUS.TaiKhoanBUS;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class QuanLyTaiKhoanFrm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private TaiKhoanBUS tk_bus = new TaiKhoanBUS();

	/**
	 * Create the panel.
	 */
	
	// TODO : LƯU Ý : KHÔNG HIỂN THỊ MẬT KHẨU LÊN FORM
	public QuanLyTaiKhoanFrm() {
		tk_bus = new TaiKhoanBUS();
		QuanLyTaiKhoanFrm self = this;
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
		
		JPanel quanLyTaiKhoanPanel = new JPanel();
		quanLyTaiKhoanPanel.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("Quản lý tài khoản", null, quanLyTaiKhoanPanel, null);
		
		QuanLyNhanVienFrm quanLyNhanVienPanel = new QuanLyNhanVienFrm();
		tabbedPane.addTab("Quản lý nhân viên", null, quanLyNhanVienPanel, null);
		
		MyTextfield timKiemTaiKhoanTxt = new MyTextfield();
		timKiemTaiKhoanTxt.setPreferredSize(new Dimension(180, 35));
		timKiemTaiKhoanTxt.setColumns(10);
		timKiemTaiKhoanTxt.setBorder(new EmptyBorder(0, 0, 0, 0));
		timKiemTaiKhoanTxt.setBackground(new Color(77, 77, 77));
		
		JComboBox timKiemTypeCmbx_1 = new JComboBox();
		timKiemTypeCmbx_1.setModel(new DefaultComboBoxModel(new String[] {"mã tài khoản", "mã nhân viên", "username"}));
		timKiemTypeCmbx_1.setForeground(Color.CYAN);
		timKiemTypeCmbx_1.setBackground(new Color(102, 102, 102));
		
		MyButton timKiemBtn_1 = new MyButton();
		timKiemBtn_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timKiemTaiKhoan(timKiemTaiKhoanTxt.getText(), timKiemTypeCmbx_1.getSelectedIndex());
			}
		});
		timKiemBtn_1.setText("Lọc");
		timKiemBtn_1.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel lblNewLabel_1 = new JLabel("Sắp xếp :");
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox sortCmbx_1 = new JComboBox();
		sortCmbx_1.setModel(new DefaultComboBoxModel(new String[] {"----------", "mã nhân viên (A -> Z)", "mã nhân viên (Z -> A)"}));
		sortCmbx_1.setForeground(Color.CYAN);
		sortCmbx_1.setBackground(new Color(102, 102, 102));
		sortCmbx_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sapXepTaiKhoan(sortCmbx_1.getSelectedIndex());
			}
			
		});
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.getViewport().setBackground(new Color(51,51,51));
		
		MyButton timKiemBtn_1_1 = new MyButton();
		timKiemBtn_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ThemTaiKhoanFrm(self, tk_bus).setVisible(true);
			}
		});
		timKiemBtn_1_1.setText("Thêm");
		timKiemBtn_1_1.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton timKiemBtn_1_1_1 = new MyButton();
		timKiemBtn_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() >= 0) {
					new CapNhatTaiKhoanFrm(tk_bus.ds_hienThi.get(table.getSelectedRow()+1), tk_bus).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Bạn phải chọn 1 tài khoản trong bảng");
				}
			}
		});
		timKiemBtn_1_1_1.setText("Sửa");
		timKiemBtn_1_1_1.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel autoIncreaseSizeLbl = new JLabel("");
		
		MyButton themTaiKhoanExcelBtn = new MyButton();
		themTaiKhoanExcelBtn.setText("Thêm tài khoản với Excel");
		themTaiKhoanExcelBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton mbtnLmMi = new MyButton();
		mbtnLmMi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tk_bus = new TaiKhoanBUS();
				loadTaiKhoanTable();
				
			}
		});
		mbtnLmMi.setIcon(new ImageIcon(QuanLyTaiKhoanFrm.class.getResource("/assets/reset.png")));
		mbtnLmMi.setText("làm mới");
		mbtnLmMi.setHorizontalTextPosition(SwingConstants.LEADING);
		GroupLayout gl_quanLyTaiKhoanPanel = new GroupLayout(quanLyTaiKhoanPanel);
		gl_quanLyTaiKhoanPanel.setHorizontalGroup(
			gl_quanLyTaiKhoanPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_quanLyTaiKhoanPanel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_quanLyTaiKhoanPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_quanLyTaiKhoanPanel.createSequentialGroup()
							.addComponent(timKiemTaiKhoanTxt, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(timKiemTypeCmbx_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(timKiemBtn_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(mbtnLmMi, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(autoIncreaseSizeLbl, GroupLayout.DEFAULT_SIZE, 8, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(sortCmbx_1, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
						.addGroup(gl_quanLyTaiKhoanPanel.createSequentialGroup()
							.addComponent(timKiemBtn_1_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(timKiemBtn_1_1_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 461, Short.MAX_VALUE)
							.addComponent(themTaiKhoanExcelBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(10))
		);
		gl_quanLyTaiKhoanPanel.setVerticalGroup(
			gl_quanLyTaiKhoanPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_quanLyTaiKhoanPanel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_quanLyTaiKhoanPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(timKiemTaiKhoanTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(timKiemTypeCmbx_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_quanLyTaiKhoanPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(timKiemBtn_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_quanLyTaiKhoanPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(sortCmbx_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_quanLyTaiKhoanPanel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(autoIncreaseSizeLbl, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
						.addComponent(mbtnLmMi, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
					.addGroup(gl_quanLyTaiKhoanPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_quanLyTaiKhoanPanel.createSequentialGroup()
							.addGap(11)
							.addGroup(gl_quanLyTaiKhoanPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(timKiemBtn_1_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(timKiemBtn_1_1_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_quanLyTaiKhoanPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(themTaiKhoanExcelBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addGap(11))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"m\u00E3 t\u00E0i kho\u1EA3n", "m\u00E3 nh\u00E2n vi\u00EAn", "username", "t\u00ECnh tr\u1EA1ng"
			}
		));
		table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		table.getTableHeader().setUI(new CustomTableHeaderUI());
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		quanLyTaiKhoanPanel.setLayout(gl_quanLyTaiKhoanPanel);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
					.addGap(21))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
					.addGap(22))
		);
		setLayout(groupLayout);
		loadTaiKhoanTable();
		setVisible(true);

	}
	
	public void loadTaiKhoanTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for(int i = 0; i<tk_bus.ds_hienThi.size(); i++) {
			if(!tk_bus.ds_hienThi.get(i).getManv().contains("AD"))
			model.addRow(new Object[]{tk_bus.ds_hienThi.get(i).getMatk(), tk_bus.ds_hienThi.get(i).getManv(), 
					tk_bus.ds_hienThi.get(i).getUsername(),  tk_bus.taikhoan_status_map.get(tk_bus.ds_hienThi.get(i).getTinhtrang())});
		}
	}
	
	public void sapXepTaiKhoan(int selectedIndex) {
		tk_bus.sapXepTaiKhoan(selectedIndex);
		loadTaiKhoanTable();
	}
	public void timKiemTaiKhoan(String thongtin, int selectedIndex) {
		if(thongtin.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin tìm kiếm");
		}else {
			tk_bus.timKiemTaiKhoan(thongtin, selectedIndex);
			loadTaiKhoanTable();
		}
	}
	
	public void Refresh() {
		this.tk_bus = new TaiKhoanBUS();
		loadTaiKhoanTable();
	}
}
