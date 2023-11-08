package DTO;

import java.util.Date;

public class DTO_PhieuBaoHanh {
	private String mapbh;
	private Date ngaynhan;
	private Date ngaytra;
	private String manv;
	
	public DTO_PhieuBaoHanh() {}
	public DTO_PhieuBaoHanh(String mapbh, Date ngaynhan, Date ngaytra, String manv) {
		super();
		this.mapbh = mapbh;
		this.ngaynhan = ngaynhan;
		this.ngaytra = ngaytra;
		this.manv = manv;
	}
	public String getMapbh() {
		return mapbh;
	}
	public void setMapbh(String mapbh) {
		this.mapbh = mapbh;
	}
	public Date getNgaynhan() {
		return ngaynhan;
	}
	public void setNgaynhan(Date ngaynhan) {
		this.ngaynhan = ngaynhan;
	}
	public Date getNgaytra() {
		return ngaytra;
	}
	public void setNgaytra(Date ngaytra) {
		this.ngaytra = ngaytra;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	
	@Override
	public String toString() {
		return "DTO_BaoHanh [mapbh=" + mapbh + ", ngaynhan=" + ngaynhan + ", ngaytra=" + ngaytra + ", manv=" + manv
				+ "]";
	}
	
}
