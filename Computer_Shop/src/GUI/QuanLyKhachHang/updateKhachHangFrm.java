package GUI.QuanLyKhachHang;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.QuanLyKhachHangBUS;
import DTO.DTO_KhachHang;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import MyDesign.MyComponents.MyTextfield;
import javax.swing.JButton;
import MyDesign.MyComponents.MyButton;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.Toolkit;

public class updateKhachHangFrm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DTO_KhachHang kh;
	private QuanLyKhachHangBUS qlkh;
	private JLabel lblMKhchHng;
	private JLabel lblimTchLy;
	private MyTextfield tenKhachHangTxt;
	private MyTextfield tenKhachHangTxt_1;
	private QuanLyKhachHangFrm qlkh_f;

	/**
	 * Create the frame.
	 */
	public updateKhachHangFrm(QuanLyKhachHangFrm qlkh_f,DTO_KhachHang khachHang, QuanLyKhachHangBUS qlkh) {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(updateKhachHangFrm.class.getResource("/assets/Laptop_Login.png")));
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		
		this.kh = khachHang;
		this.qlkh = qlkh;
		this.qlkh_f = qlkh_f;
		setTitle("cập nhật thông tin khách hàng");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(538, 288);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("------------Thông tin khách hàng------------");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1.setForeground(Color.CYAN);
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblMKhchHng = new JLabel("mã khách hàng : <<makh>>");
		lblMKhchHng.setForeground(Color.CYAN);
		lblMKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblTnKhchHng = new JLabel("tên khách hàng :");
		lblTnKhchHng.setForeground(Color.CYAN);
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tenKhachHangTxt = new MyTextfield();
		tenKhachHangTxt.setBackground(new Color(77, 77, 77));
		tenKhachHangTxt.setColumns(10);
		tenKhachHangTxt.setBorder(null);
		
		JLabel lblSinThoi = new JLabel("số điện thoại :");
		lblSinThoi.setForeground(Color.CYAN);
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tenKhachHangTxt_1 = new MyTextfield();
		tenKhachHangTxt_1.setBackground(new Color(77, 77, 77));
		tenKhachHangTxt_1.setColumns(10);
		tenKhachHangTxt_1.setBorder(null);
		
		lblimTchLy = new JLabel("điểm tích lũy : <diem>");
		lblimTchLy.setForeground(Color.CYAN);
		lblimTchLy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyButton themPhieuNhapItemBtn = new MyButton();
		themPhieuNhapItemBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				capNhatKhachHang();
			}
		});
		themPhieuNhapItemBtn.setText("cập nhật");
		themPhieuNhapItemBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel autoIncreaseSpace_Lbl = new JLabel("");
		
		JLabel autoIncreaseSpace_Lbl_1 = new JLabel("");
		
		JLabel autoIncreaseSpace_Lbl_1_1 = new JLabel("");
		
		JLabel autoIncreaseSpace_Lbl_1_2 = new JLabel("");
		
		JLabel cornerLbl = new JLabel("");
		
		JLabel cornerLbl_1 = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(120)
					.addComponent(lblNewLabel_1_1_2_1, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
					.addGap(133))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(lblMKhchHng, GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(lblTnKhchHng, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(tenKhachHangTxt, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(autoIncreaseSpace_Lbl, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(tenKhachHangTxt_1, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(autoIncreaseSpace_Lbl_1, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(cornerLbl_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(autoIncreaseSpace_Lbl_1_2, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
							.addGap(4)
							.addComponent(themPhieuNhapItemBtn, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(autoIncreaseSpace_Lbl_1_1, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
							.addGap(8)
							.addComponent(cornerLbl, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblimTchLy, GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE))
					.addGap(10))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(lblNewLabel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblMKhchHng, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTnKhchHng, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(tenKhachHangTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(autoIncreaseSpace_Lbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(tenKhachHangTxt_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(autoIncreaseSpace_Lbl_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addComponent(cornerLbl_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addComponent(autoIncreaseSpace_Lbl_1_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addComponent(themPhieuNhapItemBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addComponent(autoIncreaseSpace_Lbl_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addComponent(cornerLbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblimTchLy, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
		hienThiThongTinKhachHang();
	}
	
	public void hienThiThongTinKhachHang() {
		this.lblMKhchHng.setText("mã khách hàng : "+this.kh.getMakh());
		this.tenKhachHangTxt.setText(this.kh.getTenkh());
		this.tenKhachHangTxt_1.setText(this.kh.getSdt());
		this.lblimTchLy.setText("điểm tích lũy : "+this.kh.getDiem());
	}
	
	public void capNhatKhachHang() {
		
		int xacnhan = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn cập nhật thông tin khách hàng?");
		if(xacnhan != 0) {
			return;
		}
		
		// TODO : xác minh
		String ten = tenKhachHangTxt.getText();
		for(int i =0; i<10; i++) {
			if(ten.contains(i+"")) {
				JOptionPane.showMessageDialog( null, "Tên không thể chứa kí tự số");
				return;
			}
		}
		
		String sdt = tenKhachHangTxt_1.getText();
		String regexPattern_sdt = "^0\\d{9}$";
		Pattern pattern = Pattern.compile(regexPattern_sdt);
		Matcher matcher = pattern.matcher(sdt);
		if(!matcher.matches()) {
			JOptionPane.showMessageDialog( null, "Vui lòng nhập số điện thoại hợp lệ");
			return;
		}
		
		for(int i = 0; i<qlkh.ds_khachHang.size(); i++) {
			if(qlkh.ds_khachHang.get(i).getSdt().equalsIgnoreCase(sdt)) {
				JOptionPane.showMessageDialog( null, "Số điện thoại đã được sử dụng");
				return;
			}
		}
		
		DTO_KhachHang khach = new DTO_KhachHang(this.kh.getMakh(), ten, sdt, this.kh.getDiem());
		int kq = qlkh.capNhatKhachHang(khach);
		if(kq == 1) {
			JOptionPane.showMessageDialog( null,"Cập nhật khách hàng thành công");
			this.qlkh_f.refresh();
			dispose();
		}else {
			JOptionPane.showMessageDialog( null,"Cập nhật thất bại, liên hệ với kĩ thuật nếu tình trạng tiếp tục xảy ra");
		}
	}
}
