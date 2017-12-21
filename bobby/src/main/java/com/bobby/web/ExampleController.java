package com.bobby.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bobby.dto.ExampleDTO;
import com.bobby.service.ExampleService;

/**
 * 
 * 项目名称：bobby 类名称：ExampleController 描述：
 * 
 * @author tongjie
 * @date 2017年12月6日 上午9:40:10
 */
@Controller
@RequestMapping(value = "example")
public class ExampleController {

	private static final Logger logger = Logger.getLogger(ExampleController.class);

	@Autowired
	private ExampleService exampleService;

	// 以下方式，路径只能/example/example/,以/结尾
	@ResponseBody
	@RequestMapping(value = "example/", method = RequestMethod.GET)
	public String exampleGet() {
		logger.info("invoke this");
		exampleService.exampleSearch(new ExampleDTO());
		return "welcom";
	}

	// 以下方式，路径只能/example/example/,以/结尾
	@ResponseBody
	@RequestMapping(value = "example/", method = RequestMethod.PUT)
	public String exampleUpdate() {
		logger.info("invoke this");
		exampleService.exampleSearch(new ExampleDTO());
		return "welcom";
	}

	// 以下方式，路径只能/example/example/,以/结尾
	@ResponseBody
	@RequestMapping(value = "example/", method = RequestMethod.DELETE)
	public String exampleDelete() {
		logger.info("invoke this");
		exampleService.exampleSearch(new ExampleDTO());
		return "welcom";
	}

	// 以下方式，路径只能/example/example/,以/结尾
	@ResponseBody
	@RequestMapping(value = "example/", method = RequestMethod.POST)
	public String exampleAdd() {
		logger.info("invoke this");
		exampleService.exampleSearch(new ExampleDTO());
		return "welcom";
	}

	@ResponseBody
	@RequestMapping(value = "example/", method = RequestMethod.PATCH)
	public List<ExampleDTO> exampleList() {
		logger.info("invoke this");
		exampleService.exampleSearch(new ExampleDTO());
		return null;
	}

	// 以下方式，路径可以是/example/welcome,/example/welcome.*,/example/welcome/都能请求到这个方法
	@ResponseBody
	@RequestMapping(value = "example/", method = RequestMethod.POST)
	public String welcom() {
		logger.info("invoke welcome");
		exampleService.exampleAdd(new ExampleDTO());
		return "index";
	}

	@RequestMapping(value = "welcome2", method = RequestMethod.GET)
	public ModelAndView welcome2() {
		logger.info("invoke welcome");
		return new ModelAndView("index");
	}

}
