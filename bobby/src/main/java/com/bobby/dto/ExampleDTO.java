package com.bobby.dto;

/**
 * 
 * 描述:
 * 
 * @author tongjie
 * @date 2017年12月6日 上午9:41:48
 */
public class ExampleDTO {

	private String id;
	private String username;
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "id=" + this.id + ",name=" + this.username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
