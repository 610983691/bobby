/**
 * 
 */
package com.bobby.service.location;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.bobby.api.http.client.ConvertGPS2BDClient;
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
			Date now = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
			location.setReportTime(now.getTime());
			location.setNickName(reportData.getUserInfo().getNickName());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			location.setReportDateTime(sdf.format(now));
			ConvertGPS2BDClient.convertGPS2BDClient(location);
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

	/**
	 * 方法描述:查询今天的所有位置信息
	 * 
	 * @param @param
	 *            locatioin
	 * @param @return
	 * @throws @author
	 *             tongjie
	 * @date 2018年1月29日
	 */
	@Override
	public List<LocationDTO> queryTodayDatas(JSONObject locatioin) {
		List<LocationDTO> result = Collections.emptyList();
		try {
			LocationDTO location = JSONObject.toJavaObject(locatioin, LocationDTO.class);
			if (StringUtils.isEmpty(location.getNickName())) {
				return result;
			}
			Date now = Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
			location.setReportTime(now.getTime());
			result = locationDao.queryLocations(location);
		} catch (Exception e) {
			LOG.error("查询位置信息异常", e);
		}
		return result;
	}

	/**
	 * 方法描述:
	 * 
	 * @param @param
	 *            locatioin
	 * @param @return
	 * @throws @author
	 *             tongjie
	 * @date 2018年1月29日
	 */
	@Override
	public List<LocationDTO> queryHotMapDatas(JSONObject locatioin) {
		List<LocationDTO> result = Collections.emptyList();
		try {
			LocationDTO location = JSONObject.toJavaObject(locatioin, LocationDTO.class);
			if (StringUtils.isEmpty(location.getNickName())) {
				return result;
			}
			result = locationDao.queryHotmapLocations(location);
		} catch (Exception e) {
			LOG.error("查询热力图信息异常", e);
		}
		return result;
	}
}
