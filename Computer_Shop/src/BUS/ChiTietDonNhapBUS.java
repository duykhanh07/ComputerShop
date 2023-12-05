package BUS;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.DAO_ChiTietDonNhap;
import DTO.DTO_CTDonNhap;




public class ChiTietDonNhapBUS {
	
	DAO_ChiTietDonNhap daoChiTietDonNhap;
	DecimalFormat df = new DecimalFormat("#,###");
	
	public ChiTietDonNhapBUS() {
		daoChiTietDonNhap = new DAO_ChiTietDonNhap();
	}
	
	public void hienThiDonNhapHang(JTable table, String madn) {
		
		ArrayList<DTO_CTDonNhap> listChitietDonNhap = daoChiTietDonNhap.selectChiTietDonNhap(madn);
		//System.out.println(madn);
		for (DTO_CTDonNhap dto_CTDonNhap : listChitietDonNhap) {
			//System.out.println(dto_CTDonNhap);//test
			Object[] rowData = {dto_CTDonNhap.getMasp(),dto_CTDonNhap.getTensp(),df.format((long)dto_CTDonNhap.getDongia()), dto_CTDonNhap.getSolg(), df.format((long)dto_CTDonNhap.getThanhtien())};
			DefaultTableModel  model_table = (DefaultTableModel) table.getModel();
			model_table.addRow(rowData);
		}
	}
	
}
