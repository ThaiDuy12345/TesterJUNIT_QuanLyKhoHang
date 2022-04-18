/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Help;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.CallableStatement;

/**
 *
 * @author hp
 */
public class JdbcHelper {

    public static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String url = "jdbc:sqlserver://" + "localhost" + ":1433;DatabaseName=" + "Qly_KhoHang";
    public static String username = "sa";
    public static String password = "";

    //Nạp driver
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JdbcHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
        * Xây dựng CallableStatement
        * @param sql là câu lệnh SQL chứa có thể chứa tham số. Nó là một lời gọi thủ tục lưu
        * @param args là danh sách các giá trị được cung cấp cho các tham số trong câu lệnh sql
        * @return CallableStatement tạo được
        * @throws java.sql.SQLException lỗi sai cú pháp
     */
    public static CallableStatement callableStatement(String sql, Object... args) throws SQLException {
        Connection con = DriverManager.getConnection(url, username, password);
        CallableStatement cstmt = con.prepareCall(sql);
        //Dùng cho proc lời gọi trong sql
        if (sql.startsWith("{?")) {
            cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
            for (int i = 1; i <= args.length; i++) {
                cstmt.setObject(i + 1, args[i - 1]);
            }
        } else {
            for (int i = 0; i < args.length; i++) {
                cstmt.setObject(i + 1, args[i]);
            }
        }

        return cstmt;
    }

    /*
        * Thực hiện câu lệnh SQL thủ tục lưu thao tác dữ liệu
        * @param sql là câu lệnh SQL chứa có thể chứa tham số. Nó là một lời gọi thủ tục lưu
        * @param args là danh sách các giá trị được cung cấp cho các tham số trong câu lệnh sql *
     */
    public static int executeUpdate(String sql, Object... args) {
        try {
            CallableStatement cstmt = callableStatement(sql, args);

            try {
                cstmt.executeUpdate();
                return cstmt.getInt(1);
            } finally {
                cstmt.getConnection().close();            //đóng Connection từ statement
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    /*
        * Thực hiện câu lệnh SQL thủ tục lưu truy vấn dữ liệu
        * @param sql là câu lệnh SQL chứa có thể chứa tham số. Nó là một lời gọi thủ tục lưu
        * @param args là danh sách các giá trị được cung cấp cho các tham số trong câu lệnh sql
     */
    public static ResultSet executeQuery(String sql, Object... args) {
        try {
            CallableStatement cstmt = callableStatement(sql, args);
            return cstmt.executeQuery();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);         //throw các lỗi khi chạy CT, VD không có return khi try bị lỗi
        }
    }

    /*
        * Thực hiện câu lệnh SQL thủ tục lưu truy vấn dữ liệu để lấy ra 1 giá trị
        * @param sql là câu lệnh SQL chứa có thể chứa tham số. Nó là một lời gọi thủ tục lưu
        * @param args là danh sách các giá trị được cung cấp cho các tham số trong câu lệnh sql
     */
    public static Object value(String sql, Object... args) {
        try {
            ResultSet rs = executeQuery(sql,args) ;
            if (rs.next()) {
                return rs.getObject(1);
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
