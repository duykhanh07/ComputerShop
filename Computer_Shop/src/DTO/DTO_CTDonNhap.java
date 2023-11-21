package DTO;

public class DTO_CTDonNhap {
	private String madn;
	private String masp;
	private String tensp;
	private double dongia;
	private double thanhtien;
	private int solg;
	
	
	public DTO_CTDonNhap() {}

	public DTO_CTDonNhap(String madn,String masp,String tensp, double dongia, int solg, double thanhtien) {
		this.madn = madn;
		this.masp = masp;
		this.tensp = tensp;
		this.dongia = dongia;
		this.solg = solg;
		this.thanhtien = thanhtien;
	}
	
	
	public String getTensp() {
		return tensp;
	}

	public void setTensp(String tensp) {
		this.tensp = tensp;
	}

	public double getThanhtien() {
		return thanhtien;
	}

	public void setThanhtien(double thanhtien) {
		this.thanhtien = thanhtien;
	}

	public String getMadn() {
		return madn;
	}

	public void setMadn(String madn) {
		this.madn = madn;
	}

	public String getMasp() {
		return masp;
	}

	public void setMasp(String masp) {
		this.masp = masp;
	}

	public double getDongia() {
		return dongia;
	}

	public void setDongia(double dongia) {
		this.dongia = dongia;
	}

	public int getSolg() {
		return solg;
	}

	public void setSolg(int solg) {
		this.solg = solg;
	}

	@Override
	public String toString() {
		return "DTO_CTDonNhap [masp=" + masp + ", dongia=" + dongia + ", solg=" + solg + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
