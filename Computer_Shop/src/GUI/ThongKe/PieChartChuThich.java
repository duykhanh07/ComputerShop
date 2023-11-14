package GUI.ThongKe;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;

public class PieChartChuThich extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PieChartChuThich(String text, Color color) {
		setBackground(new Color(102, 102, 102));
		setAlignmentY(0.0f);
		setAlignmentX(0.0f);
		
		JLabel colorBox = new JLabel("");
		colorBox.setBackground(color);
		colorBox.setBorder(new LineBorder(new Color(255, 255, 255)));
		colorBox.setOpaque(true);
		
		JLabel key = new JLabel("New label");
		key.setText(text);
		key.setForeground(new Color(0, 255, 255));
		key.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(colorBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(key, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(colorBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(key, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
		);
		setLayout(groupLayout);

	}
}
