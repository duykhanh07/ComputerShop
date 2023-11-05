package GUI.QuanLySanPham;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import MyDesign.MyComponents.MyTextfield;
import MyDesign.MyTable.CustomTableCellRenderer;
import MyDesign.MyTable.CustomTableHeaderUI;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Font;
import javax.swing.JTextField;
import MyDesign.MyComponents.MyButton;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThemSanPhamFrm extends JFrame {

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
					ThemSanPhamFrm frame = new ThemSanPhamFrm();
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
	public ThemSanPhamFrm() {
		setMinimumSize(new Dimension(1024,740));
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ThemSanPhamFrm.class.getResource("/assets/Laptop_Login.png")));
		setTitle("Thêm sản phẩm");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1024, 742);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Hinh anh");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(128, 255, 255));
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel_1 = new JLabel("----------Thông tin sản phẩm----------");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblMSnPhm = new JLabel("mã sản phẩm :");
		lblMSnPhm.setForeground(Color.CYAN);
		lblMSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblTnSnPhm = new JLabel("tên sản phẩm :");
		lblTnSnPhm.setForeground(Color.CYAN);
		lblTnSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield tenSanPhamTxt = new MyTextfield();
		tenSanPhamTxt.setBackground(new Color(77, 77, 77));
		tenSanPhamTxt.setColumns(10);
		tenSanPhamTxt.setBorder(null);
		
		JLabel lblTnSnPhm_1 = new JLabel("CPU :");
		lblTnSnPhm_1.setForeground(Color.CYAN);
		lblTnSnPhm_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield CPUTxt = new MyTextfield();
		CPUTxt.setBackground(new Color(77, 77, 77));
		CPUTxt.setColumns(10);
		CPUTxt.setBorder(null);
		
		JLabel lblTnSnPhm_2 = new JLabel("ram :");
		lblTnSnPhm_2.setForeground(Color.CYAN);
		lblTnSnPhm_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield ramTxt = new MyTextfield();
		ramTxt.setBackground(new Color(77, 77, 77));
		ramTxt.setColumns(10);
		ramTxt.setBorder(null);
		
		JLabel lblTnSnPhm_3 = new JLabel("bộ nhớ :");
		lblTnSnPhm_3.setForeground(Color.CYAN);
		lblTnSnPhm_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield romTxt = new MyTextfield();
		romTxt.setBackground(new Color(77, 77, 77));
		romTxt.setColumns(10);
		romTxt.setBorder(null);
		
		JLabel lblTnSnPhm_4 = new JLabel("card đồ họa :");
		lblTnSnPhm_4.setForeground(Color.CYAN);
		lblTnSnPhm_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield cardTxt = new MyTextfield();
		cardTxt.setBackground(new Color(77, 77, 77));
		cardTxt.setColumns(10);
		cardTxt.setBorder(null);
		
		JLabel lblTnSnPhm_5 = new JLabel("màn hình:");
		lblTnSnPhm_5.setForeground(Color.CYAN);
		lblTnSnPhm_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield manHinhTxt = new MyTextfield();
		manHinhTxt.setBackground(new Color(77, 77, 77));
		manHinhTxt.setColumns(10);
		manHinhTxt.setBorder(null);
		
		JLabel lblTnSnPhm_6 = new JLabel("pin :");
		lblTnSnPhm_6.setForeground(Color.CYAN);
		lblTnSnPhm_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield pinTxt = new MyTextfield();
		pinTxt.setBackground(new Color(77, 77, 77));
		pinTxt.setColumns(10);
		pinTxt.setBorder(null);
		
		JLabel lblTnSnPhm_7 = new JLabel("hãng :");
		lblTnSnPhm_7.setForeground(Color.CYAN);
		lblTnSnPhm_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield hangTxt = new MyTextfield();
		hangTxt.setBackground(new Color(77, 77, 77));
		hangTxt.setColumns(10);
		hangTxt.setBorder(null);
		
		JLabel lblTnSnPhm_8 = new JLabel("giá :");
		lblTnSnPhm_8.setForeground(Color.CYAN);
		lblTnSnPhm_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield giaTxt = new MyTextfield();
		giaTxt.setBackground(new Color(77, 77, 77));
		giaTxt.setColumns(10);
		giaTxt.setBorder(null);
		
		JLabel lblTnSnPhm_9 = new JLabel("tình trạng :");
		lblTnSnPhm_9.setForeground(Color.CYAN);
		lblTnSnPhm_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel imageLinkTxt = new JLabel("hình ảnh : <image>");
		imageLinkTxt.setForeground(Color.CYAN);
		imageLinkTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyButton themSanPhamBtn = new MyButton();
		themSanPhamBtn.setText("Thêm");
		themSanPhamBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton chonHinhSanPhamBtn = new MyButton();
		chonHinhSanPhamBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// sử dụng File chooser lấy ra đường dẫn hoặc lấy ra tên rồi tạo đường dẫn cho hình ảnh
			}
		});
		chonHinhSanPhamBtn.setIcon(new ImageIcon(ThemSanPhamFrm.class.getResource("/assets/pickImage.png")));
		chonHinhSanPhamBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JComboBox tinhTrangCmbx = new JComboBox();
		tinhTrangCmbx.setModel(new DefaultComboBoxModel(new String[] {"đang kinh doanh", "ngưng kinh doanh"}));
		tinhTrangCmbx.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tinhTrangCmbx.setForeground(new Color(0, 255, 255));
		tinhTrangCmbx.setBackground(new Color(102, 102, 102));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(new Color(51,51,51));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		table = new JTable();
		table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		table.getTableHeader().setUI(new CustomTableHeaderUI());
		table.getTableHeader().setFont(new Font("Tahoma",Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"m\u00E3 s\u1EA3n ph\u1EA9m", "t\u00EAn s\u1EA3n ph\u1EA9m", "cpu", "ram", "b\u1ED9 nh\u1EDB", "card \u0111\u1ED3 h\u1ECDa", "m\u00E0n h\u00ECnh", "pin", "h\u00E3ng", "gi\u00E1", "t\u00ECnh tr\u1EA1ng", "h\u00ECnh \u1EA3nh"
			}
		));
		scrollPane.setViewportView(table);
		
		MyButton xacNhanBtn = new MyButton();
		xacNhanBtn.setText("xác nhận");
		xacNhanBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton xoaBtn = new MyButton();
		xoaBtn.setText("xóa");
		xoaBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyTextfield maSanPhamTxt = new MyTextfield();
		maSanPhamTxt.setBackground(new Color(77, 77, 77));
		maSanPhamTxt.setColumns(10);
		maSanPhamTxt.setBorder(null);
		
		JLabel autoIncreaseLabel = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(79)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(autoIncreaseLabel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblMSnPhm, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(maSanPhamTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(tenSanPhamTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(CPUTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_2, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(ramTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_3, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(romTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_4, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(cardTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_5, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(manHinhTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_6, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(pinTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_7, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(hangTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_8, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(giaTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_9, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(tinhTrangCmbx, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addComponent(imageLinkTxt, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(300)
							.addComponent(chonHinhSanPhamBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(themSanPhamBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(xoaBtn, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addGap(96)
							.addComponent(xacNhanBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
					.addGap(1))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(autoIncreaseLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
							.addGap(11)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMSnPhm, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(maSanPhamTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(tenSanPhamTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(CPUTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(ramTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(romTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(cardTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(manHinhTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(pinTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_7, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(hangTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_8, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(giaTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_9, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(tinhTrangCmbx, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(imageLinkTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(chonHinhSanPhamBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(1)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(themSanPhamBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(xoaBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(xacNhanBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))))
					.addGap(11))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
