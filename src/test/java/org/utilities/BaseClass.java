package org.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static void initialization() 
	{
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	}
	public static void loadurl(String url) 
	{
		driver.get(url);

	}
	public static void winmax() 
	{
		driver.manage().window().maximize();

	}
	public static void printtitle()
	{
		String title = driver.getTitle();
		System.out.println(title);
	}
	public static void printcurnturl() 
	{
		System.out.println(driver.getCurrentUrl());

	}
	public static void fill(WebElement ele, String value ) 
	{
		ele.sendKeys(value);

	}
	public static void btnclick(WebElement login)
	{
		login.click();

	}
	public static String getData(int rowNumber, int cellNumber ) throws IOException 
	{
       File f=new File("C:\\Users\\manikandan\\eclipse-workspace\\FrameWork\\TestData\\Mani.xlsx");
		
		FileInputStream fine=new FileInputStream(f);
		
		Workbook w=new XSSFWorkbook(fine);
		
		Sheet s = w.getSheet("Mani");
		
		Row row = s.getRow(rowNumber);
		
		Cell cell = row.getCell(cellNumber);
		
		int cellType = cell.getCellType();
		
		
		String value="";
		if (cellType==1) 
		{	
		value = cell.getStringCellValue();	 			
		}
		else if (cellType==0) 
		{
		if (DateUtil.isCellDateFormatted(cell)) 
		{		
		Date d = cell.getDateCellValue();
				
		SimpleDateFormat sim=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		value = sim.format(d);				
		}
		else 
		{
		double d = cell.getNumericCellValue();
		long l=(long)d;
		value = String.valueOf(l);			
		}	
		}
		
		return value;		
	}
	
   	 public static void CloseBrowserChrome() {
		driver.close();

	}
    
    	public static String titleReturn() {
		String title = driver.getTitle();
		return title;
	}
    
   	public static void screenshot(String name) throws IOException  {
    	
    		TakesScreenshot tk=(TakesScreenshot)driver;
    	
    		File src = tk.getScreenshotAs(OutputType.FILE);
    	
    		File des= new File("C:\\Users\\manikandan\\eclipse-workspace\\CucumberDemo\\target\\screenshot\\name+");
    	
    		FileUtils.copyFile(src, des);	
	}
   	public static void jsScrollToView(WebElement element, WebDriver driver) {
	   
	   JavascriptExecutor js=(JavascriptExecutor) driver;
	   js.executeScript("arguments[0].scrollIntoView(true);", element);	   
   }   
}
