package BUS.QuanLyBanHang;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import BUS.ChiTietHoaDonBUS;
import BUS.HoaDonBUS;
import DTO.DTO_CTHoaDon;
import DTO.DTO_HoaDon;
import GUI.QuanLyBanHang.CartItem;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class InHoaDonBUS {

	 public static  String pdfFilePath;

     // Đặc biệt
	 
	 public static String mahd1;
     public static String makh1;
   //  tensp = array.get(0).get;
     public static String manv1 ;
     public static Long tongcong;

     public static String diachi1;
     public static Date date1 ;
     public static String trangthai1;
    
    
    public static void PrintHD(String mahd) {
    	mahd1 = mahd;
    	
    	HoaDonBUS hd = new HoaDonBUS();
    	ArrayList<DTO_HoaDon> hdlist = hd.get_AllHoaDon();
    	
    	DTO_HoaDon hd1 = null ;
    	for (DTO_HoaDon x: hdlist )
    	{
    		if (x.getMahd().equalsIgnoreCase(mahd))
    		{
    			hd1 = new DTO_HoaDon(x.getMahd(),x.getMakh(),x.getManv(),x.getNgaylaphd(),
    					x.getDiachigiao(),x.getTongtien(),x.getTrangthai());
    			
    		}
    	}
    	
    	
        pdfFilePath = "HoaDon.pdf";

        // Đặc biệt
        makh1 = hd1.getMakh();
      //  tensp = array.get(0).get;
        manv1 = hd1.getManv();
        tongcong = (long) hd1.getTongtien();

        diachi1 = hd1.getDiachigiao();
        date1 = hd1.getNgaylaphd();
        
        trangthai1 = hd1.getTrangthai();

       
        
        generatePDF(mahd, pdfFilePath);
//makh1,manv1,date1,diachi1,thanhtien1,trangthai1, 
        System.out.println("File PDF được tạo thành công.");

        openPDFWithEdge(pdfFilePath);

    }
//, String makh, String manv, Date date, String diachi,double thanhtien,String trangthai
   
    public static void generatePDF(String mahd, String pdfFilePath) {
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

            Paragraph maHD = new Paragraph("Mã hóa đơn: " + mahd1, TitleFont);
            maHD.setAlignment(Element.ALIGN_LEFT);
            document.add(maHD);

            Paragraph tenkhX = new Paragraph("Mã khách hàng: " + makh1, TitleFont);
            tenkhX.setAlignment(Element.ALIGN_LEFT);
            document.add(tenkhX);

            // setp địa chỉ

            Paragraph diachiX = new Paragraph("Địa chỉ: " + diachi1, TitleFont);
            diachiX.setAlignment(Element.ALIGN_LEFT);
            document.add(diachiX);

            Paragraph manvX = new Paragraph("Mã nhân viên: " + manv1, TitleFont);
            manvX.setAlignment(Element.ALIGN_LEFT);
            document.add(manvX);

            Paragraph dateX = new Paragraph("Ghi nhận: " + date1, TitleFont);
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
            
            ChiTietHoaDonBUS hdd = new ChiTietHoaDonBUS();
        	ResultSet hdlist2 = (ResultSet) hdd.get_AllChiTietHoaDon(mahd);
        	
        //	ArrayList <DTO_CTHoaDon> array = new ArrayList<DTO_CTHoaDon>();
        	try {
        		while(hdlist2.next())
            	{	
            			masp = hdlist2.getString("masp");
            			tensp = hdlist2.getString("tensp");
                        dongia = hdlist2.getLong("dongia");
                        soluong =hdlist2.getInt("solg");
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
        	

           /* // Tổng cộng
            DecimalFormat decimalFormat = new DecimalFormat("#");
            Paragraph tc = new Paragraph("Tổng cộng: " + String.valueOf(decimalFormat.format(thanhtien1)), TitleFont);
            tc.setAlignment(Element.ALIGN_RIGHT);
            document.add(tc);
            */
            Paragraph thanhtienX = new Paragraph("Tổng cộng: " + tongcong, TitleFont);
            thanhtienX.setAlignment(Element.ALIGN_RIGHT);
            document.add(thanhtienX);
            
            Paragraph tinhtrangX = new Paragraph("Tình trạng: " + trangthai1, TitleFont);
            tinhtrangX.setAlignment(Element.ALIGN_RIGHT);
            document.add(tinhtrangX);

        } catch (

        Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng document sau khi ghi xong
            document.close();
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
