package BUS;

import java.util.ArrayList;
import java.util.Collections;

import DAO.DAO_NhanVien;
import DAO.DAO_TaiKhoan;
import DTO.DTO_KhachHang;
import DTO.DTO_NhanVien;
import DTO.DTO_TaiKhoan;
import GUI.MainForm;

public class TaiKhoanBUS {
	public ArrayList<DTO_TaiKhoan> ds_taiKhoan;
	public ArrayList<DTO_TaiKhoan> ds_hienThi;
	private ArrayList <DTO_TaiKhoan> TaiKhoan__mainList = DAO_TaiKhoan.selectAllTaiKhoan();
	public ArrayList<DTO_TaiKhoan> ds_taiKhoan_temp;
	public TaiKhoanBUS() {
		ds_taiKhoan = new DAO_TaiKhoan().selectAllTaiKhoan();
		if(ds_taiKhoan.size() >0 ) {
			ds_hienThi = (ArrayList<DTO_TaiKhoan>) ds_taiKhoan.clone();
		}
	}
	
	public ArrayList<DTO_TaiKhoan> importToTable(ArrayList<DTO_TaiKhoan> splist) {
		splist = DAO_TaiKhoan.getInstance().selectAllTaiKhoan();
		return splist;
	}
	
	public ArrayList<DTO_TaiKhoan> getTaiKhoan_mainList() {
        return TaiKhoan__mainList;
    }

    public void setTaiKhoan_mainList() {
        this.TaiKhoan__mainList = DAO_TaiKhoan.selectAllTaiKhoan();
    }
    
    public void themTK() {
		for(int i =0; i< ds_taiKhoan_temp.size(); i++) {
			ds_taiKhoan_temp.get(i).setManv(taoMa(ds_taiKhoan_temp.get(i), i));
			new DAO_TaiKhoan().themTK(ds_taiKhoan_temp.get(i));
		}
	}

	public int suaTK(DTO_TaiKhoan tk) {
		return DAO_TaiKhoan.suaTK(tk);
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
		ds_hienThi.clear();
		for (int i = 0; i < ds_taiKhoan.size(); i++) {
			switch (selectedIndex) {
			case 0:
				if (ds_taiKhoan.get(i).getMatk().contains(thongTinTimKiem)) {
					ds_hienThi.add(ds_taiKhoan.get(i));
				}
				break;
			case 1:
				if (ds_taiKhoan.get(i).getManv().contains(thongTinTimKiem)) {
					ds_hienThi.add(ds_taiKhoan.get(i));
				}
				break;
			case 2:
				if (ds_taiKhoan.get(i).getUsername().contains(thongTinTimKiem)) {
					ds_hienThi.add(ds_taiKhoan.get(i));
				}
				break;
			}
		}
	}
	
	public String taoMa(DTO_TaiKhoan taiKhoan, int i) {
		int maso = ds_taiKhoan.size() + i + 1;
		String manv = "";
		String matk = "TK";
		if(taiKhoan.getManv().equalsIgnoreCase("admin")) {
			manv = "AD";
		}else if(taiKhoan.getManv().equalsIgnoreCase("quản lí")) {
			manv = "QL";
		}else {
			manv = "NV";
		}
		if(maso < 1000) {
			manv+="0";
			if(maso <100) {
				manv += "0";
				if(maso < 10) {
					manv += "0";
				}
			}
		}
		manv += maso;
		matk+=maso;
		
		return manv;
		
	}
}
