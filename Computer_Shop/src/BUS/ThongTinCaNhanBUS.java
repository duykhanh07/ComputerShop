package BUS;

import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.ThongTinCaNhanDAO;
import DTO.DTO_NhanVien;
import DTO.DTO_TaiKhoan;

public class ThongTinCaNhanBUS {
	
	public DTO_NhanVien nv;
	
	public DTO_TaiKhoan tk;
	
	public ThongTinCaNhanDAO tk_dao;
	
	public ThongTinCaNhanBUS() {
		tk_dao = new ThongTinCaNhanDAO();
	}
	
	public void layThongTinNhanVien(String manv) {
		ResultSet rss = tk_dao.ExecuteQuery("SELECT * \r\n"
				+ "from nhanvien as nv join taikhoan AS tk  ON nv.manv = tk.manv\r\n"
				+ "where nv.manv= '"+manv+"'");
		try {
			while(rss.next()) {
				nv = new DTO_NhanVien(rss.getString("manv"), rss.getString("tennv"), rss.getString("sdt"), rss.getString("email"), rss.getString("diachi"), rss.getString("chucvu"));
				tk = new DTO_TaiKhoan(rss.getString("matk"), rss.getString("manv"), rss.getString("username"), rss.getString("password"), rss.getInt("tinhtrang"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void suaMatKhau(String matkhau_moi) {
		String query = "Update taikhoan "
				+ "set "
				+ "password = '"+matkhau_moi+"' "
				+ "where matk = '"+tk.getMatk()+"'";
		tk_dao.ExecuteUpdate(query);
		layThongTinNhanVien(nv.getManv());
	}
}
