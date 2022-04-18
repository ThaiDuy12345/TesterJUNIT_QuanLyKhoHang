package JunitTest;

public class testCase {


    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInputData() {
        return inputData;
    }

    public void setInputData(String inputData) {
        this.inputData = inputData;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    private int iD;
    private String category;
    private String description;
    private String inputData;
    private String expectedResult;
    public testCase() {
    }



    public testCase(int iD, String category, String description, String inputData, String expectedResult) {
        this.iD = iD;
        this.category = category;
        this.description = description;
        this.inputData = inputData;
        this.expectedResult = expectedResult;
    }


}
