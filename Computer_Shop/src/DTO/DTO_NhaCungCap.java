package DTO;

public class DTO_NhaCungCap {
	private String mancc;
	private String tenncc;
	private String sdt;
	private String diachi;
	
	public DTO_NhaCungCap() {}

	public DTO_NhaCungCap(String mancc, String tenncc, String sdt, String diachi) {
		super();
		this.mancc = mancc;
		this.tenncc = tenncc;
		this.sdt = sdt;
		this.diachi = diachi;
	}

	public String getMancc() {
		return mancc;
	}

	public void setMancc(String mancc) {
		this.mancc = mancc;
	}

	public String getTenncc() {
		return tenncc;
	}

	public void setTenncc(String tenncc) {
		this.tenncc = tenncc;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	@Override
	public String toString() {
		return "DTO_NhaCungCap [mancc=" + mancc + ", tenncc=" + tenncc + ", sdt=" + sdt + ", diachi=" + diachi + "]";
	}
	
	
}
