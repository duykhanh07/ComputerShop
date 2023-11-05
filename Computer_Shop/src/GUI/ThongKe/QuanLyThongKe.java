package GUI.ThongKe;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import MyDesign.MyComponents.MyButton;
import javax.swing.SwingConstants;

public class QuanLyThongKe extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public QuanLyThongKe() {
		
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
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setDividerSize(1);
		splitPane_1.setBorder(null);
		splitPane.setRightComponent(splitPane_1);
		
		JPanel BieuDoCotPanel = new JPanel();
		splitPane_1.setLeftComponent(BieuDoCotPanel);
		
		JPanel BieuDoTronPanel = new JPanel();
		splitPane_1.setRightComponent(BieuDoTronPanel);
		splitPane_1.setDividerLocation(440);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 102, 102));
		splitPane.setLeftComponent(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(77, 77, 77));
		panel_1.setForeground(new Color(51, 51, 51));
		panel_1.setBounds(10, 11, 701, 40);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JCheckBox theoThoiGianCheck = new JCheckBox("Theo thời gian");
		theoThoiGianCheck.setFont(new Font("Tahoma", Font.PLAIN, 15));
		theoThoiGianCheck.setBounds(0, 0, 145, 40);
		theoThoiGianCheck.setForeground(Color.CYAN);
		theoThoiGianCheck.setBackground(new Color(77, 77, 77));
		panel_1.add(theoThoiGianCheck);
		
		JLabel lblNewLabel_1 = new JLabel("Chọn năm :");
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(182, 0, 97, 37);
		panel_1.add(lblNewLabel_1);
		
		JComboBox yearCmbx = new JComboBox();
		yearCmbx.setBackground(new Color(51, 51, 51));
		yearCmbx.setBounds(276, 5, 100, 30);
		panel_1.add(yearCmbx);
		
		JLabel lblNewLabel_1_1 = new JLabel("Chọn quý :");
		lblNewLabel_1_1.setForeground(Color.CYAN);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(431, 0, 97, 37);
		panel_1.add(lblNewLabel_1_1);
		
		JComboBox yearCmbx_1 = new JComboBox();
		yearCmbx_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		yearCmbx_1.setBackground(new Color(51, 51, 51));
		yearCmbx_1.setBounds(538, 5, 65, 30);
		panel_1.add(yearCmbx_1);
		
		JCheckBox TheoNhanVienCheck = new JCheckBox("Theo nhân viên");
		TheoNhanVienCheck.setForeground(Color.CYAN);
		TheoNhanVienCheck.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TheoNhanVienCheck.setBackground(new Color(77, 77, 77));
		TheoNhanVienCheck.setBounds(10, 58, 148, 40);
		panel.add(TheoNhanVienCheck);
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(theoThoiGianCheck);
		btnGroup.add(TheoNhanVienCheck);
		
		JCheckBox bieuDoCotCheck = new JCheckBox("Biểu đồ cột");
		bieuDoCotCheck.setForeground(Color.CYAN);
		bieuDoCotCheck.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bieuDoCotCheck.setBackground(new Color(77, 77, 77));
		bieuDoCotCheck.setBounds(405, 58, 148, 40);
		panel.add(bieuDoCotCheck);
		
		JCheckBox bieuDoTronCheck = new JCheckBox("Biểu đồ tròn");
		bieuDoTronCheck.setForeground(Color.CYAN);
		bieuDoTronCheck.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bieuDoTronCheck.setBackground(new Color(77, 77, 77));
		bieuDoTronCheck.setBounds(563, 58, 148, 40);
		panel.add(bieuDoTronCheck);
		
		MyButton refreshButton = new MyButton();
		refreshButton.setText("Làm mới");
		refreshButton.setHorizontalTextPosition(SwingConstants.LEADING);
		refreshButton.setBounds(717, 61, 153, 35);
		panel.add(refreshButton);
		splitPane.setDividerLocation(110);
		setLayout(groupLayout);

	}
}
