package com.bobby.api.http.client;

import java.io.IOException;
import java.net.URLEncoder;
import java.security.SignatureException;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

/**
 * 
 * 描述:获取天气信息客户端接口 使用心知天气官方提供的demo,进行改造
 * 
 * @author tongjie
 * @date 2017年12月21日 下午2:03:11
 */
public class GetWeatherInfoClient {

	private final static Logger LOG = Logger.getLogger(GetWeatherInfoClient.class);
	// 查询当前天气情况：气温，天气
	private final static String TIANQI_NOW_WEATHER_URL = "https://api.seniverse.com/v3/weather/now.json";

	// 查询当前生活指数：穿衣，洗车等
	private final static String TIQNQI_NOW_SUGGESTION = "https://api.seniverse.com/v3/life/suggestion.json";

	/**
	 * 今天以及之后4天的天气
	 */
	private final static String TIANQI_DAILY_5 = "https://api.seniverse.com/v3/weather/daily.json";

	private final static String TIANQI_API_SECRET_KEY = "eki6heotxtx5tss8"; //

	private final static String TIANQI_API_USER_ID = "U960C4B582"; //

	/**
	 * Generate HmacSHA1 signature with given data string and key
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws SignatureException
	 */
	private static String generateSignature(String data, String key) throws SignatureException {
		String result;
		try {
			// get an hmac_sha1 key from the raw key bytes
			SecretKeySpec signingKey = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA1");
			// get an hmac_sha1 Mac instance and initialize with the signing key
			Mac mac = Mac.getInstance("HmacSHA1");
			mac.init(signingKey);
			// compute the hmac on input data bytes
			byte[] rawHmac = mac.doFinal(data.getBytes("UTF-8"));
			result = new sun.misc.BASE64Encoder().encode(rawHmac);
		} catch (Exception e) {
			throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
		}
		return result;
	}

	/**
	 * Generate the URL to get diary weather
	 * 
	 * @param location
	 * @param start
	 *            默认值0 ，start=-2 代表前天、start=-1 代表昨天、start=0 代表今天、start=1 代表明天
	 * @param days
	 *            天数 (可选) 返回从start算起days天的结果。默认为你的权限允许的最多天数。
	 * @return
	 */
	private static String generateGetDiaryWeatherURL(String location, String start, String days) {
		try {
			String timestamp = String.valueOf(new Date().getTime());
			String params = "ts=" + timestamp + "&ttl=30&uid=" + TIANQI_API_USER_ID;
			String signature = URLEncoder.encode(generateSignature(params, TIANQI_API_SECRET_KEY), "UTF-8");
			return TIANQI_DAILY_5 + "?" + params + "&sig=" + signature + "&location=" + location + "&start=" + start
					+ "&days=" + days;
		} catch (Exception e) {
			LOG.error("获取请求URL异常", e);
		}
		return null;
	}

	/**
	 * 获取现在的天气URL
	 * 
	 * @param location
	 * @return
	 */
	private static String generateGetNowWeatherURL(String location) {
		try {
			String timestamp = String.valueOf(new Date().getTime());
			String params = "ts=" + timestamp + "&ttl=30&uid=" + TIANQI_API_USER_ID;
			String signature = URLEncoder.encode(generateSignature(params, TIANQI_API_SECRET_KEY), "UTF-8");
			return TIANQI_NOW_WEATHER_URL + "?" + params + "&sig=" + signature + "&location=" + location;
		} catch (Exception e) {
			LOG.error("获取请求URL异常", e);
		}
		return null;
	}

	/**
	 * 获取现在的穿衣指数URL
	 * 
	 * @param location
	 * @return
	 */
	private static String generateGetSuggestionURL(String location) {
		try {
			String timestamp = String.valueOf(new Date().getTime());
			String params = "ts=" + timestamp + "&ttl=30&uid=" + TIANQI_API_USER_ID;
			String signature = URLEncoder.encode(generateSignature(params, TIANQI_API_SECRET_KEY), "UTF-8");
			return TIQNQI_NOW_SUGGESTION + "?" + params + "&sig=" + signature + "&location=" + location;
		} catch (Exception e) {
			LOG.error("获取请求URL异常", e);
		}
		return null;
	}

	/**
	 * 获取最近几天的天气，最多支持5天，从今天开始
	 * 
	 * @param location
	 *            支持城市名，拼音，ip,经纬度,详情见心知天气API
	 * @param start
	 * @param days
	 * @return 请求响应的json报文或者null
	 */
	public static String getDailyWeathers(String location, String start, String days) {
		return httpGet(generateGetDiaryWeatherURL(location, start, days));
	}

	/**
	 * 获取现在的天气
	 * 
	 * @param location
	 *            支持城市名，拼音，ip,经纬度,详情见心知天气API
	 * @param start
	 * @param days
	 * @return 请求响应的json报文或者null
	 */
	public static String getNowWeather(String location) {
		return httpGet(generateGetNowWeatherURL(location));
	}

	/**
	 * 获取穿衣指数等信息
	 * 
	 * @param location
	 * @return
	 * @return String
	 */
	public static String getWeatherSuggestion(String location) {
		return httpGet(generateGetSuggestionURL(location));
	}

	public static void main(String args[]) {
		try {
			getWeatherSuggestion("chengdu");
		} catch (Exception e) {
			System.out.println("Exception:" + e);
		}

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
					LOG.debug("Response content length:" + entity.getContentLength());
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
