package BUS;

import java.util.List;

import DAO.DAO_PhieuBaoHanh;

public class BUS_PhieuBaoHanh {
	public static List<Object[]> layDanhSachPhieuBaoHanh() {
		return DAO_PhieuBaoHanh.layDanhSachPhieuBaoHanh();
	}

	public static List<Object[]> layThongTinPhieuBaoHanh(String mapbh) {
		return DAO_PhieuBaoHanh.layThongTinPhieuBaoHanh(mapbh);
	}
	public static boolean capNhatNgayTra(String mapbh) {
		 return DAO_PhieuBaoHanh.capNhatNgayTra(mapbh);
	 }
}
