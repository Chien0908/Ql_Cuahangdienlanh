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
public class ChiTietHoaDonXuat {
    private int macthdx, mahdx, masp, soluong;
    private float dongiaxuat, thanhtien;

    public ChiTietHoaDonXuat(int macthdx, int mahdx, int masp, int soluong, float dongiaxuat, float thanhtien) {
        this.macthdx = macthdx;
        this.mahdx = mahdx;
        this.masp = masp;
        this.soluong = soluong;
        this.dongiaxuat = dongiaxuat;
        this.thanhtien = thanhtien;
    }

    public int getMacthdx() {
        return macthdx;
    }

    public void setMacthdx(int macthdx) {
        this.macthdx = macthdx;
    }

    public int getMahdx() {
        return mahdx;
    }

    public void setMahdx(int mahdx) {
        this.mahdx = mahdx;
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

    public float getDongiaxuat() {
        return dongiaxuat;
    }

    public void setDongiaxuat(float dongiaxuat) {
        this.dongiaxuat = dongiaxuat;
    }

    public float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }
    
}
