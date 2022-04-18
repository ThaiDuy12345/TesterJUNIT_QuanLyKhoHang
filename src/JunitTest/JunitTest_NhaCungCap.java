package JunitTest;

import Model.NhaCungCap;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;
public class JunitTest_NhaCungCap {
    public static HSSFWorkbook workbook;
    public static HSSFSheet sheet;
    public static Map<String, Object[]> TestNGResult;
    public static int col = 1;
    public static int index = 0;
    public static ArrayList<testCase> list;
    public static int numbers[];
    @BeforeClass
    public static void suiteSetUp() {
        try {
            workbook = new HSSFWorkbook();
            sheet = workbook.createSheet("TestNG Result Summary");
            TestNGResult = new LinkedHashMap<String, Object[]>();
            TestNGResult.put(String.valueOf(col), new Object[]{"ID TestCase", "Đánh số", "Danh mục", "Mô tả","Dữ liệu đầu vào", "Kết quả dự đoán", "Kết quả thực tế", "Tình trạng"});
            col++;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void suiteTearDown() {
        Set<String> keyset = TestNGResult.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = TestNGResult.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj.toString().contains("IF"))
                    cell.setCellFormula(String.valueOf(obj));
                else if (obj instanceof Date)
                    cell.setCellValue((Date) obj);
                else if (obj instanceof Boolean)
                    cell.setCellValue((Boolean) obj);
                else if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Double)
                    cell.setCellValue((Double) obj);

            }
        }
        try {
            FileOutputStream out = new FileOutputStream(new File("SaveTestNGResultToExcel.xls"));
            workbook.write(out);
            out.close();
            System.out.println("SuccessFully saved Selinium WebDriver TestNG result to Excel File!!!");

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }
    };



    //MaNCC_NhaCungCap

    //Test description: "Mã được nhập đúng định dạng(2 hoặc 3 chữ cái đầu
    //và sau đó là dãy số)"
    //Test input data: AB33425
    //Text expected result: Hàm không trả về giá trị null
    @Test
    public void Test1_NhaCungCap(){
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
        NhaCungCap object = new NhaCungCap();
        object.setMaNCC(String.valueOf(input));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(object.getMaNCC()), helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi exception", helper.equals(col)});
        }
        col++;
    }

    //Test description: "Nhập sai định dạng (Tất cả ký tự là chữ hoặc
    //tất cả ký tự là số"
    //Test input data: ABCCSS
    //Text expected result: Hàm trả về giá trị null
    @Test
    public void Test2_NhaCungCap(){
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            NhaCungCap object = new NhaCungCap();
            object.setMaNCC(String.valueOf(input));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(object.getMaNCC()), helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi exception", helper.equals(col)});
        }
    }

    //Test description: Nhập số trước và chữ sau
    //Test input data: 23ABDGS
    //Text expected result: Hàm trả về giá trị null
    @Test
    public void Test3_NhaCungCap(){
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            NhaCungCap object = new NhaCungCap();
            object.setMaNCC(String.valueOf(input));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(object.getMaNCC()), helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi exception", helper.equals(col)});
        }
        col++;
    }

    //Test description: Nhập kí tự đặc biệt
    //Test input data: AB@3*2
    //Text expected result: Hàm trả về giá trị null
    @Test
    public void Test4_NhaCungCap(){
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            NhaCungCap object = new NhaCungCap();
            object.setMaNCC(String.valueOf(input));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(object.getMaNCC()), helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi exception", helper.equals(col)});
        }
        col++;
    }

    //Test description: Nhập không đủ 2-3 chữ cái ở đầu và sau đó nhập số
    //Test input data: A123455
    //Text expected result: Hàm trả về giá trị null
    @Test
    public void Test5_NhaCungCap(){
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            NhaCungCap object = new NhaCungCap();
            object.setMaNCC(String.valueOf(input));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(object.getMaNCC()), helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi exception", helper.equals(col)});
        }
        col++;
    }

    //Test description: Nhập 2 hoặc 3 chữ cái thường và sau đó là dãy số
    //Test input data: ab12345
    //Text expected result: Hàm trả về giá trị null
    @Test
    public void Test6_NhaCungCap(){
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            NhaCungCap object = new NhaCungCap();
            object.setMaNCC(String.valueOf(input));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(object.getMaNCC()), helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi exception", helper.equals(col)});
        }
        col++;
    }

    //SDT_NhaCungCap

    //Test description: "Nhập vào toàn số từ 10-11 số và 3 chữ số đầu phải thuộc
    //nhà mạng được đăng ký"
    //Test input data: 0912571469
    //Text expected result: Hàm không trả về giá trị null
    @Test
    public void Test7_NhaCungCap(){
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            NhaCungCap object = new NhaCungCap();
            object.setSDT(String.valueOf(input));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(object.getSDT()), helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi exception", helper.equals(col)});
        }
        col++;
    }

    //Test description: Nhập vào toàn chữ
    //Test input data: ABCGDHSHJD
    //Text expected result: Hàm trả về giá trị null
    @Test
    public void Test8_NhaCungCap(){
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            NhaCungCap object = new NhaCungCap();
            object.setSDT(String.valueOf(input));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(object.getSDT()), helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi exception", helper.equals(col)});
        }
        col++;
    }

    //Test description: Nhập vào vừa chữ vừa số
    //Test input data: ABC2571DDS
    //Text expected result: Hàm trả về giá trị null
    @Test
    public void Test9_NhaCungCap(){
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            NhaCungCap object = new NhaCungCap();
            object.setSDT(String.valueOf(input));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(object.getSDT()), helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi exception", helper.equals(col)});
        }
        col++;
    }

    //Test description: Nhập vào ký tự đặc biệt
    //Test input data: 091257149@@0
    //Text expected result: Hàm trả về giá trị null
    @Test
    public void Test10_NhaCungCap(){
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            NhaCungCap object = new NhaCungCap();
            object.setSDT(String.valueOf(input));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(object.getSDT()), helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi exception", helper.equals(col)});
        }
        col++;
    }

    //Test description: "Nhập vào toàn số từ 10-11 số và 3 chữ số đầu không thuộc
    //nhà mạng được đăng ký"
    //Test input data: 1111957462
    //Text expected result: Hàm trả về giá trị null
    @Test
    public void Test11_NhaCungCap(){
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            NhaCungCap object = new NhaCungCap();
            object.setSDT(String.valueOf(input));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(object.getSDT()), helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi exception", helper.equals(col)});
        }
        col++;
    }

    //Test description: Không đủ số được yêu cầu nhập vào từ 10-11 số
    //Test input data: 1
    //Text expected result: Hàm trả về giá trị null
    @Test
    public void Test12_NhaCungCap_SDT(){
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            NhaCungCap object = new NhaCungCap();
            object.setSDT(String.valueOf(input));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(object.getSDT()), helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi exception", helper.equals(col)});
        }
        col++;
    }

    //Email_NhaCungCap

    //Test description: Nhập vào đúng định dạng email
    //Test input data: brand@gmail.com
    //Text expected result: Hàm không trả về giá trị null

    @Test
    public void Test13_NhaCungCap_Email(){
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            NhaCungCap object = new NhaCungCap();
            object.setEmail(String.valueOf(input));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(object.getEmail()), helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi exception", helper.equals(col)});
        }
        col++;
    }

    //Test description: Nhập sai định dạng email
    //Test input data: brand
    //Text expected result: Hàm trả về giá trị null

    @Test
    public void Test14_NhaCungCap(){
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            NhaCungCap object = new NhaCungCap();
            object.setEmail(String.valueOf(input));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(object.getEmail()), helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi exception", helper.equals(col)});
        }
        col++;
    }

    //Test description: Nhập vào địa chỉ email không có @
    //Test input data: brandgmail.com
    //Text expected result: Hàm trả về giá trị null

    @Test
    public void Test15_NhaCungCap(){
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            NhaCungCap object = new NhaCungCap();
            object.setEmail(String.valueOf(input));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(object.getEmail()), helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi exception", helper.equals(col)});
        }
        col++;
    }

    //Test description: Trước @ không có ký tự nào được nhập vào
    //Test input data: @gmail.com
    //Text expected result: Hàm trả về giá trị null

    @Test
    public void Test16_NhaCungCap(){
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            NhaCungCap object = new NhaCungCap();
            object.setEmail(String.valueOf(input));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(object.getEmail()), helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi exception", helper.equals(col)});
        }
        col++;
    }

    //Test description: Sau @ không có ký tự nào được nhập vào
    //Test input data: brand@
    //Text expected result: Hàm trả về giá trị null

    @Test
    public void Test17_NhaCungCap(){
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            NhaCungCap object = new NhaCungCap();
            object.setEmail(String.valueOf(input));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(object.getEmail()), helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi exception", helper.equals(col)});
        }
        col++;
    }

    //Test description: Nhập vào địa chỉ email có nhiều hơn 1 @
    //Test input data: brand@@@gmail.com
    //Text expected result: Hàm trả về giá trị null

    @Test
    public void Test18_NhaCungCap(){
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            NhaCungCap object = new NhaCungCap();
            object.setEmail(String.valueOf(input));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(object.getEmail()), helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi exception", helper.equals(col)});
        }
        col++;
    }
}
