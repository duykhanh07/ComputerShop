package BUS;

import DAO.LoginDAO;
import GUI.MainForm;

public class LoginBUS {
	
	public int Login(String username, String password) {
		String[] data = LoginDAO.Login(username, password);		
		if(data[0] != null) {
			new MainForm(data).setVisible(true);
			return 1;
		}else {
			return 0;
		}
	}
}
