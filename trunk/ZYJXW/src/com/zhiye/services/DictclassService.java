package com.zhiye.services;

import com.zhiye.dao.ZyDictclassDAO;
import com.zhiye.dao.ZyDictionaryDAO;

public class DictclassService extends CommonService{


	private ZyDictclassDAO DictclassDAO;

	public ZyDictclassDAO getDictclassDAO() {
		return DictclassDAO;
	}

	public void setDictclassDAO(ZyDictclassDAO dictclassDAO) {
		DictclassDAO = dictclassDAO;
	}
	
}
