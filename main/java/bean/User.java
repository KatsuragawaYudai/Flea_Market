package bean;

public class User {
	private int userId;
	private String name;
	private String nickname;
	private String address;
	private String password;
	private String email;
	private int authority;
	
	public User() {
		this.userId = -1;
		this.name = null;
		this.nickname = null;
		this.address = null;
		this.password = null;
		this.email = null;
		this.authority = -1;
	}
	
	public User(
		int userId, String name, String nickname, String address, String password, String email, int authority
	) {
		this.userId = userId;
		this.name = name;
		this.nickname = nickname;
		this.address = address;
		this.password = password;
		this.email = email;
		this.authority = authority;
	}

	public int getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getNickname() {
		return nickname;
	}

	public String getAddress() {
		return address;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public int getAuthority() {
		return authority;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}
	
}
