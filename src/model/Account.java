package model;

public class Account {
	private String userId;
	private String pass;
	private String lineToken;
	private String nickname;
	private String location;

	public Account() {};

	public Account(String userId, String pass, String lineToken, String nickname, String location) {
		this.userId = userId;
		this.pass = pass;
		this.lineToken = lineToken;
		this.nickname = nickname;
		this.location = location;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getLineToken() {
		return lineToken;
	}

	public void setLineToken(String lineToken) {
		this.lineToken = lineToken;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


}
