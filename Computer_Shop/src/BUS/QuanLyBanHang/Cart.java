package BUS.QuanLyBanHang;
public class Cart {
    // Các thuộc tính
    public String masp = CartItemBUS.getMa();
    public String tensp;
    public double dongia;
    public int soluong;
    public double thanhtien;

    // Constructor
    public Cart(String masp, String tensp, double dongia, int soluong) {
        this.masp = masp;
        this.tensp = tensp;
        this.dongia = dongia;
        this.soluong = soluong;
        this.thanhtien = dongia * soluong;
    }

    // Phương thức set và get cho masp
    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    // Phương thức set và get cho tensp
    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    // Phương thức set và get cho dongia
    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
        // Cập nhật lại thành tiền khi đơn giá thay đổi
        this.thanhtien = dongia * soluong;
    }

    // Phương thức set và get cho soluong
    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
        // Cập nhật lại thành tiền khi số lượng thay đổi
        this.thanhtien = dongia * soluong;
    }

    // Phương thức get cho thanhtien
    public double getThanhtien() {
        return thanhtien;
    }

    // Không cần phương thức set cho thanhtien vì nó được tự động cập nhật khi dongia và soluong thay đổi
}

