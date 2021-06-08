package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;
	
	//Page
	private String url = "https://www.saucedemo.com/";
	
	//Locators
	private By inptUsername 	= By.id("user-name"); 
	private By inptPassword 	= By.id("password");
	private By btnSubmit 		= By.id("login-button");
	private By errorText 		= By.xpath("html/body/div/div/div[2]/div[1]/div[1]/div/form/div[3]/h3");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	//Get And Set Information
	public void setUsername(String username) {
		driver.findElement(inptUsername).clear();
		driver.findElement(inptUsername).sendKeys(username);
	}
	
	public void setPassword(String password) {
		driver.findElement(inptPassword).clear();
		driver.findElement(inptPassword).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(btnSubmit).click();
	}
	
	//get url
	public String getUrl() {
		return this.url;
	}

	//This methods validates when there is an error
	public String readError() {
		String text = driver.findElement(errorText).getText();
		return text;
	}
	
	public void loginToPage(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
		this.clickLogin();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
}
