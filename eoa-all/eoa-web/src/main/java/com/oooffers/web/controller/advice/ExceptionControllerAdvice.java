/**
 * 
 */
package com.oooffers.web.controller.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Zrieq
 * 
 */
@ControllerAdvice
public class ExceptionControllerAdvice {
	
	private final static Logger LOG = LoggerFactory.getLogger(ExceptionControllerAdvice.class);
	
	@ExceptionHandler(Exception.class)
	public String exception(Exception e) {
		LOG.error(e.getMessage(), e);
		return "error";
	}
}
