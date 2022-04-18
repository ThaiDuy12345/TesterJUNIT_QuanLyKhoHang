/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author ZBook
 */
public class SaoLuu {
   private String maSaoLuu;
   private String tenDangNhap;
   private String loaiSaoLuu;
   private Date ngayTao;
   private String trangThai;
   private String maKH;
   private double tongTien;

    public SaoLuu() {
    }

    public SaoLuu(String maSaoLuu, String tenDangNhap, String loaiSaoLuu, Date ngayTao, String trangThai, String maKH, double tongTien) {
        this.maSaoLuu = maSaoLuu;
        this.tenDangNhap = tenDangNhap;
        this.loaiSaoLuu = loaiSaoLuu;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.maKH = maKH;
        this.tongTien = tongTien;
    }
    

    public String getMaSaoLuu() {
        return maSaoLuu;
    }

    public void setMaSaoLuu(String maSaoLuu) {
        this.maSaoLuu = maSaoLuu;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getLoaiSaoLuu() {
        return loaiSaoLuu;
    }

    public void setLoaiSaoLuu(String loaiSaoLuu) {
        this.loaiSaoLuu = loaiSaoLuu;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
}
