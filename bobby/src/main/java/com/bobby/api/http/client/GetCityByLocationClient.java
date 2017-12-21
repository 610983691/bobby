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

/**
 * 描述:
 * 
 * @author tongjie
 * @date 2017年12月21日 下午7:43:11
 */
public class GetCityByLocationClient {

	private final static Logger LOG = Logger.getLogger(GetWeatherInfoClient.class);

	private final static String GET_CITY_URL_PREFFIX = "https://api.seniverse.com/v3/location/search.json?key=eki6heotxtx5tss8&q=";

	/**
	 * 
	 * @param latitude
	 *            维度
	 * @param longitude
	 *            经度
	 * @return
	 * @return 响应报文
	 */
	public static String getCityByLocation(String latitude, String longitude) {
		String url = GET_CITY_URL_PREFFIX + latitude + ":" + longitude;
		return httpGet(url);
	}

	public static void main(String[] a) {
		getCityByLocation("29", "113");
	}

	/**
	 * 发起一个HTTP GET请求
	 * 
	 * @param url
	 * @return 请求成功，返回响应报文。失败返回null
	 */
	private static String httpGet(String url) {
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
}
