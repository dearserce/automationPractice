package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import pages.HomePage;
import pages.LoginPage;
import utilities.Paths;

public class LoginTest {

	//Please Refer to this class for every new Test case attemp.
	private int Errors = 0;
	private int Success = 0;
	WebDriver driver;
	LoginPage loginPage;
	Paths paths;
	ArrayList<String> ErrorMessages = new ArrayList<String>();
	
	//Should add @beforeTest on this method
	public void setup() {
		paths = new Paths();	
		//Set Webdriver by using Utilities Class so we can reuse that code.
		//System.setProperty("webdriver.chrome.driver", paths.getWebDriverPath_Chrome());
		System.setProperty("webdriver.edge.driver", paths.getWebDriverPath_Edge());
		
		//driver = new ChromeDriver();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		loginPage = new LoginPage(driver);
		driver.get(loginPage.getUrl());
	}
	

	
	public void test_login(String username, String Password) {
		//Should put assetTrue for Title Validation- TestNG
		LoginPage login = new LoginPage(driver);
		login.loginToPage(username, Password);
		
		//are we logged?
		if(this.validate_login()) {
			Success++;
			driver.close();
		}else {
			Errors++;
			ErrorMessages.add(login.readError());
			driver.close();
		}
	}
	
	//Validate if we are logged to the system - Returns true if we are succesfully logged
	public boolean validate_login() {
		
		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);
		
		String expected_url = home.getUrl(); //Inventory
		String actual_url = driver.getCurrentUrl();
		
		if(actual_url.equals(expected_url)) {
			return true;
		}else {
			return false;
		}
}
	
		public int getErrors() {
			return this.Errors;
		}
		
		public int getSuccess() {
			return this.Success;
		}
		
		public void validateErrors() {
				if(this.getErrors() == 0) {
					driver.close();
				}else {
					
				}
		}
}
