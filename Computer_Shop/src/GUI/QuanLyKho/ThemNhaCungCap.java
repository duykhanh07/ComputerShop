package GUI.QuanLyKho;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import MyDesign.MyComponents.MyTextfield;
import MyDesign.MyTable.CustomTableCellRenderer;
import MyDesign.MyTable.CustomTableHeaderUI;
import MyDesign.MyComponents.MyButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.NhaCungCapBUS;
import DTO.DTO_NhaCungCap;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ThemNhaCungCap extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	MyTextfield donGiaTxt;
	public static DefaultTableModel model1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemNhaCungCap frame = new ThemNhaCungCap();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ThemNhaCungCap() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ThemDonNhapFrm.class.getResource("/assets/Laptop_Login.png")));
		setTitle("Thêm Nhà cung cấp");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(840, 609);
		setMinimumSize(new Dimension(840, 609));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("------------Thông tin nhà cung cấp------------");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1.setForeground(Color.CYAN);
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(new Color(51,51,51));
		scrollPane.setBackground(new Color(51,51,51));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JLabel lblMNhCung = new JLabel("mã nhà cung cấp :");
		lblMNhCung.setForeground(Color.CYAN);
		lblMNhCung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		donGiaTxt = new MyTextfield();
		donGiaTxt.setColumns(10);
		donGiaTxt.setBorder(null);
		donGiaTxt.setEditable(false);
		//Tạo mã nhà cung cấp
		setMancc();
		
		JLabel lblTnNhCung = new JLabel("tên nhà cung cấp :");
		lblTnNhCung.setForeground(Color.CYAN);
		lblTnNhCung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield donGiaTxt_1 = new MyTextfield();
		donGiaTxt_1.setColumns(10);
		donGiaTxt_1.setBorder(null);
		
		JLabel lblSinThoi = new JLabel("số điện thoại:");
		lblSinThoi.setForeground(Color.CYAN);
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyTextfield donGiaTxt_1_1 = new MyTextfield();
		donGiaTxt_1_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c))
					e.consume();
			}
		});
		donGiaTxt_1_1.setColumns(10);
		donGiaTxt_1_1.setBorder(null);
		
		JLabel lblaCh = new JLabel("địa chỉ : ");
		lblaCh.setForeground(Color.CYAN);
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		MyTextfield donGiaTxt_1_1_1 = new MyTextfield();
		donGiaTxt_1_1_1.setColumns(10);
		donGiaTxt_1_1_1.setBorder(null);
		
		MyButton themNhaCungCapBtn = new MyButton();
		themNhaCungCapBtn.setText("Thêm");
		themNhaCungCapBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		themNhaCungCapBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String mancc = donGiaTxt.getText();
				String tenncc = donGiaTxt_1.getText();
				String sdt = donGiaTxt_1_1.getText();
				String diachi = donGiaTxt_1_1_1.getText();
				if(sdt.equalsIgnoreCase("") || mancc.equalsIgnoreCase("") || tenncc.equalsIgnoreCase("") || diachi.equalsIgnoreCase(""))
				{
					JOptionPane.showMessageDialog(null, "Dữ liệu nhập vào không được để trống!!!");
				}
				else if(sdt.charAt(0) != '0' || sdt.length() != 10)
				{
					JOptionPane.showMessageDialog(null, "Số điện thoại nhập vào không hợp lệ!!!");
					donGiaTxt_1_1.requestFocus();
				}
				else
				{
					arr_sample.add( new DTO_NhaCungCap(mancc, tenncc, sdt, diachi));
					loadNhaCungCap();
					setMancc();
					
					//làm mới ô nhập dữ liệu form nhà cung cấp
					donGiaTxt_1.setText("");
					donGiaTxt_1_1.setText("");
					donGiaTxt_1_1_1.setText("");
				}
			}
		});
		
		MyButton xoaNhaCungCapItemBtn = new MyButton();
		xoaNhaCungCapItemBtn.setText("Xóa");
		xoaNhaCungCapItemBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		//Xóa 1 nhà cung cấp vừa thêm trên form (chưa lưu vào Database)
		xoaNhaCungCapItemBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				arr_sample.remove(table.getSelectedRow());
				
				//Chỉnh sửa mã nhà cung cấp
				for(int i=0; i < arr_sample.size(); i++)
				{
					int count = arr_ncc.size() + (i+1);
					
					if(count > 0 && count < 10)
						arr_sample.get(i).setMancc("CC000" + String.valueOf(count));
					else if(count >= 10 && count < 100)
						donGiaTxt.setText("CC00" + String.valueOf(count));
					else if(count >= 100 && count <= 999)
						arr_sample.get(i).setMancc("CC0" + String.valueOf(count));
					else if(count >= 1000 && count <= 9999)
						arr_sample.get(i).setMancc("CC" + String.valueOf(count));
					
				}
				loadNhaCungCap();
				setMancc();
			}
		});
		
		MyButton xemTruocBtn = new MyButton();
		xemTruocBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new XemTruocKhoFrm().setVisible(true);
			}
		});
		xemTruocBtn.setText("Xem trước");
		xemTruocBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		//Hiển thị danh sách nhà cung cấp vừa thêm (chưa lưu vào Database) lên form "Xem trước"
		xemTruocBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				XemTruocKhoFrm.transferArrayList(arr_sample);
			}
		});
		
		MyButton xacThemNhaCungCapBtn = new MyButton();
		xacThemNhaCungCapBtn.setText("Xác nhận");
		xacThemNhaCungCapBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		xacThemNhaCungCapBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Kiểm tra bảng có dữ liệu không
				if(arr_sample.size() == 0)
				{
					JOptionPane.showMessageDialog(null, "Không tìm thấy dữ liệu từ bảng để thêm vào Database!!!");
					return;
				}
				
				int result = JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn lưu vào Database???", "Xác nhận", JOptionPane.OK_CANCEL_OPTION);
				//Biến kiểm tra thêm thành công hay không?
				int check;
				if(result == JOptionPane.OK_OPTION)
				{
					//Thêm dữ liệu vào Database
					for(DTO_NhaCungCap x: arr_sample)
					{
						check = nhacungcapbus.insert_NhaCungCap(x);
						
						//Kiểm tra lệnh thêm dữ liệu có bị lỗi không???
						if(check != 1)
						{
							System.out.println("Thêm không thành công!!!");
							return;
						}
					}
					arr_sample.clear();
					loadNhaCungCap();
				}
			}
		});
		
		MyButton huyBtn = new MyButton();
		huyBtn.setText("hủy");
		huyBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		//Xử lý sự kiện hiển thị danh sách nhà cung cấp theo kiểu sắp xếp đã chọn
		huyBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JLabel autoIncreaseSizeLbl = new JLabel("");
		
		MyButton mbtnRefresh = new MyButton();
		//Làm mới ô nhập dữ liệu form thêm nhà cung cấp
		mbtnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				donGiaTxt_1.setText("");
				donGiaTxt_1_1.setText("");
				donGiaTxt_1_1_1.setText("");
				loadNhaCungCap();
			}
		});
		mbtnRefresh.setText("Refresh");
		mbtnRefresh.setHorizontalTextPosition(SwingConstants.LEADING);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMNhCung, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addComponent(donGiaTxt, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTnNhCung, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addComponent(donGiaTxt_1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addComponent(donGiaTxt_1_1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblaCh, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addComponent(donGiaTxt_1_1_1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(themNhaCungCapBtn, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(xoaNhaCungCapItemBtn, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(mbtnRefresh, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(autoIncreaseSizeLbl, GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(xemTruocBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(xacThemNhaCungCapBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(huyBtn, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)))
					.addGap(10))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(27)
									.addComponent(lblMNhCung, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
							.addGap(10)
							.addComponent(donGiaTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblTnNhCung, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(donGiaTxt_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(donGiaTxt_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblaCh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(donGiaTxt_1_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(mbtnRefresh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(themNhaCungCapBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addComponent(xoaNhaCungCapItemBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(autoIncreaseSizeLbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(xemTruocBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(xacThemNhaCungCapBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(huyBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(16))
		);
		
		table = new JTable();
		table.getTableHeader().setUI(new CustomTableHeaderUI());
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"m\u00E3 nh\u00E0 cung c\u1EA5p", "t\u00EAn nh\u00E0 cung c\u1EA5p", "s\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0111\u1ECBa ch\u1EC9"
			}
		));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
	
	//Mảng chứa nhà cung cấp vừa nhập vào form (chưa thêm vào Database)
	public static ArrayList <DTO_NhaCungCap> arr_sample = new ArrayList<DTO_NhaCungCap>();
	
	//Khai báo instance để sử dụng các phương thức NhaCungCapBUS
	NhaCungCapBUS nhacungcapbus = new NhaCungCapBUS();
	
	//Mảng chứa các nhà cung cấp lấy từ Database
	ArrayList <DTO_NhaCungCap> arr_ncc = nhacungcapbus.get_AllNhaCungCap();
	
	
	//Tạo mã nhà cung cấp tự động vào JTextField
	public void setMancc()
	{
		int count = arr_sample.size() + arr_ncc.size() + 1;
		
		if(count > 0 && count < 10)
			donGiaTxt.setText("CC000" + String.valueOf(count));
		else if(count >= 10 && count < 100)
			donGiaTxt.setText("CC00" + String.valueOf(count));
		else if(count >= 100 && count <= 999)
			donGiaTxt.setText("CC0" + String.valueOf(count));
		else if(count >= 1000 && count <= 9999)
			donGiaTxt.setText("CC" + String.valueOf(count));
	}
	
	//Thêm nhà cung cấp vào form (chưa lưu vào Database)
	public void loadNhaCungCap()
	{
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for(DTO_NhaCungCap x: arr_sample)
		{
			model.addRow(new Object[] {x.getMancc(), x.getTenncc(), x.getSdt(), x.getDiachi()});
		}
	}
}
