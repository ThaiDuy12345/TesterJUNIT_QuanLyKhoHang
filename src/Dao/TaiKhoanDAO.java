/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Help.JdbcHelper;
import Model.TaiKhoan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class TaiKhoanDAO {

    /**
     * Đọc kết quả từ ResultSet
     *
     * @param rs là 1 đối tượng ResultSet được truyền vào
     * @return về 1 đối tượng TaiKhoan
     * @throws SQLException
     */
    public TaiKhoan readFromResultSet(ResultSet rs) throws SQLException {
        TaiKhoan tk = new TaiKhoan();
        tk.setTenDn(rs.getString("TenDangNhap"));
        tk.setMatKhau(rs.getString("MatKhau"));
        tk.setHoTen(rs.getString("HoTen"));
        tk.setVaiTro(rs.getInt("VaiTro"));
        tk.setEmail(rs.getString("Email"));
        tk.setSoDt(rs.getString("SDT"));
        tk.setGioiTinh(rs.getInt("GioiTinh"));
        tk.setLuong(rs.getFloat("Luong"));
        tk.setHinh(rs.getString("Hinh"));
        return tk;
    }

    /**
     * Thêm 1 đối tượng TaiKhoan vào csdl
     *
     * @param tk là 1 đối tượng TaiKhoan
     * @return 1 nếu thêm thành công còn @return về 0 nếu trùng tên đăng nhập
     */
    public int insert(TaiKhoan tk) {
        int kq;
        String sql = "{? = call sp_ThemTaiKhoan(?,?,?,?,?,?,?,?,?)}";
        kq = JdbcHelper.executeUpdate(sql, tk.getTenDn(),
                tk.getMatKhau(),
                tk.getHoTen(),
                tk.getVaiTro(),
                tk.getEmail(),
                tk.getSoDt(),
                tk.getGioiTinh(),
                tk.getLuong(),
                tk.getHinh());
        return kq;
    }

    /**
     * Sửa thông tin 1 đối tượng TaiKhoan trong csdl
     *
     * @param tk là 1 đối tượng TaiKhoan
     * @return 1 nếu cập nhật thành công còn @return về 0 nếu tên đăng nhập
     * không tồn tại
     */
    public int update(TaiKhoan tk) {
        int kq;
        String sql = "{? = call sp_SuaTaiKhoan(?,?,?,?,?,?,?,?,?)}";
        kq = JdbcHelper.executeUpdate(sql, tk.getMatKhau(),
                tk.getHoTen(),
                tk.getVaiTro(),
                tk.getEmail(),
                tk.getSoDt(),
                tk.getGioiTinh(),
                tk.getLuong(),
                tk.getHinh(),
                tk.getTenDn());
        return kq;
    }

    public int updatePass(String a, String b) {
        int kq;
        String sql = "{? = call sp_SuaTaiKhoanPass(?,?)}";
        kq = JdbcHelper.executeUpdate(sql, a, b);
        return kq;
    }

    /**
     * Xóa 1 đối tượng TaiKhoan trong csdl
     *
     * @param TenDn là tên đăng nhập cần xóa
     * @return về 1 nếu xóa thành công còn nếu về 0 thì tên đăng nhập không tồn
     * tại
     */
    public int delete(String TenDn) {
        int kq;
        String sql = "{? = call sp_XoaTaiKhoan(?)}";
        kq = JdbcHelper.executeUpdate(sql, TenDn);
        return kq;
    }

    /**
     * Thực thi truy vấn
     *
     * @param sql là câu truy vấn được truyền vào
     * @param args là tập hợp các điều kiện cho câu truy vấn đó
     * @return trả về 1 list đối tượng TaiKhoan
     */
    public List<TaiKhoan> selectBySQL(String sql, Object... args) {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    TaiKhoan model = readFromResultSet(rs);
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
     *
     * @param tenDangNhap là tên đăng nhập cần tìm
     * @return trả về 1 đối tượng TaiKhoan(nếu không rỗng) còn rỗng thì trả về
     * null
     */
    public TaiKhoan selectById(String tenDangNhap) {
        String sql = "{call sp_TimTaiKhoanID(?)}";
        List<TaiKhoan> list = selectBySQL(sql, tenDangNhap);
        return list.size() > 0 ? list.get(0) : null;
    }

    /**
     * Hàm lấy tất cả đối tượng từ bảng TaiKhoan trong csdl
     *
     * @return 1 list đối tượng TaiKhoan
     */
    public List<TaiKhoan> selectAll() {
        String sql = "{call sp_TatCaTaiKhoan}";
        List<TaiKhoan> list = selectBySQL(sql);
        return list;
    }

    /**
     * Hàm tìm 1 đối tượng TaiKhoan theo nhiều điều kiện
     *
     * @param condition là điều kiện tìm kiếm
     * @return 1 list đối tượng TaiKhoan
     */
    public List<TaiKhoan> selectByConditions(String condition) {
        String sql = "{call sp_TimTaiKhoan(?)}";
        List<TaiKhoan> list = selectBySQL(sql, condition);
        return list;
    }

    /**
     * Hàm kiểm tra tên đăng nhập có tồn tại hay ko
     *
     * @param tenDn là tên đăng nhập cần tìm
     * @param matKhau là mật khẩu của tên đăng nhập
     * @return về 2 nếu cả 2 tên đăng nhập và mật khẩu đều thỏa mãn điều kiện
     */
    public int checkLogin(String tenDn, String matKhau) {
        String sql = "{? = call sp_KiemTraDN (?,?)}";
        int kq = JdbcHelper.executeUpdate(sql, tenDn, matKhau);
        return kq;
    }
}
