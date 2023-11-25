package BUS;

import java.util.List;
import DAO.DAO_ThongKeDoanhSo;
import DTO.DTO_CTHoaDon;

public class BUS_ThongKeDoanhSo {

    public static List<Object[]> getSanPhamDaBanTheoNam(int selectedYear) {
        return DAO_ThongKeDoanhSo.getSanPhamDaBanTheoNam(selectedYear);
    }

    public List<Object[]> getSanPhamDaBanTheoQuy(int selectedYear, int selectedQuarter) {
        return DAO_ThongKeDoanhSo.getSanPhamDaBanTheoQuy(selectedYear, selectedQuarter);
    }

    public List<Object[]> getSanPhamDaBanTheoThang(int selectedYear, int selectedQuarter, int selectedMonth) {
        return DAO_ThongKeDoanhSo.getSanPhamDaBanTheoThang(selectedYear, selectedQuarter, selectedMonth);
    }

    public List<Object[]> getSanPhamDaBan(int selectedYear, int selectedMonth) {
        return DAO_ThongKeDoanhSo.getSanPhamDaBan(selectedYear, selectedMonth);
    }

    public static List<DTO_CTHoaDon> getCTHDData() {
        return DAO_ThongKeDoanhSo.getCTHDData();
    }

    public static List<Object[]> getSalesData() {
        return DAO_ThongKeDoanhSo.getSalesData();
    }

}