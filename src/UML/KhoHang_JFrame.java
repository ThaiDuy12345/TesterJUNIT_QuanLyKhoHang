/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import Dao.*;
import static Help.ColorHelper.*;
import Help.DialogHelper;
import static Help.ValidateHelper.*;
import static Help.DialogHelper.*;
import Help.ImageHelper;
import java.io.File;
import java.util.List;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import static Help.ImageHelper.*;
import Model.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author hp
 */
public class KhoHang_JFrame extends javax.swing.JFrame {

    /**
     * Creates new form SanPhamCungCap_JFrame
     */
    public KhoHang_JFrame(int a) {
        numberTab = a;
        initComponents();
        init1();
        init2();
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    int countNCC = cboMaNCCCNSP.getModel().getSize() - 1;
                    int countLoaiSP = cboIDSPCC.getModel().getSize() - 1;
                    if (countLoaiSP < daoLoaiSP.countLoaiSP() || countLoaiSP > daoLoaiSP.countLoaiSP()) {
                        fillComboBoxLPNCC();
                    }
                    if (countNCC < daoNCC.countNhaCungCap() || countNCC > daoNCC.countNhaCungCap()) {
                        fillComboBoxNCC();
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
    }

    public KhoHang_JFrame() {
        initComponents();
        init();
        init1();
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    int countNCC = cboMaNCCCNSP.getModel().getSize() - 1;
                    int countLoaiSP = cboIDSPCC.getModel().getSize() - 1;
                    if (countLoaiSP < daoLoaiSP.countLoaiSP() || countLoaiSP > daoLoaiSP.countLoaiSP()) {
                        fillComboBoxLPNCC();
                    }
                    if (countNCC < daoNCC.countNhaCungCap() || countNCC > daoNCC.countNhaCungCap()) {
                        fillComboBoxNCC();
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
    }

    JFileChooser fileChooser = new JFileChooser();
    CardLayout card, card1;
    LoaiSPDAO daoLoaiSP = new LoaiSPDAO();
    LoHangDAO daoLoHang = new LoHangDAO();
    NhaCungCapDAO daoNCC = new NhaCungCapDAO();
    SPCungCapDAO daoSPCC = new SPCungCapDAO();
    int indexLoaiSP = 0;
    int indexLoHang = 0;
    int indexNCC = 0;
    int indexSPCC = 0;
    List<JButton> listBtnLoaiSP = new ArrayList<>();
    List<JButton> listBtnLoHang = new ArrayList<>();
    List<JButton> listBtnNhaCC = new ArrayList<>();
    List<JButton> listBtnSPCC = new ArrayList<>();
    int numberTab;

    void init() {
        card = (CardLayout) pnlTab.getLayout();
        card1 = (CardLayout) pnlTabCnDs.getLayout();
        card.show(pnlTab, "pnlCardTrangChu");
    }

    void init1() {
        designTable(false, new Color(0, 102, 255), Color.white, Plain, tblSPCC);
        designTable(false, new Color(0, 102, 255), Color.white, Plain, tblLoaiSP);
        designTable(false, new Color(0, 102, 255), Color.white, Plain, tblLoHang);
        designTable(false, new Color(0, 102, 255), Color.white, Plain, tblNhaCungCap);
        listBtnLoaiSP.add(0, btnInsertLoaiSP);
        listBtnLoaiSP.add(1, btnUpdateLoaiSP);
        listBtnLoaiSP.add(2, btnDeleteLoaiSP);
        listBtnLoaiSP.add(3, btnFirstLoaiSP);
        listBtnLoaiSP.add(4, btnPrevLoaiSP);
        listBtnLoaiSP.add(5, btnNextLoaiSP);
        listBtnLoaiSP.add(6, btnLastLoaiSP);

        listBtnLoHang.add(0, btnInsertLH);
        listBtnLoHang.add(1, btnUpdateLH);
        listBtnLoHang.add(2, btnDeleteLH);
        listBtnLoHang.add(3, btnFistLH);
        listBtnLoHang.add(4, btnPrevLH);
        listBtnLoHang.add(5, btnNextLH);
        listBtnLoHang.add(6, btnLastLH);

        listBtnNhaCC.add(0, btnInsertNhaCC);
        listBtnNhaCC.add(1, btnUpdateNhaCC);
        listBtnNhaCC.add(2, btnDeleteNhaCC);
        listBtnNhaCC.add(3, btnFirstNhaCC);
        listBtnNhaCC.add(4, btnPrevNhaCC);
        listBtnNhaCC.add(5, btnNextNhaCC);
        listBtnNhaCC.add(6, btnLastNhaCC);

        listBtnSPCC.add(0, btnInsertSPCC);
        listBtnSPCC.add(1, btnUpdateSPCC);
        listBtnSPCC.add(2, btnDeleteSPCC);
        listBtnSPCC.add(3, btnFirstSPCC);
        listBtnSPCC.add(4, btnPrevSPCC);
        listBtnSPCC.add(5, btnNextSPCC);
        listBtnSPCC.add(6, btnLastSPCC);

        loadLoaiSP();
        setStatus(true, txtIDLoaiSP, indexLoaiSP, tblLoaiSP, listBtnLoaiSP);
        loadLoHang();
        setStatus(true, txtMaLH, indexLoHang, tblLoHang, listBtnLoHang);
        loadNhaCungCap();
        setStatus(true, txtMaNhaCC, indexNCC, tblNhaCungCap, listBtnNhaCC);
        loadSPCC();
        fillComboBoxNCC();
        fillComboBoxLPNCC();
        setStatus(true, txtMaSPCC, indexSPCC, tblSPCC, listBtnSPCC);
    }

    void init2() {
        if (numberTab == 0) {
            card = (CardLayout) pnlTab.getLayout();
            card1 = (CardLayout) pnlTabCnDs.getLayout();
            card.show(pnlTab, "CardLoading");
            card1.show(pnlTabCnDs, "CardNhaCcc");
            chooserList(new Color(153, 153, 255), lblNhaCungCap);
        }
        if (numberTab == 1) {
            card = (CardLayout) pnlTab.getLayout();
            card1 = (CardLayout) pnlTabCnDs.getLayout();
            card.show(pnlTab, "CardLoading");
            card1.show(pnlTabCnDs, "CardSpp");
            chooserList(new Color(153, 153, 255), lblSpCungCap);
        }
        if (numberTab == 2) {
            card = (CardLayout) pnlTab.getLayout();
            card1 = (CardLayout) pnlTabCnDs.getLayout();
            card.show(pnlTab, "CardLoading");
            card1.show(pnlTabCnDs, "CardLoHangg");
            chooserList(new Color(153, 153, 255), lblLoHang);
        }
        if (numberTab == 3) {
            card = (CardLayout) pnlTab.getLayout();
            card1 = (CardLayout) pnlTabCnDs.getLayout();
            card.show(pnlTab, "CardLoading");
            card1.show(pnlTabCnDs, "CardLoaiSpp");
            chooserList(new Color(153, 153, 255), lblLoaiSp);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblSpCungCap = new javax.swing.JLabel();
        lblNhaCungCap = new javax.swing.JLabel();
        lblLoaiSp = new javax.swing.JLabel();
        lblLoHang = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        pnlTabCnDs = new keeptoo.KGradientPanel();
        pnlCardTrangChu1 = new keeptoo.KGradientPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        pnlCardLoHang = new keeptoo.KGradientPanel();
        pnlCardTrangChu2 = new keeptoo.KGradientPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        lblDanhSachLh = new javax.swing.JLabel();
        lblCapNhatLh = new javax.swing.JLabel();
        pnlCardSpCc = new keeptoo.KGradientPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        lblDanhSachSp = new javax.swing.JLabel();
        lblCapNhatSp = new javax.swing.JLabel();
        pnlCardNhaCc = new keeptoo.KGradientPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblDanhSachTab = new javax.swing.JLabel();
        lblCapNhatTab = new javax.swing.JLabel();
        pnlCardLoaiSP = new keeptoo.KGradientPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        lblLoaiSp1 = new javax.swing.JLabel();
        pnlTab = new javax.swing.JPanel();
        pnlCardLoading = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        pnlCardTrangChu = new keeptoo.KGradientPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlCardDanhSachSpCc = new keeptoo.KGradientPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSPCC = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtTimKiemSPCC = new javax.swing.JTextField();
        lblExcel = new javax.swing.JLabel();
        pnlCardCapNhatSp = new keeptoo.KGradientPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblMaSP = new javax.swing.JLabel();
        lblLoiMaNhaCCSPCC = new javax.swing.JLabel();
        txtMaSPCC = new javax.swing.JTextField();
        lblLoiMaSPCC = new javax.swing.JLabel();
        lblMaSP1 = new javax.swing.JLabel();
        lblMaSP2 = new javax.swing.JLabel();
        txtTenSPCC = new javax.swing.JTextField();
        lblLoiTenSPCC = new javax.swing.JLabel();
        lblMaSP3 = new javax.swing.JLabel();
        txtGiaSPCC = new javax.swing.JTextField();
        lblLoiGiaSPCC = new javax.swing.JLabel();
        lblMaSP4 = new javax.swing.JLabel();
        txtDonVTSPCC = new javax.swing.JTextField();
        lblLoiDonVTSPCC = new javax.swing.JLabel();
        lblMaSP5 = new javax.swing.JLabel();
        lblLoiIDSPCC = new javax.swing.JLabel();
        lblHinhSPCC = new javax.swing.JLabel();
        btnInsertSPCC = new javax.swing.JButton();
        btnFirstSPCC = new javax.swing.JButton();
        btnPrevSPCC = new javax.swing.JButton();
        btnDeleteSPCC = new javax.swing.JButton();
        btnUpdateSPCC = new javax.swing.JButton();
        btnNextSPCC = new javax.swing.JButton();
        btnLastSPCC = new javax.swing.JButton();
        btnNewSPCC = new javax.swing.JButton();
        lblLoiHinhSPCC = new javax.swing.JLabel();
        cboMaNCCCNSP = new javax.swing.JComboBox<>();
        cboIDSPCC = new javax.swing.JComboBox<>();
        pnlCardLoaiSp = new keeptoo.KGradientPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLoaiSP = new javax.swing.JTable();
        btnFirstLoaiSP = new javax.swing.JButton();
        btnPrevLoaiSP = new javax.swing.JButton();
        btnNextLoaiSP = new javax.swing.JButton();
        btnLastLoaiSP = new javax.swing.JButton();
        btnInsertLoaiSP = new javax.swing.JButton();
        btnDeleteLoaiSP = new javax.swing.JButton();
        btnNewLoaiSP = new javax.swing.JButton();
        btnUpdateLoaiSP = new javax.swing.JButton();
        lblMaSP8 = new javax.swing.JLabel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        lblMaSP6 = new javax.swing.JLabel();
        txtLoaiSP = new javax.swing.JTextField();
        lblLoiIDLoaiSP = new javax.swing.JLabel();
        txtIDLoaiSP = new javax.swing.JTextField();
        lblMaSP7 = new javax.swing.JLabel();
        lblLoiLoaiSP = new javax.swing.JLabel();
        lblMaSP9 = new javax.swing.JLabel();
        pnlDanhSachLoHang = new keeptoo.KGradientPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtTimKiemLH = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblLoHang = new javax.swing.JTable();
        pnlCapNhatLoHang = new keeptoo.KGradientPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lblMaSP10 = new javax.swing.JLabel();
        txtMaLH = new javax.swing.JTextField();
        lblLoiMaLH = new javax.swing.JLabel();
        lblMaSP11 = new javax.swing.JLabel();
        txtTenLH = new javax.swing.JTextField();
        lblLoiTenLoHang = new javax.swing.JLabel();
        lblMaSP12 = new javax.swing.JLabel();
        txtViTriLH = new javax.swing.JTextField();
        lblLoiViTriLH = new javax.swing.JLabel();
        lblMaSP13 = new javax.swing.JLabel();
        lblLoiMoTaLH = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoLH = new javax.swing.JTextArea();
        btnInsertLH = new javax.swing.JButton();
        btnDeleteLH = new javax.swing.JButton();
        btnUpdateLH = new javax.swing.JButton();
        btnNewLH = new javax.swing.JButton();
        btnFistLH = new javax.swing.JButton();
        btnLastLH = new javax.swing.JButton();
        btnNextLH = new javax.swing.JButton();
        btnPrevLH = new javax.swing.JButton();
        pnlCradDanhSachNhaCC = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblNhaCungCap = new javax.swing.JTable();
        txtTimKiemNhaCC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pnlCardCapNhatNhaCC = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        lblMaSP14 = new javax.swing.JLabel();
        lblMaSP15 = new javax.swing.JLabel();
        lblMaSP16 = new javax.swing.JLabel();
        lblMaSP17 = new javax.swing.JLabel();
        lblMaSP18 = new javax.swing.JLabel();
        txtMaNhaCC = new javax.swing.JTextField();
        txtTenNhaCC = new javax.swing.JTextField();
        txtSDTNhaCC = new javax.swing.JTextField();
        txtEmailNhaCC = new javax.swing.JTextField();
        txtDiaChiNhaCC = new javax.swing.JTextField();
        lblLoiTenDangNhap = new javax.swing.JLabel();
        btnInsertNhaCC = new javax.swing.JButton();
        btnFirstNhaCC = new javax.swing.JButton();
        btnPrevNhaCC = new javax.swing.JButton();
        btnNextNhaCC = new javax.swing.JButton();
        btnLastNhaCC = new javax.swing.JButton();
        btnNewNhaCC = new javax.swing.JButton();
        btnUpdateNhaCC = new javax.swing.JButton();
        btnDeleteNhaCC = new javax.swing.JButton();
        lblLoiDiaChiNhaCC = new javax.swing.JLabel();
        lblLoiMaNhaCC = new javax.swing.JLabel();
        lblLoiTenNhaCC = new javax.swing.JLabel();
        lblLoiSDTNhaCC = new javax.swing.JLabel();
        lblLoiEmailNhaCC = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        kGradientPanel1.setkEndColor(new java.awt.Color(0, 51, 102));
        kGradientPanel1.setkStartColor(new java.awt.Color(102, 153, 255));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Sp_Icon.png"))); // NOI18N
        jLabel1.setText("Kho hàng");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 240, 40));

        jSeparator1.setOpaque(true);
        kGradientPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 58, 210, -1));

        lblSpCungCap.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSpCungCap.setForeground(new java.awt.Color(204, 255, 255));
        lblSpCungCap.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSpCungCap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/type.png"))); // NOI18N
        lblSpCungCap.setText("Sản phẩm cung cấp");
        lblSpCungCap.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        lblSpCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSpCungCapMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSpCungCapMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSpCungCapMouseExited(evt);
            }
        });
        kGradientPanel1.add(lblSpCungCap, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 260, 100));

        lblNhaCungCap.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNhaCungCap.setForeground(new java.awt.Color(204, 255, 255));
        lblNhaCungCap.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNhaCungCap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/type.png"))); // NOI18N
        lblNhaCungCap.setText("Nhà cung cấp");
        lblNhaCungCap.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        lblNhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNhaCungCapMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblNhaCungCapMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblNhaCungCapMouseExited(evt);
            }
        });
        kGradientPanel1.add(lblNhaCungCap, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 260, 100));

        lblLoaiSp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLoaiSp.setForeground(new java.awt.Color(204, 255, 255));
        lblLoaiSp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiSp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/type.png"))); // NOI18N
        lblLoaiSp.setText("Loại sản phẩm");
        lblLoaiSp.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        lblLoaiSp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoaiSpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLoaiSpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLoaiSpMouseExited(evt);
            }
        });
        kGradientPanel1.add(lblLoaiSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 260, 100));

        lblLoHang.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLoHang.setForeground(new java.awt.Color(204, 255, 255));
        lblLoHang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/type.png"))); // NOI18N
        lblLoHang.setText("Lô hàng");
        lblLoHang.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        lblLoHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLoHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLoHangMouseExited(evt);
            }
        });
        kGradientPanel1.add(lblLoHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 260, 100));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 1, new java.awt.Color(0, 0, 0)));
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

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Backs.png"))); // NOI18N
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel30MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel30MouseExited(evt);
            }
        });
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 90, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 50));

        pnlTabCnDs.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        pnlTabCnDs.setkEndColor(new java.awt.Color(0, 51, 102));
        pnlTabCnDs.setkGradientFocus(1000);
        pnlTabCnDs.setkStartColor(new java.awt.Color(102, 153, 255));
        pnlTabCnDs.setLayout(new java.awt.CardLayout());

        pnlCardTrangChu1.setkEndColor(new java.awt.Color(51, 51, 255));
        pnlCardTrangChu1.setkStartColor(new java.awt.Color(51, 51, 255));
        pnlCardTrangChu1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 102, 255));
        jLabel25.setText("Kho hàng/ Trang chủ/");

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 102, 255));
        jLabel28.setText("Trang chủ");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel25)
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(jLabel28)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 190, 79));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/nvKhoHang.png"))); // NOI18N
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 90, 190, 390));

        pnlCardTrangChu1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 51, 190, 500));

        pnlTabCnDs.add(pnlCardTrangChu1, "CardTrangChu1");

        pnlCardLoHang.setkStartColor(new java.awt.Color(51, 51, 255));
        pnlCardLoHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCardTrangChu2.setkEndColor(new java.awt.Color(51, 51, 255));
        pnlCardTrangChu2.setkStartColor(new java.awt.Color(51, 51, 255));
        pnlCardTrangChu2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlCardLoHang.add(pnlCardTrangChu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel14.setBackground(new java.awt.Color(102, 102, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        jPanel15.setLayout(new java.awt.GridLayout(1, 0));

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/LoHang.png"))); // NOI18N
        jLabel27.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel15.add(jLabel27);

        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 190, 140));

        lblDanhSachLh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDanhSachLh.setForeground(new java.awt.Color(204, 255, 255));
        lblDanhSachLh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDanhSachLh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/list-lohang.png"))); // NOI18N
        lblDanhSachLh.setText("Danh sách lô hàng");
        lblDanhSachLh.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        lblDanhSachLh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDanhSachLhMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDanhSachLhMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDanhSachLhMouseExited(evt);
            }
        });
        jPanel14.add(lblDanhSachLh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 190, 70));
        lblDanhSachLh.getAccessibleContext().setAccessibleName("pnlDanhSachLh");

        lblCapNhatLh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCapNhatLh.setForeground(new java.awt.Color(204, 255, 255));
        lblCapNhatLh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCapNhatLh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/update-lohang.png"))); // NOI18N
        lblCapNhatLh.setText("Cập nhật lô hàng");
        lblCapNhatLh.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        lblCapNhatLh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCapNhatLhMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCapNhatLhMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCapNhatLhMouseExited(evt);
            }
        });
        jPanel14.add(lblCapNhatLh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 190, 70));

        pnlCardLoHang.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 51, 190, 500));

        pnlTabCnDs.add(pnlCardLoHang, "CardLoHangg");

        pnlCardSpCc.setkStartColor(new java.awt.Color(51, 51, 255));
        pnlCardSpCc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBackground(new java.awt.Color(102, 102, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        jPanel17.setLayout(new java.awt.GridLayout(1, 0));

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/SpCc.png"))); // NOI18N
        jLabel26.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel17.add(jLabel26);

        jPanel16.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 150));

        lblDanhSachSp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDanhSachSp.setForeground(new java.awt.Color(204, 255, 255));
        lblDanhSachSp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDanhSachSp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/list.png"))); // NOI18N
        lblDanhSachSp.setText("Danh sách sản phẩm");
        lblDanhSachSp.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        lblDanhSachSp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDanhSachSpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDanhSachSpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDanhSachSpMouseExited(evt);
            }
        });
        jPanel16.add(lblDanhSachSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 190, 70));

        lblCapNhatSp.setBackground(new java.awt.Color(153, 153, 255));
        lblCapNhatSp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCapNhatSp.setForeground(new java.awt.Color(204, 255, 255));
        lblCapNhatSp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCapNhatSp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/edit1.png"))); // NOI18N
        lblCapNhatSp.setText("Cập nhật sản phẩm");
        lblCapNhatSp.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        lblCapNhatSp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCapNhatSpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCapNhatSpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCapNhatSpMouseExited(evt);
            }
        });
        jPanel16.add(lblCapNhatSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 190, 70));

        pnlCardSpCc.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 51, 190, 500));

        pnlTabCnDs.add(pnlCardSpCc, "CardSpp");

        pnlCardNhaCc.setBackground(new java.awt.Color(51, 51, 255));
        pnlCardNhaCc.setkStartColor(new java.awt.Color(51, 51, 255));
        pnlCardNhaCc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel18.setBackground(new java.awt.Color(102, 102, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBackground(new java.awt.Color(51, 51, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/nhaCc.png"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        jLabel4.setOpaque(true);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );

        jPanel18.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 190, 140));

        lblDanhSachTab.setBackground(new java.awt.Color(0, 102, 204));
        lblDanhSachTab.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDanhSachTab.setForeground(new java.awt.Color(204, 255, 255));
        lblDanhSachTab.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDanhSachTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/dsNhaCC_Icon.png"))); // NOI18N
        lblDanhSachTab.setText("Danh sách");
        lblDanhSachTab.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        lblDanhSachTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDanhSachTabMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDanhSachTabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDanhSachTabMouseExited(evt);
            }
        });
        jPanel18.add(lblDanhSachTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 190, 70));

        lblCapNhatTab.setBackground(new java.awt.Color(0, 102, 204));
        lblCapNhatTab.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCapNhatTab.setForeground(new java.awt.Color(204, 255, 255));
        lblCapNhatTab.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCapNhatTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/rsz_6198d8fe351bf.png"))); // NOI18N
        lblCapNhatTab.setText("Cập nhật");
        lblCapNhatTab.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        lblCapNhatTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCapNhatTabMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCapNhatTabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCapNhatTabMouseExited(evt);
            }
        });
        jPanel18.add(lblCapNhatTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 190, 70));

        pnlCardNhaCc.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 190, 500));

        pnlTabCnDs.add(pnlCardNhaCc, "CardNhaCcc");

        pnlCardLoaiSP.setkStartColor(new java.awt.Color(51, 51, 255));
        pnlCardLoaiSP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel20.setBackground(new java.awt.Color(102, 102, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/typeProduct.png"))); // NOI18N
        jLabel24.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanel20.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 190, 150));

        lblLoaiSp1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLoaiSp1.setForeground(new java.awt.Color(204, 255, 255));
        lblLoaiSp1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiSp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/type.png"))); // NOI18N
        lblLoaiSp1.setText("Loại sản phẩm");
        lblLoaiSp1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        lblLoaiSp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoaiSp1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLoaiSp1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLoaiSp1MouseExited(evt);
            }
        });
        jPanel20.add(lblLoaiSp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 190, 70));

        pnlCardLoaiSP.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 190, 500));

        pnlTabCnDs.add(pnlCardLoaiSP, "CardLoaiSpp");

        getContentPane().add(pnlTabCnDs, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 190, 550));

        pnlTab.setBackground(new java.awt.Color(255, 255, 255));
        pnlTab.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));
        pnlTab.setLayout(new java.awt.CardLayout());

        pnlCardLoading.setBackground(new java.awt.Color(255, 255, 255));
        pnlCardLoading.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setBackground(new java.awt.Color(51, 51, 255));
        jLabel19.setOpaque(true);
        pnlCardLoading.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 50));

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/loadDing.gif"))); // NOI18N
        jLabel23.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        pnlCardLoading.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 750, 500));

        pnlTab.add(pnlCardLoading, "CardLoading");

        pnlCardTrangChu.setkEndColor(new java.awt.Color(255, 255, 255));
        pnlCardTrangChu.setkStartColor(new java.awt.Color(51, 51, 255));
        pnlCardTrangChu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 255));
        jLabel20.setText("________________________________________________________________________");
        jLabel20.setToolTipText("");
        jPanel9.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 38, 790, 20));

        pnlCardTrangChu.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 51, 750, 75));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/KhoHang.png"))); // NOI18N
        jLabel2.setOpaque(true);
        pnlCardTrangChu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 750, 430));

        pnlTab.add(pnlCardTrangChu, "pnlCardTrangChu");

        pnlCardDanhSachSpCc.setkEndColor(new java.awt.Color(255, 255, 255));
        pnlCardDanhSachSpCc.setkStartColor(new java.awt.Color(51, 51, 255));
        pnlCardDanhSachSpCc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 255));
        jLabel7.setText("Kho hàng/ Sản phẩm cung cấp/ Danh sách sản phẩm/");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 255));
        jLabel8.setText("Danh sách sản phẩm________________________________________________________");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(16, 16, 16))
        );

        pnlCardDanhSachSpCc.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, 79));

        tblSPCC.setModel(new javax.swing.table.DefaultTableModel(
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
                "Mã sản phẩm cung cấp", "Mã nhà cung cấp", "Tên sản phẩm", "ID", "Giá sản phẩm", "Đơn vị tính", "Hình"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSPCC.setRowHeight(25);
        tblSPCC.setSelectionBackground(new java.awt.Color(255, 102, 153));
        tblSPCC.setShowVerticalLines(false);
        tblSPCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPCCMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSPCC);
        if (tblSPCC.getColumnModel().getColumnCount() > 0) {
            tblSPCC.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblSPCC.getColumnModel().getColumn(3).setPreferredWidth(2);
            tblSPCC.getColumnModel().getColumn(5).setPreferredWidth(25);
            tblSPCC.getColumnModel().getColumn(6).setPreferredWidth(50);
        }

        pnlCardDanhSachSpCc.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 188, 729, 350));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/find.png"))); // NOI18N
        pnlCardDanhSachSpCc.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 135, -1, 40));

        txtTimKiemSPCC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTimKiemSPCC.setForeground(new java.awt.Color(153, 153, 153));
        txtTimKiemSPCC.setText("Tìm kiếm...");
        txtTimKiemSPCC.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtTimKiemSPCC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemSPCCFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimKiemSPCCFocusLost(evt);
            }
        });
        txtTimKiemSPCC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemSPCCKeyReleased(evt);
            }
        });
        pnlCardDanhSachSpCc.add(txtTimKiemSPCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 560, 32));

        lblExcel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/excelIcon1.png"))); // NOI18N
        lblExcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExcelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblExcelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblExcelMouseExited(evt);
            }
        });
        pnlCardDanhSachSpCc.add(lblExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 130, 60, 60));

        pnlTab.add(pnlCardDanhSachSpCc, "pnlCardDanhSach");

        pnlCardCapNhatSp.setkEndColor(new java.awt.Color(204, 204, 255));
        pnlCardCapNhatSp.setkStartColor(new java.awt.Color(51, 51, 255));
        pnlCardCapNhatSp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 255));
        jLabel10.setText("Kho hàng/ Sản phẩm cung cấp/ Cập nhật sản phẩm/");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 255));
        jLabel11.setText("Cập nhật sản phẩm________________________________________________________");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addContainerGap(298, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pnlCardCapNhatSp.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 940, 79));

        lblMaSP.setFont(new java.awt.Font("UVN Van Chuong Nang", 0, 14)); // NOI18N
        lblMaSP.setForeground(new java.awt.Color(0, 0, 51));
        lblMaSP.setText("Mã sản phẩm cung cấp");
        pnlCardCapNhatSp.add(lblMaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 150, -1));

        lblLoiMaNhaCCSPCC.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiMaNhaCCSPCC.setForeground(new java.awt.Color(255, 0, 0));
        pnlCardCapNhatSp.add(lblLoiMaNhaCCSPCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 270, 18));

        txtMaSPCC.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtMaSPCC.setForeground(new java.awt.Color(153, 153, 153));
        txtMaSPCC.setText("VD: CC5");
        txtMaSPCC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtMaSPCC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMaSPCCFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaSPCCFocusLost(evt);
            }
        });
        pnlCardCapNhatSp.add(txtMaSPCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 270, 25));

        lblLoiMaSPCC.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiMaSPCC.setForeground(new java.awt.Color(255, 0, 0));
        pnlCardCapNhatSp.add(lblLoiMaSPCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 270, 18));

        lblMaSP1.setFont(new java.awt.Font("UVN Van Chuong Nang", 0, 14)); // NOI18N
        lblMaSP1.setForeground(new java.awt.Color(0, 0, 51));
        lblMaSP1.setText("Mã nhà cung cấp");
        pnlCardCapNhatSp.add(lblMaSP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 120, -1));

        lblMaSP2.setFont(new java.awt.Font("UVN Van Chuong Nang", 0, 14)); // NOI18N
        lblMaSP2.setForeground(new java.awt.Color(0, 0, 51));
        lblMaSP2.setText("Tên sản phẩm");
        pnlCardCapNhatSp.add(lblMaSP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 120, -1));

        txtTenSPCC.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtTenSPCC.setForeground(new java.awt.Color(153, 153, 153));
        txtTenSPCC.setText("VD: Bột giặt ABA");
        txtTenSPCC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTenSPCC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTenSPCCFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTenSPCCFocusLost(evt);
            }
        });
        txtTenSPCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSPCCActionPerformed(evt);
            }
        });
        pnlCardCapNhatSp.add(txtTenSPCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 270, 25));

        lblLoiTenSPCC.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiTenSPCC.setForeground(new java.awt.Color(255, 0, 0));
        pnlCardCapNhatSp.add(lblLoiTenSPCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 270, 18));

        lblMaSP3.setFont(new java.awt.Font("UVN Van Chuong Nang", 0, 14)); // NOI18N
        lblMaSP3.setForeground(new java.awt.Color(0, 0, 51));
        lblMaSP3.setText("Giá sản phẩm");
        pnlCardCapNhatSp.add(lblMaSP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 120, -1));

        txtGiaSPCC.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtGiaSPCC.setForeground(new java.awt.Color(153, 153, 153));
        txtGiaSPCC.setText("VD: 20000");
        txtGiaSPCC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtGiaSPCC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtGiaSPCCFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGiaSPCCFocusLost(evt);
            }
        });
        pnlCardCapNhatSp.add(txtGiaSPCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 270, 25));

        lblLoiGiaSPCC.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiGiaSPCC.setForeground(new java.awt.Color(255, 0, 0));
        pnlCardCapNhatSp.add(lblLoiGiaSPCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 270, 18));

        lblMaSP4.setFont(new java.awt.Font("UVN Van Chuong Nang", 0, 14)); // NOI18N
        lblMaSP4.setForeground(new java.awt.Color(0, 0, 51));
        lblMaSP4.setText("Đơn vị tính");
        pnlCardCapNhatSp.add(lblMaSP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 120, -1));

        txtDonVTSPCC.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtDonVTSPCC.setForeground(new java.awt.Color(153, 153, 153));
        txtDonVTSPCC.setText("VD: KG");
        txtDonVTSPCC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtDonVTSPCC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDonVTSPCCFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDonVTSPCCFocusLost(evt);
            }
        });
        pnlCardCapNhatSp.add(txtDonVTSPCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 270, 25));

        lblLoiDonVTSPCC.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiDonVTSPCC.setForeground(new java.awt.Color(255, 0, 0));
        pnlCardCapNhatSp.add(lblLoiDonVTSPCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 270, 18));

        lblMaSP5.setFont(new java.awt.Font("UVN Van Chuong Nang", 0, 14)); // NOI18N
        lblMaSP5.setForeground(new java.awt.Color(0, 0, 51));
        lblMaSP5.setText("Id(loại sản phẩm)");
        pnlCardCapNhatSp.add(lblMaSP5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 120, -1));

        lblLoiIDSPCC.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiIDSPCC.setForeground(new java.awt.Color(255, 0, 0));
        pnlCardCapNhatSp.add(lblLoiIDSPCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, 270, 18));

        lblHinhSPCC.setBackground(new java.awt.Color(204, 204, 204));
        lblHinhSPCC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHinhSPCC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblHinhSPCC.setOpaque(true);
        lblHinhSPCC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lblHinhSPCCFocusLost(evt);
            }
        });
        lblHinhSPCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhSPCCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHinhSPCCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHinhSPCCMouseExited(evt);
            }
        });
        lblHinhSPCC.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                lblHinhSPCCInputMethodTextChanged(evt);
            }
        });
        pnlCardCapNhatSp.add(lblHinhSPCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 200, 200));

        btnInsertSPCC.setBackground(new java.awt.Color(0, 0, 255));
        btnInsertSPCC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnInsertSPCC.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertSPCC.setText("Thêm");
        btnInsertSPCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertSPCCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInsertSPCCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInsertSPCCMouseExited(evt);
            }
        });
        btnInsertSPCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertSPCCActionPerformed(evt);
            }
        });
        pnlCardCapNhatSp.add(btnInsertSPCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 90, 40));

        btnFirstSPCC.setBackground(new java.awt.Color(0, 0, 255));
        btnFirstSPCC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFirstSPCC.setForeground(new java.awt.Color(255, 255, 255));
        btnFirstSPCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/first.png"))); // NOI18N
        btnFirstSPCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFirstSPCCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFirstSPCCMouseExited(evt);
            }
        });
        btnFirstSPCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstSPCCActionPerformed(evt);
            }
        });
        pnlCardCapNhatSp.add(btnFirstSPCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 500, 50, 40));

        btnPrevSPCC.setBackground(new java.awt.Color(0, 0, 255));
        btnPrevSPCC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrevSPCC.setForeground(new java.awt.Color(255, 255, 255));
        btnPrevSPCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/prev.png"))); // NOI18N
        btnPrevSPCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrevSPCCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPrevSPCCMouseExited(evt);
            }
        });
        btnPrevSPCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevSPCCActionPerformed(evt);
            }
        });
        pnlCardCapNhatSp.add(btnPrevSPCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 500, 50, 40));

        btnDeleteSPCC.setBackground(new java.awt.Color(0, 0, 255));
        btnDeleteSPCC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteSPCC.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteSPCC.setText("Xóa");
        btnDeleteSPCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteSPCCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteSPCCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteSPCCMouseExited(evt);
            }
        });
        btnDeleteSPCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSPCCActionPerformed(evt);
            }
        });
        pnlCardCapNhatSp.add(btnDeleteSPCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 90, 40));

        btnUpdateSPCC.setBackground(new java.awt.Color(0, 0, 255));
        btnUpdateSPCC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdateSPCC.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateSPCC.setText("Sửa");
        btnUpdateSPCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateSPCCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateSPCCMouseExited(evt);
            }
        });
        btnUpdateSPCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateSPCCActionPerformed(evt);
            }
        });
        pnlCardCapNhatSp.add(btnUpdateSPCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, 90, 40));

        btnNextSPCC.setBackground(new java.awt.Color(0, 0, 255));
        btnNextSPCC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNextSPCC.setForeground(new java.awt.Color(255, 255, 255));
        btnNextSPCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/next.png"))); // NOI18N
        btnNextSPCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNextSPCCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNextSPCCMouseExited(evt);
            }
        });
        btnNextSPCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextSPCCActionPerformed(evt);
            }
        });
        pnlCardCapNhatSp.add(btnNextSPCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 500, 50, 40));

        btnLastSPCC.setBackground(new java.awt.Color(0, 0, 255));
        btnLastSPCC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLastSPCC.setForeground(new java.awt.Color(255, 255, 255));
        btnLastSPCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/last.png"))); // NOI18N
        btnLastSPCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLastSPCCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLastSPCCMouseExited(evt);
            }
        });
        btnLastSPCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastSPCCActionPerformed(evt);
            }
        });
        pnlCardCapNhatSp.add(btnLastSPCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 500, 50, 40));

        btnNewSPCC.setBackground(new java.awt.Color(0, 0, 255));
        btnNewSPCC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNewSPCC.setForeground(new java.awt.Color(255, 255, 255));
        btnNewSPCC.setText("Mới");
        btnNewSPCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNewSPCCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNewSPCCMouseExited(evt);
            }
        });
        btnNewSPCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewSPCCActionPerformed(evt);
            }
        });
        pnlCardCapNhatSp.add(btnNewSPCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 420, 90, 40));

        lblLoiHinhSPCC.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiHinhSPCC.setForeground(new java.awt.Color(255, 0, 0));
        lblLoiHinhSPCC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlCardCapNhatSp.add(lblLoiHinhSPCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 350, 180, 20));

        cboMaNCCCNSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn...", "Item 2", "Item 3", "Item 4" }));
        pnlCardCapNhatSp.add(cboMaNCCCNSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 270, 30));

        cboIDSPCC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn...", "Item 2", "Item 3", "Item 4" }));
        pnlCardCapNhatSp.add(cboIDSPCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 270, 30));

        pnlTab.add(pnlCardCapNhatSp, "pnlCardCapNhatSp");

        pnlCardLoaiSp.setkEndColor(new java.awt.Color(255, 255, 255));
        pnlCardLoaiSp.setkGradientFocus(1500);
        pnlCardLoaiSp.setkStartColor(new java.awt.Color(51, 51, 255));
        pnlCardLoaiSp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 255));
        jLabel12.setText("Kho hàng/ Loại sản phẩm/");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 255));
        jLabel13.setText("Loại sản phẩm________________________________________________________");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addContainerGap(332, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addContainerGap())
        );

        pnlCardLoaiSp.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 939, 74));

        tblLoaiSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Loại sản phẩm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLoaiSP.setRowHeight(25);
        tblLoaiSP.setSelectionBackground(new java.awt.Color(255, 102, 153));
        tblLoaiSP.setShowVerticalLines(false);
        tblLoaiSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiSPMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblLoaiSP);

        pnlCardLoaiSp.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 330, 225));

        btnFirstLoaiSP.setBackground(new java.awt.Color(0, 0, 255));
        btnFirstLoaiSP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFirstLoaiSP.setForeground(new java.awt.Color(255, 255, 255));
        btnFirstLoaiSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/first.png"))); // NOI18N
        btnFirstLoaiSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFirstLoaiSPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFirstLoaiSPMouseExited(evt);
            }
        });
        btnFirstLoaiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstLoaiSPActionPerformed(evt);
            }
        });
        pnlCardLoaiSp.add(btnFirstLoaiSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, 50, 40));

        btnPrevLoaiSP.setBackground(new java.awt.Color(0, 0, 255));
        btnPrevLoaiSP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrevLoaiSP.setForeground(new java.awt.Color(255, 255, 255));
        btnPrevLoaiSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/prev.png"))); // NOI18N
        btnPrevLoaiSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrevLoaiSPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPrevLoaiSPMouseExited(evt);
            }
        });
        btnPrevLoaiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevLoaiSPActionPerformed(evt);
            }
        });
        pnlCardLoaiSp.add(btnPrevLoaiSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, 50, 40));

        btnNextLoaiSP.setBackground(new java.awt.Color(0, 0, 255));
        btnNextLoaiSP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNextLoaiSP.setForeground(new java.awt.Color(255, 255, 255));
        btnNextLoaiSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/next.png"))); // NOI18N
        btnNextLoaiSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNextLoaiSPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNextLoaiSPMouseExited(evt);
            }
        });
        btnNextLoaiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextLoaiSPActionPerformed(evt);
            }
        });
        pnlCardLoaiSp.add(btnNextLoaiSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 430, 50, 40));

        btnLastLoaiSP.setBackground(new java.awt.Color(0, 0, 255));
        btnLastLoaiSP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLastLoaiSP.setForeground(new java.awt.Color(255, 255, 255));
        btnLastLoaiSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/last.png"))); // NOI18N
        btnLastLoaiSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLastLoaiSPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLastLoaiSPMouseExited(evt);
            }
        });
        btnLastLoaiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastLoaiSPActionPerformed(evt);
            }
        });
        pnlCardLoaiSp.add(btnLastLoaiSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 430, 50, 40));

        btnInsertLoaiSP.setBackground(new java.awt.Color(0, 0, 255));
        btnInsertLoaiSP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnInsertLoaiSP.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertLoaiSP.setText("Thêm");
        btnInsertLoaiSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertLoaiSPMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInsertLoaiSPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInsertLoaiSPMouseExited(evt);
            }
        });
        btnInsertLoaiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertLoaiSPActionPerformed(evt);
            }
        });
        pnlCardLoaiSp.add(btnInsertLoaiSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 90, 40));

        btnDeleteLoaiSP.setBackground(new java.awt.Color(0, 0, 255));
        btnDeleteLoaiSP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteLoaiSP.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteLoaiSP.setText("Xóa");
        btnDeleteLoaiSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteLoaiSPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteLoaiSPMouseExited(evt);
            }
        });
        btnDeleteLoaiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteLoaiSPActionPerformed(evt);
            }
        });
        pnlCardLoaiSp.add(btnDeleteLoaiSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 90, 40));

        btnNewLoaiSP.setBackground(new java.awt.Color(0, 0, 255));
        btnNewLoaiSP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNewLoaiSP.setForeground(new java.awt.Color(255, 255, 255));
        btnNewLoaiSP.setText("Mới");
        btnNewLoaiSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNewLoaiSPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNewLoaiSPMouseExited(evt);
            }
        });
        btnNewLoaiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewLoaiSPActionPerformed(evt);
            }
        });
        pnlCardLoaiSp.add(btnNewLoaiSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 90, 40));

        btnUpdateLoaiSP.setBackground(new java.awt.Color(0, 0, 255));
        btnUpdateLoaiSP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdateLoaiSP.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateLoaiSP.setText("Sửa");
        btnUpdateLoaiSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateLoaiSPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateLoaiSPMouseExited(evt);
            }
        });
        btnUpdateLoaiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateLoaiSPActionPerformed(evt);
            }
        });
        pnlCardLoaiSp.add(btnUpdateLoaiSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 90, 40));

        lblMaSP8.setFont(new java.awt.Font("UVN Van Chuong Nang", 0, 18)); // NOI18N
        lblMaSP8.setForeground(new java.awt.Color(255, 255, 255));
        lblMaSP8.setText("Danh sách loại sản phẩm");
        pnlCardLoaiSp.add(lblMaSP8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 211, -1));

        kGradientPanel2.setBorder(new javax.swing.border.MatteBorder(null));
        kGradientPanel2.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 255, 255));

        lblMaSP6.setFont(new java.awt.Font("UVN Van Chuong Nang", 0, 14)); // NOI18N
        lblMaSP6.setForeground(new java.awt.Color(0, 0, 51));
        lblMaSP6.setText("ID");

        txtLoaiSP.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtLoaiSP.setForeground(new java.awt.Color(153, 153, 153));
        txtLoaiSP.setText("VD: SP");
        txtLoaiSP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtLoaiSP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLoaiSPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLoaiSPFocusLost(evt);
            }
        });

        lblLoiIDLoaiSP.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiIDLoaiSP.setForeground(new java.awt.Color(255, 0, 0));

        txtIDLoaiSP.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtIDLoaiSP.setForeground(new java.awt.Color(153, 153, 153));
        txtIDLoaiSP.setText("VD: 15");
        txtIDLoaiSP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtIDLoaiSP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIDLoaiSPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIDLoaiSPFocusLost(evt);
            }
        });

        lblMaSP7.setFont(new java.awt.Font("UVN Van Chuong Nang", 0, 14)); // NOI18N
        lblMaSP7.setForeground(new java.awt.Color(0, 0, 51));
        lblMaSP7.setText("Loại sản phẩm");

        lblLoiLoaiSP.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiLoaiSP.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(lblMaSP6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addComponent(txtIDLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                                .addComponent(lblMaSP7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtLoaiSP, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                    .addComponent(lblLoiLoaiSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(lblLoiIDLoaiSP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaSP6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLoiIDLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaSP7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLoiLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pnlCardLoaiSp.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        lblMaSP9.setBackground(new java.awt.Color(0, 0, 255));
        lblMaSP9.setFont(new java.awt.Font("UVN Van Chuong Nang", 0, 18)); // NOI18N
        lblMaSP9.setForeground(new java.awt.Color(0, 0, 153));
        lblMaSP9.setText("Cập nhật loại sản phẩm");
        pnlCardLoaiSp.add(lblMaSP9, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 148, -1, -1));

        pnlTab.add(pnlCardLoaiSp, "pnlCardLoaiSp");

        pnlDanhSachLoHang.setkEndColor(new java.awt.Color(255, 255, 255));
        pnlDanhSachLoHang.setkStartColor(new java.awt.Color(51, 51, 255));
        pnlDanhSachLoHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 255));
        jLabel14.setText("Kho hàng/ Lô hàng/ Danh sách lô hàng/");

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 255));
        jLabel15.setText("Danh sách lô hàng________________________________________________________");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel14)
                .addGap(11, 11, 11)
                .addComponent(jLabel15))
        );

        pnlDanhSachLoHang.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 750, 76));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/find.png"))); // NOI18N
        pnlDanhSachLoHang.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        txtTimKiemLH.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtTimKiemLH.setForeground(new java.awt.Color(153, 153, 153));
        txtTimKiemLH.setText("Tìm kiếm...");
        txtTimKiemLH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTimKiemLH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemLHFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimKiemLHFocusLost(evt);
            }
        });
        txtTimKiemLH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemLHKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemLHKeyReleased(evt);
            }
        });
        pnlDanhSachLoHang.add(txtTimKiemLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 147, 630, 32));

        tblLoHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã lô hàng", "Tên lô hàng", "Vị trí", "Mô tả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLoHang.setRowHeight(25);
        tblLoHang.setSelectionBackground(new java.awt.Color(255, 102, 153));
        tblLoHang.setShowVerticalLines(false);
        tblLoHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoHangMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblLoHang);

        pnlDanhSachLoHang.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 191, 730, 350));

        pnlTab.add(pnlDanhSachLoHang, "pnlDanhSachLoHang");

        pnlCapNhatLoHang.setkEndColor(new java.awt.Color(255, 255, 255));
        pnlCapNhatLoHang.setkStartColor(new java.awt.Color(51, 51, 255));
        pnlCapNhatLoHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 255));
        jLabel17.setText("Kho hàng/ Lô hàng/Cập nhật lô hàng/");

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 255));
        jLabel18.setText("Cập nhật lô hàng________________________________________________________");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addContainerGap(314, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pnlCapNhatLoHang.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 51, -1, 75));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMaSP10.setFont(new java.awt.Font("UVN Van Chuong Nang", 0, 14)); // NOI18N
        lblMaSP10.setForeground(new java.awt.Color(0, 0, 51));
        lblMaSP10.setText("Mã lô hàng");
        jPanel8.add(lblMaSP10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 100, -1));

        txtMaLH.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtMaLH.setForeground(new java.awt.Color(153, 153, 153));
        txtMaLH.setText("VD: LH15");
        txtMaLH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtMaLH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMaLHFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaLHFocusLost(evt);
            }
        });
        txtMaLH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaLHActionPerformed(evt);
            }
        });
        jPanel8.add(txtMaLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 380, 25));

        lblLoiMaLH.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiMaLH.setForeground(new java.awt.Color(255, 0, 0));
        jPanel8.add(lblLoiMaLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 270, 18));

        lblMaSP11.setFont(new java.awt.Font("UVN Van Chuong Nang", 0, 14)); // NOI18N
        lblMaSP11.setForeground(new java.awt.Color(0, 0, 51));
        lblMaSP11.setText("Tên lô hàng");
        jPanel8.add(lblMaSP11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 100, -1));

        txtTenLH.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtTenLH.setForeground(new java.awt.Color(153, 153, 153));
        txtTenLH.setText("VD: Lô 15");
        txtTenLH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTenLH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTenLHFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTenLHFocusLost(evt);
            }
        });
        jPanel8.add(txtTenLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 380, 25));

        lblLoiTenLoHang.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiTenLoHang.setForeground(new java.awt.Color(255, 0, 0));
        jPanel8.add(lblLoiTenLoHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 270, 18));

        lblMaSP12.setFont(new java.awt.Font("UVN Van Chuong Nang", 0, 14)); // NOI18N
        lblMaSP12.setForeground(new java.awt.Color(0, 0, 51));
        lblMaSP12.setText("Vị trí");
        jPanel8.add(lblMaSP12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 100, -1));

        txtViTriLH.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtViTriLH.setForeground(new java.awt.Color(153, 153, 153));
        txtViTriLH.setText("VD: Trên");
        txtViTriLH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtViTriLH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtViTriLHFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtViTriLHFocusLost(evt);
            }
        });
        jPanel8.add(txtViTriLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 380, 25));

        lblLoiViTriLH.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiViTriLH.setForeground(new java.awt.Color(255, 0, 0));
        jPanel8.add(lblLoiViTriLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 270, 18));

        lblMaSP13.setFont(new java.awt.Font("UVN Van Chuong Nang", 0, 14)); // NOI18N
        lblMaSP13.setForeground(new java.awt.Color(0, 0, 51));
        lblMaSP13.setText("Mô tả");
        jPanel8.add(lblMaSP13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 100, -1));

        lblLoiMoTaLH.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiMoTaLH.setForeground(new java.awt.Color(255, 0, 0));
        jPanel8.add(lblLoiMoTaLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 294, 270, 18));

        txtMoLH.setColumns(20);
        txtMoLH.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtMoLH.setForeground(new java.awt.Color(153, 153, 153));
        txtMoLH.setRows(5);
        txtMoLH.setText("Nhập vào mô tả ở đây....");
        txtMoLH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMoLHFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMoLHFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(txtMoLH);

        jPanel8.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 380, 80));

        btnInsertLH.setBackground(new java.awt.Color(0, 0, 255));
        btnInsertLH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnInsertLH.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertLH.setText("Thêm");
        btnInsertLH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInsertLHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInsertLHMouseExited(evt);
            }
        });
        btnInsertLH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertLHActionPerformed(evt);
            }
        });
        jPanel8.add(btnInsertLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 90, 40));

        btnDeleteLH.setBackground(new java.awt.Color(0, 0, 255));
        btnDeleteLH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteLH.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteLH.setText("Xóa");
        btnDeleteLH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteLHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteLHMouseExited(evt);
            }
        });
        btnDeleteLH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteLHActionPerformed(evt);
            }
        });
        jPanel8.add(btnDeleteLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 90, 40));

        btnUpdateLH.setBackground(new java.awt.Color(0, 0, 255));
        btnUpdateLH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdateLH.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateLH.setText("Sửa");
        btnUpdateLH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateLHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateLHMouseExited(evt);
            }
        });
        btnUpdateLH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateLHActionPerformed(evt);
            }
        });
        jPanel8.add(btnUpdateLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, 90, 40));

        btnNewLH.setBackground(new java.awt.Color(0, 0, 255));
        btnNewLH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNewLH.setForeground(new java.awt.Color(255, 255, 255));
        btnNewLH.setText("Mới");
        btnNewLH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNewLHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNewLHMouseExited(evt);
            }
        });
        btnNewLH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewLHActionPerformed(evt);
            }
        });
        jPanel8.add(btnNewLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, 90, 40));

        btnFistLH.setBackground(new java.awt.Color(0, 0, 255));
        btnFistLH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFistLH.setForeground(new java.awt.Color(255, 255, 255));
        btnFistLH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/first.png"))); // NOI18N
        btnFistLH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFistLHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFistLHMouseExited(evt);
            }
        });
        btnFistLH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFistLHActionPerformed(evt);
            }
        });
        jPanel8.add(btnFistLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 90, 40));

        btnLastLH.setBackground(new java.awt.Color(0, 0, 255));
        btnLastLH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLastLH.setForeground(new java.awt.Color(255, 255, 255));
        btnLastLH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/last.png"))); // NOI18N
        btnLastLH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLastLHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLastLHMouseExited(evt);
            }
        });
        btnLastLH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastLHActionPerformed(evt);
            }
        });
        jPanel8.add(btnLastLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 90, 40));

        btnNextLH.setBackground(new java.awt.Color(0, 0, 255));
        btnNextLH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNextLH.setForeground(new java.awt.Color(255, 255, 255));
        btnNextLH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/next.png"))); // NOI18N
        btnNextLH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNextLHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNextLHMouseExited(evt);
            }
        });
        btnNextLH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextLHActionPerformed(evt);
            }
        });
        jPanel8.add(btnNextLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, 90, 40));

        btnPrevLH.setBackground(new java.awt.Color(0, 0, 255));
        btnPrevLH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrevLH.setForeground(new java.awt.Color(255, 255, 255));
        btnPrevLH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/prev.png"))); // NOI18N
        btnPrevLH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrevLHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPrevLHMouseExited(evt);
            }
        });
        btnPrevLH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevLHActionPerformed(evt);
            }
        });
        jPanel8.add(btnPrevLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 90, 40));

        pnlCapNhatLoHang.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 710, 382));

        pnlTab.add(pnlCapNhatLoHang, "pnlCapNhatLoHang");

        pnlCradDanhSachNhaCC.setBackground(new java.awt.Color(255, 255, 255));
        pnlCradDanhSachNhaCC.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 1, new java.awt.Color(0, 0, 0)));
        pnlCradDanhSachNhaCC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(51, 51, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Danh sách nhà cung cấp");

        jSeparator2.setOpaque(true);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kho hàng/Loại sản phẩm/ Danh sách/");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        pnlCradDanhSachNhaCC.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 756, 73));

        tblNhaCungCap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã nhà cung cấp", "Tên nhà cung cấp", "Số điện thoại", "Email", "Địa chỉ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhaCungCap.setRowHeight(25);
        tblNhaCungCap.setSelectionBackground(new java.awt.Color(255, 102, 153));
        tblNhaCungCap.setShowVerticalLines(false);
        tblNhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhaCungCapMouseClicked(evt);
            }
        });
        tblNhaCungCap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblNhaCungCapKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(tblNhaCungCap);

        pnlCradDanhSachNhaCC.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 188, 736, 349));

        txtTimKiemNhaCC.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtTimKiemNhaCC.setForeground(new java.awt.Color(153, 153, 153));
        txtTimKiemNhaCC.setText("VD: NCC1");
        txtTimKiemNhaCC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTimKiemNhaCC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemNhaCCFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimKiemNhaCCFocusLost(evt);
            }
        });
        txtTimKiemNhaCC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemNhaCCKeyReleased(evt);
            }
        });
        pnlCradDanhSachNhaCC.add(txtTimKiemNhaCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 150, 652, 32));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 204));
        jLabel6.setText("Tìm kiếm");
        pnlCradDanhSachNhaCC.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 156, -1, -1));

        pnlTab.add(pnlCradDanhSachNhaCC, "pnlDanhSach");

        pnlCardCapNhatNhaCC.setBackground(new java.awt.Color(255, 255, 255));
        pnlCardCapNhatNhaCC.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 1, new java.awt.Color(0, 0, 0)));

        jPanel11.setBackground(new java.awt.Color(51, 51, 255));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Cập nhật nhà cung cấp");

        jSeparator3.setOpaque(true);

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Kho hàng/ Cập nhật/Loại sản phẩm");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMaSP14.setFont(new java.awt.Font("UVN Bai Sau Nang", 0, 14)); // NOI18N
        lblMaSP14.setForeground(new java.awt.Color(0, 102, 204));
        lblMaSP14.setText("Mã nhà cung cấp");
        jPanel12.add(lblMaSP14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        lblMaSP15.setFont(new java.awt.Font("UVN Bai Sau Nang", 0, 14)); // NOI18N
        lblMaSP15.setForeground(new java.awt.Color(0, 102, 204));
        lblMaSP15.setText("Tên nhà cung cấp");
        jPanel12.add(lblMaSP15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        lblMaSP16.setFont(new java.awt.Font("UVN Bai Sau Nang", 0, 14)); // NOI18N
        lblMaSP16.setForeground(new java.awt.Color(0, 102, 204));
        lblMaSP16.setText("Số điện thoại");
        jPanel12.add(lblMaSP16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        lblMaSP17.setFont(new java.awt.Font("UVN Bai Sau Nang", 0, 14)); // NOI18N
        lblMaSP17.setForeground(new java.awt.Color(0, 102, 204));
        lblMaSP17.setText("Email");
        jPanel12.add(lblMaSP17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        lblMaSP18.setFont(new java.awt.Font("UVN Bai Sau Nang", 0, 14)); // NOI18N
        lblMaSP18.setForeground(new java.awt.Color(0, 102, 204));
        lblMaSP18.setText("Địa chỉ");
        jPanel12.add(lblMaSP18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        txtMaNhaCC.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtMaNhaCC.setForeground(new java.awt.Color(153, 153, 153));
        txtMaNhaCC.setText("VD: NCC1");
        txtMaNhaCC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtMaNhaCC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMaNhaCCFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaNhaCCFocusLost(evt);
            }
        });
        jPanel12.add(txtMaNhaCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 360, 25));

        txtTenNhaCC.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtTenNhaCC.setForeground(new java.awt.Color(153, 153, 153));
        txtTenNhaCC.setText("VD: CTY Long Thành");
        txtTenNhaCC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTenNhaCC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTenNhaCCFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTenNhaCCFocusLost(evt);
            }
        });
        jPanel12.add(txtTenNhaCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 360, 25));

        txtSDTNhaCC.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtSDTNhaCC.setForeground(new java.awt.Color(153, 153, 153));
        txtSDTNhaCC.setText("VD: 0889******");
        txtSDTNhaCC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSDTNhaCC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSDTNhaCCFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSDTNhaCCFocusLost(evt);
            }
        });
        jPanel12.add(txtSDTNhaCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 360, 25));

        txtEmailNhaCC.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtEmailNhaCC.setForeground(new java.awt.Color(153, 153, 153));
        txtEmailNhaCC.setText("VD: kimbinhmai@gmail.com");
        txtEmailNhaCC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtEmailNhaCC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailNhaCCFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailNhaCCFocusLost(evt);
            }
        });
        jPanel12.add(txtEmailNhaCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 360, 25));

        txtDiaChiNhaCC.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtDiaChiNhaCC.setForeground(new java.awt.Color(153, 153, 153));
        txtDiaChiNhaCC.setText("VD: 318_Tô ký , TP HCM");
        txtDiaChiNhaCC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtDiaChiNhaCC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDiaChiNhaCCFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDiaChiNhaCCFocusLost(evt);
            }
        });
        jPanel12.add(txtDiaChiNhaCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 360, 25));

        lblLoiTenDangNhap.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiTenDangNhap.setForeground(new java.awt.Color(255, 0, 0));
        jPanel12.add(lblLoiTenDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, -290, -1, -1));

        btnInsertNhaCC.setBackground(new java.awt.Color(0, 0, 255));
        btnInsertNhaCC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnInsertNhaCC.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertNhaCC.setText("Thêm");
        btnInsertNhaCC.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnInsertNhaCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInsertNhaCCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInsertNhaCCMouseExited(evt);
            }
        });
        btnInsertNhaCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertNhaCCActionPerformed(evt);
            }
        });
        jPanel12.add(btnInsertNhaCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 110, 30));

        btnFirstNhaCC.setBackground(new java.awt.Color(0, 0, 255));
        btnFirstNhaCC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFirstNhaCC.setForeground(new java.awt.Color(255, 255, 255));
        btnFirstNhaCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/first.png"))); // NOI18N
        btnFirstNhaCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFirstNhaCCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFirstNhaCCMouseExited(evt);
            }
        });
        btnFirstNhaCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstNhaCCActionPerformed(evt);
            }
        });
        jPanel12.add(btnFirstNhaCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 50, 40));

        btnPrevNhaCC.setBackground(new java.awt.Color(0, 0, 255));
        btnPrevNhaCC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrevNhaCC.setForeground(new java.awt.Color(255, 255, 255));
        btnPrevNhaCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/prev.png"))); // NOI18N
        btnPrevNhaCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrevNhaCCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPrevNhaCCMouseExited(evt);
            }
        });
        btnPrevNhaCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevNhaCCActionPerformed(evt);
            }
        });
        jPanel12.add(btnPrevNhaCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 50, 40));

        btnNextNhaCC.setBackground(new java.awt.Color(0, 0, 255));
        btnNextNhaCC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNextNhaCC.setForeground(new java.awt.Color(255, 255, 255));
        btnNextNhaCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/next.png"))); // NOI18N
        btnNextNhaCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNextNhaCCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNextNhaCCMouseExited(evt);
            }
        });
        btnNextNhaCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextNhaCCActionPerformed(evt);
            }
        });
        jPanel12.add(btnNextNhaCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 50, 40));

        btnLastNhaCC.setBackground(new java.awt.Color(0, 0, 255));
        btnLastNhaCC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLastNhaCC.setForeground(new java.awt.Color(255, 255, 255));
        btnLastNhaCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/last.png"))); // NOI18N
        btnLastNhaCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLastNhaCCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLastNhaCCMouseExited(evt);
            }
        });
        btnLastNhaCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastNhaCCActionPerformed(evt);
            }
        });
        jPanel12.add(btnLastNhaCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 50, 40));

        btnNewNhaCC.setBackground(new java.awt.Color(0, 0, 255));
        btnNewNhaCC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNewNhaCC.setForeground(new java.awt.Color(255, 255, 255));
        btnNewNhaCC.setText("Mới");
        btnNewNhaCC.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnNewNhaCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNewNhaCCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNewNhaCCMouseExited(evt);
            }
        });
        btnNewNhaCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewNhaCCActionPerformed(evt);
            }
        });
        jPanel12.add(btnNewNhaCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 308, 110, 30));

        btnUpdateNhaCC.setBackground(new java.awt.Color(0, 0, 255));
        btnUpdateNhaCC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdateNhaCC.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateNhaCC.setText("Sửa");
        btnUpdateNhaCC.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnUpdateNhaCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateNhaCCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateNhaCCMouseExited(evt);
            }
        });
        btnUpdateNhaCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateNhaCCActionPerformed(evt);
            }
        });
        jPanel12.add(btnUpdateNhaCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 110, 30));

        btnDeleteNhaCC.setBackground(new java.awt.Color(0, 0, 255));
        btnDeleteNhaCC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteNhaCC.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteNhaCC.setText("Xóa");
        btnDeleteNhaCC.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnDeleteNhaCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteNhaCCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteNhaCCMouseExited(evt);
            }
        });
        btnDeleteNhaCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteNhaCCActionPerformed(evt);
            }
        });
        jPanel12.add(btnDeleteNhaCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, 110, 30));

        lblLoiDiaChiNhaCC.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiDiaChiNhaCC.setForeground(new java.awt.Color(255, 0, 0));
        jPanel12.add(lblLoiDiaChiNhaCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 360, 18));

        lblLoiMaNhaCC.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiMaNhaCC.setForeground(new java.awt.Color(255, 0, 0));
        jPanel12.add(lblLoiMaNhaCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 70, 360, 18));

        lblLoiTenNhaCC.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiTenNhaCC.setForeground(new java.awt.Color(255, 0, 0));
        jPanel12.add(lblLoiTenNhaCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 360, 18));

        lblLoiSDTNhaCC.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiSDTNhaCC.setForeground(new java.awt.Color(255, 0, 0));
        jPanel12.add(lblLoiSDTNhaCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 360, 18));

        lblLoiEmailNhaCC.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiEmailNhaCC.setForeground(new java.awt.Color(255, 0, 0));
        jPanel12.add(lblLoiEmailNhaCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 360, 18));

        javax.swing.GroupLayout pnlCardCapNhatNhaCCLayout = new javax.swing.GroupLayout(pnlCardCapNhatNhaCC);
        pnlCardCapNhatNhaCC.setLayout(pnlCardCapNhatNhaCCLayout);
        pnlCardCapNhatNhaCCLayout.setHorizontalGroup(
            pnlCardCapNhatNhaCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCardCapNhatNhaCCLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        pnlCardCapNhatNhaCCLayout.setVerticalGroup(
            pnlCardCapNhatNhaCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardCapNhatNhaCCLayout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlTab.add(pnlCardCapNhatNhaCC, "pnlCapNhat");

        getContentPane().add(pnlTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 750, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemSPCCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemSPCCFocusGained
        if (txtTimKiemSPCC.getForeground().equals(new Color(153, 153, 153))) {
            Color(txtTimKiemSPCC, "", Plain, Black);
        }
    }//GEN-LAST:event_txtTimKiemSPCCFocusGained

    private void txtTimKiemSPCCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemSPCCFocusLost
        if (txtTimKiemSPCC.getText().trim().isEmpty()) {
            Color(txtTimKiemSPCC, "VD: NoPT", Italic, Gray);
        }
    }//GEN-LAST:event_txtTimKiemSPCCFocusLost

    private void lblHinhSPCCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblHinhSPCCFocusLost

    }//GEN-LAST:event_lblHinhSPCCFocusLost

    private void lblHinhSPCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhSPCCMouseClicked
        chonAnh();
    }//GEN-LAST:event_lblHinhSPCCMouseClicked

    private void lblHinhSPCCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhSPCCMouseEntered
        lblHinhSPCC.setBackground(Color.black);
    }//GEN-LAST:event_lblHinhSPCCMouseEntered

    private void lblHinhSPCCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhSPCCMouseExited
        lblHinhSPCC.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_lblHinhSPCCMouseExited

    private void lblHinhSPCCInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_lblHinhSPCCInputMethodTextChanged

    }//GEN-LAST:event_lblHinhSPCCInputMethodTextChanged

    private void btnInsertSPCCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertSPCCMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnInsertSPCC);
    }//GEN-LAST:event_btnInsertSPCCMouseEntered

    private void btnInsertSPCCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertSPCCMouseExited
        setBackround(new Color(0, 0, 255), Color.WHITE, btnInsertSPCC);
    }//GEN-LAST:event_btnInsertSPCCMouseExited

    private void btnInsertSPCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertSPCCActionPerformed
        if (checkFormCNSP() == true) {
            if (validateFormCNSP() == true) {
                insertSPCC();
            }
        }
    }//GEN-LAST:event_btnInsertSPCCActionPerformed

    private void btnFirstSPCCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstSPCCMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnFirstSPCC);
    }//GEN-LAST:event_btnFirstSPCCMouseEntered

    private void btnFirstSPCCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstSPCCMouseExited
        setBackround(new Color(0, 0, 255), Color.WHITE, btnFirstSPCC);
    }//GEN-LAST:event_btnFirstSPCCMouseExited

    private void btnFirstSPCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstSPCCActionPerformed
        indexSPCC = 0;
        editSPCC();
    }//GEN-LAST:event_btnFirstSPCCActionPerformed

    private void btnPrevSPCCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevSPCCMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnPrevSPCC);
    }//GEN-LAST:event_btnPrevSPCCMouseEntered

    private void btnPrevSPCCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevSPCCMouseExited
        setBackround(new Color(0, 0, 255), Color.WHITE, btnPrevSPCC);
    }//GEN-LAST:event_btnPrevSPCCMouseExited

    private void btnPrevSPCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevSPCCActionPerformed
        indexSPCC--;
        editSPCC();
    }//GEN-LAST:event_btnPrevSPCCActionPerformed

    private void btnDeleteSPCCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteSPCCMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnDeleteSPCC);
    }//GEN-LAST:event_btnDeleteSPCCMouseEntered

    private void btnDeleteSPCCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteSPCCMouseExited
        setBackround(new Color(0, 0, 255), Color.WHITE, btnDeleteSPCC);
    }//GEN-LAST:event_btnDeleteSPCCMouseExited

    private void btnDeleteSPCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSPCCActionPerformed
        deleteSPCC();
    }//GEN-LAST:event_btnDeleteSPCCActionPerformed

    private void btnUpdateSPCCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateSPCCMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnUpdateSPCC);
    }//GEN-LAST:event_btnUpdateSPCCMouseEntered

    private void btnUpdateSPCCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateSPCCMouseExited
        setBackround(new Color(0, 0, 255), Color.WHITE, btnUpdateSPCC);
    }//GEN-LAST:event_btnUpdateSPCCMouseExited

    private void btnUpdateSPCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSPCCActionPerformed
        if (checkFormCNSP() == true) {
            if (validateFormCNSP() == true) {
                updateSPCC();
            }
        }
    }//GEN-LAST:event_btnUpdateSPCCActionPerformed

    private void btnNextSPCCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextSPCCMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnNextSPCC);
    }//GEN-LAST:event_btnNextSPCCMouseEntered

    private void btnNextSPCCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextSPCCMouseExited
        setBackround(new Color(0, 0, 255), Color.WHITE, btnNextSPCC);
    }//GEN-LAST:event_btnNextSPCCMouseExited

    private void btnNextSPCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextSPCCActionPerformed
        indexSPCC++;
        editSPCC();
    }//GEN-LAST:event_btnNextSPCCActionPerformed

    private void btnLastSPCCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastSPCCMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnLastSPCC);
    }//GEN-LAST:event_btnLastSPCCMouseEntered

    private void btnLastSPCCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastSPCCMouseExited
        setBackround(new Color(0, 0, 255), Color.WHITE, btnLastSPCC);
    }//GEN-LAST:event_btnLastSPCCMouseExited

    private void btnLastSPCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastSPCCActionPerformed
        indexSPCC = tblSPCC.getRowCount() - 1;
        editSPCC();
    }//GEN-LAST:event_btnLastSPCCActionPerformed

    private void btnNewSPCCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewSPCCMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnNewSPCC);
    }//GEN-LAST:event_btnNewSPCCMouseEntered

    private void btnNewSPCCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewSPCCMouseExited
        setBackround(new Color(0, 0, 255), Color.WHITE, btnNewSPCC);
    }//GEN-LAST:event_btnNewSPCCMouseExited

    private void btnNewSPCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewSPCCActionPerformed
        clearSPCC();
    }//GEN-LAST:event_btnNewSPCCActionPerformed

    private void btnFirstLoaiSPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstLoaiSPMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFirstLoaiSPMouseEntered

    private void btnFirstLoaiSPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstLoaiSPMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFirstLoaiSPMouseExited

    private void btnFirstLoaiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstLoaiSPActionPerformed
        // TODO add your handling code here:
        indexLoaiSP = 0;
        editLoaiSP();
    }//GEN-LAST:event_btnFirstLoaiSPActionPerformed

    private void btnPrevLoaiSPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevLoaiSPMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrevLoaiSPMouseEntered

    private void btnPrevLoaiSPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevLoaiSPMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrevLoaiSPMouseExited

    private void btnPrevLoaiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevLoaiSPActionPerformed
        // TODO add your handling code here:
        indexLoaiSP--;
        editLoaiSP();
    }//GEN-LAST:event_btnPrevLoaiSPActionPerformed

    private void btnNextLoaiSPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextLoaiSPMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNextLoaiSPMouseEntered

    private void btnNextLoaiSPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextLoaiSPMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNextLoaiSPMouseExited

    private void btnNextLoaiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextLoaiSPActionPerformed
        // TODO add your handling code here:
        indexLoaiSP++;
        editLoaiSP();
    }//GEN-LAST:event_btnNextLoaiSPActionPerformed

    private void btnLastLoaiSPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastLoaiSPMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLastLoaiSPMouseEntered

    private void btnLastLoaiSPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastLoaiSPMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLastLoaiSPMouseExited

    private void btnLastLoaiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastLoaiSPActionPerformed
        // TODO add your handling code here:
        indexLoaiSP = tblLoaiSP.getRowCount() - 1;
        editLoaiSP();
    }//GEN-LAST:event_btnLastLoaiSPActionPerformed

    private void btnInsertLoaiSPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertLoaiSPMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInsertLoaiSPMouseEntered

    private void btnInsertLoaiSPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertLoaiSPMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInsertLoaiSPMouseExited

    private void btnInsertLoaiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertLoaiSPActionPerformed

    }//GEN-LAST:event_btnInsertLoaiSPActionPerformed

    private void btnDeleteLoaiSPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteLoaiSPMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteLoaiSPMouseEntered

    private void btnDeleteLoaiSPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteLoaiSPMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteLoaiSPMouseExited

    private void btnDeleteLoaiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteLoaiSPActionPerformed
        // TODO add your handling code here:
        deleteLoaiSP();
    }//GEN-LAST:event_btnDeleteLoaiSPActionPerformed

    private void btnNewLoaiSPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewLoaiSPMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNewLoaiSPMouseEntered

    private void btnNewLoaiSPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewLoaiSPMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNewLoaiSPMouseExited

    private void btnNewLoaiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewLoaiSPActionPerformed
        // TODO add your handling code here:
        clearLoaiSP();
    }//GEN-LAST:event_btnNewLoaiSPActionPerformed

    private void btnUpdateLoaiSPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateLoaiSPMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateLoaiSPMouseEntered

    private void btnUpdateLoaiSPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateLoaiSPMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateLoaiSPMouseExited

    private void btnUpdateLoaiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateLoaiSPActionPerformed
        // TODO add your handling code here:
        if (checkFormLoaiSP() == true) {
            if (vailidateFormLSP() == true) {
                updateLoaiSP();
            }
        }
    }//GEN-LAST:event_btnUpdateLoaiSPActionPerformed

    private void txtTimKiemLHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemLHFocusGained
        if (txtTimKiemLH.getForeground().equals(Gray)) {
            Color(txtTimKiemLH, "", Plain, Black);
        }
    }//GEN-LAST:event_txtTimKiemLHFocusGained

    private void txtTimKiemLHFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemLHFocusLost
        if (txtTimKiemLH.getText().trim().isEmpty()) {
            Color(txtTimKiemLH, "VD: NoPT", Italic, Gray);
        }
    }//GEN-LAST:event_txtTimKiemLHFocusLost

    private void btnInsertLHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertLHMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInsertLHMouseEntered

    private void btnInsertLHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertLHMouseExited

    }//GEN-LAST:event_btnInsertLHMouseExited

    private void btnInsertLHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertLHActionPerformed
        if (checkFormCNLH() == true) {
            if(validateFormCNLH() == true){
               insertLoHang();
            }
            
        }

    }//GEN-LAST:event_btnInsertLHActionPerformed

    private void btnDeleteLHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteLHMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteLHMouseEntered

    private void btnDeleteLHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteLHMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteLHMouseExited

    private void btnDeleteLHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteLHActionPerformed
        // TODO add your handling code here:
        deleteLoHang();
    }//GEN-LAST:event_btnDeleteLHActionPerformed

    private void btnUpdateLHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateLHMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateLHMouseEntered

    private void btnUpdateLHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateLHMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateLHMouseExited

    private void btnUpdateLHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateLHActionPerformed
        // TODO add your handling code here:
        if (checkFormCNLH() == true) {
            updateLoHang();
        }
    }//GEN-LAST:event_btnUpdateLHActionPerformed

    private void btnNewLHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewLHMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNewLHMouseEntered

    private void btnNewLHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewLHMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNewLHMouseExited

    private void btnNewLHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewLHActionPerformed
        // TODO add your handling code here:
        clearLoHang();
    }//GEN-LAST:event_btnNewLHActionPerformed

    private void btnFistLHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFistLHMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFistLHMouseEntered

    private void btnFistLHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFistLHMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFistLHMouseExited

    private void btnFistLHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFistLHActionPerformed
        indexLoHang = 0;
        editLoHang();
    }//GEN-LAST:event_btnFistLHActionPerformed

    private void btnLastLHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastLHMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLastLHMouseEntered

    private void btnLastLHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastLHMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLastLHMouseExited

    private void btnLastLHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastLHActionPerformed
        // TODO add your handling code here:
        indexLoHang = tblLoHang.getRowCount() - 1;
        editLoHang();
    }//GEN-LAST:event_btnLastLHActionPerformed

    private void btnNextLHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextLHMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNextLHMouseEntered

    private void btnNextLHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextLHMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNextLHMouseExited

    private void btnNextLHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextLHActionPerformed
        // TODO add your handling code here:
        indexLoHang++;
        editLoHang();
    }//GEN-LAST:event_btnNextLHActionPerformed

    private void btnPrevLHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevLHMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrevLHMouseEntered

    private void btnPrevLHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevLHMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrevLHMouseExited

    private void btnPrevLHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevLHActionPerformed
        // TODO add your handling code here:
        indexLoHang--;
        editLoHang();
    }//GEN-LAST:event_btnPrevLHActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        moveFrom(evt);
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        MouseDragged(evt, this);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void lblCapNhatSpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCapNhatSpMouseClicked
        chooserDefault(new Color(204, 255, 255), lblDanhSachSp, lblCapNhatLh, lblDanhSachLh, lblLoaiSp1, lblDanhSachTab,
                lblCapNhatTab);
        if (evt.getClickCount() == 1) {
            card.show(pnlTab, "pnlCardCapNhatSp");
            chooserList(new Color(153, 153, 255), lblCapNhatSp);
        }
    }//GEN-LAST:event_lblCapNhatSpMouseClicked

    private void lblSpCungCapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSpCungCapMouseClicked
        clearNCC();
        clearLoHang();
        clearSPCC();
        clearLoaiSP();
        chooserDefault(new Color(204, 255, 255), lblLoHang, lblNhaCungCap, lblLoaiSp);
        chooserDefault(new Color(204, 255, 255), lblDanhSachSp, lblLoaiSp1, lblDanhSachTab,
                lblCapNhatTab, lblCapNhatSp, lblCapNhatLh, lblDanhSachLh);
        if (evt.getClickCount() == 1) {
            card1.show(pnlTabCnDs, "CardSpp");
            card.show(pnlTab, "CardLoading");
            chooserList(new Color(153, 153, 255), lblSpCungCap);
        }
    }//GEN-LAST:event_lblSpCungCapMouseClicked

    private void lblDanhSachLhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDanhSachLhMouseClicked
        chooserDefault(new Color(204, 255, 255), lblCapNhatLh, lblDanhSachSp, lblCapNhatLh, lblLoaiSp1, lblDanhSachTab,
                lblCapNhatTab, lblCapNhatSp);
        if (evt.getClickCount() == 1) {
            card.show(pnlTab, "pnlDanhSachLoHang");
            chooserList(new Color(153, 153, 255), lblDanhSachLh);
        }
    }//GEN-LAST:event_lblDanhSachLhMouseClicked

    private void lblCapNhatLhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCapNhatLhMouseClicked
        chooserDefault(new Color(204, 255, 255), lblDanhSachSp, lblDanhSachLh, lblLoaiSp1, lblDanhSachTab,
                lblCapNhatTab, lblCapNhatSp);
        if (evt.getClickCount() == 1) {
            card.show(pnlTab, "pnlCapNhatLoHang");
            chooserList(new Color(153, 153, 255), lblCapNhatLh);
        }
//        if(!checkFormNCC() || !checkFormCNSP() || !checkFormCNLH() || !checkFormLoaiSP()){
//            if(DialogHelper.confirm(null, "Dữ liệu đang nhập sẽ bị mât \n Bạn có muốn tiếp tục không ?")){
//                
//            }
//        }
    }//GEN-LAST:event_lblCapNhatLhMouseClicked

    private void lblCapNhatSpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCapNhatSpMouseEntered
        lblCapNhatSp.setBorder(white_border);
    }//GEN-LAST:event_lblCapNhatSpMouseEntered

    private void lblSpCungCapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSpCungCapMouseEntered
        lblSpCungCap.setBorder(white_border);
    }//GEN-LAST:event_lblSpCungCapMouseEntered

    private void lblDanhSachLhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDanhSachLhMouseEntered
        lblDanhSachLh.setBorder(white_border);
    }//GEN-LAST:event_lblDanhSachLhMouseEntered

    private void lblCapNhatLhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCapNhatLhMouseEntered
        lblCapNhatLh.setBorder(white_border);
    }//GEN-LAST:event_lblCapNhatLhMouseEntered

    private void lblCapNhatSpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCapNhatSpMouseExited
        lblCapNhatSp.setBorder(default_border);
    }//GEN-LAST:event_lblCapNhatSpMouseExited

    private void lblSpCungCapMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSpCungCapMouseExited
        lblSpCungCap.setBorder(default_border);
    }//GEN-LAST:event_lblSpCungCapMouseExited

    private void lblDanhSachLhMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDanhSachLhMouseExited
        lblDanhSachLh.setBorder(default_border);
    }//GEN-LAST:event_lblDanhSachLhMouseExited

    private void lblCapNhatLhMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCapNhatLhMouseExited
        lblCapNhatLh.setBorder(default_border);
    }//GEN-LAST:event_lblCapNhatLhMouseExited

    private void lblDanhSachSpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDanhSachSpMouseClicked
        chooserDefault(new Color(204, 255, 255), lblCapNhatLh, lblDanhSachLh, lblLoaiSp1, lblDanhSachTab,
                lblCapNhatTab, lblCapNhatSp);
        if (evt.getClickCount() == 1) {
            card.show(pnlTab, "pnlCardDanhSach");
            chooserList(new Color(153, 153, 255), lblDanhSachSp);
        }
    }//GEN-LAST:event_lblDanhSachSpMouseClicked

    private void lblDanhSachSpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDanhSachSpMouseEntered
        lblDanhSachSp.setBorder(white_border);
    }//GEN-LAST:event_lblDanhSachSpMouseEntered

    private void lblDanhSachSpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDanhSachSpMouseExited
        lblDanhSachSp.setBorder(default_border);
    }//GEN-LAST:event_lblDanhSachSpMouseExited

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        card.show(pnlTab, "pnlCardTrangChu");
        card1.show(pnlTabCnDs, "CardTrangChu1");
        chooserDefault(new Color(204, 255, 255), lblDanhSachLh,
                lblLoHang, lblSpCungCap, lblLoaiSp, lblNhaCungCap);
        chooserDefault(new Color(204, 255, 255), lblDanhSachSp, lblLoaiSp1, lblDanhSachTab,
                lblCapNhatTab, lblCapNhatSp, lblCapNhatLh);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void tblSPCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPCCMouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 1) {
            indexSPCC = tblSPCC.getSelectedRow();
            editSPCC();
            card.show(pnlTab, "pnlCardCapNhatSp");
            chooserList(new Color(153, 153, 255), lblCapNhatSp);
            chooserDefault(new Color(204, 255, 255), lblDanhSachSp, lblCapNhatLh, lblDanhSachLh, lblLoaiSp1, lblDanhSachTab,
                    lblCapNhatTab);
        }

    }//GEN-LAST:event_tblSPCCMouseClicked

    private void txtMaSPCCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaSPCCFocusGained
        // TODO add your handling code here:
        if (txtMaSPCC.getForeground().equals(Gray)) {
            Color(txtMaSPCC, "", Plain, Black);
        }
    }//GEN-LAST:event_txtMaSPCCFocusGained

    private void txtMaSPCCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaSPCCFocusLost
        if (txtMaSPCC.getText().trim().isEmpty()) {
            Color(txtMaSPCC, "VD: CC1 ", Italic, Gray);
        } else {
            lblLoiMaSPCC.setText("");
        }
    }//GEN-LAST:event_txtMaSPCCFocusLost

    private void txtTenSPCCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenSPCCFocusGained
        if (txtTenSPCC.getForeground().equals(Gray)) {
            Color(txtTenSPCC, "", Plain, Black);
        }
    }//GEN-LAST:event_txtTenSPCCFocusGained

    private void txtTenSPCCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenSPCCFocusLost
        if (txtTenSPCC.getText().trim().isEmpty()) {
            Color(txtTenSPCC, "VD: Bột giặt ABA ", Italic, Gray);
        } else {
            lblLoiTenSPCC.setText("");
        }
    }//GEN-LAST:event_txtTenSPCCFocusLost

    private void txtGiaSPCCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGiaSPCCFocusGained
        if (txtGiaSPCC.getForeground().equals(Gray)) {
            Color(txtGiaSPCC, "", Plain, Black);
        }
    }//GEN-LAST:event_txtGiaSPCCFocusGained

    private void txtGiaSPCCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGiaSPCCFocusLost
        if (txtGiaSPCC.getText().trim().isEmpty()) {
            Color(txtGiaSPCC, "VD: 20000(Nhập số lớn hơn 0!) ", Italic, Gray);
        } else {
            lblLoiGiaSPCC.setText("");
        }
    }//GEN-LAST:event_txtGiaSPCCFocusLost

    private void txtDonVTSPCCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDonVTSPCCFocusGained
        if (txtDonVTSPCC.getForeground().equals(Gray)) {
            Color(txtDonVTSPCC, "", Plain, Black);
        }
    }//GEN-LAST:event_txtDonVTSPCCFocusGained

    private void txtDonVTSPCCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDonVTSPCCFocusLost
        if (txtDonVTSPCC.getText().trim().isEmpty()) {
            Color(txtDonVTSPCC, "VD: Kg(Chữ cái đầu phải viết hoa!) ", Italic, Gray);
        } else {
            lblLoiDonVTSPCC.setText("");
        }
    }//GEN-LAST:event_txtDonVTSPCCFocusLost

    private void txtTenSPCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSPCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSPCCActionPerformed

    private void txtIDLoaiSPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDLoaiSPFocusGained
        if (txtIDLoaiSP.getForeground().equals(Gray)) {
            Color(txtIDLoaiSP, "", Plain, Black);
        }
    }//GEN-LAST:event_txtIDLoaiSPFocusGained

    private void txtIDLoaiSPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDLoaiSPFocusLost
        if (txtIDLoaiSP.getText().trim().isEmpty()) {
            Color(txtIDLoaiSP, "VD: 015(Phải là số nguyên lớn hơn 0!)", Italic, Gray);
        } else {
            lblLoiDonVTSPCC.setText("");
        }
    }//GEN-LAST:event_txtIDLoaiSPFocusLost

    private void txtLoaiSPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLoaiSPFocusGained
        if (txtLoaiSP.getForeground().equals(Gray)) {
            Color(txtLoaiSP, "", Plain, Black);
        }
    }//GEN-LAST:event_txtLoaiSPFocusGained

    private void txtLoaiSPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLoaiSPFocusLost
        if (txtLoaiSP.getText().trim().isEmpty()) {
            Color(txtLoaiSP, "VD: SP ", Italic, Gray);
        } else {
            lblLoiLoaiSP.setText("");
        }
    }//GEN-LAST:event_txtLoaiSPFocusLost

    private void txtMaLHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaLHFocusGained
        if (txtMaLH.getForeground().equals(Gray)) {
            Color(txtMaLH, "", Plain, Black);
        }
    }//GEN-LAST:event_txtMaLHFocusGained

    private void txtMaLHFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaLHFocusLost
        if (txtMaLH.getText().trim().isEmpty()) {
            Color(txtMaLH, "VD: LH1 ", Italic, Gray);
        } else {
            lblLoiMaLH.setText("");
        }
    }//GEN-LAST:event_txtMaLHFocusLost

    private void txtTenLHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenLHFocusGained
        if (txtTenLH.getForeground().equals(Gray)) {
            Color(txtTenLH, "", Plain, Black);
        }
    }//GEN-LAST:event_txtTenLHFocusGained

    private void txtTenLHFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenLHFocusLost
        if (txtTenLH.getText().trim().isEmpty()) {
            Color(txtTenLH, "VD: Lô 1 ", Italic, Gray);
        } else {
            lblLoiTenLoHang.setText("");
        }
    }//GEN-LAST:event_txtTenLHFocusLost

    private void txtViTriLHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtViTriLHFocusGained
        if (txtViTriLH.getForeground().equals(Gray)) {
            Color(txtViTriLH, "", Plain, Black);
        }
    }//GEN-LAST:event_txtViTriLHFocusGained

    private void txtViTriLHFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtViTriLHFocusLost
        if (txtViTriLH.getText().trim().isEmpty()) {
            Color(txtViTriLH, "VD: Trên  ", Italic, Gray);
        } else {
            lblLoiViTriLH.setText("");
        }
    }//GEN-LAST:event_txtViTriLHFocusLost

    private void txtMoLHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMoLHFocusGained
        if (txtMoLH.getForeground().equals(Gray)) {
            Color(txtMoLH, "", Plain, Black);
        }
    }//GEN-LAST:event_txtMoLHFocusGained

    private void txtMoLHFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMoLHFocusLost
        if (txtMoLH.getText().trim().isEmpty()) {
            Color(txtMoLH, "VD: 9 ", Italic, Gray);
        } else {
            lblLoiMoTaLH.setText("");
        }
    }//GEN-LAST:event_txtMoLHFocusLost

    private void btnInsertSPCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertSPCCMouseClicked

    }//GEN-LAST:event_btnInsertSPCCMouseClicked

    private void btnDeleteSPCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteSPCCMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteSPCCMouseClicked

    private void btnInsertLoaiSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertLoaiSPMouseClicked
        // TODO add your handling code here:
        if (checkFormLoaiSP() == true) {
            if (vailidateFormLSP() == true) {
                insertLoaiSP();
            }
        }
    }//GEN-LAST:event_btnInsertLoaiSPMouseClicked

    private void txtMaLHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaLHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaLHActionPerformed

    private void lblDanhSachTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDanhSachTabMouseClicked
        chooserDefault(new Color(204, 255, 255), lblDanhSachSp, lblCapNhatLh, lblDanhSachLh, lblLoaiSp1,
                lblCapNhatTab, lblCapNhatSp);
        if (evt.getClickCount() == 1) {
            card.show(pnlTab, "pnlDanhSach");
            chooserList(new Color(153, 153, 255), lblDanhSachTab);
        }
    }//GEN-LAST:event_lblDanhSachTabMouseClicked

    private void lblDanhSachTabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDanhSachTabMouseEntered
        lblDanhSachTab.setBorder(white_border);
    }//GEN-LAST:event_lblDanhSachTabMouseEntered

    private void lblDanhSachTabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDanhSachTabMouseExited
        lblDanhSachTab.setBorder(default_border);
    }//GEN-LAST:event_lblDanhSachTabMouseExited

    private void lblCapNhatTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCapNhatTabMouseClicked
        chooserDefault(new Color(204, 255, 255), lblDanhSachSp, lblCapNhatLh, lblDanhSachLh, lblLoaiSp1, lblDanhSachTab,
                lblCapNhatSp);
        if (evt.getClickCount() == 1) {
            card.show(pnlTab, "pnlCapNhat");
            chooserList(new Color(153, 153, 255), lblCapNhatTab);
        }
    }//GEN-LAST:event_lblCapNhatTabMouseClicked

    private void lblCapNhatTabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCapNhatTabMouseEntered
        lblCapNhatTab.setBorder(white_border);
    }//GEN-LAST:event_lblCapNhatTabMouseEntered

    private void lblCapNhatTabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCapNhatTabMouseExited
        lblCapNhatTab.setBorder(default_border);
    }//GEN-LAST:event_lblCapNhatTabMouseExited

    private void txtTimKiemNhaCCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemNhaCCFocusGained
        if (txtTimKiemNhaCC.getForeground().equals(Gray)) {
            Color(txtTimKiemNhaCC, "", Plain, Black);
        }
    }//GEN-LAST:event_txtTimKiemNhaCCFocusGained

    private void txtTimKiemNhaCCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemNhaCCFocusLost
        if (txtTimKiemNhaCC.getText().trim().isEmpty()) {
            Color(txtTimKiemNhaCC, "VD: NCC1", Italic, Gray);
        }
    }//GEN-LAST:event_txtTimKiemNhaCCFocusLost

    private void txtMaNhaCCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaNhaCCFocusGained
        if (txtMaNhaCC.getForeground().equals(Gray)) {
            Color(txtMaNhaCC, "", Plain, Black);
        }
    }//GEN-LAST:event_txtMaNhaCCFocusGained

    private void txtMaNhaCCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaNhaCCFocusLost
        if (txtMaNhaCC.getText().trim().isEmpty()) {
            Color(txtMaNhaCC, "VD: NCC1 ", Italic, Gray);
        } else {
            lblLoiMaNhaCC.setText("");
        }
    }//GEN-LAST:event_txtMaNhaCCFocusLost

    private void txtTenNhaCCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenNhaCCFocusGained
        if (txtTenNhaCC.getForeground().equals(Gray)) {
            Color(txtTenNhaCC, "", Plain, Black);
        }
    }//GEN-LAST:event_txtTenNhaCCFocusGained

    private void txtTenNhaCCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenNhaCCFocusLost
        if (txtTenNhaCC.getText().trim().isEmpty()) {
            Color(txtTenNhaCC, "VD: CTY Long Thành ", Italic, Gray);
        } else {
            lblLoiTenNhaCC.setText("");
        }
    }//GEN-LAST:event_txtTenNhaCCFocusLost

    private void txtSDTNhaCCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSDTNhaCCFocusGained
        if (txtSDTNhaCC.getForeground().equals(Gray)) {
            Color(txtSDTNhaCC, "", Plain, Black);
        }
    }//GEN-LAST:event_txtSDTNhaCCFocusGained

    private void txtSDTNhaCCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSDTNhaCCFocusLost
        if (txtSDTNhaCC.getText().trim().isEmpty()) {
            Color(txtSDTNhaCC, "VD: 0889****** ", Italic, Gray);
        } else {
            lblLoiSDTNhaCC.setText("");
        }
    }//GEN-LAST:event_txtSDTNhaCCFocusLost

    private void txtEmailNhaCCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailNhaCCFocusGained
        if (txtEmailNhaCC.getForeground().equals(Gray)) {
            Color(txtEmailNhaCC, "", Plain, Black);
        }
    }//GEN-LAST:event_txtEmailNhaCCFocusGained

    private void txtEmailNhaCCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailNhaCCFocusLost
        if (txtEmailNhaCC.getText().trim().isEmpty()) {
            Color(txtEmailNhaCC, "VD: kimbinhmai@gmail.com ", Italic, Gray);
        } else {
            lblLoiEmailNhaCC.setText("");
        }
    }//GEN-LAST:event_txtEmailNhaCCFocusLost

    private void txtDiaChiNhaCCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiaChiNhaCCFocusGained
        if (txtDiaChiNhaCC.getForeground().equals(Gray)) {
            Color(txtDiaChiNhaCC, "", Plain, Black);
        }
    }//GEN-LAST:event_txtDiaChiNhaCCFocusGained

    private void txtDiaChiNhaCCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiaChiNhaCCFocusLost
        if (txtDiaChiNhaCC.getText().trim().isEmpty()) {
            Color(txtDiaChiNhaCC, "VD: 318_Tô ký, TP HCM ", Italic, Gray);
        } else {
            lblLoiDiaChiNhaCC.setText("");
        }
    }//GEN-LAST:event_txtDiaChiNhaCCFocusLost

    private void btnInsertNhaCCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertNhaCCMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnInsertSPCC);
    }//GEN-LAST:event_btnInsertNhaCCMouseEntered

    private void btnInsertNhaCCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertNhaCCMouseExited
        setBackround(new Color(0, 0, 255), Color.WHITE, btnInsertSPCC);
    }//GEN-LAST:event_btnInsertNhaCCMouseExited

    private void btnInsertNhaCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertNhaCCActionPerformed
        if (checkFormNCC() == true) {
            if (validateFormNCC() == true) {
                insertNCC();
            }
        }
    }//GEN-LAST:event_btnInsertNhaCCActionPerformed

    private void btnFirstNhaCCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstNhaCCMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnFirstSPCC);
    }//GEN-LAST:event_btnFirstNhaCCMouseEntered

    private void btnFirstNhaCCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstNhaCCMouseExited
        setBackround(new Color(0, 0, 255), Color.WHITE, btnFirstSPCC);
    }//GEN-LAST:event_btnFirstNhaCCMouseExited

    private void btnFirstNhaCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstNhaCCActionPerformed
        indexNCC = 0;
        editNCC();
    }//GEN-LAST:event_btnFirstNhaCCActionPerformed

    private void btnPrevNhaCCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevNhaCCMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnPrevSPCC);
    }//GEN-LAST:event_btnPrevNhaCCMouseEntered

    private void btnPrevNhaCCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevNhaCCMouseExited
        setBackround(new Color(0, 0, 255), Color.WHITE, btnPrevSPCC);
    }//GEN-LAST:event_btnPrevNhaCCMouseExited

    private void btnPrevNhaCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevNhaCCActionPerformed
        indexNCC--;
        editNCC();
    }//GEN-LAST:event_btnPrevNhaCCActionPerformed

    private void btnNextNhaCCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextNhaCCMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnNextSPCC);
    }//GEN-LAST:event_btnNextNhaCCMouseEntered

    private void btnNextNhaCCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextNhaCCMouseExited
        setBackround(new Color(0, 0, 255), Color.WHITE, btnNextSPCC);
    }//GEN-LAST:event_btnNextNhaCCMouseExited

    private void btnNextNhaCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextNhaCCActionPerformed
        indexNCC++;
        editNCC();
    }//GEN-LAST:event_btnNextNhaCCActionPerformed

    private void btnLastNhaCCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastNhaCCMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnLastSPCC);
    }//GEN-LAST:event_btnLastNhaCCMouseEntered

    private void btnLastNhaCCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastNhaCCMouseExited
        setBackround(new Color(0, 0, 255), Color.WHITE, btnLastSPCC);
    }//GEN-LAST:event_btnLastNhaCCMouseExited

    private void btnLastNhaCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastNhaCCActionPerformed
        indexNCC = tblNhaCungCap.getRowCount() - 1;
        editNCC();
    }//GEN-LAST:event_btnLastNhaCCActionPerformed

    private void btnNewNhaCCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewNhaCCMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnNewSPCC);
    }//GEN-LAST:event_btnNewNhaCCMouseEntered

    private void btnNewNhaCCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewNhaCCMouseExited
        setBackround(new Color(0, 0, 255), Color.WHITE, btnNewSPCC);
    }//GEN-LAST:event_btnNewNhaCCMouseExited

    private void btnNewNhaCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewNhaCCActionPerformed
        clearNCC();
    }//GEN-LAST:event_btnNewNhaCCActionPerformed

    private void btnUpdateNhaCCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateNhaCCMouseEntered

    }//GEN-LAST:event_btnUpdateNhaCCMouseEntered

    private void btnUpdateNhaCCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateNhaCCMouseExited

    }//GEN-LAST:event_btnUpdateNhaCCMouseExited

    private void btnUpdateNhaCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateNhaCCActionPerformed
        if (checkFormNCC() == true) {
            if (validateFormNCC() == true) {
                updateNCC();
            }
        }
    }//GEN-LAST:event_btnUpdateNhaCCActionPerformed

    private void btnDeleteNhaCCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteNhaCCMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnDeleteSPCC);
    }//GEN-LAST:event_btnDeleteNhaCCMouseEntered

    private void btnDeleteNhaCCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteNhaCCMouseExited
        setBackround(new Color(0, 0, 255), Color.WHITE, btnDeleteSPCC);
    }//GEN-LAST:event_btnDeleteNhaCCMouseExited

    private void btnDeleteNhaCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteNhaCCActionPerformed
        deleteNCC();
    }//GEN-LAST:event_btnDeleteNhaCCActionPerformed

    private void lblLoaiSp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoaiSp1MouseClicked
        chooserDefault(new Color(204, 255, 255), lblDanhSachSp, lblCapNhatLh, lblDanhSachLh, lblDanhSachTab,
                lblCapNhatTab, lblCapNhatSp);
        if (evt.getClickCount() == 1) {
            card.show(pnlTab, "pnlCardLoaiSp");
            chooserList(new Color(153, 153, 255), lblLoaiSp1);
        }
    }//GEN-LAST:event_lblLoaiSp1MouseClicked

    private void lblLoaiSp1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoaiSp1MouseEntered
        lblLoaiSp1.setBorder(white_border);
    }//GEN-LAST:event_lblLoaiSp1MouseEntered

    private void lblLoaiSp1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoaiSp1MouseExited
        lblLoaiSp1.setBorder(default_border);
    }//GEN-LAST:event_lblLoaiSp1MouseExited

    private void lblNhaCungCapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhaCungCapMouseClicked
        chooserDefault(new Color(204, 255, 255), lblLoHang, lblSpCungCap, lblLoaiSp);
        chooserDefault(new Color(204, 255, 255), lblDanhSachSp, lblLoaiSp1, lblDanhSachTab,
                lblCapNhatTab, lblCapNhatSp, lblCapNhatLh, lblDanhSachLh);
        clearNCC();
        clearLoHang();
        clearSPCC();
        clearLoaiSP();
        if (evt.getClickCount() == 1) {
            card1.show(pnlTabCnDs, "CardNhaCcc");
            card.show(pnlTab, "CardLoading");
            chooserList(new Color(153, 153, 255), lblNhaCungCap);
        }

    }//GEN-LAST:event_lblNhaCungCapMouseClicked

    private void lblNhaCungCapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhaCungCapMouseEntered
        lblNhaCungCap.setBorder(white_border);
    }//GEN-LAST:event_lblNhaCungCapMouseEntered

    private void lblNhaCungCapMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhaCungCapMouseExited
        lblNhaCungCap.setBorder(default_border);
    }//GEN-LAST:event_lblNhaCungCapMouseExited

    private void lblLoaiSpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoaiSpMouseClicked
        clearNCC();
        clearLoHang();
        clearSPCC();
        clearLoaiSP();

        chooserDefault(new Color(204, 255, 255), lblNhaCungCap, lblSpCungCap, lblLoHang);
        chooserDefault(new Color(204, 255, 255), lblDanhSachSp, lblLoaiSp1, lblDanhSachTab,
                lblCapNhatTab, lblCapNhatSp, lblCapNhatLh, lblDanhSachLh);
        if (evt.getClickCount() == 1) {
            card.show(pnlTab, "CardLoading");
            card1.show(pnlTabCnDs, "CardLoaiSpp");
            chooserList(new Color(153, 153, 255), lblLoaiSp);
        }
    }//GEN-LAST:event_lblLoaiSpMouseClicked

    private void lblLoaiSpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoaiSpMouseEntered
        lblLoaiSp.setBorder(white_border);
    }//GEN-LAST:event_lblLoaiSpMouseEntered

    private void lblLoaiSpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoaiSpMouseExited
        lblLoaiSp.setBorder(default_border);
    }//GEN-LAST:event_lblLoaiSpMouseExited

    private void lblLoHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoHangMouseClicked
        clearNCC();
        clearLoHang();
        clearSPCC();
        clearLoaiSP();
        if (evt.getClickCount() == 1) {
            chooserDefault(new Color(204, 255, 255), lblNhaCungCap, lblSpCungCap, lblLoaiSp);
            chooserDefault(new Color(204, 255, 255), lblDanhSachSp, lblLoaiSp1, lblDanhSachTab,
                    lblCapNhatTab, lblCapNhatSp, lblCapNhatLh, lblDanhSachLh);
            card1.show(pnlTabCnDs, "CardLoHangg");
            card.show(pnlTab, "CardLoading");
            chooserList(new Color(153, 153, 255), lblLoHang);
        }
    }//GEN-LAST:event_lblLoHangMouseClicked

    private void lblLoHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoHangMouseEntered
        lblLoHang.setBorder(white_border);
    }//GEN-LAST:event_lblLoHangMouseEntered

    private void lblLoHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoHangMouseExited
        lblLoHang.setBorder(default_border);
    }//GEN-LAST:event_lblLoHangMouseExited

    private void tblLoHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoHangMouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 2) {
            indexLoHang = tblLoHang.getSelectedRow();
            editLoHang();
            chooserDefault(new Color(204, 255, 255), lblDanhSachSp, lblDanhSachLh, lblLoaiSp1, lblDanhSachTab,
                    lblCapNhatTab, lblCapNhatSp);
            card.show(pnlTab, "pnlCapNhatLoHang");
            chooserList(new Color(153, 153, 255), lblCapNhatLh);
        }

    }//GEN-LAST:event_tblLoHangMouseClicked

    private void txtTimKiemLHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemLHKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTimKiemLHKeyPressed

    private void txtTimKiemLHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemLHKeyReleased
        // TODO add your handling code here:
        loadLoHangTK();
    }//GEN-LAST:event_txtTimKiemLHKeyReleased

    private void tblNhaCungCapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblNhaCungCapKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_tblNhaCungCapKeyReleased

    private void txtTimKiemNhaCCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemNhaCCKeyReleased
        loadNhaCungCapTK();
    }//GEN-LAST:event_txtTimKiemNhaCCKeyReleased

    private void tblNhaCungCapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhaCungCapMouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 1) {
            indexNCC = tblNhaCungCap.getSelectedRow();
            editNCC();
            card.show(pnlTab, "pnlCapNhat");
            chooserDefault(new Color(204, 255, 255), lblDanhSachSp, lblCapNhatLh, lblDanhSachLh, lblLoaiSp1, lblDanhSachTab,
                    lblCapNhatSp);
            chooserList(new Color(153, 153, 255), lblCapNhatTab);
        }
    }//GEN-LAST:event_tblNhaCungCapMouseClicked

    private void txtTimKiemSPCCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemSPCCKeyReleased
        // TODO add your handling code here:
        loadSPCCTK();
    }//GEN-LAST:event_txtTimKiemSPCCKeyReleased

    private void tblLoaiSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiSPMouseClicked
        // TODO add your handling code here:
        indexLoaiSP = tblLoaiSP.getSelectedRow();
        editLoaiSP();
    }//GEN-LAST:event_tblLoaiSPMouseClicked

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        dispose();
        FromChaQuanLy_JFrame ql = new FromChaQuanLy_JFrame();
        ql.setVisible(true);
    }//GEN-LAST:event_jLabel30MouseClicked

    private void jLabel30MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseEntered
        jLabel30.setIcon(Back2);
    }//GEN-LAST:event_jLabel30MouseEntered

    private void jLabel30MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseExited
        jLabel30.setIcon(Back1);
    }//GEN-LAST:event_jLabel30MouseExited

    private void lblExcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExcelMouseClicked
        if (tblSPCC.getRowCount() == 0) {
            DialogHelper.alert(null, "Không có dữ liệu bạn cần xuất!");
            return;
        }
        xuatFile(tblSPCC);
    }//GEN-LAST:event_lblExcelMouseClicked

    private void lblExcelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExcelMouseEntered
        ImageIcon excel = new ImageIcon("src/icon/excelIcon.png");
        lblExcel.setIcon(excel);
    }//GEN-LAST:event_lblExcelMouseEntered

    private void lblExcelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExcelMouseExited
        ImageIcon excel = new ImageIcon("src/icon/excelIcon1.png");
        lblExcel.setIcon(excel);
    }//GEN-LAST:event_lblExcelMouseExited

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
            java.util.logging.Logger.getLogger(KhoHang_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhoHang_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhoHang_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhoHang_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhoHang_JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteLH;
    private javax.swing.JButton btnDeleteLoaiSP;
    private javax.swing.JButton btnDeleteNhaCC;
    private javax.swing.JButton btnDeleteSPCC;
    private javax.swing.JButton btnFirstLoaiSP;
    private javax.swing.JButton btnFirstNhaCC;
    private javax.swing.JButton btnFirstSPCC;
    private javax.swing.JButton btnFistLH;
    private javax.swing.JButton btnInsertLH;
    private javax.swing.JButton btnInsertLoaiSP;
    private javax.swing.JButton btnInsertNhaCC;
    private javax.swing.JButton btnInsertSPCC;
    private javax.swing.JButton btnLastLH;
    private javax.swing.JButton btnLastLoaiSP;
    private javax.swing.JButton btnLastNhaCC;
    private javax.swing.JButton btnLastSPCC;
    private javax.swing.JButton btnNewLH;
    private javax.swing.JButton btnNewLoaiSP;
    private javax.swing.JButton btnNewNhaCC;
    private javax.swing.JButton btnNewSPCC;
    private javax.swing.JButton btnNextLH;
    private javax.swing.JButton btnNextLoaiSP;
    private javax.swing.JButton btnNextNhaCC;
    private javax.swing.JButton btnNextSPCC;
    private javax.swing.JButton btnPrevLH;
    private javax.swing.JButton btnPrevLoaiSP;
    private javax.swing.JButton btnPrevNhaCC;
    private javax.swing.JButton btnPrevSPCC;
    private javax.swing.JButton btnUpdateLH;
    private javax.swing.JButton btnUpdateLoaiSP;
    private javax.swing.JButton btnUpdateNhaCC;
    private javax.swing.JButton btnUpdateSPCC;
    private javax.swing.JComboBox<String> cboIDSPCC;
    private javax.swing.JComboBox<String> cboMaNCCCNSP;
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
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
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
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel lblCapNhatLh;
    private javax.swing.JLabel lblCapNhatSp;
    private javax.swing.JLabel lblCapNhatTab;
    private javax.swing.JLabel lblDanhSachLh;
    private javax.swing.JLabel lblDanhSachSp;
    private javax.swing.JLabel lblDanhSachTab;
    private javax.swing.JLabel lblExcel;
    private javax.swing.JLabel lblHinhSPCC;
    private javax.swing.JLabel lblLoHang;
    private javax.swing.JLabel lblLoaiSp;
    private javax.swing.JLabel lblLoaiSp1;
    private javax.swing.JLabel lblLoiDiaChiNhaCC;
    private javax.swing.JLabel lblLoiDonVTSPCC;
    private javax.swing.JLabel lblLoiEmailNhaCC;
    private javax.swing.JLabel lblLoiGiaSPCC;
    private javax.swing.JLabel lblLoiHinhSPCC;
    private javax.swing.JLabel lblLoiIDLoaiSP;
    private javax.swing.JLabel lblLoiIDSPCC;
    private javax.swing.JLabel lblLoiLoaiSP;
    private javax.swing.JLabel lblLoiMaLH;
    private javax.swing.JLabel lblLoiMaNhaCC;
    private javax.swing.JLabel lblLoiMaNhaCCSPCC;
    private javax.swing.JLabel lblLoiMaSPCC;
    private javax.swing.JLabel lblLoiMoTaLH;
    private javax.swing.JLabel lblLoiSDTNhaCC;
    private javax.swing.JLabel lblLoiTenDangNhap;
    private javax.swing.JLabel lblLoiTenLoHang;
    private javax.swing.JLabel lblLoiTenNhaCC;
    private javax.swing.JLabel lblLoiTenSPCC;
    private javax.swing.JLabel lblLoiViTriLH;
    private javax.swing.JLabel lblMaSP;
    private javax.swing.JLabel lblMaSP1;
    private javax.swing.JLabel lblMaSP10;
    private javax.swing.JLabel lblMaSP11;
    private javax.swing.JLabel lblMaSP12;
    private javax.swing.JLabel lblMaSP13;
    private javax.swing.JLabel lblMaSP14;
    private javax.swing.JLabel lblMaSP15;
    private javax.swing.JLabel lblMaSP16;
    private javax.swing.JLabel lblMaSP17;
    private javax.swing.JLabel lblMaSP18;
    private javax.swing.JLabel lblMaSP2;
    private javax.swing.JLabel lblMaSP3;
    private javax.swing.JLabel lblMaSP4;
    private javax.swing.JLabel lblMaSP5;
    private javax.swing.JLabel lblMaSP6;
    private javax.swing.JLabel lblMaSP7;
    private javax.swing.JLabel lblMaSP8;
    private javax.swing.JLabel lblMaSP9;
    private javax.swing.JLabel lblNhaCungCap;
    private javax.swing.JLabel lblSpCungCap;
    private keeptoo.KGradientPanel pnlCapNhatLoHang;
    private javax.swing.JPanel pnlCardCapNhatNhaCC;
    private keeptoo.KGradientPanel pnlCardCapNhatSp;
    private keeptoo.KGradientPanel pnlCardDanhSachSpCc;
    private keeptoo.KGradientPanel pnlCardLoHang;
    private javax.swing.JPanel pnlCardLoading;
    private keeptoo.KGradientPanel pnlCardLoaiSP;
    private keeptoo.KGradientPanel pnlCardLoaiSp;
    private keeptoo.KGradientPanel pnlCardNhaCc;
    private keeptoo.KGradientPanel pnlCardSpCc;
    private keeptoo.KGradientPanel pnlCardTrangChu;
    private keeptoo.KGradientPanel pnlCardTrangChu1;
    private keeptoo.KGradientPanel pnlCardTrangChu2;
    private javax.swing.JPanel pnlCradDanhSachNhaCC;
    private keeptoo.KGradientPanel pnlDanhSachLoHang;
    private javax.swing.JPanel pnlTab;
    private keeptoo.KGradientPanel pnlTabCnDs;
    private javax.swing.JTable tblLoHang;
    private javax.swing.JTable tblLoaiSP;
    private javax.swing.JTable tblNhaCungCap;
    private javax.swing.JTable tblSPCC;
    private javax.swing.JTextField txtDiaChiNhaCC;
    private javax.swing.JTextField txtDonVTSPCC;
    private javax.swing.JTextField txtEmailNhaCC;
    private javax.swing.JTextField txtGiaSPCC;
    private javax.swing.JTextField txtIDLoaiSP;
    private javax.swing.JTextField txtLoaiSP;
    private javax.swing.JTextField txtMaLH;
    private javax.swing.JTextField txtMaNhaCC;
    private javax.swing.JTextField txtMaSPCC;
    private javax.swing.JTextArea txtMoLH;
    private javax.swing.JTextField txtSDTNhaCC;
    private javax.swing.JTextField txtTenLH;
    private javax.swing.JTextField txtTenNhaCC;
    private javax.swing.JTextField txtTenSPCC;
    private javax.swing.JTextField txtTimKiemLH;
    private javax.swing.JTextField txtTimKiemNhaCC;
    private javax.swing.JTextField txtTimKiemSPCC;
    private javax.swing.JTextField txtViTriLH;
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
            lblHinhSPCC.setIcon(anh);
            lblHinhSPCC.setToolTipText(file.getName()); //Giữ tên hình trong tooltip
            System.out.println(file.getName());
            if (!lblHinhSPCC.getToolTipText().equals("")) {
                lblLoiHinhSPCC.setText("");
            }
        }
    }

    private boolean checkFormCNSP() {
        int count = 0;
        //bỏ trống mã SP cung cấp
        if (ValidateNull(txtMaSPCC) == false) {
            lblLoiMaSPCC.setText("Không bỏ trống mã sản phẩm cung cấp!");
            count++;
            //      txtMaSPCC.requestFocus();
        } else {
            lblLoiMaSPCC.setText("");
        }
        // bỏ trống mã nhà cung cấp
//          if (ValidateNull(txtMaNhaCC) == false) {
//            lblLoiMaNhaCc.setText("Không bỏ trống mã Nhà cung cấp!");
//            count++;
//       ///     txtMaNhaCC.requestFocus();
//        } else {
//            lblLoiMaNhaCc.setText("");
//        }
        int NCC = cboMaNCCCNSP.getSelectedIndex();
        if (NCC == 0) {
            lblLoiMaNhaCCSPCC.setText("Vui lòng chọn vào mã nhà cung cấp!");
            count++;
        } else {
            lblLoiMaNhaCCSPCC.setText("");
        }
        // bỏ trống  tên SP 
        if (ValidateNull(txtTenSPCC) == false) {
            lblLoiTenSPCC.setText("Không bỏ trống tên sản phẩm!");
            count++;
            ///       txtTenSP.requestFocus();
        } else {
            lblLoiTenSPCC.setText("");
        }
        //bỏ trống giá SP
        if (ValidateNull(txtGiaSPCC) == false) {
            lblLoiGiaSPCC.setText(" Không bỏ trống giá sản phẩm!");
            count++;
            /// txtGia.requestFocus();
        } else {
            lblLoiGiaSPCC.setText("");
        }
        // bỏ trống đơn vị tính
        if (ValidateNull(txtDonVTSPCC) == false) {
            lblLoiDonVTSPCC.setText("Không bỏ trống đơn vj tính!");
            count++;
            //   txtDonVT.requestFocus();
        } else {
            lblLoiDonVTSPCC.setText("");
        }
        //bỏ trống ID
//             if (ValidateNull(txtID) == false) {
//            lblLoiID.setText("Không bỏ trống ID!");
//            count++;
//          //  txtID.requestFocus();
//               } else {
//            lblLoiID.setText("");
//        }   
        int id = cboIDSPCC.getSelectedIndex();
        if (id == 0) {
            lblLoiIDSPCC.setText("Vui lòng chọn vào ID!");
            count++;
        } else {
            lblLoiIDSPCC.setText("");
        }
        if (checkNullHinh(lblHinhSPCC) == false) {
            count++;
            lblLoiHinhSPCC.setText("Không bỏ trống hình bạn ưi!");
        } else {
            lblLoiHinhSPCC.setText("");
        }
        return count == 0;
    }

    private boolean checkFormLoaiSP() {
        int count = 0;
        // bỏ trống ID Loại SP
        if (ValidateNull(txtIDLoaiSP) == false) {
            lblLoiIDLoaiSP.setText("Không bỏ trống ID !");
            count++;
            txtIDLoaiSP.requestFocus();
        } else {
            lblLoiIDLoaiSP.setText("");
        }
        // bỏ trống Loại Sản phẩm
        if (ValidateNull(txtLoaiSP) == false) {
            lblLoiLoaiSP.setText("Không bỏ trống Loại sản Phẩm !");
            count++;

        } else {
            lblLoiLoaiSP.setText("");
        }

        return count == 0;
    }

    private boolean vailidateFormLSP() {
        int count = 0;
        if (checkSoLuong(txtIDLoaiSP) == false) {
            lblLoiIDLoaiSP.setText("ID nhập vào chưa hợp lệ!");
            count++;
        } else {
            lblLoiIDLoaiSP.setText("");
        }
        if (ValidateName(txtLoaiSP) == false) {
            lblLoiLoaiSP.setText("Loại nhà cung cấp nhập vào chưa hợp lệ!");
            count++;
        } else {
            lblLoiLoaiSP.setText("");
        }
        if (count != 0) {
            return false;
        }
        return true;
    }

    private boolean checkFormCNLH() {
        int count = 0;
        // bỏ trống Mã lô hàng
        if (ValidateNull(txtMaLH) == false) {
            lblLoiMaLH.setText("Không bỏ trống mã lô hàng !");
            count++;
            txtMaLH.requestFocus();
        } else {
            lblLoiMaLH.setText("");
        }
        // bỏ trống Tên Lô hàng
        if (ValidateNull(txtTenLH) == false) {
            lblLoiTenLoHang.setText("Không bỏ trống tên lô hàng !");
            count++;
            txtTenLH.requestFocus();
        } else {
            lblLoiTenLoHang.setText("");
        }
        // bỏ trống vị trí
        if (ValidateNull(txtViTriLH) == false) {
            lblLoiViTriLH.setText("Không bỏ trống vị trí !");
            count++;
            txtViTriLH.requestFocus();
        } else {
            lblLoiViTriLH.setText("");
        }
        // bỏ trống mô tả
        if (ValidateNull(txtMoLH) == false) {
            lblLoiMoTaLH.setText("Không bỏ trống mô tả !");
            count++;
            txtMoLH.requestFocus();
        } else {
            lblLoiMoTaLH.setText("");
        }
        return count == 0;
    }
    private boolean validateFormCNLH() {
        int count = 0;
        if (ValidateName(txtTenLH) == false) {
            lblLoiTenLoHang.setText("Tên lô hàng nhập vào chưa hợp lệ!");
            count++;
        } else {
            lblLoiTenLoHang.setText("");
        }
        // kiểm tra tính hợp lệ giá sản phẩm
        if (ValidateName(txtViTriLH) == false) {
            lblLoiViTriLH.setText("Vị trí lô hàng nhập vào chưa hợp lệ!");
            count++;
        } else {
            lblLoiViTriLH.setText("");
        }
     if (count != 0) {
            return false;
        }
        return true;   
    }
    
    

    private boolean validateFormCNSP() {
        int count = 0;
        if (ValidateName(txtTenSPCC) == false) {
            lblLoiTenSPCC.setText("Tên sản phẩm nhập vào chưa hợp lệ!");
            count++;
        } else {
            lblLoiTenSPCC.setText("");
        }
        // kiểm tra tính hợp lệ giá sản phẩm
        if (ValidateGiaSp(txtGiaSPCC) == false) {
            lblLoiGiaSPCC.setText("Giá nhập vào chưa hợp lệ!");
            count++;
        } else {
            lblLoiGiaSPCC.setText("");
        }
        // kiểm tra tính hợp lệ mã nhà cung câp
        if (ValidateName(txtDonVTSPCC) == false) {
            lblLoiDonVTSPCC.setText("Đơn vị nhập vào chưa hợp lệ!");
            count++;
        } else {
            lblLoiDonVTSPCC.setText("");
        }

        if (count != 0) {
            return false;
        }
        return true;
    }

    private boolean checkFormNCC() {
        int count = 0;
        // bỏ trống mã nhà cc
        if (ValidateNull(txtMaNhaCC) == false) {
            lblLoiMaNhaCC.setText("Không bỏ trống mã nhà cung cấp!");
            count++;
            //      txtMaSPCC.requestFocus();
        } else {
            lblLoiMaNhaCC.setText("");
        }
        // bỏ trống tên nhà cung cấp
        if (ValidateNull(txtTenNhaCC) == false) {
            lblLoiTenNhaCC.setText("Không bỏ trống tên nhà cung cấp!");
            count++;
            //      txtMaSPCC.requestFocus();
        } else {
            lblLoiTenNhaCC.setText("");
        }
        //bỏ trống SDT
        if (ValidateNull(txtSDTNhaCC) == false) {
            lblLoiSDTNhaCC.setText("Không bỏ trống số điện thoại!");
            count++;
            //      txtMaSPCC.requestFocus();
        } else {
            lblLoiSDTNhaCC.setText("");
        }
        //bỏ trống Email
        if (ValidateNull(txtEmailNhaCC) == false) {
            lblLoiEmailNhaCC.setText("Không bỏ trống Email!");
            count++;
            //      txtMaSPCC.requestFocus();
        } else {
            lblLoiEmailNhaCC.setText("");
        }
        //bỏ trống Địa chỉ
        if (ValidateNull(txtDiaChiNhaCC) == false) {
            lblLoiDiaChiNhaCC.setText("Không bỏ trống địa chỉ!");
            count++;
            //      txtMaSPCC.requestFocus();
        } else {
            lblLoiDiaChiNhaCC.setText("");
        }
        return count == 0;
    }

    private boolean validateFormNCC() {
        int count = 0;
        if (ValidateNhaCc(txtMaNhaCC) == false) {
            lblLoiMaNhaCC.setText("Mã nhà cung cấp nhập vào chưa hợp lệ!");
            count++;
        } else {
            lblLoiMaNhaCC.setText("");
        }
        if (ValidateName(txtTenNhaCC) == false) {
            lblLoiTenNhaCC.setText("Tên nhà cung cấp nhập vào chưa hợp lệ!");
            count++;
        } else {
            lblLoiTenNhaCC.setText("");
        }
        
        if (ValidateSDT(txtSDTNhaCC) == false) {
            lblLoiSDTNhaCC.setText("Số điện thoại chưa hợp lệ(10 hoặc 11 số)!");
            count++;
        } else {
            lblLoiSDTNhaCC.setText("");
        }
        if (ValidateEmail(txtEmailNhaCC) == false) {
            lblLoiEmailNhaCC.setText("Email chưa hợp lệ!");
            count++;
        } else {
            lblLoiEmailNhaCC.setText("");
        }
        if (count != 0) {
            return false;
        }
        return true;
    }

    //--------------------------------------------------------HÀM CHUNG---------------------------------------------------------------------
    void setStatus(boolean status, JTextField txt, int index, JTable tbl, List<JButton> list) {
        txt.setEditable(status);
        list.get(0).setEnabled(status);
        list.get(1).setEnabled(!status);
        list.get(2).setEnabled(!status);

        boolean first = index > 0;
        boolean last = index < tbl.getRowCount() - 1;

        list.get(3).setEnabled(!status && first);
        list.get(4).setEnabled(!status && first);
        list.get(5).setEnabled(!status && last);
        list.get(6).setEnabled(!status && last);
    }

    //-------------------------------------------------LOẠI SẢN PHẨM-------------------------------------------------------------
    //Load bảng loại sản phẩm
    void loadLoaiSP() {
        DefaultTableModel model = (DefaultTableModel) tblLoaiSP.getModel();
        model.setRowCount(0);
        List<LoaiSP> listLoaiSPDone = daoLoaiSP.selectAll();
        for (LoaiSP lsp : listLoaiSPDone) {
            Object[] ob = {lsp.getID(), lsp.getLoaiSP()};
            model.addRow(ob);
        }
    }

    //Lấy dữ liệu từ form Loại sản phẩm
    LoaiSP getModelLoaiSP() {
        LoaiSP lsp = new LoaiSP();
        lsp.setID(Integer.parseInt(txtIDLoaiSP.getText().trim()));
        lsp.setLoaiSP(txtLoaiSP.getText().trim());
        return lsp;
    }

    //Điều dữ liệu từ bảng vào form
    void setModelLoaiSP(LoaiSP lsp) {
        Color(txtIDLoaiSP, "", Plain, Black);
        Color(txtLoaiSP, "", Plain, Black);
        txtIDLoaiSP.setText(String.valueOf(lsp.getID()));
        txtLoaiSP.setText(lsp.getLoaiSP());
    }

    //Làm mới form Loại sản phẩm
    void clearLoaiSP() {
        Color(txtIDLoaiSP, "VD: 015(Phải là số nguyên lớn hơn 0!)", Italic, Gray);
        Color(txtLoaiSP, "VD: SP ", Italic, Gray);
        lblLoiIDLoaiSP.setText("");
        lblLoiLoaiSP.setText("");
        setStatus(true, txtIDLoaiSP, indexLoaiSP, tblLoaiSP, listBtnLoaiSP);
        tblLoaiSP.clearSelection();
    }

    //Hiển thị đối tượng đươc chọn từ bảng Loại sản phẩm lên form
    void editLoaiSP() {
        int ID = (Integer) tblLoaiSP.getValueAt(indexLoaiSP, 0);
        tblLoaiSP.setRowSelectionInterval(indexLoaiSP, indexLoaiSP);
        LoaiSP lsp = daoLoaiSP.selectById(ID);
        setModelLoaiSP(lsp);
        setStatus(false, txtIDLoaiSP, indexLoaiSP, tblLoaiSP, listBtnLoaiSP);
    }

    //Thêm loại sản phẩm
    void insertLoaiSP() {
        LoaiSP lsp = getModelLoaiSP();
        if (daoLoaiSP.insert(lsp) == 1) {
            loadLoaiSP();
            clearLoaiSP();
            DialogHelper.alert(null, "Thêm mới thành công");
        } else {
            lblLoiIDLoaiSP.setText("ID loại sản phẩm đã tồn tại");
            DialogHelper.alert(null, "Thêm mới thất bại");
        }
    }

    //Cập nhật loại sản phẩm
    void updateLoaiSP() {
        LoaiSP lsp = getModelLoaiSP();
        if (daoLoaiSP.update(lsp) == 1) {
            loadLoaiSP();
            DialogHelper.alert(null, "Cập nhật thành công");
        } else {
            lblLoiIDLoaiSP.setText("ID loại sản phẩm không tồn tại");
            DialogHelper.alert(null, "Cập nhật thất bại");
        }
    }

    //Xóa loại sản phẩm
    void deleteLoaiSP() {
        if (DialogHelper.confirm(null, "Bạn có muốn xóa loại sản phẩm này không ?")) {
            if (daoLoaiSP.delete(Integer.parseInt(txtIDLoaiSP.getText().trim())) == 1) {
                loadLoaiSP();
                clearLoaiSP();
                DialogHelper.alert(null, "Xóa thành công");
            } else {
                lblLoiIDLoaiSP.setText("ID loại sản phẩm không tồn tại");
                DialogHelper.alert(null, "Xóa thất bại");
            }
        }
    }

    //-------------------------------------------------LÔ HÀNG------------------------------------------------------------
    //Đổ dữ liệu lên bảng Lô hàng
    void loadLoHang() {
        DefaultTableModel model = (DefaultTableModel) tblLoHang.getModel();
        model.setRowCount(0);
        List<LoHang> list = daoLoHang.selectAll();
        for (LoHang lh : list) {
            Object[] ob = {lh.getMaLoHang(), lh.getTenLoHang(), lh.getViTri(), lh.getMoTa()};
            model.addRow(ob);
        }
    }

    //Đổ dữ liệu lên bảng Lô hàng khi tìm kiếm
    void loadLoHangTK() {
        DefaultTableModel model = (DefaultTableModel) tblLoHang.getModel();
        model.setRowCount(0);
        List<LoHang> list = daoLoHang.selectByKeyword("%" + txtTimKiemLH.getText() + "%");
        for (LoHang lh : list) {
            Object[] ob = {lh.getMaLoHang(), lh.getTenLoHang(), lh.getViTri(), lh.getMoTa()};
            model.addRow(ob);
        }
    }

    //Lấy dữ liệu từ form Lô hàng
    LoHang getModelLH() {
        LoHang lh = new LoHang();
        lh.setMaLoHang(txtMaLH.getText().trim());
        lh.setTenLoHang(txtTenLH.getText().trim());
        lh.setViTri(txtViTriLH.getText().trim());
        lh.setMoTa(txtMoLH.getText().trim());
        return lh;
    }

    //Đổ dữ liệu lên form Lô hàng
    void setModelLH(LoHang lh) {
        Color(txtMaLH, "", Plain, Black);
        Color(txtTenLH, "", Plain, Black);
        Color(txtViTriLH, "", Plain, Black);
        Color(txtMoLH, "", Plain, Black);
        txtMaLH.setText(lh.getMaLoHang());
        txtTenLH.setText(lh.getTenLoHang());
        txtViTriLH.setText(lh.getViTri());
        txtMoLH.setText(lh.getMoTa());
    }

    //Làm mới form Lô hàng
    void clearLoHang() {
        Color(txtMaLH, "VD: LH1 ", Italic, Gray);
        Color(txtTenLH, "VD: Lô 1 ", Italic, Gray);
        Color(txtViTriLH, "VD: Trên  ", Italic, Gray);
        Color(txtMoLH, "VD: 9 ", Italic, Gray);
        lblLoiMaLH.setText("");
        lblLoiTenLoHang.setText("");
        lblLoiViTriLH.setText("");
        lblLoiMoTaLH.setText("");
        tblNhaCungCap.clearSelection();
        setStatus(true, txtMaLH, indexLoHang, tblLoHang, listBtnLoHang);
    }

    //Đổ dữ liệu đối tượng được chọn từ bảng Lô hàng lên form
    void editLoHang() {
        String maLH = (String) tblLoHang.getValueAt(indexLoHang, 0);
        tblLoHang.setRowSelectionInterval(indexLoHang, indexLoHang);
        LoHang lh = daoLoHang.selectById(maLH);
        setModelLH(lh);
        setStatus(false, txtMaLH, indexLoHang, tblLoHang, listBtnLoHang);
    }

    //Thêm lô hàng
    void insertLoHang() {
        LoHang lh = getModelLH();
        if (daoLoHang.insert(lh) == 1) {
            loadLoHang();
            clearLoHang();
            DialogHelper.alert(null, "Thêm mới thành công");
        } else {
            lblLoiMaLH.setText("Mã lô hàng này đã tồn tại");
            DialogHelper.alert(null, "Thêm mới thất bại");
        }
    }

    //Cập nhật lô hàng
    void updateLoHang() {
        LoHang lh = getModelLH();
        if (daoLoHang.update(lh) == 1) {
            loadLoHang();
            DialogHelper.alert(null, "Cập nhật thành công");
        } else {
            lblLoiMaLH.setText("Mã lô hàng này không tồn tại");
            DialogHelper.alert(null, "Cập nhật thất bại");
        }
    }

    //Xóa lô hàng
    void deleteLoHang() {
        if (DialogHelper.confirm(null, "Bạn có muốn xóa lô hàng này không ?")) {
            if (daoLoHang.delete(txtMaLH.getText().trim()) == 1) {
                loadLoHang();
                clearLoHang();
                DialogHelper.alert(null, "Xóa thành công");
            } else {
                lblLoiMaLH.setText("Mã lô hàng này không tồn tại");
                DialogHelper.alert(null, "Xóa thất bại");
            }
        }
    }

    //------------------------------------------------NHÀ CUNG CẤP-----------------------------------------------
    //Đổ dữ liệu lên bảng Nhà cung cấp
    void loadNhaCungCap() {
        DefaultTableModel model = (DefaultTableModel) tblNhaCungCap.getModel();
        model.setRowCount(0);
        List<NhaCungCap> list = daoNCC.selectAll();
        for (NhaCungCap ncc : list) {
            Object[] ob = {ncc.getMaNCC(), ncc.getTenNCC(), ncc.getSDT(), ncc.getEmail(), ncc.getDiaChi()};
            model.addRow(ob);
        }
    }

    //Đổ dữ liệu lên bảng Nhà cung cấp theo điều kiện tìm kiếm
    void loadNhaCungCapTK() {
        DefaultTableModel model = (DefaultTableModel) tblNhaCungCap.getModel();
        model.setRowCount(0);
        List<NhaCungCap> list = daoNCC.selectByConditions("%" + txtTimKiemNhaCC.getText() + "%");
        for (NhaCungCap ncc : list) {
            Object[] ob = {ncc.getMaNCC(), ncc.getTenNCC(), ncc.getSDT(), ncc.getEmail(), ncc.getDiaChi()};
            model.addRow(ob);
        }
    }

    //Lấy dữ liệu từ form Nhà cung cấp
    NhaCungCap getModelNCC() {
        NhaCungCap ncc = new NhaCungCap();
        ncc.setMaNCC(txtMaNhaCC.getText().trim());
        ncc.setTenNCC(txtTenNhaCC.getText().trim());
        ncc.setSDT(txtSDTNhaCC.getText().trim());
        ncc.setEmail(txtEmailNhaCC.getText().trim());
        ncc.setDiaChi(txtDiaChiNhaCC.getText().trim());
        return ncc;
    }

    //Đổ dữ liệu của 1 đối tượng Nhà cung cấp lên form
    void setModelNCC(NhaCungCap ncc) {
        Color(txtMaNhaCC, "", Plain, Black);
        Color(txtTenNhaCC, "", Plain, Black);
        Color(txtSDTNhaCC, "", Plain, Black);
        Color(txtEmailNhaCC, "", Plain, Black);
        Color(txtDiaChiNhaCC, "", Plain, Black);
        txtMaNhaCC.setText(ncc.getMaNCC());
        txtTenNhaCC.setText(ncc.getTenNCC());
        txtSDTNhaCC.setText(ncc.getSDT());
        txtEmailNhaCC.setText(ncc.getEmail());
        txtDiaChiNhaCC.setText(ncc.getDiaChi());
    }

    //Làm mới form Nhà cung cấp
    void clearNCC() {
        Color(txtMaNhaCC, "VD: NCC1 ", Italic, Gray);
        Color(txtTenNhaCC, "VD: CTY Long Thành ", Italic, Gray);
        Color(txtSDTNhaCC, "VD: 0889****** ", Italic, Gray);
        Color(txtEmailNhaCC, "VD: kimbinhmai@gmail.com ", Italic, Gray);
        Color(txtDiaChiNhaCC, "VD: 318_Tô ký, TP HCM ", Italic, Gray);
        lblLoiMaNhaCC.setText("");
        lblLoiTenNhaCC.setText("");
        lblLoiSDTNhaCC.setText("");
        lblLoiEmailNhaCC.setText("");
        lblLoiDiaChiNhaCC.setText("");
        tblNhaCungCap.clearSelection();
        setStatus(true, txtMaNhaCC, indexNCC, tblNhaCungCap, listBtnNhaCC);
    }

    //ĐỔ dữ liệu của đối tượng được chọn từ bảng Nhà cung cấp lên form
    void editNCC() {
        String maNCC = (String) tblNhaCungCap.getValueAt(indexNCC, 0);
        tblNhaCungCap.setRowSelectionInterval(indexNCC, indexNCC);
        NhaCungCap ncc = daoNCC.selectById(maNCC);
        setModelNCC(ncc);
        setStatus(false, txtMaNhaCC, indexNCC, tblNhaCungCap, listBtnNhaCC);
    }

    //Thêm nhà cung cấp
    void insertNCC() {
        NhaCungCap ncc = getModelNCC();
        if (daoNCC.insert(ncc) == 3) {
            loadNhaCungCap();
            clearNCC();
            DialogHelper.alert(null, "Thêm mới thành công");
        } else if(daoNCC.insert(ncc) == 2){
            lblLoiSDTNhaCC.setText("Số điện thoại này đã tồn tại");
            DialogHelper.alert(null, "Thêm mới thất bại");
        }else if(daoNCC.insert(ncc) == 1){
            lblLoiEmailNhaCC.setText("Email này đã tồn tại");
            DialogHelper.alert(null, "Thêm mới thất bại");
        }else{
            lblLoiMaNhaCC.setText("Mã nhà cung cấp đã tồn tại");
            DialogHelper.alert(null, "Thêm mới thất bại");
        }
    }

    //Cập nhật nhà cung cấp
    void updateNCC() {
        NhaCungCap ncc = getModelNCC();
        if (daoNCC.update(ncc) == 3) {
            loadNhaCungCap();
            DialogHelper.alert(null, "Cập nhật thành công");
        } else if(daoNCC.update(ncc) == 2) {
            lblLoiSDTNhaCC.setText("Số điện thoại này đã tồn tại");
            DialogHelper.alert(null, "Cập nhật thất bại");
        }else if(daoNCC.update(ncc) == 1){
            lblLoiEmailNhaCC.setText("Email này tồn tại");
            DialogHelper.alert(null, "Cập nhật thất bại");
        }else{
            lblLoiMaNhaCC.setText("Mã nhà cung cấp không tồn tại");
            DialogHelper.alert(null, "Cập nhật thất bại");
        }
    }

    //Xóa nhà cung cấp
    void deleteNCC() {
        if (DialogHelper.confirm(null, "Bạn có muốn xóa nhà cung cấp này không ?")) {
            if (daoNCC.delete(txtMaNhaCC.getText().trim()) == 1) {
                loadNhaCungCap();
                clearNCC();
                DialogHelper.alert(null, "Xóa thành công");
            } else {
                lblLoiMaNhaCC.setText("Mã nhà cung cấp này không tồn tại");
                DialogHelper.alert(null, "Xóa thất bại");
            }
        }
    }

    //--------------------------------------------SẢN PHẨM NHÀ CUNG CẤP-----------------------------------------------------
    //Đổ tất cả dữ liệu lên bảng Sản phẩm cung cấp
    void loadSPCC() {
        DefaultTableModel model = (DefaultTableModel) tblSPCC.getModel();
        model.setRowCount(0);
        List<SPCungCap> list = daoSPCC.selectAll();
        for (SPCungCap spcc : list) {
            Object[] ob = {spcc.getMaSPCC(), spcc.getMaNCC(), spcc.getTenSP(),
                spcc.getLoaiSP(), spcc.getGia(), spcc.getDonViTinh(), spcc.getHinh()};
            model.addRow(ob);
        }
    }

    //Đổ dữ liệu lên bảng Sản phẩm cung cấp theo điều kiện tìm kiếm
    void loadSPCCTK() {
        DefaultTableModel model = (DefaultTableModel) tblSPCC.getModel();
        model.setRowCount(0);
        List<SPCungCap> list = daoSPCC.selectByConditions("%" + txtTimKiemSPCC.getText().trim() + "%");
        for (SPCungCap spcc : list) {
            Object[] ob = {spcc.getMaSPCC(), spcc.getMaNCC(), spcc.getTenSP(),
                spcc.getLoaiSP(), spcc.getGia(), spcc.getDonViTinh(), spcc.getHinh()};
            model.addRow(ob);
        }
    }

    //Đổ dữ liệu vào ComboBox Mã nhà cung cấp
    void fillComboBoxNCC() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboMaNCCCNSP.getModel();
        model.removeAllElements();
        List<NhaCungCap> list = daoNCC.selectAll();
        model.insertElementAt("Chọn...", 0);
        model.setSelectedItem("Chọn...");
        for (int i = 0; i < list.size(); i++) {
            model.insertElementAt(list.get(i), i + 1);
        }
    }

    //Đổ dữ liệu bào ComboBox ID loại sản phẩm
    void fillComboBoxLPNCC() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboIDSPCC.getModel();
        model.removeAllElements();
        List<LoaiSP> list = daoLoaiSP.selectAll();
        model.insertElementAt("Chọn...", 0);
        model.setSelectedItem("Chọn...");
        for (int i = 0; i < list.size(); i++) {
            model.insertElementAt(list.get(i), i + 1);
        }
    }

    //Lấy dữ liệu của 1 đối tượng Sản phẩm cung cấp từ form
    SPCungCap getModelSPCC() {
        SPCungCap spcc = new SPCungCap();
        String replace;
        spcc.setMaSPCC(txtMaSPCC.getText().trim());
        NhaCungCap ncc = (NhaCungCap) cboMaNCCCNSP.getSelectedItem();
        spcc.setMaNCC(ncc.getMaNCC());
        spcc.setTenSP(txtTenSPCC.getText().trim());
        LoaiSP lsp = (LoaiSP) cboIDSPCC.getSelectedItem();
        spcc.setLoaiSP(lsp.getID());
        if (txtGiaSPCC.getText().trim().contains(",")) {
            replace = txtGiaSPCC.getText().replace(",", ".").trim();
        } else {
            replace = txtGiaSPCC.getText().trim();
        }
        spcc.setGia(Double.parseDouble(replace));
        spcc.setDonViTinh(txtDonVTSPCC.getText().trim());
        spcc.setHinh(lblHinhSPCC.getToolTipText());
        return spcc;
    }

    //Đổ dữ liệu của 1 đối tượng Sản phẩm cung cấp lên form
    void setModelSPCC(SPCungCap spcc) {
        txtMaSPCC.setText(spcc.getMaSPCC());
        NhaCungCap ncc = daoNCC.selectById(spcc.getMaNCC());
        cboMaNCCCNSP.getModel().setSelectedItem(ncc);
        txtTenSPCC.setText(spcc.getTenSP());
        LoaiSP lsp = daoLoaiSP.selectById(spcc.getLoaiSP());
        cboIDSPCC.getModel().setSelectedItem(lsp);
        txtGiaSPCC.setText(String.valueOf(spcc.getGia()));
        txtDonVTSPCC.setText(spcc.getDonViTinh());
        ImageIcon anh = ImageHelper.read(spcc.getHinh());
        lblHinhSPCC.setIcon(anh);
        lblHinhSPCC.setToolTipText(spcc.getHinh()); //Giữ tên hình trong tooltip
    }

    //Làm mới form Sản phẩm cung cấp
    void clearSPCC() {
        Color(txtMaSPCC, "VD: CC1 ", Italic, Gray);
        Color(txtTenSPCC, "VD: Bột giặt ABA ", Italic, Gray);
        Color(txtGiaSPCC, "VD: 20000(Nhập số lớn hơn 0!) ", Italic, Gray);
        Color(txtDonVTSPCC, "VD: Kg(Chữ cái đầu phải viết hoa!) ", Italic, Gray);
        cboIDSPCC.setSelectedIndex(0);
        cboMaNCCCNSP.setSelectedIndex(0);
        lblHinhSPCC.setIcon(null);
        lblHinhSPCC.setToolTipText(null);
        lblLoiMaSPCC.setText("");
        lblLoiMaNhaCCSPCC.setText("");
        lblLoiTenSPCC.setText("");
        lblLoiGiaSPCC.setText("");
        lblLoiDonVTSPCC.setText("");
        lblLoiIDSPCC.setText("");
        lblLoiHinhSPCC.setText("");
        tblSPCC.clearSelection();
        setStatus(true, txtMaSPCC, indexSPCC, tblSPCC, listBtnSPCC);
    }

    //Đổ dữ liệu của 1 đối tượng Sản phẩm cung cấp đươc chọn trên bảng
    void editSPCC() {
        Color(txtMaSPCC, "", Plain, Black);
        Color(txtTenSPCC, "", Plain, Black);
        Color(txtGiaSPCC, "", Plain, Black);
        Color(txtDonVTSPCC, "", Plain, Black);
        String masp = (String) tblSPCC.getValueAt(indexSPCC, 0);
        tblSPCC.setRowSelectionInterval(indexSPCC, indexSPCC);
        SPCungCap spcc = daoSPCC.selectById(masp);
        setModelSPCC(spcc);
        setStatus(false, txtMaSPCC, indexSPCC, tblSPCC, listBtnSPCC);
    }

    //Thêm Sản phẩm cung cấp
    void insertSPCC() {
        SPCungCap spcc = getModelSPCC();
        if (daoSPCC.insert(spcc) == 3) {
            loadSPCC();
            clearSPCC();
            DialogHelper.alert(null, "Thêm mới thành công");
        } else if (daoSPCC.insert(spcc) == 2) {
            lblLoiIDSPCC.setText("ID loại sản phẩm này không tồn tại");
            DialogHelper.alert(null, "Thêm mới thất bại");
        } else if (daoSPCC.insert(spcc) == 1) {
            lblLoiMaNhaCCSPCC.setText("Nhà cung cấp này chưa tòn tại");
            DialogHelper.alert(null, "Thêm mới thất bại");
        } else {
            lblLoiMaSPCC.setText("Mã sản phẩm cung cấp đã tồn tại");
            DialogHelper.alert(null, "Thêm mới thất bại");
        }
    }

    //Cập nhật sản phẩm cung cấp
    void updateSPCC() {
        SPCungCap spcc = getModelSPCC();
        if (daoSPCC.update(spcc) == 3) {
            loadSPCC();
            DialogHelper.alert(null, "Cập nhật thành công");
        } else if (daoSPCC.update(spcc) == 2) {
            lblLoiIDSPCC.setText("ID loại sản phẩm này không tồn tại");
            DialogHelper.alert(null, "Cập nhật thất bại");
        } else if (daoSPCC.update(spcc) == 1) {
            lblLoiMaNhaCCSPCC.setText("Nhà cung cấp này chưa tòn tại");
            DialogHelper.alert(null, "Cập nhật thất bại");
        } else {
            lblLoiMaSPCC.setText("Mã sản phẩm cung cấp không tồn tại");
            DialogHelper.alert(null, "Cập nhật thất bại");
        }
    }

    //Xóa Sản phẩm cung cấp
    void deleteSPCC() {
        if (DialogHelper.confirm(null, "Bạn có muốn xóa nhà cung cấp này không ?")) {
            if (daoSPCC.delete(txtMaSPCC.getText().trim()) == 1) {
                loadSPCC();
                clearSPCC();
                DialogHelper.alert(null, "Xóa thành công");
            } else {
                lblLoiMaSPCC.setText("Mã nhà cung cấp này không tồn tại");
                DialogHelper.alert(null, "Xóa thất bại");
            }
        }
    }

    boolean checkOut(Object... object) {
        for (int i = 0; i < object.length; i++) {
            if (object[i] instanceof JLabel) {
                JTextField txt = (JTextField) object[i];
                if (!txt.getForeground().equals(Gray)) {
                    return true;
                }
            }
        }
        return false;
    }

}
