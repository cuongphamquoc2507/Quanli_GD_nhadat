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
public class NguoiDung {
   private String TenND, SoDT,DiaChi,ChucVu,UserName,Pass, NgaySinh;
   private int GioiTinh; 
   private byte [] Hinh;
   private int MaND;

    public NguoiDung() {
    }

    public NguoiDung(String TenND, String SoDT, String DiaChi, String ChucVu, String UserName, String NgaySinh, int GioiTinh, byte[] Hinh, int MaND) {
        this.TenND = TenND;
        this.SoDT = SoDT;
        this.DiaChi = DiaChi;
        this.ChucVu = ChucVu;
        this.UserName = UserName;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.Hinh = Hinh;
        this.MaND = MaND;
    }

    public String getTenND() {
        return TenND;
    }

    public void setTenND(String TenND) {
        this.TenND = TenND;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public byte[] getHinh() {
        return Hinh;
    }

    public void setHinh(byte[] Hinh) {
        this.Hinh = Hinh;
    }

    public int getMaND() {
        return MaND;
    }

    public void setMaND(int MaND) {
        this.MaND = MaND;
    }

    
    

}