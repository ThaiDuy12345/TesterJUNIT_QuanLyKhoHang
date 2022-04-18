/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hp
 */
public class TaiKhoan {
    private String tenDn;
    private String matKhau;
    private int vaiTro;
    private String email;
    private String soDt;
    private int gioiTinh;
    private double luong;
    private String hoTen;
    private String hinh;

    

    public TaiKhoan() {
    }

    public TaiKhoan(String tenDn, String matKhau, int vaiTro, String email, String soDt, int gioiTinh, double luong, String hoTen) {
        this.tenDn = tenDn;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.email = email;
        this.soDt = soDt;
        this.gioiTinh = gioiTinh;
        this.luong = luong;
        this.hoTen = hoTen;
    }

    public String getTenDn() {
        return tenDn;
    }

    public void setTenDn(String tenDn) {
        this.tenDn = tenDn;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(int vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDt() {
        return soDt;
    }

    public void setSoDt(String soDt) {
        this.soDt = soDt;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    
    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }
}
