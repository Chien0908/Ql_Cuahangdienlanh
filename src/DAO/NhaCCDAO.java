/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.NhaCC;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Administrator-PC
 */
public class NhaCCDAO {
    
    //lấy dữ liệu danh sách nhân viên -> form
     public static ArrayList<NhaCC> getDSNCC(){
        ArrayList<NhaCC> dsncc = new ArrayList<NhaCC>();
        try {
            String sql = "select * from nhacungcap";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                NhaCC ncc = new NhaCC(rs.getInt("mancc"), rs.getString("tenncc").trim(), rs.getString("diachi").trim(), rs.getString("sdt").trim());
                dsncc.add(ncc);
            }
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu sản phẩm");
            e.printStackTrace();
        }
        return dsncc;
    }
    //==================================================================
     
     
    //thêm xóa sửa dữ liệu nhan viên
       public static int ThemXoaSuaNCC(String sql){
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
       
    public static ArrayList<NhaCC> TimChiTietNCC(String mancc) 
    {
         ArrayList<NhaCC> thongTinNCC = new ArrayList<NhaCC>();
         //KhachHang thongTinKH = new KhachHang("", "", "", "", 0);
          try {
            String sql ="select * from NhaCungCap where Mancc='"+mancc+"'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
            NhaCC ncc = new NhaCC(rs.getInt("mancc"), rs.getString("tenncc").trim(), rs.getString("diachi").trim(), rs.getString("sdt").trim());
             thongTinNCC.add(ncc);
            }
            cn.close();
        } catch (Exception e) 
        {
            System.out.println("Lỗi không thể lấy dữ liệu ");
        }
          return thongTinNCC;
    }
}
