/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.HoaDonNhap;
import POJO.ChiTietHoaDonNhap;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Administrator-PC
 */
public class NhapHangDAO {
    
      public static ArrayList<HoaDonNhap> getDSHDN(){
        ArrayList<HoaDonNhap> dshdn = new ArrayList<HoaDonNhap>();
        try {
            String sql = "select * from HoaDonNhap";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                HoaDonNhap hdn = new HoaDonNhap(rs.getInt("mahdn"), rs.getInt("mancc"), rs.getInt("manv"), rs.getDate("ngaynhap"), rs.getFloat("tongtien"));
                dshdn.add(hdn);
            }
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
            e.printStackTrace();
        }
        return dshdn;
    }
    //==================================================================
     
     
   
       public static int ThemXoaSuaDSHDN(String sql){
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
    //==================================================================
         public static ArrayList<ChiTietHoaDonNhap> getDSCTHDN(){
        ArrayList<ChiTietHoaDonNhap> dscthdn = new ArrayList<ChiTietHoaDonNhap>();
        try {
            String sql = "select * from ChiTietHoaDonNhap";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                ChiTietHoaDonNhap cthdn = new ChiTietHoaDonNhap(rs.getInt("macthdn"), rs.getInt("mahdn"), rs.getInt("masp"), rs.getInt("soluongnhap"), rs.getFloat("dongianhap"),rs.getFloat("thanhtien"));
                dscthdn.add(cthdn);
            }
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
            e.printStackTrace();
        }
        return dscthdn;
    }
    //==================================================================
     
     
   
       public static int ThemXoaSuaDSCTHDN(String sql){
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
    //========================================================================================
       public static ArrayList<ChiTietHoaDonNhap> TimChiTietHoaDonNhap(String mapn) 
    {
         ArrayList<ChiTietHoaDonNhap> thongTinCTHDN = new ArrayList<ChiTietHoaDonNhap>();
         //KhachHang thongTinKH = new KhachHang("", "", "", "", 0);
          try {
            String sql ="select * from ChiTietHoaDonNhap where mahdn='"+mapn+"'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
             ChiTietHoaDonNhap cthdn = new ChiTietHoaDonNhap(rs.getInt("macthdn"), rs.getInt("mahdn"), rs.getInt("masp"), rs.getInt("soluongnhap"), rs.getFloat("dongianhap"),rs.getFloat("thanhtien"));

              thongTinCTHDN.add(cthdn);
            }
            cn.close();
        } catch (Exception e) 
        {
            System.out.println("Lỗi không thể lấy dữ liệu ");
        }
          return thongTinCTHDN;
    }
}
