package GUI.QuanLySanPham;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ScrollPaneConstants;
import MyDesign.MyComponents.MyButton;
import MyDesign.MyTable.CustomTableCellRenderer;
import MyDesign.MyTable.CustomTableHeaderUI;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import BUS.SanPhamBUS;
import DAO.SanPhamDAO;
import DTO.DTO_SanPham;
import GUI.MainForm;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class XemTruocThemSanPham extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	public DefaultTableModel model;
	private SanPhamBUS sp_bus;
	private HashMap<Integer, String> tinhTrangMap;
	public QuanLySanPhamFrm qlsp;
	private ArrayList<DTO_SanPham> listSP = SanPhamDAO.getInstance().selectAll();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XemTruocThemSanPham frame = new XemTruocThemSanPham(null);
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
	public XemTruocThemSanPham(QuanLySanPhamFrm qlsp) {
		this.qlsp = qlsp;
		ThemSanPhamFrm themSanPhamFrm = new ThemSanPhamFrm(qlsp);
		setIconImage(Toolkit.getDefaultToolkit().getImage(XemTruocThemSanPham.class.getResource("/assets/Laptop_Login.png")));
		setTitle("Xem trước thêm sản phẩm");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1024, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.getViewport().setBackground(new Color(51,51,51));
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBorder(new LineBorder(new Color(130, 135, 144)));
		
		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		table.getTableHeader().setUI(new CustomTableHeaderUI());
		table.getTableHeader().setFont(new Font("Tahoma",Font.PLAIN,15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
					"mã sản phẩm", "tên sản phẩm", "image", "cpu", "ram", "rom", 
					"card", "màn hình", "pin", "hãng", "giá", "tình trạng"
			}
		));
		model = (DefaultTableModel)table.getModel();
		model.setRowCount(0);
		sp_bus = new SanPhamBUS();
		scrollPane_1.setViewportView(table);
		
		MyButton huyBtn = new MyButton();
		huyBtn.setText("hủy");
		huyBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		huyBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int reply =JOptionPane.showConfirmDialog(null, "Bạn có muốn huỷ không?", "Huỷ", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					setVisible(false);
				}
			}
		});
		
		MyButton xacNhanBtn = new MyButton();
		xacNhanBtn.setText("Xác nhận");		
		xacNhanBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		xacNhanBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sp_bus = new SanPhamBUS();
				
				for (int i=listSP.size();i<model.getRowCount();i++) { 
					String masp = model.getValueAt(i,0).toString();
					String tensp = model.getValueAt(i, 1).toString(); 
					String image = model.getValueAt(i, 2).toString();
					
					String[] image_split = image.split("\\\\");
					String image_name = image_split[image_split.length - 1];
					
					
					ProtectionDomain protectionDomain = XemTruocThemSanPham.class.getProtectionDomain();
			        CodeSource codeSource = protectionDomain.getCodeSource();
			        
			        if (codeSource != null) {
			        	
		                try {
		                	URL location = codeSource.getLocation();
					        File desFile = new File(location.toURI().getPath() +"../src/assets/Image/" + image_name);
							Path path = desFile.toPath();
							Files.copy(Path.of(image),path, StandardCopyOption.COPY_ATTRIBUTES);
							
							System.out.println();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			        }
			        image = "/assets/Image/"+image_name;
					String cpu = model.getValueAt(i,3).toString(); 
					String ram = model.getValueAt(i, 4).toString(); 
					String rom =model.getValueAt(i, 5).toString(); 
					String card = model.getValueAt(i,6).toString(); 
					String manhinh = model.getValueAt(i, 7).toString();
					String pin = model.getValueAt(i, 8).toString(); 
					String hang = model.getValueAt(i,9).toString();
					int gia = (int) model.getValueAt(i, 10); 
					int tinhtrang = (int) model.getValueAt(i, 11);
				  
					DTO_SanPham sp = new DTO_SanPham(masp, tensp, image, cpu, ram, rom, card,
				  manhinh , pin, hang, gia, tinhtrang); 
					sp_bus.addSP(sp); 
				 }
				 
				
				
				if(qlsp != null) {
					qlsp.refresh();
					JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Thêm thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
					.addGap(8))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(636)
					.addComponent(xacNhanBtn, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(huyBtn, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(8))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(xacNhanBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(huyBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(9))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
}
