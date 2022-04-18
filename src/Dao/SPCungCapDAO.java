/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Help.JdbcHelper;
import Model.SPCungCap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TIEN'S LAPTOP
 */
public class SPCungCapDAO {
    /**
     * Đọc kết quả từ ResultSet
     * @param rs là 1 đối tượng ResultSet được truyền vào
     * @return về 1 đối tượng SPCungCap
     * @throws SQLException 
     */
    public SPCungCap readFromResultSet(ResultSet rs) throws SQLException {
        SPCungCap spNCC = new SPCungCap();
        spNCC.setMaSPCC(rs.getString("MaSPCC"));
        spNCC.setMaNCC(rs.getString("MaNhaCC"));
        spNCC.setTenSP(rs.getString("TenSP"));
        spNCC.setGia(rs.getDouble("GiaSP"));
        spNCC.setDonViTinh(rs.getString("DonVT"));
        spNCC.setHinh(rs.getString("Hinh"));
        spNCC.setLoaiSP(rs.getInt("ID"));
        return spNCC;
    }
    
    /**
     * Thêm 1 đối tượng SPCungCap vào csdl
     * @param spNCC là 1 đối tượng SPCungCap
     * @return 1 nếu thêm thành công còn @return về 0 nếu trùng mã sản phẩm nhà cung cấp
     */
     public int insert(SPCungCap spNCC){
        String sql = "{? = call sp_ThemSPNCC(?,?,?,?,?,?,?)}";
        int kq = JdbcHelper.executeUpdate(sql,spNCC.getMaSPCC(),
                                              spNCC.getMaNCC(),
                                              spNCC.getTenSP(),
                                              spNCC.getGia(),
                                              spNCC.getDonViTinh(),
                                              spNCC.getHinh(),
                                              spNCC.getLoaiSP()
                                            );
        return kq;
    }
     
     /**
     * Sửa thông tin 1 đối tượng SPCungCap trong csdl
     * @param spNCC là 1 đối tượng SPCungCap
     * @return 1 nếu cập nhật thành công còn @return về 0 nếu mã sản phẩm nhà cung cấp không tồn tại
     */
     public int update(SPCungCap spNCC){
        String sql = "{? = call sp_SuaSPNCC(?,?,?,?,?,?,?)}";
        int kq = JdbcHelper.executeUpdate(sql,spNCC.getMaNCC(),
                                              spNCC.getTenSP(),
                                              spNCC.getGia(),
                                              spNCC.getDonViTinh(),
                                              spNCC.getHinh(),
                                              spNCC.getLoaiSP(),
                                              spNCC.getMaSPCC()
                                            );
        return kq;
    }
     
     /**
     * Xóa 1 đối tượng SPCungCap trong csdl
     * @param spNCC là mã sản phẩm nhà cung cấp cần xóa
     * @return về 1 nếu xóa thành công còn nếu về 0 thì mã sản phẩm nhà cung cấp không tồn tại
     */ 
    public int delete(String spNCC){
        String sql = "{? = call sp_XoaSPNCC(?)}";
        int kq = JdbcHelper.executeUpdate(sql,spNCC);
        return kq;
    }
    
    /**
     * Thực thi truy vấn
     * @param sql là câu truy vấn được truyền vào
     * @param args là tập hợp các điều kiện cho câu truy vấn đó
     * @return trả về 1 list đối tượng SPCungCap
     */
    public List<SPCungCap> selectBySQL(String sql, Object...args ) {
        List<SPCungCap> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql,args);
                while (rs.next()) {
                    SPCungCap model = readFromResultSet(rs);
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
     * Hàm lấy tất cả đối tượng từ bảng SPCungCap trong csdl
     * @return 1 list đối tượng SPCungCap 
     */
     public List<SPCungCap> selectAll(){
        String sql = "{call sp_TatCaSPNCC}";
        List<SPCungCap> list = selectBySQL(sql);
        return list;
    }
     
     /**
     * Hàm tìm 1 đối tượng SPCungCap theo nhiều điều kiện
     * @param condition là điều kiện tìm kiếm
     * @return 1 list đối tượng SPCungCap
     */ 
     public List<SPCungCap> selectByConditions(String condition){
        String sql = "{call sp_TimSPNCC(?)}";
        List<SPCungCap> list = selectBySQL(sql,condition);
        return list;
    }
     
     /**
     * Hàm tìm 1 đối tượng SPCungCap theo mã sản phẩm nhà cung cấp
     * @param maNCC là mã sản phẩm nhà cung cấp cần tìm
     * @return trả về 1 đối tượng SPCungCap(nếu không rỗng) còn rỗng thì trả về null
     */
     public SPCungCap selectById(String maNCC) {
        String sql = "{call sp_TimSPNCCID(?)}";
        List<SPCungCap> list = selectBySQL(sql,maNCC);
        return list.size() > 0 ? list.get(0) : null;
    }
     
    public List<SPCungCap> selectByX2(String maNCC,int lsp){
        String sql = "{call sp_TimSPCCx2(?,?)}";
        List<SPCungCap> list = selectBySQL(sql,maNCC,lsp);
        return list;
    }
    
    public List<SPCungCap> selectByNCC(String condition){
        String sql = "{call sp_TimSPCCNCC(?)}";
        List<SPCungCap> list = selectBySQL(sql,condition);
        return list;
    }
    
    public List<SPCungCap> sp_TimSPCCLSP(int condition){
        String sql = "{call sp_TimSPCCLSP(?)}";
        List<SPCungCap> list = selectBySQL(sql,condition);
        return list;
    }
}
