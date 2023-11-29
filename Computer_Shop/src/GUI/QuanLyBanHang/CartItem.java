package GUI.QuanLyBanHang;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import MyDesign.MyComponents.MyButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class CartItem extends JPanel {

	
	//Edit button cong tru
	private static final long serialVersionUID = 1L;
	public static JLabel donGiaLbl;
	public static JTextArea soLuongLbl;
	public static JLabel GiaTienlbl, maSanPhamLbl;
	public static JTextArea tenLaptopLbl;

	/**
	 * Create the panel.
	 */
	public CartItem() {
		setBorder(new LineBorder(new Color(0, 255, 255)));
		setBackground(new Color(77, 77, 77));
		setSize(792,40);
		
		
		maSanPhamLbl = new JLabel();
		maSanPhamLbl.setHorizontalAlignment(SwingConstants.CENTER);
		maSanPhamLbl.setForeground(new Color(0, 255, 255));
		maSanPhamLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		
		tenLaptopLbl = new JTextArea();
		tenLaptopLbl.setLineWrap(true);
		tenLaptopLbl.setForeground(Color.CYAN);
		tenLaptopLbl.setEditable(false);
		tenLaptopLbl.setBorder(null);
		tenLaptopLbl.setBackground(new Color(77, 77, 77));
		
		donGiaLbl = new JLabel();
		donGiaLbl.setHorizontalAlignment(SwingConstants.CENTER);
		donGiaLbl.setForeground(Color.CYAN);
		donGiaLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		soLuongLbl = new JTextArea();
		soLuongLbl.setLineWrap(true);
		soLuongLbl.setForeground(Color.CYAN);
		soLuongLbl.setEditable(true);
		soLuongLbl.setBorder(null);
		soLuongLbl.setBackground(new Color(77, 77, 77));
		
		GiaTienlbl = new JLabel();
		GiaTienlbl.setHorizontalAlignment(SwingConstants.CENTER);
		GiaTienlbl.setForeground(Color.CYAN);
		GiaTienlbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(maSanPhamLbl, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tenLaptopLbl, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(donGiaLbl, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
					.addComponent(soLuongLbl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(GiaTienlbl, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(55))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(maSanPhamLbl, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(donGiaLbl, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(GiaTienlbl, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(soLuongLbl, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(tenLaptopLbl, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
}
