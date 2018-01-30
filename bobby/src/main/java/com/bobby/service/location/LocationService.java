/**
 * 
 */
package com.bobby.service.location;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.bobby.dto.common.LocationDTO;

/**
 * 描述:
 * 
 * @author tongjie
 * @date 2017年12月8日 下午9:18:57
 */
public interface LocationService {

	/**
	 * 保存位置信息
	 * 
	 * @param json
	 * @return
	 * @return String
	 */
	String saveUserLocation(JSONObject json);

	/**
	 * 查询今天的位置信息
	 * 
	 * @param locatioin
	 * @return
	 * @return List<LocationDTO>
	 */
	List<LocationDTO> queryTodayDatas(JSONObject locatioin);

	/**
	 * 查询所有的位置信息
	 * 
	 * @param locatioin
	 * @return
	 * @return List<LocationDTO>
	 */
	List<LocationDTO> queryHotMapDatas(JSONObject locatioin);

}
