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
import Model.TaiKhoan;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;

/**
 *
 * @author hp
 */
public class TimTaiKhoan_JDialog extends javax.swing.JDialog {

    /**
     * Creates new form TimTaiKhoan_JDialog
     */
    public TimTaiKhoan_JDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    TaiKhoanDAO dao = new TaiKhoanDAO();
    String emailTk, tenDnn, tenNd;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        lblAnh = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblThoat = new javax.swing.JLabel();
        lblLoiThongTin = new javax.swing.JLabel();
        btnTim = new javax.swing.JButton();
        btnHuyBo = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        kGradientPanel1.setkEndColor(new java.awt.Color(0, 204, 153));
        kGradientPanel1.setkGradientFocus(650);
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));
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

        kGradientPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));
        kGradientPanel2.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(153, 204, 255));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Tìm tài khoản của bạn");
        kGradientPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        lblAnh.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblAnh.setForeground(new java.awt.Color(255, 0, 51));
        lblAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Khunglong.gif"))); // NOI18N
        lblAnh.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        kGradientPanel2.add(lblAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 220, 250));

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        txtTimKiem.setForeground(new java.awt.Color(153, 153, 153));
        txtTimKiem.setText("Nhập vào thông tin tài khoản!");
        txtTimKiem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusLost(evt);
            }
        });
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        kGradientPanel2.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 270, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Vui lòng nhập thông tin để tìm kiếm tài khoản của bạn.");
        kGradientPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

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
        kGradientPanel2.add(lblThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(524, 0, 50, 50));

        lblLoiThongTin.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiThongTin.setForeground(new java.awt.Color(255, 0, 0));
        kGradientPanel2.add(lblLoiThongTin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 290, 20));

        btnTim.setBackground(new java.awt.Color(0, 204, 51));
        btnTim.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTim.setForeground(new java.awt.Color(255, 255, 255));
        btnTim.setText("Tìm");
        btnTim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTimMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTimMouseExited(evt);
            }
        });
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });
        kGradientPanel2.add(btnTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 110, 40));

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
        kGradientPanel2.add(btnHuyBo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 120, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/emailIcom.png"))); // NOI18N
        kGradientPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 60, 40));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/fpt_Icon.png"))); // NOI18N
        kGradientPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 40));
        kGradientPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 580, 10));

        kGradientPanel1.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 580, 330));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        kGradientPanel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 670, 130));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 390));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusGained
        if (txtTimKiem.getForeground().equals(Gray)) {
            Color(txtTimKiem, "", Plain, Black);
        }
    }//GEN-LAST:event_txtTimKiemFocusGained

    private void txtTimKiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusLost
        if (txtTimKiem.getForeground().equals(Gray)) {
            Color(txtTimKiem, "Nhập vào thông tin tài khoản!", Italic, Gray);
        }
    }//GEN-LAST:event_txtTimKiemFocusLost

    private void lblThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseClicked
        dispose();
    }//GEN-LAST:event_lblThoatMouseClicked

    private void lblThoatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseEntered
        lblThoat.setIcon(Close2);
    }//GEN-LAST:event_lblThoatMouseEntered

    private void lblThoatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseExited
        lblThoat.setIcon(Close1);
    }//GEN-LAST:event_lblThoatMouseExited

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        if (checkFrom() == false) {
            return;
        }
        if (btnTim.getText().equals("Tìm")) {
            find();
        } else {
            getCode();

        }

    }//GEN-LAST:event_btnTimActionPerformed

    private void btnTimMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimMouseEntered
        setBackround(new Color(0, 204, 51), Color.darkGray, btnTim);
    }//GEN-LAST:event_btnTimMouseEntered

    private void btnTimMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimMouseExited
        setBackround(new Color(0, 204, 51), Color.white, btnTim);
    }//GEN-LAST:event_btnTimMouseExited

    private void btnHuyBoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyBoMouseEntered
        setBackround(new Color(0, 153, 255), Color.darkGray, btnHuyBo);
    }//GEN-LAST:event_btnHuyBoMouseEntered

    private void btnHuyBoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyBoMouseExited
        setBackround(new Color(0, 153, 255), Color.white, btnHuyBo);
    }//GEN-LAST:event_btnHuyBoMouseExited

    private void btnHuyBoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyBoMouseClicked
        dispose();
    }//GEN-LAST:event_btnHuyBoMouseClicked

    private void kGradientPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MouseDragged

    }//GEN-LAST:event_kGradientPanel1MouseDragged

    private void kGradientPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MousePressed

    }//GEN-LAST:event_kGradientPanel1MousePressed

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
            java.util.logging.Logger.getLogger(TimTaiKhoan_JDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TimTaiKhoan_JDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TimTaiKhoan_JDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TimTaiKhoan_JDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TimTaiKhoan_JDialog dialog = new TimTaiKhoan_JDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnHuyBo;
    private javax.swing.JButton btnTim;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblLoiThongTin;
    private javax.swing.JLabel lblThoat;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
public static ImageIcon readHinh(String fileName) {
        File path = new File("logos", fileName);
        return new ImageIcon(new ImageIcon(path.getAbsolutePath()).getImage().getScaledInstance(220, 250, Image.SCALE_DEFAULT));
    }

    void find() {
        Loading_JDialog ld = new Loading_JDialog(this, true);
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
                String bien = txtTimKiem.getText().trim();
                boolean kt = false;
                List<TaiKhoan> ds = dao.selectByConditions(bien);
                for (int i = 0; i < ds.size(); i++) {
                    if (ds.get(i).getEmail().equals(bien) || ds.get(i).getSoDt().equals(bien)
                            || ds.get(i).getTenDn().equals(bien) || ds.get(i).getHoTen().equals(bien)) {
                        ld.dispose();
                        boolean yes = DialogHelper.confirm(null, "Chào bạn " + ds.get(i).getHoTen() + " bạn đang cần tìm tài khoản!");
                        if (yes == true) {
                            btnTim.setText("Lấy mã");
                            File f = new File("logos/" + ds.get(i).getHinh());
                            if (f.exists() == false) {
                                lblAnh.setIcon(Erro);
                                return;
                            } else {
                                ImageIcon anh = readHinh(ds.get(i).getHinh());
                                lblAnh.setIcon(anh);
                            }//if
                            emailTk = ds.get(i).getEmail();
                            tenDnn = ds.get(i).getTenDn();
                            tenNd = ds.get(i).getHoTen();
                        }
                        kt = true;
                    }//if
                }//for
                if (kt == false) {
                    ld.dispose();
                    DialogHelper.alert(null, "Tài khoản bạn vừa tìm không tồn tại!");
                }
            }
        };
        thread2.start();
    }

    boolean checkFrom() {
        if (ValidateNull(txtTimKiem) && txtTimKiem.getText().trim().isEmpty()) {
            DialogHelper.alert(null, "Hệ thống cần bạn cung cấp thông tin tìm kiếm!");
            lblLoiThongTin.setText("Nhập vào Email, tên đăng nhập hoặc số điện thoại!");
            return false;
        }
        return true;
    }

    public void getCode() {
        Loading_JDialog ld = new Loading_JDialog(this, true);
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                ld.setVisible(true);
            }
        };
        thread1.start();
        ///////
        Thread thread2;
        thread2 = new Thread() {
            @Override
            public void run() {
                Properties p = new Properties();
                p.put("mail.smtp.auth", "true");
                p.put("mail.smtp.starttls.enable", "true");
                p.put("mail.smtp.host", "smtp.gmail.com");
                p.put("mail.smtp.port", 587);
                //-----
                //Người gửi
                final String accountName = "nhavtps16500@fpt.edu.vn";
                final String accountPassword = "Vothanhnhavothanhnha123456789";
                try {
                    Session s = Session.getInstance(p,
                            new javax.mail.Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(accountName, accountPassword);
                        }
                    });
                    //--------
                    String to = emailTk;
                    //Tạo các giá trị ngẫu nhiên gửi đến người xác nhận Email bằng hàm random
                    double randomDouble = Math.random();
                    randomDouble = randomDouble * 100000 + 1;
                    int randomInt = (int) randomDouble;
                    //------------
                    Message msg = new MimeMessage(s);
                    // gán giá trị cho các thuộc tính của đối tượng msg
                    msg.setFrom(new InternetAddress(accountName));
                    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
                    msg.setSubject("Hệ thống quản lý kho hàng");
                    msg.setText("Mã xác thực của bạn là " + randomInt);
                    //-----------
                    Transport.send(msg);
                    //-----------
                    ld.dispose();
                    JOptionPane.showMessageDialog(rootPane, "Chúng tôi đã gửi một tin nhắn cho bạn để xác thực tài khoản vui lòng kiểm tra lại Mail");
                    //Tắt from gọi from xác nhận mã
                    dispose();
                    XacNhan_ThayDoi_Mk_JDialog xn = new XacNhan_ThayDoi_Mk_JDialog(this, true, randomInt, tenDnn, tenNd);
                    xn.setVisible(true);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        java.util.logging.Logger.getLogger(KhoHang_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                } catch (MessagingException ex) {
                    java.util.logging.Logger.getLogger(DialogHelper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        };
        thread2.start();
    }
}
