/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;
import java.util.Date;
/**
 *
 * @author Administrator-PC
 */
public class HoaDonXuat {
    private int mahdx, manv;
    private String hotenkh, sdt;
    private Date ngayxuat;
    private float tongtien;

    public HoaDonXuat(int mahdx, int manv, String hotenkh, String sdt, Date ngayxuat, float tongtien) {
        this.mahdx = mahdx;
        this.manv = manv;
        this.hotenkh = hotenkh;
        this.sdt = sdt;
        this.ngayxuat = ngayxuat;
        this.tongtien = tongtien;
    }

    public int getMahdx() {
        return mahdx;
    }

    public void setMahdx(int mahdx) {
        this.mahdx = mahdx;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getHotenkh() {
        return hotenkh;
    }

    public void setHotenkh(String hotenkh) {
        this.hotenkh = hotenkh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgayxuat() {
        return ngayxuat;
    }

    public void setNgayxuat(Date ngayxuat) {
        this.ngayxuat = ngayxuat;
    }

    public float getTongtien() {
        return tongtien;
    }

    public void setTongtien(float tongtien) {
        this.tongtien = tongtien;
    }
    
    
}