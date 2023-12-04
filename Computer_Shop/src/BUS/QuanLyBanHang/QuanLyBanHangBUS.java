package BUS.QuanLyBanHang;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import DAO.BanHangDAO;
import DTO.DTO_CTHoaDon;
import DTO.DTO_HoaDon;
import DTO.DTO_KhachHang;
import DTO.DTO_SanPham;

public class QuanLyBanHangBUS {
	private BanHangDAO banHangDAO;
	
	public ArrayList<DTO_SanPham> ds_sanPham;
	public ArrayList<DTO_SanPham> ds_hienThi;
	public ArrayList<String> ds_hang;
	
	
	public HashMap<String, Integer> ds_tonkho;
	public ArrayList<DTO_SanPham> gioHang_sanpham;
	public ArrayList<Integer> gioHang_soluong;
	
	public ArrayList<DTO_KhachHang> ds_khachHang;
	private String makh;
	private int diemTichLuyKhachHang;

	private long tongTien;
	
	
	public QuanLyBanHangBUS() {
		banHangDAO = new BanHangDAO();
		ds_sanPham = banHangDAO.layCacSanPham();
		ds_hienThi = (ArrayList<DTO_SanPham>) ds_sanPham.clone();
		ds_tonkho = banHangDAO.layTonKho();
		gioHang_sanpham = new ArrayList<DTO_SanPham>();
		gioHang_soluong = new ArrayList<Integer>();
		ds_khachHang = banHangDAO.layKhachHang();
		makh = "";
		layCacHang();
	}
	
	public void timKiem(String timKiemStr) {
		ds_hienThi.clear();
		for(int i = 0; i<ds_sanPham.size(); i++) {
			if(ds_sanPham.get(i).getTensp().toLowerCase().trim().contains(timKiemStr.toLowerCase().trim())) {
				ds_hienThi.add(ds_sanPham.get(i));
			}
		}
		layCacHang();
	}
	
	public void filterByBrand(ArrayList<String> cacHang, String timKiemStr) {
		timKiem(timKiemStr);
		for(int i = 0; i< ds_hienThi.size(); i++) {
			if(!cacHang.contains(ds_hienThi.get(i).getHang())) {
				ds_hienThi.remove(i);
				i--;
			}
		}
	}
	
	public void layCacHang(){
		ds_hang = new ArrayList<String>();
		for(int i = 0; i<ds_hienThi.size(); i++) {
			if(!ds_hang.contains(ds_hienThi.get(i).getHang())) {
				ds_hang.add(ds_hienThi.get(i).getHang());
			}
		}
	}
	public void sapXepTheoGia(int type) {
		if(type == 0) {
			Collections.sort(ds_hienThi, (o1, o2) -> o1.getGia() - o2.getGia());
		}else if(type == 1) {
			Collections.sort(ds_hienThi, (o1, o2) -> o2.getGia() - o1.getGia());
		}
	}
	
	public int themVaoGioHang(DTO_SanPham sp, int soluong) {
		for(int i = 0; i<gioHang_sanpham.size(); i++) {
			if(gioHang_sanpham.get(i).getMasp().equals(sp.getMasp())) {
				if(soluong <= ds_tonkho.get(sp.getMasp())) {	
					gioHang_soluong.set(i, soluong);
					return 1;					
				}else {
					return -1;
				}
			}
		}
		gioHang_sanpham.add(sp);
		gioHang_soluong.add(soluong);
		tinhTongTien();
		return 1;
	}
	public void boKhoiGioHang(String  masp) {
		for(int i = 0; i<gioHang_sanpham.size(); i++) {
			if(gioHang_sanpham.get(i).getMasp().equals(masp)) {
				gioHang_sanpham.remove(i);
			}
		}
		tinhTongTien();
	}
	public long tinhTongTien() {
		tongTien = 0l;
		for(int i =0; i<gioHang_sanpham.size(); i++) {
			tongTien += gioHang_sanpham.get(i).getGia() * gioHang_soluong.get(i);
		}
		return tongTien;
	}
	public String timKiemKhachHang(String sdt) {
		for(int i = 0; i<ds_khachHang.size(); i++) {
			if(ds_khachHang.get(i).getSdt().equalsIgnoreCase(sdt)) {
				makh = ds_khachHang.get(i).getMakh();
				diemTichLuyKhachHang = ds_khachHang.get(i).getDiem();
				return ds_khachHang.get(i).getTenkh();
			}
		}
		return "";
	}
	public void taoHoaDon(String manv, String diaChi) {
		String mahd = taoMaHoaDon();
		Date ngayLapHd = new Date(System.currentTimeMillis());
		
		// tongTien = tinhTongTien
		
		String trangThai;
		if(diaChi!=null) {
			trangThai = "Đang giao";
		}else {
			trangThai = "Đã thanh toán";
		}
		
		// Cập nhật điểm cho khách hàng
		if((int)tongTien/100000 + diemTichLuyKhachHang > 100) {
			int phanTramGiam = (int) ((tongTien/100000 + diemTichLuyKhachHang)/100);
			int diemConLai = (int)(tongTien/100000 + diemTichLuyKhachHang)%100;
			banHangDAO.congDiemTichLuy(makh, diemConLai);
			tongTien = tongTien*(100 - phanTramGiam)/100;
		}else {
			banHangDAO.congDiemTichLuy(makh, (int)tongTien/100000 + diemTichLuyKhachHang);
		}
		
		
		// Thêm hóa đơn
		banHangDAO.themHoaDon(mahd, makh, manv,diaChi, tongTien, trangThai);
			//Thêm các chi tiết hóa đơn
		for(int i =0 ; i< gioHang_sanpham.size(); i++) {
			banHangDAO.themCtHoaDon(mahd, gioHang_sanpham.get(i).getMasp(), gioHang_sanpham.get(i).getGia(), gioHang_soluong.get(i));
		}
		
		inHoaDon(mahd);
		
	}
	public void taoHoaDon(String manv,String tenKh, String sdt, String diaChi) {
		String makh = taoMaKhachHang();
		
		String mahd = taoMaHoaDon();
		
		long tongTien = 0l;
		for(int i =0; i<gioHang_sanpham.size(); i++) {
			tongTien += gioHang_sanpham.get(i).getGia() * gioHang_soluong.get(i);
		}
		
		String trangThai;
		if(diaChi!=null) {
			trangThai = "Đang giao";
		}else {
			trangThai = "Đã thanh toán";
		}
		
		// Thêm khách hàng
		DTO_KhachHang kh = new DTO_KhachHang(makh, tenKh, sdt, 0);
		banHangDAO.themKhachHang(kh);
		
		// Thêm hóa đơn
		banHangDAO.themHoaDon(mahd, makh, manv,diaChi, tongTien, trangThai);
			//Thêm các chi tiết hóa đơn
		for(int i =0 ; i< gioHang_sanpham.size(); i++) {
			banHangDAO.themCtHoaDon(mahd, gioHang_sanpham.get(i).getMasp(), gioHang_sanpham.get(i).getGia(), gioHang_soluong.get(i));
		}
		inHoaDon(mahd);
	}
	public String taoMaHoaDon() {
		int stt_hd = banHangDAO.taoSTT_HoaDon();
		String mahd = "HD";
		if(stt_hd<1000) {
			mahd+= 0;
			if(stt_hd<100) {
				mahd+= 0;
				if(stt_hd<10) {
					mahd+= 0;
				}
			}
		}
		mahd += stt_hd;
		return mahd;
	}
	public String taoMaKhachHang() {
		ds_khachHang = banHangDAO.layKhachHang();
		String makh = "KH";
		int stt_kh = ds_khachHang.size()+1;
		if(stt_kh<1000) {
			makh+= 0;
			if(stt_kh<100) {
				makh+= 0;
				if(stt_kh<10) {
					makh+= 0;
				}
			}
		}
		makh += stt_kh;
		return makh;
	}
	public void inHoaDon(String mahd) {
		DTO_HoaDon hd = banHangDAO.layHoaDon(mahd);
		ResultSet ds_cthd = banHangDAO.layChiTiet1HoaDon(mahd);
		
		String pdfFilePath = "HoaDon"+mahd+".pdf";
		Document document = new Document();

        try {
            // Tạo đối tượng PdfWriter và gắn liền với file PDF
            PdfWriter.getInstance(document, new FileOutputStream(pdfFilePath));

            // Mở document để bắt đầu ghi thông tin
            document.open();

            // Thiết lập lề trên, dưới, trái, và phải của trang PDF là 1cm
            document.setMargins(72, 72, 72, 72);

            // Sử dụng font Unicode hỗ trợ tiếng Việt (Ví dụ: Arial Unicode MS)
            BaseFont baseFont = BaseFont.createFont("C:/Windows/Fonts/timesbd.ttf", BaseFont.IDENTITY_H,
                    BaseFont.EMBEDDED);

            Font titleFont = new Font(baseFont, 16, Font.BOLD);
            Paragraph title = new Paragraph("HÓA ĐƠN", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            Font TitleFont = new Font(baseFont, 12);

            Paragraph maHD = new Paragraph("Mã hóa đơn: " + mahd, TitleFont);
            maHD.setAlignment(Element.ALIGN_LEFT);
            document.add(maHD);

            Paragraph tenkhX = new Paragraph("Mã khách hàng: " + hd.getMakh(), TitleFont);
            tenkhX.setAlignment(Element.ALIGN_LEFT);
            document.add(tenkhX);

            // setp địa chỉ

            if(hd.getDiachigiao()!=null) {
            	Paragraph diachiX = new Paragraph("Địa chỉ: " + hd.getDiachigiao(), TitleFont);
                diachiX.setAlignment(Element.ALIGN_LEFT);
                document.add(diachiX);
            }
            
            Paragraph manvX = new Paragraph("Mã nhân viên: " + hd.getManv(), TitleFont);
            manvX.setAlignment(Element.ALIGN_LEFT);
            document.add(manvX);

            Paragraph dateX = new Paragraph("Ngày: " + hd.getNgaylaphd(), TitleFont);
            dateX.setAlignment(Element.ALIGN_RIGHT);
            document.add(dateX);

                   
            PdfPTable t = new PdfPTable(5);
            t.setSpacingBefore(25);
            t.setSpacingAfter(25);

            // Thêm các cột vào bảng
            t.addCell(new PdfPCell(new Phrase("Mã sản phẩm", new Font(baseFont))));
            t.addCell(new PdfPCell(new Phrase("Tên sản phẩm", new Font(baseFont))));
            t.addCell(new PdfPCell(new Phrase("Đơn giá", new Font(baseFont))));
            t.addCell(new PdfPCell(new Phrase("Số lượng", new Font(baseFont))));
            t.addCell(new PdfPCell(new Phrase("Thành tiền", new Font(baseFont))));

            String masp="" ;
            String tensp="" ;
            Long dongia = 0l;
            int soluong=0 ;
            Long thanhtien= 0l;
        	
        	try {
        		while(ds_cthd.next())
            	{	
            			masp = ds_cthd.getString("masp");
            			tensp = ds_cthd.getString("tensp");
                        dongia = ds_cthd.getLong("dongia");
                        soluong =ds_cthd.getInt("solg");
                        thanhtien = dongia*soluong;
                        
                        // Thêm ô cho mỗi đối tượng CartItem
                        t.addCell(new PdfPCell(new Phrase(masp, new Font(baseFont))));
                        t.addCell(new PdfPCell(new Phrase(tensp, new Font(baseFont))));
                        t.addCell(new PdfPCell(new Phrase(String.valueOf(dongia), new Font(baseFont))));
                        t.addCell(new PdfPCell(new Phrase(String.valueOf(soluong), new Font(baseFont))));
                        t.addCell(new PdfPCell(new Phrase(String.valueOf(thanhtien), new Font(baseFont))));
  
                }
            	document.add(t);
			} catch (Exception e) {
				System.out.println(e);
			}	
        	
        	 Paragraph thanhtienX = new Paragraph("Tổng cộng: " + (long)hd.getTongtien(), TitleFont);
             thanhtienX.setAlignment(Element.ALIGN_RIGHT);
             document.add(thanhtienX);
             
            
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			document.close();
			openPDFWithEdge(pdfFilePath);
		}
	}
	private static void openPDFWithEdge(String pdfFilePath) {
        try {
            File file = new File(pdfFilePath);
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}	
