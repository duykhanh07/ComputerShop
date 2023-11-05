package GUI;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import MyDesign.MyComponents.MyPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import MyDesign.MyComponents.MyButton;

public class Information extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Information() {
		setBackground(new Color(102, 102, 102));
		setSize(880,595);
		
		JPanel panel = new JPanel();
		TitledBorder tb = new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin nh\u00E2n vi\u00EAn (Li\u00EAn h\u1EC7 v\u1EDBi admin n\u1EBFu c\u00F3 nhu c\u1EA7u thay \u0111\u1ED5i)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 255, 255));
		tb.setTitleFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.setBorder(tb);
		panel.setBackground(new Color(102, 102, 102));
		
		JLabel lblTn = new JLabel("Mã nhân viên :");
		lblTn.setForeground(Color.CYAN);
		lblTn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblTnNhnVin = new JLabel("Tên nhân viên :");
		lblTnNhnVin.setForeground(Color.CYAN);
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblaCh = new JLabel("Địa chỉ :");
		lblaCh.setForeground(Color.CYAN);
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblSinThoi = new JLabel("Số điện thoại :");
		lblSinThoi.setForeground(Color.CYAN);
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setForeground(Color.CYAN);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblChcV = new JLabel("Chức vụ :");
		lblChcV.setForeground(Color.CYAN);
		lblChcV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTn, GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
						.addComponent(lblTnNhnVin, GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
						.addComponent(lblaCh, GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
						.addComponent(lblSinThoi, GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
						.addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
						.addComponent(lblChcV, GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTnNhnVin, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblaCh, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblChcV, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
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
		
		MyPasswordField textField_1 = new MyPasswordField();
		textField_1.setColumns(10);
		textField_1.setBorder(new EmptyBorder(0, 10, 0, 46));
		textField_1.setBackground(new Color(77, 77, 77));
		
		JLabel lblChcV_1_1 = new JLabel("Xác nhận mật khẩu mới :");
		lblChcV_1_1.setForeground(Color.CYAN);
		lblChcV_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyPasswordField textField_1_1 = new MyPasswordField();
		textField_1_1.setColumns(10);
		textField_1_1.setBorder(new EmptyBorder(0, 10, 0, 46));
		textField_1_1.setBackground(new Color(77, 77, 77));
		
		MyPasswordField textField_1_2 = new MyPasswordField();
		textField_1_2.setColumns(10);
		textField_1_2.setBorder(new EmptyBorder(0, 10, 0, 46));
		textField_1_2.setBackground(new Color(77, 77, 77));
		
		MyButton mbtnXcNhn = new MyButton();
		mbtnXcNhn.setText("Xác nhận");
		mbtnXcNhn.setFont(new Font("Segoe UI", Font.BOLD, 14));
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
								.addComponent(textField_1_1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblChcV_1_1)
							.addGap(13)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(mbtnXcNhn, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1_2, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(434, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMtKhuC, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblChcV_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblChcV_1_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(mbtnXcNhn, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
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
	}
}
