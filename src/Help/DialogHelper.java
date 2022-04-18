/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Help;

import java.awt.Component;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class DialogHelper {

    /**
     * Hiển thị thông báo cho người dùng
     *
     * @param parent là cửa sổ chứa thông báo
     * @param message là thông báo
     */
    public static void alert(Component parent, String message) {
        javax.swing.JOptionPane.showMessageDialog(parent, message,
                "Hệ thống quản lý", javax.swing.JOptionPane.INFORMATION_MESSAGE);

    }

    /**
     * Hiển thị thông báo và yêu cầu người dùng xác nhận
     *
     * @param parent là cửa sổ chứa thông báo
     * @param message là câu hỏi yes/no
     * @return là kết quả nhận được true/false
     */
    public static boolean confirm(Component parent, String message) {
        int result = javax.swing.JOptionPane.showConfirmDialog(parent, message,
                "Hệ thống quản lý ",
                javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE);
        return result == javax.swing.JOptionPane.YES_OPTION;
    }

    /**
     * Hiển thị thông báo yêu cầu nhập dữ liệu
     *
     * @param parent là cửa sổ chứa thông báo
     * @param message là thông báo nhắc nhở nhập
     * @return là kết quả nhận được từ người sử dụng nhập vào
     */
    public static String prompt(Component parent, String message) {
        return javax.swing.JOptionPane.showInputDialog(parent, message,
                "Hệ thống quản lý", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }


    //Hàm xuất file theo dạng bảng từ file exe sang các dạng file như excel, word...
    public static void xuatFile(JTable table) {
        JFileChooser chooser = new JFileChooser();
        chooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".xlsx","xlsx");
        //Add đối tượng cần lấy vào File để hộp thoại hiển thị File cần lưu
        chooser.addChoosableFileFilter(filter);
        int i = chooser.showSaveDialog(chooser);
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                FileWriter out = new FileWriter(file + ".xls"); 
                BufferedWriter bwrite = new BufferedWriter(out);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                // ten Cot
                for (int j = 0; j < table.getColumnCount(); j++) {
                    bwrite.write(model.getColumnName(j) + "\t");
                }
                bwrite.write("\n");
                // Lay du lieu dong
                for (int j = 0; j < table.getRowCount(); j++) {
                    for (int k = 0; k < table.getColumnCount(); k++) {
                        bwrite.write(model.getValueAt(j, k) + "\t");
                    }
                    bwrite.write("\n");
                }
                bwrite.close();
                javax.swing.JOptionPane.showMessageDialog(null, "Lưu file thành công!");
            } catch (Exception e2) {
                javax.swing.JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
            }
        }
    }


}
