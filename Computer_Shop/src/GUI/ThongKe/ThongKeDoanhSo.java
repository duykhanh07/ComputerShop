package GUI.ThongKe;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileOutputStream;
import java.util.List;
import java.awt.FileDialog;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import MyDesign.MyTabPane.MyTabbedPaneCustom;
import MyDesign.MyTable.CustomTableCellRenderer;
import MyDesign.MyTable.CustomTableHeaderUI;
import MyDesign.MyComponents.MyButton;
import BUS.BUS_ThongKeDoanhSo;
import DAO.DAO_ThongKeDoanhSo;

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

		yearCmbx.setSelectedItem("---");
		yearCmbx_1.setSelectedItem("---");
		yearCmbx_1_1.setSelectedItem("---");

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
						"Mã sản phẩm", "Tên sản phẩm", "Số lượng bán ra"
				}));

		scrollPane.setViewportView(table);

		MyButton mbtnIn_1 = new MyButton();
		mbtnIn_1.setText("In");
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

		JPanel DoanhSoNhanVien = new JPanel();
		DoanhSoNhanVien.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("Doanh số bán hàng", null, DoanhSoNhanVien, null);

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
						"Mã nhân viên", "Tên nhân viên", "Số đơn bán được", "Doanh thu"
				}));
		scrollPane_1.setViewportView(table_1);

		MyButton mbtnIn = new MyButton();
		mbtnIn.setText("In");
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
					int quarter = Integer.parseInt(selectedQuarter);

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

					yearCmbx_1_1.setModel(new DefaultComboBoxModel(months));
				}
			}
		});

		yearCmbx.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateTableData();
			}
		});

		yearCmbx_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateTableData();
			}
		});

		yearCmbx_1_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateTableData();
			}
		});

		yearCmbx.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String selectedOption = (String) yearCmbx.getSelectedItem();
					if (selectedOption.equals("---")) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);

						SwingUtilities.invokeLater(new Runnable() {
							@Override
							public void run() {
								bieuDoLoiNhuan.removeAll();
								bieuDoLoiNhuan.revalidate();
								bieuDoLoiNhuan.repaint();
							}
						});
					}
				}
			}
		});

		List<Object[]> DSsalesData = BUS_ThongKeDoanhSo.getSalesData();
		updateTableFromSalesData(DSsalesData);

		tabbedPane.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if (tabbedPane.getSelectedComponent() == bieuDoLoiNhuan) {
					yearCmbx.setEnabled(true);
					yearCmbx_1.setEnabled(false);
					yearCmbx_1_1.setEnabled(false);
				} else if (tabbedPane.getSelectedComponent() == DoanhSoNhanVien) {
					yearCmbx.setSelectedItem("---");
					yearCmbx_1.setSelectedItem("---");
					yearCmbx_1_1.setSelectedItem("---");

					yearCmbx.setEnabled(false);
					yearCmbx_1.setEnabled(false);
					yearCmbx_1_1.setEnabled(false);
				} else {
					yearCmbx.setEnabled(true);
					yearCmbx_1.setEnabled(true);
					yearCmbx_1_1.setEnabled(true);
				}
			}
		});

		mbtnIn_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog fileDialog = new FileDialog((Frame) null, "Chọn nơi lưu file", FileDialog.SAVE);
				fileDialog.setVisible(true);

				String directory = fileDialog.getDirectory();
				String file = fileDialog.getFile();

				if (directory != null && file != null) {
					try {
						String filePath = directory + file;

						XSSFWorkbook workbook = new XSSFWorkbook();
						XSSFSheet sheet = workbook.createSheet("Danh sách sản phẩm");

						DefaultTableModel model = (DefaultTableModel) table.getModel();
						int rowCount = model.getRowCount();
						int columnCount = model.getColumnCount();

						XSSFRow headerRow = sheet.createRow(0);
						for (int col = 0; col < columnCount; col++) {
							Cell cell = headerRow.createCell(col);
							cell.setCellValue(model.getColumnName(col));
						}

						for (int row = 0; row < rowCount; row++) {
							XSSFRow excelRow = sheet.createRow(row + 1);
							for (int col = 0; col < columnCount; col++) {
								Cell cell = excelRow.createCell(col);
								cell.setCellValue(model.getValueAt(row, col).toString());
							}
						}

						FileOutputStream fileOut = new FileOutputStream(filePath + ".xlsx");
						workbook.write(fileOut);
						fileOut.close();
						workbook.close();

						// Hiển thị thông báo khi xuất file thành công
						JOptionPane.showMessageDialog(null, "File Excel đã được tạo thành công!");

						System.out.println("File Excel đã được tạo thành công!");
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		mbtnIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog fileDialog = new FileDialog((Frame) null, "Chọn nơi lưu file", FileDialog.SAVE);
				fileDialog.setVisible(true);

				String directory = fileDialog.getDirectory();
				String file = fileDialog.getFile();

				if (directory != null && file != null) {
					try {
						String filePath = directory + file;

						XSSFWorkbook workbook = new XSSFWorkbook();
						XSSFSheet sheet = workbook.createSheet("Danh sách nhân viên");

						DefaultTableModel model = (DefaultTableModel) table_1.getModel();
						int rowCount = model.getRowCount();
						int columnCount = model.getColumnCount();

						XSSFRow headerRow = sheet.createRow(0);
						for (int col = 0; col < columnCount; col++) {
							Cell cell = headerRow.createCell(col);
							cell.setCellValue(model.getColumnName(col));
						}

						for (int row = 0; row < rowCount; row++) {
							XSSFRow excelRow = sheet.createRow(row + 1);
							for (int col = 0; col < columnCount; col++) {
								Cell cell = excelRow.createCell(col);
								cell.setCellValue(model.getValueAt(row, col).toString());
							}
						}

						FileOutputStream fileOut = new FileOutputStream(filePath + ".xlsx");
						workbook.write(fileOut);
						fileOut.close();
						workbook.close();

						System.out.println("File Excel đã được tạo thành công!");

						// Hiển thị thông báo khi xuất file thành công
						JOptionPane.showMessageDialog(null, "File Excel đã được tạo thành công!");

					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		refreshButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
				modelTable.setRowCount(0);

				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						bieuDoLoiNhuan.removeAll();
						bieuDoLoiNhuan.revalidate();
						bieuDoLoiNhuan.repaint();
					}
				});

				yearCmbx.setSelectedItem("---");
				yearCmbx_1.setSelectedItem("---");
				yearCmbx_1_1.setModel(new DefaultComboBoxModel(new String[] { "---" }));
				yearCmbx_1_1.setSelectedItem("---");
			}
		});

	}

	private void hienThiSanPhamDaBanTheoNam(int selectedYear) {
		List<Object[]> danhSachSanPham = busThongKe.getSanPhamDaBanTheoNam(selectedYear);
		hienThiDanhSachSanPhamLenBang(danhSachSanPham);
	}

	private void hienThiDanhSachSanPhamLenBang(List<Object[]> danhSachSanPham) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		for (Object[] sanPham : danhSachSanPham) {
			model.addRow(sanPham);
		}
	}

	private void updateTableData() {
		String selectedYear = (String) yearCmbx.getSelectedItem();
		String selectedQuarter = (String) yearCmbx_1.getSelectedItem();
		String selectedMonth = (String) yearCmbx_1_1.getSelectedItem();

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		if (!selectedYear.equals("---")) {
			if (selectedQuarter.equals("---") && selectedMonth.equals("---")) {
				hienThiBieuDoSanPhamDaBanTrongNam(Integer.parseInt(selectedYear));
				List<Object[]> danhSach = DAO_ThongKeDoanhSo.getSanPhamDaBanTheoNam(Integer.parseInt(selectedYear));
				hienThiDanhSachSanPhamLenBang(danhSach);
			} else if (!selectedQuarter.equals("---") && selectedMonth.equals("---")) {
				List<Object[]> danhSach = DAO_ThongKeDoanhSo.getSanPhamDaBanTheoQuy(Integer.parseInt(selectedYear),
						Integer.parseInt(selectedQuarter));
				hienThiDanhSachSanPhamLenBang(danhSach);
			} else if (!selectedQuarter.equals("---") && !selectedMonth.equals("---")) {
				List<Object[]> danhSach = DAO_ThongKeDoanhSo.getSanPhamDaBanTheoThang(Integer.parseInt(selectedYear),
						Integer.parseInt(selectedQuarter), Integer.parseInt(selectedMonth));
				hienThiDanhSachSanPhamLenBang(danhSach);
			} else if (selectedQuarter.equals("---") && !selectedMonth.equals("---")) {
				List<Object[]> danhSach = DAO_ThongKeDoanhSo.getSanPhamDaBan(Integer.parseInt(selectedYear),
						Integer.parseInt(selectedMonth));
				hienThiDanhSachSanPhamLenBang(danhSach);
			}
		}
	}

	private void updateTableFromSalesData(List<Object[]> data) {

		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		model.setRowCount(0);

		for (Object[] row : data) {
			model.addRow(row);
		}
	}

	private void hienThiBieuDoSanPhamDaBanTrongNam(int selectedYear) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		List<Object[]> danhSachSanPham = busThongKe.getSanPhamDaBanTheoNam(selectedYear);

		for (Object[] sanPham : danhSachSanPham) {
			String maSP = (String) sanPham[0];
			int soLuong = (int) sanPham[2];

			dataset.addValue(soLuong, "Mã Sản phẩm", maSP);
		}

		JFreeChart barChart = ChartFactory.createBarChart(
				"Sản phẩm đã bán trong năm " + selectedYear,
				"Mã sản phẩm",
				"Số lượng bán ra",
				dataset,
				PlotOrientation.VERTICAL,
				true, true, false);

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(800, 400));
		bieuDoLoiNhuan.removeAll();

		bieuDoLoiNhuan.add(chartPanel, BorderLayout.CENTER);
		bieuDoLoiNhuan.validate();
	}

}