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
 * @author hp
 */
public class SPKho {

    private String maSPKho;
    private String tenSP;
    private int loaiSP;
    private double Gia;
    private int soLuong;
    private String donViTinh;
    private String tenNCC;
    private String maLoHang;
    private Date ngayNhap = DateHelper.now();
    private String Hinh;

    public SPKho(String maSPKho, String tenSP, int loaiSP, double Gia, int soLuong, String donViTinh, String tenNCC, String maLoHang, String Hinh) {
        this.maSPKho = maSPKho;
        this.tenSP = tenSP;
        this.loaiSP = loaiSP;
        this.Gia = Gia;
        this.soLuong = soLuong;
        this.donViTinh = donViTinh;
        this.tenNCC = tenNCC;
        this.maLoHang = maLoHang;
        this.Hinh = Hinh;
    }

    @Override
    public String toString() {
        return this.tenSP + " (" + this.maSPKho + ")";
    }
    public SPKho(){}

    public String getMaSPKho() {
        return maSPKho;
    }

    public void setMaSPKho(String maSPKho) {
        this.maSPKho = maSPKho;
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

    public String getMaLoHang() {
        return maLoHang;
    }

    public void setMaLoHang(String maLoHang) {
        this.maLoHang = maLoHang;
    }

    public int getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(int loaiSP) {
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

}
