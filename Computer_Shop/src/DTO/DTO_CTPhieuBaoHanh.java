package DTO;

public class DTO_CTPhieuBaoHanh {
	private String mapbh;
	private String masp;
	private String mahd;
	private String loi;
	private String giaiquyet;
	
	public DTO_CTPhieuBaoHanh() {}

	public DTO_CTPhieuBaoHanh(String mapbh, String masp, String mahd, String loi, String giaiquyet) {
		this.mapbh = mapbh;
		this.masp = masp;
		this.mahd = mahd;
		this.loi = loi;
		this.giaiquyet = giaiquyet;
	}
	
	
	public String getMapbh() {
		return mapbh;
	}

	public void setMapbh(String mapbh) {
		this.mapbh = mapbh;
	}

	public String getMasp() {
		return masp;
	}

	public void setMasp(String masp) {
		this.masp = masp;
	}

	public String getMahd() {
		return mahd;
	}

	public void setMahd(String mahd) {
		this.mahd = mahd;
	}

	public String getLoi() {
		return loi;
	}

	public void setLoi(String loi) {
		this.loi = loi;
	}

	public String getGiaiquyet() {
		return giaiquyet;
	}

	public void setGiaiquyet(String giaiquyet) {
		this.giaiquyet = giaiquyet;
	}

	@Override
	public String toString() {
		return "DTO_CTPhieuBaoHanh [masp=" + masp + ", mahd=" + mahd + ", loi=" + loi + ", giaiquyet=" + giaiquyet
				+ ", toString()=" + super.toString() + "]";
	}
	
}
