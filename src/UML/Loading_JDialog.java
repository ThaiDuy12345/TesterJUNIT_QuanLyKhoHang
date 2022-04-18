/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import Dao.TaiKhoanDAO;
import Help.Auth;
import static Help.ColorHelper.pgbLoading_border;
import Help.DialogHelper;
import Model.TaiKhoan;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.Timer;
import UML.DangNhap_JFrame;

/**
 *
 * @author hp
 */
public class Loading_JDialog extends javax.swing.JDialog {

    public Loading_JDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 150, 150));
        init();
    }

    private Loading_JDialog(JFrame jFrame, boolean b) {
        initComponents();
        this.setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 150, 150));
        init();
    }

    Loading_JDialog(Thread aThis, boolean b) {
        initComponents();
        this.setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 150, 150));
        init();
    }

    Loading_JDialog(TimTaiKhoan_JDialog aThis, boolean b) {
        initComponents();
        this.setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 150, 150));
        init();
    }

    Loading_JDialog(OTP_JDialog aThis, boolean b) {
        initComponents();
        this.setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 150, 150));
        init();
    }

    Loading_JDialog(XacNhan_ThayDoi_Mk_JDialog aThis, boolean b) {
        initComponents();
        this.setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 150, 150));
        init();
    }

    void init() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i <= 100; i++) {
                        Thread.sleep(200000);
                    }
                    dispose();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(204, 204, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Loading_gif.gif"))); // NOI18N
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 120));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Loading_JDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loading_JDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loading_JDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loading_JDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Loading_JDialog dialog = new Loading_JDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
