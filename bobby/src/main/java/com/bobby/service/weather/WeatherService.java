/**
 * 
 */
package com.bobby.service.weather;

import com.alibaba.fastjson.JSONObject;

/**
 * 描述:
 * 
 * @author tongjie
 * @date 2017年12月26日 上午9:48:37
 */
public interface WeatherService {

	String getWeather(JSONObject location);

}
