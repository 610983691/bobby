/**
 * 
 */
package com.bobby.service.weather;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bobby.api.http.client.GetWeatherInfoClient;
import com.bobby.dto.common.LocationDTO;
import com.bobby.dto.weather.WeatherNowDTO;

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
	 *            location
	 * @param @return
	 * @throws @author
	 *             tongjie
	 * @date 2017年12月26日
	 */
	@Override
	public String getWeather(JSONObject location) {
		LocationDTO locationDto = JSONObject.toJavaObject(location, LocationDTO.class);
		String locationInfo = locationDto.getLatitude() + ":" + locationDto.getLongitude();
		WeatherNowDTO weather = JSONObject.parseObject(GetWeatherInfoClient.getNowWeather(locationInfo),
				WeatherNowDTO.class);

		return weather.toString();
	}

}
