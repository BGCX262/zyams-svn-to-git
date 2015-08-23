package com.zhiye.services;

public class ServiceException extends Exception {
	
	/**
	 *  default UID
	 */
	private static final long serialVersionUID = 20001L;

	//BEAN ID为NULL
	public static final String ID_NULL_ERROR = "00001";

	//BEAN 为NULL
	public static final String ENTITY_NULL_ERROR = "00002";

	//INSERT DAO exception
	public static final String INSERT_DAO_ERROR = "00003";
	//delete DAO exception
	public static final String DELETE_DAO_ERROR = "00004";
	//UPDATE DAO exception
	public static final String UPDATE_DAO_ERROR = "00005";
	//QUERY DAO exception
	public static final String QUERY_DAO_ERROR = "00006";
	//user name exception
	public static final String USER_NAME_ERROR = "00009";
	//unknown error
	public static final String UNKNOWN_ERROR = "00007";
	
	//params null exception
	public static final String PARAMS_NULL_ERROR = "00008";

	public ServiceException() {
	}

	public ServiceException(String errorMsg) {
		super(errorMsg);
	}
	
	public ServiceException(Throwable th,String errorMsg) {
		super(errorMsg,th);
	}
}
