package JunitTest;
import Help.ValidateHelper;
import org.junit.Test;

import javax.swing.*;
import Help.ValidateHelper;
import static org.junit.Assert.*;
public class JunitTest_ValidateHelper {
    //ValidateNhaCC


    //Test_Description: "Mã được nhập đúng định dạng(2 hoặc 3 chữ cái đầu
    //và sau đó là dãy số)"
    //Test_Input: AB33425
    //Test_Expected: Hàm trả về giá trị true
    @Test
    public void Test1_ValidateHelper_ValidateNhaCC(){
        String input = "AB33425";
        JTextField txt = new JTextField();
        txt.setText(input);
        assertEquals(true, ValidateHelper.ValidateNhaCc(txt));
    }

    //Test_Description: "Nhập sai định dạng (Tất cả ký tự là chữ hoặc
    //tất cả ký tự là số)"
    //Test_Input: ABCCSS
    //Test_Expected: Hàm trả về giá trị false
    @Test
    public void Test2_ValidateHelper_ValidateNhaCC(){
        String input = "ABCCSS";
        JTextField txt = new JTextField();
        txt.setText(input);
        assertEquals(false, ValidateHelper.ValidateNhaCc(txt));
    }

    //Test_Description: Nhập số trước và chữ sau
    //Test_Input: 23ABDGS
    //Test_Expected: Hàm trả về giá trị false
    @Test
    public void Test3_ValidateHelper_ValidateNhaCC(){
        String input = "23ABDGS";
        JTextField txt = new JTextField();
        txt.setText(input);
        assertEquals(false, ValidateHelper.ValidateNhaCc(txt));
    }

    //Test_Description: Nhập kí tự đặc biệt
    //Test_Input: AB@3*2
    //Test_Expected: Hàm trả về giá trị false
    @Test
    public void Test4_ValidateHelper_ValidateNhaCC(){
        String input = "AB@3*2";
        JTextField txt = new JTextField();
        txt.setText(input);
        assertEquals(false, ValidateHelper.ValidateNhaCc(txt));
    }

    //Test_Description: Nhập không đủ 2-3 chữ cái ở đầu và sau đó nhập số
    //Test_Input: A123455
    //Test_Expected: Hàm trả về giá trị false
    @Test
    public void Test5_ValidateHelper_ValidateNhaCC(){
        String input = "A123455";
        JTextField txt = new JTextField();
        txt.setText(input);
        assertEquals(false, ValidateHelper.ValidateNhaCc(txt));
    }

    //Test_Description: Nhập 2 hoặc 3 chữ cái thường và sau đó là dãy số
    //Temst_Input: ab12345
    //Test_Expected: Hàm trả về giá trị false
    @Test
    public void Test6_ValidateHelper_ValidateNhaCC(){
        String input = "ab12345";
        JTextField txt = new JTextField();
        txt.setText(input);
        assertEquals(false, ValidateHelper.ValidateNhaCc(txt));
    }

    //ValidatePass

    //Test_Description: Nhập vào tổng số ký tự bé hơn 2
    //Test_Input Data: o
    //Test_Expected: Hàm trả về giá trị false
    @Test
    public void Test7_ValidateHelper_ValidatePass(){
        String input = "o";
        JPasswordField txt = new JPasswordField();
        txt.setText(input);
        assertEquals(false, ValidateHelper.ValidatePass(txt));
    }

    //Test_Description: Nhập vào tổng số ký tự lớn hơn 26
    //Test_Input Data: anhbalabanhbacotcheocheoquachlknejkosao
    //Test_Expected: Hàm trả về giá trị false
    @Test
    public void Test8_ValidateHelper_ValidatePass(){
        String input = "anhbalabanhbacotcheocheoquachlknejkosao";
        JPasswordField txt = new JPasswordField();
        txt.setText(input);
        assertEquals(false, ValidateHelper.ValidatePass(txt));
    }

    //Test_Description: Nhập vào tổng số ký tự trong khoảng 2 đến 26
    //Test_Input Data: okmatkhau
    //Test_Expected: Hàm trả về giá trị true
    @Test
    public void Test9_ValidateHelper_ValidatePass(){
        String input = "okmatkhau";
        JPasswordField txt = new JPasswordField();
        txt.setText(input);
        assertEquals(true, ValidateHelper.ValidatePass(txt));
    }

    //ValidateName

    //Test_Description: "Nhập vào đúng định dạng(Chữ cái đầu viết hoa và không
    // ký tự đặc biệt)"
    //Test_Input Data: Thái Duy
    //Test_Expected: Hàm trả về giá trị true
    @Test
    public void Test10_ValidateHelper_ValidateName(){
        String input = "Thái Duy";
        JTextField txt = new JTextField();
        txt.setText(input);
        assertEquals(true, ValidateHelper.ValidateName(txt));
    }

    //Test_Description: Ký tự nhập vào vừa chữ vừa số
    //Test_Input Data: Duy 14
    //Test_Expected: Hàm trả về giá trị false
    @Test
    public void Test11_ValidateHelper_ValidateName(){
        String input = "Duy 14";
        JTextField txt = new JTextField();
        txt.setText(input);
        assertEquals(false, ValidateHelper.ValidateName(txt));
    }

    //Test_Description: Chữ cái đầu không được viết hoa
    //Test_Input Data: duy Thái
    //Test_Expected: Hàm trả về giá trị false
    @Test
    public void Test12_ValidateHelper_ValidateName(){
        String input = "duy Thái";
        JTextField txt = new JTextField();
        txt.setText(input);
        assertEquals(false, ValidateHelper.ValidateName(txt));
    }

    //Test_Description: Nhập vào toàn chữ cái thường
    //Test_Input Data: duy thường
    //Test_Expected: Hàm trả về giá trị false
    @Test
    public void Test13_ValidateHelper_ValidateName(){
        String input = "Duy 14";
        JTextField txt = new JTextField();
        txt.setText(input);
        assertEquals(false, ValidateHelper.ValidateName(txt));
    }

    //Test_Description: Ký tự nhập vào vừa chữ vừa số
    //Test_Input Data: DUy Thường
    //Test_Expected: Hàm trả về giá trị false
    @Test
    public void Test14_ValidateHelper_ValidateName(){
        String input = "DUy Thường";
        JTextField txt = new JTextField();
        txt.setText(input);
        assertEquals(false, ValidateHelper.ValidateName(txt));
    }

    //CheckSoLuong

    //Test_Description: Nhập vào giá trị là số nguyên lớn hơn 0
    //Test_Input Data: 15
    //Test_Expected: Hàm trả về giá trị true
    @Test
    public void Test15_ValidateHelper_CheckSoLuong(){
        int input = 15;
        JTextField txt = new JTextField();
        txt.setText(String.valueOf(input));
        assertEquals(true, ValidateHelper.checkSoLuong(txt));
    }

    //Test_Description: Nhập giá trị là kiểu thập phân
    //Test_Input Data: 1.5
    //Test_Expected: Hàm trả về giá trị false
    @Test
    public void Test16_ValidateHelper_CheckSoLuong(){
        double input = 1.5;
        JTextField txt = new JTextField();
        txt.setText(String.valueOf(input));
        assertEquals(false, ValidateHelper.checkSoLuong(txt));
    }

    //Test_Description: Nhập giá trị vừa chữ vừa số
    //Test_Input Data: một chấm 5
    //Test_Expected: Hàm trả về giá trị false
    @Test
    public void Test17_ValidateHelper_CheckSoLuong(){
        String input = "một chấm 5";
        JTextField txt = new JTextField();
        txt.setText(String.valueOf(input));
        assertEquals(false, ValidateHelper.checkSoLuong(txt));
    }

    //Test_Description: Nhập giá trị có ký tự đặc biệt
    //Test_Input Data: 12##
    //Test_Expected: Hàm trả về giá trị false
    @Test
    public void Test18_ValidateHelper_CheckSoLuong(){
        String input = "12##";
        JTextField txt = new JTextField();
        txt.setText(String.valueOf(input));
        assertEquals(false, ValidateHelper.checkSoLuong(txt));
    }
}