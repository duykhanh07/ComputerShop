package DTO;

public class DTO_TaiKhoan {
	private String matk;
	private String manv;
	private String username;
	private String password;
	private int tinhtrang;
	
	public DTO_TaiKhoan() {}
	public DTO_TaiKhoan(String matk, String manv, String username, String password, int tinhtrang) {
		this.matk = matk;
		this.manv = manv;
		this.username = username;
		this.password = password;
		this.tinhtrang = tinhtrang;
	}
	public String getMatk() {
		return matk;
	}
	public void setMatk(String matk) {
		this.matk = matk;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getTinhtrang() {
		return tinhtrang;
	}
	public void setTinhtrang(int tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	
	@Override
	public String toString() {
		return "DTO_TaiKhoan [matk=" + matk + ", manv=" + manv + ", username=" + username + ", password=" + password
				+ ", tinhtrang=" + tinhtrang + "]";
	}
	
	public String insertString() {
		String insertString = String.format("('%s','%s','%s','%s','%d')", matk, manv, username, password, tinhtrang);
		return insertString;
	}
	
	public int compareByName(DTO_TaiKhoan other) {
		String[] name_1st_split = this.matk.split(" ");
		String[] name_2nd_split = other.getMatk().split(" ");
		if (!name_1st_split[name_1st_split.length - 1].equalsIgnoreCase(name_2nd_split[name_2nd_split.length - 1])) {
			return name_1st_split[name_1st_split.length - 1]
					.compareToIgnoreCase(name_2nd_split[name_2nd_split.length - 1]);
		} else {
			return this.matk.compareToIgnoreCase(other.getMatk());
		}
	}
	
}
