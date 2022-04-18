/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Help.JdbcHelper;
import Model.SPKho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TIEN'S LAPTOP
 */
public class SPKhoDAO {
    /**
     * Đọc kết quả từ ResultSet
     * @param rs là 1 đối tượng ResultSet được truyền vào
     * @return về 1 đối tượng SPKho
     * @throws SQLException 
     */
    public SPKho readFromResultSet(ResultSet rs) throws SQLException {
        SPKho spKho = new SPKho();
        spKho.setMaSPKho(rs.getString("MaSPKho"));
        spKho.setTenSP(rs.getString("TenSP"));
        spKho.setLoaiSP(rs.getInt("LoaiSP"));
        spKho.setGia(rs.getDouble("GiaSP"));
        spKho.setSoLuong(rs.getInt("SoLuong"));
        spKho.setDonViTinh(rs.getString("DonVT"));
        spKho.setTenNCC(rs.getString("TenNhaCC"));
        spKho.setMaLoHang(rs.getString("MaLoHang"));
        spKho.setNgayNhap(rs.getDate("NgayNhap"));
        spKho.setHinh(rs.getString("Hinh"));
        return spKho;
    }
    
     /**
     * Thêm 1 đối tượng SPKho vào csdl
     * @param spKho là 1 đối tượng SPKho
     * @return 1 nếu thêm thành công còn @return về 0 nếu trùng mã sản phẩm kho
     */
     public int insert(SPKho spKho){
        String sql = "{? = call sp_ThemSPKho(?,?,?,?,?,?,?,?,?,?)}";
        int kq = JdbcHelper.executeUpdate(sql,spKho.getMaSPKho(),
                                              spKho.getTenSP(),
                                              spKho.getLoaiSP(),
                                              spKho.getGia(),
                                              spKho.getSoLuong(),
                                              spKho.getDonViTinh(),
                                              spKho.getTenNCC(),
                                              spKho.getMaLoHang(),
                                              spKho.getNgayNhap(),
                                              spKho.getHinh());
        return kq;
    }
     
     public int truSoLuong(String maSP, int sl){
         String sql = "{? = call sp_TruSL(?,?)}";
         int kq = JdbcHelper.executeUpdate(sql, maSP,sl);
         return kq;
     }
     
     /**
     * Sửa thông tin 1 đối tượng SPKho trong csdl
     * @param spKho là 1 đối tượng SPKho
     * @return 1 nếu cập nhật thành công còn @return về 0 nếu mã sản phẩm kho không tồn tại
     */
     public int update(double gia, String maSP){
        String sql = "{? = call sp_SuaSPKho(?,?)}";
        int kq = JdbcHelper.executeUpdate(sql,gia,maSP
                                            );
        return kq;
    }
     
     /**
     * Xóa 1 đối tượng SPKho trong csdl
     * @param spKho là mã sản phẩm kho cần xóa
     * @return về 1 nếu xóa thành công còn nếu về 0 thì mã sản phẩm nhà kho không tồn tại
     */ 
    public int delete(String spKho){
        String sql = "{? = call sp_XoaSPKho(?)}";
        int kq = JdbcHelper.executeUpdate(sql,spKho);
        return kq;
    }
    
    /**
     * Thực thi truy vấn
     * @param sql là câu truy vấn được truyền vào
     * @param args là tập hợp các điều kiện cho câu truy vấn đó
     * @return trả về 1 list đối tượng SPKho
     */
    public List<SPKho> selectBySQL(String sql, Object...args ) {
        List<SPKho> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql,args);
                while (rs.next()) {
                    SPKho model = readFromResultSet(rs);
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
     * Hàm lấy tất cả đối tượng từ bảng SPKho trong csdl
     * @return 1 list đối tượng SPKho 
     */
     public List<SPKho> selectAll(){
        String sql = "{call sp_TatCaSPKho}";
        List<SPKho> list = selectBySQL(sql);
        return list;
    }
     
       /**
     * Hàm tìm 1 đối tượng SPKho theo nhiều điều kiện
     * @param condition là điều kiện tìm kiếm
     * @return 1 list đối tượng SPKho
     */ 
     public List<SPKho> selectByConditions(String conditions){
        String sql = "{call sp_TimSPKho(?)}";
        List<SPKho> list = selectBySQL(sql,conditions);
        return list;
    }
     
      /**
     * Hàm tìm 1 đối tượng SPKho theo mã sản phẩm kho
     * @param spKho là mã sản phẩm kho cần tìm
     * @return trả về 1 đối tượng SPKho(nếu không rỗng) còn rỗng thì trả về null
     */
     public SPKho selectById(String maNCC) {
        String sql = "{call sp_TimSPKhoID(?)}";
        List<SPKho> list = selectBySQL(sql,maNCC);
        return list.size() > 0 ? list.get(0) : null;
    }
     
     public int kiemTraSPKho(String maSP){
         String sql = "{? = call sp_KiemTraSanPham(?)}";
         int kq = JdbcHelper.executeUpdate(sql,maSP);
         return kq;
     }
     
     public List<Object[]> getDanhGia(String maSP) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_CTDanhGia(?)}";
                rs = JdbcHelper.executeQuery(sql,maSP);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaSP"),
                        rs.getString("MoTa"),
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
