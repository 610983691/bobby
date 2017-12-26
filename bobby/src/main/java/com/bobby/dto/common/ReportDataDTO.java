/**
 * 
 */
package com.bobby.dto.common;

/**
 * 描述:
 * 
 * @author tongjie
 * @date 2017年12月26日 下午5:58:12
 */
public class ReportDataDTO {
	private LocationDTO location;

	private WxUserInfoDTO userInfo;

	public LocationDTO getLocation() {
		return location;
	}

	public void setLocation(LocationDTO location) {
		this.location = location;
	}

	public WxUserInfoDTO getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(WxUserInfoDTO userInfo) {
		this.userInfo = userInfo;
	}
}
