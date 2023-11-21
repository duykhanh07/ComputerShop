package BUS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import DAO.DAO_NhanVien;
import DTO.DTO_NhanVien;
import GUI.MainForm;

public class NhanVienBUS {
	public ArrayList<DTO_NhanVien> ds_hienThi;
	public ArrayList<DTO_NhanVien> ds_nhanVien;
	private ArrayList <DTO_NhanVien> NhanVien_mainList = DAO_NhanVien.selectAllNhanVien();

	public NhanVienBUS() {
		ds_nhanVien = new DAO_NhanVien().selectAllNhanVien();
		if (ds_nhanVien.size() > 0) {
			ds_hienThi = (ArrayList<DTO_NhanVien>) ds_nhanVien.clone();
		}
	}
	
	public ArrayList<DTO_NhanVien> getNhanVien_mainList() {
        return NhanVien_mainList;
    }

    public void setNhanVien_mainList() {
        this.NhanVien_mainList = DAO_NhanVien.selectAllNhanVien();
    }

	public int themNV(DTO_NhanVien nv) {
		return DAO_NhanVien.themNV(nv);
	}

	public int suaNV(String manv, String tennv) {
		return DAO_NhanVien.suaNV(manv, tennv);
	}

	public void sapXepNhanVien(int selectedIndex) {
		switch (selectedIndex) {
		case 1:
			Collections.sort(ds_hienThi, (o1, o2) -> o1.compareByName(o2));
			break;
		case 2:
			Collections.sort(ds_hienThi, (o1, o2) -> o2.compareByName(o1));
			break;
		default:
			Collections.sort(ds_hienThi, (o1, o2) -> o1.getManv().compareToIgnoreCase(o2.getManv()));
			break;
		}
	}

	public void timKiemNhanVien(String thongTinTimKiem, int selectedIndex) {
		ds_hienThi.clear();
		for (int i = 0; i < ds_nhanVien.size(); i++) {
			switch (selectedIndex) {
			case 0:
				if (ds_nhanVien.get(i).getManv().contains(thongTinTimKiem)) {
					ds_hienThi.add(ds_nhanVien.get(i));
				}
				break;
			case 1:
				if (ds_nhanVien.get(i).getTennv().contains(thongTinTimKiem)) {
					ds_hienThi.add(ds_nhanVien.get(i));
				}
				break;
			case 2:
				if (ds_nhanVien.get(i).getSdt().equalsIgnoreCase(thongTinTimKiem)) {
					ds_hienThi.add(ds_nhanVien.get(i));
				}
				break;
			case 3:
				if (ds_nhanVien.get(i).getEmail().contains(thongTinTimKiem)) {
					ds_hienThi.add(ds_nhanVien.get(i));
				}
				break;
			}
		}
	}
}
