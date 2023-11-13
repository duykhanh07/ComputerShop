package BUS;

import DAO.DAO_TaiKhoan;
import GUI.MainForm;

public class TaiKhoanBUS {
	public int TaiKhoan() {
		String data[] = DAO_TaiKhoan.selectTaikhoanNV();
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
