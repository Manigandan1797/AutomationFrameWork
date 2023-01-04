package org.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM extends BaseClass{
	
	public POM(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public String popHandle1 = "//*[@class='sc-aef7b723-0 fKbUaI close-button']";
	public String popHandle2 = "//div[contains(text(),'×')]";
	public String dropDown = "//div[@class='scroll-child']//p[normalize-space(text())='Show rows']//..//div[@class='sc-aef7b723-0 sc-dae82938-0 coScOT']";
	public String algorithmPow = "//li[@class='filter']//button[text()='Algorithm']//span";
	public String showRow = "//div[@class='scroll-child']//p[normalize-space(text())='Show rows']";	
	public String filterBtn = "//div[@class='sc-319be8a1-5 feBTJO']//button[text()='Filters']";
	public String AddFilter = "//button[text()='Add Filter']";
	public String minableToggle ="//label[@id='mineable']";
	public String AllCryptoDropDown ="//div//button[text()='All Cryptocurrencies']";
	public String Coins ="//div//button[text()='Coins']";
	public String Price ="//button[text()='Price']//div//*[@class='sc-aef7b723-0 dsDrxm']";
	public String minPrice ="//input[@data-qa-id='range-filter-input-min']";
	public String maxPrice ="//input[@data-qa-id='range-filter-input-max']";
	public String ApplyFilter ="//button[text()='Apply Filter']";
	public String ShowResult ="//button[text()='Show results']";
	public String actualName ="//td//a[@class='cmc-link']//p[@class='sc-e225a64a-0 ePTNty']";
	public String name ="//td//a[@class='cmc-link']//p[text()='Monero']";

		
	public void jsclick(String element,WebDriver driver) {	   
		driver.findElement(By.xpath(element)).click();
	   
	   }
	
	public void selectValueFromDropDown(String Value) {
		
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(Value);
		driver.findElement(By.xpath("//li[text()='"+Value+"']")).click();	
	}
	
	public void enterValues(String element,String value,WebDriver driver) {
		driver.findElement(By.xpath(element)).isDisplayed();
		driver.findElement(By.xpath(element)).click();
		driver.findElement(By.xpath(element)).sendKeys(value);;
	
		   
	   }
	public void forceClick(String element,WebDriver driver) {
		WebElement locator = driver.findElement(By.xpath(element));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", locator);
	   }
	public void getValueMethos(String Value) {
		
		String resultvalues = driver.findElement(By.xpath("//input[@placeholder='Search']")).getText();
	}

	public List<String> getListResult(String locator){
	       List<WebElement> myList= driver.findElements(By.xpath("//td//a[@class='cmc-link']//p[@class='sc-e225a64a-0 ePTNty']"));
	       List<String> all_elements_text=new ArrayList<>();
	       String[] values = null;
	       String text = "";
			 
			 for(WebElement element : myList ) {
				 text = element.getText();
				 values = text.split(" ");
				 System.out.println("result:"+values[0]+" length: "+values[0].length()); 
			 }
			 
			 return all_elements_text;   

			}
	public void elementVisible(String locator,WebDriver driver)
	{
	driver.findElement(By.xpath(locator)).isDisplayed();
	}
	
	}

			


