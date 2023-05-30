package com.jquery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.dataTable.HomePageObject;
import pageObjects.jQuery.dataTable.PageGeneratorManager;

public class Level_10_DataTable_DataGrid extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	List<String> actualAllCountryValues;
	List<String> expectedlAllCountryValues;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	// @Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("10"));

		homePage.openPagingByPageNumber("5");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("5"));

		homePage.openPagingByPageNumber("17");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("17"));

		homePage.openPagingByPageNumber("9");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("9"));
	}

	// @Test
	public void Table_02_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);

		homePage.enterToHeaderTextboxByLabel("Females", "338282");
		homePage.enterToHeaderTextboxByLabel("Country", "Argentina");
		homePage.enterToHeaderTextboxByLabel("Males", "349238");
		homePage.enterToHeaderTextboxByLabel("Total", "687522");
		homePage.sleepInSecond(3);

		homePage.enterToHeaderTextboxByLabel("Females", "276880");
		homePage.enterToHeaderTextboxByLabel("Country", "Angola");
		homePage.enterToHeaderTextboxByLabel("Males", "276472");
		homePage.enterToHeaderTextboxByLabel("Total", "553353");
	}

	// @Test
	public void Table_03_Enter_To_Header() {
		actualAllCountryValues = homePage.getValueEachRowAtAllPage();
		Assert.assertEquals(actualAllCountryValues, expectedlAllCountryValues);
	}

	@Test
	public void Table_04_Enter_To_Textbox_At_Any_Row() {
		homePage.clickToLoadButton();
		homePage.sleepInSecond(2);
		homePage.enterToTextboxByColumnNameAtRowNumber("Contact Person", "1", "Michael 97");
		homePage.enterToTextboxByColumnNameAtRowNumber("Order Placed", "1", "Michael 97");
		homePage.enterToTextboxByColumnNameAtRowNumber("Company", "1", "Michael 97");

		homePage.selectDropdownByColumnNameAtRowNumber("Country", "2", "Malaysia");
		homePage.sleepInSecond(3);
		homePage.selectDropdownByColumnNameAtRowNumber("Country", "7", "Germany");
		homePage.sleepInSecond(3);
		homePage.selectDropdownByColumnNameAtRowNumber("Country", "5", "United Kingdom");
		homePage.sleepInSecond(3);

		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "2");
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "3");
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "6");
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "7");
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "8");

		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "1");
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "4");
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "5");

		homePage.clickToIconByRowNumber("1", "Remove Current Row");
		homePage.clickToIconByRowNumber("1", "Insert Row Above");
		homePage.clickToIconByRowNumber("3", "Move Up");

		homePage.clickToIconByRowNumber("8", "Remove Current Row");
		homePage.clickToIconByRowNumber("7", "Remove Current Row");
		homePage.clickToIconByRowNumber("6", "Remove Current Row");
		homePage.clickToIconByRowNumber("5", "Remove Current Row");
		homePage.clickToIconByRowNumber("4", "Remove Current Row");
		homePage.clickToIconByRowNumber("3", "Remove Current Row");
		homePage.clickToIconByRowNumber("2", "Remove Current Row");
		homePage.clickToIconByRowNumber("1", "Remove Current Row");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
