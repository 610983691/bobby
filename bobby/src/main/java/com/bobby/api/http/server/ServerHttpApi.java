package com.bobby.api.http.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.bobby.service.location.LocationService;
import com.bobby.service.weather.WeatherService;
import com.bobby.utils.threadpool.SaveLocationThreadPoolUtil;

/**
 * 
 * 描述:
 * 
 * @author tongjie
 * @date 2017年12月6日 上午10:19:43
 */
@Controller
@RequestMapping(value = "api")
public class ServerHttpApi {

	private static final Logger LOG = LoggerFactory.getLogger(ServerHttpApi.class);

	@Autowired
	private WeatherService weatherService;

	@Autowired
	private LocationService locationService;

	@RequestMapping(value = "weathers/", headers = { "content-type=application/json" }, method = RequestMethod.POST)
	@ResponseBody
	public String getWeatherNow(@RequestBody JSONObject json) {
		/** 1.这一步是异步的保存位置信息 */
		SaveLocationThreadPoolUtil.saveLocation(locationService, json);
		if (LOG.isDebugEnabled()) {
			LOG.debug("请求weathers接口，请求参数：\n" + json.toJSONString());
		}
		/** 2.获取实时天气信息 */
		return weatherService.getWeather(json);
	}

	@RequestMapping(value = "weatherDaily/", headers = { "content-type=application/json" }, method = RequestMethod.POST)
	@ResponseBody
	public String getWeatherDaily(@RequestBody JSONObject json) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("获取最近3天的天气，请求参数：\n" + json);
		}
		/** 1.这一步是异步的保存位置信息 */
		SaveLocationThreadPoolUtil.saveLocation(locationService, json);
		return weatherService.getWeatherDaily(json);
	}

}
