package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_04_Multiple_Browser extends BaseTest {
	private WebDriver driverTestClass;
	private String firstName, lastName, emailAddress, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driverTestClass = getBrowserDriver(browserName);

		homePage = new UserHomePageObject(driverTestClass);
		firstName = "Automation";
		lastName = "FC";
		emailAddress = "abc" + generateFakeNumber() + "@mail.com";
		password = "123456";

	}

	@Test
	public void Register_01_Empty_Data() {
//		System.out.println("Register_01 - Step 01: Click to Register link");
//		homePage.clickToRegisterLink();
//
//		registerPage = new RegisterPageObject(driver);
//
//		System.out.println("Register_01 - Step 02: Click to Register button");
//		registerPage.clickToRegisterButton();
//
//		System.out.println("Register_01 - Step 03: Verify error message displayed");
//		Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
//		Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
//		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
//		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
//		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
//		System.out.println("Register_02 - Step 01: Click to Register link");
//		homePage.clickToRegisterLink();
//
//		registerPage = new RegisterPageObject(driver);
//
//		System.out.println("Register_02 - Step 02: Input to required fields");
//		registerPage.InputToFirstnameTextbox(firstName);
//		registerPage.InputToLastnameTextbox(lastName);
//		registerPage.InputToEmailTextbox("123@abc@#$");
//		registerPage.InputToPasswordTextbox(password);
//		registerPage.InputToConfirmPasswordTextbox(password);
//
//		System.out.println("Register_02 - Step 03: Click to Register button");
//		registerPage.clickToRegisterButton();
//
//		System.out.println("Register_02 - Step 04: Verify error message displayed");
//		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void Register_03_Success() {
//		System.out.println("Register_03 - Step 01: Click to Register link");
//		homePage.clickToRegisterLink();
//
//		registerPage = new RegisterPageObject(driver);
//
//		System.out.println("Register_03 - Step 02: Input to required fields");
//		registerPage.InputToFirstnameTextbox(firstName);
//		registerPage.InputToLastnameTextbox(lastName);
//		registerPage.InputToEmailTextbox(emailAddress);
//		registerPage.InputToPasswordTextbox(password);
//		registerPage.InputToConfirmPasswordTextbox(password);
//
//		System.out.println("Register_03 - Step 03: Click to Register button");
//		registerPage.clickToRegisterButton();
//
//		System.out.println("Register_03 - Step 04: Verify success message displayed");
//		Assert.assertEquals(registerPage.getSuccessMessage(), "Your registration completed");
//
//		System.out.println("Register_03 - Step 05: Click to Continue link");
//		registerPage.clickToContinueLink();
	}

	@Test
	public void Register_04_Existing_Email() {
//		System.out.println("Register_04 - Step 01: Click to Register link");
//		homePage.clickToRegisterLink();
//
//		registerPage = new RegisterPageObject(driver);
//
//		System.out.println("Register_04 - Step 02: Input to required fields");
//		registerPage.InputToFirstnameTextbox(firstName);
//		registerPage.InputToLastnameTextbox(lastName);
//		registerPage.InputToEmailTextbox(emailAddress);
//		registerPage.InputToPasswordTextbox(password);
//		registerPage.InputToConfirmPasswordTextbox(password);
//
//		System.out.println("Register_04 - Step 03: Click to Register button");
//		registerPage.clickToRegisterButton();
//
//		System.out.println("Register_04 - Step 04: Verify error existing email message displayed");
//		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
	}

	@Test
	public void Register_05_Password_Less_Than_6_Chars() {
//		System.out.println("Register_05 - Step 01: Click to Register link");
//		homePage.clickToRegisterLink();
//
//		registerPage = new RegisterPageObject(driver);
//
//		System.out.println("Register_05 - Step 02: Input to required fields");
//		registerPage.InputToFirstnameTextbox(firstName);
//		registerPage.InputToLastnameTextbox(lastName);
//		registerPage.InputToEmailTextbox(emailAddress);
//		registerPage.InputToPasswordTextbox("123");
//		registerPage.InputToConfirmPasswordTextbox("123");
//
//		System.out.println("Register_05 - Step 03: Click to Register button");
//		registerPage.clickToRegisterButton();
//
//		System.out.println("Register_05 - Step 04: Verify error message displayed");
//		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_06_Invalid_Confirm_Password() {
//		System.out.println("Register_06 - Step 01: Click to Register link");
//		homePage.clickToRegisterLink();
//
//		registerPage = new RegisterPageObject(driver);
//
//		registerPage.InputToFirstnameTextbox(firstName);
//		registerPage.InputToLastnameTextbox(lastName);
//		registerPage.InputToEmailTextbox(emailAddress);
//		registerPage.InputToPasswordTextbox(password);
//		registerPage.InputToConfirmPasswordTextbox("654321");
//
//		System.out.println("Register_06 - Step 03: Click to Register button");
//		registerPage.clickToRegisterButton();
//
//		System.out.println("Register_06 - Step 04: Verify error message displayed");
//		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
		driverTestClass.quit();
	}

}
