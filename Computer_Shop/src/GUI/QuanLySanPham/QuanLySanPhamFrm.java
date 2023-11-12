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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import BUS.SanPhamBUS;
import DTO.DTO_SanPham;


import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;

public class QuanLySanPhamFrm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JPanel panel;
	public ArrayList<DTO_SanPham> listSP;
	private TableRowSorter<DefaultTableModel> sort;
	Object [][]data;
	String col[] = {"Mã sản phẩm", "Tên sản phẩm", "Image", "CPU", "RAM", "ROM", 
			"Card", "Màn hình", "Pin", "Hãng", "Giá", "Tình trạng"};
	DefaultTableModel model;
	int selectrow;
	

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
		
		MyTextfield timKiemKhachHangTxt = new MyTextfield();
		timKiemKhachHangTxt.setPreferredSize(new Dimension(180, 35));
		timKiemKhachHangTxt.setColumns(10);
		timKiemKhachHangTxt.setBorder(new EmptyBorder(0, 0, 0, 0));
		timKiemKhachHangTxt.setBackground(new Color(77, 77, 77));
		
		JComboBox timKiemTypeCmbx_1 = new JComboBox();
		timKiemTypeCmbx_1.setForeground(Color.CYAN);
		timKiemTypeCmbx_1.setBackground(new Color(102, 102, 102));
		
		MyButton timKiemBtn_1 = new MyButton();
		timKiemBtn_1.setText("Lọc");
		timKiemBtn_1.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel lblNewLabel_1 = new JLabel("Sắp xếp :");
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox sortCmbx_1 = new JComboBox();
		sortCmbx_1.setForeground(Color.CYAN);
		sortCmbx_1.setBackground(new Color(102, 102, 102));
		
		JLabel auto_increase_spaceLbl_3 = new JLabel("");
		auto_increase_spaceLbl_3.setBackground(new Color(102, 102, 102));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.getViewport().setBackground(new Color(51,51,51));
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBorder(new LineBorder(new Color(130, 135, 144)));
		
		//table
		//import from database
		listSP = SanPhamBUS.getInstance().importToTable(listSP);
		data = new Object[listSP.size()][col.length];
		for (int i=0;i<listSP.size();i++) {
			data[i][0] = (listSP.get(i).getMasp()).trim();
			data[i][1] = (listSP.get(i).getTensp()).trim();
			data[i][2] = (listSP.get(i).getImage()).trim();
			data[i][3] = (listSP.get(i).getCpu()).trim();
			data[i][4] = (listSP.get(i).getRam()).trim();
			data[i][5] = (listSP.get(i).getRom()).trim();
			data[i][6] = (listSP.get(i).getCard()).trim();
			data[i][7] = (listSP.get(i).getManhinh()).trim();
			data[i][8] = (listSP.get(i).getPin()).trim();
			data[i][9] = (listSP.get(i).getHang()).trim();
			data[i][10] = listSP.get(i).getGia();
			data[i][11] = listSP.get(i).getTinhtrang();
		}
		
		
		model = new DefaultTableModel(data, col);
		sort = new TableRowSorter<DefaultTableModel>(model);
		table = new JTable(model);
		table.setDefaultEditor(Object.class, null);
		table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		table.getTableHeader().setUI(new CustomTableHeaderUI());
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setRowSorter(sort);
		scrollPane_1.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				selectrow = table.getSelectedRow();
				ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
				chiTietSanPham.setVisible(true);
				//chi la dong code de test xem khi an vao 1 dong no co nhan thong tin k
				String sp=model.getValueAt(selectrow, 0).toString();
				
				chiTietSanPham.maSanPhamLbl.setText("Mã sản phẩm: "+model.getValueAt(selectrow, 0).toString());
				chiTietSanPham.tenSanPhamLbl.setText("Tên sản phẩm: "+model.getValueAt(selectrow, 1).toString());
				chiTietSanPham.lblHnhnh.setText("Hình ảnh: "+model.getValueAt(selectrow, 2).toString());
				chiTietSanPham.CPULbl.setText("CPU: "+model.getValueAt(selectrow, 3).toString());
				chiTietSanPham.ramLbl.setText("RAM: "+model.getValueAt(selectrow, 4).toString());
				chiTietSanPham.romLbl.setText("Bộ nhớ: "+model.getValueAt(selectrow, 5).toString());
				chiTietSanPham.cardLbl.setText("Card đồ hoạ: "+model.getValueAt(selectrow, 6).toString());
				chiTietSanPham.manHinhLbl.setText("Màn hình: "+model.getValueAt(selectrow, 7).toString());
				chiTietSanPham.pinLbl.setText("Pin: "+model.getValueAt(selectrow, 8).toString());
				chiTietSanPham.hangLbl.setText("Hãng: "+model.getValueAt(selectrow, 9).toString());
				chiTietSanPham.giaLbl.setText("Giá: "+model.getValueAt(selectrow, 10).toString());
				chiTietSanPham.tinhTrangLbl.setText("Tình trạng: "+model.getValueAt(selectrow, 11).toString());
				
				chiTietSanPham.lblNewLabel.setIcon(new ImageIcon(new ImageIcon(QuanLySanPhamFrm.class.getResource(model.getValueAt(
						selectrow, 2).toString())).getImage().getScaledInstance(168, 112, Image.SCALE_SMOOTH)));
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
		
		MyButton mbtnThmSnPhm = new MyButton();
		mbtnThmSnPhm.setText("thêm sản phẩm với Excel");
		mbtnThmSnPhm.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel autoIncreaseSpaceLbl = new JLabel("");
		
		MyButton capNhatSanPhamBtn = new MyButton();
		capNhatSanPhamBtn.setText("cập nhật");
		capNhatSanPhamBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
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
							.addComponent(timKiemKhachHangTxt, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
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
						.addComponent(timKiemKhachHangTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
		setLayout(groupLayout);
		taoDanhSachHang();

	}
	public void taoDanhSachHang() {
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("ACER");
		chckbxNewCheckBox.setForeground(new Color(0, 255, 255));
		chckbxNewCheckBox.setBackground(new Color(77, 77, 77));
		panel.add(chckbxNewCheckBox);
		chckbxNewCheckBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					filterByBrand(model);
				}
			}
		});
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("ASUS");
		chckbxNewCheckBox_1.setForeground(new Color(0, 255, 255));
		chckbxNewCheckBox_1.setBackground(new Color(77, 77, 77));
		panel.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("HP");
		chckbxNewCheckBox_1_1.setForeground(new Color(0, 255, 255));
		chckbxNewCheckBox_1_1.setBackground(new Color(77, 77, 77));
		panel.add(chckbxNewCheckBox_1_1);
		
		JCheckBox chckbxNewCheckBox_1_2 = new JCheckBox("Intel");
		chckbxNewCheckBox_1_2.setForeground(new Color(0, 255, 255));
		chckbxNewCheckBox_1_2.setBackground(new Color(77, 77, 77));
		panel.add(chckbxNewCheckBox_1_2);
		
		JCheckBox chckbxNewCheckBox_1_3 = new JCheckBox("Lenovo");
		chckbxNewCheckBox_1_3.setForeground(new Color(0, 255, 255));
		chckbxNewCheckBox_1_3.setBackground(new Color(77, 77, 77));
		panel.add(chckbxNewCheckBox_1_3);
	}
	
	private static void filterByBrand(DefaultTableModel model) {
        for (int i = 0; i < model.getRowCount(); i++) {
            String brand =  model.getValueAt(i, 9).toString();
            if (brand.equals("Asus") || brand.equals("Acer") || brand.equals("HP") || brand.equals("Intel") || brand.equals("Lenovo")) {
                model.removeRow(i);
                //i--; 
            }
        }
    }
}
