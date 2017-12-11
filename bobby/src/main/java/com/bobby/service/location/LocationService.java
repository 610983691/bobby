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
	 * 保存位置信息
	 * 
	 * @param json
	 * @return
	 * @return String
	 */
	String saveUserLocation(JSONObject json);

}
