package DTO;

public class DTO_NhanVien {
	private String manv;
	private String tennv;
	private String sdt;
	private String email;
	private String diachi;
	private String chucvu;
	
	public DTO_NhanVien() {}
	public DTO_NhanVien(String manv, String tennv, String sdt, String email, String diachi, String chucvu) {
		super();
		this.manv = manv;
		this.tennv = tennv;
		this.sdt = sdt;
		this.email = email;
		this.diachi = diachi;
		this.chucvu = chucvu;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getTennv() {
		return tennv;
	}
	public void setTennv(String tennv) {
		this.tennv = tennv;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getChucvu() {
		return chucvu;
	}
	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}
	@Override
	public String toString() {
		return "DTO_NhanVien [manv=" + manv + ", tennv=" + tennv + ", sdt=" + sdt + ", email=" + email + ", diachi="
				+ diachi + ", chucvu=" + chucvu + "]";
	}
	
}
