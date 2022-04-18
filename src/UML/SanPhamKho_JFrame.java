/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import Dao.ChungTuCTDAO;
import Dao.ChungTuDAO;
import Dao.SPKhoDAO;
import Help.Auth;
import static Help.ColorHelper.*;
import Help.DateHelper;
import Help.DialogHelper;
import java.awt.Color;
import static Help.ValidateHelper.*;
import Help.ImageHelper;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import static Help.ImageHelper.*;
import Help.ValidateHelper;
import Model.ChungTu;
import Model.ChungTuCT;
import Model.SPKho;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class SanPhamKho_JFrame extends javax.swing.JFrame {

    public SanPhamKho_JFrame() {
        initComponents();
        init();
        load();
        setStatus(true);
        row = tblSPKho.getRowCount();
        loadCboSp();
    }

    void init() {
        designTable(false, new Color(0, 102, 255), Color.white, Plain, tblSPKho);
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    int countSpKho = cboMaSp.getModel().getSize() - 1;
                    if (tblSPKho.getRowCount() > row || tblSPKho.getRowCount() < row) {
                        row = tblSPKho.getRowCount();
                        loadCboSp();
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(KhoHang_JFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        };
        thread.start();
        designComboBox(Black, Color.white, Plain, cboMaSp);
        designTable(false, new Color(51, 51, 51), Color.white, Plain, tblDanhGia);
        designTable(false, new Color(51, 51, 51), Color.white, Plain, tblSPKho);
        pnlBackRoundKiemHang.setBackground(new Color(0, 0, 0, 0));
        pnlKiemHang.setBackground(new Color(0, 0, 0, 0));
    }

    JFileChooser fileChooser = new JFileChooser();
    SPKhoDAO dao = new SPKhoDAO();
    ChungTuDAO daoChungTu = new ChungTuDAO();
    ChungTuCTDAO daoChungTuCT = new ChungTuCTDAO();
    int index = -1, row;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        lblTieuDe = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        lblAnh = new javax.swing.JLabel();
        lblTimKiem = new javax.swing.JLabel();
        txtTimSP = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSPKho = new javax.swing.JTable();
        lblTimKiem1 = new javax.swing.JLabel();
        pnlBackRoundKiemHang = new javax.swing.JPanel();
        pnlKiemHang = new RoundedPanel(50,new Color(102,255,102));
        jLabel5 = new javax.swing.JLabel();
        btnLast3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cboMaSp = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDanhGia = new javax.swing.JTextArea();
        lblLoiDanhGia = new javax.swing.JLabel();
        lblLoiChonSp = new javax.swing.JLabel();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDanhGia = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        kGradientPanel1.setkEndColor(new java.awt.Color(51, 102, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(153, 255, 255));
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

        lblTieuDe.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(255, 255, 255));
        lblTieuDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logo.png"))); // NOI18N
        lblTieuDe.setText("Sản phẩm kho");
        kGradientPanel1.add(lblTieuDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Backs.png"))); // NOI18N
        jLabel10.setToolTipText("Quay lại");
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
        kGradientPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 0, 70, 50));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 50));

        kGradientPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        kGradientPanel2.setkEndColor(new java.awt.Color(51, 102, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(153, 255, 255));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAnh.setBackground(new java.awt.Color(0, 204, 153));
        lblAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblAnh.setOpaque(true);
        lblAnh.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lblAnhFocusLost(evt);
            }
        });
        lblAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAnhMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAnhMouseExited(evt);
            }
        });
        lblAnh.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                lblAnhInputMethodTextChanged(evt);
            }
        });
        kGradientPanel2.add(lblAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 200, 200));

        lblTimKiem.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTimKiem.setForeground(new java.awt.Color(0, 102, 204));
        lblTimKiem.setText("Hình sản phẩm");
        kGradientPanel2.add(lblTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        txtTimSP.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtTimSP.setForeground(new java.awt.Color(153, 153, 153));
        txtTimSP.setText("VD: NoPT");
        txtTimSP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTimSP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimSPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimSPFocusLost(evt);
            }
        });
        txtTimSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimSPKeyReleased(evt);
            }
        });
        kGradientPanel2.add(txtTimSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 521, 29));

        tblSPKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm Kho", "Tên Sản Phẩm Kho", "Loại Sản Phẩm", "Giá", "Số Lượng", "Đơn Vị Tính", "Tên Nhà Cung Cấp", "Mã Lô Hàng", "Ngày Tạo", "Hình"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSPKho.setRowHeight(25);
        tblSPKho.setSelectionBackground(new java.awt.Color(255, 153, 153));
        tblSPKho.setShowGrid(true);
        tblSPKho.setShowVerticalLines(false);
        tblSPKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPKhoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSPKho);
        if (tblSPKho.getColumnModel().getColumnCount() > 0) {
            tblSPKho.getColumnModel().getColumn(0).setPreferredWidth(110);
            tblSPKho.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblSPKho.getColumnModel().getColumn(3).setPreferredWidth(60);
            tblSPKho.getColumnModel().getColumn(5).setPreferredWidth(60);
            tblSPKho.getColumnModel().getColumn(6).setPreferredWidth(130);
            tblSPKho.getColumnModel().getColumn(9).setPreferredWidth(45);
        }

        kGradientPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 270, 910, 290));

        lblTimKiem1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTimKiem1.setForeground(new java.awt.Color(102, 0, 204));
        lblTimKiem1.setText("Tìm kiếm");
        kGradientPanel2.add(lblTimKiem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, -1));

        pnlBackRoundKiemHang.setBackground(new java.awt.Color(255, 255, 255));
        pnlBackRoundKiemHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlKiemHang.setBackground(new java.awt.Color(102, 255, 102));
        pnlKiemHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Kiểm hàng");
        pnlKiemHang.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, -1));

        btnLast3.setBackground(new java.awt.Color(0, 0, 255));
        btnLast3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLast3.setForeground(new java.awt.Color(255, 255, 255));
        btnLast3.setText("Thêm đánh giá");
        btnLast3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLast3ActionPerformed(evt);
            }
        });
        pnlKiemHang.add(btnLast3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 150, 70));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Đánh giá");
        pnlKiemHang.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Sản Phẩm");
        pnlKiemHang.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        cboMaSp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMaSpItemStateChanged(evt);
            }
        });
        cboMaSp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboMaSpMouseClicked(evt);
            }
        });
        pnlKiemHang.add(cboMaSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 380, 30));

        txtDanhGia.setColumns(20);
        txtDanhGia.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        txtDanhGia.setForeground(new java.awt.Color(153, 153, 153));
        txtDanhGia.setRows(5);
        txtDanhGia.setText("VD: Sản phẩm ok");
        txtDanhGia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDanhGiaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDanhGiaFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(txtDanhGia);

        pnlKiemHang.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 230, 70));

        lblLoiDanhGia.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiDanhGia.setForeground(new java.awt.Color(255, 255, 0));
        pnlKiemHang.add(lblLoiDanhGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 230, 20));

        lblLoiChonSp.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiChonSp.setForeground(new java.awt.Color(255, 255, 0));
        pnlKiemHang.add(lblLoiChonSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 330, 20));

        pnlBackRoundKiemHang.add(pnlKiemHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 420, 230));

        kGradientPanel2.add(pnlBackRoundKiemHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 440, 253));

        btnFirst.setBackground(new java.awt.Color(0, 0, 255));
        btnFirst.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFirst.setForeground(new java.awt.Color(255, 255, 255));
        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/first.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });
        kGradientPanel2.add(btnFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 121, 40));

        btnPrev.setBackground(new java.awt.Color(0, 0, 255));
        btnPrev.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrev.setForeground(new java.awt.Color(255, 255, 255));
        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/prev.png"))); // NOI18N
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });
        kGradientPanel2.add(btnPrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 107, 40));

        btnNext.setBackground(new java.awt.Color(0, 0, 255));
        btnNext.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/next.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        kGradientPanel2.add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 109, 40));

        btnLast.setBackground(new java.awt.Color(0, 0, 255));
        btnLast.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLast.setForeground(new java.awt.Color(255, 255, 255));
        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/last.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });
        kGradientPanel2.add(btnLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 120, 40));

        btnDelete.setBackground(new java.awt.Color(0, 0, 255));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/cacelIcon.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        kGradientPanel2.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 121, 40));

        btnUpdate.setBackground(new java.awt.Color(0, 0, 255));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/ssss.png"))); // NOI18N
        btnUpdate.setText("Sửa giá");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        kGradientPanel2.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 130, 40));
        kGradientPanel2.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 150, 40));
        jLabel9.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Chỉ sửa được giá sản phẩm***");
        kGradientPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, 220, -1));

        tblDanhGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Đánh giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhGia.setRowHeight(25);
        tblDanhGia.setSelectionBackground(new java.awt.Color(255, 102, 153));
        tblDanhGia.setShowVerticalLines(false);
        tblDanhGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhGiaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDanhGia);

        kGradientPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 270, 340, 290));

        getContentPane().add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 46, 1290, 570));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblAnhFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblAnhFocusLost

    }//GEN-LAST:event_lblAnhFocusLost

    private void lblAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhMouseClicked

    }//GEN-LAST:event_lblAnhMouseClicked

    private void lblAnhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhMouseEntered
        lblAnh.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_lblAnhMouseEntered

    private void lblAnhMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhMouseExited
        lblAnh.setBackground(new Color(0, 204, 153));
    }//GEN-LAST:event_lblAnhMouseExited

    private void lblAnhInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_lblAnhInputMethodTextChanged

    }//GEN-LAST:event_lblAnhInputMethodTextChanged

    private void txtTimSPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimSPFocusGained
        if (txtTimSP.getForeground().equals(new Color(153, 153, 153))) {
            Color(txtTimSP, "", Plain, Black);
        }
    }//GEN-LAST:event_txtTimSPFocusGained

    private void txtTimSPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimSPFocusLost
        if (txtTimSP.getText().trim().isEmpty()) {
            Color(txtTimSP, "VD: NoPT", Italic, Gray);
        }
    }//GEN-LAST:event_txtTimSPFocusLost

    private void kGradientPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MousePressed
        moveFrom(evt);
    }//GEN-LAST:event_kGradientPanel1MousePressed

    private void kGradientPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MouseDragged
        MouseDragged(evt, this);
    }//GEN-LAST:event_kGradientPanel1MouseDragged

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        jLabel10.setIcon(Back2);
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        jLabel10.setIcon(Back1);
    }//GEN-LAST:event_jLabel10MouseExited

    private void txtDanhGiaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDanhGiaFocusGained
        // TODO add your handling code here:
        Color(txtDanhGia, "", Plain, Black);
    }//GEN-LAST:event_txtDanhGiaFocusGained

    private void txtDanhGiaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDanhGiaFocusLost
        // TODO add your handling code here:
        if (txtDanhGia.getText().trim().isEmpty()) {
            Color(txtDanhGia, "VD: Sản phẩm ok ", Italic, Gray);
        } else {
            lblLoiDanhGia.setText("");
        }
    }//GEN-LAST:event_txtDanhGiaFocusLost

    private void tblSPKhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPKhoMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            index = tblSPKho.getSelectedRow();
            setModel();

            setStatus(false);
        }
    }//GEN-LAST:event_tblSPKhoMouseClicked

    private void txtTimSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimSPKeyReleased
        // TODO add your handling code here:
        loadTK();
    }//GEN-LAST:event_txtTimSPKeyReleased

    private void btnLast3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLast3ActionPerformed
        // TODO add your handling code here:
        if (cboMaSp.getSelectedIndex() == 0 || cboMaSp.getSelectedIndex() == 0) {
            DialogHelper.alert(null, "Vui lòng chọn vào sản phẩm trên bảng hoặc combobox bạn cần kiểm tra");
            return;
        }
        if (checkForm()) {
            insertDanhGia();
            clear();
            loadDanhGia();
        }
    }//GEN-LAST:event_btnLast3ActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        index = 0;
        setModel();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        index--;
        setModel();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        index++;
        setModel();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        index = tblSPKho.getSelectedRow();
        setModel();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        index = tblSPKho.getSelectedRow();
        if (index != -1) {
            delete();
        } else {
            DialogHelper.alert(null, "Vui lòng chọn sản phẩm");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void cboMaSpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboMaSpMouseClicked

    }//GEN-LAST:event_cboMaSpMouseClicked

    private void cboMaSpItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMaSpItemStateChanged
                click();
    }//GEN-LAST:event_cboMaSpItemStateChanged

    private void tblDanhGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhGiaMouseClicked

    }//GEN-LAST:event_tblDanhGiaMouseClicked

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
            java.util.logging.Logger.getLogger(SanPhamKho_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SanPhamKho_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SanPhamKho_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SanPhamKho_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SanPhamKho_JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLast3;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboMaSp;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblLoiChonSp;
    private javax.swing.JLabel lblLoiDanhGia;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JLabel lblTimKiem1;
    private javax.swing.JPanel pnlBackRoundKiemHang;
    private javax.swing.JPanel pnlKiemHang;
    private javax.swing.JTable tblDanhGia;
    private javax.swing.JTable tblSPKho;
    private javax.swing.JTextArea txtDanhGia;
    private javax.swing.JTextField txtTimSP;
    // End of variables declaration//GEN-END:variables
    void chonAnh() {
        //Chỉ chọn được một ảnh
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        //Xét đối tượng File ta cần lấy là png và gif 
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG,PNG and  GIF images", "png", "gif", "jpeg", "jpg");
        //Add đối tượng cần lấy vào File để hộp thoại hiển thị File cần lấy
        fileChooser.addChoosableFileFilter(filter);
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            //Lấy file người dùng chọn
            File file = fileChooser.getSelectedFile();
            //Lưu hình vào thư mục logos
            ImageHelper.save(file);
            ImageIcon anh = ImageHelper.read(file.getName());
            //Đọc hình từ thư mục logos
            //ImageIcon read(String tenFile) đọc file trong thư mục logos theo tên file trả về ImageIcon
            lblAnh.setIcon(anh);
            lblAnh.setToolTipText(file.getName()); //Giữ tên hình trong tooltip
            System.out.println(file.getName());
        }
    }

    boolean checkForm() {
        int count = 0;
        if (cboMaSp.getSelectedIndex() == 0) {
            lblLoiChonSp.setText("Vui lòng chọn mã sản phẩm từ bảng hoặc combobox!");
            count++;
        } else {
            lblLoiChonSp.setText("");
        }

        if (!ValidateHelper.ValidateNull(txtDanhGia)) {
            lblLoiDanhGia.setText("Vui lòng nhập đánh giá");
            count++;
        } else {
            lblLoiDanhGia.setText("");
        }

        return count == 0;
    }

    //Toàn bộ dữ liệu sản phẩm kho
    void load() {
        DefaultTableModel model = (DefaultTableModel) tblSPKho.getModel();
        model.setRowCount(0);
        List<SPKho> list = dao.selectAll();
        for (SPKho sp : list) {
            Object[] ob = {sp.getMaSPKho(), sp.getTenSP(),
                sp.getLoaiSP(), sp.getGia(),
                sp.getSoLuong(), sp.getDonViTinh(),
                sp.getTenNCC(), sp.getMaLoHang(),
                sp.getNgayNhap(), sp.getHinh()};
            model.addRow(ob);
        }

    }

    void loadTK() {
        DefaultTableModel model = (DefaultTableModel) tblSPKho.getModel();
        model.setRowCount(0);
        List<SPKho> list = dao.selectByConditions("%" + txtTimSP.getText().trim() + "%");
        for (SPKho sp : list) {
            Object[] ob = {sp.getMaSPKho(), sp.getTenSP(),
                sp.getLoaiSP(), sp.getGia(),
                sp.getSoLuong(), sp.getDonViTinh(),
                sp.getTenNCC(), sp.getMaLoHang(),
                sp.getNgayNhap(), sp.getHinh()};
            model.addRow(ob);
        }
    }

    void setModel() {
        tblSPKho.setRowSelectionInterval(index, index);
//        txtMaSP.setText(String.valueOf(tblSPKho.getValueAt(index, 0)));
        ImageIcon anh = ImageHelper.read(String.valueOf(tblSPKho.getValueAt(index, 9)));
        //Đọc hình từ thư mục logos
        //ImageIcon read(String tenFile) đọc file trong thư mục logos theo tên file trả về ImageIcon
        File f = new File("logos/" + String.valueOf(tblSPKho.getValueAt(index, 9)));
        if (f.exists() == false) {
            lblAnh.setIcon(Erro);
        } else {
            lblAnh.setIcon(anh);
        }
        lblAnh.setToolTipText(String.valueOf(tblSPKho.getValueAt(index, 9))); //Giữ tên hình trong tooltip
        String dataSeleted = String.valueOf(tblSPKho.getValueAt(index, 0));
        List<SPKho> list = dao.selectAll();
        for (int i = 0; i < list.size(); i++) {
            if (dataSeleted.equals(list.get(i).getMaSPKho())) {
                cboMaSp.setSelectedIndex(i + 1);
            }
        }
        loadDanhGia();
        setStatus(false);
    }

    //Trạng thái của các nút
    void setStatus(boolean status) {
        btnUpdate.setEnabled(!status);
        btnDelete.setEnabled(!status);

        boolean first = index > 0;
        boolean last = index < tblSPKho.getRowCount() - 1;

        btnFirst.setEnabled(!status && first);
        btnPrev.setEnabled(!status && first);
        btnNext.setEnabled(!status && last);
        btnLast.setEnabled(!status && last);
    }

    ChungTu getModelChungTu() {
        ChungTu ct = new ChungTu();
        ct.setTenDangNhap(Auth.user.getTenDn());
        ct.setLoaiChungTu("Đánh giá");
        ct.setNgayTao(DateHelper.now());
        ct.setTrangThai("Đã duyệt");
        ct.setMaKH(null);
        ct.setNguoiDuyet(null);
        String findBy = String.valueOf(cboMaSp.getSelectedItem());
        String[] words = findBy.split("\\(");
        String find = words[1];
        String[] wordss = find.split("\\)");
        SPKho sp = dao.selectById(wordss[0]);
        ct.setTongTien(sp.getGia() * sp.getSoLuong());
        return ct;
    }

    void loadCboSp() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboMaSp.getModel();
        model.removeAllElements();
        List<SPKho> list = dao.selectAll();
        model.insertElementAt("Chọn...", 0);
        model.setSelectedItem("Chọn...");
        for (int i = 0; i < list.size(); i++) {
            model.insertElementAt(list.get(i), i + 1);
        }
    }

    void loadDanhGia() {
        DefaultTableModel model = (DefaultTableModel) tblDanhGia.getModel();
        model.setRowCount(0);
        String maSP = String.valueOf(tblSPKho.getValueAt(index, 0));
        List<Object[]> list = dao.getDanhGia(maSP);
        for (Object[] ob : list) {
            model.addRow(ob);
        }
    }

    void insertDanhGia() {
        ChungTu ct = getModelChungTu();
        String maCT = daoChungTu.insert(ct);
        String find = String.valueOf(cboMaSp.getSelectedItem());
        String[] words = find.split("\\(");
        String maTim = words[1];
        String[] maDaSua = maTim.split("\\)");
        if (maCT != null) {
            SPKho sp = dao.selectById(maDaSua[0]);
            ChungTuCT ctt = new ChungTuCT();
            ctt.setMaChungTu(maCT);
            ctt.setMaSP(sp.getMaSPKho());
            ctt.setTenSP(sp.getTenSP());
            ctt.setLoaiSP(sp.getLoaiSP());
            ctt.setGia(sp.getGia());
            ctt.setSoLuong(sp.getSoLuong());
            ctt.setDonViTinh(sp.getDonViTinh());
            ctt.setTenNCC(sp.getTenNCC());
            ctt.setMaLoHang(sp.getMaLoHang());
            ctt.setNgayNhap(sp.getNgayNhap());
            ctt.setHinh(sp.getHinh());
            ctt.setMoTa(txtDanhGia.getText());
            if (daoChungTuCT.insert(ctt) == 0) {
                DialogHelper.alert(null, "Thêm thất bại");
            }

            DialogHelper.alert(null, "Thêm thành công");

        } else {
            DialogHelper.alert(null, "Thêm thất bại");
        }
    }

    void click() {
        if (cboMaSp.getSelectedIndex() != 0) {
            SPKho sp = (SPKho) cboMaSp.getSelectedItem();
            DefaultTableModel model = (DefaultTableModel) tblSPKho.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                if (String.valueOf(model.getValueAt(i, 0)).equals(sp.getMaSPKho())) {
                    index = i;
                    tblSPKho.setRowSelectionInterval(i, i);
                    File f = new File("logos/" + sp.getHinh());
                    if (f.exists() == false) {
                        lblAnh.setIcon(Erro);
                    } else {
                        ImageIcon anh = ImageHelper.read(sp.getHinh());
                        //Đọc hình từ thư mục logos
                        //ImageIcon read(String tenFile) đọc file trong thư mục logos theo tên file trả về ImageIcon
                        lblAnh.setIcon(anh);
                    }
                }
            }
            loadDanhGia();
        } else {
            tblSPKho.clearSelection();
            DefaultTableModel model = (DefaultTableModel) tblDanhGia.getModel();
            model.setRowCount(0);
            lblAnh.setIcon(Erro);
        }
    }

    void delete() {
        String maSP = String.valueOf(tblSPKho.getValueAt(index, 0));
        if (DialogHelper.confirm(null, "Bạn có muốn xóa sản phẩm " + maSP + " không?")) {
            if (dao.kiemTraSPKho(maSP) != 1) {
                if (dao.delete(maSP) == 1) {
                    DialogHelper.alert(null, "Xóa thành công");
                    clear();
                    load();
                } else {
                    DialogHelper.alert(null, "Xóa thất bại");
                }
            } else {
                DialogHelper.alert(null, "Không thể xóa!\n Sản phẩm " + maSP + " đang được lên đơn");
            }
        }

    }

    void clear() {
        Color(txtDanhGia, "VD: Sản phẩm ok ", Italic, Gray);
        lblLoiDanhGia.setText("");
        lblLoiDanhGia.setText("");
        tblSPKho.clearSelection();
        cboMaSp.setSelectedIndex(0);
        lblAnh.setIcon(null);
        setStatus(true);
    }

    void update() {
        int[] count = tblSPKho.getSelectedRows();
        if (count.length != 0) {
            for (int i : count) {
                String masp = String.valueOf(tblSPKho.getValueAt(i, 0));
                double gia = Double.parseDouble(String.valueOf(tblSPKho.getValueAt(i, 3)));
                if (dao.update(gia, masp) == 0) {
                    DialogHelper.alert(null, "Sửa giá sản phẩm " + masp + " thất bại");
                }
            }
            clear();
            load();
            DialogHelper.alert(null, "Sửa giá sản phẩm thành công");
        } else {
            DialogHelper.alert(null, "Vui lòng chọn sản phẩm");
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
