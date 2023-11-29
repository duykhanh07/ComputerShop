package GUI.QuanLyBanHang;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import MyDesign.MyComponents.MyButton;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class CartItem extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public CartItem() {
		setBorder(new LineBorder(new Color(0, 255, 255)));
		setBackground(new Color(77, 77, 77));
		setSize(792,40);
		
		
		JLabel maSanPhamLbl = new JLabel("1");
		maSanPhamLbl.setHorizontalAlignment(SwingConstants.CENTER);
		maSanPhamLbl.setForeground(new Color(0, 255, 255));
		maSanPhamLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 102, 102));
		panel.setLayout(null);
		
		MyButton congBtn = new MyButton();
		congBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		congBtn.setIcon(new ImageIcon(CartItem.class.getResource("/assets/add.png")));
		congBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		congBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
		congBtn.setBounds(5, 5, 30, 30);
		panel.add(congBtn);
		
		MyButton congBtn_1 = new MyButton();
		congBtn_1.setIcon(new ImageIcon(CartItem.class.getResource("/assets/remove.png")));
		congBtn_1.setHorizontalTextPosition(SwingConstants.CENTER);
		congBtn_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		congBtn_1.setBounds(40, 5, 30, 30);
		panel.add(congBtn_1);
		
		MyButton congBtn_2 = new MyButton();
		congBtn_2.setIcon(new ImageIcon(CartItem.class.getResource("/assets/cancel.png")));
		congBtn_2.setHorizontalTextPosition(SwingConstants.CENTER);
		congBtn_2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		congBtn_2.setColorOver(new Color(255, 100, 100));
		congBtn_2.setColor(new Color(255, 128, 128));
		congBtn_2.setBackground(new Color(255, 128, 128));
		congBtn_2.setBounds(75, 5, 30, 30);
		panel.add(congBtn_2);
		
		JTextArea tenLaptopLbl = new JTextArea();
		tenLaptopLbl.setText("Laptop Acer Gaming Nitro 5 AN515 57 53F9");
		tenLaptopLbl.setLineWrap(true);
		tenLaptopLbl.setForeground(Color.CYAN);
		tenLaptopLbl.setEditable(false);
		tenLaptopLbl.setBorder(null);
		tenLaptopLbl.setBackground(new Color(77, 77, 77));
		
		JLabel donGiaLbl = new JLabel("20000000");
		donGiaLbl.setHorizontalAlignment(SwingConstants.CENTER);
		donGiaLbl.setForeground(Color.CYAN);
		donGiaLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel soLuongLbl = new JLabel("3");
		soLuongLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		soLuongLbl.setForeground(Color.CYAN);
		soLuongLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("60000000");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setForeground(Color.CYAN);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(maSanPhamLbl, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tenLaptopLbl, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(donGiaLbl, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(soLuongLbl, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(maSanPhamLbl, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(soLuongLbl, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(donGiaLbl, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(tenLaptopLbl, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
}
