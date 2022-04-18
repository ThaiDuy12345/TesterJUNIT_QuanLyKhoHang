/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import Dao.TaiKhoanDAO;
import Help.Auth;
import static Help.ColorHelper.designComboBox;
import static Help.ColorHelper.*;
import Help.DialogHelper;
import Help.ImageHelper;
import static Help.ImageHelper.*;
import Help.ValidateHelper;
import Model.TaiKhoan;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author hp
 */
public class HoSo_JDialog extends javax.swing.JDialog {

    /**
     * Creates new form HoSo_JDialog
     */
    public HoSo_JDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    void init() {
        designComboBox(new Color(0, 153, 0), Color.white, new Font("Tahoma", Font.PLAIN, 14), cboGioiTinh);
    }

    static String tenDn = null;
    JFileChooser fileChooser = new JFileChooser();
    TaiKhoanDAO dao = new TaiKhoanDAO();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        pnlHoSo = new javax.swing.JPanel();
        lblAnh = new javax.swing.JLabel();
        lblTenVaiTro = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblVaiTroNhanVien = new javax.swing.JLabel();
        lblTenVaiTro2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtHoTen = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSoDt = new javax.swing.JTextField();
        btnThayDoi = new javax.swing.JButton();
        cboGioiTinh = new javax.swing.JComboBox<>();
        lblLoiEmail = new javax.swing.JLabel();
        lblLoiHoTen = new javax.swing.JLabel();
        lblLoiSdt = new javax.swing.JLabel();
        lblThoat = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        kGradientPanel1.setkEndColor(new java.awt.Color(0, 255, 204));
        kGradientPanel1.setkStartColor(new java.awt.Color(51, 153, 255));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlHoSo.setBackground(new java.awt.Color(255, 255, 255));
        pnlHoSo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 5, true)));
        pnlHoSo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAnh.setBackground(new java.awt.Color(255, 102, 102));
        lblAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Nha_Fix.jpg"))); // NOI18N
        lblAnh.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
        lblAnh.setOpaque(true);
        lblAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhMouseClicked(evt);
            }
        });
        pnlHoSo.add(lblAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 320, 400));

        lblTenVaiTro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTenVaiTro.setForeground(new java.awt.Color(102, 102, 102));
        lblTenVaiTro.setText("Thành viên:");
        pnlHoSo.add(lblTenVaiTro, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 160, 150, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Vai trò:");
        pnlHoSo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 70, 40, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Thông tin hồ sơ nhân viên");
        pnlHoSo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 280, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/emailIcom.png"))); // NOI18N
        pnlHoSo.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 60, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Giới tính:");
        pnlHoSo.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 60, 30));

        lblVaiTroNhanVien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblVaiTroNhanVien.setForeground(new java.awt.Color(102, 102, 102));
        lblVaiTroNhanVien.setText("Nhân viên đơn hàng");
        pnlHoSo.add(lblVaiTroNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 150, 30));

        lblTenVaiTro2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTenVaiTro2.setForeground(new java.awt.Color(102, 102, 102));
        lblTenVaiTro2.setText("Ứng dụng quản lý kho hàng");
        pnlHoSo.add(lblTenVaiTro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 100, 150, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/phoneIcon.png"))); // NOI18N
        pnlHoSo.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 60, 30));
        pnlHoSo.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 320, 10));

        txtHoTen.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtHoTen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHoTen.setText("Nguyễn Lê Duy Tiến");
        txtHoTen.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtHoTen.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHoTenFocusLost(evt);
            }
        });
        txtHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoTenActionPerformed(evt);
            }
        });
        pnlHoSo.add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 300, 50));

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(102, 102, 102));
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setText("tiennldps16590@fpt.edu.vn");
        txtEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        pnlHoSo.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 380, 210, 30));

        txtSoDt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSoDt.setForeground(new java.awt.Color(102, 102, 102));
        txtSoDt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSoDt.setText("0374856958");
        txtSoDt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        txtSoDt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSoDtFocusLost(evt);
            }
        });
        pnlHoSo.add(txtSoDt, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 210, 30));

        btnThayDoi.setBackground(new java.awt.Color(0, 204, 51));
        btnThayDoi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThayDoi.setForeground(new java.awt.Color(255, 255, 255));
        btnThayDoi.setText("Thay đổi");
        btnThayDoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnThayDoiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnThayDoiMouseExited(evt);
            }
        });
        btnThayDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThayDoiActionPerformed(evt);
            }
        });
        pnlHoSo.add(btnThayDoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 450, 150, 40));

        cboGioiTinh.setBackground(new java.awt.Color(0, 153, 0));
        cboGioiTinh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));
        pnlHoSo.add(cboGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 210, 30));

        lblLoiEmail.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiEmail.setForeground(new java.awt.Color(255, 0, 0));
        lblLoiEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlHoSo.add(lblLoiEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, 210, 20));

        lblLoiHoTen.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiHoTen.setForeground(new java.awt.Color(255, 0, 0));
        pnlHoSo.add(lblLoiHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 250, 20));

        lblLoiSdt.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblLoiSdt.setForeground(new java.awt.Color(255, 0, 0));
        lblLoiSdt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlHoSo.add(lblLoiSdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, 210, 20));

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
        pnlHoSo.add(lblThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(634, 10, 60, 40));

        kGradientPanel1.add(pnlHoSo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 700, 510));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        kGradientPanel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 418, 820, 162));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenActionPerformed

    private void btnThayDoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThayDoiActionPerformed
        if (checkFrom() == false) {
            return;
        }
        update();
    }//GEN-LAST:event_btnThayDoiActionPerformed

    private void lblAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhMouseClicked
        chonAnh();
    }//GEN-LAST:event_lblAnhMouseClicked

    private void txtHoTenFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoTenFocusLost
        if (!txtHoTen.getText().trim().isEmpty()) {
            lblLoiHoTen.setText("");
        }
    }//GEN-LAST:event_txtHoTenFocusLost

    private void txtSoDtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoDtFocusLost
        if (!txtSoDt.getText().trim().isEmpty()) {
            lblLoiSdt.setText("");
        }
    }//GEN-LAST:event_txtSoDtFocusLost

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        if (!txtEmail.getText().trim().isEmpty()) {
            lblLoiEmail.setText("");
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void lblThoatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseEntered
        lblThoat.setIcon(Close2);
    }//GEN-LAST:event_lblThoatMouseEntered

    private void lblThoatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseExited
        lblThoat.setIcon(Close1);
    }//GEN-LAST:event_lblThoatMouseExited

    private void lblThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseClicked
        dispose();
    }//GEN-LAST:event_lblThoatMouseClicked

    private void btnThayDoiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThayDoiMouseEntered
        setBackround(new Color(0, 204, 51), Color.darkGray, btnThayDoi);
    }//GEN-LAST:event_btnThayDoiMouseEntered

    private void btnThayDoiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThayDoiMouseExited
        setBackround(new Color(0, 204, 51), Color.white, btnThayDoi);
    }//GEN-LAST:event_btnThayDoiMouseExited

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
            java.util.logging.Logger.getLogger(HoSo_JDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoSo_JDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoSo_JDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoSo_JDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HoSo_JDialog dialog = new HoSo_JDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnThayDoi;
    private javax.swing.JComboBox<String> cboGioiTinh;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblLoiEmail;
    private javax.swing.JLabel lblLoiHoTen;
    private javax.swing.JLabel lblLoiSdt;
    private javax.swing.JLabel lblTenVaiTro;
    private javax.swing.JLabel lblTenVaiTro2;
    private javax.swing.JLabel lblThoat;
    private javax.swing.JLabel lblVaiTroNhanVien;
    private javax.swing.JPanel pnlHoSo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtSoDt;
    // End of variables declaration//GEN-END:variables
    public static ImageIcon readAnh(String fileName) {
        File path = new File("logos", fileName);
        return new ImageIcon(new ImageIcon(path.getAbsolutePath()).getImage().getScaledInstance(320, 400, Image.SCALE_DEFAULT));
    }
//        ImageIcon anh = ImageHelper.read(file.getName());
//            //Đọc hình từ thư mục logos
//            //ImageIcon read(String tenFile) đọc file trong thư mục logos theo tên file trả về ImageIcon
//            lblHinh.setIcon(anh);
    String hoTen, email, soDt;

    public void Contructer(String tenDnn, String hoTenn, int vaiTro, String emaill, String sdt, int gioiTinh, String hinh) {
        TaiKhoan tk = Auth.user;
        hoTen = hoTenn;
        email = emaill;
        soDt = sdt;
        if (Auth.user == null) {
            return;
        }
        //Mã đăng nhập
        tenDn = tenDnn;
        //Vai trò
        if (vaiTro == 1) {
            lblVaiTroNhanVien.setText("Nhân viên đơn hàng");
        } else if (vaiTro == 2) {
            lblVaiTroNhanVien.setText("Nhân viên kho hàng");
        } else {
            lblVaiTroNhanVien.setText("Bộ phận quản lý");
        }
        //Giới tính
        if (gioiTinh == 0) {
            cboGioiTinh.setSelectedIndex(0);
        } else if (gioiTinh == 1) {
            cboGioiTinh.setSelectedIndex(1);
        } else {
            cboGioiTinh.setSelectedIndex(2);
        }
        //Email
        txtEmail.setText(emaill);
        //Họ và tên
        txtHoTen.setText(hoTenn);
        //Số điện thoại
        txtSoDt.setText(sdt);
        File f = new File("logos/" + hinh);
        if (f.exists() == false) {
            lblAnh.setIcon(Erro);
            return;
        }
        //Ảnh nhân viên
        ImageIcon anh = readAnh(tk.getHinh());
        lblAnh.setIcon(anh);
    }

    TaiKhoan getModel() {
        TaiKhoan tk = new TaiKhoan();
        if (tenDn == null) {
            DialogHelper.alert(null, "Vui lòng đăng nhập để sử dụng!");
            return tk = null;
        }
        TaiKhoan tk1 = Auth.user;
        tk.setTenDn(tenDn);
        //Thay đổi 
        tk.setHoTen(txtHoTen.getText().trim());
        if (cboGioiTinh.getSelectedIndex() == 0) {
            tk.setGioiTinh(0);
        } else if (cboGioiTinh.getSelectedIndex() == 1) {
            tk.setGioiTinh(1);
        } else {
            tk.setGioiTinh(2);
        }
        tk.setEmail(txtEmail.getText().trim());
        tk.setSoDt(txtSoDt.getText().trim());
        if (lblAnh.getToolTipText() == null) {
            tk.setHinh(tk1.getHinh());
        } else {
            tk.setHinh(lblAnh.getToolTipText());
        }
        //Không thay đổi
        tk.setVaiTro(tk1.getVaiTro());
        tk.setMatKhau(tk1.getMatKhau());
        tk.setLuong(tk1.getLuong());
        return tk;
    }

    private void update() {
        if (tenDn == null) {
            DialogHelper.alert(null, "Vui lòng đăng nhập để sử dụng!");
            return;
        }
        TaiKhoan tk = getModel();
        if (dao.update(tk) == 3) {
            DialogHelper.alert(null, "Thay đổi thông tin thành công!");
        } else if (dao.update(tk) == 2) {
            lblLoiSdt.setText("Số điện thoai này đã tồn tại");
            DialogHelper.alert(null, "Cập nhật thất bại");
        } else {
            lblLoiEmail.setText("Email này đã tồn tại");
            DialogHelper.alert(null, "Cập nhật thất bại");
        }
        Auth.clear();
        Auth.user = tk;
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
            ImageIcon anh = readAnh(file.getName());
            //Đọc hình từ thư mục logos
            //ImageIcon read(String tenFile) đọc file trong thư mục logos theo tên file trả về ImageIcon
            lblAnh.setIcon(anh);
            lblAnh.setToolTipText(file.getName()); //Giữ tên hình trong tooltip
            System.out.println(file.getName());
//            if (!lblAnh.getToolTipText().equals("")) {
////                lblLoiHinh.setText("");
//            }
        }
    }

    boolean checkFrom() {
        if (txtEmail.getText().trim().isEmpty() && txtSoDt.getText().trim().isEmpty() && txtHoTen.getText().trim().isEmpty()) {
            lblLoiEmail.setText("Vui lòng không bỏ trống Email của bạn!");
            lblLoiSdt.setText("Vui lòng không bỏ trống số điện thoại của bạn!");
            lblLoiHoTen.setText("Vui lòng không bỏ trống họ và tên của bạn!");
            return false;
        }
        if (txtEmail.getText().trim().isEmpty()) {
            lblLoiEmail.setText("Vui lòng không bỏ trống Email của bạn!");
            txtEmail.requestFocus();
            return false;
        }
        if (ValidateHelper.ValidateEmail1(txtEmail) == false) {
            lblLoiEmail.setText("Email của bạn không hợp lệ thử lại!");
            txtEmail.requestFocus();
            return false;
        }
        if (txtSoDt.getText().trim().isEmpty()) {
            lblLoiSdt.setText("Vui lòng không bỏ trống số điện thoại của bạn!");
            txtSoDt.requestFocus();
            return false;
        }
        if (ValidateHelper.ValidateSDT1(txtSoDt) == false) {
            lblLoiSdt.setText("Số điện thoại của bạn không hợp lệ thử lại!");
            txtSoDt.requestFocus();
            return false;
        }
        if (txtHoTen.getText().trim().isEmpty()) {
            lblLoiHoTen.setText("Vui lòng không bỏ trống họ và tên của bạn!");
            txtHoTen.requestFocus();
            return false;
        }
        if (ValidateHelper.ValidateName1(txtHoTen) == false) {
            lblLoiHoTen.setText("Tên của bạn không hợp lệ thử lại!");
            txtHoTen.requestFocus();
            return false;
        }
        return true;
    }
}
