package GUI.QuanLyTaiKhoan;

import javax.swing.JPanel;
import MyDesign.MyComponents.MyTextfield;
import MyDesign.MyTable.CustomTableCellRenderer;
import MyDesign.MyTable.CustomTableHeaderUI;

import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import MyDesign.MyComponents.MyButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.NhanVienBUS;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class QuanLyNhanVienFrm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private NhanVienBUS qlnv;

	/**
	 * Create the panel.
	 */
	public QuanLyNhanVienFrm() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		
		qlnv = new NhanVienBUS();
		setBackground(new Color(102, 102, 102));
		setSize(835,525);
		
		MyTextfield timKiemTaiKhoanTxt = new MyTextfield();
		timKiemTaiKhoanTxt.setPreferredSize(new Dimension(180, 35));
		timKiemTaiKhoanTxt.setColumns(10);
		timKiemTaiKhoanTxt.setBorder(new EmptyBorder(0, 0, 0, 0));
		timKiemTaiKhoanTxt.setBackground(new Color(77, 77, 77));
		
		JComboBox timKiemTypeCmbx_1 = new JComboBox();
		timKiemTypeCmbx_1.setModel(new DefaultComboBoxModel(new String[] {"mã nhân viên", "tên nhân viên", "số điện thoại", "email", "địa chỉ", "chức vụ"}));
		timKiemTypeCmbx_1.setForeground(Color.CYAN);
		timKiemTypeCmbx_1.setBackground(new Color(102, 102, 102));
		
		MyButton timKiemBtn_1 = new MyButton();
		timKiemBtn_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				timKiemNhanVien(timKiemTaiKhoanTxt.getText(), timKiemTypeCmbx_1.getSelectedIndex());
			}
		});
		timKiemBtn_1.setText("Lọc");
		timKiemBtn_1.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel autoIncreaseSizeLbl = new JLabel("");
		
		JLabel lblNewLabel_1 = new JLabel("Sắp xếp :");
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox sortCmbx_1 = new JComboBox();
		sortCmbx_1.setModel(new DefaultComboBoxModel(new String[] {"----------", "tên nhân viên (A -> Z)", "tên nhân viên (Z -> A)"}));
		sortCmbx_1.setForeground(Color.CYAN);
		sortCmbx_1.setBackground(new Color(102, 102, 102));
		sortCmbx_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sapXepNhanVien(sortCmbx_1.getSelectedIndex());
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(new Color(51,51,51));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		table = new JTable();
		table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		table.getTableHeader().setUI(new CustomTableHeaderUI());
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"m\u00E3 nh\u00E2n vi\u00EAn", "t\u00EAn nh\u00E2n vi\u00EAn", "s\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "email", "\u0111\u1ECBa ch\u1EC9", "ch\u1EE9c v\u1EE5"
			}
		));
		scrollPane.setViewportView(table);
		
		MyButton themNhanVienBtn = new MyButton();
		themNhanVienBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ThemNhanVienFrm().setVisible(true);
			}
		});
		themNhanVienBtn.setText("Thêm");
		themNhanVienBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton capNhatNhanVienBtn = new MyButton();
		capNhatNhanVienBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CapNhapNhanVienFrm().setVisible(true);
			}
		});
		capNhatNhanVienBtn.setText("Sửa");
		capNhatNhanVienBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton themTaiKhoanExcelBtn = new MyButton();
		themTaiKhoanExcelBtn.setText("Thêm tài khoản với Excel");
		themTaiKhoanExcelBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel autoIncreaseSizeLbl_1 = new JLabel("");
		
		MyButton mbtnLmMi = new MyButton();
		mbtnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qlnv = new NhanVienBUS();
				loadNhanVienTable();
			}
		});
		mbtnLmMi.setIcon(new ImageIcon(QuanLyNhanVienFrm.class.getResource("/assets/reset.png")));
		mbtnLmMi.setText("làm mới");
		mbtnLmMi.setHorizontalTextPosition(SwingConstants.LEADING);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(themNhanVienBtn, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(capNhatNhanVienBtn, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addGap(97)
							.addComponent(autoIncreaseSizeLbl_1, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
							.addGap(141)
							.addComponent(themTaiKhoanExcelBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(timKiemTaiKhoanTxt, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(timKiemTypeCmbx_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(timKiemBtn_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(mbtnLmMi, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(autoIncreaseSizeLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(10)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addGap(3)
									.addComponent(sortCmbx_1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(14)
							.addComponent(sortCmbx_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(autoIncreaseSizeLbl, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(timKiemTaiKhoanTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(timKiemTypeCmbx_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(1)
									.addComponent(timKiemBtn_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(mbtnLmMi, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(autoIncreaseSizeLbl_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(themNhanVienBtn, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addComponent(capNhatNhanVienBtn, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addComponent(themTaiKhoanExcelBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		setLayout(groupLayout);
		loadNhanVienTable();
		setVisible(true);
	}
	public void loadNhanVienTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for(int i = 0; i<qlnv.ds_hienThi.size(); i++) {
			model.addRow(new Object[]{qlnv.ds_hienThi.get(i).getManv(), qlnv.ds_hienThi.get(i).getTennv(), 
					qlnv.ds_hienThi.get(i).getSdt(), qlnv.ds_hienThi.get(i).getEmail(),  qlnv.ds_hienThi.get(i).getDiachi(),  qlnv.ds_hienThi.get(i).getChucvu()});
		}
	}
	
	public void sapXepNhanVien(int selectedIndex) {
		qlnv.sapXepNhanVien(selectedIndex);
		loadNhanVienTable();
	}
	public void timKiemNhanVien(String thongtin, int selectedIndex) {
		if(thongtin.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin tìm kiếm");
		}else {
			qlnv.timKiemNhanVien(thongtin, selectedIndex);
			loadNhanVienTable();
		}
	}
	
	
}
