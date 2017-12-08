/**
 * 
 */
package com.bobby.service.location;

import org.apache.log4j.Logger;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.bobby.dto.common.CommonResDTO;
import com.bobby.dto.common.LocationDTO;
import com.bobby.exception.InvalidParamException;
import com.bobby.exception.ServiceException;

/**
 * 描述:
 * 
 * @author tongjie
 * @date 2017年12月8日 下午9:19:12
 */
public class LocationServiceImpl implements LocationService {

	private static final Logger LOG = Logger.getLogger(LocationServiceImpl.class);

	private static final float MAX_LATITUDE = 90.0f;
	private static final float MAX_LONGITUDE = 180.0f;

	/**
	 * 保存用户位置信息
	 * 
	 * @param @param
	 *            location
	 * @throws @author
	 *             tongjie
	 * @date 2017年12月8日
	 */
	@Override
	public String saveUserLocation(JSONObject json) {
		try {
			if (!isValidLocation(json)) {
				return CommonResDTO.getFailureRes().buildMsg("参数错误").toString();
			}
		} catch (InvalidParamException ie) {
			LOG.error("invalid location info:", ie);
			throw new InvalidParamException("异常" + ie.getMessage());
		} catch (Exception e) {
			LOG.error("save user location err", e);
			throw new ServiceException("异常" + e.getMessage());
		}
		return null;
	}

	private boolean isValidLocation(JSONObject json) {
		try {
			LocationDTO location = JSONObject.toJavaObject(json, LocationDTO.class);
			if (location.getLatitude() > MAX_LATITUDE || location.getLatitude() < -MAX_LATITUDE) {
				return false;
			}
			if (location.getLongitude() > MAX_LONGITUDE || location.getLongitude() < -MAX_LONGITUDE) {
				return false;
			}
			if (StringUtils.isEmpty(location.getUser().getUsername())) {
				return false;
			}
		} catch (Exception e) {
			throw new InvalidParamException("参数异常：" + json);
		}
		return true;
	}
}
