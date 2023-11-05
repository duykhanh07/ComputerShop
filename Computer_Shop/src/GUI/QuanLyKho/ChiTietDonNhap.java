package GUI.QuanLyKho;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import MyDesign.MyTable.CustomTableCellRenderer;
import MyDesign.MyTable.CustomTableHeaderUI;
import java.awt.Toolkit;

public class ChiTietDonNhap extends JFrame {

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
					ChiTietDonNhap frame = new ChiTietDonNhap();
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
	public ChiTietDonNhap() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ChiTietDonNhap.class.getResource("/assets/Laptop_Login.png")));
		setTitle("Chi tiết phiếu nhập");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(572,596);
		setMinimumSize(new Dimension(572,596));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 102, 102));
		panel.setLayout(null);
		
		JLabel maNhanVienPhieuNhapLbl = new JLabel("mã nhân viên : <<mavn>>");
		maNhanVienPhieuNhapLbl.setBounds(10, 50, 493, 19);
		maNhanVienPhieuNhapLbl.setForeground(Color.CYAN);
		maNhanVienPhieuNhapLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(maNhanVienPhieuNhapLbl);
		
		JLabel maNhaCungCapLbl = new JLabel("mã nhà cung cấp: <<mancc>>");
		maNhaCungCapLbl.setForeground(Color.CYAN);
		maNhaCungCapLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		maNhaCungCapLbl.setBounds(10, 80, 493, 30);
		panel.add(maNhaCungCapLbl);
		
		JLabel ngayNhapLbl = new JLabel("ngày nhập: <<ngaynhap>>");
		ngayNhapLbl.setForeground(Color.CYAN);
		ngayNhapLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ngayNhapLbl.setBounds(10, 121, 493, 30);
		panel.add(ngayNhapLbl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(new Color(51,51,51));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"m\u00E3 s\u1EA3n ph\u1EA9m", "t\u00EAn s\u1EA3n ph\u1EA9m", "\u0111\u01A1n gi\u00E1", "s\u1ED1 l\u01B0\u1EE3ng", "th\u00E0nh ti\u1EC1n"
			}
		));
		table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		table.getTableHeader().setUI(new CustomTableHeaderUI());
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		
		JLabel lblTngCng = new JLabel("tổng cộng :....................");
		lblTngCng.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTngCng.setForeground(Color.CYAN);
		lblTngCng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
						.addComponent(lblTngCng, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE))
					.addGap(22))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(lblTngCng, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(6))
		);
		
		JLabel maPhieuNhapLbl = new JLabel("mã phiếu nhập : <madh>");
		maPhieuNhapLbl.setForeground(Color.CYAN);
		maPhieuNhapLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		maPhieuNhapLbl.setBounds(10, 20, 493, 19);
		panel.add(maPhieuNhapLbl);
		contentPane.setLayout(gl_contentPane);
	}

}
