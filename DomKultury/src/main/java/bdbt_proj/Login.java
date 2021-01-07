package bdbt_proj;

public class Login {
	
	private String login;
	private String password;
	
	/* Constructor */
	public Login(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	/* Constructor without fields*/
	public Login() {
		super();
	}
	
	/* Setter and getters */
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
