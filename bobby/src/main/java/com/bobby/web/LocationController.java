package com.bobby.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.bobby.dto.common.LocationDTO;
import com.bobby.service.location.LocationService;

/**
 * 
 * 项目名称：bobby 类名称：CommonController 描述：
 * 
 * @author tongjie
 * @date 2017年12月6日 上午9:40:10
 */
@Controller
@RequestMapping(value = "location")
public class LocationController {

	private static final Logger logger = Logger.getLogger(LocationController.class);

	@Autowired
	private LocationService locationService;

	// 以下方式，路径只能/location/example/,以/结尾
	@RequestMapping(value = "hotMapData/", headers = { "content-type=application/json" }, method = RequestMethod.POST)
	@ResponseBody
	public String loadHotMapData(@RequestBody JSONObject json) {
		List<LocationDTO> locations = locationService.queryHotMapDatas(json);
		return JSONObject.toJSONString(locations);
	}

	@RequestMapping(value = "todayData/", headers = { "content-type=application/json" }, method = RequestMethod.POST)
	@ResponseBody
	public String loadTodayData(@RequestBody JSONObject json) {
		List<LocationDTO> locations = locationService.queryTodayDatas(json);
		return JSONObject.toJSONString(locations);
	}

}
