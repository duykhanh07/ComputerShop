package GUI.QuanLySanPham;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ScrollPaneConstants;
import MyDesign.MyComponents.MyButton;
import MyDesign.MyTable.CustomTableCellRenderer;
import MyDesign.MyTable.CustomTableHeaderUI;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class XemTruocThemSanPham extends JFrame {

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
					XemTruocThemSanPham frame = new XemTruocThemSanPham();
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
	public XemTruocThemSanPham() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(XemTruocThemSanPham.class.getResource("/assets/Laptop_Login.png")));
		setTitle("Xem trước thêm sản phẩm");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1024, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.getViewport().setBackground(new Color(51,51,51));
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBorder(new LineBorder(new Color(130, 135, 144)));
		
		table = new JTable();
		table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		table.getTableHeader().setUI(new CustomTableHeaderUI());
		table.getTableHeader().setFont(new Font("Tahoma",Font.PLAIN,15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"m\u00E3 s\u1EA3n ph\u1EA9m", "t\u00EAn s\u1EA3n ph\u1EA9m", "CPU", "Ram", "B\u1ED9 nh\u1EDB", "Card \u0111\u1ED3 h\u1ECDa", "m\u00E0n h\u00ECnh", "pin", "h\u00E3ng", "gi\u00E1", "t\u00ECnh tr\u1EA1ng", "h\u00ECnh \u1EA3nh"
			}
		));
		scrollPane_1.setViewportView(table);
		
		MyButton huyBtn = new MyButton();
		huyBtn.setText("hủy");
		huyBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton xacNhanBtn = new MyButton();
		xacNhanBtn.setText("Xác nhận");
		xacNhanBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
					.addGap(8))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(636)
					.addComponent(xacNhanBtn, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(huyBtn, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(8))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(xacNhanBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(huyBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(9))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
