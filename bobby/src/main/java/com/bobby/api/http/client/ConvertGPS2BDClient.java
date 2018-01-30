/**
 * 
 */
package com.bobby.api.http.client;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.bobby.dto.common.LocationDTO;

/**
 * 描述:
 * 
 * @author tongjie
 * @date 2018年1月29日 下午5:45:29
 */
public class ConvertGPS2BDClient {

	private final static Logger LOG = Logger.getLogger(ConvertGPS2BDClient.class);

	/** 经纬度转换URL */
	private final static String BD_GPS_CONVERT_URL = "http://api.map.baidu.com/geoconv/v1/?coords=";

	/** 经纬度转换URL 后缀 */
	private final static String BD_GPS_CONVERT_URLOFFSET = "&from=1&to=5&ak=QSE9W1K0fa1oXKoLAa0XaBPWnIqzHD3n";

	public static LocationDTO convertGPS2BDClient(LocationDTO location) {
		String url = BD_GPS_CONVERT_URL + location.getLongitude() + "," + location.getLatitude()
				+ BD_GPS_CONVERT_URLOFFSET;
		String result = httpGet(url);
		GPSConvertResponse response = JSONObject.parseObject(result, GPSConvertResponse.class);
		location.setBdLongitude(response.getResult()[0].x);
		location.setBdLatitude(response.getResult()[0].y);
		return location;
	}

	/**
	 * 发起一个HTTP GET请求
	 * 
	 * @param url
	 * @return 请求成功，返回响应报文。失败返回null
	 */
	public static String httpGet(String url) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String result = null;
		try {
			HttpGet httpget = new HttpGet(url);
			if (LOG.isDebugEnabled()) {
				LOG.debug("executing get request: " + httpget.getURI());
			}
			// 执行get请求.
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				// 获取响应实体
				HttpEntity entity = response.getEntity();
				result = EntityUtils.toString(entity);
				LOG.info("请求结果" + result);
				if (LOG.isDebugEnabled()) {
					LOG.debug("Response for request uri:" + httpget.getURI());
					LOG.debug("Response status:" + response.getStatusLine());
					LOG.debug("Response content:" + result);
				}
			} finally {
				response.close();
			}
		} catch (IOException e) {
			LOG.error("请求失败或者关闭资源失败:" + url, e);
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				LOG.error("关闭资源失败:", e);
			}
		}
		return result;
	}

	/**
	 * @param args
	 * @return void
	 */

	public static void main(String[] args) {
		LocationDTO location = new LocationDTO();
		location.setLongitude(104.1132f);
		location.setLatitude(30.65271f);

		// modify history data
		// ApplicationContext ac = new ClassPathXmlApplicationContext(
		// new String[] { "config/spring.xml", "config/mybatis-config.xml",
		// "config/spring-mybatis.xml" });
		// LocationDAO locationDAO = (LocationDAO) ac.getBean("locationDAO");
		// List<LocationDTO> res = locationDAO.queryLocations(location);
		// for (LocationDTO locationDTO : res) {
		// convertGPS2BDClient(locationDTO);
		// locationDAO.updateLocation(locationDTO);
		// }

	}

	private static class GPSConvertResponse {
		private int status;
		private BDGPS[] result;

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public BDGPS[] getResult() {
			return result;
		}

		public void setResult(BDGPS[] result) {
			this.result = result;
		}
	}

	private static class BDGPS {
		private Double x;
		private Double y;

		public Double getX() {
			return x;
		}

		public void setX(Double x) {
			this.x = x;
		}

		public Double getY() {
			return y;
		}

		public void setY(Double y) {
			this.y = y;
		}

	}

}
