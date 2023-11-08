package DTO;

import java.util.Date;

public class DTO_DonNhap {
	private String madn;
	private String manv;
	private String mancc;
	private double tongtien;
	private Date ngaynhap;
	
	public DTO_DonNhap() {}
	public DTO_DonNhap(String madn, String manv, String mancc, double tongtien, Date ngaynhap) {
		this.madn = madn;
		this.manv = manv;
		this.mancc = mancc;
		this.tongtien = tongtien;
		this.ngaynhap = ngaynhap;
	}
	public String getMadn() {
		return madn;
	}
	public void setMadn(String madn) {
		this.madn = madn;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getMancc() {
		return mancc;
	}
	public void setMancc(String mancc) {
		this.mancc = mancc;
	}
	public double getTongtien() {
		return tongtien;
	}
	public void setTongtien(double tongtien) {
		this.tongtien = tongtien;
	}
	public Date getNgaynhap() {
		return ngaynhap;
	}
	public void setNgaynhap(Date ngaynhap) {
		this.ngaynhap = ngaynhap;
	}
	
	@Override
	public String toString() {
		return "DTO_DonNhap [madn=" + madn + ", manv=" + manv + ", mancc=" + mancc + ", tongtien=" + tongtien
				+ ", ngaynhap=" + ngaynhap + "]";
	}
}
