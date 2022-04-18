/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Help.JdbcHelper;
import Model.LoHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TIEN'S LAPTOP
 */
public class LoHangDAO {
    /**
     * Đọc kết quả từ ResultSet
     * @param rs là 1 đối tượng ResultSet được truyền vào
     * @return về 1 đối tượng LoHang
     * @throws SQLException 
     */
    public LoHang readFromResultSet(ResultSet rs) throws SQLException {
        LoHang lh = new LoHang();
        lh.setMaLoHang(rs.getString("MaLoHang"));
        lh.setTenLoHang(rs.getString("TenLoHang"));
        lh.setViTri(rs.getString("ViTri"));
        lh.setMoTa(rs.getString("MoTa"));
        return lh;
    }
    
    /**
     * Thêm 1 đối tượng LoHang vào csdl
     * @param lh là 1 đối tượng LoHang
     * @return 1 nếu thêm thành công còn @return về 0 nếu trùng ID
     */
     public int insert(LoHang lh){
        String sql = "{? = call sp_ThemLoHang(?,?,?,?)}";
        int kq = JdbcHelper.executeUpdate(sql,lh.getMaLoHang(),
                                              lh.getTenLoHang(),
                                              lh.getViTri(),
                                              lh.getMoTa()
                                            );
        return kq;
    }
     
       /**
     * Sửa thông tin 1 đối tượng LoHang trong csdl
     * @param lh là 1 đối tượng LoHang
     * @return 1 nếu cập nhật thành công còn @return về 0 nếu mã lô hàng không tồn tại
     */
     public int update(LoHang lh){
        String sql = "{? = call sp_SuaLoHang(?,?,?,?)}";
        int kq = JdbcHelper.executeUpdate(sql,lh.getTenLoHang(),
                                              lh.getViTri(),
                                              lh.getMoTa(),
                                              lh.getMaLoHang()
                                            );
        return kq;
    }
     
     /**
     * Xóa 1 đối tượng LoHang trong csdl
     * @param lsp là mã lô hàng cần xóa
     * @return về 1 nếu xóa thành công còn nếu về 0 thì mã lô hàng không tồn tại
     */ 
    public int delete(String lh){
        String sql = "{? = call sp_XoaLoHang(?)}";
        int kq = JdbcHelper.executeUpdate(sql,lh);
        return kq;
    }
    
    /**
     * Thực thi truy vấn
     * @param sql là câu truy vấn được truyền vào
     * @param args là tập hợp các điều kiện cho câu truy vấn đó
     * @return trả về 1 list đối tượng LoHang
     */
    public List<LoHang> selectBySQL(String sql, Object...args ) {
        List<LoHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql,args);
                while (rs.next()) {
                    LoHang model = readFromResultSet(rs);
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
     * Hàm lấy tất cả đối tượng từ bảng LoHang trong csdl
     * @return 1 list đối tượng LoHang 
     */
     public List<LoHang> selectAll(){
        String sql = "{call sp_TatCaLoHang}";
        List<LoHang> list = selectBySQL(sql);
        return list;
    }
     
     
       /**
     * Hàm tìm 1 đối tượng LoHang theo mã lô hàng
     * @param lh là mã lô hàng cần tìm
     * @return trả về 1 đối tượng LoHang(nếu không rỗng) còn rỗng thì trả về null
     */
     public LoHang selectById(String lh) {
        String sql = "{call sp_TimLoHang(?)}";
        List<LoHang> list = selectBySQL(sql,lh);
        return list.size() > 0 ? list.get(0) : null;
    }
     
     public List<LoHang> selectByKeyword(String lh) {
        String sql = "{call sp_TimLoHangKey(?)}";
        List<LoHang> list = selectBySQL(sql,lh);
        return list;
    }
}
