package com.bobby.service;

import org.springframework.stereotype.Service;

import com.bobby.dto.ExampleDTO;

@Service
public interface ExampleService {

	void exampleSearch(ExampleDTO exampleDTO);

	void exampleAdd(ExampleDTO exampleDTO);

	void exampleModify(ExampleDTO exampleDTO);

	void exampleDelete(ExampleDTO exampleDTO);

}
