package GUI.QuanLyTaiKhoan;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import MyDesign.MyComponents.MyTextfield;
import MyDesign.MyTable.CustomTableCellRenderer;
import MyDesign.MyTable.CustomTableHeaderUI;

import javax.swing.JComboBox;
import MyDesign.MyComponents.MyButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.NhanVienBUS;
import DTO.DTO_NhanVien;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class ThemNhanVienFrm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private static NhanVienBUS nv_bus;
	private JComboBox chucVuCmbx;
	private MyTextfield tenTaiKhoanTxt;
	private MyTextfield soDienThoaiTxt;
	private MyTextfield emailTxt;
	private MyTextfield diaChiTxt;
	private NhanVienBUS ds_nv = new NhanVienBUS();
	private ArrayList<DTO_NhanVien> listNV;
	DefaultTableModel model;
	int luaChonDong;
	private QuanLyNhanVienFrm qlnv;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemNhanVienFrm frame = new ThemNhanVienFrm(null, null);
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
	public ThemNhanVienFrm(QuanLyNhanVienFrm qlnv_form,NhanVienBUS nvbus) {
		this.nv_bus = nvbus;
		this.qlnv = qlnv_form;
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		setIconImage(Toolkit.getDefaultToolkit().getImage(ThemTaiKhoanFrm.class.getResource("/assets/Laptop_Login.png")));
		setTitle("Thêm tài khoản nhân viên");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1024,441);
		setMinimumSize(new Dimension(1024,441));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));

		setContentPane(contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("----------Thông tin tài khoản----------");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(new Color(51,51,51));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		table = new JTable();
		table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		table.getTableHeader().setUI(new CustomTableHeaderUI());
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"t\u00EAn nh\u00E2n vi\u00EAn", "s\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "email", "\u0111\u1ECBa ch\u1EC9", "ch\u1EE9c v\u1EE5"
			}
		));
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		scrollPane.setViewportView(table);
		
		JLabel lblTnSnPhm_1_1 = new JLabel("tên nhân viên :");
		lblTnSnPhm_1_1.setForeground(Color.CYAN);
		lblTnSnPhm_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tenTaiKhoanTxt = new MyTextfield();
		tenTaiKhoanTxt.setColumns(10);
		tenTaiKhoanTxt.setBorder(null);
		tenTaiKhoanTxt.setBackground(new Color(77, 77, 77));
		
		JLabel lblTnSnPhm_1_1_1 = new JLabel("số điện thoại  :");
		lblTnSnPhm_1_1_1.setForeground(Color.CYAN);
		lblTnSnPhm_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		soDienThoaiTxt = new MyTextfield();
		soDienThoaiTxt.setColumns(10);
		soDienThoaiTxt.setBorder(null);
		soDienThoaiTxt.setBackground(new Color(77, 77, 77));
		
		JLabel lblTnSnPhm_1_1_2 = new JLabel("email :");
		lblTnSnPhm_1_1_2.setForeground(Color.CYAN);
		lblTnSnPhm_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		emailTxt = new MyTextfield();
		emailTxt.setColumns(10);
		emailTxt.setBorder(null);
		emailTxt.setBackground(new Color(77, 77, 77));
		
		JLabel lblTnSnPhm_1_1_3 = new JLabel("địa chỉ  :");
		lblTnSnPhm_1_1_3.setForeground(Color.CYAN);
		lblTnSnPhm_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		diaChiTxt = new MyTextfield();
		diaChiTxt.setColumns(10);
		diaChiTxt.setBorder(null);
		diaChiTxt.setBackground(new Color(77, 77, 77));
		
		JLabel lblTnSnPhm_1_1_3_1 = new JLabel("chức vụ :");
		lblTnSnPhm_1_1_3_1.setForeground(Color.CYAN);
		lblTnSnPhm_1_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		chucVuCmbx = new JComboBox();
		chucVuCmbx.setModel(new DefaultComboBoxModel(new String[] {"admin", "quản lý", "bán hàng", "thủ kho", "kĩ thuật"}));
		chucVuCmbx.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chucVuCmbx.setForeground(new Color(0, 255, 255));
		chucVuCmbx.setBackground(new Color(102, 102, 102));
		
		MyButton xoaBtn = new MyButton();
		xoaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				luaChonDong = table.getSelectedRow();
				int reply = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Xóa", JOptionPane.YES_NO_OPTION);
				if(reply == JOptionPane.YES_OPTION) {
					model.removeRow(luaChonDong);
				}
			}
		});
		xoaBtn.setText("xóa");
		xoaBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton themNhanVienBtn = new MyButton();
		themNhanVienBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String manv = "";
				int maso = nv_bus.ds_nhanVien.size() + nv_bus.ds_nhanVien_temp.size();
				String chucVu = "";
				if(checkField()==1 && checkDupAdd()==1) {
					if(chucVuCmbx.getSelectedItem()=="admin") {
						chucVu="admin";
						manv = "AD";
					}
					
					if(chucVuCmbx.getSelectedItem()=="quản lý") {
						chucVu="quản lý";
						manv = "QL";
						if(maso < 1000) {
							manv+="0";
							if(maso <100) {
								manv += "0";
								if(maso < 10) {
									manv += "0";
								}
							}
						}
						manv += maso;
					}
					
					if(chucVuCmbx.getSelectedItem()=="bán hàng" || chucVuCmbx.getSelectedItem()=="thủ kho" || chucVuCmbx.getSelectedItem()=="kĩ thuật") {
						chucVu=chucVuCmbx.getSelectedItem().toString();
						manv = "NV";
						if(maso < 1000) {
							manv+="0";
							if(maso <100) {
								manv += "0";
								if(maso < 10) {
									manv += "0";
								}
							}
						}
						manv += maso;
					}
					if(maso < 1000) {
						manv+="0";
						if(maso <100) {
							manv += "0";
							if(maso < 10) {
								manv += "0";
							}
						}
					}
					manv += maso;
					DTO_NhanVien nv = new DTO_NhanVien(manv, tenTaiKhoanTxt.getText(), soDienThoaiTxt.getText(), emailTxt.getText(), diaChiTxt.getText(), chucVu);
					
					nv_bus.ds_nhanVien_temp.add(nv);
					
					Object[] newRow = {tenTaiKhoanTxt.getText(), soDienThoaiTxt.getText(), emailTxt.getText(), diaChiTxt.getText(), chucVu};
					tenTaiKhoanTxt.setText("");
					soDienThoaiTxt.setText("");
					emailTxt.setText("");
					diaChiTxt.setText("");
					chucVuCmbx.setSelectedIndex(-1);
					model.addRow(newRow);
				}else {
//					System.out.println("Failure");
				}
				
			}
		});
		themNhanVienBtn.setText("Thêm");
		themNhanVienBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton xacNhanBtn = new MyButton();
		xacNhanBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nv_bus.ds_nhanVien_temp.size()>0) {
					nv_bus.themNV();
					nv_bus.ds_nhanVien_temp.clear();
					qlnv.Refresh();
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Ít nhất phải có 1 nhân viên trong bảng");
				}
				
			}
		});
		xacNhanBtn.setText("xác nhận");
		xacNhanBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_1_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(tenTaiKhoanTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_1_1_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(soDienThoaiTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_1_1_2, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(emailTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_1_1_3, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(diaChiTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_1_1_3_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(chucVuCmbx, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(themNhanVienBtn, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(xoaBtn, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)))
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(901)
					.addComponent(xacNhanBtn, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(10))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(tenTaiKhoanTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_1_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(soDienThoaiTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_1_1_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(emailTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_1_1_3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(diaChiTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_1_1_3_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(chucVuCmbx, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(themNhanVienBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(xoaBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE))
					.addGap(4)
					.addComponent(xacNhanBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(6))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public int checkField() {
		int flag=1;
		//kiem tra cac truong du lieu co trong hay khong
		if (tenTaiKhoanTxt.getText().isEmpty()|| soDienThoaiTxt.getText().isEmpty() || emailTxt.getText().isEmpty()
				|| diaChiTxt.getText().isEmpty()|| chucVuCmbx.getSelectedIndex() == -1){
			
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
			flag=0;
			return flag;
		}
		
		//kiem tra dau vao cua gia san pham co phai la so hay khong
		if (!(soDienThoaiTxt.getText().matches("^0\\d{9}$"))) {
			JOptionPane.showMessageDialog(null, "Số điện thoại phải hợp lệ!");
			flag=0;
			return flag;
		}
				
		
		String regexPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regexPattern);

        // Create a matcher
        Matcher matcher = pattern.matcher(emailTxt.getText());
        
        if(!matcher.matches()) {
        	flag = 0;
        	JOptionPane.showMessageDialog(null,"Email không hợp lệ!");
        	return flag;
        }
		return flag;
	}
	
	public int checkDupAdd() {
		int flag=1;
		for(int i=0; i<nv_bus.ds_nhanVien.size();i++) {
			if(emailTxt.getText().equals(nv_bus.ds_nhanVien.get(i).getEmail().trim())) {
				JOptionPane.showMessageDialog(null,"email nhân viên không thể trùng!");
				flag=0;
				return flag;
			}else if (soDienThoaiTxt.getText().equals(nv_bus.ds_nhanVien.get(i).getSdt().trim())) {		
				JOptionPane.showMessageDialog(null,"Số điện thoại nhân viên không thể trùng!");
				flag=0;
				return flag;
			}
		}
		return flag;
	}
}
