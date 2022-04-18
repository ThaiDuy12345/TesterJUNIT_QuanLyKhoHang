/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import Dao.TaiKhoanDAO;
import Help.Auth;
import static Help.ColorHelper.*;
import Help.DialogHelper;
import static Help.ValidateHelper.*;
import Model.TaiKhoan;
import java.awt.*;
import UML.Loading_JDialog;
import java.util.logging.Level;
import java.util.logging.Logger;
import static Help.ImageHelper.*;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class DangNhap_JFrame extends javax.swing.JFrame implements Runnable, ThreadFactory {

    /**
     * Creates new form DangNhap_JFrame
     */
    public DangNhap_JFrame() {
        initComponents();
        setLocationRelativeTo(null);
        card = (CardLayout) pnlTab.getLayout();
        lblStatusTK.setText("____________________");
        lblTk.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblStatusQR.setText("");
        card.show(pnlTab, "CardTK");
    }
    TaiKhoanDAO dao = new TaiKhoanDAO();

    boolean status = false;
    boolean show = false;
    ImageIcon closeEye = new ImageIcon("src/icon/closeEye.png");
    ImageIcon openEye = new ImageIcon("src/icon/openEye.png");
    ImageIcon baby = new ImageIcon("src/icon/Khunglong.gif");
    CardLayout card;
    private WebcamPanel panel = null;
    private Webcam webcam = null;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    String maQr;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        lblTCCB = new javax.swing.JLabel();
        lblHQUT = new javax.swing.JLabel();
        lblQLKH = new javax.swing.JLabel();
        lblAnh = new javax.swing.JLabel();
        lblTHOAT = new javax.swing.JLabel();
        pnlTab = new javax.swing.JPanel();
        pnlQR = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pnlWebCam = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        pnlDangNhap = new javax.swing.JPanel();
        txtTenDangNhap = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JPasswordField();
        lblAnhDangNhap = new javax.swing.JLabel();
        lblAnhMatKhau = new javax.swing.JLabel();
        lblQuenMatKhau = new javax.swing.JLabel();
        lblLoiTenDangNhap = new javax.swing.JLabel();
        lblLoiPassWord = new javax.swing.JLabel();
        lblDangNhap = new javax.swing.JLabel();
        lblDangNhap_Option = new javax.swing.JLabel();
        lblHuyBo_Option = new javax.swing.JLabel();
        lblShowPass = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblTk = new javax.swing.JLabel();
        lblQr = new javax.swing.JLabel();
        lblStatusTK = new javax.swing.JLabel();
        lblStatusQR = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        kGradientPanel1.setkEndColor(new java.awt.Color(41, 144, 181));
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

        lblTCCB.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        lblTCCB.setForeground(new java.awt.Color(255, 255, 255));
        lblTCCB.setText("THEO CÁCH CỦA BẠN");
        kGradientPanel1.add(lblTCCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 180, 402, 44));

        lblHQUT.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        lblHQUT.setForeground(new java.awt.Color(255, 255, 255));
        lblHQUT.setText("<html><u>HIỆU QUẢ - UY TÍN</u></html>"); // NOI18N
        kGradientPanel1.add(lblHQUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 230, 334, 68));

        lblQLKH.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblQLKH.setForeground(new java.awt.Color(255, 157, 0));
        lblQLKH.setText("QUẢN LÝ KHO HÀNG");
        kGradientPanel1.add(lblQLKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 106, 402, 68));

        lblAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/qlkh.png"))); // NOI18N
        lblAnh.setBorder(new javax.swing.border.MatteBorder(null));
        kGradientPanel1.add(lblAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 309, 380, 200));

        lblTHOAT.setFont(new java.awt.Font("Tahoma", 1, 38)); // NOI18N
        lblTHOAT.setForeground(new java.awt.Color(255, 255, 255));
        lblTHOAT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTHOAT.setText("X");
        lblTHOAT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTHOATMouseClicked(evt);
            }
        });
        kGradientPanel1.add(lblTHOAT, new org.netbeans.lib.awtextra.AbsoluteConstraints(1058, 0, 36, -1));

        pnlTab.setLayout(new java.awt.CardLayout());

        pnlQR.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlWebCam.setBackground(new java.awt.Color(204, 255, 204));
        pnlWebCam.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        pnlWebCam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(pnlWebCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 330, 260));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Quét mã QR đăng nhập");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, -1, -1));

        jSeparator3.setForeground(new java.awt.Color(153, 153, 153));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 520, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("Đưa mã QR của bạn vào khung ảnh để đăng nhập");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, -1, -1));

        pnlQR.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 400));

        pnlTab.add(pnlQR, "CardQR");

        pnlDangNhap.setBackground(new java.awt.Color(255, 255, 255));
        pnlDangNhap.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pnlDangNhap.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTenDangNhap.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        txtTenDangNhap.setForeground(new java.awt.Color(153, 153, 153));
        txtTenDangNhap.setText("Tên đăng nhập");
        txtTenDangNhap.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtTenDangNhap.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTenDangNhapFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTenDangNhapFocusLost(evt);
            }
        });
        pnlDangNhap.add(txtTenDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 304, 50));

        txtMatKhau.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMatKhau.setForeground(new java.awt.Color(153, 153, 153));
        txtMatKhau.setText("jPasswordField1");
        txtMatKhau.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtMatKhau.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMatKhauFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMatKhauFocusLost(evt);
            }
        });
        txtMatKhau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMatKhauKeyReleased(evt);
            }
        });
        pnlDangNhap.add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 304, 44));

        lblAnhDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/person.png"))); // NOI18N
        pnlDangNhap.add(lblAnhDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, 30));

        lblAnhMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/password.png"))); // NOI18N
        pnlDangNhap.add(lblAnhMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        lblQuenMatKhau.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblQuenMatKhau.setForeground(new java.awt.Color(255, 0, 0));
        lblQuenMatKhau.setText("Quên mật khẩu");
        lblQuenMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuenMatKhauMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblQuenMatKhauMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblQuenMatKhauMouseExited(evt);
            }
        });
        pnlDangNhap.add(lblQuenMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 90, -1));

        lblLoiTenDangNhap.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblLoiTenDangNhap.setForeground(new java.awt.Color(255, 0, 0));
        pnlDangNhap.add(lblLoiTenDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 304, 20));

        lblLoiPassWord.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblLoiPassWord.setForeground(new java.awt.Color(255, 0, 0));
        pnlDangNhap.add(lblLoiPassWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 250, 22));

        lblDangNhap.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblDangNhap.setForeground(new java.awt.Color(51, 102, 255));
        lblDangNhap.setText("Đăng nhập");
        pnlDangNhap.add(lblDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        lblDangNhap_Option.setBackground(new java.awt.Color(51, 102, 255));
        lblDangNhap_Option.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDangNhap_Option.setForeground(new java.awt.Color(255, 255, 255));
        lblDangNhap_Option.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDangNhap_Option.setText("Đăng nhập");
        lblDangNhap_Option.setOpaque(true);
        lblDangNhap_Option.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDangNhap_OptionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDangNhap_OptionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDangNhap_OptionMouseExited(evt);
            }
        });
        pnlDangNhap.add(lblDangNhap_Option, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 146, 44));

        lblHuyBo_Option.setBackground(new java.awt.Color(0, 204, 0));
        lblHuyBo_Option.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHuyBo_Option.setForeground(new java.awt.Color(255, 255, 255));
        lblHuyBo_Option.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHuyBo_Option.setText("Hủy bỏ");
        lblHuyBo_Option.setOpaque(true);
        lblHuyBo_Option.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHuyBo_OptionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHuyBo_OptionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHuyBo_OptionMouseExited(evt);
            }
        });
        pnlDangNhap.add(lblHuyBo_Option, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 146, 44));

        lblShowPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblShowPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblShowPassMouseClicked(evt);
            }
        });
        pnlDangNhap.add(lblShowPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 50, 30));

        pnlTab.add(pnlDangNhap, "CardTK");

        kGradientPanel1.add(pnlTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 145, 520, 400));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTk.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTk.setForeground(new java.awt.Color(102, 102, 102));
        lblTk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTk.setText("Với tài khoản");
        lblTk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTkMouseClicked(evt);
            }
        });
        jPanel2.add(lblTk, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 60));

        lblQr.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblQr.setForeground(new java.awt.Color(102, 102, 102));
        lblQr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQr.setText("Với mã QR");
        lblQr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQrMouseClicked(evt);
            }
        });
        jPanel2.add(lblQr, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 260, 60));

        lblStatusTK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatusTK.setText("_____________________________");
        jPanel2.add(lblStatusTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 150, 30));

        lblStatusQR.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblStatusQR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatusQR.setText("_____________________________");
        jPanel2.add(lblStatusQR, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 150, 30));

        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 520, 10));

        jSeparator2.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 20, 40));

        kGradientPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 520, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1104, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblTHOATMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTHOATMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblTHOATMouseClicked

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
            lblLoiPassWord.setText("");
        }
    }//GEN-LAST:event_txtMatKhauFocusLost

    private void kGradientPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MousePressed
        moveFrom(evt);
    }//GEN-LAST:event_kGradientPanel1MousePressed

    private void kGradientPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MouseDragged
        MouseDragged(evt, this);
    }//GEN-LAST:event_kGradientPanel1MouseDragged

    private void lblDangNhap_OptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangNhap_OptionMouseClicked
        if (checkFrom() == true) {
            login();
        }
    }//GEN-LAST:event_lblDangNhap_OptionMouseClicked

    private void lblHuyBo_OptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHuyBo_OptionMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblHuyBo_OptionMouseClicked

    private void lblDangNhap_OptionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangNhap_OptionMouseEntered
        setBackround(new Color(51, 102, 255), Color.darkGray, lblDangNhap_Option);
    }//GEN-LAST:event_lblDangNhap_OptionMouseEntered

    private void lblHuyBo_OptionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHuyBo_OptionMouseEntered
        setBackround(new Color(0, 204, 0), Color.darkGray, lblHuyBo_Option);
    }//GEN-LAST:event_lblHuyBo_OptionMouseEntered

    private void lblDangNhap_OptionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangNhap_OptionMouseExited
        setBackround(new Color(51, 102, 255), Color.white, lblDangNhap_Option);
    }//GEN-LAST:event_lblDangNhap_OptionMouseExited

    private void lblHuyBo_OptionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHuyBo_OptionMouseExited
        setBackround(new Color(0, 204, 0), Color.white, lblHuyBo_Option);
    }//GEN-LAST:event_lblHuyBo_OptionMouseExited

    private void lblQuenMatKhauMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMatKhauMouseEntered
        String quen = "<html><u>" + "Quên mật khẩu" + "</u></html>";
        lblQuenMatKhau.setText(quen);
    }//GEN-LAST:event_lblQuenMatKhauMouseEntered

    private void lblQuenMatKhauMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMatKhauMouseExited
        String quen = "Quên mật khẩu";
        lblQuenMatKhau.setText(quen);
    }//GEN-LAST:event_lblQuenMatKhauMouseExited

    private void lblQuenMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMatKhauMouseClicked
        int messageType = JOptionPane.QUESTION_MESSAGE;
        String[] options = {"SMS", "Email"};
        int code = JOptionPane.showOptionDialog(this, "Chọn cách lấy mã xác nhận ", "Option Dialog Box", 0, messageType, baby, options, "OTP");
        if (code == -1) {
            return;
        }
        if (code == 0) {
            new OTP_JDialog(this, true).setVisible(true);
        } else {
            new TimTaiKhoan_JDialog(this, true).setVisible(true);
        }
    }//GEN-LAST:event_lblQuenMatKhauMouseClicked

    private void lblShowPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblShowPassMouseClicked
        if (lblShowPass.getIcon() == null) {
            return;
        }
        if (lblShowPass.getIcon().equals(closeEye)) {
            txtMatKhau.setEchoChar('*');
            lblShowPass.setIcon(openEye);
            return;
        }
        if (show == true) {
            txtMatKhau.setEchoChar((char) 0);
            lblShowPass.setIcon(closeEye);
        }
    }//GEN-LAST:event_lblShowPassMouseClicked

    private void txtMatKhauKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatKhauKeyReleased
        if (txtMatKhau.getForeground().equals(Gray) || txtMatKhau.getText().length() == 0) {
            lblShowPass.setIcon(null);
            show = false;
            return;
        }
        show = true;
        lblShowPass.setIcon(openEye);
    }//GEN-LAST:event_txtMatKhauKeyReleased

    private void lblTkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTkMouseClicked
        card.show(pnlTab, "CardTK");
        lblStatusQR.setText("");
        lblStatusTK.setText("____________________");
        lblTk.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblQr.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        webcam.close();
    }//GEN-LAST:event_lblTkMouseClicked

    private void lblQrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQrMouseClicked
        card.show(pnlTab, "CardQR");
        lblStatusTK.setText("");
        lblStatusQR.setText("__________________________");
        lblQr.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTk.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        initWebcam();

    }//GEN-LAST:event_lblQrMouseClicked

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhap_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhap_JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblAnhDangNhap;
    private javax.swing.JLabel lblAnhMatKhau;
    private javax.swing.JLabel lblDangNhap;
    private javax.swing.JLabel lblDangNhap_Option;
    private javax.swing.JLabel lblHQUT;
    private javax.swing.JLabel lblHuyBo_Option;
    private javax.swing.JLabel lblLoiPassWord;
    private javax.swing.JLabel lblLoiTenDangNhap;
    private javax.swing.JLabel lblQLKH;
    private javax.swing.JLabel lblQr;
    private javax.swing.JLabel lblQuenMatKhau;
    private javax.swing.JLabel lblShowPass;
    private javax.swing.JLabel lblStatusQR;
    private javax.swing.JLabel lblStatusTK;
    private javax.swing.JLabel lblTCCB;
    private javax.swing.JLabel lblTHOAT;
    private javax.swing.JLabel lblTk;
    private javax.swing.JPanel pnlDangNhap;
    private javax.swing.JPanel pnlQR;
    private javax.swing.JPanel pnlTab;
    private javax.swing.JPanel pnlWebCam;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTenDangNhap;
    // End of variables declaration//GEN-END:variables

    /*
        Hàm kiểm tra tài khoản có nằm trong csdl hay không
        Nếu có thì hiển thị đăng nhập thành công
        Nếu không thì hiển thị thất bại
     */
    void login() {
        String tenDn = txtTenDangNhap.getText().trim();
        String matKhau = txtMatKhau.getText();
        Loading_JDialog ld = new Loading_JDialog(this, true);
        Thread thread10 = new Thread() {
            @Override
            public void run() {
                ld.setVisible(true);
            }
        };
        thread10.start();

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    if (dao.checkLogin(tenDn, matKhau) == 2) {
                        System.out.println("Thành công!");
                        ld.dispose();
                        thread10.stop();
                        DialogHelper.alert(null, "Đăng nhập thành công");
                        lblDangNhap_Option.setEnabled(false);
                        TaiKhoan tk = dao.selectById(tenDn);
                        Auth.user = tk;
                        dispose();
                        FromChaQuanLy_JFrame ql = new FromChaQuanLy_JFrame();
                        ql.setVisible(true);
                    } else if (dao.checkLogin(tenDn, matKhau) == 1) {
                        txtMatKhau.requestFocus();
                        ld.dispose();
                        thread10.stop();
                        DialogHelper.alert(null, "Sai mật khẩu!");
                    } else {
                        txtTenDangNhap.requestFocus();
                        ld.dispose();
                        thread10.stop();
                        DialogHelper.alert(null, "Tên đăng nhập không tồn tại");
                    }
                } catch (Exception e) {
                    thread10.stop();
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    void loginQR() {
        Loading_JDialog ld = new Loading_JDialog(this, true);
        Thread thread10 = new Thread() {
            @Override
            public void run() {
                ld.setVisible(true);
            }
        };
        thread10.start();

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    boolean kt = false;
                    java.util.List<TaiKhoan> ds = dao.selectByConditions(maQr);
                    for (int i = 0; i < ds.size(); i++) {
                        if (ds.get(i).getTenDn().equals(maQr)) {
                            kt = true;
                            nt.stop();
                            ld.dispose();
                            TaiKhoan tk = dao.selectById(maQr);
                            Auth.user = tk;
                            dispose();
                            DialogHelper.alert(null, "Đăng nhập thành công");
                            FromChaQuanLy_JFrame qn = new FromChaQuanLy_JFrame();
                            qn.setVisible(true);
                        }//if
                    }//for
                    if (kt == false) {
                        ld.dispose();
                        DialogHelper.alert(null, "Mã QR này không tồn tại trong hệ thống thử lại!");
                    }
                } catch (Exception e) {
                    thread10.stop();
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    boolean checkFrom() {
        int count = 0;
        //Bỏ trống tên đăng nhập
        if (ValidateNull(txtTenDangNhap) == false || txtTenDangNhap.getText().trim().equals("")) {
            lblLoiTenDangNhap.setText("Không bỏ trống tên đăng nhập!");
            count++;
        } else {
            lblLoiTenDangNhap.setText("");
        }
        //Bỏ trống mật khẩu
        if (ValidateNull(txtMatKhau) == false || txtMatKhau.getText().trim().equals("")) {
            lblLoiPassWord.setText("Không bỏ trống mật khẩu!");
            count++;
        } else {
            lblLoiPassWord.setText("");
        }

        if (count != 0) {
            return false;
        }
        return true;
    }

    private void initWebcam() {
        try {
            Dimension size = WebcamResolution.QVGA.getSize();
            webcam = Webcam.getWebcams().get(0);
            webcam.setViewSize(size);

            panel = new WebcamPanel(webcam);
            panel.setPreferredSize(size);
            panel.setFPSDisplayed(true);

            pnlWebCam.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 330, 260));
            executor.execute(this);
        } catch (Exception e) {
        }
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {

            }
            Result result = null;
            BufferedImage image = null;
            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }
            if (image == null) {
                return;
            }
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException ex) {
                Logger.getLogger(DangNhap_JFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (result != null) {
                maQr = result.getText();
                loginQR();
            }
        } while (true);
    }
    Thread nt;

    @Override
    public Thread newThread(Runnable r) {
        nt = new Thread(r, "My Thread");
        nt.setDaemon(true);
        return nt;
    }
}
