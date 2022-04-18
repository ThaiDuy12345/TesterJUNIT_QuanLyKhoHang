/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import Dao.TaiKhoanDAO;
import static Help.ColorHelper.*;
import Help.DialogHelper;
import java.awt.Color;
import java.util.Arrays;
import static Help.ValidateHelper.*;
import Help.ImageHelper;
import Model.TaiKhoan;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import static Help.ImageHelper.*;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class QuanLyNhanVien_JFrame extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyNhanVien_JFrame
     */
    public QuanLyNhanVien_JFrame() {
        initComponents();
        init();
        load();
        setStatus(true);
    }

    void init() {
        this.getContentPane().setBackground(new Color(255, 255, 255));
        designTable(false, new Color(0, 102, 255), Color.white, Plain, tblTaiKhoan);
        designComboBox(new Color(0, 102, 204), Color.white, Plain, cboGioiTinh);
        designComboBox(new Color(0, 102, 204), Color.white, Plain, cboVaiTro);
    }

    JFileChooser fileChooser = new JFileChooser();
    TaiKhoanDAO dao = new TaiKhoanDAO();
    int index = 0;
    String url, name, nguoiNhan;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHinh = new javax.swing.JLabel();
        pnlDanhSach = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTaiKhoan = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        pnlCapNhat = new javax.swing.JPanel();
        txtSoDienThoai = new javax.swing.JTextField();
        txtTenDangNhap = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtLuong = new javax.swing.JTextField();
        txtXacNhanMatKhau = new javax.swing.JPasswordField();
        txtMatKhau = new javax.swing.JPasswordField();
        cboGioiTinh = new javax.swing.JComboBox<>();
        cboVaiTro = new javax.swing.JComboBox<>();
        lblTenDangNhap = new javax.swing.JLabel();
        lblXacNhanMK = new javax.swing.JLabel();
        lblMatKhau = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        lblVaiTro = new javax.swing.JLabel();
        lblHoVaTen = new javax.swing.JLabel();
        lblLuong = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblLoiMatKhau = new javax.swing.JLabel();
        lblLoiTenDangNhap = new javax.swing.JLabel();
        lblLoiHoTen = new javax.swing.JLabel();
        lblLoiXacNhan = new javax.swing.JLabel();
        lblLoiDienThoai = new javax.swing.JLabel();
        lblLoiGioiTinh = new javax.swing.JLabel();
        lblLoiVaiTro = new javax.swing.JLabel();
        lblLoiEmail = new javax.swing.JLabel();
        lblLoiLuong = new javax.swing.JLabel();
        pnlQuanLyNhanVien = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnLast = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        lblLoiHinh = new javax.swing.JLabel();
        btnNew1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý nhân viên");
        setFont(new java.awt.Font(".Vn3DH", 0, 14)); // NOI18N
        setForeground(new java.awt.Color(51, 0, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHinh.setBackground(new java.awt.Color(0, 153, 102));
        lblHinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHinh.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblHinh.setOpaque(true);
        lblHinh.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lblHinhFocusLost(evt);
            }
        });
        lblHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHinhMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHinhMouseExited(evt);
            }
        });
        lblHinh.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                lblHinhInputMethodTextChanged(evt);
            }
        });
        getContentPane().add(lblHinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 200, 200));

        pnlDanhSach.setBackground(new java.awt.Color(255, 255, 255));
        pnlDanhSach.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 24))); // NOI18N
        pnlDanhSach.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tên đăng nhập", "Mật khẩu", "Họ và tên", "Email", "Giới tính", "Vai trò", "Số điện thoại", "Lương", "Hinh"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTaiKhoan.setRowHeight(25);
        tblTaiKhoan.setSelectionBackground(new java.awt.Color(255, 153, 153));
        tblTaiKhoan.setShowGrid(true);
        tblTaiKhoan.setShowVerticalLines(false);
        tblTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTaiKhoanMouseClicked(evt);
            }
        });
        tblTaiKhoan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblTaiKhoanKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblTaiKhoan);
        if (tblTaiKhoan.getColumnModel().getColumnCount() > 0) {
            tblTaiKhoan.getColumnModel().getColumn(0).setPreferredWidth(110);
            tblTaiKhoan.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        pnlDanhSach.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 89, 758, 514));

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtTimKiem.setForeground(new java.awt.Color(153, 153, 153));
        txtTimKiem.setText("VD: NoPT");
        txtTimKiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusLost(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });
        pnlDanhSach.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 42, 682, 29));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 204, 51));
        jLabel20.setText("Tìm kiếm");
        pnlDanhSach.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 47, -1, -1));

        getContentPane().add(pnlDanhSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(704, 74, 780, 620));

        pnlCapNhat.setBackground(new java.awt.Color(255, 255, 255));
        pnlCapNhat.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cập nhật", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        txtSoDienThoai.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtSoDienThoai.setForeground(new java.awt.Color(153, 153, 153));
        txtSoDienThoai.setText("VD: 0374035658(10 hoặc 11 số)");
        txtSoDienThoai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSoDienThoai.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSoDienThoaiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSoDienThoaiFocusLost(evt);
            }
        });

        txtTenDangNhap.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtTenDangNhap.setForeground(new java.awt.Color(153, 153, 153));
        txtTenDangNhap.setText("VD: lenNv15");
        txtTenDangNhap.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTenDangNhap.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTenDangNhapFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTenDangNhapFocusLost(evt);
            }
        });

        txtEmail.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(153, 153, 153));
        txtEmail.setText("Email");
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });

        txtHoTen.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtHoTen.setForeground(new java.awt.Color(153, 153, 153));
        txtHoTen.setText("VD: Lê Văn Tèo");
        txtHoTen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtHoTen.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHoTenFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHoTenFocusLost(evt);
            }
        });

        txtLuong.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtLuong.setForeground(new java.awt.Color(153, 153, 153));
        txtLuong.setText("VD: 2000000");
        txtLuong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtLuong.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLuongFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLuongFocusLost(evt);
            }
        });

        txtXacNhanMatKhau.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtXacNhanMatKhau.setForeground(new java.awt.Color(153, 153, 153));
        txtXacNhanMatKhau.setText("jPasswordFi4567");
        txtXacNhanMatKhau.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtXacNhanMatKhau.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtXacNhanMatKhauFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtXacNhanMatKhauFocusLost(evt);
            }
        });
        txtXacNhanMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXacNhanMatKhauActionPerformed(evt);
            }
        });

        txtMatKhau.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMatKhau.setForeground(new java.awt.Color(153, 153, 153));
        txtMatKhau.setText("jPasswordField1");
        txtMatKhau.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtMatKhau.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMatKhauFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMatKhauFocusLost(evt);
            }
        });

        cboGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn", "Nam", "Nữ", "Khác" }));
        cboGioiTinh.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboGioiTinhItemStateChanged(evt);
            }
        });
        cboGioiTinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboGioiTinhMouseClicked(evt);
            }
        });

        cboVaiTro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn", "Nhân viên kho", "Nhân viên đơn hàng", "Quản lý" }));
        cboVaiTro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboVaiTroItemStateChanged(evt);
            }
        });
        cboVaiTro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboVaiTroMouseClicked(evt);
            }
        });

        lblTenDangNhap.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTenDangNhap.setForeground(new java.awt.Color(255, 204, 51));
        lblTenDangNhap.setText("Tên đăng nhập");

        lblXacNhanMK.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblXacNhanMK.setForeground(new java.awt.Color(255, 204, 51));
        lblXacNhanMK.setText("Xác nhận mật khẩu");

        lblMatKhau.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMatKhau.setForeground(new java.awt.Color(255, 204, 51));
        lblMatKhau.setText("Mật khẩu");

        lblGioiTinh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblGioiTinh.setForeground(new java.awt.Color(255, 204, 51));
        lblGioiTinh.setText("Giới tính");

        lblSDT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSDT.setForeground(new java.awt.Color(255, 204, 51));
        lblSDT.setText("Số điện thoại");

        lblVaiTro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblVaiTro.setForeground(new java.awt.Color(255, 204, 51));
        lblVaiTro.setText("Vai trò");

        lblHoVaTen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblHoVaTen.setForeground(new java.awt.Color(255, 204, 51));
        lblHoVaTen.setText("Họ và tên");

        lblLuong.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLuong.setForeground(new java.awt.Color(255, 204, 51));
        lblLuong.setText("Lương");

        lblEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 204, 51));
        lblEmail.setText("Email");

        lblLoiMatKhau.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiMatKhau.setForeground(new java.awt.Color(255, 0, 0));

        lblLoiTenDangNhap.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiTenDangNhap.setForeground(new java.awt.Color(255, 0, 0));

        lblLoiHoTen.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiHoTen.setForeground(new java.awt.Color(255, 0, 0));

        lblLoiXacNhan.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiXacNhan.setForeground(new java.awt.Color(255, 0, 0));

        lblLoiDienThoai.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiDienThoai.setForeground(new java.awt.Color(255, 0, 0));

        lblLoiGioiTinh.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiGioiTinh.setForeground(new java.awt.Color(255, 0, 0));

        lblLoiVaiTro.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiVaiTro.setForeground(new java.awt.Color(255, 0, 0));

        lblLoiEmail.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiEmail.setForeground(new java.awt.Color(255, 0, 0));

        lblLoiLuong.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiLuong.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout pnlCapNhatLayout = new javax.swing.GroupLayout(pnlCapNhat);
        pnlCapNhat.setLayout(pnlCapNhatLayout);
        pnlCapNhatLayout.setHorizontalGroup(
            pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCapNhatLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblLoiTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCapNhatLayout.createSequentialGroup()
                        .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                                .addComponent(lblEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblLoiEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                                    .addComponent(lblLoiLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                                    .addComponent(txtEmail)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCapNhatLayout.createSequentialGroup()
                                .addComponent(lblLuong)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCapNhatLayout.createSequentialGroup()
                                .addComponent(lblHoVaTen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblLoiHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                                    .addComponent(txtHoTen)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCapNhatLayout.createSequentialGroup()
                                .addComponent(lblVaiTro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblLoiVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(cboVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblLoiGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCapNhatLayout.createSequentialGroup()
                                .addComponent(lblGioiTinh)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCapNhatLayout.createSequentialGroup()
                                .addComponent(lblSDT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblLoiDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                                    .addComponent(txtSoDienThoai)))
                            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                                .addComponent(lblTenDangNhap)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCapNhatLayout.createSequentialGroup()
                                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMatKhau)
                                    .addComponent(lblXacNhanMK))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblLoiXacNhan, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                                    .addComponent(txtMatKhau)
                                    .addComponent(lblLoiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                                    .addComponent(txtXacNhanMatKhau))))
                        .addGap(13, 13, 13)))
                .addContainerGap())
        );
        pnlCapNhatLayout.setVerticalGroup(
            pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenDangNhap)
                    .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLoiTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMatKhau))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtXacNhanMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblXacNhanMK))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLoiXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSDT))
                .addGap(10, 10, 10)
                .addComponent(lblLoiDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGioiTinh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLoiGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVaiTro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLoiVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHoVaTen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLoiHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLuong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLoiEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        getContentPane().add(pnlCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 74, 490, 620));

        pnlQuanLyNhanVien.setBackground(new java.awt.Color(0, 102, 204));
        pnlQuanLyNhanVien.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        pnlQuanLyNhanVien.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlQuanLyNhanVienMouseDragged(evt);
            }
        });
        pnlQuanLyNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlQuanLyNhanVienMousePressed(evt);
            }
        });
        pnlQuanLyNhanVien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logo.png"))); // NOI18N
        jLabel2.setText("Quản lý nhân viên");
        pnlQuanLyNhanVien.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

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
        pnlQuanLyNhanVien.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 0, 100, 70));

        getContentPane().add(pnlQuanLyNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1490, 70));

        btnLast.setBackground(new java.awt.Color(0, 0, 255));
        btnLast.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLast.setForeground(new java.awt.Color(255, 255, 255));
        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/last.png"))); // NOI18N
        btnLast.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLastMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLastMouseExited(evt);
            }
        });
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });
        getContentPane().add(btnLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 520, 80, 40));

        btnDelete.setBackground(new java.awt.Color(0, 0, 255));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Xóa");
        btnDelete.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteMouseExited(evt);
            }
        });
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, 80, 40));

        btnUpdate.setBackground(new java.awt.Color(0, 0, 255));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Sửa");
        btnUpdate.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateMouseExited(evt);
            }
        });
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 460, 80, 40));

        btnInsert.setBackground(new java.awt.Color(0, 0, 255));
        btnInsert.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnInsert.setForeground(new java.awt.Color(255, 255, 255));
        btnInsert.setText("Thêm");
        btnInsert.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnInsert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInsertMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInsertMouseExited(evt);
            }
        });
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 350, 80, 40));

        btnFirst.setBackground(new java.awt.Color(0, 0, 255));
        btnFirst.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFirst.setForeground(new java.awt.Color(255, 255, 255));
        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/first.png"))); // NOI18N
        btnFirst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFirstMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFirstMouseExited(evt);
            }
        });
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });
        getContentPane().add(btnFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, 80, 40));

        btnPrev.setBackground(new java.awt.Color(0, 0, 255));
        btnPrev.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrev.setForeground(new java.awt.Color(255, 255, 255));
        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/prev.png"))); // NOI18N
        btnPrev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrevMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPrevMouseExited(evt);
            }
        });
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });
        getContentPane().add(btnPrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 400, 80, 40));

        btnNext.setBackground(new java.awt.Color(0, 0, 255));
        btnNext.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/next.png"))); // NOI18N
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNextMouseExited(evt);
            }
        });
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        getContentPane().add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 460, 80, 40));

        lblLoiHinh.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiHinh.setForeground(new java.awt.Color(255, 0, 0));
        lblLoiHinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblLoiHinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, 180, 20));

        btnNew1.setBackground(new java.awt.Color(0, 0, 255));
        btnNew1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNew1.setForeground(new java.awt.Color(255, 255, 255));
        btnNew1.setText("Mới");
        btnNew1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnNew1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNew1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNew1MouseExited(evt);
            }
        });
        btnNew1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNew1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnNew1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 520, 80, 40));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 690, 170, 10));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtXacNhanMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXacNhanMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtXacNhanMatKhauActionPerformed

    private void txtTenDangNhapFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenDangNhapFocusGained
        if (txtTenDangNhap.getForeground().equals(Gray)) {
            Color(txtTenDangNhap, "", Plain, Black);
        }
    }//GEN-LAST:event_txtTenDangNhapFocusGained

    private void txtTenDangNhapFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenDangNhapFocusLost
        if (txtTenDangNhap.getText().trim().isEmpty()) {
            Color(txtTenDangNhap, "VD: lenNv15 ", Italic, Gray);
        } else {
            lblLoiTenDangNhap.setText("");
        }
    }//GEN-LAST:event_txtTenDangNhapFocusLost

    private void txtMatKhauFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMatKhauFocusGained
        if (txtMatKhau.getForeground().equals(Gray)) {
            Color(txtMatKhau, "", Plain, Black);
        }
    }//GEN-LAST:event_txtMatKhauFocusGained

    private void txtMatKhauFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMatKhauFocusLost
        if (txtMatKhau.getText().trim().isEmpty()) {
            Color(txtMatKhau, "jPasswordField1", Plain, Gray);
        } else {
            lblLoiMatKhau.setText("");
        }
    }//GEN-LAST:event_txtMatKhauFocusLost

    private void txtXacNhanMatKhauFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtXacNhanMatKhauFocusGained
        if (txtXacNhanMatKhau.getForeground().equals(new Color(153, 153, 153))) {
            Color(txtXacNhanMatKhau, "", Plain, Black);
        }
    }//GEN-LAST:event_txtXacNhanMatKhauFocusGained

    private void txtXacNhanMatKhauFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtXacNhanMatKhauFocusLost
        if (txtXacNhanMatKhau.getText().trim().isEmpty()) {
            Color(txtXacNhanMatKhau, "jPasswordFi4567", Plain, Gray);
        } else {
            lblLoiXacNhan.setText("");
        }
    }//GEN-LAST:event_txtXacNhanMatKhauFocusLost

    private void txtSoDienThoaiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoDienThoaiFocusGained
        if (txtSoDienThoai.getForeground().equals(new Color(153, 153, 153))) {
            Color(txtSoDienThoai, "", Plain, Black);
        }
    }//GEN-LAST:event_txtSoDienThoaiFocusGained

    private void txtSoDienThoaiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoDienThoaiFocusLost
        if (txtSoDienThoai.getText().trim().isEmpty()) {
            Color(txtSoDienThoai, "VD: 0374035658(10 hoặc 11 số)", Italic, Gray);
        } else {
            lblLoiDienThoai.setText("");
        }
    }//GEN-LAST:event_txtSoDienThoaiFocusLost

    private void txtHoTenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoTenFocusGained
        if (txtHoTen.getForeground().equals(new Color(153, 153, 153))) {
            Color(txtHoTen, "", Plain, Black);
        }
    }//GEN-LAST:event_txtHoTenFocusGained

    private void txtHoTenFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoTenFocusLost
        if (txtHoTen.getText().trim().isEmpty()) {
            Color(txtHoTen, "VD: Lê Văn Tèo", Italic, Gray);
        } else {
            lblLoiHoTen.setText("");
        }
    }//GEN-LAST:event_txtHoTenFocusLost

    private void txtLuongFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLuongFocusGained
        if (txtLuong.getForeground().equals(new Color(153, 153, 153))) {
            Color(txtLuong, "", Plain, Black);
        }
    }//GEN-LAST:event_txtLuongFocusGained

    private void txtLuongFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLuongFocusLost
        if (txtLuong.getText().trim().isEmpty()) {
            Color(txtLuong, "VD: 2000000", Italic, Gray);
        } else {
            lblLoiLuong.setText("");
        }
    }//GEN-LAST:event_txtLuongFocusLost

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        if (txtEmail.getForeground().equals(new Color(153, 153, 153))) {
            Color(txtEmail, "", Plain, Black);
        }
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        if (txtEmail.getText().trim().isEmpty()) {
            Color(txtEmail, "VD: blabla@gmail.com", Italic, Gray);
        } else {
            lblLoiEmail.setText("");
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusGained
        if (txtTimKiem.getForeground().equals(new Color(153, 153, 153))) {
            Color(txtTimKiem, "", Plain, Black);
        }
    }//GEN-LAST:event_txtTimKiemFocusGained

    private void txtTimKiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusLost
        if (txtTimKiem.getText().trim().isEmpty()) {
            Color(txtTimKiem, "VD: NoPT", Italic, Gray);
        }
    }//GEN-LAST:event_txtTimKiemFocusLost

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        if (checkFrom() == true) {
            if (validateFrom() == true) {
                insert();
            }
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void cboGioiTinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboGioiTinhMouseClicked

    }//GEN-LAST:event_cboGioiTinhMouseClicked

    private void cboVaiTroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboVaiTroMouseClicked

    }//GEN-LAST:event_cboVaiTroMouseClicked

    private void cboGioiTinhItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboGioiTinhItemStateChanged
        if (cboGioiTinh.getSelectedIndex() != 0) {
            lblLoiGioiTinh.setText("");
        }
    }//GEN-LAST:event_cboGioiTinhItemStateChanged

    private void cboVaiTroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboVaiTroItemStateChanged
        if (cboVaiTro.getSelectedIndex() != 0) {
            lblLoiVaiTro.setText("");
        }
    }//GEN-LAST:event_cboVaiTroItemStateChanged

    private void lblHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseClicked
        chonAnh();
    }//GEN-LAST:event_lblHinhMouseClicked

    private void lblHinhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseEntered
        lblHinh.setBackground(Color.darkGray);
    }//GEN-LAST:event_lblHinhMouseEntered

    private void lblHinhMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseExited
        lblHinh.setBackground(new Color(0, 153, 102));
    }//GEN-LAST:event_lblHinhMouseExited

    private void lblHinhFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblHinhFocusLost

    }//GEN-LAST:event_lblHinhFocusLost

    private void lblHinhInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_lblHinhInputMethodTextChanged

    }//GEN-LAST:event_lblHinhInputMethodTextChanged

    private void pnlQuanLyNhanVienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlQuanLyNhanVienMousePressed
        moveFrom(evt);
    }//GEN-LAST:event_pnlQuanLyNhanVienMousePressed

    private void pnlQuanLyNhanVienMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlQuanLyNhanVienMouseDragged
        MouseDragged(evt, this);
    }//GEN-LAST:event_pnlQuanLyNhanVienMouseDragged

    private void btnInsertMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnInsert);
    }//GEN-LAST:event_btnInsertMouseEntered

    private void btnInsertMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertMouseExited
        setBackround(new Color(0, 0, 255), Color.WHITE, btnInsert);
    }//GEN-LAST:event_btnInsertMouseExited

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnDelete);
    }//GEN-LAST:event_btnDeleteMouseEntered

    private void btnDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseExited
        setBackround(new Color(0, 0, 255), Color.WHITE, btnDelete);
    }//GEN-LAST:event_btnDeleteMouseExited

    private void btnUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnUpdate);
    }//GEN-LAST:event_btnUpdateMouseEntered

    private void btnUpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseExited
        setBackround(new Color(0, 0, 255), Color.WHITE, btnUpdate);
    }//GEN-LAST:event_btnUpdateMouseExited

    private void btnFirstMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnFirst);
    }//GEN-LAST:event_btnFirstMouseEntered

    private void btnFirstMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFirstMouseExited
        setBackround(new Color(0, 0, 255), Color.WHITE, btnFirst);
    }//GEN-LAST:event_btnFirstMouseExited

    private void btnPrevMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnPrev);
    }//GEN-LAST:event_btnPrevMouseEntered

    private void btnPrevMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevMouseExited
        setBackround(new Color(0, 0, 255), Color.WHITE, btnPrev);
    }//GEN-LAST:event_btnPrevMouseExited

    private void btnNextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnNext);
    }//GEN-LAST:event_btnNextMouseEntered

    private void btnNextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseExited
        setBackround(new Color(0, 0, 255), Color.WHITE, btnNext);
    }//GEN-LAST:event_btnNextMouseExited

    private void btnLastMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastMouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnLast);
    }//GEN-LAST:event_btnLastMouseEntered

    private void btnLastMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLastMouseExited
        setBackround(new Color(0, 0, 255), Color.WHITE, btnLast);
    }//GEN-LAST:event_btnLastMouseExited

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (checkFrom() == true) {
            if (validateFrom() == true) {
                update();
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        index = 0;
        edit();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        index--;
        edit();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        index++;
        edit();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        index = tblTaiKhoan.getRowCount() - 1;
        edit();
    }//GEN-LAST:event_btnLastActionPerformed

    private void tblTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTaiKhoanMouseClicked
        // TODO add your handling code here:
        index = tblTaiKhoan.getSelectedRow();
        edit();
        File f = new File("logos/" + lblHinh.getToolTipText());
        if (f.exists() == false) {
            lblHinh.setIcon(Erro);
        }
    }//GEN-LAST:event_tblTaiKhoanMouseClicked

    private void tblTaiKhoanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblTaiKhoanKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_tblTaiKhoanKeyReleased

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        loadTimKiem();
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        dispose();
        FromChaQuanLy_JFrame ql = new FromChaQuanLy_JFrame();
        ql.setVisible(true);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        jLabel10.setIcon(Back2);
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        jLabel10.setIcon(Back1);
    }//GEN-LAST:event_jLabel10MouseExited

    private void btnNew1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNew1MouseEntered
        setBackround(Color.WHITE, new Color(0, 0, 255), btnNew1);
    }//GEN-LAST:event_btnNew1MouseEntered

    private void btnNew1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNew1MouseExited
        setBackround(new Color(0, 0, 255), Color.WHITE, btnNew1);
    }//GEN-LAST:event_btnNew1MouseExited

    private void btnNew1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNew1ActionPerformed

        clear();
    }//GEN-LAST:event_btnNew1ActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyNhanVien_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyNhanVien_JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNew1;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboGioiTinh;
    private javax.swing.JComboBox<String> cboVaiTro;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JLabel lblHoVaTen;
    private javax.swing.JLabel lblLoiDienThoai;
    private javax.swing.JLabel lblLoiEmail;
    private javax.swing.JLabel lblLoiGioiTinh;
    private javax.swing.JLabel lblLoiHinh;
    private javax.swing.JLabel lblLoiHoTen;
    private javax.swing.JLabel lblLoiLuong;
    private javax.swing.JLabel lblLoiMatKhau;
    private javax.swing.JLabel lblLoiTenDangNhap;
    private javax.swing.JLabel lblLoiVaiTro;
    private javax.swing.JLabel lblLoiXacNhan;
    private javax.swing.JLabel lblLuong;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblTenDangNhap;
    private javax.swing.JLabel lblVaiTro;
    private javax.swing.JLabel lblXacNhanMK;
    private javax.swing.JPanel pnlCapNhat;
    private javax.swing.JPanel pnlDanhSach;
    private javax.swing.JPanel pnlQuanLyNhanVien;
    private javax.swing.JTable tblTaiKhoan;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenDangNhap;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JPasswordField txtXacNhanMatKhau;
    // End of variables declaration//GEN-END:variables
private boolean checkFrom() {
        int count = 0;
        //Bỏ trống tên đăng nhập
        if (ValidateNull(txtTenDangNhap) == false) {
            lblLoiTenDangNhap.setText("Không bỏ trống tên đăng nhập!");
            count++;
            txtTenDangNhap.requestFocus();
        } else {
            lblLoiTenDangNhap.setText("");
        }
        //Bỏ trống mật khẩu
        if (ValidateNull(txtMatKhau) == false) {
            lblLoiMatKhau.setText("Không bỏ trống mật khẩu!");
            count++;
        } else {
            lblLoiMatKhau.setText("");
        }
        //Bỏ trống xác nhận mật khẩu
        if (ValidateNull(txtXacNhanMatKhau) == false) {
            lblLoiXacNhan.setText("Không bỏ trống mật khẩu xác nhận!");
            count++;
        } else {
            lblLoiXacNhan.setText("");
        }
        //Bỏ trống số điện thoại
        if (ValidateNull(txtSoDienThoai) == false) {
            lblLoiDienThoai.setText("Không bỏ trống số điện thoại!");
            count++;
        } else {
            lblLoiDienThoai.setText("");
        }
        //Không chọn vào giới tính
        int gt = cboGioiTinh.getSelectedIndex();
        int vt = cboVaiTro.getSelectedIndex();
        if (gt == 0) {
            lblLoiGioiTinh.setText("Vui lòng chọn vào giới tính của bạn!");
            count++;
        } else {
            lblLoiGioiTinh.setText("");
        }
        //Không chọn vào vai trò
        if (vt == 0) {
            lblLoiVaiTro.setText("Vui lòng chọn vào vai trò!");
            count++;
        } else {
            lblLoiVaiTro.setText("");
        }
        //Bỏ trống họ và tên
        if (ValidateNull(txtHoTen) == false) {
            lblLoiHoTen.setText("Không bỏ trống họ và tên!");
            count++;
        } else {
            lblLoiHoTen.setText("");
        }
        //Bỏ trống lương
        if (ValidateNull(txtLuong) == false) {
            lblLoiLuong.setText("Không bỏ trống lương khi nhập vào!");
            count++;
        } else {
            lblLoiLuong.setText("");
        }
        //Bỏ trống Email
        if (ValidateNull(txtEmail) == false) {
            count++;
            lblLoiEmail.setText("Vui lòng không bỏ trống Email!");
        } else {
            lblLoiEmail.setText("");
        }
        //Bỏ trống hình 
        if (checkNullHinh(lblHinh) == false) {
            count++;
            lblLoiHinh.setText("Không bỏ trống hình bạn ưi!");
        } else {
            lblLoiHinh.setText("");
        }
        return count == 0;
    }

    private boolean validateFrom() {
        int count = 0;
        //Kiểm tra tính hợp lệ mật khẩu
        if (ValidatePass(txtMatKhau) == false) {
            lblLoiMatKhau.setText("Mật khẩu phải từ 3-16 ký tự !");
            count++;
            txtMatKhau.requestFocus();
        } else {
            lblLoiMatKhau.setText("");
        }
        //Kiểm tra tính hợp lệ số điện thoại
        if (ValidateSDT(txtSoDienThoai) == false) {
            lblLoiDienThoai.setText("Nhập vào số điện thoại hợp lệ!");
            count++;
        } else {
            lblLoiDienThoai.setText("");
        }
        //Kiểm tra tính hợp lệ họ và tên
        if (ValidateName(txtHoTen) == false) {
            lblLoiHoTen.setText("Vui lòng nhập vào họ tên hợp lệ!");
            count++;
        } else {
            lblLoiHoTen.setText("");
        }
        //Kiểm tra tính hợp lệ của lương nhập vào
        if (ValidateLuong(txtLuong) == false) {
            lblLoiLuong.setText("Vui lòng nhập vào lương phù hợp!");
            count++;
        } else {
            lblLoiLuong.setText("");
        }
        //Kiểm tra tính hợp lệ email
        if (ValidateEmail(txtEmail) == false) {
            lblLoiEmail.setText("Email nhập vào không hợp lệ!");
            count++;
        } else {
            lblLoiEmail.setText("");
        }
        //Kiểm tra trùng khớp với mật khẩu
        if (!Arrays.equals(txtXacNhanMatKhau.getPassword(), txtMatKhau.getPassword()) && ValidateNull(txtXacNhanMatKhau) == true) {
            lblLoiXacNhan.setText("Mật khẩu không trùng khớp thử lại!");
            count++;
        } else {
            lblLoiXacNhan.setText("");
        }
        if (count != 0) {
            return false;
        }
        return true;
    }

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
            lblHinh.setIcon(anh);
            lblHinh.setToolTipText(file.getName()); //Giữ tên hình trong tooltip
            System.out.println(file.getName());
            if (!lblHinh.getToolTipText().equals("")) {
                lblLoiHinh.setText("");
            }
        }
    }

    void load() {
        DefaultTableModel model = (DefaultTableModel) tblTaiKhoan.getModel();
        model.setRowCount(0);
        List<TaiKhoan> list = dao.selectAll();
        for (TaiKhoan tk : list) {
            String gioiTinh = null;
            String vaiTro = null;

            if (tk.getGioiTinh() == 0) {
                gioiTinh = "Nam";
            } else if (tk.getGioiTinh() == 1) {
                gioiTinh = "Nữ";
            } else {
                gioiTinh = "Khác";
            }

            if (tk.getVaiTro() == 0) {
                vaiTro = "Quản lý";
            } else if (tk.getVaiTro() == 1) {
                vaiTro = "Nhân viên đơn hàng";
            } else {
                vaiTro = "Nhân viên kho";
            }

            Object[] ob = {tk.getTenDn(), tk.getMatKhau(), tk.getHoTen(), tk.getEmail(),
                gioiTinh, vaiTro, tk.getSoDt(), tk.getLuong(), tk.getHinh()};
            model.addRow(ob);
        }
    }

    void loadTimKiem() {
        DefaultTableModel model = (DefaultTableModel) tblTaiKhoan.getModel();
        model.setRowCount(0);
        List<TaiKhoan> list = dao.selectByConditions("%" + txtTimKiem.getText().trim() + "%");
        for (TaiKhoan tk : list) {
            String gioiTinh = null;
            String vaiTro = null;

            if (tk.getGioiTinh() == 0) {
                gioiTinh = "Nam";
            } else if (tk.getGioiTinh() == 1) {
                gioiTinh = "Nữ";
            } else {
                gioiTinh = "Khác";
            }

            if (tk.getVaiTro() == 0) {
                vaiTro = "Quản lý";
            } else if (tk.getVaiTro() == 1) {
                vaiTro = "Nhân viên đơn hàng";
            } else {
                vaiTro = "Nhân viên kho";
            }

            Object[] ob = {tk.getTenDn(), tk.getMatKhau(), tk.getHoTen(), tk.getEmail(),
                gioiTinh, vaiTro, tk.getSoDt(), tk.getLuong(), tk.getHinh()};
            model.addRow(ob);
        }
    }

    TaiKhoan getModel() {
        TaiKhoan tk = new TaiKhoan();
        tk.setTenDn(txtTenDangNhap.getText().trim());
        tk.setMatKhau(new String(txtMatKhau.getPassword()));
        tk.setHoTen(txtHoTen.getText().trim());

        if (cboGioiTinh.getSelectedIndex() == 1) {
            tk.setGioiTinh(0);
        } else if (cboGioiTinh.getSelectedIndex() == 2) {
            tk.setGioiTinh(1);
        } else {
            tk.setGioiTinh(2);
        }

        if (cboVaiTro.getSelectedIndex() == 1) {
            tk.setVaiTro(2);
        } else if (cboVaiTro.getSelectedIndex() == 2) {
            tk.setVaiTro(1);
        } else {
            tk.setVaiTro(0);
        }

        tk.setEmail(txtEmail.getText().trim());
        tk.setSoDt(txtSoDienThoai.getText().trim());
        String replace = "";
        if (txtLuong.getText().trim().contains(",") || txtLuong.getText().trim().contains(".")) {
            replace = txtLuong.getText().replace(",", ".");
            replace = txtLuong.getText().replace(".", ".");
        } else {
            replace = txtLuong.getText().trim();
        }
        tk.setLuong(Double.parseDouble(replace));
        tk.setHinh(lblHinh.getToolTipText());
        return tk;
    }

    void setModel(TaiKhoan tk) {
        txtTenDangNhap.setText(tk.getTenDn());
        txtMatKhau.setText(tk.getMatKhau());
        txtXacNhanMatKhau.setText(tk.getMatKhau());

        if (tk.getGioiTinh() == 0) {
            cboGioiTinh.setSelectedIndex(1);
        } else if (tk.getGioiTinh() == 1) {
            cboGioiTinh.setSelectedIndex(2);
        } else {
            cboGioiTinh.setSelectedIndex(3);
        }

        if (tk.getVaiTro() == 0) {
            cboVaiTro.setSelectedIndex(3);
        } else if (tk.getVaiTro() == 1) {
            cboVaiTro.setSelectedIndex(2);
        } else {
            cboVaiTro.setSelectedIndex(1);
        }
        txtHoTen.setText(tk.getHoTen());
        txtEmail.setText(tk.getEmail());
        txtSoDienThoai.setText(tk.getSoDt());
        txtLuong.setText(String.format("%.1f", tk.getLuong()));
        ImageIcon anh = ImageHelper.read(tk.getHinh());
        //Đọc hình từ thư mục logos
        //ImageIcon read(String tenFile) đọc file trong thư mục logos theo tên file trả về ImageIcon
        lblHinh.setIcon(anh);
        lblHinh.setToolTipText(tk.getHinh()); //Giữ tên hình trong tooltip
    }

    void clear() {
        Color(txtTenDangNhap, "VD: lenNv15", Italic, Gray);
        Color(txtMatKhau, "jPasswordField1", Plain, Gray);
        Color(txtXacNhanMatKhau, "jPasswordFi4567", Plain, Gray);
        Color(txtSoDienThoai, "VD: 0374035658(10 hoặc 11 số)", Italic, Gray);
        Color(txtHoTen, "VD: Lê Văn Tèo", Italic, Gray);
        Color(txtEmail, "Email", Italic, Gray);
        Color(txtLuong, "VD: 2000000", Italic, Gray);
        cboGioiTinh.setSelectedIndex(0);
        cboVaiTro.setSelectedIndex(0);
        lblHinh.setIcon(null);
        lblHinh.setToolTipText(null);
        tblTaiKhoan.clearSelection();
        lblLoiTenDangNhap.setText("");
        lblLoiMatKhau.setText("");
        lblLoiXacNhan.setText("");
        cboGioiTinh.setSelectedIndex(0);
        cboVaiTro.setSelectedIndex(0);
        lblLoiHoTen.setText("");
        lblLoiEmail.setText("");
        lblLoiDienThoai.setText("");
        lblLoiLuong.setText("");
        lblLoiHinh.setText("");
        lblLoiVaiTro.setText("");
        lblLoiGioiTinh.setText("");
        setStatus(true);
    }

    void edit() {
        String tenDangNhap = (String) tblTaiKhoan.getValueAt(index, 0);
        Color(txtTenDangNhap, "", Plain, Black);
        Color(txtMatKhau, "", Plain, Black);
        Color(txtXacNhanMatKhau, "", Plain, Black);
        Color(txtSoDienThoai, "", Plain, Black);
        Color(txtHoTen, "", Plain, Black);
        Color(txtEmail, "", Plain, Black);
        Color(txtLuong, "", Plain, Black);
        //Xét các label lỗi về null
        lblLoiTenDangNhap.setText("");
        lblLoiMatKhau.setText("");
        lblLoiXacNhan.setText("");
        lblLoiDienThoai.setText("");
        lblLoiGioiTinh.setText("");
        lblLoiVaiTro.setText("");
        lblLoiHoTen.setText("");
        lblLoiEmail.setText("");
        lblLoiLuong.setText("");
        lblLoiHinh.setText("");

        tblTaiKhoan.setRowSelectionInterval(index, index);
        TaiKhoan tk = dao.selectById(tenDangNhap);
        setModel(tk);
        setStatus(false);

    }

    void insert() {
        TaiKhoan tk = getModel();
        Loading1_JDialog ld = new Loading1_JDialog();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                ld.setVisible(true);
            }
        };
        thread1.start();

        Thread thread2 = new Thread() {
            @Override
            public void run() {

                if (dao.insert(tk) == 3) {
                    load();
                    clear();
                    try {
                        createQr(tk.getTenDn());
                    } catch (WriterException | IOException | NotFoundException ex) {
                        Logger.getLogger(QuanLyNhanVien_JFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //Kiểm tra ảnh trong thư mục có tồn tại hay không
                    File f = new File("logos/" + tk.getTenDn());
                    String path = null;
                    if (f.exists() == false) {
                        path = "logos/" + tk.getTenDn() + ".png";
                    }
                    nguoiNhan = tk.getEmail();
                    sendQr(nguoiNhan, path);
                    ld.dispose();
                    DialogHelper.alert(null, "Thêm mới thành công");
                } else if (dao.insert(tk) == 2) {
                    ld.dispose();
                    lblLoiDienThoai.setText("Số điện thoai này đã tồn tại");
                    DialogHelper.alert(null, "Thêm mới thất bại");
                } else if (dao.insert(tk) == 1) {
                    ld.dispose();
                    lblLoiEmail.setText("Email này đã tồn tại");
                    DialogHelper.alert(null, "Thêm mới thất bại");
                } else {
                    ld.dispose();
                    lblLoiTenDangNhap.setText("Tên đăng nhập này đã tồn tại");
                    DialogHelper.alert(null, "Thêm mới thất bại");
                }
            }
        };
        thread2.start();
    }

    void update() {
        TaiKhoan tk = getModel();
        if (dao.update(tk) == 3) {
            load();
            clear();
            DialogHelper.alert(null, "Cập nhật thành công");
        } else if (dao.update(tk) == 2) {
            lblLoiDienThoai.setText("Số điện thoai này đã tồn tại");
            DialogHelper.alert(null, "Cập nhật thất bại");
        } else if (dao.update(tk) == 1) {
            lblLoiEmail.setText("Email này đã tồn tại");
            DialogHelper.alert(null, "Cập nhật thất bại");
        } else {
            lblLoiTenDangNhap.setText("Tên đăng nhập chưa tồn tại");
            DialogHelper.alert(null, "Cập nhật thất bại");
        }
    }

    void delete() {
        if (DialogHelper.confirm(null, "Bạn có muốn xóa nhân viên này không ?")) {
            if (dao.delete(txtTenDangNhap.getText().trim()) == 1) {
                load();
                clear();
                DialogHelper.alert(null, "Xóa thành công");
            } else {
                lblLoiTenDangNhap.setText("Tên đăng nhập không tồn tại");
                DialogHelper.alert(null, "Xóa thất bại");
            }
        }
    }

    void setStatus(boolean status) {
        txtTenDangNhap.setEditable(status);
        btnInsert.setEnabled(status);
        btnUpdate.setEnabled(!status);
        btnDelete.setEnabled(!status);

        boolean first = index > 0;
        boolean last = index < tblTaiKhoan.getRowCount() - 1;

        btnFirst.setEnabled(!status && first);
        btnPrev.setEnabled(!status && first);
        btnNext.setEnabled(!status && last);
        btnLast.setEnabled(!status && last);
    }

    void sendQr(String to, String url) {
        try {
            Properties p = new Properties();
            p.put("mail.smtp.auth", "true");
            p.put("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.put("mail.smtp.port", 587);
            String accountName = "nhavtps16500@fpt.edu.vn";
            String accountPassword = "Vothanhnhavothanhnha123456789";
            Session s = Session.getInstance(p,
                    new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(accountName, accountPassword);
                }
            });
            String subject = "Hệ thống quản lý kho hàng gửi mã QR cho bạn!";
            //Đây là mã QR của bạn bạn có thể sử dụng để đăng nhập, Xin trân trọng cảm ơn!
            String body = "";
            Message msg = new MimeMessage(s);
            msg.setFrom(new InternetAddress(accountName));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            msg.setSubject(subject);
            msg.setText(body);
            msg.setSentDate(new Date());
            //3. dinh nghia loai noi dung cua message
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setContent(String.valueOf(body),"text/plain");
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(textPart);
            String strAttach = url;
            if (!strAttach.equals("")) {
                MimeBodyPart attachFilePart = new MimeBodyPart();
                FileDataSource fds = new FileDataSource(strAttach);
                attachFilePart.setDataHandler(new DataHandler(fds));
                attachFilePart.setFileName(fds.getName());
                mp.addBodyPart(attachFilePart);
            }

            msg.setContent(mp);
            Transport.send(msg);
            System.out.println("QR was sent successfully.");
        } catch (MessagingException ex) {
            Logger.getLogger(QuanLyNhanVien_JFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void generateQRcode(String data, String path, String charset, Map map, int h, int w) throws WriterException, IOException {
        BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset), BarcodeFormat.QR_CODE, w, h);
        MatrixToImageWriter.writeToFile(matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));
    }

    void createQr(String nameImage) throws WriterException, IOException, NotFoundException {
        //Dữ liệu đuọc tạo của mã QR
        String str = nameImage;
// Đường dẫn lưu mã QR vào máy 
        String path = "logos\\" + nameImage + ".png";
// Mã hóa bộ ký tự sẽ được sử dụng
        String charset = "UTF-8";
        Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
// tạo mã QR với khả năng sửa lỗi mức Thấp (L) 
        hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
// gọi phương thức do người dùng xác định để tạo mã QR
        generateQRcode(str, path, charset, hashMap, 250, 250);//increase or decrease height and width accodingly   
    }
}
