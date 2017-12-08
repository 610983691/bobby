/**
 * 
 */
package com.bobby.dto.common;

import com.alibaba.fastjson.JSONObject;

/**
 * 描述:
 * 
 * @author tongjie
 * @date 2017年12月8日 下午8:50:41
 */
public class UserDTO {

	/** 用户名 */
	private String username;
	private String password;
	private String userid;
	/** 微信端id */
	private String wxid;

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

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getWxid() {
		return wxid;
	}

	public void setWxid(String wxid) {
		this.wxid = wxid;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}
