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
public class WxUserInfoDTO {

	/** 用户名 */
	private String nickName;
	/** 头像url */
	private String avatarUrl;
	/** 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知 */
	private String gender;
	/** 用户所在城市 */
	private String city;

	/** 用户所在省份 */
	private String province;
	/** 用户所在国家 */
	private String country;
	/** 用户语言 */
	private String language;

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
