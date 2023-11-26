package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.LoginBUS;
import MyDesign.MyComponents.MyButton;
import MyDesign.MyComponents.MyPasswordField;
import MyDesign.MyComponents.MyTextfield;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private MyTextfield textField;
	private MyPasswordField textField_1;
	private JLabel lblNewLabel_2;
	private MyButton btnNewButton;
	private JLabel nortifyLabel;
	private boolean revealPass = false;

	private LoginBUS login_bus;
	private char echochar;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//				        if ("Nimbus".equals(info.getName())) {
//				            UIManager.setLookAndFeel(info.getClassName());
//				            break;
//				        }
//				    }
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public LoginForm() {
		login_bus = new LoginBUS();
		
		setTitle("Computer shop application");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginForm.class.getResource("/assets/Laptop_Login.png")));
		setSize(440, 360);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		lblNewLabel = new JLabel("Username :");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setBounds(10, 200, 88, 30);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setBounds(10, 241, 80, 30);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField = new MyTextfield();
		textField.setBackground(new Color(77, 77, 77));
		textField.setBorder(new EmptyBorder(0, 10, 0, 0));
		textField.setBounds(100, 199, 220, 30);
		textField.setColumns(10);
		
		textField_1 = new MyPasswordField();
		textField_1.setBackground(new Color(77, 77, 77));
		textField_1.setBorder(new EmptyBorder(0, 10, 0, 46));
		textField_1.setBounds(100, 241, 220, 30);
		textField_1.setColumns(10);
		echochar = textField_1.getEchoChar();
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(LoginForm.class.getResource("/assets/Laptop_Login.png")));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(255, 255, 102));
		lblNewLabel_2.setLocation(0, 0);
		lblNewLabel_2.setSize(424, 160);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(LoginForm.class.getResource("/assets/reveal-icon.png")));
		lblNewLabel_4.setBounds(281, 241, 33, 33);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("LAPTOP SHOP APP");
		lblNewLabel_3.setFont(new Font("Bangers", Font.PLAIN, 25));
		lblNewLabel_3.setForeground(new Color(0, 204, 204));
		lblNewLabel_3.setBounds(217, 28, 149, 51);
		contentPane.add(lblNewLabel_3);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(textField_1);
		contentPane.add(textField);
		contentPane.add(lblNewLabel_2);
		
		btnNewButton = new MyButton();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equalsIgnoreCase("") || textField_1.getText().equalsIgnoreCase("")) {
					nortifyLabel.setText("Tài khoản và mật khẩu không được để trống");
				}else {
					int kq_DangNhap =  login_bus.Login(textField.getText(), textField_1.getText());
					if(kq_DangNhap == 1) {
						dispose();
					}else {
						if(kq_DangNhap == -1) {
							nortifyLabel.setText("Sai mật khẩu");
						}else {
							nortifyLabel.setText("Tài khoản không tồn tại hoặc đã khóa");
						}	
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton.setText("Đăng nhập");
		btnNewButton.setBounds(152, 282, 108, 33);
		contentPane.add(btnNewButton);
		
		nortifyLabel = new JLabel("");
		nortifyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nortifyLabel.setForeground(new Color(255, 100, 0));
		nortifyLabel.setBounds(10, 160, 404, 30);
		contentPane.add(nortifyLabel);
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(revealPass) {
					textField_1.setEchoChar(echochar);
					lblNewLabel_4.setIcon(new ImageIcon(LoginForm.class.getResource("/assets/reveal-icon.png")));
					revealPass = false;
					
				}else{
					textField_1.setEchoChar((char) 0);
					lblNewLabel_4.setIcon(new ImageIcon(LoginForm.class.getResource("/assets/unreveal.png")));
					revealPass = true;
				}
			}
		});
		
		// Trong hàm constructor của lớp LoginForm, sau khi khởi tạo các thành phần giao diện
		textField.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        login();
		    }
		});

		textField_1.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        login();
		    }
		});

		// Phương thức để xử lý đăng nhập
		

	}
	private void login() {
	    if(textField.getText().equalsIgnoreCase("") || textField_1.getText().equalsIgnoreCase("")) {
	        nortifyLabel.setText("Tài khoản và mật khẩu không được để trống");
	    } else {
	        int kq_DangNhap =  login_bus.Login(textField.getText(), textField_1.getText());
	        if(kq_DangNhap == 1) {
	            dispose(); // Đăng nhập thành công, đóng cửa sổ đăng nhập
	        } else {
	            if(kq_DangNhap == -1) {
	                nortifyLabel.setText("Sai mật khẩu");
	            } else {
	                nortifyLabel.setText("Tài khoản không tồn tại hoặc đã bị khóa");
	            }   
	        }
	    }
	}
}
