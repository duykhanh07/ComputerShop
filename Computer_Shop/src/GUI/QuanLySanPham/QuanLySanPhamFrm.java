package GUI.QuanLySanPham;

import javax.swing.JPanel;
import MyDesign.MyComponents.MyTextfield;
import MyDesign.MyTable.CustomTableCellRenderer;
import MyDesign.MyTable.CustomTableHeaderUI;

import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JComboBox;
import MyDesign.MyComponents.MyButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableRowSorter;

import BUS.SanPhamBUS;
import DTO.DTO_SanPham;


import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RowFilter;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.DefaultComboBoxModel;

public class QuanLySanPhamFrm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JPanel panel;
	private SanPhamBUS sp_bus;
	Object [][]data;
	String col[] = {"Mã sản phẩm", "Tên sản phẩm", "Image", "CPU", "RAM", "ROM", 
			"Card", "Màn hình", "Pin", "Hãng", "Giá", "Tình trạng"};
	DefaultTableModel model;
	int selectrow;
	private Map<JCheckBox, String> brandCheckboxMap;
	private ArrayList<JCheckBox> dsHangCheckBox;
	private HashMap<Integer, String> tinhTrangMap;

	/**
	 * Create the panel.
	 */
	public QuanLySanPhamFrm() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		setBackground(new Color(102, 102, 102));
		
		initTinhTrangMap();
		
		MyTextfield timKiemSanPhamTxt = new MyTextfield();
		timKiemSanPhamTxt.setPreferredSize(new Dimension(180, 35));
		timKiemSanPhamTxt.setColumns(10);
		timKiemSanPhamTxt.setBorder(new EmptyBorder(0, 0, 0, 0));
		timKiemSanPhamTxt.setBackground(new Color(77, 77, 77));
		
		JComboBox timKiemTypeCmbx_1 = new JComboBox();
		timKiemTypeCmbx_1.setModel(new DefaultComboBoxModel(new String[] {"<Chọn loại>", "Mã sản phẩm", "Tên sản phẩm"}));
		timKiemTypeCmbx_1.setForeground(Color.CYAN);
		timKiemTypeCmbx_1.setBackground(new Color(102, 102, 102));
		
		
		MyButton timKiemBtn_1 = new MyButton();
		
		timKiemBtn_1.setText("Lọc");
		timKiemBtn_1.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel lblNewLabel_1 = new JLabel("Sắp xếp :");
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox sortCmbx_1 = new JComboBox();
		sortCmbx_1.setModel(new DefaultComboBoxModel(new String[] {"---------", "Tên từ A-Z", "Tên từ Z-A", "Giá thấp đến cao", "Giá cao đến thấp"}));
		sortCmbx_1.setForeground(Color.CYAN);
		sortCmbx_1.setBackground(new Color(102, 102, 102));
		
		JLabel auto_increase_spaceLbl_3 = new JLabel("");
		auto_increase_spaceLbl_3.setBackground(new Color(102, 102, 102));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.getViewport().setBackground(new Color(51,51,51));
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBorder(new LineBorder(new Color(130, 135, 144)));
		
		sp_bus= new SanPhamBUS();
				
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"m\u00E3 s\u1EA3n ph\u1EA9m", "t\u00EAn s\u1EA3n ph\u1EA9m", "cpu", "ram", "rom", "card", "h\u00E3ng", "gi\u00E1", "s\u1ED1 l\u01B0\u1EE3ng", "t\u00ECnh tr\u1EA1ng"
			}
		));
		table.setDefaultEditor(Object.class, null);
		table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		table.getTableHeader().setUI(new CustomTableHeaderUI());
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane_1.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DecimalFormat df = new DecimalFormat("#,###₫");
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				selectrow = table.getSelectedRow();
				ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
				chiTietSanPham.setVisible(true);
				//chi la dong code de test xem khi an vao 1 dong no co nhan thong tin k
				String sp=model.getValueAt(selectrow, 0).toString();
				
				chiTietSanPham.maSanPhamLbl.setText("Mã sản phẩm: "+sp_bus.listHT.get(selectrow).getMasp());
				chiTietSanPham.tenSanPhamLbl.setText("Tên sản phẩm: "+sp_bus.listHT.get(selectrow).getTensp());
				chiTietSanPham.lblHnhnh.setText("Hình ảnh: "+sp_bus.listHT.get(selectrow).getImage());
				chiTietSanPham.CPULbl.setText("CPU: "+sp_bus.listHT.get(selectrow).getCpu());
				chiTietSanPham.ramLbl.setText("RAM: "+sp_bus.listHT.get(selectrow).getRam());
				chiTietSanPham.romLbl.setText("Bộ nhớ: "+sp_bus.listHT.get(selectrow).getRom());
				chiTietSanPham.cardLbl.setText("Card đồ hoạ: "+sp_bus.listHT.get(selectrow).getCard());
				chiTietSanPham.manHinhLbl.setText("Màn hình: "+sp_bus.listHT.get(selectrow).getManhinh());
				chiTietSanPham.pinLbl.setText("Pin: "+sp_bus.listHT.get(selectrow).getPin());
				chiTietSanPham.hangLbl.setText("Hãng: "+sp_bus.listHT.get(selectrow).getHang());
				chiTietSanPham.giaLbl.setText("Giá: "+df.format(sp_bus.listHT.get(selectrow).getGia()));
				chiTietSanPham.tinhTrangLbl.setText("Tình trạng: "+tinhTrangMap.get(sp_bus.listHT.get(selectrow).getTinhtrang()));
				
				chiTietSanPham.lblNewLabel.setIcon(new ImageIcon(new ImageIcon(QuanLySanPhamFrm.class.getResource(sp_bus.listHT.get(selectrow).getImage())).getImage().getScaledInstance(168, 112, Image.SCALE_SMOOTH)));
				System.out.println(sp);
				
				
			}
		});
		
		// tạo danh sách các checkbox của các hãng sãn phẩm trong kho
		panel = new JPanel();
		panel.setForeground(new Color(0, 255, 255));
		panel.setBackground(new Color(77, 77, 77));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setToolTipText("các hãng laptop");
		
		MyButton themSanPhamBtn = new MyButton();
		themSanPhamBtn.setText("Thêm"); 
		themSanPhamBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		themSanPhamBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==themSanPhamBtn) {
					ThemSanPhamFrm themSanPhamFrm = new ThemSanPhamFrm();
					themSanPhamFrm.setVisible(true);
				}
			}
		});
		
		MyButton mbtnThmSnPhm = new MyButton();
		mbtnThmSnPhm.setText("thêm sản phẩm với Excel");
		mbtnThmSnPhm.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel autoIncreaseSpaceLbl = new JLabel("");
		
		MyButton capNhatSanPhamBtn = new MyButton();
		capNhatSanPhamBtn.setText("cập nhật");
		capNhatSanPhamBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		capNhatSanPhamBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == capNhatSanPhamBtn) {
				CapNhatSanPhamFrm capNhatSanPhamFrm = new CapNhatSanPhamFrm();
				capNhatSanPhamFrm.setVisible(true);
				}
			}
		});
		
		MyButton mbtnLmMi = new MyButton();
		mbtnLmMi.setText("làm mới");
		mbtnLmMi.setHorizontalTextPosition(SwingConstants.LEADING);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(timKiemSanPhamTxt, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(timKiemTypeCmbx_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(timKiemBtn_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(mbtnLmMi, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(auto_increase_spaceLbl_3, GroupLayout.DEFAULT_SIZE, 8, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(sortCmbx_1, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(themSanPhamBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(capNhatSanPhamBtn, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(68)
							.addComponent(autoIncreaseSpaceLbl, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(mbtnThmSnPhm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(5))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(timKiemSanPhamTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(timKiemTypeCmbx_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(timKiemBtn_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(mbtnLmMi, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addComponent(auto_increase_spaceLbl_3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(sortCmbx_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(themSanPhamBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(capNhatSanPhamBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(autoIncreaseSpaceLbl, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(mbtnThmSnPhm, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(11))
		);
		
		sortCmbx_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				sapXepSanPham(sortCmbx_1.getSelectedIndex());
				
			}
		});
		
		timKiemBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiemSanPham(timKiemSanPhamTxt.getText().toLowerCase().trim(),timKiemTypeCmbx_1.getSelectedIndex());
			}
		});
		
		setLayout(groupLayout);
		taoDanhSachHang();
		loadSanPhamTable();

	}
	private void initTinhTrangMap() {
		tinhTrangMap = new HashMap<Integer, String>();
		tinhTrangMap.put(0, "Ngưng kinh doanh");
		tinhTrangMap.put(1, "Đang kinh doanh");
		
	}
	public void taoDanhSachHang() {
		
		dsHangCheckBox = new ArrayList<JCheckBox>();
		panel.removeAll();
		ArrayList<String> layDSHang = sp_bus.getBrand();
		for (String hang:layDSHang) {
			JCheckBox chckbxNewCheckBox = new JCheckBox(hang);
			chckbxNewCheckBox.setForeground(new Color(0, 255, 255));
			chckbxNewCheckBox.setBackground(new Color(77, 77, 77));
			chckbxNewCheckBox.setSelected(true);
			panel.add(chckbxNewCheckBox);
			dsHangCheckBox.add(chckbxNewCheckBox);
		}
		
		// TODO : gan chuc nang cho checkbox hang
		
		for(int i =0 ;i < dsHangCheckBox.size(); i++) {
			dsHangCheckBox.get(i).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					filterByBrand();
				}
			});
		}			
	}
	public void loadSanPhamTable() {
		DecimalFormat df = new DecimalFormat("#,###₫");
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (int i=0;i<sp_bus.listHT.size();i++) {
			model.addRow(new Object[] {sp_bus.listHT.get(i).getMasp(), sp_bus.listHT.get(i).getTensp(),
					sp_bus.listHT.get(i).getCpu(), sp_bus.listHT.get(i).getRam(), sp_bus.listHT.get(i).getRom(),sp_bus.listHT.get(i).getCard(),
					sp_bus.listHT.get(i).getHang(),df.format(sp_bus.listHT.get(i).getGia()),
					sp_bus.tonKhoMap.get(sp_bus.listHT.get(i).getMasp()), tinhTrangMap.get(sp_bus.listHT.get(i).getTinhtrang())});
		}
	}
	public void filterByBrand() {
		ArrayList<String> brands = new ArrayList<String>();
		for(int i = 0;i < dsHangCheckBox.size();i++) {
			if(dsHangCheckBox.get(i).isSelected()) {
				brands.add(dsHangCheckBox.get(i).getText());
			}
		}
		sp_bus.filterByBrand(brands);
		loadSanPhamTable();
	}
	
	public void sapXepSanPham(int index) {
		sp_bus.sapXepSanPham(index);
		loadSanPhamTable();
		
	}
	public void timKiemSanPham(String str, int index) {
		sp_bus.timKiemSanPham(str, index);
		loadSanPhamTable();
	}
}
