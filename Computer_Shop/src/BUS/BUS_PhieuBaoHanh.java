package BUS;

import java.sql.Date;
import java.util.List;

import DAO.DAO_PhieuBaoHanh;
import DTO.DTO_PhieuBaoHanh;

public class BUS_PhieuBaoHanh {
	public static List<Object[]> layDanhSachPhieuBaoHanh() {
        return DAO_PhieuBaoHanh.layDanhSachPhieuBaoHanh();
    }
	
	public static List<Object[]> layDanhSachPhieuBaoHanhTheoNgay(Date tuNgay, Date denNgay) {
        return DAO_PhieuBaoHanh.layDanhSachPhieuBaoHanhTheoNgay(tuNgay, denNgay);
    }
}
