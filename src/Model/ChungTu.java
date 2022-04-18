/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import Help.DateHelper;

/**
 *
 * @author hp
 */
public class ChungTu {

    private String maChungTu;
    private String tenDangNhap;
    private String loaiChungTu;
    private Date ngayTao = DateHelper.now();
    private String trangThai;
    private String maKH;
    private String nguoiDuyet;
    private double tongTien;

    public ChungTu(String maChungTu, String tenDangNhap, String loaiChungTu, String trangThai, String maKH, String nguoiDuyet, double tongTien) {
        this.maChungTu = maChungTu;
        this.tenDangNhap = tenDangNhap;
        this.loaiChungTu = loaiChungTu;
        this.trangThai = trangThai;
        this.maKH = maKH;
        this.nguoiDuyet = nguoiDuyet;
        this.tongTien = tongTien;
    }

    

    public ChungTu() {
    }

    public String getMaChungTu() {
        return maChungTu;
    }

    public void setMaChungTu(String maChungTu) {
        this.maChungTu = maChungTu;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getLoaiChungTu() {
        return loaiChungTu;
    }

    public void setLoaiChungTu(String loaiChungTu) {
        this.loaiChungTu = loaiChungTu;
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

    public String getNguoiDuyet() {
        return nguoiDuyet;
    }

    public void setNguoiDuyet(String nguoiDuyet) {
        this.nguoiDuyet = nguoiDuyet;
    }
    
    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

}
