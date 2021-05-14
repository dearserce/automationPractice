package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.LoginPage;

public class Main {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Programming\\Libraries\\Chromedriver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("headless");
		options.addArguments("ignore-certificate-errors");
		
		WebDriver driver = new ChromeDriver(options);
		LoginPage login = new LoginPage(driver);
		
		
		//Perform Login
		login.LoginToSystem("standard_user", "secret_sauce");

		
	}

}
