package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	
	//Page
	private String url = "https://www.saucedemo.com/inventory.html";
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public String getUrl() {
	return this.url;
	}	
}
