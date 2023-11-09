package DTO;

public class DTO_CTHoaDon {
	private String mahd;
	private String masp;
	private double dongia;
	private int solg;
	
	public DTO_CTHoaDon() {}
	public DTO_CTHoaDon(String mahd, String masp, double dongia, int solg) {
		this.mahd = mahd;
		this.masp = masp;
		this.dongia = dongia;
		this.solg = solg;
	}
	
	
	public String getMahd() {
		return mahd;
	}
	public void setMahd(String mahd) {
		this.mahd = mahd;
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
		return "DTO_CTHoaDon [masp=" + masp + ", dongia=" + dongia + ", solg=" + solg + ", toString()="
				+ super.toString() + "]";
	}
	
}
