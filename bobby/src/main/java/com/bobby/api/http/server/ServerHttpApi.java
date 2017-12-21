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
	private LocationService locationService;

	@RequestMapping(value = "reportLocation/", headers = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public String reportLocation(@RequestBody JSONObject json) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("请求report接口，请求参数：\n" + json);
		}
		return locationService.saveUserLocation(json);
	}

}
