package GUI.QuanLySanPham;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;

public class ChiTietSanPham extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiTietSanPham frame = new ChiTietSanPham();
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
	public ChiTietSanPham() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		
		setBackground(new Color(102, 102, 102));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ChiTietSanPham.class.getResource("/assets/Laptop_Login.png")));
		setTitle("Chi tiết sản phẩm");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(366, 551);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Hinh anh");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel.setForeground(new Color(128, 255, 255));
		
		JLabel lblNewLabel_1 = new JLabel("----------Thông tin sản phẩm----------");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		
		JLabel maSanPhamLbl = new JLabel("mã sản phẩm : <masp>");
		maSanPhamLbl.setForeground(Color.CYAN);
		maSanPhamLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel tenSanPhamLbl = new JLabel("tên sản phẩm : <tensp>");
		tenSanPhamLbl.setForeground(Color.CYAN);
		tenSanPhamLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel CPULbl = new JLabel("CPU : <cpu>");
		CPULbl.setForeground(Color.CYAN);
		CPULbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel ramLbl = new JLabel("RAM : <ram>");
		ramLbl.setForeground(Color.CYAN);
		ramLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel romLbl = new JLabel("bộ nhớ : <ROM>");
		romLbl.setForeground(Color.CYAN);
		romLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel cardLbl = new JLabel("card đồ hoa : <card>");
		cardLbl.setForeground(Color.CYAN);
		cardLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel manHinhLbl = new JLabel("màn hình: <manhinh>");
		manHinhLbl.setForeground(Color.CYAN);
		manHinhLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel pinLbl = new JLabel("Pin : <pin>");
		pinLbl.setForeground(Color.CYAN);
		pinLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel hangLbl = new JLabel("Hãng : <hang>");
		hangLbl.setForeground(Color.CYAN);
		hangLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel giaLbl = new JLabel("giá  : <gia>");
		giaLbl.setForeground(Color.CYAN);
		giaLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel tinhTrangLbl = new JLabel("tình trang : <đang kinh doanh hay ngưng>");
		tinhTrangLbl.setForeground(Color.CYAN);
		tinhTrangLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel auIncreaseSpace1 = new JLabel("");
		
		JLabel autoIncreaseSpace2 = new JLabel("");
		
		JLabel lblHnhnh = new JLabel("hình ảnh : <image>");
		lblHnhnh.setForeground(Color.CYAN);
		lblHnhnh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(auIncreaseSpace1, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(autoIncreaseSpace2, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
							.addGap(4))
						.addComponent(giaLbl, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
						.addComponent(cardLbl, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
						.addComponent(tinhTrangLbl, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
						.addComponent(hangLbl, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
						.addComponent(tenSanPhamLbl, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
						.addComponent(CPULbl, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
						.addComponent(ramLbl, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
						.addComponent(romLbl, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
						.addComponent(pinLbl, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
						.addComponent(manHinhLbl, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
						.addComponent(maSanPhamLbl, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblHnhnh, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(auIncreaseSpace1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addComponent(autoIncreaseSpace2, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(267)
							.addComponent(giaLbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(163)
							.addComponent(cardLbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(295)
							.addComponent(tinhTrangLbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(240)
							.addComponent(hangLbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(56)
							.addComponent(tenSanPhamLbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(82)
							.addComponent(CPULbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(110)
							.addComponent(ramLbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(135)
							.addComponent(romLbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(214)
							.addComponent(pinLbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(187)
							.addComponent(manHinhLbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addComponent(maSanPhamLbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblHnhnh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
