package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;
	//Page
	private String url = "https://www.saucedemo.com/";
	
	//Locators
	private By inptUsername = By.id("user-name"); //We locate the inputs so we can interact with them
	private By inptPassword = By.id("password");
	private By btnSubmit = By.id("login-button");
	private By errorText = By.xpath("//*[@id=\"login_button_container\"]/div/form/h3");

	//web elements
	private WebElement weUsername;
	private WebElement wePassword;
	private WebElement weSubmit;
	private WebElement weErrorText;
		
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, 10);
	}
	
	//Start Methods
	//Login to System method
	public void LoginToSystem(String username, String password) {
		//Open Web Page
		driver.get(getUrl());
		
		weUsername = driver.findElement(inptUsername); //We aren't managing exeptions about this yet, if something is not getting located, there can be errors
		weUsername.clear();
		weUsername.sendKeys(username);
		
		wePassword = driver.findElement(inptPassword);
		wePassword.clear();
		
		weSubmit = driver.findElement(btnSubmit);
		wePassword.sendKeys(password);
		weSubmit.click();		
		
		if(areWeLogged()) {
			System.out.println("Succesfully logged");
//			driver.close();
//			driver.quit();
	
		}else {
			System.out.println("Error: "+readError());
			driver.close();
			driver.quit();
		}
	}

	//get url
	public String getUrl() {
		return this.url;
	}
	
	//This methods checks if we are logged in by using the url.
	public Boolean areWeLogged() {
		String driverUrl = driver.getCurrentUrl(); //actual url
		if(driverUrl.equals(this.getUrl())) {
			return false; //as it is the same, it means that we are not logged in
		}else {
			return true; //as it different, it means that we are logged in
		}
	}
	
	//This methods validates when there is an error
	public String readError() {
		weErrorText = driver.findElement(errorText);
		String text = weErrorText.getText();
		return text;
	}
}
