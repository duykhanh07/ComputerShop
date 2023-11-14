package BUS;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import DAO.ThongKeDoanhThuDAO;

public class ThongKeDoanhThuBUS {
	
	public ResultSet result;
	public String[] years;
	public String[] quaters;
	public String[] months;
	public ThongKeDoanhThuBUS() {
		result =  ThongKeDoanhThuDAO.layDoanhThuTheoCacNam();
		years = ThongKeDoanhThuDAO.layCacNam();
	}
	public void layCacQuy(String nam) {
		quaters = ThongKeDoanhThuDAO.layCacQuy(nam);
	}
	
	public void thongKeTheoNam(String nam, int opt) {
		result =  ThongKeDoanhThuDAO.layDoanhThuTheoNam(nam, opt);
		layCacQuy(nam);
		layCacThang(nam);
	}
	
	public void layCacThang(String nam) {
		months =  ThongKeDoanhThuDAO.layCacThang(nam);
	}
	
	public void thongKeTheoThang(String nam, String thang) {
		result = ThongKeDoanhThuDAO.layDoanhThuTheoThang(nam, thang);
	}
	
	public void thongKeTheoQuy(String nam, String quy) {
		result = ThongKeDoanhThuDAO.layDoanhThuTheoQuy(nam, quy);
	}
	
	
	
}
