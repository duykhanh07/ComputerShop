package BUS;

import java.awt.Label;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.DAO_ThemDonNhap;
import DTO.DTO_CTDonNhap;
import DTO.DTO_DonNhap;

public class ThemDonNhapBUS {
	
	DAO_ThemDonNhap daoThemDonNhap;
	
	public ThemDonNhapBUS() {
		daoThemDonNhap = new DAO_ThemDonNhap();
	}
	
	public void hienThiComboBoxMaSanPham(JComboBox<String> jComboBox) {
		
		ArrayList<String> listMaSanPham = daoThemDonNhap.selectMaSanPham();
		for (String maSanPham : listMaSanPham) {
			jComboBox.addItem(maSanPham);
		}
	}
	
	public void layTenSanPham(JComboBox<String> jComboBox, JLabel jLabel) {
		ArrayList<String> listTenSanPham = daoThemDonNhap.selectTenSanPham( jComboBox.getSelectedItem().toString());
		if(listTenSanPham.size() > 1) {
			jLabel.setText(null);
		}
		else {
			jLabel.setText(listTenSanPham.get(0));
		}
	}
	
	public void hienThiComboBoxMaNhaCungCap(JComboBox<String> jComboBox) {
		
		ArrayList<String> listMaNhaCungCap = daoThemDonNhap.selectMaNhaCungCap();
		for (String maNhaCungCap : listMaNhaCungCap) {
			jComboBox.addItem(maNhaCungCap);
		}
	}
	
	public int insertDonNhap(DTO_DonNhap donNhap) {
		return daoThemDonNhap.insertDonNhap(donNhap);
	}
	
	public int insertChiTietDonNhap(DTO_CTDonNhap chiTietDonNhap) {
		return daoThemDonNhap.insertChiTietDonNhap(chiTietDonNhap);
	}
	
	public static void main(String[] args) {
		//DTO_DonNhap donNhap = new DTO_DonNhap("DN00020", "QL0003", "CC0001", 2000000, Date.valueOf("2023-11-25"));
		DTO_CTDonNhap chiTietDonNhap = new DTO_CTDonNhap("DN00002", "AC0003", null, 19000000, 20, 0);
		ThemDonNhapBUS bus = new ThemDonNhapBUS();
		//bus.insertDonNhap(donNhap);
		bus.insertChiTietDonNhap(chiTietDonNhap);
	}
}
