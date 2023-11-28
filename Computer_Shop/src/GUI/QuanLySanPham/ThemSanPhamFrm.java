package GUI.QuanLySanPham;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import MyDesign.MyComponents.MyTextfield;
import MyDesign.MyTable.CustomTableCellRenderer;
import MyDesign.MyTable.CustomTableHeaderUI;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.JTextField;
import MyDesign.MyComponents.MyButton;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import BUS.SanPhamBUS;
import DAO.SanPhamDAO;
import DTO.DTO_SanPham;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class ThemSanPhamFrm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private MyTextfield maSanPhamTxt;
	private MyTextfield tenSanPhamTxt;
	private MyTextfield CPUTxt;
	private MyTextfield ramTxt;
	private JTextField romTxt;
	private JTextField cardTxt;
	private MyTextfield manHinhTxt;
	private MyTextfield pinTxt;
	private MyTextfield hangTxt;
	private MyTextfield giaTxt;
	private JComboBox tinhTrangCmbx;
	private SanPhamBUS sp_bus;
	private String relativePath = "/assets/Image/";
	private String maspHientai;
	private ArrayList<DTO_SanPham> listSP = SanPhamDAO.getInstance().selectAll();
	public ArrayList<DTO_SanPham> listHT = new ArrayList<DTO_SanPham>();
	public QuanLySanPhamFrm qlsp;
	DefaultTableModel model;
	int selectrow;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemSanPhamFrm frame = new ThemSanPhamFrm(null);
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
	public ThemSanPhamFrm(QuanLySanPhamFrm qlsp) {
		this.qlsp = qlsp;
		setMinimumSize(new Dimension(1024,740));
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ThemSanPhamFrm.class.getResource("/assets/Laptop_Login.png")));
		setTitle("Thêm sản phẩm");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1024, 742);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(128, 255, 255));
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel_1 = new JLabel("----------Thông tin sản phẩm----------");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblMSnPhm = new JLabel("mã sản phẩm :");
		lblMSnPhm.setForeground(Color.CYAN);
		lblMSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblTnSnPhm = new JLabel("tên sản phẩm :");
		lblTnSnPhm.setForeground(Color.CYAN);
		lblTnSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tenSanPhamTxt = new MyTextfield();
		tenSanPhamTxt.setBackground(new Color(77, 77, 77));
		tenSanPhamTxt.setColumns(10);
		tenSanPhamTxt.setBorder(null);
		
		JLabel lblTnSnPhm_1 = new JLabel("CPU :");
		lblTnSnPhm_1.setForeground(Color.CYAN);
		lblTnSnPhm_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		CPUTxt = new MyTextfield();
		CPUTxt.setBackground(new Color(77, 77, 77));
		CPUTxt.setColumns(10);
		CPUTxt.setBorder(null);
		
		JLabel lblTnSnPhm_2 = new JLabel("ram :");
		lblTnSnPhm_2.setForeground(Color.CYAN);
		lblTnSnPhm_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		ramTxt = new MyTextfield();
		ramTxt.setBackground(new Color(77, 77, 77));
		ramTxt.setColumns(10);
		ramTxt.setBorder(null);
		
		JLabel lblTnSnPhm_3 = new JLabel("bộ nhớ :");
		lblTnSnPhm_3.setForeground(Color.CYAN);
		lblTnSnPhm_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		romTxt = new MyTextfield();
		romTxt.setBackground(new Color(77, 77, 77));
		romTxt.setColumns(10);
		romTxt.setBorder(null);
		
		JLabel lblTnSnPhm_4 = new JLabel("card đồ họa :");
		lblTnSnPhm_4.setForeground(Color.CYAN);
		lblTnSnPhm_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		cardTxt = new MyTextfield();
		cardTxt.setBackground(new Color(77, 77, 77));
		cardTxt.setColumns(10);
		cardTxt.setBorder(null);
		
		JLabel lblTnSnPhm_5 = new JLabel("màn hình:");
		lblTnSnPhm_5.setForeground(Color.CYAN);
		lblTnSnPhm_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		manHinhTxt = new MyTextfield();
		manHinhTxt.setBackground(new Color(77, 77, 77));
		manHinhTxt.setColumns(10);
		manHinhTxt.setBorder(null);
		
		JLabel lblTnSnPhm_6 = new JLabel("pin :");
		lblTnSnPhm_6.setForeground(Color.CYAN);
		lblTnSnPhm_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		pinTxt = new MyTextfield();
		pinTxt.setBackground(new Color(77, 77, 77));
		pinTxt.setColumns(10);
		pinTxt.setBorder(null);
		
		JLabel lblTnSnPhm_7 = new JLabel("hãng :");
		lblTnSnPhm_7.setForeground(Color.CYAN);
		lblTnSnPhm_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		hangTxt = new MyTextfield();
		hangTxt.setBackground(new Color(77, 77, 77));
		hangTxt.setColumns(10);
		hangTxt.setBorder(null);
		
		JLabel lblTnSnPhm_8 = new JLabel("giá :");
		lblTnSnPhm_8.setForeground(Color.CYAN);
		lblTnSnPhm_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		giaTxt = new MyTextfield();
		giaTxt.setBackground(new Color(77, 77, 77));
		giaTxt.setColumns(10);
		giaTxt.setBorder(null);
		
		JLabel lblTnSnPhm_9 = new JLabel("tình trạng :");
		lblTnSnPhm_9.setForeground(Color.CYAN);
		lblTnSnPhm_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel imageLinkTxt = new JLabel("hình ảnh : <image>");
		imageLinkTxt.setForeground(Color.CYAN);
		imageLinkTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyButton themSanPhamBtn = new MyButton();
		themSanPhamBtn.setText("Thêm");
		themSanPhamBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		themSanPhamBtn.addActionListener(new ActionListener() {
		
		
			@Override
			public void actionPerformed(ActionEvent e) {
				DecimalFormat df = new DecimalFormat("#,###₫");
				int tinhtrang=0;
				if (checkField()== 1 && checkDupAdd() == 1) {
					if (tinhTrangCmbx.getSelectedItem() == "đang kinh doanh")
						tinhtrang=1;
					DTO_SanPham sp = new DTO_SanPham(maSanPhamTxt.getText(), tenSanPhamTxt.getText(), relativePath, 
							CPUTxt.getText(), ramTxt.getText(), romTxt.getText(), cardTxt.getText(), manHinhTxt.getText(),
							pinTxt.getText(),hangTxt.getText(), Integer.parseInt(giaTxt.getText()), tinhtrang); 
					//sp_bus.addSP(sp);
					listSP = sp_bus.importToTable(listSP);
					Object[] newRow = {maSanPhamTxt.getText(), tenSanPhamTxt.getText(), relativePath, CPUTxt.getText(),
							ramTxt.getText(), romTxt.getText(), cardTxt.getText(), manHinhTxt.getText(), pinTxt.getText(),
							hangTxt.getText(), df.format(Integer.parseInt(giaTxt.getText())), tinhtrang};
					
					maSanPhamTxt.setText("");
					tenSanPhamTxt.setText("");
					CPUTxt.setText("");
					ramTxt.setText("");
					romTxt.setText("");
					cardTxt.setText("");
					manHinhTxt.setText("");
					pinTxt.setText("");
					hangTxt.setText("");
					giaTxt.setText("");
					tinhTrangCmbx.setSelectedIndex(-1);
					imageLinkTxt.setText("hình ảnh : " );
					lblNewLabel.setIcon(null);
					relativePath = "/assets/Image/";
					model.addRow(newRow);
					listHT.add(sp);
					
				}
				else {
					System.out.println("Failure");
				}
			}
		});
		
		MyButton chonHinhSanPhamBtn = new MyButton();
		chonHinhSanPhamBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String absolutePath, pathname;
				// sử dụng File chooser lấy ra đường dẫn hoặc lấy ra tên rồi tạo đường dẫn cho hình ảnh
				JFileChooser openFileChooser = new JFileChooser();
				openFileChooser.setDialogTitle("Open file");
				
				if (openFileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
					File inputFile=openFileChooser.getSelectedFile();
					
					pathname= inputFile.getName();
					relativePath += pathname;
					System.out.println(relativePath);
					
					imageLinkTxt.setText("hình ảnh : " +relativePath);
					lblNewLabel.setIcon(new ImageIcon(new ImageIcon(QuanLySanPhamFrm.class.getResource(relativePath)).getImage().getScaledInstance(168, 112, Image.SCALE_SMOOTH)));
				}
				else {
					 System.out.println("Không thể mở file!");
				}
				
			}
		});
		chonHinhSanPhamBtn.setIcon(new ImageIcon(ThemSanPhamFrm.class.getResource("/assets/pickImage.png")));
		chonHinhSanPhamBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		tinhTrangCmbx = new JComboBox();
		tinhTrangCmbx.setModel(new DefaultComboBoxModel(new String[] {"đang kinh doanh", "ngưng kinh doanh"}));
		tinhTrangCmbx.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tinhTrangCmbx.setForeground(new Color(0, 255, 255));
		tinhTrangCmbx.setBackground(new Color(102, 102, 102));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(new Color(51,51,51));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		table.getTableHeader().setUI(new CustomTableHeaderUI());
		table.getTableHeader().setFont(new Font("Tahoma",Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
					"mã sản phẩm", "tên sản phẩm", "image", "cpu", "ram", "rom", 
					"card", "màn hình", "pin", "hãng", "giá", "tình trạng"
			}
		));
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		scrollPane.setViewportView(table);
		
		MyButton xacNhanBtn = new MyButton();
		xacNhanBtn.setText("xác nhận");
		xacNhanBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		xacNhanBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				XemTruocThemSanPham xemTruoc = new XemTruocThemSanPham(qlsp);
				xemTruoc.setVisible(true);
				
				for (int i=0;i<listSP.size();i++) {
					xemTruoc.model.addRow(new Object[] {listSP.get(i).getMasp(), listSP.get(i).getTensp(), listSP.get(i).getImage(),
							listSP.get(i).getCpu(), listSP.get(i).getRam(), listSP.get(i).getRom(), listSP.get(i).getCard(),
							listSP.get(i).getManhinh(), listSP.get(i).getPin(), listSP.get(i).getHang(), listSP.get(i).getGia(),
							listSP.get(i).getTinhtrang()});
					
					}
				
				
				for (int i=0;i<listHT.size();i++) {
					xemTruoc.model.addRow(new Object[] {listHT.get(i).getMasp(), listHT.get(i).getTensp(), listHT.get(i).getImage(),
							listHT.get(i).getCpu(),listHT.get(i).getRam(), listHT.get(i).getRom(),listHT.get(i).getCard(),
							listHT.get(i).getManhinh(), listHT.get(i).getPin(), listHT.get(i).getHang(), listHT.get(i).getGia(),
							listHT.get(i).getTinhtrang()});
				}
				if(qlsp!=null) {
					qlsp.refresh();
				}
			}
		});
		MyButton xoaBtn = new MyButton();
		xoaBtn.setText("xóa");
		xoaBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		xoaBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectrow = table.getSelectedRow();
				int reply = JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá không?", "Xoá", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					model.removeRow(selectrow);
				}
			}
		});
		
		maSanPhamTxt = new MyTextfield();
		maSanPhamTxt.setBackground(new Color(77, 77, 77));
		maSanPhamTxt.setColumns(10);
		maSanPhamTxt.setBorder(null);
		
		sp_bus = new SanPhamBUS();
		
		JLabel autoIncreaseLabel = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(79)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(autoIncreaseLabel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblMSnPhm, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(maSanPhamTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(tenSanPhamTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(CPUTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_2, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(ramTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_3, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(romTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_4, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(cardTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_5, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(manHinhTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_6, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(pinTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_7, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(hangTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_8, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(giaTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTnSnPhm_9, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(tinhTrangCmbx, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addComponent(imageLinkTxt, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(300)
							.addComponent(chonHinhSanPhamBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(themSanPhamBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(xoaBtn, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addGap(96)
							.addComponent(xacNhanBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
					.addGap(1))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(autoIncreaseLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
							.addGap(11)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMSnPhm, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(maSanPhamTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(tenSanPhamTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(CPUTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(ramTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(romTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(cardTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(manHinhTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(pinTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_7, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(hangTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_8, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(giaTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTnSnPhm_9, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(tinhTrangCmbx, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(imageLinkTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(chonHinhSanPhamBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(1)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(themSanPhamBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(xoaBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(xacNhanBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))))
					.addGap(11))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public int checkField() {
		int flag=1;
		//kiem tra cac truong du lieu co trong hay khong
		if (maSanPhamTxt.getText().isEmpty()|| tenSanPhamTxt.getText().isEmpty() || CPUTxt.getText().isEmpty()
				|| ramTxt.getText().isEmpty() || romTxt.getText().isEmpty() || cardTxt.getText().isEmpty() 
				|| manHinhTxt.getText().isEmpty() || pinTxt.getText().isEmpty() || hangTxt.getText().isEmpty()
				|| giaTxt.getText().isEmpty() && (tinhTrangCmbx.getSelectedIndex() == -1)) {
			
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
			flag=0;
		}
		
		//kiem tra dau vao cua gia san pham co phai la so hay khong
		if (!(giaTxt.getText().matches("[0-9]+"))) {
			JOptionPane.showMessageDialog(null, "Giá bán phải là số!");
			flag=0;
		}
		
		return flag;
	}
	
	public int checkDupAdd() {
		int flag=1;
		for(int i=0;i<sp_bus.listSP.size();i++) {
			if (maSanPhamTxt.getText().equals(sp_bus.listSP.get(i).getMasp().trim())) {
				
				JOptionPane.showMessageDialog(null,"Mã sản phẩm không thể trùng!");
				flag=0;
			}
		}
		return flag;
	}
}
