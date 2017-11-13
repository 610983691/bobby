package com.bobby.dao;

import com.bobby.dto.ExampleDTO;

public interface ExampleDAO {

	void insert(ExampleDTO exampleDTO);

	void select(ExampleDTO exampleDTO);
}
