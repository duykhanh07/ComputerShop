package BUS;

import java.util.ArrayList;

import DAO.DAO_NhanVien;
import DTO.DTO_NhanVien;
import GUI.MainForm;

public class NhanVienBUS {
	public ArrayList<DTO_NhanVien> ds_nhanvien;
	public NhanVienBUS() {
		ds_nhanvien = new DAO_NhanVien().selectAllNhanVien();
	}
	
	public int themNV(DTO_NhanVien nv) {
		return DAO_NhanVien.themNV(nv);
	}
}
