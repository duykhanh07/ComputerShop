package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_PhieuBaoHanh {
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

    public static List<Object[]> layDanhSachPhieuBaoHanh() {
        List<Object[]> danhSachPhieuBaoHanh = new ArrayList<>();
        try (Connection conn = DAO_PhieuBaoHanh.getConnection();
                PreparedStatement ps = conn.prepareStatement(
                        "SELECT * FROM baohanh")) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] row = new Object[4];
                row[0] = rs.getString("mapbh");
                row[1] = rs.getDate("ngaynhan");
                row[2] = rs.getDate("ngaytra");
                row[3] = rs.getString("manv");

                danhSachPhieuBaoHanh.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachPhieuBaoHanh;
    }

    public static List<Object[]> layThongTinPhieuBaoHanh(String mapbh) {
        List<Object[]> danhSachThongTin = new ArrayList<>();

        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(
                        "SELECT baohanh.mapbh, baohanh.manv, ctbh.mahd, ctbh.masp, sanpham.tensp, ctbh.loi, ctbh.giaiquyet, baohanh.ngaynhan, baohanh.ngaytra "
                                +
                                "FROM baohanh " +
                                "INNER JOIN ctbh ON baohanh.mapbh = ctbh.mapbh " +
                                "INNER JOIN sanpham ON ctbh.masp = sanpham.masp " +
                                "WHERE baohanh.mapbh = ?")) {

            ps.setString(1, mapbh);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] row = new Object[9];
                row[0] = rs.getString("mapbh");
                row[1] = rs.getString("manv");
                row[2] = rs.getString("mahd");
                row[3] = rs.getString("masp");
                row[4] = rs.getString("tensp");
                row[5] = rs.getString("loi");
                row[6] = rs.getString("giaiquyet");
                row[7] = rs.getDate("ngaynhan");
                row[8] = rs.getDate("ngaytra");

                danhSachThongTin.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachThongTin;
    }

}
