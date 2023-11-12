package BUS;

import java.util.ArrayList;

import DAO.SanPhamDAO;
import DTO.DTO_SanPham;

public class SanPhamBUS {
	public static SanPhamBUS getInstance() {
		return new SanPhamBUS();
	}
	
	public ArrayList<DTO_SanPham> importToTable(ArrayList<DTO_SanPham> splist) {
		splist = SanPhamDAO.getInstance().selectAll();
		return splist;
	}
}
