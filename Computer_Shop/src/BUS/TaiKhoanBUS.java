package BUS;

import java.util.ArrayList;
import java.util.Collections;

import DAO.DAO_TaiKhoan;
import DTO.DTO_KhachHang;
import DTO.DTO_TaiKhoan;
import GUI.MainForm;

public class TaiKhoanBUS {
	public ArrayList<DTO_TaiKhoan> ds_taiKhoan;
	public ArrayList<DTO_TaiKhoan> ds_hienThi;
	public TaiKhoanBUS() {
		ds_taiKhoan = new DAO_TaiKhoan().selectAllTaiKhoan();
		if(ds_taiKhoan.size() >0 ) {
			ds_hienThi = (ArrayList<DTO_TaiKhoan>) ds_taiKhoan.clone();
		}
	}
	
	public int themTK(DTO_TaiKhoan tk) {
		return DAO_TaiKhoan.themTaiKhoan(tk);
	}
	
	public int suaTK(String matk, String manv) {
		return DAO_TaiKhoan.suaTK(matk, manv);
	}
	public void sapXepTaiKhoan(int selectedIndex) {
		switch (selectedIndex) {
		case 1:
			Collections.sort(ds_hienThi, (o1, o2) -> o1.compareByName(o2));
			break;
		case 2:
			Collections.sort(ds_hienThi, (o1, o2) -> o2.compareByName(o1));
			break;
		default:
			Collections.sort(ds_hienThi, (o1, o2) -> o1.getMatk().compareToIgnoreCase(o2.getMatk()));
			break;
		}
	}
	
	public void timKiemTaiKhoan(String thongTinTimKiem, int selectedIndex) {
		ds_taiKhoan.clear();
		for (int i = 0; i < ds_taiKhoan.size(); i++) {
			switch (selectedIndex) {
			case 0:
				if (ds_taiKhoan.get(i).getMatk().contains(thongTinTimKiem)) {
					ds_hienThi.add(ds_taiKhoan.get(i));
				}
				break;
			case 1:
				if (ds_taiKhoan.get(i).getPassword().equalsIgnoreCase(thongTinTimKiem)) {
					ds_hienThi.add(ds_taiKhoan.get(i));
				}
				break;
			case 2:
				if (ds_taiKhoan.get(i).getManv().contains(thongTinTimKiem)) {
					ds_hienThi.add(ds_taiKhoan.get(i));
				}
				break;
			}
		}
	}
}
