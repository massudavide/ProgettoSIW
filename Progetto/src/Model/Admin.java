package Model;

public class Admin {
	String username;
	String psw;
	
public Admin (String nome, String psw) {
	this.username=nome;
	this.psw=psw;
}
	
	// Getters & Setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}

	
}
