package DTO;

public class DTO_KhachHang {
	private String makh;
	private String tenkh;
	private String sdt;
	private int diem = 0 ;
	
	public DTO_KhachHang() {}
	public DTO_KhachHang(String makh, String tenkh, String sdt, int diem) {
		super();
		this.makh = makh;
		this.tenkh = tenkh;
		this.sdt = sdt;
		this.diem = diem;
	}



	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public String getTenkh() {
		return tenkh;
	}

	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public int getDiem() {
		return diem;
	}

	public void setDiem(int diem) {
		this.diem = diem;
	}

	@Override
	public String toString() {
		return "DTO_KhachHang [makh=" + makh + ", tenkh=" + tenkh + ", sdt=" + sdt + ", diem=" + diem + "]";
	}
	
	
}
