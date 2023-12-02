package GUI.QuanLyBanHang;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import BUS.QuanLyBanHang.BanHangInterface;
import BUS.QuanLyBanHang.QuanLyBanHangBUS;
import DTO.DTO_SanPham;
import GUI.LoginForm;

import javax.swing.JTextArea;
import MyDesign.MyComponents.MyButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ProductItem extends JPanel {

	//Edit
	private static long serialVersionUID = 1L;
	public static JLabel imageLbl ;
	public static JTextArea tenLaptopLbl;
	public static JLabel giaLbl;
	public static MyButton timKiemBtn_1;
	private DTO_SanPham sp;

	/**
	 * Create the panel.
	 */
	
	
	public ProductItem(DTO_SanPham sp, BanHangInterface banHangInter) {
		this.sp = sp;
		setBorder(new LineBorder(new Color(0, 255, 255), 1, true));
		setBackground(new Color(102, 102, 102));
		setSize(237,207);
		
		//Edit: hình
		imageLbl = new JLabel();
		imageLbl.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		imageLbl.setHorizontalAlignment(SwingConstants.CENTER);
		imageLbl.setForeground(new Color(0, 255, 255));
		
		//Edit: tên sp
		tenLaptopLbl = new JTextArea();
		tenLaptopLbl.setWrapStyleWord(true);
		tenLaptopLbl.setBorder(null);
		tenLaptopLbl.setEditable(false);
		tenLaptopLbl.setLineWrap(true);
		tenLaptopLbl.setForeground(new Color(0, 255, 255));
		tenLaptopLbl.setBackground(new Color(102, 102, 102));
		
		timKiemBtn_1 = new MyButton();
		timKiemBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				banHangInter.moCuaSoGioHang(sp);
			}
		});
		timKiemBtn_1.setIcon(new ImageIcon(ProductItem.class.getResource("/assets/cart.png")));
		timKiemBtn_1.setHorizontalTextPosition(SwingConstants.LEADING);
		
		//Edit: giá
		giaLbl = new JLabel();
		giaLbl.setHorizontalAlignment(SwingConstants.CENTER);
		giaLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		giaLbl.setForeground(new Color(255, 255, 102));
		
		JLabel autoIncreaseSpaceLbl = new JLabel("");
		
		JLabel autoIncreaseSpaceLbl_1 = new JLabel("");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(tenLaptopLbl, GroupLayout.PREFERRED_SIZE, 216, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(autoIncreaseSpaceLbl, GroupLayout.DEFAULT_SIZE, 11, Short.MAX_VALUE)
									.addGap(4)
									.addComponent(imageLbl, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(autoIncreaseSpaceLbl_1, GroupLayout.DEFAULT_SIZE, 9, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(giaLbl, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
									.addGap(5)
									.addComponent(timKiemBtn_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
							.addGap(9))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(autoIncreaseSpaceLbl, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addComponent(imageLbl, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addComponent(autoIncreaseSpaceLbl_1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addComponent(giaLbl, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tenLaptopLbl, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(timKiemBtn_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))))
		);
		setLayout(groupLayout);
		hienThiSanPham();
	}
	public void hienThiSanPham() {
		tenLaptopLbl.setText(sp.getTensp());
		imageLbl.setIcon(new ImageIcon(new ImageIcon(ProductItem.class.getResource(sp.getImage())).getImage().getScaledInstance(187, 112, Image.SCALE_SMOOTH)));
		DecimalFormat df = new DecimalFormat("#,###");
		giaLbl.setText(df.format(sp.getGia())+"đ");
	}

}
