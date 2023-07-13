/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.NhanVien;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Administrator-PC
 */
public class NhanVienDAO {
    //lấy dữ liệu danh sách nhân viên -> form
     public static ArrayList<NhanVien> getDSNV(){
        ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
        try {
            String sql = "select * from nhanvien";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                NhanVien nv = new NhanVien(rs.getInt("manv"), rs.getString("hoten").trim(), rs.getString("taikhoan").trim(), rs.getString("matkhau").trim(), rs.getString("sdt"),rs.getString("chucvu"),rs.getString("hinh"));
                dsnv.add(nv);
            }
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ nhân viên");
            e.printStackTrace();
        }
        return dsnv;
    }
    //==================================================================
     
     
    //thêm xóa sửa dữ liệu nhan viên
       public static int ThemXoaSuaNV(String sql){
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
        public static ArrayList<NhanVien> TimChiTietNhanVien(String manv) 
    {
         ArrayList<NhanVien> thongTinNV = new ArrayList<NhanVien>();
         //KhachHang thongTinKH = new KhachHang("", "", "", "", 0);
          try {
            String sql ="select * from NHANVIEN where MANV='"+manv+"'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
            NhanVien nv = new NhanVien(rs.getInt("manv"), rs.getString("hoten").trim(), rs.getString("taikhoan").trim(), rs.getString("matkhau").trim(), rs.getString("sdt"),rs.getString("chucvu"),rs.getString("hinh"));

             thongTinNV.add(nv);
            }
            cn.close();
        } catch (Exception e) 
        {
            System.out.println("Lỗi không thể lấy dữ liệu ");
        }
          return thongTinNV;
    }
         public static ArrayList<NhanVien> TimChiTietThongTinNhanVien(int manv) 
    {
         ArrayList<NhanVien> thongTinNV = new ArrayList<NhanVien>();
         //KhachHang thongTinKH = new KhachHang("", "", "", "", 0);
          try {
            String sql ="select * from NHANVIEN where MANV='"+manv+"'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
            NhanVien nv = new NhanVien(rs.getInt("manv"), rs.getString("hoten").trim(), rs.getString("taikhoan").trim(), rs.getString("matkhau").trim(), rs.getString("sdt"),rs.getString("chucvu"),rs.getString("hinh"));

             thongTinNV.add(nv);
            }
            cn.close();
        } catch (Exception e) 
        {
            System.out.println("Lỗi không thể lấy dữ liệu ");
        }
          return thongTinNV;
    }
    //==================================================================    
          public static ArrayList<NhanVien> layTTDangNhap(String taiKhoan, String matKhau) 
    {
         ArrayList<NhanVien> thongTinNV = new ArrayList<NhanVien>();
         //KhachHang thongTinKH = new KhachHang("", "", "", "", 0);
          try {
            String sql ="select * from NhanVien where TaiKhoan = '"+taiKhoan+"' AND matKhau = '"+matKhau+"'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
            NhanVien nv = new NhanVien(rs.getInt("manv"), rs.getString("hoten").trim(), rs.getString("taikhoan").trim(), rs.getString("matkhau").trim(), rs.getString("sdt"),rs.getString("chucvu"),rs.getString("hinh"));

            thongTinNV.add(nv);
            }
            cn.close();
        } catch (Exception e) 
        {
            System.out.println("Lỗi không thể lấy dữ liệu ");
        }
          return thongTinNV;
    }
         //==================================================================
    public static boolean KTraDangNhap(String taiKhoan, String matKhau) 
    {
         
         //KhachHang thongTinKH = new KhachHang("", "", "", "", 0);
          try {
            String sql ="select * from NhanVien where TaiKhoan = '"+taiKhoan+"' AND matKhau = '"+matKhau+"'";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
            return true;
            }
            cn.close();
        } catch (Exception e) 
        {
            System.out.println("Lỗi không thể lấy dữ liệu ");
        }
          return false;
    }
}
