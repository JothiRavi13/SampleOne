package com.testng.dataprovider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class ExcelDataProvider {
	
	@DataProvider(name = "excelData")
	 public  Object[][] excelDataProvider() throws IOException {
		  Object[][] arrObj = dpMethod("C:\\Users\\HP\\eclipse-workspace\\TestNGPractice\\"
		  		+ "src\\test\\resources\\testngtestdata.xlsx","Sheet1");
	        return arrObj;
	}
	
	public String[][] dpMethod(String a,String b) throws IOException{
		String [] [] data =null;
		
		 FileInputStream fis = new FileInputStream(a);
         XSSFWorkbook workbook = new XSSFWorkbook(fis);
         XSSFSheet sheet = workbook.getSheet(b);
         XSSFRow row = sheet.getRow(0);
		 int noOfRows = sheet.getPhysicalNumberOfRows();
        int noOfCols = row.getLastCellNum();
        Cell cell;
        data = new String[noOfRows - 1][noOfCols];

        for (int i = 1; i < noOfRows; i++) {
            for (int j = 0; j < noOfCols; j++) {
                row = sheet.getRow(i);
                cell = row.getCell(j);
                data[i - 1][j] = cell.getStringCellValue();
            }
		
	}
        return data;
      
	}
	@Test(dataProvider = "excelData")
	  public void sampleOne(String a) {
		System.out.println(a);
	}
	   

	
}

