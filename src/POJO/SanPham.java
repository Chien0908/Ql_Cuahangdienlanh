/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author Administrator-PC
 */
public class SanPham {
    private String tensp  ,mancc ,loaisp, hinh;
    private int masp,soluong;
    private float giatien;

    public SanPham(int masp, String tensp, String mancc, String loaisp, int soluong, float giatien, String hinh) {
        this.tensp = tensp;
        this.mancc = mancc;
        this.loaisp = loaisp;
        this.hinh = hinh;
        this.masp = masp;
        this.soluong = soluong;
        this.giatien = giatien;
    }
    
    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }

    public String getLoaisp() {
        return loaisp;
    }

    public void setLoaisp(String loaisp) {
        this.loaisp = loaisp;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getGiatien() {
        return giatien;
    }

    public void setGiatien(float giatien) {
        this.giatien = giatien;
    }

    

    
    
}
