package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import data.LoginData;

import pages.HomePage;
import pages.LoginPage;
import utilities.Paths;

public class LoginTest {

	//Please Refer to this class for every new Test case attemp.

	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	Paths paths;
	LoginData loginData;
	ArrayList<String> ErrorMessages = new ArrayList<String>();
	
	@Test(priority = 0)
	public void setup() {
		loginData = new LoginData();
		paths = new Paths();	
		//Set Webdriver by using Utilities Class so we can reuse that code.
		System.setProperty("webdriver.chrome.driver", paths.getWebDriverPath_Chrome());
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		driver.get(loginPage.getUrl());
	}
	
	@Test(priority = 1)
	public void test_login_happyPath() {
		loginPage.loginToPage(loginData.getUsername(), loginData.getPassword());
		Assert.assertEquals(driver.getCurrentUrl(),homePage.getUrl());
	}
	
	@AfterClass
	public void end() {
		if(ErrorMessages.size() > 0) {
			System.out.println(ErrorMessages.toString());
		}else {
			driver.close();
		}
	}
}
