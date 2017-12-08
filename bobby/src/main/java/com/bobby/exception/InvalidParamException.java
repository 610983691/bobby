/**
 * 
 */
package com.bobby.exception;

/**
 * 描述:
 * 
 * @author tongjie
 * @date 2017年12月8日 下午9:24:03
 */
public class InvalidParamException extends RuntimeException {
	/** @Fields serialVersionUID : */
	private static final long serialVersionUID = 1L;
	private String errMsg;

	public InvalidParamException(String msg) {
		this.errMsg = msg;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
}
