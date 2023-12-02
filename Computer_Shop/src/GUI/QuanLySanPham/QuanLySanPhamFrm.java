package GUI.QuanLySanPham;

import javax.swing.JPanel;
import MyDesign.MyComponents.MyTextfield;
import MyDesign.MyTable.CustomTableCellRenderer;
import MyDesign.MyTable.CustomTableHeaderUI;

import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import MyDesign.MyComponents.MyButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableRowSorter;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
import javax.swing.AbstractButton;
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
	
	private ArrayList<JCheckBox> dsHangCheckBox;
	private HashMap<Integer, String> tinhTrangMap;
	private MyTextfield timKiemSanPhamTxt;
	private JComboBox timKiemTypeCmbx_1;
	private JComboBox sortCmbx_1;
	private ArrayList<DTO_SanPham> newlistsp;

	/**
	 * Create the panel.
	 */
	public QuanLySanPhamFrm() {
		QuanLySanPhamFrm self = this;
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
		
		timKiemSanPhamTxt = new MyTextfield();
		timKiemSanPhamTxt.setPreferredSize(new Dimension(180, 35));
		timKiemSanPhamTxt.setColumns(10);
		timKiemSanPhamTxt.setBorder(new EmptyBorder(0, 0, 0, 0));
		timKiemSanPhamTxt.setBackground(new Color(77, 77, 77));
		
		timKiemTypeCmbx_1 = new JComboBox();
		timKiemTypeCmbx_1.setModel(new DefaultComboBoxModel(new String[] {"----------", "Mã sản phẩm", "Tên sản phẩm"}));
		timKiemTypeCmbx_1.setForeground(Color.CYAN);
		timKiemTypeCmbx_1.setBackground(new Color(102, 102, 102));
		
		
		MyButton timKiemBtn_1 = new MyButton();
		
		timKiemBtn_1.setText("Lọc");
		timKiemBtn_1.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel lblNewLabel_1 = new JLabel("Sắp xếp :");
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		sortCmbx_1 = new JComboBox();
		sortCmbx_1.setModel(new DefaultComboBoxModel(new String[] {"----------", "Tên từ A-Z", "Tên từ Z-A", "Giá thấp đến cao", "Giá cao đến thấp"}));
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
					ThemSanPhamFrm themSanPhamFrm = new ThemSanPhamFrm(self);
					themSanPhamFrm.setVisible(true);
				}
			}
		});
		
		MyButton mbtnThmSnPhm = new MyButton();
		mbtnThmSnPhm.setText("thêm sản phẩm với Excel");
		mbtnThmSnPhm.setHorizontalTextPosition(SwingConstants.LEADING);
		
		mbtnThmSnPhm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Excel workbook(.xlsx)","xlsx"));
				jFileChooser.setAcceptAllFileFilterUsed(false); // chi luu file excel,Loai bo viec chon nhung file ko lien quan
				int userSelection = jFileChooser.showOpenDialog(QuanLySanPhamFrm.this); //show hop thoai mo va tra ve quyet dinh cua nguoi dung
				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File fileOpen = jFileChooser.getSelectedFile();
					String fileName = fileOpen.getAbsolutePath();
					import_excel(fileName);
				}
			}
		});
		
		JLabel autoIncreaseSpaceLbl = new JLabel("");
		
		MyButton capNhatSanPhamBtn = new MyButton();
		capNhatSanPhamBtn.setText("cập nhật");
		capNhatSanPhamBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		capNhatSanPhamBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				selectrow = table.getSelectedRow();
				CapNhatSanPhamFrm capNhatSanPhamFrm = new CapNhatSanPhamFrm();
				capNhatSanPhamFrm.setVisible(true);
				
				capNhatSanPhamFrm.maSanPhamTxt.setText(sp_bus.listHT.get(selectrow).getMasp());
				capNhatSanPhamFrm.tenSanPhamTxt.setText(sp_bus.listHT.get(selectrow).getTensp());
				capNhatSanPhamFrm.CPUTxt.setText(sp_bus.listHT.get(selectrow).getCpu());
				capNhatSanPhamFrm.ramTxt.setText(sp_bus.listHT.get(selectrow).getRam());
				capNhatSanPhamFrm.romTxt.setText(sp_bus.listHT.get(selectrow).getRom());
				capNhatSanPhamFrm.cardTxt.setText(sp_bus.listHT.get(selectrow).getCard());
				capNhatSanPhamFrm.manHinhTxt.setText(sp_bus.listHT.get(selectrow).getManhinh());
				capNhatSanPhamFrm.pinTxt.setText(sp_bus.listHT.get(selectrow).getPin());
				capNhatSanPhamFrm.hangTxt.setText(sp_bus.listHT.get(selectrow).getHang());
				capNhatSanPhamFrm.giaTxt.setText(sp_bus.listHT.get(selectrow).getGia()+"");
				capNhatSanPhamFrm.tinhTrangCmbx.setSelectedItem(tinhTrangMap.get(sp_bus.listHT.get(selectrow).getTinhtrang()));
				capNhatSanPhamFrm.imageLinkTxt.setText(sp_bus.listHT.get(selectrow).getImage());
				capNhatSanPhamFrm.lblNewLabel.setIcon(new ImageIcon(new ImageIcon(QuanLySanPhamFrm.class.getResource
					(sp_bus.listHT.get(selectrow).getImage())).getImage().getScaledInstance(168, 112, Image.SCALE_SMOOTH)));

			}
		});
		
		MyButton mbtnLmMi = new MyButton();
		mbtnLmMi.setText("làm mới");
		mbtnLmMi.setHorizontalTextPosition(SwingConstants.LEADING);
		
		mbtnLmMi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				refresh();
				
				
			}
		});
		
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
		panel.revalidate();
		panel.repaint();
		
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
		sp_bus.timKiemSanPham(str.strip().toLowerCase(), index);
		loadSanPhamTable();
		taoDanhSachHang();
	}
	
	public void refresh() {
		this.sp_bus = new SanPhamBUS();
		taoDanhSachHang();
		loadSanPhamTable();
		timKiemSanPhamTxt.setText("");
		timKiemTypeCmbx_1.setSelectedIndex(0);
		sortCmbx_1.setSelectedIndex(0);
	}
	
	public void import_excel(String fileName) {
		try {
			FileInputStream fileInputStream = new FileInputStream(fileName);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet sheet1 = workbook.getSheetAt(0);
			DataFormatter formatter = new DataFormatter();
			
				
			Iterator<Row> row_Iterator = sheet1.iterator();
			Row firstRow = row_Iterator.next();
			Cell firstCell = firstRow.getCell(0);
		
			newlistsp = new ArrayList<DTO_SanPham>();
			
			String ds_sp_loi = "Mã các sản phẩm lỗi thông tin : ";
			
			while(row_Iterator.hasNext()) {
				Row currentRow = row_Iterator.next();
				DTO_SanPham newsp = new DTO_SanPham();
				
				if (validateData(sheet1,currentRow.getRowNum(), 0)) {
					newsp.setMasp(currentRow.getCell(0).getStringCellValue());
					System.out.println(currentRow.getCell(0).getStringCellValue());
				}else
					continue;
				
				if (validateData(sheet1,currentRow.getRowNum(), 1))	
					newsp.setTensp(currentRow.getCell(1).getStringCellValue());
				else {
					ds_sp_loi += currentRow.getCell(0).getStringCellValue()+" ";
					continue;
				}
				
				if (validateData(sheet1,currentRow.getRowNum(), 2))	
					newsp.setImage(currentRow.getCell(2).getStringCellValue());
				else {
					ds_sp_loi += currentRow.getCell(0).getStringCellValue()+" ";
					continue;
				}
				
				if (validateData(sheet1,currentRow.getRowNum(), 3)) 	
					newsp.setCpu(currentRow.getCell(3).getStringCellValue());
				else {
					ds_sp_loi += currentRow.getCell(0).getStringCellValue()+" ";
					continue;
				}
				
				if (validateData(sheet1,currentRow.getRowNum(), 4))	
					newsp.setRam(currentRow.getCell(4).getStringCellValue());
				else {
					ds_sp_loi += currentRow.getCell(0).getStringCellValue()+" ";
					continue;
				}
				
				if (validateData(sheet1,currentRow.getRowNum(), 5))	
					newsp.setRom(currentRow.getCell(5).getStringCellValue());
				else {
					ds_sp_loi += currentRow.getCell(0).getStringCellValue()+" ";
					continue;
				}
				
				if (validateData(sheet1,currentRow.getRowNum(), 6))
					newsp.setCard(currentRow.getCell(6).getStringCellValue());
				else {
					ds_sp_loi += currentRow.getCell(0).getStringCellValue()+" ";
					continue;
				}
				
				if (validateData(sheet1,currentRow.getRowNum(), 7))	
					newsp.setManhinh(currentRow.getCell(7).getStringCellValue());
				else {
					ds_sp_loi += currentRow.getCell(0).getStringCellValue()+" ";
					continue;
				}
				
				if (validateData(sheet1,currentRow.getRowNum(), 8))
					newsp.setPin(currentRow.getCell(8).getStringCellValue());
				else {
					ds_sp_loi += currentRow.getCell(0).getStringCellValue()+" ";
					continue;
				}
				
				if (validateData(sheet1,currentRow.getRowNum(), 9))	
					newsp.setHang(currentRow.getCell(9).getStringCellValue());
				else {
					ds_sp_loi += currentRow.getCell(0).getStringCellValue()+" ";
					continue;
				}
					
				if (validateData(sheet1,currentRow.getRowNum(), 10)) {
					Cell cellGia = currentRow.getCell(10);
					String strGia = formatter.formatCellValue(cellGia);
					newsp.setGia(Integer.parseInt(strGia));
				}
				else {
					ds_sp_loi += currentRow.getCell(0).getStringCellValue()+" ";
					continue;
				}
				
				
				if (validateData(sheet1,currentRow.getRowNum(), 11)) {
				Cell cellTinhtrang = currentRow.getCell(11);
				String strTinhtrang = formatter.formatCellValue(cellTinhtrang);
				newsp.setTinhtrang(Integer.parseInt(strTinhtrang));
				}else {
					ds_sp_loi += currentRow.getCell(0).getStringCellValue()+" ";
					continue;
				}
				
				newlistsp.add(newsp);
				sp_bus.addSP(newsp);
				}
				
				
				
				JOptionPane.showMessageDialog(null, "Import thành công");
				JOptionPane.showMessageDialog(null, ds_sp_loi);
				loadSanPhamExcel();
				workbook.close();
			
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Import thất bại");
		}
	}
		
		

	public void loadSanPhamExcel() {
		DecimalFormat df = new DecimalFormat("#,###₫");
		model = (DefaultTableModel) table.getModel();
		
		for (int i=0;i<newlistsp.size();i++) {
			model.addRow(new Object[] {newlistsp.get(i).getMasp(), newlistsp.get(i).getTensp(), newlistsp.get(i).getCpu(),
					newlistsp.get(i).getRam(), newlistsp.get(i).getRom(),newlistsp.get(i).getCard(), newlistsp.get(i).getHang(),
					df.format(newlistsp.get(i).getGia()), sp_bus.tonKhoMap.get(newlistsp.get(i).getMasp()),
					tinhTrangMap.get(newlistsp.get(i).getTinhtrang())});
		}
	}
	
	public boolean validateData(Sheet sheet,int rowIndex, int cellIndex) {
			Row row = sheet.getRow(rowIndex);
	        Cell cell = row.getCell(cellIndex);

	        // Check if the cell is not empty
	        if (cell == null || cell.getCellType() == CellType.BLANK) {
	            System.out.println("Có ô dữ liệu bị trống ở hàng " + row.getRowNum());
	            return false;
	        } 
	        else {
	            
	            switch (cell.getCellType()) {
	                case STRING:
	                    String stringValue = cell.getStringCellValue();
	                    // Example: Check if a string is not too long
	                    if (stringValue.length() > 50) {
	                        System.out.println("Chuỗi kí tự quá dài ở hàng " + row.getRowNum());
	                        return false;
	                    }
	                    // Add more string-specific validation as needed
	                    break;

	                case NUMERIC:
	                    int numericValue = (int) cell.getNumericCellValue();
	                    // Example: Check if a numeric value is within a specific range
	                    if (numericValue < 0) {
	                        System.out.println("Giá bán phải là số dương ở hàng " + row.getRowNum());
	                        return false;
	                    }
	                    // Add more numeric-specific validation as needed
	                    break;

	                
	            }
	        }    
		return true;
	}
	
}
