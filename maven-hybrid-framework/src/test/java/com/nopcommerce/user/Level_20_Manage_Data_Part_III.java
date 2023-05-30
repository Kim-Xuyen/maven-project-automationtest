package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserData;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_20_Manage_Data_Part_III extends BaseTest {
	private WebDriver driver;
	private String emailAddress;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		emailAddress = UserData.Register.EMAIL_ADDRESS + generateFakeNumber() + "@fakemail.com";

	}

	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();

		registerPage.clickToRadioButtonByLabel(driver, "Male");

		log.info("Register - Step 02: Enter to Firstname textbox with value is'" + UserData.Register.FIRST_NAME + "'");
		registerPage.inputToTextboxByID(driver, "FirstName", UserData.Register.FIRST_NAME);

		log.info("Register - Step 03: Enter to Lastname textbox with value is'" + UserData.Register.LAST_NAME + "'");
		registerPage.inputToTextboxByID(driver, "LastName", UserData.Register.LAST_NAME);

		log.info("Register - Step 04: Select to day of birth with value is'" + UserData.Register.DATE + "'");
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", UserData.Register.DATE);

		log.info("Register - Step 05: Select to month of birth with value is'" + UserData.Register.MONTH + "'");
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", UserData.Register.MONTH);

		log.info("Register - Step 06: Select to year of birth with value is'" + UserData.Register.YEAR + "'");
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", UserData.Register.YEAR);

		log.info("Register - Step 07: Enter to Email textbox with value is'" + emailAddress + "'");
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);

		registerPage.clickToCheckboxByLabel(driver, "Newsletter");

		log.info("Register - Step 08: Enter to Password textbox with value is'" + UserData.Register.PASSWORD + "'");
		registerPage.inputToTextboxByID(driver, "Password", UserData.Register.PASSWORD);

		log.info("Register - Step 09: Enter to Confirm Password textbox with value is'" + UserData.Register.PASSWORD + "'");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", UserData.Register.PASSWORD);

		log.info("Register - Step 10: Click to 'Register' button");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Register - Step 11: Verify register success message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Register - Step 12: Click to Continue button");
		registerPage.clickToContinueLink();

	}

	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Navigate to Login page");
		loginPage = homePage.openLoginPage();

		log.info("Login - Step 02: Enter to Email textbox with value is'" + emailAddress + "'");
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);

		log.info("Login - Step 03: Enter to Password textbox with value is'" + UserData.Register.PASSWORD + "'");
		loginPage.inputToTextboxByID(driver, "Password", UserData.Register.PASSWORD);

		log.info("Login - Step 04: Click to Login button");
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Login - Step 05: Verify 'My Account' link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Test
	public void User_03_My_Account() {
		log.info("MyAccount - Step 01: Navigate to 'My Account' page");
		customerInforPage = homePage.openMyAccountPage();

		log.info("MyAccount - Step 02: Verify 'Custom Info' is displayed");
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());

		log.info("MyAccount - Step 03: Verify 'First Name' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "FirstName"), UserData.Register.FIRST_NAME);

		log.info("MyAccount - Step 03: Verify 'Last Name' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "LastName"), UserData.Register.LAST_NAME);

		log.info("MyAccount - Step 03: Verify 'Email' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "Email"), emailAddress);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}