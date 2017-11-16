package com.bobby.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bobby.dao.ExampleDAO;
import com.bobby.dto.ExampleDTO;

@Transactional
@Service
public class ExampleServiceImpl implements ExampleService {

	@Autowired
	private ExampleDAO exampleDao;

	public void exampleSearch(ExampleDTO exampleDTO) {
		exampleDao.select(exampleDTO);
	}

	public void exampleAdd(ExampleDTO exampleDTO) {
		exampleDao.select(exampleDTO);

	}

	public void exampleModify(ExampleDTO exampleDTO) {

	}

	public void exampleDelete(ExampleDTO exampleDTO) {

	}

}
