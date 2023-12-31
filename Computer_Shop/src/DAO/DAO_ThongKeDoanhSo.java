package DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DTO.DTO_CTHoaDon;
import java.sql.*;
import java.text.DecimalFormat;

public class DAO_ThongKeDoanhSo {
    public static Connection getConnection() {
        Connection conn;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlycuahang", "root", "");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Phương thức để lấy danh sách các năm từ bảng sản phẩm
    public static List<String> getDistinctYearsFromSanPham() {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<String> yearsList = new ArrayList<>();

        try {
            String query = "SELECT DISTINCT YEAR(ngaylaphd) AS year FROM hoadon";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                String year = rs.getString("year");
                yearsList.add(year);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và tài nguyên
            try {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return yearsList;
    }

    public static List<Object[]> getSanPhamDaBanTheoNam(int selectedYear) {
        List<Object[]> danhSachSanPhamDaBan = new ArrayList<>();
        String query = "SELECT cthd.masp, sp.tensp, SUM(cthd.solg) AS solg " +
                "FROM cthd " +
                "INNER JOIN sanpham sp ON cthd.masp = sp.masp " +
                "INNER JOIN hoadon hd ON cthd.mahd = hd.mahd " +
                "WHERE YEAR(hd.ngaylaphd) = ? " +
                "GROUP BY cthd.masp, sp.tensp";

        try (Connection conn = DAO_ThongKeDoanhSo.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, selectedYear);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] row = new Object[3];
                row[0] = rs.getString("masp");
                row[1] = rs.getString("tensp");
                row[2] = rs.getInt("solg");
                danhSachSanPhamDaBan.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachSanPhamDaBan;
    }

    public static List<Object[]> getSanPhamDaBanTheoQuy(int selectedYear, int selectedQuarter) {
        List<Object[]> danhSachSanPhamDaBan = new ArrayList<>();
        String query = "SELECT cthd.masp, sp.tensp, SUM(cthd.solg) AS solg " +
                "FROM cthd " +
                "INNER JOIN sanpham sp ON cthd.masp = sp.masp " +
                "INNER JOIN hoadon hd ON cthd.mahd = hd.mahd " +
                "WHERE YEAR(hd.ngaylaphd) = ? " +
                "AND QUARTER(hd.ngaylaphd) = ? " +
                "GROUP BY cthd.masp, sp.tensp";

        try (Connection conn = DAO_ThongKeDoanhSo.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, selectedYear);
            ps.setInt(2, selectedQuarter);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] row = new Object[3];
                row[0] = rs.getString("masp");
                row[1] = rs.getString("tensp");
                row[2] = rs.getInt("solg");
                danhSachSanPhamDaBan.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachSanPhamDaBan;
    }

    public static List<Object[]> getSanPhamDaBanTheoThang(int selectedYear, int selectedQuarter, int selectedMonth) {
        List<Object[]> danhSachSanPhamDaBan = new ArrayList<>();
        String query = "SELECT cthd.masp, sp.tensp, SUM(cthd.solg) AS solg " +
                "FROM cthd " +
                "INNER JOIN sanpham sp ON cthd.masp = sp.masp " +
                "INNER JOIN hoadon hd ON cthd.mahd = hd.mahd " +
                "WHERE YEAR(hd.ngaylaphd) = ? " +
                "AND QUARTER(hd.ngaylaphd) = ? " +
                "AND MONTH(hd.ngaylaphd) = ? " +
                "GROUP BY cthd.masp, sp.tensp";

        try (Connection conn = DAO_ThongKeDoanhSo.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, selectedYear);
            ps.setInt(2, selectedQuarter);
            ps.setInt(3, selectedMonth);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] row = new Object[3];
                row[0] = rs.getString("masp");
                row[1] = rs.getString("tensp");
                row[2] = rs.getInt("solg");
                danhSachSanPhamDaBan.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachSanPhamDaBan;
    }

    public static List<Object[]> getSanPhamDaBan(int selectedYear, int selectedMonth) {
        List<Object[]> danhSachSanPhamDaBan = new ArrayList<>();
        String query = "SELECT cthd.masp, sp.tensp, SUM(cthd.solg) AS solg " +
                "FROM cthd " +
                "INNER JOIN sanpham sp ON cthd.masp = sp.masp " +
                "INNER JOIN hoadon hd ON cthd.mahd = hd.mahd " +
                "WHERE YEAR(hd.ngaylaphd) = ? " +
                "AND MONTH(hd.ngaylaphd) = ? " +
                "GROUP BY cthd.masp, sp.tensp";

        try (Connection conn = DAO_ThongKeDoanhSo.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, selectedYear);
            ps.setInt(2, selectedMonth);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] row = new Object[3];
                row[0] = rs.getString("masp");
                row[1] = rs.getString("tensp");
                row[2] = rs.getInt("solg");
                danhSachSanPhamDaBan.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachSanPhamDaBan;
    }

    public static List<DTO_CTHoaDon> getCTHDData() {
        List<DTO_CTHoaDon> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            String query = "SELECT * FROM cthd";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                // Lấy thông tin từ ResultSet và tạo DTO_CTHoaDon, sau đó thêm vào danh sách
                DTO_CTHoaDon cthd = new DTO_CTHoaDon();
                cthd.setMahd(rs.getString("mahd"));
                cthd.setMasp(rs.getString("masp"));
                cthd.setDongia(rs.getDouble("dongia"));
                cthd.setSolg(rs.getInt("solg"));
                // Nếu cần lấy thêm thông tin khác, bạn có thể thêm vào đây

                list.add(cthd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng ResultSet trước
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // Đóng PreparedStatement sau
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // Đóng kết nối cuối cùng
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }

    public static List<Object[]> getSalesData() {
        List<Object[]> salesData = new ArrayList<>();
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        decimalFormat.setMaximumFractionDigits(0);

        try (Connection conn = DAO_ThongKeDoanhSo.getConnection();
                PreparedStatement ps = conn.prepareStatement(
                        "SELECT nv.manv, nv.tennv, COUNT(hd.mahd) AS soDonBanDuoc, SUM(cthd.dongia * cthd.solg) AS doanhThu "
                                + "FROM nhanvien nv " +
                                "LEFT JOIN hoadon hd ON nv.manv = hd.manv " +
                                "LEFT JOIN cthd ON hd.mahd = cthd.mahd " +
                                "GROUP BY nv.manv, nv.tennv")) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] row = new Object[4];
                row[0] = rs.getString("manv");
                row[1] = rs.getString("tennv");
                row[2] = rs.getLong("soDonBanDuoc"); // Sử dụng getLong() cho COUNT
                double doanhThu = rs.getDouble("doanhThu");
                row[3] = decimalFormat.format(doanhThu);
                salesData.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return salesData;
    }

    
    public static Map<Integer, Double> calculateProfitByMonth(int year) {
        Map<Integer, Double> profits = new HashMap<>();
        Connection conn = getConnection();
        if (conn != null) {
            try {
                // Tạo các câu truy vấn để tính toán lợi nhuận cho từng tháng trong năm
                String query = "SELECT MONTH(ngaylaphd) AS month, SUM(tongtien) AS total_sales " +
                        "FROM hoadon " +
                        "WHERE YEAR(ngaylaphd) = ? " +
                        "GROUP BY MONTH(ngaylaphd)";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setInt(1, year);
                ResultSet rs = pstmt.executeQuery();

                // Tính lợi nhuận từ hóa đơn
                while (rs.next()) {
                    int month = rs.getInt("month");
                    double totalSales = Double.parseDouble(rs.getString("total_sales"));

                    if (!profits.containsKey(month)) {
                        profits.put(month, totalSales);
                    } else {
                        double currentProfit = profits.get(month);
                        profits.put(month, currentProfit + totalSales);
                    }
                }

                // Lấy tổng tiền từ đơn nhập và trừ đi lợi nhuận
                String queryDonNhap = "SELECT MONTH(ngaynhap) AS month, SUM(tongtien) AS total_expenses " +
                        "FROM donnhap " +
                        "WHERE YEAR(ngaynhap) = ? " +
                        "GROUP BY MONTH(ngaynhap)";
                PreparedStatement pstmtDonNhap = conn.prepareStatement(queryDonNhap);
                pstmtDonNhap.setInt(1, year);
                ResultSet rsDonNhap = pstmtDonNhap.executeQuery();

                while (rsDonNhap.next()) {
                    int month = rsDonNhap.getInt("month");
                    double totalExpenses = rsDonNhap.getDouble("total_expenses");

                    if (profits.containsKey(month)) {
                        double currentProfit = profits.get(month);
                        profits.put(month, currentProfit - totalExpenses);
                    } else {
                        profits.put(month, -totalExpenses);
                    }
                }

                // Đóng kết nối
                rs.close();
                pstmt.close();
                rsDonNhap.close();
                pstmtDonNhap.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return profits;
    }

}
