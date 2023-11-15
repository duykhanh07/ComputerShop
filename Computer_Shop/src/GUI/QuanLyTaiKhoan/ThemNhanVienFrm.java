package GUI.QuanLyTaiKhoan;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import MyDesign.MyComponents.MyTextfield;
import MyDesign.MyTable.CustomTableCellRenderer;
import MyDesign.MyTable.CustomTableHeaderUI;

import javax.swing.JComboBox;
import MyDesign.MyComponents.MyButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.NhanVienBUS;
import DTO.DTO_NhanVien;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThemNhanVienFrm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private NhanVienBUS nv_bus;
	private JComboBox chucVuCmbx;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemNhanVienFrm frame = new ThemNhanVienFrm();
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
	public ThemNhanVienFrm(NhanVienBUS nv_bus1) {
		nv_bus = nv_bus1;
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		setIconImage(Toolkit.getDefaultToolkit().getImage(ThemTaiKhoanFrm.class.getResource("/assets/Laptop_Login.png")));
		setTitle("Thêm tài khoản nhân viên");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1024,441);
		setMinimumSize(new Dimension(1024,441));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));

		setContentPane(contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("----------Thông tin tài khoản----------");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
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
				{null, null, null, null, null},
			},
			new String[] {
				"t\u00EAn nh\u00E2n vi\u00EAn", "s\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "email", "\u0111\u1ECBa ch\u1EC9", "ch\u1EE9c v\u1EE5"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblTnSnPhm_1_1 = new JLabel("tên nhân viên :");
		lblTnSnPhm_1_1.setForeground(Color.CYAN);
		lblTnSnPhm_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield tenTaiKhoanTxt = new MyTextfield();
		tenTaiKhoanTxt.setColumns(10);
		tenTaiKhoanTxt.setBorder(null);
		tenTaiKhoanTxt.setBackground(new Color(77, 77, 77));
		
		JLabel lblTnSnPhm_1_1_1 = new JLabel("số điện thoại  :");
		lblTnSnPhm_1_1_1.setForeground(Color.CYAN);
		lblTnSnPhm_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield soDienThoaiTxt = new MyTextfield();
		soDienThoaiTxt.setColumns(10);
		soDienThoaiTxt.setBorder(null);
		soDienThoaiTxt.setBackground(new Color(77, 77, 77));
		
		JLabel lblTnSnPhm_1_1_2 = new JLabel("email :");
		lblTnSnPhm_1_1_2.setForeground(Color.CYAN);
		lblTnSnPhm_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield emailTxt = new MyTextfield();
		emailTxt.setColumns(10);
		emailTxt.setBorder(null);
		emailTxt.setBackground(new Color(77, 77, 77));
		
		JLabel lblTnSnPhm_1_1_3 = new JLabel("địa chỉ  :");
		lblTnSnPhm_1_1_3.setForeground(Color.CYAN);
		lblTnSnPhm_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		MyTextfield diaChiTxt = new MyTextfield();
		diaChiTxt.setColumns(10);
		diaChiTxt.setBorder(null);
		diaChiTxt.setBackground(new Color(77, 77, 77));
		
		JLabel lblTnSnPhm_1_1_3_1 = new JLabel("chức vụ :");
		lblTnSnPhm_1_1_3_1.setForeground(Color.CYAN);
		lblTnSnPhm_1_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		chucVuCmbx = new JComboBox();
		chucVuCmbx.setModel(new DefaultComboBoxModel(new String[] {"admin", "quản lý", "bán hàng", "thủ kho", "kĩ thuật"}));
		chucVuCmbx.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chucVuCmbx.setForeground(new Color(0, 255, 255));
		chucVuCmbx.setBackground(new Color(102, 102, 102));
		
		MyButton xoaBtn = new MyButton();
		xoaBtn.setText("xóa");
		xoaBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton themNhanVienBtn = new MyButton();
		themNhanVienBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maso = nv_bus.ds_nhanvien.size()+1;
				String manv;
				switch(chucVuCmbx.getSelectedItem().toString()) {
				case "admin": manv = "AD"; break;
				case "quản lý": manv = "QL"; break;
				default : manv = "NV"; break;
				
				}
				if(maso<1000) {
					manv += 0;
					if(maso<100) {
						manv += 0;
						if(maso<10) {
							manv += 0;
						}
					}
				}
				manv+=maso;
				String tennv = tenTaiKhoanTxt.getText();
				String sdt = soDienThoaiTxt.getText();
				String email = emailTxt.getText();
				String diachi = diaChiTxt.getText();
				String chucvu = chucVuCmbx.getSelectedItem().toString();
				DTO_NhanVien nv = new DTO_NhanVien(manv,tennv,sdt,email,diachi,chucvu);
				int ketqua = nv_bus.themNV(nv);
				if(ketqua == 0) {
					JOptionPane.showMessageDialog(null, "Lỗi");
				}else {
					JOptionPane.showMessageDialog(null, "Thêm thành công");
				}
			}
		});
		themNhanVienBtn.setText("Thêm");
		themNhanVienBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton xacNhanBtn = new MyButton();
		xacNhanBtn.setText("xác nhận");
		xacNhanBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_1_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(tenTaiKhoanTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_1_1_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(soDienThoaiTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_1_1_2, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(emailTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_1_1_3, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(diaChiTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_1_1_3_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(chucVuCmbx, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(themNhanVienBtn, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(xoaBtn, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)))
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(901)
					.addComponent(xacNhanBtn, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(10))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(tenTaiKhoanTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_1_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(soDienThoaiTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_1_1_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(emailTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_1_1_3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(diaChiTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_1_1_3_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(chucVuCmbx, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(themNhanVienBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(xoaBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE))
					.addGap(4)
					.addComponent(xacNhanBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(6))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
