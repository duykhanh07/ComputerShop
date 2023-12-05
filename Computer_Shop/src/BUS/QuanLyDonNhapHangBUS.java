package BUS;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.DAO_ChiTietDonNhap;
import DAO.DAO_QuanLyDonNhap;
import DTO.DTO_CTDonNhap;
import DTO.DTO_DonNhap;
import GUI.QuanLyKho.ChiTietDonNhap;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;




import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class QuanLyDonNhapHangBUS {
	
	DAO_QuanLyDonNhap daoDonNhap;
	DAO_ChiTietDonNhap daoChiTietDonNhap;
	DecimalFormat df = new DecimalFormat("#,###");
	public QuanLyDonNhapHangBUS() {
		daoDonNhap = new DAO_QuanLyDonNhap();
		daoChiTietDonNhap = new DAO_ChiTietDonNhap();
	}
	
	public void hienThiDonNhapHang(JTable table) {
		ArrayList<DTO_DonNhap> listDonNhap = daoDonNhap.selectAllDonNhap();
		for (DTO_DonNhap dto_DonNhap : listDonNhap) {
			Object[] rowData = {dto_DonNhap.getMadn(),dto_DonNhap.getManv(),dto_DonNhap.getMancc(), df.format((long)dto_DonNhap.getTongtien()), dto_DonNhap.getNgaynhap()};
			DefaultTableModel  model_table = (DefaultTableModel) table.getModel();
			model_table.addRow(rowData);
		}
		
	}
	
	public void selectDonNhap_MaDN(JTable table,String madn){
		ArrayList<DTO_DonNhap> listDonNhap = daoDonNhap.selectDonNhap_MaDN(madn);
		for (DTO_DonNhap dto_DonNhap : listDonNhap) {
			Object[] rowData = {dto_DonNhap.getMadn(),dto_DonNhap.getManv(),dto_DonNhap.getMancc(), df.format((long)dto_DonNhap.getTongtien()), dto_DonNhap.getNgaynhap()};
			DefaultTableModel  model_table = (DefaultTableModel) table.getModel();
			model_table.addRow(rowData);
		}
	}
	public void selectDonNhap_MaNV(JTable table,String manv){
		ArrayList<DTO_DonNhap> listDonNhap = daoDonNhap.selectDonNhap_MaNV(manv);
		for (DTO_DonNhap dto_DonNhap : listDonNhap) {
			Object[] rowData = {dto_DonNhap.getMadn(),dto_DonNhap.getManv(),dto_DonNhap.getMancc(), df.format((long)dto_DonNhap.getTongtien()), dto_DonNhap.getNgaynhap()};
			DefaultTableModel  model_table = (DefaultTableModel) table.getModel();
			model_table.addRow(rowData);
		}
	}
	public void selectDonNhap_MaNCC(JTable table,String mancc){
		ArrayList<DTO_DonNhap> listDonNhap = daoDonNhap.selectDonNhap_MaNCC(mancc);
		for (DTO_DonNhap dto_DonNhap : listDonNhap) {
			Object[] rowData = {dto_DonNhap.getMadn(),dto_DonNhap.getManv(),dto_DonNhap.getMancc(), df.format((long)dto_DonNhap.getTongtien()), dto_DonNhap.getNgaynhap()};
			DefaultTableModel  model_table = (DefaultTableModel) table.getModel();
			model_table.addRow(rowData);
		}
	}
	
	public void selectDonNhap_Ngay(JTable table, String ngayBatDau, String ngayKetThuc){
		ArrayList<DTO_DonNhap> listDonNhap = daoDonNhap.selectDonNhap_Ngay(ngayBatDau, ngayKetThuc);
		for (DTO_DonNhap dto_DonNhap : listDonNhap) {
			Object[] rowData = {dto_DonNhap.getMadn(),dto_DonNhap.getManv(),dto_DonNhap.getMancc(), df.format((long)dto_DonNhap.getTongtien()), dto_DonNhap.getNgaynhap()};
			DefaultTableModel  model_table = (DefaultTableModel) table.getModel();
			model_table.addRow(rowData);
		}
	}
	public String getTenNhanVien(String manv) {
		return daoDonNhap.getTenNhanVien(manv);
	}
	public String getTenNCC(String mancc) {
		return daoDonNhap.getTenNCC(mancc);
	}
	public void generatePDF(String madn,String tennvl,String tennvi,String tenncc,String tong, String ngayNhap, String pdfFilePath) {
        Document document = new Document();
        ArrayList<DTO_CTDonNhap> listChiDonNhap = daoChiTietDonNhap.selectChiTietDonNhap(madn);
        try {
            // Tạo đối tượng PdfWriter và gắn liền với file PDF
            PdfWriter.getInstance(document, new FileOutputStream(pdfFilePath));

            // Mở document để bắt đầu ghi thông tin
            document.open();

            // Thiết lập lề trên, dưới, trái, và phải của trang PDF là 1cm
            document.setMargins(72, 72, 72, 72);
            
            // Sử dụng font Unicode hỗ trợ tiếng Việt (Ví dụ: Arial Unicode MS)
            BaseFont baseFont = BaseFont.createFont("C:/Windows/Fonts/timesbd.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            
            Font titleFont = new Font(baseFont, 16, Font.BOLD);
            Paragraph title = new Paragraph("ĐƠN NHẬP HÀNG", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            
            Font TitleFont = new Font(baseFont, 12);
            
            Paragraph maDN = new Paragraph("Mã đơn nhập: "+madn, TitleFont);
            maDN.setAlignment(Element.ALIGN_LEFT);
            document.add(maDN);

            Paragraph tenNCC = new Paragraph("Tên nhà cung cấp: "+tenncc, TitleFont);
            tenNCC.setAlignment(Element.ALIGN_LEFT);
            document.add(tenNCC);
            
            Paragraph maNVL = new Paragraph("Tên nhân viên lập phiếu: "+tennvl, TitleFont);
            maNVL.setAlignment(Element.ALIGN_LEFT);
            document.add(maNVL);
            
            Paragraph maNVI = new Paragraph("Tên nhân viên in phiếu: "+tennvi, TitleFont);
            maNVI.setAlignment(Element.ALIGN_LEFT);
            document.add(maNVI);
            
            Paragraph NgayNhap = new Paragraph("Ngày lập: "+ngayNhap, TitleFont);
            NgayNhap.setAlignment(Element.ALIGN_RIGHT);
            document.add(NgayNhap);
            

            if (!listChiDonNhap.isEmpty()) {
                PdfPTable t = new PdfPTable(5);
                t.setSpacingBefore(25);
                t.setSpacingAfter(25);
                // Thêm các cột vào bảng
                t.addCell(new PdfPCell(new Phrase("Mã sản phẩm", new Font(baseFont))));
                t.addCell(new PdfPCell(new Phrase("Tên sản phẩm", new Font(baseFont))));
                t.addCell(new PdfPCell(new Phrase("Đơn giá", new Font(baseFont))));
                t.addCell(new PdfPCell(new Phrase("Số lượng", new Font(baseFont))));
                t.addCell(new PdfPCell(new Phrase("Thành tiền", new Font(baseFont))));
                for (DTO_CTDonNhap chitiet : listChiDonNhap) {
                	String masp = chitiet.getMasp().trim().toString();
                    String tensp = chitiet.getTensp().trim().toString();
                    Double dongia = chitiet.getDongia();
                    int soluong = chitiet.getSolg();
                    Double thanhtien = chitiet.getThanhtien();
                    // Thêm ô cho mỗi đối tượng 
                    t.addCell(new PdfPCell(new Phrase(masp, new Font(baseFont))));
                    t.addCell(new PdfPCell(new Phrase(tensp, new Font(baseFont))));
                    t.addCell(new PdfPCell(new Phrase(dongia+"", new Font(baseFont))));
                    t.addCell(new PdfPCell(new Phrase(soluong+"", new Font(baseFont))));
                    t.addCell(new PdfPCell(new Phrase(thanhtien+"", new Font(baseFont))));
    			}
                // Thêm bảng vào tài liệu
                document.add(t);

                // Đặt tổng chiều rộng của bảng bằng tổng chiều rộng của trang trừ đi lề
                t.setTotalWidth(document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin());

            } else {
                // Xử lý trường hợp giỏ hàng trống
                document.add(new Paragraph("Phiếu nhập không có sản phẩm"));
            }
            Paragraph TongCong = new Paragraph("Tổng cộng: "+tong, TitleFont);
            TongCong.setAlignment(Element.ALIGN_RIGHT);
            document.add(TongCong);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng document sau khi ghi xong
            document.close();
        }
    }
}
