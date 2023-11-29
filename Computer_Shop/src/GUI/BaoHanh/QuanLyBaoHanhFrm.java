package GUI.BaoHanh;

import javax.swing.JPanel;
import java.awt.Color;
import MyDesign.MyTabPane.MyTabbedPaneCustom;
import MyDesign.MyTable.CustomTableCellRenderer;
import MyDesign.MyTable.CustomTableHeaderUI;
import GUI.formPhieuBaoHanh.ChiTietPhieuBaoHanhForm;
import MyDesign.MyComponents.MyTextfield;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.FileDialog;

import javax.swing.JComboBox;
import MyDesign.MyComponents.MyButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import MyDesign.Calendar.MyDateChooser;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BUS.BUS_PhieuBaoHanh;
import BUS.ThemPhieuBaoHanhBUS;
import DTO.DTO_CTPhieuBaoHanh;
import DTO.DTO_PhieuBaoHanh;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Frame;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;

public class QuanLyBaoHanhFrm extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private JTable table_1;
    private JTable table_2;
    private ThemPhieuBaoHanhBUS themPhieuBaoHanhBUS = new ThemPhieuBaoHanhBUS();
    private MyTextfield loiTxt;
    private MyTextfield HuongGiaiQuyetTxt;
    private MyTextfield timKiemChiTietHoaDon;

    MyDateChooser toDateChooser = new MyDateChooser();
    MyDateChooser fromDateChooser = new MyDateChooser();
    JComboBox timKiemTypeCmbx = new JComboBox();
    MyTextfield timKiemBaoHanhTxt = new MyTextfield();
    JCheckBox chckbxHonThnh = new JCheckBox("Đã hoàn thành");
    JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Chưa hoàn thành");

    public boolean CheckMa() {
        if (table_2.getRowCount() == 0) {
            return true;
        } else {
            int countRow = table_2.getRowCount();
            int selectRow = table_1.getSelectedRow();
            DefaultTableModel model_table_1 = (DefaultTableModel) table_1.getModel();
            DefaultTableModel model_table_2 = (DefaultTableModel) table_2.getModel();
            for (int i = 0; i < countRow; i++) {
                if (model_table_2.getValueAt(i, 0).equals(model_table_1.getValueAt(selectRow, 0))
                        && model_table_2.getValueAt(i, 1).equals(model_table_1.getValueAt(selectRow, 1))) {
                    int option = JOptionPane.showConfirmDialog(null,
                            "Mã sản phẩm " + model_table_1.getValueAt(selectRow, 1) + " của hóa đơn "
                                    + model_table_1.getValueAt(selectRow, 0)
                                    + " bạn đã thêm vào rồi! Bạn có muốn xóa để thêm mới không?",
                            "Xác nhận", JOptionPane.YES_NO_OPTION);
                    // Kiểm tra phản hồi của người dùng
                    if (option == JOptionPane.YES_OPTION) {
                        model_table_2.removeRow(i);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public String taoMaBH() {
        ArrayList<DTO_PhieuBaoHanh> listPhieuBaoHanh = themPhieuBaoHanhBUS.selectAllPhieuBaoHanh();
        int size = listPhieuBaoHanh.size() + 1;
        if (size < 10) {
            return "BH000" + size;
        } else if (size < 100) {
            return "BH00" + size;
        } else if (size < 1000) {
            return "BH0" + size;
        } else {
            return "BH" + size;
        }
    }

    /**
     * Create the panel.
     */
    public QuanLyBaoHanhFrm(String manv) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
        setBackground(new Color(102, 102, 102));

        MyTabbedPaneCustom tabbedPane = new MyTabbedPaneCustom();

        JPanel phieuBaoHanhPanel = new JPanel();
        phieuBaoHanhPanel.setBackground(new Color(102, 102, 102));
        tabbedPane.addTab("Phiếu bảo hành", null, phieuBaoHanhPanel, null);

        timKiemBaoHanhTxt.setPreferredSize(new Dimension(180, 35));
        timKiemBaoHanhTxt.setColumns(10);
        timKiemBaoHanhTxt.setBorder(new EmptyBorder(0, 0, 0, 0));
        timKiemBaoHanhTxt.setBackground(new Color(77, 77, 77));

        timKiemTypeCmbx.setModel(
                new DefaultComboBoxModel(new String[] { "Mã phiếu", "Mã nhân viên", "Ngày nhận", "Ngày trả" }));
        timKiemTypeCmbx.setForeground(Color.CYAN);
        timKiemTypeCmbx.setBackground(new Color(102, 102, 102));

        MyButton timKiemBtn = new MyButton();
        timKiemBtn.setText("Lọc");
        timKiemBtn.setHorizontalTextPosition(SwingConstants.LEADING);

        JLabel auto_increase_spaceLbl = new JLabel("");

        JLabel lblNewLabel = new JLabel("Sắp xếp :");
        lblNewLabel.setForeground(Color.CYAN);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JComboBox sortCmbx = new JComboBox();
        sortCmbx.setModel(
                new DefaultComboBoxModel(new String[] { "Mã phiếu", "Mã nhân viên", "Ngày nhận", "Ngày trả" }));
        sortCmbx.setForeground(Color.CYAN);
        sortCmbx.setBackground(new Color(102, 102, 102));

        JLabel lblT = new JLabel("Từ :");
        lblT.setForeground(Color.CYAN);
        lblT.setFont(new Font("Tahoma", Font.PLAIN, 15));

        fromDateChooser.setBackground(new Color(102, 102, 102));

        JLabel lbln = new JLabel("Đến :");
        lbln.setForeground(Color.CYAN);
        lbln.setFont(new Font("Tahoma", Font.PLAIN, 15));

        toDateChooser.setBackground(new Color(102, 102, 102));

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().setBackground(new Color(51, 51, 51));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        table = new JTable();
        table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
        table.getTableHeader().setUI(new CustomTableHeaderUI());
        table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                },
                new String[] {
                        "m\u00E3 phi\u1EBFu", "ng\u00E0y nh\u1EADn", "ng\u00E0y tr\u1EA3", "m\u00E3 nh\u00E2n vi\u00EAn"
                }));
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setColumnIdentifiers(new String[] { "Mã phiếu", "Ngày nhận", "Ngày trả", "Mã nhân viên" });

        scrollPane.setViewportView(table);

        MyButton timKiemBtn_1 = new MyButton();
        timKiemBtn_1.setText("Hoàn thành");
        timKiemBtn_1.setHorizontalTextPosition(SwingConstants.LEADING);

        JPanel HangSXPanel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) HangSXPanel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        HangSXPanel.setToolTipText("các hãng laptop");
        HangSXPanel.setForeground(Color.CYAN);
        HangSXPanel.setBackground(new Color(77, 77, 77));

        chckbxHonThnh.setFont(new Font("Tahoma", Font.PLAIN, 15));
        chckbxHonThnh.setForeground(Color.CYAN);
        chckbxHonThnh.setBackground(new Color(77, 77, 77));
        HangSXPanel.add(chckbxHonThnh);

        chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        chckbxNewCheckBox_1.setForeground(Color.CYAN);
        chckbxNewCheckBox_1.setBackground(new Color(77, 77, 77));
        HangSXPanel.add(chckbxNewCheckBox_1);

        MyButton timKiemBtn_1_1 = new MyButton();
        timKiemBtn_1_1.setText("In");
        timKiemBtn_1_1.setHorizontalTextPosition(SwingConstants.LEADING);

        JLabel auto_increase_spaceLbl_2 = new JLabel("");

        MyButton mbtnLmMi_1 = new MyButton();
        mbtnLmMi_1.setIcon(new ImageIcon(QuanLyBaoHanhFrm.class.getResource("/assets/reset.png")));
        mbtnLmMi_1.setText("Làm mới");
        mbtnLmMi_1.setHorizontalTextPosition(SwingConstants.LEADING);
        GroupLayout gl_phieuBaoHanhPanel = new GroupLayout(phieuBaoHanhPanel);
        gl_phieuBaoHanhPanel.setHorizontalGroup(
                gl_phieuBaoHanhPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_phieuBaoHanhPanel.createSequentialGroup()
                                .addGap(10)
                                .addGroup(gl_phieuBaoHanhPanel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_phieuBaoHanhPanel.createSequentialGroup()
                                                .addComponent(timKiemBaoHanhTxt, GroupLayout.PREFERRED_SIZE, 180,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(10)
                                                .addComponent(timKiemTypeCmbx, GroupLayout.PREFERRED_SIZE, 147,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(4)
                                                .addComponent(timKiemBtn, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(mbtnLmMi_1, GroupLayout.PREFERRED_SIZE, 107,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(auto_increase_spaceLbl, GroupLayout.PREFERRED_SIZE, 22,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)
                                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 74,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                                .addComponent(sortCmbx, GroupLayout.PREFERRED_SIZE, 174,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_phieuBaoHanhPanel.createSequentialGroup()
                                                .addComponent(lblT, GroupLayout.PREFERRED_SIZE, 42,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(4)
                                                .addComponent(fromDateChooser, GroupLayout.PREFERRED_SIZE, 147,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(10)
                                                .addComponent(lbln, GroupLayout.PREFERRED_SIZE, 42,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(4)
                                                .addComponent(toDateChooser, GroupLayout.PREFERRED_SIZE, 147,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(10)
                                                .addComponent(auto_increase_spaceLbl_2, GroupLayout.DEFAULT_SIZE, 89,
                                                        Short.MAX_VALUE)
                                                .addGap(21)
                                                .addComponent(HangSXPanel, GroupLayout.PREFERRED_SIZE, 295,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
                                        .addGroup(gl_phieuBaoHanhPanel.createSequentialGroup()
                                                .addComponent(timKiemBtn_1, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(11)
                                                .addComponent(timKiemBtn_1_1, GroupLayout.PREFERRED_SIZE, 109,
                                                        GroupLayout.PREFERRED_SIZE)))
                                .addGap(9)));
        gl_phieuBaoHanhPanel.setVerticalGroup(
                gl_phieuBaoHanhPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_phieuBaoHanhPanel.createSequentialGroup()
                                .addGap(8)
                                .addGroup(gl_phieuBaoHanhPanel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_phieuBaoHanhPanel.createSequentialGroup()
                                                .addGap(3)
                                                .addComponent(timKiemBaoHanhTxt, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_phieuBaoHanhPanel.createSequentialGroup()
                                                .addGap(3)
                                                .addComponent(timKiemTypeCmbx, GroupLayout.PREFERRED_SIZE, 33,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addComponent(timKiemBtn, GroupLayout.PREFERRED_SIZE, 35,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_phieuBaoHanhPanel.createSequentialGroup()
                                                .addGap(3)
                                                .addComponent(auto_increase_spaceLbl, GroupLayout.PREFERRED_SIZE, 37,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_phieuBaoHanhPanel.createSequentialGroup()
                                                .addGap(3)
                                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 37,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_phieuBaoHanhPanel.createSequentialGroup()
                                                .addGap(3)
                                                .addComponent(sortCmbx, GroupLayout.PREFERRED_SIZE, 35,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addComponent(mbtnLmMi_1, GroupLayout.PREFERRED_SIZE, 35,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(6)
                                .addGroup(gl_phieuBaoHanhPanel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblT, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fromDateChooser, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbln, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(toDateChooser, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(auto_increase_spaceLbl_2, GroupLayout.PREFERRED_SIZE, 37,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_phieuBaoHanhPanel.createSequentialGroup()
                                                .addGap(3)
                                                .addComponent(HangSXPanel, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(11)
                                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                .addGap(11)
                                .addGroup(gl_phieuBaoHanhPanel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(timKiemBtn_1, GroupLayout.PREFERRED_SIZE, 35,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(timKiemBtn_1_1, GroupLayout.PREFERRED_SIZE, 35,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(14)));
        phieuBaoHanhPanel.setLayout(gl_phieuBaoHanhPanel);

        JPanel LapPhieuBaoHanhPanel = new JPanel();
        LapPhieuBaoHanhPanel.setBackground(new Color(102, 102, 102));
        tabbedPane.addTab("Lập phiếu", null, LapPhieuBaoHanhPanel, null);

        timKiemChiTietHoaDon = new MyTextfield();
        timKiemChiTietHoaDon.setPreferredSize(new Dimension(180, 35));
        timKiemChiTietHoaDon.setColumns(10);
        timKiemChiTietHoaDon.setBorder(new EmptyBorder(0, 0, 0, 0));
        timKiemChiTietHoaDon.setBackground(new Color(77, 77, 77));

        JComboBox timKiemTypeCmbx_1 = new JComboBox();
        timKiemTypeCmbx_1.setForeground(Color.CYAN);
        timKiemTypeCmbx_1.setBackground(new Color(102, 102, 102));
        // Thêm dữ liệu cho Combobox
        timKiemTypeCmbx_1.addItem("Mã hóa đơn");
        timKiemTypeCmbx_1.addItem("Mã sản phẩm");

        MyButton timkiemBtn = new MyButton();
        timkiemBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (timKiemTypeCmbx_1.getSelectedItem().equals("Mã hóa đơn")) {
                    DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
                    model_table.setRowCount(0);
                    themPhieuBaoHanhBUS.hienThiChiTiet_MaHD(table_1, timKiemChiTietHoaDon.getText());
                }
                if (timKiemTypeCmbx_1.getSelectedItem().equals("Mã sản phẩm")) {
                    DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
                    model_table.setRowCount(0);
                    themPhieuBaoHanhBUS.hienThiChiTiet_MaSP(table_1, timKiemChiTietHoaDon.getText());
                }
            }
        });
        timkiemBtn.setText("Lọc");
        timkiemBtn.setHorizontalTextPosition(SwingConstants.LEADING);

        JComboBox sortCmbx_1 = new JComboBox();
        sortCmbx_1.setForeground(Color.CYAN);
        sortCmbx_1.setBackground(new Color(102, 102, 102));
        sortCmbx_1.addItem("Mã hóa đơn");
        sortCmbx_1.addItem("Mã sản phẩm");
        sortCmbx_1.addItem("Hạn bảo hành");
        sortCmbx_1.addItemListener(new ItemListener() {

            private int columnIndexToSort;

            @Override
            public void itemStateChanged(ItemEvent e) {
                // TODO Auto-generated method stub
                // Tạo mô hình dữ liệu
                DefaultTableModel model = (DefaultTableModel) table_1.getModel();

                // Tạo TableRowSorter
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);

                if (sortCmbx_1.getSelectedItem().equals("Mã hóa đơn")) {
                    columnIndexToSort = 0;
                }
                if (sortCmbx_1.getSelectedItem().equals("Mã sản phẩm")) {
                    columnIndexToSort = 1;
                }
                if (sortCmbx_1.getSelectedItem().equals("Hạn bảo hành")) {
                    columnIndexToSort = 2;
                }

                Comparator<Date> dateComparator = new Comparator<Date>() {
                    public int compare(Date date1, Date date2) {
                        return date1.compareTo(date2);
                    }
                };
                sorter.setSortable(columnIndexToSort, true);
                if (columnIndexToSort == 2) {
                    sorter.setComparator(columnIndexToSort, dateComparator);
                } else {
                    sorter.setComparator(columnIndexToSort, String.CASE_INSENSITIVE_ORDER);
                }
                sorter.toggleSortOrder(columnIndexToSort); // Sắp xếp cột "Name" theo thứ tự tăng dần

                // Đặt TableRowSorter vào JTable
                table_1.setRowSorter(sorter);
            }
        });

        JLabel lblNewLabel_1 = new JLabel("Sắp xếp :");
        lblNewLabel_1.setForeground(Color.CYAN);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane_1.getViewport().setBackground(new Color(51, 51, 51));

        table_1 = new JTable();
        table_1.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
        table_1.getTableHeader().setUI(new CustomTableHeaderUI());
        table_1.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
        table_1.setModel(new DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "m\u00E3 h\u00F3a \u0111\u01A1n", "m\u00E3 s\u1EA3n ph\u1EA9m", "H\u1EA1n b\u1EA3o h\u00E0nh"
                }));

        // Hiển thị chi tiết hóa đơn
        themPhieuBaoHanhBUS.hienThiChiTiet(table_1);

        scrollPane_1.setViewportView(table_1);

        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane_2.getViewport().setBackground(new Color(51, 51, 51));

        table_2 = new JTable();
        table_2.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
        table_2.getTableHeader().setUI(new CustomTableHeaderUI());
        table_2.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
        table_2.setModel(new DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "m\u00E3 h\u00F3a \u0111\u01A1n", "m\u00E3 s\u1EA3n ph\u1EA9m", "l\u1ED7i",
                        "h\u01B0\u1EDBng gi\u1EA3i quy\u1EBFt"
                }));
        scrollPane_2.setViewportView(table_2);

        MyButton themCTHDBtn = new MyButton();
        themCTHDBtn.setText("Thêm");
        themCTHDBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if (CheckMa()) {
                    int selectRow = table_1.getSelectedRow();
                    Object[] rowData = { table_1.getValueAt(selectRow, 0), table_1.getValueAt(selectRow, 1),
                            loiTxt.getText(), HuongGiaiQuyetTxt.getText() };
                    DefaultTableModel model_table_2 = (DefaultTableModel) table_2.getModel();
                    model_table_2.addRow(rowData);
                    DefaultTableModel model_table_1 = (DefaultTableModel) table_1.getModel();
                    model_table_1.setRowCount(0);
                    themPhieuBaoHanhBUS.hienThiChiTiet_MaHD(table_1, model_table_2.getValueAt(0, 0).toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm thất bại");
                }
                loiTxt.setText("");
                HuongGiaiQuyetTxt.setText("");
            }
        });
        themCTHDBtn.setHorizontalTextPosition(SwingConstants.LEADING);

        MyButton xoaCTHDBtn = new MyButton();
        xoaCTHDBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectRow = table_2.getSelectedRow();
                DefaultTableModel model = (DefaultTableModel) table_2.getModel();
                DefaultTableModel model_table_1 = (DefaultTableModel) table_1.getModel();
                int option = JOptionPane
                        .showConfirmDialog(
                                null, "Bạn có chắc chắn xóa sản phẩm " + table_2.getValueAt(selectRow, 1)
                                        + " của hóa đơn " + table_2.getValueAt(selectRow, 0),
                                "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    model.removeRow(selectRow);
                    if (table_2.getRowCount() < 1) {
                        model_table_1.setRowCount(0);
                        themPhieuBaoHanhBUS.hienThiChiTiet(table_1);
                    }
                }
            }
        });
        xoaCTHDBtn.setText("Xóa");
        xoaCTHDBtn.setHorizontalTextPosition(SwingConstants.LEADING);

        MyButton themPhieuBaoHanhBtn = new MyButton();
        themPhieuBaoHanhBtn.setText("thêm phiếu");
        // Thêm phiếu bảo hành
        themPhieuBaoHanhBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                if (table_2.getRowCount() != 0) {
                    int dem = 0;
                    Date ngayNhan = Date.valueOf(LocalDate.now());
                    Date ngayTra = Date.valueOf(LocalDate.now().plusDays(7));
                    String maBaoHanh = taoMaBH();
                    DTO_PhieuBaoHanh phieuBaoHanh = new DTO_PhieuBaoHanh(maBaoHanh, ngayNhan, ngayTra, manv);
                    if (themPhieuBaoHanhBUS.insertBaoHanh(phieuBaoHanh) == 0) {
                        JOptionPane.showMessageDialog(null, "Thêm phiếu bảo hành thất bại");
                    } else {
                        int rowCount = table_2.getRowCount();
                        for (int i = 0; i < rowCount; i++) {
                            String maSanPham = String.valueOf(table_2.getValueAt(i, 1));
                            String maHoaDon = String.valueOf(table_2.getValueAt(i, 0));
                            String loi = String.valueOf(table_2.getValueAt(i, 2));
                            String giaiQuyet = String.valueOf(table_2.getValueAt(i, 3));
                            DTO_CTPhieuBaoHanh chiTietBaoHanh = new DTO_CTPhieuBaoHanh(maBaoHanh, maSanPham, maHoaDon,
                                    loi, giaiQuyet);
                            if (themPhieuBaoHanhBUS.insertChiTietBaoHanh(chiTietBaoHanh) != 0) {
                                dem += 1;
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Có " + dem + " chi tiết phiếu thêm thành công");
                    DefaultTableModel model_table_1 = (DefaultTableModel) table_1.getModel();
                    model_table_1.setRowCount(0);
                    themPhieuBaoHanhBUS.hienThiChiTiet(table_1);
                    DefaultTableModel model_table_2 = (DefaultTableModel) table_2.getModel();
                    model_table_2.setRowCount(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Không có dữ liệu để thêm");
                }

            }
        });
        themPhieuBaoHanhBtn.setHorizontalTextPosition(SwingConstants.LEADING);

        loiTxt = new MyTextfield();
        loiTxt.setPreferredSize(new Dimension(180, 35));
        loiTxt.setColumns(10);
        loiTxt.setBorder(new EmptyBorder(0, 0, 0, 0));
        loiTxt.setBackground(new Color(77, 77, 77));

        JLabel lblNewLabel_1_1 = new JLabel("Lỗi :");
        lblNewLabel_1_1.setForeground(Color.CYAN);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel lblNewLabel_1_1_1 = new JLabel("Hướng giải quyết :");
        lblNewLabel_1_1_1.setForeground(Color.CYAN);
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

        HuongGiaiQuyetTxt = new MyTextfield();
        HuongGiaiQuyetTxt.setPreferredSize(new Dimension(180, 35));
        HuongGiaiQuyetTxt.setColumns(10);
        HuongGiaiQuyetTxt.setBorder(new EmptyBorder(0, 0, 0, 0));
        HuongGiaiQuyetTxt.setBackground(new Color(77, 77, 77));

        JLabel auto_increase_spaceLbl_1 = new JLabel("");

        MyButton mbtnLmMi = new MyButton();
        mbtnLmMi.setText("Làm mới");
        // Nút Làm mới
        mbtnLmMi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                DefaultTableModel model_table_1 = (DefaultTableModel) table_1.getModel();
                DefaultTableModel model_table_2 = (DefaultTableModel) table_2.getModel();
                if (table_2.getRowCount() > 0) {
                    int option = JOptionPane.showConfirmDialog(null,
                            "Bạn chưa lưu dữ liệu vào cơ sở dữ liệu! Bạn có muốn tiếp tục không", "Xác nhận",
                            JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        model_table_2.setRowCount(0);
                        model_table_1.setRowCount(0);
                        themPhieuBaoHanhBUS.hienThiChiTiet(table_1);
                        timKiemChiTietHoaDon.setText("");
                        timKiemTypeCmbx_1.setSelectedIndex(0);
                        sortCmbx_1.setSelectedIndex(0);
                    } else {
                        return;
                    }
                } else {
                    model_table_1.setRowCount(0);
                    themPhieuBaoHanhBUS.hienThiChiTiet(table_1);
                    timKiemChiTietHoaDon.setText("");
                    timKiemTypeCmbx_1.setSelectedIndex(0);
                    sortCmbx_1.setSelectedIndex(0);
                }
            }
        });
        mbtnLmMi.setIcon(new ImageIcon(QuanLyBaoHanhFrm.class.getResource("/assets/reset.png")));
        mbtnLmMi.setHorizontalTextPosition(SwingConstants.LEADING);
        GroupLayout gl_LapPhieuBaoHanhPanel = new GroupLayout(LapPhieuBaoHanhPanel);
        gl_LapPhieuBaoHanhPanel.setHorizontalGroup(
                gl_LapPhieuBaoHanhPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_LapPhieuBaoHanhPanel.createSequentialGroup()
                                .addGap(10)
                                .addComponent(timKiemChiTietHoaDon, GroupLayout.PREFERRED_SIZE, 180,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(10)
                                .addComponent(timKiemTypeCmbx_1, GroupLayout.PREFERRED_SIZE, 147,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(5)
                                .addComponent(timkiemBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(20)
                                .addComponent(mbtnLmMi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(auto_increase_spaceLbl_1, GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                                .addGap(10)
                                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                                .addGap(10)
                                .addComponent(sortCmbx_1, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                                .addGap(9))
                        .addGroup(gl_LapPhieuBaoHanhPanel.createSequentialGroup()
                                .addGap(10)
                                .addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
                                .addGap(9))
                        .addGroup(gl_LapPhieuBaoHanhPanel.createSequentialGroup()
                                .addGap(10)
                                .addGroup(gl_LapPhieuBaoHanhPanel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 43,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_LapPhieuBaoHanhPanel.createSequentialGroup()
                                                .addGap(40)
                                                .addComponent(loiTxt, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))
                                .addGap(10)
                                .addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 129,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(10)
                                .addComponent(HuongGiaiQuyetTxt, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                .addGap(10)
                                .addComponent(themCTHDBtn, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                                .addGap(10)
                                .addComponent(xoaCTHDBtn, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                                .addGap(9))
                        .addGroup(gl_LapPhieuBaoHanhPanel.createSequentialGroup()
                                .addGap(10)
                                .addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
                                .addGap(9))
                        .addGroup(gl_LapPhieuBaoHanhPanel.createSequentialGroup()
                                .addGap(671)
                                .addComponent(themPhieuBaoHanhBtn, GroupLayout.PREFERRED_SIZE, 150,
                                        GroupLayout.PREFERRED_SIZE)));
        gl_LapPhieuBaoHanhPanel.setVerticalGroup(
                gl_LapPhieuBaoHanhPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_LapPhieuBaoHanhPanel.createSequentialGroup()
                                .addGap(14)
                                .addGroup(gl_LapPhieuBaoHanhPanel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(timKiemChiTietHoaDon, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(timKiemTypeCmbx_1, GroupLayout.PREFERRED_SIZE, 33,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(timkiemBtn, GroupLayout.PREFERRED_SIZE, 35,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(mbtnLmMi, GroupLayout.PREFERRED_SIZE, 35,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(auto_increase_spaceLbl_1, GroupLayout.PREFERRED_SIZE, 37,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 37,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sortCmbx_1, GroupLayout.PREFERRED_SIZE, 35,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(9)
                                .addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                .addGap(10)
                                .addGroup(gl_LapPhieuBaoHanhPanel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 37,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_LapPhieuBaoHanhPanel.createSequentialGroup()
                                                .addGap(1)
                                                .addComponent(loiTxt, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 37,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_LapPhieuBaoHanhPanel.createSequentialGroup()
                                                .addGap(1)
                                                .addComponent(HuongGiaiQuyetTxt, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_LapPhieuBaoHanhPanel.createSequentialGroup()
                                                .addGap(1)
                                                .addComponent(themCTHDBtn, GroupLayout.PREFERRED_SIZE, 35,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_LapPhieuBaoHanhPanel.createSequentialGroup()
                                                .addGap(1)
                                                .addComponent(xoaCTHDBtn, GroupLayout.PREFERRED_SIZE, 35,
                                                        GroupLayout.PREFERRED_SIZE)))
                                .addGap(7)
                                .addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                                .addGap(11)
                                .addComponent(themPhieuBaoHanhBtn, GroupLayout.PREFERRED_SIZE, 35,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(4)));
        LapPhieuBaoHanhPanel.setLayout(gl_LapPhieuBaoHanhPanel);
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(22)
                                .addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
                                .addGap(23)));
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(22)
                                .addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                                .addGap(22)));
        setLayout(groupLayout);

        List<Object[]> phieuBaoHanh = BUS_PhieuBaoHanh.layDanhSachPhieuBaoHanh();
        hienThiPhieuBaoHanh(phieuBaoHanh);

        timKiemBtn_1.addActionListener(new ActionListener() {
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

                        System.out.println("File Excel đã được tạo thành công!");

                        // Hiển thị thông báo khi xuất file thành công
                        JOptionPane.showMessageDialog(null, "File Excel đã được tạo thành công!");

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        timKiemBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) timKiemTypeCmbx.getSelectedItem();
                if (selectedOption.equals("Mã phiếu") || selectedOption.equals("Mã nhân viên")) {
                    String searchText = timKiemBaoHanhTxt.getText();
                    List<Object[]> filteredData = filterByColumn(phieuBaoHanh, selectedOption, searchText);
                    hienThiPhieuBaoHanh(filteredData);
                } else if (selectedOption.equals("Ngày nhận") || selectedOption.equals("Ngày trả")) {
                    java.util.Date utilFromDate = fromDateChooser.getDate();
                    java.sql.Date sqlFromDate = new java.sql.Date(utilFromDate.getTime());
                    java.util.Date utilToDate = toDateChooser.getDate();
                    java.sql.Date sqlToDate = new java.sql.Date(utilToDate.getTime());
                    List<Object[]> filteredData = filterByDateRange(phieuBaoHanh, selectedOption, sqlFromDate,
                            sqlToDate);
                    hienThiPhieuBaoHanh(filteredData);
                }
            }
        });

        sortCmbx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) sortCmbx.getSelectedItem();
                if (selectedOption != null) {
                    List<Object[]> sortedData = sortByColumn(phieuBaoHanh, selectedOption);
                    hienThiPhieuBaoHanh(sortedData);
                }
            }
        });

        timKiemTypeCmbx.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedOption = (String) timKiemTypeCmbx.getSelectedItem();

                    if (selectedOption.equals("Ngày nhận") || selectedOption.equals("Ngày trả")) {
                        timKiemBaoHanhTxt.setText("");
                        timKiemBaoHanhTxt.setEnabled(false);
                    } else {
                        timKiemBaoHanhTxt.setEnabled(true);
                    }
                }
            }
        });

        mbtnLmMi_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timKiemBaoHanhTxt.setText("");
                timKiemTypeCmbx.setSelectedIndex(0);
                sortCmbx.setSelectedIndex(0);

                // Refresh data
                List<Object[]> refreshedData = BUS_PhieuBaoHanh.layDanhSachPhieuBaoHanh();

                // Update displayed data
                hienThiPhieuBaoHanh(refreshedData);

                // Clear any previous filters or selections if needed
                // For example, if you have applied filters or sorting,
                // you might want to reset them when refreshing data.
                // Clear filters or sorting logic can go here.
            }
        });

        chckbxHonThnh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyFilters();
            }
        });

        chckbxNewCheckBox_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyFilters();
            }
        });

        timKiemBtn_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedMapbh = (String) table.getValueAt(table.getSelectedRow(), 0); // Lấy Mã phiếu từ hàng đã
                                                                                             // chọn
                hienThiThongTinChiTietPhieuBaoHanh(selectedMapbh);
            }
        });

    }

    private void hienThiPhieuBaoHanh(List<Object[]> data) {
        // Tạo mô hình dữ liệu mới chỉ chứa các cột cần thiết
        String[] columnNames = { "Mã phiếu", "Ngày nhận", "Ngày trả", "Mã nhân viên" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Thêm các dòng từ dữ liệu vào mô hình dữ liệu mới
        for (Object[] row : data) {
            Object[] rowData = { row[0], row[1], row[2], row[3] }; // Chỉ lấy các cột cần thiết từ dữ liệu
            model.addRow(rowData);
        }

        // Gán mô hình dữ liệu mới cho JTable
        table.setModel(model);
    }

    // Phương thức lọc theo cột (mã phiếu, mã nhân viên)
    private List<Object[]> filterByColumn(List<Object[]> data, String column, String searchText) {
        List<Object[]> filteredData = new ArrayList<>();
        for (Object[] row : data) {
            String value = String.valueOf(row[getColumnIndex(column)]);
            if (value.toLowerCase().contains(searchText.toLowerCase())) {
                filteredData.add(row);
            }
        }
        return filteredData;
    }

    private List<Object[]> filterByDateRange(List<Object[]> data, String column, java.sql.Date fromDate,
            java.sql.Date toDate) {
        List<Object[]> filteredData = new ArrayList<>();
        for (Object[] row : data) {
            java.sql.Date dateValue = (java.sql.Date) row[getColumnIndex(column)];
            if (dateValue.after(fromDate) && dateValue.before(toDate)) {
                filteredData.add(row);
            }
        }
        return filteredData;
    }

    // Phương thức lấy chỉ số cột dựa trên tên cột
    private int getColumnIndex(String columnName) {
        switch (columnName) {
            case "Mã phiếu":
                return 0;
            case "Ngày nhận":
                return 1;
            case "Ngày trả":
                return 2;
            case "Mã nhân viên":
                return 3;
            default:
                return -1;
        }
    }

    // Phương thức sắp xếp dữ liệu theo cột được chọn
    private List<Object[]> sortByColumn(List<Object[]> data, String column) {
        int columnIndex = getColumnIndex(column);
        if (columnIndex >= 0) {
            Collections.sort(data, new Comparator<Object[]>() {
                @Override
                public int compare(Object[] o1, Object[] o2) {
                    Comparable<Object> val1 = (Comparable<Object>) o1[columnIndex];
                    Comparable<Object> val2 = (Comparable<Object>) o2[columnIndex];
                    return val1.compareTo(val2);
                }
            });
        }
        return data;
    }

    private void applyFilters() {
        String selectedOption = (String) timKiemTypeCmbx.getSelectedItem();
        String searchText = timKiemBaoHanhTxt.getText();
        java.util.Date utilFromDate = fromDateChooser.getDate();
        java.sql.Date sqlFromDate = new java.sql.Date(utilFromDate.getTime());

        java.util.Date utilToDate = toDateChooser.getDate();
        java.sql.Date sqlToDate = new java.sql.Date(utilToDate.getTime());

        List<Object[]> filteredData = BUS_PhieuBaoHanh.layDanhSachPhieuBaoHanh();

        if (chckbxHonThnh.isSelected()) {
            filteredData = filterCompleted(filteredData);
        }

        if (chckbxNewCheckBox_1.isSelected()) {
            filteredData = filterIncomplete(filteredData);
        }

        if (selectedOption.equals("Mã phiếu") || selectedOption.equals("Mã nhân viên")) {
            filteredData = filterByColumn(filteredData, selectedOption, searchText);
        } else if (selectedOption.equals("Ngày nhận") || selectedOption.equals("Ngày trả")) {
            filteredData = filterByDateRange(filteredData, selectedOption, sqlFromDate, sqlToDate);
        }

        hienThiPhieuBaoHanh(filteredData);
    }

    private List<Object[]> filterCompleted(List<Object[]> data) {
        List<Object[]> filteredData = new ArrayList<>();
        Date currentDate = new Date(System.currentTimeMillis()); // Ngày hiện tại

        for (Object[] row : data) {
            Date dateValue = (Date) row[getColumnIndex("Ngày trả")];
            if (dateValue != null && dateValue.before(currentDate)) {
                filteredData.add(row);
            }
        }
        return filteredData;
    }

    private List<Object[]> filterIncomplete(List<Object[]> data) {
        List<Object[]> filteredData = new ArrayList<>();
        Date currentDate = new Date(System.currentTimeMillis()); // Ngày hiện tại

        for (Object[] row : data) {
            Date dateValue = (Date) row[getColumnIndex("Ngày trả")];
            if (dateValue != null && dateValue.after(currentDate)) {
                filteredData.add(row);
            }
        }
        return filteredData;
    }

    private void hienThiThongTinChiTietPhieuBaoHanh(String mapbh) {
        List<Object[]> thongTinPhieu = BUS_PhieuBaoHanh.layThongTinPhieuBaoHanh(mapbh);

        if (!thongTinPhieu.isEmpty()) {
            Object[] thongTin = thongTinPhieu.get(0); // Lấy thông tin của phiếu bảo hành đã chọn
            ChiTietPhieuBaoHanhForm form = new ChiTietPhieuBaoHanhForm(thongTin);
            form.setVisible(true);
        }
    }

}
