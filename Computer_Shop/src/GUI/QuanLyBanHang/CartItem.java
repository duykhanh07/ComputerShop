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
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import BUS.QuanLyBanHang.BanHangInterface;
import DTO.DTO_SanPham;

import java.awt.GridLayout;

public class CartItem extends JPanel {

	private static final long serialVersionUID = 1L;
	public static JLabel donGiaLbl;
	public static JLabel soLuongLbl;
	public static JLabel thanhTienlbl, maSanPhamLbl;
	public static JTextArea tenLaptopLbl;
	private MyButton truBtn;
	private MyButton loaiBoBtn;
	private MyButton themBtn;
	private BanHangInterface banHangInter;
	private DTO_SanPham sp;
	private int soluong;
	private long thanhTien;
	DecimalFormat df = new DecimalFormat("#,###");
	/**
	 * Create the panel.
	 */
	public CartItem() {
		setBackground(new Color(77, 77, 77));
		setSize(792,40);
	}
	
	public CartItem(DTO_SanPham sp, int soluong ,BanHangInterface banHangInter) {
		setMaximumSize(new Dimension(32767, 40));
		
		this.banHangInter = banHangInter;
		this.sp = sp;
		this.soluong = soluong;
		
		setBorder(new LineBorder(new Color(0, 255, 255)));
		setBackground(new Color(77, 77, 77));
		setSize(792,40);
		
		
		maSanPhamLbl = new JLabel("1");
		maSanPhamLbl.setHorizontalAlignment(SwingConstants.CENTER);
		maSanPhamLbl.setForeground(new Color(0, 255, 255));
		maSanPhamLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 102, 102));
		panel.setLayout(null);
		
		tenLaptopLbl = new JTextArea();
		tenLaptopLbl.setText("Laptop Acer Gaming Nitro 5 AN515 57 53F9");
		tenLaptopLbl.setLineWrap(true);
		tenLaptopLbl.setForeground(Color.CYAN);
		tenLaptopLbl.setEditable(false);
		tenLaptopLbl.setBorder(null);
		tenLaptopLbl.setBackground(new Color(77, 77, 77));
		
		donGiaLbl = new JLabel("20000000");
		donGiaLbl.setHorizontalAlignment(SwingConstants.CENTER);
		donGiaLbl.setForeground(Color.CYAN);
		donGiaLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		soLuongLbl = new JLabel();
		soLuongLbl.setHorizontalAlignment(SwingConstants.CENTER);
		soLuongLbl.setForeground(Color.CYAN);
		soLuongLbl.setBorder(null);
		soLuongLbl.setBackground(new Color(77, 77, 77));
		
		thanhTienlbl = new JLabel();
		thanhTienlbl.setHorizontalAlignment(SwingConstants.CENTER);
		thanhTienlbl.setForeground(Color.CYAN);
		thanhTienlbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		themBtn = new MyButton();
		themBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				increase();
			}
		});
		themBtn.setBackground(new Color(255, 255, 128));
		themBtn.setIcon(new ImageIcon(CartItem.class.getResource("/assets/add.png")));
		
		truBtn = new MyButton();
		truBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				decrease();
			}
		});
		truBtn.setIcon(new ImageIcon(CartItem.class.getResource("/assets/remove.png")));
		truBtn.setBackground(new Color(255, 255, 128));
		
		loaiBoBtn = new MyButton();
		loaiBoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove();
			}
		});
		loaiBoBtn.setColor(new Color(255, 128, 128));
		loaiBoBtn.setColorOver(new Color(255, 0, 0));
		loaiBoBtn.setIcon(new ImageIcon(CartItem.class.getResource("/assets/cancel.png")));
		loaiBoBtn.setBackground(new Color(255, 128, 128));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(themBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(truBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(loaiBoBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(themBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(loaiBoBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(truBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(20))
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(maSanPhamLbl, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(tenLaptopLbl)
					.addGap(2)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(177)
							.addComponent(thanhTienlbl, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
						.addComponent(donGiaLbl, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(88)
							.addComponent(soLuongLbl, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addGap(2)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(maSanPhamLbl, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(tenLaptopLbl, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(thanhTienlbl, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(donGiaLbl, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(soLuongLbl, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		hienThi();
	}
	public void hienThi() {
		maSanPhamLbl.setText(sp.getMasp());
		tenLaptopLbl.setText(sp.getTensp());
		donGiaLbl.setText(df.format(sp.getGia())+"đ");
		soLuongLbl.setText(soluong+"");
		tinhThanhTien();
		thanhTienlbl.setText(df.format(thanhTien)+"đ");
	}
	public void increase() {
		soluong += 1;
		tinhThanhTien();
		banHangInter.capNhatGioHang(sp, soluong);
	}
	public void decrease() {
		if(soluong>1) {
			soluong -=1;
		}
		tinhThanhTien();
		banHangInter.capNhatGioHang(sp, soluong);
	}
	public void remove() {
		banHangInter.boKhoiGioHang(sp.getMasp());
	}
	public void tinhThanhTien() {
		thanhTien = sp.getGia() * soluong;
	}
}
