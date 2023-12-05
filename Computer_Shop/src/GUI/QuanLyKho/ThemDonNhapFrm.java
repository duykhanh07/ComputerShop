package GUI.QuanLyKho;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Rectangle;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import MyDesign.MyComponents.MyButton;
import MyDesign.MyComponents.MyTextfield;
import MyDesign.MyTable.CustomTableCellRenderer;
import MyDesign.MyTable.CustomTableHeaderUI;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Date;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;

import BUS.ThemDonNhapBUS;
import DAO.DAO_QuanLyDonNhap;
import DTO.DTO_CTDonNhap;
import DTO.DTO_DonNhap;

import javax.swing.ScrollPaneConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class ThemDonNhapFrm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable chiTietPhieuNhapTable;
	private MyTextfield donGiaTxt;
	private ThemDonNhapBUS themDonNhapBUS = new ThemDonNhapBUS();
	private JLabel maNhanVienPhieuNhapLbl;
	private Long tong = 0l;
	private DAO_QuanLyDonNhap daoQuanLyDonNhap = new DAO_QuanLyDonNhap();
	private JComboBox maSanPhamCmbx;
	private MyTextfield soLuongTxt;
	private JLabel tongTienPhieuNhapLbl;
	private JComboBox nhaCungCapCmbx;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemDonNhapFrm frame = new ThemDonNhapFrm("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Hàm tạo mã
	public String taoMaDonNhap() {
		ArrayList<DTO_DonNhap> listDonNhap = daoQuanLyDonNhap.selectAllDonNhap();
		int size = listDonNhap.size()+1;
		if(size<10) {
			return "DN0000"+size;
		}else if(size<100) {
			return "DN000"+size;
		}else if(size<1000) {
			return "DN00"+size;
		}else if(size<10000) {
			return "DN0"+size;
		}
		return "DN"+size;
	}
	
	public boolean checkDonGia() {
		if(donGiaTxt.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Đơn giá trống");
			return false;
		}
		if(!donGiaTxt.getText().matches("\\d+")) {
			JOptionPane.showMessageDialog(null, "Đơn giá có chữ hoặc kí tự");
			return false;
		}
		if(Double.parseDouble(donGiaTxt.getText())==0.0) {
			JOptionPane.showMessageDialog(null, "Đơn giá phải lớn hơn 0");
			return false;
		}
		return true;
	}
	//check mã có trùng với mã đã thêm vào bảng chi tiết phiếu nhập
	public boolean CheckMa() {
		int countRow = chiTietPhieuNhapTable.getRowCount();
		DefaultTableModel model = (DefaultTableModel) chiTietPhieuNhapTable.getModel();
		for (int i = 0; i < countRow ;i++) {
			if(maSanPhamCmbx.getSelectedItem().equals(model.getValueAt(i, 1))) {
				 int option = JOptionPane.showConfirmDialog(null, "Sản phẩm "+maSanPhamCmbx.getSelectedItem()+" bạn đã thêm vào rồi! Bạn có muốn xóa để thêm mới không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
				// Kiểm tra phản hồi của người dùng
				 if (option == JOptionPane.YES_OPTION) {
					 tong = tong - Long.parseLong(model.getValueAt(i, 4).toString());
					 model.removeRow(i);
			         return true; 
			     }else {
			    	 return false;
			     }
			}
		}
		return true;
	}

	/**
	 * Create the frame.
	 */

	public ThemDonNhapFrm(String manv) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ThemDonNhapFrm.class.getResource("/assets/Laptop_Login.png")));
		setTitle("Thêm phiếu nhập hàng");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(840, 609);
		setMinimumSize(new Dimension(840, 609));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setAlignmentY(0.0f);
		contentPane.setAlignmentX(0.0f);
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		
		maNhanVienPhieuNhapLbl = new JLabel("Mã nhân viên: "+manv);
		maNhanVienPhieuNhapLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		maNhanVienPhieuNhapLbl.setForeground(new Color(0, 255, 255));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.getViewport().setBackground(new Color(51,51,51));
		
		chiTietPhieuNhapTable = new JTable();
		chiTietPhieuNhapTable.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		chiTietPhieuNhapTable.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "Th\u00E0nh ti\u1EC1n"
			}
		));
		chiTietPhieuNhapTable.getColumnModel().getColumn(1).setPreferredWidth(223);
		scrollPane.setViewportView(chiTietPhieuNhapTable);
		
		chiTietPhieuNhapTable.getTableHeader().setUI(new CustomTableHeaderUI());
		
		JLabel lblNewLabel_1_1 = new JLabel("tên nhà cung cấp :");
		lblNewLabel_1_1.setForeground(Color.CYAN);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		nhaCungCapCmbx = new JComboBox();
		nhaCungCapCmbx.setBackground(new Color(102, 102, 102));
		nhaCungCapCmbx.setForeground(new Color(0, 255, 255));
		
		//Thêm mã nhà cung cấp vào comboBox
		themDonNhapBUS.hienThiComboBoxMaNhaCungCap(nhaCungCapCmbx);

		tongTienPhieuNhapLbl = new JLabel("Tổng cộng: "+tong);
		tongTienPhieuNhapLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		tongTienPhieuNhapLbl.setForeground(Color.CYAN);
		tongTienPhieuNhapLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyButton xacNhanPhieuNhapBtn = new MyButton();
		xacNhanPhieuNhapBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chiTietPhieuNhapTable.getRowCount()!=0) {
					int dem = 0;
					String maNCC = themDonNhapBUS.ds_nhaCungCap.get(nhaCungCapCmbx.getSelectedItem().toString());
					String maDonNhap = taoMaDonNhap();
					Long tongTien = tong;
					Date ngayNhap = Date.valueOf(LocalDate.now());
					DTO_DonNhap donNhap = new DTO_DonNhap(maDonNhap, manv, maNCC, tongTien, ngayNhap);
					if(themDonNhapBUS.insertDonNhap(donNhap)==0) {
						JOptionPane.showMessageDialog(null, "Thêm đơn nhập thất bại");
					}else {
						int rowCount = chiTietPhieuNhapTable.getRowCount();
						for(int i=0; i < rowCount; i++) {
							String maSanPham = String.valueOf(chiTietPhieuNhapTable.getValueAt(i, 0));
							int donGia = Integer.parseInt(chiTietPhieuNhapTable.getValueAt(i, 3).toString());
							int soLuong = Integer.parseInt(chiTietPhieuNhapTable.getValueAt(i, 2).toString());
							DTO_CTDonNhap chiTietDonNhap = new DTO_CTDonNhap(maDonNhap, maSanPham, null, donGia, soLuong, 0);
							if(themDonNhapBUS.insertChiTietDonNhap(chiTietDonNhap)!=0) {
								dem+=1;
							}
						}
					}
					JOptionPane.showMessageDialog(null, "Có "+dem+" chi tiết phiếu thêm thành công");
					DefaultTableModel model_table = (DefaultTableModel) chiTietPhieuNhapTable.getModel();
					model_table.setRowCount(0);
					tong = 0l;
					tongTienPhieuNhapLbl.setText("Tổng cộng: "+tong);
					nhaCungCapCmbx.setEnabled(true);
					nhaCungCapCmbx.setSelectedIndex(0);
					maSanPhamCmbx.setSelectedIndex(0);
					donGiaTxt.setText("");
					soLuongTxt.setText("1");
				}else {
					JOptionPane.showMessageDialog(null, "Không có dữ liệu để thêm");
				}
			}
		});
		xacNhanPhieuNhapBtn.setText("Xác nhận");
		xacNhanPhieuNhapBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton xemTruocBtn = new MyButton();
		//Nút xem trước
		xemTruocBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mancc = (String) nhaCungCapCmbx.getSelectedItem();
				Date thoiGian = java.sql.Date.valueOf(LocalDate.now()) ;
				new XemTruocKhoFrm(taoMaDonNhap(), manv, mancc, tong, thoiGian, chiTietPhieuNhapTable, tongTienPhieuNhapLbl,nhaCungCapCmbx,maSanPhamCmbx,donGiaTxt, soLuongTxt).setVisible(true);
			}
			
		});
		xemTruocBtn.setText("Xem trước");
		xemTruocBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton huyBtn = new MyButton();
		huyBtn.setText("hủy");
		huyBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		//nút hủy
		huyBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DefaultTableModel model_table =(DefaultTableModel) chiTietPhieuNhapTable.getModel();
				model_table.setRowCount(0);
				tong = 0l;
				tongTienPhieuNhapLbl.setText("Tổng cộng: "+tong);
				nhaCungCapCmbx.setEnabled(true);
				nhaCungCapCmbx.setSelectedIndex(0);
				maSanPhamCmbx.setSelectedIndex(0);
				donGiaTxt.setText("");
				soLuongTxt.setText("1");
			}
		});
		
		JLabel lblNewLabel_1_1_1 = new JLabel("sản phẩm :");
		lblNewLabel_1_1_1.setForeground(Color.CYAN);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		maSanPhamCmbx = new JComboBox();
		maSanPhamCmbx.setForeground(new Color(0, 255, 255));
		maSanPhamCmbx.setBackground(new Color(102, 102, 102));
		maSanPhamCmbx.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		//Thêm tên sản phẩm vào Combobox
		themDonNhapBUS.hienThiComboBoxMaSanPham(maSanPhamCmbx);
		
		//ten san pham
		maSanPhamCmbx.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
//				themDonNhapBUS.layTenSanPham(maSanPhamCmbx, tenSanPhamTxt);
			}
		});
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("đơn giá :");
		lblNewLabel_1_1_1_1.setForeground(Color.CYAN);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		donGiaTxt = new MyTextfield();
		donGiaTxt.setBackground(new Color(77, 77, 77));
		donGiaTxt.setBorder(null);
		donGiaTxt.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("số lượng :");
		lblNewLabel_1_1_1_2.setForeground(Color.CYAN);
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		soLuongTxt = new MyTextfield();
		soLuongTxt.setBackground(new Color(77, 77, 77));
		soLuongTxt.setHorizontalAlignment(SwingConstants.CENTER);
		soLuongTxt.setText("1");
		soLuongTxt.setColumns(10);
		soLuongTxt.setBorder(null);
		
		MyButton truBtn = new MyButton();
		truBtn.setIcon(new ImageIcon(ThemDonNhapFrm.class.getResource("/assets/remove.png")));
		truBtn.setFont(new Font("Segoe UI", Font.BOLD, 15));
		truBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(soLuongTxt.getText().equals("1")) {
					JOptionPane.showMessageDialog(null, "Số lượng không được nhỏ hơn 1");
				}
				else {
					soLuongTxt.setText((Integer.parseInt(soLuongTxt.getText()) - 1)+"");
				}
			}
		});
		truBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		MyButton congBtn = new MyButton();
		congBtn.setIcon(new ImageIcon(ThemDonNhapFrm.class.getResource("/assets/add.png")));
		congBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		congBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				soLuongTxt.setText((Integer.parseInt(soLuongTxt.getText()) + 1)+"");
			}
		});
		
		MyButton themPhieuNhapItemBtn = new MyButton();
		themPhieuNhapItemBtn.setText("Thêm");
		themPhieuNhapItemBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		//nút thêm chi tiết của hóa đơn
		themPhieuNhapItemBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//JOptionPane.showMessageDialog(null, nhaCungCapCmbx.isEnabled());
				int option = JOptionPane.YES_OPTION;
				if(nhaCungCapCmbx.isEnabled()) {
					option = JOptionPane.showConfirmDialog(null, "Phiếu nhập này thuộc về nhà cung cấp "+nhaCungCapCmbx.getSelectedItem()+" phải không?","Xác nhận",JOptionPane.YES_NO_OPTION);
					if(option == JOptionPane.YES_OPTION) {
						nhaCungCapCmbx.setEnabled(false);
					}else {
						JOptionPane.showMessageDialog(null, "Nhập không thành công vì chưa chọn được nhà cung cấp cố định");
					}
				}
				if(!nhaCungCapCmbx.isEnabled() && option == JOptionPane.YES_OPTION){
					if(checkDonGia()&&CheckMa()&&checkSoLuong()) {
						Long thanhTien = Integer.parseInt(soLuongTxt.getText())*Long.parseLong(donGiaTxt.getText());
						Object[] rowData = {themDonNhapBUS.ds_sanPham.get(maSanPhamCmbx.getSelectedItem().toString()), maSanPhamCmbx.getSelectedItem().toString(),
								soLuongTxt.getText(), donGiaTxt.getText(), thanhTien+"" };
						DefaultTableModel model_table = (DefaultTableModel) chiTietPhieuNhapTable.getModel();
						model_table.addRow(rowData);
						tong+=thanhTien;
						tongTienPhieuNhapLbl.setText("Tổng cộng : "+ tong);
						maSanPhamCmbx.setSelectedIndex(0);
						donGiaTxt.setText("");
						soLuongTxt.setText("1");
					}else {
						JOptionPane.showMessageDialog(null, "Nhập không thành công");
					}
				}
			}
		});
		
		MyButton xoaPhieuNhapItemBtn = new MyButton();
		xoaPhieuNhapItemBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectRow = chiTietPhieuNhapTable.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) chiTietPhieuNhapTable.getModel();
				int option = JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn xóa sản phẩm "+chiTietPhieuNhapTable.getValueAt(selectRow, 1),"Xác nhận",JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_OPTION) {
					tong = tong - Long.parseLong(model.getValueAt(selectRow, 4).toString());
					tongTienPhieuNhapLbl.setText("Tổng cộng : "+tong);
					model.removeRow(selectRow);
				}
			}
		});
		xoaPhieuNhapItemBtn.setText("xóa");
		xoaPhieuNhapItemBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("------------------Sản phẩm---------------------");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setForeground(Color.CYAN);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("------------Thông tin phiếu nhập------------");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1.setForeground(Color.CYAN);
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DefaultTableModel model_changeTong = (DefaultTableModel) chiTietPhieuNhapTable.getModel();
		model_changeTong.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				if(chiTietPhieuNhapTable.getRowCount()==0) {
					tong = 0l;
				}
			}
		});
		JLabel lblNewLabel_1 = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(maNhanVienPhieuNhapLbl, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(nhaCungCapCmbx, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(maSanPhamCmbx, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(congBtn, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(soLuongTxt, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(truBtn, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_1_1_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1_1_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_1_1_1_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1_1_1_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(donGiaTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))))
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
					.addGap(18))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(289)
					.addComponent(tongTienPhieuNhapLbl, GroupLayout.PREFERRED_SIZE, 525, GroupLayout.PREFERRED_SIZE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(themPhieuNhapItemBtn, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(xoaPhieuNhapItemBtn, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addGap(127)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
					.addGap(117)
					.addComponent(xemTruocBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(xacNhanPhieuNhapBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(huyBtn, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(12))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(28)
									.addComponent(maNhanVienPhieuNhapLbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(23)
							.addComponent(nhaCungCapCmbx, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(maSanPhamCmbx, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(donGiaTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(lblNewLabel_1_1_1_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(congBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(soLuongTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(1)
									.addComponent(truBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE))
					.addGap(6)
					.addComponent(tongTienPhieuNhapLbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(themPhieuNhapItemBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(xoaPhieuNhapItemBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(xemTruocBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(xacNhanPhieuNhapBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(huyBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(11))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	public boolean checkSoLuong() {
		if(Integer.parseInt(soLuongTxt.getText())<=0) {
			JOptionPane.showMessageDialog(null, "Số lượng phải bằng hoặc lớn hơn 1");
			return false;
		}
		if(soLuongTxt.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Số lượng trống");
			return false;
		}
		return true;
	}
}
