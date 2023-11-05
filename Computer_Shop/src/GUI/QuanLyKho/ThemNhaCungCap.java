package GUI.QuanLyKho;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import MyDesign.MyComponents.MyTextfield;
import MyDesign.MyTable.CustomTableCellRenderer;
import MyDesign.MyTable.CustomTableHeaderUI;
import MyDesign.MyComponents.MyButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ThemNhaCungCap extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemNhaCungCap frame = new ThemNhaCungCap();
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
	public ThemNhaCungCap() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ThemDonNhapFrm.class.getResource("/assets/Laptop_Login.png")));
		setTitle("Thêm Nhà cung cấp");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(840, 609);
		setMinimumSize(new Dimension(840, 609));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("------------Thông tin nhà cung cấp------------");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1.setForeground(Color.CYAN);
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(51,51,51));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JLabel lblMNhCung = new JLabel("mã nhà cung cấp :");
		lblMNhCung.setForeground(Color.CYAN);
		lblMNhCung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield donGiaTxt = new MyTextfield();
		donGiaTxt.setColumns(10);
		donGiaTxt.setBorder(null);
		
		JLabel lblTnNhCung = new JLabel("tên nhà cung cấp :");
		lblTnNhCung.setForeground(Color.CYAN);
		lblTnNhCung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield donGiaTxt_1 = new MyTextfield();
		donGiaTxt_1.setColumns(10);
		donGiaTxt_1.setBorder(null);
		
		JLabel lblSinThoi = new JLabel("số điện thoại:");
		lblSinThoi.setForeground(Color.CYAN);
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield donGiaTxt_1_1 = new MyTextfield();
		donGiaTxt_1_1.setColumns(10);
		donGiaTxt_1_1.setBorder(null);
		
		JLabel lblaCh = new JLabel("địa chỉ : ");
		lblaCh.setForeground(Color.CYAN);
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		MyTextfield donGiaTxt_1_1_1 = new MyTextfield();
		donGiaTxt_1_1_1.setColumns(10);
		donGiaTxt_1_1_1.setBorder(null);
		
		MyButton themNhaCungCapBtn = new MyButton();
		themNhaCungCapBtn.setText("Thêm");
		themNhaCungCapBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton xoaNhaCungCapItemBtn = new MyButton();
		xoaNhaCungCapItemBtn.setText("Xóa");
		xoaNhaCungCapItemBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton xemTruocBtn = new MyButton();
		xemTruocBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new XemTruocKhoFrm().setVisible(true);
			}
		});
		xemTruocBtn.setText("Xem trước");
		xemTruocBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton xacThemNhaCungCapBtn = new MyButton();
		xacThemNhaCungCapBtn.setText("Xác nhận");
		xacThemNhaCungCapBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton huyBtn = new MyButton();
		huyBtn.setText("hủy");
		huyBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel autoIncreaseSizeLbl = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMNhCung, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
						.addComponent(donGiaTxt, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTnNhCung, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
						.addComponent(donGiaTxt_1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
						.addComponent(donGiaTxt_1_1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblaCh, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
						.addComponent(donGiaTxt_1_1_1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(themNhaCungCapBtn, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(xoaNhaCungCapItemBtn, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(autoIncreaseSizeLbl, GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(xemTruocBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(xacThemNhaCungCapBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(huyBtn, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(10))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(27)
									.addComponent(lblMNhCung, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
							.addGap(10)
							.addComponent(donGiaTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblTnNhCung, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(donGiaTxt_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(donGiaTxt_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblaCh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(donGiaTxt_1_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(themNhaCungCapBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(xoaNhaCungCapItemBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(autoIncreaseSizeLbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(xemTruocBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(xacThemNhaCungCapBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(huyBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(16))
		);
		
		table = new JTable();
		table.getTableHeader().setUI(new CustomTableHeaderUI());
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"m\u00E3 nh\u00E0 cung c\u1EA5p", "t\u00EAn nh\u00E0 cung c\u1EA5p", "s\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0111\u1ECBa ch\u1EC9"
			}
		));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
