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
public class WeatherNowDTO {

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

	static class Results {

		private Location location;
		private Now now;
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

	}
}
