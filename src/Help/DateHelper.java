/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Help;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author hp
 */
public class DateHelper {

    public static final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("yyyy-MM-dd");
    public static final java.sql.Date dae = new java.sql.Date(Calendar.getInstance().getTime().getTime());//Thời gian hiện tại

    public static java.util.Date now() {
        return new java.util.Date();   //new DateHelper lấy giờ hiện tại
    }

    /*
    @param date chuyền vào date kiểu date
    @param pattern định dạng date
    return date kiểu String đã định theo dạng pattern
     */
    public static String toString(java.util.Date date, String... pattern) {
        if (pattern.length > 0) {
            DATE_FORMATER.applyPattern(pattern[0]);
        }
        if (date == null) {
            date = DateHelper.now();
        }
        return DATE_FORMATER.format(date);
    }

    /**
    *@param date truyền vào date kiểu DateHelper
    *@param pattern truyền vào kiểu
    *return trả về date kiểu DateHelper
     */
    public static java.util.Date toDate(String date, String... pattern) {
        try {
            if (pattern.length > 0) {
                DATE_FORMATER.applyPattern(pattern[0]);
            }
            if (date == null) {
                return DateHelper.now();
            }
            return DATE_FORMATER.parse(date);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }
}
