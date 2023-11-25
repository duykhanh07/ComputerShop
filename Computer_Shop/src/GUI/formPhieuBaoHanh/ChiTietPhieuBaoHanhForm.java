package GUI.formPhieuBaoHanh;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

import com.itextpdf.text.Font;

public class ChiTietPhieuBaoHanhForm extends JFrame {
    private JTextField txtMaPhieu, txtMaNV, txtMaHD, txtMaSP, txtTenSP, txtLoi, txtGiaiQuyet, txtNgayNhan, txtNgayTra;

    public ChiTietPhieuBaoHanhForm(Object[] thongTinPhieu) {
        setTitle("Thông tin chi tiết phiếu bảo hành");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 400);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2));

        txtMaPhieu = new JTextField();
        txtMaNV = new JTextField();
        txtMaHD = new JTextField();
        txtMaSP = new JTextField();
        txtTenSP = new JTextField();
        txtLoi = new JTextField();
        txtGiaiQuyet = new JTextField();
        txtNgayNhan = new JTextField();
        txtNgayTra = new JTextField();

        panel.add(new JLabel("Mã phiếu:"));
        panel.add(txtMaPhieu);
        panel.add(new JLabel("Mã nhân viên:"));
        panel.add(txtMaNV);
        panel.add(new JLabel("Mã hóa đơn:"));
        panel.add(txtMaHD);
        panel.add(new JLabel("Mã sản phẩm:"));
        panel.add(txtMaSP);
        panel.add(new JLabel("Tên sản phẩm:"));
        panel.add(txtTenSP);
        panel.add(new JLabel("Lỗi:"));
        panel.add(txtLoi);
        panel.add(new JLabel("Giải quyết:"));
        panel.add(txtGiaiQuyet);
        panel.add(new JLabel("Ngày nhận:"));
        panel.add(txtNgayNhan);
        panel.add(new JLabel("Ngày trả:"));
        panel.add(txtNgayTra);

        contentPane.add(panel, BorderLayout.CENTER);

        // Hiển thị thông tin từ Object[] vào các JTextField
        txtMaPhieu.setText(thongTinPhieu[0].toString());
        txtMaNV.setText(thongTinPhieu[1].toString());
        txtMaHD.setText(thongTinPhieu[2].toString());
        txtMaSP.setText(thongTinPhieu[3].toString());
        txtTenSP.setText(thongTinPhieu[4].toString());
        txtLoi.setText(thongTinPhieu[5].toString());
        txtGiaiQuyet.setText(thongTinPhieu[6].toString());
        txtNgayNhan.setText(thongTinPhieu[7].toString());
        txtNgayTra.setText(thongTinPhieu[8].toString());

        panel.setBorder(BorderFactory.createTitledBorder("Thông tin phiếu bảo hành"));

        JPanel buttonPanel = new JPanel();
        JButton myButtonTaoPDF = new JButton("Xuất PDF");
        buttonPanel.add(myButtonTaoPDF);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        // Sự kiện khi nhấn nút Xuất PDF
        myButtonTaoPDF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chonViTriLuuPDF(thongTinPhieu);
            }
        });

    }

    private void chonViTriLuuPDF(Object[] thongTin) {
        java.awt.Frame parentFrame = new java.awt.Frame(); // Tạo một instance của java.awt.Frame
        FileDialog fileDialog = new FileDialog(parentFrame, "Chọn vị trí lưu file", FileDialog.SAVE);
        fileDialog.setVisible(true);

        String directory = fileDialog.getDirectory();
        String file = fileDialog.getFile();

        if (directory != null && file != null) {
            try {
                String filePath = directory + file;

                taoPDFtuThongTinPhieu(thongTin, filePath);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void taoPDFtuThongTinPhieu(Object[] thongTin, String filePath) {
        // Tạo PDF từ thông tin phiếu bảo hành và lưu vào đường dẫn filePath
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filePath + ".pdf"));
            document.open();

            Font font = new Font(
                    BaseFont.createFont("D:\\arial-unicode-ms.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            font.setSize(12);
            font.setStyle(Font.NORMAL);

            // Thêm thông tin vào PDF
            document.add(new Paragraph("Mã phiếu: " + thongTin[0]));
            document.add(new Paragraph("Mã nhân viên: " + thongTin[1]));
            document.add(new Paragraph("Mã hóa đơn: " + thongTin[2]));
            document.add(new Paragraph("Mã sản phẩm: " + thongTin[3]));
            document.add(new Paragraph("Tên sản phẩm: " + thongTin[4]));
            document.add(new Paragraph("Lỗi: " + thongTin[5]));
            document.add(new Paragraph("Giải quyết: " + thongTin[6]));
            document.add(new Paragraph("Ngày nhận: " + thongTin[7]));
            document.add(new Paragraph("Ngày trả: " + thongTin[8]));

            document.close();
            JOptionPane.showMessageDialog(null, "Tạo file PDF thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
