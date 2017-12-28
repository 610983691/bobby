/**
 * 
 */
package com.bobby.service.location;

import java.util.Calendar;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.bobby.dao.location.LocationDAO;
import com.bobby.dto.common.CommonResDTO;
import com.bobby.dto.common.LocationDTO;
import com.bobby.dto.common.ReportDataDTO;
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
			ReportDataDTO reportData = JSONObject.toJavaObject(json, ReportDataDTO.class);
			LocationDTO location = reportData.getLocation();
			location.setId(UUID.randomUUID().toString());
			location.setReportTime(Calendar.getInstance().getTimeInMillis());
			location.setNickName(reportData.getUserInfo().getNickName());
			locationDao.saveLocation(location);
		} catch (InvalidParamException ie) {
			LOG.error("invalid location info:", ie);
			throw ie;
		} catch (Exception e) {
			LOG.error("save user location err", e);
			throw new RuntimeException(e.getMessage());
		}
		return null;
	}

	private boolean isValidLocation(JSONObject json) {
		try {
			ReportDataDTO data = JSONObject.toJavaObject(json, ReportDataDTO.class);
			if (data.getLocation().getLatitude() > MAX_LATITUDE || data.getLocation().getLatitude() < -MAX_LATITUDE) {
				return false;
			}
			if (Float.valueOf(data.getLocation().getLongitude()) > MAX_LONGITUDE
					|| Float.valueOf(data.getLocation().getLongitude()) < -MAX_LONGITUDE) {
				return false;
			}
			if (StringUtils.isEmpty(data.getUserInfo().getNickName())) {
				return false;
			}
		} catch (Exception e) {
			throw new InvalidParamException("参数异常：" + json);
		}
		return true;
	}
}
