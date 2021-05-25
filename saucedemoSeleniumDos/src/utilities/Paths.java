package utilities;

public class Paths {

	private String WebDriver_Chrome_Path = "D:\\Documents\\Programming\\Libraries\\Chromedriver\\chromedriver.exe";
	private String WebDriver_Edge_Path   = "D:\\Documents\\Programming\\Libraries\\Edgedriver\\msedgedriver.exe";
	private String LoginData_Path = ""; //This file will include necessary excel file for named test case
	
	public String getWebDriverPath_Chrome() {
		return this.WebDriver_Chrome_Path; 
	}
	
	public String getWebDriverPath_Edge() {
		return this.WebDriver_Edge_Path;
	}
	
}
