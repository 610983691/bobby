/**
 * 
 */
package com.bobby.dto.weather;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 描述:
 * 
 * @author tongjie
 * @date 2017年12月26日 上午9:54:06
 */
public class WeatherDTO {

	private List<Results> results;

	public void setResults(List<Results> results) {
		this.results = results;
	}

	public List<Results> getResults() {
		return results;
	}

	static class Location {

		private String id;
		private String name;
		private String country;
		private String path;
		private String timezone;
		@JsonProperty("timezone_offset")
		private String timezoneOffset;

		public void setId(String id) {
			this.id = id;
		}

		public String getId() {
			return id;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getCountry() {
			return country;
		}

		public void setPath(String path) {
			this.path = path;
		}

		public String getPath() {
			return path;
		}

		public void setTimezone(String timezone) {
			this.timezone = timezone;
		}

		public String getTimezone() {
			return timezone;
		}

		public void setTimezoneOffset(String timezoneOffset) {
			this.timezoneOffset = timezoneOffset;
		}

		public String getTimezoneOffset() {
			return timezoneOffset;
		}

	}

	static class Now {

		private String text;
		private String code;
		private String temperature;

		public void setText(String text) {
			this.text = text;
		}

		public String getText() {
			return text;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getCode() {
			return code;
		}

		public void setTemperature(String temperature) {
			this.temperature = temperature;
		}

		public String getTemperature() {
			return temperature;
		}

	}

	static class Daily {

		private String date;

		private String text_day;

		private String code_day;

		private String text_night;

		private String code_night;

		private String high;

		private String low;

		private String precip;

		private String wind_direction;

		private String wind_direction_degree;

		private String wind_speed;

		private String wind_scale;

		public void setDate(String date) {
			this.date = date;
		}

		public String getDate() {
			return this.date;
		}

		public void setText_day(String text_day) {
			this.text_day = text_day;
		}

		public String getText_day() {
			return this.text_day;
		}

		public void setCode_day(String code_day) {
			this.code_day = code_day;
		}

		public String getCode_day() {
			return this.code_day;
		}

		public void setText_night(String text_night) {
			this.text_night = text_night;
		}

		public String getText_night() {
			return this.text_night;
		}

		public void setCode_night(String code_night) {
			this.code_night = code_night;
		}

		public String getCode_night() {
			return this.code_night;
		}

		public void setHigh(String high) {
			this.high = high;
		}

		public String getHigh() {
			return this.high;
		}

		public void setLow(String low) {
			this.low = low;
		}

		public String getLow() {
			return this.low;
		}

		public void setPrecip(String precip) {
			this.precip = precip;
		}

		public String getPrecip() {
			return this.precip;
		}

		public void setWind_direction(String wind_direction) {
			this.wind_direction = wind_direction;
		}

		public String getWind_direction() {
			return this.wind_direction;
		}

		public void setWind_direction_degree(String wind_direction_degree) {
			this.wind_direction_degree = wind_direction_degree;
		}

		public String getWind_direction_degree() {
			return this.wind_direction_degree;
		}

		public void setWind_speed(String wind_speed) {
			this.wind_speed = wind_speed;
		}

		public String getWind_speed() {
			return this.wind_speed;
		}

		public void setWind_scale(String wind_scale) {
			this.wind_scale = wind_scale;
		}

		public String getWind_scale() {
			return this.wind_scale;
		}
	}

	static class Results {

		private Location location;
		private Now now;
		private List<Daily> daily;
		private Date lastUpdate;

		public void setLocation(Location location) {
			this.location = location;
		}

		public Location getLocation() {
			return location;
		}

		public void setNow(Now now) {
			this.now = now;
		}

		public Now getNow() {
			return now;
		}

		public void setLastUpdate(Date lastUpdate) {
			this.lastUpdate = lastUpdate;
		}

		public Date getLastUpdate() {
			return lastUpdate;
		}

		public List<Daily> getDaily() {
			return daily;
		}

		public void setDaily(List<Daily> daily) {
			this.daily = daily;
		}

	}
}
