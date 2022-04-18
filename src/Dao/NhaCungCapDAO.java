/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Help.JdbcHelper;
import Model.NhaCungCap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TIEN'S LAPTOP
 */
public class NhaCungCapDAO {
    /**
     * Đọc kết quả từ ResultSet
     * @param rs là 1 đối tượng ResultSet được truyền vào
     * @return về 1 đối tượng NhaCungCap
     * @throws SQLException 
     */
    public NhaCungCap readFromResultSet(ResultSet rs) throws SQLException {
        NhaCungCap ncc = new NhaCungCap();
        ncc.setMaNCC(rs.getString("MaNhaCC"));
        ncc.setTenNCC(rs.getString("TenNhaCC"));
        ncc.setSDT(rs.getString("SDT"));
        ncc.setEmail(rs.getString("Email"));
        ncc.setDiaChi(rs.getString("DiaChi"));
        return ncc;
    }
    
    /**
     * Thêm 1 đối tượng NhaCungCap vào csdl
     * @param ncc là 1 đối tượng NhaCungCap
     * @return 1 nếu thêm thành công còn @return về 0 nếu trùng mã nhà cung cấp
     */
     public int insert(NhaCungCap ncc){
        String sql = "{? = call sp_ThemNhaCungCap(?,?,?,?,?)}";
        int kq = JdbcHelper.executeUpdate(sql,ncc.getMaNCC(),
                                              ncc.getTenNCC(),
                                              ncc.getSDT(),
                                              ncc.getEmail(),
                                              ncc.getDiaChi()
                                            );
        return kq;
    }
     
     /**
     * Sửa thông tin 1 đối tượng NhaCungCap trong csdl
     * @param ncc là 1 đối tượng NhaCungCap
     * @return 1 nếu cập nhật thành công còn @return về 0 nếu mã nhà cung cấp không tồn tại
     */
     public int update(NhaCungCap ncc){
        String sql = "{? = call sp_SuaNhaCungCap(?,?,?,?,?)}";
        int kq = JdbcHelper.executeUpdate(sql,ncc.getTenNCC(),
                                              ncc.getSDT(),
                                              ncc.getEmail(),
                                              ncc.getDiaChi(),
                                              ncc.getMaNCC()
                                            );
        return kq;
    }
     
     /**
     * Xóa 1 đối tượng NhaCungCap trong csdl
     * @param maNCC là mã nhà cung cấp cần xóa
     * @return về 1 nếu xóa thành công còn nếu về 0 thì mã nhà cung cấp không tồn tại
     */
    public int delete(String maNCC){
        String sql = "{? = call sp_XoaNhaCungCap(?)}";
        int kq = JdbcHelper.executeUpdate(sql,maNCC);
        return kq;
    }
    
    /**
     * Thực thi truy vấn
     * @param sql là câu truy vấn được truyền vào
     * @param args là tập hợp các điều kiện cho câu truy vấn đó
     * @return trả về 1 list đối tượng NhaCungCap
     */
    public List<NhaCungCap> selectBySQL(String sql, Object...args ) {
        List<NhaCungCap> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql,args);
                while (rs.next()) {
                    NhaCungCap model = readFromResultSet(rs);
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
     * Hàm lấy tất cả đối tượng từ bảng NhaCungCap trong csdl
     * @return 1 list đối tượng NhaCungCap 
     */
     public List<NhaCungCap> selectAll(){
        String sql = "{call sp_TatCaNhaCungCap}";
        List<NhaCungCap> list = selectBySQL(sql);
        return list;
    }
     
     /**
     * Hàm tìm 1 đối tượng NhaCungCap theo nhiều điều kiện
     * @param condition là điều kiện tìm kiếm
     * @return 1 list đối tượng NhaCungCap
     */ 
     public List<NhaCungCap> selectByConditions(String condition){
        String sql = "{call sp_TimNhaCungCap(?)}";
        List<NhaCungCap> list = selectBySQL(sql,condition);
        return list;
    }
     
     /**
     * Hàm tìm 1 đối tượng NhaCungCap theo mã nhà cung cấp
     * @param maNCC là mã nhà cung cấp cần tìm
     * @return trả về 1 đối tượng NhaCungCap(nếu không rỗng) còn rỗng thì trả về null
     */
     public NhaCungCap selectById(String maNCC) {
        String sql = "{call sp_TimNhaCungCapID(?)}";
        List<NhaCungCap> list = selectBySQL(sql,maNCC);
        return list.size() > 0 ? list.get(0) : null;
    }
     
     public int countNhaCungCap(){
         String sql = "{? = call sp_DemNhaCungCap}";
         int count = JdbcHelper.executeUpdate(sql);
         return count;
     }
}
