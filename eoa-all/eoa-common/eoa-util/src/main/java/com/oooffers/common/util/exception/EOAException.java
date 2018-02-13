/**
 * 
 */
package com.oooffers.common.util.exception;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zrieq
 *
 */
public class EOAException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * a Map that holds extra info to be captured
	 */
	private Map<String, Object> infoMap;

	private String errorCode;

	private String errorMessage;

	private BigInteger exceptionId;

	private String reasonCode;

	public EOAException(String errorCode) {
		this.errorCode = errorCode;
		this.generateExceptionId();
	}

	public EOAException(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.generateExceptionId();
	}

	public EOAException(String errorCode, String errorMessage, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.generateExceptionId();
	}

	public BigInteger getExceptionId() {
		return exceptionId;
	}

	public void setExceptionId(BigInteger exceptionId) {
		if (this.exceptionId == null)
			this.exceptionId = exceptionId;
	}

	private void generateExceptionId() {
		if (this.exceptionId == null) {
			this.exceptionId = new BigInteger(System.currentTimeMillis() + "");
		}
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String toString() {
		return "ErrorCode= " + errorCode + ", ErrorMessage= " + errorMessage + ", ExceptionId= " + exceptionId;
	}

	public void setInfoMap(Object... infoMap) {

		if (infoMap == null) {
			return;
		}

		if (this.infoMap == null) {
			this.infoMap = new HashMap<String, Object>();
		}

		if (infoMap.length % 2 != 0) {
			throw new IllegalArgumentException("info map length should be even number. e.g, key-value pairs)");
		}

		for (int i = 0; i < infoMap.length / 2; i++) {
			this.infoMap.put((String) infoMap[2 * i], infoMap[2 * i + 1]);
		}
	}

	public Map<String, Object> getInfoMap() {
		return infoMap;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

}