package com.bobby.dao;

import com.bobby.dto.ExampleDTO;

/**
 * 
 * 项目名称：bobby 类名称：ExampleDAO 描述：
 * 
 * @author tongjie
 * @date 2017年12月6日 上午9:25:32
 */
public interface ExampleDAO {

	/**
	 * 插入示例
	 * 
	 * @param exampleDTO
	 * @return void
	 */
	void insert(ExampleDTO exampleDTO);

	/**
	 * 查询示例
	 * 
	 * @param exampleDTO
	 * @return void
	 */
	void select(ExampleDTO exampleDTO);
}
