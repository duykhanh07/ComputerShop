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

import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

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
        JButton myButtonTaoPDF = new JButton("Xuất WORD");
        buttonPanel.add(myButtonTaoPDF);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        myButtonTaoPDF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chonViTriLuuWord(thongTinPhieu);
            }
        });

    }

    private void taoWordTuThongTinPhieu(Object[] thongTin, String filePath) {
        try {
            XWPFDocument document = new XWPFDocument();

            // Tạo đối tượng XWPFParagraph cho tiêu đề "PHIẾU BẢO HÀNH"
            XWPFParagraph title = document.createParagraph();
            title.setAlignment(ParagraphAlignment.CENTER);
            title.setBorderBottom(Borders.SINGLE); // Thêm khung chứa cho tiêu đề
            title.setBorderTop(Borders.SINGLE);
            title.setBorderLeft(Borders.SINGLE);
            title.setBorderRight(Borders.SINGLE);
            XWPFRun titleRun = title.createRun();
            titleRun.setBold(true);
            titleRun.setFontSize(16);
            titleRun.setText("PHIẾU BẢO HÀNH");

            // Tạo các đối tượng XWPFParagraph cho từng thông tin và thêm khung chứa
            for (int i = 0; i < thongTin.length; i++) {
                XWPFParagraph paragraph = document.createParagraph();
                XWPFRun run = paragraph.createRun();

                // Đặt thông tin dưới dạng "Mã phiếu: ..."
                run.setText(getLabel(i) + thongTin[i]);

                // Thêm khung chứa bằng cách thiết lập border
                paragraph.setBorderBottom(Borders.SINGLE);
                paragraph.setBorderTop(Borders.SINGLE);
                paragraph.setBorderLeft(Borders.SINGLE);
                paragraph.setBorderRight(Borders.SINGLE);
            }

            // Tạo file Word tại đường dẫn được chỉ định
            FileOutputStream out = new FileOutputStream(filePath + ".docx");
            document.write(out);
            out.close();
            System.out.println("File Word đã được tạo thành công!");
            JOptionPane.showMessageDialog(null, "Tạo file Word thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getLabel(int index) {
        // Mảng chứa các nhãn tương ứng với từng thông tin
        String[] labels = {
                "Mã phiếu: ",
                "Mã nhân viên: ",
                "Mã hóa đơn: ",
                "Mã sản phẩm: ",
                "Tên sản phẩm: ",
                "Lỗi: ",
                "Giải quyết: ",
                "Ngày nhận: ",
                "Ngày trả: "
        };

        return labels[index];
    }

    private void chonViTriLuuWord(Object[] thongTin) {
        java.awt.Frame parentFrame = new java.awt.Frame(); // Tạo một instance của java.awt.Frame
        FileDialog fileDialog = new FileDialog(parentFrame, "Chọn vị trí lưu file", FileDialog.SAVE);
        fileDialog.setVisible(true);

        String directory = fileDialog.getDirectory();
        String file = fileDialog.getFile();

        if (directory != null && file != null) {
            try {
                String filePath = directory + file;

                taoWordTuThongTinPhieu(thongTin, filePath);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
