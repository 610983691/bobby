package com.bobby.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bobby.dao.ExampleDAO;
import com.bobby.dto.ExampleDTO;

/**
 * 
 * 描述:
 * 
 * @author tongjie
 * @date 2017年12月6日 上午9:42:16
 */
@Transactional(rollbackFor = Exception.class)
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
