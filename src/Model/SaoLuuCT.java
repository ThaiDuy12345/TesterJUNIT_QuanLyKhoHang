/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Help.DateHelper;
import java.util.Date;

/**
 *
 * @author ZBook
 */
public class SaoLuuCT {
   private String maSaoLuu;
   private String maSP;
   private String tenSP;
   private double Gia;
   private int soLuong;
   private String donViTinh;
   private String loaiSP;
   private String tenNCC;
   private String Hinh;
   private Date ngayNhap=DateHelper.now();
   private String moTa;

    public SaoLuuCT() {
    }

    public SaoLuuCT(String maSaoLuu, String maSP, String tenSP, double Gia, int soLuong, String donViTinh, String loaiSP, String tenNCC, String Hinh, Date ngayNhap, String moTa) {
        this.maSaoLuu = maSaoLuu;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.Gia = Gia;
        this.soLuong = soLuong;
        this.donViTinh = donViTinh;
        this.loaiSP = loaiSP;
        this.tenNCC = tenNCC;
        this.Hinh = Hinh;
        this.ngayNhap = ngayNhap;
        this.moTa = moTa;
    }
    

    public String getMaSaoLuu() {
        return maSaoLuu;
    }

    public void setMaSaoLuu(String maSaoLuu) {
        this.maSaoLuu = maSaoLuu;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    
}
