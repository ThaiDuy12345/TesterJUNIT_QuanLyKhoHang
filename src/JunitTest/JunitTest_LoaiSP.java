package JunitTest;

import Model.LoaiSP;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.AfterClass;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JunitTest_LoaiSP {
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

    //ID_LoaiSanPham

    //Test description: Nhập vào không phải giá trị số
    //Test input data: "soNeBa"
    //Text expected result: Hàm trả về giá trị -1
    @Test
    public void Test1_LoaiSP() throws Exception{
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            LoaiSP object = new LoaiSP();
            object.setID(Integer.parseInt(String.valueOf(input)));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(object.getID()), helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi exception", helper.equals(col)});
        }
        col++;
    }
    //Test description: Nhập vào giá trị nhỏ hơn 1
    //Test input data: -10
    //Text expected result: Hàm trả về giá trị -1

    @Test
    public void Test2_LoaiSP() throws Exception{
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            LoaiSP object = new LoaiSP();
            object.setID(Integer.parseInt(String.valueOf(input)));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(object.getID()), helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi exception", helper.equals(col)});
        }
        col++;
    }
    //Test description: Nhập vào giá trị vừa chữ vừa số
    //Test input data: âm 10
    //Text expected result: Hàm trả về giá trị -1

    @Test
    public void Test3_LoaiSP() throws Exception{
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            LoaiSP object = new LoaiSP();
            object.setID(Integer.parseInt(String.valueOf(input)));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(object.getID()),helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi exception",helper.equals(col)});
        }
        col++;
    }
    //Test description: Nhập vào đúng giá trị số
    //Test input data: 15
    //Text expected result: Hàm không trả về giá trị -1

    @Test
    public void Test4_LoaiSP() throws Exception{
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            LoaiSP object = new LoaiSP();
            object.setID(Integer.parseInt(String.valueOf(input)));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(object.getID()),helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi exception",helper.equals(col)});
        }
        col++;
    }
    //LoaiSP_LoaiSanPham

    //Test description: Nhập giá trị loại sản phẩm có chứa số
    //Test input data: Dệt may 15
    //Text expected result: Hàm trả về giá trị null
    @Test
    public void Test5_LoaiSP(){
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            LoaiSP object = new LoaiSP();
            object.setLoaiSP(String.valueOf(input));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(object.getLoaiSP()),helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi exception",helper.equals(col)});
        }
        col++;
    }

    //Test description: Nhập giá trị loại sản phẩm toàn chữ thường
    //Test input data: dệt may
    //Text expected result: Hàm trả về giá trị null
    @Test
    public void Test6_LoaiSP(){
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            LoaiSP object = new LoaiSP();
            object.setLoaiSP(String.valueOf(input));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(object.getLoaiSP()),helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi exception",helper.equals(col)});
        }
        col++;
    }

    //Test description: Nhập giá trị loại sản phẩm có ký tự đặc biệt
    //Test input data: Dệt may 15
    //Text expected result: Hàm trả về giá trị null
    @Test
    public void Test7_LoaiSP(){
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            LoaiSP object = new LoaiSP();
            object.setLoaiSP(String.valueOf(input));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(object.getLoaiSP()),helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi exception",helper.equals(col)});
        }
        col++;
    }

    //Test description: Nhập giá trị loại sản phẩm có chữ cái viết hoa ở giữa
    //Test input data: DỆt may
    //Text expected result: Hàm trả về giá trị null
    @Test
    public void Test8_LoaiSP(){
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            LoaiSP object = new LoaiSP();
            object.setLoaiSP(String.valueOf(input));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(object.getLoaiSP()),helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi exception",helper.equals(col)});
        }
        col++;
    }

    //Test description: Nhập giá trị loại sản phẩm hợp lệ
    //Test input data: Dệt May
    //Text expected result: Hàm không trả về giá trị null
    @Test
    public void Test9_LoaiSP(){
        int id = numbers[index++];
        testCase ts = list.get(id);
        Object input = ts.getInputData();
        Object expected = helper.convert(ts.getExpectedResult(), input);
        try {
            LoaiSP object = new LoaiSP();
            object.setLoaiSP(String.valueOf(input));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), expected, object.getLoaiSP(),helper.equals(col)});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), expected, "Lỗi exception",helper.equals(col)});
        }
        col++;
    }
}
