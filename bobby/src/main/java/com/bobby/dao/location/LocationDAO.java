/**
 * 
 */
package com.bobby.dao.location;

import java.util.List;

import com.bobby.dto.common.LocationDTO;

/**
 * 描述:
 * 
 * @author tongjie
 * @date 2017年12月9日 下午8:53:56
 */
public interface LocationDAO {

	/**
	 * 
	 * @param location
	 * @return
	 */
	public void saveLocation(LocationDTO location);

	public List<LocationDTO> queryLocations(LocationDTO location);

	public void updateLocation(LocationDTO location);
}
