/**
 * 
 */
package com.bobby.service.weather;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bobby.api.http.client.GetWeatherInfoClient;
import com.bobby.dto.common.ReportDataDTO;

/**
 * 描述:
 * 
 * @author tongjie
 * @date 2017年12月26日 上午9:48:51
 */
@Service
public class WeatherServiceImpl implements WeatherService {

	/**
	 * 方法描述:获取实时天气
	 * 
	 * @param @param
	 *            reportData
	 * @param @return
	 * @throws @author
	 *             tongjie
	 * @date 2017年12月26日
	 */
	@Override
	public String getWeather(JSONObject reportData) {
		ReportDataDTO data = JSONObject.toJavaObject(reportData, ReportDataDTO.class);
		String locationInfo = data.getLocation().getLatitude() + ":" + data.getLocation().getLongitude();
		return GetWeatherInfoClient.getNowWeather(locationInfo);
	}

	/**
	 * 
	 * 方法描述:获取最近3天的天气信息
	 * 
	 * @param @param
	 *            reportData
	 * @param @return
	 * @throws @author
	 *             tongjie
	 * @date 2017年12月26日
	 */
	public String getWeatherDaily(JSONObject reportData) {
		ReportDataDTO data = JSONObject.toJavaObject(reportData, ReportDataDTO.class);
		String locationInfo = data.getLocation().getLatitude() + ":" + data.getLocation().getLongitude();
		return GetWeatherInfoClient.getDefaultDailyWeathers(locationInfo);
	}

}
