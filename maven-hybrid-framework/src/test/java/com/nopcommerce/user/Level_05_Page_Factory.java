package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePageFactory;
import pageFactury.nopCommerce.HomePageObject;
import pageFactury.nopCommerce.LoginPageObject;
import pageFactury.nopCommerce.RegisterPageObject;

public class Level_05_Page_Factory extends BasePageFactory {
	private WebDriver driver;
	private String firstName, lastName, invalidEmail, notFoundEmail, existingEmail, validPassword, incorrectPassword;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = new HomePageObject(driver);

		firstName = "Automation";
		lastName = "FC";
		invalidEmail = "abc@xyz@.com.vn";
		existingEmail = "abc" + generateFakeNumber() + "@mail.com";
		notFoundEmail = "abc" + generateFakeNumber() + "@mail.vn";
		validPassword = "123456";
		incorrectPassword = "654321";

		homePage = new HomePageObject(driver);

		System.out.println("Pre-Condition - Step 01: Click to Register link");
		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

		System.out.println("Pre-Condition - Step 02: Input to required fields");
		registerPage.InputToFirstnameTextbox(firstName);
		registerPage.InputToLastnameTextbox(lastName);
		registerPage.InputToEmailTextbox(existingEmail);
		registerPage.InputToPasswordTextbox(validPassword);
		registerPage.InputToConfirmPasswordTextbox(validPassword);

		System.out.println("Pre-Condition - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Pre-Condition - Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getSuccessMessage(), "Your registration completed");

		System.out.println("Pre-Condition - Step 05: Click to Continue link");
		registerPage.clickToContinueLink();

		System.out.println("Pre-Condition - Step 05: Click to Continue link");
		registerPage.clickToLoginLink();

		homePage = new HomePageObject(driver);
	}

	@Test
	public void Login_01_Empty_Data() {
		System.out.println("Login_01_Empty_Data - Step 01: Click to Login link");
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		System.out.println("Login_01_Empty_Data - Step 02: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login_01_Empty_Data - Step 03: Verify error message is displayed");
		Assert.assertEquals(loginPage.getErrorMessageAtFirstnameTextbox(), "Please enter your email");

	}

	@Test
	public void Login_02_Invalid_Email() {
		System.out.println("Login_02_Invalid_Email - Step 01: Click to Login link");
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		System.out.println("Login_02_Invalid_Email - Step 02: Input invalid email");
		loginPage.inputToEmailTextbox(invalidEmail);

		System.out.println("Login_02_Invalid_Email - Step 03: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login_02_Invalid_Email - Step 04: Verify error message is displayed");
		Assert.assertEquals(loginPage.getErrorMessageAtFirstnameTextbox(), "Wrong email");
	}

	@Test
	public void Login_03_Email_Not_Found() {
		System.out.println("Login_03_Email_Not_Found - Step 01: Click to Login link");
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		System.out.println("Login_03_Email_Not_Found - Step 02: Input email not found");
		loginPage.inputToEmailTextbox(notFoundEmail);

		System.out.println("Login_03_Email_Not_Found - Step 03: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login_03_Email_Not_Found - Step 04: Verify error message is displayed");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		System.out.println("Login_04_Existing_Email_Empty_Password - Step 01: Click to Login link");
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		System.out.println("Login_04_Existing_Email_Empty_Password - Step 02: Input existing mail");
		loginPage.inputToEmailTextbox(existingEmail);
		System.out.println("Login_04_Existing_Email_Empty_Password - Step 03: Input empty password");
		loginPage.inputToPasswordTextbox("");

		System.out.println("Login_04_Existing_Email_Empty_Password - Step 04: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login_04_Existing_Email_Empty_Password - Step 05: Verify error message is displayed");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		System.out.println("Login_05_Existing_Email_Incorrect_Password - Step 01: Click to Login link");
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		System.out.println("Login_05_Existing_Email_Incorrect_Password - Step 02: Input existing mail");
		loginPage.inputToEmailTextbox(existingEmail);
		System.out.println("Login_05_Existing_Email_Incorrect_Password - Step 03: Input incorrect password");
		loginPage.inputToPasswordTextbox(incorrectPassword);

		System.out.println("Login_05_Existing_Email_Incorrect_Password - Step 04: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login_05_Existing_Email_Incorrect_Password - Step 05: Verify error message is displayed");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Valid_Email_Password() {
		System.out.println("Login_06_Valid_Email_Password - Step 01: Click to Login link");
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		System.out.println("Login_06_Valid_Email_Password - Step 02: Input existing mail");
		loginPage.inputToEmailTextbox(existingEmail);
		System.out.println("Login_06_Valid_Email_Password - Step 03: Input valid password");
		loginPage.inputToPasswordTextbox(validPassword);

		System.out.println("Login_06_Valid_Email_Password - Step 04: Click to Login button");
		loginPage.clickToLoginButton();

		homePage = new HomePageObject(driver);

		System.out.println("Login_06_Valid_Email_Password - Step 05: Verrify successfull message is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
