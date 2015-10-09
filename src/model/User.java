package model;

public class User {
	private String lastName;
	private String firstName;
	private String nickName;
	private String passWord;

	public User() {

	}

	public User(String lastName, String firstName, String nickName, String passWord) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.nickName = nickName;
		this.passWord = passWord;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}
