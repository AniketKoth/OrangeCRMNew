package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long IMPLICIT_WAIT = 10;
	public static long PAGE_LOAD_TIMEOUT = 20;
	
	public static String path = "/Users/aniketkothawade/eclipse-workspace/FreeCRMTest/src/main/java/com/crm/qa/testdata/OrangeHRMTestData.xlsx";
	
	static Workbook workBook = null;
	static Sheet sheet;
	
	public void switchToFrame() {
		driver.switchTo().frame("mainframe");
	}
	
	public static Object[][] getTestData(String sheetName){
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(path);
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
		try {
			workBook = WorkbookFactory.create(fis);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		sheet = workBook.getSheet(sheetName);
		
		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		
		return data;
	}
	
	public static void getScreenshotAtEnd() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir");
		FileUtils.copyFile(src, new File(path+ "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

}
