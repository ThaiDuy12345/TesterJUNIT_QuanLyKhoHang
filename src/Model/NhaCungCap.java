/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.*;

import static Help.ValidateHelper.*;

/**
 *
 * @author hp
 */
public class NhaCungCap {

    private String maNCC;
    private String tenNCC;
    private String SDT;
    private String Email;
    private String diaChi;

    public NhaCungCap() {
    }

    public NhaCungCap(String maNCC, String tenNCC, String SDT, String Email, String diaChi) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.SDT = SDT;
        this.Email = Email;
        this.diaChi = diaChi;
    }
    
    @Override
    public String toString(){
        return this.maNCC + " - " + this.tenNCC;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        JTextField txt = new JTextField(maNCC);
        if(ValidateNhaCc(txt)){
            this.maNCC = maNCC;
        }else{
            this.maNCC = null;
        }
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        JTextField txt = new JTextField(tenNCC);
        if(ValidateName(txt)){
            this.tenNCC = tenNCC;
        }else{
            this.tenNCC = null;
        }
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        JTextField txt = new JTextField(SDT);
        if(ValidateSDT(txt)){
            this.SDT = SDT;
        }else{
            this.SDT = null;
        }
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        JTextField txt = new JTextField(Email);
        if(ValidateEmail(txt)){
            this.Email = Email;
        }else{
            this.Email = null;
        }
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

}
