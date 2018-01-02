package com.bobby.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 项目名称：bobby 类名称：CommonController 描述：
 * 
 * @author tongjie
 * @date 2017年12月6日 上午9:40:10
 */
@Controller
public class CommonController {

	private static final Logger logger = Logger.getLogger(CommonController.class);

	// 以下方式，路径只能/example/example/,以/结尾
	@RequestMapping(value = "index/", method = RequestMethod.GET)
	public ModelAndView exampleGet() {
		logger.info("invoke index");
		return new ModelAndView("index");
	}

}
