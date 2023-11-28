package GUI.QuanLyKhachHang;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import MyDesign.MyComponents.MyTextfield;
import javax.swing.JButton;
import MyDesign.MyComponents.MyButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.Toolkit;

public class updateKhachHangFrm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateKhachHangFrm frame = new updateKhachHangFrm();
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
	public updateKhachHangFrm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(updateKhachHangFrm.class.getResource("/assets/Laptop_Login.png")));
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		setTitle("cập nhật thông tin khách hàng");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 538, 288);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("------------Thông tin khách hàng------------");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1.setForeground(Color.CYAN);
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblMKhchHng = new JLabel("mã khách hàng : <<makh>>");
		lblMKhchHng.setForeground(Color.CYAN);
		lblMKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblTnKhchHng = new JLabel("tên khách hàng :");
		lblTnKhchHng.setForeground(Color.CYAN);
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield tenKhachHangTxt = new MyTextfield();
		tenKhachHangTxt.setColumns(10);
		tenKhachHangTxt.setBorder(null);
		
		JLabel lblSinThoi = new JLabel("số điện thoại :");
		lblSinThoi.setForeground(Color.CYAN);
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield tenKhachHangTxt_1 = new MyTextfield();
		tenKhachHangTxt_1.setColumns(10);
		tenKhachHangTxt_1.setBorder(null);
		
		JLabel lblimTchLy = new JLabel("điểm tích lũy : <diem>");
		lblimTchLy.setForeground(Color.CYAN);
		lblimTchLy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyButton themPhieuNhapItemBtn = new MyButton();
		themPhieuNhapItemBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		themPhieuNhapItemBtn.setText("Thêm");
		themPhieuNhapItemBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel autoIncreaseSpace_Lbl = new JLabel("");
		
		JLabel autoIncreaseSpace_Lbl_1 = new JLabel("");
		
		JLabel autoIncreaseSpace_Lbl_1_1 = new JLabel("");
		
		JLabel autoIncreaseSpace_Lbl_1_2 = new JLabel("");
		
		JLabel cornerLbl = new JLabel("");
		
		JLabel cornerLbl_1 = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(120)
					.addComponent(lblNewLabel_1_1_2_1, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
					.addGap(133))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(lblMKhchHng, GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(lblTnKhchHng, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(tenKhachHangTxt, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(autoIncreaseSpace_Lbl, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(tenKhachHangTxt_1, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(autoIncreaseSpace_Lbl_1, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(cornerLbl_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(autoIncreaseSpace_Lbl_1_2, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
							.addGap(4)
							.addComponent(themPhieuNhapItemBtn, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(autoIncreaseSpace_Lbl_1_1, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
							.addGap(8)
							.addComponent(cornerLbl, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblimTchLy, GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE))
					.addGap(10))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(lblNewLabel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblMKhchHng, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTnKhchHng, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(tenKhachHangTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(autoIncreaseSpace_Lbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(tenKhachHangTxt_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(autoIncreaseSpace_Lbl_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addComponent(cornerLbl_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addComponent(autoIncreaseSpace_Lbl_1_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addComponent(themPhieuNhapItemBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addComponent(autoIncreaseSpace_Lbl_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addComponent(cornerLbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblimTchLy, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
