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
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Welcome extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel imageWelcome2;
	private JLabel tenNhanVienLbl;
	public JLabel maNhanVienLbl;
	private JLabel chucVuLbl;
	private JLabel imageWelcome;

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
		case "tester":
			imageWelcome.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(LoginForm.class.getResource("/assets/tester.png"))));
			break;
		}
		imageWelcome2.setIcon(new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(LoginForm.class.getResource("/assets/background_laptop_shop.png"))).getImage().getScaledInstance(595, 595, Image.SCALE_SMOOTH)));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(imageWelcome2, GroupLayout.PREFERRED_SIZE, 590, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(imageWelcome, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
						.addComponent(chucVuLbl, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
						.addComponent(maNhanVienLbl, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
						.addComponent(tenNhanVienLbl, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(imageWelcome2, GroupLayout.PREFERRED_SIZE, 575, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(imageWelcome, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
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
	
	public void initComponent() {
		setBackground(new Color(102, 102, 102));
		
		imageWelcome = new JLabel("");
		imageWelcome.setOpaque(true);
		imageWelcome.setBackground(new Color(200, 255, 255));
		
		imageWelcome2 = new JLabel("");
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				imageWelcome2.setIcon(new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(LoginForm.class.getResource("/assets/background_laptop_shop.png"))).getImage().getScaledInstance(imageWelcome2.getWidth(), imageWelcome2.getHeight(), Image.SCALE_SMOOTH)));
				revalidate();
				repaint();
			}
		});
		imageWelcome2.setHorizontalAlignment(SwingConstants.CENTER);
		imageWelcome2.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		tenNhanVienLbl = new JLabel("Chào bạn, ");
		tenNhanVienLbl.setForeground(new Color(0, 255, 255));
		tenNhanVienLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		maNhanVienLbl = new JLabel("Mã nhân viên :");
		maNhanVienLbl.setForeground(Color.CYAN);
		maNhanVienLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		chucVuLbl = new JLabel("Chức vụ :");
		chucVuLbl.setForeground(Color.CYAN);
		chucVuLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));


	}
}
