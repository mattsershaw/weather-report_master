package model;

public class Registration {
	private String userId;
	private String pass;
	private String lineToken;
	private String nickname;
	private String location;
	public Registration(String userId, String pass, String lineToken, String nickname, String location) {
		this.userId = userId;
		this.pass = pass;
		this.lineToken = lineToken;
		this.nickname = nickname;
		this.location = location;
	}
	public String getUserId() {
		return userId;
	}
	public String getPass() {
		return pass;
	}
	public String getLineToken() {
		return lineToken;
	}
	public String getNickname() {
		return nickname;
	}
	public String getLocation() {
		return location;
	}

}
