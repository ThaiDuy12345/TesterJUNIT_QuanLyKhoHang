/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import Dao.ChungTuCTDAO;
import Dao.ChungTuDAO;
import Dao.KhachHangDAO;
import Dao.SPKhoDAO;
import static Help.ColorHelper.*;
import Help.*;
import java.awt.Color;
import static Help.ValidateHelper.*;
import java.awt.CardLayout;
import static Help.ImageHelper.*;
import Model.ChungTu;
import Model.ChungTuCT;
import Model.KhachHang;
import Model.SPKho;
import Model.TaiKhoan;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class QuanLyDonHang_JFrame extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyDonHang_JFrame
     */
    public QuanLyDonHang_JFrame() {
        initComponents();
        init();
        loadSPKho();

    }

    public QuanLyDonHang_JFrame(int a) {
        initComponents();
        numberTab = a;
        init();
        init1();
        loadSPKho();
        hinh();
    }
    CardLayout card;
    int numberTab;
    SPKhoDAO daoSPKho = new SPKhoDAO();
    ChungTuDAO daoChungTu = new ChungTuDAO();
    ChungTuCTDAO daoChungTuCT = new ChungTuCTDAO();
    KhachHangDAO daoKhachHang = new KhachHangDAO();
    int indexSPKho = -1;
    int indexGioHang = -1;
    int indexDonHang = -1;
    int indexDonHangCT = -1;

    void init() {
        designTable(false, new Color(0, 102, 255), Color.white, Plain, tblSPKho);
        designTable(false, new Color(0, 102, 255), Color.white, Plain, tblGioHang);
        designTable(false, new Color(0, 102, 255), Color.white, Plain, tblKhachHang);
        designTable(false, new Color(0, 102, 255), Color.white, Plain, tblDonHang);
        designTable(false, new Color(0, 102, 255), Color.white, Plain, tblDonHangCT);
        designComboBox(new Color(0,51,204), Color.white, Plain, cboTrangThaiDH);
        card = (CardLayout) pnlTab.getLayout();
        card.show(pnlTab, "CardTrangChu");
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    chooserCustom();
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();

    }

    void init1() {
        if (numberTab == 0) {
            card = (CardLayout) pnlTab.getLayout();
            card.show(pnlTab, "CardQldh");
            chooserList(new Color(153, 153, 255), lblQldh);
        }
        if (numberTab == 1) {
            card = (CardLayout) pnlTab.getLayout();
            card.show(pnlTab, "CardDsdh");
            chooserList(new Color(153, 153, 255), lblDsdh);
            loadDSDH();
        }
        if (numberTab == 2) {
            card = (CardLayout) pnlTab.getLayout();
            card.show(pnlTab, "CardDskh");
            chooserList(new Color(153, 153, 255), lblDskh);
            loadKhachHang();
        }
    }

    void hinh() {
        TaiKhoan tui = Auth.user;
        File f = new File("logos/" + tui.getHinh());
        if (f.exists() == false) {
            lblHinh.setIcon(Erro);
            return;
        }
        //Ảnh nhân viên
        ImageIcon anh = ImageHelper.read(tui.getHinh());
        lblHinh.setIcon(anh);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgrGioiTinh = new javax.swing.ButtonGroup();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        lblHinh = new javax.swing.JLabel();
        lblQldh = new javax.swing.JLabel();
        lblDsdh = new javax.swing.JLabel();
        lblDskh = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        pnlTab = new javax.swing.JPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlQldh = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSPKho = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblLoiMaKH = new javax.swing.JLabel();
        lblLoiTongTien = new javax.swing.JLabel();
        lblLoiTenKH = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnThemVaoGioHang = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        pnlDsdh = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDonHangCT = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDonHang = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        cboTrangThaiDH = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        txtMaDonHang = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtGiaSanPham = new javax.swing.JTextField();
        txtTenSanPham = new javax.swing.JTextField();
        txtSoLuongSanPham = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        lblAnh = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel12 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        pnlDskh = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        pnlTitle = new javax.swing.JPanel();
        lblBack = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 51, 204)));
        kGradientPanel1.setkEndColor(new java.awt.Color(0, 0, 153));
        kGradientPanel1.setkGradientFocus(800);
        kGradientPanel1.setkStartColor(new java.awt.Color(51, 153, 255));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHinh.setBackground(new java.awt.Color(0, 153, 0));
        lblHinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/personnn.png"))); // NOI18N
        lblHinh.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        kGradientPanel1.add(lblHinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 200, 200));

        lblQldh.setBackground(new java.awt.Color(102, 102, 255));
        lblQldh.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblQldh.setForeground(new java.awt.Color(0, 255, 204));
        lblQldh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQldh.setText("Quản lý đơn hàng");
        lblQldh.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        lblQldh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQldhMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblQldhMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblQldhMouseExited(evt);
            }
        });
        kGradientPanel1.add(lblQldh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 250, 75));

        lblDsdh.setBackground(new java.awt.Color(102, 102, 255));
        lblDsdh.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblDsdh.setForeground(new java.awt.Color(0, 255, 204));
        lblDsdh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDsdh.setText("Danh sách đơn hàng");
        lblDsdh.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        lblDsdh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDsdhMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDsdhMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDsdhMouseExited(evt);
            }
        });
        kGradientPanel1.add(lblDsdh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 375, 250, 75));

        lblDskh.setBackground(new java.awt.Color(102, 102, 255));
        lblDskh.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblDskh.setForeground(new java.awt.Color(0, 255, 204));
        lblDskh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDskh.setText("Danh sách khách hàng");
        lblDskh.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        lblDskh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDskhMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDskhMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDskhMouseExited(evt);
            }
        });
        kGradientPanel1.add(lblDskh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 250, 75));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Sp_Icon.png"))); // NOI18N
        jLabel3.setText("Đơn hàng");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        kGradientPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 40));

        jSeparator1.setOpaque(true);
        kGradientPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 50, 180, -1));
        kGradientPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 670, 210, 20));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 690));

        pnlTab.setBackground(new java.awt.Color(255, 255, 255));
        pnlTab.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));
        pnlTab.setLayout(new java.awt.CardLayout());

        kGradientPanel2.setkEndColor(new java.awt.Color(204, 204, 255));
        kGradientPanel2.setkGradientFocus(1500);
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(51, 102, 255));

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Quản lý đơn hàng/ Trang chủ/");

        jLabel44.setBackground(new java.awt.Color(255, 255, 255));
        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Trang chủ________________________________________________________");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel44)))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel26)
                .addGap(11, 11, 11)
                .addComponent(jLabel44))
        );

        kGradientPanel2.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1048, 76));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/qldh_TrangChu.png"))); // NOI18N
        kGradientPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1050, 520));

        pnlTab.add(kGradientPanel2, "CardTrangChu");

        pnlQldh.setBackground(new java.awt.Color(255, 255, 255));
        pnlQldh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlQldh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Loại SP", "Giá", "Số lượng", "Đơn vị tính", "Tên nhà CC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        tblGioHang.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tblGioHangInputMethodTextChanged(evt);
            }
        });
        tblGioHang.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblGioHangPropertyChange(evt);
            }
        });
        tblGioHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblGioHangKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblGioHangKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblGioHangKeyTyped(evt);
            }
        });
        tblGioHang.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                tblGioHangVetoableChange(evt);
            }
        });
        jScrollPane1.setViewportView(tblGioHang);

        pnlQldh.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 641, 197));

        tblSPKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Loại SP", "Giá", "Số lượng", "Đơn vị tính", "Tên nhà CC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblSPKho);

        pnlQldh.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 162, 642, 170));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 255));
        jLabel7.setText("Giỏ hàng");
        pnlQldh.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 255));
        jLabel8.setText("Sản phẩm");
        pnlQldh.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jPanel7.setBackground(new java.awt.Color(51, 102, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Mã khách hàng");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 68, -1, -1));

        txtMaKH.setEditable(false);
        txtMaKH.setBackground(new java.awt.Color(255, 255, 255));
        txtMaKH.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMaKH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMaKHFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaKHFocusLost(evt);
            }
        });
        txtMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKHActionPerformed(evt);
            }
        });
        jPanel7.add(txtMaKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 286, 40));

        txtTongTien.setEditable(false);
        txtTongTien.setBackground(new java.awt.Color(255, 255, 255));
        txtTongTien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTongTien.setText("0");
        txtTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienActionPerformed(evt);
            }
        });
        jPanel7.add(txtTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 308, 286, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Tên khách hàng");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 175, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Tổng tiền");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 280, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Tạo đơn hàng");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        lblLoiMaKH.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiMaKH.setForeground(new java.awt.Color(255, 0, 0));
        jPanel7.add(lblLoiMaKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 149, 280, 14));

        lblLoiTongTien.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiTongTien.setForeground(new java.awt.Color(255, 0, 0));
        jPanel7.add(lblLoiTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 350, 278, 14));

        lblLoiTenKH.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiTenKH.setForeground(new java.awt.Color(255, 0, 0));
        jPanel7.add(lblLoiTenKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 260, 280, 14));

        txtTenKH.setEditable(false);
        txtTenKH.setBackground(new java.awt.Color(255, 255, 255));
        txtTenKH.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTenKH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTenKHFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTenKHFocusLost(evt);
            }
        });
        txtTenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKHActionPerformed(evt);
            }
        });
        jPanel7.add(txtTenKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 208, 286, 40));
        jPanel7.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 330, 10));

        jButton7.setBackground(new java.awt.Color(255, 204, 0));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/addOrther.png"))); // NOI18N
        jButton7.setText("Tạo đơn thanh toán");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7MouseExited(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 220, 46));

        jButton1.setBackground(new java.awt.Color(255, 102, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/khachHanIcon.png"))); // NOI18N
        jButton1.setText("Chọn khách hàng");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jPanel7.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 200, 40));

        pnlQldh.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 120, 369, 500));

        btnThemVaoGioHang.setBackground(new java.awt.Color(255, 255, 255));
        btnThemVaoGioHang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemVaoGioHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Cart_Icon.png"))); // NOI18N
        btnThemVaoGioHang.setText("Thêm vào giỏ hàng");
        btnThemVaoGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVaoGioHangActionPerformed(evt);
            }
        });
        pnlQldh.add(btnThemVaoGioHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 200, 40));

        jPanel11.setBackground(new java.awt.Color(51, 102, 255));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Quản lý đơn hàng/ Đơn hàng/");

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Đơn hàng________________________________________________________");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel30)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel25)
                .addGap(11, 11, 11)
                .addComponent(jLabel30))
        );

        pnlQldh.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 40, 1047, 76));

        btnXoa.setBackground(new java.awt.Color(255, 255, 255));
        btnXoa.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/cancel.png"))); // NOI18N
        btnXoa.setText("Hủy chọn");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        pnlQldh.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 590, 170, 40));

        pnlTab.add(pnlQldh, "CardQldh");

        pnlDsdh.setBackground(new java.awt.Color(255, 255, 255));
        pnlDsdh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlDsdh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDonHangCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đơn hàng", "Mã SP", "Tên SP", "Loại SP", "Giá", "Số lượng", "Đơn vị tính", "Tên nhà CC", "Hình"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDonHangCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDonHangCTMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDonHangCT);

        jPanel8.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 650, 210));

        tblDonHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đơn hàng", "Người tạo", "Loại chứng từ", "Ngày tạo", "Trạng thái", "Mã KH", "Người duyệt", "Tổng tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDonHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDonHangMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblDonHang);

        jPanel8.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 650, 205));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 102, 255));
        jLabel31.setText("Trạng thái:");
        jPanel8.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 113, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 102, 255));
        jLabel32.setText("Đơn hàng chi tiết");
        jPanel8.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 189, -1));

        cboTrangThaiDH.setBackground(new java.awt.Color(255, 102, 0));
        cboTrangThaiDH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Chờ duyệt", "Đã duyệt" }));
        cboTrangThaiDH.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTrangThaiDHItemStateChanged(evt);
            }
        });
        jPanel8.add(cboTrangThaiDH, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 260, 30));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 102, 255));
        jLabel37.setText("Đơn hàng");
        jPanel8.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 113, -1));

        pnlDsdh.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 680, 510));

        jPanel9.setBackground(new java.awt.Color(102, 153, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMaDonHang.setEditable(false);
        txtMaDonHang.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.add(txtMaDonHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 286, 30));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel33.setText("Mã đơn hàng");
        jPanel9.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        txtGiaSanPham.setEditable(false);
        txtGiaSanPham.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.add(txtGiaSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 286, 30));

        txtTenSanPham.setEditable(false);
        txtTenSanPham.setBackground(new java.awt.Color(255, 255, 255));
        txtTenSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSanPhamActionPerformed(evt);
            }
        });
        jPanel9.add(txtTenSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 286, 30));

        txtSoLuongSanPham.setEditable(false);
        txtSoLuongSanPham.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.add(txtSoLuongSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 286, 30));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel34.setText("Tên sản phẩm");
        jPanel9.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setText("Giá sản phẩm");
        jPanel9.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setText("Số lượng");
        jPanel9.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel38.setText("Đơn hàng chi tiết");
        jPanel9.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 152, -1));

        lblAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/person.png"))); // NOI18N
        lblAnh.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jPanel9.add(lblAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 205, 205));
        jPanel9.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 32, 140, 10));

        pnlDsdh.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, 340, 510));

        jPanel12.setBackground(new java.awt.Color(51, 102, 255));

        jLabel42.setBackground(new java.awt.Color(255, 255, 255));
        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Quản lý đơn hàng/ Danh sách đơn hàng/");

        jLabel43.setBackground(new java.awt.Color(255, 255, 255));
        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Danh sách đơn hàng________________________________________________________");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addComponent(jLabel43)))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel42)
                .addGap(11, 11, 11)
                .addComponent(jLabel43))
        );

        pnlDsdh.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 40, 1047, 76));

        pnlTab.add(pnlDsdh, "CardDsdh");

        pnlDskh.setBackground(new java.awt.Color(204, 204, 255));
        pnlDskh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlDskh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Tên KH", "Giới tính", "SDT", "Địa chỉ", "Email", "Người tạo", "Tổng đơn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblKhachHang);

        pnlDskh.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 1020, 470));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 255));
        jLabel21.setText("Quản lý đơn hàng/ Danh sách khách hàng/");

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 255));
        jLabel22.setText("Danh sách khách hàng________________________________________________________");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel21)
                .addGap(11, 11, 11)
                .addComponent(jLabel22))
        );

        pnlDskh.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 60, 1045, 76));

        pnlTab.add(pnlDskh, "CardDskh");

        getContentPane().add(pnlTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 1050, 640));

        pnlTitle.setBackground(new java.awt.Color(255, 255, 255));
        pnlTitle.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        pnlTitle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlTitleMouseDragged(evt);
            }
        });
        pnlTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlTitleMousePressed(evt);
            }
        });
        pnlTitle.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Backs.png"))); // NOI18N
        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBackMouseExited(evt);
            }
        });
        pnlTitle.add(lblBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 0, 70, 50));

        getContentPane().add(pnlTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 50));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKHActionPerformed

    private void txtTenSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSanPhamActionPerformed

    private void txtTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienActionPerformed

    private void lblQldhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQldhMouseEntered
        lblQldh.setBorder(white_border);
    }//GEN-LAST:event_lblQldhMouseEntered

    private void lblQldhMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQldhMouseExited
        lblQldh.setBorder(default_border);
    }//GEN-LAST:event_lblQldhMouseExited

    private void lblDsdhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDsdhMouseEntered
        lblDsdh.setBorder(white_border);
    }//GEN-LAST:event_lblDsdhMouseEntered

    private void lblDsdhMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDsdhMouseExited
        lblDsdh.setBorder(default_border);
    }//GEN-LAST:event_lblDsdhMouseExited

    private void lblDskhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDskhMouseEntered
        lblDskh.setBorder(white_border);
    }//GEN-LAST:event_lblDskhMouseEntered

    private void lblDskhMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDskhMouseExited
        lblDskh.setBorder(default_border);
    }//GEN-LAST:event_lblDskhMouseExited

    private void lblQldhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQldhMouseClicked
        chooserDefault(new Color(204, 255, 255), lblDsdh, lblQldh, lblDskh);
        if (evt.getClickCount() == 1) {
            clearDsDonHang();
            clearDonHang();
            card.show(pnlTab, "CardQldh");
            chooserList(new Color(153, 153, 255), lblQldh);
        }
    }//GEN-LAST:event_lblQldhMouseClicked

    private void lblDsdhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDsdhMouseClicked
        chooserDefault(new Color(204, 255, 255), lblDsdh, lblQldh, lblDskh);
        if (evt.getClickCount() == 1) {
            clearDsDonHang();
            clearDonHang();
            card.show(pnlTab, "CardDsdh");
            chooserList(new Color(153, 153, 255), lblDsdh);
            loadDSDH();
        }
    }//GEN-LAST:event_lblDsdhMouseClicked

    private void lblDskhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDskhMouseClicked
        chooserDefault(new Color(204, 255, 255), lblDsdh, lblQldh, lblDskh);
        if (evt.getClickCount() == 1) {
            clearDsDonHang();
            clearDonHang();
            card.show(pnlTab, "CardDskh");
            chooserList(new Color(153, 153, 255), lblDskh);
            loadKhachHang();
        }
    }//GEN-LAST:event_lblDskhMouseClicked

    private void pnlTitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTitleMouseDragged
        MouseDragged(evt, this);
    }//GEN-LAST:event_pnlTitleMouseDragged

    private void pnlTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTitleMousePressed
        moveFrom(evt);
    }//GEN-LAST:event_pnlTitleMousePressed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        chooserDefault(new Color(204, 255, 255), lblDsdh, lblQldh, lblDskh);
        if (evt.getClickCount() == 1) {
            card.show(pnlTab, "CardTrangChu");
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        dispose();
        FromChaQuanLy_JFrame ql = new FromChaQuanLy_JFrame();
        ql.setVisible(true);
    }//GEN-LAST:event_lblBackMouseClicked

    private void lblBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseEntered
        lblBack.setIcon(Back2);
    }//GEN-LAST:event_lblBackMouseEntered

    private void lblBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseExited
        lblBack.setIcon(Back1);
    }//GEN-LAST:event_lblBackMouseExited

    private void txtTenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKHActionPerformed

    private void txtMaKHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaKHFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKHFocusGained

    private void txtMaKHFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaKHFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKHFocusLost

    private void txtTenKHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenKHFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKHFocusGained

    private void txtTenKHFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenKHFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKHFocusLost

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
        setBackround(new Color(255, 204, 0), Color.darkGray, jButton7);
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseExited
        setBackround(new Color(255, 204, 0), Color.WHITE, jButton7);
    }//GEN-LAST:event_jButton7MouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        setBackround(new Color(51, 102, 255), Color.darkGray, jButton1);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        setBackround(new Color(255,102,51), Color.WHITE, jButton1);
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        new KhachHang_JFrame(true).setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void btnThemVaoGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVaoGioHangActionPerformed
        // TODO add your handling code here:
        
            try{
                setModelSPKho();
            }catch(Exception e){
                
            }
    }//GEN-LAST:event_btnThemVaoGioHangActionPerformed

    private void tblGioHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblGioHangKeyReleased
        // TODO add your handling code here:
        try {
            indexGioHang = tblGioHang.getSelectedRow();
            soLuong();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_tblGioHangKeyReleased

    private void tblGioHangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblGioHangKeyPressed
        // TODO add your handling code here:


    }//GEN-LAST:event_tblGioHangKeyPressed

    private void tblGioHangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblGioHangKeyTyped
        // TODO add your handling code here:


    }//GEN-LAST:event_tblGioHangKeyTyped

    private void tblGioHangPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblGioHangPropertyChange
        // TODO add your handling code here:


    }//GEN-LAST:event_tblGioHangPropertyChange

    private void tblGioHangInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tblGioHangInputMethodTextChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_tblGioHangInputMethodTextChanged

    private void tblGioHangVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_tblGioHangVetoableChange
        // TODO add your handling code here:

    }//GEN-LAST:event_tblGioHangVetoableChange

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if (!txtMaKH.getText().trim().isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) tblGioHang.getModel();
            if (model.getRowCount() > 0) {
                if (checkForm()) {
                    insert();
                    loadSPKho();
                }
            } else {
                DialogHelper.alert(null, "Vui lòng chọn sản phẩm");
            }
        } else {
            DialogHelper.alert(null, "Vui lòng chọn khách hàng");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        indexGioHang = tblGioHang.getSelectedRow();
        huyHang();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblDonHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDonHangMouseClicked
        // TODO add your handling code here:
        indexDonHang = tblDonHang.getSelectedRow();
        loadDonHangCT();
    }//GEN-LAST:event_tblDonHangMouseClicked

    private void tblDonHangCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDonHangCTMouseClicked
        // TODO add your handling code here:
        indexDonHangCT = tblDonHangCT.getSelectedRow();
        setModelDHCT();
    }//GEN-LAST:event_tblDonHangCTMouseClicked

    private void cboTrangThaiDHItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTrangThaiDHItemStateChanged
        // TODO add your handling code here:
        changeComboBoxDH();
    }//GEN-LAST:event_cboTrangThaiDHItemStateChanged

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        // TODO add your handling code here:
        indexGioHang = tblGioHang.getSelectedRow();
        click();
    }//GEN-LAST:event_tblGioHangMouseClicked

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
            java.util.logging.Logger.getLogger(QuanLyDonHang_JFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyDonHang_JFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyDonHang_JFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyDonHang_JFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyDonHang_JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgrGioiTinh;
    private javax.swing.JButton btnThemVaoGioHang;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboTrangThaiDH;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblDsdh;
    private javax.swing.JLabel lblDskh;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JLabel lblLoiMaKH;
    private javax.swing.JLabel lblLoiTenKH;
    private javax.swing.JLabel lblLoiTongTien;
    private javax.swing.JLabel lblQldh;
    private javax.swing.JPanel pnlDsdh;
    private javax.swing.JPanel pnlDskh;
    private javax.swing.JPanel pnlQldh;
    private javax.swing.JPanel pnlTab;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JTable tblDonHang;
    private javax.swing.JTable tblDonHangCT;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTable tblSPKho;
    private javax.swing.JTextField txtGiaSanPham;
    private javax.swing.JTextField txtMaDonHang;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSoLuongSanPham;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables

    //---------------------------------------------QUẢN LÝ ĐƠN HÀNG--------------------------------------------------------
    //Hàm chọn khách hàng
    void chooserCustom() {
        if (Auth.khachHang == null) {
            return;
        }
        Color(txtTenKH, "", Plain, Black);
        Color(txtMaKH, "", Plain, Black);
        KhachHang kh = Auth.khachHang;
        txtMaKH.setText(kh.getMaKH());
        txtTenKH.setText(kh.getTenKH());
    }

    //Hàm kiểm tra số lượng trong giỏ hàng có hợp lệ hay vượt quá số lượng trong kho không
    boolean checkForm() {
        DefaultTableModel model = (DefaultTableModel) tblGioHang.getModel();
        //Kiểm tra tính hợp lệ của số lượng trong Giỏ hàng
        for (int i = 0; i < model.getRowCount(); i++) {
            if (!ValidateHelper.checkSoLuongTB(String.valueOf(tblGioHang.getValueAt(i, 4)))) {
                tblGioHang.setRowSelectionInterval(i, i);
                DialogHelper.alert(null, "Số lượng sản phẩm " + String.valueOf(tblGioHang.getValueAt(i, 0)) + " không hợp lệ");
                return false;
            }
        }
        //Kiểm tra số lượng trong Giỏ hàng có vượt quá số lượng Sản phẩm kho hay ko
        DefaultTableModel model1 = (DefaultTableModel) tblSPKho.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model1.getRowCount(); j++) {
                if (String.valueOf(tblGioHang.getValueAt(i, 0)).equals(String.valueOf(tblSPKho.getValueAt(j, 0)))) {
                    int slGioHang = Integer.parseInt(String.valueOf(tblGioHang.getValueAt(i, 4)));
                    int slKho = Integer.parseInt(String.valueOf(tblSPKho.getValueAt(j, 4)));
                    if (slGioHang > slKho) {
                        tblGioHang.setRowSelectionInterval(i, i);
                        DialogHelper.alert(null, "Số lượng sản phẩm " + String.valueOf(tblGioHang.getValueAt(i, 0)) + "vượt quá số lượng kho");
                        return false;
                    }
                    
                    if(slGioHang == 0){
                        tblGioHang.setRowSelectionInterval(i, i);
                        DialogHelper.alert(null, "Số lượng sản phẩm " + String.valueOf(tblGioHang.getValueAt(i, 0)) + " phải lớn hơn 0");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //Hàm load sản phẩm kho lên bảng
    void loadSPKho() {
        DefaultTableModel model = (DefaultTableModel) tblSPKho.getModel();
        model.setRowCount(0);
        List<SPKho> list = daoSPKho.selectAll();
        for (SPKho sp : list) {
            String maSP = sp.getMaSPKho();

            int sl = sp.getSoLuong() - daoChungTuCT.soLuongAoTungSPDH(maSP) - daoChungTuCT.soLuongAoTungSPXH(maSP);

            Object[] ob = {maSP, sp.getTenSP(),
                sp.getLoaiSP(), sp.getGia(),
                sl, sp.getDonViTinh(),
                sp.getTenNCC()};
            model.addRow(ob);
        }
    }

    //Hàm tự cộng tổng tiền và số lượng khi thêm sản phẩm vào Giỏ hàng
    void setModelSPKho() {
        DefaultTableModel model = (DefaultTableModel) tblGioHang.getModel();
        int[] arrayIndexKho = tblSPKho.getSelectedRows();
        if(arrayIndexKho.length == 0){
            DialogHelper.alert(null, "Vui lòng chọn sản phẩm");
            return;
        }
        for(int i : arrayIndexKho ){
            String maSP = (String.valueOf(tblSPKho.getValueAt(i,0)));
            int slKho = Integer.parseInt(String.valueOf(tblSPKho.getValueAt(i, 4)));
            if (slKho == 0) {
                DialogHelper.alert(null, "Sản phẩm " + maSP + " hết hàng!");
                break;
            }

            boolean check = true;
            //Nếu có sản phẩm kho trùng với sản phẩm trên giỏ hàng
            for (int i2 = 0; i2 < model.getRowCount(); i2++) {
                if (String.valueOf(model.getValueAt(i2, 0)).equals(maSP)) {
                    i = i2;
                    check = false;
                    break;
                }
            }

            double tien = 0;
            //Nếu sản phẩm kho chưa xuất hiện trên giỏ hàng thì thêm mới vào giỏ hàng và cộng tổng tiền
            if (check == true) {
                SPKho sp = daoSPKho.selectById(maSP);
                Object[] ob = {sp.getMaSPKho(), sp.getTenSP(),
                    sp.getLoaiSP(), sp.getGia(),
                    1, sp.getDonViTinh(),
                    sp.getTenNCC()};
                model.addRow(ob);
                tien = Double.parseDouble(txtTongTien.getText().trim());
                tien += Double.parseDouble(String.valueOf(tblSPKho.getValueAt(i, 3))) * 1;
                txtTongTien.setText(String.valueOf(tien));
            } else {//Nếu sản phẩm thêm mới trùng với sản phẩm trên giỏ hàng thì cộng số lượng và tổng tiền
                //Nếu số lượng trong giỏ hàng không hợp lệ thì thông báo lỗi
                if (!ValidateHelper.checkSoLuongTB(String.valueOf(tblGioHang.getValueAt(i, 4)))) {
                    DialogHelper.alert(null, "Số lượng sản phẩm " + maSP + " trong giỏ hàng không hợp lệ");
                    tblGioHang.setRowSelectionInterval(i, i);
                    break;
                }

                //Cộng số lượng có sẵn trong giỏ hàng thêm cho 1
                int sl = Integer.parseInt(String.valueOf(tblGioHang.getValueAt(i, 4))) + 1;
                //Nếu số lượng nhập lớn hơn số lượng kho thì thông báo
                if (sl > slKho) {
                    DialogHelper.alert(null, "Sản phẩm " +maSP+" vượt quá số lượng trong kho");
                    tblGioHang.setRowSelectionInterval(i, i);
                } else if (sl == 0) {
                    DialogHelper.alert(null, "Số lượng sản phẩm " + maSP + " phải lớn hơn 0");
                    tblGioHang.setRowSelectionInterval(i, i);
                } else {
                    tblGioHang.setValueAt(sl, i, 4);

                    //Tính lại tổng tiền
                    for (int i2 = 0; i2 < model.getRowCount(); i2++) {
                        tien += Double.parseDouble(String.valueOf(model.getValueAt(i2, 3))) * Integer.parseInt(String.valueOf(model.getValueAt(i2, 4)));
                        txtTongTien.setText(String.valueOf(tien));
                    }
                }

            }
        }
        
    }

    //Tạo 1 đối tượng chứng từ
    ChungTu getModelChungTu() {
        ChungTu ct = new ChungTu();
        ct.setTenDangNhap(Auth.user.getTenDn());
        ct.setLoaiChungTu("Đơn hàng");
        ct.setNgayTao(DateHelper.now());
        ct.setTrangThai("Chờ duyệt");
        ct.setMaKH(txtMaKH.getText());
        ct.setNguoiDuyet(null);
        ct.setTongTien(Double.parseDouble(txtTongTien.getText().trim()));
        return ct;
    }

    //Kiểm tra tính hợp lệ hoặc số lượng trên giỏ hàng có vượt quá số lượng trong kho hay ko
    //Nếu tất cả điều kiện đều đúng thì cộng tổng tiền sản phẩm vào tổng tiền
    void soLuong() {
        if (indexGioHang != -1) {
            if (ValidateHelper.checkSoLuongTB(String.valueOf(tblGioHang.getValueAt(indexGioHang, 4)))) {
                String maSPGioHang = String.valueOf(tblGioHang.getValueAt(indexGioHang, 0));
                DefaultTableModel model = (DefaultTableModel) tblSPKho.getModel();
                int slKho = 0;
                //Lấy số lượng trên bảng Sản phẩm kho
                for (int i = 0; i < model.getRowCount(); i++) {
                    if (String.valueOf(tblSPKho.getValueAt(i, 0)).equals(maSPGioHang)) {
                        slKho = Integer.parseInt(String.valueOf(tblSPKho.getValueAt(i, 4)));
                        tblSPKho.setRowSelectionInterval(i, i);
                    }
                }

                //Giá và số lượng trong Giỏ hàng
                double gia = Double.parseDouble(String.valueOf(tblGioHang.getValueAt(indexGioHang, 3)));
                int sl = Integer.parseInt(String.valueOf(tblGioHang.getValueAt(indexGioHang, 4)));

                //Nếu số lượng nhập lớn hơn số lượng kho thì thông báo
                if (sl > slKho) {
                    DialogHelper.alert(null, "Vượt quá số lượng trong kho");
                }else if(sl == 0){
                    DialogHelper.alert(null, "Số lượng phải lớn hơn 0");
                
                } else {

                    double tien = 0;
                    //Tính lại tổng tiền
                    for (int i = 0; i < model.getRowCount(); i++) {
                        tien += Double.parseDouble(String.valueOf(tblGioHang.getValueAt(i, 3))) * Integer.parseInt(String.valueOf(tblGioHang.getValueAt(i, 4)));
                        txtTongTien.setText(String.valueOf(tien));
                    }
                }
            } else {
                DialogHelper.alert(null, "Chỉ nhập số lớn hơn 0");
            }
        }
    }

    void click(){
        String maSPGioHang = String.valueOf(tblGioHang.getValueAt(indexGioHang, 0));
        DefaultTableModel model = (DefaultTableModel) tblSPKho.getModel();
                //Lấy số lượng trên bảng Sản phẩm kho
         for (int i = 0; i < model.getRowCount(); i++) {
            if (String.valueOf(tblSPKho.getValueAt(i, 0)).equals(maSPGioHang)) {
                tblSPKho.setRowSelectionInterval(i, i);
            }
        }
    }
    //Hủy sản phẩm đang chọn trên giỏ hàng
    void huyHang() {
        if (indexGioHang == -1) {
            DialogHelper.alert(null, "Vui lòng chọn sản phẩm trên giỏ hàng");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tblGioHang.getModel();
        DefaultTableModel model1 = (DefaultTableModel) tblSPKho.getModel();
        
        int slGioHang = 0;
        try{
            slGioHang = Integer.parseInt(String.valueOf(model.getValueAt(indexGioHang, 4)));
        }catch(Exception e){
            model.removeRow(indexGioHang);
            double tien = 0;
            //Tính lại tổng tiền
            for (int i = 0; i < model.getRowCount(); i++) {
                tien += Double.parseDouble(String.valueOf(model.getValueAt(i, 3))) * Integer.parseInt(String.valueOf(model.getValueAt(i, 4)));
                txtTongTien.setText(String.valueOf(tien));
            }
        }
        
        int slKho = 0;
        for (int i = 0; i < model1.getRowCount(); i++) {
            if (String.valueOf(model.getValueAt(indexGioHang, 0)).equals(String.valueOf(model1.getValueAt(i, 0)))) {
                slKho = Integer.parseInt(String.valueOf(model1.getValueAt(i, 4)));
            }
        }
        
        model.removeRow(indexGioHang);
        double tien = 0;
        //Tính lại tổng tiền
        for (int i = 0; i < model.getRowCount(); i++) {
            tien += Double.parseDouble(String.valueOf(model.getValueAt(i, 3))) * Integer.parseInt(String.valueOf(model.getValueAt(i, 4)));
            txtTongTien.setText(String.valueOf(tien));
        }
        
        if(model.getRowCount() == 0){
            txtTongTien.setText("0");
        }

    }

    //Tạo chứng từ và chứng từ chi tiết
    void insert() {
        ChungTu ct = getModelChungTu();
        String maCT = daoChungTu.insert(ct);
        int count = tblGioHang.getRowCount();
        if (maCT != null) {
            for (int i = 0; i < count; i++) {
                String maSP = String.valueOf(tblGioHang.getValueAt(i, 0));
                SPKho sp = daoSPKho.selectById(maSP);
                ChungTuCT ctt = new ChungTuCT();
                ctt.setMaChungTu(maCT);
                ctt.setMaSP(sp.getMaSPKho());
                ctt.setTenSP(sp.getTenSP());
                ctt.setLoaiSP(sp.getLoaiSP());
                ctt.setGia(sp.getGia());
                ctt.setSoLuong(Integer.parseInt(String.valueOf(tblGioHang.getValueAt(i, 4))));
                ctt.setDonViTinh(sp.getDonViTinh());
                ctt.setTenNCC(sp.getTenNCC());
                ctt.setMaLoHang(sp.getMaLoHang());
                ctt.setNgayNhap(sp.getNgayNhap());
                ctt.setHinh(sp.getHinh());
                ctt.setMoTa(null);
                if (daoChungTuCT.insert(ctt) == 0) {
                    DialogHelper.alert(null, "Thêm thất bại");
                    break;
                }
            }
            DialogHelper.alert(null, "Đơn hàng của bạn đã được tạo!");
            clear();
        }
    }

    //Hàm làm mới form
    void clear() {
        DefaultTableModel model = (DefaultTableModel) tblGioHang.getModel();
        model.setRowCount(0);
        txtMaKH.setText("");
        txtTenKH.setText("");
        txtTongTien.setText("0");
        Auth.clearKhachHang();
    }

    //----------------------------------------------DANH SÁCH ĐƠN HÀNG-----------------------------------------------------------------
    //Hiển thị dữ liệu các đơn hàng lên bảng
    void loadDSDH() {
        DefaultTableModel model = (DefaultTableModel) tblDonHang.getModel();
        model.setRowCount(0);
        List<ChungTu> list = daoChungTu.selectDonHang();
        for (ChungTu ct : list) {
            Object[] ob = {ct.getMaChungTu(), ct.getTenDangNhap(), ct.getLoaiChungTu(), ct.getNgayTao(), ct.getTrangThai(), ct.getMaKH(), ct.getNguoiDuyet(), ct.getTongTien()};
            model.addRow(ob);
        }
    }

    //Hiển thị dữ liệu các đơn hàng chưa duyệt lên bảng
    void loadDSDHChuaDuyet() {
        DefaultTableModel model = (DefaultTableModel) tblDonHang.getModel();
        model.setRowCount(0);
        List<ChungTu> list = daoChungTu.selectDuyetDonHang();
        for (ChungTu ct : list) {
            Object[] ob = {ct.getMaChungTu(), ct.getTenDangNhap(), ct.getLoaiChungTu(), ct.getNgayTao(), ct.getTrangThai(), ct.getMaKH(), ct.getNguoiDuyet(), ct.getTongTien()};
            model.addRow(ob);
        }
    }

    //Hiển thị dữ liệu các đơn hàng đã duyệt lên bảng
    void loadDSDHĐaDuyet() {
        DefaultTableModel model = (DefaultTableModel) tblDonHang.getModel();
        model.setRowCount(0);
        List<ChungTu> list = daoChungTu.selectDaDuyetDonHang();
        for (ChungTu ct : list) {
            Object[] ob = {ct.getMaChungTu(), ct.getTenDangNhap(), ct.getLoaiChungTu(), ct.getNgayTao(), ct.getTrangThai(), ct.getMaKH(), ct.getNguoiDuyet(), ct.getTongTien()};
            model.addRow(ob);
        }
    }

    //Hiển thị các đơn hàng chi tiết lên bảng
    void loadDonHangCT() {
        DefaultTableModel model = (DefaultTableModel) tblDonHangCT.getModel();
        model.setRowCount(0);
        String mct = String.valueOf(tblDonHang.getValueAt(indexDonHang, 0));
        List<ChungTuCT> list = daoChungTuCT.selectByConditions(mct);
        for (ChungTuCT ct : list) {
            Object[] ob = {ct.getMaChungTu(), ct.getMaSP(),
                ct.getTenSP(), ct.getLoaiSP(),
                ct.getGia(), ct.getSoLuong(),
                ct.getDonViTinh(), ct.getTenNCC(),
                ct.getHinh()};
            model.addRow(ob);
        }
    }

    //Hiển thị 1 đối tượng đơn hàng chi tiết lên form
    void setModelDHCT() {
        txtMaDonHang.setText(String.valueOf(tblDonHangCT.getValueAt(indexDonHangCT, 1)));
        txtTenSanPham.setText(String.valueOf(tblDonHangCT.getValueAt(indexDonHangCT, 2)));
        txtGiaSanPham.setText(String.valueOf(tblDonHangCT.getValueAt(indexDonHangCT, 4)));
        txtSoLuongSanPham.setText(String.valueOf(tblDonHangCT.getValueAt(indexDonHangCT, 5)));
        ImageIcon anh = ImageHelper.read(String.valueOf(tblDonHangCT.getValueAt(indexDonHangCT, 8)));
        lblAnh.setIcon(anh);
        lblAnh.setToolTipText(String.valueOf(String.valueOf(tblDonHangCT.getValueAt(indexDonHangCT, 8)))); //Giữ tên hình trong tooltip
    }

    //Tải lại bảng khi chọn vào comboBox Trạng thái
    void changeComboBoxDH() {
        if (cboTrangThaiDH.getSelectedIndex() == 0) {
            loadDSDH();
        } else if (cboTrangThaiDH.getSelectedIndex() == 1) {
            loadDSDHChuaDuyet();
        } else {
            loadDSDHĐaDuyet();
        }
    }

    //-----------------------------------------------KHÁCH HÀNG-----------------------------------------------------
    //Hiển thị toàn bộ dữ liệu của khách hàng
    void loadKhachHang() {
        DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
        model.setRowCount(0);
        List<KhachHang> list = daoKhachHang.selectAll();
        for (KhachHang kh : list) {
            String gioiTinh = null;
            if (kh.getGioiTinh() == 0) {
                gioiTinh = "Nam";
            } else if (kh.getGioiTinh() == 1) {
                gioiTinh = "Nữ";

            } else {
                gioiTinh = "Khác";
            }
            int soLuong = daoKhachHang.tongDon(kh.getMaKH());
            Object[] ob = {kh.getMaKH(), kh.getTenKH(),
                gioiTinh, kh.getSDT(),
                kh.getDiaChi(), kh.getEmail(),
                kh.getTenDangNhap(), soLuong};
            model.addRow(ob);
        }
    }

    void clearDonHang() {
        txtMaKH.setText("");
        txtTenKH.setText("");
        txtTongTien.setText("");
    }

    void clearDsDonHang() {
        txtMaDonHang.setText("");
        txtTenSanPham.setText("");
        txtGiaSanPham.setText("");
        txtSoLuongSanPham.setText("");
    }
}
