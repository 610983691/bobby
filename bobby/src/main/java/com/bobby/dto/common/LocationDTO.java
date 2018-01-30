/**
 * 
 */
package com.bobby.dto.common;

import com.alibaba.fastjson.JSONObject;

/**
 * 描述:
 * 
 * @author tongjie
 * @date 2017年12月8日 下午8:52:55
 */
public class LocationDTO {

	private String id;

	private String nickName;
	/** 维度 */
	private Float latitude;

	/** 经度 */
	private Float longitude;

	/** 速度，单位m/s */
	private String speed;

	/** 位置的精确度 */
	private String accuracy;

	/** 高度，单位m */
	private String altitude;

	/** 垂直精度，单位m(android无法获取) */
	private String verticalAccuracy;

	/** 水平经度，m */
	private String horizontalAccuracy;

	/** 上报时间 */
	private Long reportTime;

	/** 上报时间，日期格式 */
	private String reportDateTime;
	private Double bdLongitude;
	private Double bdLatitude;

	private Integer count;

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

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
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

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}

	public Long getReportTime() {
		return reportTime;
	}

	public void setReportTime(Long reportTime) {
		this.reportTime = reportTime;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReportDateTime() {
		return reportDateTime;
	}

	public void setReportDateTime(String reportDateTime) {
		this.reportDateTime = reportDateTime;
	}

	public Double getBdLongitude() {
		return bdLongitude;
	}

	public void setBdLongitude(Double bdLongitude) {
		this.bdLongitude = bdLongitude;
	}

	public Double getBdLatitude() {
		return bdLatitude;
	}

	public void setBdLatitude(Double bdLatitude) {
		this.bdLatitude = bdLatitude;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
