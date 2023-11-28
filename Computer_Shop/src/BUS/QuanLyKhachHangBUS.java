package BUS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

import DAO.QuanLyKhachHangDAO;
import DTO.DTO_KhachHang;

public class QuanLyKhachHangBUS {
	public ArrayList<DTO_KhachHang> ds_khachHang;
	public HashMap<String,Date> ds_lanCuoi;
	public ArrayList<DTO_KhachHang> ds_hienThi;
	
	public QuanLyKhachHangBUS() {
		ds_khachHang = QuanLyKhachHangDAO.layKhachHang();
		ds_lanCuoi = QuanLyKhachHangDAO.layLanCuoiMuaHang();
		if(ds_khachHang.size()>0) {
			ds_hienThi = (ArrayList<DTO_KhachHang>) ds_khachHang.clone();
		}	
	}
	public void sapXepKhachHang(int selectedIndex) {
		switch(selectedIndex) {
			case 1 : Collections.sort(ds_hienThi, (o1,o2) -> o1.compareByName(o2));break;
			case 2 : Collections.sort(ds_hienThi, (o1,o2) -> o2.compareByName(o1));break;
			case 3 : Collections.sort(ds_hienThi, (o1,o2)-> o1.getDiem() - o2.getDiem());break;
			case 4 : Collections.sort(ds_hienThi, (o1,o2)-> o2.getDiem() - o1.getDiem());break;
			case 5 : Collections.sort(ds_hienThi, (o1,o2)-> ds_lanCuoi.get(o1.getMakh()).compareTo(ds_lanCuoi.get(o2.getMakh())));break;
			case 6 : Collections.sort(ds_hienThi, (o1,o2)-> ds_lanCuoi.get(o2.getMakh()).compareTo(ds_lanCuoi.get(o1.getMakh())));break;
			default:Collections.sort(ds_hienThi, (o1,o2)-> o1.getMakh().compareToIgnoreCase(o2.getMakh()));break;
		}
	}
	public void timKiemKhachHang(String thongTinTimKiem, int selectedIndex) {
		ds_hienThi.clear();
		for(int i =0; i<ds_khachHang.size(); i++) {
			switch(selectedIndex){
			case 0:
				if(ds_khachHang.get(i).getTenkh().contains(thongTinTimKiem)) {
					ds_hienThi.add(ds_khachHang.get(i));
				}break;
			case 1:
				if(ds_khachHang.get(i).getSdt().equalsIgnoreCase(thongTinTimKiem)) {
					ds_hienThi.add(ds_khachHang.get(i));
				}break;
			case 2:
				if(ds_khachHang.get(i).getMakh().contains(thongTinTimKiem)) {
					ds_hienThi.add(ds_khachHang.get(i));
				}break;
			}
		}
	}
	
	public int capNhatKhachHang(DTO_KhachHang khachhang) {
		return QuanLyKhachHangDAO.capNhatKhachHang(khachhang);
	}
}
