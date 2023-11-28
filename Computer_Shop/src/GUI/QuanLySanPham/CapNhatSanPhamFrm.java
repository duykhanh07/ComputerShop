package GUI.QuanLySanPham;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import MyDesign.MyComponents.MyTextfield;
import javax.swing.JComboBox;
import MyDesign.MyComponents.MyButton;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CapNhatSanPhamFrm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhatSanPhamFrm frame = new CapNhatSanPhamFrm();
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
	public CapNhatSanPhamFrm() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		setMinimumSize(new Dimension(370, 740));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 368, 745);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setBackground(new Color(102, 102, 102));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ThemSanPhamFrm.class.getResource("/assets/Laptop_Login.png")));
		setTitle("Cập nhật sản phẩm");

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Hinh anh");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(128, 255, 255));
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel autoIncreaseLabel = new JLabel("");
		
		JLabel autoIncreaseLabel_1 = new JLabel("");
		
		JLabel lblNewLabel_1 = new JLabel("----------Thông tin sản phẩm----------");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel maSanPhamLbl = new JLabel("mã sản phẩm : <masp>");
		maSanPhamLbl.setForeground(Color.CYAN);
		maSanPhamLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblTnSnPhm = new JLabel("tên sản phẩm :");
		lblTnSnPhm.setForeground(Color.CYAN);
		lblTnSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield tenSanPhamTxt = new MyTextfield();
		tenSanPhamTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tenSanPhamTxt.setText("<tensp>");
		tenSanPhamTxt.setColumns(10);
		tenSanPhamTxt.setBorder(null);
		tenSanPhamTxt.setBackground(new Color(77, 77, 77));
		
		MyTextfield CPUTxt = new MyTextfield();
		CPUTxt.setText("<cpu>");
		CPUTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CPUTxt.setColumns(10);
		CPUTxt.setBorder(null);
		CPUTxt.setBackground(new Color(77, 77, 77));
		
		JLabel lblTnSnPhm_1 = new JLabel("CPU :");
		lblTnSnPhm_1.setForeground(Color.CYAN);
		lblTnSnPhm_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblTnSnPhm_2 = new JLabel("ram :");
		lblTnSnPhm_2.setForeground(Color.CYAN);
		lblTnSnPhm_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblTnSnPhm_3 = new JLabel("bộ nhớ :");
		lblTnSnPhm_3.setForeground(Color.CYAN);
		lblTnSnPhm_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblTnSnPhm_4 = new JLabel("card đồ họa :");
		lblTnSnPhm_4.setForeground(Color.CYAN);
		lblTnSnPhm_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblTnSnPhm_5 = new JLabel("màn hình:");
		lblTnSnPhm_5.setForeground(Color.CYAN);
		lblTnSnPhm_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblTnSnPhm_6 = new JLabel("pin :");
		lblTnSnPhm_6.setForeground(Color.CYAN);
		lblTnSnPhm_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield ramTxt = new MyTextfield();
		ramTxt.setText("<ram>");
		ramTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ramTxt.setColumns(10);
		ramTxt.setBorder(null);
		ramTxt.setBackground(new Color(77, 77, 77));
		
		MyTextfield romTxt = new MyTextfield();
		romTxt.setText("<rom>");
		romTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		romTxt.setColumns(10);
		romTxt.setBorder(null);
		romTxt.setBackground(new Color(77, 77, 77));
		
		MyTextfield cardTxt = new MyTextfield();
		cardTxt.setText("<card>");
		cardTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cardTxt.setColumns(10);
		cardTxt.setBorder(null);
		cardTxt.setBackground(new Color(77, 77, 77));
		
		MyTextfield manHinhTxt = new MyTextfield();
		manHinhTxt.setText("<manhinh>");
		manHinhTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		manHinhTxt.setColumns(10);
		manHinhTxt.setBorder(null);
		manHinhTxt.setBackground(new Color(77, 77, 77));
		
		MyTextfield pinTxt = new MyTextfield();
		pinTxt.setText("<pin>");
		pinTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pinTxt.setColumns(10);
		pinTxt.setBorder(null);
		pinTxt.setBackground(new Color(77, 77, 77));
		
		JLabel lblTnSnPhm_7 = new JLabel("hãng :");
		lblTnSnPhm_7.setForeground(Color.CYAN);
		lblTnSnPhm_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield hangTxt = new MyTextfield();
		hangTxt.setText("<hang>");
		hangTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		hangTxt.setColumns(10);
		hangTxt.setBorder(null);
		hangTxt.setBackground(new Color(77, 77, 77));
		
		MyTextfield giaTxt = new MyTextfield();
		giaTxt.setText("<gia>");
		giaTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		giaTxt.setColumns(10);
		giaTxt.setBorder(null);
		giaTxt.setBackground(new Color(77, 77, 77));
		
		JLabel lblTnSnPhm_8 = new JLabel("giá :");
		lblTnSnPhm_8.setForeground(Color.CYAN);
		lblTnSnPhm_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblTnSnPhm_9 = new JLabel("tình trạng :");
		lblTnSnPhm_9.setForeground(Color.CYAN);
		lblTnSnPhm_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox tinhTrangCmbx = new JComboBox();
		tinhTrangCmbx.setModel(new DefaultComboBoxModel(new String[] {"đang kinh doanh", "ngưng kinh doanh"}));
		tinhTrangCmbx.setForeground(Color.CYAN);
		tinhTrangCmbx.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tinhTrangCmbx.setBackground(new Color(102, 102, 102));
		
		MyButton chonHinhSanPhamBtn = new MyButton();
		chonHinhSanPhamBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// sử dụng File chooser lấy ra đường dẫn hoặc lấy ra tên rồi tạo đường dẫn cho hình ảnh
			}
		});
		chonHinhSanPhamBtn.setIcon(new ImageIcon(CapNhatSanPhamFrm.class.getResource("/assets/pickImage.png")));
		chonHinhSanPhamBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel imageLinkTxt = new JLabel("hình ảnh : <image>");
		imageLinkTxt.setForeground(Color.CYAN);
		imageLinkTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyButton mbtnCpNht = new MyButton();
		mbtnCpNht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mbtnCpNht.setText("Cập nhật");
		mbtnCpNht.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel autoIncreaseLabel_1_1 = new JLabel("");
		
		JLabel autoIncreaseLabel_1_1_1 = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(autoIncreaseLabel_1, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(autoIncreaseLabel, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
					.addGap(15))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(maSanPhamLbl, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(lblTnSnPhm, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(tenSanPhamTxt, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(lblTnSnPhm_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(CPUTxt, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(lblTnSnPhm_2, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(ramTxt, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(lblTnSnPhm_3, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(romTxt, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(lblTnSnPhm_4, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(cardTxt, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(lblTnSnPhm_5, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(manHinhTxt, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(lblTnSnPhm_6, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(pinTxt, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(lblTnSnPhm_7, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(hangTxt, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(lblTnSnPhm_8, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(giaTxt, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(lblTnSnPhm_9, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(tinhTrangCmbx, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(300)
							.addComponent(chonHinhSanPhamBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(imageLinkTxt, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
							.addGap(29)))
					.addGap(15))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(autoIncreaseLabel_1_1, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(mbtnCpNht, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(autoIncreaseLabel_1_1_1, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
					.addGap(5))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(autoIncreaseLabel_1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addComponent(autoIncreaseLabel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(maSanPhamLbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
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
						.addComponent(chonHinhSanPhamBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(imageLinkTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(autoIncreaseLabel_1_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(mbtnCpNht, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(autoIncreaseLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
