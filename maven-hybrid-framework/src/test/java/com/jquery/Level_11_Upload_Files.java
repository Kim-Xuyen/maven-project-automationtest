package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.uploadFile.HomePageObject;
import pageObjects.jQuery.uploadFile.PageGeneratorManager;

public class Level_11_Upload_Files extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	String f1FileName = "f1.jpg";
	String f2FileName = "f2.jpg";
	String f3FileName = "f3.jpg";
	String summerFileName = "summer.jpg";
	String[] multipleFileNames = { f1FileName, f3FileName, summerFileName };

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Upload_01_One_File_Per_Time() {
		homePage.uploadMultipleFiles(driver, f2FileName);
		Assert.assertTrue(homePage.isFileLoadedByName(f2FileName));

		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(f2FileName));
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(f2FileName));
	}

	@Test
	public void Upload_02_Multiple_File_Per_Time() {
		homePage.refreshCurrentPage(driver);
		homePage.uploadMultipleFiles(driver, multipleFileNames);
		Assert.assertTrue(homePage.isFileLoadedByName(f1FileName));
		Assert.assertTrue(homePage.isFileLoadedByName(f3FileName));
		Assert.assertTrue(homePage.isFileLoadedByName(summerFileName));

		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(f1FileName));
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(f3FileName));
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(summerFileName));

		Assert.assertTrue(homePage.isFileImageUpLoadedByName(f1FileName));
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(f3FileName));
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(summerFileName));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
