/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author This PC
 */
public class GiaoDichNha {
    private String MaND, MaNha, MaKH;
   private String NgayGD;
   private float ThanhToan;
   private int MaGDN ;

    public GiaoDichNha() {
    }

    public String getMaND() {
        return MaND;
    }

    public void setMaND(String MaND) {
        this.MaND = MaND;
    }

    public String getMaNha() {
        return MaNha;
    }

    public void setMaNha(String MaNha) {
        this.MaNha = MaNha;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getNgayGD() {
        return NgayGD;
    }

    public void setNgayGD(String NgayGD) {
        this.NgayGD = NgayGD;
    }

    public float getThanhToan() {
        return ThanhToan;
    }

    public void setThanhToan(float ThanhToan) {
        this.ThanhToan = ThanhToan;
    }

    public int getMaGDN() {
        return MaGDN;
    }

    public void setMaGDN(int MaGDN) {
        this.MaGDN = MaGDN;
    }

    public GiaoDichNha(String MaND, String MaNha, String MaKH, String NgayGD, float ThanhToan, int MaGDN) {
        this.MaND = MaND;
        this.MaNha = MaNha;
        this.MaKH = MaKH;
        this.NgayGD = NgayGD;
        this.ThanhToan = ThanhToan;
        this.MaGDN = MaGDN;
    }

   
}
