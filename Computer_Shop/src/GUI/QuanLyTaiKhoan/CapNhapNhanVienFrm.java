package GUI.QuanLyTaiKhoan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BUS.NhanVienBUS;
import DTO.DTO_NhanVien;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import MyDesign.MyComponents.MyTextfield;
import javax.swing.JComboBox;
import MyDesign.MyComponents.MyButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Toolkit;
import GUI.QuanLyTaiKhoan.QuanLyNhanVienFrm;
public class CapNhapNhanVienFrm extends JFrame {
	private ArrayList <DTO_NhanVien> NhanVien_tempList = new ArrayList <DTO_NhanVien> ();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private NhanVienBUS bus_nhanvien = new NhanVienBUS();
	private DefaultTableModel tblm;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhapNhanVienFrm frame = new CapNhapNhanVienFrm();
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
	public CapNhapNhanVienFrm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CapNhapNhanVienFrm.class.getResource("/assets/Laptop_Login.png")));
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		setTitle("cập nhật thông tin sinh viên");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(367, 371);
		setMinimumSize(new Dimension(367, 371));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		tblm = (DefaultTableModel) table.getModel();
		JLabel lblNewLabel_1 = new JLabel("----------Thông tin tài khoản----------");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblTnSnPhm_1_1 = new JLabel("tên nhân viên :");
		lblTnSnPhm_1_1.setForeground(Color.CYAN);
		lblTnSnPhm_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield tenNhanVienTxt = new MyTextfield();
		tenNhanVienTxt.setColumns(10);
		tenNhanVienTxt.setBorder(null);
		tenNhanVienTxt.setBackground(new Color(77, 77, 77));
		
		JLabel lblTnSnPhm_1_1_1 = new JLabel("số điện thoại  :");
		lblTnSnPhm_1_1_1.setForeground(Color.CYAN);
		lblTnSnPhm_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield soDienThoaiTxt = new MyTextfield();
		soDienThoaiTxt.setColumns(10);
		soDienThoaiTxt.setBorder(null);
		soDienThoaiTxt.setBackground(new Color(77, 77, 77));
		
		JLabel lblTnSnPhm_1_1_2 = new JLabel("email :");
		lblTnSnPhm_1_1_2.setForeground(Color.CYAN);
		lblTnSnPhm_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield emailTxt = new MyTextfield();
		emailTxt.setColumns(10);
		emailTxt.setBorder(null);
		emailTxt.setBackground(new Color(77, 77, 77));
		
		JLabel lblTnSnPhm_1_1_3 = new JLabel("địa chỉ  :");
		lblTnSnPhm_1_1_3.setForeground(Color.CYAN);
		lblTnSnPhm_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		MyTextfield diaChiTxt = new MyTextfield();
		diaChiTxt.setColumns(10);
		diaChiTxt.setBorder(null);
		diaChiTxt.setBackground(new Color(77, 77, 77));
		
		JComboBox chucVuCmbx = new JComboBox();
		chucVuCmbx.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Quản lý", "Nhân viên"}));
		chucVuCmbx.setForeground(Color.CYAN);
		chucVuCmbx.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chucVuCmbx.setBackground(new Color(102, 102, 102));
		
		JLabel lblTnSnPhm_1_1_3_1 = new JLabel("chức vụ :");
		lblTnSnPhm_1_1_3_1.setForeground(Color.CYAN);
		lblTnSnPhm_1_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		MyButton capNhatBtn = new MyButton();
		capNhatBtn.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				DTO_NhanVien nv = bus_nhanvien.getNhanVien_mainList().get(getSelectedNhanVien());
				nv.setManv(getName());
				nv.setTennv(tenNhanVienTxt.getText().toString());
				nv.setSdt(soDienThoaiTxt.getText().toString());
				nv.setEmail(emailTxt.getText().toString());
				nv.setDiachi(diaChiTxt.getText().toString());
				nv.setChucvu(chucVuCmbx.getName());
				bus_nhanvien.suaNV(nv.getManv(), nv.getTennv());
				renderMainTable(NhanVien_tempList);
//				nv.getMaNV(tenNhanVienTxt.getText().toString());
				
			}
		});
		capNhatBtn.setText("cập nhật");
		capNhatBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel maNhanVienLbl = new JLabel("mã nhân viên : <manv>");
		maNhanVienLbl.setForeground(Color.CYAN);
		maNhanVienLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel = new JLabel("");
		
		JLabel lblNewLabel_2 = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
					.addGap(6))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(maNhanVienLbl, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(lblTnSnPhm_1_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(tenNhanVienTxt, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(lblTnSnPhm_1_1_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(soDienThoaiTxt, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(lblTnSnPhm_1_1_2, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(emailTxt, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(lblTnSnPhm_1_1_3, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(diaChiTxt, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(capNhatBtn, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblTnSnPhm_1_1_3_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(chucVuCmbx, 0, 214, Short.MAX_VALUE)))
					.addGap(1))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addComponent(maNhanVienLbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTnSnPhm_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(tenNhanVienTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(capNhatBtn, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	 private void renderMainTable(ArrayList <DTO_NhanVien> lst) {
	        tblm.setRowCount(0);
	        for(DTO_NhanVien nv : lst) {
	            String data [] = new String[5];
	            data[0] = nv.getManv();
	            data[1] = nv.getTennv();
	            data[2] = nv.getSdt();
	            data[3] = nv.getEmail();
	            data[4] = nv.getDiachi();
	            data[5] = nv.getChucvu();
	            tblm.addRow(data);
	        }
	    }
	
	 private int getSelectedNhanVien() {
	        int Rowindex = table.getSelectedRow();
	        int index = -1;
	        for(int i = 0; i < bus_nhanvien.getNhanVien_mainList().size(); i++) {
	            if(table.getValueAt(Rowindex, 0).equals(bus_nhanvien.getNhanVien_mainList().get(i).getManv())) {
	                index = i;
	                break;
	            }
	        }
	        return index;
	    }
}
