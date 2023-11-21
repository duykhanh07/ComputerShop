package BUS;

import DAO.LoginDAO;
import GUI.MainForm;
import GUI.QuanLyKho.ThemDonNhapFrm;

public class LoginBUS {
	
	public int Login(String username, String password) {
		String[] data = LoginDAO.Login(username, password);		
		if(data[0] != null) {
			if(data[1] == null) {
				return -1;
			}
			new MainForm(data).setVisible(true);
			return 1;
		}else {
			return 0;
		}
	}

}
