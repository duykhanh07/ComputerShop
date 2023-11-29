package GUI.QuanLyBanHang;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import MyDesign.MyComponents.MyButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductItem extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ProductItem() {
		setBorder(new LineBorder(new Color(0, 255, 255), 1, true));
		setBackground(new Color(102, 102, 102));
			setSize(230,206);
			
			JLabel imageLbl = new JLabel("hình ảnh");
			imageLbl.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			imageLbl.setHorizontalAlignment(SwingConstants.CENTER);
			imageLbl.setForeground(new Color(0, 255, 255));
			
			JTextArea tenLaptopLbl = new JTextArea();
			tenLaptopLbl.setBorder(null);
			tenLaptopLbl.setEditable(false);
			tenLaptopLbl.setLineWrap(true);
			tenLaptopLbl.setText("Laptop Acer Gaming Nitro 5 AN515 57 53F9");
			tenLaptopLbl.setForeground(new Color(0, 255, 255));
			tenLaptopLbl.setBackground(new Color(102, 102, 102));
			
			MyButton timKiemBtn_1 = new MyButton();
			timKiemBtn_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AddToCart().setVisible(true);
				}
			});
			timKiemBtn_1.setIcon(new ImageIcon(ProductItem.class.getResource("/assets/cart.png")));
			timKiemBtn_1.setHorizontalTextPosition(SwingConstants.LEADING);
			
			JLabel lblNewLabel = new JLabel("100000000 đ");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setForeground(new Color(255, 255, 102));
			
			JLabel lblNewLabel_1 = new JLabel("");
			
			JLabel lblNewLabel_1_1 = new JLabel("");
			GroupLayout groupLayout = new GroupLayout(this);
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
						.addGap(4)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(imageLbl, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(timKiemBtn_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addComponent(tenLaptopLbl, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
						.addGap(2)
						.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
						.addGap(3))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(10)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(imageLbl, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
								.addGap(2)
								.addComponent(tenLaptopLbl, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addGap(1)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addComponent(timKiemBtn_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)))
			);
			setLayout(groupLayout);
	}
}
