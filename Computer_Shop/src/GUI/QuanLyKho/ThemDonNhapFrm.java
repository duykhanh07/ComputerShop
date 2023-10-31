package GUI.QuanLyKho;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import MyDesign.MyComponents.MyButton;
import MyDesign.MyComponents.MyTextfield;
import MyDesign.MyTable.CustomTableCellRenderer;
import MyDesign.MyTable.CustomTableHeaderUI;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;

public class ThemDonNhapFrm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable chiTietPhieuNhapTable;
	private MyTextfield donGiaTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemDonNhapFrm frame = new ThemDonNhapFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ThemDonNhapFrm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ThemDonNhapFrm.class.getResource("/assets/Laptop_Login.png")));
		setTitle("Thêm phiếu nhập hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(840, 609);
		setMinimumSize(new Dimension(840, 609));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setAlignmentY(0.0f);
		contentPane.setAlignmentX(0.0f);
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Thêm phiếu nhập hàng");
		lblNewLabel.setAlignmentY(0.0f);
		lblNewLabel.setForeground(new Color(0, 204, 204));
		lblNewLabel.setBackground(new Color(255, 255, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel maNhanVienPhieuNhapLbl = new JLabel("mã nhân viên : <<mavn>>");
		maNhanVienPhieuNhapLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		maNhanVienPhieuNhapLbl.setForeground(new Color(0, 255, 255));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.getViewport().setBackground(new Color(51,51,51));
		
		chiTietPhieuNhapTable = new JTable();
		chiTietPhieuNhapTable.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		chiTietPhieuNhapTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"AC0003", "Laptop Acer Gaming Nitro 5 AN515 57 53F9", "30", "20000000", "600000000"},
			},
			new String[] {
				"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "Th\u00E0nh ti\u1EC1n"
			}
		));
		chiTietPhieuNhapTable.getColumnModel().getColumn(1).setPreferredWidth(223);
		scrollPane.setViewportView(chiTietPhieuNhapTable);
		
		chiTietPhieuNhapTable.getTableHeader().setUI(new CustomTableHeaderUI());
		
		JLabel lblNewLabel_1_1 = new JLabel("mã nhà cung cấp :");
		lblNewLabel_1_1.setForeground(Color.CYAN);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox nhaCungCapCmbx = new JComboBox();
		nhaCungCapCmbx.setBackground(new Color(102, 102, 102));
		nhaCungCapCmbx.setForeground(new Color(0, 255, 255));
		
		JLabel tongTienPhieuNhapLbl = new JLabel("Tổng cộng : ..........");
		tongTienPhieuNhapLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		tongTienPhieuNhapLbl.setForeground(Color.CYAN);
		tongTienPhieuNhapLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyButton xacNhanPhieuNhapBtn = new MyButton();
		xacNhanPhieuNhapBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		xacNhanPhieuNhapBtn.setText("Xác nhận");
		xacNhanPhieuNhapBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton xemTruocBtn = new MyButton();
		xemTruocBtn.setText("Xem trước");
		xemTruocBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton huyBtn = new MyButton();
		huyBtn.setText("hủy");
		huyBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("mã sản phẩm :");
		lblNewLabel_1_1_1.setForeground(Color.CYAN);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox maSanPhamCmbx = new JComboBox();
		maSanPhamCmbx.setForeground(new Color(0, 255, 255));
		maSanPhamCmbx.setBackground(new Color(102, 102, 102));
		maSanPhamCmbx.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("đơn giá :");
		lblNewLabel_1_1_1_1.setForeground(Color.CYAN);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		donGiaTxt = new MyTextfield();
		donGiaTxt.setBorder(null);
		donGiaTxt.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("số lượng :");
		lblNewLabel_1_1_1_2.setForeground(Color.CYAN);
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield soLuongTxt = new MyTextfield();
		soLuongTxt.setHorizontalAlignment(SwingConstants.CENTER);
		soLuongTxt.setText("0");
		soLuongTxt.setColumns(10);
		soLuongTxt.setBorder(null);
		
		MyButton congBtn = new MyButton();
		congBtn.setFont(new Font("Segoe UI", Font.BOLD, 15));
		congBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		congBtn.setText("+");
		congBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton truBtn = new MyButton();
		truBtn.setText("-");
		truBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton themPhieuNhapItemBtn = new MyButton();
		themPhieuNhapItemBtn.setText("Thêm");
		themPhieuNhapItemBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton xoaPhieuNhapItemBtn = new MyButton();
		xoaPhieuNhapItemBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		xoaPhieuNhapItemBtn.setText("xóa");
		xoaPhieuNhapItemBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("------------------Sản phẩm---------------------");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setForeground(Color.CYAN);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("------------Thông tin phiếu nhập------------");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1.setForeground(Color.CYAN);
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel tenSanPhamTxt = new JLabel("<Tên sản phẩm khi chọn combobox>");
		tenSanPhamTxt.setForeground(Color.CYAN);
		tenSanPhamTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
										.addComponent(maNhanVienPhieuNhapLbl, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(1)
											.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
											.addGap(10)
											.addComponent(nhaCungCapCmbx, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
										.addComponent(maSanPhamCmbx, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
										.addComponent(tenSanPhamTxt, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
										.addComponent(donGiaTxt, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_1_1_2, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
									.addGap(10))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(truBtn, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(soLuongTxt, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(congBtn, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)))
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE))
						.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(themPhieuNhapItemBtn, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(xoaPhieuNhapItemBtn, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addGap(127)
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
							.addGap(117)
							.addComponent(xemTruocBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(xacNhanPhieuNhapBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(huyBtn, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addGap(12)))
					.addGap(0))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(289, Short.MAX_VALUE)
					.addComponent(tongTienPhieuNhapLbl, GroupLayout.PREFERRED_SIZE, 525, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(28)
									.addComponent(maNhanVienPhieuNhapLbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(2)
									.addComponent(nhaCungCapCmbx, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(26)
									.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(55)
									.addComponent(maSanPhamCmbx, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
							.addGap(11)
							.addComponent(tenSanPhamTxt, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(donGiaTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(lblNewLabel_1_1_1_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(19)
									.addComponent(congBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(soLuongTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addComponent(truBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tongTienPhieuNhapLbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(xemTruocBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addComponent(xacNhanPhieuNhapBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addComponent(huyBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(themPhieuNhapItemBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(xoaPhieuNhapItemBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
