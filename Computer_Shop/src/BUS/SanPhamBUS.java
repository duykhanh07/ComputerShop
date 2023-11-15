package BUS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import DAO.SanPhamDAO;
import DTO.DTO_SanPham;

public class SanPhamBUS {
	public ArrayList<DTO_SanPham> listSP;
	public ArrayList<DTO_SanPham> listHT;
	public HashMap<String, Integer> tonKhoMap;
	
	public SanPhamBUS() {
		listSP = SanPhamDAO.getInstance().selectAll();
		listHT = (ArrayList<DTO_SanPham>) listSP.clone();
		tonKhoMap = SanPhamDAO.getInstance().layTonKho();
	}
	
	public ArrayList<DTO_SanPham> importToTable(ArrayList<DTO_SanPham> splist) {
		splist = SanPhamDAO.getInstance().selectAll();
		return splist;
	}
	
	public ArrayList<String> getBrand() {
		return SanPhamDAO.getInstance().getAllBrands();
	}
	public void filterByBrand(ArrayList<String> brands) {
		listHT.clear();
		for(int i = 0;i < listSP.size();i ++) {
			if(brands.contains(listSP.get(i).getHang())) {
				listHT.add(listSP.get(i));
			}
		}
	}

	public void sapXepSanPham(int index) {
		switch (index) {
		case 0:
			Collections.sort(listHT, (o1, o2) -> o1.getMasp().compareToIgnoreCase(o2.getMasp()));break;
		case 1:
			Collections.sort(listHT, (o1, o2) -> o1.getTensp().compareToIgnoreCase(o2.getTensp()));break;
		case 2:
			Collections.sort(listHT, (o1, o2) -> o2.getTensp().compareToIgnoreCase(o1.getTensp()));break;
		case 3:
			Collections.sort(listHT, (o1, o2) -> o1.getGia() - o2.getGia());break;
		case 4:
			Collections.sort(listHT, (o1, o2) -> o2.getGia() - o1.getGia());break;
			
		default:
			Collections.sort(listHT, (o1, o2) -> o1.getMasp().compareToIgnoreCase(o2.getMasp()));break;
		}
		
	}

	public void timKiemSanPham(String str, int index) {
		listHT.clear();
		switch (index) {
			case 0: 
				for(int i =0; i< listSP.size(); i++)
					if(listSP.get(i).getTensp().toLowerCase().contains(str) || listSP.get(i).getMasp().toLowerCase().contains(str)) {
						listHT.add(listSP.get(i));	
					}
				break;
			case 1:
				for(int i =0; i< listSP.size(); i++)
					if (listSP.get(i).getMasp().toLowerCase().contains(str)) {
						listHT.add(listSP.get(i));
					}
				break;
			
			case 2:
				for(int i =0; i< listSP.size(); i++)
					if (listSP.get(i).getTensp().toLowerCase().contains(str)) {
						listHT.add(listSP.get(i));
				}
				break;
			
		}
		
	}
}
