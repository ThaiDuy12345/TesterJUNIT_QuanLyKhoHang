/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Help;

import Model.KhachHang;
import Model.TaiKhoan;

/**
 *
 * @author hp
 */
public class Auth {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    /**
     *
     * @author hp
     */
    //Lưu tên đăng nhập của người dùng hiện tại
    public static TaiKhoan user = null;
    //Lưu tên khách hàng được chọn tạo đơn
    public static KhachHang khachHang = null;

    //Xóa tên người dùng hiện tại
    public static void clear() {
        Auth.user = null;
    }

    //Xóa tên khách hàng
    public static void clearKhachHang() {
        Auth.khachHang = null;
    }
    //Kiểm tra dã chọn khách hàng hay chưa

    public static boolean isKhachHang() {
        return Auth.khachHang != null;
        //Biến khác null thì return là true và ngược lại
    }

    //Kiểm tra xem người dùng đã đăng nhập hay chưa
    public static boolean isLogin() {
        return Auth.user != null;
        //Biến khác null thì return là true và ngược lại
    }

    //Kiểm tra người dùng có phải quản lý hay ko
    //Nếu là quản lý thì trả về true và ngược lại
    public static boolean isManager() {
        return Auth.isLogin() == true && user.getVaiTro() == 0;
        //Kiểm tra có phải trưởng phòng hay không và đuọc đăng nhập hay chưa
    }

    //Kiểm tra người dùng có phải là nhân viên đơn hàng
    public static boolean isEmployeeOder() {
        return Auth.isLogin() == true && user.getVaiTro() == 1;
        //Kiểm tra có phải nhân viên đơn hàng hay không và đuọc đăng nhập hay chưa
    }
    //Kiểm tra người dùng có phải là nhân viên kho hàng

    public static boolean isEmployeeWareHouse() {
        return Auth.isLogin() == true && user.getVaiTro() == 2;
        //Kiểm tra có phải nhân viên kho hàng hay không và đuọc đăng nhập hay chưa
    }
}
