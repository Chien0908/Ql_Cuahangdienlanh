/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.DanhMucBean;
import form_view.BanHangJPanel;
import form_view.BanHang_form;
import form_view.NhaCCJPanel;
import form_view.NhaCC_form;
import form_view.NhanVienJPanel;
import form_view.NhanVien_form;
import form_view.NhapHangJPanel;
import form_view.NhapHang_form;
import form_view.SanPhamJPanel;
import form_view.SanPham_form;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Administrator-PC
 */
public class ChuyenManHinhController {
    private JPanel root;
    private String kinSelect = "";
    
    
    private List<DanhMucBean> listItem = null;
    
    public ChuyenManHinhController(JPanel jpnRoot)
    {
        this.root = jpnRoot;
    }
    public void setView(JPanel jpn, JLabel jlb)
    {
        kinSelect = "BanHang";
        jpn.setBackground(new Color(96,100,191));
        jlb.setBackground(new Color(96,100,191));
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new BanHangJPanel());
        root.validate();
        root.repaint();
    }
    
    public void setEvent(List<DanhMucBean> listItem)
    {
        this.listItem = listItem;
        for(DanhMucBean item : listItem)
        {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    class LabelEvent implements MouseListener{
        private JPanel node;
        private String kind;
        
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind){
                case "BanHang":
                    node = new BanHangJPanel();
                    break;
                case "SanPham":
                    node = new SanPhamJPanel();
                    break;
                case "NhaCungCap":
                    node = new NhaCCJPanel();
                    break;
                case "NhapHang":
                    node = new NhapHangJPanel();
                    break;
                case "NhanVien":
                    node =  new NhanVienJPanel();
                    break;    
                 default:
                    node = new BanHangJPanel();
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kinSelect = kind;
            jlbItem.setBackground(new Color(96,100,191));
            jpnItem.setBackground(new Color(96,100,191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jlbItem.setBackground(new Color(96,100,191));
            jpnItem.setBackground(new Color(96,100,191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
           jlbItem.setBackground(new Color(76,175,80));
           jpnItem.setBackground(new Color(76,175,80));
        }
         private void setChangeBackground(String kind)
        {
            for(DanhMucBean item : listItem){
                if(item.getKind().equalsIgnoreCase(kind)){
                     item.getJlb().setBackground(new Color(96,100,191));
                     item.getJpn().setBackground(new Color(96,100,191));
                }
                else{
                    item.getJlb().setBackground(new Color(76,175,80));
                    item.getJpn().setBackground(new Color(76,175,80));
                }
            }
        }

    }  

       
}
