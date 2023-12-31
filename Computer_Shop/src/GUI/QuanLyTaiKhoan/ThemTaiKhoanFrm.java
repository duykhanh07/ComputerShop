package GUI.QuanLyTaiKhoan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import MyDesign.MyComponents.MyTextfield;
import MyDesign.MyTable.CustomTableCellRenderer;
import MyDesign.MyTable.CustomTableHeaderUI;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Toolkit;
import MyDesign.MyComponents.MyButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.NhanVienBUS;
import BUS.TaiKhoanBUS;
import DTO.DTO_NhanVien;
import DTO.DTO_TaiKhoan;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ThemTaiKhoanFrm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	public static TaiKhoanBUS tk_bus;
	private DefaultTableModel tbl;
	private JComboBox maNhanVienCmbx;
	private MyTextfield tenTaiKhoanTxt;
	private JComboBox tinhTrangCmbx;
	private TaiKhoanBUS ds_tk = new TaiKhoanBUS();
	private ArrayList<DTO_TaiKhoan> listTK;
	DefaultTableModel model;
	int luaChonDong;
	private QuanLyTaiKhoanFrm qltk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemTaiKhoanFrm frame = new ThemTaiKhoanFrm(null,null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Chức năng : Thêm tài khoản Chỉ cần điền Tên đăng nhập, chọn mã tài khoản và
	 * tình trạng password và mã tài khoản cần để cho hệ thộng tự tạo, password nên
	 * thống nhất mặc định là 888888888
	 */

	public ThemTaiKhoanFrm(QuanLyTaiKhoanFrm qltk_form,TaiKhoanBUS tkbus) {
		this.tk_bus = tkbus;
		this.qltk = qltk_form;
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
		}
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(ThemTaiKhoanFrm.class.getResource("/assets/Laptop_Login.png")));
		setTitle("Thêm tài khoản nhân viên");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(444, 642);
		setMinimumSize(new Dimension(444, 642));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));

		setContentPane(contentPane);

		JLabel lblNewLabel_1 = new JLabel("----------Thông tin tài khoản----------");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblTnSnPhm_1 = new JLabel("mã nhân viên  :");
		lblTnSnPhm_1.setForeground(Color.CYAN);
		lblTnSnPhm_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		maNhanVienCmbx = new JComboBox();
		maNhanVienCmbx.setForeground(new Color(0, 255, 255));
		maNhanVienCmbx.setBackground(new Color(102, 102, 102));
		maNhanVienCmbx.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblTnSnPhm_1_1 = new JLabel("tên tài khoản :");
		lblTnSnPhm_1_1.setForeground(Color.CYAN);
		lblTnSnPhm_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		tenTaiKhoanTxt = new MyTextfield();
		tenTaiKhoanTxt.setColumns(10);
		tenTaiKhoanTxt.setBorder(null);
		tenTaiKhoanTxt.setBackground(new Color(77, 77, 77));

		JLabel lblTnSnPhm_1_1_1 = new JLabel("tình trạng :");
		lblTnSnPhm_1_1_1.setForeground(Color.CYAN);
		lblTnSnPhm_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		tinhTrangCmbx = new JComboBox();
		tinhTrangCmbx.setModel(new DefaultComboBoxModel(new String[] { "đang hoạt động", "đã khóa" }));
		tinhTrangCmbx.setForeground(new Color(0, 255, 255));
		tinhTrangCmbx.setBackground(new Color(102, 102, 102));
		tinhTrangCmbx.setFont(new Font("Tahoma", Font.PLAIN, 15));

		MyButton themNhanVienBtn = new MyButton();
		themNhanVienBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				themTaiKhoanVaoBang();
			}

		});
		themNhanVienBtn.setText("Thêm");
		themNhanVienBtn.setHorizontalTextPosition(SwingConstants.LEADING);

		MyButton xoaBtn = new MyButton();
		xoaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				luaChonDong = table.getSelectedRow();
				if(luaChonDong > -1) {
					int reply = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Xóa",
							JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						String manv = (String) model.getValueAt(luaChonDong, 0);
						model.removeRow(luaChonDong);
						maNhanVienCmbx.addItem(manv);
						tk_bus.ds_taiKhoan_temp.remove(luaChonDong);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 tài khoản trong bảng");
				}
			}
		});
		xoaBtn.setText("xóa");
		xoaBtn.setHorizontalTextPosition(SwingConstants.LEADING);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(new Color(51, 51, 51));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		table = new JTable();
		table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		table.getTableHeader().setUI(new CustomTableHeaderUI());
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, }, new String[] {
				"m\u00E3 nh\u00E2n vi\u00EAn", "t\u00EAn t\u00E0i kho\u1EA3n", "t\u00ECnh tr\u1EA1ng" }));
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		scrollPane.setViewportView(table);

		MyButton xacNhanBtn = new MyButton();
		xacNhanBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tk_bus.ds_taiKhoan_temp.size() > 0) {
					tk_bus.themTK();
					tk_bus.ds_taiKhoan_temp.clear();
					qltk.Refresh();
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Ít nhất phải có 1 nhân viên trong bảng");
				}
			}
		});
		xacNhanBtn.setText("xác nhận");
		xacNhanBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(10)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE).addGap(9))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(10)
						.addComponent(lblTnSnPhm_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addComponent(maNhanVienCmbx, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(10)
						.addComponent(lblTnSnPhm_1_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addComponent(tenTaiKhoanTxt, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(10)
						.addComponent(lblTnSnPhm_1_1_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addComponent(tinhTrangCmbx, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(10)
						.addComponent(themNhanVienBtn, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addGap(4).addComponent(xoaBtn, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(10)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE).addGap(9))
				.addGroup(Alignment.TRAILING,
						gl_contentPane.createSequentialGroup().addGap(322)
								.addComponent(xacNhanBtn, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(9)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(11)
				.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE).addGap(11)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTnSnPhm_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(maNhanVienCmbx, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addGap(11)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTnSnPhm_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(tenTaiKhoanTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addGap(11)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTnSnPhm_1_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(tinhTrangCmbx, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addGap(11)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(themNhanVienBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(xoaBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
				.addGap(11).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE).addGap(7)
				.addComponent(xacNhanBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE).addGap(9)));
		contentPane.setLayout(gl_contentPane);
		
		layDsNhanVienKoTK();
	}
	
	public void layDsNhanVienKoTK() {
		maNhanVienCmbx.setModel(new DefaultComboBoxModel(this.tk_bus.layDanhSachMaNhanVienChuaCoTaiKhoan()));
		
	}

	public int checkField() {
		int flag = 1;
		// kiem tra cac truong du lieu co trong hay khong
		if (maNhanVienCmbx.getSelectedIndex() == -1 || tenTaiKhoanTxt.getText().isEmpty()
				|| tinhTrangCmbx.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
			flag = 0;
		}
		return flag;
	}

	public int checkDupAdd() {
		int flag = 1;
		for (int i = 0; i < ds_tk.getTaiKhoan_mainList().size(); i++) {
			if (tenTaiKhoanTxt.getText().equals(ds_tk.getTaiKhoan_mainList().get(i).getUsername().trim())) {
				JOptionPane.showMessageDialog(null, "Tên tài khoản không thể trùng!");
				flag = 0;
			}
		}
		return flag;
	}
	
	public void themTaiKhoanVaoBang() {
		int tinhtrang = 0;
		if(maNhanVienCmbx.getSelectedIndex()>=0) {
			JOptionPane.showMessageDialog(null,"vui lòng chọn mã nhân viên muốn cấp tài khoản");
			return;
		}
		
		if(tenTaiKhoanTxt.getText().length() < 6) {
			JOptionPane.showMessageDialog(null,"tên tài khoản ít nhất phải có 6 thứ tự");
			return;
		}
		
		if(tinhTrangCmbx.getSelectedItem().toString().equalsIgnoreCase("đang hoạt động")) {
			tinhtrang = 1;
		}
		
		// TODO : Thêm vào danh sách tạm
		DTO_TaiKhoan tk = new DTO_TaiKhoan("", maNhanVienCmbx.getSelectedItem().toString(), tenTaiKhoanTxt.getText(), "888888888", tinhtrang);
		tk_bus.ds_taiKhoan_temp.add(tk);

		// TODO : Thêm vào bảng
		Object[] newRow = {maNhanVienCmbx.getSelectedItem().toString(), tenTaiKhoanTxt.getText(), tinhTrangCmbx.getSelectedItem().toString()};
		model.addRow(newRow);
		
		
		maNhanVienCmbx.removeItem(maNhanVienCmbx.getSelectedItem());
		tenTaiKhoanTxt.setText("");
		tinhTrangCmbx.setSelectedIndex(0);
		
	}
}
