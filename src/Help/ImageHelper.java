/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Help;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author hp
 */
public class ImageHelper {

//    public static final Image ICON;
//    public static final ImageIcon ImageIcon;
    public static ImageIcon Erro = new ImageIcon("src/icon/Erro.png");
    public static ImageIcon Back1 = new ImageIcon("src/icon/Backs.png");
    public static ImageIcon Back2 = new ImageIcon("src/icon/Backs1.png");
    public static ImageIcon Close1 = new ImageIcon("src/icon/lblThoat.png");
    public static ImageIcon Close2 = new ImageIcon("src/icon/lblThoat1.png");
//    static {
//        // Tải biểu tượng ứng dụng 
//        //CÁCH TẢI ẢNH TỪ TRONG PROJECT
//        //icon là thư mục con của src
//        String file = "/icon/fpt.png";      //icon là thư mục con của src
//        ICON = new ImageIcon(ImageHelper.class.getResource(file)).getImage();
//        ImageIcon = new ImageIcon(ImageHelper.class.getResource(file));
//    }
//
//    public static Image getAppIcon() {
//        URL url = ImageHelper.class.getResource("/src/icon/fpt.png");
//        return new ImageIcon(url).getImage();
//    }

    //Hàm lưu file vào 1 thư mục logos
    public static void save(File src) {
        //Tạo thư mục để chép các đối tượng ảnh vào
        //Nếu không có thư mục thì tạo mới
        File dst = new File("logos", src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdir();
        }
        try {
            //Đường dẫn của file của người dùng chọn
            Path from = Paths.get(src.getAbsolutePath());
            //Đường dẫn đến thư mục logos
            Path to = Paths.get(dst.getAbsolutePath());
            //Coppy file
            //REPLACE_EXISTING cho phép ghì đè lên các đối tượng đã tồn tại
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //Hàm đọc ảnh từ thư mục logos
    public static ImageIcon read(String fileName) {
        File path = new File("logos", fileName);
        return new ImageIcon(new ImageIcon(path.getAbsolutePath()).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
    }

}
