package JunitTest;

import Model.LoaiSP;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
//Dòng Annotations này dùng để khiến các @Test chạy theo thứ tự sắp xếp theo "Tên"
//Nên đánh số test theo kiểu "Test1_KhachHang, Test2_KhachHang"
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class templateTest {
    //Chuẩn bị biến toàn cục nạp file excel để ghi ra
    public static HSSFWorkbook workbook;
    public static HSSFSheet sheet;
    public static Map<String, Object[]> TestNGResult;
    //Biến col dùng để chỉ định các Row trong Excel
    public static int col = 1;
    //Biến index dùng để chỉ định thứ tự phần tử con trong mảng Number, vd: index = 0; numbers[index] -> đối tượng chứa nội dung test
    public static int index = 0;
    //Array chứa dữ liệu data từ excel
    public static ArrayList<testCase> list;
    //Mảng chứa các tham số, cụ thể chỉ định ID trong list;
    public static int numbers[];
    //61, 62 ,63 ,64 ,65 ,66 ,67, 68, 69


    //SetUp tiêu đề
    @BeforeClass
    public static void suiteSetUp() {
        try {
            workbook = new HSSFWorkbook();
            sheet = workbook.createSheet("TestNG Result Summary");
            TestNGResult = new LinkedHashMap<String, Object[]>();
            TestNGResult.put(String.valueOf(col), new Object[]{"ID TestCase", "Đánh số", "Danh mục", "Mô tả","Dữ liệu đầu vào", "Kết quả dự đoán", "Kết quả thực tế"});
            col++;
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    //Ghi các kết quả lên excel
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
                if (obj instanceof Date)
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
    }
    //test
    @Test
    public void Test1_LoaiSP_ExampleTest() throws Exception {
        int id = numbers[index++];//Lấy con số ID cụ thể của testcase
        testCase ts = list.get(id);//truy vấn phần tự có chứa nội dung test trong list
        Object input = ts.getInputData();//Lấy dữ liệu đầu vào
        Object expected = helper.convert(ts.getExpectedResult(), input);//Lấy dữ liệu kết quả dự đoán
        try {
            //test
            LoaiSP object = new LoaiSP();
            object.setID(Integer.parseInt(String.valueOf(input)));
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), String.valueOf(object.getID())});
        }catch(Exception e){
            TestNGResult.put(String.valueOf(col), new Object[]{String.valueOf(ts.getiD()+10), String.valueOf(id), ts.getCategory(), ts.getDescription(),String.valueOf(input), String.valueOf(expected), "Lỗi exception"});
        }
        col++;
    }
}
