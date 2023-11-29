package GUI.QuanLyBanHang;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import MyDesign.MyTabPane.MyTabbedPaneCustom;
import MyDesign.MyTable.CustomTableCellRenderer;
import MyDesign.MyTable.CustomTableHeaderUI;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import MyDesign.MyComponents.MyTextfield;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JComboBox;
import MyDesign.MyComponents.MyButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.ScrollPaneConstants;
<<<<<<< HEAD
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
=======

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
>>>>>>> Hoang-Phat
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import MyDesign.Calendar.MyDateChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
<<<<<<< HEAD

import BUS.HoaDonBUS;
import DTO.DTO_HoaDon;
=======
import javax.swing.table.TableColumnModel;

import BUS.QuanLyBanHang.Cart;
import BUS.QuanLyBanHang.CartItemBUS;
import BUS.QuanLyBanHang.ProductItemBUS;
>>>>>>> Hoang-Phat

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;



public class QuanLyBanHangFrm extends JPanel {

	//Edit
	private static final long serialVersionUID = 1L;
	public static JComboBox sortCmbx_1;
	public static JCheckBox giaoHangChck;
	//public static JComboBox<String> teniKhachHangTxt;
	public static MyTextfield soDienThoaiKHTxt;
	public static MyTextfield teniKhachHangTxt;
	public static MyTextfield timKiemTonKhoTxt;
	public static MyTextfield diaChiTxt;
	private JTable table;
	public static JRadioButton chckbxNewCheckBox;
	public static JRadioButton chckbxNewCheckBox_1;
	public static JRadioButton chckbxNewCheckBox_1_1;
	public static JRadioButton chckbxNewCheckBox_1_2;
	public static JRadioButton chckbxNewCheckBox_1_3;
	public static JPanel cartItemPanel;
	public static JPanel ProductItemPanel;
	public final static ButtonGroup GroupModel = new ButtonGroup();
	public static JLabel lblTngCng;
	public static MyTextfield timKiemDonHangTxt ;

	private static DefaultTableModel model;
    private static JTable table_1;
    
	/**
	 * Create the panel.
	 */
	public QuanLyBanHangFrm() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		setBackground(new Color(102, 102, 102));
		
		MyTabbedPaneCustom tabbedPane = new MyTabbedPaneCustom();
		
		JPanel banHangPanel = new JPanel();
		banHangPanel.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("bán hàng", null, banHangPanel, null);
		
		//Edit
		timKiemTonKhoTxt = new MyTextfield();
		timKiemTonKhoTxt.setPreferredSize(new Dimension(180, 35));
		timKiemTonKhoTxt.setColumns(10);
		timKiemTonKhoTxt.setBorder(new EmptyBorder(0, 0, 0, 0));
		timKiemTonKhoTxt.setBackground(new Color(77, 77, 77));
		timKiemTonKhoTxt.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String searchText = timKiemTonKhoTxt.getText();
                   BUS.QuanLyBanHang.ProductItemBUS.filterAndDisplayItems(true, searchText);
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // Không cần xử lý
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Không cần xử lý
            }
        });
		
		JLabel lblNewLabel_1 = new JLabel("Sắp xếp :");
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		//Edit sorting
		 String[] sortOptions = { "Giá tăng dần", "Giá giảm dần"};
	        JComboBox sortCmbx_1 = new JComboBox(sortOptions);
	        sortCmbx_1.setForeground(Color.CYAN);
	        sortCmbx_1.setBackground(new Color(102, 102, 102));
	        sortCmbx_1.addItemListener(new ItemListener() {
	            @Override
	            public void itemStateChanged(ItemEvent e) {
	                if (e.getStateChange() == ItemEvent.SELECTED) {
	                    String selectedOption = (String) sortCmbx_1.getSelectedItem();
	                    switch (selectedOption) {
	                        case "Giá tăng dần":
	                            // Gọi hàm sorting theo giá tăng dần
	                        	BUS.QuanLyBanHang.ProductItemBUS.SortingPrice(0);
	                            break;
	                        case "Giá giảm dần":
	                            // Gọi hàm sorting theo giá giảm dần
	                        	BUS.QuanLyBanHang.ProductItemBUS.SortingPrice(1);
	                            break;
	                        default:
	                            // Thêm xử lý cho các lựa chọn khác nếu cần
	                            break;
	                    }
	                }
	            }
	        });
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBorder(new LineBorder(new Color(130, 135, 144)));
		scrollPane_1.getVerticalScrollBar().setUnitIncrement(100);
		
		JPanel HangSXPanel = new JPanel();
		FlowLayout fl_HangSXPanel = (FlowLayout) HangSXPanel.getLayout();
		fl_HangSXPanel.setAlignment(FlowLayout.LEFT);
		HangSXPanel.setToolTipText("các hãng laptop");
		HangSXPanel.setForeground(Color.CYAN);
		HangSXPanel.setBackground(new Color(77, 77, 77));
		
		//Edit
		chckbxNewCheckBox = new JRadioButton("ACER");
		GroupModel.add(chckbxNewCheckBox);
		chckbxNewCheckBox.setForeground(Color.CYAN);
		chckbxNewCheckBox.setBackground(new Color(77, 77, 77));
		HangSXPanel.add(chckbxNewCheckBox);
		chckbxNewCheckBox.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                BUS.QuanLyBanHang.ProductItemBUS.filterAndDisplayItems(chckbxNewCheckBox.isSelected(),
	                		chckbxNewCheckBox.getText());
	            }
	        });
		
		//Edit
		chckbxNewCheckBox_1 = new JRadioButton("ASUS");
		GroupModel.add(chckbxNewCheckBox_1);
		chckbxNewCheckBox_1.setForeground(Color.CYAN);
		chckbxNewCheckBox_1.setBackground(new Color(77, 77, 77));
		HangSXPanel.add(chckbxNewCheckBox_1);
		chckbxNewCheckBox_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	BUS.QuanLyBanHang.ProductItemBUS.filterAndDisplayItems(chckbxNewCheckBox_1.isSelected(),
                		chckbxNewCheckBox_1.getText());            }
        });
		
		//Edit
		chckbxNewCheckBox_1_1 = new JRadioButton("HP");
		GroupModel.add(chckbxNewCheckBox_1_1);
		chckbxNewCheckBox_1_1.setForeground(Color.CYAN);
		chckbxNewCheckBox_1_1.setBackground(new Color(77, 77, 77));
		HangSXPanel.add(chckbxNewCheckBox_1_1);
		chckbxNewCheckBox_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	BUS.QuanLyBanHang.ProductItemBUS.filterAndDisplayItems(chckbxNewCheckBox_1_1.isSelected(),
                		chckbxNewCheckBox_1_1.getText());            }
        });
		
		//Edit
		chckbxNewCheckBox_1_2 = new JRadioButton("Intel");
		GroupModel.add(chckbxNewCheckBox_1_2);
		chckbxNewCheckBox_1_2.setForeground(Color.CYAN);
		chckbxNewCheckBox_1_2.setBackground(new Color(77, 77, 77));
		HangSXPanel.add(chckbxNewCheckBox_1_2);
		chckbxNewCheckBox_1_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	BUS.QuanLyBanHang.ProductItemBUS.filterAndDisplayItems(chckbxNewCheckBox_1_2.isSelected(),
                		"Itel");
            }
        });
		
		//Edit
		chckbxNewCheckBox_1_3 = new JRadioButton("Lenovo");
		GroupModel.add(chckbxNewCheckBox_1_3);
		chckbxNewCheckBox_1_3.setForeground(Color.CYAN);
		chckbxNewCheckBox_1_3.setBackground(new Color(77, 77, 77));
		HangSXPanel.add(chckbxNewCheckBox_1_3);
		chckbxNewCheckBox_1_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	BUS.QuanLyBanHang.ProductItemBUS.filterAndDisplayItems(chckbxNewCheckBox_1_3.isSelected(),
                		chckbxNewCheckBox_1_3.getText());            }
        });
		
		//Edit
		MyButton mbtnLmMi = new MyButton();
		mbtnLmMi.setIcon(new ImageIcon(QuanLyBanHangFrm.class.getResource("/assets/reset.png")));
		mbtnLmMi.setText("làm mới");
		mbtnLmMi.setHorizontalTextPosition(SwingConstants.LEADING);
		mbtnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BUS.QuanLyBanHang.ProductItemBUS.clearProductItemPanel();
			}
		});
		
		GroupLayout gl_banHangPanel = new GroupLayout(banHangPanel);
		gl_banHangPanel.setHorizontalGroup(
			gl_banHangPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_banHangPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_banHangPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)
						.addGroup(gl_banHangPanel.createSequentialGroup()
							.addComponent(timKiemTonKhoTxt, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 358, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(sortCmbx_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_banHangPanel.createSequentialGroup()
							.addComponent(HangSXPanel, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(mbtnLmMi, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
					.addGap(22))
		);
		gl_banHangPanel.setVerticalGroup(
			gl_banHangPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_banHangPanel.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_banHangPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_banHangPanel.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_banHangPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(sortCmbx_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_banHangPanel.createSequentialGroup()
							.addGap(13)
							.addComponent(timKiemTonKhoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_banHangPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(mbtnLmMi, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(HangSXPanel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
					.addGap(13))
		);
		
		ProductItemPanel = new JPanel();
		ProductItemPanel.setBackground(new Color(51, 51, 51));
		scrollPane_1.setViewportView(ProductItemPanel);
		banHangPanel.setLayout(gl_banHangPanel);
		
		
		/*
		teniKhachHangTxt = new JComboBox<>();
		teniKhachHangTxt.setBackground(new Color(77, 77, 77));
		teniKhachHangTxt.setBorder(null);
		teniKhachHangTxt.setVisible(true);

		teniKhachHangTxt.addItemListener(new ItemListener() {
		    public void itemStateChanged(ItemEvent e) {
		        System.out.println("ItemStateChanged event triggered!");
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		            CartItemBUS.ShowNameCustomerByPhone(teniKhachHangTxt);
		        }
		    }
		});
		*/
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 851, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
					.addGap(21))
		);
		
		JPanel cartPanel = new JPanel();
		cartPanel.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("Giỏ hàng", null, cartPanel, null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(new Color(51,51,51));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		
		MyButton xacNhanHoaDonBtn = new MyButton();
		xacNhanHoaDonBtn.setText("Xác nhận");
		xacNhanHoaDonBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		xacNhanHoaDonBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 boolean check = BUS.QuanLyBanHang.ThanhToan.checkCartItem();
         	    if (check) {
            	BUS.QuanLyBanHang.ThanhToan.XacNhan();
            	BUS.QuanLyBanHang.CartItemBUS.cart.clear();
            	GUI.QuanLyBanHang.QuanLyBanHangFrm.cartItemPanel.revalidate();
        	    GUI.QuanLyBanHang.QuanLyBanHangFrm.cartItemPanel.repaint();
         	    }
            }
        });
		

		JLabel maNhanVienThuNganLbl = new JLabel("mã nhân viên : << "+GUI.MainForm.manv+" >>" );
		maNhanVienThuNganLbl.setForeground(Color.CYAN);
		maNhanVienThuNganLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		//Edit tồng cộng label
		
		JLabel lblTngCng = new JLabel();
		lblTngCng.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTngCng.setForeground(Color.CYAN);
		lblTngCng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		JLabel lblTnKhchHng = new JLabel("số điện thoại : ");
		lblTnKhchHng.setForeground(Color.CYAN);
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		//Edit
		soDienThoaiKHTxt = new MyTextfield();
		soDienThoaiKHTxt.setBackground(new Color(77, 77, 77));
		soDienThoaiKHTxt.setColumns(10);
		soDienThoaiKHTxt.setBorder(null);
		
		
		JLabel lblSinThoi = new JLabel("tên khách hàng :");
		lblSinThoi.setForeground(Color.CYAN);
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		//Edit
		teniKhachHangTxt = new MyTextfield();
		teniKhachHangTxt.setText("");
		teniKhachHangTxt.setBackground(new Color(77, 77, 77));
		teniKhachHangTxt.setBorder(null);
		teniKhachHangTxt.setVisible(true);
		teniKhachHangTxt.setEditable(false);
		teniKhachHangTxt.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        GUI.QuanLyBanHang.QuanLyBanHangFrm.teniKhachHangTxt.setText("");
		        CartItemBUS.ShowNameCustomerByPhone(); // test: 0242569874 , 0795897463
		    }
		});
		
				
				giaoHangChck = new JCheckBox("giao hàng tại nhà");
				giaoHangChck.setForeground(Color.CYAN);
				giaoHangChck.setFont(new Font("Tahoma", Font.PLAIN, 15));
				giaoHangChck.setBorder(new EmptyBorder(0, 0, 0, 0));
				giaoHangChck.setBackground(new Color(102, 102, 102));
				
				diaChiTxt = new MyTextfield();
				diaChiTxt.setText("");
				diaChiTxt.setEditable(false);
				diaChiTxt.setBackground(new Color(77, 77, 77));
				diaChiTxt.setColumns(10);
				diaChiTxt.setBorder(null);
				
				JLabel autoIncreaseSpaceLbl = new JLabel("");
				
				JLabel autoIncreaseSpaceLbl_1 = new JLabel("");
				
				cartItemPanel = new JPanel();
				cartItemPanel.setBackground(new Color(51, 51, 51));
				scrollPane.setViewportView(cartItemPanel);
				cartItemPanel.setLayout(new GridLayout(0, 1, 0, 0));
				
				
				 // Custom cell renderer để tự động xuống dòng cho cột Tên sản phẩm
		       
				model = new DefaultTableModel() {
		            // Override isCellEditable method to make cells non-editable
		            @Override
		            public boolean isCellEditable(int row, int column) {
		                return false;
		            }
		        };
		        
		        model.addColumn("Mã SP");
		        model.addColumn("Tên SP");
		        model.addColumn("Đơn giá");
		        model.addColumn("Số lượng");
		        model.addColumn("Thành tiền");

		        

		        table_1 = new JTable(model);
		        cartItemPanel.add(table_1);

		        // Thiết lập font cho toàn bộ JTable
		        Font tableFont = new Font("Arial", Font.PLAIN, 16);
		        table_1.setFont(tableFont);

		        
		        // Thiết lập kích thước cột theo tỉ lệ sau khi table đã hiển thị
		        TableColumnModel columnModel = table_1.getColumnModel();
		        int totalWidth = table_1.getWidth();

		        columnModel.getColumn(0).setPreferredWidth((int) (totalWidth * 0.10));  // 10%
		        columnModel.getColumn(1).setPreferredWidth((int) (totalWidth * 0.40));  // 40%
		        columnModel.getColumn(2).setPreferredWidth((int) (totalWidth * 0.20));  // 20%
		        columnModel.getColumn(3).setPreferredWidth((int) (totalWidth * 0.20));  // 20%
		        columnModel.getColumn(4).setPreferredWidth((int) (totalWidth * 0.20));  // 20%
		    
		        
		     // Lắng nghe sự kiện thay đổi trên JTable
		        model.addTableModelListener( new TableModelListener() {
		            @Override
		            public void tableChanged(TableModelEvent e) {
		                int row = e.getFirstRow();
		                int column = e.getColumn();

		                if (row != -1 && column != -1) {
		                    // Lấy giá trị từ JTable và cập nhật vào ArrayList
		                    String columnName = model.getColumnName(column);
		                    Object value = model.getValueAt(row, column);

		                    updateArrayList(row, columnName, value);
		                }
		            }

					
		        });

		        
				JPanel panel = new JPanel();
				panel.setBackground(new Color(255, 255, 102));
				
				JLabel lblNewLabel_2 = new JLabel(".No");
				lblNewLabel_2.setForeground(new Color(0, 205, 205));
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
				
				JLabel lblNewLabel_2_1 = new JLabel("Tên sản phẩm");
				lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_2_1.setForeground(new Color(0, 205, 205));
				lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				
				JLabel lblNewLabel_2_1_1 = new JLabel("đơn giá");
				lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_2_1_1.setForeground(new Color(0, 205, 205));
				lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				
				JLabel lblNewLabel_2_1_1_1 = new JLabel("số lượng");
				lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_2_1_1_1.setForeground(new Color(0, 205, 205));
				lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				
				JLabel lblNewLabel_2_1_1_2 = new JLabel("thành tiền");
				lblNewLabel_2_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_2_1_1_2.setForeground(new Color(0, 205, 205));
				lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
				
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBackground(new Color(102, 102, 102));
				
				MyButton congBtn1 = new MyButton();
				congBtn1.setIcon(new ImageIcon(CartItem.class.getResource("/assets/add.png")));
				congBtn1.setHorizontalTextPosition(SwingConstants.CENTER);
				congBtn1.setFont(new Font("Segoe UI", Font.BOLD, 16));
				congBtn1.setBounds(5, 5, 30, 30);
				panel_1.add(congBtn1);
				congBtn1.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                int selectedRow = table_1.getSelectedRow();
		                if (selectedRow != -1) {
		                    // Lấy số lượng từ cột "Số lượng" của dòng được chọn
		                    int currentQuantity = (int) table_1.getValueAt(selectedRow, 3);

		                    // Tăng số lượng lên 1 và cập nhật lại cột "Số lượng" trong JTable
		                    if (currentQuantity <10)
		                    {
		                   table_1.setValueAt(currentQuantity + 1, selectedRow, 3);
		                    }
		                    else
		                    {
			           JOptionPane.showMessageDialog(null, "Để tránh tình trạng đầu cơ trục lợi. \n Vui lòng đặt tối đa 10 sản phẩm");
	                   table_1.setValueAt(1, selectedRow, 3);
		                    }
		                    
		                    
		                } else {
		                    JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng để tăng số lượng.");
		                }
		            }
		        });
				
				MyButton truBtn1 = new MyButton();
				truBtn1.setIcon(new ImageIcon(CartItem.class.getResource("/assets/remove.png")));
				truBtn1.setHorizontalTextPosition(SwingConstants.CENTER);
				truBtn1.setFont(new Font("Segoe UI", Font.BOLD, 16));
				truBtn1.setBounds(40, 5, 30, 30);
				panel_1.add(truBtn1);
				truBtn1.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                int selectedRow = table_1.getSelectedRow();
		                if (selectedRow != -1) {
		                    // Lấy số lượng từ cột "Số lượng" của dòng được chọn
		                    int currentQuantity = (int) table_1.getValueAt(selectedRow, 3);

		                    // Tăng số lượng lên 1 và cập nhật lại cột "Số lượng" trong JTable
		                    if (currentQuantity >1)
		                    {		                   
		                    table_1.setValueAt(currentQuantity - 1, selectedRow, 3);
		                    }
		                    else
		                    {
			           JOptionPane.showMessageDialog(null, "Sản phẩm không được bằng 0");
	                   table_1.setValueAt(1, selectedRow, 3);
		                    }
		                } else {
		                    JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng để tăng số lượng.");
		                }
		            }
		        });
				
				MyButton xoaBtn1 = new MyButton();
				xoaBtn1.setIcon(new ImageIcon(CartItem.class.getResource("/assets/cancel.png")));
				
						xoaBtn1.setHorizontalTextPosition(SwingConstants.CENTER);
						xoaBtn1.setFont(new Font("Segoe UI", Font.BOLD, 16));
						xoaBtn1.setColorOver(new Color(255, 100, 100));
						xoaBtn1.setColor(new Color(255, 128, 128));
						xoaBtn1.setBackground(new Color(255, 128, 128));
						xoaBtn1.setBounds(75, 5, 30, 30);
						panel_1.add(xoaBtn1);
						xoaBtn1.addActionListener(new ActionListener() {
				            @Override
				            public void actionPerformed(ActionEvent e) {
				                int selectedRow = table_1.getSelectedRow();
				                if (selectedRow != -1) {
				                    // Lấy mã sản phẩm của dòng được chọn
				                    String selectedMasp = (String) table_1.getValueAt(selectedRow, 0);

				                    // Xóa object trong ArrayList có mã sản phẩm tương ứng
				                    for (int i = 0; i < BUS.QuanLyBanHang.CartItemBUS.cart.size(); i++) {
				                        Cart ct = BUS.QuanLyBanHang.CartItemBUS.cart.get(i);
				                        if (ct.masp.equals(selectedMasp)) {
				                            BUS.QuanLyBanHang.CartItemBUS.cart.remove(i);
				                            break;
				                        }
				                    }

				                    // Xóa dòng từ JTable
				                    model.removeRow(selectedRow);
				                } else {
				                    JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng để xóa.");
				                }
				            }
				        });
						
						MyButton InHoaDonBtn_2 = new MyButton();
						InHoaDonBtn_2.setText("in hóa đơn");
						InHoaDonBtn_2.setHorizontalTextPosition(SwingConstants.LEADING);
						
						GroupLayout gl_cartPanel = new GroupLayout(cartPanel);
						gl_cartPanel.setHorizontalGroup(
							gl_cartPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_cartPanel.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_cartPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_cartPanel.createSequentialGroup()
											.addGap(28)
											.addComponent(InHoaDonBtn_2, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
											.addGap(248)
											.addComponent(lblTngCng, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(xacNhanHoaDonBtn, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_cartPanel.createSequentialGroup()
											.addGroup(gl_cartPanel.createParallelGroup(Alignment.TRAILING)
												.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
												.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 796, Short.MAX_VALUE)
												.addGroup(gl_cartPanel.createSequentialGroup()
													.addGroup(gl_cartPanel.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_cartPanel.createSequentialGroup()
															.addComponent(maNhanVienThuNganLbl, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
															.addGap(69)
															.addComponent(giaoHangChck, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
														.addComponent(lblTnKhchHng, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_cartPanel.createSequentialGroup()
															.addGap(122)
															.addComponent(soDienThoaiKHTxt, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_cartPanel.createSequentialGroup()
															.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
															.addGap(5)
															.addComponent(teniKhachHangTxt, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)))
													.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
													.addGroup(gl_cartPanel.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_cartPanel.createSequentialGroup()
															.addGap(85)
															.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
														.addComponent(diaChiTxt, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))))
											.addGap(0)
											.addGroup(gl_cartPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_cartPanel.createSequentialGroup()
													.addGap(453)
													.addComponent(autoIncreaseSpaceLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addGroup(gl_cartPanel.createSequentialGroup()
													.addGap(244)
													.addComponent(autoIncreaseSpaceLbl_1, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)))))
									.addGap(22))
						);
						gl_cartPanel.setVerticalGroup(
							gl_cartPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_cartPanel.createSequentialGroup()
									.addGroup(gl_cartPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_cartPanel.createSequentialGroup()
											.addGap(3)
											.addGroup(gl_cartPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_cartPanel.createSequentialGroup()
													.addGap(12)
													.addComponent(maNhanVienThuNganLbl))
												.addComponent(autoIncreaseSpaceLbl_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
											.addGap(5)
											.addGroup(gl_cartPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_cartPanel.createSequentialGroup()
													.addGap(6)
													.addComponent(lblTnKhchHng))
												.addComponent(soDienThoaiKHTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_cartPanel.createSequentialGroup()
													.addGap(3)
													.addComponent(autoIncreaseSpaceLbl, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
											.addGap(3)
											.addGroup(gl_cartPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_cartPanel.createSequentialGroup()
													.addGap(7)
													.addComponent(lblSinThoi))
												.addGroup(gl_cartPanel.createSequentialGroup()
													.addGap(9)
													.addGroup(gl_cartPanel.createParallelGroup(Alignment.LEADING)
														.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
														.addComponent(teniKhachHangTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))))
										.addGroup(gl_cartPanel.createSequentialGroup()
											.addContainerGap()
											.addGroup(gl_cartPanel.createParallelGroup(Alignment.BASELINE)
												.addComponent(giaoHangChck, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
												.addComponent(diaChiTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
									.addGap(21)
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
									.addGroup(gl_cartPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_cartPanel.createSequentialGroup()
											.addGap(17)
											.addGroup(gl_cartPanel.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblTngCng, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
												.addComponent(xacNhanHoaDonBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_cartPanel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(InHoaDonBtn_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
									.addGap(12))
						);
						
						JLabel lblNewLabel_2_1_1_2_1 = new JLabel("");
						lblNewLabel_2_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
						lblNewLabel_2_1_1_2_1.setForeground(new Color(0, 205, 205));
						lblNewLabel_2_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
						GroupLayout gl_panel = new GroupLayout(panel);
						gl_panel.setHorizontalGroup(
							gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
									.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addGap(47)
									.addComponent(lblNewLabel_2_1_1_2, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_2_1_1_2_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addGap(71))
						);
						gl_panel.setVerticalGroup(
							gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblNewLabel_2_1_1_2_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2_1, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
											.addComponent(lblNewLabel_2_1_1_1, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
											.addComponent(lblNewLabel_2_1_1, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
											.addComponent(lblNewLabel_2_1_1_2, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)))
									.addContainerGap())
						);
						panel.setLayout(gl_panel);
						cartPanel.setLayout(gl_cartPanel);
						
						giaoHangChck.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								if(giaoHangChck.isSelected()) {
									diaChiTxt.setEditable(true);
									diaChiTxt.setBackground(new Color(77,77,77));
								}else {
									diaChiTxt.setText("");
									diaChiTxt.setEditable(false);
									diaChiTxt.setBackground(new Color(100,100,100));
								}
							}
						});
		
		JPanel donHangPanel = new JPanel();
		donHangPanel.setBackground(new Color(102, 102, 102));
		tabbedPane.addTab("Đơn hàng - Hóa đơn", null, donHangPanel, null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.getViewport().setBackground(new Color(51,51,51));
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		table = new JTable();
		table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		table.getTableHeader().setUI(new CustomTableHeaderUI());
		table.getTableHeader().setFont(new Font("Tahoma",Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"m\u00E3 h\u00F3a \u0111\u01A1n", "m\u00E3 kh\u00E1ch h\u00E0ng", "m\u00E3 nh\u00E2n vi\u00EAn", "ng\u00E0y l\u1EADp", "địa chỉ giao hàng", "t\u1ED5ng ti\u1EC1n", "tr\u1EA1ng th\u00E1i"
			}
		));
		scrollPane_2.setViewportView(table);
		
<<<<<<< HEAD
		//Hiển thị danh sách hóa đơn
		loadHoaDon();
		
		MyTextfield timKiemDonHangTxt = new MyTextfield();
=======
		timKiemDonHangTxt = new MyTextfield();
>>>>>>> Hoang-Phat
		timKiemDonHangTxt.setPreferredSize(new Dimension(180, 35));
		timKiemDonHangTxt.setColumns(10);
		timKiemDonHangTxt.setBorder(new EmptyBorder(0, 0, 0, 0));
		timKiemDonHangTxt.setBackground(new Color(77, 77, 77));
		
		JComboBox timKiemTypeCmbx = new JComboBox();
		timKiemTypeCmbx.setModel(new DefaultComboBoxModel(new String[] {"theo mã hóa đơn", "theo mã khách hàng", "theo mã nhân viên", "theo địa chỉ giao hàng", "theo trạng thái"}));
		timKiemTypeCmbx.setForeground(Color.CYAN);
		timKiemTypeCmbx.setBackground(new Color(102, 102, 102));
		
		MyButton timKiemBtn = new MyButton();
		timKiemBtn.setText("Lọc");
		timKiemBtn.setHorizontalTextPosition(SwingConstants.LEADING);
		
		
		JLabel auto_increase_spaceLbl = new JLabel("");
		auto_increase_spaceLbl.setBackground(new Color(102, 102, 102));
		
		JLabel lblNewLabel = new JLabel("Sắp xếp :");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox sortCmbx = new JComboBox();
		sortCmbx.setModel(new DefaultComboBoxModel(new String[] {"----------", "ngày lập hóa đơn tăng dần", "ngày lập hóa đơn giảm dần", "tổng tiền tăng dần", "tổng tiền giảm dần"}));
		sortCmbx.setForeground(Color.CYAN);
		sortCmbx.setBackground(new Color(102, 102, 102));
		//Xử lý sự kiện khi chọn JComboBox
		sortCmbx.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				sapXepHoaDon(sortCmbx.getSelectedIndex());
			}
		});
		
		JLabel lblT = new JLabel("Từ :");
		lblT.setForeground(Color.CYAN);
		lblT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyDateChooser fromDateChooser = new MyDateChooser();
		fromDateChooser.setBackground(new Color(102, 102, 102));
//		fromDateChooser.addMouseListener(new MouseAdapter() {
//			public void mouseEntered(MouseEvent e) {
//                JOptionPane.showMessageDialog(null, "hi");
//                System.out.println("hi");
//            }
//		});
		
		JLabel lbln = new JLabel("Đến :");
		lbln.setForeground(Color.CYAN);
		lbln.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MyDateChooser toDateChooser = new MyDateChooser();
		toDateChooser.setBackground(new Color(102, 102, 102));
		
		//Xử lý sự kiện nhấn vào nút "lọc" form hóa đơn
				timKiemBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e)
					{
						timKiemHoaDon(timKiemDonHangTxt.getText().toLowerCase(), timKiemTypeCmbx.getSelectedIndex(), fromDateChooser.getDate(), toDateChooser.getDate());
					}
				});
		
		MyButton InHoaDonBtn = new MyButton();
		InHoaDonBtn.setText("in hóa đơn");
		InHoaDonBtn.setHorizontalTextPosition(SwingConstants.LEADING);
<<<<<<< HEAD
		//Xử lý sự kiện khi nhấn vào nút "In"
		InHoaDonBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				MessageFormat header = new MessageFormat("Hóa đơn bán hàng");
				MessageFormat footer = new MessageFormat("Page{0, number, integer}");	
				try {
					table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
=======
		InHoaDonBtn.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
							        if (GUI.QuanLyBanHang.QuanLyBanHangFrm.timKiemDonHangTxt != null) {
			            String text1 = GUI.QuanLyBanHang.QuanLyBanHangFrm.timKiemDonHangTxt.getText();
			            BUS.QuanLyBanHang.InHoaDonBUS.PrintHD(text1);
			        } 
			    
			}
		});
		
>>>>>>> Hoang-Phat
		
		// Nút này để cập nhật trạng thái, ví dụ từ : đang giao hàng -> đã thanh toán
		MyButton InHoaDonBtn_1 = new MyButton();
		InHoaDonBtn_1.setToolTipText("cập nhật trạng thái hóa đơn");
		InHoaDonBtn_1.setText("cập nhật");
		//Xử lý khi nhấn vào nút "cập nhật" để cập nhật trạng thái hóa đơn
		InHoaDonBtn_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				updateTrangThaiHoaDon(table.getSelectedRow());
			}
		});
		
		InHoaDonBtn_1.setHorizontalTextPosition(SwingConstants.LEADING);
		GroupLayout gl_donHangPanel = new GroupLayout(donHangPanel);
		gl_donHangPanel.setHorizontalGroup(
			gl_donHangPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_donHangPanel.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_donHangPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_donHangPanel.createSequentialGroup()
							.addComponent(timKiemDonHangTxt, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(timKiemTypeCmbx, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(timKiemBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(auto_increase_spaceLbl, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
							.addGap(26)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(sortCmbx, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_donHangPanel.createSequentialGroup()
							.addComponent(lblT, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(fromDateChooser, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(lbln, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(toDateChooser, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
						.addGroup(gl_donHangPanel.createSequentialGroup()
							.addComponent(InHoaDonBtn, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(InHoaDonBtn_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))
					.addGap(38))
		);
		gl_donHangPanel.setVerticalGroup(
			gl_donHangPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_donHangPanel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_donHangPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(timKiemDonHangTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_donHangPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(timKiemTypeCmbx, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_donHangPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(timKiemBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addComponent(auto_increase_spaceLbl, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(sortCmbx, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(gl_donHangPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_donHangPanel.createSequentialGroup()
							.addGap(2)
							.addComponent(lblT, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_donHangPanel.createSequentialGroup()
							.addGap(2)
							.addComponent(fromDateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_donHangPanel.createSequentialGroup()
							.addGap(2)
							.addComponent(lbln, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(toDateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
					.addGap(11)
					.addGroup(gl_donHangPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(InHoaDonBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(InHoaDonBtn_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(21))
		);
		donHangPanel.setLayout(gl_donHangPanel);
		setLayout(groupLayout);
		demo1(); //Sản phẩm
		
		
		//BUS.QuanLyBanHang.CartItemBUS.executeOK();
		//demo2(); //Giỏ hàng
	}

	
	//Edit
	public static void demo1() {
        int itemsPerRow = 4;
		ProductItemPanel.setLayout(new GridLayout(0, itemsPerRow + 1, 0, 0));

        // Get the list of ProductItem objects from the database
        ArrayList<ProductItem> productItems = ProductItemBUS.getProductItems();

        for (int i = 0; i < productItems.size(); i++) {
            ProductItem pi = productItems.get(i);
            ProductItemPanel.add(pi);

            if ((i + 1) % itemsPerRow == 0) {
                ProductItemPanel.add(new JPanel());
            }
        }
	}
<<<<<<< HEAD
	
	//Tạo instance của HoaDonBUS để thực thi các phương thức
	HoaDonBUS hoadonbus = new HoaDonBUS();
	
	//Tạo ArrayList lưu trữ danh sách hóa đơn lấy từ Database
	ArrayList <DTO_HoaDon> arr_hoadon = hoadonbus.get_AllHoaDon();
	
	//Hiển thị danh sách hóa đơn
	public void loadHoaDon()
	{
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		//Định dạng hiển thị ngày
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY      HH:mm:ss");
		
		//Định dạng hiển thị tiền tệ
		String patternTongTien = "###,###";
		DecimalFormat formatTongTien = new DecimalFormat(patternTongTien);
		
		for(DTO_HoaDon x: arr_hoadon)
		{
			String ngaylaphoadon = sdf.format(x.getNgaylaphd());
			String tongtien = formatTongTien.format(x.getTongtien());
			model.addRow(new Object [] {x.getMahd(), x.getMakh(), x.getManv(), ngaylaphoadon, x.getDiachigiao(), tongtien, x.getTrangthai()});
		}
	}
	
	//Tìm kiếm hóa đơn
	public void timKiemHoaDon(String timKiemStr, int selectedIndex, Date fromDate, Date toDate)
	{
		if(timKiemStr.equalsIgnoreCase(""))
			JOptionPane.showMessageDialog(null, "Bạn phải điền thông tin muốn tìm");
		else
		{
			arr_hoadon = hoadonbus.timKiemHoaDon(timKiemStr, selectedIndex, fromDate, toDate);
		}
		loadHoaDon();
	}
	
	//Sắp xếp danh sách hóa đơn
	public void sapXepHoaDon(int selectedIndex)
	{
		switch (selectedIndex)
		{
		case 1:
			Collections.sort(arr_hoadon, Comparator.comparing(DTO_HoaDon -> DTO_HoaDon.getNgaylaphd()));
			loadHoaDon();
			break;
		case 2:
			Collections.sort(arr_hoadon, Comparator.comparing(DTO_HoaDon -> ((DTO.DTO_HoaDon) DTO_HoaDon).getNgaylaphd()).reversed());
			loadHoaDon();
			break;
		case 3:
			Collections.sort(arr_hoadon, Comparator.comparingDouble(DTO_HoaDon -> DTO_HoaDon.getTongtien()));
			loadHoaDon();
			break;
		case 4:
			Collections.sort(arr_hoadon, Comparator.comparingDouble((DTO_HoaDon -> ((DTO.DTO_HoaDon) DTO_HoaDon).getTongtien())).reversed());
			loadHoaDon();
			break;
		default:
			arr_hoadon = hoadonbus.get_AllHoaDon();
			loadHoaDon();
		}
	}
	
	//Cập nhật trạng thái hóa đơn
	public void updateTrangThaiHoaDon(int selectedRow)
	{
		if(arr_hoadon.get(selectedRow).getTrangthai().equalsIgnoreCase("đã thanh toán"))
		{
			JOptionPane.showMessageDialog(null, "Hóa đơn này đã thanh toán");
			return;
		}
		
		arr_hoadon.get(selectedRow).setTrangthai("đã thanh toán");
		int check = -1;
		check = hoadonbus.update_TrangThaiHoaDon(arr_hoadon.get(selectedRow));
		if(check != -1)
			JOptionPane.showMessageDialog(null, "Cập nhật trạng thái hóa đơn thành công!!!");
		else
			JOptionPane.showMessageDialog(null, "Lỗi!!! Cập nhật trạng thái hóa đơn không thành công!!!");
		loadHoaDon();
	}
=======
	// Method to update the table with new data
    public static void updateTable() {
        // Clear the existing rows in the model
        model.setRowCount(0);

        DecimalFormat decimalFormat1 = new DecimalFormat("#");
        
        // Thêm hàng vào model với các giá trị truyền vào
        for (int i = 0; i < BUS.QuanLyBanHang.CartItemBUS.cart.size(); i++) {
            Cart ct = BUS.QuanLyBanHang.CartItemBUS.cart.get(i);
            Object[] row = new Object[]{ct.masp, ct.tensp, decimalFormat1.format(ct.dongia),
            		ct.soluong, decimalFormat1.format(ct.thanhtien)};
            model.addRow(row);
            DecimalFormat decimalFormat = new DecimalFormat("#");
    		//lblTngCng.setText("Tổng cộng: "+decimalFormat.format(CartItemBUS.TongCong()));
        }

        // Revalidate and repaint the panel to update the displayed table
        table_1.revalidate();
        table_1.repaint();
    }
	
 // Phương thức cập nhật dữ liệu trong ArrayList dựa trên thay đổi từ JTable
    private static void updateArrayList(int row, String columnName, Object value) {
        Cart ct = BUS.QuanLyBanHang.CartItemBUS.cart.get(row);

        switch (columnName) {
            case "Mã SP":
                ct.masp = (String) value;
                break;
            case "Tên SP":
                ct.tensp = (String) value;
                break;
            case "Đơn giá":
                ct.dongia = (Double) value;
                break;
            case "Số lượng":
                ct.soluong = (Integer) value;
                ct.thanhtien = ct.dongia * ct.soluong; // Cập nhật thành tiền khi số lượng thay đổi
                break;
            case "Thành tiền":
                // Bạn có thể xử lý theo nhu cầu cụ thể
                break;
        }
    }
>>>>>>> Hoang-Phat
}
