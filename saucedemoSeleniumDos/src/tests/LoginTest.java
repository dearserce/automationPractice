package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginPage;
import utilities.Paths;

public class LoginTest {

	//Please Refer to this class for every new Test case attemp.
	
	WebDriver driver;
	LoginPage loginPage;
	Paths paths;
	
	//Should add @beforeTest on this method
	public void setup() {
		paths = new Paths();	
		//Set Webdriver by using Utilities Class so we can reuse that code.
		System.setProperty("webdriver.chrome.driver", paths.getWebDriverPath_Chrome());
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginPage = new LoginPage(driver);
		driver.get(loginPage.getUrl());
	}
	
	public void test_login(String username, String Password) {
		//Should put assetTrue for Title Validation- TestNG
		LoginPage login = new LoginPage(driver);
		login.loginToPage(username, Password);
		
	}
}
