/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Help.JdbcHelper;
import Model.LoaiSP;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TIEN'S LAPTOP
 */
public class LoaiSPDAO {
    /**
     * Đọc kết quả từ ResultSet
     * @param rs là 1 đối tượng ResultSet được truyền vào
     * @return về 1 đối tượng LoaiSP
     * @throws SQLException 
     */
    public LoaiSP readFromResultSet(ResultSet rs) throws SQLException {
        LoaiSP lsp = new LoaiSP();
        lsp.setID(rs.getInt("ID"));
        lsp.setLoaiSP(rs.getString("LoaiSP"));
        return lsp;
    }
    
    /**
     * Thêm 1 đối tượng LoaiSP vào csdl
     * @param lsp là 1 đối tượng LoaiSP
     * @return 1 nếu thêm thành công còn @return về 0 nếu trùng ID
     */
     public int insert(LoaiSP lsp){
        String sql = "{? = call sp_ThemLoaiSp(?,?)}";
        int kq = JdbcHelper.executeUpdate(sql,lsp.getID(),
                                              lsp.getLoaiSP()
                                            );
        return kq;
    }
     
       /**
     * Sửa thông tin 1 đối tượng LoaiSP trong csdl
     * @param lsp là 1 đối tượng LoaiSP
     * @return 1 nếu cập nhật thành công còn @return về 0 nếu ID không tồn tại
     */
     public int update(LoaiSP lsp){
        String sql = "{? = call sp_SuaLoaiSp(?,?)}";
        int kq = JdbcHelper.executeUpdate(sql,lsp.getLoaiSP(),
                                              lsp.getID()
                                            );
        return kq;
    }
     
     /**
     * Xóa 1 đối tượng LoaiSP trong csdl
     * @param lsp là ID loại sản phẩm cần xóa
     * @return về 1 nếu xóa thành công còn nếu về 0 thì ID loại sản phẩm không tồn tại
     */ 
    public int delete(int lsp){
        String sql = "{? = call sp_XoaLoaiSp(?)}";
        int kq = JdbcHelper.executeUpdate(sql,lsp);
        return kq;
    }
    
    /**
     * Thực thi truy vấn
     * @param sql là câu truy vấn được truyền vào
     * @param args là tập hợp các điều kiện cho câu truy vấn đó
     * @return trả về 1 list đối tượng LoaiSP
     */
    public List<LoaiSP> selectBySQL(String sql, Object...args ) {
        List<LoaiSP> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql,args);
                while (rs.next()) {
                    LoaiSP model = readFromResultSet(rs);
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
     * Hàm lấy tất cả đối tượng từ bảng LoaiSP trong csdl
     * @return 1 list đối tượng LoaiSP 
     */
     public List<LoaiSP> selectAll(){
        String sql = "{call sp_TatCaLoaiSp}";
        List<LoaiSP> list = selectBySQL(sql);
        return list;
    }
     
     /**
     * Hàm tìm 1 đối tượng LoaiSP theo ID loại sản phẩm
     * @param lsp là ID loai sản phẩm cần tìm
     * @return trả về 1 đối tượng LoaiSP(nếu không rỗng) còn rỗng thì trả về null
     */
     public LoaiSP selectById(int lsp) {
        String sql = "{call sp_TimLoaiSp(?)}";
        List<LoaiSP> list = selectBySQL(sql,lsp);
        return list.size() > 0 ? list.get(0) : null;
    }
     
     public int countLoaiSP(){
         String sql = "{? = call sp_DemLoaiSp}";
         int count = JdbcHelper.executeUpdate(sql);
         return count;
     }
}
