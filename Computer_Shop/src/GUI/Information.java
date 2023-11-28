package GUI;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import BUS.ThongTinCaNhanBUS;

import java.awt.Color;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import MyDesign.MyComponents.MyPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

import MyDesign.MyComponents.MyButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Information extends JPanel {

	private static final long serialVersionUID = 1L;
	private ThongTinCaNhanBUS ttcn_bus;
	private JLabel newPass2_lbl;
	private JLabel newPass_lbl;
	private JLabel oldPassErr_lbl;
	private JLabel manvLbl;
	private JLabel tennvLbl;
	private JLabel diaChiLbl;
	private JLabel sdtLbl;
	private JLabel emailLbl;
	private JLabel chucVuLbl;
	private MyPasswordField oldPass;
	private MyPasswordField newPass;
	private MyPasswordField newPass2;

	/**
	 * Create the panel.
	 */
	public Information(String manv) {
		ttcn_bus = new ThongTinCaNhanBUS();
		ttcn_bus.layThongTinNhanVien(manv);
		setBackground(new Color(102, 102, 102));
		setSize(880,595);
		
		JPanel panel = new JPanel();
		TitledBorder tb = new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin nh\u00E2n vi\u00EAn (Li\u00EAn h\u1EC7 v\u1EDBi admin n\u1EBFu c\u00F3 nhu c\u1EA7u thay \u0111\u1ED5i)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 255, 255));
		tb.setTitleFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.setBorder(tb);
		panel.setBackground(new Color(102, 102, 102));
		
		manvLbl = new JLabel("Mã nhân viên :");
		manvLbl.setForeground(Color.CYAN);
		manvLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tennvLbl = new JLabel("Tên nhân viên :");
		tennvLbl.setForeground(Color.CYAN);
		tennvLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		diaChiLbl = new JLabel("Địa chỉ :");
		diaChiLbl.setForeground(Color.CYAN);
		diaChiLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		sdtLbl = new JLabel("Số điện thoại :");
		sdtLbl.setForeground(Color.CYAN);
		sdtLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		emailLbl = new JLabel("Email :");
		emailLbl.setForeground(Color.CYAN);
		emailLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		chucVuLbl = new JLabel("Chức vụ :");
		chucVuLbl.setForeground(Color.CYAN);
		chucVuLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(manvLbl, GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
						.addComponent(tennvLbl, GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
						.addComponent(diaChiLbl, GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
						.addComponent(sdtLbl, GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
						.addComponent(emailLbl, GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
						.addComponent(chucVuLbl, GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(manvLbl, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tennvLbl, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(diaChiLbl, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(sdtLbl, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(emailLbl, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chucVuLbl, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(43, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		TitledBorder tb1 = new TitledBorder(null, "Thay \u0111\u1ED5i Password", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 255, 255));
		tb1.setTitleFont(new Font("Tahoma",Font.PLAIN,15));
		panel_1.setBorder(tb1);
		panel_1.setBackground(new Color(102, 102, 102));
		
		JLabel lblChcV_1 = new JLabel("Mật khẩu mới :");
		lblChcV_1.setForeground(Color.CYAN);
		lblChcV_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblMtKhuC = new JLabel("Mật khẩu cũ :");
		lblMtKhuC.setForeground(Color.CYAN);
		lblMtKhuC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		oldPass = new MyPasswordField();
		oldPass.setColumns(10);
		oldPass.setBorder(new EmptyBorder(0, 10, 0, 46));
		oldPass.setBackground(new Color(77, 77, 77));
		
		JLabel lblChcV_1_1 = new JLabel("Xác nhận mật khẩu mới :");
		lblChcV_1_1.setForeground(Color.CYAN);
		lblChcV_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		newPass = new MyPasswordField();
		newPass.setColumns(10);
		newPass.setBorder(new EmptyBorder(0, 10, 0, 46));
		newPass.setBackground(new Color(77, 77, 77));
		
		newPass2 = new MyPasswordField();
		newPass2.setColumns(10);
		newPass2.setBorder(new EmptyBorder(0, 10, 0, 46));
		newPass2.setBackground(new Color(77, 77, 77));
		
		MyButton mbtnXcNhn = new MyButton();
		mbtnXcNhn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				capNhatMatKhau();
			}
		});
		mbtnXcNhn.setText("Xác nhận");
		mbtnXcNhn.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		oldPassErr_lbl = new JLabel("");
		oldPassErr_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		oldPassErr_lbl.setForeground(new Color(255, 0, 0));
		
		newPass_lbl = new JLabel("");
		newPass_lbl.setForeground(Color.RED);
		newPass_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		newPass2_lbl = new JLabel("");
		newPass2_lbl.setForeground(Color.RED);
		newPass2_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblChcV_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblMtKhuC, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
							.addGap(68)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(newPass, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(newPass_lbl, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(oldPass, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(oldPassErr_lbl, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblChcV_1_1)
							.addGap(13)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(mbtnXcNhn, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(newPass2, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(newPass2_lbl, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(oldPassErr_lbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblMtKhuC, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(oldPass, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblChcV_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
								.addComponent(newPass, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblChcV_1_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
								.addComponent(newPass2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(mbtnXcNhn, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(newPass_lbl, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(newPass2_lbl, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(10))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(11))
		);
		setLayout(groupLayout);
		hienThiThongTin();
	}
	
	public void hienThiThongTin() {
		manvLbl.setText("Mã nhân viên :"+ttcn_bus.nv.getManv());
		tennvLbl.setText("Tên nhân viên : "+ttcn_bus.nv.getTennv());
		sdtLbl.setText("Số điện thoại : "+ttcn_bus.nv.getSdt());
		diaChiLbl.setText("Địa chỉ : "+ttcn_bus.nv.getDiachi());
		emailLbl.setText("Email : "+ttcn_bus.nv.getEmail());
		chucVuLbl.setText("Chức vụ: "+ttcn_bus.nv.getChucvu());
	}
	public void capNhatMatKhau() {
		oldPassErr_lbl.setText("");
		newPass_lbl.setText("");
		newPass2_lbl.setText("");
		// validate
		if(oldPass.getText().equalsIgnoreCase("")) {
			oldPassErr_lbl.setText("* Mật khẩu cũ không được phép để trống");
			oldPass.requestFocus();
			return;
		}else if(!oldPass.getText().equals(ttcn_bus.tk.getPassword())) {
			oldPassErr_lbl.setText("* Mật khẩu cũ không trùng khớp");
			oldPass.requestFocus();
			return;
		}
		
		if(newPass.getText().equalsIgnoreCase("")) {
			newPass_lbl.setText("* Mật khẩu không được phép để trống");
			newPass.requestFocus();
			return;
		}else if(newPass.getText().length() < 9) {
			newPass_lbl.setText("Mật khẩu phải có ít nhất 9 kí tự");
			newPass.requestFocus();
			return;
		}else if(newPass.getText().equals(oldPass.getText())) {
			newPass_lbl.setText("Mật khẩu mới không trùng với mật khẩu cũ");
			newPass.requestFocus();
			return;
		}
		
		if(newPass2.getText().equalsIgnoreCase("")) {
			newPass2_lbl.setText("* Vui lòng xác nhận mật khẩu mới");
			newPass2.requestFocus();
			return;
		}else if(newPass2.getText().length() < 9) {
			newPass2_lbl.setText("Mật khẩu phải có ít nhất 9 kí tự");
			newPass2.requestFocus();
			return;
		}else if(! newPass2.getText().equals(newPass.getText())) {
			newPass2_lbl.setText("Mật khẩu xác thực không hợp lệ");
			newPass2.requestFocus();
			return;
		}
		
		int xacnhan = JOptionPane.showConfirmDialog(null, "Xác nhận cập nhật mật khẩu ");
		if(xacnhan == 0) {
			ttcn_bus.suaMatKhau(newPass.getText());
			oldPass.setText("");
			newPass.setText("");
			newPass2.setText("");
		}else {
			return;
		}		
	}
}
