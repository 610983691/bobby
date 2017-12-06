package com.bobby.api.http.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.bobby.dto.ExampleDTO;

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

	@RequestMapping(value = "reportLocation")
	@ResponseBody
	public String reportLocation() {
		LOG.info("请求report接口");
		return JSONArray.toJSONString(new ExampleDTO());
	}

}
