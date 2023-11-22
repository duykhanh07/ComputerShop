package GUI.ThongKe;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

import MyDesign.MyTabPane.MyTabbedPaneCustom;
import MyDesign.MyTable.CustomTableCellRenderer;
import MyDesign.MyTable.CustomTableHeaderUI;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.BUS_ThongKeDoanhSo;
import DAO.DAO_ThongKeDoanhSo;
import DTO.DTO_CTDonNhap;
import DTO.DTO_CTHoaDon;

import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import MyDesign.MyComponents.MyButton;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ScrollPaneConstants;

import javax.swing.JFrame;

public class ThongKeDoanhSo extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;
	JComboBox yearCmbx = new JComboBox();
	JComboBox yearCmbx_1 = new JComboBox();
	JComboBox yearCmbx_1_1 = new JComboBox();
	JPanel bieuDoLoiNhuan = new JPanel();
	private BUS_ThongKeDoanhSo busThongKe = new BUS_ThongKeDoanhSo();

	/**
	 * Create the panel.
	 */
	public ThongKeDoanhSo() {
		setBackground(new Color(102, 102, 102));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(77, 77, 77));
		panel.setBorder(new LineBorder(new Color(0, 255, 255)));

		JLabel lblNewLabel_1 = new JLabel("Chọn năm :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		yearCmbx.setModel(new DefaultComboBoxModel(new String[] { "---" }));
		yearCmbx.setBackground(new Color(51, 51, 51));

		JLabel lblNewLabel_1_1 = new JLabel("Chọn quý :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setForeground(Color.CYAN);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		yearCmbx_1.setModel(new DefaultComboBoxModel(new String[] { "---", "1", "2", "3", "4" }));
		yearCmbx_1.setBackground(new Color(51, 51, 51));

		JLabel lblNewLabel_1_1_1 = new JLabel("Chọn tháng :");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setForeground(Color.CYAN);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		yearCmbx_1_1.setBackground(new Color(51, 51, 51));
		yearCmbx_1_1.setModel(new DefaultComboBoxModel(
				new String[] { "---", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

		MyButton refreshButton = new MyButton();
		refreshButton.setText("Làm mới");
		refreshButton.setHorizontalTextPosition(SwingConstants.LEADING);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
								.addGap(7)
								.addComponent(yearCmbx, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addGap(8)
								.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
								.addGap(21)
								.addComponent(yearCmbx_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(lblNewLabel_1_1_1, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
								.addGap(10)
								.addComponent(yearCmbx_1_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addGap(50)
								.addComponent(refreshButton, GroupLayout.PREFERRED_SIZE, 153,
										GroupLayout.PREFERRED_SIZE)
								.addGap(8)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addGap(5)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 30,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
								.addGap(5)
								.addComponent(yearCmbx, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
								.addGap(2)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 37,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
								.addGap(5)
								.addComponent(yearCmbx_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
								.addGap(5)
								.addComponent(yearCmbx_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
								.addGap(5)
								.addComponent(refreshButton, GroupLayout.PREFERRED_SIZE, 30,
										GroupLayout.PREFERRED_SIZE)));
		panel.setLayout(gl_panel);

		MyTabbedPaneCustom tabbedPane = new MyTabbedPaneCustom();

		JPanel bangDoanhSoPanel = new JPanel();
		bangDoanhSoPanel.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("Doanh số sản phẩm", null, bangDoanhSoPanel, null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.getViewport().setBackground(new Color(51, 51, 51));

		table = new JTable();
		table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		table.getTableHeader().setUI(new CustomTableHeaderUI());
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null },
				},
				new String[] {
						"m\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m",
						"s\u1ED1 l\u01B0\u1EE3ng b\u00E1n ra"
				}));
		scrollPane.setViewportView(table);

		MyButton mbtnIn_1 = new MyButton();
		mbtnIn_1.setText("in");
		mbtnIn_1.setHorizontalTextPosition(SwingConstants.LEADING);
		GroupLayout gl_bangDoanhSoPanel = new GroupLayout(bangDoanhSoPanel);
		gl_bangDoanhSoPanel.setHorizontalGroup(
				gl_bangDoanhSoPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_bangDoanhSoPanel.createSequentialGroup()
								.addGap(10)
								.addGroup(gl_bangDoanhSoPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
										.addComponent(mbtnIn_1, GroupLayout.PREFERRED_SIZE, 90,
												GroupLayout.PREFERRED_SIZE))
								.addGap(10)));
		gl_bangDoanhSoPanel.setVerticalGroup(
				gl_bangDoanhSoPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_bangDoanhSoPanel.createSequentialGroup()
								.addGap(11)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
								.addGap(9)
								.addComponent(mbtnIn_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGap(11)));
		bangDoanhSoPanel.setLayout(gl_bangDoanhSoPanel);

		bieuDoLoiNhuan.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("Biểu đồ lợi nhuận", null, bieuDoLoiNhuan, null);
		bieuDoLoiNhuan.setLayout(new BorderLayout());

		drawProfitChart(bieuDoLoiNhuan);

		JPanel DoanhSoNhanVien = new JPanel();
		DoanhSoNhanVien.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("doanh số bán hành", null, DoanhSoNhanVien, null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.getViewport().setBackground(new Color(51, 51, 51));

		table_1 = new JTable();
		table_1.getTableHeader().setUI(new CustomTableHeaderUI());
		table_1.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_1.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		table_1.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null },
				},
				new String[] {
						"m\u00E3 nh\u00E2n vi\u00EAn", "t\u00EAn nh\u00E2n vi\u00EAn",
						"s\u1ED1 \u0111\u01A1n b\u00E1n \u0111\u01B0\u1EE3c", "doanh thu"
				}));
		scrollPane_1.setViewportView(table_1);

		MyButton mbtnIn = new MyButton();
		mbtnIn.setText("in");
		mbtnIn.setHorizontalTextPosition(SwingConstants.LEADING);
		GroupLayout gl_DoanhSoNhanVien = new GroupLayout(DoanhSoNhanVien);
		gl_DoanhSoNhanVien.setHorizontalGroup(
				gl_DoanhSoNhanVien.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_DoanhSoNhanVien.createSequentialGroup()
								.addGap(10)
								.addGroup(gl_DoanhSoNhanVien.createParallelGroup(Alignment.LEADING)
										.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
										.addComponent(mbtnIn, GroupLayout.PREFERRED_SIZE, 90,
												GroupLayout.PREFERRED_SIZE))
								.addGap(10)));
		gl_DoanhSoNhanVien.setVerticalGroup(
				gl_DoanhSoNhanVien.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_DoanhSoNhanVien.createSequentialGroup()
								.addGap(11)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
								.addGap(11)
								.addComponent(mbtnIn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGap(9)));
		DoanhSoNhanVien.setLayout(gl_DoanhSoNhanVien);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(10)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(panel, GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
										.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
								.addGap(10)));
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(11)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGap(11)
								.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGap(11)));
		setLayout(groupLayout);

		List<String> yearsList = DAO_ThongKeDoanhSo.getDistinctYearsFromSanPham();
		for (String year : yearsList) {
			yearCmbx.addItem(year);
		}

		yearCmbx.setSelectedItem("---");
		yearCmbx_1.setSelectedItem("---");
		yearCmbx_1_1.setSelectedItem("---");

		DefaultTableModel model = new DefaultTableModel(
				new Object[][] {
						{ null, null, null },
				},
				new String[] {
						"Mã sản phẩm", "Tên sản phẩm", "Số lượng bán ra"
				});

		yearCmbx_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String selectedQuarter = (String) yearCmbx_1.getSelectedItem();
				if (!selectedQuarter.equals("---")) {
					// Lấy số quý đã chọn
					int quarter = Integer.parseInt(selectedQuarter);

					// Xác định các tháng tương ứng với quý đã chọn
					String[] months;
					switch (quarter) {
						case 1:
							months = new String[] { "1", "2", "3" };
							break;
						case 2:
							months = new String[] { "4", "5", "6" };
							break;
						case 3:
							months = new String[] { "7", "8", "9" };
							break;
						case 4:
							months = new String[] { "10", "11", "12" };
							break;
						default:
							months = new String[] { "---" };
							break;
					}

					// Cập nhật combobox tháng với danh sách tháng tương ứng
					yearCmbx_1_1.setModel(new DefaultComboBoxModel(months));
				}
			}
		});

		yearCmbx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedYear = yearCmbx.getSelectedItem().toString();
				if (!selectedYear.equals("---") && yearCmbx_1.getSelectedItem().toString().equals("---")
						&& yearCmbx_1_1.getSelectedItem().toString().equals("---")) {
					int year = Integer.parseInt(selectedYear);
					hienThiSanPhamDaBanTheoNam(year);
				}
			}
		});

		yearCmbx_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedYear = yearCmbx.getSelectedItem().toString();
				String selectedQuarter = yearCmbx_1.getSelectedItem().toString();
				String selectedMonth = yearCmbx_1_1.getSelectedItem().toString();
				if (!selectedYear.equals("---") && !selectedQuarter.equals("---")
						&& selectedMonth.equals("---")) {
					int year = Integer.parseInt(selectedYear);
					int quarter = Integer.parseInt(selectedQuarter);
					hienThiSanPhamDaBanTheoQuy(year, quarter);
				}
			}
		});

		yearCmbx_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedYear = yearCmbx.getSelectedItem().toString();
				String selectedQuarter = yearCmbx_1.getSelectedItem().toString();
				String selectedMonth = yearCmbx_1_1.getSelectedItem().toString();
				if (!selectedYear.equals("---") && !selectedQuarter.equals("---")
						&& !selectedMonth.equals("---")) {
					int year = Integer.parseInt(selectedYear);
					int quarter = Integer.parseInt(selectedQuarter);
					int month = Integer.parseInt(selectedMonth);
					hienThiSanPhamDaBanTheoThang(year, quarter, month);
				}
			}
		});

		
		
		
		List<Object[]> salesData = BUS_ThongKeDoanhSo.getSalesData();
		updateTableFromSalesData(salesData);

	}

	private void hienThiSanPhamDaBanTheoNam(int selectedYear) {
		List<Object[]> danhSachSanPham = busThongKe.getSanPhamDaBanTheoNam(selectedYear);
		hienThiDanhSachSanPhamLenBang(danhSachSanPham);
	}

	private void hienThiSanPhamDaBanTheoQuy(int selectedYear, int selectedQuarter) {
		List<Object[]> danhSachSanPham = busThongKe.getSanPhamDaBanTheoQuy(selectedYear, selectedQuarter);
		hienThiDanhSachSanPhamLenBang(danhSachSanPham);
	}

	private void hienThiSanPhamDaBanTheoThang(int selectedYear, int selectedQuarter, int selectedMonth) {
		List<Object[]> danhSachSanPham = busThongKe.getSanPhamDaBanTheoThangTrongQuy(selectedYear, selectedQuarter,
				selectedMonth);
		hienThiDanhSachSanPhamLenBang(danhSachSanPham);
	}

	private void hienThiDanhSachSanPhamLenBang(List<Object[]> danhSachSanPham) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		for (Object[] sanPham : danhSachSanPham) {
			model.addRow(sanPham);
		}
	}

	private void drawProfitChart(JPanel panel) {
		List<DTO_CTHoaDon> cthdData = BUS_ThongKeDoanhSo.getCTHDData();
		JPanel chartPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();

				int barWidth = 30;
				int padding = 10;
				int startX = 50;
				int startY = getHeight() - 50;

				g2d.setColor(Color.BLUE);
				int x = startX;
				for (DTO_CTHoaDon cthd : cthdData) {
					int height = (int) (cthd.getDongia() * cthd.getSolg());
					g2d.fillRect(x, startY - height, barWidth, height);
					x += barWidth + padding;
				}
				g2d.dispose();
			}
		};
		chartPanel.setPreferredSize(new Dimension(500, 300)); // Kích thước của biểu đồ, điều chỉnh theo ý muốn

		panel.add(chartPanel, BorderLayout.CENTER);

	}

	private void updateTableFromSalesData(List<Object[]> data) {
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		model.setRowCount(0); // Xóa tất cả các dòng cũ trong bảng

		// Duyệt qua danh sách dữ liệu từ lớp BUS và thêm vào bảng
		for (Object[] row : data) {
			model.addRow(row);
		}
	}

}