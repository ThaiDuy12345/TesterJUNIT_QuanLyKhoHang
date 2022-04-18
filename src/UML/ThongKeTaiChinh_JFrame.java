/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import Dao.TaiKhoanDAO;
import Dao.ThongKeDAO;
import static Help.ColorHelper.MouseDragged;
import static Help.ColorHelper.chooserDefault;
import static Help.ColorHelper.chooserList;
import static Help.ColorHelper.default_border;
import static Help.ColorHelper.designComboBox;
import static Help.ColorHelper.designTable;
import static Help.ColorHelper.moveFrom;
import static Help.ColorHelper.white_border;
import static Help.ImageHelper.Close1;
import static Help.ImageHelper.Close2;
import static Help.ValidateHelper.Plain;
import Model.TaiKhoan;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
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
public class ThongKeTaiChinh_JFrame extends javax.swing.JFrame {

    public ThongKeTaiChinh_JFrame(int i) {
        initComponents();
        designTable(false, new Color(0, 0, 0), Color.white, Plain, tblDoanhThu);
        designTable(false, new Color(0, 0, 0), Color.white, Plain, tblTinhHinh);
        designComboBox(new Color(0, 204, 51), Color.white, Plain, cboNamDoanhThu);
        designComboBox(new Color(0, 204, 51), Color.white, Plain, cboThangDoanhThu);
        designComboBox(new Color(0, 204, 51), Color.white, Plain, cboNamTinhHinh);
        designComboBox(new Color(0, 204, 51), Color.white, Plain, cboThangTinhHinh);
        fillThangDoanhThu(cboThangDoanhThu);
        fillNamDoanhThu(cboNamDoanhThu);
        fillThangDoanhThu(cboThangTinhHinh);
        fillNamDoanhThu(cboNamTinhHinh);
        cboThangDoanhThu.setSelectedItem(11);
        cboNamDoanhThu.setSelectedItem(2021);
        cboThangTinhHinh.setSelectedItem(11);
        cboNamTinhHinh.setSelectedItem(2021);
        card = (CardLayout) pnlTab.getLayout();
        if (i == 0) {
            loadDoanhThu();
            card.show(pnlTab, "CardDoanhThu");
            chooserList(new Color(204, 204, 204), lblDoanhThu);
        } else {
            loadTinhHinh();
            card.show(pnlTab, "CardNhanVien");
            chooserList(new Color(204, 204, 204), lblNv);
        }

    }
    CardLayout card;

    public ThongKeTaiChinh_JFrame() {
        initComponents();
        card = (CardLayout) pnlTab.getLayout();
        card.show(pnlTab, "CardDoanhThu");
        chooserList(new Color(204, 204, 204), lblDoanhThu);
        designTable(false, new Color(0, 0, 0), Color.white, Plain, tblDoanhThu);
        designTable(false, new Color(0, 0, 0), Color.white, Plain, tblTinhHinh);
        designComboBox(new Color(0, 204, 51), Color.white, Plain, cboNamDoanhThu);
        designComboBox(new Color(0, 204, 51), Color.white, Plain, cboThangDoanhThu);
        designComboBox(new Color(0, 102, 255), Color.white, Plain, cboNamTinhHinh);
        designComboBox(new Color(0, 102, 255), Color.white, Plain, cboThangTinhHinh);
        fillThangDoanhThu(cboThangDoanhThu);
        fillNamDoanhThu(cboNamDoanhThu);
        fillThangDoanhThu(cboThangTinhHinh);
        fillNamDoanhThu(cboNamTinhHinh);
        cboThangDoanhThu.setSelectedItem(11);
        cboNamDoanhThu.setSelectedItem(2021);
        cboThangTinhHinh.setSelectedItem(11);
        cboNamTinhHinh.setSelectedItem(2021);
        loadDoanhThu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblDoanhThu = new javax.swing.JLabel();
        lblNv = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        lblThoat = new javax.swing.JLabel();
        pnlTab = new keeptoo.KGradientPanel();
        pnlTinhHinhNv = new keeptoo.KGradientPanel();
        pnlTinhHinh = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTinhHinh = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        cboThangTinhHinh = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cboNamTinhHinh = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        lblTienTinhHinh = new javax.swing.JLabel();
        pnlLuongNhanVien = new javax.swing.JPanel();
        pnlCardDoanhThu = new keeptoo.KGradientPanel();
        kGradientPanel7 = new keeptoo.KGradientPanel();
        pnlDoanhThu = new javax.swing.JPanel();
        kGradientPanel8 = new keeptoo.KGradientPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDoanhThu = new javax.swing.JTable();
        cboNamDoanhThu = new javax.swing.JComboBox<>();
        cboThangDoanhThu = new javax.swing.JComboBox<>();
        lblTien = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnlDtCircle = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setkEndColor(new java.awt.Color(102, 255, 204));
        kGradientPanel1.setkStartColor(new java.awt.Color(51, 153, 255));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        kGradientPanel2.setkEndColor(new java.awt.Color(51, 153, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(102, 255, 204));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thống kê tài chính");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        kGradientPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 50));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDoanhThu.setBackground(new java.awt.Color(204, 204, 204));
        lblDoanhThu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDoanhThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDoanhThu.setText("Doanh thu");
        lblDoanhThu.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        lblDoanhThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDoanhThuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDoanhThuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDoanhThuMouseExited(evt);
            }
        });
        jPanel1.add(lblDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 100, 269, 90));

        lblNv.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNv.setText("Thống kê đơn hàng");
        lblNv.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        lblNv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNvMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblNvMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblNvMouseExited(evt);
            }
        });
        jPanel1.add(lblNv, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 190, 269, 90));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 140, 10));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Quản lý kho hàng của bạn");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 150, -1));

        kGradientPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 270, 460));

        kGradientPanel1.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 510));

        kGradientPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        kGradientPanel3.setkEndColor(new java.awt.Color(102, 255, 204));
        kGradientPanel3.setkStartColor(new java.awt.Color(51, 153, 255));
        kGradientPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                kGradientPanel3MouseDragged(evt);
            }
        });
        kGradientPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                kGradientPanel3MousePressed(evt);
            }
        });

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

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap(1075, Short.MAX_VALUE)
                .addComponent(lblThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblThoat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        kGradientPanel1.add(kGradientPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1147, 50));

        pnlTab.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));
        pnlTab.setkEndColor(new java.awt.Color(204, 204, 204));
        pnlTab.setkStartColor(new java.awt.Color(102, 102, 102));
        pnlTab.setLayout(new java.awt.CardLayout());

        pnlTinhHinhNv.setkEndColor(new java.awt.Color(204, 204, 204));
        pnlTinhHinhNv.setkStartColor(new java.awt.Color(102, 102, 102));
        pnlTinhHinhNv.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTinhHinh.setBackground(new java.awt.Color(255, 255, 255));
        pnlTinhHinh.setLayout(new java.awt.BorderLayout());
        pnlTinhHinhNv.add(pnlTinhHinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, 200));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblTinhHinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên đăng nhập", "Họ tên", "Email", "SDT", "Ngày tạo", "Tổng đơn", "Tổng tiền"
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
        jScrollPane2.setViewportView(tblTinhHinh);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 61, 830, 160));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setText("Tháng:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 30));

        cboThangTinhHinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboThangTinhHinh.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboThangTinhHinhItemStateChanged(evt);
            }
        });
        jPanel4.add(cboThangTinhHinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 190, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setText("Năm:");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 40, 20));

        cboNamTinhHinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboNamTinhHinh.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboNamTinhHinhItemStateChanged(evt);
            }
        });
        jPanel4.add(cboNamTinhHinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 190, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setText("Tổng đơn:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 90, 20));

        lblTienTinhHinh.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblTienTinhHinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTienTinhHinh.setText("0");
        jPanel4.add(lblTienTinhHinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 15, 100, 30));

        pnlTinhHinhNv.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 850, 230));

        pnlLuongNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        pnlLuongNhanVien.setLayout(new java.awt.BorderLayout());
        pnlTinhHinhNv.add(pnlLuongNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 510, 200));

        pnlTab.add(pnlTinhHinhNv, "CardNhanVien");

        pnlCardDoanhThu.setkEndColor(new java.awt.Color(204, 204, 204));
        pnlCardDoanhThu.setkStartColor(new java.awt.Color(102, 102, 102));
        pnlCardDoanhThu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel7.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel7.setkStartColor(new java.awt.Color(204, 204, 204));
        kGradientPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlDoanhThu.setBackground(new java.awt.Color(102, 255, 102));
        pnlDoanhThu.setLayout(new java.awt.BorderLayout());
        kGradientPanel7.add(pnlDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 540, 200));

        pnlCardDoanhThu.add(kGradientPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 560, 220));

        kGradientPanel8.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel8.setkStartColor(new java.awt.Color(153, 153, 153));
        kGradientPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Số lượng", "Giá", "Tổng tiền", "Ngày bán gần đây"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDoanhThu);

        kGradientPanel8.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 820, 150));

        cboNamDoanhThu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboNamDoanhThu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboNamDoanhThuItemStateChanged(evt);
            }
        });
        kGradientPanel8.add(cboNamDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 190, -1));

        cboThangDoanhThu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboThangDoanhThu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboThangDoanhThuItemStateChanged(evt);
            }
        });
        kGradientPanel8.add(cboThangDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 190, -1));

        lblTien.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        kGradientPanel8.add(lblTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 160, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Tháng:");
        kGradientPanel8.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 30));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("Năm:");
        kGradientPanel8.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 40, 30));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setText("Doanh thu:");
        kGradientPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 70, 30));

        pnlCardDoanhThu.add(kGradientPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 840, 210));

        pnlDtCircle.setBackground(new java.awt.Color(255, 255, 255));
        pnlDtCircle.setLayout(new java.awt.BorderLayout());
        pnlCardDoanhThu.add(pnlDtCircle, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 270, 220));

        pnlTab.add(pnlCardDoanhThu, "CardDoanhThu");

        kGradientPanel1.add(pnlTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 877, 460));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseClicked
        dispose();
    }//GEN-LAST:event_lblThoatMouseClicked

    private void lblThoatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseEntered
        lblThoat.setIcon(Close2);
    }//GEN-LAST:event_lblThoatMouseEntered

    private void lblThoatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseExited
        lblThoat.setIcon(Close1);
    }//GEN-LAST:event_lblThoatMouseExited

    private void lblDoanhThuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDoanhThuMouseEntered
        lblDoanhThu.setBorder(white_border);
    }//GEN-LAST:event_lblDoanhThuMouseEntered

    private void lblDoanhThuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDoanhThuMouseExited
        lblDoanhThu.setBorder(default_border);
    }//GEN-LAST:event_lblDoanhThuMouseExited

    private void lblNvMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNvMouseEntered
        lblNv.setBorder(white_border);
    }//GEN-LAST:event_lblNvMouseEntered

    private void lblNvMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNvMouseExited
        lblNv.setBorder(default_border);
    }//GEN-LAST:event_lblNvMouseExited

    private void lblDoanhThuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDoanhThuMouseClicked
        chooserDefault(null, lblNv, lblDoanhThu);//[204,204,204]
        chooserList(new Color(204, 204, 204), lblDoanhThu);
        card.show(pnlTab, "CardDoanhThu");

        loadDoanhThu();
    }//GEN-LAST:event_lblDoanhThuMouseClicked

    private void lblNvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNvMouseClicked
        chooserDefault(null, lblNv, lblDoanhThu);//[204,204,204]
        chooserList(new Color(204, 204, 204), lblNv);
        card.show(pnlTab, "CardNhanVien");

        loadTinhHinh();
    }//GEN-LAST:event_lblNvMouseClicked

    private void kGradientPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel3MouseDragged
        MouseDragged(evt, this);
    }//GEN-LAST:event_kGradientPanel3MouseDragged

    private void kGradientPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel3MousePressed
        moveFrom(evt);
    }//GEN-LAST:event_kGradientPanel3MousePressed

    private void cboThangDoanhThuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboThangDoanhThuItemStateChanged
        // TODO add your handling code here:
        try {
            loadDoanhThu();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_cboThangDoanhThuItemStateChanged

    private void cboNamDoanhThuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboNamDoanhThuItemStateChanged
        // TODO add your handling code here:

        try {
            loadDoanhThu();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_cboNamDoanhThuItemStateChanged

    private void cboThangTinhHinhItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboThangTinhHinhItemStateChanged
        // TODO add your handling code here:
        try {
            loadTinhHinh();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_cboThangTinhHinhItemStateChanged

    private void cboNamTinhHinhItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboNamTinhHinhItemStateChanged
        // TODO add your handling code here:
        try {
            loadTinhHinh();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_cboNamTinhHinhItemStateChanged

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
            java.util.logging.Logger.getLogger(ThongKeTaiChinh_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeTaiChinh_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeTaiChinh_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeTaiChinh_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKeTaiChinh_JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboNamDoanhThu;
    private javax.swing.JComboBox<String> cboNamTinhHinh;
    private javax.swing.JComboBox<String> cboThangDoanhThu;
    private javax.swing.JComboBox<String> cboThangTinhHinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel7;
    private keeptoo.KGradientPanel kGradientPanel8;
    private javax.swing.JLabel lblDoanhThu;
    private javax.swing.JLabel lblNv;
    private javax.swing.JLabel lblThoat;
    private javax.swing.JLabel lblTien;
    private javax.swing.JLabel lblTienTinhHinh;
    private keeptoo.KGradientPanel pnlCardDoanhThu;
    private javax.swing.JPanel pnlDoanhThu;
    private javax.swing.JPanel pnlDtCircle;
    private javax.swing.JPanel pnlLuongNhanVien;
    private keeptoo.KGradientPanel pnlTab;
    private javax.swing.JPanel pnlTinhHinh;
    private keeptoo.KGradientPanel pnlTinhHinhNv;
    private javax.swing.JTable tblDoanhThu;
    private javax.swing.JTable tblTinhHinh;
    // End of variables declaration//GEN-END:variables

    ThongKeDAO daoTK = new ThongKeDAO();

    //Tạo biểu đồ
    void chartDoanhThu(DefaultTableModel model, JPanel pnl) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < model.getRowCount(); i++) {
            dataset.setValue(Double.parseDouble(String.valueOf(model.getValueAt(i, 4))), "", String.valueOf(model.getValueAt(i, 1)));
        }
        JFreeChart chart = ChartFactory.createBarChart3D("Biểu đồ doanh thu", "Sản phẩm", "Doanh thu", dataset, PlotOrientation.VERTICAL, false, false, false);
        CategoryPlot catPlot = chart.getCategoryPlot();
        catPlot.setRangeGridlinePaint(Color.BLACK);

        ChartPanel chartPanel = new ChartPanel(chart);
        pnl.removeAll();
        pnl.add(chartPanel, BorderLayout.CENTER);
        pnl.validate();
    }

    void chartTinhHinh(DefaultTableModel model, JPanel pnl) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < model.getRowCount(); i++) {
            dataset.setValue(Double.parseDouble(String.valueOf(model.getValueAt(i, 5))), "", String.valueOf(model.getValueAt(i, 1)));
        }
        JFreeChart chart = ChartFactory.createBarChart3D("Biểu đồ", "Nhân viên", "Tổng đơn", dataset, PlotOrientation.VERTICAL, false, false, false);
        CategoryPlot catPlot = chart.getCategoryPlot();
        catPlot.setRangeGridlinePaint(Color.BLACK);

        ChartPanel chartPanel = new ChartPanel(chart);
        pnl.removeAll();
        pnl.add(chartPanel, BorderLayout.CENTER);
        pnl.validate();
    }

    //Tải dữ liêu tháng lên comboBox
    void fillThangDoanhThu(JComboBox combo) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) combo.getModel();
        model.removeAllElements();
        for (int i = 1; i <= 12; i++) {
            model.addElement(i);
        }
    }

    //Tải dữ liệu năm lên comboBox
    void fillNamDoanhThu(JComboBox combo) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) combo.getModel();
        model.removeAllElements();
        for (int i = 2018; i <= 2060; i++) {
            model.addElement(i);
        }
    }

    //Tải dữ liệu doanh thu lên bảng
    void loadDoanhThu() {
        DefaultTableModel model = (DefaultTableModel) tblDoanhThu.getModel();
        model.setRowCount(0);
        List<Object[]> list = daoTK.getDoanhThu(Integer.parseInt(String.valueOf(cboThangDoanhThu.getSelectedItem())), Integer.parseInt(String.valueOf(cboNamDoanhThu.getSelectedItem())));
        for (Object[] ob : list) {
            model.addRow(ob);
        }
        if (list != null) {
            double tien = 0;
            for (int i = 0; i < model.getRowCount(); i++) {
                tien += Double.parseDouble(String.valueOf(tblDoanhThu.getValueAt(i, 4)));
            }
            lblTien.setText(String.format("%.2f",tien));
            chartDoanhThu(model, pnlDoanhThu);
//            circle(model, pnlDtCircle);

            DefaultPieDataset dataset = new DefaultPieDataset();
            for (int i = 0; i < model.getRowCount(); i++) {
                dataset.setValue(String.valueOf(model.getValueAt(i, 1)), Double.valueOf(String.valueOf(model.getValueAt(i, 2))));
            }
            JFreeChart objChart = ChartFactory.createPieChart3D(
                    "Tổng số lượng sản phẩm", //Chart title
                    dataset, //Chart Data 
                    true, // include legend?
                    true, // include tooltips?
                    false // include URLs?
            );
            ChartPanel frame = new ChartPanel(objChart);
            pnlDtCircle.removeAll();
            pnlDtCircle.add(frame);
            pnlDtCircle.validate();
        } else {
            lblTien.setText("");
        }
    }

    //Tải dữ liệu tình hình nhân viên lên bảng
    void loadTinhHinh() {
        DefaultTableModel model = (DefaultTableModel) tblTinhHinh.getModel();
        model.setRowCount(0);
        List<Object[]> list = daoTK.getTinhHinh(Integer.parseInt(String.valueOf(cboThangTinhHinh.getSelectedItem())), Integer.parseInt(String.valueOf(cboNamTinhHinh.getSelectedItem())));
        for (Object[] ob : list) {
            model.addRow(ob);
        }
        if (list != null) {
            int tien = 0;
            for (int i = 0; i < model.getRowCount(); i++) {
                tien += Integer.parseInt(String.valueOf(tblTinhHinh.getValueAt(i, 5)));
            }
            lblTienTinhHinh.setText(String.valueOf(tien));
            chartTinhHinh(model, pnlTinhHinh);
            chartNhaVien(model,pnlLuongNhanVien);
        } else {
            lblTienTinhHinh.setText("");
        }
    }

    void chartNhaVien(DefaultTableModel model, JPanel pnl) {
        DefaultCategoryDataset objDataset = new DefaultCategoryDataset();
        for (int i = 0; i < model.getRowCount(); i++) {
            objDataset.setValue(Double.parseDouble(String.valueOf(model.getValueAt(i, 6))), "", String.valueOf(model.getValueAt(i, 1)));
        }
        JFreeChart objChart = ChartFactory.createBarChart3D(
                "Đơn hàng thống kê", //Chart title
                "Các nhân viên", //Domain axis label
                "Doanh thu bán được", //Range axis label
                objDataset, //Chart Data 
                PlotOrientation.VERTICAL, // orientation
                true, // include legend?
                true, // include tooltips?
                false // include URLs?
        );
        ChartPanel frame = new ChartPanel(objChart);
        pnlLuongNhanVien.removeAll();
        pnlLuongNhanVien.add(frame);
        pnlLuongNhanVien.validate();
    }
}