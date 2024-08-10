package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;

public class BaseClass {
public static WebDriver dr;
	@BeforeTest
	public static void openBrowser() {
		try {
			dr = new ChromeDriver();
			dr.get("https://adactinhotelapp.com/");
			dr.manage().window().maximize();
			
		}catch(Exception e) {
			e.getMessage();
		
		}
	}
	public static void input(WebElement c, String b) {
		c.sendKeys(b);
	}
	public static void click(WebElement a) {
		a.click();
	}
	public static void clear(WebElement a) {
		a.clear();
	}
	public static String getAttr(WebElement a, String b) {
		
		String c =a.getAttribute(b);
		return c;
	}
	public static String propertyRead(String value) {
		String data ="null";
		try {
		FileReader ff = new FileReader(new File("C:\\Users\\HP\\eclipse-workspace\\POMAdactin\\src\\test\\"
				+ "resources\\TestData\\config.properties"));
		Properties prop = new Properties();
		  prop.load(ff);
		  data =prop.getProperty(value);
		  
		  
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return data;
	}
		public static String excelRead(int i,int j) {
			String data ="null";
			try {
				File ff = new File("C:\\Users\\HP\\eclipse-workspace\\POMAdactin\\"
						+ "src\\test\\resources\\TestData\\Data.xlsx");
				FileInputStream fis = new FileInputStream(ff);
				Workbook wb =new XSSFWorkbook(fis);
				Sheet sh = wb.getSheet("Sheet1");
				Row r = sh.getRow(i);
				Cell cc = r.getCell(j);
				int ct =cc.getCellType();
				if(ct==1) {
					data = cc.getStringCellValue();
				}else if(ct==0) {
					if(DateUtil.isCellDateFormatted(cc)) {
						Date dd = cc.getDateCellValue();
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						data =sdf.format(dd);
					}else {
						double numericCellValue = cc.getNumericCellValue();
						long l = (long) numericCellValue;
						data = String.valueOf(l);
					}
				}
				}catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
			return data;
		}
		public static void byVisibleText(WebElement b,String a) {
			Select ss = new Select(b);
			
			ss.selectByVisibleText(a);
		}
		public static String dateFormat() {
			String a = "";
			try {
			Date dd= new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss");
			a= sdf.format(dd);
			}catch(Exception e) {
				e.getMessage();		
			}
			return a;
		}
		
		public static void pageScreenshot() {
			File src=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
			File des = new File ("./Screenshots"+dateFormat()+".png");
				try {
				FileHandler.copy(src, des);
			}catch(Exception e) {
				e.getMessage();		
			}
		}
	

}
