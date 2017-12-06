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
 * 
 * <p>
 * 项目名称：bobby
 * <p>
 * 类名称：ServerHttpApi
 * <p>
 * 类描述：
 * <p>
 * 创建人：tongjie
 * <p>
 * 创建时间：2017年12月5日 下午2:14:06
 * <p>
 * 修改人：tongjie
 * <p>
 * 修改时间：2017年12月5日 下午2:14:06
 * <p>
 * 修改备注：
 * 
 * @author tongjie
 * @version
 *
 */

@Controller
@RequestMapping(value = "api")
public class ServerHttpApi {

	private static final Logger LOG = LoggerFactory
			.getLogger(ServerHttpApi.class);

	@RequestMapping(value = "reportLocation")
	@ResponseBody
	public String reportLocation() {
		LOG.info("请求report接口");
		return JSONArray.toJSONString(new ExampleDTO());
	}

}
