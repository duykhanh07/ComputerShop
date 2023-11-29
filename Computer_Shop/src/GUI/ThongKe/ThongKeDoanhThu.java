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
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import MyDesign.MyComponents.MyButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class ThongKeDoanhThu extends JPanel {

	private static final long serialVersionUID = 1L;

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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(77, 77, 77));
		panel_1.setForeground(new Color(51, 51, 51));
		
		JCheckBox theoThoiGianCheck = new JCheckBox("Theo thời gian");
		theoThoiGianCheck.setFont(new Font("Tahoma", Font.PLAIN, 15));
		theoThoiGianCheck.setForeground(Color.CYAN);
		theoThoiGianCheck.setBackground(new Color(77, 77, 77));
		
		JLabel lblNewLabel_1 = new JLabel("Chọn năm :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox yearCmbx = new JComboBox();
		yearCmbx.setBackground(new Color(51, 51, 51));
		
		JLabel lblNewLabel_1_1 = new JLabel("Chọn quý :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setForeground(Color.CYAN);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox yearCmbx_1 = new JComboBox();
		yearCmbx_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		yearCmbx_1.setBackground(new Color(51, 51, 51));
		
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Chọn tháng :");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setForeground(Color.CYAN);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox yearCmbx_1_1 = new JComboBox();
		yearCmbx_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		yearCmbx_1_1.setBackground(new Color(51, 51, 51));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(theoThoiGianCheck, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(yearCmbx, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(yearCmbx_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1_1_1, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(yearCmbx_1_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(60))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(theoThoiGianCheck, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(yearCmbx, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(yearCmbx_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(yearCmbx_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
		);
		panel_1.setLayout(gl_panel_1);
		
		JCheckBox bieuDoCotCheck = new JCheckBox("Biểu đồ cột");
		bieuDoCotCheck.setForeground(Color.CYAN);
		bieuDoCotCheck.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bieuDoCotCheck.setBackground(new Color(77, 77, 77));
		
		JCheckBox bieuDoTronCheck = new JCheckBox("Biểu đồ tròn");
		bieuDoTronCheck.setForeground(Color.CYAN);
		bieuDoTronCheck.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bieuDoTronCheck.setBackground(new Color(77, 77, 77));
		
		MyButton refreshButton = new MyButton();
		refreshButton.setText("Làm mới");
		refreshButton.setHorizontalTextPosition(SwingConstants.LEADING);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(405)
					.addComponent(bieuDoCotCheck, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(bieuDoTronCheck, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(refreshButton, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addGap(10))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(bieuDoCotCheck, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(bieuDoTronCheck, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(refreshButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))))
		);
		panel.setLayout(gl_panel);
		splitPane.setDividerLocation(110);
		setLayout(groupLayout);

	}
}
