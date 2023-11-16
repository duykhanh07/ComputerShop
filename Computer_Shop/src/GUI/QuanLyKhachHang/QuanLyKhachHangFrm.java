package GUI.QuanLyKhachHang;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager.LookAndFeelInfo;

import MyDesign.MyComponents.MyTextfield;
import MyDesign.MyTable.CustomTableCellRenderer;
import MyDesign.MyTable.CustomTableHeaderUI;

import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JComboBox;
import MyDesign.MyComponents.MyButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.QuanLyKhachHangBUS;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

public class QuanLyKhachHangFrm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private QuanLyKhachHangBUS qlkh;

	/**
	 * Create the panel.
	 */
	
// 	TODO : câu lệnh lấy ra thuộc tính ngày cuối cùng mua hàng
//	SELECT kh.*,MAX(ngaylaphd) AS lancuoi
//	FROM khachhang AS kh JOIN hoadon AS hd ON kh.makh = hd.makh
//	GROUP BY kh.makh
	
	public QuanLyKhachHangFrm() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		
		qlkh = new QuanLyKhachHangBUS();
		
		setBackground(new Color(102, 102, 102));
		
		JPanel QLKhachHangPanel = new JPanel();
		QLKhachHangPanel.setBackground(new Color(102, 102, 102));
		
		MyTextfield timKiemKhachHangTxt = new MyTextfield();
		timKiemKhachHangTxt.setPreferredSize(new Dimension(180, 35));
		timKiemKhachHangTxt.setColumns(10);
		timKiemKhachHangTxt.setBorder(new EmptyBorder(0, 0, 0, 0));
		timKiemKhachHangTxt.setBackground(new Color(77, 77, 77));
		
		JComboBox timKiemTypeCmbx_1 = new JComboBox();
		timKiemTypeCmbx_1.setModel(new DefaultComboBoxModel(new String[] {"tên khách hàng", "số điện thoại", "mã khách hàng"}));
		timKiemTypeCmbx_1.setForeground(Color.CYAN);
		timKiemTypeCmbx_1.setBackground(new Color(102, 102, 102));
		
		MyButton timKiemBtn_1 = new MyButton();
		timKiemBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiemKhachHang(timKiemKhachHangTxt.getText(), timKiemTypeCmbx_1.getSelectedIndex());
			}
		});
		timKiemBtn_1.setText("Lọc");
		timKiemBtn_1.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel auto_increase_spaceLbl_3 = new JLabel("");
		
		JLabel lblNewLabel_1 = new JLabel("Sắp xếp :");
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox sortCmbx_1 = new JComboBox();
		sortCmbx_1.setModel(new DefaultComboBoxModel(new String[] {"----------", "tên khách hàng (A -> Z)", "tên khách hàng (Z -> A)", "điểm (thấp -> cao)", "điểm (cao -> thấp)", "lần cuối mua (từ lâu)", "lần cuối mua (gần đây)"}));
		sortCmbx_1.setForeground(Color.CYAN);
		sortCmbx_1.setBackground(new Color(102, 102, 102));
		sortCmbx_1.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				sapXepKhachHang(sortCmbx_1.getSelectedIndex());
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.getViewport().setBackground(new Color(51,51,51));
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBorder(new LineBorder(new Color(130, 135, 144)));
		
		table = new JTable();
		table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		table.getTableHeader().setUI(new CustomTableHeaderUI());
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"m\u00E3 kh\u00E1ch h\u00E0ng", "t\u00EAn kh\u00E1ch h\u00E0ng", "s\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0111i\u1EC3m", "l\u1EA7n cu\u1ED1i c\u00F9ng mua h\u00E0ng"
			}
		));
		scrollPane_1.setViewportView(table);
		
		MyButton timKiemBtn_1_1 = new MyButton();
		timKiemBtn_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// cập nhật khách hàng được chọn trong bảng
				new updateKhachHangFrm().setVisible(true);
			}
		});
		timKiemBtn_1_1.setText("Cập nhật");
		timKiemBtn_1_1.setHorizontalTextPosition(SwingConstants.LEADING);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(QLKhachHangPanel, GroupLayout.PREFERRED_SIZE, 860, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addComponent(QLKhachHangPanel, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		MyButton mbtnLmMi = new MyButton();
		mbtnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qlkh = new QuanLyKhachHangBUS();
				loadKhachHangTable();
			}
		});
		mbtnLmMi.setIcon(new ImageIcon(QuanLyKhachHangFrm.class.getResource("/assets/reset.png")));
		mbtnLmMi.setText("làm mới");
		mbtnLmMi.setHorizontalTextPosition(SwingConstants.LEADING);
		GroupLayout gl_QLKhachHangPanel = new GroupLayout(QLKhachHangPanel);
		gl_QLKhachHangPanel.setHorizontalGroup(
			gl_QLKhachHangPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_QLKhachHangPanel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_QLKhachHangPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_QLKhachHangPanel.createSequentialGroup()
							.addGap(10)
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_QLKhachHangPanel.createSequentialGroup()
							.addGroup(gl_QLKhachHangPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_QLKhachHangPanel.createSequentialGroup()
									.addComponent(timKiemKhachHangTxt, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(timKiemTypeCmbx_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(timKiemBtn_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(8)
									.addComponent(mbtnLmMi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(auto_increase_spaceLbl_3, GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
									.addGap(10)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(sortCmbx_1, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
								.addComponent(timKiemBtn_1_1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
							.addGap(10))))
		);
		gl_QLKhachHangPanel.setVerticalGroup(
			gl_QLKhachHangPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_QLKhachHangPanel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_QLKhachHangPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(timKiemKhachHangTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(timKiemTypeCmbx_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_QLKhachHangPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(timKiemBtn_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_QLKhachHangPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(mbtnLmMi, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addComponent(auto_increase_spaceLbl_3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_QLKhachHangPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(sortCmbx_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(timKiemBtn_1_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(9))
		);
		QLKhachHangPanel.setLayout(gl_QLKhachHangPanel);
		setLayout(groupLayout);
		
		loadKhachHangTable();
	}
	public void loadKhachHangTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY 		HH:mm:ss");
		model.setRowCount(0);
		for(int i = 0; i<qlkh.ds_hienThi.size(); i++) {
			String lancuoi_str = df.format(qlkh.ds_lanCuoi.get(qlkh.ds_hienThi.get(i).getMakh()));
			model.addRow(new Object[]{qlkh.ds_hienThi.get(i).getMakh(), qlkh.ds_hienThi.get(i).getTenkh(), 
					qlkh.ds_hienThi.get(i).getSdt(), qlkh.ds_hienThi.get(i).getDiem(), lancuoi_str});
		}
	}
	public void sapXepKhachHang(int selectedIndex) {
		qlkh.sapXepKhachHang(selectedIndex);
		loadKhachHangTable();
	}
	public void timKiemKhachHang(String thongtin, int selectedIndex) {
		if(thongtin.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin tìm kiếm");
		}else {
			qlkh.timKiemKhachHang(thongtin, selectedIndex);
			loadKhachHangTable();
		}
	}
}
