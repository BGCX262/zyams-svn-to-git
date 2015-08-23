package com.zhiye.common.util;

import com.zhiye.common.CommonException;



/**
 * The Exception class for Email utils
 * 
 * @author pellias
 */
public class EmailUtilException extends CommonException {
    private static final long serialVersionUID = 21130001L;
    
    public static final String ERR_SENDER = "21130001";
    public static final String ERR_MESSAGE = "21130002";
    public static final String ERR_RECIPIENT = "21130003";
    public static final String ERR_BCC = "21130004"; 
    public static final String ERR_CC = "21130005"; 
    
    
    /**
     * Constructs a new ManagerException.
     * 
     * @param errcode
     *            error code
     */
    public EmailUtilException(String errcode) {
        super(errcode);
    }

    /**
     * Constructs a new ManagerException.
     * 
     * @param errcode
     *            error code
     * @param s
     *            description
     */
    public EmailUtilException(String errcode, String s) {
        super(errcode, s);
    }

    /**
     * Constructs a new ManagerException.
     * 
     * @param errcode
     *            error code
     * @param t
     *            cause
     */
    public EmailUtilException(String errcode, Throwable t) {
        super(errcode, t);
    }

    /**
     * Constructs a new ManagerException.
     * 
     * @param errcode
     *            error code
     * @param s
     *            description
     * @param t
     *            cause
     */
    public EmailUtilException(String errcode, String s, Throwable t) {
        super(errcode, s, t);
    }
}

