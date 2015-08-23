package com.zhiye.common.bean;

import java.io.Serializable;
import java.util.Date;

public class ZySite implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private String ip;
	private Date viewTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getViewTime() {
		return viewTime;
	}

	public void setViewTime(Date viewTime) {
		this.viewTime = viewTime;
	}
}