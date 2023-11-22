package BUS;

import java.util.ArrayList;
import java.util.List;

import DAO.DAO_ThongKeDoanhSo;
import DTO.DTO_CTHoaDon;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BUS_ThongKeDoanhSo {

    public List<Object[]> getSanPhamDaBanTheoNam(int selectedYear) {
        return DAO_ThongKeDoanhSo.getSanPhamDaBanTheoNam(selectedYear);
    }

    public List<Object[]> getSanPhamDaBanTheoQuy(int selectedYear, int selectedQuarter) {
        return DAO_ThongKeDoanhSo.getSanPhamDaBanTheoQuyTrongNam(selectedYear, selectedQuarter);
    }

    public List<Object[]> getSanPhamDaBanTheoThangTrongQuy(int selectedYear, int selectedQuarter, int selectedMonth) {
        return DAO_ThongKeDoanhSo.getSanPhamDaBanTheoThangTrongQuy(selectedYear, selectedQuarter, selectedMonth);
    }

    public static List<DTO_CTHoaDon> getCTHDData() {
        return DAO_ThongKeDoanhSo.getCTHDData();
    }

    public static List<Object[]> getSalesData() {
        return DAO_ThongKeDoanhSo.getSalesData();
    }
}