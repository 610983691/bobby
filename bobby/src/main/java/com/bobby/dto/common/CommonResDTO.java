/**
 * 
 */
package com.bobby.dto.common;

import com.alibaba.fastjson.JSONObject;

/**
 * 描述:
 * 
 * @author tongjie
 * @date 2017年12月8日 下午11:13:50
 */
public class CommonResDTO {

	private Integer code;

	private String msg;

	private static final Integer SUCCESS = 1;
	private static final Integer FAILURE = 0;

	private CommonResDTO(Integer code) {
		this.code = code;
	}

	public static CommonResDTO getSuccessRes() {
		return new CommonResDTO(SUCCESS);
	}

	public static CommonResDTO getFailureRes() {
		return new CommonResDTO(FAILURE);
	}

	public CommonResDTO buildMsg(String msg) {
		this.msg = msg;
		return this;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}

}
