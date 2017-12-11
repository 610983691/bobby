/**
 * 
 */
package com.bobby.dao.location;

import com.bobby.dto.common.LocationDTO;

/**
 * 描述:
 * 
 * @author tongjie
 * @date 2017年12月9日 下午8:53:56
 */
public interface LocationDAO {

	/**
	 * 保存位置信息，返回插入的主键ID
	 * 
	 * @param location
	 * @return
	 * @return String
	 */
	public String saveLocation(LocationDTO location);
}
