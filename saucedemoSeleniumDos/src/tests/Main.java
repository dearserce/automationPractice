package tests;

public class Main {
	public static void main(String[] args) {
		LoginTest Login_test = new LoginTest();
		Login_test.setup();		
		Login_test.test_login("standard_user", "secret_sauce");		
	} 
}
