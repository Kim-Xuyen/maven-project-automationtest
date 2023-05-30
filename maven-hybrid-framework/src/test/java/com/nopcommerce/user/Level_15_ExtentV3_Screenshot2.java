//package com.nopcommerce.user;
//
//import java.lang.reflect.Method;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.relevantcodes.extentreports.LogStatus;
//
//import ReportConfig.ExtentManager;
//import commons.BaseTest;
//import commons.PageGeneratorManager;
//import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
//import pageObjects.nopCommerce.user.UserHomePageObject;
//import pageObjects.nopCommerce.user.UserLoginPageObject;
//import pageObjects.nopCommerce.user.UserRegisterPageObject;
//
//public class Level_15_ExtentV3_Screenshot2 extends BaseTest {
//	private WebDriver driver;
//	private String firstName, lastName, emailAddress, validPassword;
//	private UserHomePageObject homePage;
//	private UserRegisterPageObject registerPage;
//	private UserLoginPageObject loginPage;
//	private UserCustomerInforPageObject customerInforPage;
//
//	@Parameters({ "browser", "environment" })
//	@BeforeClass
//	public void beforeClass(String browserName, String environmentName) {
//		driver = getBrowserDriver(browserName);
//		homePage = PageGeneratorManager.getUserHomePage(driver);
//
//		firstName = "Automation";
//		lastName = "FC";
//		emailAddress = "abc" + generateFakeNumber() + "@mail.com";
//		System.out.println(emailAddress);
//		validPassword = "123456";
//
//	}
//
//	@Test
//	public void User_01_Register(Method method) {
//		ExtentManager.startTest(method.getName(), "User_01_Register");
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 01: Navigate to 'Register' page");
//		registerPage = homePage.openRegisterPage();
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 02: Enter to Firstname textbox with value is'" + firstName + "'");
//		registerPage.InputToFirstnameTextbox(firstName);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 03: Enter to Lastname textbox with value is'" + lastName + "'");
//		registerPage.InputToLastnameTextbox(lastName);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 04: Enter to Email textbox with value is'" + emailAddress + "'");
//		registerPage.InputToEmailTextbox(emailAddress);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 05: Enter to Password textbox with value is'" + validPassword + "'");
//		registerPage.InputToPasswordTextbox(validPassword);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 06: Enter to Confirm Password textbox with value is'" + validPassword + "'");
//		registerPage.InputToConfirmPasswordTextbox(validPassword);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 07: Click to 'Register' button");
//		registerPage.clickToRegisterButton();
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 08: Verify register success message is displayed");
//		Assert.assertEquals(registerPage.getSuccessMessage(), "Your registration completed..");
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 09: Click to Continue button");
//		registerPage.clickToContinueLink();
//		ExtentManager.endTest();
//	}
//
//	@Test
//	public void User_02_Login(Method method) {
//		ExtentManager.startTest(method.getName(), "User_02_Login");
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 01: Navigate to Login page");
//		loginPage = homePage.openLoginPage();
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 02: Enter to Email textbox with value is'" + emailAddress + "'");
//		loginPage.inputToEmailTextbox(emailAddress);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 03: Enter to Password textbox with value is'" + validPassword + "'");
//		loginPage.inputToPasswordTextbox(validPassword);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 04: Click to Login button");
//		homePage = loginPage.clickToLoginButton();
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 05: Verify 'My Account' link is displayed");
//		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 06: Navigate to 'My Account' page");
//		customerInforPage = homePage.openMyAccountPage();
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 07: Verify 'Custom Info' is displayed");
//		Assert.assertFalse(customerInforPage.isCustomerInforPageDisplayed());
//		ExtentManager.endTest();
//	}
//
//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//	}
//
//}
