package org.Stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.utilities.BaseClass;
import org.utilities.POM;

import cucumber.api.java.en.*;

public class CoinMarketCap extends BaseClass  {
	
	 POM pom = new POM(driver);
	 public String Arr[];
	 
	 List<String> all_elements_text=new ArrayList<>();
	 List<String> finalResult=new ArrayList<>();
	 
	
//	public POM POM;
	
	@Given("The user should launch the browser")
	public void theUserShouldLaunchTheBrowser() {
		initialization();
	}


	@When("The user should load the url")
	public void theUserShouldLoadTheUrl() {
		loadurl("https://coinmarketcap.com");
	    winmax();
	    pom.jsclick(pom.popHandle1,driver);
	    pom.jsclick(pom.popHandle2,driver);
	}

	@When("The user should select the chart in to list of {string}")
	public void theUserShouldSelectTheChartInToListOf(String int1) throws InterruptedException {
		pom.jsclick(pom.dropDown, driver);
		Thread.sleep(3000);
		WebElement dropDownValue = driver.findElement(By.xpath("//div[@class='sc-aef7b723-0 sc-f84d4cca-0 ezlhyG dropdown-container']//button[text()='"+int1+"']"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", dropDownValue);
	    pom.jsclick(pom.showRow,driver);
	
	}

	@When("The user should filter by {string}")
	public void theUserShouldFilterByAlgoPow(String Value) throws InterruptedException {
		Thread.sleep(4000);
//	   WebElement algorithmPow = driver.findElement(By.xpath("//li[@class='filter']//button[text()='Algorithm']//span"));
	   pom.jsclick(pom.algorithmPow,driver);
	   pom.selectValueFromDropDown(Value);
	}
	@When("The user should capture the information from table")
	public void theUserShouldCaptureTheInformationFromTable() {
		pom.elementVisible(pom.name, driver);
	}

	@When("The user should click on addfilter")
	public void theUserShouldClickOnAddfilter() throws InterruptedException {
	
		Thread.sleep(5000);
		WebElement filterBtn = driver.findElement(By.xpath("//div[@class='sc-319be8a1-5 feBTJO']//button[text()='Filters']"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", filterBtn);
		   
	}
	

	@When("The user should click on toggle mineable")
	public void theUserShouldClickOnToggleMineable() {
	    // Write code here that turns the phrase above into concrete actions
		pom.jsclick(pom.AddFilter,driver);
		 pom.jsclick(pom.minableToggle,driver);
	}

	@When("The user should be select all Cryptocurrencies")
	public void theUserShouldBeSelectAllCryptocurrencies() {
	    // Write code here that turns the phrase above into concrete actions
		pom.forceClick(pom.AllCryptoDropDown,driver);
		
	}

	@When("The user should be select coins")
	public void theUserShouldBeSelectCoins() throws InterruptedException {
		pom.forceClick(pom.Coins,driver);
	}

	@When("The user should be select price and set min value")
	public void theUserShouldBeSelectPriceAndSetMinValueTo() throws InterruptedException {
		pom.jsclick(pom.Price,driver);
		pom.enterValues(pom.minPrice, "100", driver);
		pom.enterValues(pom.maxPrice, "10000", driver);
		pom.jsclick(pom.ApplyFilter,driver);
		pom.jsclick(pom.ShowResult,driver);
	}

	@When("The user should compare price name and position")
	public void theUserShouldComparePriceNameAndPosition() {
	    // Write code here that turns the phrase above into concrete actions
//		finalResult =  pom.getListResult(pom.nam);
//	    all_elements_text.contains(finalResult);
		pom.elementVisible(pom.name, driver);
	}

	@Then("The user should close the browser")
	public void theUserShouldCloseTheBrowser() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	
	

}
