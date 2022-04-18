/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import Dao.TaiKhoanDAO;
import static Help.ColorHelper.setBackround;
import Help.DialogHelper;
import static Help.ImageHelper.*;
import static Help.ValidateHelper.*;
import java.awt.CardLayout;
import javax.swing.JFrame;
import static Help.ValidateHelper.Color;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author hp
 */
public class XacNhan_ThayDoi_Mk_JDialog extends javax.swing.JDialog {

    /**
     * Creates new form XacNhan_ThayDoi_Mk_JDialog
     *
     * @param parent
     * @param modal
     * @param maXn
     */
    public XacNhan_ThayDoi_Mk_JDialog(java.awt.Frame parent, boolean modal, int maXn) {
        super(parent, modal);
        initComponents();
        maXnn = maXn;
        card = (CardLayout) pnlTab.getLayout();
        card.show(pnlTab, "CardXacNhan");
        System.out.println(maXn);
    }

    CardLayout card;
    int maXnn;
    String tenNdDn, name;
    TaiKhoanDAO dao = new TaiKhoanDAO();
    ImageIcon closeEye = new ImageIcon("src/icon/closeEye.png");
    ImageIcon openEye = new ImageIcon("src/icon/openEye.png");
    boolean show = false;

    XacNhan_ThayDoi_Mk_JDialog(Thread aThis, boolean b, int randomInt, String tenDn, String hoTen) {
        initComponents();
        maXnn = randomInt;
        card = (CardLayout) pnlTab.getLayout();
        card.show(pnlTab, "CardXacNhan");
        System.out.println(randomInt);
        tenNdDn = tenDn;
        name = hoTen;
    }

    private XacNhan_ThayDoi_Mk_JDialog(JFrame jFrame, boolean b) {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        pnlTab = new keeptoo.KGradientPanel();
        pblXacNhanMa = new keeptoo.KGradientPanel();
        jLabel4 = new javax.swing.JLabel();
        lblThoat = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtCode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnHuyBo = new javax.swing.JButton();
        btnXacNhan = new javax.swing.JButton();
        lblLoiMaXn = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlDoiMatKhau = new keeptoo.KGradientPanel();
        jLabel5 = new javax.swing.JLabel();
        lblThoat1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnHuyBo1 = new javax.swing.JButton();
        btnDoiMatKhau = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblLoiXacNhan = new javax.swing.JLabel();
        lblLoiMatKhau = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtXacNhan = new javax.swing.JPasswordField();
        txtMatKhau = new javax.swing.JPasswordField();
        lblHoTen = new javax.swing.JLabel();
        lblShowPass = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        kGradientPanel1.setkEndColor(new java.awt.Color(51, 255, 51));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTab.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));
        pnlTab.setkEndColor(new java.awt.Color(255, 255, 255));
        pnlTab.setkStartColor(new java.awt.Color(51, 255, 153));
        pnlTab.setLayout(new java.awt.CardLayout());

        pblXacNhanMa.setkEndColor(new java.awt.Color(153, 255, 153));
        pblXacNhanMa.setkStartColor(new java.awt.Color(204, 255, 255));
        pblXacNhanMa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/fpt_Icon.png"))); // NOI18N
        pblXacNhanMa.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 40));

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
        pblXacNhanMa.add(lblThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 50, 50));
        pblXacNhanMa.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 55, 650, 10));

        txtCode.setBackground(new java.awt.Color(204, 255, 255));
        txtCode.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtCode.setForeground(new java.awt.Color(153, 153, 153));
        txtCode.setText("Nhập vào mã");
        txtCode.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodeFocusLost(evt);
            }
        });
        pblXacNhanMa.add(txtCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 290, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Nhập mã xác nhận của bạn");
        pblXacNhanMa.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 300, 20));

        btnHuyBo.setBackground(new java.awt.Color(0, 153, 255));
        btnHuyBo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnHuyBo.setForeground(new java.awt.Color(255, 255, 255));
        btnHuyBo.setText("Hủy bỏ");
        btnHuyBo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHuyBoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHuyBoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHuyBoMouseExited(evt);
            }
        });
        pblXacNhanMa.add(btnHuyBo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 120, 40));

        btnXacNhan.setBackground(new java.awt.Color(255, 51, 51));
        btnXacNhan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnXacNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnXacNhanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnXacNhanMouseExited(evt);
            }
        });
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });
        pblXacNhanMa.add(btnXacNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 130, 40));

        lblLoiMaXn.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiMaXn.setForeground(new java.awt.Color(255, 0, 0));
        pblXacNhanMa.add(lblLoiMaXn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 250, 20));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/XacNhanMa.png"))); // NOI18N
        pblXacNhanMa.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 320, 270));

        pnlTab.add(pblXacNhanMa, "CardXacNhan");

        pnlDoiMatKhau.setkEndColor(new java.awt.Color(204, 255, 255));
        pnlDoiMatKhau.setkStartColor(new java.awt.Color(102, 255, 102));
        pnlDoiMatKhau.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/fpt_Icon.png"))); // NOI18N
        pnlDoiMatKhau.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 40));

        lblThoat1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThoat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/lblThoat.png"))); // NOI18N
        lblThoat1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThoat1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblThoat1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblThoat1MouseExited(evt);
            }
        });
        pnlDoiMatKhau.add(lblThoat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 50, 50));
        pnlDoiMatKhau.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 55, 650, 10));

        btnHuyBo1.setBackground(new java.awt.Color(0, 153, 255));
        btnHuyBo1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnHuyBo1.setForeground(new java.awt.Color(255, 255, 255));
        btnHuyBo1.setText("Hủy bỏ");
        btnHuyBo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHuyBo1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHuyBo1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHuyBo1MouseExited(evt);
            }
        });
        pnlDoiMatKhau.add(btnHuyBo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 140, 40));

        btnDoiMatKhau.setBackground(new java.awt.Color(255, 51, 51));
        btnDoiMatKhau.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDoiMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        btnDoiMatKhau.setText("Thay đổi");
        btnDoiMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDoiMatKhauMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDoiMatKhauMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDoiMatKhauMouseExited(evt);
            }
        });
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });
        pnlDoiMatKhau.add(btnDoiMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 130, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 255));
        jLabel3.setText("Thành viên thay đổi mật khẩu");
        pnlDoiMatKhau.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 310, 30));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/doiPass.png"))); // NOI18N
        pnlDoiMatKhau.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 240, 240));

        lblLoiXacNhan.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiXacNhan.setForeground(new java.awt.Color(255, 0, 0));
        pnlDoiMatKhau.add(lblLoiXacNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 280, 20));

        lblLoiMatKhau.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiMatKhau.setForeground(new java.awt.Color(255, 0, 0));
        pnlDoiMatKhau.add(lblLoiMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 240, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 51));
        jLabel7.setText("Xác nhận");
        pnlDoiMatKhau.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 230, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 51));
        jLabel8.setText("Mật khẩu mới");
        pnlDoiMatKhau.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 170, -1, -1));

        txtXacNhan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtXacNhan.setForeground(new java.awt.Color(153, 153, 153));
        txtXacNhan.setText("jPasswordField1");
        txtXacNhan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtXacNhanFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtXacNhanFocusLost(evt);
            }
        });
        txtXacNhan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtXacNhanKeyReleased(evt);
            }
        });
        pnlDoiMatKhau.add(txtXacNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 240, 30));

        txtMatKhau.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMatKhau.setForeground(new java.awt.Color(153, 153, 153));
        txtMatKhau.setText("jPasswordField1");
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
        pnlDoiMatKhau.add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 240, 30));

        lblHoTen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblHoTen.setForeground(new java.awt.Color(102, 102, 102));
        lblHoTen.setText("Thanh Nhã");
        pnlDoiMatKhau.add(lblHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 220, 30));

        lblShowPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblShowPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblShowPassMouseClicked(evt);
            }
        });
        pnlDoiMatKhau.add(lblShowPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 50, 30));

        pnlTab.add(pnlDoiMatKhau, "CardDoiMatKhau");

        kGradientPanel1.add(pnlTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 660, 380));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 149, Short.MAX_VALUE)
        );

        kGradientPanel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 720, 150));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 460));

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

    private void txtCodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodeFocusGained
        if (txtCode.getForeground().equals(Gray)) {
            Color(txtCode, "", Plain, Black);
        }
    }//GEN-LAST:event_txtCodeFocusGained

    private void txtCodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodeFocusLost
        if (txtCode.getText().trim().isEmpty()) {
            Color(txtCode, "Nhập vào mã", Italic, Gray);
        } else {
            lblLoiMaXn.setText("");
        }
    }//GEN-LAST:event_txtCodeFocusLost

    private void btnHuyBoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyBoMouseClicked
        dispose();
        new DangNhap_JFrame().setVisible(true);
    }//GEN-LAST:event_btnHuyBoMouseClicked

    private void btnHuyBoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyBoMouseEntered
        setBackround(new Color(0, 153, 255), Color.darkGray, btnHuyBo);
    }//GEN-LAST:event_btnHuyBoMouseEntered

    private void btnHuyBoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyBoMouseExited
        setBackround(new Color(0, 153, 255), Color.white, btnHuyBo);
    }//GEN-LAST:event_btnHuyBoMouseExited

    private void btnXacNhanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXacNhanMouseEntered
        setBackround(new Color(0, 204, 51), Color.darkGray, btnXacNhan);
    }//GEN-LAST:event_btnXacNhanMouseEntered

    private void btnXacNhanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXacNhanMouseExited
        setBackround(new Color(255, 51, 51), Color.white, btnXacNhan);
    }//GEN-LAST:event_btnXacNhanMouseExited

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        if (checkFrom() == false) {
            return;
        }
        if (checkCode() == false) {
            return;
        }
        card.show(pnlTab, "CardDoiMatKhau");
        lblHoTen.setText(name);
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void lblThoat1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoat1MouseClicked
        dispose();
        new DangNhap_JFrame().setVisible(true);
    }//GEN-LAST:event_lblThoat1MouseClicked

    private void lblThoat1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoat1MouseEntered
        lblThoat1.setIcon(Close2);
    }//GEN-LAST:event_lblThoat1MouseEntered

    private void lblThoat1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoat1MouseExited
        lblThoat1.setIcon(Close1);
    }//GEN-LAST:event_lblThoat1MouseExited

    private void btnHuyBo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyBo1MouseClicked
        dispose();
        new DangNhap_JFrame().setVisible(true);
    }//GEN-LAST:event_btnHuyBo1MouseClicked

    private void btnHuyBo1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyBo1MouseEntered
        setBackround(new Color(0, 204, 51), Color.darkGray, btnHuyBo1);
    }//GEN-LAST:event_btnHuyBo1MouseEntered

    private void btnHuyBo1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyBo1MouseExited
        setBackround(new Color(0, 204, 51), Color.WHITE, btnHuyBo1);
    }//GEN-LAST:event_btnHuyBo1MouseExited

    private void btnDoiMatKhauMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoiMatKhauMouseEntered
        setBackround(new Color(255, 51, 51), Color.darkGray, btnDoiMatKhau);
    }//GEN-LAST:event_btnDoiMatKhauMouseEntered

    private void btnDoiMatKhauMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoiMatKhauMouseExited
        setBackround(new Color(255, 51, 51), Color.WHITE, btnDoiMatKhau);
    }//GEN-LAST:event_btnDoiMatKhauMouseExited

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
        if (checkFromDoiMk() == false) {
            return;
        }
        update();
    }//GEN-LAST:event_btnDoiMatKhauActionPerformed

    private void txtMatKhauFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMatKhauFocusGained
        if (txtMatKhau.getForeground().equals(Gray)) {
            Color(txtMatKhau, "", Plain, Black);
        }
    }//GEN-LAST:event_txtMatKhauFocusGained

    private void txtXacNhanFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtXacNhanFocusGained
        if (txtXacNhan.getForeground().equals(Gray)) {
            Color(txtXacNhan, "", Plain, Black);
        }
    }//GEN-LAST:event_txtXacNhanFocusGained

    private void txtMatKhauFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMatKhauFocusLost
        if (txtMatKhau.getText().length() == 0) {
            Color(txtMatKhau, "jPasswordField1", Plain, Gray);
        } else {
            lblLoiMatKhau.setText("");
        }
    }//GEN-LAST:event_txtMatKhauFocusLost

    private void txtXacNhanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtXacNhanFocusLost
        if (txtXacNhan.getText().length() == 0) {
            Color(txtXacNhan, "jPasswordField1", Plain, Gray);
        } else {
            lblLoiXacNhan.setText("");
        }
    }//GEN-LAST:event_txtXacNhanFocusLost

    private void lblShowPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblShowPassMouseClicked
        if (lblShowPass.getIcon() == null) {
            return;
        }
        if (lblShowPass.getIcon().equals(closeEye)) {
            txtMatKhau.setEchoChar('*');
            txtXacNhan.setEchoChar('*');
            lblShowPass.setIcon(openEye);
            return;
        }
        if (show == true) {
            txtMatKhau.setEchoChar((char) 0);
            txtXacNhan.setEchoChar((char) 0);
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

    private void txtXacNhanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtXacNhanKeyReleased
        if (txtXacNhan.getForeground().equals(Gray) || txtXacNhan.getText().length() == 0) {
            lblShowPass.setIcon(null);
            show = false;
            return;
        }
        show = true;
        lblShowPass.setIcon(openEye);
    }//GEN-LAST:event_txtXacNhanKeyReleased

    private void btnDoiMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoiMatKhauMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDoiMatKhauMouseClicked

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
            java.util.logging.Logger.getLogger(XacNhan_ThayDoi_Mk_JDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XacNhan_ThayDoi_Mk_JDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XacNhan_ThayDoi_Mk_JDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XacNhan_ThayDoi_Mk_JDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                XacNhan_ThayDoi_Mk_JDialog dialog = new XacNhan_ThayDoi_Mk_JDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnHuyBo;
    private javax.swing.JButton btnHuyBo1;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblLoiMaXn;
    private javax.swing.JLabel lblLoiMatKhau;
    private javax.swing.JLabel lblLoiXacNhan;
    private javax.swing.JLabel lblShowPass;
    private javax.swing.JLabel lblThoat;
    private javax.swing.JLabel lblThoat1;
    private keeptoo.KGradientPanel pblXacNhanMa;
    private keeptoo.KGradientPanel pnlDoiMatKhau;
    private keeptoo.KGradientPanel pnlTab;
    private javax.swing.JTextField txtCode;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JPasswordField txtXacNhan;
    // End of variables declaration//GEN-END:variables
    boolean checkCode() {
        if (checkFrom() == false) {
            return false;
        }
        try {
            int maNhap = Integer.parseInt(txtCode.getText().trim());
            if (maNhap != maXnn) {
                DialogHelper.alert(null, "Mã bạn nhập không trùng khớp thử lại!");
                lblLoiMaXn.setText("Thử lại với mã đã gửi trong Mail của bạn!");
                return false;
            }
        } catch (Exception e) {
            DialogHelper.alert(null, "Mã bạn nhập không trùng khớp thử lại!");
            lblLoiMaXn.setText("Thử lại với mã đã gửi trong Mail của bạn!");
            return false;
        }

        return true;
    }

    boolean checkFrom() {
        if (ValidateNull(txtCode) && txtCode.getText().trim().isEmpty()) {
            DialogHelper.alert(null, "Vui lòng nhập vào mã đã được gửi đến Mail của bạn!");
            lblLoiMaXn.setText("Nhập vào mã để xác nhận tài khoản");
            return false;
        }
        return true;
    }

    boolean checkFromDoiMk() {
        int count = 0;
        if (ValidateNull(txtMatKhau) == false) {
            lblLoiMaXn.setText("Nhập vào mật khẩu mới của bạn!");
            count++;
        }
        if (ValidateNull(txtXacNhan) == false) {
            lblLoiXacNhan.setText("Nhập vào mật khẩu xác nhận của bạn!");
            count++;
        }
        String mk = String.valueOf(txtMatKhau.getPassword());
        String xn = String.valueOf(txtXacNhan.getPassword());
        if (!xn.equals(mk)) {
            lblLoiXacNhan.setText("Mật khẩu xác nhận của bạn không trùng khớp thử lại!");
            count++;
        }
        return count == 0;
    }

    private void update() {
        if (tenNdDn == null) {
            DialogHelper.alert(null, "Vui lòng đăng nhập để sử dụng!");
            return;
        }
        Loading_JDialog ld = new Loading_JDialog(this, true);
        Thread thread30 = new Thread() {
            @Override
            public void run() {
                ld.setVisible(true);
            }
        };
        thread30.start();
        Thread thread15 = new Thread() {
            @Override
            public void run() {
                String pass = String.valueOf(txtXacNhan.getPassword());
                if (dao.updatePass(pass, tenNdDn) == 0) {
                    thread30.stop();
                    ld.dispose();
                    dispose();
                    DialogHelper.alert(null, "Thay đổi thông tin thành công bạn có thể thử lại với đăng nhập!");
                } else {
                    thread30.stop();
                    ld.dispose();
                    DialogHelper.alert(null, "Thay đổi thông tin thất bại");
                }
            }
        };
        thread15.start();
    }
}
