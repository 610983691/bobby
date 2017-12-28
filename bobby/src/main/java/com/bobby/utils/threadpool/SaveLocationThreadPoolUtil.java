/**
 * 
 */
package com.bobby.utils.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.alibaba.fastjson.JSONObject;
import com.bobby.service.location.LocationService;

/**
 * 描述:
 * 
 * @author tongjie
 * @date 2017年12月8日 下午11:41:13
 */
public class SaveLocationThreadPoolUtil {

	private final static ExecutorService POOL = Executors.newFixedThreadPool(2);

	public static void saveLocation(LocationService locationService, JSONObject reportData) {
		SaveLocationThread thread = new SaveLocationThread(locationService, reportData);
		POOL.execute(thread);
	}
}
