/**
 * 
 */
package com.bobby.service.location;

import com.alibaba.fastjson.JSONObject;

/**
 * 描述:
 * 
 * @author tongjie
 * @date 2017年12月8日 下午9:18:57
 */
public interface LocationService {

	/**
	 * 保存用户的位置信息
	 * 
	 * @param location
	 * @return void
	 */
	String saveUserLocation(JSONObject json);

}
