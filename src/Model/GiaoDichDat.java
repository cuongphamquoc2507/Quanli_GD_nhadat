/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author 54321
 */
public class GiaoDichDat {
   private String  MaND, MaDat, MaKH;
   private String NgayGD;
   private int MaGDD;
   private float ThanhToan;

    public String getMaND() {
        return MaND;
    }

    public void setMaND(String MaND) {
        this.MaND = MaND;
    }

    public String getMaDat() {
        return MaDat;
    }

    public void setMaDat(String MaDat) {
        this.MaDat = MaDat;
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

    public int getMaGDD() {
        return MaGDD;
    }

    public void setMaGDD(int MaGDD) {
        this.MaGDD = MaGDD;
    }

    public float getThanhToan() {
        return ThanhToan;
    }

    public void setThanhToan(float ThanhToan) {
        this.ThanhToan = ThanhToan;
    }

    public GiaoDichDat(String MaND, String MaDat, String MaKH, String NgayGD, int MaGDD, float ThanhToan) {
        this.MaND = MaND;
        this.MaDat = MaDat;
        this.MaKH = MaKH;
        this.NgayGD = NgayGD;
        this.MaGDD = MaGDD;
        this.ThanhToan = ThanhToan;
    }

    public GiaoDichDat() {
    }

   
}
