/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Help.JdbcHelper;
import Model.ChungTu;
import Model.ChungTuCT;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TIEN'S LAPTOP
 */
public class ChungTuCTDAO {
    public ChungTuCT readFromResultSet(ResultSet rs) throws SQLException {
        ChungTuCT ct = new ChungTuCT();
        ct.setMaChungTu(rs.getString("MaChungTu"));
        ct.setMaSP(rs.getString("MaSP"));
        ct.setTenSP(rs.getString("TenSP"));
        ct.setLoaiSP(rs.getInt("LoaiSP"));
        ct.setGia(rs.getDouble("GiaSP"));
        ct.setSoLuong(rs.getInt("SoLuong"));
        ct.setDonViTinh(rs.getString("DonViTinh"));
        ct.setTenNCC(rs.getString("TenNhaCC"));
        ct.setMaLoHang(rs.getString("MaLoHang"));
        ct.setNgayNhap(rs.getDate("NgayNhap"));
        ct.setHinh(rs.getString("Hinh"));
        ct.setMoTa(rs.getString("MoTa"));
        return ct;
    }
    
    public int insert(ChungTuCT ct) {
        String sql = "{? = call sp_ThemChungTuCT(?,?,?,?,?,?,?,?,?,?,?,?)}";
        int kq = JdbcHelper.executeUpdate(sql,ct.getMaChungTu(),
                                                 ct.getMaSP(),
                                                 ct.getTenSP(),
                                                 ct.getLoaiSP(),
                                                 ct.getGia(),
                                                 ct.getSoLuong(),
                                                 ct.getDonViTinh(),
                                                 ct.getTenNCC(),
                                                 ct.getMaLoHang(),
                                                 ct.getNgayNhap(),
                                                 ct.getHinh(),
                                                 ct.getMoTa());
        return kq;
    }
    
    /**
     * Thực thi truy vấn
     * @param sql là câu truy vấn được truyền vào
     * @param args là tập hợp các điều kiện cho câu truy vấn đó
     * @return trả về 1 list đối tượng TaiKhoan
     */
    public List<ChungTuCT> selectBySQL(String sql, Object...args ) {
        List<ChungTuCT> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql,args);
                while (rs.next()) {
                    ChungTuCT model = readFromResultSet(rs);
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
    
    /**
     * Hàm lấy tất cả đối tượng từ bảng TaiKhoan trong csdl
     * @return 1 list đối tượng TaiKhoan 
     */
    public List<ChungTuCT> selectAll(){
        String sql = "{call sp_TatCaChungTuCT}";
        List<ChungTuCT> list = selectBySQL(sql);
        return list;
    }
    
    /**
     * Hàm tìm 1 đối tượng TaiKhoan theo nhiều điều kiện
     * @param condition là điều kiện tìm kiếm
     * @return 1 list đối tượng TaiKhoan
     */
    public List<ChungTuCT> selectByConditions(String condition){
        String sql = "{call sp_TimChungTuCT(?)}";
        List<ChungTuCT> list = selectBySQL(sql,condition);
        return list;
    }
    
    public int soLuongAoTungSPDH(String maSP){
        String sql = "{call sp_DemSLSPDH(?)}";
        int kq = (int)JdbcHelper.value(sql, maSP);
        return kq;
    }
    
    public int soLuongAoTungSPXH(String maSP){
        String sql = "{call sp_DemSLSPXH(?)}";
        int kq = (int)JdbcHelper.value(sql, maSP);
        return kq;
    }
}
