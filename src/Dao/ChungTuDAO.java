/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Help.JdbcHelper;
import Model.ChungTu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TIEN'S LAPTOP
 */
public class ChungTuDAO {
    /**
     * Đọc kết quả từ ResultSet
     * @param rs là 1 đối tượng ResultSet được truyền vào
     * @return về 1 đối tượng ChungTu
     * @throws SQLException 
     */

    public ChungTu readFromResultSet(ResultSet rs) throws SQLException {
        ChungTu ct = new ChungTu();
        ct.setMaChungTu(rs.getString("MaChungTu"));
        ct.setTenDangNhap(rs.getString("TenDangNhap"));
        ct.setLoaiChungTu(rs.getString("LoaiChungTu"));
        ct.setNgayTao(rs.getDate("NgayTao"));
        ct.setTrangThai(rs.getString("TrangThai"));
        ct.setMaKH(rs.getString("MaKH"));
        ct.setNguoiDuyet(rs.getString("NguoiDuyet"));
        ct.setTongTien(rs.getDouble("TongTien"));
        return ct;
    }

    
    
   public String insert(ChungTu ct) {
        String sql = "{call sp_ThemChungTu(?,?,?,?,?,?,?)}";
        String kq = (String)JdbcHelper.value(sql,ct.getTenDangNhap(),
                                              ct.getLoaiChungTu(),
                                              ct.getNgayTao(),
                                              ct.getTrangThai(),
                                              ct.getMaKH(),
                                              ct.getNguoiDuyet(),
                                              ct.getTongTien());
        return kq;
    }
   
   public int update(String trangThai,String nguoiDuyet ,String maChungTu){
       String sql = "{? = call sp_SuaChungTu(?,?,?)}";
       int kq = JdbcHelper.executeUpdate(sql, trangThai,nguoiDuyet,maChungTu);
       return kq;
   }
    
    /**
     * Xóa 1 đối tượng TaiKhoan trong csdl
     * @param TenDn là tên đăng nhập cần xóa
     * @return về 1 nếu xóa thành công còn nếu về 0 thì tên đăng nhập không tồn tại
     */
    public int delete(String maChungTu){
        int kq;
        String sql = "{? = call sp_XoaChungTu(?)}";
        kq = JdbcHelper.executeUpdate(sql,maChungTu);
        return kq;
    }
    
    /**
     * Thực thi truy vấn
     * @param sql là câu truy vấn được truyền vào
     * @param args là tập hợp các điều kiện cho câu truy vấn đó
     * @return trả về 1 list đối tượng TaiKhoan
     */
    public List<ChungTu> selectBySQL(String sql, Object...args ) {
        List<ChungTu> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql,args);
                while (rs.next()) {
                    ChungTu model = readFromResultSet(rs);
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
     * Hàm tìm 1 đối tượng TaiKhoan theo tên đăng nhập
     * @param tenDangNhap là tên đăng nhập cần tìm
     * @return trả về 1 đối tượng TaiKhoan(nếu không rỗng) còn rỗng thì trả về null
     */
    public ChungTu selectById(String maChungTu) {
        String sql = "{call sp_TimTaiKhoanID(?)}";
        List<ChungTu> list = selectBySQL(sql,maChungTu);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    /**
     * Hàm lấy tất cả đối tượng từ bảng TaiKhoan trong csdl
     * @return 1 list đối tượng TaiKhoan 
     */
    public List<ChungTu> selectAll(){
        String sql = "{call sp_TatCaChungTu}";
        List<ChungTu> list = selectBySQL(sql);
        return list;
    }
    
    public List<ChungTu> selectDuyet(){
        String sql = "{call sp_ChungTuDuyet}";
        List<ChungTu> list = selectBySQL(sql);
        return list;
    }
    public List<ChungTu> selectDuyetNhap(){
        String sql = "{call sp_ChungTuDuyetNhap}";
        List<ChungTu> list = selectBySQL(sql);
        return list;
    }
    public List<ChungTu> selectDuyetXuat(){
        String sql = "{call sp_ChungTuDuyetXuat}";
        List<ChungTu> list = selectBySQL(sql);
        return list;
    }
    
    public List<ChungTu> selectDuyetDonHang(){
        String sql = "{call sp_DonHangDuyet}";
        List<ChungTu> list = selectBySQL(sql);
        return list;
    }
    
    
    public List<ChungTu> selectDaDuyetDonHang(){
        String sql = "{call sp_DonHangDaDuyet}";
        List<ChungTu> list = selectBySQL(sql);
        return list;
    }
    /**
     * Hàm tìm 1 đối tượng TaiKhoan theo nhiều điều kiện
     * @param condition là điều kiện tìm kiếm
     * @return 1 list đối tượng TaiKhoan
     */
    public List<ChungTu> selectByConditions(String condition){
        String sql = "{call sp_TimChungTu(?)}";
        List<ChungTu> list = selectBySQL(sql,condition);
        return list;
    }
    
    public List<ChungTu> selectDonHang(){
        String sql = "{call sp_TatCaDonHang}";
        List<ChungTu> list = selectBySQL(sql);
        return list;
    }
    
    public int countChuaDuyet(){
         String sql = "{? = call sp_DemChuaDuyet}";
         int count = JdbcHelper.executeUpdate(sql);
         return count;
     }
    
    public int countChuaDuyetNhap(){
         String sql = "{? = call sp_DemChuaDuyetNhap}";
         int count = JdbcHelper.executeUpdate(sql);
         return count;
     }
    
    public int countChuaDuyetXuat(){
         String sql = "{? = call sp_DemChuaDuyetXuat}";
         int count = JdbcHelper.executeUpdate(sql);
         return count;
     }
    
    public int countChuaDuyetDonHang(){
         String sql = "{? = call sp_DemChuaDuyetDH}";
         int count = JdbcHelper.executeUpdate(sql);
         return count;
     }
}
