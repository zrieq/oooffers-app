/**
 * 
 */
package com.oooffers.common.util.exception;

import org.slf4j.Logger;

/**
 * @author Zrieq
 *
 */
public class EOAExceptionUtil {
	
	public static void logAndRethrowEOAException(Logger logger, String errorCode, String msg) throws EOAException {
		EOAExceptionUtil.logAndRethrowEOAException(logger, null, errorCode, msg);
	}

	public static void logAndRethrowEOAException(Logger logger, String errorCode, String msg, Exception e) throws EOAException {
		EOAExceptionUtil.logAndRethrowEOAException(logger, errorCode, null, msg, e);
	}

	public static void logAndRethrowEOAException(Logger logger, String methodName, String errorCode, String msg) throws EOAException {
		StringBuffer sb = new StringBuffer();
		if (methodName != null) {
			sb.append("Method Name: [");
			sb.append(methodName);
			sb.append("] ");
		}

		String message = sb.toString();

		if (msg != null) {
			message = message + "Message: [" + msg + "], ";
		}
		logger.error(message);
		throw new EOAException(errorCode, message);
	}

	public static void logAndRethrowEOAException(Logger logger, String errorCode, String methodName, String msg, Exception e) throws EOAException {
		StringBuffer sb = new StringBuffer();
		sb.append("Error Message [");
		sb.append(e.getMessage());
		if (methodName != null) {
			sb.append("], Method Name: [");
			sb.append(methodName);
		}
		sb.append("], Local Exception Message: [");
		sb.append(e.getLocalizedMessage());
		sb.append("]");

		String message = sb.toString();

		if (msg != null) {
			message = message + "Message: [" + msg + "], ";
		}
		logger.error(message, e);
		throw new EOAException(errorCode, message, e);
	}
}
