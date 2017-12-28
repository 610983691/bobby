/**
 * 
 */
package com.bobby.utils.threadpool;

import com.alibaba.fastjson.JSONObject;
import com.bobby.service.location.LocationService;

/**
 * 描述:
 * 
 * @author tongjie
 * @date 2017年12月28日 下午2:35:38
 */
public class SaveLocationThread implements Runnable {

	private JSONObject location;
	private LocationService locationService;

	public SaveLocationThread(LocationService locationService, JSONObject json) {
		this.location = json;
		this.locationService = locationService;
	}

	@Override
	public void run() {
		try {
			locationService.saveUserLocation(location);
		} catch (Exception e) {
			throw new RuntimeException("保存失败:" + location.toJSONString());
		}
	}

}
