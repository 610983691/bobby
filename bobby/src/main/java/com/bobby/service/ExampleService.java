package com.bobby.service;

import com.bobby.dto.ExampleDTO;

public interface ExampleService {

	void exampleSearch(ExampleDTO exampleDTO);

	void exampleAdd(ExampleDTO exampleDTO);

	void exampleModify(ExampleDTO exampleDTO);

	void exampleDelete(ExampleDTO exampleDTO);

}
