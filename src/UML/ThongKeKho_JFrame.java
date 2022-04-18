package UML;

import Dao.TaiKhoanDAO;
import Dao.ThongKeDAO;
import static Help.ColorHelper.MouseDragged;
import static Help.ColorHelper.chooserDefault;
import static Help.ColorHelper.chooserList;
import static Help.ColorHelper.default_border;
import static Help.ColorHelper.designTable;
import static Help.ColorHelper.moveFrom;
import static Help.ColorHelper.white_border;
import static Help.ImageHelper.Close1;
import static Help.ImageHelper.Close2;
import static Help.ValidateHelper.Plain;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author hp
 */
public class ThongKeKho_JFrame extends javax.swing.JFrame {

    CardLayout card;
    Thread th1, th2, th3;

    public ThongKeKho_JFrame(int i) {
        initComponents();
        card = (CardLayout) pnlTab.getLayout();
        card.show(pnlTab, "CardNhapKho");
        if (i == 0) {
            card.show(pnlTab, "CardNhapKho");
            chooserList(new Color(0, 204, 204), lblNhapKho);
            loadNhapKho();
        } else if (i == 1) {
            card.show(pnlTab, "CardXuatKho");
            chooserList(new Color(0, 204, 204), lblXuatKho);
            loadXuatKho(); 
        } else {
            chooserList(new Color(0, 204, 204), lblTonKho);
            card.show(pnlTab, "CardTonKho");
            loadTonKho();
        }

        designTable(false, new Color(153, 51, 255), Color.white, Plain, tblNhapKho);
        designTable(false, new Color(0, 153, 0), Color.white, Plain, tblTonKho);
        designTable(false, new Color(102, 102, 102), Color.white, Plain, tblXuatKho);
       
    }

    private ThongKeKho_JFrame() {
        initComponents();
        init();
        loadNhapKho();
    }

    void init() {
        card = (CardLayout) pnlTab.getLayout();
        card.show(pnlTab, "CardNhapKho");
        with = pnlTabTitle.getWidth();
        chooserList(new Color(0, 204, 204), lblNhapKho);
        designTable(false, new Color(153, 51, 255), Color.white, Plain, tblNhapKho);
        designTable(false, new Color(0, 153, 0), Color.white, Plain, tblTonKho);
        designTable(false, new Color(102, 102, 102), Color.white, Plain, tblXuatKho);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pnlTab = new keeptoo.KGradientPanel();
        pnlCardNhapKho = new keeptoo.KGradientPanel();
        pnl1 = new keeptoo.KGradientPanel();
        pnlNhap = new keeptoo.KGradientPanel();
        pnl2 = new keeptoo.KGradientPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblNhapKho = new javax.swing.JTable();
        pnlCardXuatKho = new keeptoo.KGradientPanel();
        kGradientPanel6 = new keeptoo.KGradientPanel();
        pnlXuat = new keeptoo.KGradientPanel();
        kGradientPanel7 = new keeptoo.KGradientPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblXuatKho = new javax.swing.JTable();
        pnlCardTonKho = new keeptoo.KGradientPanel();
        kGradientPanel8 = new keeptoo.KGradientPanel();
        pnlTonKho = new keeptoo.KGradientPanel();
        kGradientPanel9 = new keeptoo.KGradientPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTonKho = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblThoat = new javax.swing.JLabel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        pnlTabTitle = new keeptoo.KGradientPanel();
        lblTonKho = new javax.swing.JLabel();
        lblNhapKho = new javax.swing.JLabel();
        lblXuatKho = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setUndecorated(true);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(102, 153, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logo.png"))); // NOI18N
        jLabel1.setText("Thống kê kho");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 40));

        pnlTab.setkEndColor(new java.awt.Color(102, 102, 102));
        pnlTab.setkStartColor(new java.awt.Color(204, 204, 204));
        pnlTab.setLayout(new java.awt.CardLayout());

        pnlCardNhapKho.setkEndColor(new java.awt.Color(102, 102, 102));
        pnlCardNhapKho.setkStartColor(new java.awt.Color(204, 204, 204));
        pnlCardNhapKho.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl1.setkEndColor(new java.awt.Color(255, 255, 255));
        pnl1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlNhap.setkEndColor(new java.awt.Color(51, 51, 51));
        pnlNhap.setkStartColor(new java.awt.Color(255, 255, 255));
        pnlNhap.setLayout(new java.awt.BorderLayout());
        pnl1.add(pnlNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 980, 250));

        pnlCardNhapKho.add(pnl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1000, 270));

        pnl2.setkStartColor(new java.awt.Color(255, 255, 255));
        pnl2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblNhapKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Số lượng", "Tổng tiền", "Ngày nhập"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblNhapKho);

        pnl2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 980, 230));

        pnlCardNhapKho.add(pnl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 1000, 250));

        pnlTab.add(pnlCardNhapKho, "CardNhapKho");

        pnlCardXuatKho.setkEndColor(new java.awt.Color(102, 102, 102));
        pnlCardXuatKho.setkStartColor(new java.awt.Color(204, 204, 255));
        pnlCardXuatKho.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel6.setkEndColor(new java.awt.Color(153, 153, 153));
        kGradientPanel6.setkStartColor(new java.awt.Color(102, 102, 102));
        kGradientPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlXuat.setLayout(new java.awt.BorderLayout());
        kGradientPanel6.add(pnlXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 520, 510));

        pnlCardXuatKho.add(kGradientPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 13, 540, 530));

        kGradientPanel7.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel7.setkEndColor(new java.awt.Color(204, 204, 204));
        kGradientPanel7.setkStartColor(new java.awt.Color(204, 204, 204));
        kGradientPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblXuatKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Số lượng", "Tổng tiền", "Ngày xuất"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblXuatKho);

        kGradientPanel7.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 430, 510));

        pnlCardXuatKho.add(kGradientPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 13, 450, 530));

        pnlTab.add(pnlCardXuatKho, "CardXuatKho");

        pnlCardTonKho.setkEndColor(new java.awt.Color(204, 204, 255));
        pnlCardTonKho.setkStartColor(new java.awt.Color(102, 102, 102));
        pnlCardTonKho.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kGradientPanel8MouseClicked(evt);
            }
        });
        kGradientPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTonKho.setkEndColor(new java.awt.Color(204, 204, 204));
        pnlTonKho.setkStartColor(new java.awt.Color(102, 102, 102));
        pnlTonKho.setLayout(new java.awt.BorderLayout());
        kGradientPanel8.add(pnlTonKho, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 970, 300));

        pnlCardTonKho.add(kGradientPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 11, 990, 320));

        kGradientPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblTonKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Số lượng", "Đơn vị tính", "Giá nhâp", "Giá bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblTonKho);

        kGradientPanel9.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 970, 190));

        pnlCardTonKho.add(kGradientPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 990, 210));

        pnlTab.add(pnlCardTonKho, "CardTonKho");

        getContentPane().add(pnlTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 1020, 550));

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblThoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/lblThoat.png"))); // NOI18N
        lblThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThoatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblThoatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblThoatMouseExited(evt);
            }
        });
        jPanel1.add(lblThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 60, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 40));

        kGradientPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                kGradientPanel2MouseEntered(evt);
            }
        });
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTabTitle.setkEndColor(new java.awt.Color(153, 255, 204));
        pnlTabTitle.setkStartColor(new java.awt.Color(102, 153, 255));
        pnlTabTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlTabTitleMouseExited(evt);
            }
        });
        pnlTabTitle.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTonKho.setBackground(new java.awt.Color(255, 102, 255));
        lblTonKho.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTonKho.setForeground(new java.awt.Color(255, 255, 255));
        lblTonKho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTonKho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/tonkho.png"))); // NOI18N
        lblTonKho.setText("Tồn Kho");
        lblTonKho.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        lblTonKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTonKhoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTonKhoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblTonKhoMouseExited(evt);
            }
        });
        pnlTabTitle.add(lblTonKho, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 290, 90));

        lblNhapKho.setBackground(new java.awt.Color(255, 102, 255));
        lblNhapKho.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNhapKho.setForeground(new java.awt.Color(255, 255, 255));
        lblNhapKho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNhapKho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/import.png"))); // NOI18N
        lblNhapKho.setText("Nhập kho");
        lblNhapKho.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        lblNhapKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNhapKhoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblNhapKhoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblNhapKhoMouseExited(evt);
            }
        });
        pnlTabTitle.add(lblNhapKho, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 290, 90));

        lblXuatKho.setBackground(new java.awt.Color(255, 102, 255));
        lblXuatKho.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblXuatKho.setForeground(new java.awt.Color(255, 255, 255));
        lblXuatKho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblXuatKho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/export.png"))); // NOI18N
        lblXuatKho.setText("Xuất kho");
        lblXuatKho.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        lblXuatKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblXuatKhoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblXuatKhoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblXuatKhoMouseExited(evt);
            }
        });
        pnlTabTitle.add(lblXuatKho, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 290, 90));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Quản lý kho hàng của bạn");
        pnlTabTitle.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 510, 150, -1));
        pnlTabTitle.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 530, 140, 20));

        kGradientPanel2.add(pnlTabTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 550));

        getContentPane().add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 290, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblNhapKhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhapKhoMouseClicked
        chooserDefault(null, lblNhapKho, lblTonKho, lblXuatKho);
        chooserList(new Color(0, 204, 204), lblNhapKho);
        card.show(pnlTab, "CardNhapKho");
        loadNhapKho();
    }//GEN-LAST:event_lblNhapKhoMouseClicked

    private void lblXuatKhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXuatKhoMouseClicked
        chooserDefault(null, lblNhapKho, lblTonKho, lblXuatKho);
        chooserList(new Color(0, 204, 204), lblXuatKho);
        card.show(pnlTab, "CardXuatKho");
        loadXuatKho();
    }//GEN-LAST:event_lblXuatKhoMouseClicked

    private void lblTonKhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTonKhoMouseClicked
        chooserDefault(null, lblNhapKho, lblTonKho, lblXuatKho);
        chooserList(new Color(0, 204, 204), lblTonKho);
        card.show(pnlTab, "CardTonKho");
        loadTonKho();
    }//GEN-LAST:event_lblTonKhoMouseClicked
    int x = 0;
    int with;
    private void pnlTabTitleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTabTitleMouseExited


    }//GEN-LAST:event_pnlTabTitleMouseExited
//th2 ra th1 vao
    private void kGradientPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel2MouseEntered


    }//GEN-LAST:event_kGradientPanel2MouseEntered

    private void kGradientPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel8MouseClicked

    }//GEN-LAST:event_kGradientPanel8MouseClicked

    private void lblNhapKhoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhapKhoMouseEntered
        lblNhapKho.setBorder(white_border);
    }//GEN-LAST:event_lblNhapKhoMouseEntered

    private void lblXuatKhoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXuatKhoMouseEntered
        lblXuatKho.setBorder(white_border);
    }//GEN-LAST:event_lblXuatKhoMouseEntered

    private void lblTonKhoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTonKhoMouseEntered
        lblTonKho.setBorder(white_border);
    }//GEN-LAST:event_lblTonKhoMouseEntered

    private void lblNhapKhoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhapKhoMouseExited
        lblNhapKho.setBorder(default_border);
    }//GEN-LAST:event_lblNhapKhoMouseExited

    private void lblXuatKhoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXuatKhoMouseExited
        lblXuatKho.setBorder(default_border);
    }//GEN-LAST:event_lblXuatKhoMouseExited

    private void lblTonKhoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTonKhoMouseExited
        lblTonKho.setBorder(default_border);
    }//GEN-LAST:event_lblTonKhoMouseExited

    private void lblThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseClicked
        dispose();
    }//GEN-LAST:event_lblThoatMouseClicked

    private void lblThoatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseEntered
        lblThoat.setIcon(Close2);
    }//GEN-LAST:event_lblThoatMouseEntered

    private void lblThoatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseExited
        lblThoat.setIcon(Close1);
    }//GEN-LAST:event_lblThoatMouseExited

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        MouseDragged(evt, this);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        moveFrom(evt);
    }//GEN-LAST:event_jPanel1MousePressed

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
            java.util.logging.Logger.getLogger(ThongKeKho_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeKho_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeKho_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeKho_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKeKho_JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel6;
    private keeptoo.KGradientPanel kGradientPanel7;
    private keeptoo.KGradientPanel kGradientPanel8;
    private keeptoo.KGradientPanel kGradientPanel9;
    private javax.swing.JLabel lblNhapKho;
    private javax.swing.JLabel lblThoat;
    private javax.swing.JLabel lblTonKho;
    private javax.swing.JLabel lblXuatKho;
    private keeptoo.KGradientPanel pnl1;
    private keeptoo.KGradientPanel pnl2;
    private keeptoo.KGradientPanel pnlCardNhapKho;
    private keeptoo.KGradientPanel pnlCardTonKho;
    private keeptoo.KGradientPanel pnlCardXuatKho;
    private keeptoo.KGradientPanel pnlNhap;
    private keeptoo.KGradientPanel pnlTab;
    private keeptoo.KGradientPanel pnlTabTitle;
    private keeptoo.KGradientPanel pnlTonKho;
    private keeptoo.KGradientPanel pnlXuat;
    private javax.swing.JTable tblNhapKho;
    private javax.swing.JTable tblTonKho;
    private javax.swing.JTable tblXuatKho;
    // End of variables declaration//GEN-END:variables
    TaiKhoanDAO dao = new TaiKhoanDAO();

    //Hàm tạo chart
    void chart(DefaultTableModel model, JPanel pnl) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < model.getRowCount(); i++) {
            dataset.setValue(Double.parseDouble(String.valueOf(model.getValueAt(i, 2))), "", String.valueOf(model.getValueAt(i, 1)));
        }
        JFreeChart chart = ChartFactory.createBarChart3D("Biểu đồ", "Sản phẩm", "Số lượng", dataset, PlotOrientation.VERTICAL, false, false, false);
        CategoryPlot catPlot = chart.getCategoryPlot();
        catPlot.setRangeGridlinePaint(Color.BLACK);
        ChartPanel chartPanel = new ChartPanel(chart);
        pnl.removeAll();
        pnl.add(chartPanel, BorderLayout.CENTER);
        pnl.validate();
    }

    void Chart3D() {

        DefaultCategoryDataset objDataset = new DefaultCategoryDataset();

        objDataset.setValue(29, "Điện thoại", "Nokia");
        objDataset.setValue(15, "Điện thoại", "HTC");
        objDataset.setValue(24, "Điện thoại", "Samsung");

        objDataset.setValue(22, "Laptop", "Apple");
        objDataset.setValue(18, "Laptop", "HTC");
        objDataset.setValue(25, "Laptop", "Samsung");

        objDataset.setValue(30, "Gia dụng", "Chổi");
        objDataset.setValue(10, "Gia dụng", "Quạt");
        objDataset.setValue(21, "Gia dụng", "Tủ lạnh");
        JFreeChart objChart = ChartFactory.createBarChart3D(
                "Demo Bar Chart", //Chart title
                "Some products", //Domain axis label
                "Market Share", //Range axis label
                objDataset, //Chart Data 
                PlotOrientation.VERTICAL, // orientation
                true, // include legend?
                true, // include tooltips?
                false // include URLs?
        );
    }

    ThongKeDAO daoTK = new ThongKeDAO();

    //Tải toàn bộ dữ liệu xuất kho lên bảng
    void loadNhapKho() {
        DefaultTableModel model = (DefaultTableModel) tblNhapKho.getModel();
        model.setRowCount(0);
        List<Object[]> list = daoTK.getNhapHang();
        for (Object[] ob : list) {
            model.addRow(ob);
        }
        chart(model, pnlNhap);
    }

    //Tải toàn bộ dữ liệu nhập kho lên bảng
    void loadXuatKho() {
        DefaultTableModel model = (DefaultTableModel) tblXuatKho.getModel();
        model.setRowCount(0);
        List<Object[]> list = daoTK.getXuatHang();
        for (Object[] ob : list) {
            model.addRow(ob);
        }
        chart(model, pnlXuat);
    }

    //Tải toàn bộ dữ liệu tồn kho lên bảng
    void loadTonKho() {
        DefaultTableModel model = (DefaultTableModel) tblTonKho.getModel();
        model.setRowCount(0);
        List<Object[]> list = daoTK.getTonKho();
        for (Object[] ob : list) {
            model.addRow(ob);
        }
        chart(model, pnlTonKho);
    }


}
