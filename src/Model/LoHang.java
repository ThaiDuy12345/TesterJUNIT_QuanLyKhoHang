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
public class LoHang {

    private String maLoHang;
    private String tenLoHang;
    private String viTri;
    private String moTa;

    public LoHang() {
    }

    public LoHang(String maLoHang, String tenLoHang, String viTri, String moTa) {
        this.maLoHang = maLoHang;
        this.tenLoHang = tenLoHang;
        this.viTri = viTri;
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return this.maLoHang + " - " + this.tenLoHang;
    }
    
    
    public String getMaLoHang() {
        return maLoHang;
    }

    public void setMaLoHang(String maLoHang) {
        this.maLoHang = maLoHang;
    }

    public String getTenLoHang() {
        return tenLoHang;
    }

    public void setTenLoHang(String tenLoHang) {
        this.tenLoHang = tenLoHang;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

}
