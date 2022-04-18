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
 * @author ZBook
 */
public class LoaiSP {
    private int ID;
    private String loaiSP;

    public LoaiSP() {
    }

    public LoaiSP(int ID, String loaiSP) {
        this.ID = ID;
        this.loaiSP = loaiSP;
    }

    @Override
    public String toString() {
        return this.ID + " - " + this.loaiSP;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        try{
            JTextField txt = new JTextField();
            txt.setText(String.valueOf(ID));
            if (checkSoLuong(txt)) {
                this.ID = ID;
            }else{
                this.ID = -1;
            }
        }catch(Exception ex){
            this.ID = -1;
        }
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        JTextField txt = new JTextField();
        txt.setText(loaiSP);
        if (ValidateName(txt)) {
            this.loaiSP = loaiSP;
        }else{
            this.loaiSP = null;
        }
    }
    
    
}
