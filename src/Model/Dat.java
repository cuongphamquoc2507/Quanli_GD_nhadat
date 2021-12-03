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
public class Dat {
    private String LoaiDat, TrangThai;
    private int MaDat;
    private float  DienTich;
   // private float  DonGia;
    private byte [] Mota;

   
     public int getDonGia()
    {
        if("A".equals(LoaiDat))
        {
             return  100000; 
        }
        if("B".equals(LoaiDat))
        {
              return  50000; 
        }
        else 
        {
            return 40000;
        }
        
    }

    public Dat(String LoaiDat, String TrangThai, int MaDat, float DienTich, byte[] Mota) {
        this.LoaiDat = LoaiDat;
        this.TrangThai = TrangThai;
        this.MaDat = MaDat;
        this.DienTich = DienTich;
        this.Mota = Mota;
    }

    public Dat() {
    }

    public String getLoaiDat() {
        return LoaiDat;
    }

    public void setLoaiDat(String LoaiDat) {
        this.LoaiDat = LoaiDat;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getMaDat() {
        return MaDat;
    }

    public void setMaDat(int MaDat) {
        this.MaDat = MaDat;
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
   
    

}