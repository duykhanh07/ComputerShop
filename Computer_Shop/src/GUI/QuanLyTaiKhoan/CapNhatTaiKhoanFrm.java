package GUI.QuanLyTaiKhoan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.TaiKhoanBUS;
import DTO.DTO_TaiKhoan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import MyDesign.MyComponents.MyTextfield;
import MyDesign.MyComponents.MyButton;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CapNhatTaiKhoanFrm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DTO_TaiKhoan tk;
	private TaiKhoanBUS tk_bus;
	private JLabel maTaiKhoanLbl;
	private JLabel passwordLbl;
	private JComboBox maNhanVienCmbx;
	private JLabel lblTnSnPhm_1_1;
	private JComboBox tinhTrangCmbx;
	
	/* TODO : Chức năng cập nhật tài khoản
	 * Chỉ hiển thị mã tài khoản và tên tài khoản không cho sửa 2 thông tin này
	 * không hiện password nhưng có thể chọn nút bên cạnh để reset lại mật khẩu ban đầu
	 * Các thông tin còn lại có thể sửa*/
	public CapNhatTaiKhoanFrm(DTO_TaiKhoan tk, TaiKhoanBUS tkbus) {
		this.tk = tk;
		this.tk_bus = tkbus;
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		setIconImage(Toolkit.getDefaultToolkit().getImage(CapNhatTaiKhoanFrm.class.getResource("/assets/Laptop_Login.png")));
		setTitle("cập nhật tài khoản");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(370, 322);
		setMinimumSize(new Dimension(370, 322));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("----------Thông tin tài khoản----------");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblTnSnPhm_1 = new JLabel("mã nhân viên  :");
		lblTnSnPhm_1.setForeground(Color.CYAN);
		lblTnSnPhm_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		maNhanVienCmbx = new JComboBox();
		maNhanVienCmbx.setModel(new DefaultComboBoxModel(new String[] {"AD", "NV", "QL"}));
		maNhanVienCmbx.setForeground(Color.CYAN);
		maNhanVienCmbx.setFont(new Font("Tahoma", Font.PLAIN, 15));
		maNhanVienCmbx.setBackground(new Color(102, 102, 102));
		
		lblTnSnPhm_1_1 = new JLabel("tên tài khoản : <tentk>");
		lblTnSnPhm_1_1.setForeground(Color.CYAN);
		lblTnSnPhm_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tinhTrangCmbx = new JComboBox();
		tinhTrangCmbx.setModel(new DefaultComboBoxModel(new String[] {"đang hoạt động ", "đã khóa"}));
		tinhTrangCmbx.setForeground(Color.CYAN);
		tinhTrangCmbx.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tinhTrangCmbx.setBackground(new Color(102, 102, 102));
		
		JLabel tnhtrgtxt = new JLabel("tình trạng :");
		tnhtrgtxt.setForeground(Color.CYAN);
		tnhtrgtxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyButton capNhatTaiKhoanBtn = new MyButton();
		capNhatTaiKhoanBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(maNhanVienCmbx.getSelectedIndex() == -1 || tinhTrangCmbx.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin");
				}else {
					if(tinhTrangCmbx.getSelectedItem() == "đang hoạt động") {
						tk.setManv(maNhanVienCmbx.getSelectedItem().toString());
						tk.setTinhtrang(1);
						tk_bus.suaTK(tk);
					}else {
						tk.setManv(maNhanVienCmbx.getSelectedItem().toString());
						tk.setTinhtrang(0);
						tk_bus.suaTK(tk);
					}
					JOptionPane.showMessageDialog(null, "Cập nhật thành công");
				}
			}
		});
		capNhatTaiKhoanBtn.setText("cập nhật");
		capNhatTaiKhoanBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		maTaiKhoanLbl = new JLabel("mã tài khoản  : <matk>");
		maTaiKhoanLbl.setForeground(Color.CYAN);
		maTaiKhoanLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		passwordLbl = new JLabel("password : ********");
		passwordLbl.setForeground(Color.CYAN);
		passwordLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel autoIncreaseSize = new JLabel("");
		
		JLabel autoIncreaseSize_1 = new JLabel("");
		
		MyButton resetPasswordBtn = new MyButton();
		resetPasswordBtn.setIcon(new ImageIcon(CapNhatTaiKhoanFrm.class.getResource("/assets/reset.png")));
		resetPasswordBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(maTaiKhoanLbl, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
							.addGap(5))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(maNhanVienCmbx, 0, 214, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(passwordLbl, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(resetPasswordBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(tnhtrgtxt, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(tinhTrangCmbx, 0, 214, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(autoIncreaseSize_1, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(capNhatTaiKhoanBtn, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(autoIncreaseSize, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
							.addGap(1))
						.addComponent(lblTnSnPhm_1_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
					.addGap(4))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(maTaiKhoanLbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTnSnPhm_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(maNhanVienCmbx, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addComponent(lblTnSnPhm_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(passwordLbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(resetPasswordBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(tnhtrgtxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(tinhTrangCmbx, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(autoIncreaseSize_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(capNhatTaiKhoanBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(autoIncreaseSize, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
		layDsNhanVienKoTK();
		hienThongTin();
	}
	
	public void hienThongTin() {
		maTaiKhoanLbl.setText("mã tài khoản :" + tk.getMatk());
		maNhanVienCmbx.setSelectedItem(tk.getManv());
		lblTnSnPhm_1_1.setText("tên tài khoản :"+tk.getUsername());
		passwordLbl.setText("password :" + tk.getPassword());
		tinhTrangCmbx.setSelectedItem(tk_bus.taikhoan_status_map.get(tk.getTinhtrang()));
	}
	
	public void layDsNhanVienKoTK() {
		maNhanVienCmbx.setModel(new DefaultComboBoxModel(this.tk_bus.layDanhSachMaNhanVienChuaCoTaiKhoan()));
		maNhanVienCmbx.addItem(tk.getManv());
	}
}
