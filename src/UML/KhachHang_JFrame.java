/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import Dao.KhachHangDAO;
import Help.Auth;
import static Help.ColorHelper.*;
import Help.DialogHelper;
import static Help.ImageHelper.*;
import static Help.ValidateHelper.*;
import Model.KhachHang;
import Model.TaiKhoan;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class KhachHang_JFrame extends javax.swing.JFrame {

    boolean trangThai;
    KhachHangDAO dao = new KhachHangDAO();
    CardLayout card;
    int index = 0;

    public KhachHang_JFrame(boolean status) {
        initComponents();
        trangThai = status;
        init();
        txtNhanVien.setText(Auth.user.getTenDn());
        txtNhanVien.setEditable(false);

    }

    private KhachHang_JFrame() {
        initComponents();
        trangThai = false;
        init();
        txtNhanVien.setText(Auth.user.getTenDn());
        txtNhanVien.setEditable(false);
    }

    void init() {
        fillTable();
        card = (CardLayout) pnlTab.getLayout();
        designTable(false, new Color(0, 102, 102), Color.white, Plain, tblBangKhachHang);
        designComboBox(new Color(0, 102, 103), Color.white, Plain, cboGioiTinh);
        if (trangThai == true) {
            btnInsertKH.setText("Tạo đơn");
            card.show(pnlTab, "CardDanhSach");
            chooserDefault(new Color(204, 255, 255), lblSatusCapNhat, lblSatusDanhSach, lblSatusTrangChu);
            chooserList(new Color(102, 255, 0), lblSatusDanhSach);
            return;
        } else {
            btnInsertKH.setText("Thêm");
        }
        card.show(pnlTab, "CardKhachHang");
        TaiKhoan nv = Auth.user;
        if (nv == null) {
            txtNhanVien.setEditable(false);
            return;
        }
        txtNhanVien.setText(nv.getHoTen());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel2 = new javax.swing.JPanel();
        lblSatusCapNhat = new javax.swing.JLabel();
        btnCapNhat = new javax.swing.JButton();
        lblSatusDanhSach = new javax.swing.JLabel();
        bntDanhSach = new javax.swing.JButton();
        lblSatusTrangChu = new javax.swing.JLabel();
        btnTrangChu = new javax.swing.JButton();
        pnlTab = new javax.swing.JPanel();
        pnlCardKhachHang = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        pnlCardCapNhat = new keeptoo.KGradientPanel();
        jPanel4 = new javax.swing.JPanel();
        txtMaKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtNhanVien = new javax.swing.JTextField();
        lblMaSP = new javax.swing.JLabel();
        lblMaSP1 = new javax.swing.JLabel();
        lblMaSP2 = new javax.swing.JLabel();
        lblMaSP3 = new javax.swing.JLabel();
        lblMaSP4 = new javax.swing.JLabel();
        lblMaSP5 = new javax.swing.JLabel();
        lblMaSP6 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        lblLoiNhanVien = new javax.swing.JLabel();
        lblLoiDiaChi = new javax.swing.JLabel();
        lblLoiTenKH = new javax.swing.JLabel();
        lblLoiSDT = new javax.swing.JLabel();
        lblLoiEmail = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        cboGioiTinh = new javax.swing.JComboBox<>();
        lblLoiMaKH = new javax.swing.JLabel();
        btnFirstKH = new javax.swing.JButton();
        btnPrevKH = new javax.swing.JButton();
        btnNextKH = new javax.swing.JButton();
        btnLastKH = new javax.swing.JButton();
        btnNewKH = new javax.swing.JButton();
        btnUpdateKH = new javax.swing.JButton();
        btnDeleteKH = new javax.swing.JButton();
        btnInsertKH = new javax.swing.JButton();
        lblLoiGioiTinh = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pnlCardDanhSach = new keeptoo.KGradientPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblBangKhachHang = new javax.swing.JTable();
        txtTimKiemKh = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnTaoDonKhachHang = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        kGradientPanel3 = new keeptoo.KGradientPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 0, 204));
        kGradientPanel1.setkGradientFocus(650);
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSatusCapNhat.setBackground(new java.awt.Color(102, 255, 0));
        lblSatusCapNhat.setOpaque(true);
        jPanel2.add(lblSatusCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 60, 5));

        btnCapNhat.setBackground(new java.awt.Color(255, 255, 255));
        btnCapNhat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.setBorder(null);
        btnCapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCapNhatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCapNhatMouseExited(evt);
            }
        });
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });
        jPanel2.add(btnCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 30));

        lblSatusDanhSach.setBackground(new java.awt.Color(102, 255, 0));
        lblSatusDanhSach.setOpaque(true);
        jPanel2.add(lblSatusDanhSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 70, 5));

        bntDanhSach.setBackground(new java.awt.Color(255, 255, 255));
        bntDanhSach.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bntDanhSach.setText("Danh Sách");
        bntDanhSach.setBorder(null);
        bntDanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bntDanhSachMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bntDanhSachMouseExited(evt);
            }
        });
        bntDanhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDanhSachActionPerformed(evt);
            }
        });
        jPanel2.add(bntDanhSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 90, 30));

        lblSatusTrangChu.setBackground(new java.awt.Color(102, 255, 0));
        lblSatusTrangChu.setOpaque(true);
        jPanel2.add(lblSatusTrangChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 70, 5));

        btnTrangChu.setBackground(new java.awt.Color(255, 255, 255));
        btnTrangChu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTrangChu.setText("Trang chủ");
        btnTrangChu.setBorder(null);
        btnTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTrangChuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTrangChuMouseExited(evt);
            }
        });
        btnTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrangChuActionPerformed(evt);
            }
        });
        jPanel2.add(btnTrangChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 90, 30));

        kGradientPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 60));

        pnlTab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlTab.setLayout(new java.awt.CardLayout());

        pnlCardKhachHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/khachHang.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(102, 204, 0)));
        pnlCardKhachHang.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 78, 898, 400));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 255, 0)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 255));
        jLabel14.setText("Khách hàng/ Trang chủ/");
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 255));
        jLabel15.setText("Trang chủ________________________________________________________");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        pnlCardKhachHang.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 79));

        pnlTab.add(pnlCardKhachHang, "CardTrangChu");

        pnlCardCapNhat.setkEndColor(new java.awt.Color(51, 204, 0));
        pnlCardCapNhat.setkGradientFocus(700);
        pnlCardCapNhat.setkStartColor(new java.awt.Color(255, 255, 255));
        pnlCardCapNhat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMaKH.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtMaKH.setForeground(new java.awt.Color(153, 153, 153));
        txtMaKH.setText("VD: KH1");
        txtMaKH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtMaKH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMaKHFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaKHFocusLost(evt);
            }
        });
        jPanel4.add(txtMaKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 270, 25));

        txtTenKH.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtTenKH.setForeground(new java.awt.Color(153, 153, 153));
        txtTenKH.setText("VD: Nguyễn Văn An");
        txtTenKH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
        jPanel4.add(txtTenKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 270, 25));

        txtEmail.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(153, 153, 153));
        txtEmail.setText("VD: Annv@gmail.com");
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        jPanel4.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 270, 25));

        txtNhanVien.setEditable(false);
        txtNhanVien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNhanVien.setText("VD: Nguyễn Văn Tèo");
        txtNhanVien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNhanVien.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNhanVienFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNhanVienFocusLost(evt);
            }
        });
        jPanel4.add(txtNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 270, 30));

        lblMaSP.setFont(new java.awt.Font("UVN Van Chuong Nang", 0, 14)); // NOI18N
        lblMaSP.setForeground(new java.awt.Color(0, 0, 51));
        lblMaSP.setText("Tên khách hàng");
        jPanel4.add(lblMaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 110, -1));

        lblMaSP1.setFont(new java.awt.Font("UVN Van Chuong Nang", 0, 14)); // NOI18N
        lblMaSP1.setForeground(new java.awt.Color(0, 0, 51));
        lblMaSP1.setText("Mã khách hàng");
        jPanel4.add(lblMaSP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, -1));

        lblMaSP2.setFont(new java.awt.Font("UVN Van Chuong Nang", 0, 14)); // NOI18N
        lblMaSP2.setForeground(new java.awt.Color(0, 0, 51));
        lblMaSP2.setText("Email");
        jPanel4.add(lblMaSP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 50, -1));

        lblMaSP3.setFont(new java.awt.Font("UVN Van Chuong Nang", 0, 14)); // NOI18N
        lblMaSP3.setForeground(new java.awt.Color(0, 0, 51));
        lblMaSP3.setText("Số điện thoại");
        jPanel4.add(lblMaSP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 100, -1));

        lblMaSP4.setFont(new java.awt.Font("UVN Van Chuong Nang", 0, 14)); // NOI18N
        lblMaSP4.setForeground(new java.awt.Color(0, 0, 51));
        lblMaSP4.setText("Địa chỉ");
        jPanel4.add(lblMaSP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 60, -1));

        lblMaSP5.setFont(new java.awt.Font("UVN Van Chuong Nang", 0, 14)); // NOI18N
        lblMaSP5.setForeground(new java.awt.Color(0, 0, 51));
        lblMaSP5.setText("Giới tính");
        jPanel4.add(lblMaSP5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 70, -1));

        lblMaSP6.setFont(new java.awt.Font("UVN Van Chuong Nang", 0, 14)); // NOI18N
        lblMaSP6.setForeground(new java.awt.Color(0, 0, 51));
        lblMaSP6.setText("Nhân viên");
        jPanel4.add(lblMaSP6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 80, 20));

        txtSDT.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtSDT.setForeground(new java.awt.Color(153, 153, 153));
        txtSDT.setText("VD: 075*******(Nhập 10 - 11 số)");
        txtSDT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSDT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSDTFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSDTFocusLost(evt);
            }
        });
        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });
        jPanel4.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 270, 25));

        lblLoiNhanVien.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiNhanVien.setForeground(new java.awt.Color(255, 0, 0));
        jPanel4.add(lblLoiNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 270, 18));

        lblLoiDiaChi.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiDiaChi.setForeground(new java.awt.Color(255, 0, 0));
        jPanel4.add(lblLoiDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 270, 18));

        lblLoiTenKH.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiTenKH.setForeground(new java.awt.Color(255, 0, 0));
        jPanel4.add(lblLoiTenKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 270, 18));

        lblLoiSDT.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiSDT.setForeground(new java.awt.Color(255, 0, 0));
        jPanel4.add(lblLoiSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 270, 18));

        lblLoiEmail.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiEmail.setForeground(new java.awt.Color(255, 0, 0));
        jPanel4.add(lblLoiEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 270, 18));

        txtDiaChi.setColumns(20);
        txtDiaChi.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtDiaChi.setForeground(new java.awt.Color(153, 153, 153));
        txtDiaChi.setRows(5);
        txtDiaChi.setText("VD: 123 Tô Ký, Q12,TP.HCM");
        txtDiaChi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDiaChiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDiaChiFocusLost(evt);
            }
        });
        txtDiaChi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDiaChiKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtDiaChi);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, 350, 100));

        cboGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn", "Nam", "Nữ", "Khác" }));
        cboGioiTinh.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboGioiTinhItemStateChanged(evt);
            }
        });
        jPanel4.add(cboGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, 270, 30));

        lblLoiMaKH.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiMaKH.setForeground(new java.awt.Color(255, 0, 0));
        jPanel4.add(lblLoiMaKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 270, 18));

        btnFirstKH.setBackground(new java.awt.Color(51, 204, 0));
        btnFirstKH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFirstKH.setForeground(new java.awt.Color(255, 255, 255));
        btnFirstKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/first.png"))); // NOI18N
        btnFirstKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFirstKHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFirstKHMouseExited(evt);
            }
        });
        btnFirstKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstKHActionPerformed(evt);
            }
        });
        jPanel4.add(btnFirstKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 60, 40));

        btnPrevKH.setBackground(new java.awt.Color(51, 204, 0));
        btnPrevKH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrevKH.setForeground(new java.awt.Color(255, 255, 255));
        btnPrevKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/prev.png"))); // NOI18N
        btnPrevKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrevKHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPrevKHMouseExited(evt);
            }
        });
        btnPrevKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevKHActionPerformed(evt);
            }
        });
        jPanel4.add(btnPrevKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 400, 60, 40));

        btnNextKH.setBackground(new java.awt.Color(51, 204, 0));
        btnNextKH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNextKH.setForeground(new java.awt.Color(255, 255, 255));
        btnNextKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/next.png"))); // NOI18N
        btnNextKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNextKHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNextKHMouseExited(evt);
            }
        });
        btnNextKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextKHActionPerformed(evt);
            }
        });
        jPanel4.add(btnNextKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, 60, 40));

        btnLastKH.setBackground(new java.awt.Color(51, 204, 0));
        btnLastKH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLastKH.setForeground(new java.awt.Color(255, 255, 255));
        btnLastKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/last.png"))); // NOI18N
        btnLastKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLastKHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLastKHMouseExited(evt);
            }
        });
        btnLastKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastKHActionPerformed(evt);
            }
        });
        jPanel4.add(btnLastKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, 60, 40));

        btnNewKH.setBackground(new java.awt.Color(51, 204, 0));
        btnNewKH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNewKH.setForeground(new java.awt.Color(255, 255, 255));
        btnNewKH.setText("Mới");
        btnNewKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNewKHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNewKHMouseExited(evt);
            }
        });
        btnNewKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewKHActionPerformed(evt);
            }
        });
        jPanel4.add(btnNewKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 400, 90, 40));

        btnUpdateKH.setBackground(new java.awt.Color(51, 204, 0));
        btnUpdateKH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdateKH.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateKH.setText("Sửa");
        btnUpdateKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateKHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateKHMouseExited(evt);
            }
        });
        btnUpdateKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateKHActionPerformed(evt);
            }
        });
        jPanel4.add(btnUpdateKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 400, 90, 40));

        btnDeleteKH.setBackground(new java.awt.Color(51, 204, 0));
        btnDeleteKH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteKH.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteKH.setText("Xóa");
        btnDeleteKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteKHMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteKHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteKHMouseExited(evt);
            }
        });
        btnDeleteKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteKHActionPerformed(evt);
            }
        });
        jPanel4.add(btnDeleteKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, 90, 40));

        btnInsertKH.setBackground(new java.awt.Color(51, 204, 0));
        btnInsertKH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnInsertKH.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertKH.setText("Thêm");
        btnInsertKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertKHMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInsertKHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInsertKHMouseExited(evt);
            }
        });
        btnInsertKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertKHActionPerformed(evt);
            }
        });
        jPanel4.add(btnInsertKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 400, 100, 40));

        lblLoiGioiTinh.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiGioiTinh.setForeground(new java.awt.Color(255, 0, 0));
        jPanel4.add(lblLoiGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 270, 18));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 255, 0)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 255));
        jLabel10.setText("Khách hàng/ Cập nhật/");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 255));
        jLabel11.setText("Cập nhật khách hàng________________________________________________________");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 79));

        pnlCardCapNhat.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 900, 450));

        pnlTab.add(pnlCardCapNhat, "CardCapNhat");

        pnlCardDanhSach.setkEndColor(new java.awt.Color(255, 255, 255));
        pnlCardDanhSach.setkGradientFocus(300);
        pnlCardDanhSach.setkStartColor(new java.awt.Color(51, 204, 0));
        pnlCardDanhSach.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 255, 0)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 255));
        jLabel12.setText("Khách hàng/ Danh sách/");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 255));
        jLabel13.setText("Danh sách khách hàng________________________________________________________");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 79));

        tblBangKhachHang.setModel(new javax.swing.table.DefaultTableModel(
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
                "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Địa chỉ", "Email", "Giới tính", "Người tạo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBangKhachHang.setRowHeight(25);
        tblBangKhachHang.setSelectionBackground(new java.awt.Color(255, 102, 153));
        tblBangKhachHang.setShowVerticalLines(false);
        tblBangKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangKhachHangMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblBangKhachHang);

        jPanel5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 860, 240));

        txtTimKiemKh.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtTimKiemKh.setForeground(new java.awt.Color(153, 153, 153));
        txtTimKiemKh.setText("VD: Kotex");
        txtTimKiemKh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTimKiemKh.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemKhFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimKiemKhFocusLost(evt);
            }
        });
        txtTimKiemKh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKhKeyReleased(evt);
            }
        });
        jPanel5.add(txtTimKiemKh, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 760, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 204, 0));
        jLabel16.setText("Tìm kiếm");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 80, -1));

        btnTaoDonKhachHang.setBackground(new java.awt.Color(255, 204, 0));
        btnTaoDonKhachHang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTaoDonKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoDonKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/khachHanIcon.png"))); // NOI18N
        btnTaoDonKhachHang.setText("Tạo đơn");
        btnTaoDonKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaoDonKhachHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTaoDonKhachHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTaoDonKhachHangMouseExited(evt);
            }
        });
        jPanel5.add(btnTaoDonKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(745, 393, 130, 30));

        pnlCardDanhSach.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 900, 430));

        pnlTab.add(pnlCardDanhSach, "CardDanhSach");

        kGradientPanel1.add(pnlTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 900, 480));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 900, 540));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 70, 50));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(51, 51, 255));
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logo.png"))); // NOI18N
        jLabel39.setText("Khách hàng");
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 50));

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(kGradientPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel30MouseClicked

    private void jLabel30MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseEntered
        jLabel30.setIcon(Back2);
    }//GEN-LAST:event_jLabel30MouseEntered

    private void jLabel30MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseExited
        jLabel30.setIcon(Back1);
    }//GEN-LAST:event_jLabel30MouseExited

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        MouseDragged(evt, this);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        moveFrom(evt);
    }//GEN-LAST:event_jPanel1MousePressed

    private void btnCapNhatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapNhatMouseEntered
//        ColorForeground(Color.BLUE, btnCapNhat);
    }//GEN-LAST:event_btnCapNhatMouseEntered

    private void btnCapNhatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapNhatMouseExited
//        ColorForeground(Color.black, btnNhanVienDh);
    }//GEN-LAST:event_btnCapNhatMouseExited

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        chooserDefault(new Color(204, 255, 255), lblSatusCapNhat, lblSatusDanhSach, lblSatusTrangChu);
        card.show(pnlTab, "CardCapNhat");
        chooserList(new Color(102, 255, 0), lblSatusCapNhat);
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void bntDanhSachMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntDanhSachMouseEntered
//        ColorForeground(Color.BLUE, bntNhanVienKho);
    }//GEN-LAST:event_bntDanhSachMouseEntered

    private void bntDanhSachMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntDanhSachMouseExited
//        ColorForeground(Color.black, bntNhanVienKho);
    }//GEN-LAST:event_bntDanhSachMouseExited

    private void bntDanhSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDanhSachActionPerformed
        chooserDefault(new Color(204, 255, 255), lblSatusCapNhat, lblSatusDanhSach, lblSatusTrangChu);
        card.show(pnlTab, "CardDanhSach");
        chooserList(new Color(102, 255, 0), lblSatusDanhSach);
    }//GEN-LAST:event_bntDanhSachActionPerformed

    private void txtMaKHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaKHFocusGained
        if (txtMaKH.getForeground().equals(Gray)) {
            Color(txtMaKH, "", Plain, Black);
        }
    }//GEN-LAST:event_txtMaKHFocusGained

    private void txtMaKHFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaKHFocusLost
        if (txtMaKH.getText().trim().isEmpty()) {
            Color(txtMaKH, "VD: KH1", Italic, Gray);
        } else {
            lblLoiMaKH.setText("");
        }
    }//GEN-LAST:event_txtMaKHFocusLost

    private void txtTenKHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenKHFocusGained
        if (txtTenKH.getForeground().equals(Gray)) {
            Color(txtTenKH, "", Plain, Black);
        }
    }//GEN-LAST:event_txtTenKHFocusGained

    private void txtTenKHFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenKHFocusLost
        if (txtTenKH.getText().trim().isEmpty()) {
            Color(txtTenKH, "VD: Nguyễn Văn An", Italic, Gray);
        } else {
            lblLoiTenKH.setText("");
        }
    }//GEN-LAST:event_txtTenKHFocusLost

    private void txtTenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKHActionPerformed

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        if (txtEmail.getForeground().equals(Gray)) {
            Color(txtEmail, "", Plain, Black);
        }
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        if (txtEmail.getText().trim().isEmpty()) {
            Color(txtEmail, "VD: Annv@gmail.com", Italic, Gray);
        } else {
            lblLoiEmail.setText("");
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtNhanVienFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNhanVienFocusGained
        if (txtNhanVien.getForeground().equals(Gray)) {
            Color(txtNhanVien, "", Plain, Black);
        }
    }//GEN-LAST:event_txtNhanVienFocusGained

    private void txtNhanVienFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNhanVienFocusLost
        if (txtNhanVien.getText().trim().isEmpty()) {
            Color(txtNhanVien, "VD: Nguyễn Văn Tèo", Italic, Gray);
        } else {
            lblLoiNhanVien.setText("");
        }
    }//GEN-LAST:event_txtNhanVienFocusLost

    private void txtSDTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSDTFocusGained
        if (txtSDT.getForeground().equals(Gray)) {
            Color(txtSDT, "", Plain, Black);
        }
    }//GEN-LAST:event_txtSDTFocusGained

    private void txtSDTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSDTFocusLost
        if (txtSDT.getText().trim().isEmpty()) {
            Color(txtSDT, "VD: 075*******(Phải nhập 10 - 11 số)", Italic, Gray);
        } else {
            lblLoiSDT.setText("");
        }
    }//GEN-LAST:event_txtSDTFocusLost

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void btnFirstKHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstKHMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnFirstKH);
    }//GEN-LAST:event_btnFirstKHMouseEntered

    private void btnFirstKHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstKHMouseExited
        setBackround(new Color(51, 204, 0), Color.WHITE, btnFirstKH);
    }//GEN-LAST:event_btnFirstKHMouseExited

    private void btnFirstKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstKHActionPerformed
        index = 0;
        edit();
    }//GEN-LAST:event_btnFirstKHActionPerformed

    private void btnPrevKHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevKHMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnPrevKH);
    }//GEN-LAST:event_btnPrevKHMouseEntered

    private void btnPrevKHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevKHMouseExited
        setBackround(new Color(51, 204, 0), Color.WHITE, btnPrevKH);
    }//GEN-LAST:event_btnPrevKHMouseExited

    private void btnPrevKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevKHActionPerformed
        index--;
        edit();
    }//GEN-LAST:event_btnPrevKHActionPerformed

    private void btnNextKHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextKHMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnNextKH);
    }//GEN-LAST:event_btnNextKHMouseEntered

    private void btnNextKHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextKHMouseExited
        setBackround(new Color(51, 204, 0), Color.WHITE, btnNextKH);
    }//GEN-LAST:event_btnNextKHMouseExited

    private void btnNextKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextKHActionPerformed
        index++;
        edit();
    }//GEN-LAST:event_btnNextKHActionPerformed

    private void btnLastKHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastKHMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnLastKH);
    }//GEN-LAST:event_btnLastKHMouseEntered

    private void btnLastKHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastKHMouseExited
        setBackround(new Color(51, 204, 0), Color.WHITE, btnLastKH);
    }//GEN-LAST:event_btnLastKHMouseExited

    private void btnLastKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastKHActionPerformed
        index = tblBangKhachHang.getRowCount() - 1;
        edit();
    }//GEN-LAST:event_btnLastKHActionPerformed

    private void btnNewKHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewKHMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnNewKH);
    }//GEN-LAST:event_btnNewKHMouseEntered

    private void btnNewKHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewKHMouseExited
        setBackround(new Color(51, 204, 0), Color.WHITE, btnNewKH);
    }//GEN-LAST:event_btnNewKHMouseExited

    private void btnNewKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewKHActionPerformed
        clear();
    }//GEN-LAST:event_btnNewKHActionPerformed

    private void btnUpdateKHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateKHMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnUpdateKH);
    }//GEN-LAST:event_btnUpdateKHMouseEntered

    private void btnUpdateKHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateKHMouseExited
        setBackround(new Color(51, 204, 0), Color.WHITE, btnUpdateKH);
    }//GEN-LAST:event_btnUpdateKHMouseExited

    private void btnUpdateKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateKHActionPerformed
        
        if (checkFormKH() == true) {
            if (validateFormKH() == true) {
                update();
            }
        }
    }//GEN-LAST:event_btnUpdateKHActionPerformed

    private void btnDeleteKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteKHMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteKHMouseClicked

    private void btnDeleteKHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteKHMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnDeleteKH);
    }//GEN-LAST:event_btnDeleteKHMouseEntered

    private void btnDeleteKHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteKHMouseExited
        setBackround(new Color(51, 204, 0), Color.WHITE, btnDeleteKH);
    }//GEN-LAST:event_btnDeleteKHMouseExited

    private void btnDeleteKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteKHActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteKHActionPerformed

    private void btnInsertKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertKHMouseClicked

    }//GEN-LAST:event_btnInsertKHMouseClicked

    private void btnInsertKHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertKHMouseEntered
//        setBackround(Color.WHITE, new Color(0, 0, 255), btnInsertSPCC);
        setBackround(Color.WHITE, new Color(0, 0, 255), btnInsertKH);
    }//GEN-LAST:event_btnInsertKHMouseEntered

    private void btnInsertKHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertKHMouseExited
//        setBackround(new Color(0, 0, 255), Color.WHITE, btnInsertSPCC);
        setBackround(new Color(51, 204, 0), Color.WHITE, btnInsertKH);
    }//GEN-LAST:event_btnInsertKHMouseExited

    private void btnInsertKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertKHActionPerformed
        //Tạo đơn khi mở từ from quản lý đơn hàng!
        if (trangThai == true) {
            KhachHang kh = getModel();
            Auth.clearKhachHang();
            Auth.khachHang = kh;

        }
        if (checkFormKH() == true) {
            if (validateFormKH() == true) {
                insert();
            }
        }
    }//GEN-LAST:event_btnInsertKHActionPerformed

    private void tblBangKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangKhachHangMouseClicked
        index = tblBangKhachHang.getSelectedRow();
        if (evt.getClickCount() == 2) {
            edit();
            chooserDefault(new Color(204, 255, 255), lblSatusCapNhat, lblSatusDanhSach, lblSatusTrangChu);
            card.show(pnlTab, "CardCapNhat");
            chooserList(new Color(102, 255, 0), lblSatusCapNhat);
        }
    }//GEN-LAST:event_tblBangKhachHangMouseClicked

    private void txtTimKiemKhFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemKhFocusGained
        if (txtTimKiemKh.getForeground().equals(Gray)) {
            Color(txtTimKiemKh, "", Plain, Black);
        }
    }//GEN-LAST:event_txtTimKiemKhFocusGained

    private void txtTimKiemKhFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemKhFocusLost
        if (txtTimKiemKh.getText().trim().isEmpty()) {
            Color(txtTimKiemKh, "VD: Nguyễn Văn Lên", Italic, Gray);
        }
    }//GEN-LAST:event_txtTimKiemKhFocusLost

    private void txtTimKiemKhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKhKeyReleased
        loadTimKiem();
    }//GEN-LAST:event_txtTimKiemKhKeyReleased

    private void btnTrangChuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTrangChuMouseEntered

    private void btnTrangChuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTrangChuMouseExited

    private void btnTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangChuActionPerformed
        chooserDefault(new Color(204, 255, 255), lblSatusCapNhat, lblSatusDanhSach, lblSatusTrangChu);
        card.show(pnlTab, "CardTrangChu");
        chooserList(new Color(102, 255, 0), lblSatusTrangChu);
    }//GEN-LAST:event_btnTrangChuActionPerformed

    private void txtDiaChiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiaChiFocusGained
        if (txtDiaChi.getForeground().equals(Gray)) {
            Color(txtDiaChi, "", Plain, Black);
        }
    }//GEN-LAST:event_txtDiaChiFocusGained

    private void txtDiaChiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiaChiFocusLost
        if (txtDiaChi.getText().trim().isEmpty()) {
            Color(txtDiaChi, "VD: 123 Tô Ký, Q12,TP.HCM", Italic, Gray);
        } else {
            lblLoiDiaChi.setText("");
        }
    }//GEN-LAST:event_txtDiaChiFocusLost

    private void btnTaoDonKhachHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaoDonKhachHangMouseEntered
        setBackround(new Color(255, 204, 0), Color.darkGray, btnTaoDonKhachHang);
    }//GEN-LAST:event_btnTaoDonKhachHangMouseEntered

    private void btnTaoDonKhachHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaoDonKhachHangMouseExited
        setBackround(new Color(255, 204, 0), Color.WHITE, btnTaoDonKhachHang);
    }//GEN-LAST:event_btnTaoDonKhachHangMouseExited

    private void btnTaoDonKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaoDonKhachHangMouseClicked
        int rs = tblBangKhachHang.getSelectedRow();
        if (rs < 0) {
            DialogHelper.alert(null, "Vui lòng chọn khách hàng cần tạo đơn");
            return;
        }
        AuthKhachHang(rs);
        dispose();
        if (trangThai == false) {
            new QuanLyDonHang_JFrame(0).setVisible(true);
        }
    }//GEN-LAST:event_btnTaoDonKhachHangMouseClicked

    private void cboGioiTinhItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboGioiTinhItemStateChanged
        if (cboGioiTinh.getSelectedIndex() != 0) {
            lblLoiGioiTinh.setText("");
        }
    }//GEN-LAST:event_cboGioiTinhItemStateChanged

    private void txtDiaChiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiaChiKeyReleased

    }//GEN-LAST:event_txtDiaChiKeyReleased

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
            java.util.logging.Logger.getLogger(KhachHang_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachHang_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachHang_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHang_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhachHang_JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntDanhSach;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnDeleteKH;
    private javax.swing.JButton btnFirstKH;
    private javax.swing.JButton btnInsertKH;
    private javax.swing.JButton btnLastKH;
    private javax.swing.JButton btnNewKH;
    private javax.swing.JButton btnNextKH;
    private javax.swing.JButton btnPrevKH;
    private javax.swing.JButton btnTaoDonKhachHang;
    private javax.swing.JButton btnTrangChu;
    private javax.swing.JButton btnUpdateKH;
    private javax.swing.JComboBox<String> cboGioiTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel3;
    private javax.swing.JLabel lblLoiDiaChi;
    private javax.swing.JLabel lblLoiEmail;
    private javax.swing.JLabel lblLoiGioiTinh;
    private javax.swing.JLabel lblLoiMaKH;
    private javax.swing.JLabel lblLoiNhanVien;
    private javax.swing.JLabel lblLoiSDT;
    private javax.swing.JLabel lblLoiTenKH;
    private javax.swing.JLabel lblMaSP;
    private javax.swing.JLabel lblMaSP1;
    private javax.swing.JLabel lblMaSP2;
    private javax.swing.JLabel lblMaSP3;
    private javax.swing.JLabel lblMaSP4;
    private javax.swing.JLabel lblMaSP5;
    private javax.swing.JLabel lblMaSP6;
    private javax.swing.JLabel lblSatusCapNhat;
    private javax.swing.JLabel lblSatusDanhSach;
    private javax.swing.JLabel lblSatusTrangChu;
    private keeptoo.KGradientPanel pnlCardCapNhat;
    private keeptoo.KGradientPanel pnlCardDanhSach;
    private javax.swing.JPanel pnlCardKhachHang;
    private javax.swing.JPanel pnlTab;
    private javax.swing.JTable tblBangKhachHang;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtNhanVien;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTimKiemKh;
    // End of variables declaration//GEN-END:variables

    private boolean checkFormKH() {
        int count = 0;
        //Không để trống MaKH
        if (ValidateNull(txtMaKH) == false) {
            lblLoiMaKH.setText("Không được để trống mã khách hàng!");
            count++;
        } else {
            lblLoiMaKH.setText("");
        }
        //Không để trống TênKH
        if (ValidateNull(txtTenKH) == false) {
            lblLoiTenKH.setText("Không được để trống tên khách hàng");
            count++;
        } else {
            lblLoiTenKH.setText("");
        }
        //Không để trống SDT
        if (ValidateNull(txtSDT) == false) {
            lblLoiSDT.setText("Không được để trống số điện thoại!");
            count++;
        } else {
            lblLoiSDT.setText("");
        }
        //Không để trống Email
        if (ValidateNull(txtEmail) == false) {
            lblLoiEmail.setText("Không được để trống Email!");
            count++;
        } else {
            lblLoiEmail.setText("");
        }
        //Không để trống NV
        if (ValidateNull(txtNhanVien) == false) {
            lblLoiNhanVien.setText("Không được để trống nhân viên!");
            count++;
        } else {
            lblLoiNhanVien.setText("");
        }
        //Không để trống giới tính
        int gt = cboGioiTinh.getSelectedIndex();
        if (gt == 0) {
            lblLoiGioiTinh.setText("Không để trống giới tính!");
            count++;
        } else {
            lblLoiGioiTinh.setText("");
        }
        //Không để trống địa chỉ
        if (ValidateNull(txtDiaChi) == false) {
            lblLoiDiaChi.setText("Không được để trống địa chỉ!");
            count++;
        } else {
            lblLoiDiaChi.setText("");
        }

        return count == 0;
    }

    private boolean validateFormKH() {
        int count = 0;

        if (ValidateMaSp(txtMaKH) == false) {
            lblLoiMaKH.setText("Mã khách hàng nhập chưa hợp lệ!");
            count++;
        } else {
            lblLoiMaKH.setText("");
        }
        
        if (ValidateName(txtTenKH) == false) {
            lblLoiTenKH.setText("Tên khách hàng nhập chưa hợp lệ!");
            count++;
        } else {
            lblLoiTenKH.setText("");
        }
        
        if (ValidateSDT(txtSDT) == false) {
            lblLoiSDT.setText("Số điện thoại nhập chưa hợp lệ!");
            count++;
        } else {
            lblLoiSDT.setText("");
        }

        if (ValidateEmail(txtEmail) == false) {
            lblLoiEmail.setText("Email nhập chưa hợp lệ!");
            count++;
        } else {
            lblLoiSDT.setText("");
        }
        
        

        if (count != 0) {
            return false;
        }
        return true;
    }

    private KhachHang getModel() {
        KhachHang kh = new KhachHang();
        kh.setMaKH(txtMaKH.getText().trim());
        kh.setTenKH(txtTenKH.getText().trim());
        kh.setSDT(txtSDT.getText().trim());
        kh.setDiaChi(txtDiaChi.getText().trim());
        kh.setEmail(txtEmail.getText().trim());
        if (cboGioiTinh.getSelectedIndex() == 1) {
            kh.setGioiTinh(0);
        } else if (cboGioiTinh.getSelectedIndex() == 2) {
            kh.setGioiTinh(1);
        } else {
            kh.setGioiTinh(2);
        }
        kh.setTenDangNhap(txtNhanVien.getText().trim());
        return kh;
    }

    private void AuthKhachHang(int re) {
        String maKh = (String) tblBangKhachHang.getValueAt(re, 0);
        String tenKh = (String) tblBangKhachHang.getValueAt(re, 1);
        String SoDt = (String) tblBangKhachHang.getValueAt(re, 2);
        String diaChi = (String) tblBangKhachHang.getValueAt(re, 3);
        String email = (String) tblBangKhachHang.getValueAt(re, 4);
        int gt;
        if (tblBangKhachHang.getValueAt(re, 5).equals("Nam")) {
            gt = 0;//Nam
        } else if (tblBangKhachHang.getValueAt(re, 5).equals("Nữ")) {
            gt = 1;//Nữ 
        } else {
            gt = 2;//Khác
        }
        String nguoiTao = (String) tblBangKhachHang.getValueAt(re, 6);
        KhachHang kh = new KhachHang();
        kh.setMaKH(maKh);
        kh.setTenKH(tenKh);
        kh.setSDT(SoDt);
        kh.setDiaChi(diaChi);
        kh.setEmail(email);
        kh.setGioiTinh(gt);
        kh.setTenDangNhap(nguoiTao);
        Auth.khachHang = kh;
    }

    private void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblBangKhachHang.getModel();
        model.setRowCount(0);
        List<KhachHang> list = dao.selectAll();
        for (KhachHang kh : list) {
            String gt = null;
            if (kh.getGioiTinh() == 0) {
                gt = "Nam";
            } else if (kh.getGioiTinh() == 1) {
                gt = "Nữ";
            } else {
                gt = "Khác";
            }
            Object[] ob = {kh.getMaKH(), kh.getTenKH(), kh.getSDT(), kh.getDiaChi(),
                kh.getEmail(), gt, kh.getTenDangNhap()};
            model.addRow(ob);
        }
    }

    void clear() {
        Color(txtMaKH, "VD: KH1", Italic, Gray);
        Color(txtTenKH, "VD: Nguyễn Văn An", Plain, Gray);
        Color(txtSDT, "VD: 075*******", Plain, Gray);
        Color(txtEmail, "VD: Annv@gmail.com", Italic, Gray);
        Color(txtDiaChi, "VD: 123 Tô Ký, Q12,TP.HCM", Italic, Gray);
        Color(txtEmail, "Email", Italic, Gray);
        Color(txtNhanVien, "VD: Nguyễn Văn Tèo", Italic, Gray);
        cboGioiTinh.setSelectedIndex(0);
        tblBangKhachHang.clearSelection();
        lblLoiDiaChi.setText("");
        lblLoiMaKH.setText("");
        lblLoiTenKH.setText("");
        lblLoiEmail.setText("");
        lblLoiGioiTinh.setText("");
        lblLoiNhanVien.setText("");
        lblLoiSDT.setText("");
        setStatus(true);
    }

    private void insert() {
        KhachHang tk = getModel();
        if (dao.insert(tk) == 3) {
            fillTable();
            clear();
            DialogHelper.alert(null, "Thêm mới thành công");
            dispose();
        } else if(dao.insert(tk) == 2) {
            lblLoiSDT.setText("Số điện thoại này đã tồn tại");
            DialogHelper.alert(null, "Thêm mới thất bại");
        }else if(dao.insert(tk) == 1){
            lblLoiEmail.setText("Email này đã tồn tại");
            DialogHelper.alert(null, "Thêm mới thất bại");
        }else{
            lblLoiMaKH.setText("Mã khách hàng đã tồn tại");
            DialogHelper.alert(null, "Thêm mới thất bại");
        }
    }

    private void update() {
        KhachHang kh = getModel();
        if (dao.update(kh) == 3) {
            fillTable();
            DialogHelper.alert(null, "Cập nhật thành công");
        } else if(dao.update(kh) == 2) {
            lblLoiSDT.setText("Số điện thoại này đã tồn tại");
            DialogHelper.alert(null, "Cập nhật thất bại");
        }else if(dao.update(kh) == 1){
            lblLoiEmail.setText("Email này đã tồn tại");
            DialogHelper.alert(null, "Cập nhật thất bại");
        }else{
            lblLoiMaKH.setText("Tên đăng nhập đã tồn tại");
            DialogHelper.alert(null, "Cập nhật thất bại");
        }
    }
    void setStatus(boolean status) {
        txtMaKH.setEditable(status);
        btnInsertKH.setEnabled(status);
        btnUpdateKH.setEnabled(!status);
        btnDeleteKH.setEnabled(!status);

        boolean first = index > 0;
        boolean last = index < tblBangKhachHang.getRowCount() - 1;

        btnFirstKH.setEnabled(!status && first);
        btnPrevKH.setEnabled(!status && first);
        btnNextKH.setEnabled(!status && last);
        btnLastKH.setEnabled(!status && last);
    }

    private void delete() {
        if(tblBangKhachHang.getSelectedRow() == -1){
            DialogHelper.alert(null, "Vui lòng chọn khách hàng cần xóa");
            return;
        }
        
        if (DialogHelper.confirm(null, "Bạn có muốn xóa khách hàng này không ?")) {
            if (dao.delete(txtMaKH.getText().trim()) == 1) {
                fillTable();
                clear();
                DialogHelper.alert(null, "Xóa thành công");
            } else {
                lblLoiMaKH.setText("Mã khách hàng không tồn tại");
                DialogHelper.alert(null, "Xóa thất bại");
            }
        }
    }

    

    void edit() {
        Color(txtMaKH, "", Plain, Black);
        Color(txtTenKH, "", Plain, Black);
        Color(txtSDT, "", Plain, Black);
        Color(txtEmail, "", Plain, Black);
        Color(txtEmail, "", Plain, Black);
        Color(txtNhanVien, "", Plain, Black);
        //Xét các label lỗi về null
        lblLoiDiaChi.setText("");
        lblLoiMaKH.setText("");
        lblLoiTenKH.setText("");
        lblLoiEmail.setText("");
        lblLoiGioiTinh.setText("");
        lblLoiNhanVien.setText("");
        lblLoiSDT.setText("");
        tblBangKhachHang.setRowSelectionInterval(index, index);
        String maKh = String.valueOf(tblBangKhachHang.getValueAt(index, 0));
        KhachHang kh = dao.selectById(maKh);
        setModel(kh);
        setStatus(false);
    }

    void setModel(KhachHang kh) {
        txtMaKH.setText(kh.getMaKH());
        txtTenKH.setText(kh.getTenKH());
        txtSDT.setText(kh.getSDT());
        txtEmail.setText(kh.getEmail());
        txtNhanVien.setText(kh.getTenDangNhap());
        if (kh.getGioiTinh() == 0) {
            cboGioiTinh.setSelectedIndex(1);
        } else if (kh.getGioiTinh() == 1) {
            cboGioiTinh.setSelectedIndex(2);
        } else {
            cboGioiTinh.setSelectedIndex(3);
        }
        txtDiaChi.setText(kh.getDiaChi());
    }
       void loadTimKiem() {
        DefaultTableModel model = (DefaultTableModel) tblBangKhachHang.getModel();
        model.setRowCount(0);
        List<KhachHang> list = dao.selectByConditions("%" + txtTimKiemKh.getText().trim() + "%");
        for (KhachHang kh : list) { 
            String gioiTinh = null;
            if (kh.getGioiTinh() == 0) {
                gioiTinh = "Nam";
            } else if (kh.getGioiTinh() == 1) {
                gioiTinh = "Nữ";
            } else {
                gioiTinh = "Khác";
            }

            Object[] ob = {kh.getMaKH(), kh.getTenKH(), kh.getSDT(), kh.getDiaChi(),kh.getEmail(),gioiTinh,kh.getTenDangNhap()};
            model.addRow(ob);
        }
    }
}
