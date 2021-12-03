/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author This PC
 */
public class Nha {
     private String LoaiNha, DiaChi, TrangThai;
    private float DienTich;
    private byte [] Mota;
private int  MaNha;

    public String getLoaiNha() {
        return LoaiNha;
    }

    public void setLoaiNha(String LoaiNha) {
        this.LoaiNha = LoaiNha;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public float getDienTich() {
        return DienTich;
    }

    public void setDienTich(float DienTich) {
        this.DienTich = DienTich;
    }

    public byte[] getMota() {
        return Mota;
    }

    public void setMota(byte[] Mota) {
        this.Mota = Mota;
    }

    public int getMaNha() {
        return MaNha;
    }

    public void setMaNha(int MaNha) {
        this.MaNha = MaNha;
    }

    public Nha(String LoaiNha, String DiaChi, float DienTich, byte[] Mota, int MaNha) {
        this.LoaiNha = LoaiNha;
        this.DiaChi = DiaChi;
        this.DienTich = DienTich;
        this.Mota = Mota;
        this.MaNha = MaNha;
    }
    public Nha() {
    }

    
      public int getDonGia()
    {
        if("Cao cấp".equals(LoaiNha))
        {
             return  100000; 
        }
        else 
        {
            return 90000;
        }
        
    }
   
    
}
