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
public class ChungTuCT {

    private String maChungTu;
    private String maSP;
    private String tenSP;
    private int loaiSP;
    private double Gia;
    private int soLuong;
    private String donViTinh;
    private String tenNCC;
    private String maLoHang;
    private String Hinh;
    private Date ngayNhap =DateHelper.now();
    private String moTa;

    public ChungTuCT() {
    }

    public ChungTuCT(String maChungTu, String maSP, String tenSP, int loaiSP, double Gia, int soLuong, String donViTinh, String tenNCC, String maLoHang, String Hinh, String moTa) {
        this.maChungTu = maChungTu;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.loaiSP = loaiSP;
        this.Gia = Gia;
        this.soLuong = soLuong;
        this.donViTinh = donViTinh;
        this.tenNCC = tenNCC;
        this.maLoHang = maLoHang;
        this.Hinh = Hinh;
        this.moTa = moTa;
    }

    
    

    public String getMaChungTu() {
        return maChungTu;
    }

    public void setMaChungTu(String maChungTu) {
        this.maChungTu = maChungTu;
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

    public String getMaLoHang() {
        return maLoHang;
    }

    public void setMaLoHang(String maLoHang) {
        this.maLoHang = maLoHang;
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
