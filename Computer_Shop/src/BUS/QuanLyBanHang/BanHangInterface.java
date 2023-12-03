package BUS.QuanLyBanHang;

import DTO.DTO_SanPham;

public interface BanHangInterface {
	public void moCuaSoGioHang(DTO_SanPham sp);
	public void themGioHang(DTO_SanPham sp, int soluong);
	public void capNhatGioHang(DTO_SanPham sp, int soluong);
	public void boKhoiGioHang(String sp);
}
