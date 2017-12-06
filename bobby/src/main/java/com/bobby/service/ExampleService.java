package com.bobby.service;

import com.bobby.dto.ExampleDTO;

/**
 * 
 * 
 * <p>
 * 项目名称：bobby
 * <p>
 * 类名称：ExampleService
 * <p>
 * 类描述：
 * <p>
 * 创建人：tongjie
 * <p>
 * 创建时间：2017年12月5日 下午2:31:40
 * <p>
 * 修改人：tongjie
 * <p>
 * 修改时间：2017年12月5日 下午2:31:40
 * <p>
 * 修改备注：
 * 
 * @author tongjie
 * @version
 *
 */
public interface ExampleService {

	/**
	 * 查询示例
	 * 
	 * @param exampleDTO
	 * @return void
	 */
	void exampleSearch(ExampleDTO exampleDTO);

	/**
	 * 新增示例
	 * 
	 * @param exampleDTO
	 * @return void
	 */
	void exampleAdd(ExampleDTO exampleDTO);

	/**
	 * 修改示例
	 * 
	 * @param exampleDTO
	 * @return void
	 */
	void exampleModify(ExampleDTO exampleDTO);

	/**
	 * 删除示例
	 * 
	 * @param exampleDTO
	 * @return void
	 */
	void exampleDelete(ExampleDTO exampleDTO);

}
