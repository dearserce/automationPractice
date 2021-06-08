package data;

public class LoginData {

	//Here we will have some kind of methods that will include several ways to obtain information from Excel
	//Apache POI I guess, but for now let's patch this
	
	private String username;
	private String password;
	
	public LoginData() {
		username = "standard_user";
		password = "secret_sauce";
	}
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
}
