package JunitTest;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class readFileExcel {
    //Các thư viện cần add vào
    //poi.jar
    //poi ooxml.jar
    //log4j 2.0.jar
    //xmls bean.jar
    //common collection apache.jar
    //common compress.jar
    //poi-ooxml-lite-5.2.2
    public static ArrayList<testCase> readData() throws Exception{
        //Tạo File input
        FileInputStream inputStream = new FileInputStream(new File("D:\\Saving\\KiemThuNangCao\\QuanLyKhoHang\\TestCase_QuanLyKhoHang.xlsx"));
        //Chỉ định là file excel
        Workbook workbook = new XSSFWorkbook(inputStream);
        //Chỉ định sheet thứ 2 của excel
        Sheet sheet = workbook.getSheetAt(1);
        //hàm này để lưu hết các dữ liệu lấy từ excel thành hàm string bất kể là kiểu dữ liệu gì
        DataFormatter formatter = new DataFormatter();
        //Chỉ định dòng
        Iterator<Row> rowIterator = sheet.iterator();
        ArrayList<testCase> list = new ArrayList<>();
        //Skip 10 hàng đầu của trang
        int id = 0;
        for(int i = 0; i <9;i++){
            rowIterator.next();
        }
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            //Lấy dữ liệu các cột "Danh mục", "Mô tả", "Dữ liệu đầu vào", "Kết quả dự đoán"
            String Category = formatter.formatCellValue(row.getCell(1));
            String Description = formatter.formatCellValue(row.getCell(2));
            String InputData = formatter.formatCellValue(row.getCell(3));
            String ExpectedResult = formatter.formatCellValue(row.getCell(4));

            //Nếu như dòng tiếp theo tất cả các phần tử có giá trị trống -> break;
            if(Category.equals("") && Description.equals("") && InputData.equals("") && ExpectedResult.equals("")){
                break;
            }else{
                testCase ts = new testCase(id++, Category,Description,InputData,ExpectedResult);
                list.add(ts);
            }
        }
        return list;
    }
}
