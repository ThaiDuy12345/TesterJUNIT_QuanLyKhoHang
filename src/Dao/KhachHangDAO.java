/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Help.JdbcHelper;
import Model.KhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TIEN'S LAPTOP
 */
public class KhachHangDAO {

    /**
     * Đọc kết quả từ ResultSet
     *
     * @param rs là 1 đối tượng ResultSet được truyền vào
     * @return về 1 đối tượng KhachHang
     * @throws SQLException
     */
    public KhachHang readFromResultSet(ResultSet rs) throws SQLException {
        KhachHang kh = new KhachHang();
        kh.setMaKH(rs.getString("MaKH"));
        kh.setTenKH(rs.getString("TenKH"));
        kh.setGioiTinh(rs.getInt("GioiTinh"));
        kh.setSDT(rs.getString("SDT"));
        kh.setEmail(rs.getString("Email"));
        kh.setDiaChi(rs.getString("DiaChi"));
        kh.setTenDangNhap(rs.getString("TenDangNhap"));
        return kh;
    }

    /**
     * Thêm 1 đối tượng KhachHang vào csdl
     *
     * @param kh là 1 đối tượng KhachHang
     * @return 1 nếu thêm thành công còn @return về 0 nếu trùng mã khách hàng
     */
    public int insert(KhachHang kh) {
        String sql = "{?= call sp_ThemKhachHang(?,?,?,?,?,?,?)}";
        int kq = JdbcHelper.executeUpdate(sql, kh.getMaKH(),
                kh.getTenKH(),
                kh.getSDT(),
                kh.getDiaChi(),
                kh.getEmail(),
                kh.getGioiTinh(),
                kh.getTenDangNhap()
        );
        return kq;
    }

    /**
     * Sửa thông tin 1 đối tượng KhachHang trong csdl
     *
     * @param kh là 1 đối tượng KhachHang
     * @return 1 nếu cập nhật thành công còn @return về 0 nếu mã khách hàng
     * không tồn tại
     */
    public int update(KhachHang kh) {
        String sql = "{?= call sp_SuaKhachHang(?,?,?,?,?,?,?)}";
        int kq = JdbcHelper.executeUpdate(sql, kh.getTenKH(),
                kh.getSDT(),
                kh.getDiaChi(),
                kh.getEmail(),
                kh.getGioiTinh(),
                kh.getTenDangNhap(),
                kh.getMaKH()
        );
        return kq;
    }

    /**
     * Xóa 1 đối tượng KhachHang trong csdl
     *
     * @param makh là mã khách hàng cần xóa
     * @return về 1 nếu xóa thành công còn nếu về 0 thì mã khách hàng không tồn
     * tại
     */
    public int delete(String makh) {
        String sql = "{?= call sp_XoaKhachHang(?)}";
        int kq = JdbcHelper.executeUpdate(sql, makh);

        return kq;
    }

    /**
     * Thực thi truy vấn
     *
     * @param sql là câu truy vấn được truyền vào
     * @param args là tập hợp các điều kiện cho câu truy vấn đó
     * @return trả về 1 list đối tượng KhachHang
     */
    public List<KhachHang> selectBySQL(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    KhachHang model = readFromResultSet(rs);
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
     * Hàm lấy tất cả đối tượng từ bảng KhachHang trong csdl
     *
     * @return 1 list đối tượng KhachHang
     */
    public List<KhachHang> selectAll() {
        String sql = "{call sp_TatCaKhachHang}";
        List<KhachHang> list = selectBySQL(sql);
        return list;
    }

    /**
     * Hàm tìm 1 đối tượng KhachHang theo nhiều điều kiện
     *
     * @param condition là điều kiện tìm kiếm
     * @return 1 list đối tượng KhachHang
     */
    public List<KhachHang> selectByConditions(String condition) {
        String sql = "{call sp_TimKhachHang(?)}";
        List<KhachHang> list = selectBySQL(sql, condition);
        return list;
    }

    /**
     * Hàm tìm 1 đối tượng KhachHang theo mã khách hàng
     *
     * @param makh là mã khách hàng nhập cần tìm
     * @return trả về 1 đối tượng KhachHang(nếu không rỗng) còn rỗng thì trả về
     * null
     */
    public KhachHang selectById(String makh) {
        String sql = "{call sp_TimKhachHangID(?)}";
        List<KhachHang> list = selectBySQL(sql, makh);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    //Tổng đơn mà khách hàng đã order
    public int tongDon(String maKH){
        String sql = "{call sp_TongDonKH(?)}";
        int kq = (int)JdbcHelper.value(sql, maKH);
        return kq;
    }
}
