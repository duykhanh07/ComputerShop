package BUS;

import java.util.ArrayList;

import DAO.DAO_TaiKhoan;
import DTO.DTO_TaiKhoan;
import GUI.MainForm;

public class TaiKhoanBUS {
	public ArrayList<DTO_TaiKhoan> ds_taikhoan;
	public TaiKhoanBUS() {
		ds_taikhoan = new DAO_TaiKhoan().selectAllTaiKhoan();
	}
	
	public int themTK(DTO_TaiKhoan tk) {
		return DAO_TaiKhoan.themTaiKhoan(tk);
	}
	
	public int suaTK(String matk, String manv) {
		return DAO_TaiKhoan.suaTK(matk, manv);
	}
}
