/**
 * 
 */
package com.bobby.service.location;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.bobby.dao.location.LocationDAO;
import com.bobby.dto.common.CommonResDTO;
import com.bobby.dto.common.LocationDTO;
import com.bobby.exception.InvalidParamException;

/**
 * 描述:
 * 
 * @author tongjie
 * @date 2017年12月8日 下午9:19:12
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class LocationServiceImpl implements LocationService {

	private static final Logger LOG = Logger.getLogger(LocationServiceImpl.class);

	private static final float MAX_LATITUDE = 90.0f;
	private static final float MAX_LONGITUDE = 180.0f;

	@Autowired
	private LocationDAO locationDao;

	/**
	 * 
	 * 方法描述:保存位置信息
	 * 
	 * @param @param
	 *            json
	 * @param @return
	 * @throws @author
	 *             tongjie
	 * @date 2017年12月9日
	 */
	@Override
	public String saveUserLocation(JSONObject json) {
		try {
			if (!isValidLocation(json)) {
				return CommonResDTO.getFailureRes().buildMsg("参数错误").toString();
			}
			locationDao.saveLocation(JSONObject.toJavaObject(json, LocationDTO.class));
		} catch (InvalidParamException ie) {
			LOG.error("invalid location info:", ie);
			return CommonResDTO.getFailureRes().buildMsg(ie.getErrMsg()).toString();
		} catch (Exception e) {
			LOG.error("save user location err", e);
			return CommonResDTO.getFailureRes().buildMsg(e.getMessage()).toString();
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
		} catch (Exception e) {
			throw new InvalidParamException("参数异常：" + json);
		}
		return true;
	}
}
