package JunitTest;
import static org.junit.Assert.*;
import Help.Auth;
import Model.TaiKhoan;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JunitTest_Authenticatior {

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
            TestNGResult.put(String.valueOf(col), new Object[]{"ID TestCase", "Đánh số", "Danh mục", "Mô tả", "Dữ liệu đầu vào", "Kết quả dự đoán", "Kết quả thực tế", "Tình trạng"});
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
    //Authenticator

    //Test_Description: vai trò đầu vào không phải là quản lý;
    //Test_Data Input: 1;
    //Test_Expected: Hàm trả về giá trị false;
    @Test
    public void Test1_Authenticatior(){
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            TaiKhoan account = new TaiKhoan();
            account.setVaiTro(Integer.parseInt(String.valueOf(input)));
            Auth.user = account;
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(), String.valueOf(input), String.valueOf(expected), String.valueOf(Auth.isManager()), helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id),ts.getCategory(), ts.getDescription(), String.valueOf(input), String.valueOf(expected), "Lỗi Exception", helper.equals(col)});
        }
        col++;
    }

    //Test_Description: vai trò đầu vào là quản lý;
    //Test_Data Input: 0;
    //Test_Expected: hàm trả về giá trị true
    @Test
    public void Test2_Authenticatior(){
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try{
            TaiKhoan account = new TaiKhoan();
            account.setVaiTro(Integer.parseInt(String.valueOf(input)));
            Auth.user = account;
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id),ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(Auth.isManager()), helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id),ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "lỗi Exception", helper.equals(col)});
        }
        col++;
    }

    //Test_Description: vai trò đầu vào không phải là nhân viên kho;
    //Test_Data Input: 1;
    //Test_Expected: hàm trả về giá trị false
    @Test
    public void Test3_Authenticatior(){
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try{
            TaiKhoan account = new TaiKhoan();
            account.setVaiTro(Integer.parseInt(String.valueOf(input)));
            Auth.user = account;
            TestNGResult.put(String.valueOf(col), new Object[] {  String.valueOf(ts.getiD()+10), String.valueOf(id),ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(Auth.isEmployeeWareHouse()), helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[] { String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "lỗi Exception",helper.equals(col) });
        }
        col++;
    }

    //Test_Description: vai trò đầu vào là nhân viên kho;
    //Test_Data Input: 2;
    //Test_Expected: hàm trả về giá trị true
    @Test
    public void Test4_Authenticatior(){
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            TaiKhoan account = new TaiKhoan();
            account.setVaiTro(Integer.parseInt(String.valueOf(input)));
            Auth.user = account;
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id),ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(Auth.isEmployeeWareHouse()), helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id),ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi Exception", helper.equals(col)});
        }
        col++;
    }

}

