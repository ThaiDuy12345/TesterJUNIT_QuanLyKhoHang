/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ZBook
 */
public class KhachHang {

    private String maKH;
    private String tenKH;
    private String SDT;
    private String diaChi;
    private String Email;
    private int gioiTinh;
    private String tenDangNhap;

    public KhachHang() {
    }

    public KhachHang(String maKH, String tenKH, String SDT, String diaChi, String Email, int gioiTinh, String tenDangNhap) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.SDT = SDT;
        this.diaChi = diaChi;
        this.Email = Email;
        this.gioiTinh = gioiTinh;
        this.tenDangNhap = tenDangNhap;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        String rgx = "([A-ZĐ][a-záàạãảắặằẵẳăâấậẩẫầềềêèéệếểễôốồộổơớởờợỡũúùứửừựữưịìíỉĩýỳỵỹỷòóọỏõđ]+[ ]{0,1})+";
        if (tenKH.matches(rgx)) {
            return tenKH;
        } else {
            return null;
        }
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSDT() {
        String rgx = "(086|096|097|098|032|033|034|035|036|037|038|039|089|090|093|070|079|077|078|076|088|091|094|083|084|085|081|082|092|056|058|099|059)[0-9]{7,8}";
        if (SDT.matches(rgx)) {
            return SDT;
        } else {
            return null;
        }
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        String rgx = "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
        if (Email.matches(rgx)) {
            return Email;
        } else {
            return null;
        }
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

}
