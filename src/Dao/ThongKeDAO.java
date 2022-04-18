/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Help.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author TIEN'S LAPTOP
 */
public class ThongKeDAO {

    public List<Object[]> getXuatHang() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_TKXuatKho}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getInt("soluong"),
                        rs.getDouble("tongtien"),
                        rs.getDate("NgayGanDay")
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<Object[]> getNhapHang() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_TKNhapKho}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getInt("soluong"),
                        rs.getDouble("tongtien"),
                        rs.getDate("NgayGanDay")
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<Object[]> getTonKho() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_TKTonKho}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getInt("SoLuong"),
                        rs.getString("DonVT"),
                        rs.getDouble("GiaNhap"),
                        rs.getDouble("GiaBan")
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<Object[]> getDuKienKho() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_DuKienKho}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getString("LoaiChungTu"),
                        rs.getDouble("Gia"),
                        rs.getString("DonVT"),
                        rs.getInt("soLuong1"),
                        rs.getInt("soLuong2"),
                        rs.getInt("soLuong3")
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<Object[]> getDoanhThu(int thang, int nam) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_DoanhThuThang(?,?)}";
                rs = JdbcHelper.executeQuery(sql, thang, nam);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getInt("soluong"),
                        rs.getDouble("GiaSP"),
                        rs.getDouble("tongtien"),
                        rs.getDate("ngay")
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<Object[]> getTinhHinh(int thang, int nam) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_TinhHinhNV(?,?)}";
                rs = JdbcHelper.executeQuery(sql, thang, nam);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("TenDangNhap"),
                        rs.getString("HoTen"),
                        rs.getString("Email"),
                        rs.getString("SDT"),
                        rs.getDate("NgayTao"),
                        rs.getInt("tongdon"),
                        rs.getDouble("tongtien")
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
}
