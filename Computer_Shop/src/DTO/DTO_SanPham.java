package DTO;

public class DTO_SanPham {
	private String masp;
	private String tensp;
	private String image;
	private String cpu;
	private String ram;
	private String rom;
	private String card;
	private String manhinh;
	private String pin;
	private String hang;
	private int gia;
	private int tinhtrang;

	public DTO_SanPham(String masp, String tensp, String image, String cpu, String ram, String rom, String card,
			String manhinh, String pin, String hang, int gia, int tinhtrang) {
		this.masp = masp;
		this.tensp = tensp;
		this.image = image;
		this.cpu = cpu;
		this.ram = ram;
		this.rom = rom;
		this.card = card;
		this.manhinh = manhinh;
		this.pin = pin;
		this.hang = hang;
		this.gia = gia;
		this.tinhtrang = tinhtrang;
	}

	public String getMasp() {
		return masp;
	}

	public void setMasp(String masp) {
		this.masp = masp;
	}

	public String getTensp() {
		return tensp;
	}

	public void setTensp(String tensp) {
		this.tensp = tensp;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getRom() {
		return rom;
	}

	public void setRom(String rom) {
		this.rom = rom;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getManhinh() {
		return manhinh;
	}

	public void setManhinh(String manhinh) {
		this.manhinh = manhinh;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getHang() {
		return hang;
	}

	public void setHang(String hang) {
		this.hang = hang;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public int getTinhtrang() {
		return tinhtrang;
	}

	public void setTinhtrang(int tinhtrang) {
		this.tinhtrang = tinhtrang;
	}

	@Override
	public String toString() {
		return "DTO_SanPham [masp=" + masp + ", tensp=" + tensp + ", image=" + image + ", cpu=" + cpu + ", ram=" + ram
				+ ", rom=" + rom + ", card=" + card + ", manhinh=" + manhinh + ", pin=" + pin + ", hang=" + hang
				+ ", gia=" + gia + ", tinhtrang=" + tinhtrang + "]";
	}
}
