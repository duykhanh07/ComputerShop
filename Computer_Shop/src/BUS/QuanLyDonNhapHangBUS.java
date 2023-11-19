package BUS;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.DAO_QuanLyDonNhap;
import DTO.DTO_DonNhap;

public class QuanLyDonNhapHangBUS {
	
	DAO_QuanLyDonNhap daoDonNhap;
	
	public QuanLyDonNhapHangBUS() {
		daoDonNhap = new DAO_QuanLyDonNhap();
	}
	
	public void hienThiDonNhapHang(JTable table) {
		ArrayList<DTO_DonNhap> listDonNhap = daoDonNhap.selectAllDonNhap();
		for (DTO_DonNhap dto_DonNhap : listDonNhap) {
			Object[] rowData = {dto_DonNhap.getMadn(),dto_DonNhap.getManv(),dto_DonNhap.getMancc(), dto_DonNhap.getTongtien(), dto_DonNhap.getNgaynhap()};
			DefaultTableModel  model_table = (DefaultTableModel) table.getModel();
			model_table.addRow(rowData);
		}
		
	}
	
	public void selectDonNhap_MaDN(JTable table,String madn){
		ArrayList<DTO_DonNhap> listDonNhap = daoDonNhap.selectDonNhap_MaDN(madn);
		for (DTO_DonNhap dto_DonNhap : listDonNhap) {
			Object[] rowData = {dto_DonNhap.getMadn(),dto_DonNhap.getManv(),dto_DonNhap.getMancc(), dto_DonNhap.getTongtien(), dto_DonNhap.getNgaynhap()};
			DefaultTableModel  model_table = (DefaultTableModel) table.getModel();
			model_table.addRow(rowData);
		}
	}
	public void selectDonNhap_MaNV(JTable table,String manv){
		ArrayList<DTO_DonNhap> listDonNhap = daoDonNhap.selectDonNhap_MaNV(manv);
		for (DTO_DonNhap dto_DonNhap : listDonNhap) {
			Object[] rowData = {dto_DonNhap.getMadn(),dto_DonNhap.getManv(),dto_DonNhap.getMancc(), dto_DonNhap.getTongtien(), dto_DonNhap.getNgaynhap()};
			DefaultTableModel  model_table = (DefaultTableModel) table.getModel();
			model_table.addRow(rowData);
		}
	}
	public void selectDonNhap_MaNCC(JTable table,String mancc){
		ArrayList<DTO_DonNhap> listDonNhap = daoDonNhap.selectDonNhap_MaNCC(mancc);
		for (DTO_DonNhap dto_DonNhap : listDonNhap) {
			Object[] rowData = {dto_DonNhap.getMadn(),dto_DonNhap.getManv(),dto_DonNhap.getMancc(), dto_DonNhap.getTongtien(), dto_DonNhap.getNgaynhap()};
			DefaultTableModel  model_table = (DefaultTableModel) table.getModel();
			model_table.addRow(rowData);
		}
	}
	
	public void selectDonNhap_Ngay(JTable table, String ngayBatDau, String ngayKetThuc){
		ArrayList<DTO_DonNhap> listDonNhap = daoDonNhap.selectDonNhap_Ngay(ngayBatDau, ngayKetThuc);
		for (DTO_DonNhap dto_DonNhap : listDonNhap) {
			Object[] rowData = {dto_DonNhap.getMadn(),dto_DonNhap.getManv(),dto_DonNhap.getMancc(), dto_DonNhap.getTongtien(), dto_DonNhap.getNgaynhap()};
			DefaultTableModel  model_table = (DefaultTableModel) table.getModel();
			model_table.addRow(rowData);
		}
	}
}
