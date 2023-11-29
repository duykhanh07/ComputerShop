package GUI.ThongKe;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import MyDesign.MyComponents.MyButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import BUS.ThongKeDoanhThuBUS;
import GUI.ThongKe.BarChart.BarChart;
import GUI.ThongKe.BarChart.ModelBarChart;

import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;

public class ThongKeDoanhThu extends JPanel {

	private static final long serialVersionUID = 1L;
	private PieChart pieChart;
	private Color[] colors = {new Color(255, 46, 126), new Color(255, 107, 69), new Color(255, 171, 5), new Color(213, 45, 183), new Color(96, 80, 220),
							new Color(255, 106, 186), new Color(255, 167, 129), new Color(255, 231, 65), new Color(213, 105, 243), new Color(156, 140, 255)
							};

	private ThongKeDoanhThuBUS tkdt_bus;
	private JPanel chuThichPanel;
	private JComboBox yearCmbx_1_1;
	private JSplitPane splitPane_1;
	private int type = 0;
	private JComboBox yearCmbx;
	private JComboBox yearCmbx_1;
	private JLabel tongDoanhThuLbl;
	private final DecimalFormat format = new DecimalFormat("#,##0.#");
	private JRadioButton quyOptionRad;
	private JRadioButton thangOptionRad;
	private BarChart barChart;
	private JCheckBox bieuDoCotCheck;
	private JCheckBox bieuDoTronCheck;
	/**
	 * Create the panel.
	 */
	public ThongKeDoanhThu() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		
		tkdt_bus = new ThongKeDoanhThuBUS();
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(1);
		splitPane.setBorder(null);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
		);
		
		splitPane_1 = new JSplitPane();
		splitPane_1.setBorder(null);
		splitPane.setRightComponent(splitPane_1);
		
		JPanel BieuDoCotPanel = new JPanel();
		BieuDoCotPanel.setBackground(new Color(102, 102, 102));
		splitPane_1.setLeftComponent(BieuDoCotPanel);
		
		barChart = new BarChart();
		GroupLayout gl_BieuDoCotPanel = new GroupLayout(BieuDoCotPanel);
		gl_BieuDoCotPanel.setHorizontalGroup(
			gl_BieuDoCotPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_BieuDoCotPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(barChart, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_BieuDoCotPanel.setVerticalGroup(
			gl_BieuDoCotPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_BieuDoCotPanel.createSequentialGroup()
					.addGap(11)
					.addComponent(barChart, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
					.addGap(11))
		);
		BieuDoCotPanel.setLayout(gl_BieuDoCotPanel);
		
		JPanel BieuDoTronPanel = new JPanel();
		BieuDoTronPanel.setBackground(new Color(102, 102, 102));
		splitPane_1.setRightComponent(BieuDoTronPanel);
		
		pieChart = new PieChart();
		
		chuThichPanel = new JPanel();
		chuThichPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 255, 255)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 255, 255)));
		chuThichPanel.setBackground(new Color(102, 102, 102));
		GroupLayout gl_BieuDoTronPanel = new GroupLayout(BieuDoTronPanel);
		gl_BieuDoTronPanel.setHorizontalGroup(
			gl_BieuDoTronPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_BieuDoTronPanel.createSequentialGroup()
					.addGap(100)
					.addComponent(pieChart, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(89))
				.addGroup(gl_BieuDoTronPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(chuThichPanel, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_BieuDoTronPanel.setVerticalGroup(
			gl_BieuDoTronPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_BieuDoTronPanel.createSequentialGroup()
					.addGap(86)
					.addComponent(pieChart, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
					.addGap(41)
					.addComponent(chuThichPanel, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addGap(11))
		);
		chuThichPanel.setLayout(new GridLayout(0, 4, 0, 0));
		BieuDoTronPanel.setLayout(gl_BieuDoTronPanel);
		splitPane_1.setDividerLocation(440);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 102, 102));
		splitPane.setLeftComponent(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(77, 77, 77));
		panel_1.setForeground(new Color(51, 51, 51));
		
		JLabel lblNewLabel_1 = new JLabel("Chọn năm :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		yearCmbx = new JComboBox();
		yearCmbx.setBackground(new Color(51, 51, 51));
		
		yearCmbx_1 = new JComboBox();
		yearCmbx_1.setEnabled(false);
		yearCmbx_1.setBackground(new Color(51, 51, 51));
		
		yearCmbx_1_1 = new JComboBox();
		yearCmbx_1_1.setEnabled(false);
		yearCmbx_1_1.setBackground(new Color(51, 51, 51));
		
		thangOptionRad = new JRadioButton("chọn tháng :");
		thangOptionRad.setForeground(new Color(0, 255, 255));
		thangOptionRad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		thangOptionRad.setEnabled(false);
		thangOptionRad.setHorizontalAlignment(SwingConstants.RIGHT);
		
		quyOptionRad = new JRadioButton("chọn quý :");
		quyOptionRad.setSelected(true);
		quyOptionRad.setForeground(new Color(0, 255, 255));
		quyOptionRad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		quyOptionRad.setEnabled(false);
		quyOptionRad.setHorizontalAlignment(SwingConstants.RIGHT);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(thangOptionRad);
		bg.add(quyOptionRad);
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(105, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(yearCmbx, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(quyOptionRad, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(yearCmbx_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(thangOptionRad, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(yearCmbx_1_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(yearCmbx, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(quyOptionRad, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(yearCmbx_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(thangOptionRad, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(yearCmbx_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
		);
		panel_1.setLayout(gl_panel_1);
		
		bieuDoCotCheck = new JCheckBox("Biểu đồ cột");
		bieuDoCotCheck.setSelected(true);
		bieuDoCotCheck.setForeground(Color.CYAN);
		bieuDoCotCheck.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bieuDoCotCheck.setBackground(new Color(77, 77, 77));
		
		bieuDoTronCheck = new JCheckBox("Biểu đồ tròn");
		bieuDoTronCheck.setSelected(true);
		bieuDoTronCheck.setForeground(Color.CYAN);
		bieuDoTronCheck.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bieuDoTronCheck.setBackground(new Color(77, 77, 77));
		
		MyButton refreshButton = new MyButton();
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		refreshButton.setText("Làm mới");
		refreshButton.setHorizontalTextPosition(SwingConstants.LEADING);
		
		tongDoanhThuLbl = new JLabel();
		tongDoanhThuLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		tongDoanhThuLbl.setForeground(Color.CYAN);
		tongDoanhThuLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(tongDoanhThuLbl, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
							.addGap(53)
							.addComponent(bieuDoCotCheck, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(bieuDoTronCheck, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(refreshButton, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)))
					.addGap(10))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(tongDoanhThuLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(bieuDoCotCheck, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
						.addComponent(bieuDoTronCheck, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(refreshButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))))
		);
		panel.setLayout(gl_panel);
		splitPane.setDividerLocation(110);
		setLayout(groupLayout);
		
		loadYearOption();
		loadChart();
		
		
		yearCmbx.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				thongKeTheoNam(yearCmbx.getSelectedItem().toString());
			}
		});
		
		quyOptionRad.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				type = 1;
				yearCmbx_1.setEnabled(true);
				yearCmbx_1.setSelectedIndex(0);
				yearCmbx_1_1.setEnabled(false);
				thongKeTheoQuy(yearCmbx.getSelectedItem().toString(), yearCmbx_1.getSelectedItem().toString());
			}
		});
		
		thangOptionRad.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				type = 2;
				yearCmbx_1_1.setEnabled(true);
				yearCmbx_1_1.setSelectedIndex(0);
				yearCmbx_1.setEnabled(false);
				thongKeTheoThang(yearCmbx.getSelectedItem().toString(), yearCmbx_1_1.getSelectedItem().toString());
			}
		});
		
		yearCmbx_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				thongKeTheoQuy(yearCmbx.getSelectedItem().toString(), yearCmbx_1.getSelectedItem().toString());
			}
		});
		yearCmbx_1_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				thongKeTheoThang(yearCmbx.getSelectedItem().toString(), yearCmbx_1_1.getSelectedItem().toString());
			}
		});
		
		bieuDoCotCheck.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				chinhSplitPane(bieuDoCotCheck);
			}
		});
		bieuDoTronCheck.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chinhSplitPane(bieuDoTronCheck);
			}
		});
	}
	public void loadChart() {
		// xóa dữ liệu cũ
		pieChart.clearData();
		barChart.clearData();
		
		chuThichPanel.removeAll();
		tongDoanhThuLbl.setText("");
		
		
		
		// khởi tạo title cho chú thích
		String chuThichTitle;

		switch(type) {
			case 0:
				chuThichTitle = "năm ";break;
			case 1:
				chuThichTitle = "quý ";break;
			case 2:
				chuThichTitle = "tháng ";break;		
			case 3:
				chuThichTitle = "tháng ";break;	
			case 4:
				chuThichTitle = "ngày ";break;	
			default:
				chuThichTitle = "năm ";break;
		}
		// chỉnh sửa chú thích cho phần chú thích
		chuThichPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 255, 255)), chuThichTitle, TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 255, 255)));
		
		try {
			// khởi tạo màu
			int index = 0;
				
			if(tkdt_bus.result == null) {
				JOptionPane.showMessageDialog(null, "lỗi");
			}
			// lấy dữ liệu vào gắn vào Piechart
			while(tkdt_bus.result.next()) {
				pieChart.addData(new ModelPieChart(chuThichTitle+tkdt_bus.result.getString(1), tkdt_bus.result.getLong(2), colors[index%colors.length]));
				chuThichPanel.add(new PieChartChuThich(tkdt_bus.result.getString(1), colors[index%colors.length]));
			
				barChart.addData(new ModelBarChart(tkdt_bus.result.getString(1), tkdt_bus.result.getLong(2)));
				barChart.addLegend(tkdt_bus.result.getString(1), colors[index++%colors.length]);
			}
			
			// nếu có quá nhiều dữ liệu thì rút ngắn các thành phần nhỏ thành 'khác'
			if(pieChart.getModelsCount() > 10) {
				pieChart.shortenModel();
				chuThichPanel.removeAll();
				
				index = 0;
				for(int i =0; i<pieChart.getModelsCount(); i++) {
					String[] name_split = pieChart.getModels().get(i).getName().split(chuThichTitle);
					String new_name = name_split[name_split.length-1];
					
					pieChart.getModels().get(i).setColor(colors[index%colors.length]);
					chuThichPanel.add(new PieChartChuThich(new_name, colors[index++%colors.length]));
				}
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// hiển thị tổng tiền 
		
		switch(type) {
		case 0:
			tongDoanhThuLbl.setText( String.format("Tổng doanh thu : %sđ", format.format(pieChart.getTotalvalue())));break;
		case 1:
			tongDoanhThuLbl.setText( String.format("Tổng doanh thu năm %s : %sđ",yearCmbx.getSelectedItem().toString(),format.format(pieChart.getTotalvalue())));break;
		case 2:
			tongDoanhThuLbl.setText( String.format("Tổng doanh thu năm %s : %sđ",
					yearCmbx.getSelectedItem().toString(),format.format(pieChart.getTotalvalue())));break;	
		case 3:
			tongDoanhThuLbl.setText( String.format("Tổng doanh thu năm %s quý %s: %sđ",yearCmbx.getSelectedItem().toString(),
					yearCmbx_1.getSelectedItem().toString(),format.format(pieChart.getTotalvalue())));break;
		case 4:
			tongDoanhThuLbl.setText( String.format("Tổng doanh thu năm %s tháng %s: %sđ",yearCmbx.getSelectedItem().toString(),
					yearCmbx_1_1.getSelectedItem().toString(),format.format(pieChart.getTotalvalue())));break;
		default:
			chuThichTitle = "năm ";break;
	}
		
		// chỉnh lại divider
		splitPane_1.setDividerLocation(440);
	}
	public void loadYearOption() {
		yearCmbx.setModel(new DefaultComboBoxModel(tkdt_bus.years));
	}
	public void thongKeTheoNam(String nam) {
		if(nam!="---------") {
			// đổi lựa chọn thống kê
			if(quyOptionRad.isSelected()) {
				type = 1;
				yearCmbx_1.setEnabled(true);
			}else {
				type = 2;
				yearCmbx_1_1.setEnabled(true);
			}
			
			tkdt_bus.thongKeTheoNam(nam,type);
			
			// bật các nút			
			quyOptionRad.setEnabled(true);
			yearCmbx_1.setModel(new DefaultComboBoxModel(tkdt_bus.quaters));
			
			thangOptionRad.setEnabled(true);
			yearCmbx_1_1.setModel(new DefaultComboBoxModel(tkdt_bus.months));
		}else {
			type = 0;
			tkdt_bus = new ThongKeDoanhThuBUS();
			quyOptionRad.setEnabled(false);
			thangOptionRad.setEnabled(false);
			yearCmbx_1.setEnabled(false);
			yearCmbx_1_1.setEnabled(false);
		}
		loadChart();
	}
	
	public void thongKeTheoQuy(String nam, String quy) {
		if(quy!="---------") {
			type = 3;
			tkdt_bus.thongKeTheoQuy(nam, quy);
		}else {
			type = 1;
			tkdt_bus.thongKeTheoNam(nam, 1);
		}
		loadChart();
	}
	
	public void thongKeTheoThang(String nam, String thang) {
		if(thang!="---------") {
			type = 4;
			tkdt_bus.thongKeTheoThang(nam, thang);
		}else {
			type = 2;
			tkdt_bus.thongKeTheoNam(nam, 2);
		}
		loadChart();
	}
	public void refresh() {
		tkdt_bus = new ThongKeDoanhThuBUS();
		yearCmbx.setModel(new DefaultComboBoxModel(tkdt_bus.years));
		quyOptionRad.setSelected(true);
		type = 0;
		loadChart();
	}
	public void chinhSplitPane(JCheckBox check) {
		if(bieuDoCotCheck.isSelected()&&bieuDoTronCheck.isSelected()) {
			splitPane_1.setDividerLocation(splitPane_1.getWidth()/2);
		}else {
			if(bieuDoCotCheck.isSelected()) {
				splitPane_1.setDividerLocation(splitPane_1.getWidth());
			}else if(bieuDoTronCheck.isSelected()) {
				splitPane_1.setDividerLocation(0);
			}else {
				if(check == bieuDoCotCheck) {
					bieuDoTronCheck.doClick();
				}else {
					bieuDoCotCheck.doClick();
				}
			}
		}
	}
}
