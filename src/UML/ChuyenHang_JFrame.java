/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import Dao.ChungTuCTDAO;
import Dao.ChungTuDAO;
import Help.Auth;
import static Help.ColorHelper.*;
import Help.DateHelper;
import Help.DialogHelper;
import static Help.ImageHelper.*;
import java.awt.Color;
import static Help.ValidateHelper.*;
import Model.ChungTu;
import Model.ChungTuCT;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class ChuyenHang_JFrame extends javax.swing.JFrame {

    /**
     * Creates new form ChuyenHang_JFrame
     */
    public ChuyenHang_JFrame() {
        initComponents();
        init();
        loadDonHangDuyet();
        lblDem.setText(String.valueOf(daoChungTu.countChuaDuyetDonHang()));
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    int sl = Integer.parseInt(lblDem.getText());
                    if (sl > daoChungTu.countChuaDuyetDonHang() || sl < daoChungTu.countChuaDuyetDonHang()) {
                        loadDonHangDuyet();
                        lblDem.setText(String.valueOf(daoChungTu.countChuaDuyetDonHang()));
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ChuyenHang_JFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        };
        thread.start();

    }

    ChungTuDAO daoChungTu = new ChungTuDAO();
    ChungTuCTDAO daoChungTuCT = new ChungTuCTDAO();
    int index = -1;

    void init() {
        designTable(false, new Color(0, 102, 255), Color.white, Plain, tblXemChiTiet);
        designTable(false, new Color(0, 102, 255), Color.white, Plain, tblDonHang);
        pnlTongDonHang.setBackground(new Color(0,0,0,0)); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        lblTieuDe = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblHuyHang = new javax.swing.JLabel();
        lblTaoPhieu = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblXemChiTiet = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDonHang = new javax.swing.JTable();
        pnlTongDonHang = new RoundedPanel(50,new Color(255, 102, 102));
        lblDem = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        kGradientPanel1.setkEndColor(new java.awt.Color(102, 153, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(51, 51, 255));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1200, 80));
        kGradientPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                kGradientPanel1MouseDragged(evt);
            }
        });
        kGradientPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                kGradientPanel1MousePressed(evt);
            }
        });
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTieuDe.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(255, 255, 255));
        lblTieuDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logo.png"))); // NOI18N
        lblTieuDe.setText("Chuy???n h??ng");
        kGradientPanel1.add(lblTieuDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 19, -1, -1));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Backs.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });
        kGradientPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 10, 70, 50));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 80));

        kGradientPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        kGradientPanel2.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("UVN Bai Sau Nang", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tr???ng th??i ????n");
        kGradientPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("UVN Van Chuong Nang", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 0));
        jLabel4.setText("????n ?????t h??ng");
        kGradientPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        lblHuyHang.setBackground(new java.awt.Color(255, 255, 255));
        lblHuyHang.setFont(new java.awt.Font("UVN Chim Bien", 0, 24)); // NOI18N
        lblHuyHang.setForeground(new java.awt.Color(255, 153, 0));
        lblHuyHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHuyHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/cancel.png"))); // NOI18N
        lblHuyHang.setText("H???y h??ng");
        lblHuyHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        lblHuyHang.setOpaque(true);
        lblHuyHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHuyHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHuyHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHuyHangMouseExited(evt);
            }
        });
        kGradientPanel2.add(lblHuyHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 293, 160, 40));

        lblTaoPhieu.setBackground(new java.awt.Color(255, 255, 255));
        lblTaoPhieu.setFont(new java.awt.Font("UVN Chim Bien", 0, 24)); // NOI18N
        lblTaoPhieu.setForeground(new java.awt.Color(255, 153, 0));
        lblTaoPhieu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTaoPhieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/dukien.png"))); // NOI18N
        lblTaoPhieu.setText("????ng g??i h??ng");
        lblTaoPhieu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        lblTaoPhieu.setOpaque(true);
        lblTaoPhieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTaoPhieuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTaoPhieuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblTaoPhieuMouseExited(evt);
            }
        });
        kGradientPanel2.add(lblTaoPhieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 293, 220, 40));

        tblXemChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "M?? ????n h??ng", "M?? s???n ph???m", "T??n s???n ph???m", "Lo???i s???n ph???m", "Gi??", "S??? L?????ng", "????n v??? t??nh", "T??n nh?? cung c???p", "M?? L?? H??ng", "Ng??y nh???p", "H??nh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblXemChiTiet.setRowHeight(25);
        tblXemChiTiet.setSelectionBackground(new java.awt.Color(255, 153, 153));
        tblXemChiTiet.setShowGrid(true);
        tblXemChiTiet.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tblXemChiTiet);

        kGradientPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 341, 1261, 217));

        jLabel6.setFont(new java.awt.Font("UVN Van Chuong Nang", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 0));
        jLabel6.setText("Xem chi ti???t");
        kGradientPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 303, -1, -1));

        tblDonHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "M?? ????n h??ng", "T??n nh??n vi??n", "Lo???i ch???ng t???", "Ng??y t???o", "Tr???ng th??i", "M?? kh??ch h??ng", "T???ng ti???n"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDonHang.setRowHeight(25);
        tblDonHang.setSelectionBackground(new java.awt.Color(255, 102, 153));
        tblDonHang.setShowVerticalLines(false);
        tblDonHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDonHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDonHang);

        kGradientPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 48, 786, 240));

        pnlTongDonHang.setBackground(new java.awt.Color(255, 102, 102));
        pnlTongDonHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDem.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblDem.setForeground(new java.awt.Color(255, 255, 255));
        lblDem.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDem.setText("135");
        pnlTongDonHang.add(lblDem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("????n h??ng");
        pnlTongDonHang.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 220, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("T???ng ????n h??ng");
        pnlTongDonHang.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 297, 67));

        kGradientPanel2.add(pnlTongDonHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 50, 450, 230));

        getContentPane().add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1290, 570));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void kGradientPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MouseDragged
        MouseDragged(evt, this);
    }//GEN-LAST:event_kGradientPanel1MouseDragged

    private void kGradientPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MousePressed
        moveFrom(evt);
    }//GEN-LAST:event_kGradientPanel1MousePressed

    private void lblTaoPhieuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTaoPhieuMouseEntered
        lblTaoPhieu.setBackground(new Color(255, 153, 0));
        lblTaoPhieu.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblTaoPhieuMouseEntered

    private void lblTaoPhieuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTaoPhieuMouseExited
        lblTaoPhieu.setBackground(Color.WHITE);
        lblTaoPhieu.setForeground(new Color(255, 153, 0));
    }//GEN-LAST:event_lblTaoPhieuMouseExited

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        jLabel10.setIcon(Back2);
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        jLabel10.setIcon(Back1);
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void tblDonHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDonHangMouseClicked
        // TODO add your handling code here:
        index = tblDonHang.getSelectedRow();
        loadDonHangCT();
    }//GEN-LAST:event_tblDonHangMouseClicked

    private void lblHuyHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHuyHangMouseEntered
        lblHuyHang.setBackground(new Color(255, 153, 0));
        lblHuyHang.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblHuyHangMouseEntered

    private void lblHuyHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHuyHangMouseExited
        lblHuyHang.setBackground(Color.WHITE);
        lblHuyHang.setForeground(new Color(255, 153, 0));
    }//GEN-LAST:event_lblHuyHangMouseExited

    private void lblTaoPhieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTaoPhieuMouseClicked
        // TODO add your handling code here:
        index = tblDonHang.getSelectedRow();
        if (index != -1) {
            insert();
        } else {
            DialogHelper.alert(null, "Vui l??ng ch???n ????n h??ng");
        }
    }//GEN-LAST:event_lblTaoPhieuMouseClicked

    private void lblHuyHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHuyHangMouseClicked
        // TODO add your handling code here:
        index = tblDonHang.getSelectedRow();
        if (index != -1) {
            delete();
        } else {
            DialogHelper.alert(null, "Vui l??ng ch???n ????n h??ng");
        }
    }//GEN-LAST:event_lblHuyHangMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Window".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChuyenHang_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChuyenHang_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChuyenHang_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChuyenHang_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChuyenHang_JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel lblDem;
    private javax.swing.JLabel lblHuyHang;
    private javax.swing.JLabel lblTaoPhieu;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JPanel pnlTongDonHang;
    private javax.swing.JTable tblDonHang;
    private javax.swing.JTable tblXemChiTiet;
    // End of variables declaration//GEN-END:variables

    void loadDonHangDuyet() {
        DefaultTableModel model = (DefaultTableModel) tblDonHang.getModel();
        model.setRowCount(0);
        List<ChungTu> list = daoChungTu.selectDuyetDonHang();
        for (ChungTu ct : list) {
            Object[] ob = {ct.getMaChungTu(), ct.getTenDangNhap(), ct.getLoaiChungTu(), ct.getNgayTao(), ct.getTrangThai(), ct.getMaKH(), ct.getTongTien()};
            model.addRow(ob);
        }
    }

    void loadDonHangCT() {
        DefaultTableModel model = (DefaultTableModel) tblXemChiTiet.getModel();
        model.setRowCount(0);
        String mct = String.valueOf(tblDonHang.getValueAt(index, 0));
        List<ChungTuCT> list = daoChungTuCT.selectByConditions(mct);
        for (ChungTuCT ct : list) {
            Object[] ob = {ct.getMaChungTu(), ct.getMaSP(),
                ct.getTenSP(), ct.getLoaiSP(),
                ct.getGia(), ct.getSoLuong(),
                ct.getDonViTinh(), ct.getTenNCC(),
                ct.getMaLoHang(), ct.getNgayNhap(),
                ct.getHinh()};
            model.addRow(ob);
        }
    }

    ChungTu getModelDonHang() {
        ChungTu ct = new ChungTu();
        ct.setTenDangNhap(Auth.user.getTenDn());
        ct.setLoaiChungTu("Xu???t h??ng");
        ct.setNgayTao(DateHelper.toDate(String.valueOf(tblDonHang.getValueAt(index, 3))));
        ct.setTrangThai("Ch??? duy???t");
        ct.setMaKH(String.valueOf(tblDonHang.getValueAt(index, 5)));
        ct.setNguoiDuyet(null);
        ct.setTongTien(Double.parseDouble(String.valueOf(tblDonHang.getValueAt(index, 6))));
        return ct;
    }

    void insert() {
        String maDH = String.valueOf(tblDonHang.getValueAt(index, 0));
        if (DialogHelper.confirm(null, "B???n c?? mu???n ????ng g??i ????n " + maDH + " kh??ng?")) {
            ChungTu ct = getModelDonHang();
            String maCT = daoChungTu.insert(ct);
            int count = tblXemChiTiet.getRowCount();
            if (maCT != null) {
                for (int i = 0; i < count; i++) {
                    ChungTuCT ctt = new ChungTuCT();
                    ctt.setMaChungTu(maCT);
                    ctt.setMaSP(String.valueOf(tblXemChiTiet.getValueAt(i, 1)));
                    ctt.setTenSP(String.valueOf(tblXemChiTiet.getValueAt(i, 2)));
                    ctt.setLoaiSP(Integer.parseInt(String.valueOf(tblXemChiTiet.getValueAt(i, 3))));
                    ctt.setGia(Double.parseDouble(String.valueOf(tblXemChiTiet.getValueAt(i, 4))));
                    ctt.setSoLuong(Integer.parseInt(String.valueOf(tblXemChiTiet.getValueAt(i, 5))));
                    ctt.setDonViTinh(String.valueOf(tblXemChiTiet.getValueAt(i, 6)));
                    ctt.setTenNCC(String.valueOf(tblXemChiTiet.getValueAt(i, 7)));
                    ctt.setMaLoHang(String.valueOf(tblXemChiTiet.getValueAt(i, 8)));
                    ctt.setNgayNhap(DateHelper.toDate(String.valueOf(tblXemChiTiet.getValueAt(i, 9))));
                    ctt.setHinh(String.valueOf(tblXemChiTiet.getValueAt(i, 10)));
                    ctt.setMoTa(null);
                    if (daoChungTuCT.insert(ctt) == 0) {
                        DialogHelper.alert(null, "Th??m th???t b???i");
                        break;
                    }
                }

                DefaultTableModel model = (DefaultTableModel) tblXemChiTiet.getModel();
                model.setRowCount(0);
                if (daoChungTu.update("???? duy???t", Auth.user.getTenDn(), maDH) == 1) {
                    DialogHelper.alert(null, "Th??m th??nh c??ng");
                }
            }
        }
    }

    //X??a ????n h??ng
    void delete() {
        String mct = String.valueOf(tblDonHang.getValueAt(index, 0));
        if (DialogHelper.confirm(null, "B???n c?? mu???n x??a ????n c?? m?? \n" + mct + " kh??ng ?")) {
            if (daoChungTu.delete(mct) == 1) {
                DefaultTableModel model = (DefaultTableModel) tblXemChiTiet.getModel();
                model.setRowCount(0);
                DialogHelper.alert(null, "X??a ????n th??nh c??ng");
            } else {
                DialogHelper.alert(null, "X??a ????n th???t b???i");
            }
        }
    }
       class RoundedPanel extends JPanel {

        private Color backgroundColor;
        private int cornerRadius = 15;

        public RoundedPanel(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
        }

        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        public RoundedPanel(int radius) {
            super();
            cornerRadius = radius;

        }

        public RoundedPanel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); //paint background
            graphics.setColor(getForeground());
//            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
//             
        }
    }
}
