/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import Help.Auth;
import static Help.ColorHelper.*;
import Help.DialogHelper;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import Help.ImageHelper;
import static Help.ImageHelper.Erro;
import Model.TaiKhoan;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author hp
 */
public class FromChaQuanLy_JFrame extends javax.swing.JFrame {

    /**
     * Creates new form FromChaQuanLy_JFrame
     */
    public FromChaQuanLy_JFrame() {
        initComponents();
        init();
        taiKhoan = Auth.user;
        vaiTro = taiKhoan.getVaiTro();
        hoTen = taiKhoan.getHoTen();
        hinhOnline = taiKhoan.getHinh();
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    taiKhoan = Auth.user;
                    if (taiKhoan == null) {
                        return;
                    }
                    if (vaiTro != taiKhoan.getVaiTro() || !hoTen.equals(taiKhoan.getHoTen()) || !hinhOnline.equals(taiKhoan.getHinh())) {
                        vaiTro = taiKhoan.getVaiTro();
                        hoTen = taiKhoan.getHoTen();
                        hinhOnline = taiKhoan.getHinh();
                        hinh();
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(FromChaQuanLy_JFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        thread.start();
    }

    void init() {
        card = (CardLayout) pnlTab.getLayout();
        card.show(pnlTab, "cardThongKeKho");
        setOpaque(true, new Color(0, 102, 255), lblStatusTrangChu);
        setOpaque(false, null, lblStatusQuanLy, lblStatusNvKho, lblStatusNvDh, lblStatusThongKeKho, lblStatusThongKeTc);
        hinh();
        pnlThongTinUd.setBackground(new Color(0, 0, 0, 0));
        
        btnTrangChu.setBackground(new Color(255,255,255));
        btnQuanLy.setBackground(new Color(255,255,255));
        btnThongKeKho.setBackground(new Color(255,255,255));
        btnThongKeTaiC.setBackground(new Color(255,255,255));
        btnNhanVienDh.setBackground(new Color(255,255,255));
        bntNhanVienKho.setBackground(new Color(255,255,255));
    }

    void hinh() {
        taiKhoan = Auth.user;
        if (taiKhoan == null) {
            return;
        }
        File f = new File("logos/" + taiKhoan.getHinh());
        if (f.exists() == false) {
            lblHinh.setIcon(Erro);
            return;
        }
        //Ảnh nhân viên
        ImageIcon anh = ImageHelper.read(taiKhoan.getHinh());
        lblHinh.setIcon(anh);
        //HOẠT ĐỘNG 
        pnlHoatDong.setBackground(new Color(0, 0, 0, 1));
        pnlHoatDong.setBackground(new Color(0, 0, 0, 0));
        lblHoatDong.setBackground(new Color(0, 0, 0, 0));
        lblHoatDong.setIcon(icon);
        String vaiTroo;
        if (taiKhoan.getVaiTro() == 1) {
            vaiTroo = "Nhân viên đơn hàng";
        } else if (taiKhoan.getVaiTro() == 2) {
            vaiTroo = "Nhân viên kho hàng";
        } else {
            vaiTroo = "Quản lý";
        }
        lblName.setText(taiKhoan.getHoTen() + " (" + vaiTroo + ")");
    }

    CardLayout card;
    TaiKhoan taiKhoan;
    ImageIcon icon = new ImageIcon("src/icon/HoatDong.png");
    String hoTen, hinhOnline;
    int vaiTro;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel39 = new javax.swing.JLabel();
        lblThoat = new javax.swing.JLabel();
        kGradientPanel6 = new keeptoo.KGradientPanel();
        btnThongKeKho = new javax.swing.JButton();
        bntNhanVienKho = new javax.swing.JButton();
        btnNhanVienDh = new javax.swing.JButton();
        lblStatusNvKho = new javax.swing.JLabel();
        lblStatusThongKeKho = new javax.swing.JLabel();
        lblStatusNvDh = new javax.swing.JLabel();
        btnThongKeTaiC = new javax.swing.JButton();
        lblStatusThongKeTc = new javax.swing.JLabel();
        btnTrangChu = new javax.swing.JButton();
        lblStatusTrangChu = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        lblStatusQuanLy = new javax.swing.JLabel();
        btnQuanLy = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        pnlHoatDong = new javax.swing.JPanel();
        lblHoatDong = new clabel.CLabel();
        lblHinh = new clabel.CLabel();
        jLabel54 = new javax.swing.JLabel();
        pnlTab = new keeptoo.KGradientPanel();
        pnlCardTrangChu = new keeptoo.KGradientPanel();
        pnlThongTinUd = new RoundedPanelCha(20, new Color(153,153,153));
        jLabel37 = new javax.swing.JLabel();
        kGradientPanel7 = new keeptoo.KGradientPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnlCardNhanVienKho = new keeptoo.KGradientPanel();
        kGradientPanel5 = new keeptoo.KGradientPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        pnlCardNhanVienDonHang = new keeptoo.KGradientPanel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        pnlCardThongKeKho = new keeptoo.KGradientPanel();
        kGradientPanel8 = new keeptoo.KGradientPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        kGradientPanel9 = new keeptoo.KGradientPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        pnlCardThongKeTaiChinh = new keeptoo.KGradientPanel();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lblNhanVien = new javax.swing.JLabel();
        lblTongDoanhThu = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        pnlCardChucNang = new keeptoo.KGradientPanel();
        kGradientPanel10 = new keeptoo.KGradientPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        kGradientPanel1.setkGradientFocus(1400);
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

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(51, 51, 255));
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logo.png"))); // NOI18N
        jLabel39.setText("Hệ thống quản lý ");
        kGradientPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblThoat.setFont(new java.awt.Font("UVN Thay Giao Nhe", 1, 48)); // NOI18N
        lblThoat.setForeground(new java.awt.Color(153, 204, 255));
        lblThoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThoat.setText("o");
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
        kGradientPanel1.add(lblThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, -10, 40, 50));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 50));

        kGradientPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        kGradientPanel6.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel6.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnThongKeKho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThongKeKho.setText("Thống kê kho");
        btnThongKeKho.setBorder(null);
        btnThongKeKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnThongKeKhoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnThongKeKhoMouseExited(evt);
            }
        });
        btnThongKeKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeKhoActionPerformed(evt);
            }
        });
        kGradientPanel6.add(btnThongKeKho, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 140, 90, 30));

        bntNhanVienKho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bntNhanVienKho.setText("Nhân viên kho");
        bntNhanVienKho.setBorder(null);
        bntNhanVienKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bntNhanVienKhoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bntNhanVienKhoMouseExited(evt);
            }
        });
        bntNhanVienKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNhanVienKhoActionPerformed(evt);
            }
        });
        kGradientPanel6.add(bntNhanVienKho, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 90, 30));

        btnNhanVienDh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNhanVienDh.setText("Nhân viên đơn hàng");
        btnNhanVienDh.setBorder(null);
        btnNhanVienDh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNhanVienDhMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNhanVienDhMouseExited(evt);
            }
        });
        btnNhanVienDh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienDhActionPerformed(evt);
            }
        });
        kGradientPanel6.add(btnNhanVienDh, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 120, 30));

        lblStatusNvKho.setBackground(new java.awt.Color(0, 102, 255));
        lblStatusNvKho.setOpaque(true);
        kGradientPanel6.add(lblStatusNvKho, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 170, 85, 5));

        lblStatusThongKeKho.setBackground(new java.awt.Color(0, 102, 255));
        lblStatusThongKeKho.setOpaque(true);
        kGradientPanel6.add(lblStatusThongKeKho, new org.netbeans.lib.awtextra.AbsoluteConstraints(745, 170, 83, 5));

        lblStatusNvDh.setBackground(new java.awt.Color(0, 102, 255));
        lblStatusNvDh.setOpaque(true);
        kGradientPanel6.add(lblStatusNvDh, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 170, 110, 5));

        btnThongKeTaiC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThongKeTaiC.setText("Thống kê tài chính");
        btnThongKeTaiC.setBorder(null);
        btnThongKeTaiC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnThongKeTaiCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnThongKeTaiCMouseExited(evt);
            }
        });
        btnThongKeTaiC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeTaiCActionPerformed(evt);
            }
        });
        kGradientPanel6.add(btnThongKeTaiC, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, 110, 30));

        lblStatusThongKeTc.setBackground(new java.awt.Color(0, 102, 255));
        lblStatusThongKeTc.setOpaque(true);
        kGradientPanel6.add(lblStatusThongKeTc, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 170, 105, 5));

        btnTrangChu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTrangChu.setText("Trang chủ");
        btnTrangChu.setBorder(null);
        btnTrangChu.setNextFocusableComponent(btnTrangChu);
        btnTrangChu.setOpaque(true);
        btnTrangChu.setSelected(true);
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
        kGradientPanel6.add(btnTrangChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 70, 30));

        lblStatusTrangChu.setBackground(new java.awt.Color(0, 102, 255));
        lblStatusTrangChu.setOpaque(true);
        kGradientPanel6.add(lblStatusTrangChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 170, 57, 5));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 102, 204));
        jLabel35.setText("Chi tiết");
        jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel35MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel35MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel35MouseExited(evt);
            }
        });
        kGradientPanel6.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, -1, -1));

        lblName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblName.setForeground(new java.awt.Color(153, 153, 153));
        lblName.setText("Nhã Thanh(Quản lý)");
        kGradientPanel6.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, -1));

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(153, 153, 153));
        jLabel38.setText("Bạn đang đăng nhập");
        kGradientPanel6.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 20, -1, -1));

        lblStatusQuanLy.setBackground(new java.awt.Color(0, 102, 255));
        lblStatusQuanLy.setOpaque(true);
        kGradientPanel6.add(lblStatusQuanLy, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 170, 45, 5));

        btnQuanLy.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnQuanLy.setText("Quản lý");
        btnQuanLy.setBorder(null);
        btnQuanLy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnQuanLyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnQuanLyMouseExited(evt);
            }
        });
        btnQuanLy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyActionPerformed(evt);
            }
        });
        kGradientPanel6.add(btnQuanLy, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 140, 60, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHoatDong.setBackground(new java.awt.Color(0, 255, 0));
        lblHoatDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/HoatDong.png"))); // NOI18N
        lblHoatDong.setText("");
        lblHoatDong.setLineBorder(7);
        lblHoatDong.setLineColor(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlHoatDongLayout = new javax.swing.GroupLayout(pnlHoatDong);
        pnlHoatDong.setLayout(pnlHoatDongLayout);
        pnlHoatDongLayout.setHorizontalGroup(
            pnlHoatDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHoatDongLayout.createSequentialGroup()
                .addGap(0, 155, Short.MAX_VALUE)
                .addComponent(lblHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlHoatDongLayout.setVerticalGroup(
            pnlHoatDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHoatDongLayout.createSequentialGroup()
                .addContainerGap(134, Short.MAX_VALUE)
                .addComponent(lblHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(pnlHoatDong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 200));

        lblHinh.setBackground(new java.awt.Color(255, 255, 255));
        lblHinh.setText("");
        lblHinh.setLineBorder(3);
        lblHinh.setLineColor(new java.awt.Color(204, 204, 204));
        jPanel2.add(lblHinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 200));

        kGradientPanel6.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 210, 200));

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 102, 204));
        jLabel54.setText("Đăng xuất ?");
        jLabel54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel54MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel54MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel54MouseExited(evt);
            }
        });
        kGradientPanel6.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 20, -1, -1));

        getContentPane().add(kGradientPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1200, 200));

        pnlTab.setkEndColor(new java.awt.Color(255, 204, 51));
        pnlTab.setLayout(new java.awt.CardLayout());

        pnlCardTrangChu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlCardTrangChu.setkEndColor(new java.awt.Color(51, 51, 255));
        pnlCardTrangChu.setkGradientFocus(1500);
        pnlCardTrangChu.setkStartColor(new java.awt.Color(255, 255, 255));
        pnlCardTrangChu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlThongTinUd.setBackground(new java.awt.Color(153, 153, 153));
        pnlThongTinUd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlThongTinUdMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlThongTinUdMouseExited(evt);
            }
        });
        pnlThongTinUd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Thông tin ứng dụng");
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel37MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel37MouseExited(evt);
            }
        });
        pnlThongTinUd.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, 20));

        pnlCardTrangChu.add(pnlThongTinUd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 390, 180, 50));

        kGradientPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        kGradientPanel7.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel7.setkStartColor(new java.awt.Color(0, 51, 255));
        kGradientPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Quản lý/ Trang chủ________________________________________________________");
        kGradientPanel7.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Trang chủ_______________________________________________");
        kGradientPanel7.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        pnlCardTrangChu.add(kGradientPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1200, 70));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/QuanLy.png"))); // NOI18N
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });
        pnlCardTrangChu.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1200, 330));

        pnlTab.add(pnlCardTrangChu, "CardTrangChu");

        pnlCardNhanVienKho.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlCardNhanVienKho.setkEndColor(new java.awt.Color(0, 102, 102));
        pnlCardNhanVienKho.setkStartColor(new java.awt.Color(0, 204, 153));
        pnlCardNhanVienKho.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel5.setkEndColor(new java.awt.Color(51, 153, 255));
        kGradientPanel5.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        kGradientPanel2.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 51, 255));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Quản lý/ Nhân viên kho________________________________________________________");
        kGradientPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Nhân viên kho_______________________________________________");
        kGradientPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        kGradientPanel5.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1200, 70));

        pnlCardNhanVienKho.add(kGradientPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setAlignmentX(2.0F);
        jScrollPane1.setAlignmentY(1.5F);
        jScrollPane1.setAutoscrolls(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/nhapHangIcon.png"))); // NOI18N
        jLabel11.setOpaque(true);
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/managerWareHouse.png"))); // NOI18N
        jLabel10.setOpaque(true);
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

        jLabel5.setBackground(new java.awt.Color(153, 153, 153));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Chuyển hàng");
        jLabel5.setOpaque(true);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/ChuyenHang.png"))); // NOI18N
        jLabel13.setOpaque(true);
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(204, 204, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý kho");
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(0, 204, 102));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nhập hàng");
        jLabel2.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(255, 51, 51));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Loại sản phẩm");
        jLabel3.setOpaque(true);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/product kind.png"))); // NOI18N
        jLabel12.setOpaque(true);
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(153, 153, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Nhà cung cấp");
        jLabel7.setOpaque(true);

        jLabel36.setBackground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/suliper.png"))); // NOI18N
        jLabel36.setOpaque(true);
        jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel36MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel36MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel36MouseExited(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(102, 0, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Lô hàng");
        jLabel8.setOpaque(true);

        jLabel48.setBackground(new java.awt.Color(255, 255, 255));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/loHang_Logo.png"))); // NOI18N
        jLabel48.setOpaque(true);
        jLabel48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel48MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel48MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel48MouseExited(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 153, 0));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Sản phẩm cung cấp");
        jLabel9.setOpaque(true);

        jLabel49.setBackground(new java.awt.Color(255, 255, 255));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/providedProduct.png"))); // NOI18N
        jLabel49.setOpaque(true);
        jLabel49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel49MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel49MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel49MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150)
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        pnlCardNhanVienKho.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1200, 340));

        pnlTab.add(pnlCardNhanVienKho, "CardNvKho");

        pnlCardNhanVienDonHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlCardNhanVienDonHang.setkEndColor(new java.awt.Color(153, 153, 255));
        pnlCardNhanVienDonHang.setkStartColor(new java.awt.Color(255, 255, 255));
        pnlCardNhanVienDonHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        kGradientPanel3.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel3.setkStartColor(new java.awt.Color(0, 51, 255));
        kGradientPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Quản lý/ Nhân viên đơn hàng________________________________________________________");
        kGradientPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Nhân viên đơn hàng___________________________________________");
        kGradientPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        pnlCardNhanVienDonHang.add(kGradientPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1200, 70));

        jLabel4.setBackground(new java.awt.Color(0, 204, 204));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Quản lý đơn hàng");
        jLabel4.setOpaque(true);
        pnlCardNhanVienDonHang.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 118, 250, 50));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/qlKho.png"))); // NOI18N
        jLabel14.setOpaque(true);
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });
        pnlCardNhanVienDonHang.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 168, 250, 250));

        jLabel50.setBackground(new java.awt.Color(51, 51, 255));
        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Danh sách đơn hàng");
        jLabel50.setOpaque(true);
        pnlCardNhanVienDonHang.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 250, 50));

        jLabel51.setBackground(new java.awt.Color(255, 255, 255));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/listDonHang.png"))); // NOI18N
        jLabel51.setOpaque(true);
        jLabel51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel51MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel51MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel51MouseExited(evt);
            }
        });
        pnlCardNhanVienDonHang.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 250, 250));

        jLabel52.setBackground(new java.awt.Color(153, 204, 0));
        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Danh sách khách hàng");
        jLabel52.setOpaque(true);
        pnlCardNhanVienDonHang.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 120, 250, 50));

        jLabel53.setBackground(new java.awt.Color(255, 255, 255));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/listKhachHang.png"))); // NOI18N
        jLabel53.setOpaque(true);
        jLabel53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel53MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel53MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel53MouseExited(evt);
            }
        });
        pnlCardNhanVienDonHang.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 170, 250, 250));

        pnlTab.add(pnlCardNhanVienDonHang, "CardNvDonHang");

        pnlCardThongKeKho.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlCardThongKeKho.setkEndColor(new java.awt.Color(102, 102, 255));
        pnlCardThongKeKho.setkStartColor(new java.awt.Color(255, 255, 204));
        pnlCardThongKeKho.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        kGradientPanel8.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel8.setkStartColor(new java.awt.Color(0, 51, 255));
        kGradientPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Quản lý/ Thống kê kho________________________________________________________");
        kGradientPanel8.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Thống kê kho___________________________________________");
        kGradientPanel8.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        pnlCardThongKeKho.add(kGradientPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1200, 70));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        kGradientPanel9.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel9.setkStartColor(new java.awt.Color(255, 255, 255));

        jLabel15.setBackground(new java.awt.Color(204, 204, 0));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Báo cáo tồn kho");
        jLabel15.setOpaque(true);

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/reportTonKho.png"))); // NOI18N
        jLabel16.setOpaque(true);
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(255, 153, 102));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Báo cáo xuất kho");
        jLabel17.setOpaque(true);

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/xuatKho.png"))); // NOI18N
        jLabel18.setOpaque(true);
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel18MouseExited(evt);
            }
        });

        jLabel27.setBackground(new java.awt.Color(153, 153, 255));
        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Báo cáo nhập kho");
        jLabel27.setOpaque(true);

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/NhapKho.png"))); // NOI18N
        jLabel28.setOpaque(true);
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel28MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel28MouseExited(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel9Layout = new javax.swing.GroupLayout(kGradientPanel9);
        kGradientPanel9.setLayout(kGradientPanel9Layout);
        kGradientPanel9Layout.setHorizontalGroup(
            kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel9Layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addGroup(kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(330, 330, 330)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(330, 330, 330)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        kGradientPanel9Layout.setVerticalGroup(
            kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel9Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(kGradientPanel9);

        pnlCardThongKeKho.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1200, 330));

        pnlTab.add(pnlCardThongKeKho, "CardThongKeKho");

        pnlCardThongKeTaiChinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlCardThongKeTaiChinh.setkEndColor(new java.awt.Color(153, 204, 255));
        pnlCardThongKeTaiChinh.setkStartColor(new java.awt.Color(255, 255, 255));
        pnlCardThongKeTaiChinh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        kGradientPanel4.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel4.setkStartColor(new java.awt.Color(0, 51, 255));
        kGradientPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Quản lý/ Thống kê tài chính________________________________________________________");
        kGradientPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Thống kê tài chính___________________________________________");
        kGradientPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        pnlCardThongKeTaiChinh.add(kGradientPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1200, 70));

        jLabel31.setBackground(new java.awt.Color(204, 204, 0));
        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Báo cáo tình hình nhân viên");
        jLabel31.setOpaque(true);
        pnlCardThongKeTaiChinh.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 250, 50));

        lblNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        lblNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/statusEmployee.png"))); // NOI18N
        lblNhanVien.setOpaque(true);
        lblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNhanVienMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblNhanVienMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblNhanVienMouseExited(evt);
            }
        });
        pnlCardThongKeTaiChinh.add(lblNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 250, 250));

        lblTongDoanhThu.setBackground(new java.awt.Color(255, 255, 255));
        lblTongDoanhThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongDoanhThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/tongDoanhThu.png"))); // NOI18N
        lblTongDoanhThu.setOpaque(true);
        lblTongDoanhThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTongDoanhThuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTongDoanhThuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblTongDoanhThuMouseExited(evt);
            }
        });
        pnlCardThongKeTaiChinh.add(lblTongDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 170, 250, 250));

        jLabel34.setBackground(new java.awt.Color(255, 102, 51));
        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Tổng doanh thu");
        jLabel34.setOpaque(true);
        pnlCardThongKeTaiChinh.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, 250, 50));

        pnlTab.add(pnlCardThongKeTaiChinh, "CardThongTaiChinh");

        pnlCardChucNang.setkEndColor(new java.awt.Color(0, 153, 153));
        pnlCardChucNang.setkGradientFocus(1000);
        pnlCardChucNang.setkStartColor(new java.awt.Color(153, 255, 255));
        pnlCardChucNang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        kGradientPanel10.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel10.setkStartColor(new java.awt.Color(0, 51, 255));
        kGradientPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setBackground(new java.awt.Color(255, 255, 255));
        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Quản lý/ Chức năng________________________________________________________");
        kGradientPanel10.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel43.setBackground(new java.awt.Color(255, 255, 255));
        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Chức năng___________________________________________");
        kGradientPanel10.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        pnlCardChucNang.add(kGradientPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1200, 70));

        jLabel44.setBackground(new java.awt.Color(0, 255, 153));
        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Quản lý nhân viên");
        jLabel44.setOpaque(true);
        pnlCardChucNang.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 250, 50));

        jLabel45.setBackground(new java.awt.Color(255, 255, 255));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/statusEmployee.png"))); // NOI18N
        jLabel45.setOpaque(true);
        jLabel45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel45MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel45MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel45MouseExited(evt);
            }
        });
        pnlCardChucNang.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 250, 250));

        jLabel46.setBackground(new java.awt.Color(255, 153, 102));
        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Duyệt hàng");
        jLabel46.setOpaque(true);
        pnlCardChucNang.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 110, 250, 50));

        jLabel47.setBackground(new java.awt.Color(255, 255, 255));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/duyetHang.png"))); // NOI18N
        jLabel47.setOpaque(true);
        jLabel47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel47MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel47MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel47MouseExited(evt);
            }
        });
        pnlCardChucNang.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 160, 250, 250));

        pnlTab.add(pnlCardChucNang, "CardChucNang");

        getContentPane().add(pnlTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 1200, 430));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangChuActionPerformed
        setOpaque(false, null, lblStatusNvKho, lblStatusNvDh, lblStatusThongKeTc, lblStatusThongKeKho, lblStatusTrangChu, lblStatusQuanLy);
        setOpaque(true, new Color(0, 102, 255), lblStatusTrangChu);
        card.show(pnlTab, "CardTrangChu");
    }//GEN-LAST:event_btnTrangChuActionPerformed

    private void bntNhanVienKhoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntNhanVienKhoMouseEntered
        ColorForeground(Color.BLUE, bntNhanVienKho);
    }//GEN-LAST:event_bntNhanVienKhoMouseEntered

    private void btnNhanVienDhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNhanVienDhMouseEntered
        ColorForeground(Color.BLUE, btnNhanVienDh);
    }//GEN-LAST:event_btnNhanVienDhMouseEntered

    private void btnThongKeKhoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongKeKhoMouseEntered
        ColorForeground(Color.BLUE, btnThongKeKho);
    }//GEN-LAST:event_btnThongKeKhoMouseEntered

    private void btnThongKeTaiCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongKeTaiCMouseEntered
        ColorForeground(Color.BLUE, btnThongKeTaiC);
    }//GEN-LAST:event_btnThongKeTaiCMouseEntered

    private void btnTrangChuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseEntered
        ColorForeground(Color.BLUE, btnTrangChu);
    }//GEN-LAST:event_btnTrangChuMouseEntered

    private void bntNhanVienKhoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntNhanVienKhoMouseExited
        ColorForeground(Color.black, bntNhanVienKho);
    }//GEN-LAST:event_bntNhanVienKhoMouseExited

    private void btnNhanVienDhMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNhanVienDhMouseExited
        ColorForeground(Color.black, btnNhanVienDh);
    }//GEN-LAST:event_btnNhanVienDhMouseExited

    private void btnThongKeKhoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongKeKhoMouseExited
        ColorForeground(Color.black, btnThongKeKho);
    }//GEN-LAST:event_btnThongKeKhoMouseExited

    private void btnThongKeTaiCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongKeTaiCMouseExited
        ColorForeground(Color.black, btnThongKeTaiC);
    }//GEN-LAST:event_btnThongKeTaiCMouseExited

    private void btnTrangChuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseExited
        ColorForeground(Color.black, btnTrangChu);
    }//GEN-LAST:event_btnTrangChuMouseExited

    private void bntNhanVienKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNhanVienKhoActionPerformed
        if (Auth.user == null) {
            DialogHelper.alert(null, "Bạn chưa đăng nhập thử lại!");
            return;
        }
        if (!Auth.isEmployeeWareHouse() && !Auth.isManager()) {
            DialogHelper.alert(null, "Bạn không phải là nhân viên kho hàng thử lại!");
            return;
        }
        setOpaque(false, null, lblStatusNvKho, lblStatusNvDh, lblStatusThongKeTc, lblStatusThongKeKho, lblStatusTrangChu, lblStatusQuanLy);
        setOpaque(true, new Color(0, 102, 255), lblStatusNvKho);
        card.show(pnlTab, "CardNvKho");
    }//GEN-LAST:event_bntNhanVienKhoActionPerformed

    private void btnNhanVienDhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienDhActionPerformed
        if (Auth.user == null) {
            DialogHelper.alert(null, "Bạn chưa đăng nhập thử lại!");
            return;
        }
        if (!Auth.isEmployeeOder() && !Auth.isManager()) {
            DialogHelper.alert(null, "Bạn không phải là nhân viên đơn hàng thử lại!");
            return;
        }
        setOpaque(false, null, lblStatusNvKho, lblStatusNvDh, lblStatusThongKeTc, lblStatusThongKeKho, lblStatusTrangChu, lblStatusQuanLy);
        setOpaque(true, new Color(0, 102, 255), lblStatusNvDh);
        card.show(pnlTab, "CardNvDonHang");
    }//GEN-LAST:event_btnNhanVienDhActionPerformed

    private void btnThongKeKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeKhoActionPerformed
        if (Auth.user == null) {
            DialogHelper.alert(null, "Bạn chưa đăng nhập thử lại!");
            return;
        }
        if (!Auth.isManager()) {
            DialogHelper.alert(null, "Bạn không có quyền xem thử lại!");
            return;
        }
        setOpaque(false, null, lblStatusNvKho, lblStatusNvDh, lblStatusThongKeTc, lblStatusThongKeKho, lblStatusTrangChu, lblStatusQuanLy);
        setOpaque(true, new Color(0, 102, 255), lblStatusThongKeKho);
        card.show(pnlTab, "CardThongKeKho");
    }//GEN-LAST:event_btnThongKeKhoActionPerformed

    private void btnThongKeTaiCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeTaiCActionPerformed
        if (Auth.user == null) {
            DialogHelper.alert(null, "Bạn chưa đăng nhập thử lại!");
            return;
        }
        if (!Auth.isManager()) {
            DialogHelper.alert(null, "Bạn không có quyền xem thử lại!");
            return;
        }
        setOpaque(false, null, lblStatusNvKho, lblStatusNvDh, lblStatusThongKeTc, lblStatusThongKeKho, lblStatusTrangChu, lblStatusQuanLy);
        setOpaque(true, new Color(0, 102, 255), lblStatusThongKeTc);
        card.show(pnlTab, "CardThongTaiChinh");
    }//GEN-LAST:event_btnThongKeTaiCActionPerformed

    private void lblThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblThoatMouseClicked

    private void lblThoatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseEntered
        lblThoat.setForeground(Color.darkGray);
    }//GEN-LAST:event_lblThoatMouseEntered

    private void lblThoatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseExited
        lblThoat.setForeground(new Color(153, 204, 255));
    }//GEN-LAST:event_lblThoatMouseExited

    private void kGradientPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MousePressed
        moveFrom(evt);
    }//GEN-LAST:event_kGradientPanel1MousePressed

    private void kGradientPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MouseDragged
        MouseDragged(evt, this);
    }//GEN-LAST:event_kGradientPanel1MouseDragged

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        setBackround(new Color(204, 204, 204), null, jLabel10);
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        setBackround(Color.white, null, jLabel10);
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        setBackround(new Color(204, 204, 204), null, jLabel13);
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        setBackround(Color.white, null, jLabel13);
    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        setBackround(new Color(204, 204, 204), null, jLabel11);
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        setBackround(Color.white, null, jLabel11);
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        setBackround(new Color(204, 204, 204), null, jLabel14);
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
        setBackround(Color.white, null, jLabel14);
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        setBackround(new Color(204, 204, 204), null, jLabel16);
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
        setBackround(Color.white, null, jLabel16);
    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
        setBackround(new Color(204, 204, 204), null, jLabel18);
    }//GEN-LAST:event_jLabel18MouseEntered

    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited
        setBackround(Color.white, null, jLabel18);
    }//GEN-LAST:event_jLabel18MouseExited

    private void jLabel28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseEntered
        setBackround(new Color(204, 204, 204), null, jLabel28);
    }//GEN-LAST:event_jLabel28MouseEntered

    private void jLabel28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseExited
        setBackround(Color.white, null, jLabel28);
    }//GEN-LAST:event_jLabel28MouseExited

    private void lblNhanVienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanVienMouseEntered
        setBackround(new Color(204, 204, 204), null, lblNhanVien);
    }//GEN-LAST:event_lblNhanVienMouseEntered

    private void lblNhanVienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanVienMouseExited
        setBackround(Color.white, null, lblNhanVien);
    }//GEN-LAST:event_lblNhanVienMouseExited

    private void lblTongDoanhThuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTongDoanhThuMouseEntered
        setBackround(new Color(204, 204, 204), null, lblTongDoanhThu);
    }//GEN-LAST:event_lblTongDoanhThuMouseEntered

    private void lblTongDoanhThuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTongDoanhThuMouseExited
        setBackround(Color.white, null, lblTongDoanhThu);
    }//GEN-LAST:event_lblTongDoanhThuMouseExited

    private void jLabel37MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseEntered
        String xet = "<html><u>" + "Thông tin ứng dụng" + "</u></html>";
        jLabel37.setText(xet);
    }//GEN-LAST:event_jLabel37MouseEntered

    private void jLabel37MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseExited
        String xet = "Thông tin ứng dụng";
        jLabel37.setText(xet);
    }//GEN-LAST:event_jLabel37MouseExited

    private void jLabel35MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseEntered
        String xet = "<html><u>" + "Chi tiết" + "</u></html>";
        jLabel35.setText(xet);
    }//GEN-LAST:event_jLabel35MouseEntered

    private void jLabel35MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseExited
        String xet = "Chi tiết";
        jLabel35.setText(xet);
    }//GEN-LAST:event_jLabel35MouseExited

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        pnlThongTinUd.setSize(0, 0);
        new GioiThieu_JDialog(this, true).setVisible(true);
    }//GEN-LAST:event_jLabel37MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked

        SanPhamKho_JFrame sp = new SanPhamKho_JFrame();
        sp.setVisible(true);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        NhapHang_JFrame sp = new NhapHang_JFrame();
        sp.setVisible(true);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        ChuyenHang_JFrame sp = new ChuyenHang_JFrame();
        sp.setVisible(true);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        dispose();
        new QuanLyDonHang_JFrame(0).setVisible(true);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        ThongKeKho_JFrame sp = new ThongKeKho_JFrame(3);//Tồn kho
        sp.setVisible(true);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        ThongKeKho_JFrame sp = new ThongKeKho_JFrame(1);//Xuất kho
        sp.setVisible(true);
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        ThongKeKho_JFrame sp = new ThongKeKho_JFrame(0);//Nhập kho
        sp.setVisible(true);
    }//GEN-LAST:event_jLabel28MouseClicked

    private void lblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanVienMouseClicked
        ThongKeTaiChinh_JFrame sp = new ThongKeTaiChinh_JFrame(1);
        sp.setVisible(true);
    }//GEN-LAST:event_lblNhanVienMouseClicked

    private void lblTongDoanhThuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTongDoanhThuMouseClicked
        ThongKeTaiChinh_JFrame sp = new ThongKeTaiChinh_JFrame(0);
        sp.setVisible(true);
    }//GEN-LAST:event_lblTongDoanhThuMouseClicked

    private void jLabel45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseClicked
        dispose();
        QuanLyNhanVien_JFrame dh = new QuanLyNhanVien_JFrame();
        dh.setVisible(true);
    }//GEN-LAST:event_jLabel45MouseClicked

    private void jLabel45MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseEntered
        setBackround(new Color(204, 204, 204), null, jLabel45);
    }//GEN-LAST:event_jLabel45MouseEntered

    private void jLabel45MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseExited
        setBackround(Color.white, null, jLabel45);
    }//GEN-LAST:event_jLabel45MouseExited

    private void jLabel47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseClicked
        DuyetHang_JFrame dh = new DuyetHang_JFrame();
        dh.setVisible(true);
    }//GEN-LAST:event_jLabel47MouseClicked

    private void jLabel47MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseEntered
        setBackround(new Color(204, 204, 204), null, jLabel47);
    }//GEN-LAST:event_jLabel47MouseEntered

    private void jLabel47MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseExited
        setBackround(Color.white, null, jLabel47);
    }//GEN-LAST:event_jLabel47MouseExited

    private void btnQuanLyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyMouseEntered
        ColorForeground(Color.BLUE, btnQuanLy);
    }//GEN-LAST:event_btnQuanLyMouseEntered

    private void btnQuanLyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyMouseExited
        ColorForeground(Color.black, btnQuanLy);
    }//GEN-LAST:event_btnQuanLyMouseExited

    private void btnQuanLyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyActionPerformed
        if (Auth.user == null) {
            DialogHelper.alert(null, "Bạn chưa đăng nhập thử lại!");
            return;
        }
        if (!Auth.isManager()) {
            DialogHelper.alert(null, "Bạn không có quyền xem thử lại!");
            return;
        }
        setOpaque(false, null, lblStatusNvKho, lblStatusNvDh, lblStatusThongKeTc, lblStatusThongKeKho, lblStatusTrangChu, lblStatusQuanLy);
        setOpaque(true, new Color(0, 102, 255), lblStatusQuanLy);
        card.show(pnlTab, "CardChucNang");
    }//GEN-LAST:event_btnQuanLyActionPerformed

    private void jLabel35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseClicked
        HoSo_JDialog hs = new HoSo_JDialog(this, true);
        TaiKhoan tk = Auth.user;
        if (tk == null) {
            DialogHelper.alert(null, "Vui lòng đăng nhập vào hệ thống");
            return;
        }
        hs.Contructer(tk.getTenDn(), tk.getHoTen(), tk.getVaiTro(), tk.getEmail(), tk.getSoDt(), tk.getGioiTinh(), tk.getHinh());
        hs.setVisible(true);

    }//GEN-LAST:event_jLabel35MouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
   
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
  
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        dispose();
        new KhoHang_JFrame(3).setVisible(true);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        setBackround(new Color(204, 204, 204), null, jLabel12);
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        setBackround(Color.white, null, jLabel12);
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseClicked
        dispose();
        new KhoHang_JFrame(0).setVisible(true);
    }//GEN-LAST:event_jLabel36MouseClicked

    private void jLabel36MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseEntered
        setBackround(new Color(204, 204, 204), null, jLabel36);
    }//GEN-LAST:event_jLabel36MouseEntered

    private void jLabel36MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseExited
        setBackround(Color.white, null, jLabel36);
    }//GEN-LAST:event_jLabel36MouseExited

    private void jLabel48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel48MouseClicked
        dispose();
        new KhoHang_JFrame(2).setVisible(true);
    }//GEN-LAST:event_jLabel48MouseClicked

    private void jLabel48MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel48MouseEntered
        setBackround(new Color(204, 204, 204), null, jLabel48);
    }//GEN-LAST:event_jLabel48MouseEntered

    private void jLabel48MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel48MouseExited
        setBackround(Color.white, null, jLabel48);
    }//GEN-LAST:event_jLabel48MouseExited

    private void jLabel49MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel49MouseClicked
        dispose();
        new KhoHang_JFrame(1).setVisible(true);
    }//GEN-LAST:event_jLabel49MouseClicked

    private void jLabel49MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel49MouseEntered
        setBackround(new Color(204, 204, 204), null, jLabel49);
    }//GEN-LAST:event_jLabel49MouseEntered

    private void jLabel49MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel49MouseExited
        setBackround(Color.white, null, jLabel49);
    }//GEN-LAST:event_jLabel49MouseExited

    private void jLabel51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseClicked
        dispose();
        new QuanLyDonHang_JFrame(1).setVisible(true);
    }//GEN-LAST:event_jLabel51MouseClicked

    private void jLabel51MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseEntered
        setBackround(new Color(204, 204, 204), null, jLabel51);
    }//GEN-LAST:event_jLabel51MouseEntered

    private void jLabel51MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseExited
        setBackround(Color.white, null, jLabel51);
    }//GEN-LAST:event_jLabel51MouseExited

    private void jLabel53MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel53MouseClicked
        dispose();
        new QuanLyDonHang_JFrame(2).setVisible(true);
    }//GEN-LAST:event_jLabel53MouseClicked

    private void jLabel53MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel53MouseEntered
        setBackround(new Color(204, 204, 204), null, jLabel53);
    }//GEN-LAST:event_jLabel53MouseEntered

    private void jLabel53MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel53MouseExited
        setBackround(Color.white, null, jLabel53);
    }//GEN-LAST:event_jLabel53MouseExited

    private void jLabel54MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel54MouseClicked
        if (DialogHelper.confirm(null, "Bạn thật sự muốn đăng xuất ?")) {
            Auth.clear();
            DialogHelper.alert(this, "Bạn đã đăng xuất");
            dispose();
            DangNhap_JFrame dn = new DangNhap_JFrame();
            dn.setVisible(true);
        }
    }//GEN-LAST:event_jLabel54MouseClicked

    private void jLabel54MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel54MouseEntered
        String xet = "<html><u>" + "Đăng xuất ?" + "</u></html>";
        jLabel54.setText(xet);
    }//GEN-LAST:event_jLabel54MouseEntered

    private void jLabel54MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel54MouseExited
        String xet = "Đăng xuất ?";
        jLabel54.setText(xet);
    }//GEN-LAST:event_jLabel54MouseExited

    private void pnlThongTinUdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlThongTinUdMouseEntered

    }//GEN-LAST:event_pnlThongTinUdMouseEntered

    private void pnlThongTinUdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlThongTinUdMouseExited
   
    }//GEN-LAST:event_pnlThongTinUdMouseExited

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
            java.util.logging.Logger.getLogger(FromChaQuanLy_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FromChaQuanLy_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FromChaQuanLy_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FromChaQuanLy_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FromChaQuanLy_JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntNhanVienKho;
    private javax.swing.JButton btnNhanVienDh;
    private javax.swing.JButton btnQuanLy;
    private javax.swing.JButton btnThongKeKho;
    private javax.swing.JButton btnThongKeTaiC;
    private javax.swing.JButton btnTrangChu;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel10;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private keeptoo.KGradientPanel kGradientPanel5;
    private keeptoo.KGradientPanel kGradientPanel6;
    private keeptoo.KGradientPanel kGradientPanel7;
    private keeptoo.KGradientPanel kGradientPanel8;
    private keeptoo.KGradientPanel kGradientPanel9;
    private clabel.CLabel lblHinh;
    private clabel.CLabel lblHoatDong;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblStatusNvDh;
    private javax.swing.JLabel lblStatusNvKho;
    private javax.swing.JLabel lblStatusQuanLy;
    private javax.swing.JLabel lblStatusThongKeKho;
    private javax.swing.JLabel lblStatusThongKeTc;
    private javax.swing.JLabel lblStatusTrangChu;
    private javax.swing.JLabel lblThoat;
    private javax.swing.JLabel lblTongDoanhThu;
    private keeptoo.KGradientPanel pnlCardChucNang;
    private keeptoo.KGradientPanel pnlCardNhanVienDonHang;
    private keeptoo.KGradientPanel pnlCardNhanVienKho;
    private keeptoo.KGradientPanel pnlCardThongKeKho;
    private keeptoo.KGradientPanel pnlCardThongKeTaiChinh;
    private keeptoo.KGradientPanel pnlCardTrangChu;
    private javax.swing.JPanel pnlHoatDong;
    private keeptoo.KGradientPanel pnlTab;
    private javax.swing.JPanel pnlThongTinUd;
    // End of variables declaration//GEN-END:variables
void setOpaque(boolean opaque, Color color, Object... object) {
        //Cho JLabel
        for (int i = 0; i < object.length; i++) {
            if (object[i] instanceof JLabel) {
                JLabel lbl = (JLabel) object[i];
                lbl.setOpaque(opaque);
                lbl.setBackground(color);
            }
        }
    }

    class RoundedPanelCha extends JPanel {

        private Color backgroundColor;
        private int cornerRadius = 15;

        public RoundedPanelCha(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
        }

        public RoundedPanelCha(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        public RoundedPanelCha(int radius) {
            super();
            cornerRadius = radius;

        }

        public RoundedPanelCha(int radius, Color bgColor) {
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
