/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form_view;
import DAO.NhaCCDAO;
import DAO.NhanVienDAO;
import DAO.NhapHangDAO;
import DAO.SanPhamDAO;
import POJO.NhaCC;
import POJO.NhanVien;
import POJO.HoaDonNhap;
import POJO.SanPham;
import POJO.ChiTietHoaDonNhap;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Administrator-PC
 */
public class NhapHangJPanel extends javax.swing.JPanel {
    Vector tblDatanv = new Vector();
    Vector tblTitlenv = new Vector();
    Vector tblDatancc = new Vector();
    Vector tblTitlencc = new Vector();
    Vector tblDatanhaphang = new Vector();
    Vector tblTitlenhaphang = new Vector();
    Vector tblDatasanpham = new Vector();
    Vector tblTitlesanpham = new Vector();
    Vector tblDatactnhaphang = new Vector();
    Vector tblTitlectnhaphang = new Vector();
    Vector tblDataxuatdsctnhaphang = new Vector();
    Vector tblTitlexuatdsctnhaphang = new Vector();
    DefaultTableModel tblModel;
    static ArrayList<NhaCC> dsncc = NhaCCDAO.getDSNCC();
    static ArrayList<NhanVien> dsnv = NhanVienDAO.getDSNV();
    static ArrayList<HoaDonNhap> dshdn = NhapHangDAO.getDSHDN();
    static ArrayList<SanPham> dssp = SanPhamDAO.getDSSP();
    static ArrayList<ChiTietHoaDonNhap> dscthdn = NhapHangDAO.getDSCTHDN();
    /**
     * Creates new form NhapHangJPanel
     */
    public NhapHangJPanel() {
        initComponents();
        bangnhanvien();
        laydulieunhanvien(dsnv);
        bangnhacc();
        laydulieuncc(dsncc);
        bangphieunhap();
        laydulieuphieunhap(dshdn);
        bangsanpham();
        laydulieusanpham(dssp);
        bangctnhaphang();
        laydulieuctnhaphang(dscthdn);
        bangxuatdsctnhaphang();
        mhdn2_txt.setText(hdn_txt.getText());
        ngaynhap_txt.setText(java.time.LocalDate.now()+"");
        hdn_txt.setEnabled(false);
        mhdn2_txt.setEnabled(false);
        thanhtien_txt.setEnabled(false);
        mcthd_txt.setEnabled(false);
        tongtien_txt.setEnabled(false);  
    }
    
    public void bangnhanvien(){
        tblTitlenv.add("Mã nhân viên"); tblTitlenv.add("Họ tên nhân viên"); tblTitlenv.add("Số đt"); tblTitlenv.add("Chức vụ"); 
    }
    
    public void laydulieunhanvien(ArrayList<NhanVien> dsnv){
        tblDatanv.removeAllElements();
        for(NhanVien b : dsnv){
            Vector v = new Vector();
            v.add(b.getManv()); v.add(b.getHoten()); v.add(b.getSdt());  v.add(b.getChucvu()); 
            tblDatanv.add(v);
        }
        table_dsnv.setModel(new DefaultTableModel(tblDatanv, tblTitlenv));
    }
    //===================================================================================================================================================================================
    public void bangnhacc(){
        tblTitlencc.add("Mã nhà CC"); tblTitlencc.add("Tên nhà CC"); tblTitlencc.add("Địa chỉ"); tblTitlencc.add("số DT");
    }
    
    public void laydulieuncc(ArrayList<NhaCC> dsncc){
        tblDatancc.removeAllElements();
        for(NhaCC b : dsncc){
            Vector v = new Vector();
            v.add(b.getMancc()); v.add(b.getTenncc()); v.add(b.getDiachi());v.add(b.getSdt());
            tblDatancc.add(v);
        }
        table_ncc.setModel(new DefaultTableModel(tblDatancc, tblTitlencc));
    }
    //===================================================================================================================================================================================
    public void bangphieunhap(){
        tblTitlenhaphang.add("Mã hóa đơn nhập"); tblTitlenhaphang.add("Ngày nhập hàng"); tblTitlenhaphang.add("Mã nhà cung cấp"); tblTitlenhaphang.add("Mã nhân viên");tblTitlenhaphang.add("Tổng tiền");
    }
    
    public void laydulieuphieunhap(ArrayList<HoaDonNhap> dshdn){
        tblDatanhaphang.removeAllElements();
        for(HoaDonNhap b : dshdn){
            Vector v = new Vector();
             v.add(b.getMahdn());v.add(b.getNgaynhap()); v.add(b.getMancc());v.add(b.getManv());v.add(b.getTongtien());
            tblDatanhaphang.add(v);
        }
        table_hdnhap.setModel(new DefaultTableModel(tblDatanhaphang, tblTitlenhaphang));
    }
    //===================================================================================================================================================================================
     public void bangsanpham(){
        tblTitlesanpham.add("Mã sản phẩm"); tblTitlesanpham.add("Tên sản phẩm"); tblTitlesanpham.add("Mã nhà cc"); tblTitlesanpham.add("Loại sản phẩm"); tblTitlesanpham.add("Số lượng"); tblTitlesanpham.add("Giá tiền");
    }
    
    public void laydulieusanpham(ArrayList<SanPham> dssp){
        tblDatasanpham.removeAllElements();
        for(SanPham b : dssp){
            Vector v = new Vector();
            v.add(b.getMasp()); v.add(b.getTensp()); v.add(b.getMancc());v.add(b.getLoaisp()); v.add(b.getSoluong()); v.add(b.getGiatien());
            tblDatasanpham.add(v);
        }
        table_sanpham.setModel(new DefaultTableModel(tblDatasanpham, tblTitlesanpham));
    }
    //===================================================================================================================================================================================
     public void bangctnhaphang(){
        tblTitlectnhaphang.add("Mã chi tiết DH nhập"); tblTitlectnhaphang.add("Mã hóa đơn nhâp "); tblTitlectnhaphang.add("Mã sản phẩm"); tblTitlectnhaphang.add("Số lượng nhập"); tblTitlectnhaphang.add("Đơn giá nhập"); tblTitlectnhaphang.add("Thành tiền");
    }
    
    public void laydulieuctnhaphang(ArrayList<ChiTietHoaDonNhap> dscthdn){
        tblDatactnhaphang.removeAllElements();
        for(ChiTietHoaDonNhap b : dscthdn){
            Vector v = new Vector();
            v.add(b.getMacthdn()); v.add(b.getMahdn()); v.add(b.getMasp());v.add(b.getSoluongnhap()); v.add(b.getDongianhap()); v.add(b.getThanhtien());
            tblDatactnhaphang.add(v);
        }
        table_cthoadonnhap.setModel(new DefaultTableModel(tblDatactnhaphang, tblTitlectnhaphang));
    }
        //===================================================================================================================================================================================
     public void bangxuatdsctnhaphang(){
        tblTitlexuatdsctnhaphang.add("Mã chi tiết DH nhập"); tblTitlexuatdsctnhaphang.add("Mã hóa đơn nhâp "); tblTitlexuatdsctnhaphang.add("Mã sản phẩm"); tblTitlexuatdsctnhaphang.add("Số lượng nhập"); tblTitlexuatdsctnhaphang.add("Đơn giá nhập"); tblTitlexuatdsctnhaphang.add("Thành tiền");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_dsnv = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_ncc = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_hdnhap = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        hdn_txt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ngaynhap_txt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tenncc_txt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        mncc_txt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tennv_txt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        mnv_txt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tongtien_txt = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_sanpham = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_cthoadonnhap = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        mcthd_txt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        mhdn2_txt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tensp2_txt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        msp2_txt = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        soluong_txt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        gianhap_txt = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        thanhtien_txt = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        hdn_txt1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        ngaynhap_txt1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        tenncc_txt1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        mncc_txt1 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        tennv_txt1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        mnv_txt1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        tongtien_txt1 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_xuat_ds_cthoadon = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        table_dsnv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_dsnv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_dsnvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_dsnv);

        table_ncc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_ncc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_nccMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_ncc);

        table_hdnhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_hdnhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_hdnhapMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_hdnhap);

        jLabel1.setText("Danh sách nhân viên");

        jLabel2.setText("Danh sách nhà cung cấp");

        jLabel3.setText("Danh sách hóa đơn nhập");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane2)
            .addComponent(jScrollPane3)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(729, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Mã hóa đơn nhập");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 41, -1, -1));
        jPanel4.add(hdn_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 38, 265, -1));

        jLabel5.setText("Ngày nhập hàng");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 70, -1, -1));
        jPanel4.add(ngaynhap_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 67, 265, -1));

        jLabel6.setText("Tên nhà cung cấp");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 99, -1, -1));
        jPanel4.add(tenncc_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 96, 265, -1));

        jLabel7.setText("Mã nhà cung cấp");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 128, -1, -1));
        jPanel4.add(mncc_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 125, 265, -1));

        jLabel8.setText("Tên nhân viên");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 157, -1, -1));
        jPanel4.add(tennv_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 154, 265, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image_icon/Create.png"))); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 269, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image_icon/Delete.png"))); // NOI18N
        jButton2.setText("Xóa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 269, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image_icon/Edit.png"))); // NOI18N
        jButton3.setText("Sửa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 269, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image_icon/Trash.png"))); // NOI18N
        jButton4.setText("Clean");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 269, -1, -1));

        jLabel9.setText("Mã nhân viên");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 186, -1, -1));
        jPanel4.add(mnv_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 183, 265, -1));

        jLabel10.setText("Tổng tiền");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 215, -1, -1));
        jPanel4.add(tongtien_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 212, 265, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("HÓA ĐƠN NHẬP", jPanel1);

        table_sanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_sanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_sanphamMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(table_sanpham);

        jLabel11.setText("Danh sách sản phẩm");

        jLabel12.setText("Danh sách chi tiết hóa đơn nhập hàng");

        table_cthoadonnhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_cthoadonnhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_cthoadonnhapMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(table_cthoadonnhap);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane5)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel13.setText("Mã chi tiết hóa đơn");

        jLabel14.setText("Mã hóa đơn nhập");

        jLabel15.setText("Tên sản phẩm");

        jLabel16.setText("Mã sản phẩm");

        jLabel17.setText("Số lượng");

        jLabel18.setText("Đơn giá nhập");

        jLabel19.setText("Thành tiền");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image_icon/Create.png"))); // NOI18N
        jButton5.setText("Thêm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image_icon/Delete.png"))); // NOI18N
        jButton6.setText("Xóa");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image_icon/Edit.png"))); // NOI18N
        jButton7.setText("Sửa");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image_icon/Trash.png"))); // NOI18N
        jButton8.setText("Clean");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Tính");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mhdn2_txt)
                            .addComponent(mcthd_txt)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel15))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thanhtien_txt))
                            .addComponent(gianhap_txt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(soluong_txt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(msp2_txt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tensp2_txt, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addGap(7, 7, 7)
                .addComponent(jButton8)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(mcthd_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(mhdn2_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(tensp2_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(msp2_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(soluong_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(gianhap_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(thanhtien_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9))
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("CHI TIẾT HÓA ĐƠN NHẬP", jPanel2);

        jLabel21.setText("Mã hóa đơn nhập");

        jLabel22.setText("Ngày nhập hàng");

        jLabel23.setText("Tên nhà cung cấp");

        jLabel24.setText("Mã nhà cung cấp");

        jLabel25.setText("Tên nhân viên");

        jLabel26.setText("Mã nhân viên");

        jLabel27.setText("Tổng tiền");

        table_xuat_ds_cthoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(table_xuat_ds_cthoadon);

        jLabel28.setText("Danh sách chi tiết");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(34, 34, 34)
                        .addComponent(hdn_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ngaynhap_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(32, 32, 32)
                        .addComponent(tenncc_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mncc_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tennv_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mnv_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tongtien_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel21))
                            .addComponent(hdn_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(ngaynhap_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel23))
                            .addComponent(tenncc_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(mncc_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(tennv_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(mnv_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(tongtien_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(153, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("XUẤT HÓA ĐƠN", jPanel7);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 51));
        jLabel20.setText("Quản lý nhập hàng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(519, 519, 519)
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

     public Boolean KiemTraTXTHoaDonNhap(){
        if(ngaynhap_txt.getText().equals("")|| mncc_txt.getText().equals("")|| mnv_txt.getText().equals("") ){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Thông báo", 2);
            return false;
        }
        return true;
    }
     public Boolean KiemTraTXTCTHoaDonNhap(){
        if( msp2_txt.getText().equals("")|| soluong_txt.getText().equals("")|| gianhap_txt.getText().equals("") ){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Thông báo", 2);
            return false;
        }
        return true;
    }
    public Boolean KiemTraTinhTien(){
        int a,b,c,d;
        a = Integer.parseInt(soluong_txt.getText());
        b = Integer.parseInt(gianhap_txt.getText());
        d = Integer.parseInt(thanhtien_txt.getText());
        c=a*b;
        
        if(c!=d){
            JOptionPane.showMessageDialog(this, "Vui lòng nhấn [TÍNH] do thành tiền không bằng số lượng nhân đơn giá ", "Thông báo", 2);
            return false;
        }
        return true;
    }
    private void table_dsnvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_dsnvMouseClicked
        // TODO add your handling code here:
        int i = table_dsnv.getSelectedRow();
        String manv = table_dsnv.getValueAt(i, 0).toString().trim();
        String tennv = table_dsnv.getValueAt(i, 1).toString().trim();
        tennv_txt.setText(tennv);
        mnv_txt.setText(manv);
    }//GEN-LAST:event_table_dsnvMouseClicked

    private void table_nccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_nccMouseClicked
        // TODO add your handling code here:
        int i = table_ncc.getSelectedRow();
        String mancc = table_ncc.getValueAt(i, 0).toString().trim();
        String tenncc = table_ncc.getValueAt(i, 1).toString().trim();
        tenncc_txt.setText(tenncc);
        mncc_txt.setText(mancc);
    }//GEN-LAST:event_table_nccMouseClicked

    private void table_hdnhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_hdnhapMouseClicked
        // TODO add your handling code here:
        int i = table_hdnhap.getSelectedRow();
        String mahdn = table_hdnhap.getValueAt(i, 0).toString().trim();
        String ngaynhap = table_hdnhap.getValueAt(i, 1).toString().trim();
        String mancc = table_hdnhap.getValueAt(i, 2).toString().trim();
        String manv = table_hdnhap.getValueAt(i, 3).toString().trim();
        String tongtien = table_hdnhap.getValueAt(i, 4).toString().trim();

        hdn_txt.setText(mahdn);
        ngaynhap_txt.setText(ngaynhap);
        mncc_txt.setText(mancc);
        mnv_txt.setText(manv);
        tongtien_txt.setText(tongtien);
        mhdn2_txt.setText(mahdn);

        hdn_txt1.setText(mahdn);
        ngaynhap_txt1.setText(ngaynhap);
        mncc_txt1.setText(mancc);
        mnv_txt1.setText(manv);
        tongtien_txt1.setText(tongtien);

        ArrayList<NhanVien> dsttctnv = NhanVienDAO.TimChiTietNhanVien(manv+"");
        for(NhanVien b : dsttctnv){

            tennv_txt.setText( b.getHoten());
            tennv_txt1.setText( b.getHoten());
        }
        ArrayList<NhaCC> dsttctncc = NhaCCDAO.TimChiTietNCC(mancc+"");
        for(NhaCC b : dsttctncc){

            tenncc_txt.setText( b.getTenncc());
            tenncc_txt1.setText( b.getTenncc());
        }

        ArrayList<ChiTietHoaDonNhap> dsttctpn = NhapHangDAO.TimChiTietHoaDonNhap(mahdn);
        tblDataxuatdsctnhaphang.removeAllElements();
        for(ChiTietHoaDonNhap b : dsttctpn){
            Vector v = new Vector();
            v.add(b.getMacthdn()); v.add(b.getMahdn()); v.add(b.getMasp());v.add(b.getSoluongnhap()); v.add(b.getDongianhap()); v.add(b.getThanhtien());
            tblDataxuatdsctnhaphang.add(v);
        }
        table_xuat_ds_cthoadon.setModel(new DefaultTableModel(tblDataxuatdsctnhaphang, tblTitlexuatdsctnhaphang));

    }//GEN-LAST:event_table_hdnhapMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(KiemTraTXTHoaDonNhap()  ){
            if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thêm không?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                String sql = "insert into hoadonnhap( ngaynhap, mancc,manv,tongtien) values ( N'"+ngaynhap_txt.getText().trim()+"', N'"+mncc_txt.getText().trim()+"', N'"+mnv_txt.getText().trim()+"','0')";
                int kq = NhapHangDAO.ThemXoaSuaDSHDN(sql);
                if(kq!=-1)
                {
                    dshdn = NhapHangDAO.getDSHDN();
                    laydulieuphieunhap(dshdn);
                   
                }
                else
                JOptionPane.showMessageDialog(this, "Mã hóa đơn này đã tồn tại hoặc lỗi không thể thêm", "Thông báo", 2);

            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int i = table_hdnhap.getSelectedRow();

        if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa không?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            String sql = "delete from hoadonnhap where mahdn = '"+hdn_txt.getText().trim()+"'";
            if(NhapHangDAO.ThemXoaSuaDSHDN(sql)!=-1)
            {
                dshdn = NhapHangDAO.getDSHDN();
                laydulieuphieunhap(dshdn);
            }
            else
            JOptionPane.showMessageDialog(this, "Dữ liệu này đang được sử dụng, không thể xóa", "Thông báo", 2);

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String mancc = mncc_txt.getText().trim();
        String manv = mnv_txt.getText().trim();
        String mahdn = hdn_txt.getText().trim();
        if(KiemTraTXTHoaDonNhap()){
            if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa không?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                 String sql = "update HoaDonNhap set mancc='"+mancc+"',manv='"+manv+"' where mahdn='"+mahdn+"'";
                
                NhapHangDAO.ThemXoaSuaDSHDN(sql);
                dshdn = NhapHangDAO.getDSHDN();
                laydulieuphieunhap(dshdn);
            }
            else
            JOptionPane.showMessageDialog(this, "Lỗi không thề sửa", "Thông báo", 2);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        hdn_txt.setText("");
        ngaynhap_txt.setText("");
        mncc_txt.setText("");
        mnv_txt.setText("");
        tongtien_txt.setText("");
        tenncc_txt.setText("");
        tennv_txt.setText("");
        ngaynhap_txt.setText(java.time.LocalDate.now()+"");

    }//GEN-LAST:event_jButton4ActionPerformed

    private void table_sanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_sanphamMouseClicked
        // TODO add your handling code here:
        int i = table_sanpham.getSelectedRow();
        String masp = table_sanpham.getValueAt(i, 0).toString().trim();
        String tensp = table_sanpham.getValueAt(i, 1).toString().trim();
        msp2_txt.setText(masp);
        tensp2_txt.setText(tensp);

    }//GEN-LAST:event_table_sanphamMouseClicked

    private void table_cthoadonnhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_cthoadonnhapMouseClicked
        // TODO add your handling code here:
        int i = table_cthoadonnhap.getSelectedRow();
        String macthdn = table_cthoadonnhap.getValueAt(i, 0).toString().trim();
        String mahdn = table_cthoadonnhap.getValueAt(i, 1).toString().trim();
        String masp = table_cthoadonnhap.getValueAt(i, 2).toString().trim();
        String soluong = table_cthoadonnhap.getValueAt(i, 3).toString().trim();
        String dongia = table_cthoadonnhap.getValueAt(i, 4).toString().trim(); 
        String thanhtien = table_cthoadonnhap.getValueAt(i, 5).toString().trim();
        
        mcthd_txt.setText(macthdn);
        mhdn2_txt.setText(mahdn);
        msp2_txt.setText(masp);
        soluong_txt.setText(soluong);
        gianhap_txt.setText(dongia);
        thanhtien_txt.setText(thanhtien);

        ArrayList<SanPham> dsttctsp = SanPhamDAO.TimChiTietSanPham(masp);
        for(SanPham b : dsttctsp){

            tensp2_txt.setText( b.getTensp());

        }
    }//GEN-LAST:event_table_cthoadonnhapMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if(KiemTraTXTCTHoaDonNhap()&&KiemTraTinhTien()){
            if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thêm không?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                String sql = "insert into ChiTietHoaDonNhap( mahdn,masp,soluongnhap,dongianhap,thanhtien) values ( N'"+mhdn2_txt.getText().trim()+"', N'"+msp2_txt.getText().trim()+"', N'"+soluong_txt.getText().trim()+"', N'"+gianhap_txt.getText().trim()+"', N'"+thanhtien_txt.getText().trim()+"')";
                int kq = NhapHangDAO.ThemXoaSuaDSCTHDN(sql);
                if(kq!=-1)
                {
                    dscthdn = NhapHangDAO.getDSCTHDN();
                    laydulieuctnhaphang(dscthdn);
                    dshdn = NhapHangDAO.getDSHDN();
                    laydulieuphieunhap(dshdn);
                    dssp= SanPhamDAO.getDSSP();
                    laydulieusanpham(dssp);
                   
                }
                else
                JOptionPane.showMessageDialog(this, "Mã chi tiết hóa đơn này đã tồn tại hoặc lỗi không thể thêm", "Thông báo", 2);

            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int i = table_cthoadonnhap.getSelectedRow();

        if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa không?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            String sql = "delete from ChiTietHoaDonNhap where macthdn = '"+mcthd_txt.getText().trim()+"'";
            if(NhapHangDAO.ThemXoaSuaDSCTHDN(sql)!=-1)
            {
                dscthdn = NhapHangDAO.getDSCTHDN();
                laydulieuctnhaphang(dscthdn);
                 dshdn = NhapHangDAO.getDSHDN();
                    laydulieuphieunhap(dshdn);
            }
            else
            JOptionPane.showMessageDialog(this, "Dữ liệu này đang được sử dụng hoặc lỗi, không thể xóa", "Thông báo", 2);

        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        String masp=msp2_txt.getText().trim();
        String soluongnhap=soluong_txt.getText().trim();
        String dongianhap=gianhap_txt.getText().trim();
        String thanhtien=thanhtien_txt.getText().trim();
        String macthdn=mcthd_txt.getText().trim();
        if(KiemTraTXTCTHoaDonNhap()&&KiemTraTinhTien()){
            if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa không?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                String sql = "update ChiTietHoaDonNhap set masp='"+masp+"',soluongnhap='"+soluongnhap+"', dongianhap='"+dongianhap+"',thanhtien='"+thanhtien+"' where macthdn='"+macthdn+"'";
                NhapHangDAO.ThemXoaSuaDSCTHDN(sql);          
                dscthdn = NhapHangDAO.getDSCTHDN();
                laydulieuctnhaphang(dscthdn);
                dshdn = NhapHangDAO.getDSHDN();
                laydulieuphieunhap(dshdn);
            }
            else
            JOptionPane.showMessageDialog(this, "Lỗi không thề sửa", "Thông báo", 2);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        mcthd_txt.setText("");
        mhdn2_txt.setText("");
        tensp2_txt.setText("");
        msp2_txt.setText("");
        soluong_txt.setText("");
        gianhap_txt.setText("");
        thanhtien_txt.setText("");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        int a,b,c;
        a = Integer.parseInt(soluong_txt.getText());
        b = Integer.parseInt(gianhap_txt.getText());
        c=a*b;
        thanhtien_txt.setText(c+"");
    }//GEN-LAST:event_jButton9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField gianhap_txt;
    private javax.swing.JTextField hdn_txt;
    private javax.swing.JTextField hdn_txt1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField mcthd_txt;
    private javax.swing.JTextField mhdn2_txt;
    private javax.swing.JTextField mncc_txt;
    private javax.swing.JTextField mncc_txt1;
    private javax.swing.JTextField mnv_txt;
    private javax.swing.JTextField mnv_txt1;
    private javax.swing.JTextField msp2_txt;
    private javax.swing.JTextField ngaynhap_txt;
    private javax.swing.JTextField ngaynhap_txt1;
    private javax.swing.JTextField soluong_txt;
    private javax.swing.JTable table_cthoadonnhap;
    private javax.swing.JTable table_dsnv;
    private javax.swing.JTable table_hdnhap;
    private javax.swing.JTable table_ncc;
    private javax.swing.JTable table_sanpham;
    private javax.swing.JTable table_xuat_ds_cthoadon;
    private javax.swing.JTextField tenncc_txt;
    private javax.swing.JTextField tenncc_txt1;
    private javax.swing.JTextField tennv_txt;
    private javax.swing.JTextField tennv_txt1;
    private javax.swing.JTextField tensp2_txt;
    private javax.swing.JTextField thanhtien_txt;
    private javax.swing.JTextField tongtien_txt;
    private javax.swing.JTextField tongtien_txt1;
    // End of variables declaration//GEN-END:variables
}
