package com.bobby.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bobby.dto.ExampleDTO;
import com.bobby.service.ExampleService;

@Controller("example")
public class ExampleController {

	@Autowired
	private ExampleService exampleService;

	public void example() {
		exampleService.exampleAdd(new ExampleDTO());
	}
}
