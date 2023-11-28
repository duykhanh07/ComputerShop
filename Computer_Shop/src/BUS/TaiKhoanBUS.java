package BUS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import DAO.DAO_NhanVien;
import DAO.DAO_TaiKhoan;
import DTO.DTO_KhachHang;
import DTO.DTO_NhanVien;
import DTO.DTO_TaiKhoan;
import GUI.MainForm;

public class TaiKhoanBUS {
	public ArrayList<DTO_TaiKhoan> ds_hienThi;
	public ArrayList<DTO_TaiKhoan> ds_taiKhoan;
	private ArrayList <DTO_TaiKhoan> TaiKhoan__mainList = DAO_TaiKhoan.selectAllTaiKhoan();
	public ArrayList<DTO_TaiKhoan> ds_taiKhoan_temp;
	
	public HashMap<Integer, String> taikhoan_status_map = new HashMap<Integer, String>();
	
	
	public TaiKhoanBUS() {
		ds_taiKhoan = new DAO_TaiKhoan().selectAllTaiKhoan();
		if(ds_taiKhoan.size() >0 ) {
			ds_hienThi = (ArrayList<DTO_TaiKhoan>) ds_taiKhoan.clone();
		}
		ds_taiKhoan_temp = new ArrayList<DTO_TaiKhoan>();
		
		taikhoan_status_map.put(1, "đang hoạt động");
		taikhoan_status_map.put(0, "đã khóa");
	}
	
	
	public ArrayList<DTO_TaiKhoan> getTaiKhoan_mainList() {
        return TaiKhoan__mainList;
    }

    public void setTaiKhoan_mainList() {
        this.TaiKhoan__mainList = DAO_TaiKhoan.selectAllTaiKhoan();
    }
    
    public void themTK() {
		for(int i =0; i< ds_taiKhoan_temp.size(); i++) {
			ds_taiKhoan_temp.get(i).setMatk(taoMa(i));
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
	
	public String taoMa(int i) {
		int maso = ds_taiKhoan.size() + i + 1;
		String matk = "TK";
		
		if(maso < 1000) {
			matk+="0";
			if(maso <100) {
				matk += "0";
				if(maso < 10) {
					matk += "0";
				}
			}
		}
		matk += maso;		
		return matk;	
	}
	
	public String[] layDanhSachMaNhanVienChuaCoTaiKhoan() {
		String[] ds_ma = new DAO_TaiKhoan().layMaNhanVienKoTK();
		return ds_ma;
		
	}
}
