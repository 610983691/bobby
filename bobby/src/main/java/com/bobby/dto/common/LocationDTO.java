/**
 * 
 */
package com.bobby.dto.common;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;

/**
 * 描述:
 * 
 * @author tongjie
 * @date 2017年12月8日 下午8:52:55
 */
public class LocationDTO {

	private UserDTO user;
	/** 维度 */
	private Float latitude;

	/** 经度 */
	private Float longitude;

	/** 速度，单位m/s */
	private Float speed;

	/** 位置的精确度 */
	private String accuracy;

	/** 高度，单位m */
	private String altitude;

	/** 垂直精度，单位m(android无法获取) */
	private String verticalAccuracy;

	/** 水平经度，m */
	private String horizontalAccuracy;

	/** 上报时间 */
	private Date reportTime;

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getSpeed() {
		return speed;
	}

	public void setSpeed(Float speed) {
		this.speed = speed;
	}

	public String getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}

	public String getAltitude() {
		return altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}

	public String getVerticalAccuracy() {
		return verticalAccuracy;
	}

	public void setVerticalAccuracy(String verticalAccuracy) {
		this.verticalAccuracy = verticalAccuracy;
	}

	public String getHorizontalAccuracy() {
		return horizontalAccuracy;
	}

	public void setHorizontalAccuracy(String horizontalAccuracy) {
		this.horizontalAccuracy = horizontalAccuracy;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}

	public Date getReportTime() {
		return reportTime;
	}

	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}
}
