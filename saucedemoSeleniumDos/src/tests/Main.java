package tests;

public class Main {
	public static void main(String[] args) {
		int Success = 0;
		int Errors = 0;
		
		LoginTest Login_test = new LoginTest();
		Login_test.setup();		
		Login_test.test_login("standard_user", "secret_sauce");
		Errors += Login_test.getErrors();
		Success += Login_test.getSuccess();
		
		LoginTest Login_test2 = new LoginTest();
		Login_test2.setup();		
		Login_test2.test_login("standard_3user", "secret_sauce");
		Errors += Login_test2.getErrors();
		Success += Login_test2.getSuccess();
	
		LoginTest Login_test3 = new LoginTest();
		Login_test3.setup();		
		Login_test3.test_login("standar2d_user", "secret_sauce");
		Errors += Login_test3.getErrors();
		Success += Login_test3.getSuccess();
		
			System.out.println("Total Test Cases Error: "+Errors);
			System.out.println("Total Test Cases Successfuly: "+Success);
		
		
		
		
	} 
	
	
}
