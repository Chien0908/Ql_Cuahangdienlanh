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
public class ChiTietHoaDonNhap {
    private int macthdn,mahdn,masp,soluongnhap;
    private float dongianhap,thanhtien;

    public ChiTietHoaDonNhap(int macthdn, int mahdn, int masp, int soluongnhap, float dongianhap, float thanhtien) {
        this.macthdn = macthdn;
        this.mahdn = mahdn;
        this.masp = masp;
        this.soluongnhap = soluongnhap;
        this.dongianhap = dongianhap;
        this.thanhtien = thanhtien;
    }

    public int getMacthdn() {
        return macthdn;
    }

    public void setMacthdn(int macthdn) {
        this.macthdn = macthdn;
    }

    public int getMahdn() {
        return mahdn;
    }

    public void setMahdn(int mahdn) {
        this.mahdn = mahdn;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public int getSoluongnhap() {
        return soluongnhap;
    }

    public void setSoluongnhap(int soluongnhap) {
        this.soluongnhap = soluongnhap;
    }

    public float getDongianhap() {
        return dongianhap;
    }

    public void setDongianhap(float dongianhap) {
        this.dongianhap = dongianhap;
    }

    public float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }
    

   
}
