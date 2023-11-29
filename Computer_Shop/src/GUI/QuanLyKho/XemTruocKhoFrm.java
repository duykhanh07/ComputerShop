package GUI.QuanLyKho;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.TableHeaderUI;

import MyDesign.MyTabPane.MyTabbedPaneCustom;
import MyDesign.MyTable.CustomTableCellRenderer;
import MyDesign.MyTable.CustomTableHeaderUI;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import MyDesign.MyComponents.MyButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.Toolkit;

public class XemTruocKhoFrm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XemTruocKhoFrm frame = new XemTruocKhoFrm();
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
	public XemTruocKhoFrm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(XemTruocKhoFrm.class.getResource("/assets/Laptop_Login.png")));
		setTitle("Xem trước");
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(920, 642);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		
		JLabel lblXemTrc = new JLabel("XEM TRƯỚC ");
		lblXemTrc.setOpaque(true);
		lblXemTrc.setHorizontalAlignment(SwingConstants.CENTER);
		lblXemTrc.setForeground(new Color(0, 204, 204));
		lblXemTrc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblXemTrc.setBackground(new Color(255, 255, 102));
		lblXemTrc.setAlignmentY(0.0f);
		
		MyTabbedPaneCustom tabbedPane = new MyTabbedPaneCustom();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("Đơn hàng", null, panel, null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(new Color(51,51,51));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		table = new JTable();
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.getTableHeader().setUI(new CustomTableHeaderUI());
		table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"m\u00E3 \u0111\u01A1n nh\u1EADp", "m\u00E3 nh\u00E2n vi\u00EAn", "m\u00E3 nh\u00E0 cung c\u1EA5p", "t\u1ED5ng ti\u1EC1n", "th\u1EDDi gian"
			}
		));
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
					.addGap(16))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 102, 102));
		panel_1.setBorder(null);
		tabbedPane.addTab("Tồn kho", null, panel_1, null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.getViewport().setBackground(new Color(51,51,51));
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		table_1 = new JTable();
		table_1.getTableHeader().setUI(new CustomTableHeaderUI());
		table_1.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
		table_1.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"m\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "s\u1ED1 l\u01B0\u1EE3ng"
			}
		));
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane_1.setViewportView(table_1);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(11)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
					.addGap(16))
		);
		panel_1.setLayout(gl_panel_1);
		
		MyButton xacNhanPhieuNhapBtn = new MyButton();
		xacNhanPhieuNhapBtn.setText("Xác nhận");
		xacNhanPhieuNhapBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		JLabel autoIncreaseLbl = new JLabel("New label");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblXemTrc, GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(autoIncreaseLbl, GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(xacNhanPhieuNhapBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(10))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblXemTrc, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addComponent(xacNhanPhieuNhapBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(autoIncreaseLbl, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(null);
		panel_1_1.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("New tab", null, panel_1_1, null);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.getViewport().setBackground(new Color(51,51,51));
		scrollPane_1_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		GroupLayout gl_panel_1_1 = new GroupLayout(panel_1_1);
		gl_panel_1_1.setHorizontalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 879, Short.MAX_VALUE)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollPane_1_1, GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_panel_1_1.setVerticalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 463, Short.MAX_VALUE)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addGap(11)
					.addComponent(scrollPane_1_1, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
					.addGap(16))
		);
		
		table_2 = new JTable();
		table_2.getTableHeader().setUI(new CustomTableHeaderUI());
		table_2.getTableHeader().setFont(new Font("Tahoma",Font.PLAIN,18));
		table_2.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"m\u00E3 nh\u00E0 cung c\u1EA5p", "t\u00EAn nh\u00E0 cung c\u1EA5p", "s\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0111\u1ECBa ch\u1EC9"
			}
		));
		table_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane_1_1.setViewportView(table_2);
		panel_1_1.setLayout(gl_panel_1_1);
		contentPane.setLayout(gl_contentPane);
	}
}
