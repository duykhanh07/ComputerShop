package DTO;

import java.util.Date;

public class DTO_HoaDon {
	private String mahd;
	private String makh;
	private String manv;
	private Date ngaylaphd;
	private String diachigiao;
	private double tongtien;
	private String trangthai;
	
	public DTO_HoaDon() {}

	public DTO_HoaDon(String mahd, String makh, String manv, Date ngaylaphd, String diachigiao, double tongtien,
			String trangthai) {
		this.mahd = mahd;
		this.makh = makh;
		this.manv = manv;
		this.ngaylaphd = ngaylaphd;
		this.diachigiao = diachigiao;
		this.tongtien = tongtien;
		this.trangthai = trangthai;
	}

	public String getMahd() {
		return mahd;
	}

	public void setMahd(String mahd) {
		this.mahd = mahd;
	}

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public String getManv() {
		return manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	public Date getNgaylaphd() {
		return ngaylaphd;
	}

	public void setNgaylaphd(Date ngaylaphd) {
		this.ngaylaphd = ngaylaphd;
	}

	public String getDiachigiao() {
		return diachigiao;
	}

	public void setDiachigiao(String diachigiao) {
		this.diachigiao = diachigiao;
	}

	public double getTongtien() {
		return tongtien;
	}

	public void setTongtien(double tongtien) {
		this.tongtien = tongtien;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

	@Override
	public String toString() {
		return "DTO_HoaDon [mahd=" + mahd + ", makh=" + makh + ", manv=" + manv + ", ngaylaphd=" + ngaylaphd
				+ ", diachigiao=" + diachigiao + ", tongtien=" + tongtien + ", trangthai=" + trangthai + "]";
	}
	
}
