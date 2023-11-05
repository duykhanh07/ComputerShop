package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class Welcome extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel imageWelcome;
	private JLabel tenNhanVienLbl;
	private JLabel maNhanVienLbl;
	private JLabel chucVuLbl;

	/**
	 * Create the panel.
	 */
	public Welcome(String manv, String tennv, String chucvu) {
		initComponent();
		maNhanVienLbl.setText("Mã nhân viên : "+manv);
		tenNhanVienLbl.setText("Tên nhân viên : "+tennv);
		chucVuLbl.setText("Chức vụ : "+chucvu);
		
		switch(chucvu) {
		case "bán hàng" : 
			imageWelcome.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(LoginForm.class.getResource("/assets/accountant.png"))));
			break;
		case "thủ kho" :
			imageWelcome.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(LoginForm.class.getResource("/assets/storage.png"))));
			break;
		case "quản lý" :
			imageWelcome.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(LoginForm.class.getResource("/assets/manager.png"))));
			break;
		case "admin":
			imageWelcome.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(LoginForm.class.getResource("/assets/admin.png"))));
			break;
		case "kĩ thuật":
			imageWelcome.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(LoginForm.class.getResource("/assets/technician.png"))));
			break;
		}
	}
	public void initComponent() {
		setBackground(new Color(102, 102, 102));
		
		imageWelcome = new JLabel("");
		imageWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		imageWelcome.setBackground(new Color(200, 255, 255));
		imageWelcome.setOpaque(true);
		imageWelcome.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		tenNhanVienLbl = new JLabel("Chào bạn, ");
		tenNhanVienLbl.setForeground(new Color(0, 255, 255));
		tenNhanVienLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		maNhanVienLbl = new JLabel("Mã nhân viên :");
		maNhanVienLbl.setForeground(Color.CYAN);
		maNhanVienLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		chucVuLbl = new JLabel("Chức vụ :");
		chucVuLbl.setForeground(Color.CYAN);
		chucVuLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel = new JLabel("");
		
		JLabel lblNewLabel_1 = new JLabel("");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(147)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(chucVuLbl, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
						.addComponent(maNhanVienLbl, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
						.addComponent(tenNhanVienLbl, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
						.addComponent(imageWelcome, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
					.addGap(197))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(80)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 504, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(imageWelcome, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tenNhanVienLbl, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(maNhanVienLbl, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chucVuLbl, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		setLayout(groupLayout);


	}

}
