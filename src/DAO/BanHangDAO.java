/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.HoaDonXuat;
import POJO.ChiTietHoaDonXuat;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Administrator-PC
 */
public class BanHangDAO {
     public static ArrayList<HoaDonXuat> getDSHDX()
    {
        ArrayList<HoaDonXuat> dshdx = new ArrayList<HoaDonXuat>();
        try{
            String sql="select * from HoaDonXuat";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while (rs.next())
            {
               HoaDonXuat hdx = new HoaDonXuat(rs.getInt("mahdx"), rs.getInt("manv"), rs.getString("hotenkh").trim(),rs.getString("sdt"), rs.getDate("ngayxuat"),rs.getFloat("tongtien"));
               dshdx.add(hdx);
            }
            
        }catch(Exception e)
        {
            System.err.println("Không thể lấy dữ liệu hóa đơn");
        }
        return  dshdx;
    }
    
    public static ArrayList<ChiTietHoaDonXuat> getDSCTHDX()
    {
        ArrayList<ChiTietHoaDonXuat> dscthdx = new ArrayList<ChiTietHoaDonXuat>();
        try{
            String sql="select * from ChiTietHoaDonXuat";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while (rs.next())
            {
               ChiTietHoaDonXuat cthdx = new ChiTietHoaDonXuat(rs.getInt("macthdx"), rs.getInt("mahdx"), rs.getInt("masp"), rs.getInt("soluongxuat"), rs.getFloat("dongiaxuat"), rs.getFloat("thanhtien"));
               dscthdx.add(cthdx);
            }
            
        }catch(Exception e)
        {
            System.err.println("Không thể lấy dữ liệu chi tiết hóa đơn");
        }
        return  dscthdx;
    }
    
    public static int ThemXoaSuaHoaDonXuat (String sql){
        int i=0;
        try {
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
             i = cn.executeUpdate(sql);
            cn.close();
            System.out.println("Thêm/xóa/sửa thành công");
            
        } catch (Exception e) {
            System.out.println("Thêm/xóa/sửa không thành công");
           
        }
        return i;
    }
     public static ArrayList<ChiTietHoaDonXuat> TimChiTietHoaDonXuat(String mapn) 
    {
         ArrayList<ChiTietHoaDonXuat> thongTinCTHDN = new ArrayList<ChiTietHoaDonXuat>();
         //KhachHang thongTinKH = new KhachHang("", "", "", "", 0);
          try {
            String sql ="select * from ChiTietHoaDonXuat where mahdx='"+mapn+"'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
             ChiTietHoaDonXuat cthdx = new ChiTietHoaDonXuat(rs.getInt("macthdx"), rs.getInt("mahdx"), rs.getInt("masp"), rs.getInt("soluongxuat"), rs.getFloat("dongiaxuat"), rs.getFloat("thanhtien"));

              thongTinCTHDN.add(cthdx);
            }
            cn.close();
        } catch (Exception e) 
        {
            System.out.println("Lỗi không thể lấy dữ liệu ");
        }
          return thongTinCTHDN;
    }
}
