/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import POJO.SanPham;
/**
 *
 * @author Administrator-PC
 */
public class SanPhamDAO {
    //lấy dữ liệu danh sách sản phẩm -> form
     public static ArrayList<SanPham> getDSSP(){
        ArrayList<SanPham> dssp = new ArrayList<SanPham>();
        try {
            String sql = "select * from sanpham";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                SanPham sp = new SanPham(rs.getInt("masp"), rs.getString("tensp").trim(), rs.getString("mancc").trim(), rs.getString("loaisp").trim(), rs.getInt("soluong"), rs.getFloat("giatien"), rs.getString("hinh").trim());
                dssp.add(sp);
            }
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu sản phẩm");
            e.printStackTrace();
        }
        return dssp;
    }
    //==================================================================
     
     
    //thêm xóa sửa dữ liệu sản phẩm 
      public static int ThemXoaSuaSP(String sql){
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
      public static ArrayList<SanPham> TimChiTietSanPham(String masp) 
    {
         ArrayList<SanPham> thongTinSP = new ArrayList<SanPham>();
         //KhachHang thongTinKH = new KhachHang("", "", "", "", 0);
          try {
            String sql ="select * from SanPham where Masp='"+masp+"'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
            SanPham sp = new SanPham(rs.getInt("masp"), rs.getString("tensp").trim(), rs.getString("mancc").trim(), rs.getString("loaisp").trim(), rs.getInt("soluong"), rs.getFloat("giatien"), rs.getString("hinh"));
             thongTinSP.add(sp);
            }
            cn.close();
        } catch (Exception e) 
        {
            System.out.println("Lỗi không thể lấy dữ liệu ");
        }
          return thongTinSP;
    }
       public static ArrayList<SanPham> TimcomboboxSanPham(String sql) 
    {
         ArrayList<SanPham> thongTinSP = new ArrayList<SanPham>();
         //KhachHang thongTinKH = new KhachHang("", "", "", "", 0);
          try {
            
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
            SanPham sp = new SanPham(rs.getInt("masp"), rs.getString("tensp").trim(), rs.getString("mancc").trim(), rs.getString("loaisp").trim(), rs.getInt("soluong"), rs.getFloat("giatien"), rs.getString("hinh"));
             thongTinSP.add(sp);
            }
            cn.close();
        } catch (Exception e) 
        {
            System.out.println("Lỗi không thể lấy dữ liệu ");
        }
          return thongTinSP;
    }
}
