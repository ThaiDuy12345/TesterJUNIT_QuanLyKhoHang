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
public class SPCungCap {

    private String maSPCC;
    private String maNCC;
    private String tenSP;
    private double Gia;
    private String donViTinh;
    private String Hinh;
    private int loaiSP;

    public SPCungCap() {
    }

    public SPCungCap(String maSPCC, String maNCC, String tenSP, double Gia, String donViTinh, String Hinh, int ID) {
        this.maSPCC = maSPCC;
        this.maNCC = maNCC;
        this.tenSP = tenSP;
        this.Gia = Gia;
        this.donViTinh = donViTinh;
        this.Hinh = Hinh;
        this.loaiSP = ID;
    }
    

    public String getMaSPCC() {
        return maSPCC;
    }

    public void setMaSPCC(String maSPCC) {
        this.maSPCC = maSPCC;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
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

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public int getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(int loaiSP) {
        this.loaiSP = loaiSP;
    }

}
