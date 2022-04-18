package JunitTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;

public class mainClass {
    public static void main(String[] args){
        try{
            //Lấy dữ liệu testCase
            ArrayList<testCase> list = readFileExcel.readData();


            /*//------------------Authenticatior Test------------------
            //Nhập list data excel test qua class để chuyển bị test
            JunitTest_Authenticatior.list = list;
            //Tạo mảng các testcase cần test
            JunitTest_Authenticatior.numbers = new int[]{102, 103, 108, 109};
            */

            /*//------------------LoaiSP Test------------------
            //Nhập list data excel test qua class để chuyển bị test
            JunitTest_LoaiSP.list = list;
            //Tạo mảng các testcase cần test
            JunitTest_LoaiSP.numbers = new int[]{61, 62 ,63 ,64 ,65 ,66 ,67, 68, 69};
            */

            //------------------NhaCungCap Test------------------
            //Nhập list data excel test qua class để chuyển bị test
            JunitTest_NhaCungCap.list = list;
            //Tạo mảng các testcase cần test
            JunitTest_NhaCungCap.numbers = new int[]{70 ,71 ,72 ,73 ,74, 75, 76, 77, 78, 79 ,80, 81, 82 ,83 ,84 ,85, 86, 87};

            //-------------------Execute Test-------------------------
            Result rs = JUnitCore.runClasses(JunitTest_NhaCungCap.class);
            for(Failure failure : rs.getFailures()){
                System.out.println(failure.toString());
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
