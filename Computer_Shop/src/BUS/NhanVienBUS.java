package BUS;

import DAO.DAO_NhanVien;
import GUI.MainForm;

public class NhanVienBUS {
	public int NhanVien() {
		String[] data = DAO_NhanVien.selectAllNhanVien();
		if (data[0] != null) {
			if (data[1] == null) {
				return -1;
			}
			new MainForm(data).setVisible(true);
			return 1;
		} else {
			return 0;
		}
	}
}
