package com.hurricane.learn.shiro.user.entity;

public class User {
	private String id;
	private String userName;
	private String nickName;
	private String password;
	private String salt;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj==null || !(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		if (other.getUserName()==null || !other.getUserName().equals(this.userName)) {
			return false;
		}
		if (other.getNickName()==null || !other.getNickName().equals(this.nickName)) {
			return false;
		}
		if (other.getPassword()==null || !other.getPassword().equals(this.password)) {
			return false;
		}
		return true;
	}
	
	
}
