package Main.util;

import Main.base.TestBase;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;


import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestUtil extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 20;
    public static String TESTDATA_SHEET_PATH = "Main/testdata/FreeCrmTestData.xlsx";
    static Workbook book;
    static Sheet sheet;

    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }




    public void switchToFrame(){
        driver.switchTo().frame("mainpanel");
    }


//
//
//    public static Object[][] getTestData(String sheetName){
//        FileInputStream file = null;
//        try{
//            file= new FileInputStream((TESTDATA_SHEET_PATH));
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        try{
//            book = WorkbookFactory.create(file);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        sheet = book.getSheet(sheetName);
//        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//        // System.out.println(sheet.getLastRowNum() + "--------" +
//        // sheet.getRow(0).getLastCellNum());
//        for (int i = 0; i < sheet.getLastRowNum(); i++) {
//            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
//                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
//                // System.out.println(data[i][k]);
//            }
//        }
//        return data;
//    }
//
//

}
