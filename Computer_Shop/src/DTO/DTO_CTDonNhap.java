package DTO;

public class DTO_CTDonNhap {
	private String madn;
	private String masp;
	private double dongia;
	private int solg;
	
	public DTO_CTDonNhap() {}

	public DTO_CTDonNhap(String madn,String masp, double dongia, int solg) {
		this.madn = madn;
		this.masp = masp;
		this.dongia = dongia;
		this.solg = solg;
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
