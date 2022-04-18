package JunitTest;

public class helper {
    //hàm chuyển kết quả dự đoán thành dạng cụ thể
    public static Object convert(String expected, Object input){
        if(expected.contains("Không") || expected.contains("Khác") || expected.contains("khác") || expected.contains("không")){
            if(expected.contains("null")){
                return String.valueOf(input);
            }else if(expected.contains("-1")){
                return 1;
            }else if(expected.contains("False") || expected.contains("false")){
                return true;
            }else{
                return false;
            }
        }else{
            if(expected.contains("null")){
                return null;
            }else if(expected.contains("-1")){
                return -1;
            }else if(expected.contains("False") || expected.contains("false")){
                return false;
            }else{
                return true;
            }
        }
    }

    public static String equals(int col){
        return "IF(G"+col+"=F"+col+", \"PASS\", \"FAIL\")";
    }
}
