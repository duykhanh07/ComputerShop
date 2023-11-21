package BUS;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.DAO_ThemPhieuBaoHanh;
import DTO.DTO_CTHoaDon;
import DTO.DTO_CTPhieuBaoHanh;
import DTO.DTO_PhieuBaoHanh;

public class ThemPhieuBaoHanhBUS {

	DAO_ThemPhieuBaoHanh dao_ThemPhieuBaoHanh = new DAO_ThemPhieuBaoHanh();
	 public void hienThiChiTiet(JTable jTable) {
		 ArrayList<DTO_CTHoaDon> listChiTietHoaDon = dao_ThemPhieuBaoHanh.selectHoaDonCanBHAll();	 
		 for (DTO_CTHoaDon chiTietHoaDon : listChiTietHoaDon) {
				Object[] rowData = {chiTietHoaDon.getMahd(), chiTietHoaDon.getMasp(), chiTietHoaDon.getNgayHetHan()};
				DefaultTableModel  model_table = (DefaultTableModel) jTable.getModel();
				model_table.addRow(rowData);
			}
	 }
	 public void hienThiChiTiet_MaHD(JTable jTable, String mahd) {
		 ArrayList<DTO_CTHoaDon> listChiTietHoaDon = dao_ThemPhieuBaoHanh.selectCTHD_MaHD(mahd);	 
		 for (DTO_CTHoaDon chiTietHoaDon : listChiTietHoaDon) {
				Object[] rowData = {chiTietHoaDon.getMahd(), chiTietHoaDon.getMasp(), chiTietHoaDon.getNgayHetHan()};
				DefaultTableModel  model_table = (DefaultTableModel) jTable.getModel();
				model_table.addRow(rowData);
			}
	 }
	 public void hienThiChiTiet_MaSP(JTable jTable, String masp) {
		 ArrayList<DTO_CTHoaDon> listChiTietHoaDon = dao_ThemPhieuBaoHanh.selectCTHD_MaSP(masp);	 
		 for (DTO_CTHoaDon chiTietHoaDon : listChiTietHoaDon) {
				Object[] rowData = {chiTietHoaDon.getMahd(), chiTietHoaDon.getMasp(), chiTietHoaDon.getNgayHetHan()};
				DefaultTableModel  model_table = (DefaultTableModel) jTable.getModel();
				model_table.addRow(rowData);
			}
	 }
	 
	 public int insertChiTietBaoHanh(DTO_CTPhieuBaoHanh chiTietBaoHanh) {
		 return dao_ThemPhieuBaoHanh.insertChiTietBaoHanh(chiTietBaoHanh);
	 }
	 
	 public  int insertBaoHanh(DTO_PhieuBaoHanh phieuBaoHanh) {
		 return dao_ThemPhieuBaoHanh.insertBaoHanh(phieuBaoHanh);
	}
	 
	public ArrayList<DTO_PhieuBaoHanh> selectAllPhieuBaoHanh(){
		return dao_ThemPhieuBaoHanh.selectAllBaoHanh();
	}
}
