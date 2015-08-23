package com.zhiye.services;

import com.zhiye.log.Logger;
import com.zhiye.log.LoggerFactory;

public class CommonService {
	 private Logger _logger = LoggerFactory.getServiceLog(this.getClass());
	    

	    /**
	     * debug log
	     */
	    protected void debug(String method, String message) {
	        _logger.debug(method, message);
	    }
	    
	    /**
	     * warn log
	     */
	    protected void warn(String method, String message) {
	        _logger.warn(method, message);
	    }

	    /**
	     * fatal log
	     */
	    protected void error(String method, String message) {
	        _logger.error(method, message);
	    }

	    /**
	     * fatal log
	     */
	    protected void error(String method, String message,
	            Throwable t) {
	        _logger.error(method, message, t);
	    }

	    /**
	     * info log
	     */
	    protected void info(String method, String message) {
	        _logger.info(method, message);
	    }
}
